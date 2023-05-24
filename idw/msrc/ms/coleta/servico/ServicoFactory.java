package ms.coleta.servico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.util.IdwLogger;
import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.util.UtilsThreads;

public class ServicoFactory {
	
	public final static int _VAZIO = 1000;
	
	public final static int _REGISTRO_CLIENTES = 0;
	public final static int _DESREGISTRO_CLIENTES = 1;
	public final static int _FIM_CICLO = 2;
	public final static int _INICIO_PARADA = 3;
	public final static int _MOTIVO_PARADA = 4;
	public final static int _ANDON = 5;
	public final static int _INICIA_NOVA_PARADA = 6;
	public final static int _LOGIN = 8;
	public final static int _LOGOUT = 9;
	public final static int _INICIA_ALERTA = 10;
	public final static int _REMOVE_ALERTA = 11;
	public final static int _CONSULTA = 12;
	public final static int _APAGAULTIMOREFUGO = 13;
	public final static int _VALIDAREFUGO = 14;
	public final static int _NOVOREFUGO = 15;
	public final static int _VALIDAPARADA = 16;
	public final static int _INFORMA_MOTIVO_PARADA = 17;
	public final static int _IC_HEART_BEAT = 18;
	public final static int _NOVA_OP = 19;
	public final static int _FINALIZA_OP = 20;
	
	// servicos de resp usados no IHM android
	public final static int _RESPOSTA = 21;
	public final static int _RESP_CONSULTA = 22;
	public final static int _RESP_VALIDA_REFUGO = 23;
	public final static int _RESP_VALIDA_PARADA = 24;
	public final static int _FINALIZA_PARADA = 25;

	// Alessandre: inclui o 26 abaixo para tratar o inicio de ciclo vindo das insersoras fuji e troca de programa
	public final static int _INICIO_CICLO = 26;
	public final static int _TROCA_PROGRAMA = 27;
	//ph: inclui o 28 para tratar as informacoes de usoRap
	public final static int _USO_RAP = 28;
	
	// alessamdre: inclui o fim_parada principalmente porcausa do insert e foi criado um servico inicio_parada e fim-parada separados
	public final static int _FIM_PARADA = 29;
	
	// Peagah: Inclui a informa��o do erro das insersoras evento 30
	
	public static int _ERRO_INSERSORA = 30;
	public static final int _PASSAGEM = 31;
	public static final int _VALIDA_PASSAGEM = 31001;
	public static final int _VALIDA_NUMERO_DE_SERIE = 32;
	public static final int _VERIFICA_REFUGO_TCP = 33;
	public static final int _VALIDA_REFUGO = 15001;
	public static final int _CRIA_OP_AUTOMATICA = 34;
	public static final int _CRIA_OP_AUTOMATICA_STANDALONE = 19001;
	public static final int _CONSULTA_GENERICA_INOVASA = 35;
	public static final int _CONSULTA_GENERICA = 35000;
	public static final int _INICIAR_CIP_INOVASA = 36;
	public static final int _FINALIZAR_CIP_INOVASA = 37;
	public static final int _INICIO_VARIACAO_RITMO = 38;
	public static final int _MOTIVO_VARRITMO = 39;
	public static final int _FIM_VARIACAO_RITMO = 40;
	
	public static final int _INOVASA_STARTUP = 99;
	
