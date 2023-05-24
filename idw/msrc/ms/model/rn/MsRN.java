package ms.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.exception.SQLGrammarException;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.MsUsrDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsIc;
import idw.model.pojos.MsIhm;
import idw.model.pojos.MsMs;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsMsicupProduto;
import idw.model.pojos.MsMsihm;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUpihm;
import idw.model.pojos.MsUsr;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPromidia;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.MsIcTemplate;
import idw.model.pojos.template.OmPromidiaTemplate;
import idw.model.pojos.template.OmPtTemplate;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.RefugoRN;
import idw.model.rn.ResumoRetornoRegistrosRN;
import idw.model.rn.TempoRealRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.util.UtilsString;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaMSsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.MsDTO2;
import idw.webservices.rest.idw.v2.dto.UpIcMsDTO2;
import injetws.model.IwsFacade;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpAlertasEmAberto;
import injetws.model.pojos.PrUpLoginsEmAberto;
import injetws.model.pojos.PrUpProduto;
import injetws.model.rn.InfoRN;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.IhmDesconhecidoException;
import ms.excessao.MsDesconhecidoException;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.ListaMSDTO;
import ms.model.dto.MSalertaDTO;
import ms.model.dto.MsDTO;
import ms.model.dto.PortaEthernetDTO;
import ms.model.dto.ResultadoMSDTO;
import ms.model.dto.UpDTO;
import ms.model.dto.UpIhmDTO;
import ms.model.dto.UsuarioMSDTO;
import ms.model.rn.pdba.PrUpAlertasRN;
import ms.model.rn.pdba.PrUpProdutoRN;
import ms.model.rn.pdba.PrUpRN;
import ms.util.ConversaoTipos;

public class MsRN extends DAOGenerico {

	MsDTO msDTO;

	public MsRN() {
	}

	public void setMsDTO(MsDTO msdto) {
		this.msDTO = msdto;
	}

	public MsDTO getMsdDTO() {
		return this.msDTO;
	}

