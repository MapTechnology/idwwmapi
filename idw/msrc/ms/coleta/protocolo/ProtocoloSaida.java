package ms.coleta.protocolo;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.pojos.MsPerfilregras;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.DadosProdutoSADTO;
import injetws.model.IwsFacade;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpProduto;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsListaAlertaDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.IcUpDTO;
import ms.model.dto.MSalertaDTO;
import ms.model.dto.UsuarioMSDTO;
import ms.model.rn.UpRN;
import ms.util.UtilsString;

public class ProtocoloSaida  extends ProtocoloSaidaFactory{
	private static String _RECEBIDO_COM_SUCESSO = "rs#";
	private static String _ID_UP = "up=";
	// private static String _INICIO_CICLO = "iniciociclo=";
	private static String _FINAL_CICLO = "finalciclo=";
	private static String _INICIO_PARADA = "inicioparada=";
	// private static String _FINAL_PARADA = "finalparada=";
	private static String _RELE = "rele=";
	private static String _ATIVO = "ativo=";
	private static String _INTERMITENCIA = "pisca=";
	private static String _TEMPO_LIGADO = "tmpalto=";
	private static String _TEMPO_DESLIGADO = "tmpbaixo=";
	private static String _FIM_CONFIG_RELE = "fimrele#";
	private static String _LISTA_RELES = "listarele=";
	private static String _QUANTIDADE = "qtd=";
	private static String _OP = "op=";
	private static String _CD_PRODUTO = "cdproduto=";
	private static String _CD_FOLHA = "cdfolha=";
	private static String _ID_FOLHA = "idfolha=";
	private static String _CICLO_PADRAO = "ciclopadrao=";
	private static String _CICLO_MEDIO = "ciclomedio=";
	private static String _CICLO_TIMEOUT = "ciclotimeout=";
	private static String _CICLO_MINIMO = "ciclominimo=";
	private static String _TIMEOUT_CIP = "timeoutcip=";
	private static String _QUANTIDADE_POR_CICLO = "qtdporciclo=";
	private static String _PROD_LIQ = "prodliq=";
	private static String _EFI_REAL = "efireal=";
	private static String _PROD_REF = "prodref=";
	private static String _INDI_REF = "indiref=";
	private static String _INDI_PAR_TURNO = "indipartur=";
	private static String _INDI_PAR_OP = "indiparop=";
	private static String _EFI_CIC_TURNO = "eficictur=";
	private static String _EFI_CIC_OP = "eficicop=";
	private static String _DS_TURNO = "dsturno=";
	private static String _PROD_OEE = "prodoee=";
	private static String _META_OEE = "metaoee=";
	private static String _A_PRODUZIR = "aproduzir=";
	private static String _INTERVALO_HR = "intervalohr=";
	private static String _IND_QLD = "indqld=";
	private static String _IND_UTL = "indutl=";
	private static String _IND_EFC = "indefc=";
	private static String _QTD_PROD = "qtdprod=";
	private static String _PROD = "prod";
//	private static String _PROD_CD = "prodcd";
	private static String _PROD_IDRDZ = "prodidrdz";
	private static String _PROD_QTDPORCICLO = "prodqtdporciclo";
	private static String _IS_CIP = "iscip=";
	private static String _DTHR = "dthr=";
	private static String _DURATION = "duration=";
	
	// Ailton 2019-08-06: modificacao para permitir a consulta no perfil do andon
	public static final String _CD_PERFIL_ANDON = "CDPERFILANDON=";
	public static final String _ID_PERFIL_REGRAS_ANDON = "IDPERFILREGRAS=";
	public static final String _PORTA_ANDON = "PORTAANDON=";
	public static final String _PRIORIDADE_PORTA_ANDON = "PRIORIDADEPORTAANDON=";
	public static final String _SEG_TEMPO_ALTO_ANDON = "SEGTEPOALTOANDON=";
	public static final String _SEG_TEMPO_BAIXO_ANDON = "SEGTEMPOBAIXOANDON=";
	public static final String _IS_PISCANTE_ANDON = "ISPISCANTEANDON=";
	public static final String _TP_SAIDA_ANDON = "TPSAIDAANDON=";
	public static final String _TP_MOTIVO_ANDON = "TPMOTIVOANDON=";
	public static final String _SINAL_MOTIVO_ANDON = "SINALMOTIVOANDON=";
	public static final String _VL_MOTIVO_ANDON = "VLMOTIVOANDON=";
	public static final String _SEG_TOLERANCIA_ANDON = "SEGTOLERANCIAANDON=";
	
	public static final String _REFUGO_APAGADO_COM_SUCESSO = "REFMSG1#";
	public static final String _ERRO_APAGAR_REFUGO = "REFMSG2#";
	public static final String _RESPOSTA = "resposta=";
	public static final String _PRINT_RESPOSTA = "tiporesp=0#";
	public static final String _DISMISS_DIALOG_LOGIN = "tiporesp=1#";
	public static final String _DISMISS_DIALOG_ALERTA = "tiporesp=2#";
	public static final String _DISMISS_DIALOG_REFUGO = "tiporesp=4#";
	public static final String _DISMISS_DIALOG_PARADA = "tiporesp=5#";
	public static final String _SETAR_BC_OFFLINE = "tiporesp=3#";
	public static final String _ACTION_SESSION = "ac=7#";
	public static final String _ACTION_RESPOSTA = "ac=21#";
	public static final String _ACTION_CONSULTA = "ac=22#";

