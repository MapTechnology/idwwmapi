package idw.model.rn;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.OmTpptTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.OrigemDTO;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.SessaoDTO;
import injetws.model.excessoes.SemSGBDException;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.rn.UpRN;


public abstract class PostoPassagemRNAbs extends AbstractRN<DAOGenerico> {
	public PostoPassagemRNAbs(DAOGenerico dao) {
		super(dao);
	}
	
	protected abstract void postoMontagem(List<MontagemDTO> listaMontagem, DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) throws SemSGBDException;
	protected abstract void postoTesteFuncional(IdwLogger log, PassagemDTO passagem, DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) throws SemSGBDException;
	protected abstract void postoTesteVisual(List<DefeitoDTO> listaDefeitos, DwPassagem passagem) throws SemSGBDException;
	protected abstract void postoReprocesso(List<AcaoDTO> listaAcoes, List<OrigemDTO> listaOrigens, DwPassagem passagem, PassagemDTO retorno) throws SemSGBDException;

	private Session sessao;

	public PassagemDTO postosPassagem(PassagemDTO passagem) throws SemCalendarioException, SemSGBDException {
		IdwLogger log = new IdwLogger("PostoPassagemRNAbs");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		PassagemDTO retorno = new PassagemDTO();

		retorno.setCb(passagem.getCb());

		VerificaPassagemRN verRN = new VerificaPassagemRN(getDao());
		// instancia o LoginRN
		LoginRN oLoginRN = new LoginRN();
		oLoginRN.setSession(getDaoSession());
		// instancia o ConsolidaRN
		ConsolidaRN oConsolidaRN = new ConsolidaRN();
		oConsolidaRN.getDao().setSession(this.getDaoSession());

		try {
			retorno = verRN.verificaPassagem(passagem);
		} catch (NumeroSerieIrregularException e1) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().CONFIGURACAO_DESCONHECIDA);
		}
		retorno.setEnviarRefugo(passagem.getEnviarRefugo());
		retorno.setPosicoesMecanicas(passagem.getPosicoesMecanicas());

		// atualiza omPt com a ultima folha passada no posto
		PTRN ptrn = new PTRN();
		ptrn.setDaoSession(this.getDaoSession());
		OmPt ompt = null;
		if (passagem.getIdPt() != 0)
			ompt = ptrn.getDao().findById(OmPt.class, passagem.getIdPt(), false);
		else
			try {
				ompt = ptrn.getOmPt(passagem.getCdPt());
				passagem.setIdPt(ompt.getIdPt());
				passagem.setIdGt(ompt.getOmGt().getIdGt());
			} catch (RegistroDesconhecidoException e1) {
				
			}

		// Se o posto for reprocesso nao considerar o ROTEIRO INCONSISTENTE
		if (
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGIN_GT_COM_SUCESSO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGIN_GT_PRE_EXISTENTE) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGIN_NAO_HOMOLOGADO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGIN_PT_COM_SUCESSO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGIN_PT_PRE_EXISTENTE) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGOUT_GT_COM_SUCESSO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGOUT_PT_COM_SUCESSO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGOFF_DE_OPERADOR) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGOFF_DE_SUPERVISOR) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGON_DE_OPERADOR) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGON_DE_SUPERVISOR) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().ACAO_DESCONHECIDA) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().ORIGEM_DESCONHECIDA) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().COMPONENTE_NAO_PERTENCE_AO_PRODUTO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().CONFIGURACAO_DESCONHECIDA) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().DEFEITO_DESCONHECIDO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().ERRO_CC_DESCONHECIDO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGIN_AFERICAO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().LOGIN_MANUTENCAO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().PRODUTO_DESCONHECIDO) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().ROTEIRO_INCONSISTENTE && ompt.getOmTppt().getIdTppt() != OmTpptTemplate.Type.PRE.getId()) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().CONFIGURACAO_DESCONHECIDA) ||
				(retorno.getResultado().getIdmensagem() == retorno.getResultado().ERRO_CONFIGURACAO_SENDO_USADA)
				){


			retorno.setDwfolha(null);
			retorno.setDwnserie(null);
			retorno.setDwrotapasso(null);
			retorno.setOmcfg(null);
			return retorno;
		}


		// A partir daqui tudo esta verificado

		retorno.setTppt(ompt.getOmTppt().getIdTppt().intValue());
		// obtem o supervisor atual do GT
		DwConsolmolog oDwConsolmologGt = null;
		oDwConsolmologGt = oLoginRN.getSupervisorGt(passagem.getIdGt());

		// Se a folha nao existe em retorno, pesquisa-la anovamente
		if (retorno.getDwfolha() == null || retorno.getDwfolha().getIdFolha() == null) {
			CpRN rncp = new CpRN(getDao());
			// Pesquisar a OP e pegar a folha da OP
			PpCp ppcp = rncp.pesquisarPpCpByNrDocCdPt(passagem.getCdOp(), ompt.getCdPt());
			if (ppcp == null)
				ppcp = ompt.getPpCp();
			
			if (ppcp.getDwFolha() != null)
				retorno.setDwfolha(ppcp.getDwFolha());
		}
		
		if (retorno.getDwnserie() == null || retorno.getDwnserie().getIdNserie() == 0) {
			NumeroSerieRN rn = new NumeroSerieRN();
			rn.setDaoSession(getDaoSession());
			DwNserie oDwNserie;
			try {
				oDwNserie = rn.getDwNserieCb(retorno.getCb());
				retorno.setDwnserie(oDwNserie);
			} catch (NumeroSerieIrregularException e) {
				retorno.setDwnserie(null);
			}
		}
		// consolidObtido = RN - Obtem consolid.c (passagemDTO)
		DwConsolid oDwConsolid = null;
		oDwConsolid = oConsolidaRN.obtemConsolIdTurno(log, idLog, identacao, passagem, retorno.getDwfolha());

		ompt.setDwFolha(retorno.getDwfolha());
		ptrn.getDao().makePersistent(ompt);

		SessaoDTO s = new SessaoDTO();

		// salva passagem do produto
		Byte stNSerie;
		//se passagem.resultadoPassagem = OK E retorno.resultado.idmensagem = COM SUCESSO
		if(passagem.getResultado().getIdmensagem() == passagem.getResultado().getCOM_SUCESSO() ) {
			stNSerie = 1;
		}
		else {
			stNSerie = 0;
		}

		// pegando milisegundos da data do evento
		String msDtHrEvento = new SimpleDateFormat("SSS").format(passagem.getDtHrEvento());
		DwPassagem oDwPassagem = new DwPassagem();

		// Se o posto for reprocesso entao verificar se o ultimpo posto do numero de serie foi um reprocesso. Se sim, utilizar a mesma
		// passagem

		boolean isUtilizarNovaPassagem = true;

		// Se o posto for de reprocesso, obter entao a ultima passagem, pois o reprocesso pode lancar eventos esporadicos
		// que devem ser associados a mesma passagem.
		// NO entanto se for o resultado final de um teste funcional uma nova passagem deve ser criada
		if (retorno.getTppt() == s.PT_TESTE_REPROCESSO){
			oDwPassagem = this.getDwPassagem(retorno.getDwnserie(), ompt.getIdPt());
			if ((oDwPassagem != null) && (passagem.isDeveSerPassagemNova() == false)) {
				isUtilizarNovaPassagem = false;
			} else {
				oDwPassagem = new DwPassagem();
				isUtilizarNovaPassagem = true;
				oDwPassagem.setDthrInicio(passagem.getDtHrEvento());
				oDwPassagem.setMsDthrinicio(new Integer(msDtHrEvento));
				oDwPassagem.setIsTfFinalizado(false);
			}
			// Salva se o teste funcinal foi finalizado
			if (passagem.getResultadoTesteFuncional() == null || passagem.getResultadoTesteFuncional().isReceitaFinalizada() == false) {
				oDwPassagem.setIsTfFinalizado(false);
			} else {
				oDwPassagem.setIsTfFinalizado(passagem.getResultadoTesteFuncional().isReceitaFinalizada());
			}
		}

		// Se o posto for de teste funcional, obter a ultima passagem pois quando o posto for para coleta total, as medicoes serao
		// enviadas paulatinamente. Mas deve-se usar a mesma passagem se existir a indicacao que a mesma nao finalizou
		if (retorno.getTppt() == s.PT_TESTE_FUNCIONAL ){
			oDwPassagem.setIsTfFinalizado(false);
			oDwPassagem = this.getDwPassagem(retorno.getDwnserie(), ompt.getIdPt());
			if ((oDwPassagem != null) && (oDwPassagem.getIsTfFinalizado() == false)  && (passagem.isDeveSerPassagemNova() == false)) {
				isUtilizarNovaPassagem = false;
			} else {
				oDwPassagem = new DwPassagem();
				oDwPassagem.setDthrInicio(passagem.getDtHrEvento());
				oDwPassagem.setMsDthrinicio(new Integer(msDtHrEvento));
				oDwPassagem.setDwEst(retorno.getDwrotapasso().getDwEst());
				oDwPassagem.setDwConsolid(oDwConsolid);
				oDwPassagem.setIsTfFinalizado(false);
				isUtilizarNovaPassagem = true;
			}

			// Salva se o teste funcinal foi finalizado
			if (passagem.getResultadoTesteFuncional() == null) {
				oDwPassagem.setIsTfFinalizado(false);
			} else {
				oDwPassagem.setIsTfFinalizado(passagem.getResultadoTesteFuncional().isReceitaFinalizada());
			}
		}

		// Atualiza a data do evento e o tempo de ciclo
		oDwPassagem.setDthr(passagem.getDtHrEvento());
		oDwPassagem.setMsDthr(new Integer(msDtHrEvento));
		Date inicio = null;
		try{
			inicio = DataHoraRN.getDataComMilisegundos(oDwPassagem.getDthrInicio(), oDwPassagem.getMsDthrinicio());
		} catch (NullPointerException e){
			inicio = new Date();
		}
		Date fim = null;
		try {
			fim = DataHoraRN.getDataComMilisegundos(oDwPassagem.getDthr(), oDwPassagem.getMsDthr());
		} catch (NullPointerException e){
			fim = new Date();
		}
		BigDecimal ciclo = new BigDecimal(DataHoraRN.getQuantidadeSegundosNoPeriodo(inicio, fim));
		oDwPassagem.setSegCiclo(ciclo);

		if (isUtilizarNovaPassagem == true ) {


			oDwPassagem.setDwNserie(retorno.getDwnserie());

			oDwPassagem.setDwConsolid(oDwConsolid);

			// Pesquisa o operador
			// Obter o ultimo operador logado que permanece logado
			List<DwConsolmolog> lista = oConsolidaRN.getDwConsolmologComLoginAberto(ompt.getIdPt());
			OmUsr omusrOperador = null;
			if (lista != null && lista.isEmpty() == false) {
				omusrOperador = lista.get(lista.size()-1).getOmUsr();
			}
			
			// Se nao tem operador logado, verificar se veio no dto
			if (omusrOperador == null && passagem.getIdUsr() > 0) {
				omusrOperador = getDao().findById(OmUsr.class, passagem.getIdUsr(), false);
			}

			oDwPassagem.setOmUsrByIdUsroperador(omusrOperador);

			if (oDwPassagem.getOmUsrByIdUsroperador() == null){
				//System.out.println("Setou um operador null, mas nao deveria idusr = " + passagem.getIdUsr());
			}
			if (oDwConsolmologGt != null) {
				oDwPassagem.setOmUsrByIdUsrsupervisor(oDwConsolmologGt.getOmUsr());
			}

			// TODO: verificar se funciona
			oDwPassagem.setOmPt(ompt);
			oDwPassagem.setStNserie(stNSerie);

			this.getDaoSession().save(oDwPassagem);
		}


		/**
		 * O POSTO DE PASSAGEM SOMENTE UTILIZA O RETORNO PARA PASSAR O RESULTADO
		 * OUTROS POSTOS PODEM UTILIZAR PARA OUTRA COISA, E AQUI ELES ATUALIZAM
		 * O RETORNO
		 */

		/* inicio do trecho incluido para posto de teste funcional */
		try {
			this.postoTesteFuncional(log, passagem, oDwPassagem, retorno.getDwnserie(), retorno);
		} catch (Exception e){
			e.printStackTrace();
			throw new SemSGBDException();
		}
		/* fim do trecho incluido para posto de teste funcional */


		/* inicio do trecho incluido para posto de teste visual */
		this.postoTesteVisual(passagem.getListaDefeitos(), oDwPassagem);
		/* fim do trecho incluido para posto de teste visual */

		/* inicio do trecho incluido para posto de montagem */
		this.postoMontagem(passagem.getListaMontagem(), oDwPassagem, retorno.getDwnserie(), retorno);
		/* fim do trecho incluido para posto de montagem */

		/* inicio do trecho incluido para posto de reprocesso*/
		this.postoReprocesso(passagem.getListaAcoes(), passagem.getListaOrigens(), oDwPassagem, retorno);
		/* fim do trecho incluido para posto de reprocesso*/

		// informa se o real-time deve considerar o posto como amarelo
		oDwConsolid.getDwRt().setIsConforme(stNSerie.intValue() == 1 ? true : false);
		//registro salvo deve atualizar retorno

		// verifica se o posto eh do tipo que libera para estoque E stnserie = 1 (com sucesso) (rotapasso.is_liberacao = true)
		if(
				retorno.getDwrotapasso() != null &&
				retorno.getDwrotapasso().getIsLiberacao() != null && 
				retorno.getDwrotapasso().getIsLiberacao().booleanValue() == true && 
				stNSerie.intValue() == 1) { // se for
			// obter para qual estoque deve ir
			// rotapasso.id_est

			// alterar o estoque atual do numero de serie para o novo estoque
			if ((retorno.getDwrotapasso() != null) && (retorno.getDwrotapasso().getDwEst() != null) && (retorno.getDwrotapasso().getDwEst().getIdEst() > 0)){
				// Salva o estoque se:
				// 1) N�o for um posto de teste eletrico
				// 2) Se for um posto de teste eletrico e o produto tiver sido bloqueado mesmo q tenha sido com sucesso o teste
				if ((retorno.getTppt() != s.PT_TESTE_PASSA_NAO_PASSA) || ( (retorno.getTppt() == s.PT_TESTE_PASSA_NAO_PASSA) && ((retorno.getNaoConformidadesAtuais() == null) || (retorno.getNaoConformidadesAtuais().size() <= 0)))){
					// procuparar o estoque e alterar no numero de serie
					retorno.getDwnserie().setDwEst((DwEst) this.getDaoSession().get(DwEst.class, retorno.getDwrotapasso().getDwEst().getIdEst()));
					//merge
					this.getDaoSession().merge(retorno.getDwnserie());
					oDwPassagem.setDwEst((DwEst) this.getDaoSession().get(DwEst.class, retorno.getDwrotapasso().getDwEst().getIdEst()));
					this.getDaoSession().merge(oDwPassagem);
				}
			}
		}
		
		// Lancar evento de final de ciclo para a passagem
		// Se existir mais de uma passagem do CB no PT entao NAO lancar final de ciclo
		// esta sempre lancando pq a consolidacao descarta ciclos com cb repetido no mesmo posto
		int qtPassagens = 0;
		
		if (qtPassagens <= 1) {
			EventoColetado evento = new EventoColetado();
			evento.setDthrEvento(passagem.getDtHrEvento());
			evento.setCb(passagem.getCb());
			evento.setLog(log);
			evento.setCdop(oDwConsolid.getPpCp().getCdCp());
			evento.setTipoEvento(ServicoFactory._FIM_CICLO);
			evento.setIcUpDTO( Stubedelegate.getInstancia().getMsthread().getIcUp(ompt.getCdPt()) );
			evento.setCdcausa(passagem.getCdCausa());
			if (passagem.getListaDefeitos().isEmpty() == false) {
				DefeitoDTO defeitodto = passagem.getListaDefeitos().get(0);
				evento.setLogin(defeitodto.getLogin());
				evento.setCddefeito(defeitodto.getCdDefeito());
				evento.setCdacao(defeitodto.getCdAcao());
			}
			UpRN uprn = new UpRN(getDao(), null);
			uprn.setLog(log);
			try {
				if (evento.getIcUpDTO() != null)
					uprn.finalCiclo(idLog, 0, evento);
				else
					log.info(idLog, 0, "Lancamento do final de ciclo falhou.1");
			} catch (ServicoFalhouException e) {
				log.info(idLog, 0, "Lancamento do final de ciclo falhou");
			}
		}
		
		retorno.setDwfolha(null);
		retorno.setDwnserie(null);
		retorno.setDwrotapasso(null);
		retorno.setOmcfg(null);
		verRN = null;
		oLoginRN = null;
		oConsolidaRN = null;
		oDwConsolmologGt = null;
		oDwConsolid = null;
		ptrn = null;
		ompt = null;
		stNSerie = null;