	/*
	 * Registrar um IHM em um MS significa que o IHM ir� comecar a receber dados
	 * de tempo real
	 */
	public void registrarIHM(IhmDTO ihmDTO) throws ServicoFalhouException, MsDesconhecidoException, IhmDesconhecidoException {
		IdwLogger log = new IdwLogger("registrarIHM-" + ihmDTO.getUrl_Ip());
		int idLog = log.getIdAleatorio();
		IhmRN ihmRN = new IhmRN();
		ihmRN.setIhmDTO(ihmDTO);
		ihmRN.setDao(this);
		MsIhm msIhm;
		MsMsihm msmsihm = new MsMsihm();
		MsMs msms = null;

		
		OmCfg omcfg = Util.getConfigGeral(getSession());
		
		log.info(idLog, 0, "Iniciando registrarIHM");
		
		msms = pesquisarMsMsPorURLConexao();
		
		log.info(idLog, 0, "pesquisando ihm pela url " + ihmDTO.getUrl_Conexao());
		msIhm = ihmRN.pesquisarMsIhmPorURLConexao();
		
		IdwFacade.getInstancia().setHoraServidorBanco(DataHoraRN.getDataHoraAtual(getDao()));

		// Altera o msihm.url_ip para o Ip do IHM que esta se registrando
		log.info(idLog, 0, "setando url ip para o ihm " + ihmDTO.getUrl_Ip());
		msIhm.setUrlIp(ihmDTO.getUrl_Ip());
		makePersistent(msIhm);

		msmsihm.setMsIhm(msIhm);
		msmsihm.setMsMs(msms);

		// Verifica se esta registrado, se nao estiver registrar
		msmsihm = pesquisarMsMsihmPorIdMSIdIHM(msIhm, msms);
		if (msmsihm == null) {
			msmsihm = new MsMsihm();
			msmsihm.setMsIhm(msIhm);
			msmsihm.setMsMs(msms);
			msmsihm.setDthrRegistro(DataHoraRN.getDataHoraAtual());
			makePersistent(msmsihm);
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				// Inicializa eventos
				IwsFacade.getInstancia().inicializacao(msIhm.getUrlConexao(), false, false, DataHoraRN.getDataHoraAtual());
		}

		// Inicializa a lista de Ups (Pt) para o Ihm
		Set<MsUpihm> listaUpsDoIhm = msIhm.getMsUpihms();
		List<IcUpDTO> listaIcUpDTO = new ArrayList<IcUpDTO>();

		InfoRN rninfo = new InfoRN(getDao());
		ConsolidaRN crn = new ConsolidaRN(getDao());
		
		log.info(idLog, 0, "qtde de ups no ihm=" + listaUpsDoIhm.size());

		for (MsUpihm msupihm : listaUpsDoIhm) {
			log.info(idLog, 0, "avaliando pt " + msupihm.getMsUp().getCdUp());
			
			
			// Somente a UP que tiver cadastrada em ompt entrar� na lista, assim o IHM nao receber� essa UP para gerenciar
			// Encontrar o OmPt referente a Up avaliada
			PTRN rnPt = new PTRN(getDao());
			OmPt ompt = null;
			try {
				ompt = rnPt.getOmPt(msupihm.getMsUp().getCdUp());
			} catch (RegistroDesconhecidoException e) {
				continue;
			}
			
			UpDTO upDTO = new UpDTO(msupihm.getMsUp(), ompt);

			IcUpDTO icupdto = new IcUpDTO();
			
			icupdto.setIc(null);
			icupdto.setUpDTO(upDTO);

			PrUpRN prUpRN = new PrUpRN(this);
			BcRN bcRN = new BcRN(this);

			PrUp prup = null;

			if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
				log.info(idLog, 0, "Pesquisando PRUP com " + msupihm.getMsUp().getCdUp());
				prup = prUpRN.getPrup(msupihm.getMsUp());
				// Atualiza dados do CIP
				if (prup != null)
					rninfo.verificaIsComCIP(log, idLog, prup);
				else {
					// 2019-10-02 Ailton: se chegou ate esse ponto e nao ha prup, pelo casos que vimos
					// e pq o ihm esta associado a um up, mas esse up nao esta cadastrado no modulo de sinais
					continue;
				}
			}

			upDTO.setIsComOP(!(prup == null || prup.getNrop() == null));

			// Se nao tiver prup entao o injet nao esta ativo, logo nao
			// poderemos pegar as configuracoes dele
			// assim assumiremos a op definida em ppCp
			if (prup == null) {
				// Encontrar DwRt para se usado como base dos dados
				TempoRealRN rn = new TempoRealRN(getDao());
				DwRt dwrt = null;
				dwrt = rn.obtemDwRtParaHeartBeat(DataHoraRN.getDataHoraAtual(), ompt, log, idLog, 0, null);

				if (dwrt != null) {
					/* Se o tipo do IC for 3 (Coleta dinamica) faz o update do dthrheartbeat
					 * 
					 */
					IcDTO icdto = Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByCdUp(ompt.getCdPt());
					if (icdto != null && icdto.getTp_ic().equals(3)) {
						dwrt.setDthrHeartbeat(DataHoraRN.getDataHoraAtual());
						dwrt.setIsOffline(false);
						// Verificar se o PT possui planejamento. Se possuir entao setar semPlanejamento false;
						// O sem planejamento true esta sendo setado no obtemDwRtParaHeartBeat para casos em que eventos futuros chegaram
						//e se deseja remover o planejamento. Mas se o pT tiver um planejamento carregado entao setar para false
						if ( (ompt.getIsSemop() != null && ompt.getIsSemop() == true) || ompt.getIsSemop() == null || ompt.getPpCp() == null)
							dwrt.setIsSemplanejamento(true);
						else
							dwrt.setIsSemplanejamento(false);
						
						// Verifica se existe operador logado
						List<DwConsolmolog> lope = crn.getDwConsolmologComLoginAberto(ompt.getIdPt());
						if (lope != null && lope.size() > 0)
							dwrt.setIsOperador(true);
						else
							dwrt.setIsOperador(false);

						getDao().makePersistent(dwrt);
					}
					
					
					// O tipo da sessao deve ser o mesmo definido no posto
					if (ompt.getTpSessao() != null)
						upDTO.setTpSessao(ompt.getTpSessao());
					else
						upDTO.setTpSessao(OmPtTemplate.TipoSessao.TP_RECUPERA_OP_NUMERO.getValue());
					
					upDTO.setBcOffLine(false); // pq o bc nao existe nesse
												// caso
					upDTO.setCdmaqestendido(msupihm.getMsUp().getCdUp());

					upDTO.setParadaEmAberto(dwrt.getStFuncionamento());
					upDTO.setUpParada(dwrt.getStFuncionamento().equals((byte) 0) ? true : false);
					
					if (dwrt.getPpCp() != null && ompt != null && (ompt.getIsSemop() == null || ompt.getIsSemop() == false) ) {
						if (dwrt != null && dwrt.getPpCp() != null && dwrt.getPpCp().getCdCp() != null && dwrt.getPpCp().getCdCp().equals("") == false && dwrt.getPpCp().getCdCp().equals("null") == false) {
							upDTO.setNropestendido(dwrt.getPpCp().getNrop());
							if (dwrt.getPpCp().getOmGt() != null)
								upDTO.setFilial(dwrt.getPpCp().getOmGt().getCdGt());
							else
								upDTO.setFilial("SF2");
							
							upDTO.setIsOPReprocesso(dwrt.getPpCp().getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()));
							
							// Abaixo mudanca para o driver da sony saber qual o unico produto da op permitindo refugar
							for (PpCpproduto cpproduto : dwrt.getPpCp().getPpCpprodutos()) {
								 upDTO.setCdproduto(cpproduto.getOmProduto().getCdProduto());
								 upDTO.setLerCB(cpproduto.getOmProduto().getIsRastreabilidade() != null ? cpproduto.getOmProduto().getIsRastreabilidade() : false);
							}
							
							
						} else {
							upDTO.setNropestendido("CD.INDEF");
							upDTO.setFilial("SF3");
						}
						upDTO.setIsComOP(true);
					} else {
						upDTO.setIsComOP(false);
					}
					upDTO.setProducaoliquida(String.valueOf(dwrt.getPcsProducaoliquidaOp()));
					upDTO.setProducaoplanejada(String.valueOf(dwrt.getPcsProducaoplanejadaOp()));

					upDTO.setIdUpPDBA(msupihm.getMsUp().getCdUp());
					upDTO.setParadaPermiteCorrecao(false);
					upDTO.setReqCancel(false);
					
					if (dwrt != null && dwrt.getDwConsolpalog() != null && dwrt.getDwConsolpalog().getDwTParada() != null) {
						upDTO.setDsParada(dwrt.getDwConsolpalog().getDwTParada().getDsTparada());
						upDTO.setCdParada(dwrt.getDwConsolpalog().getDwTParada().getCdTparada());
						if (dwrt.getDwConsolpalog().getDthrIparada() != null) {
							upDTO.setDthrIParada(dwrt.getDwConsolpalog().getDthrIparada());
							upDTO.setDthrFParada(dwrt.getDwConsolpalog().getDthrFparada());
						}
						upDTO.setParadaPermiteCorrecao(dwrt.getDwConsolpalog().getDwTParada().getIsPermitecorrecao() != null ? dwrt.getDwConsolpalog().getDwTParada().getIsPermitecorrecao()  : true);
						upDTO.setReqCancel(dwrt.getDwConsolpalog().getDwTParada().getIsRegulagem() != null ? dwrt.getDwConsolpalog().getDwTParada().getIsRegulagem() : false);
					} else {
						// Pesquisa a ultima parada da maquina independente do turno
						
						DwConsolpalog palog = crn.getUltimaParadaFromDwConsolpalog(ompt);
						if (palog != null) {
							upDTO.setDsParada(palog.getDwTParada().getDsTparada());
							upDTO.setCdParada(palog.getDwTParada().getCdTparada());
							if (palog.getDthrIparada() != null) {
								upDTO.setDthrIParada(palog.getDthrIparada());
								upDTO.setDthrFParada(palog.getDthrFparada());
							}
							upDTO.setParadaPermiteCorrecao(palog.getDwTParada().getIsPermitecorrecao() != null ? palog.getDwTParada().getIsPermitecorrecao()  : true);
							upDTO.setReqCancel(palog.getDwTParada().getIsRegulagem() != null ? palog.getDwTParada().getIsRegulagem() : false);
						}
					}

					RefugoRN rnref = new RefugoRN();
					rnref.setDao(getDao());

					DwConsolrelog dwConsolrelog = null;
					if (dwrt.getPpCp() != null)
						dwConsolrelog = rnref.getUltimoRefugo(ompt, dwrt.getPpCp());
					
					if (dwConsolrelog != null) {
						if (dwConsolrelog.getIsCancelado() == null || dwConsolrelog.getIsCancelado().equals(false)) {
							upDTO.setCdRefugo(dwConsolrelog.getDwTRefugo().getCdTrefugo());
							upDTO.setDsRefugo(dwConsolrelog.getDwTRefugo().getDsTrefugo());
							upDTO.setDthrIRefugo(dwConsolrelog.getDthrRefugo());
							if (dwConsolrelog.getMsDthrrefugo() != null) {
								upDTO.setMsdthrIRefugo(dwConsolrelog.getMsDthrrefugo().toString());
							}
							upDTO.setCdproduto(dwConsolrelog.getOmProduto().getCdProduto());
							DwFolha dwfolha = dwrt.getPpCp().getDwFolha();
							FolhaRN frn = new FolhaRN(getDao());
							DwFolharapcom rapcom;
							try {
								rapcom = frn.getFolharapcom(dwfolha, dwConsolrelog.getOmProduto());
							} catch (RegistroDesconhecidoException e) {
								rapcom = null;
							}
							if (rapcom == null)
								upDTO.setIdRdzProduto(upDTO.getCdproduto());
							else
								upDTO.setIdRdzProduto(ConversaoTipos.converterParaString(rapcom.getIdredzproduto()));
						}
					}
					upDTO.setUpTrabalhando(upDTO.getUpParada() == false);
					
					boolean rtOffline = dwrt.getIsOffline() == null ? true : dwrt.getIsOffline();
					int diff = 0;
					if (dwrt.getDthrHeartbeat() != null)
						diff = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwrt.getDthrHeartbeat(), DataHoraRN.getDataHoraAtual());

					if (rtOffline == false && diff > 1200) {
						rtOffline=true;
					}
					upDTO.setOffline(rtOffline);

					upDTO.setListaOperadoresLogados(avaliarLogoutOperadores(ompt, DataHoraRN.getDataHoraAtual(), log, omcfg));
					upDTO.setListaAlertasEmAberto(prepararListaAlertasEmAbertoIDW(ompt));
					upDTO.setListaProdutos(prepararListaProdutoIDW(dwrt));
					
					
					
					
					
				} else {
					// offline??????
				}

			}

			if (prup != null) {

				try {
					upDTO.setTpSessao(Integer.parseInt(prup.getCfgtpsessaoproducao().toString()));
					upDTO.setBcOffLine(bcRN.verificaBCOnLine(prup));
				} catch (Exception e) {

					e.printStackTrace();
				}

				upDTO.setCdmaqestendido(prup.getCdmaqestendido());
				if (prup.obtemDadosCIPDTO() != null) {
					upDTO.setCip(prup.obtemDadosCIPDTO().getIsEmCIP());
					upDTO.setCipIniciado(prup.obtemDadosCIPDTO().getIsCIPPendente() == false);
					// Alessandre: aparentemente o cipPendente pode estar true e o CIP false. Assim,
					//para efeito do tablet funcionar vou considerar CIP tambem true se pendente for true, pois CIP eh a flag para
					// o ihm saber que o CIP esta sendo controlado mesmo estando pendente
					if (prup.obtemDadosCIPDTO().getIsCIPPendente())
						upDTO.setCip(true);
					
				} else {
					upDTO.setCip(false);
					upDTO.setCipIniciado(false);
				}
			}
			
			
			if (prup != null && upDTO.getIsComOP() == true) {

				// PrParada prparada= new PrParada();// TODO: MUdar para
				// IwsPAradaDTO
				PrUpProduto prproduto = null;

				upDTO.setParadaEmAberto( ConversaoTipos.converterParaByte(prup.getStparadaemaberto() ) );
				// Faz a verificacao se o BC esta offline

				upDTO.setUpParada( upDTO.getParadaEmAberto() == (byte) 1);
				upDTO.setUpTrabalhando(!upDTO.getUpParada());

				PrUpProdutoRN prUpProdutoRN = new PrUpProdutoRN(this);
				prproduto = prUpProdutoRN.pesquisaProdutoPorIdUp(prup);
				upDTO.setListaProdutos(prUpProdutoRN.pesquisaListaProdutoPorUp(prup.getIdup()));

				if (prproduto != null) {
					upDTO.setNropestendido(prup.getNropestendido());
					upDTO.setFilial("SF4");

					try {
						upDTO.setProducaoliquida(String.valueOf(prproduto.getQtdprodliquida()));
						upDTO.setProducaoplanejada(String.valueOf(prproduto.getQtdplan()));
					} catch (Exception e) {

						upDTO.setProducaoliquida("");
						upDTO.setProducaoplanejada("");
					}

					upDTO.setCdproduto(prproduto.getCdproduto());

				}

				IwsParadaDTO parada = new IwsParadaDTO();
				IwsFacade iws = new IwsFacade();
				// 2019-10-02 Ailton
				// Algumas vezes, quando se atualiza o cadastro do UP, nao se consegue obter temporariamente 
				// o upDTO.getIdUpPDBA(), nesse casos, utilizar o id vinndo do prup que e o mesmo
				if (upDTO.getIdUpPDBA() == null)
					parada = iws.getTr_TabParadaSetaCod(prup.getIdup().toString(), prup.getCdultimaparada());
				else
					parada = iws.getTr_TabParadaSetaCod(upDTO.getIdUpPDBA(), prup.getCdultimaparada());
				upDTO.setIdUpPDBA(prup.getIdup().toString());

				if (prup.getCdultimaparada() != null && !prup.getCdultimaparada().equals("999999")) {

					// TODO: Mudar par o m�todo de InjetParadaRN que retorna
					// IwsParadaDTO
					// prparada = pRN.getPrParada(prup.getCdultimaparada());
					upDTO.setDsParada("");// prparada.getDsparada()
					if (parada != null && parada.getDsParada() != null)
						upDTO.setDsParada(UtilsString.removeCaracteresEspeciaisListString(parada.getDsParada()));// prparada.getDsparada()
					upDTO.setCdParada(prup.getCdultimaparada());
					upDTO.setDthrIParada(prup.getDthriniultimaparada());
					if (parada != null) {
						upDTO.setReqCancel(parada.getIsRegulagem());
						if (parada.getIsPodeAlterarCdPar() != null)
							upDTO.setParadaPermiteCorrecao(parada.getIsPodeAlterarCdPar());
						else
							upDTO.setParadaPermiteCorrecao(true);
					}

				} else if (prup.getCdultimaparada() != null && prup.getCdultimaparada().equals("999999")) {
					upDTO.setDsParada("Parada nao informada");
					upDTO.setCdParada(prup.getCdultimaparada());
					upDTO.setDthrIParada(prup.getDthriniultimaparada());

				} else {
					upDTO.setDsParada("");
					upDTO.setCdParada("");
					upDTO.setDthrIParada(null);
					upDTO.setDthrFParada(null);
				}

				/*
				 * PrRefugo refugo = prRefugoRN.getRefugo(prup); if (refugo !=
				 * null){ upDTO.setDsRefugo(refugo.getDsrefugo());
				 * 
				 * }else{ upDTO.setDsRefugo("refugo n�o informado"); }
				 */
				// Ailton 2019-08-26
				// TODO Verificar o motivo de  prup.getCdultimorefugo() estar null as vezes
				if (prup.getCdultimorefugo() != null) {
					IwsRefugoDTO refugoDTO = new IwsRefugoDTO();
					refugoDTO = iws.getTr_TabValidaCodRefugo(upDTO.getIdUpPDBA(), prup.getCdultimorefugo());
					upDTO.setCdRefugo(prup.getCdultimorefugo());
					if (refugoDTO != null)
						upDTO.setDsRefugo(refugoDTO.getDsRefugo());
				}
				if (prup.getDthrultimorefugo() != null)
					upDTO.setDthrIRefugo(prup.getDthrultimorefugo());

				// TODO Verificar o motivo de msDthrUltimoRefugo estar null. Nao
				// deveria
				if (prup.getMsdthrultimorefugo() != null)
					upDTO.setMsdthrIRefugo(prup.getMsdthrultimorefugo().toString());
				else
					upDTO.setMsdthrIRefugo("999");

				if (prup.getIdreduzidaproduto() != null)
					upDTO.setIdRdzProduto(prup.getIdreduzidaproduto().toString());
				else
					upDTO.setIdRdzProduto("");

				/*
				 * Preparando lista de operadores logados
				 */
				upDTO.setListaOperadoresLogados(prepararListaOperadoresLogados(prUpRN, prup));

				PrUpAlertasRN prUpAlertasRN = new PrUpAlertasRN(this);
				List<PrUpAlertasEmAberto> listaalertas = prUpAlertasRN.getAlertas(prup);
				if (listaalertas != null) {
					upDTO.setListaAlertasEmAberto(new ArrayList<MSalertaDTO>());
					for (PrUpAlertasEmAberto alertaEmAberto : listaalertas) {
						MSalertaDTO msAlertaDTO = new MSalertaDTO(alertaEmAberto);

						try {
							// PrAlerta alerta =
							// aRN.getPrAlerta(prup.getIdup().toString(),
							// alertaEmAberto.getCdalerta());
							msAlertaDTO.setDsAlerta("");

						} catch (Exception e) {
							msAlertaDTO.setDsAlerta("Alerta Desconhecido");
						}
						upDTO.getListaAlertasEmAberto().add(msAlertaDTO);
					}
				}
			} else {
				if (prup != null) {
					upDTO.setListaOperadoresLogados(prepararListaOperadoresLogados(prUpRN, prup));
				}

			}

			if (prup != null)
				getDao().evict(prup);

			// Marcos Sardinha: 2020-08-07 - trecho abaixo incluido por causa do IHM Web 3 (Injet) 
			// status que indicava maq offline em upDTO nao estava sendo avaliado (aparentemente procura essa  
			if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
				DAOGenericoInjet daoInjet  = new DAOGenericoInjet();
				String strSQL = "";
				SQLQuery q = null;
				List<Object> listaReg = null;
				
				strSQL = "";
				strSQL = strSQL.concat("SELECT a.cdinjestendido, a.stfuncionamento ");
				strSQL = strSQL.concat("  FROM ijtbinj a ");
				strSQL = strSQL.concat(" WHERE a.cdinjestendido = :cdmaquina ");
				daoInjet.getDao().iniciaSessao();
				q = daoInjet.getDao().getDao().getSession().createSQLQuery(strSQL);
				q.setParameter("cdmaquina", prup.getCdmaqestendido());
				q.setMaxResults(1);
				listaReg = q.list();
				
				Object[] registroLido = null;
				Object reg = null;
				reg = listaReg.get(0);
				Object registroAux = (Object) reg;
				registroAux = (Object) reg;
				registroLido = (Object[]) registroAux;

				
				registroLido = null;
				reg = null;
				reg = listaReg.get(0);
				registroAux = (Object) reg;
				registroAux = (Object) reg;
				registroLido = (Object[]) registroAux;
				
				if (registroLido[1] == null) {
					upDTO.setOffline(true);
				} else {
					upDTO.setOffline(((String)(registroLido[1])).toString().equals("2"));	
				}
				
				
				daoInjet.finalizaConexaoBanco();
			}
			
			listaIcUpDTO.add(icupdto);
		}
		// pRN = null;
		// aRN = null;
		msDTO.setIcsColetados(listaIcUpDTO);
		msDTO.setOmcfg(omcfg);
		
		log.info(idLog, 0, "FIM registrarIHM");
	}
	

	private List<UsuarioMSDTO> prepararListaOperadoresLogados(PrUpRN prUpRN,
			PrUp prup) {
		List<UsuarioMSDTO> retorno = new ArrayList<UsuarioMSDTO>();

		List<PrUpLoginsEmAberto> listaoperadores = prUpRN
				.getOperadoresLogados(prup);

		if (listaoperadores != null) {

			for (PrUpLoginsEmAberto logins : listaoperadores) {
				UsuarioMSDTO usuario = new UsuarioMSDTO();
				usuario.setDthrLogin(logins.getDthrlogin());
				usuario.setLogin(logins.getCdusuario());
				usuario.setCdusuario(logins.getCdusuario());
				usuario.setNome(logins.getCdusuario());// TODO: SENOJ GetNomeOperador(pruploginemaberto.getCdusuario(),idUP)
				retorno.add(usuario);
			}
		}
		return retorno;
	}

	/**
	 * Metodo para buscar operador logado pelo IDW
	 * 
	 * @param omPt
	 * @return
	 */
	private List<UsuarioMSDTO> avaliarLogoutOperadores(OmPt omPt, Date dthrEvento, IdwLogger log, OmCfg omcfg) {
		List<UsuarioMSDTO> retorno = new ArrayList<UsuarioMSDTO>();

		ConsolidaRN rn = new ConsolidaRN(getDao());
		List<DwConsolmolog> listaDwConsolmolog = new ArrayList<DwConsolmolog>();
		listaDwConsolmolog = rn.getDwConsolmologComLoginAberto(omPt.getIdPt());

		if (listaDwConsolmolog != null) {
			// Obtem o turno atual para determinar se o posto deve ter logout automatico de operador
			TurnoAtualDTO dwTurnoAtual = null;
			int segTempoDisponivelTurno = 0;
			
			if (omcfg.getIsLogoutautomatico() != null && omcfg.getIsLogoutautomatico()) {
				dwTurnoAtual = IdwFacade.getInstancia().getTurnoAtualDTO(omPt, dthrEvento);
				segTempoDisponivelTurno = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwTurnoAtual.getDtHrITurnoComTolerancia(), dthrEvento);
				
				if (omcfg.getSegLogoutautomatico() != null)
					segTempoDisponivelTurno += omcfg.getSegLogoutautomatico().intValue();
			}
			
			
			for (DwConsolmolog dwConsolmolog : listaDwConsolmolog) {
				UsuarioMSDTO usuario = new UsuarioMSDTO();
				usuario.setDthrLogin(dwConsolmolog.getDthrIlogin());
				usuario.setLogin(dwConsolmolog.getOmUsr().getLogin());
				usuario.setCdusuario(dwConsolmolog.getOmUsr().getCdUsr());
				usuario.setNome(dwConsolmolog.getOmUsr().getDsNome());
				retorno.add(usuario);
				
				
				if (omcfg.getIsLogoutautomatico() != null && omcfg.getIsLogoutautomatico()) {
				
					/* Avaliar se os operadores logados devem fazer logout automatico */
					int segTempoLogin = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwConsolmolog.getDthrIlogin(), dthrEvento);
					if (segTempoLogin > segTempoDisponivelTurno) {
						log.info("Executando logout automatico para login " + dwConsolmolog.getOmUsr().getLogin() + " duracaoLogin=" + segTempoLogin + " duracaoTurno:" + segTempoDisponivelTurno);
						// Lancar evento de logout do operador
						EventoColetado evento = new EventoColetado();
						evento.setDthrEvento(dthrEvento);
						evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(omPt.getCdPt()));
						evento.setLogin(dwConsolmolog.getOmUsr().getLogin());
						evento.setTipoEvento(ServicoFactory._LOGOUT);
						evento.setLog(log);
						
						MensagemRecebida mensagem = new MensagemRecebida(evento);
						mensagem.setLog(log);
						try {
							ServicoFactory.getInstancia().executaServico(null,mensagem);
						} catch (ServicoFalhouException e) {
							// TODO Auto-generated catch block
							log.info(e.getMessage());
							e.printStackTrace();
						}
	
					}
				}				

			}
		}
		return retorno;
	}

	/**
	 * Metodo para buscar alertar em aberto pelo IDW
	 * 
	 * @param omPt
	 * @return
	 */
	private List<MSalertaDTO> prepararListaAlertasEmAbertoIDW(OmPt omPt) {
		List<MSalertaDTO> retorno = new ArrayList<MSalertaDTO>();
		List<DwConsolallog> listaDwConsolallog = null;

		ConsolidaRN rn = new ConsolidaRN(getDao());
		listaDwConsolallog = rn.getDwConsolalManuaisComAlertaAberto(omPt);

		if (listaDwConsolallog != null) {
			for (DwConsolallog dwConsolallog : listaDwConsolallog) {
				MSalertaDTO msAlertaDTO = new MSalertaDTO();
				msAlertaDTO.setCdAlerta(dwConsolallog.getDwTAlerta().getCdTalerta());
				msAlertaDTO.setDsAlerta(dwConsolallog.getDwTAlerta().getDsTalerta());
				msAlertaDTO.setdthrinialerta(dwConsolallog.getDthrIalerta());
				retorno.add(msAlertaDTO);
			}
		}

		return retorno;
	}

	/**
	 * Metodo para buscar produto pelo IDW
	 * 
	 * @param omPt
	 * @return
	 */
	public List<PrUpProduto> prepararListaProdutoIDW(DwRt dwrt) {
		Map<String, PrUpProduto> retorno = new HashMap<String, PrUpProduto>();

		List<DwConsolpr> listaDwConsolpr = new ArrayList<DwConsolpr>();

		// Obtem todos os dwconsolids do dwrt
		ConsolidaRN rn = new ConsolidaRN(getDao());
		// Obtem o ultimo dwrt para o posto

		List<DwConsolid> lista = null;

		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("where dwconsolid.dwRt = :dwrt ");
		
		q.append( "and ((dwconsolid.stAtivo is NULL) or (dwconsolid.stAtivo = 1 )) "); //Senoj: Adiconado  or is NULL para casos onde dwconsolid n�o monitora vers�o ativa

		q.defineParametro("dwrt", dwrt);
		
		lista = q.list();

		if (lista != null && lista.size() > 0) {
			for (DwConsolid dwConsolid : lista) {
				for (DwConsol dwConsol : dwConsolid.getDwConsols()) {
					listaDwConsolpr = rn.getDwConsolpr(dwConsol.getIdConsol());

					if (listaDwConsolpr != null) {
						for (DwConsolpr dwConsolpr : listaDwConsolpr) {
							PrUpProduto prUpProd = new PrUpProduto();
							prUpProd.setCdproduto(dwConsolpr.getOmProduto().getCdProduto());
							prUpProd.setDsproduto(dwConsolpr.getOmProduto().getDsProduto());
							if (dwConsol.getPcsAutoProducaoprevista() != null) {
								prUpProd.setQtdplan(dwConsol.getPcsAutoProducaoprevista().doubleValue());
							}
							if (dwConsolpr.getPcsProducaoBruta() != null && dwConsolpr.getPcsProducaoRefugada() != null) {
								prUpProd.setQtdprodliquida(dwConsolpr.getPcsProducaoBruta().subtract(dwConsolpr.getPcsProducaoRefugada()).doubleValue());
							} else if (dwConsolpr.getPcsProducaoBruta() != null && dwConsolpr.getPcsProducaoRefugada() == null) {
								prUpProd.setQtdprodliquida(dwConsolpr.getPcsProducaoBruta().doubleValue());
							}
							if (retorno.containsKey(dwConsolpr.getOmProduto().getCdProduto())) {
								PrUpProduto prodAux = retorno.get(dwConsolpr.getOmProduto().getCdProduto());
								prUpProd.setQtdplan(prodAux.getQtdplan() + prUpProd.getQtdplan());
								prUpProd.setQtdprodliquida(prodAux.getQtdprodliquida() + prUpProd.getQtdprodliquida());
							}
							retorno.put(dwConsolpr.getOmProduto().getCdProduto(), prUpProd);
						}
					}
				}
			}
		}

		return new ArrayList<>(retorno.values());
	}


	public void removerRegistroIHM(IhmDTO ihmDTO) throws ServicoFalhouException {
		IhmRN ihmRN = new IhmRN();
		ihmRN.setIhmDTO(ihmDTO);
		ihmRN.setDao(this);
		MsIhm msIhm;
		MsMsihm msmsihm = new MsMsihm();
		MsMs msms = null;
		try {
			msms = pesquisarMsMsPorURLConexao();
			msIhm = ihmRN.pesquisarMsIhmPorURLConexao();
		} catch (IhmDesconhecidoException e) {
			throw new ServicoFalhouException(e);
		} catch (MsDesconhecidoException e) {
			throw new ServicoFalhouException(e);
		}

		msmsihm.setMsIhm(msIhm);
		msmsihm.setMsMs(msms);

		// Verifica se esta registrado, se nao estiver registrar
		msmsihm = pesquisarMsMsihmPorIdMSIdIHM(msIhm, msms);
		if (msmsihm != null) {
			this.makeTransient(msmsihm);
		}
	}

	// O heart-beat faz papelo de inicializacao dos dados necessarios para o
	// funcionamento do MS
	// e informe de funcionamento do MS
	public MsDTO heartBeat() throws ServicoFalhouException, MsDesconhecidoException {
		IdwLogger log = new IdwLogger("MsHearbeat");
		int idLog = log.getIdAleatorio();
		
		// Alessandre: criei a flag abaixo em 24-09-12 para gerenciar se o pdba
		// existe na base
		// O pdba soh sera considerado qdo a importacao do injet estiver ativa
		boolean isPdbaExiste = Stubdelegate.getInstancia().isInjetAtivo();

		// Encontra o MsMs do msdto passado
		MsMs msms = null;
		try {
			msms = pesquisarMsMsPorURLConexao();
		} catch (MsDesconhecidoException e) {
			throw e;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServicoFalhouException(ex);
		}

		// Atualiza a data e hora do hear-beat
		// Alessandre em 04-02-15 comentei esse update a fim de evitar alteracoes no registro e evitar o SNAPSHOT
		// esse campo parece nao ser usado pra nada
		//msms.setDthrHeartbeat(DataHoraRN.getDataHoraAtual());
		//this.makePersistent(msms);

		// Monta o MsDTO de retorno
		MsDTO retorno = new MsDTO();

		retorno.setIdMs(msms.getIdMs());
		retorno.setCd_ms(msms.getCdMs());
		retorno.setUrlConexao(msms.getUrlConexao());
		retorno.setTpCalculoAndon(msms.getTpCalculoandon());
		retorno.setOmcfg(Util.getConfigGeral(getSession()));

		// Obtem os ic e up do modulo de sinais
		IcUpDTO icupDTO;
		IcDTO icDTO;
		UpDTO upDTO;
		PTRN rn = new PTRN(getDao());
		
		log.info("Encontrados MsMsicup.size=" + msms.getMsMsicups().size());
		
		for (MsMsicup msmsicup : msms.getMsMsicups()) {
			
			// Se a coleta estiver desativada entao o registro deve ser ignorado
			if (msmsicup.getIsAtivo() != null && msmsicup.getIsAtivo() == false)
				continue;
			
			icupDTO = new IcUpDTO();
			icDTO = new IcDTO();
			upDTO = null;
			
			icDTO.setCd_ic(msmsicup.getMsIc().getCdIc());
			icDTO.setIdIc(msmsicup.getMsIc().getIdIc().intValue());
			icDTO.setTp_ic(msmsicup.getMsIc().getTpIc().intValue());
			icDTO.setUrl_conexao(msmsicup.getMsIc().getUrlConexao());
			icDTO.setIsAutenticacao(msmsicup.getMsIc().getIsAutenticacao());
			icDTO.setLoginAD(msmsicup.getMsIc().getLogin());
			icDTO.setSernhaAD(msmsicup.getMsIc().getSenha());
			if (icDTO.getIsAutenticacao() != null && icDTO.getIsAutenticacao() && (icDTO.getLoginAD() == null || icDTO.getLoginAD().trim().equals("")) ) {
				OmCfg omcfg = Util.getConfigGeral(getSession());
				icDTO.setLoginAD(omcfg.getLogin());
				icDTO.setSernhaAD(omcfg.getSenha());
				icDTO.setEmailsScriptPadraoNC(omcfg.getEmailsscriptpadraonc());
				icDTO.setEmailAoiNC(omcfg.getEmailaoi());
			} else {
				OmCfg omcfg = Util.getConfigGeral(getSession());
				icDTO.setEmailsScriptPadraoNC(omcfg.getEmailsscriptpadraonc());
				icDTO.setEmailAoiNC(omcfg.getEmailaoi());
			}

			if (msms.getTpCalculoandon() != null)
				icDTO.setTpCalculoAndon(msms.getTpCalculoandon());

			
			icupDTO.setIc(icDTO);
			icupDTO.setTpConexao(msmsicup.getTpConexao().intValue());
			icupDTO.setUrlConexao(msmsicup.getUrlConexao());
			icupDTO.setUrlAuxiliar(msmsicup.getUrlAuxiliar());
			icupDTO.setColetaAtiva(msmsicup.getIsAtivo());
			icupDTO.setIdIcUp(msmsicup.getIdMsicup().intValue());

			OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msmsicup.getMsUp().getCdUp());
			
			// Verifica se o MSUP existe em omPt. Se nao existir logar e retornar
			if (ompt == null) {
				log.info(idLog, 0, "Posto " + msmsicup.getMsUp().getCdUp() + " não cadastrado.");
				continue;
			}
			
			// Alessandre: Inicializa o upDto com os dados do PDBA e coloca os
			// valores no icUp
			// Verificar para que eh usado o upDTO
			// Se nao existirem as tabelas PR* na base entao nao inicializar o
			// UpDTO e verificar o impacto disso
			if (isPdbaExiste == true && icDTO.getTp_ic().equals(MsIcTemplate.TpIc._TP_IC_CCK7200ME.getTpIc().intValue()) == false) {
				try {
					upDTO = inicializarUPDTO(log, msmsicup, ompt);
					if (upDTO == null)
						continue;
					
					icupDTO.setUpDTO(upDTO);
				} catch (SQLGrammarException e) {
					// Se deu erro, tentar inicializar a UpDTO usando MsUp
					e.printStackTrace();
					upDTO = inicilizarUpDTOUsandoMsUp(msmsicup, ompt, log);
					icupDTO.setUpDTO(upDTO);
					isPdbaExiste = false;
				}
			} else {
				upDTO = inicilizarUpDTOUsandoMsUp(msmsicup, ompt, log);
				icupDTO.setUpDTO(upDTO);
			}
			
			// Inicializa script de teste quando houver
			OmPromidia ompromidia = inicializarScriptPadrao(ompt);
			// obtem o script
			if (ompromidia != null) {
				icupDTO.setScriptTeste(new StringBuilder(new String(ompromidia.getMidia())));
				icupDTO.setNomeArquivoScript(ompromidia.getDsPromidia());
				icupDTO.setExtensaoArquivoScript(ompromidia.getExtensaoArquivo());
			}

			retorno.getIcsColetados().add(icupDTO);
		}

		// Alessandre: O trecho abaixo nao sei dizer pq foi feito, mas criei um
		// flag acima para qdo nao existirem as tabelas do PDBA o trecho abaixo
		// nao ser executado
		// Alessandre: em 27-5-14 aparentemente esse trecho eh importante para obter diversas configuracoes para a maquina q estao presentes apenas em Pr*
		if (isPdbaExiste == true) {
			PrUpRN pruprn = new PrUpRN(this.getDao());
			injetws.webservices.dto.IwsListaUpDTO listaUpDto = new IwsListaUpDTO();
			try {
				listaUpDto = pruprn.getListaUpInjetWsDTO();
			} catch (SemSGBDException e) {
				e.printStackTrace();
			}
			for (injetws.webservices.dto.IwsUpDTO upDtoWs : listaUpDto.getUps()) {
				for (IcUpDTO icupDTOindex : retorno.getIcsColetados()) {
					if (upDtoWs.getIdUP().equals(icupDTOindex.getUpDTO().getCd_up()) || upDtoWs.getIdUP().equals(icupDTOindex.getUpDTO().getIdUpPDBA())) {
						icupDTOindex.getUpDTO().atualizaUPWS(upDtoWs);
						icupDTOindex.getIc().setStAndonConfiguravelAtivo(listaUpDto.getStAndonConfiguravel());
					}
				}
			}
		}

		// Obtem os ihms registrados do modulo de sinais
		for (MsMsihm ihm : msms.getMsMsihms()) {
			PortaEthernetDTO porta = new PortaEthernetDTO();
			porta.setIp(ihm.getMsIhm().getUrlIp());
			// HUGO MUDOU
			// porta.setPorta(2969);
			porta.setPorta(3001);
			IhmDTO ihmdto = new IhmDTO();
			ihmdto.setIdIhm(ihm.getIdMsihm().intValue());
			ihmdto.setUrl_Conexao(ihm.getMsIhm().getUrlConexao());
			ihmdto.setUrl_Ip(ihm.getMsIhm().getUrlIp());
			ihmdto.setConexaoIHM(porta);
			retorno.getIhmsRegistrados().add(ihmdto);
		}
		return retorno;
	}
	
	public OmPromidia inicializarScriptPadrao(OmPt ompt) {		
		// Obtem a OP
		if (ompt == null)
			return null;
		
		PpCp  ppcp = null;
		if (ompt.getPpCp() != null)
			ppcp = ompt.getPpCp();	// ppcp.getCdCp()
		
		if (ppcp == null)
			return null;
		
		// Obtem o produto
		OmProduto omproduto = ppcp.obtemPrimeiroProduto();
		
		
		// Procura a midia
		OmPromidia ompromidia = null;
		
		if (omproduto != null)
			ompromidia = getOmPromidia(ompt, omproduto); // omproduto.getCdProduto();
		
		return ompromidia;
	}
	
	private OmPromidia getOmPromidia(OmPt ompt, OmProduto omproduto) {
		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from OmPromidia a");
		q.append("join a.omProduto b");
		q.append("where b.cdProduto = :cdproduto");
		q.append("and b.stAtivo = 1");
		q.append("and a.tpMidia = :tpmidia");
		q.append("and a.omTppt = :omtppt");
		
		q.defineParametro("tpmidia", OmPromidiaTemplate.TpMidia._TP_MIDIA_SCRIPTTESTE.getTipoMidia());
		q.defineParametro("cdproduto", omproduto.getCdProduto());
		q.defineParametro("omtppt", ompt.getOmTppt());
		q.setMaxResults(1);
		
		OmPromidia retorno = (OmPromidia) q.uniqueResult();
		return retorno;
	}

	// Inicializa UpDTO a partir de MsUp
	private UpDTO inicilizarUpDTOUsandoMsUp(MsMsicup msmsicup, OmPt ompt, IdwLogger log) {
		UpDTO upDTO = new UpDTO();
		upDTO.setIdUp(msmsicup.getMsUp().getIdUp());
		upDTO.setCd_up(msmsicup.getMsUp().getCdUp());
		upDTO.setDs_up(msmsicup.getMsUp().getDsUp());
		if (ompt != null && ompt.getOmTppt() != null) {
			upDTO.setIdTppt(ompt.getOmTppt().getIdTppt());
			if (ompt.getOmTppt().getIsIhmtrocaop() != null)
				upDTO.setIsIhmtrocaOP(ompt.getOmTppt().getIsIhmtrocaop());
		}else
			upDTO.setIdTppt(0l);
		
		upDTO.setIdUpPDBA(msmsicup.getMsUp().getCdUp());
		
		if (ompt.getPpCp() == null)
			log.info("ompt.getPpCp is null");
		else if (ompt.getPpCp().obtemPrimeiroProduto() == null)
			log.info("ompt.getPpCp.obtemPrimeiroProduto null");
		else if (ompt.getPpCp().obtemPrimeiroProduto().getIsRastreabilidade() == null)
			log.info("ompt.getPpCp.obtemPrimeiroProduto.isRastreabilidade is null");
		else
			log.info("cdPt:" + ompt.getCdPt() + " idCp:" + ompt.getPpCp().getIdCp() + " - idProduto:" + ompt.getPpCp().obtemPrimeiroProduto().getIdProduto() + " - ompt.getPpCp.obtemPrimeiroProduto.isRastreabilidade = " + ompt.getPpCp().obtemPrimeiroProduto().getIsRastreabilidade());
			
		if (ompt.getPpCp() !=  null && ompt.getPpCp().obtemPrimeiroProduto() != null && ompt.getPpCp().obtemPrimeiroProduto().getIsRastreabilidade() != null) {
			upDTO.setLerCB(ompt.getPpCp().obtemPrimeiroProduto().getIsRastreabilidade());
			upDTO.setCdproduto(ompt.getPpCp().obtemPrimeiroProduto().getCdProduto());
		} else {
			upDTO.setLerCB(false);
		}

		upDTO.setUpihmColetados(new ArrayList<UpIhmDTO>());
		for (MsUpihm ihm : msmsicup.getMsUp().getMsUpihms()) {
			UpIhmDTO dto = new UpIhmDTO(ihm);
			upDTO.getUpihmColetados().add(dto);
		}

		return upDTO;
	}

	// Inicializa UpDTO a partir de PRUp
	private UpDTO inicializarUPDTO(IdwLogger log, MsMsicup msmsicup, OmPt ompt) {

		PrUpRN prupRN = new PrUpRN(this);

		PrUp prup = (PrUp) prupRN.getPrup(msmsicup.getMsUp());

		if (prup == null) {
			log.info("nao encontrou prup com id = " + msmsicup.getMsUp().getCdUp());
			return null;
		}
		getDao().evict(prup);
		
		// Atualiza dados do CIP
		InfoRN rn = new InfoRN(getDao());
		rn.verificaIsComCIP(log, 0, prup);
		
		UpDTO upDTO = new UpDTO();
		upDTO.setFromPrUP(prup);
		upDTO.setIdUp(msmsicup.getMsUp().getIdUp());
		upDTO.setCd_up(msmsicup.getMsUp().getCdUp());
		if (ompt != null && ompt.getOmTppt() != null)
			upDTO.setIdTppt(ompt.getOmTppt().getIdTppt());
		else
			upDTO.setIdTppt(0l);
		
		upDTO.setIdUpPDBA(msmsicup.getMsUp().getIduppdba());
		upDTO.setUpihmColetados(new ArrayList<UpIhmDTO>());
		for (MsUpihm ihm : msmsicup.getMsUp().getMsUpihms()) {
			UpIhmDTO dto = new UpIhmDTO(ihm);
			upDTO.getUpihmColetados().add(dto);
		}

		return upDTO;
	}

	public MsMsihm pesquisarMsMsihmPorIdMSIdIHM(MsIhm msihm, MsMs msms) {
		MapQuery q = new MapQuery(this.getSession());

		q.append("select distinct msmsihm from MsMsihm msmsihm ");
		q.append("where msmsihm.msIhm.idIhm = :idihm ");
		q.append("and msmsihm.msMs.idMs = :idms ");

		q.defineParametro("idihm", msihm.getIdIhm());
		q.defineParametro("idms", msms.getIdMs());
		q.setMaxResults(1);

		MsMsihm msmsihm = (MsMsihm) q.uniqueResult();

		return msmsihm;
	}

	public MsMs pesquisarMsMsPorURLConexao() throws MsDesconhecidoException {
		if (msDTO.getUrlConexao() == null) {
			throw new MsDesconhecidoException();
		}
		MapQuery q = new MapQuery(this.getSession());

		q.append("select msms from MsMs msms ");
		q.append("join fetch msms.msMsicups b");
		q.append("where msms.urlConexao like :urlconexao ");
		q.append("and msms.stAtivo = 1 ");
		q.append("order by msms.idMs, revisao desc");

		q.defineParametro("urlconexao", "%" + msDTO.getUrlConexao() + "%");
		q.setMaxResults(1);

		MsMs msms = (MsMs) q.uniqueResult();

		if (msms == null) {
			throw new MsDesconhecidoException();
		}
		return msms;
	}

	public MsMs pesquisarMsMsPorURLConexaoComParametro(String UrlConexao) {
		MapQuery q = new MapQuery(this.getSession());

		q.append("select msms from MsMs msms ");
		q.append("where msms.urlConexao = :urlconexao ");
		q.append("and msms.stAtivo = 1 ");
		q.append("order by id_ms, revisao desc");

		q.defineParametro("urlconexao", UrlConexao);
		q.setMaxResults(1);

		MsMs msms = (MsMs) q.uniqueResult();

		return msms;
	}

	public MsMsicup pesquisarMsMsIcupById(BigDecimal idMsMsicup) {
		MapQuery q = new MapQuery(this.getSession());
		q.append("from MsMsicup msmsicup where msmsicup.idMsicup = :id");
		q.defineParametro("id", idMsMsicup);
		q.setMaxResults(1);
		return (MsMsicup) q.uniqueResult();
	}

	public MsMsicup pesquisarMsMsIcupByMsUpIc(MsMs msms, MsUp msup, MsIc msic) {
		MapQuery q = new MapQuery(this.getSession());
		q.append("from MsMsicup msmsicup where msmsicup.msMs.idMs = :idms");
		q.append("and msmsicup.msUp.idUp = :idup");
		q.append("and msmsicup.msIc.idIc = :idic");
		
		q.defineParametro("idms", msms.getIdMs());
		q.defineParametro("idup", msup.getIdUp());
		q.defineParametro("idic", msic.getIdIc());
		q.setMaxResults(1);
		return (MsMsicup) q.uniqueResult();
	}
	
	public List<MsMsicup> pesquisarMsMsIcupByMsIc(MsMs msms,MsIc msic) {
	
		MapQuery q = new MapQuery(this.getSession());
		
		q.append("select distinct msmsicup");
		q.append("from MsMsicup msmsicup where msmsicup.msMs.idMs = :idms");		
		q.append("and msmsicup.msIc.idIc = :idic");		
		q.defineParametro("idms", msms.getIdMs());		
		q.defineParametro("idic", msic.getIdIc());	
		
		
		
		return q.list();
		
	}
	
	public MsMsicup pesquisarMsMsIcupByIdUpPdba(String idUpPdba) {
		MapQuery q = new MapQuery(this.getSession());
		q.append("from MsMsicup msmsicup");
		q.append("join msmsicup.msUp msup");
		q.append("where");
		q.append("msup.iduppdba = :idup");
		q.append("and msup.stAtivo = 1");
		q.defineParametro("idup", idUpPdba);
		q.setMaxResults(1);
		return (MsMsicup) q.uniqueResult();
	}

	public ListaMSDTO getListaMSDTO() throws MsDesconhecidoException {
		List<MsMs> lista = null;
		ArrayList<MsDTO> listamsdto = new ArrayList<MsDTO>();
		ListaMSDTO listaMsDTO = new ListaMSDTO();
		MsDTO msDTO = null;
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

		lista = pesquisarMsMsByPojo();
		if (lista.isEmpty()) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
			listaMsDTO.setResultadoDTO(resultadoDTO);
			listaMsDTO.setListaMSDTO(listamsdto);

			return listaMsDTO;
		} else {
			PTRN ptrn = new PTRN(getDao());
			for (MsMs msms : lista) {
				msDTO = null;
				msDTO = new MsDTO(msms);

				msDTO.setIcsColetados(new ArrayList<IcUpDTO>());

				for (MsMsicup msmsicup : msms.getMsMsicups()) {
					OmPt ompt = ptrn.pesquisarPtByCdPtStAtivo(msmsicup.getMsUp().getCdUp());
					IcUpDTO icupdto = new IcUpDTO(msmsicup, ompt);

					msDTO.getIcsColetados().add(icupdto);
				}

				listamsdto.add(msDTO);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}

		listaMsDTO.setResultadoDTO(resultadoDTO);
		listaMsDTO.setListaMSDTO(listamsdto);

		return listaMsDTO;
	}

	public List<MsMs> pesquisarMsMsByPojo() {

		MapQuery q = new MapQuery(this.getSession());

		q.append("select distinct msms");
		q.append("from MsMs msms");
		q.append("left join fetch msms.msMsicups");

		q.appendWhere(MapQuery._NULL, "msms.cdMs = :cdms",
				msDTO.getCd_ms() != null && !msDTO.getCd_ms().equals(""));
		q.appendWhere(MapQuery._AND, "msms.dsMs = :dsms ",
				msDTO.getDs_ms() != null && !msDTO.getDs_ms().equals(""));
		q.appendWhere(
				MapQuery._AND,
				"msms.urlConexao = :urlconexao ",
				msDTO.getUrlConexao() != null
						&& !msDTO.getUrlConexao().equals(""));
		q.appendWhere(MapQuery._AND, "msms.tpCalculoandon = :tpcalandon ", msDTO.getTpCalculoAndon() != null);
		q.appendWhere(MapQuery._AND, "msms.revisao = :revisao ", msDTO.getRevisao() != null && msDTO.getRevisao() != 0);
		q.appendWhere(MapQuery._AND, "msms.stAtivo = :stativo ", msDTO.getSt_ativo() != null);
		q.appendWhere(MapQuery._AND, "msms.stAtivo = 1 ", msDTO.getSt_ativo() == null);
		q.appendWhere(MapQuery._AND, "msms.idMs = :idms", msDTO.getIdMs() != null && msDTO.getIdMs().longValue() > 0l);

		q.defineParametro("cdms", msDTO.getCd_ms());
		q.defineParametro("dsms", msDTO.getDs_ms());
		q.defineParametro("urlconexao", msDTO.getUrlConexao());
		q.defineParametro("tpcalandon", msDTO.getTpCalculoAndon());
		q.defineParametro("idms", msDTO.getIdMs());

		if (msDTO.getRevisao() != null)
			q.defineParametro("revisao", new BigDecimal(msDTO.getRevisao()));
		if (msDTO.getSt_ativo() != null)
			q.defineParametro("stativo", new BigDecimal(msDTO.getSt_ativo()));

		return q.list();
	}
	public List<MsMs> pesquisarMsMsByAtivas() {

		MapQuery q = new MapQuery(this.getSession());

		q.append("select distinct msms");
		q.append("from MsMs msms");
		q.append("left join fetch msms.msMsicups");
		q.append("where msms.stAtivo = 1 ");

		return q.list();
	}


	public Boolean validarURLConexao(MsDTO msdto, List<MsDTO> lista,
			ListaMSDTO listaMsDTO, ResultadoMSDTO resultadoDTO) {
		MsMs msihmAux = null;
		try {
			msihmAux = pesquisarMsMsPorURLConexao();
			if (msihmAux != null) {
				resultadoDTO
						.setIdMensagem(resultadoDTO.ERRO_URL_CONEXAO_JA_CADASTRADA);
				msdto.setCd_ms(msihmAux.getCdMs());
				lista.add(msdto);
				listaMsDTO.setListaMSDTO(lista);
				listaMsDTO.setResultadoDTO(resultadoDTO);
				return true;
			}
		} catch (MsDesconhecidoException e) {
		}
		return false;
	}

	public ListaMSDTO setMSDTO() {
		MsMs msms = null;
		MsUsr msusr = null;
		BigDecimal valorRevisao = null;
		MsDTO msdto = new MsDTO();
		List<MsDTO> lista = new ArrayList<MsDTO>();
		ListaMSDTO listaMsDTO = new ListaMSDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		Date data = new Date();

		if (msDTO.getCd_ms() == null || msDTO.getCd_ms().equals("")) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDMS_DESCONHECIDO);
			lista.add(msdto);
			listaMsDTO.setListaMSDTO(lista);
			listaMsDTO.setResultadoDTO(resultadoDTO);

			return listaMsDTO;
		}

		msms = consultaMsMsByCdEStAtivo();

		if (msms != null) {
			msms.setStAtivo(BigDecimal.ZERO);
			msms.setDthrStativo(data);
			this.makePersistent(msms);
		}

		MsMs msmsNovo = new MsMs();

		if (msms == null) {
			msmsNovo.setRevisao(BigDecimal.ONE);
			msmsNovo.setIsImportouTm(false);
			if (validarURLConexao(msdto, lista, listaMsDTO, resultadoDTO) == true) {
				return listaMsDTO;
			}
		} else {
			valorRevisao = msms.getRevisao().add(BigDecimal.ONE);
			msmsNovo.setIdMs(null);
			msmsNovo.setRevisao(valorRevisao);
			msmsNovo.setIsImportouTm(msms.getIsImportouTm());
			msmsNovo.setDthrHeartbeat(msms.getDthrHeartbeat());
			msmsNovo.setSegHeartbeat(msms.getSegHeartbeat());
			/*
			 * Esse trecho foi removido pq ao excluir um msmsicup com eventos a
			 * exclusao falha for(MsMsicup msmsicup : msms.getMsMsicups()) {
			 * this.getSession().delete(msmsicup); } msms.setMsMsicups(null);
			 */
		}
		msmsNovo.setCdMs(msDTO.getCd_ms());
		msmsNovo.setDthrRevisao(data);
		msmsNovo.setDthrStativo(data);
		msmsNovo.setStAtivo(BigDecimal.ONE);

		MsUsrDAO dao = new MsUsrDAO(getSession());
		msusr = dao.getMsUsrPorLoginAtivo(msDTO.getLoginUsuario()); //pesquisarMsUsr();
		msmsNovo.setMsUsr(msusr);
		
		if (msusr == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_USUARIO_DESCONHECIDO);
			listaMsDTO.setResultadoDTO(resultadoDTO);
			return listaMsDTO;
		}

		if (msDTO.getDs_ms() != null) {
			msmsNovo.setDsMs(msDTO.getDs_ms());
		}
		if (msDTO.getUrlConexao() != null) {
			msmsNovo.setUrlConexao(msDTO.getUrlConexao());
		}
		if (msDTO.getTpCalculoAndon() != null) {
			msmsNovo.setTpCalculoandon(msDTO.getTpCalculoAndon());
		}
		if (msDTO.getIcsColetados() != null) {
			msmsNovo.setMsMsicups(new HashSet<MsMsicup>());

			for (IcUpDTO icupDTO : msDTO.getIcsColetados()) {
				MsMsicup msmsicup;
				msmsicup = null;
				msmsicup = new MsMsicup();

				msmsicup.setMsIc(consultarMsIcPorIdIc(icupDTO.getIc()));
				// Se msic estiver desativado, falhar
				if (msmsicup.getMsIc() == null || msmsicup.getMsIc().getStAtivo().equals(BigDecimal.ZERO)) {
					resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDIC_DESCONHECIDO);
					listaMsDTO.setResultadoDTO(resultadoDTO);
					return listaMsDTO;
				}
				
				msmsicup.setIdMsicup(null);
				msmsicup.setMsUp(consultarMsUpPorIdUp(icupDTO.getUpDTO()));
				
				// se msup estiver desativada, falhar
				if (msmsicup.getMsUp().getStAtivo().equals(BigDecimal.ZERO)) {
					
					// Verificar se existe a UP cadastrada com outro id
					UpRN urn = new UpRN(getDao(), null);
					
					MsUp msup;
					try {
						msup = urn.pesquisarMsUpPorCdUpStAtivo(msmsicup.getMsUp().getCdUp());
					} catch (injetws.model.excessoes.RegistroDesconhecidoException e) {
						msup = null;
					}
					
					if (msup != null) {
						resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDUP_DESCONHECIDO);
						resultadoDTO.setComplemento(msmsicup.getMsUp().getCdUp() + "-" + msmsicup.getMsUp().getDsUp());
						listaMsDTO.setResultadoDTO(resultadoDTO);
						return listaMsDTO;
					} else {
						resultadoDTO.setIdMensagem(resultadoDTO.ERRO_UP_EXCLUIDA);
						resultadoDTO.setComplemento(msmsicup.getMsUp().getCdUp() + "-" + msmsicup.getMsUp().getDsUp());
						listaMsDTO.setResultadoDTO(resultadoDTO);
						return listaMsDTO;
					}
				}
				
				msmsicup.setTpConexao(BigDecimal.valueOf(icupDTO.getTpConexao()));
				if (icupDTO.getUrlConexao() != null)
					msmsicup.setUrlConexao(icupDTO.getUrlConexao().trim());
				else
					msmsicup.setUrlConexao(icupDTO.getUrlConexao());
				
				if (icupDTO.getUrlAuxiliar() != null)
					msmsicup.setUrlAuxiliar(icupDTO.getUrlAuxiliar().trim());
				else
					msmsicup.setUrlAuxiliar(icupDTO.getUrlAuxiliar());
				
				msmsicup.setIsAtivo(icupDTO.isColetaAtiva());
				
				// Limpa e adiciona msmsicupProduto
				for (MsMsicupProduto uprod :  icupDTO.getUrlsProduto()) {
					uprod.setMsMsicup(msmsicup);
					uprod.setIdMsicupProduto(null);
					msmsicup.getMsMsicupProdutos().add(uprod);
				}
				
				// msmsicup.setAtributo(icupDTO.getAtributo());
				msmsicup.setMsMs(msmsNovo);

				msmsNovo.getMsMsicups().add(msmsicup);
			}
		}

		this.makePersistent(msmsNovo); // bug

		msdto.setIdMs(msmsNovo.getIdMs());
		msdto.setCd_ms(msmsNovo.getCdMs());
		msdto.setDs_ms(msmsNovo.getDsMs());
		msdto.setUrlConexao(msmsNovo.getUrlConexao());
		msdto.setTpCalculoAndon(msmsNovo.getTpCalculoandon());
		msdto.setRevisao(msmsNovo.getRevisao().intValue());
		msdto.setDthr_revisao(msmsNovo.getDthrRevisao());
		msdto.setDthr_stativo(msmsNovo.getDthrStativo());
		msdto.setSt_ativo(msmsNovo.getStAtivo().intValue());

		msdto.setIcsColetados(new ArrayList<IcUpDTO>());
		PTRN rn = new PTRN(getDao());
		for (MsMsicup msmsicups : msmsNovo.getMsMsicups()) {
			OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msmsicups.getMsUp().getCdUp());
			IcUpDTO icupdto = new IcUpDTO(msmsicups, ompt);

			msdto.getIcsColetados().add(icupdto);
		}

		resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);

		lista.add(msdto);
		listaMsDTO.setListaMSDTO(lista);
		listaMsDTO.setResultadoDTO(resultadoDTO);

		return listaMsDTO;
	}

	private MsMs consultaMsMsByCdEStAtivo() {
		MapQuery q = new MapQuery(this.getSession());

		q.append("select msms ");
		q.append("from MsMs msms ");
		q.append("where msms.cdMs = :cdms and msms.stAtivo = 1");
		q.append("order by msms.revisao desc");

		q.defineParametro("cdms", msDTO.getCd_ms());
		q.setMaxResults(1);

		return (MsMs) q.uniqueResult();
	}

	private MsIc consultarMsIcPorIdIc(IcDTO icdto) {
		// Avalia se o IC vaio preenchido
		if (icdto == null || icdto.getIdIc() == null) {
			return null;
		}
		MapQuery q = new MapQuery(this.getSession());

		q.append("select msic from MsIc msic ");
		q.append("where msic.idIc = :idic ");

		q.defineParametro("idic", new BigDecimal(icdto.getIdIc()));
		q.setMaxResults(1);

		return (MsIc) q.uniqueResult();
	}

	private MsUp consultarMsUpPorIdUp(UpDTO updto) {
		MapQuery q = new MapQuery(this.getSession());

		q.append("select msup from MsUp msup ");
		q.append("where msup.idUp = :idup");

		q.defineParametro("idup", updto.getIdUp());
		q.setMaxResults(1);

		return (MsUp) q.uniqueResult();
	}

	// Esse metodo tem que sair daqui
