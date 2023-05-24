package ms.coleta;

import java.util.List;

import javax.websocket.Session;

import idw.model.pojos.MsEvt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.SessaoICDTO;
import ms.coleta.servico.ServicoFactory;
import ms.coleta.tcp.GerenteThreadsIHM;
import ms.excessao.IhmDesconhecidoException;
import ms.excessao.MsDesconhecidoException;
import ms.excessao.ServicoFalhouException;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.MsDTO;
import ms.model.rn.SessaoRN;
import ms.webservice.Msws;

public class Stubedelegate {
	private static Stubedelegate instancia = null;
	private String pathRelativo;
	private int contador = 0;
	private MSThread msthread = null;
	private GerenteThreadsIHM gerenteThreadsIHM=new GerenteThreadsIHM();
	final int _TEC1 = 3;
	final int _TEC2 = 4;
	final int _TECRESP = 5;

	public GerenteThreadsIHM getGerenteThreadsIHM() {
		return gerenteThreadsIHM;
	}

	public MSThread getMsthread() {
		return msthread;
	}
	public void setMsthread(MSThread msthread) {		
		this.msthread = msthread;
	}
	public void addContador(){
		contador++;
	}
	public int getContador(){
		return contador;
	}
	private Stubedelegate() {
		super();
	}

	public static Stubedelegate getInstancia() {
		if (instancia == null)
			instancia = new Stubedelegate();
		return instancia;
	}	

	
	
	public String getPathRelativo() {
		return pathRelativo;
	}

	public void setPathRelativo(String pathRelativo) {
		this.pathRelativo = pathRelativo;
	}


	public MsDTO registraIhm(ClienteRegistrado clienteRegistrado) throws ServicoFalhouException, MsDesconhecidoException, IhmDesconhecidoException {
		MsDTO msdto = new MsDTO();
		IhmDTO ihmdto = new IhmDTO();
		msdto.setUrlConexao(msthread.getMsdto().getUrlConexao());
		
		ihmdto.setUrl_Conexao(clienteRegistrado.getUrlConexao());
		ihmdto.setUrl_Ip(clienteRegistrado.getIp());
		

		MsDTO retorno = MsFacade.getInstancia().registraIhmNoMs(ihmdto, msdto);
		return retorno;
	}

	public MsDTO heartbeat(MsDTO msdto) throws ServicoFalhouException {
		return MsFacade.getInstancia().heartbeat(msdto);

	}


	public void finalParada(EventoColetado evento) throws ServicoFalhouException {
		Msws metodos = new Msws();
		// Console.WriteLine("Chamando finalParada");
		metodos.finalParada(evento);
	}

	public void enviaMensagemParaClientesRegistrados(int idLog, int identacao, MensagemEnviada mensagemEnviada) {
		IdwLogger log = mensagemEnviada.getMensagemRecebida().getLog();
		log.iniciaAvaliacao(idLog, "Enviando Mensagem Para Clientes Registrados");
		
		for (ClienteRegistrado c : ServicoFactory.getInstancia().getClientesRegistrados()) {
			if (c.getIp() == null) {
				log.info(idLog, identacao, "Ip null para " + c.getUrlConexao());
				continue;
			}

			// Alessandre em 6-1-13
			// Enviar a mensagem apenas para a UP que precisa receber. Futuramente reavaliar isso quando a monitorizacao precisar saber instantaneamente
			// se a maq esta parada ou produzindo. No momento somente o IHM Windows e Android precisam saber disso
			//log.info("Envia a mensagem apenas para a IHM da UP em quest�o [" + c.getUrlConexao() + "] = [" + mensagemEnviada.getMensagemRecebida().getEventoColetado().getIcUpDTO().getIc().getUrl_conexao() + "]");
			//if (mensagemEnviada.getMensagemRecebida().getEventoColetado().getIcUpDTO().getIc().getUrl_conexao().contains(c.getUrlConexao())) {

			// Alessandre: em 25-8-14 retornei o if abaixo pois os ihms windows estavam recebendo direto parada. Ate entao estava desabilitada
			//if (c.isContemUP(mensagemEnviada.getMensagemRecebida().getEventoColetado().getIcUpDTO().getUpDTO())) {

			// Alessandre 22-7-14
			// Iniciar uma thread para enviar a mensagem. Se nao ocorre uma lentidao para que o evento de fim de ciclo termine com o insert em ms_evt
			// isso eh critico qdo o idw esta junto com o injet
			if(c.getSessaoWs() != null){
				Stubedelegate.getInstancia().enviaMensagemParaWebSocketBySession(c.getSessaoWs(), mensagemEnviada.getMensagemASerTransmitida());
			}
			else{
//				Date inicio = DataHoraRN.getDataHoraAtual();
				MensagemEnviada m = mensagemEnviada;
				// Adicionar aqui o tratamento do m�todo de otimiza��o de envio de mensagens!!!!
				gerenteThreadsIHM.enviaMensagem(c, m, idLog, identacao+ 5);
				//EnviaDadosPorta ed = new EnviaDadosPorta(c, m);
				//ed.enviandoDadosPelaPorta(idLog, identacao + 5);
				//}
			}
		}
		log.paraAvaliacao();
		log.info(idLog, identacao, "MANDOU em " + log.getMilisegundosTranscorridos() + " miliseg");
	}
	