//		msDtHrEventoAnt = null;
//		segEventos = null;
		oDwPassagem = null;
		s = null;

		return(retorno);
	}


	protected DwPassagem getDwPassagem(DwNserie ns, Long idPt) {
		String hql = "";

		// select * from dw_passagem where id_nserie = nserie and
		// id_pt = (a lista de pts) order by id_passagem desc

		hql += "SELECT dwpassagem ";
		hql += "FROM DwPassagem dwpassagem ";
//		hql += "JOIN dwpassagem.dwNserie dwnserie ";
		hql += "JOIN FETCH dwpassagem.omPt ompt ";
		hql += "WHERE dwpassagem.dwNserie.idNserie = ::idNserie AND ";
		hql += "dwpassagem.omPt.idPt = ::idPt ";
		hql += "ORDER BY dwpassagem.idPassagem DESC";

		hql = hql.replaceAll("::idNserie", String.valueOf(ns.getIdNserie()));
		hql = hql.replaceAll("::idPt", idPt.toString());

		DwPassagem oDwPassagem = null;
		try {
			oDwPassagem = Util.getDadosBanco(new DwPassagem(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ??????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwPassagem = null;
		}

		hql = null;

		return(oDwPassagem);
	}
	protected DwPassagem getDwPassagem(long id) {
		String hql = "";

		// select * from dw_passagem where id_nserie = nserie and
		// id_pt = (a lista de pts) order by id_passagem desc

		hql += "SELECT dwpassagem ";
		hql += "FROM DwPassagem dwpassagem ";
//		hql += "JOIN dwpassagem.dwNserie dwnserie ";
//		hql += "JOIN dwpassagem.omPt ompt ";
		hql += "WHERE ";
		hql += "dwpassagem.idPassagem = ::id ";

		hql = hql.replaceAll("::id", String.valueOf(id));

		DwPassagem oDwPassagem = null;
		try {
			oDwPassagem = Util.getDadosBanco(new DwPassagem(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ??????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwPassagem = null;
		}

		hql = null;

		return(oDwPassagem);
	}


	protected List<OmPt> getOmPtFolha(List<DwFolha> listaDwFolha) {
		String hql = "";

		StringBuilder sbListaIn = new StringBuilder();
		String listaIn = null;
		// gerando clausula IN
		for(DwFolha oDwFolha : listaDwFolha) {
			if(sbListaIn.length() > 0) {
				sbListaIn.append(",");
			}

			sbListaIn.append(oDwFolha.getOmTppt().getIdTppt());
		}
		// passando para string
		if(sbListaIn.length() > 0) {
			listaIn = sbListaIn.toString();
		}

		if(listaIn == null){
			hql = null;
			listaIn = null;
			sbListaIn = null;
			return(null);
		}
		// select * from om_pt where id_tppt = dw_folha.id_tppt (todos os ids encontrados no select anterior)

		hql += "SELECT distinct ompt ";
		hql += "FROM OmPt ompt ";
		hql += "JOIN ompt.omTppt omtppt ";
		hql += "WHERE ompt.stAtivo = 1 and (omtppt.idTppt IN (::idTppts))";

		hql = hql.replaceAll("::idTppts", listaIn);

		List<OmPt> listaOmPt = null;
		try {
			listaOmPt = Util.getDadosBancoLista(new OmPt(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ???????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			listaOmPt = null;
		}

		hql = null;
		listaIn = null;
		sbListaIn = null;

		return(listaOmPt);
	}

	protected List<DwFolha> getDwFolhaRotaPasso(List<DwRotapasso> listaDwRotapasso) {
		String hql = "";

		StringBuilder sbListaIn = new StringBuilder();
		String listaIn = null;
		// gerando clausula IN
		for(DwRotapasso oDwRotapasso : listaDwRotapasso) {
			if(sbListaIn.length() > 0) {
				sbListaIn.append(",");
			}

			sbListaIn.append(oDwRotapasso.getDwFolha().getIdFolha());
		}
		// passando para string
		if(sbListaIn.length() > 0) {
			listaIn = sbListaIn.toString();
		}

		if(listaIn == null) {
			return(null);
		}

		// select * from dw_folha where id_folha = dw_rotapasso.idfolha (todos os ids encontrados no select anterior)

		hql += "SELECT dwfolha ";
		hql += "FROM DwFolha dwfolha ";
		hql += "WHERE (dwfolha.idFolha IN (::idFolhas))";

		hql = hql.replaceAll("::idFolhas", listaIn);

		List<DwFolha> listaDwFolha = null;
		try {
			listaDwFolha = Util.getDadosBancoLista(new DwFolha(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ???????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			listaDwFolha = null;
		}

		hql = null;
		listaIn = null;
		sbListaIn = null;

		return(listaDwFolha);
	}

	protected List<DwRotapasso> getDwRotapassoFilho(List<DwRpPredecessora> listaDwRpPredecessora) {
		String hql = "";

		StringBuilder sbListaIn = new StringBuilder();
		String listaIn = null;
		// gerando clausula IN
		for(DwRpPredecessora oDwRpPredecessora : listaDwRpPredecessora) {
			if(sbListaIn.length() > 0) {
				sbListaIn.append(",");
			}

			sbListaIn.append(oDwRpPredecessora.getDwRotapassoByIdRotapassoFilho().getIdRotapasso());
		}
		// passando para string
		if(sbListaIn.length() > 0) {
			listaIn = sbListaIn.toString();
		}

		if(listaIn == null) {
			return(null);
		}

		// select * from dw_rotapasso where id_rotapasso = id_rotapassoFilho (todos os ids encontrados no select anteiror)

		hql += "SELECT dwrotapasso ";
		hql += "FROM DwRotapasso dwrotapasso ";
		hql += "WHERE (dwrotapasso.idRotapasso IN (::idRotapassos))";

		hql = hql.replaceAll("::idRotapassos", listaIn);

		List<DwRotapasso> listaDwRotapasso = null;
		try {
			listaDwRotapasso = Util.getDadosBancoLista(new DwRotapasso(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ???????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			listaDwRotapasso = null;
		}

		hql = null;
		listaIn = null;
		sbListaIn = null;

		return(listaDwRotapasso);
	}

	protected List<DwRpPredecessora> getDwRpPredecessoraRotaPasso(Long idRotaPasso) {
		String hql = "";

		// select * from dw_rp_predecessora where id_rotapassoPai = dw_rotapasso.id_rotapasso

		hql += "SELECT dwrppredecessora ";
		hql += "FROM DwRpPredecessora dwrppredecessora ";
		hql += "JOIN dwrppredecessora.dwRotapassoByIdRotapassoPai dwrotapassopai ";
		hql += "WHERE (dwrotapassopai.idRotapasso = ::idRotapasso)";

		hql = hql.replaceAll("::idRotapasso", idRotaPasso.toString());

		List<DwRpPredecessora> listaDwRpPredecessora = null;
		try {
			listaDwRpPredecessora = Util.getDadosBancoLista(new DwRpPredecessora(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ???????????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			listaDwRpPredecessora = null;
		}

		hql = null;

		return(listaDwRpPredecessora);
	}

	protected List<DwRotapasso> getRotaPassoFolha(Long idRota, Long idTppt, Long idGt) {
		String hql = "";

		//select * from dw_rotapasso where id_rota = dw_rota.id_rota and
		//exists (select * from dw_folha where is_modelo = false and
		//		st_ativo = 1 and id_tppt = passagem.id_tppt and
		//		id_gt = passagem.id_gt)

		hql += "SELECT dwrotapasso ";
		hql += "FROM DwRotapasso dwrotapasso ";
//		hql += "JOIN dwrotapasso.dwRota dwrota ";
//		hql += "JOIN dwrota.omGt omgt ";
		hql += "WHERE (dwrotapasso.dwRota.idRota = ::idRota) AND ";
		hql += "EXISTS (SELECT dwfolha ";
		hql += "	FROM DwFolha dwfolha ";
//		hql += "	JOIN dwfolha.omTppt omtppt ";
//		hql += "	JOIN dwfolha.omGt omgt ";
		hql += "	WHERE (dwfolha.isModelo = false) AND ";
		hql += "		(dwfolha.stAtivo = 1) AND ";
		hql += "		(dwfolha.omTppt.idTppt = ::idTppt) AND ";
		hql += "		(dwfolha.omGt.idGt = ::idGt) AND ";
		hql += "		(dwfolha.idFolha = dwrotapasso.dwFolha.idFolha)";
		hql += "	)";

		hql = hql.replaceAll("::idRota", idRota.toString());
		hql = hql.replaceAll("::idTppt", idTppt.toString());
		hql = hql.replaceAll("::idGt", idGt.toString());

		List<DwRotapasso> listaDwRotapasso = null;
		try {
			listaDwRotapasso = Util.getDadosBancoLista(new DwRotapasso(), this.getDaoSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ?????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			listaDwRotapasso = null;
		}

		hql = null;

		return(listaDwRotapasso);
	}

	protected List<DwFolha> getFolhaPosto(Long idTppt, Long idGt, Long idRota) {
		MapQuery q = new MapQuery(this.getDaoSession());

		// select * from dw_folha where is_modelo = false and
		// st_ativo = 1 and id_tppt = passagem.id_tppt and id_gt = passagem.id_gt

		q.append("SELECT distinct dwfolha ");
		q.append("FROM DwFolha dwfolha ");
		q.append("left join fetch dwfolha.dwRotapassos dwrotapasso ");
		q.append("left join fetch dwrotapasso.dwEst dwest ");
		q.append("left join fetch dwfolha.dwFolhamons dwfolhamon ");
		q.append("left join fetch dwfolhamon.dwFolhamoncomps dwfolhamoncomps ");
		q.append("WHERE ");
		q.append("(dwfolha.isModelo = false or dwfolha.isModelo is null) AND ");
		q.append("dwfolha.stAtivo = 1 AND ");
		q.append("dwfolha.omTppt.idTppt = :idTppt AND ");
		q.append("dwfolha.omGt.idGt = :idGt AND ");
		q.append("dwrotapasso.dwRota.idRota = :idrota ");

		q.defineParametro("idTppt", idTppt);
		q.defineParametro("idGt", idGt);
		q.defineParametro("idrota", idRota);
		

		List<DwFolha> oDwFolha = null;
		try {
			oDwFolha = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			oDwFolha = null;
		}

		q = null;

		return(oDwFolha);
	}

	public DwRota getRotaProduto(Long idGt, Long idProduto) {
		MapQuery q = new MapQuery(getDaoSession());

		// Obtem  o omProduto a partir do idProduto
		OmProduto omproduto = getDao().findById(OmProduto.class, idProduto, false);
		
		if (omproduto == null)
			return null;
		
		// select * from dw_rota where id_gt = passagem.id_gt and id_produto = retorno.id_produto

		q.append("SELECT dwrota ");
		q.append("FROM DwRota dwrota ");
		q.append("WHERE dwrota.omGt.idGt = :idGt AND ");
		q.append("dwrota.omProduto.cdProduto = :cdProduto AND ");
		q.append("dwrota.stAtivo = 1 ");

		q.defineParametro("idGt", idGt);
		q.defineParametro("cdProduto", omproduto.getCdProduto());
		q.setMaxResults(1);

		DwRota oDwRota = null;

		oDwRota = (DwRota) q.query().uniqueResult();

		q = null;

		return(oDwRota);
	}

	public Session getSession() {
		return this.sessao;
	}

	public void setSession(Session sessao) {
		this.sessao = sessao;
	}
}
