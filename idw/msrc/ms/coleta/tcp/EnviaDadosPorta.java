package ms.coleta.tcp;

import idw.util.IdwLogger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.List;

import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.ParametroDTO;

public class EnviaDadosPorta extends Thread {
	private ClienteRegistrado cliente;
	private MensagemEnviada mensagem;
	private IdwLogger log;
	private int idLog;
	private int identacao;

	public EnviaDadosPorta(ClienteRegistrado cliente, MensagemEnviada mensagem) {
		this.cliente = cliente;
		this.mensagem = mensagem;
		this.log = mensagem.getMensagemRecebida().getLog();
	}

	public EnviaDadosPorta(ClienteRegistrado cliente) {
		this.cliente = cliente;
	}

	public EnviaDadosPorta(String ip, int porta, MensagemEnviada mensagem) {
		ClienteRegistrado c = new ClienteRegistrado();
		c.setIp(ip);
		c.setPorta(porta);
		this.cliente = c;
		this.mensagem = mensagem;
		this.log = mensagem.getMensagemRecebida().getLog();
	}

	// Método substituído por enviandoDadosPelaPorta() por estar @Deprecated. Corrigida a identação
	@Deprecated
	public void enviandoDadosPelaPorta() {
		Socket clientSocket;
		try {

			log.info("Enviando para " + cliente.getIp() + ":" + cliente.getPorta() + " mensagem [" + mensagem.getMensagemASerTransmitida() + "]");
//			System.out.println("Enviando para " + cliente.getIp() + ":" + cliente.getPorta() + " mensagem [" + mensagem.getMensagemASerTransmitida() + "]");
			SocketAddress endereco = new InetSocketAddress(cliente.getIp(), cliente.getPorta());
			clientSocket = new Socket();
			clientSocket.connect(endereco, 0);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(mensagem.getMensagemASerTransmitida());
			clientSocket.close();
			log.info("Enviou SUCESSO para " + cliente.getIp() + ":" + cliente.getPorta());
		} catch (UnknownHostException e) {
			log.info("Enviou FALHOU para " + cliente.getIp() + ":" + cliente.getPorta());
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Enviou FALHOU para " + cliente.getIp() + ":" + cliente.getPorta());
		}
	}

	/*
	 * Esse metodo deve enviar para os clientes registrados usando uma thread em separado
	 * 
	 */
	public void enviandoDadosPelaPorta(int idLog, int identacao) {
		this.idLog = idLog;
		this.identacao = identacao;
		start();
	}

	// Chamado pelo metodo acima
	public void run() {
		Socket clientSocket = null;
		try {
			SocketAddress endereco = new InetSocketAddress(cliente.getIp(), cliente.getPorta());
			clientSocket = new Socket();
			clientSocket.connect(endereco, 500);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(mensagem.getMensagemASerTransmitida());
			log.info(idLog, identacao, "Enviou SUCESSO para " + cliente.getIp() + ":" + cliente.getPorta());
			System.out.println(
					"Enviou SUCESSO para " + cliente.getIp() + ":" + cliente.getPorta() + " " + mensagem.getMensagemASerTransmitida());
		} catch (UnknownHostException e) {
			log.info(idLog, identacao, "Enviou FALHOU (UnknownHostException) para " + cliente.getIp() + ":" + cliente.getPorta());
		} catch (IOException e) {
			log.info(idLog, identacao, "Enviou FALHOU (IOException) para " + cliente.getIp() + ":" + cliente.getPorta());
		} finally {
			if (clientSocket != null)
				try {
					clientSocket.close();
				} catch (IOException e) {
					log.info(idLog, identacao, "Close FALHOU (IOException) para " + cliente.getIp() + ":" + cliente.getPorta());
				}
		}
	}

	public void enviandoDadosAndonPelaPorta(List<ParametroDTO> lista) {
		Socket clientSocket;
		try {
			log.info("Enviando para " + cliente.getIp() + ":" + cliente.getPorta() + " mensagem [" + mensagem.getMensagemAndonASerTransmitida(lista) + "]");
//			System.out.println("Enviando para " + cliente.getIp() + ":" + cliente.getPorta() + " mensagem [" + mensagem.getMensagemAndonASerTransmitida(lista) + "]");
			SocketAddress endereco = new InetSocketAddress(cliente.getIp(), cliente.getPorta());
			clientSocket = new Socket();
			clientSocket.connect(endereco, 500);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(mensagem.getMensagemAndonASerTransmitida(lista));
			clientSocket.close();
			log.info("Enviou com SUCESSO");
		} catch (UnknownHostException e) {
			log.info("Enviou FALHOU");
		} catch (IOException e) {
			log.info("Enviou FALHOU");
		}
	}
}
