package ms.coleta.ic.inova.trataevento;

import java.util.HashMap;
import java.util.Map;

public class TrataEventoFactory {
	
	/**
	 * EVENTOS DO COLETOR
	 */
	public static final int _PRE_INICIALIZAR = 0;
	public static final int _INICIALIZAR = 1;
	public static final int _VALIDAR_ORDEM_PRODUCAO = 2;
	public static final int _ENTRADA_OP_CONFIRMADA = 5;
	public static final int _FINALIZACAO_OP_INOVA = 6;
	public static final int _CICLO_INOVA = 7;
	public static final int _INICIO_PARADA_INOVA = 8;
	public static final int _INFORMAR_PARADA_PRE_CONFIGURADA = 81;
	public static final int _INFORMAR_MOTIVO_PARADA_INOVA = 9;
	public static final int _VALIDAR_MOTIVO_PARADA_INOVA = 91;
	public static final int _INFORMAR_MOTIVO_PARADA_TODAS_INOVA = 92;
	public static final int _VALIDAR_PARADA_CAJ_INOVA = 93;
	public static final int _VALIDAR_PARADA_TECNICOS_INOVA = 94;
	public static final int _FIM_PARADA_INOVA = 10;
	public static final int _FAZER_REFUGO_INOVA = 12;
	public static final int _VALIDAR_REFUGO_INOVA = 121;
	public static final int _CANCELAR_REFUGO_INOVA = 14;
	public static final int _ABRIR_ALERTA_INOVA = 15;
	public static final int _FECHAR_ALERTA_INOVA = 16;
	public static final int _LOGIN_OPERADOR_INOVA = 17;
	public static final int _VALIDAR_OPERADOR_INOVA = 171;
	public static final int _LOGOUT_OPERADOR_INOVA = 18;
	public static final int _CONSULTA_INOVA = 19;
	public static final int _INICIAR_CIP_INOVA = 26;
	public static final int _FINALIZAR_CIP_INOVA = 27;
	public static final int _VALIDAR_LOGIN_FIM_CIP_INOVA = 271;
	public static final int _SOLICITAR_DADOS_INSPECAO_QUALIDADE1_INOVA = 28;
	public static final int _EXECUTAR_INSPECAO_QUALIDADE1_INOVA = 29;
	public static final int _EXECUTAR_APONTAMENTO_ARAMADO_INOVA = 30;
	public static final int _SOLICITAR_DADOS_INSPECAO_QUALIDADE2_INOVA = 31;
	public static final int _SOLICITAR_INSPECAO_QUALIDADE2_INOVA = 311;
	public static final int _EXECUTAR_INSPECAO_QUALIDADE2_INOVA = 32;
	public static final int _VALIDAR_INSPECAO_QUALIDADE2_INOVA = 321;
	public static final int _ENVIAR_DNC_PARA_COLETOR_INOVA = 35;
	public static final int _RECEBER_DNC_DE_COLETOR_INOVA = 36;
	public static final int _ABRIR_PORTAS_DNC_INOVA = 37;
	public static final int _APOS_ENVIAR_DNC_PARA_COLETOR_INOVA = 38;
	public static final int _SOLICITAR_ABERTURA_INSPECAO_QUALIDADE2_INOVA = 41;
	public static final int _FECHAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA = 42;
	public static final int _BUSCAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA = 421;
	public static final int _VALIDAR_LOGIN_FECHAR_INSPECAO_QUALIDADE2_INOVA = 422;
	public static final int _ALTERAR_STATUS_APONTAMENTO_SAP_INOVA = 43;
	public static final int _ALTERAR_QUANTIDADE_CARTAO_KANBAN_INOVA = 44;
	public static final int _VALIDAR_DADOS_SAP_INOVA = 45;
	public static final int _VALIDAR_CODIGO_MATERIA_PRIMA_INOVA = 451;
	public static final int _HEART_BEAT_INOVA = 66;
	public static final int _FALTA_MEMORIA_INOVA = 666;
	public static final int _PEGAR_INFORMACOES_MATERIA_PRIMA_INOVA = 998;
	public static final int _CONFIRMAR_DADOS_INTEGRACAO_DOAL_INOVA = 999;
	
	
	private static TrataEventoFactory instancia = null;
	
	@SuppressWarnings("unchecked")
	private Map<Integer, Class> tratadoresDisponiveis = new HashMap<Integer, Class>();
	
