package ms.coleta.ic.inova.trataretorno;

import java.util.HashMap;
import java.util.Map;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.servico.ServicoFactory;

public class TrataRetornoFactory {
	
	private static TrataRetornoFactory instancia = null;
	
	@SuppressWarnings("unchecked")
	private Map<Integer, Class> tratadoresDisponiveis = new HashMap<Integer, Class>();
	
	public TrataRetornoFactory() {
		tratadoresDisponiveis.put(ServicoFactory._PRE_INICIALIZAR, TrataRetornoPreInicializacao.class);
		tratadoresDisponiveis.put(ServicoFactory._INICIALIZAR, TrataRetornoInicializacao.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_ORDEM_PRODUCAO, TrataRetornoValidarOrdemProducao.class);
		tratadoresDisponiveis.put(ServicoFactory._ENTRADA_OP_CONFIRMADA, TrataRetornoEntradaOpConfirmada.class);
		tratadoresDisponiveis.put(ServicoFactory._FINALIZACAO_OP_INOVA, TrataRetornoFinalizacaoOp.class);
		tratadoresDisponiveis.put(ServicoFactory._CICLO_INOVA, TrataRetornoCiclo.class);
		tratadoresDisponiveis.put(ServicoFactory._INICIO_PARADA_INOVA, TrataRetornoInicioParada.class);
		tratadoresDisponiveis.put(ServicoFactory._INFORMAR_PARADA_PRE_CONFIGURADA, TrataRetornoInfoParadaPreConfig.class);
		tratadoresDisponiveis.put(ServicoFactory._INFORMAR_MOTIVO_PARADA_INOVA, TrataRetornoInfoMotivoParada.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_MOTIVO_PARADA_INOVA, TrataRetornoValidarMotivoParada.class);
		tratadoresDisponiveis.put(ServicoFactory._INFORMAR_MOTIVO_PARADA_TODAS_INOVA, TrataRetornoInfoMotivoParadaTodas.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_PARADA_CAJ_INOVA, TrataRetornoValidarParadaCAJ.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_PARADA_TECNICOS_INOVA, TrataRetornoValidarParadaTecnicos.class);
		tratadoresDisponiveis.put(ServicoFactory._FIM_PARADA_INOVA, TrataRetornoFimParada.class);
		tratadoresDisponiveis.put(ServicoFactory._FAZER_REFUGO_INOVA, TrataRetornoFazerRefugo.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_REFUGO_INOVA, TrataRetornoValidarRefugo.class);
		tratadoresDisponiveis.put(ServicoFactory._CANCELAR_REFUGO_INOVA, TrataRetornoCancelarRefugo.class);
		tratadoresDisponiveis.put(ServicoFactory._ABRIR_ALERTA_INOVA, TrataRetornoAbrirAlerta.class);
		tratadoresDisponiveis.put(ServicoFactory._FECHAR_ALERTA_INOVA, TrataRetornoFecharAlerta.class);
		tratadoresDisponiveis.put(ServicoFactory._LOGIN_OPERADOR_INOVA, TrataRetornoLoginOperador.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_OPERADOR_INOVA, TrataRetornoValidarOperador.class);
		tratadoresDisponiveis.put(ServicoFactory._LOGOUT_OPERADOR_INOVA, TrataRetornoLogoutOperador.class);
		tratadoresDisponiveis.put(ServicoFactory._CONSULTA_INOVA, TrataRetornoConsulta.class);
		tratadoresDisponiveis.put(ServicoFactory._INICIAR_CIP_INOVA, TrataRetornoIniciarCip.class);
		tratadoresDisponiveis.put(ServicoFactory._FINALIZAR_CIP_INOVA, TrataRetornoFinalizarCip.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_LOGIN_FIM_CIP_INOVA, TrataRetornoValidarLoginFimCip.class);
		tratadoresDisponiveis.put(ServicoFactory._SOLICITAR_DADOS_INSPECAO_QUALIDADE1_INOVA, TrataRetornoSolDadosInspQualidade1.class);
		tratadoresDisponiveis.put(ServicoFactory._EXECUTAR_INSPECAO_QUALIDADE1_INOVA, TrataRetornoExecutarInspQualidade1.class);
		tratadoresDisponiveis.put(ServicoFactory._EXECUTAR_APONTAMENTO_ARAMADO_INOVA, TrataRetornoExecutarApntAramado.class);
		tratadoresDisponiveis.put(ServicoFactory._SOLICITAR_DADOS_INSPECAO_QUALIDADE2_INOVA, TrataRetornoSolDadosInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._SOLICITAR_INSPECAO_QUALIDADE2_INOVA, TrataRetornoSolInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._EXECUTAR_INSPECAO_QUALIDADE2_INOVA, TrataRetornoExecutarInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_INSPECAO_QUALIDADE2_INOVA, TrataRetornoValidarInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._ENVIAR_DNC_PARA_COLETOR_INOVA, TrataRetornoEnviarDncParaColetor.class);
		tratadoresDisponiveis.put(ServicoFactory._RECEBER_DNC_DE_COLETOR_INOVA, TrataRetornoReceberDncDeColetor.class);
		tratadoresDisponiveis.put(ServicoFactory._APOS_ENVIAR_DNC_PARA_COLETOR_INOVA, TrataRetornoAposEnviarDncParaColetor.class);
		tratadoresDisponiveis.put(ServicoFactory._SOLICITAR_ABERTURA_INSPECAO_QUALIDADE2_INOVA, TrataRetornoSolicitarAberturaInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._FECHAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA, TrataRetornoFecharAlertaProbInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._BUSCAR_ALERTA_PROBLEMA_INSPECAO_QUALIDADE2_INOVA, TrataRetornoBuscarAlertaProbInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_LOGIN_FECHAR_INSPECAO_QUALIDADE2_INOVA, TrataRetornoValidarLoginFecharInspQualidade2.class);
		tratadoresDisponiveis.put(ServicoFactory._ALTERAR_STATUS_APONTAMENTO_SAP_INOVA, TrataRetornoAlterarStatusApontSap.class);
		tratadoresDisponiveis.put(ServicoFactory._ALTERAR_QUANTIDADE_CARTAO_KANBAN_INOVA, TrataRetornoAlterarQuantidadeCartaoKanban.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_DADOS_SAP_INOVA, TrataRetornoValidarDadosSap.class);
		tratadoresDisponiveis.put(ServicoFactory._VALIDAR_CODIGO_MATERIA_PRIMA_INOVA, TrataRetornoValidarCodigoMateriaPrima.class);
		tratadoresDisponiveis.put(ServicoFactory._HEART_BEAT_INOVA, TrataRetornoHeartBeat.class);
		tratadoresDisponiveis.put(ServicoFactory._FALTA_MEMORIA_INOVA, TrataRetornoFaltaMemoria.class);
		tratadoresDisponiveis.put(ServicoFactory._PEGAR_INFORMACOES_MATERIA_PRIMA_INOVA, TrataRetornoPegarInfosMateriaPrima.class);
		tratadoresDisponiveis.put(ServicoFactory._CONFIRMAR_DADOS_INTEGRACAO_DOAL_INOVA, TrataRetornoConfirmarDadosIntegDoal.class);
	}
	
	public static TrataRetornoFactory getInstancia() {
		if(instancia == null) {
			instancia = new TrataRetornoFactory();
		}
		
		return(instancia);
	}
	
	public TrataRetorno getTratador(ParametroDTO parametro) {
		try {
			return((TrataRetorno) tratadoresDisponiveis.get(parametro.getTipoEvento()).newInstance());
		} catch (Exception e) {
			 throw new RuntimeException("Nao foi possivel criar o tratador resposta: " + parametro.getTipoEvento());
		}
	}
	
}
