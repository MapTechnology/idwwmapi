package idw.model.rn.geraplano.passos.tipoB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.SortedMap;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpData;
import idw.model.pojos.PpCpPre;
import idw.model.pojos.PpCpTurno;
import idw.model.pojos.PpCpfaltamp;
import idw.model.pojos.PpCpneccron;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlaneccron;
import idw.model.pojos.PpPlano;
import idw.model.rn.CpViewRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;

public class TipoBInsereCPs {

	private DAOGenerico dao;

	public TipoBInsereCPs(DAOGenerico dao){
		this.dao = dao;
	}


	@Deprecated
	public void inserirCpsNaBase(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> listaParaIncluir){
		// Essas datas serao usadas para determinar se a CP é uma antecipacao
		// Se a CP estiver atendendo uma necessidade fora desse periodo, ela sera do tipo antecipacao
		Date dtICorrentePlano = DataHoraRN.getPrimeiroDiaDoMesDaData(ppplano.getDtRevisao());
		Date dtFCorrentePlano = DataHoraRN.getUltimoDiaDoMesDaData(ppplano.getDtRevisao());
		dtFCorrentePlano = DataHoraRN.setHoraNaData(dtFCorrentePlano, 24, 59, 59, 999);
		
		List<PpCpproduto> listaApAberta = recuperaListaDeApsAbertas(log, idLog, identacao);
		
		// Varre todos os cts e vai inserindo os passos
		for (IdCtDTO idctdto : listaParaIncluir.keySet()){
			// Ordena da maior data de fim para a menor data de fim
			CtDTO ctdto = listaParaIncluir.get(idctdto);

			List<PassosDTO> listaordenada = ctdto.getPassosAlocados();
			Collections.sort(listaordenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.before(o1.getFim(), o2.getFim()) ? +1 : (DataHoraRN.after(o1.getFim(), o2.getFim()) ? -1 : 0);
				}
			});

