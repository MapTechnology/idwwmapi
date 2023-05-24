package idw.model.rn;

import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPasscau;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.DwPasstf;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTOrigem;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmTppt;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.OrigemDTO;
import idw.webservices.dto.PassagemDTO;
import injetws.model.excessoes.SemSGBDException;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;


public class PostoReprocessoRN extends PostoPassagemRNAbs {

	public PostoReprocessoRN() {
		super(new DAOGenerico());
	}
	public PostoReprocessoRN(DAOGenerico dao) {
		super(dao);
	}

	@Override
	protected void postoReprocesso(List<AcaoDTO> listaAcoes, List<OrigemDTO> listaOrigens, DwPassagem passagem, PassagemDTO retorno) {

		if (listaOrigens.size() == 0){
			return;
		}
		
		//Verifica se a origem existe para o tipo de posto 
		OrigemDTO origem = listaOrigens.get(0);
		
		DwTOrigem dwTOrigem = null;
		
		dwTOrigem = this.getOrigem(origem);
		
		if(dwTOrigem == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getORIGEM_DESCONHECIDA());
			return;
		} else {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());
		}
		
		if (listaAcoes.size() == 0){
			return;
		}
		
		// Verifica se a ação existe para o tipo de posto
		AcaoDTO acao = listaAcoes.get(0);
		
		DwTAcao oDwTAcao = null;
		
		oDwTAcao = this.getTAcao(acao);
		
		if(oDwTAcao == null) { // se n�o existir
			retorno.getResultado().setIdmensagem(retorno.getResultado().getACAO_DESCONHECIDA());
		} else { // se existir
			
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());
			
			// Gera a passagem atualizando o defeito original
			salvaReprocesso(acao, acao.getDefeito(), oDwTAcao, dwTOrigem, passagem, retorno, retorno.getPosicoesMecanicas());
		}
	
	}

	private void salvaReprocesso(AcaoDTO acao, DefeitoDTO defeito, DwTAcao dwtacao, DwTOrigem dwTOrigem, DwPassagem oDwPassagem, PassagemDTO retorno, String posicoesMecanicas){
		
		// Obtem Passagem
		PostoPassagemRN prn = new PostoPassagemRN(getDao());
		prn.setSession(getDaoSession());
		VerificaDefeitoRN drn = new VerificaDefeitoRN();
		drn.setSession(getDaoSession());
		ProdutoRN rnProduto = new ProdutoRN();
		rnProduto.getDao().setSession(getDaoSession());
		AreaRN arearn = new AreaRN();
		arearn.setDaoSession(getDaoSession());
		
		// Salva passagem com os dados do defeito e acao e componente
		DwTDefeito dwtdefeito = drn.getTDefeito(defeito.getIdTDefeito());
		OmTppt omtppt = new OmTppt();
		omtppt.setIdTppt(defeito.getIdTppt());
		if (dwtdefeito == null) {
			dwtdefeito = drn.getTDefeito(omtppt, defeito.getCdDefeito());
		}
		OmProduto omProduto = null;
		if (acao.getComponente() != null && acao.getComponente().getIdProduto() != 0)
			omProduto = rnProduto.getDao().findById(OmProduto.class, acao.getComponente().getIdProduto(), false);
		
		DwPasscau dwpasscau = new DwPasscau();
		dwpasscau.setDwPassagem(oDwPassagem);
		dwpasscau.setDwTAcao(dwtacao);
		dwpasscau.setDwTOrigem(dwTOrigem);
		dwpasscau.setDwTDefeito(dwtdefeito);
		dwpasscau.setOmProduto(omProduto);
		dwpasscau.setDsPosicaomecanica(posicoesMecanicas);
		
		dwpasscau = (DwPasscau) getDaoSession().merge(dwpasscau);
		
		// Obtem Passagem do defeito original
		// Atualizar defeito original
		DwPassagem dwpassAnt = null;
		if (defeito.getIdPassagem() > 0){
			dwpassAnt = prn.getDwPassagem(defeito.getIdPassagem());
			// se o defeito for de um posto eletrico, alterar dw_passagem
			// se o defeito for de um posto teste funcional, alterar dw_passtf
			// se o defeito for de um posto teste visual, alterar dw_passtf

			// Atualiza a causa para a passagem nao soh para o teste eletrico mas para todos os outros tipos de postos
			dwpassAnt.setDwPasscau(dwpasscau);
			dwpassAnt.setStNserie((byte) 1);
			
			getDaoSession().merge(dwpassAnt);
		}
		if (defeito.getIdPassdef() > 0){
			if (dwpassAnt == null){
				dwpassAnt = prn.getDwPassagem(defeito.getIdPassagem());
				dwpassAnt.setDwPasscau(dwpasscau);
				getDaoSession().merge(dwpassAnt);
			}
			
			DwPassdef dpd = getDwPassdef(defeito.getIdPassdef());
			if (dpd != null) {
				dpd.setDwPasscau(dwpasscau);
				/* Alessandre em 7-4-17 se a passagem original tiver defeitos localizar e a correcao do defeito tiver a area responsavel
				 * entao colocar no defeito original qual foi a area definida pelo reprocesso
				 */
				if (defeito.getCdAreaResponsavel() != null && defeito.getCdAreaResponsavel().equals("") == false) {
					// Salvar a area no defeito original
					DwTArea dwtarea;
					try {
						dwtarea = arearn.getDwTArea(defeito.getCdAreaResponsavel(), true);
					} catch (RegistroDesconhecidoException e) {
						dwtarea = null;
					}
					dpd.setDwTArea(dwtarea);
				}

				getDaoSession().merge(dpd);
			}
			
			if (retorno.getOmcfg().getOmTpptByIdTpptptf() != null && dwpassAnt.getOmPt().getOmTppt().getIdTppt() == retorno.getOmcfg().getOmTpptByIdTpptptf().getIdTppt()){// teste funcional
				DwPasstf dpt = getDwPasstf(defeito.getIdPassdef());
				dpt.setDwPasscau(dwpasscau);
				getDaoSession().merge(dpt);
			}
			if (retorno.getOmcfg().getOmTpptByIdTpptptf() != null && dwpassAnt.getOmPt().getOmTppt().getIdTppt() == retorno.getOmcfg().getOmTpptByIdTpptprepro().getIdTppt()){// reprocesso
				DwPasstf dpt = getDwPasstf(defeito.getIdPassdef());
				if (dpt != null) {
					dpt.setDwPasscau(dwpasscau);
					getDaoSession().merge(dpt);
				}
			}
		} else {
			if (dwpassAnt != null){
				dwpassAnt.setDwPasscau(dwpasscau);
				getDaoSession().merge(dwpassAnt);
			}
		}
	}
	
	private DwPassdef getDwPassdef(long id){
		String hql = "";
		
		//select * 
		//from dw_t_defeito
		//where st_ativo=1 and cd_tdefeito = defeito.cb and id_tppt = defeito.id_tppt
		
		hql += "SELECT dwpassdef ";
		hql += "FROM DwPassdef dwpassdef ";
		hql += "WHERE ";
		hql += "dwpassdef.idPassdef = ::id ";
		
		hql = hql.replaceAll("::id", String.valueOf(id));
		
		DwPassdef retorno = null;
		try {
			retorno = Util.getDadosBanco(new DwPassdef(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			retorno = null;
		}
		
		return(retorno);
	}
	private DwPasstf getDwPasstf(long id){
		String hql = "";
		
		//select * 
		//from dw_t_defeito
		//where st_ativo=1 and cd_tdefeito = defeito.cb and id_tppt = defeito.id_tppt
		
		hql += "SELECT dwpasstf ";
		hql += "FROM DwPasstf dwpasstf ";
		hql += "WHERE ";
		hql += "dwpasstf.idPasstf = ::id ";
		
		hql = hql.replaceAll("::id", String.valueOf(id));
		
		DwPasstf retorno = null;
		try {
			retorno = Util.getDadosBanco(new DwPasstf(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			retorno = null;
		}
		
		return(retorno);
	}
	private DwTAcao getTAcao(AcaoDTO acao) {
		MapQuery q = new MapQuery(getDaoSession());
		
		//select * 
		//from dw_t_defeito
		//where st_ativo=1 and cd_tdefeito = defeito.cb and id_tppt = defeito.id_tppt
		
		q.append("SELECT dwtacao ");
		q.append("FROM DwTAcao dwtacao ");
		q.append("WHERE dwtacao.stAtivo = 1 AND ");
		q.append("dwtacao.cdTacao = :cdTacao AND ");
		q.append("dwtacao.omTppt.idTppt = :idTppt ");
		
		q.defineParametro("cdTacao", acao.getCb());
		q.defineParametro("idTppt", acao.getIdTppt());
		
		DwTAcao oDwTAcao = (DwTAcao) q.uniqueResult();
		
		return(oDwTAcao);
	}	

	private DwTOrigem getOrigem(OrigemDTO origem) {
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("SELECT dwtorigem ");
		q.append("FROM DwTOrigem dwtorigem ");
		q.append("WHERE dwtorigem.stAtivo = 1 AND ");
		q.append("dwtorigem.cdOrigem = :cdOrigem AND ");
		q.append("dwtorigem.omTppt.idTppt = :idTppt ");
		
		q.defineParametro("cdOrigem", origem.getCb());
		q.defineParametro("idTppt", origem.getIdTppt());
		
		DwTOrigem dwTOrigem = (DwTOrigem) q.uniqueResult();
		
		return(dwTOrigem);
	}	

	
	@Override
	protected void postoTesteVisual(List<DefeitoDTO> listaDefeitos, DwPassagem passagem) {
	}
	@Override
	protected void postoMontagem(List<MontagemDTO> listaMontagem, DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
		if (listaMontagem == null || listaMontagem.size() == 0){
			if (retorno.getEnviarRefugo() == 1) {// enviar para o estoque refugo
				/* Alessandre em 27-02-18 comentei o trecho abaixo e
				 * substitui pela criacao de um evento em ms_evt
				retorno.getResultado().setIdmensagem(retorno.getResultado().COM_SUCESSO);
				// Verifica se o supervisor existe
				
				// Obtem a instancia do estoque refugo a partir da configura��o
				DwEst dwEst = null;
				dwEst = retorno.getOmcfg().getDwEstByIdEstrefugo();
				
				oDwNserie.setDwEst(dwEst);
				 */
				EventoColetado evento = new EventoColetado();
				evento.setDthrEvento(DataHoraRN.getDataHoraAtual());
				evento.setCb(retorno.getCb());
				evento.setLog(new IdwLogger("PostoReprocessoRN"));
				evento.setCdop(oDwPassagem.getDwConsolid().getPpCp().getCdCp());
				evento.setTipoEvento(ServicoFactory._NOVOREFUGO);
				evento.setIcUpDTO( Stubedelegate.getInstancia().getMsthread().getIcUp(oDwPassagem.getOmPt().getCdPt()) );
				evento.setCdrefugo(retorno.getCdRefugo());

				UpRN rn = new UpRN(getDao(), null);
				rn.setLog(null);
				try {
					rn.inserirNovoRefugo(evento);
					retorno.getResultado().setIdmensagem(retorno.getResultado().COM_SUCESSO);
				} catch (ServicoFalhouException e) {
					retorno.getResultado().setIdmensagem(retorno.getResultado().REFUGO_DESCONHECIDO);
				}
			}
			return;
		}
		retorno.getResultado().setIdmensagem(retorno.getResultado().COM_SUCESSO);
		
		ProdutoRN prn = new ProdutoRN();
		prn.getDao().setSession(getDaoSession());
		
		// Primeiramente encontra os ids para o produto que sai e para o que entra
		OmProduto omprodutoSai = null;
		OmProduto omprodutoEntra = null;

		String cdProduto =  Util.extraiPorMascara(listaMontagem.get(0).getDsProdutoEsperado(), retorno.getOmcfg().getMascaracdprodutomp());// prn.extraiProduto(listaMontagem.get(0).getDsProdutoEsperado(), retorno.getOmcfg().getMascaracdprodutofilho());
		
		omprodutoSai = prn.getProdutoByDepara(cdProduto);
		
		cdProduto = Util.extraiPorMascara(listaMontagem.get(0).getCb(), retorno.getOmcfg().getMascaracdprodutomp());
		omprodutoEntra = prn.getProdutoByDepara(cdProduto);
		
		// Verifica se existe uma lista de montagem para a passagem
		Set<DwPassmon> dwpassmons = oDwPassagem.getDwPassmons();
	
		// Se nao existir 
		if (dwpassmons == null || dwpassmons.size() == 0){
			// obter qual foi a ultima montagem para o numero de serie
			DwPassagem dwpassagem = oDwNserie.getDwPassagem();
			// e copiar essa passagem para a passagem oDwPassagem
			Set<DwPassmon> dwpassmons2 = dwpassagem.getDwPassmons();
			for (DwPassmon dwpassmon2 : dwpassmons2){
				DwPassmon dwpassmonNovo = new DwPassmon();
				dwpassmonNovo.setDwPassagem(oDwPassagem);
				if (dwpassmon2 == null){
					//System.out.println("dwpassmon2 nulo");
				} else if (dwpassmon2.getOmProduto() == null) {
					//System.out.println("dwpassmon2.getomproduto nulo");
				}
				if (omprodutoSai == null){
					//System.out.println("omprodutoSai null");
				}
				if (dwpassmon2.getOmProduto().getIdProduto() == omprodutoSai.getIdProduto())
					dwpassmonNovo.setOmProduto(omprodutoEntra);
				else
					dwpassmonNovo.setOmProduto(dwpassmon2.getOmProduto());
				dwpassmonNovo.setIsAlternativo(false);
				
				getDaoSession().persist(dwpassmonNovo);
			}
			oDwNserie.setDwPassagem(oDwPassagem);
			getDaoSession().merge(oDwNserie);
		} else {
			// em seguida substituir o componente antigo pelo novo
			for (DwPassmon dwpassmon : dwpassmons){
				if (dwpassmon.getOmProduto().getIdProduto() == omprodutoSai.getIdProduto()){
					dwpassmon.setOmProduto(omprodutoEntra);
					getDaoSession().merge(dwpassmon);
				}
			}
		}
	}
	@Override
	protected void postoTesteFuncional(IdwLogger log, PassagemDTO passagem,
			DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
		// TODO Auto-generated method stub
		
	}

}