	public TrataEventoFactory() {
		tratadoresDisponiveis.put(_PRE_INICIALIZAR, TrataEventoPreInicializacao.class);
		tratadoresDisponiveis.put(_INICIALIZAR, TrataEventoInicializacao.class);
		tratadoresDisponiveis.put(_VALIDAR_ORDEM_PRODUCAO, TrataEventoValidarOrdemProducao.class);
		tratadoresDisponiveis.put(_ENTRADA_OP_CONFIRMADA, TrataEventoEntradaOpConfirmada.class);
		tratadoresDisponiveis.put(_FINALIZACAO_OP_INOVA, TrataEventoFinalizacaoOp.class);
		tratadoresDisponiveis.put(_CICLO_INOVA, TrataEventoCiclo.class);
		tratadoresDisponiveis.put(_INICIO_PARADA_INOVA, TrataEventoInicioParada.class);
		tratadoresDisponiveis.put(_INFORMAR_PARADA_PRE_CONFIGURADA, TrataEventoInfoParadaPreConfig.class);
		tratadoresDisponiveis.put(_INFORMAR_MOTIVO_PARADA_INOVA, TrataEventoInfoMotivoParada.class);
		tratadoresDisponiveis.put(_VALIDAR_MOTIVO_PARADA_INOVA, TrataEventoValidarMotivoParada.class);
		tratadoresDisponiveis.put(_INFORMAR_MOTIVO_PARADA_TODAS_INOVA, TrataEventoInfoMotivoParadaTodas.class);
		tratadoresDisponiveis.put(_VALIDAR_PARADA_CAJ_INOVA, TrataEventoValidarParadaCAJ.class);
		tratadoresDisponiveis.put(_VALIDAR_PARADA_TECNICOS_INOVA, TrataEventoValidarParadaTecnicos.class);
		tratadoresDisponiveis.put(_FIM_PARADA_INOVA, TrataEventoFimParada.class);
		tratadoresDisponiveis.put(_FAZER_REFUGO_INOVA, TrataEventoFazerRefugo.class);
		tratadoresDisponiveis.put(_VALIDAR_REFUGO_INOVA, TrataEventoValidarRefugo.class);
		tratadoresDisponiveis.put(_CANCELAR_REFUGO_INOVA, TrataEventoCancelarRefugo.class);
		tratadoresDisponiveis.put(_ABRIR_ALERTA_INOVA, TrataEventoAbrirAlerta.class);
		tratadoresDisponiveis.put(_FECHAR_ALERTA_INOVA, TrataEventoFecharAlerta.class);
		tratadoresDisponiveis.put(_LOGIN_OPERADOR_INOVA, TrataEventoLoginOperador.class);
		tratadoresDisponiveis.put(_VALIDAR_OPERADOR_INOVA, TrataEventoValidarOperador.class);
		tratadoresDisponiveis.put(_LOGOUT_OPERADOR_INOVA, TrataEventoLogoutOperador.class);
		tratadoresDisponiveis.put(_CONSULTA_INOVA, TrataEventoConsulta.class);
		tratadoresDisponiveis.put(_INICIAR_CIP_INOVA, TrataEventoIniciarCip.class);
		tratadoresDisponiveis.put(_FINALIZAR_CIP_INOVA, TrataEventoFinalizarCip.class);
		tratadoresDisponiveis.put(_VALIDAR_LOGIN_FIM_CIP_INOVA, TrataEventoValidarLoginFimCip.class);
		tratadoresDisponiveis.put(_SOLICITAR_DADOS_INSPECAO_QUALIDADE1_INOVA, TrataEventoSolDadosInspQualidade1.class);
		tratadoresDisponiveis.put(_EXECUTAR_INSPECAO_QUALIDADE1_INOVA, TrataEventoExecutarInspQualidade1.class);
		tratadoresDisponiveis.put(_EXECUTAR_APONTAMENTO_ARAMADO_INOVA, TrataEventoExecutarApntAramado.class);
		tratadoresDisponiveis.put(_SOLICITAR_DADOS_INSPECAO_QUALIDADE2_INOVA, TrataEventoSolDadosInspQualidade2.class);
		tratadoresDisponiveis.put(_SOLICITAR_INSPECAO_QUALIDADE2_INOVA, TrataEventoSolInspQualidade2.class);
		tratadoresDisponiveis.put(_ENVIAR_DNC_PARA_COLETOR_INOVA, TrataEventoEnviarDncParaColetor.class);
		tratadoresDisponiveis.put(_RECEBER_DNC_DE_COLETOR_INOVA, TrataEventoReceberDncDeColetor.class);
	//	tratadoresDisponiveis.put(_ABRIR_PORTAS_DNC_INOVA, TrataEventoAbrirPortasDnc.class);
		tratadoresDisponiveis.put(_APOS_ENVIAR_DNC_PARA_COLETOR_INOVA, TrataEventoAposEnviarDncParaColetor.class);
		tratadoresDisponiveis.put(_SOLICITAR_ABERTURA_INSPECAO_QUALIDADE2_INOVA, TrataEventoSolicitarAberturaInspQualidade2.class);
		tratadoresDisponiveis.put(_FECHAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA, TrataEventoFecharAlertaProbInspQualidade2.class);
		tratadoresDisponiveis.put(_BUSCAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA, TrataEventoBuscarAlertaProbInspQualidade2.class);
		tratadoresDisponiveis.put(_VALIDAR_LOGIN_FECHAR_INSPECAO_QUALIDADE2_INOVA, TrataEventoValidarLoginFecharInspQualidade2.class);
		tratadoresDisponiveis.put(_ALTERAR_STATUS_APONTAMENTO_SAP_INOVA, TrataEventoAlterarStatusApontSap.class);
		tratadoresDisponiveis.put(_ALTERAR_QUANTIDADE_CARTAO_KANBAN_INOVA, TrataEventoAlterarQuantidadeCartaoKanban.class);
		tratadoresDisponiveis.put(_VALIDAR_DADOS_SAP_INOVA, TrataEventoValidarDadosSap.class);
		tratadoresDisponiveis.put(_VALIDAR_CODIGO_MATERIA_PRIMA_INOVA, TrataEventoValidarCodigoMateriaPrima.class);
		tratadoresDisponiveis.put(_HEART_BEAT_INOVA, TrataEventoHeartBeat.class);
		tratadoresDisponiveis.put(_PEGAR_INFORMACOES_MATERIA_PRIMA_INOVA, TrataEventoPegarInfosMateriaPrima.class);
		tratadoresDisponiveis.put(_CONFIRMAR_DADOS_INTEGRACAO_DOAL_INOVA, TrataEventoConfirmarDadosIntegDoal.class);
	}
	
	public static TrataEventoFactory getInstancia() {
		if(instancia == null)
			instancia = new TrataEventoFactory();
		
		return(instancia);
	}
	
	public TrataEvento getTratador(int tipoEvento) {
		try {
			return((TrataEvento) tratadoresDisponiveis.get(tipoEvento).newInstance());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Nao foi possivel criar o tratador: " + tipoEvento);
		}
	}
}
