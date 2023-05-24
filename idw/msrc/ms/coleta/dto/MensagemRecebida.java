package ms.coleta.dto;

import idw.util.IdwLogger;

import java.util.Date;
import java.util.List;

import javax.websocket.Session;

import ms.coleta.ic.IIC;
import ms.coleta.servico.ServicoFactory;
import ms.coleta.tcp.ServidorTcp.TipoProtocoloTCP;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.util.UtilsString;

public class MensagemRecebida {
	private EventoColetado evento;
	private String mensagem;
	
	private String ip;
	private IdwLogger log;
	private IcDTO dadosIcDTO;
	private IIC ic;
	private List<IcDTO> listadadosIcDTO;
	private int idLog = 0;
	private int identacao = 0;
	private Session sessaows;
	private TipoProtocoloTCP tipoProtocoloMensagem = TipoProtocoloTCP.PROTOCOLO_OLD;
	private boolean necessitaResposta = false;
	
	private Date dataMensagemRecebida;
	
	public enum TipoSolicitacao {TCP, WEBSERVICE, WEBSOCKET};
	
	public MensagemRecebida(){
		
	}
	
	public void setIc(IIC ic) {
		this.ic = ic;
	}

	public IIC getIc() {
		return ic;
	}

	public IcDTO getDadosIcDTO() {
		return dadosIcDTO;
	}