	public static final String _ACTION_VALIDA_REFUGO = "ac=23#";
	public static final String _ACTION_VALIDA_PARADA = "ac=24#";
	public static final String _LOGIN_EM_ABERTO = "LOGINMSG1#";
	public static final String _LOGIN_SUCESSO = "LOGINMSG2#";
	public static final String _LOGIN_FALHA = "LOGINMSG3#";
	public static final String _LOGOUT_SUCESSO = "LOGOUTMSG1#";
	public static final String _LOGOUT_FALHA = "LOGOUTMSG2#";
	public static final String _ALERTA_INICIADA_SUCESSO = "ALERTAIMSG1#";
	public static final String _ALERTA_INICIADA_FALHA = "ALERTAIMSG2#";
	public static final String _ALERTA_PARADA_SUCESSO = "ALERTAPMSG1#";
	public static final String _ALERTA_PARADA_FALHA = "ALERTAPMSG2#";
	public static final String _CONSULTA_FALHA = "CONSULTAMSG1#";
	public static final String _BC_OFFLINE = "BCOFFLINEMSG1#";
	public static final String _REFUGO_INVALIDO = "VALIDAREFMSG1#";
	public static final String _REFUGO_SUCESSO = "NOVOREFMSG1#";
	public static final String _REFUGO_FALHA = "NOVOREFMSG2#";
	public static final String _VALIDA_PARADA_FALHA = "VALIDAPARADAMSG1#";
	public static final String _INFORMA_MOTIVO_PARADA_SUCESSO = "PARADAMSG1#";
	public static final String _INFORMA_MOTIVO_PARADA_FALHA = "PARADAMSG2#";
	public static final String _NOVA_OP_SUCESSO = "NOVAOPMSG1#";
	public static final String _NOVA_OP_FALHA = "NOVAOPMSG2#";
	public static final String _FINALIZAOP_SUCESSO = "FINALIZAOPMSG1#";
	public static final String _FINALIZAOP_FALHA = "FINALIZAOPMSG2#";
	public static final String _IHM_DESCONHECIDO = "IHMDESCONHECIDOMSG1#";
	public static final String _SERVICO_FALHOU = "SERVICOFALHOUMSG1#";
	public static final String _FINALIZAPARADA_SUCESSO = "FINALIZAPARADAMSG1#";
	public static final String _FINALIZAPARADA_FALHA = "FINALIZAPARADAMSG2#";
	public static final String _PARADA_ACAO_INVALIDA = "PARADAACAOINVALIDA=1#";
	public static final String _PARADA_CAUSA_INVALIDA = "PARADACAUSAINVALIDA=1#";
	public static final String _PARADA_JUST_INVALIDA = "PARADAJUSTINVALIDA=1#";
	public static final String _PARADA_TEC1_INVALIDA = "PARADATEC1INVALIDA=1#";
	public static final String _PARADA_TEC2_INVALIDA = "PARADATEC2INVALIDA=1#";
	public static final String _PARADA_TEC_RESP_INVALIDA = "PARADATECRESPINVALIDA=1#";
	public static final String _NUMERO_DE_SERIE_VALIDO = "NSOK#";
	public static final String _NUMERO_DE_SERIE_INVALIDO = "NSFAIL#";
	public static final String _NUMERO_DE_SERIE_VALIDO_N = "NSOKPFAIL#";
	public static final String _REFUGO_VALIDO = "REFOK#";
	public static final String _REFUGO_NAO_VALIDO = "REFFAIL#";
	public static final String _NUMERO_DE_SERIE_INVALIDO_ROTEIRO = "NSFAILROT#";
	public static final String _REQUER_QUANTIDADE = "REQQNT#";
	public static final String _REQUER_QUANTIDADE_REFUGO = "REFREQQNT#";
	public static final String _REFUGO_PRODUTO_JA_REFUGADO = "REFFAILJAREF#";
	public static final String _NUMERO_DE_SERIE_REFUGADO = "NSREFUGADO#";
	public static final String _CRIA_OP_AUTOMATICA_FAIL = "CRIAOPAUTOFAIL#";
	public static final String _CRIA_OP_AUTOMATICA_OK = "CRIAOPAUTOOK#";
	public static final String _CONSULTA_OK_INOVASA = "CONSULTAOK#";
	public static final String _CONSULTA_FAIL = "CONSULTAFAIL#";