//	private MsUsr pesquisarMsUsr() {
//		MapQuery q = new MapQuery(this.getSession());
//
//		q.append("select msusr ");
//		q.append("from MsUsr msusr ");
//		q.append("where msusr.login = :login ");
//		q.append("and msusr.stAtivo = 1 ");
//
//		q.defineParametro("login", msDTO.getLoginUsuario());
//		q.setMaxResults(1);
//
//		return (MsUsr) q.uniqueResult();
//
//	}

	public ListaMSDTO removeMSDTO() {
		ListaMSDTO listaMsDTO = null;

		listaMsDTO = removeRegistro();

		return listaMsDTO;
	}

	private ListaMSDTO removeRegistro() {
		MsMs msms = null;
		MapQuery q = new MapQuery(this.getSession());
		MsDTO msdto = new MsDTO();
		List<MsDTO> lista = new ArrayList<MsDTO>();
		ListaMSDTO listaMsDTO = new ListaMSDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		Date data = null;

		q.append("select msms from MsMs msms ");
		q.append("left join fetch msms.msMsicups ");
		q.append("where msms.idMs = :idMs ");

		q.defineParametro("idMs", msDTO.getIdMs());

		List<MsMs> listaMsMs = null;

		listaMsMs = q.list();

		if (listaMsMs != null && listaMsMs.size() > 0) {
			msms = listaMsMs.get(0);
		} else {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			listaMsDTO.setResultadoDTO(resultadoDTO);

			return listaMsDTO;
		}

		if (msms.getStAtivo() == BigDecimal.ZERO) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			listaMsDTO.setResultadoDTO(resultadoDTO);

			return listaMsDTO;
		} else {
			msms.setStAtivo(BigDecimal.ZERO);
			data = new Date();
			msms.setDthrStativo(data);

			this.makePersistent(msms);

			msdto.setIdMs(msms.getIdMs());
			msdto.setCd_ms(msms.getCdMs());
			msdto.setDs_ms(msms.getDsMs());
			msdto.setUrlConexao(msms.getUrlConexao());
			msdto.setTpCalculoAndon(msms.getTpCalculoandon());
			msdto.setRevisao(msms.getRevisao().intValue());
			msdto.setDthr_revisao(msms.getDthrRevisao());
			msdto.setDthr_stativo(msms.getDthrStativo());
			msdto.setDthr_heart_beat(msms.getDthrHeartbeat());
			msdto.setSt_ativo(msms.getStAtivo().intValue());

			msdto.setIcsColetados(new ArrayList<IcUpDTO>());
			PTRN rn = new PTRN(getDao());
			for (MsMsicup msmsicups : msms.getMsMsicups()) {
				OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msmsicups.getMsUp().getCdUp());
				IcUpDTO icupdto = new IcUpDTO(msmsicups, ompt);

				msdto.getIcsColetados().add(icupdto);
			}

			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
			this.commitaTransacao(this.getSession());
		}

		lista.add(msdto);
		listaMsDTO.setListaMSDTO(lista);
		listaMsDTO.setResultadoDTO(resultadoDTO);

		return listaMsDTO;
	}

	public void setIdMs(BigDecimal idMs) {
		if (msDTO == null)
			msDTO = new MsDTO();
		msDTO.setIdMs(idMs);

	}

	public MsMs pesquisarUmMsMsPorStAtivo() {
		MapQuery q = new MapQuery(getSession());

		q.append("select msms ");
		q.append("from MsMs msms ");
		q.append("where msms.stAtivo = 1 ");

		q.append("order by msms.revisao desc");

		q.setMaxResults(1);

		return (MsMs) q.uniqueResult();
	}
	
	public List<MsMsicup> pesquisarMsMsicupsByIcUrlConexao(String urlConexao) {
		MapQuery q = new MapQuery(getSession());

		q.append("SELECT msmsicup");
		q.append("FROM MsMsicup msmsicup");
		q.append("left join  msmsicup.msMs msms");
		q.append("left join  msmsicup.msIc msic");

		q.append("WHERE msms.stAtivo = 1");
		q.append("AND msic.stAtivo = 1");
		q.append("AND msic.urlConexao = :urlConexao");
		
		q.defineParametro("urlConexao", urlConexao);
		
		List<MsMsicup> retorno = q.list();
		
		return retorno;
	}

	public void desativarMsUps(List<String> listaCdUsrDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr) {
		MapQuery q = new MapQuery(getSession());
		
		q.append("update MsUp a set stAtivo = 0, dthrStativo=:dt where cdUp not in (:lista)");
		q.defineListaParametro("lista", new ArrayList<Object>(listaCdUsrDevemFicarAtivos));
		q.defineParametroData("dt", dataHoraDesativacao);
		
		q.query().executeUpdate();
	}
	
	public void transferirUps(MsDTO origem, MsDTO destino, IcDTO icupdto) {
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("update MsMsicup set msMs.idMs = :idmsdestino where msMs.idMs = :idmsorigem and idMsicup = :idmsmsicup");
		
		q.defineParametro("idmsorigem", origem.getIdMs());
		q.defineParametro("idmsdestino", destino.getIdMs());
		
		for (IcUpDTO dto : icupdto.getMsIcUpDTOLocais()) {
			q.defineParametro("idmsmsicup", new BigDecimal(dto.getIdIcUp()));
			q.query().executeUpdate();
		}
	}
	
	public ListaMSDTO pesquisarMsDTOExcesao(MsDTO msdto) {
		ListaMSDTO retorno = new ListaMSDTO();
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from MsMs a");
		q.append("where a.stAtivo = 1");
		q.append("and a.cdMs <> :cdms");
		q.defineParametro("cdms", msdto.getCd_ms());
		List<MsMs> lista = q.list();
		
		retorno.setListaMSDTO(new ArrayList<MsDTO>());
		for (MsMs msms : lista) {
			MsDTO dto = new MsDTO(msms);
			retorno.getListaMSDTO().add(dto);
		}
		return retorno;
	}
	
	
	/* Metodo para retornar uma lista com os codigos das UPs gerenciadas pelo MS expecifico
	 * 
	 */
	public List<Object> pesquisarUps(String mac) {
		List<Object> retorno = new ArrayList<>();
		MapQuery q =  new MapQuery(getDao().getSession());
		q.append("select c.cdUp");
		q.append("from MsMs a");
		q.append("join a.msMsicups b");
		q.append("join b.msUp c");
		q.append("where a.stAtivo = 1");
		q.append("and a.urlConexao like :url");
		
		q.defineParametro("url", '%' + mac + '%');
		
		List<String> lista = q.list();
		
		for (Object cdup : lista) {
			retorno.add(cdup);
		}
		
		return retorno;
	}
	
	
	@SuppressWarnings("unused")
	public ListaMSsDTO getMSsDTO(FiltroPesquisaDTO filtro) {
		ListaMSsDTO retorno = new ListaMSsDTO();
		retorno.setItems(new ArrayList<MsDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select DISTINCT t ");
		q.append("from MsMs t ");
		q.append("left join fetch t.msMsicups b ");
		q.append("left join fetch b.msUp c ");
		q.append("left join fetch b.msIc c ");
		q.append("where t.stAtivo = 1 ");

		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")) {
			q.append("AND (");
			q.append(" upper(t.cdMs) LIKE '%" + filtro.getConteudoPesquisa() + "%' OR upper(t.dsMs) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append(")");
		}

		q.append("ORDER BY t.cdMs");

		List<MsMs> lista = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		for (MsMs reg : lista) {
			MsDTO2 dto = new MsDTO2();
			dto.setAssociacoesUpIc(new ArrayList<UpIcMsDTO2>());
			dto.setIdMS(reg.getIdMs().intValue());
			dto.setCdMS(reg.getCdMs());
			dto.setDsMS(reg.getDsMs());
			dto.setMacAddress(reg.getUrlConexao());
			dto.setStRegistro(reg.getStAtivo().intValue());
			dto.setRevisao(reg.getRevisao().intValue());
			
			for (MsMsicup icup : reg.getMsMsicups()) {
				if (icup.getIsAtivo() && icup.getMsUp().getStAtivo().intValue() == 1 && icup.getMsIc().getStAtivo().intValue() == 1) {
					if (icup.getMsIc().getTpIc().intValue() == 3) {
						UpIcMsDTO2 icupms = new UpIcMsDTO2();
						icupms.setCdUP(icup.getMsUp().getCdUp());
						icupms.setCdIC(icup.getMsIc().getCdIc());
						icupms.setUrlConexao(icup.getUrlConexao());
						icupms.setTipoConexao("Tudo");
						
						dto.getAssociacoesUpIc().add(icupms);						
					}
				}
			}

			Collections.sort(dto.getAssociacoesUpIc(), comparaCodigo);
			retorno.getItems().add(dto);
 		}
		
		
 		if (lista.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, lista.size()));
 			resRN = null;
 		}
		
		q = null;
		lista = null;

		return retorno;
	}

	@SuppressWarnings("unused")
	public MsDTO2 getMSByCd(String cdMS) {
		MsDTO2 retorno = new MsDTO2();
		
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select DISTINCT t ");
		q.append("from MsMs t ");
		//q.append("left join fetch t.msMsicups b ");
		//q.append("left join fetch b.msUp c ");
		//q.append("left join fetch b.msIc c ");
		q.append("where t.stAtivo = 1 ");
		q.append(" and t.cdMs = :cdMS");
		
 		q.defineParametro("cdMS", cdMS);
 		
 		List<MsMs> lista =  q.list();
 		if (lista.size() > 0) {
			retorno = new MsDTO2();
			retorno.setAssociacoesUpIc(new ArrayList<UpIcMsDTO2>());
			retorno.setIdMS(lista.get(0).getIdMs().intValue());
			retorno.setCdMS(lista.get(0).getCdMs());
			retorno.setDsMS(lista.get(0).getDsMs());
			retorno.setMacAddress(lista.get(0).getUrlConexao());
			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
			retorno.setRevisao(lista.get(0).getRevisao().intValue());
			
			for (MsMsicup icup : lista.get(0).getMsMsicups()) {
				if (icup.getIsAtivo() && icup.getMsUp().getStAtivo().intValue() == 1 && icup.getMsIc().getStAtivo().intValue() == 1) {
					if (icup.getMsIc().getTpIc().intValue() == 3) {
						UpIcMsDTO2 icupms = new UpIcMsDTO2();
						icupms.setCdUP(icup.getMsUp().getCdUp());
						icupms.setCdIC(icup.getMsIc().getCdIc());
						icupms.setUrlConexao(icup.getUrlConexao());
						icupms.setTipoConexao("Tudo");
						
						retorno.getAssociacoesUpIc().add(icupms);	
					}
				}
			}
			
			Collections.sort(retorno.getAssociacoesUpIc(), comparaCodigo);
 		}
		
		return retorno;
	}
	
	//comparators 
	private static final Comparator<UpIcMsDTO2> comparaCodigo = new Comparator<UpIcMsDTO2>() {
		@Override
		public int compare(UpIcMsDTO2 o1, UpIcMsDTO2 o2) {
			return o1.getCdUP().compareTo(o2.getCdUP());
		}
	};
	
}
