package ms.coleta.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.dto.MensagemEnviada;
import ms.util.UtilsThreads;

public class BufferThreadIHM extends Thread{
	
	private static final int LIMITE_BUFFER=200;
	private static final int _TIMEOUT = 1000;
	public static final int _TIMEOUT_VIDA_CONEXAO = 60000;
	
	private boolean isThreadExecutando=false;
	private ClienteRegistrado cliente;
	private int idLog;
	private int identacao;
	private boolean isDeveReconectar=false;
	private boolean isConectado=false;
	private List<MensagemEnviada> bufferMensagens=null;
	private final Semaphore msgAvailable = new Semaphore(1);
	private Socket clientSocket;
	private DataOutputStream outToIHM;
	private BufferedReader inFromIHM;
	private IdwLogger log = null;
	private Date ultimoEnvioComSucesso=new Date();
	private SocketAddress endereco;
	private Date dataRefReconexao= new Date();
	
		
	public Date getDataRefReconexao() {
		return dataRefReconexao;
	}
	

	public ClienteRegistrado getCliente() {
		return cliente;
	}

	public void setCliente(ClienteRegistrado cliente) {
		this.cliente = cliente;
		this.isDeveReconectar=true;
		this.dataRefReconexao=new Date();
	}

	public void insereMensagemnoBuffer(MensagemEnviada mensagem) {
		
			getMsgSemaphore();
			
			if( bufferMensagens==null){
				bufferMensagens=new ArrayList<MensagemEnviada>();
			}
			if(this.bufferMensagens.size() < LIMITE_BUFFER){
				mensagem.setDataRefMensagemEnviada(new Date());
				this.bufferMensagens.add(mensagem);	
			}else{
				log.info(idLog, identacao, "Limite de dados no Buffer atingido " + cliente.getIp() + ":" + cliente.getPorta() + " mensagem sera desprezada [" + this.bufferMensagens.get(0).getMensagemASerTransmitida() + "]");
			}
			releaseMsgSemaphore();
	}
	
		
	public BufferThreadIHM(ClienteRegistrado cliente,IdwLogger log,int idLog,int identacao) {
		this.cliente=cliente;
		this.log=log;
		this.idLog=idLog;
		this.identacao=identacao;
		this.setName("BufferThreadIHM_" + cliente.getIp());	
		this.isDeveReconectar=true;
	}
	
	public void pararThread(){
		isThreadExecutando=false;
	}
	
	protected void getMsgSemaphore() {
		try {
			msgAvailable.acquire();
		} catch (InterruptedException e) {
			if (log!=null)log.info("Nao adiquiriu flag>", e);
		}
	}

	protected void releaseMsgSemaphore() {
		msgAvailable.release();
	}
	
	protected void fechaConexoes(){
		
		try{
			if(outToIHM!=null){
				outToIHM.close();
			}
		}catch(Exception e1){
			log.info("Erro Ao fechar OutToIHM",e1);
		}

		try{
			if(inFromIHM!=null)
				inFromIHM.close();		
		}catch(Exception e2){
			log.info("Erro Ao fechar inFromIHM",e2);
		}

		try{
			if((clientSocket!=null) && (clientSocket.isClosed()==false)){
				clientSocket.close();	
			}
		}catch(Exception e3){
			log.info("Erro Ao fechar clientSocket",e3);
		}
		
		outToIHM=null;
		inFromIHM=null;
		clientSocket=null;
	}