			// Varre as CPs removendo os conflitos colocando uma das duas para um periodo anterior
			for (PassosDTO p : listaordenada){
				if (p.isExcluida() == true) {
					continue;
				}
				TipoBRemoveConflitoInclusivePre semconfRN = new TipoBRemoveConflitoInclusivePre();
				semconfRN.calculaPassoComIndisponibilidade(log, idLog, identacao, p);

				OmPt omptEscolhido = p.getCtEscolhido().getId().getOmptEscolhido();
				OmGt omgtEscolhido = p.getCtEscolhido().getId().getOmgtEscolhido();
				OmProduto omproduto = p.getOmproduto().getOmproduto();

				PpCp ppcp = new PpCp();
				ppcp.setIdCp(null);
				ppcp.setRevisao(1l);
				if (omptEscolhido != null) {
					ppcp.setCdCp(omptEscolhido.getCdPt()+"-"+omproduto.getCdProduto() ); //+ DataHoraRN.dateToStringYYYYMMDDHHMMSS(p.getInicio()));
				}
				else {
					ppcp.setCdCp(omgtEscolhido.getCdGt()+"-"+omproduto.getCdProduto() ); //+ DataHoraRN.dateToStringYYYYMMDDHHMMSS(p.getInicio()));
				}
				ppcp.setCdCp(ppcp.getCdCp() + DataHoraRN.dateToStringYYYYMMDDHHMMSS(p.getInicio()));
				ppcp.setDthrInicio(p.getInicio());
				ppcp.setDthrFinal(p.getFim());
				ppcp.setOmPt(omptEscolhido);
				ppcp.setOmGt(omgtEscolhido);
				ppcp.setStAtivo((byte)1);
				ppcp.setTpCp(0); // ordem de producao
				ppcp.setStCp(0); // cadastrada
				ppcp.setIsFaltamp(!p.isPossuiMPSuficiente());
				ppcp.setDtRevisao(DataHoraRN.getDataHoraAtual());
				ppcp.setDtStativo(DataHoraRN.getDataHoraAtual());
				ppcp.setOmUsrByIdUsrrevisao(omusr);
				ppcp.setOmUsrByIdUsrstativo(omusr);
				ppcp.setDwCal(p.getDwcal());
				ppcp.setPpPlano(ppplano);
				ppcp.setDwRota(p.getDwrota());
				ppcp.setDwFolha(p.getDwfolha());
				ppcp.setPasso(p.getDwrotapasso().getPasso());
				ppcp.setPpCliente(omproduto.getPpCliente());

				// Definir status
				ppcp.setStCp(0);
//				0 - cadastrada
//				1 - firmada
//				2 - suspensa
//				3 - cancelada
//				4 - concluida manualmente
				ppcp.setTpCp(0);
//				0 - Ordem de produ��o
//				1 - Ordem de retrabalho
//				2 - Ordem de transforma��o

				// Define o ppcpproduto
				PpCpproduto ppcpproduto = null;
				ppcpproduto = new PpCpproduto();
				ppcpproduto.setNrDoc(ppcp.getCdCp());
				ppcpproduto.setIdCpproduto(null);
				ppcpproduto.setOmProduto(omproduto);
				ppcpproduto.setPcsProducaoplanejada(new BigDecimal(p.getProducaoPlanejada()));
				ppcpproduto.setPpCp(ppcp);

				PpCpData ppcpdata = new PpCpData();
				ppcpdata.setIdCpData(null);
				ppcpdata.setDtPlanejada(p.getInicio());
				ppcpdata.setPpCpproduto(ppcpproduto);

				PpCpTurno ppcpturno = new PpCpTurno();
				ppcpturno.setIdCpTurno(null);
				ppcpturno.setPpCpData(ppcpdata);

				ppcpdata.getPpCpTurnos().add(ppcpturno);
				ppcpproduto.getPpCpDatas().add(ppcpdata);
				
				if(listaApAberta == null)
					ppcp.setIsApAberta(false);
				else
					ppcp.setIsApAberta(verificaAp(ppcpproduto, listaApAberta));
				
				ppcp.getPpCpprodutos().add(ppcpproduto);

				for (PpPlaneccron neccron : p.getListaPpplaneccron()){
					PpCpneccron ppcpneccron = new PpCpneccron();
					ppcpneccron.setIdCpneccron(null);
					ppcpneccron.setPpCp(ppcp);
					ppcpneccron.setPpPlaneccron(neccron);
					ppcpneccron.setQtAtendida(new BigDecimal(p.getProducaoPlanejada()));
					ppcp.getPpCpneccrons().add(ppcpneccron);

					ppcp.setIsAntecipacao(false);

					// Se a CP estiver atendendo uma necessidade a frente entao marca-la como antecipacao
					if (DataHoraRN.isIntersecao(neccron.getPpNeccron().getDtDesejada(), dtICorrentePlano, dtFCorrentePlano) == false){
						// Se a CP estiver dentro do periodo corrente do plano entao eh uma antecipacao realmente
						if (DataHoraRN.isIntersecao(ppcp.getDthrInicio(), dtICorrentePlano, dtFCorrentePlano) == true){
							log.info(idLog, identacao, "Intersecao de " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(neccron.getPpNeccron().getDtDesejada()) + " para o periodo " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtICorrentePlano) + " a " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtFCorrentePlano));
							ppcp.setIsAntecipacao(true);
						}
					}
				}
				
				// Preprar a relacao da falta de materia-prima para ser salva em PpCpFaltamp
				for (PpCpfaltamp mp : p.getMpfaltante()){
					mp.setPpCp(ppcp);
					ppcp.getPpCpfaltamps().add(mp);
				}
				
				// Inserir a CP
				this.dao.makePersistent(ppcp);
				
				this.dao.flushReiniciandoTransacao();

				p.setPpcpAposInclusao(ppcp);

				log.info(idLog, identacao, idctdto + " - Inseriu cp com id=" + ppcp.getIdCp() + " e quantidade = " + ppcpproduto.getPcsProducaoplanejada() + " no periodo de " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(ppcp.getDthrInicio()) + " ate " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(ppcp.getDthrFinal()) + " para o passo " + p + " que possui qt predecessoras = " + p.getPassosPredecessoras().size());

				if (ppcpproduto.getOmProduto().getCdProduto().equals("REN4743BZ-AXI"))
					log.info(idLog, identacao, "Inserindo passo " + p);
			}
		}
	}
	public void inserirCpsPrecessoras(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> listaParaIncluir){
		for (ProdutoComparable omproduto : listaParaIncluir.keySet()){
			List<PassosDTO> lista = listaParaIncluir.get(omproduto);
			for (PassosDTO p : lista){		
				if (p.isExcluida() == true) {
					log.info(idLog, identacao, "Descartando o passo " + p);
					continue;
				}
				this.inserirCpsPredecessorasRecursivamente(log, idLog, identacao, p);
			}
		}
	}

	private void inserirCpsPredecessorasRecursivamente(IdwLogger log, int idLog, int identacao, PassosDTO passoDTO){
		int contadorPredecessoras = 0;

		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select ppcppre");
		q.append("from PpCpPre ppcppre");
		q.append("where ppcppre.ppCpByIdCp.idCp = :ppcp");
		q.append("and ppcppre.ppCpByIdCppredecessora.idCp = :ppcppred");

		for (PassosDTO ps : passoDTO.getPassosPredecessoras()){
			PassosDTO predecessora = ps;

			if (ps.isExcluida() == true){
				predecessora = ps.getPassoAoQualFoiVinculad();
				if ((predecessora == null) || (predecessora.isExcluida() == true)) {
					continue;
				}
				log.info(idLog, identacao, "Assumindo predecessora VINCULADA " + predecessora + " ao inves de " + ps);
			}

			contadorPredecessoras++;
			try{
			// Antes de incluir verificar se ja existe, se existir avisar no log
				q.defineParametro("ppcp", passoDTO.getPpcpAposInclusao().getIdCp());
				q.defineParametro("ppcppred", predecessora.getPpcpAposInclusao().getIdCp());
				
				if (q.list().size() > 0) {
					log.info(idLog, identacao, "Predecessora j� cadastrada");
				}else{
					PpCpPre pre = new PpCpPre();
					pre.setIdCppre(null);
					pre.setPpCpByIdCppredecessora(predecessora.getPpcpAposInclusao());
					pre.setPpCpByIdCp(passoDTO.getPpcpAposInclusao());
					this.dao.makePersistent(pre);
					this.inserirCpsPredecessorasRecursivamente(log, idLog, identacao, predecessora);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			
				if (predecessora.getPpcpAposInclusao() == null){
					log.info(idLog, identacao, "Id da CP " + passoDTO.getPpcpAposInclusao().getIdCp() + " / " + passoDTO.getPpcpAposInclusao().getCdCp() + " tem predecessora NAO salva. Uma excessao ser� gerada.");
					continue;
				}
				if (passoDTO.getPpcpAposInclusao() == null){
					log.info(idLog, identacao, "Id da CP NAO salvo para o passo " + passoDTO);
					continue;
				}
				PpCpPre pre = new PpCpPre();
				pre.setIdCppre(null);
				pre.setPpCpByIdCppredecessora(predecessora.getPpcpAposInclusao());
				pre.setPpCpByIdCp(passoDTO.getPpcpAposInclusao());
				this.dao.makePersistent(pre);
				this.inserirCpsPredecessorasRecursivamente(log, idLog, identacao, predecessora);
			}
		}

		if ((passoDTO.getDwrotapasso().getPasso().intValue() > 1) && (contadorPredecessoras == 0)) {
			log.info(idLog, identacao, "Esse passo deveria ter predecessoras " + passoDTO);
		}

	}
	
	private List<PpCpproduto> recuperaListaDeApsAbertas(IdwLogger log, int idLog, int identacao){
		List<PpCpproduto> retorno = new ArrayList<PpCpproduto>();
		try {
			CpViewRN cpView = new CpViewRN();
			cpView.iniciaConexaoBanco();
			retorno  = cpView.verificaApAberta(log, idLog, identacao);
			cpView.finalizaConexaoBanco();
		}catch (Exception e) {
			return null;
		}
		return retorno;
	}
	
	private boolean verificaAp(PpCpproduto ppcpproduto, List<PpCpproduto> listaApAberta){
		boolean retorno = false;
		
		for(PpCpproduto cpProdutos: listaApAberta){
			if(cpProdutos.getOmProduto().getCdProduto().equals(ppcpproduto.getOmProduto().getCdProduto())){
				retorno = true;
				break;
			}
		}
		
		return retorno;
	}


	/*
	 * Esse metodo vai inserir as Cps correntes (ainda nao) do plano firmado
	 */
	public void inserirCpsAtuaisDoPlanoFirmado(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> listaParaIncluir){
		MapQuery q = new MapQuery(dao.getSession());
		q.append("from PpCp ppcp");
		q.append("join ppcp.ppPlano ppplano");
		q.append("join ppcp.ppCpprodutos ppcpprodutos");
		q.append("where ppplano.stAtivo = 1 and ppplano.stPlano = 1"); // plano
																		// firmado
		q.append("and ? between ppcp.dthrInicio and ppcp.dthrFinal");

		q.query().setDate(0, DataHoraRN.getDataHoraAtual());

		List<PpCp> lista = q.list();
		for (PpCp ppcp : lista) {
			PpCp ppcpNova = ppcp.clone(false); // nao clonar as chaves estrangeiras
			ppcpNova.setDwCal(ppcp.getDwCal());
			ppcpNova.setDwFolha(ppcp.getDwFolha());
			ppcpNova.setDwRota(ppcp.getDwRota());
			ppcpNova.setDwEst(ppcp.getDwEst());
			ppcpNova.setOmPt(ppcp.getOmPt());
			ppcpNova.setOmGt(ppcp.getOmGt());
			ppcpNova.setOmUsrByIdUsrrevisao(ppcp.getOmUsrByIdUsrrevisao());
			ppcpNova.setOmUsrByIdUsrstativo(ppcp.getOmUsrByIdUsrstativo());
			ppcpNova.setPpCliente(ppcp.getPpCliente());
			ppcpNova.setPpCpprodutos(new HashSet<PpCpproduto>());

			for (PpCpproduto prod : ppcp.getPpCpprodutos()) {
				PpCpproduto prodNovo = prod.clone(false);
				prodNovo.setPpCp(ppcpNova);
				prodNovo.setOmProduto(prod.getOmProduto().clone(false));
				ppcpNova.getPpCpprodutos().add(prodNovo);
				dao.makePersistent(ppcpNova);
			}
		}
	}
}
