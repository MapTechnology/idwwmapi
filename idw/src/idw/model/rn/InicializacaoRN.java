package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.SessaoDTO;
import idw.webservices.dto.SessoesDTO;
import injetws.model.excessoes.SemSGBDException;


@SuppressWarnings("unchecked")
public class InicializacaoRN extends DAOGenerico {

	public SessoesDTO heartBeat(String mac, Date dtHrEvento) throws SemCalendarioException, SemSGBDException {
		IdwLogger log = new IdwLogger("InicializacaoRN");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		SessoesDTO retorno = new SessoesDTO();
		retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());

		MonitorizacaoRN mrn = new MonitorizacaoRN();
		mrn.getDao().setSession(getSession());
		
		// Identifica os dados da configuracao geral do sistema{
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getSession());
		if (oOmCfg == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getSEM_CONFIGURACAO());
			return (retorno);
		}

		// Identifica o PT e GT do mac passado
		List<OmPt> listaOmPt = null;
		listaOmPt = this.getPostoTrabalho(mac);
		if (listaOmPt == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPT_DESCONHECIDO());
			return (retorno);
		}

		// Obtem o usu�rio logado no CLP
		LoginRN rn = new LoginRN();
		rn.setSession(getSession());

		OmUsr omusr = null;
		try {
			omusr = rn.getUsrLoginPt(listaOmPt.get(0).getIdPt()).getOmUsr();
		} catch (NullPointerException e) {
			omusr = null;
		}

		// obtem consolid
		ConsolidaRN oConsolidaRN = new ConsolidaRN();
		oConsolidaRN.getDao().setSession(getSession());

		for (OmPt oOmPt : listaOmPt) {
			// Obtem o ultimo evento para cada pt
			DwPassagem dwpassagem = new DwPassagem();
			DwConsolid dwconsolid = new DwConsolid();
			dwconsolid.setDwRt(mrn.getDwRtForOmPt(oOmPt));
			dwpassagem.setDwConsolid(dwconsolid);

			SessaoDTO oSessaoDTO = null;

			oSessaoDTO = setSessaoInitBeat(oOmPt, mac, oOmCfg, dwpassagem, omusr);

			// adiciona sessao na lista de sessoes de retorno
			retorno.addSessaoDTO(oSessaoDTO);

			// seta passagemDTO para passar como paramtro para obter consolid
			PassagemDTO oPassagemDTO = new PassagemDTO();
			oPassagemDTO.setIdPt(oSessaoDTO.getIdPt());
			oPassagemDTO.setDtHrEvento(dtHrEvento);
			oPassagemDTO.setDtHrEventoAnterior(dtHrEvento);
			oPassagemDTO.setIdTppt(oSessaoDTO.getIdTppt());
			oPassagemDTO.setIdGt(oSessaoDTO.getIdGt());

			// obtem a ultima folha usada no posto de passagem
			DwFolha oDwFolha = oOmPt.getDwFolha();

			DwConsolid oDwConsolid = null;

			oDwConsolid = oConsolidaRN.obtemConsolIdTurno(log, idLog, identacao, oPassagemDTO, oDwFolha);

			oDwConsolid.getDwRt().setDthrHeartbeat(dtHrEvento);
			oDwConsolid.getDwRt().setIsOffline(false);

			// Se nao tiver operador logado, setar o RT.isOperador = false
			if (omusr == null && oDwConsolid.getDwRt().getIsOperador() == true){
				oDwConsolid.getDwRt().setIsOperador(false);
			}

			// atualiza dw_rt
			this.getSession().merge(oDwConsolid.getDwRt());
		}

		return (retorno);
	}

	public SessoesDTO inicializacao(String mac, Date dthrevento) {
		SessoesDTO retorno = new SessoesDTO();
		retorno.getResultado().setIdmensagem(
				retorno.getResultado().getCOM_SUCESSO());

		MonitorizacaoRN mrn = new MonitorizacaoRN();
		mrn.getDao().setSession(getSession());
		
		// Identifica os dados da configuracao geral do sistema{
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getSession());
		if (oOmCfg == null) {
			retorno.getResultado().setIdmensagem(
					retorno.getResultado().getSEM_CONFIGURACAO());
			return (retorno);
		}

		// Identifica o PT e GT do mac passado
		List<OmPt> listaOmPt = null;
		listaOmPt = this.getPostoTrabalho(mac);
		if (listaOmPt == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPT_DESCONHECIDO());
			return (retorno);
		}
		
		
		// Obtem o usu�rio logado no CLP
		LoginRN rn = new LoginRN();
		rn.setSession(getSession());

		OmUsr omusr = null;
		try {
			omusr = rn.getUsrLoginPt(listaOmPt.get(0).getIdPt()).getOmUsr();
		} catch (NullPointerException e) {
			omusr = null;
		}
		for (OmPt oOmPt : listaOmPt) {
			DwPassagem dwpassagem = new DwPassagem();
			DwConsolid dwconsolid = new DwConsolid();
			dwconsolid.setDwRt(mrn.getDwRtForOmPt(oOmPt));
			dwpassagem.setDwConsolid(dwconsolid);
			SessaoDTO oSessaoDTO = null;

			oSessaoDTO = setSessaoInitBeat(oOmPt, mac, oOmCfg, dwpassagem, omusr);

			// adiciona sessao na lista de sessoes de retorno
			retorno.addSessaoDTO(oSessaoDTO);
		}

		return (retorno);
	}

	public SessaoDTO setSessaoInitBeat(OmPt oOmPt, String mac, OmCfg oOmCfg, DwPassagem dwpassagem, OmUsr omusr) {
		SessaoDTO oSessaoDTO = new SessaoDTO();

		oSessaoDTO.setIdPt(oOmPt.getIdPt());
		if ( oOmPt.getOmGt() != null ){
			oSessaoDTO.setIdGt(oOmPt.getOmGt().getIdGt());
			oSessaoDTO.setDsGt(oOmPt.getOmGt().getDsCurta());
		}else {
			oSessaoDTO.setIdGt(0);
			oSessaoDTO.setDsGt("DESCONHECIDO");
			oSessaoDTO.getResultado().setIdmensagem(oSessaoDTO.getResultado().ERROR_GT_DESCONHECIDO);
		}
		// Obtem o GT com os dados de configuracao do escorpiao
		OmGt omgtEscorpiao = this.getGtDoEscorpiao(oOmPt);

		if (omgtEscorpiao != null){
			oSessaoDTO.setSegX(omgtEscorpiao.getSegX());
			oSessaoDTO.setSegY(omgtEscorpiao.getSegY());
			oSessaoDTO.setSegZ(omgtEscorpiao.getSegZ());
		}
		
		oSessaoDTO.setDsPt(oOmPt.getDsCurta());
		oSessaoDTO.setMac(mac);
		oSessaoDTO.setConexao(true);
		oSessaoDTO.setIdTppt(oOmPt.getOmTppt().getIdTppt());
		oSessaoDTO.setSegFeedbacklogin(oOmCfg.getSegFeedbacklogin());
		oSessaoDTO.setSegHeartbeat(oOmCfg.getSegHeartbeat());
		oSessaoDTO.setIdCal(oOmCfg.getDwCal().getIdCal());
		oSessaoDTO.setDthrParasincronia(DataHoraRN.getDataHoraAtual());
		oSessaoDTO.setSegLogoutauto(oOmCfg.getSegAutologout());
		oSessaoDTO.setMascaraCdProdutoPai(oOmCfg.getMascaracdprodutoCB());
		oSessaoDTO.setMascaraCdProdutoFilho(oOmCfg.getMascaracdprodutomp());
		if (omusr != null) {
			oSessaoDTO.setCdUsr(omusr.getCdUsr());
			if (omusr.getDsApelido() == null)
				if (omusr.getDsNome() == null)
					oSessaoDTO.setDs_apelido(omusr.getCdUsr());
				else
					oSessaoDTO.setDs_apelido(omusr.getDsNome());
			else
				oSessaoDTO.setDs_apelido(omusr.getDsApelido());
			oSessaoDTO.setIdUsr(omusr.getIdUsr());
		}
		if (oOmCfg.getIsLogonobrigatorio() == null)
			oSessaoDTO.setLogonObrigatorio(true);
		else
			oSessaoDTO.setLogonObrigatorio(oOmCfg.getIsLogonobrigatorio());
		oSessaoDTO.setDthrevento(dwpassagem.getDthr());
		if (dwpassagem.getDwConsolid().getDwRt() != null)
			oSessaoDTO.setDthrUltimoHeartBeat(dwpassagem.getDwConsolid().getDwRt().getDthrHeartbeat());
		oSessaoDTO.setTppt(0);
		oSessaoDTO.setIdGrpUsrSupervisor(oOmCfg
				.getOmUsrgrpByIdUsrgrpsupervisor().getIdUsrgrp());
		oSessaoDTO.setIdGrpUsrOperador(oOmCfg.getOmUsrgrpByIdUsrgrpoperador()
				.getIdUsrgrp());

		if (oSessaoDTO.getIdTppt() == oOmCfg.getOmTpptByIdTpptpm().getIdTppt()) { // se
																					// o
																					// posto
																					// for
																					// do
																					// tipo
																					// MONTAGEM
			oSessaoDTO.setTppt(oSessaoDTO.getPT_MONTAGEM());
		} else if (oSessaoDTO.getIdTppt() == oOmCfg.getOmTpptByIdTpptptf()
				.getIdTppt()) { // se o posto for do tipo TESTE FUNCIONAL
			oSessaoDTO.setTppt(oSessaoDTO.getPT_TESTE_FUNCIONAL());
		} else if (oSessaoDTO.getIdTppt() == oOmCfg.getOmTpptByIdTpptpts()
				.getIdTppt()) { // se o posto for do tipo PASSA N�O PASSA
			oSessaoDTO.setTppt(oSessaoDTO.getPT_TESTE_PASSA_NAO_PASSA());
		} else if (oSessaoDTO.getIdTppt() == oOmCfg.getOmTpptByIdTpptptscd()
				.getIdTppt()) { // se o posto for do tipo PASSA CODIGO DEFEITO
			oSessaoDTO.setTppt(oSessaoDTO.getPT_TESTE_PASSA_COD_DEFEITO());
		} else if (oSessaoDTO.getIdTppt() == oOmCfg.getOmTpptByIdTpptprepro()
				.getIdTppt()) { // se o posto for do tipo REPROCESSO
			oSessaoDTO.setTppt(oSessaoDTO.getPT_TESTE_REPROCESSO());
		} else if (oSessaoDTO.getIdTppt() == oOmCfg.getOmTpptByIdTpptppass()
				.getIdTppt()) { // se o posto for do tipo passagem
			oSessaoDTO.setTppt(oSessaoDTO.getPT_PASSAGEM());
		}

		// se o tipo do posto for desconhecido para a solu��o WHP
		if (oSessaoDTO.getTppt() == oSessaoDTO.getPT_DESCONHECIDO()) {
			oSessaoDTO.getResultado().setIdmensagem(
					oSessaoDTO.getResultado().getTIPO_PT_DESCONHECIDO());
		} else {
			oSessaoDTO.getResultado().setIdmensagem(
					oSessaoDTO.getResultado().getCOM_SUCESSO());
		}

		return (oSessaoDTO);
	}

	private OmGt getGtDoEscorpiao(OmPt oOmPt){
		OmGt retorno = null;
		List<OmGt> gtsParaAvaliacaoEscorpiao = new ArrayList<OmGt>();
		// Avalia em quais GTs o PT est�. Se algum dos GTs tiver definicao dos tempos do escorpiao, utilizar
		// essas definicoes
		for (OmObj omobj : oOmPt.getOmObjs()){
			if (
					(
					omobj.getOmGtByIdGt().getSegX() != null && 
					omobj.getOmGtByIdGt().getSegY() != null && 
					omobj.getOmGtByIdGt().getSegZ() != null 
					) && (
							omobj.getOmGtByIdGt().getSegX().intValue() > 0 && 
							omobj.getOmGtByIdGt().getSegY().intValue() > 0 && 
							omobj.getOmGtByIdGt().getSegZ().intValue() > 0 
					)
				) {
				retorno = omobj.getOmGtByIdGt();
				break;
			}
			gtsParaAvaliacaoEscorpiao.add(omobj.getOmGtByIdGt());
		}
		// Se nenhum GT com tempo do escorpiao foi associado ao PT e nenhum GT para avaliacao, ent�o
		// 
		if (retorno == null && gtsParaAvaliacaoEscorpiao != null) {
			// Avalia os GTs aos quais o PT pertence ate encontrar um que tenha a definicao de escorpiao
			for (OmGt omgt : gtsParaAvaliacaoEscorpiao){
				OmGt omgtEscorpiao = null;
				omgtEscorpiao = this.getGtDoEscorpiao(omgt);
				if (omgtEscorpiao != null){
					retorno = omgtEscorpiao;
					break;
				}
			}
		}
		
		return retorno;
	}

	private OmGt getGtDoEscorpiao(OmGt omgt){
		OmGt retorno = null;
		
		// Obtem os GTs pai que tem como filho o omgt
		List<OmGt> gtsPai = null;
		//TODO obter a  lista Pai
		
		if (gtsPai == null)
			return retorno;
		
		for (OmGt omgtEscorpiao : gtsPai){
			if (omgtEscorpiao.getSegX() != null || omgtEscorpiao.getSegY() != null || omgtEscorpiao.getSegZ() != null){
				retorno = omgtEscorpiao;
				break;
			}
		}
		// Se retorno == null significa que nenhum dos GTs pai possui definicao do escorpiao, entao
		// entrar em recursao para obter os tempos de cada galpao paii
		if (retorno == null){
			// TODO Viagem piloto
		}
		return retorno;
	}
	/**
	 * Funcao que retorna os postos de trabalho dado um mac
	 * 
	 * @param mac
	 *            - Endereco de identificacao da maquina
	 * @return Retorna uma lista de postos de trabalho (OmPt)
	 */
	public List<OmPt> getPostoTrabalho(String mac) {
		String hql = "";

		hql += "SELECT ompt ";
		hql += "FROM OmPt ompt ";
//		hql += "JOIN ompt.omGt ";
		hql += "WHERE ompt.stAtivo = 1 AND ";
		hql += "ompt.urlConexao = '::urlConexao' ";

		hql = hql.replaceAll("::urlConexao", mac);

		List<OmPt> listaOmPt = null;
		try {
			listaOmPt = this.getDadosBancoLista(new OmPt(), hql);
		} catch (SemSGBDException e) {
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
		}

		return (listaOmPt);
	}

	/**
	 * Funcao generica para executar uma query e retornar um resultado de um
	 * tipo
	 * 
	 * @param <T>
	 *            - tipo generico que utilize Hibernate (POJO)
	 * @param oGen
	 *            - novo objeto do tipo T
	 * @param hql
	 *            - hql a ser executada
	 * @return Retorna o objeto passado preenchido pela execucao da query
	 *         passada
	 * @throws SemSGBDException
	 *             Se deu pau no banco
	 * @throws RegistroDesconhecidoException
	 *             Se a query passada nao retornar registro algum
	 */
	public <T> T getDadosBanco(T oGen, String hql) throws SemSGBDException,
			RegistroDesconhecidoException {
		Query q = getSession().createQuery(hql);

		List<T> listaGen = null;
		try {
			listaGen = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		if (listaGen.size() > 0)
			oGen = listaGen.get(0);
		else
			throw new RegistroDesconhecidoException();

		return (oGen);
	}

	/**
	 * Funcao generica para executar uma query e retornar uma lista de
	 * resultados de um tipo
	 * 
	 * @param <T>
	 *            - tipo generico que utilize Hibernate (POJO)
	 * @param oGen
	 *            - novo objeto do tipo T
	 * @param hql
	 *            - hql a ser executada
	 * @return Retorna uma lista do objeto passado preenchido pela execucao da
	 *         query passada
	 * @throws SemSGBDException
	 *             Se deu pau no banco
	 * @throws RegistroDesconhecidoException
	 *             Se a query passada nao retornar registro algum
	 */
	public <T> List<T> getDadosBancoLista(T oGen, String hql)
			throws SemSGBDException, RegistroDesconhecidoException {
		Query q = getSession().createQuery(hql);

		List<T> listaGen = null;
		try {
			listaGen = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		if (listaGen.size() == 0)
			throw new RegistroDesconhecidoException();

		return (listaGen);
	}

}