	@Override
	public String parsePacoteDeTransferencia(MensagemEnviada mensagem) {
		StringBuilder retorno = new StringBuilder();
		
		// construir mensagem a ser enviada para o Ihm
		if (mensagem.getMsDTO() != null) {
			String retorno2 = construirMensagemSessao(mensagem);
			return retorno2;
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._LOGIN ){
			return construirMsgLogin(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._LOGOUT){
			return construirMsgLogout(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._INICIA_ALERTA ){
			return construirMsgIniciaAlerta(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._REMOVE_ALERTA ){
			return construirMsgParadaAlerta(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._CONSULTA ){
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				return construirMsgConsulta(mensagem);
			else
				return construirMsgConsultaINOVASA(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._APAGAULTIMOREFUGO ){
			return construirMsgApagaUltimoRefugo(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._VALIDAREFUGO ){
			retorno.append(construirMsgValidaRefugo(mensagem));
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._NOVOREFUGO ){
			return construirMsgNovoRefugo(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._VALIDAPARADA ){
			return construirMsgValidaParada(mensagem);
		}

		if (mensagem.getMensagemRecebida().getServico() == ServicoFactory._NOVA_OP){
			return construirMsgNovaOP(mensagem);
		}

		if(mensagem.getMensagemRecebida().getServico() == ServicoFactory._FINALIZA_OP) {
			return construirMsgFinalizaOP(mensagem);
		}

		if(mensagem.getMensagemRecebida().getServico() == ServicoFactory._FINALIZA_PARADA){
			return construirMsgFinalizaParada(mensagem);
		}

		if(mensagem.getMensagemRecebida().getServico() == ServicoFactory._MOTIVO_PARADA && mensagem.isFlagParada() || mensagem.getMensagemRecebida().getServico() == ServicoFactory._INFORMA_MOTIVO_PARADA || mensagem.isFlagParada() ){
			return construirMsgCorrigeParada(mensagem);
		}

		if(mensagem.getMensagemRecebida().getServico() == ServicoFactory._VALIDA_NUMERO_DE_SERIE){
			return construirMsgValidaNumeroSerie(mensagem);
		}		

		if(mensagem.getMensagemRecebida().getServico() == ServicoFactory._VERIFICA_REFUGO_TCP){
			return construirMsgValidaRefugoInovaSA(mensagem);
		}
		
		if(mensagem.getMensagemRecebida().getServico() == ServicoFactory._CRIA_OP_AUTOMATICA){
			return construirMsgCriaOPAutomatica(mensagem);
		}
		
		if(mensagem.getMensagemRecebida().getServico() == ServicoFactory._CONSULTA_GENERICA_INOVASA){
			return construirMsgConsultaINOVASA(mensagem);
		}
		
		if(mensagem.isIhmDesconhecido()){
			return construirMsgIhmDesconhecido(mensagem);
		}

		if (mensagem.isRecebidoComSucesso() == true)
			retorno.append(_RECEBIDO_COM_SUCESSO);

		if (mensagem.getMensagemRecebida() != null && mensagem.getMensagemRecebida().getIp() != null)
			retorno.append(mensagem.getMensagemRecebida().getIp());

		if (mensagem.getMensagemRecebida().getEventoColetado() == null) {
			// No momento apenas a mensagem do tipo motivo parada entra nesse if
			retorno.append(mensagem.getMensagemRecebida());
		} else {

			if (mensagem.getMensagemRecebida().getEventoColetado().getTipoEvento() == ServicoFactory._FIM_CICLO) {
				retorno.append(_FINAL_CICLO);
				retorno.append(mensagem.getMensagemRecebida().getEventoColetado().getDthrEventoFormatadoParaEnvio());
				retorno.append("#");
			}
			if (mensagem.getMensagemRecebida().getEventoColetado().getTipoEvento() == ServicoFactory._INICIO_PARADA) {
				retorno.append(_INICIO_PARADA);
				retorno.append(mensagem.getMensagemRecebida().getEventoColetado().getDthrEventoFormatadoParaEnvio());
				retorno.append("#");
			}
			if (mensagem.getMensagemRecebida().getEventoColetado().getTipoEvento() == ServicoFactory._FIM_PARADA) {
				retorno.append("FINALIZAPARADA=");
				retorno.append(mensagem.getMensagemRecebida().getEventoColetado().getDthrEventoFormatadoParaEnvio());
				retorno.append("#");
			}

			// Informa qual a UP
			if (mensagem.getMensagemRecebida().getEventoColetado().getIcUpDTO() == null || mensagem.getMensagemRecebida().getEventoColetado().getIcUpDTO().getUpDTO() == null) {
				retorno.append(_ID_UP);
				retorno.append(" desconhecida#");
			} else {
				retorno.append(_ID_UP);
				retorno.append(mensagem.getMensagemRecebida().getEventoColetado().getIcUpDTO().getUpDTO().getIdUpPDBA());
				retorno.append("#");
			}
		}

		// Enviar a data e hora atual para que o ihm possa atualizar a hora
		retorno.append("dthratual=");
		retorno.append(DataHoraRN.getDataHoraAtualFormatada());
		retorno.append("#");

		return retorno.toString();
	}

	public static String parsePacoteDeTransferenciaAndon(
			List<ParametroDTO> listaParametros) {
		StringBuilder retorno = new StringBuilder();

		retorno.append(_LISTA_RELES);
		retorno.append(String.valueOf(listaParametros.size()));
		retorno.append("#");

		for (ParametroDTO parametro : listaParametros) {
			retorno.append(_RELE);
			retorno.append(String.valueOf(parametro.getNrIcDO()));
			retorno.append("#");
			retorno.append(_ATIVO);
			retorno.append(String.valueOf(parametro.getStAtivo()));
			retorno.append("#");
			retorno.append(_INTERMITENCIA);
			retorno.append(String.valueOf(parametro.getStPiscando()));
			retorno.append("#");
			retorno.append(_TEMPO_LIGADO);
			retorno.append(String.valueOf(parametro.getTempoOn()));
			retorno.append("#");
			retorno.append(_TEMPO_DESLIGADO);
			retorno.append(String.valueOf(parametro.getTempoOff()));
			retorno.append("#");
			retorno.append(_FIM_CONFIG_RELE);
		}

		return retorno.toString();
	}

	private static String construirMsgIhmDesconhecido(MensagemEnviada mensagem){
		String retorno = "";


		retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _IHM_DESCONHECIDO;

		return retorno;
	}

	private static String construirMsgCorrigeParada(MensagemEnviada mensagem){
		String retorno = "";
		if(mensagem.isMotivoParada()){
			if (mensagem.isFlagmotivoparada()){
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _INFORMA_MOTIVO_PARADA_SUCESSO;
			}else{
				retorno = _ACTION_RESPOSTA + _DISMISS_DIALOG_PARADA + _RESPOSTA + _INFORMA_MOTIVO_PARADA_SUCESSO;
			}
		}else{
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _INFORMA_MOTIVO_PARADA_FALHA + construirMsgCorrigeParadaErro(mensagem);
		}
		return retorno;
	}

	private static String construirMsgCorrigeParadaErro(MensagemEnviada mensagem){
		String retorno = "";
		if (!mensagem.isAcaovalida()){
			retorno += _PARADA_ACAO_INVALIDA;
		}

		if (!mensagem.isCausavalida()){
			retorno += _PARADA_CAUSA_INVALIDA;
		}

		if (!mensagem.isJustvalida()){
			retorno += _PARADA_JUST_INVALIDA;
		}

		if(!mensagem.isTecnico1valido()){
			retorno += _PARADA_TEC1_INVALIDA;
		}

		if(!mensagem.isTecnico2valido()){
			retorno += _PARADA_TEC2_INVALIDA;
		}

		if(!mensagem.isTecnicoResponsavelValido()){
			retorno += _PARADA_TEC_RESP_INVALIDA;
		}

		return retorno;
	}

	private static String construirMsgConsulta(MensagemEnviada mensagem){
		String retorno;

		if(mensagem.getConsulta() != null){
			if (mensagem.getConsulta().getResposta()){
				retorno = _ACTION_CONSULTA + construirMsgResultadoConsulta(mensagem.getConsulta());
			}else{
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _CONSULTA_FALHA;
			}
		}else{
			retorno = _ACTION_RESPOSTA + _SETAR_BC_OFFLINE + _RESPOSTA + _BC_OFFLINE;
		}
		return retorno;

	}

	private static String construirMsgResultadoConsulta(IwsConsultaDTO c){
		StringBuilder msg = new StringBuilder();
		msg.append("r1=" + c.getCampoRSP1() + "#");
		msg.append("r2=" + c.getCampoRSP2() + "#");
		msg.append("r3=" + c.getCampoRSP3() + "#");
		msg.append("r4=" + c.getCampoRSP4() + "#");
		msg.append("r5=" + c.getCampoRSP5() + "#");
		msg.append("r6=" + c.getCampoRSP6() + "#");
		msg.append("r7=" + c.getCampoRSP7() + "#");
		msg.append("r8=" + c.getCampoRSP8() + "#");

		return msg.toString();
	}

	private static String construirMsgParadaAlerta(MensagemEnviada mensagem){
		String retorno;
		if(mensagem.isAlertaParada()){
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _ALERTA_PARADA_SUCESSO;
		}else{
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _ALERTA_PARADA_FALHA;
		}
		return retorno;
	}

	private static String construirMsgValidaParada(MensagemEnviada mensagem){
		String retorno;

		if(mensagem.getParada() != null){
			retorno = _ACTION_VALIDA_PARADA +  construirMsgResultadoParada(mensagem.getParada(), mensagem.isFlagmotivoparada());
		}else{
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _VALIDA_PARADA_FALHA;
		}
		return retorno;
	}

	private static String construirMsgNovaOP(MensagemEnviada mensagem){
		String retorno;

		if(mensagem.getCp() != null){
			if (mensagem.getCp().getIsSGBDOnline()){

				if(mensagem.getCp().getIsProducaoValida()){
					retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _NOVA_OP_SUCESSO;
				}else{
					//Comentado esse trecho devido a mensagem de resopsta n�o mostrar a falha para o IHM, apenas um c�digo
					//O Tablet Android espera apenas receber uma TAG: NOVAOPMSG1 ou NOVAOPMSG2 
					//retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + mensagem.getCp().getTxtMensagem() + "#";
					retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _NOVA_OP_FALHA;
				}


			}else{
				retorno = _ACTION_RESPOSTA + _SETAR_BC_OFFLINE + _RESPOSTA + mensagem.getCp().getTxtMensagem() + "#";
			}
		}else{
			retorno =  _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _NOVA_OP_FALHA;
		}
		return retorno;
	}

	private static String construirMsgFinalizaOP(MensagemEnviada mensagem) {
		String retorno = null;

		retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _FINALIZAOP_FALHA;

		if(mensagem != null) {
			if(mensagem.isOpfinalizada()) {
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _FINALIZAOP_SUCESSO;
			}
		}

		return retorno;
	}

	private static String construirMsgFinalizaParada(MensagemEnviada mensagem) {
		String retorno = null;

		retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _FINALIZAPARADA_FALHA;

		if(mensagem != null) {
			if(mensagem.isParadaFinalizada()) {
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _FINALIZAPARADA_SUCESSO;
			}
		}

		return retorno;
	}
	
	private static String construirMsgNovoRefugo(MensagemEnviada mensagem){
		String retorno;

		if(mensagem.getRefugo() != null){
			if (mensagem.getRefugo().getIsRefugoValido()){
				retorno = _ACTION_RESPOSTA + _DISMISS_DIALOG_REFUGO + _RESPOSTA + _REFUGO_SUCESSO;
			}else{
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _REFUGO_FALHA;
			}
		}else{
			retorno = _ACTION_RESPOSTA + _SETAR_BC_OFFLINE + _RESPOSTA + _BC_OFFLINE;
		}
		return retorno;
	}

	private static String construirMsgValidaRefugo(MensagemEnviada mensagem){
		String retorno;

		if(mensagem.getRefugo() != null){
			if (mensagem.getRefugo().getIsRefugoValido()){
				retorno = _ACTION_VALIDA_REFUGO + construirMsgResultadoRefugo(mensagem.getRefugo());
			}else{
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _REFUGO_INVALIDO;
			}
		}else{
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _REFUGO_INVALIDO;
		}
		return retorno;
	}

	private static String construirMsgValidaNumeroSerie(MensagemEnviada mensagem) {
		String retorno = null;
		switch(mensagem.getNSValido()){
		case 1:
			retorno = _NUMERO_DE_SERIE_VALIDO;
			break;
		case 2:
			retorno = _NUMERO_DE_SERIE_VALIDO_N;
			break;
		case 3:
			retorno = _NUMERO_DE_SERIE_INVALIDO_ROTEIRO;
			break;
		case 4:
			retorno = _REQUER_QUANTIDADE;
			break;
		case 5:
			retorno = _NUMERO_DE_SERIE_REFUGADO;
			break;
		default:
			retorno = _NUMERO_DE_SERIE_INVALIDO;
			break;
		}

		char stx = (char) 0x02;
		char etx = (char) 0x03;
		retorno=stx+retorno+etx;	

		return retorno;
	}

	private static String construirMsgValidaRefugoInovaSA(MensagemEnviada mensagem)
	{
		String retorno = null;

		if(mensagem.getNSValido() == 5) {
			retorno = _REFUGO_PRODUTO_JA_REFUGADO;
		} else {
			if(mensagem.isRefugoValido()==true){
				if(mensagem.getNSValido() == 4){
					retorno = _REQUER_QUANTIDADE_REFUGO;
				}
				else {
					retorno = _REFUGO_VALIDO;
				}
			} else{
				retorno = _REFUGO_NAO_VALIDO;
			}
		}

		char stx = (char) 0x02;
		char etx = (char) 0x03;
		retorno=stx+retorno+etx;	

		return retorno;
	}
	
	private static String construirMsgCriaOPAutomatica(MensagemEnviada mensagem) {
		String retorno = null;

		if(mensagem.isOpCriadaComSucesso() == true) {
			//STxOPCRIAAUTOOK# op=001# qtd=100.0000# cdproduto=20150064# ciclopadrao=30.0# qtdporciclo=2.0#ETX
			String status = _CRIA_OP_AUTOMATICA_OK;
			String op = _OP + mensagem.getNrOp() + "#";
			String qtde = _QUANTIDADE + mensagem.getQtd() + "#";
			String cdProduto = _CD_PRODUTO + mensagem.getCdProduto() + "#";
			String cdFolha = _CD_FOLHA + mensagem.getCdFolha() + "#";
			String idFolha = _ID_FOLHA + mensagem.getIdFolha() + "#";
			String cicloPadrao = _CICLO_PADRAO + mensagem.getCicloPadrao() + "#";
			String cicloTimeout = _CICLO_TIMEOUT + mensagem.getCicloTimeout() + "#";
			String cicloMinimo = _CICLO_MINIMO + mensagem.getCicloMinimo() + "#";
			String qtdePorCiclo = _QUANTIDADE_POR_CICLO + mensagem.getQtdPorCiclo() + "#";
			String timeoutCIP = _TIMEOUT_CIP + mensagem.getTimeoutCIP() + "#";
			
			String prod = "";
			int i =0;
			for(DadosProdutoSADTO prodDTO : mensagem.getListaProdutosDTO()) {
				i++;
				if(prodDTO.getCdProduto() == null) {
					continue;
				}
				prod += _PROD + i + "=" + prodDTO.getCdProduto() + "#";
				if(prodDTO.getQtAtiva() != null)
					prod += _PROD_QTDPORCICLO + i + "=" + prodDTO.getQtAtiva().longValue() + "#";
				if(prodDTO.getIdredzproduto() != null)
					prod += _PROD_IDRDZ + i + "=" + (char)(prodDTO.getIdredzproduto() & 0xFF) + "#";
				
			}
			String qtdeProd = _QTD_PROD + i + "#";
			retorno = status + op + qtde + cdProduto + cdFolha + idFolha + cicloPadrao + cicloTimeout + cicloMinimo + timeoutCIP + qtdePorCiclo + qtdeProd + prod;
		} else {
			retorno = _CRIA_OP_AUTOMATICA_FAIL;
		}

		char stx = (char) 0x02;
		char etx = (char) 0x03;
		retorno=stx+retorno+etx;	

		return retorno;
	}
	
	private static String construirMsgConsultaINOVASA(MensagemEnviada mensagem) {
		String retorno = null;
		String status = _CONSULTA_OK_INOVASA;

		if(mensagem.isConsultaOK() == true) {
			switch (Integer.parseInt(mensagem.getMensagemRecebida().getCdConsulta())){
			
			case ServicoFactory._PROD_LIQ_EFI_REAL_TURNO:
			case ServicoFactory._PROD_LIQ_EFI_REAL_OP:
			case ServicoFactory._PRODLIQ_EFI_REAL_TODAS_OP:
			case ServicoFactory._PRODLIQ_EFI_REAL_HR:
				String prodLiq = _PROD_LIQ +  String.format("%.0f", mensagem.getProdLiquida()) + "#";
				String efiReal = _EFI_REAL + String.format("%.2f", mensagem.getEfiRealizacao()) + "#";
				retorno = status + prodLiq + efiReal;
				break;
				
			case ServicoFactory._QTD_REF_INDI_REF_OP:
			case ServicoFactory._QTD_REF_INDI_REF_TODAS_OP:
			case ServicoFactory._QTD_REF_INDI_REF_TURNO:
				String prodRef = _PROD_REF + String.format("%.0f", mensagem.getProducaoRefugada()) + "#";
				String indidRef = _INDI_REF + String.format("%.2f", mensagem.getIndiceRefugo()) + "#";
				retorno = status + prodRef + indidRef;
				break;
				
			case ServicoFactory._A_PRDZR_NUM_OP_MLD_OR_EST_OR_CDPROD:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				String aProduzir = _A_PRODUZIR + String.format("%.0f", mensagem.getSaldoAProduzir()) + "#";
				String nrOp = _OP + mensagem.getNrOp() + "#";
				String cdProduto = _CD_PRODUTO + mensagem.getCdFolha() + "#";
				retorno = status + aProduzir + nrOp + cdProduto;
				break;
				
			case ServicoFactory._CICLO_MED_CICLO_PAD_TURNO:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				String cicloPadrao = _CICLO_PADRAO + mensagem.getCicloPadrao() + "#";
				String cicloMedio = _CICLO_MEDIO + mensagem.getCicloMedio() + "#";
				retorno = status + cicloPadrao + cicloMedio;
				break;
				
			case ServicoFactory._INDC_PAR_TURNO_INDC_PAR_OP:
			case ServicoFactory._IND_PAR_TURNO_TODAS_OP_E_ATUAL:
				String indParTur = _INDI_PAR_TURNO + String.format("%.2f", mensagem.getIndiceParadasPorTurno()) + "#";
				String indParOP = _INDI_PAR_OP + String.format("%.2f", mensagem.getIndiceParadasPorOP()) + "#";
				retorno = status + indParTur + indParOP;
				break;
				
			case ServicoFactory._EFI_CICLO_TURNO_E_OP:
			case ServicoFactory._EFI_CICLO_TURNO_TODAS_OP_E_ATUAL:
				String efiCicTur = _EFI_CIC_TURNO + String.format("%.2f", mensagem.getEfiCiclosTurno()) + "#";
				String efiCicOP = _EFI_CIC_OP + String.format("%.2f", mensagem.getEfiCiclosOP()) + "#";
				retorno = status + efiCicTur + efiCicOP;
				break;
				
			case ServicoFactory._TIME_INTERV_META_PROD_HR:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				String intervalo = _INTERVALO_HR + mensagem.getIntervaloHora() + "#";
				String metaHora = _A_PRODUZIR + mensagem.getMetaProdHora() + "#";
				retorno = status + intervalo + metaHora;
				break;
				
			case ServicoFactory._TURNO_DTHR_ATUAL:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA (ESSA CONSULTA PODE SER LOCAL ACREDITO)
				String dsTurno = _DS_TURNO + mensagem.getDsTurno() + "#";
				retorno = status + dsTurno;
				break;
				
			case ServicoFactory._COD_E_DES_ULTIMA_PAR:
				//TODO: NENHUMA INFORMACAO NO DOCUMENTO SOBRE ESSA CONSULTA IMPLEMENTAR
				retorno = _CONSULTA_FAIL;
				break;
				
			case ServicoFactory._PRODUTOS_DA_OP:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				int sizeListProdutos = 0;
				if(mensagem.getListProdutos() != null)
					sizeListProdutos = mensagem.getListProdutos().size();
				String qtdProdutos = _QTD_PROD + sizeListProdutos + "#";
				String produtos = "";
				int i = 0;
				for(String cdProd : mensagem.getListProdutos()) {
					if(cdProd != null) {
						produtos += _PROD + i + "=" + cdProd + "#";
						i++;
					}
				}
				retorno = status + qtdProdutos + produtos;
				break;
			
			case ServicoFactory._CIP_DTHR_DURATION:
				String isCIP = _IS_CIP + mensagem.isCip() + "#";
				String cipDthrIni = _DTHR + mensagem.getCipDthrIni() + "#";
				String cipDuration = _DURATION + mensagem.getCipDuration() + "#";
				retorno = status + isCIP + cipDthrIni + cipDuration;
				break;
				
			case ServicoFactory._CIP_DTHR_PROD_REF:
				String isCIP2 = _IS_CIP + mensagem.isCip() + "#";
				String cipDthrIni2 = _DTHR + mensagem.getCipDthrIni() + "#";
				String prodLiqCIP = _PROD_LIQ + String.format("%.2f", mensagem.getProdLiquida()) + "#";
				String prodRefCIP = _PROD_REF + String.format("%.2f", mensagem.getProducaoRefugada()) + "#";
				retorno = status + isCIP2 + cipDthrIni2 + prodLiqCIP + prodRefCIP;
				break;
				
			case ServicoFactory._OEE_TURNO:
			case ServicoFactory._OEE_ULTIMA_HR:
				String prodOee = _PROD_OEE + String.format("%.2f", mensagem.getProdutividadeOEE()) + "#";
				String metaOee = _META_OEE + String.format("%.2f", mensagem.getMetaOEE()) + "#";
				String indQld = _IND_QLD + String.format("%.2f", mensagem.getIndiceQualidade()) + "#";
				String indUtl = _IND_UTL + String.format("%.2f", mensagem.getIndiceUtilizacao()) + "#";
				String indEfc = _IND_EFC + String.format("%.2f", mensagem.getIndiceProducao()) + "#";
				retorno = status + prodOee + metaOee + indQld + indUtl + indEfc;
				break;
			
			case ServicoFactory._PERFIL_ANDON:
				if (mensagem.getMsPerfilAndon().getCdPerfilandon() != null 
				&& !mensagem.getMsPerfilAndon().getCdPerfilandon().equals("")) {
					String cdPerfilandon = _CD_PERFIL_ANDON + mensagem.getMsPerfilAndon().getCdPerfilandon() + "#";
					String idPerfilregras = "";
					String porta = "";
					String prioridade = ""; 	
					String segTempoAlto = ""; 
					String segTempoBaixo = "";
					String isPiscante = ""; 	
					String tpSaida = ""; 		
					String tpMotivo = ""; 		
					String sinalMotivo = ""; 
					String vlMotivo = ""; 		
					String segTolerancia = "";
					String payload = cdPerfilandon;
					
					for(MsPerfilregras msPerfilregras: mensagem.getMsPerfilAndon().getMsPerfilregrases()) {
						if (msPerfilregras.getIdPerfilregras() != null)
						idPerfilregras = _ID_PERFIL_REGRAS_ANDON + msPerfilregras.getIdPerfilregras() + "#";
						porta = _PORTA_ANDON + msPerfilregras.getPorta() + "#";
						prioridade = _PRIORIDADE_PORTA_ANDON + msPerfilregras.getPrioridade() + "#";
						segTempoAlto = _SEG_TEMPO_ALTO_ANDON + msPerfilregras.getSegTempoauto() + "#";
						segTempoBaixo = _SEG_TEMPO_BAIXO_ANDON + msPerfilregras.getSegTempobaixa() + "#";
						isPiscante = _IS_PISCANTE_ANDON + msPerfilregras.getIsPiscante() + "#";
						tpSaida = _TP_SAIDA_ANDON + msPerfilregras.getTpSaida() + "#";
						tpMotivo = _TP_MOTIVO_ANDON + msPerfilregras.getTpMotivo() + "#";
						sinalMotivo = _SINAL_MOTIVO_ANDON + msPerfilregras.getSinalMotivo() + "#";
						vlMotivo = _VL_MOTIVO_ANDON + msPerfilregras.getVlMotivo() + "#";
						segTolerancia = _SEG_TOLERANCIA_ANDON + msPerfilregras.getSegTolerancia()+ "#";
						payload = payload + idPerfilregras + porta + prioridade  + segTempoAlto  + segTempoBaixo  
								+ isPiscante  + tpSaida  + tpMotivo  + sinalMotivo  + vlMotivo  + segTolerancia ;
					}
					retorno = status + payload;
				} else {
					retorno = _CONSULTA_FAIL;
				}
				break;
			default:
				retorno = _CONSULTA_FAIL;
				break;
			}
		} else {
			retorno = _CONSULTA_FAIL;
		}

		char stx = (char) 0x02;
		char etx = (char) 0x03;
		retorno=stx+retorno+etx;	
		return retorno;
	}

	private static String construirMsgResultadoParada(IwsParadaDTO p, boolean flagMotivoParada){
		StringBuilder msg = new StringBuilder();

		msg.append("pedecausa=" + p.getIsPedeCausa() + "#");
		msg.append("pedeacao=" + p.getIsPedeAcao() + "#");
		msg.append("pedejust=" + p.getIsPedeJust() + "#");
		msg.append("numtec=" + p.getQtMinimaTecnicos() + "#");
		msg.append("responsavel=" + p.getIsTecnicoArea() + "#");

		if (flagMotivoParada){
			msg.append("flagmotivoparada=true#");
		}

		return msg.toString();
	}

	private static String construirMsgResultadoRefugo(IwsRefugoDTO r){
		StringBuilder msg = new StringBuilder();

		msg.append("pedecausa=" + r.getPedeCausa() + "#");
		msg.append("pedeacao=" + r.getPedeAcao() + "#");
		msg.append("pedejust=" + r.getPedeJust() + "#");


		return msg.toString();
	}

	private static String construirMsgIniciaAlerta(MensagemEnviada mensagem){
		String retorno;

		if(mensagem.isAlertaIniciado()){
			retorno = _ACTION_RESPOSTA + _DISMISS_DIALOG_ALERTA + _RESPOSTA + _ALERTA_INICIADA_SUCESSO;
		}else{
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _ALERTA_INICIADA_FALHA;
		}

		return retorno;
	}

	private static String construirMsgLogout(MensagemEnviada mensagem){
		String retorno;

		if (mensagem.isLogoutEfetuado()){
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _LOGOUT_SUCESSO;
		}else{
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _LOGOUT_FALHA;
		}

		return retorno;
	}

	private static String construirMsgLogin(MensagemEnviada mensagem){
		String retorno;
		if (mensagem.isLoginOperadorAutenticado()){
			retorno = _ACTION_RESPOSTA + _DISMISS_DIALOG_LOGIN + _RESPOSTA + _LOGIN_SUCESSO;
		}else{				
			if(mensagem.isUsuarioLogado()){
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _LOGIN_EM_ABERTO;
			}else{
				retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _LOGIN_FALHA;
			}
		}
		return retorno;
	}

	private static String construirMsgApagaUltimoRefugo(MensagemEnviada mensagem){
		String retorno;
		if(mensagem.getResultadoRefugo()){
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _REFUGO_APAGADO_COM_SUCESSO;	
		}else{
			retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _ERRO_APAGAR_REFUGO;	
		}
		return retorno;
	}

	@SuppressWarnings("unused")
	private static String construirMensagemServicoFalhou(){

		String retorno;

		retorno = _ACTION_RESPOSTA + _PRINT_RESPOSTA + _RESPOSTA + _SERVICO_FALHOU;	


		return retorno;
	}

	private static String construirMensagemSessao(MensagemEnviada mensagem) {

		StringBuilder msg = new StringBuilder();
		UpRN uprn = new UpRN();
		PrUp prup = new PrUp();
		msg.append(_ACTION_SESSION);
		msg.append("version=");
		msg.append(IdwFacade.getInstancia().getVersaoMobile());
		msg.append("#");

		msg.append("ihm=" + mensagem.getMensagemRecebida().getUrlConexaoIhm() + "#");

		int indice = 0;

		Collections.sort(mensagem.getMsDTO().getIcsColetados(), new Comparator<IcUpDTO>() {
			@Override
			public int compare(IcUpDTO arg0, IcUpDTO arg1) {
				// TODO Auto-generated method stub
				return arg0.getUpDTO().getCd_up().compareTo(arg1.getUpDTO().getCd_up());
			}

		});

		for (IcUpDTO icColetados : mensagem.getMsDTO().getIcsColetados()) {
			
			//Luiz - 20180522 - Se o injet estiver ativo entao deve pegar os dados de parada de prup.
			if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
				uprn.iniciaConexaoBanco();
				try {
					prup = uprn.pesquisarPrUpPorCdMaquinaStAtiva(icColetados.getUpDTO().getCd_up());
					if (prup != null) {
						if (Character.getNumericValue(prup.getStparadaemaberto()) == 1) {
							icColetados.getUpDTO().setUpTrabalhando(false);
						}
						else
							icColetados.getUpDTO().setUpTrabalhando(true);
					}
				} catch (RegistroDesconhecidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//if (prup != null)
			//	System.out.println("A up " + prup.getCdmaqestendido() + "esta parada: " + Character.getNumericValue(prup.getStparadaemaberto()));
			//icColetados.getUpDTO().setUpTrabalhando(Stubedelegate.getInstancia().getMsthread().getIcUp(icColetados.getUpDTO().getCd_up()).getUpDTO().isUpTrabalhando());
//			String dados = "cdpt=" + icColetados.getUpDTO().getCd_up();
			indice++;
			msg.append("cdpt" + indice + "=" + icColetados.getUpDTO().getCd_up() + "#");
			msg.append("dsup" + indice + "=" + icColetados.getUpDTO().getDs_up() + "#");
			msg.append("idpt" + indice + "=" + icColetados.getUpDTO().getIdUp() + "#");
			msg.append("dsgt" + indice + "=" + icColetados.getUpDTO().getCdmaqestendido() + "#");
			msg.append("iduppdba" + indice + "=" + icColetados.getUpDTO().getIdUpPDBA() + "#");
			msg.append("tipopt" + indice + "=" + icColetados.getUpDTO().getIdTppt() + "#");
			msg.append("bc" + indice + "=" + icColetados.getUpDTO().isBcOffLine() + "#");
			msg.append("isoffline" + indice + "=" + icColetados.getUpDTO().isOffline() + "#");
			msg.append("islogonobrigatorio" + indice + "=" + mensagem.getMsDTO().getOmcfg().getIsLogonobrigatorio() + "#");

			/*
			 * O Ihm troca op tem uma configuracao relacionada ao PT, se estiver preenchida usa-la
			 */
			boolean isIhmTrocaop = false;
			if (icColetados.getUpDTO().getIsIhmtrocaOP() != null) {
				isIhmTrocaop = icColetados.getUpDTO().getIsIhmtrocaOP();
			} else if (mensagem.getMsDTO().getOmcfg().getIsIhmtrocaop())
				isIhmTrocaop = mensagem.getMsDTO().getOmcfg().getIsIhmtrocaop();

			msg.append("isihmtrocaop" + indice + "=" + isIhmTrocaop + "#");

//			dados += " isComOP " + icColetados.getUpDTO().getIsComOP();
			if (icColetados.getUpDTO().getIsComOP() == false) {
				msg.append("semop" + indice + "=true" + "#");
				msg.append("tpsessao" + indice + "=" + icColetados.getUpDTO().getTpSessao() + "#");

				construirListaOperadoresLogados(msg, icColetados, indice);
			} else {
				msg.append("cdparada" + indice + "=" + icColetados.getUpDTO().getCdParada() + "#");
				msg.append("reqcancel" + indice + "=" + icColetados.getUpDTO().isReqCancel() + "#");
				msg.append("ultp" + indice + "=" + icColetados.getUpDTO().getDsParada() + "#");
				msg.append("inip" + indice + "=" + icColetados.getUpDTO().getDthrIParada() + "#");
				msg.append("fimp" + indice + "=" + icColetados.getUpDTO().getDthrFParada() + "#");
				msg.append("ispermitecorrecao" + indice + "=" + icColetados.getUpDTO().isParadaPermiteCorrecao() + "#");
				// Luiz 20180521 - As condicoes de parada nao estavam sendo setadas no objeto ...getUpDTO() do idw, por isso busco do objeto prup equivalente ao do idw no injet
				if (icColetados.getUpDTO().isUpTrabalhando()) {
					msg.append("paradaemaberto" + indice + "=0#");
				} else {
					msg.append("paradaemaberto" + indice + "=1#");
				}
				if (icColetados.getUpDTO().getNropestendido() != null && icColetados.getUpDTO().getNropestendido().equals("null") == false) {
					msg.append("nrop" + indice + "=" + icColetados.getUpDTO().getNropestendido() + "#");
					msg.append("filial" + indice + "=" + icColetados.getUpDTO().getFilial() + "#");
					if(icColetados.getUpDTO().getIsOPReprocesso())
						msg.append("opreprocesso" + indice + "=1#");
				} else
					msg.append("nrop" + indice + "=SEM OP#");
				msg.append("prodliquida" + indice + "=" + icColetados.getUpDTO().getProducaoliquida() + "#");
				msg.append("prodplan" + indice + "=" + icColetados.getUpDTO().getProducaoplanejada() + "#");
				// msg.append("cdproduto" + indice + "=" + icColetados.getUp().getCdproduto() + "#");
				// Luiz 20180521 - As condicoes de parada nao estavam sendo setadas no objeto ...getUpDTO() do idw, por isso busco do objeto prup equivalente ao do idw no injet
				if (icColetados.getUpDTO().isUpParada()) {
					msg.append("isparada" + indice + "=" + "true" + "#");	
				}
				else {
					msg.append("isparada" + indice + "=" + "false" + "#");
				}
				msg.append("cdrefugo" + indice + "=" + icColetados.getUpDTO().getCdRefugo() + "#");
				msg.append("ultref" + indice + "=" + icColetados.getUpDTO().getDsRefugo() + "#");
				msg.append("dtref" + indice + "=" + icColetados.getUpDTO().getDthrIRefugo() + "#");
				msg.append("msdtref" + indice + "=" + icColetados.getUpDTO().getMsdthrIRefugo() + "#");

				// Nesse momento devo veriifcar se o CIP est� aberto e qual seu tipo
				// TipoCip = 0 - o cip ja est� aberto entao o botao Finalizar cip deve ser incluido na tela
				// TipoCip = 1 - o cip est� pendente de abertura logo o botao iniciar cip deve estar na tela

				if (icColetados.getUpDTO().isCip() == true) {
					int tipoCip = icColetados.getUpDTO().isCipIniciado() ? 0 : 1;
					msg.append("tipocip" + indice + "=" + tipoCip + "#");
				}

				msg.append("idrdzproduto" + indice + "=" + icColetados.getUpDTO().getIdRdzProduto() + "#");

				construirListaProdutos(msg, icColetados, indice);
//				dados += " sizeProdutos " + icColetados.getUpDTO().getListaProdutos().size();
				construirListaOperadoresLogados(msg, icColetados, indice);

				// trecho if adicionado, pois � necessario verificar se a flag injet est� ativa.
				if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
					icColetados.getUpDTO().setCd_up(prup.getCdmaquina());
					construirListaAlertas(msg, icColetados, indice);
				} else {
					construirListaAlertasIDW(msg, icColetados, indice);
				}
			}
		}
		// Enviar a data e hora atual para que o ihm possa atualizar a hora
		msg.append("dthratual=");
		msg.append(DataHoraRN.getDataHoraAtualFormatada());
		msg.append("#");
		return msg.toString();

	}

	private static void construirListaProdutos(StringBuilder msg, IcUpDTO icColetados, int indiceUp){
		int indice = 0;
		for (PrUpProduto produto: icColetados.getUpDTO().getListaProdutos()){
			indice++;
			msg.append("cdproduto" + indice + "|" + indiceUp + "=" + produto.getCdproduto() + "#");
			msg.append("prodplan" + indice + "|" + indiceUp + "=" + produto.getQtdplan() + "#");
			msg.append("prodliquida" + indice + "|" + indiceUp + "=" + produto.getQtdprodliquida() + "#");
		}
	}

	private static void construirListaOperadoresLogados(StringBuilder msg, IcUpDTO icColetados, int indiceUp){
		int indice = 0;	

		if(icColetados.getUpDTO().getListaOperadoresLogados() == null){
			return;
		}

		for (UsuarioMSDTO operador : icColetados.getUpDTO().getListaOperadoresLogados()){
			indice++; 
			msg.append("oplogin" + indice + "|" + indiceUp + "=" + operador.getLogin() + "#");
			msg.append("opnome" + indice + "|" + indiceUp + "=" + operador.getNome() + "#");
			msg.append("inilogin" + indice + "|" + indiceUp + "=" + operador.getDthrLogin() + "#");




			msg.append("durlogin" + indice + "|" + indiceUp + "=" + diferencaEmHoras(operador.getDthrLogin(), DataHoraRN.getDataHoraAtual() ) + "#");



		}


	}

	private static String diferencaEmHoras(Date dataInicial, Date dataFinal){  
		StringBuilder data = new StringBuilder();

		long diferenca = dataFinal.getTime() - dataInicial.getTime();  
		long diferencaEmHoras = (diferenca /1000) / 60 / 60;  
		long minutosRestantes = (diferenca / 1000)/60 %60;  
		long segundosRestantes = (diferenca / 1000) % (60);  


		data.append(diferencaEmHoras < 10 ? "0" + diferencaEmHoras + ":" : diferencaEmHoras  + ":" ); 	        
		data.append(minutosRestantes < 10 ? "0" + minutosRestantes + ":" : minutosRestantes + ":"  );
		data.append(segundosRestantes < 10 ? "0" + segundosRestantes  : segundosRestantes   );

		return data.toString();  
	}  

	private static void construirListaAlertas(StringBuilder msg, IcUpDTO icColetados, int indiceUp){
		int indice = 0;	

		//C�digo comentado devida a mudan�a no uso das tabelas de alertas em aberto
		/*		for (MSalertaDTO alertas : icColetados.getUpDTO().getListaAlertasEmAberto()){
			indice++;
			msg.append("cdalerta" + indice + "|" + indiceUp + "=" + alertas.getCdAlerta() + "#");
			msg.append("dsalerta" + indice + "|" + indiceUp + "=" + alertas.getDsAlerta() + "#");
			msg.append("inialerta" + indice + "|" + indiceUp + "=" + alertas.getdthrinialerta() + "#");
		}*/

		//A pesquisa dos alertas em aberto est�o sendo feitas pela base do Injet (semelhante ao Inova)
		IwsFacade facade = new IwsFacade();
		IwsListaAlertaDTO alertas = facade.GetTr_pesquisaAlertasEmAberto(icColetados.getUpDTO().getCd_up());

		// Se nao houver alertas ou nao existem alertas ou PR_UP nao esta utilizando o cdinjetoraestendido
		if(alertas.getAlertas() == null){
			alertas = facade.GetTr_pesquisaAlertasEmAberto("|" + UtilsString.adicionaZero(Integer.toString(indiceUp), 5));
		}

		if(alertas.getAlertas() == null){
			return;
		}

		for (IwsAlertaDTO  alerta : alertas.getAlertas()){
			if (alerta.getTpAlerta() == 0) {
				indice++;
				msg.append("cdalerta" + indice + "|" + indiceUp + "=" + alerta.getCdAlerta() + "#");
				msg.append("dsalerta" + indice + "|" + indiceUp + "=" + alerta.getDsAlerta() + "#");
				msg.append("inialerta" + indice + "|" + indiceUp + "=" + alerta.getdthrinialerta() + "#");
			}
		}

	}

	private static void construirListaAlertasIDW(StringBuilder msg, IcUpDTO icColetados, int indiceUp){
		int indice = 0;
		if(icColetados.getUpDTO().getListaAlertasEmAberto() == null || icColetados.getUpDTO().getListaAlertasEmAberto().size() <= 0){
			return;
		}

		for (MSalertaDTO  alerta : icColetados.getUpDTO().getListaAlertasEmAberto()){
			indice++;
			msg.append("cdalerta" + indice + "|" + indiceUp + "=" + alerta.getCdAlerta() + "#");
			msg.append("dsalerta" + indice + "|" + indiceUp + "=" + alerta.getDsAlerta() + "#");
			msg.append("inialerta" + indice + "|" + indiceUp + "=" + alerta.getdthrinialerta() + "#");
		}
	}
	
}
