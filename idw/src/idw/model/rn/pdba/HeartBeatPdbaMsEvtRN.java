package idw.model.rn.pdba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.MsIc;
import idw.model.pojos.MsPerfilandon;
import idw.model.pojos.MsPerfilregras;
import idw.model.pojos.MsPtColeta;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUsr;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.CIPRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.PerfilAndonRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.PerfilAndonDTO;
import idw.webservices.dto.PerfisAndonDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAndonArgsDTO;
import injetws.webservices.dto.IwsAndonDTO;
import injetws.webservices.dto.IwsAndonIndicadorDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosCIPDTO;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsListaAlertaDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsModDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsProdutoDTO;
import injetws.webservices.dto.IwsUpDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
// import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
// import ms.model.dto.UsuarioMSDTO;
// import ms.model.rn.MsRN;
import ms.model.rn.UpRN;
import ms.util.ConversaoTipos;

public class HeartBeatPdbaMsEvtRN extends AbstractPdbaMsEvtRN {

	/*
	 * Executa o heart-beat tanto para para o MS quanto para o PDBA Esse metodo eh chamado pela coleta discreta, advantech, etc. Para o
	 * inova o metodo chamado eh o setUPBeat
	 */
	public IwsHorarioDTO setUPBeatMac(String mac, Date dthrBeat) {
		return setUPBeat(mac, dthrBeat, false, false);
	}

	public IwsHorarioDTO setUPBeat(String mac, Date dthrBeat, boolean isLogoutNaViradaTurno, boolean isFechaParadaNaViradaTurno) {
		IwsHorarioDTO retorno = new IwsHorarioDTO();

		IwsListaUpDTO lista = inicializacao(mac, true, dthrBeat, ServicoFactory._IC_HEART_BEAT);

		retorno.setListaUpDTO(lista);

		return retorno;
	}

	public IwsListaUpDTO getTr_inicializacao(String mac, boolean comParadaSemConexao, boolean comParadaDefault, Date dtHr) {
		/*
		 * lancamento parada sem conexao esta sendo feita no servico ServicoInovaSAStartUp
		 */
		return inicializacao(mac, true, dtHr, ServicoFactory._INOVASA_STARTUP);
	}

	public IwsListaUpDTO inicializacaoSemEvento(String mac) {
		return inicializacao(mac, false, null, ServicoFactory._INOVASA_STARTUP);
	}

	public static void main(String[] args) {
		/*
		 * HeartBeatPdbaMsEvtRN rn = new HeartBeatPdbaMsEvtRN(); IwsListaUpDTO retorno = rn.inicializacaoSemEvento("192.168.0.16");
		 * System.out.println("deb");
		 */
	}

	/*
	 * Metodo unico chamado pelos heartbeat e inicializacoes
	 * 
	 */
	private IwsListaUpDTO inicializacao(String mac, boolean isExecutaWS, Date dthr, int tipoServico) {
		IdwLogger log = new IdwLogger("HeartBeatPdbaMsEvt.inicilizacao" + mac);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0, "inicializacao para " + mac);
		IwsListaUpDTO retorno = null;
		retorno = new IwsListaUpDTO();
		UpRN rn = new UpRN();
		OmCfg omcfg = null;
		
