package ms.coleta.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import idw.model.pojos.template.MsIcTemplate;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.ProtocoloEntradaFactory;
import ms.model.dto.IcDTO;

public class ServidorTcp implements Runnable {
	private Thread runner = null;
	private ServerSocket server = null;
	private boolean done = false;
	private IdwLogger log = new IdwLogger("ServidorTCP");
	private enum EstadoProtocoloTCP {PROTOCOLO_DEFAULT, PROTOCOLO_OLD_INICIADO, PROTOCOLO_OLD_FINALIZADO, PROTOCOLO_NOVO_FINALIZADO, PROTOCOLO_NOVO_INICIADO, PROTOCOLO_ERRO};
	public enum TipoProtocoloTCP {PROTOCOLO_NOVO, PROTOCOLO_OLD};
	//Menor mensagem possivel 
	//	->(13) 00000[a]\nb=c\n
	//	->(5) ac=1#
	static final int menorTamanhoPossivelDeMensagem = 5;//13;

	private Map<String, GerenteRecebeDadosPorta> gerentesRecebeDados = new HashMap<>();

	// Alessandre: comentei em 08-09-12 a existencia do Lis<IcDTO> e o contrutor
	// do servidorTcp, pois
	// MSThread existe no singleton Stubedelegate, entao qdo se precisa da lista
	// de icdto pegar de la.
	// private List<IcDTO> listamsdadosicdto = null;

	// public ServidorTcp(MSThread ms) {
	// if (ms != null)
	// this.listamsdadosicdto = ms.getListaDadosIcDto();
	// }

	public synchronized void startServer(int port) throws IOException {
		if (runner == null) {
			log.info("INICIALIZANDO servidorTcp na porta " + port);
			server = new ServerSocket(port);
			server.setReuseAddress(false);
			runner = new Thread(this);
			runner.setName("MS-ServidorTcp");
			runner.start();
		}

	}

	public synchronized void stopServer() {
		log.info("PARANDO servidorTcp");
		done = true;
		runner.interrupt();
	}

	protected synchronized boolean getDone() {
		return done;
	}
	
	private boolean isMensagemFinalizada(EstadoProtocoloTCP state) {
		return(state == EstadoProtocoloTCP.PROTOCOLO_NOVO_FINALIZADO || state == EstadoProtocoloTCP.PROTOCOLO_OLD_FINALIZADO);
	}

