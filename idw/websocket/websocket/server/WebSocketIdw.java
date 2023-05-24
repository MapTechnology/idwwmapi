package websocket.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.tcp.RecebeDadosPorta;
import ms.model.dto.IcDTO;
import ms.util.UtilsString;

@ServerEndpoint("/websocket")
public class WebSocketIdw {

	@OnMessage
	public void echoTextMessage(Session session, String msg, boolean last) {

		try {
			if (session.isOpen()) {
				
				String ip = UtilsString.getChave(msg, "ip");
				String cdup = UtilsString.getChave(msg, "up");

				IcDTO dadosicDTO = Stubedelegate.getInstancia().getMsthread().getMsIcDTOdaLista(ip);
				
				if (dadosicDTO == null)
					dadosicDTO = Stubedelegate.getInstancia().getMsthread().getMsIcDTOdaListaByUp(msg);

				if (dadosicDTO == null){
					dadosicDTO = Stubedelegate.getInstancia().getMsthread().getMsIcDTOdaListaByMacIHM(ip, cdup);
				}

				if(dadosicDTO == null){
					session.getBasicRemote().sendText("-1", last);
				}
				
				MensagemRecebida mensagemRecebida = new MensagemRecebida(msg, session);
				mensagemRecebida.setNecessitaResposta(true);
				RecebeDadosPorta trecdad = new RecebeDadosPorta(ip, mensagemRecebida, new IdwLogger("Websocket"), dadosicDTO);
				trecdad.processaMensagem(session);

			}
		} catch (Exception e) {
			try {
				session.getBasicRemote().sendText(e.getMessage(), last);
				session.close();
			} catch (Exception e1) {
				// Ignore
			}
		}



	}

	@OnClose
	public void fechaConexao(){
	}
	
	@OnError
	public void onError(Session session, Throwable thr) {
		// TODO: gerar log do erro
		// thr.toString()
	}

}