		try {
			
			rn.iniciaConexaoBanco();
			
			omcfg = Util.getConfigGeral(rn.getDaoPdba().getSession());
			
			List<MsUp> lista = rn.pesquisarListaMsUpPorUrlConexaoIhm(mac);
			
			if (lista == null || lista.isEmpty()) {
				log.info(idLog, 0, "sem up para o IHM com url = " + mac);
			}
			
			for (MsUp up : lista) {
				log.info(idLog, 0, "adicionando up " + up.getCdUp() + " ao coletor " + mac);
				retorno.addMsUp(up, rn.getDaoPdba());
			}
			
			retorno.setStAndonConfiguravel(false); // para testes do jconcentrador
			retorno.setStAndonProcessoft(false); // para testes do jconcentrador
			
			// Ricardo: 04/03/2023
			PerfilAndonRN andonRN = new PerfilAndonRN(rn.getDaoPdba());
			
			// Vou inicializar a lista de produtos no retorno. Isso nao estava
			// sendo feito no addMsUp
			PTRN prn = new PTRN(rn.getDaoPdba());

			for (IwsUpDTO up : retorno.getUps()) {
				
				
				// Se o simulador não está ligado...
				if (!IdwFacade.getInstancia().getIsSimuladorLigado()) {
				
					if (isExecutaWS) {
						// Executar o servico de INICILIZACAO do Inova
						log.info(idLog, 0, "Vou executar o servico " + tipoServico + " para a up " + up.getIdUP());
						executarServico(rn.getDaoPdba().getSession(), up.getIdUP(), null, dthr, null, null, tipoServico,
								"inicializacao " + DataHoraRN.getDataHoraAtualFormatada());
						log.info(idLog, 0, "Executado o servico " + tipoServico + " para a up " + up.getIdUP());
					}
					
				}
				
				
				// Pesquisar OmPt
				OmPt ompt = prn.pesquisarPtByCdPtStAtivo(up.getCdMaquina());

				// Pesquisar produtos para o CP
				PpCp ppcp = ompt.getPpCp();

				if (ppcp != null && (ompt.getIsSemop() == null || ompt.getIsSemop() == false)) {
					log.info(idLog, 0, "A up " + up.getCdMaquina() + " esta com a op " + ppcp.getCdCp() + " isSemop=" + ompt.getIsSemop());
					BigDecimal producaoLiquida = BigDecimal.ZERO;
					for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()) {
						IwsProdutoDTO produtodto = new IwsProdutoDTO();
						produtodto.setCdProduto(ppcpproduto.getOmProduto().getCdProduto());
						produtodto.setCdReduzido(ppcpproduto.getOmProduto().getDsCurta());
						produtodto.setDsProduto(ppcpproduto.getOmProduto().getDsProduto());
						produtodto.setProducaoLiquida(ppcpproduto.getProducaoLiquida().floatValue());
						producaoLiquida = producaoLiquida.add(ppcpproduto.getProducaoLiquida());
						produtodto.setProducaoPlanejada(ppcpproduto.getPcsProducaoplanejada().floatValue());
						up.getCp().addProdutoDTO(produtodto);
					}

					up.setProducaoLiquida(producaoLiquida.doubleValue());

					// Pega a quantidade de ciclos consolidados
					OmPtcp omptcp = obtemPtCp(ompt, ppcp, rn.getDaoPdba());

					if (omptcp != null && omptcp.getQtCiclos() != null)
						up.setNumeroDeCiclos(new BigDecimal(omptcp.getQtCiclos()));
					else
						up.setNumeroDeCiclos(BigDecimal.ZERO);

					if (omptcp != null && omptcp.getQtCiclosregulagem() != null)
						up.setNumeroDeCiclos(up.getNumeroDeCiclos().add(new BigDecimal(omptcp.getQtCiclosregulagem())));

					up.setIsSemPrograma(false);

					/*
					 * Atualizar dados da ordem de producao
					 * 
					 */
					up.setCp(atualizarComDadosCP(ppcp, rn.getDaoPdba(), omptcp));

				} else {
					log.info(idLog, 0, "A up " + up.getCdMaquina() + " esta sem op");
					up.setIsSemPrograma(true);
					up.setCp(null); // se esse parametro for passado o coletor se atualiza com novos dados da op. Em geral qdo mudar a op,
									// ou um ihm externo mudar a op
				}

				/*
				 * Obtem a lista de operadores logados Alessandre em 04-05-22 comentei o trecho abaixo para substituir por outro que avalie
				 * o logout automatico do operador na virada do turno List<IwsModDTO> listaLoginsEmAberto = new ArrayList<>(); ConsolidaRN
				 * rnc = new ConsolidaRN(rn.getDaoPdba()); List<DwConsolmolog> mologs =
				 * rnc.getDwConsolmologComLoginAbertoByCdUp(up.getCdMaquina());
				 * 
				 * for (DwConsolmolog molog : mologs) { IwsModDTO dto = new IwsModDTO();
				 * 
				 * dto.setDthrLogin(molog.getDthrIlogin()); dto.setDthrLogout(molog.getDthrFlogin());
				 * dto.setIdUsuario(String.valueOf(molog.getOmUsr().getCdUsr())); dto.setLogin(molog.getOmUsr().getCdUsr());
				 * dto.setNome(molog.getOmUsr().getDsNome());
				 * 
				 * listaLoginsEmAberto.add(dto); }
				 * 
				 * up.setListaLoginsEmAberto(listaLoginsEmAberto);
				 */

				up.setListaLoginsEmAberto(avaliarLogoutOperadores(rn.getDaoPdba(), ompt, DataHoraRN.getDataHoraAtual(), log, omcfg));
				up.setTemOperadorLogado(up.getListaLoginsEmAberto().size() > 0);

				/*
				 * Obtem a lista dos alertas em aberto
				 * 
				 */
				AlertaPdbaMsEvtRN arn = new AlertaPdbaMsEvtRN();

				IwsListaAlertaDTO alertasAbertos = arn.getTr_alertasAbertos(ompt.getCdPt());
				List<IwsAlertaDTO> listaAlertasEmAberto = alertasAbertos.getAlertas();
				up.setListaAlertasEmAberto(listaAlertasEmAberto);

				/*
				 * Obtem o ultimo refugo
				 * 
				 */
				// essa informacao nao vai na sessao mas na chamada do webservice getInfoUltimoRefugo

				/*
				 * Obtem a ultima parada
				 * 
				 */
				ConsolidaRN crn = new ConsolidaRN();
				crn.setDao(rn.getDaoPdba());
				IwsParadaDTO parada = new IwsParadaDTO();
				MsPtColeta coleta = null;
				try {
					coleta = ompt.getMsPtColeta();
				} catch (NullPointerException e) {
					coleta = null;
				}

				if (coleta != null && coleta.getDthrIparada() != null) {

					log.info(idLog, 0, "cdPt=" + ompt.getCdPt() +
							" MsPtColeta.heartbeat=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(coleta.getDthrHeartbeat()) +
							" inicioParada=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(coleta.getDthrIparada()) +
							" fimParada=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(coleta.getDthrFparada()) +
							" isparada=" + coleta.getIsParada());

					if (coleta.getDwTParada() != null) {
						parada.setCdParada(coleta.getDwTParada().getCdTparada());
						parada.setDsParada(coleta.getDwTParada().getDsTparada());
						parada.setIsPodeAlterarCdPar(
								coleta.getDwTParada().getIsPermitecorrecao() != null && coleta.getDwTParada().getIsPermitecorrecao());
						parada.setIsRegulagem(coleta.getDwTParada().getIsRegulagem() != null && coleta.getDwTParada().getIsRegulagem());
					} else {
						parada.setIsPodeAlterarCdPar(true);
						if (omcfg.getDwTParada() != null)
							parada.setCdParada(omcfg.getDwTParada().getCdTparada());
						else
							parada.setCdParada("999999");
						parada.setIsRegulagem(false);
					}

					parada.setIsPeriodoSemConexao(false);
					parada.setDthrIparada(coleta.getDthrIparada());
					parada.setIsPersistente(false);

					up.setParadaAtualOuUltimaParada(parada);
					up.setIsParadaEmAberto(coleta.getIsParada() != null && coleta.getIsParada());
					if (up.getIsParadaEmAberto())
						up.setIsEmRegulagem(parada.getIsRegulagem());
					else
						up.setIsEmRegulagem(false);

				} else {
					up.setParadaAtualOuUltimaParada(null);
					up.setIsParadaEmAberto(false);
					up.setIsEmRegulagem(false);
				}

				/*
				 * Define o tipo da sessao para o inova Abaixo os tipos de sessao atualmente disponiveis no Injet
				 * 
				 * Tipos de sessao que procuram uma OP que ja existe
				 * 
				 * 1 - Pede Molde 2 - Pede OP 3 - Produto
				 * 
				 * Abaixo tipos de sessao que foram desabilitados para o IDW pois sao especificas de integracoes 6 - Produto (desabilitar) 9
				 * - Molde produto e qtde de cartoes (desabilitado) 11 - OP (desabilitado) 12 - OP, Molde e estrutura (desabilitad) Arthi 13
				 * - OP Molde Estrutura Producao Planejada (desabilitado) Fitesa
				 * 
				 * 
				 * Ops criadas no servidor
				 * 
				 * Ferramenta e producao planejada Produto e producao planejada 4 - Molde e estrutura qtde ciclo (falta) 5 - Produto
				 * estrutura e producao planejada (contemplada) 7 - Produto producao planjeada (contemplado) 8 - Molde produto e qtde ciclos
				 * (falta)
				 * 
				 * 
				 * Tipo de sesssao desabilitadas criados no servidor
				 * 
				 * 10 - OP producao planejada (desabilitado)
				 * 
				 * 
				 */
				try {
					log.info(idLog, 0, "UP " + up.getCdMaquina() + " vou pegar o tipoSessao");
					up.setStCriacaoCP(ompt.obtemTipoSessaoInjet());
					log.info(idLog, 0, "UP " + up.getCdMaquina() + " tipoSessao=" + up.getStCriacaoCP());
				} catch (NullPointerException e) {
					e.printStackTrace();
				}

				/* Atualizar dados vindos do PT */

				/*
				 * Se o PT estiver configurado para nao abrir CIP entao nao considerar
				 */
				up.setDadosCIP(null);

				if (ompt.getIsHabilitaCip() != null && ompt.getIsHabilitaCip() == true) {
					log.info(idLog, 0, "CIP hablitado para pt " + ompt.getCdPt());

					/* Dados do CIP */
					CIPRN cirn = new CIPRN(rn.getDaoPdba());
					DwConsolciplog cip = null;

					if (ompt.getPpCp() != null)
						cip = cirn.getUltimoCIPByOmPt(ompt);

					if (cip != null && cip.getDthrFcip() == null) {
						log.info(idLog, 0, "Tem CIP e esta em aberto.");
						IwsDadosCIPDTO dadosCIP = new IwsDadosCIPDTO();

						dadosCIP.setCdmoldeantigo("cdmoldeantigo"); // utilizado no calculo de tempo de tolerancia

						dadosCIP.setDtHrInicio(cip.getDthrIcip()); // deve ser preenchida qdo tiver um cip em aberto

						dadosCIP.setIsEmCIP(true); // Se true ja abriu o CIP e esta pendente de finalizar

						dadosCIP.setIsCIPPendente(false); // se true entao o clp tem q abrir um CIP no injet o BC determina

						up.setDadosCIP(dadosCIP); // se passar null nada muda no coletor qto ao cip
					} else {
						log.info(idLog, 0, "NAO tem CIP em aberto, abrindo um");
						/*
						 * Se a OP nunca tiver tido um CIP entao habilitar para abrir um
						 */
						if (cip == null || (cip.getDwConsolidByIdConsolidInicio() != null
								&& cip.getDwConsolidByIdConsolidInicio().getPpCp() != ppcp)) {
							log.info(idLog, 0, "OP nunca teve CIP aberto, habilitando para abrir um");
							// determina se eh necessario executar algum cip
							IwsDadosCIPDTO dadosCIP = new IwsDadosCIPDTO();
							dadosCIP.setDtHrInicio(null);
							/*
							 * Vai ser true se o molde anterior foi diferente ou se a materia prima for diferente Se o CIP nao for
							 * necessario passar null Para o IDW vai ser true se houver tempo de setup definido para a folha da OP
							 * ppcp.getDwFolha.().getIdFolha() Por enquanto nao vou avaliar o tempo de setup na especializacao. Deve
							 * considerar pendente, alem disso, se for necessario autentica um tecnico
							 */
							boolean isCIPPendente = false;

							if (ppcp != null)
								isCIPPendente = ppcp.getDwFolha().getSegSetup() != null && ppcp.getDwFolha().getSegSetup() > 0;

							/*
							 * Comentado pois no inova essa configuracao é local no coletor if (isCIPPendente == true) { if
							 * (omcfg.getIsRequerTecnicoInicioCip() == null || (omcfg.getIsRequerTecnicoInicioCip() != null &&
							 * omcfg.getIsRequerTecnicoInicioCip() == false)) { log.info(idLog, 0,
							 * "CIP deixou de estar pendente pois requerTecnicoInicioCip = " + omcfg.getIsRequerTecnicoInicioCip());
							 * isCIPPendente = false; } else { log.info(idLog, 0, "CIP continua pendente pois requerTecnicoInicioCip = " +
							 * omcfg.getIsRequerTecnicoInicioCip()); } }
							 */

							dadosCIP.setIsCIPPendente(isCIPPendente);

							up.setDadosCIP(dadosCIP);
							log.info(idLog, 0, "CIP pendente?" + isCIPPendente);

						} else if (cip != null && cip.getDthrFcip() != null) {
							log.info(idLog, 0, "OP ja teve CIP aberto");
							// Entao ja fechou o cip, avisar isso ao coletor
							IwsDadosCIPDTO dadosCIP = new IwsDadosCIPDTO();
							dadosCIP.setIsEmCIP(false);
							dadosCIP.setIsCIPPendente(false);
							up.setDadosCIP(dadosCIP);
						}
					}
				} else {
					log.info(idLog, 0, "PT " + ompt.getCdPt() + " nao esta configurado para abrir CIP");
				}
				
								
				// --------------------------------------------------------------
				// Regras do Andon
				// --------------------------------------------------------------
				
				// Ricardo: 04/03/2023
				PerfisAndonDTO perfisAndon = new PerfisAndonDTO();
				PerfilAndonDTO perfilAndon = new PerfilAndonDTO();
				MsPerfilandon filtroAndonDTO = new MsPerfilandon();
				List<IwsAndonDTO> listaAndon = new ArrayList<IwsAndonDTO>();
				IwsAndonDTO andon = new IwsAndonDTO();
				IcUpDTO icup = new IcUpDTO();
				
				// -------------------------------------------------------------------
				// Monta o filtro para pesquisar o perfil andon do IC da UP
				// -------------------------------------------------------------------
				
				// Pesquisa o IC da UP
				icup = rn.pesquisarIcUpDtoPorIdUp(ConversaoTipos.converteParaBigDecimal(up.getIdUP()));
				
				// Seta dados do filtro
				filtroAndonDTO.setStAtivo((byte) 1);
				filtroAndonDTO.setCdPerfilandon(icup.getIc().getCdPerfilAndon());
				
				// Aplica o filtro
				perfilAndon.setMsPerfilandon(filtroAndonDTO);
				
				// -------------------------------------------------------------------
				
				// Consulta o perfil do andon da IC da UP
				perfisAndon = andonRN.getMsPerfilandon(perfilAndon);
				
				
				List<PerfilAndonDTO> perfil = perfisAndon.getAndonDTOs();

				/*
				perfil.getMsPerfilandon().getIdPerfilandon();
				perfil.getMsPerfilandon().getCdPerfilandon();
				perfil.getMsPerfilandon().getDsPerfilandon();
				*/

				// private Set<MsPerfilregras> msPerfilregrases = new HashSet<MsPerfilregras>(0);
				// private Set<MsIc> msIcs = new HashSet<MsIc>(0);
				
				
				if (perfil != null) {
					
					retorno.setStAndonConfiguravel(true);
					
					for (MsPerfilregras regra : perfil.get(0).getMsPerfilandon().getMsPerfilregrases()) {
						
						andon = new IwsAndonDTO();
						
						// andon.setIdup(up.getIdUP());
						andon.setIdup(regra.getUrlConexaoUp());
						
						// tp_saida = 0 -> LUZ VERDE
						// tp_saida = 1 -> LUZ AMARELA
						// tp_saida = 2 -> LUZ VERMELHA
						
						// sinal_motivo = NULL -> Nenhum
						// sinal_motivo = 1    -> Igual
						// sinal_motivo = 2    -> Diferente
						
						// vl_motivo = é valor de referência quando existe "sinal motivo"
						
						
						andon.setTmptolerancia(ConversaoTipos.converterParaBigDecimal(regra.getSegTolerancia()));
						
						andon.setVlMotivo(regra.getVlMotivo());
						andon.setSinalMotivo(regra.getSinalMotivo());
						andon.setTpSaida(regra.getTpSaida());
						
						// Máquina parada
						if (regra.getTpMotivo() == 0) {
							// public static int EV_PARADA = 1;
							andon.setTpeventoandon(new BigDecimal(1));
							
							// Máquina trabalhando
						} else if (regra.getTpMotivo() == 1) {
							// public static int EV_MAQUINA_TRABALHANDO = 7;
							andon.setTpeventoandon(new BigDecimal(7));
							
							// Parada específica
						} else if (regra.getTpMotivo() == 2) {
							// public static int EV_QLQR_PARADA = 13;
							andon.setTpeventoandon(new BigDecimal(13));
							
						}
						
						andon.setIdrele(ConversaoTipos.converterParaBigDecimal(regra.getPorta()));
						
						// ???
						// andon.setIdreleaux(regra.getUrlConexaoUp());
						
						andon.setPrioridade(ConversaoTipos.converterParaBigDecimal(regra.getPrioridade()));
						
						if (regra.getIsPiscante()) {
							andon.setStintermitente(new BigDecimal(1));
						} else {
							andon.setStintermitente(new BigDecimal(0));
						}
						
						andon.setTmpsinalalto(regra.getSegTempoauto());
						andon.setTmpsinalbaixo(regra.getSegTempobaixa());
						
						listaAndon.add(andon);

						
					}
					
				}
				
				up.setListaAndonDTO(listaAndon);
				
				// --------------------------------------------------------------
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			rn.finalizaConexaoBanco(log);
			log.info(idLog, 0, "FIM - inicializacao para " + mac);
		}