	public void enviaMensagemParaWebSocketBySession(Session sessaoWs, String msg) {
		if(sessaoWs.isOpen()) {
			try {
				sessaoWs.getBasicRemote().sendText(msg);
			} catch (Exception e) {
				System.out.println(DataHoraRN.getDataHoraAtualFormatada() + "- Erro na comunicação cliente " + e.getMessage() + " mensagme = " + msg);
			}
		}
	}

	public void enviaMensagemParaClientesRegistradosComExcessaoDaOrigem(MensagemEnviada mensagemEnviada) {
		MensagemRecebida mensagemRecebida = mensagemEnviada.getMensagemRecebida();
		IdwLogger log = mensagemRecebida.getLog();
		log.iniciaAvaliacao("Enviando Mensagem Para Clientes Registrados Com excessao do origem");
		boolean isEnviou = false;
		for (ClienteRegistrado c : ServicoFactory.getInstancia().getClientesRegistrados()) {
			// Se o IHM for o mesmo que deu origem a informacao, nao enviar de
			// volta
			if (c.getUrlConexao().equals(mensagemRecebida.getUrlConexaoIhm()))
				continue;

			isEnviou = true;
			if(mensagemRecebida.getSessaows() != null )
				enviaMensagemParaWebSocketBySession(mensagemRecebida.getSessaows(), mensagemEnviada.getMensagemASerTransmitida());
			else
				gerenteThreadsIHM.enviaMensagem(c, mensagemEnviada, 999, 10);
		}
		log.paraAvaliacao();
		if (isEnviou == false)
			log.info("Nenhum clienteRegistrado apto a receber mensagem (" + log.getAvaliacaoCompleta() + ")");
		else
			log.info("Envio processado em " + log.getAvaliacaoCompleta() + ")");
	}

	//	public void enviaMensagemParaUnicoClienteRegistrado(String ip, List<ParametroDTO> lista) {
	//		IdwLogger log = mensagemEnviada.getMensagemRecebida().getLog();
	//		log.iniciaCronometro();
	// Console.WriteLine("Comecar a enviar em lote para todos os clientes");
	//		for (ClienteRegistrado c : ServicoFactory.getInstancia().getClientesRegistrados()) {
	//			if(c.getIp().equals(ip)) {
	//				MensagemEnviada m = mensagemEnviada;
	//				EnviaDadosPorta ed = new EnviaDadosPorta(c);
	//				ed.enviandoDadosAndonPelaPorta(lista);
	//				break;
	//			}
	//		}
	//		log.paraCronometro();
	//		log.info("			Enviou mensagem " + mensagemEnviada.getMensagemAndonASerTransmitida(lista) + " para os clientes registrados em " + log.getMilisegundosTranscorridos() + " mili");
	//	}