	public static final int _PRE_INICIALIZAR = 100;
	public static final int _INICIALIZAR = 101;
	public static final int _VALIDAR_ORDEM_PRODUCAO = 102;
	public static final int _ENTRADA_OP_CONFIRMADA = 105;
	public static final int _FINALIZACAO_OP_INOVA = 106;
	public static final int _CICLO_INOVA = 107;
	public static final int _INICIO_PARADA_INOVA = 108;
	public static final int _INFORMAR_PARADA_PRE_CONFIGURADA = 181;
	public static final int _INFORMAR_MOTIVO_PARADA_INOVA = 109;
	public static final int _VALIDAR_MOTIVO_PARADA_INOVA = 191;
	public static final int _INFORMAR_MOTIVO_PARADA_TODAS_INOVA = 192;
	public static final int _VALIDAR_PARADA_CAJ_INOVA = 193;
	public static final int _VALIDAR_PARADA_TECNICOS_INOVA = 194;
	public static final int _FIM_PARADA_INOVA = 110;
	public static final int _FAZER_REFUGO_INOVA = 112;
	public static final int _VALIDAR_REFUGO_INOVA = 1121;
	public static final int _CANCELAR_REFUGO_INOVA = 114;
	public static final int _ABRIR_ALERTA_INOVA = 115;
	public static final int _FECHAR_ALERTA_INOVA = 116;
	public static final int _LOGIN_OPERADOR_INOVA = 117;
	public static final int _VALIDAR_OPERADOR_INOVA = 1171;
	public static final int _LOGOUT_OPERADOR_INOVA = 118;
	public static final int _CONSULTA_INOVA = 119;
	public static final int _INICIAR_CIP_INOVA = 126;
	public static final int _FINALIZAR_CIP_INOVA = 127;
	public static final int _VALIDAR_LOGIN_FIM_CIP_INOVA = 1271;
	public static final int _SOLICITAR_DADOS_INSPECAO_QUALIDADE1_INOVA = 128;
	public static final int _EXECUTAR_INSPECAO_QUALIDADE1_INOVA = 129;
	public static final int _EXECUTAR_APONTAMENTO_ARAMADO_INOVA = 130;
	public static final int _SOLICITAR_DADOS_INSPECAO_QUALIDADE2_INOVA = 131;
	public static final int _SOLICITAR_INSPECAO_QUALIDADE2_INOVA = 1311;
	public static final int _EXECUTAR_INSPECAO_QUALIDADE2_INOVA = 132;
	public static final int _VALIDAR_INSPECAO_QUALIDADE2_INOVA = 1321;
	public static final int _ENVIAR_DNC_PARA_COLETOR_INOVA = 135;
	public static final int _RECEBER_DNC_DE_COLETOR_INOVA = 136;
	public static final int _ABRIR_PORTAS_DNC_INOVA = 137;
	public static final int _APOS_ENVIAR_DNC_PARA_COLETOR_INOVA = 138;
	public static final int _SOLICITAR_ABERTURA_INSPECAO_QUALIDADE2_INOVA = 141;
	public static final int _FECHAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA = 142;
	public static final int _BUSCAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA = 1421;
	public static final int _VALIDAR_LOGIN_FECHAR_INSPECAO_QUALIDADE2_INOVA = 1422;
	public static final int _ALTERAR_STATUS_APONTAMENTO_SAP_INOVA = 143;
	public static final int _ALTERAR_QUANTIDADE_CARTAO_KANBAN_INOVA = 144;
	public static final int _VALIDAR_DADOS_SAP_INOVA = 145;
	public static final int _VALIDAR_CODIGO_MATERIA_PRIMA_INOVA = 1451;
	public static final int _HEART_BEAT_INOVA = 166;
	public static final int _FALTA_MEMORIA_INOVA = 1666;
	public static final int _PEGAR_INFORMACOES_MATERIA_PRIMA_INOVA = 1998;
	public static final int _CONFIRMAR_DADOS_INTEGRACAO_DOAL_INOVA = 1999;
	
	/*
	 * Zona de Eventos Para Coleta Micrologic FLEX 
	 */
	public static final int _MEDICAO_TEMPERATURA = 2001;
	public static final int _ALERTA_TEMPERATURA = 2002;
	public static final int _ALERTA_PERDA_CONEXAO = 2003;
	public static final int _MAQUINA_OFFLINE = 2004;
	public static final int _MAQUINA_ONLINE = 2005;
		
	/*
	 * Zona de Eventos Para Coleta OPC UA Injetora  
	 */
	public static final int _MEDICAO_TEMPERATURA_ZONAS_OPC = 2006;
	public static final int _MEDICAO_FT_PARAM_OPC = 2007;
	
	/*
	 * Zona de Eventos Para Coleta StandAlone
	 */
	