	private void trataMensagensDoBufferIHM(){
		
		try{
			/* Alessandre em 23-03-16 comentado o if abaixo e outros trechos para remover a reconexao a cada envio de mensagem
			 * A ideia eh conectar apenas uma vez e reconectar a cada perda de conexao
			 * 
			 * Descomentei o if para forcar a reabertura da porta, fiz isso para avaliar pq a demora do servidor no OM
			 * receber uma mensagem. Confirmado: apos fechar a conexao e reabir sempre, o OM passou a receber as mensagens imediatamente
			 */
			if((this.bufferMensagens != null) &&	(this.bufferMensagens.size()>0)){	
				this.isDeveReconectar=true; // Apenas para forcar a reconexao para o caso de ter mensagens pendentes de envio
			}
			if( 
					clientSocket==null || 
					clientSocket.isClosed()==true || 
					isDeveReconectar==true || 
					isConectado==false || 
					clientSocket.isOutputShutdown()==true ){
				
				endereco = new InetSocketAddress(cliente.getIp(), cliente.getPorta());
				fechaConexoes();
				
				//log.info(idLog, identacao, "Efetuando nova Conexao com " + cliente.getIp() + ":" + cliente.getPorta());

				clientSocket = new Socket();
				clientSocket.setReuseAddress(false);
				clientSocket.setKeepAlive(false);
				clientSocket.connect(endereco, _TIMEOUT);
				//log.info(idLog, identacao, "Porta local " + clientSocket.getLocalPort());
				//log.info(idLog, identacao, "Abrindo dataoutputstream");
				outToIHM = new DataOutputStream(clientSocket.getOutputStream());
				//log.info(idLog, identacao, "dataoutputstream aberto");
				this.isConectado = clientSocket.isConnected();
				isDeveReconectar=false;
			}			
		

			//log.info(idLog, identacao, "liberando semaforo");
			getMsgSemaphore();
			
			if ((this.isConectado==true)) {
				if((this.bufferMensagens != null) &&	(this.bufferMensagens.size()>0)){
					String mensagemASerTransmitida = this.bufferMensagens.get(0).getMensagemASerTransmitida();
					String mensagemLegivel = mensagemASerTransmitida.replace("\n", "");
					log.info(idLog, identacao, "Enviando para " + cliente.getIp() + ":" + cliente.getPorta() + " mensagem [" + mensagemLegivel + "]");
					//System.out.println("Enviando para " + cliente.getIp() + ":" + cliente.getPorta() + " mensagem [" + mensagemLegivel + "]");
					// Alessandre em 23-9-14 substitui o writeUTF por writeBytes pois quando a msg era muito grande nï¿½o chegava ao cliente apesar de nao ocorrer uma excessao no server
					outToIHM.writeBytes(mensagemASerTransmitida);
					outToIHM.flush();
								
					log.info(idLog, identacao, "SUCESSO no envio para " + cliente.getIp() + ":" + cliente.getPorta());
					
					ultimoEnvioComSucesso=new Date();
					if(this.bufferMensagens.get(0).getDataRefMensagemEnviada() != null)
						log.info("Tempo para envio de mensagem = " + DataHoraRN.getQuantidadeMilisegundosNoPeriodo(this.bufferMensagens.get(0).getDataRefMensagemEnviada(), ultimoEnvioComSucesso) + "ms");
					
					this.bufferMensagens.remove(0);
					
				} 
				//else
				//	log.info(idLog, identacao, "buffer vazio");
			} else
				log.info(idLog, identacao, "isConectado false");
		}catch (Exception e) {			
//			e.printStackTrace();
			//System.out.println("FALHOU no envio para " + cliente.getIp() + ":" + cliente.getPorta()+" exc:"+e.getMessage());
			log.info(idLog, identacao, "FALHOU no envio para " + cliente.getIp() + ":" + cliente.getPorta()+" exc:"+e.getMessage());
			log.info("Erro", e);
			
			this.isConectado = false;
			
		} finally {
			// Alessandre em 05-04-16 comentei a linha abaixo que eu havia inserido algum tempo atras
			// Pelo fato de estar sempre fechando a conexao, mesmo qdo nao existe nenhum dado para ser enviado, causa
			// algum problema. Acredito que é falta de porta pra conectar
			//fechaConexoes();

			if((this.bufferMensagens != null)&&
			   ((DataHoraRN.getQuantidadeMilisegundosNoPeriodo(ultimoEnvioComSucesso, new Date())>120)||
				(this.bufferMensagens.size()==0))){
				
				if(this.bufferMensagens.size()>0){
					log.info(idLog, identacao, "Limpando Lista de "+this.bufferMensagens.size()+" eventos pendentes de envio para " + cliente.getIp() + ":" + cliente.getPorta());
				}
				
				//Garante a limpeza e liberacao de memoria;
				this.ultimoEnvioComSucesso=new Date();// Para evitar limpeza cont�nua do buffer
				this.bufferMensagens.clear();
				this.bufferMensagens=null;
			}
						
			releaseMsgSemaphore();
		}
	}
	
	public void run() {
		setPriority(Thread.NORM_PRIORITY);
		isThreadExecutando=true;
		log.info("Inciando a "+this.getName());
		do {
			try {
				if(cliente==null){
					log.info(this.getName()+" abortada por falta de parametros");
					isThreadExecutando=false;
				}
				else{		
					
					//Envia mensagens da lista						
					trataMensagensDoBufferIHM();					
					
					if(this.isConectado==false)
						UtilsThreads.pausaNaThread(100);
					else
						UtilsThreads.pausaNaThread(50);
					
				}
				if(Stubedelegate.getInstancia().getMsthread().isAlive()==false){
					log.info("Fechando a "+this.getName()+" pois a MsThread parece nao estar mais viva.");
					fechaConexoes();
					this.isThreadExecutando=false;
				}
			} catch (Exception e) {
				this.isConectado = true;
			}
		}while(this.isThreadExecutando);
		log.info("Fechando a "+this.getName());
	}

}