	public void enviaMensagemParaClientesDesconhecido(MensagemEnviada mensagemEnviada) {
		//EnviaDadosPorta ed = new EnviaDadosPorta(mensagemEnviada.getMensagemRecebida().getIp(),mensagemEnviada.getMensagemRecebida().getPorta(),mensagemEnviada);
		//ed.enviandoDadosPelaPorta();
		if(mensagemEnviada.getMensagemRecebida().getSessaows() != null )
			enviaMensagemParaWebSocketBySession(mensagemEnviada.getMensagemRecebida().getSessaows(), mensagemEnviada.getMensagemASerTransmitida());
		else
			gerenteThreadsIHM.enviaMensagem(mensagemEnviada.getMensagemRecebida().getIp(),mensagemEnviada.getMensagemRecebida().getPorta(), mensagemEnviada, 999, 10);

	}

	public void enviaMensagemRespostaCasoNecessario(MensagemRecebida mensagemRecebida, MensagemEnviada mensagemEnviada) {
		enviaMensagemRespostaCasoNecessario(mensagemRecebida.getIp(), mensagemRecebida.getPorta(), mensagemEnviada, 999, 10);
	}
	
	public void enviaMensagemRespostaCasoNecessario(MensagemRecebida mensagemRecebida, MensagemEnviada mensagemEnviada, int idLog, int identacao) {
		enviaMensagemRespostaCasoNecessario(mensagemRecebida.getIp(), mensagemRecebida.getPorta(), mensagemEnviada, idLog, identacao);
	}
	
	public void enviaMensagemRespostaCasoNecessario(String ip, int porta, MensagemEnviada mensagem, int idLog, int identacao) {
		if(mensagem.getMensagemRecebida() == null || mensagem.getMensagemRecebida().isNecessitaResposta() == false)
			return;
		ClienteRegistrado cliente = new ClienteRegistrado();
		cliente.setIp(ip);
		cliente.setPorta(porta);
		cliente.setSessaoWs(mensagem.getMensagemRecebida().getSessaows());
		enviaMensagemRespostaCasoNecessario(cliente, mensagem, idLog, identacao);
	}
	
	public void enviaMensagemRespostaCasoNecessario(ClienteRegistrado cliente, MensagemEnviada mensagem, int idLog, int identacao) {
		if(mensagem.getMensagemRecebida() == null || mensagem.getMensagemRecebida().isNecessitaResposta() == false)
			return;
		if(cliente.getSessaoWs() != null)
			Stubedelegate.getInstancia().enviaMensagemParaWebSocketBySession(cliente.getSessaoWs(), mensagem.getMensagemASerTransmitida());
		else 
			gerenteThreadsIHM.enviaMensagem(cliente, mensagem, idLog, identacao);
	}
	
	public void enviaMensagemParaIhmSolicitante(String ip, MensagemEnviada mensagem ) {
		IdwLogger log = mensagem.getMensagemRecebida().getLog();
		log.iniciaAvaliacao("Enviando Mensagem Para Cliente que solicitou uma resposta");
		for (ClienteRegistrado c : ServicoFactory.getInstancia().getClientesRegistrados()) {
			if(c.getIp().equals(ip)) {
				//EnviaDadosPorta ed = new EnviaDadosPorta(c,mensagem);				
				//ed.enviandoDadosPelaPorta();
				
				if(mensagem.getMensagemRecebida().getSessaows() != null ^ c.getSessaoWs() != null)
					continue;
				
				if(mensagem.getMensagemRecebida().getSessaows() != null)
					Stubedelegate.getInstancia().enviaMensagemParaWebSocketBySession(mensagem.getMensagemRecebida().getSessaows(), mensagem.getMensagemASerTransmitida());
				else
					gerenteThreadsIHM.enviaMensagem(c, mensagem, 999, 10);
				break;
			}
		}
		log.paraAvaliacao();

		log.info("Enviou mensagem " + mensagem.getMensagemASerTransmitida() + " para o cliente solicitante  em " + log.getMilisegundosTranscorridos() + " mili");
	}

	public Boolean isLoginOperadorAutenticado(MensagemRecebida mensagem){
		return MsFacade.getInstancia().isUsuarioOperadorAutenticado(mensagem.getIdup(),mensagem.getLogin(),mensagem.getSenha());
	}

	public IwsConsultaDTO consulta(MensagemRecebida mensagem, EventoColetado evento){
		return MsFacade.getInstancia().consulta(mensagem, evento);
	}

	public boolean apagaUltimoRefugo(EventoColetado evento){

		return MsFacade.getInstancia().apagaUltimoRefugo(evento);
	}