	public void setDadosIcDTO(IcDTO dadosIcDTO) {
		this.dadosIcDTO = dadosIcDTO;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public MensagemRecebida(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public MensagemRecebida(String mensagem, TipoProtocoloTCP tipoProtocoloTCP) {
		this.mensagem = mensagem;
		this.tipoProtocoloMensagem = tipoProtocoloTCP;
	}

	public MensagemRecebida(String mensagem , javax.websocket.Session sessionws) {
		this.mensagem = mensagem;
		this.sessaows = sessionws;
	}
	
	public MensagemRecebida(EventoColetado evento) {
		this.evento = evento;
	}

	public int getServico() {
		try{
			if(this.mensagem == null)
				return this.evento.getTipoEvento();
		
			if(this.tipoProtocoloMensagem == TipoProtocoloTCP.PROTOCOLO_NOVO){
				return Integer.parseInt(UtilsString.getValorFromSecaoChave(mensagem, "evt", "ac"));	
			}
			
			return Integer.parseInt(UtilsString.getChave(mensagem, "ac"));	
		} catch(Exception e) {
			//retorno definido no passado como "valor de erro"
			return 1000;
		}
	}

	public String getDescricaoServico(){
		int servico = getServico();
		StringBuilder retorno = new StringBuilder();
		
		if (servico == ServicoFactory._REGISTRO_CLIENTES)
			retorno.append("REGISTRO");
		else if (servico == ServicoFactory._FIM_CICLO)
			retorno.append("FIM CICLO");
		else if (servico == ServicoFactory._INICIO_CICLO)
			retorno.append("INICIO CICLO");
		else if (servico == ServicoFactory._INICIO_PARADA)
			retorno.append("PARADA");
		else if (servico == ServicoFactory._MOTIVO_PARADA)
			retorno.append("MOTIVO PARADA");
		else if (servico == ServicoFactory._ANDON)
			retorno.append("ANDON");
		else if (servico == ServicoFactory._INICIA_NOVA_PARADA)
			retorno.append("INICIA NOVA PARADA");
		else if (servico == ServicoFactory._LOGIN)
			retorno.append("LOGIN");
		else if (servico == ServicoFactory._LOGOUT)
			retorno.append("LOGOUT");
		else if (servico == ServicoFactory._INICIA_ALERTA)
			retorno.append("INICIA ALERTA");
		else if (servico == ServicoFactory._REMOVE_ALERTA)
			retorno.append("REMOVE ALERTA");
		else if (servico == ServicoFactory._CONSULTA)
			retorno.append("CONSULTA");
		else if (servico == ServicoFactory._APAGAULTIMOREFUGO)
			retorno.append("APAGA ULTIMO REFUGO");
		else if (servico == ServicoFactory._VALIDAREFUGO)
			retorno.append("VALIDA REFUGO");
		else if (servico == ServicoFactory._NOVOREFUGO)
			retorno.append("NOVO REFUGO");
		else if (servico == ServicoFactory._VALIDAPARADA)
			retorno.append("VALIDA PARADA");
		else if (servico == ServicoFactory._IC_HEART_BEAT)
			retorno.append("HEART BEAT");
		else if (servico == ServicoFactory._MEDICAO_TEMPERATURA)
			retorno.append("MEDICAO DE TEMPERATURA");
		else if (servico == ServicoFactory._ALERTA_TEMPERATURA)
			retorno.append("ALERTA TEMPERATURA");
		else if (servico == ServicoFactory._ALERTA_PERDA_CONEXAO)
			retorno.append("ALERTA CONEXAO");
		else if (servico == ServicoFactory._INFORMA_MOTIVO_PARADA)
			retorno.append("INFORMA MOTIVO PARADA");
		else if (servico == ServicoFactory._FIM_PARADA)
			retorno.append("FIM PARADA");
		else if (servico == ServicoFactory._FINALIZA_PARADA)
			retorno.append("FINALIZA PARADA");
		else if (servico == ServicoFactory._MEDICAO_CCK)
			retorno.append("MEDICAO CCK");	
		else if (servico == ServicoFactory._ALERTA_CONSUMO_ATIVO)
			retorno.append("ALERTA MEDICAO CONSUMO ATIVO");
		else if (servico == ServicoFactory._ALERTA_FATOR_DE_POTENCIA)
			retorno.append("ALERTA FATOR DE POTENCIA");
		else if (servico == ServicoFactory._MEDICAO_DEMANDA_MAXIMA)
			retorno.append("MEDICAO DEMANDA MAXIMA");	
		else if (servico == ServicoFactory._PASSAGEM)
			retorno.append("PASSAGEM");
		else if (servico == ServicoFactory._VALIDA_NUMERO_DE_SERIE)
			retorno.append("VALIDA NUMERO DE SERIE");
		else if (servico == ServicoFactory._INOVASA_STARTUP)
			retorno.append("INOVASA STARTUP");
		else if (servico == ServicoFactory._CRIA_OP_AUTOMATICA)
			retorno.append("_CRIA_OP_AUTOMATICA");
		else if (servico == ServicoFactory._CRIA_OP_AUTOMATICA_STANDALONE)
			retorno.append("_CRIA_OP_AUTOMATICA_STANDALONE");
		else if (servico == ServicoFactory._NOVA_OP)
			retorno.append("_NOVA_OP");
		else if (servico == ServicoFactory._MAQUINA_ONLINE)
			retorno.append(" MAQUINA ONLINE");
		else if (servico == ServicoFactory._MAQUINA_OFFLINE)
			retorno.append(" MAQUINA OFFLINE");
		else
			retorno.append("DESCONHECIDO");
		
		retorno.append(" (");
		retorno.append(servico);
		retorno.append(")");
				
		return retorno.toString();
	}
	public String getIp() {
		return this.ip;
	}

	public int getPorta() {
		try {
			if(tipoProtocoloMensagem == TipoProtocoloTCP.PROTOCOLO_OLD)
				return Integer.parseInt(UtilsString.getChave(mensagem, "pt"));
		} catch(Exception e) {
		}
		return 3001;
	}
	
	public String getCdParadaIhm() {
		String cdParada;
		try {
			cdParada = UtilsString.getChave(mensagem, "cdparada=");
		} catch (NullPointerException e){
			cdParada = evento.getCdparada();
		}
		return cdParada;
	}

	public String getUrlConexaoIhm() {
		if(tipoProtocoloMensagem == TipoProtocoloTCP.PROTOCOLO_NOVO) {
			if(getServico() == ServicoFactory._REGISTRO_CLIENTES)
				return UtilsString.getValorFromSecaoChave(mensagem, "evtarg", "1");
			return null;
		}
		return UtilsString.getChave(mensagem, "ihm");
	}
    
	public String getFlagMotivoParada(){
		return UtilsString.getChave(mensagem, "flagmotivoparada");
	}
	
	public String getCodigoBarras(){
		String retorno = UtilsString.getChave(mensagem, "cb");
		if (retorno.equals("") && this.evento != null && this.evento.getCb() != null)
			retorno = this.evento.getCb();
		return retorno;
	}	
	
	public String getNumeroSerie(){
		String retorno = UtilsString.getChave(mensagem, "ns");
		if (retorno.equals("") && this.evento != null && this.evento.getNumeroSerie() != null)
			retorno = this.evento.getNumeroSerie();
		return retorno;
	}	
	
	public String getCdEstrutura(){
		String retorno = UtilsString.getChave(mensagem, "cdestrutura");
		if (retorno.equals("") && this.evento != null && this.evento.getCdestrutura() != null)
			retorno = this.evento.getCdestrutura();
		return retorno;
	}
	
	public String getCdMolde(){
		String retorno = UtilsString.getChave(mensagem, "cdmolde"); 
		if (retorno.equals("") && this.evento != null && this.evento.getCdmolde() != null)
			retorno = this.evento.getCdmolde();
		return retorno;
	}
	
	public String getCdProduto(){
		String retorno = UtilsString.getChave(mensagem, "cdProduto");
		if (retorno.equals("") && this.evento != null && this.evento.getCdproduto() != null)
			retorno = this.evento.getCdproduto();
		return retorno;

	}
	
	public String getTpSessao(){
		String retorno = UtilsString.getChave(mensagem, "tpsessao");
		if (retorno.equals("") && this.evento != null && this.evento.getTpSessao() != null)
			retorno = this.evento.getTpSessao();
		return retorno;

	}
	
	public String getQtdeCiclos(){
		return UtilsString.getChave(mensagem, "qtdeciclos");
	}
	
	public String getNrOp(){
		String retorno = UtilsString.getChave(mensagem, "nrop");
		if (retorno.equals("") && this.evento != null && this.evento.getCdop() != null)
			retorno = this.evento.getCdop();
		return retorno;
	}
	
	public String getIdRdzProduto(){
		return UtilsString.getChave(mensagem, "idrdzproduto");
	}
	
	public String getCdRefugo(){
		return UtilsString.getChave(mensagem, "cdrefugo");
	}
	
	public String getDthrUltRefugo(){
		return UtilsString.getChave(mensagem, "dtref");
	}
	
	public String getMsDthrUltRefugo(){
		return UtilsString.getChave(mensagem, "msdtref");
	}
	
	public String getUp() {
		String retorno = null;
		if(tipoProtocoloMensagem == TipoProtocoloTCP.PROTOCOLO_OLD) {
			try {
				retorno = UtilsString.getChave(mensagem, "up");
			} catch (Exception e){
			}
			if(retorno == null || retorno.equals("")) {
				
			}
		} else if(tipoProtocoloMensagem == TipoProtocoloTCP.PROTOCOLO_NOVO) {
			try{
			retorno = UtilsString.getValorFromSecaoChave(mensagem, "evt", "up");
			}catch(Exception e){
			}
		}
		if((retorno == null || retorno.equals("")) && evento != null && evento.getIcUpDTO() != null)
			retorno = evento.getIcUpDTO().getUpDTO().getCd_up();
		return retorno;
	}

	public String getCdAlerta(){
		String retorno = "";
		if (mensagem != null)
			retorno = UtilsString.getChave(mensagem, "cdalerta");
		else if (getEventoColetado() != null && getEventoColetado().getCdalerta() != null && getEventoColetado().getCdalerta().equals("") == false)
			retorno = getEventoColetado().getCdalerta();
		
		return retorno;
	}
	
	public String getCdConsulta(){
		try{
			return UtilsString.getChave(mensagem, "cdconsulta");
		} catch(Exception e) {
			if(getServico() == ServicoFactory._CONSULTA_GENERICA_INOVASA || getServico() == ServicoFactory._CONSULTA_GENERICA)
				return UtilsString.getValorFromSecaoChave(mensagem, "evtarg", "1");
		}
		return null;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensagemRecebidaTcp() {
		return this.mensagem;
	}

	public EventoColetado getEventoColetado() {
		return this.evento;
	}
	
	public void setEventoColetado(EventoColetado evento) {
		this.evento = evento;
	}
	
	public String getSenha(){
		return UtilsString.getChave(mensagem, "senha");
	}
	
	public String getDthrlogin(){
	 return UtilsString.getChave(mensagem, "dthrlogin");	
	}
	
	public String getLogin(){
		String retorno = null;
		if (mensagem != null)
			retorno = UtilsString.getChave(mensagem, "login");
		else if (evento != null && evento.getLogin() != null)
			retorno = evento.getLogin();
		
		return retorno;
	}
	
	public String getIdup(){
		String retorno = "desc";
		if (mensagem != null)
			retorno = UtilsString.getChave(mensagem, "idup");
		else if (evento != null && evento.getIdUpPdba() != null)
			retorno = evento.getIdUpPdba();
		return retorno;
	}

	public String getCdCausa(){
		return UtilsString.getChave(mensagem, "cdcausa");
	}
	
	public String getCdAcao(){
		return UtilsString.getChave(mensagem, "cdacao");
	}
	
	public String getCdJust(){
		return UtilsString.getChave(mensagem, "cdjust");
	}
	
	public String getCdTec1(){
		return UtilsString.getChave(mensagem, "cdtec1");
	}
	
	public String getSenhaTec1(){
		return UtilsString.getChave(mensagem, "senhatec1");
	}
	
	public String getCdTec2(){
		return UtilsString.getChave(mensagem, "cdtec2");
	}
	
	public String getSenhaTec2(){
		return UtilsString.getChave(mensagem, "senhatec2");
	}
	
	public String getCdTecResponsavel(){
		return UtilsString.getChave(mensagem, "cdtecresponsavel");
	}
	
	public String getSenhaTecResponsavel(){
		return UtilsString.getChave(mensagem, "senhatecresponsavel");
	}
		
	public String getQtde(){
		return UtilsString.getChave(mensagem, "qtde");
	}
	
	public String getCdFolha(){
		return UtilsString.getChave(mensagem, "cdfolha");
	}
	
	public String getDthrEvento(){
		return UtilsString.getChave(mensagem, "dthrevento");
	}
	
	public List<IcDTO> getListaDadosIcDTO() {
		return listadadosIcDTO;
	}

	public void setListaDadosIcDTO(List<IcDTO> listaIcDTO) {
		this.listadadosIcDTO = listaIcDTO;
	}

	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public int getIdentacao() {
		return identacao;
	}

	public void setIdentacao(int identacao) {
		this.identacao = identacao;
	}

	public Session getSessaows() {
		return sessaows;
	}

	public void setSessaows(Session sessaows) {
		this.sessaows = sessaows;
	}

	public TipoProtocoloTCP getTipoProtocoloMensagem() {
		return tipoProtocoloMensagem;
	}

	public void setTipoProtocoloMensagem(TipoProtocoloTCP tipoProtocoloMensagem) {
		this.tipoProtocoloMensagem = tipoProtocoloMensagem;
	}
	
	public void setMensagem(String valor) {
		this.mensagem = valor;
	}

	public boolean isNecessitaResposta() {
		return necessitaResposta;
	}

	public void setNecessitaResposta(boolean necessitaResposta) {
		this.necessitaResposta = necessitaResposta;
	}

	public Date getDataMensagemRecebida() {
		return dataMensagemRecebida;
	}

	public void setDataMensagemRecebida(Date dataMensagemRecebida) {
		this.dataMensagemRecebida = dataMensagemRecebida;
	}
	
}