	public static final int _PROD_LIQ_EFI_REAL_TURNO = 1;
	public static final int _PROD_LIQ_EFI_REAL_OP = 2;
	public static final int _QTD_REF_INDI_REF_TURNO = 3;
	public static final int _QTD_REF_INDI_REF_OP = 4;
	public static final int _A_PRDZR_NUM_OP_MLD_OR_EST_OR_CDPROD = 5;
	public static final int _CICLO_MED_CICLO_PAD_TURNO = 6;
	public static final int _INDC_PAR_TURNO_INDC_PAR_OP = 7;
	public static final int _PRODLIQ_EFI_REAL_TODAS_OP = 8;
	public static final int _EFI_CICLO_TURNO_E_OP = 9;
	public static final int _TIME_INTERV_META_PROD_HR = 10;
	public static final int _PRODLIQ_EFI_REAL_HR = 11;
	public static final int _TURNO_DTHR_ATUAL = 12;
	public static final int _PRODLIQ_EFI_REAL_TODAS_ACU = 13;
	public static final int _QTD_REF_INDI_REF_TODAS_OP = 14;
	public static final int _IND_PAR_TURNO_TODAS_OP_E_ATUAL = 15;
	public static final int _EFI_CICLO_TURNO_TODAS_OP_E_ATUAL = 16;
	public static final int _COD_E_DES_ULTIMA_PAR = 17;
	public static final int _PRODUTOS_DA_OP = 18;
	public static final int _CIP_DTHR_DURATION = 19;
	public static final int _CIP_DTHR_PROD_REF = 21;
	public static final int _OEE_TURNO = 23;
	public static final int _OEE_ULTIMA_HR = 24;
	public static final int _PERFIL_ANDON = 25;
	
	
	/*
	
	/*
	 * Zona de Eventos Para Coleta CCK
	 * 
	 * */
	public static final int _CCK  = 69;
	public static final int _MEDICAO_CCK = 2010;
	public static final int _ALERTA_CONSUMO_ATIVO=2012;
	public static final int _ALERTA_FATOR_DE_POTENCIA=2013;
	public static final int _MEDICAO_DEMANDA_MAXIMA=2014;
	
	public static final int _MEDICAO_VELOCIDADE= 2015;
	public static final int _MEDICAO_PRESSAO = 2016;
	
	private static ServicoFactory instancia;
	private List<ClienteRegistrado> clientesRegistrados = new ArrayList<ClienteRegistrado>();
	@SuppressWarnings("rawtypes")
	private Map<Integer, Class> servicosDisponiveis = new HashMap<Integer, Class>();
	private int qtClienteRegistrados = 0;
	private int qtCiclosEnviadosTodosClientes = 0;