	public  IwsRefugoDTO verificaCausaAcaoRefugo(EventoColetado evento){

		return MsFacade.getInstancia().verificaCausaAcaoRefugo(evento);
	}

	public MsEvt inserirNovoRefugo(EventoColetado evento){

		return MsFacade.getInstancia().inserirNovoRefugo(evento);
	}


	public boolean validaAcao(MensagemRecebida mensagem){
		return MsFacade.getInstancia().validaAcao(mensagem.getIdup(), mensagem.getCdAcao());
	}

	public boolean validaCausa(MensagemRecebida mensagem){
		return MsFacade.getInstancia().validaCausa(mensagem.getIdup(), mensagem.getCdCausa());
	}

	public boolean validaJustificativa(MensagemRecebida mensagem){
		return MsFacade.getInstancia().validaJustificativa(mensagem.getIdup(), mensagem.getCdJust());
	}

	public boolean validaTecnico1(MensagemRecebida mensagem){
		IwsAutenticacaoDTO retorno = IwsFacade.getInstancia().getTr_Autorizacao(mensagem.getIdup(), mensagem.getCdTec1(), mensagem.getSenhaTec1(), _TEC1, DataHoraRN.getDataHoraAtual(), false);

		return retorno.getIsAutorizado();
	}

	public boolean validaTecnico2(MensagemRecebida mensagem){
		IwsAutenticacaoDTO retorno = IwsFacade.getInstancia().getTr_Autorizacao(mensagem.getIdup(), mensagem.getCdTec2(), mensagem.getSenhaTec2(), _TEC2, DataHoraRN.getDataHoraAtual(), false);

		return retorno.getIsAutorizado();
	}

	public boolean validaTecnicoResponsavel(MensagemRecebida mensagem){
		IwsAutenticacaoDTO retorno = IwsFacade.getInstancia().getTr_Autorizacao(mensagem.getIdup(), mensagem.getCdTecResponsavel(), mensagem.getSenhaTecResponsavel(), _TECRESP, DataHoraRN.getDataHoraAtual(), false);

		return retorno.getIsAutorizado();
	}

	public IwsParadaDTO validaParada(EventoColetado evento){
		return MsFacade.getInstancia().validaParada(evento);
	}

	public MsEvt iniciarNovaOp(EventoColetado evento){
		return MsFacade.getInstancia().iniciarNovaOP(evento);
	}

	public MsEvt iniciarCIP(EventoColetado evento) {
		return MsFacade.getInstancia().iniciarCIP(evento);
	}

	public MsEvt finalizarCIP(EventoColetado evento) {
		return MsFacade.getInstancia().finalizarCIP(evento);
	}

	public boolean iniciarVarRitmo(EventoColetado evento) {
		return MsFacade.getInstancia().iniciarVarRitmo(evento);
	}

	public boolean finalizarVarRitmo(EventoColetado evento) {
		return MsFacade.getInstancia().finalizarVarRitmo(evento);
	}

	public boolean informaMotivoVarRitmo(EventoColetado evento) {
		return MsFacade.getInstancia().informaMotivoVarRitmo(evento);
	}

	public void finalizarParada(EventoColetado evento) throws Exception {
		MsFacade.getInstancia().finalizaParada(evento);
	}

	public void icHeartBeat(int idLog,String urlIC, EventoColetado evento) throws ServicoFalhouException {
		MsFacade.getInstancia().icHeartBeat(idLog, urlIC, evento);
	}

	//TODO: PH valida e salva o erro das maquinas insersoras
	public void validaErro(EventoColetado evento) throws ServicoFalhouException {
		Msws metodos = new Msws();
		// Console.WriteLine("Chamando inicioParada");
		metodos.validaErro(evento);

	}
	
	public SessaoICDTO getSessaoIC(IcDTO icDTO) {
		SessaoICDTO sessaoIC = null;
		SessaoRN sessaoRN = new SessaoRN();
		sessaoRN.iniciaConexaoBanco();
		try {
			List<IcUpDTO> icups = icDTO.getMsIcUpDTOLocais();

			sessaoIC = sessaoRN.montaSessaoIC(icDTO.getCd_ic(), icups);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessaoRN.finalizaConexaoBanco();
		}
		return sessaoIC;
	}

}