		return retorno;
		
	}
	

	private List<IwsModDTO> avaliarLogoutOperadores(DAOGenerico dao, OmPt omPt, Date dthrEvento, IdwLogger log, OmCfg omcfg) {
		List<IwsModDTO> retorno = new ArrayList<>();

		ConsolidaRN rn = new ConsolidaRN(dao);
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
				
				
				IwsModDTO dto = new IwsModDTO();
				dto.setDthrLogin(dwConsolmolog.getDthrIlogin()); 
				dto.setDthrLogout(dwConsolmolog.getDthrFlogin());
				dto.setIdUsuario(String.valueOf(dwConsolmolog.getOmUsr().getCdUsr())); 
				dto.setLogin(dwConsolmolog.getOmUsr().getCdUsr());
				dto.setNome(dwConsolmolog.getOmUsr().getDsNome());
				
				
				retorno.add(dto);

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
							ServicoFactory.getInstancia().executaServico(null, mensagem);
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

	public IwsHorarioDTO getTr_sincronizaHorario() {
		IwsHorarioDTO horario = new IwsHorarioDTO();

		Date data = DataHoraRN.getDataHoraAtual();

		horario.setData(data);

		return horario;

	}

	private IwsCpDTO atualizarComDadosCP(PpCp ppcp, DAOGenerico dao, OmPtcp omptcp) {
		IwsCpDTO retorno = new IwsCpDTO();
		OmCfg omcfg = Util.getConfigGeral(dao.getSession());

		/*
		 * Encontra o ciclo padrao
		 * 
		 */
		BigDecimal cicloPadrao = BigDecimal.ONE;
		FolhaRN frn = new FolhaRN(dao);
		DwFolha folhaAtualizada = frn.pesquisaFolhaByCdEStSemRota(ppcp.getDwFolha().getCdFolha());
		if (folhaAtualizada == null) // sera null qdo a folha tiver sido apagada
			folhaAtualizada = ppcp.getDwFolha();

		try {
			cicloPadrao = frn.getCicloPadrao(folhaAtualizada, ppcp.getOmPt());
		} catch (SemCicloPadraoException e1) {
			cicloPadrao = BigDecimal.ONE;
		}

		if (omcfg.getDwTParadasemconexao() != null)
			retorno.setcdParadaSemProd(omcfg.getDwTParadasemconexao().getCdTparada());

		if (folhaAtualizada.getSegCiclotimeout() != null)
			retorno.setCfgPercTmpCicloParAuto(folhaAtualizada.getSegCiclotimeout().floatValue());
		else
			retorno.setCfgPercTmpCicloParAuto(200f);

		if (folhaAtualizada.getSegCiclominimo() != null) {
			float cfgPercToleranciaSinalCiclo = 0f;
			try {
				cfgPercToleranciaSinalCiclo =
						folhaAtualizada.getSegCiclominimo().divide(cicloPadrao).multiply(new BigDecimal(100)).floatValue();
			} catch (ArithmeticException e) {
				cfgPercToleranciaSinalCiclo = 200f;
			}
			retorno.setCfgPercToleranciaSinalCiclo(cfgPercToleranciaSinalCiclo);
		} else
			retorno.setCfgPercToleranciaSinalCiclo(50f);

		Integer pacoteCiclo;
		try {
			pacoteCiclo = frn.getPacoteCicloFromDwFolha(folhaAtualizada, ppcp.getOmPt());
		} catch (SemPacoteOuFatorException e1) {
			pacoteCiclo = null;
		}
		if (pacoteCiclo != null) {
			retorno.setCfgTamanhoUmPacoteCiclos(pacoteCiclo.floatValue());
		} else {
			retorno.setCfgTamanhoUmPacoteCiclos(1f);
		}

		if (omcfg.getDwTParada() != null && omcfg.getDwTParada().getSegExtrapolacao() != null)
			retorno.setCfgTolerTmpCicloParAuto(omcfg.getDwTParada().getSegExtrapolacao().longValue());

		retorno.setCicloPadrao(cicloPadrao.floatValue());
		retorno.setDthrIPlanejamento(ppcp.getDthrInicio());
		retorno.setNrop(ppcp.getNrop());
		retorno.setNropestendido(retorno.getNrop());
		retorno.setStCriacaoCP(ppcp.getOmPt().obtemTipoSessaoInjet().toString());

		if (omptcp != null && omptcp.getQtCiclos() != null) {
			retorno.setQtciclos(omptcp.getQtCiclos().toString());
			retorno.setIsOpSemColeta(false); // Acredito q sera true qdo a OP nao tiver nenhuma coleta
		} else {
			retorno.setQtciclos("0");
			retorno.setIsOpSemColeta(true); // Acredito q sera true qdo a OP nao tiver nenhuma coleta
		}

		retorno.setIsProducaoValida(true); // Em qual situacao seria false???
		retorno.setIsOpcomloteInsumo(false);
		retorno.setIsBloqueioParadaSemConexao(false);
		retorno.setIsSGBDOnline(true);
		retorno.setIsApntSAPAtivo(null);
		retorno.setQtcartoes(null);
		retorno.setStApntSAP(null);
		retorno.setTxtMensagem(null);

		List<IwsProdutoDTO> produtos = new ArrayList<>();
		String cdProduto = null;
		for (PpCpproduto cpprod : ppcp.getPpCpprodutos()) {
			IwsProdutoDTO produto = new IwsProdutoDTO();
			produto.setCdProduto(cpprod.getOmProduto().getCdProduto());
			produto.setDsProduto(cpprod.getOmProduto().getDsProduto());
			produto.setProducaoLiquida(cpprod.getProducaoLiquida().floatValue());
			produto.setProducaoPlanejada(cpprod.getPcsProducaoplanejada().floatValue());

			if (cdProduto == null)
				cdProduto = produto.getCdProduto();

			// Proucurar a folha da ferramenta. Se nao tiver usar 1
			DwFolharapcom com = null;
			try {
				com = frn.getFolharapcom(folhaAtualizada, cpprod.getOmProduto());
			} catch (RegistroDesconhecidoException e) {
				com = null;
			}

			if (com != null && com.getIdredzproduto() != null)
				produto.setCdReduzido(ConversaoTipos.converterParaString(com.getIdredzproduto()));
			else
				produto.setCdReduzido("1");

			produtos.add(produto);
		}
		retorno.setProdutos(produtos);
		retorno.setPlanClose(ppcp.getSaldoAProduzir() <= 0d); // Acredito que seja true qdo a OP estiver concluida
		retorno.setProducaoPlanejada(ConversaoTipos.converteParaString(ppcp.getQtPecasProduzir(), 0));
		retorno.setCdProduto(cdProduto);

		/*
		 * Obtem dados da ferramenta se houver
		 * 
		 */
		String cdmolde = "";
		String cdestrutura = "0001"; // avaliar se pode ser fixo

		if (folhaAtualizada.getDwFolharaps().isEmpty() == false) {
			for (DwFolharap rap : folhaAtualizada.getDwFolharaps()) {
				cdmolde = rap.getDwRap().getCdRap();
			}
		} else {
			cdmolde = folhaAtualizada.getCdFolha();
		}

		retorno.setCdmolde(cdmolde);
		retorno.setCdestrutura(cdestrutura);
		retorno.setCdmoldeestendido(retorno.getCdmolde());
		retorno.setQtcavidades(null);

		return retorno;
	}
}