	@Override
	public void run() {
		if (server != null) {
			log.info("INICIO servidorTcp com SUCESSO");
			//System.out.println("INICIO servidorTcp com SUCESSO");
			while (getDone() == false) {
				Socket datasocket = null;
				BufferedReader inFromClient = null;
				StringBuilder sb = new StringBuilder();
				String lineFromClient = null;
				EstadoProtocoloTCP state = EstadoProtocoloTCP.PROTOCOLO_DEFAULT;
				int idLog = log.getIdAleatorio();
				try {
					
					datasocket = server.accept();
//					Escolhido 230ms por ser um valor medido empiricamente em projetos anteriores(Concentrador)
					datasocket.setSoTimeout(230);
					inFromClient = new BufferedReader(new InputStreamReader(datasocket.getInputStream()));
					try{
						lineFromClient = inFromClient.readLine();
						if(lineFromClient == null)
							continue;


						if(lineFromClient.charAt(0) == 0x02) {
							state = EstadoProtocoloTCP.PROTOCOLO_NOVO_INICIADO;
							log.info(idLog, 0, "novo protocolo " + lineFromClient.toString());
						} else {
							state = EstadoProtocoloTCP.PROTOCOLO_OLD_FINALIZADO;
						}
						
						sb.append(lineFromClient).append("\n");

						
						/* alessandre em 09-08-2019
						o while abaixo esta muito estranho. pq le caracter por caracter???
						ja que a linha toda foi lido
						pq nao pegar apenas o ultimo caracter e testar???
						*/
						while(state == EstadoProtocoloTCP.PROTOCOLO_NOVO_INICIADO){
							int charFromClient = inFromClient.read();
							if(charFromClient == -1)
								break;

							if(charFromClient == 0x03) {
								state = EstadoProtocoloTCP.PROTOCOLO_NOVO_FINALIZADO;
							}
							sb.append((char)charFromClient);
						}
						
						
						
					} catch(SocketTimeoutException e) {
						state = EstadoProtocoloTCP.PROTOCOLO_ERRO;
						log.info(idLog, 0, "PROTOCOLO_ERRO");
					}
					if(state == EstadoProtocoloTCP.PROTOCOLO_ERRO)
						continue;
					
					String clientSentence = sb.toString();
					log.info(idLog, 0, "clientSentence: "  + clientSentence);
					
					if(isMensagemFinalizada(state) == false || clientSentence == null || clientSentence.length() < menorTamanhoPossivelDeMensagem)
						continue;
					
					String ip = identificaIpOrigemSocket(datasocket.getInetAddress());
					if (ip.equals("0.0.0.0"))
						ip = "localhost";
					
					TipoProtocoloTCP tipoTCP = TipoProtocoloTCP.PROTOCOLO_OLD;
					if(state == EstadoProtocoloTCP.PROTOCOLO_NOVO_FINALIZADO) {
						tipoTCP = TipoProtocoloTCP.PROTOCOLO_NOVO;
						log.info(idLog, 0, "NOVA MSG TCP - PROTOCOLO_NOVO");
					} else
						log.info(idLog, 0, "NOVA MSG TCP - PROTOCOLO_OLD");
					
					// Alessandre: Removi em 08-09-12 o envio da lista de Icdto
					// para a classe RecebeDadosPorta, visto
					// que ela podera obter essa lista do MsThread dentro do
					// Stubedelegate
					// Modificado para ter apenas uma thread por UP
					// Se nenhum foi identificado, entao tentar identificar pela
					// UP passada
					MensagemRecebida men = new MensagemRecebida(clientSentence, tipoTCP);
					
					String up = ProtocoloEntradaFactory.getInstancia(men).getCdUp(clientSentence);
					String mensagemLegivel = null;
					if(tipoTCP == TipoProtocoloTCP.PROTOCOLO_NOVO) {

						String sizeString = clientSentence.substring(1, 6);
						if(Integer.valueOf(sizeString) != (clientSentence.length()-7)) {
							sizeString = null;
							continue;
						}
							
						clientSentence = clientSentence.substring(6, clientSentence.length()-1);
						men = new MensagemRecebida(clientSentence, tipoTCP);
						
						mensagemLegivel = clientSentence.replace("\n", "");

						sizeString = null;

					} else if(tipoTCP == TipoProtocoloTCP.PROTOCOLO_OLD) {
						mensagemLegivel = clientSentence;
					}
					log.info(idLog, 0, "\nMENSAGEM_TCP FROM " + ip + " WITH " + mensagemLegivel);
					men.setNecessitaResposta(true);
					
					// Abre thread para tratar o dado recebido
					// RecebeDadosPorta trecdad = new
					// RecebeDadosPorta(clientSentence, log,
					// getMsIcDTOdaLista(ip));

					// Identifica o msicdto pelo IP de origem da mensagem
					IcDTO dadosicDTO = Stubedelegate.getInstancia().getMsthread().getMsIcDTOdaLista(ip);	
					if (dadosicDTO == null)
						dadosicDTO = Stubedelegate.getInstancia().getMsthread().getMsIcDTOdaListaByUp(up);
					if (dadosicDTO == null) {
						String macIHM = men.getUrlConexaoIhm();
						if(macIHM == null)
							macIHM = ip;
						dadosicDTO = Stubedelegate.getInstancia().getMsthread().getMsIcDTOdaListaByMacIHM(macIHM, up);
						macIHM = null;
					}
					
					// Nem todas as mensagens ter�o a up, nesse caso usar o ip
					// como referencia do gerente
					// a principio apenas o heartbeat nao possui up mas como ele
					// nao gera evento pode ser executado em paralelo
					if (up == null || (up != null && up.equals(""))) {
						up = ip;
					}
					if (clientSentence != null && clientSentence.equals("null") == false) {
						GerenteRecebeDadosPorta gerente = null;
						if (gerentesRecebeDados.containsKey(up)) {
							log.info("GerenteRecebeDados encontrado("+up+")");
							gerente = gerentesRecebeDados.get(up);
						}
						if (gerente == null || gerente.isExecutando() == false) {
							// Se a thread parou entao deve ser criada uma nova
							// para ela poder executar novamente
							gerente = new GerenteRecebeDadosPorta(up, ip, log, dadosicDTO);
							gerentesRecebeDados.put(up, gerente);
							gerente.addMensagemRecebida(men);
							gerente.start();
							log.info(idLog, 0, "GerenteRecebeDados iniciado para " + up);
						} else {
							if(dadosicDTO != null && dadosicDTO.getUrl_conexao().equals(ip) && dadosicDTO.getTp_ic().equals(MsIcTemplate.TpIc._TP_IC_Inova_StandAlone.getTpIc().intValue())) {
								log.info(idLog, 0, "Descartando por ja ter um evento sendo tratado pro StandAlone(" + ip + ")");
							} else {
								gerente.addMensagemRecebida(men);
							}
						}
					}

					// tentando reduzir consumo de memoria
					ip =  null;
					up = null;
				} catch (Exception e) {
					e.printStackTrace();
					log.info(idLog, 0, e);
				} finally {
					// Closing the socket
					if (datasocket != null) {
						try {
							inFromClient.close();
						} catch (Exception exc) {
							exc.printStackTrace();
							log.info(idLog, 0, exc);
						}
						try {
							datasocket.close();
						} catch (Exception exc) {
							exc.printStackTrace();
							log.info(idLog, 0, exc);
						}
						inFromClient = null;
						datasocket = null;
					}

					// Liberar memoria
					inFromClient = null;
					sb = null;
					lineFromClient = null;
					state = null;
				}
			}
			log.info("PAROU servidorTcp com SUCESSO");
		}
	}

	// Alessandre: Em 08-09-12, Os metodos IcDTO getMsIcDTOdaLista(String ipIc)
	// e IcDTO getMsIcDTOdaListaByUp(String mensagemString)
	// foram para a classe MsThread

	/*
	 * O metodo abaixo identifica o IP do cliente que enviou a mensagem para
	 * esse servidor IP
	 */
	private String identificaIpOrigemSocket(InetAddress inet) {
		StringBuilder ip = new StringBuilder("");
		ip.append(String.valueOf((int) (inet.getAddress()[0]) & 0x0000000FF));
		ip.append(".");
		ip.append(String.valueOf((int) (inet.getAddress()[1]) & 0x0000000FF));
		ip.append(".");
		ip.append(String.valueOf((int) (inet.getAddress()[2]) & 0x0000000FF));
		ip.append(".");
		ip.append(String.valueOf((int) (inet.getAddress()[3]) & 0x0000000FF));

		return ip.toString();
	}
}