	public ServicoFactory() {
		// Inicializa servicos disponiveis
		/*
		 * Alterado para HashMap por Hugo, dia 30.01.2012
		 * devido a conflitos existentes com a versao
		 * do IDW Mobile feito para a plataforma Android
		 */
		
		servicosDisponiveis.put(_REGISTRO_CLIENTES, ServicoRegistro.class);
		servicosDisponiveis.put(_DESREGISTRO_CLIENTES, ServicoDesregistro.class);
		servicosDisponiveis.put(_FIM_CICLO, ServicoFimCiclo.class);
		servicosDisponiveis.put(_PASSAGEM, ServicoPassagem.class);
		servicosDisponiveis.put(_FIM_PARADA, ServicoFimParada.class);
		servicosDisponiveis.put(_MOTIVO_PARADA, ServicoMotivoParada.class);
		servicosDisponiveis.put(_ANDON, ServicoAndon.class);
		servicosDisponiveis.put(_INICIA_NOVA_PARADA, ServicoIniciaNovaParada.class);
		servicosDisponiveis.put(_LOGIN, ServicoLogin.class);
		servicosDisponiveis.put(_LOGOUT, ServicoLogout.class);
		servicosDisponiveis.put(_INICIA_ALERTA, ServicoIniciaAlerta.class);
		servicosDisponiveis.put(_REMOVE_ALERTA, ServicoRemoveAlerta.class);
		servicosDisponiveis.put(_CONSULTA, ServicoConsulta.class);
		servicosDisponiveis.put(_APAGAULTIMOREFUGO, ServicoApagaUltimoRefugo.class);
		servicosDisponiveis.put(_VALIDAREFUGO, ServicoValidaRefugo.class);
		servicosDisponiveis.put(_NOVOREFUGO, ServicoNovoRefugo.class);
		servicosDisponiveis.put(_VALIDAPARADA, ServicoValidaParada.class);
		servicosDisponiveis.put(_INFORMA_MOTIVO_PARADA, ServicoMotivoParada.class); // alessandre em 24-7-14 nao entendi pq existe o servicoinformamotivoparada. ServicoInformaMotivoParada.class);
		servicosDisponiveis.put(_IC_HEART_BEAT, ServicoIcHeartBeat.class);
		servicosDisponiveis.put(_NOVA_OP, ServicoNovaOp.class);
		servicosDisponiveis.put(_FINALIZA_OP, ServicoFinalizaOp.class);
		servicosDisponiveis.put(_FINALIZA_PARADA, ServicoFinalizaParada.class);
		servicosDisponiveis.put(_PRE_INICIALIZAR, ServicoPreInicializacao.class);
		servicosDisponiveis.put(_INICIALIZAR, ServicoInicializacao.class);
		servicosDisponiveis.put(_VALIDAR_ORDEM_PRODUCAO, ServicoValidarOrdemProducao.class);
		servicosDisponiveis.put(_ENTRADA_OP_CONFIRMADA, ServicoEntradaOpConfirmada.class);
		servicosDisponiveis.put(_FINALIZACAO_OP_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_CICLO_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_INICIO_PARADA_INOVA, ServicoInicioParadaInovaLuiz.class);
		servicosDisponiveis.put(_INFORMAR_PARADA_PRE_CONFIGURADA, ServicoVazioINova.class);
		servicosDisponiveis.put(_INFORMAR_MOTIVO_PARADA_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_MOTIVO_PARADA_INOVA, ServicoValidarMotivoParadaInova.class);
		servicosDisponiveis.put(_INFORMAR_MOTIVO_PARADA_TODAS_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_PARADA_CAJ_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_PARADA_TECNICOS_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_FIM_PARADA_INOVA, ServicoFimParadaInova.class);
		servicosDisponiveis.put(_FAZER_REFUGO_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_REFUGO_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_CANCELAR_REFUGO_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_ABRIR_ALERTA_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_FECHAR_ALERTA_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_LOGIN_OPERADOR_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_OPERADOR_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_LOGOUT_OPERADOR_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_CONSULTA_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_INICIAR_CIP_INOVA, ServicoIniciarCIP.class);
		servicosDisponiveis.put(_FINALIZAR_CIP_INOVA, ServicoFinalizarCIP.class);
		servicosDisponiveis.put(_VALIDAR_LOGIN_FIM_CIP_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_SOLICITAR_DADOS_INSPECAO_QUALIDADE1_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_EXECUTAR_INSPECAO_QUALIDADE1_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_EXECUTAR_APONTAMENTO_ARAMADO_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_SOLICITAR_DADOS_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_SOLICITAR_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_EXECUTAR_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_ENVIAR_DNC_PARA_COLETOR_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_RECEBER_DNC_DE_COLETOR_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_ABRIR_PORTAS_DNC_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_APOS_ENVIAR_DNC_PARA_COLETOR_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_SOLICITAR_ABERTURA_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_FECHAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_BUSCAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_LOGIN_FECHAR_INSPECAO_QUALIDADE2_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_ALTERAR_STATUS_APONTAMENTO_SAP_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_ALTERAR_QUANTIDADE_CARTAO_KANBAN_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_DADOS_SAP_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_VALIDAR_CODIGO_MATERIA_PRIMA_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_HEART_BEAT_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_FALTA_MEMORIA_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_PEGAR_INFORMACOES_MATERIA_PRIMA_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_CONFIRMAR_DADOS_INTEGRACAO_DOAL_INOVA, ServicoVazioINova.class);
		servicosDisponiveis.put(_INICIO_CICLO, ServicoInicioCiclo.class);
		servicosDisponiveis.put(_TROCA_PROGRAMA, ServicoTrocaPrograma.class);
		servicosDisponiveis.put(_USO_RAP, ServicoUsoRap.class);
		servicosDisponiveis.put(_INICIO_PARADA, ServicoInicioParada.class);
		servicosDisponiveis.put(_MEDICAO_TEMPERATURA, ServicoMedTemp.class);
		servicosDisponiveis.put(_MEDICAO_PRESSAO,ServicoMedTemp.class );
		servicosDisponiveis.put(_ALERTA_TEMPERATURA, ServicoAlertaTemperatura.class);
		servicosDisponiveis.put(_ALERTA_PERDA_CONEXAO, ServicoAlertaPerdaConexao.class);
		servicosDisponiveis.put(_MAQUINA_OFFLINE, ServicoMaquinaOffLine.class);
		servicosDisponiveis.put(_MAQUINA_ONLINE, ServicoMaquinaOnLine.class);
		servicosDisponiveis.put(_ERRO_INSERSORA, ServicoErroInsersora.class);
		servicosDisponiveis.put(_MEDICAO_CCK, ServicoMedCCK.class); 
		servicosDisponiveis.put(_CCK, ServicoMedCCK.class);
		servicosDisponiveis.put(_ALERTA_CONSUMO_ATIVO, ServicoAlertaEnergiaConsumida.class); // Criado por amaury em 11.11.14 para coleta cck
		servicosDisponiveis.put(_ALERTA_FATOR_DE_POTENCIA, ServicoAlertaFatorPotencia.class); // Criado por amaury em 11.11.14 para coleta cck
		servicosDisponiveis.put(_VALIDA_NUMERO_DE_SERIE, ServicoValidaNumeroDeSerie.class);
		servicosDisponiveis.put(_VALIDA_PASSAGEM, ServicoValidaNumeroDeSerie.class);
		servicosDisponiveis.put(_VERIFICA_REFUGO_TCP, ServicoValidaRefugoInovaSA.class);
		servicosDisponiveis.put(_VALIDA_REFUGO, ServicoValidaRefugoInovaSA.class);
		servicosDisponiveis.put(_CRIA_OP_AUTOMATICA, ServicoCriaOPAutomatica.class);
		servicosDisponiveis.put(_CRIA_OP_AUTOMATICA_STANDALONE, ServicoCriaOPAutomatica.class);
		servicosDisponiveis.put(_INOVASA_STARTUP, ServicoInovaSAStartUp.class);
		/*Andre 25/11/2015: Consulta proveniente do coletor INOVASA*/
		servicosDisponiveis.put(_CONSULTA_GENERICA_INOVASA, ServicoConsultaGenericaINOVASA.class);
		servicosDisponiveis.put(_CONSULTA_GENERICA, ServicoConsultaGenericaINOVASA.class);
		servicosDisponiveis.put(_INICIAR_CIP_INOVASA, ServicoIniciarCIPInovaSA.class);
		servicosDisponiveis.put(_FINALIZAR_CIP_INOVASA, ServicoFinalizarCIPInovaSA.class);
		servicosDisponiveis.put(_INICIO_VARIACAO_RITMO, ServicoIniciarVarRitmo.class);
		servicosDisponiveis.put(_MOTIVO_VARRITMO, ServicoInformaMotivoVarRitmo.class);
		servicosDisponiveis.put(_FIM_VARIACAO_RITMO, ServicoFinalizarVarRitmo.class);
		servicosDisponiveis.put(_VAZIO, ServicoVazioINova.class);
		// Ailton 2018-07-24: Servico de medicao de velocidade, e utilizado na coleta
		// de logs dos Fornors Heller da Flex
		servicosDisponiveis.put(_MEDICAO_VELOCIDADE, ServicoMedVelocidade.class);
		

		
	}
	
