package ms.coleta.ic.aoikyzl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import idw.model.pojos.aoiky.TB_AOIResult;
import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;


public class WatcherTriggerAoiKyZl extends Thread  {
	
	private final IdwLogger log;
	private final int idLog;
	private boolean isExecutandoWatcher = true;
	private IcUpDTO icUp;
	protected final AoiKyZlSqlRN tratador;
	private BufferedEventos bufferEventos;
	
	public WatcherTriggerAoiKyZl(IdwLogger log, int idLog, IcUpDTO icup, AoiKyZlSqlRN tratador ){
		
		this.log = log;
		this.idLog = idLog;
		this.icUp = icup;
		this.tratador = tratador;
		
		
	}
	
	@Override
	public void run(){
		
		List<TB_AOIResult> linhasResult = new ArrayList<TB_AOIResult>();
		List<ResultDefeitoDetailDTO> linhasUteis = new ArrayList<ResultDefeitoDetailDTO>();
		Iterator<Object> iterator = null;
						
		while(isExecutandoWatcher){
			List<EventoColetado> eventos = new ArrayList<>();
			try{
				tratador.iniciaConexaoBanco();
				log.info("Sucesso na conexão com o banco");
			} catch (Exception e){
				log.info("Erro na criação do watcher. Exceção em WatcherTrigger: " + e);
				UtilsThreads.pausaNaThread(60000);
			}			
			

			try{
				
				linhasResult = tratador.getAoiResult();
				log.info("Obtenção dos dados das ultimas placas");
								
				EventoColetado eventoObtido = null;
						
				tratador.setBufferEvento(this.bufferEventos);
				if(tratador.getUltimaLinha() == null){
					for(TB_AOIResult linha:linhasResult){
						
						if(linha.getPCBResultBefore() == 13000000 && linha.getPCBResultAfter() != 12000000){
							
							iterator = tratador.joinResultDefeitoDetail(linha.getPcbGuid());
							eventoObtido = tratador.criaEventoColetadoTesteDefeito(iterator, icUp, log);
							log.info("Criação de evento de teste com defeito: " + linha.getAllBarCode() + "-" + linha.getPCBResultBefore());
						}else {
							eventoObtido = tratador.criaEventoColetadoTesteSimples(linha, icUp, log);
							
							log.info("Criação de evento de teste simples " + linha.getAllBarCode() + "-" + linha.getPCBResultBefore());
							}
						eventos.add(eventoObtido);	
						
						}
					
																
					}else{
						
						for(TB_AOIResult linha:linhasResult){
							
							if(linha.getPcbId() > tratador.getUltimaLinha().getPcbId()){
							
							if(linha.getPCBResultBefore() == 13000000 && linha.getPCBResultAfter() != 12000000){
								
								iterator = tratador.joinResultDefeitoDetail(linha.getPcbGuid());
								eventoObtido = tratador.criaEventoColetadoTesteDefeito(iterator, icUp, log);
								log.info("Criação de evento de teste com defeito: " + linha.getAllBarCode() + "-" + linha.getPCBResultBefore());
							}else {
								eventoObtido = tratador.criaEventoColetadoTesteSimples(linha, icUp, log);
								log.info("Criação de evento de teste simples " + linha.getAllBarCode() + "-" + linha.getPCBResultBefore());
								}
							eventos.add(eventoObtido);	
							
							}
						}
												
						
					}
				tratador.setUltimaLinha(linhasResult.get(0));
				if (eventos.isEmpty() == false)
					bufferEventos.addEventos(eventos);
				tratador.finalizaConexaoBanco();
				log.info("Conexão com o banco finalizada");
				//Pausa de 3min HABLITAR PARA COMMIT
				//UtilsThreads.pausaNaThread(180000);
				UtilsThreads.pausaNaThread(180000);
				
				try{
					tratador.finalizaConexaoBanco();
					log.info("Foi possível finalizar uma sessão");
				}catch(Exception e){
					e.printStackTrace();
					log.info("Conexão com o banco já finalizada");
					
				}
							
			}catch(Exception e){
				e.printStackTrace();
				log.info("Erro no tratamento de dados. Exceção em WatcherTrigger: " + e);
				UtilsThreads.pausaNaThread(180000);
			}
					
		}
		
	}
	
	public void setBufferedEventos(BufferedEventos bev) {
		this.bufferEventos = bev;
	}
	
	public void finalizaWatcher(){
		this.isExecutandoWatcher = false;
		log.info("Parando a execução do watcher");
		
		try{
			tratador.finalizaConexaoBanco();
			log.info("Foi possível finalizar uma sessão");
		}catch(Exception e){
			e.printStackTrace();
			log.info("Conexão com o banco já finalizada");
			
		}
	}
	
		

	
	
	
	
}
