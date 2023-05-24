package idw.model.rn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPasstf;
import idw.model.pojos.DwPasstfse;
import idw.model.pojos.DwPasstfsepm;
import idw.util.IdwLogger;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.OrigemDTO;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.ResultadoEtapaDTO;
import idw.webservices.dto.ResultadoMedicaoDTO;
import idw.webservices.dto.ResultadoSubetapaDTO;
import injetws.model.excessoes.SemSGBDException;


public class PostoTesteFuncionalRN extends PostoPassagemRNAbs {

	public PostoTesteFuncionalRN() {
		super(new DAOGenerico());
	}
	
	public PostoTesteFuncionalRN(DAOGenerico dao) {
		super(dao);
	}

	@Override
	protected void postoTesteFuncional(IdwLogger log, PassagemDTO passagem, DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) throws SemSGBDException {
		// se foi passado o resultado do teste funcional, entao salvar esse resultado
		if (passagem.getResultadoTesteFuncional() != null){
			oDwNserie.setDwPassagemtf(oDwPassagem);
			//merge no dw_nserie
			this.getSession().merge(oDwNserie);
			
			// Senoj 20121101 deletado trecho de consulta que n�o estava mais em uso qDwFtParam.getHql().append("from DwFtParam t");
	
		
			// Obtem DwFtEtapa da ordemEtapa para a receita passada
			MapQuery qDwFtEtapa = new MapQuery(getSession());
			qDwFtEtapa.append("select t from DwFtEtapa t ");
			qDwFtEtapa.append("join t.dwFtSubs dwftsub ");
			qDwFtEtapa.append("join dwftsub.dwTestesubs dwtestesub ");
			qDwFtEtapa.append("join dwtestesub.dwFolhateste dwfolhateste ");
			qDwFtEtapa.append("where dwfolhateste.dwFolha.idFolha = :idfolha and ");
			qDwFtEtapa.append("dwtestesub.ordemEtapa = :ordemetapa ");
			qDwFtEtapa.query().setMaxResults(1);

			// Verifica se existe um registro para a etapa nessa passagem, se existir, reutilizar pois as medicoes
			// dos postos full sao enviadas parcialmente
			MapQuery qDwPasstf = new MapQuery(getSession());
			qDwPasstf.append("from DwPasstf dwpasstf ");
			qDwPasstf.append("where dwpasstf.dwPassagem.idPassagem = :idpassagem ");
			qDwPasstf.append(" and dwpasstf.dwFtEtapa.idFtEtapa = :idftetapa ");
			qDwPasstf.query().setMaxResults(1);


			// Obtem a subetapa
			MapQuery qDwFtsub = new MapQuery(getSession());
			qDwFtsub.append("select dwftsub from DwFtSub dwftsub ");
			qDwFtsub.append("join dwftsub.dwTestesubs dwtestesub ");
			qDwFtsub.append("join dwtestesub.dwFolhateste dwfolhateste ");
			qDwFtsub.append("where dwfolhateste.dwFolha.idFolha = :idfolha and ");
			qDwFtsub.append("dwtestesub.ordem = :ordemsubetapa ");
			qDwFtsub.query().setMaxResults(1);


			MapQuery qDwPassftse = new MapQuery(getSession());
			qDwPassftse.append("from DwPasstfse dwpasstfse ");
			qDwPassftse.append("where dwpasstfse.dwPasstf.idPasstf = :idpasstf ");
			qDwPassftse.append("and dwpasstfse.dwFtSub.idFtSub = :idftsub ");
			qDwPassftse.query().setMaxResults(1);

			// Salva etapas
			for (ResultadoEtapaDTO resultadoEtapaDTO : passagem.getResultadoTesteFuncional().getEtapas()){
				DwFtEtapa dwFtEtapa = null;
				DwPasstf dwpasstf = null;
				
				// Pesquisa DwFtEtapa
				log.info("Obtendo dwftetapa para idReceita = " + passagem.getResultadoTesteFuncional().getIdReceita() + " para etapa=" + resultadoEtapaDTO.getOrdemEtapa());
				qDwFtEtapa.defineParametro("idfolha", passagem.getResultadoTesteFuncional().getIdReceita());
				qDwFtEtapa.defineParametro("ordemetapa", resultadoEtapaDTO.getOrdemEtapa());
				dwFtEtapa = (DwFtEtapa) qDwFtEtapa.query().uniqueResult();
				if (dwFtEtapa == null){
					throw new SemSGBDException();
				}


				// Pesquisar DwPasstf
				// Falhou abaixo qdo o painel foi desligado e possivelmente o id da etapa nao chegou ate aqui, mas
				// foi colocado um if acima para testar se dwFtEtapa eh null
				qDwPasstf.defineParametro("idpassagem", oDwPassagem.getIdPassagem());
				qDwPasstf.defineParametro("idftetapa", dwFtEtapa.getIdFtEtapa());
				dwpasstf = (DwPasstf) qDwPasstf.query().uniqueResult();
				
				if (dwpasstf == null){
					dwpasstf = new DwPasstf();
				
					dwpasstf.setDwFtEtapa(dwFtEtapa);
					dwpasstf.setIdPasstf(0l);
					dwpasstf.setDwPassagem(oDwPassagem);
					dwpasstf.setOrdemetapa(resultadoEtapaDTO.getOrdemEtapa());
				}
				
				dwpasstf.setDwPasstfses(new HashSet<DwPasstfse>());
				
				// Salva sub-etapas
				boolean isAlgumaSubEtapaFalhou = false;
				boolean isPrimeiraSubetapa = true;
				for (ResultadoSubetapaDTO resultadoSubetapaDTO : resultadoEtapaDTO.getSubetapas()){

					// Pesquisar dwftsub
					qDwFtsub.defineParametro("idfolha", passagem.getResultadoTesteFuncional().getIdReceita());
					qDwFtsub.defineParametro("ordemsubetapa", resultadoSubetapaDTO.getOrdemSubetapa());
					
					DwFtSub dwFtSub = (DwFtSub) qDwFtsub.query().uniqueResult();

					DwPasstfse dwpasstfse = null;

					// Verifica se a subetapa ja foi cadastrada, se sim, reaproveitar pois as medicoes sao enviadas
					// por partes
					qDwPassftse.defineParametro("idpasstf", dwpasstf.getIdPasstf());
					qDwPassftse.defineParametro("idftsub", dwFtSub.getIdFtSub());
					
					dwpasstfse = (DwPasstfse) qDwPassftse.query().uniqueResult();

					if (dwpasstfse == null){
						dwpasstfse = new DwPasstfse();
						dwpasstfse.setDwPasstf(dwpasstf);
						dwpasstfse.setDwFtSub(dwFtSub);
						dwpasstfse.setIdPasstfse(0l);
					}
					
					dwpasstfse.setDthrIsubetapa(resultadoSubetapaDTO.getDthrISubetapaPreFalha());
					dwpasstfse.setMsDthrisubetapa(new BigDecimal(DataHoraRN.getApenasMilisegundos(resultadoSubetapaDTO.getDthrISubetapaPreFalha())));
					dwpasstfse.setDthrFsubetapa(resultadoSubetapaDTO.getDthrFSubetapaPreFalha());
					dwpasstfse.setMsDthrfsubetapa(new BigDecimal(DataHoraRN.getApenasMilisegundos(resultadoSubetapaDTO.getDthrFSubetapaPreFalha())));

					if (isPrimeiraSubetapa == true){
						isPrimeiraSubetapa = false;
						dwpasstf.setDthrIetapa(dwpasstfse.getDthrIsubetapa());
						dwpasstf.setMsDthrietapa(dwpasstfse.getMsDthrfsubetapa());
					}

					if (dwpasstfse.getDthrFsubetapa() != null){
						dwpasstf.setDthrFetapa(dwpasstfse.getDthrFsubetapa());
						dwpasstf.setMsDthrfetapa(dwpasstfse.getMsDthrfsubetapa());
					}
					if (dwpasstfse.getDthrFposfalha() != null){
						dwpasstf.setDthrFetapa(dwpasstfse.getDthrFposfalha());
						dwpasstf.setMsDthrfetapa(dwpasstfse.getMsDthrfposfalha());
					}
					
					dwpasstfse.setDthrIposfalha(resultadoSubetapaDTO.getDthrISubetapaPosFalha());
					dwpasstfse.setMsDthriposfalha(new BigDecimal(DataHoraRN.getApenasMilisegundos(resultadoSubetapaDTO.getDthrISubetapaPosFalha())));
					dwpasstfse.setDthrFposfalha(resultadoSubetapaDTO.getDthrFSubetapaPosFalha());
					dwpasstfse.setMsDthrfposfalha(new BigDecimal(DataHoraRN.getApenasMilisegundos(resultadoSubetapaDTO.getDthrFSubetapaPosFalha())));
					
					dwpasstfse.setStSubetapa(resultadoSubetapaDTO.isPassou() ? 0 : 1);
					dwpasstfse.setOrdemsubetapa(resultadoSubetapaDTO.getOrdemSubetapa());
					
					// Se a sub-etapa falhou entao a etapa falhou tambem
					if (resultadoSubetapaDTO.isPassou() == false)
						isAlgumaSubEtapaFalhou = true;
					
					// Salva parametros da sub-etapas, se existirem
					dwpasstfse.setDwPasstfsepms(new HashSet<DwPasstfsepm>());
					for (ResultadoMedicaoDTO resultadoMedicaoDTO : resultadoSubetapaDTO.getMedicoes()){
//						if (resultadoMedicaoDTO.getIdParametroMedicao() == 4){ // nao salva a tensao
//							continue;
//						}
						DwPasstfsepm pm = new DwPasstfsepm();
						pm.setDwPasstfse(dwpasstfse);
						pm.setDthrMedicao(resultadoMedicaoDTO.getDthrMedicao());
						pm.setMsDthrmedicao(new BigDecimal(DataHoraRN.getApenasMilisegundos(resultadoMedicaoDTO.getDthrMedicao())));
						
						pm.setVlcorrente(new BigDecimal(resultadoMedicaoDTO.getVlcorrente()).setScale(3, RoundingMode.CEILING));
						pm.setTensao(new BigDecimal(resultadoMedicaoDTO.getTensao()).setScale(3, RoundingMode.CEILING));
						pm.setFluxoe(new BigDecimal(resultadoMedicaoDTO.getFluxoe()));
						pm.setFluxos(new BigDecimal(resultadoMedicaoDTO.getFluxos()));

						pm.setIdPasstfsepm(null);
						pm.setStFase(resultadoMedicaoDTO.isMedicaoPosFalha() ? 1 : 0);
						// Adiciona na sub-etapa para posterior save em cascata
						dwpasstfse.getDwPasstfsepms().add(pm);
					}
					// Adiciona a sub-etapa na etapa para posterior save em cascata
					dwpasstf.getDwPasstfses().add(dwpasstfse);
				}

				// Se alguma sub-etapa falhou, entao a etapa tambem falhou
				if (isAlgumaSubEtapaFalhou == true) {
					dwpasstf.setStEtapa(1);
					oDwPassagem.setStNserie((byte) 0); // marca a passagem como NAO conforme
				} else {
					dwpasstf.setStEtapa(0);
					// Aqui nao se marca a passagem como sucesso, se assume o status do numero de serie da passagem anterior
					// Ou seja, se o produto entrou no teste funcional com falha no posto anterior, entao permanece como falha,
					// mesmo tendo passado adequadamente o posto de teste funcional
					if (oDwPassagem.getStNserie() == null)
						oDwPassagem.setStNserie((byte) 1);
				}

				getSession().merge(oDwPassagem);
				// salva a etapa por cascata
				dwpasstf = (DwPasstf) getSession().merge(dwpasstf);
			}
			
			qDwFtEtapa = null;
			qDwFtsub = null;
			qDwPassftse = null;
			qDwPasstf = null;
		}
	}

	@Override
	protected void postoMontagem(List<MontagemDTO> listaMontagem,
			DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
	}

	@Override
	protected void postoReprocesso(List<AcaoDTO> listaAcoes, List<OrigemDTO> listaOrigens, DwPassagem passagem, PassagemDTO retorno) {
	}

	@Override
	protected void postoTesteVisual(List<DefeitoDTO> listaDefeitos,
			DwPassagem passagem) {
	}
}