	public static ServicoFactory getInstancia() {
		if (instancia == null)
			instancia = new ServicoFactory();
		return instancia;
	}

	public void addCliente(ClienteRegistrado cliente) {
		this.clientesRegistrados.add(cliente);
	}

	public void updateCliente(ClienteRegistrado cliente) {
		boolean isExiste = false;
		for (ClienteRegistrado cr : clientesRegistrados){
			if (cr.getUrlConexao().contains(cliente.getUrlConexao())){
				isExiste = true;
				cr.setIp(cliente.getIp());
				cr.setPorta(cliente.getPorta());
				cr.setUpsDoIHM(cliente.getUpsDoIHM());
				cr.setSessaoWs(cliente.getSessaoWs());
				break;
			}
		}
		if (isExiste == false)
			this.clientesRegistrados.add(cliente);
	}

	public List<ClienteRegistrado> getClientesRegistrados() {
		return this.clientesRegistrados;
	}

	public IServico getServico(int idServico) {
		try {
			return (IServico) servicosDisponiveis.get(idServico).newInstance();
		} catch (Exception e) {
			 throw new RuntimeException("Nao foi possivel criar o servico: " + idServico);
		}
	}
	
	public IProtocoloNovo getProtocolo(int idServico) {
		try {
			return (IProtocoloNovo) servicosDisponiveis.get(idServico).newInstance();
		} catch (Exception e) {
			 throw new RuntimeException("Nao foi possivel criar o servico: " + idServico);
		}
	}

