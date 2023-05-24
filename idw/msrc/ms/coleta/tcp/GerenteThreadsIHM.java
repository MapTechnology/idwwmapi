package ms.coleta.tcp;


import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;

import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.dto.MensagemEnviada;

public class GerenteThreadsIHM {
	
		List<BufferThreadIHM> listaBufferThreadIHM = null;	
		private final Semaphore listaAvailable = new Semaphore(1);

		public GerenteThreadsIHM() {			
		}
		
		protected void getListaSemaphore() {
			try {
				listaAvailable.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		protected void releaseMsgSemaphore() {
			listaAvailable.release();
		}

		public void enviaMensagem(String ip,int porta,MensagemEnviada mensagem,int idLog,int identacao){
			if(mensagem.getMensagemRecebida() == null)
				return;
			ClienteRegistrado cliente= new ClienteRegistrado();
			cliente.setIp(ip);
			cliente.setPorta(porta);
			enviaMensagem(cliente, mensagem, idLog, identacao);
		}

		public void enviaMensagem(ClienteRegistrado cliente,MensagemEnviada mensagem,int idLog,int identacao){
			BufferThreadIHM instancia = null;
			try{
				getListaSemaphore();
				if(listaBufferThreadIHM==null){
					listaBufferThreadIHM=new ArrayList<BufferThreadIHM>();
				}
				if(listaBufferThreadIHM.size()>0){
					for(BufferThreadIHM buffer : listaBufferThreadIHM){
						try{
							if(buffer.getCliente().getIp().equals(cliente.getIp())){
								if((buffer.getCliente().getPorta()!=cliente.getPorta()) || 
									(DataHoraRN.getQuantidadeMilisegundosNoPeriodo(buffer.getDataRefReconexao(), new Date()) > BufferThreadIHM._TIMEOUT_VIDA_CONEXAO)
										){
									buffer.setCliente(cliente);
								}
								instancia=buffer;
								break;
							}
						} catch(NullPointerException e) {
							continue;
						}
					}
				}
				if(instancia==null){
					instancia = new BufferThreadIHM(cliente,new IdwLogger("Gerente_"+cliente.getIp()), idLog, identacao);
					instancia.start();
					listaBufferThreadIHM.add(instancia);				
				}
				instancia.insereMensagemnoBuffer(mensagem);		
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				releaseMsgSemaphore();
			}
		}
		
		
		public void setReconectar(String ip,int porta,int idLog,int identacao){
			ClienteRegistrado cliente= new ClienteRegistrado();
			cliente.setIp(ip);
			if(porta==0)
				porta=8221; //provisório apenas como teste
			cliente.setPorta(porta);
			setReconectar( cliente, idLog,identacao);
		}
		
		public void setReconectar(ClienteRegistrado cliente,int idLog,int identacao){
			BufferThreadIHM instancia = null;
			getListaSemaphore();
			if(listaBufferThreadIHM==null){
				listaBufferThreadIHM=new ArrayList<BufferThreadIHM>();
			}
			if(listaBufferThreadIHM.size()>0){
				for(BufferThreadIHM buffer : listaBufferThreadIHM){
					if(buffer.getCliente().getIp().equals(cliente.getIp())){						
						buffer.setCliente(cliente);
						instancia=buffer;
						break;
					}
				}
			}
			if(instancia==null){
				instancia = new BufferThreadIHM(cliente,new IdwLogger("Gerente_"+cliente.getIp()), idLog, identacao);
				instancia.start();
				listaBufferThreadIHM.add(instancia);				
			}
			releaseMsgSemaphore();
		}

}
