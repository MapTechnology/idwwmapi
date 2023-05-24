package ms.coleta.ic.flex;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.IdwFacade;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;
import idw.webservices.dto.CicloDTO;

public class ParadaAutomatica extends Thread{
	
	private final IdwLogger log;
	@SuppressWarnings("unused")
	private final int idLog;
	private boolean isExecutar = true;
	private IcUpDTO icUp;
	private Date dthrUltimaParada = null;
	private float limiteTempo = 120;
	private CicloDTO cicloDTO = null;
	private float cicloPadrao = 60;
	private float cicloTimeOut = 200;
	private boolean isParadaAberta = false;
	private EventosColetados eventos = new EventosColetados();
	private String op = "op";
	
	public ParadaAutomatica (IdwLogger log, int idLog, IcUpDTO icup){
		
		this.log = log;
		this.idLog = idLog;
		this.icUp = icup;
		
	}
	
	public void run(){
		
		
		while(isExecutar){
			
			paradaAutomatica();
			UtilsThreads.pausaNaThread(5000);
		}
		
		
	}
	
	public void paradaAutomatica(){
			
		if (dthrUltimaParada == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimaParada, DataHoraRN.getDataHoraAtual()) > limiteTempo && !isParadaAberta) {
			
				log.info("Enviando evento de parada automática para a UP: " + icUp.getUpDTO().getCd_up());
						
				EventoColetado ev = new EventoColetado();
				ev.setTipoEvento(ServicoFactory._INICIO_PARADA);
				ev.setIcUpDTO(icUp);
				ev.setCdop(op);
				ev.setCb("NS-"+icUp.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
				ev.setDthrEvento(DataHoraRN.getDataHoraAtual());
				ev.setOrigem("PARADA AUTOMATICA");
				ev.setCdparada("PARADA AUTOMATICA");
				this.eventos.addEventoColetado(ev);
				isParadaAberta = true;				
				dthrUltimaParada = DataHoraRN.getDataHoraAtual();
				
			}
			
		
	}
	
	public EventosColetados getParada(){
		return eventos;
	}
		
	public void getRefreshParada(EventosColetados ev){
		
		ev.addEventosColetados(eventos.getEventosColetados());
		
		eventos = new EventosColetados();		
		
	}
			
	public void fimParada (){
		
		if (isParadaAberta){
			
			log.info("Finalizando parada automática para a UP: " + icUp.getUpDTO().getCd_up());
						
			EventoColetado ev = new EventoColetado();
			ev.setTipoEvento(ServicoFactory._FIM_PARADA);
			ev.setIcUpDTO(icUp);
			ev.setCdop(op);
			ev.setCb("NS-"+icUp.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
			ev.setDthrEvento(DataHoraRN.getDataHoraAtual());
			ev.setOrigem("FIM PARADA AUTOMATICA");
			ev.setCdparada("PARADA AUTOMATICA");
			this.eventos.addEventoColetado(ev);
			dthrUltimaParada = DataHoraRN.getDataHoraAtual();
			isParadaAberta = false;
			
		}
		
		
		
	}
	
	public void setOpParadaECiclo(String op){
		log.info("OP setada para o evento de parada: " + op);
		this.op = op;
		dthrUltimaParada = DataHoraRN.getDataHoraAtual();
		getCiclos();
	}
	
	public void getCiclos(){
				
		try{
			cicloDTO = IdwFacade.getInstancia().getCicloTimeoutEPadrao(op,icUp.getUpDTO().getCd_up());
			Thread.sleep(500);
									
			log.info("Ciclo Padrao para op " + op + ": " + cicloDTO.getCicloPadrao() + " e ciclo timeout: " + cicloDTO.getEficienciaCiclo());
			
		}catch (Exception e ){
			log.info("Erro na tentativa de obtenção do ciclo padrão e ciclo timeout: " + e);
		}
		
		limiteTempo = cicloDTO.getCicloPadrao().floatValue() * ( cicloDTO.getEficienciaCiclo().floatValue()/ 100);
				
	}
	
	public void refresh(){
		dthrUltimaParada = DataHoraRN.getDataHoraAtual();
	}
	
	public void finaliza(){
		this.isExecutar = false;
		log.info("Parando a execução da thread de parada automatica");
	}

}