	/*
	 * Metodo para execucao de qualquer servico que chegue nele
	 */
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		// Verifica viabilidade de execucao do servico
		if (mensagem == null || mensagem.getEventoColetado() == null || mensagem.getEventoColetado().getIcUpDTO() == null || mensagem.getEventoColetado().getIcUpDTO().getUpDTO() == null){
			// Pode ser que mesmo nao tendo a identificacao da IcUp, o idUpPdba possa ter vindo,
			// Nesse caso, devemos passar adiante
			if (mensagem != null && mensagem.getEventoColetado().getIdUpPdba() != null &&  mensagem.getEventoColetado().getIdUpPdba().equals("") == false){
				log.info(idLog, identacao, "Servico " + mensagem.getDescricaoServico() + " Utilizando idUpPdba " + mensagem.getEventoColetado().getIdUpPdba());
			} else {
				log.info(idLog, identacao, "Servico " + mensagem.getDescricaoServico() + " Descartado - UP nao identificada.");
				log.info(idLog, identacao, "GETIDUPPBA = " + mensagem.getEventoColetado().getIdUpPdba() );
				log.info(idLog, identacao, "DESCARTOU SERVICO");
				mensagem = null;
				throw new ServicoFalhouException(new Exception());
			}
		}
		
		// Nao mostrar evento de heartbeat no log
		if (mensagem.getServico() != 18)
			log.info(idLog, identacao, "Chamando servico nro " + mensagem.getServico() + " ds=" + mensagem.getDescricaoServico());
		
		
		/* Nao se deve passar a sessao para o Servico a ser executado pq se deseja que o msevt seja
		 * comitado a fim de se esperar a consolidacao do mesmo
		 */
		mensagem.setIdLog(idLog);
		mensagem.setIdentacao(mensagem.getIdentacao() + 5); // aumenta identacao para melhorar a visualizacao dos logs do servico
		MsEvt msevt = getServico(mensagem.getServico()).executaServico(null, mensagem);
		
		// Esperar consolidacao do evento
		if (msevt != null && isEventoDeveEsperarRetorno(msevt)) {
			msevt = esperarConsolidacaoEvento(sessao, msevt, log, idLog);
		}
		return msevt;
	}
	
	private boolean isEventoDeveEsperarRetorno(MsEvt msevt) {
		if (msevt != null && msevt.getMsTpevt() != null) {
			Long idTpEvt = msevt.getMsTpevt().getIdTpevt(); 
			return	! idTpEvt.equals(MsTpevtTemplate.Type.FIM_CICLO.getIdLong()) &&
					! idTpEvt.equals(MsTpevtTemplate.Type.PERDA_MATERIA_PRIMA.getIdLong())
					// 2019-10-15 Ailton: Antes o servico IniciaNovaParada sempre retornava msevt=null, por isso,
					// seu isEventoDeveEsperarRetorno sempre retornou false. Agora que modifiquei ele para retornar
					// o msevt, acrescentei a linha abaixo para garantir que seu isEventoDeveEsperarRetorno continue
					// retornando false.
					&& ! idTpEvt.equals(MsTpevtTemplate.Type.INICIO_PARADA.getIdLong());
		}
		return false;
	}
	
	private MsEvt esperarConsolidacaoEvento(Session sessao, MsEvt msevt, IdwLogger log, int idLog) {
		DAOGenerico dao = new DAOGenerico();
		dao.setSession(sessao);
		
		if (sessao == null)
			log.info(idLog, 0, "Nao vou esperar consolidacao pq a sessao esta nula");
		
		int nTentativas = 0;
		while (sessao != null && msevt != null && msevt.getStEvt().equals(MsEvtTemplate.StEvt.PENDENTE.getValueBigDecimal()) ){
			msevt = dao.findById(MsEvt.class, msevt.getIdEvt(), false);
			UtilsThreads.pausaNaThread(1000);
			if (sessao != null)
				sessao.refresh(msevt);
			nTentativas++;
			if (nTentativas > 10) {
				log.info(idLog, 0, "Ultrapassou o timeout esperando consolidacao.");
				break;
			}
		}
		return msevt;
	}

	public boolean isClienteRegistrado(ClienteRegistrado cr) {
		// Se o cliente nao estiver registrado, registrar
		boolean isExisteRegistrado = false;
		for (ClienteRegistrado c : ServicoFactory.getInstancia().getClientesRegistrados()) {
			if (c.getUrlConexao().contains(cr.getUrlConexao()))
				isExisteRegistrado = true;
		}
		return isExisteRegistrado;
	}

	public int getQtClientesRegistrados() {
		return this.qtClienteRegistrados;
	}

	public void addClienteRegistrado() {
		this.qtClienteRegistrados++;
	}

	public int getQtCiclosEnviadosTodosClientes() {
		return this.qtCiclosEnviadosTodosClientes;
	}

	public void addQtCiclosEnviadosTodosClientes() {
		this.qtCiclosEnviadosTodosClientes++;
	}
}
