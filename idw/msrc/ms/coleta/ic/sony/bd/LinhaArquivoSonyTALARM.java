package ms.coleta.ic.sony.bd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ICSony;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoSonyTALARM {
	
	private int posDStartDateTime = EPosicoesBDTALARM.DSTARTDATETIME.getValue();
	private int posDEndDateTime = EPosicoesBDTALARM.DENDDATETIME.getValue();
	private int posSStatus = EPosicoesBDTALARM.SSTATUS.getValue();
	private int posSAlarmCode = EPosicoesBDTALARM.SALARMCODE.getValue();
	private int posSShopOrderNumber = EPosicoesBDTALARM.SSHOPORDERNUMBER.getValue();
	private int posSMachineId = EPosicoesBDTALARM.SMACHINEID.getValue();
	private int posSAlarmMessage = EPosicoesBDTALARM.SALARMMESSAGE.getValue();

	private String dStartDateTime;
	private String dEndDateTime;
	private String sStatus;
	private String sAlarmCode;
	private String sShopOrderNumber; 
	private String sMachineId;
	private String sAlarmMessage;
	
	private String origem;
	
	
	// Controle
	private String linha;
	private String linhaResumida;
	private String[] linhas;

	private IdwLogger log;
	// private int idLog;
	private ICSony ic;
	private IcUpDTO icUpDTO;
	
	private Map<String, LinhaArquivoSonyTALARM> ultimaParadaPorMachineID;
	
	public LinhaArquivoSonyTALARM(IdwLogger log, String linha, ICSony ic, IcUpDTO icUpDTO) {
		super();
		this.log = log;
		// idLog = log.getIdAleatorio();
		this.linha = linha;
		this.ic = ic;
		this.icUpDTO = icUpDTO;
		parseLinhaTratada();
	}

	private void parseLinhaTratada() {
		linhas =  idw.util.UtilsString.quebrarStringEmVetor(linha, ",").toArray(new String[0]);
		
		dStartDateTime = UtilsString.removeApas(linhas[posDStartDateTime]);
		dEndDateTime = UtilsString.removeApas(linhas[posDEndDateTime]);
		sStatus = UtilsString.removeApas(linhas[posSStatus]);
		sAlarmCode = UtilsString.removeApas(linhas[posSAlarmCode]);
		sShopOrderNumber = UtilsString.removeApas(linhas[posSShopOrderNumber]);
		sMachineId = UtilsString.removeApas(linhas[posSMachineId]);
		sAlarmMessage = UtilsString.removeApas(linhas[posSAlarmMessage]);
		
		origem = dStartDateTime + "," + dEndDateTime + "," + sStatus + "," + sAlarmCode + "," + sShopOrderNumber + "," + sMachineId;
		
	}
	
	@Override
	public String toString() {
		return (dStartDateTime + "," + dEndDateTime + "," + sStatus + "," + sAlarmCode + "," + sShopOrderNumber + "," + sMachineId);
	}

	public boolean isLinhaNoPadraoEsperado() {
		return (this.dStartDateTime != null) && (!this.dStartDateTime.equals("")) && (this.sStatus != null) && (!this.sStatus.equals(""))
				&& (this.sStatus.equals("ERROR"))
				//&& (this.sShopOrderNumber != null) && (!this.sShopOrderNumber.equals(""))
				;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		if(sStatus.equals("ERROR")) {
			
			LinhaArquivoSonyTALARM linhaAnteriorMesmaMaquina = ic.obtemUltimaLinhaTALARMDaMaquina(icUpDTO.getUpDTO().getCd_up());
			if (linhaAnteriorMesmaMaquina != null) {
				log.info("LinhaArquivoSonyTALARM: Ultima Linha obtida da mesma maquina: " + linhaAnteriorMesmaMaquina);
				// Verfica se a linha deve ser processada de acordo com a cronologia dos
				// eventos
				Date dateLinha = UtilsString.convertToDateLogSony(dStartDateTime);
				if (dateLinha.before(UtilsString.convertToDateLogSony(linhaAnteriorMesmaMaquina.getdStartDateTime())))
					return retorno;
			} else {
				log.info("LinhaArquivoSonyTALARM: Nao ha uma ultima Linha obtida da mesma maquina");
			}
			
			EventoColetado eventoInicioAlerta = geraEventoIniciAlerta();
			if (eventoInicioAlerta != null) {
				retorno.add(eventoInicioAlerta);
			}
			
			EventoColetado eventoRemoveAlerta = geraEventoRemoveAlerta();
			if (eventoRemoveAlerta != null) {
				retorno.add(eventoRemoveAlerta);
			}
			
			if (retorno.size() > 0) {
				ic.getUltimasLinhasProcessadasTALARM().put(icUpDTO.getUpDTO().getCd_up(), this);
			}
			
		}
		
		return retorno;
	}
	
	private EventoColetado geraEventoIniciAlerta() {
		EventoColetado evento = new EventoColetado();
		evento.setTipoEvento(ServicoFactory._INICIA_ALERTA);
		evento.setCdalerta(sAlarmCode);
		evento.setDthrEvento(UtilsString.convertToDateLogSony(dStartDateTime));
		evento.setCb(sAlarmMessage);
		// evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
		evento.setOrigem(linha);
		evento.setLog(log);
		evento.setIcUpDTO(icUpDTO);
		
		return evento;
	}
	
	private EventoColetado geraEventoRemoveAlerta() {
		if (!dEndDateTime.equals("")) {
			EventoColetado evento = new EventoColetado();
			
			evento.setTipoEvento(ServicoFactory._REMOVE_ALERTA);
			evento.setCdalerta(sAlarmCode);
			evento.setDthrEvento(UtilsString.convertToDateLogSony(dEndDateTime));
			// evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
			evento.setOrigem(linha);
			evento.setLog(log);
			evento.setIcUpDTO(icUpDTO);
			
			return evento;
		}
		return null;
	}
	
	// Codigo Original. Era utilziado para tentar lancar paradas a partir dos alarmes
//	public List<EventoColetado> obtemEvento() {
//		List<EventoColetado> retorno = new ArrayList<>();
//		
//		if(sStatus.equals("ERROR")) {
//			
//			LinhaArquivoSonyTALARM linhaAnteriorMesmoMachineID = obtemUltimaLinhaDaMachineID(getShopOrder(), getMachineID());
//			
//			EventoColetado eventoInicioParada = geraEventoInicioParada(linhaAnteriorMesmoMachineID);
//			if (eventoInicioParada != null) {
//				retorno.add(eventoInicioParada);
//			}
//			
//			EventoColetado eventoFimParada = geraEventoFimParada(linhaAnteriorMesmoMachineID);
//			if (eventoFimParada != null) {
//				retorno.add(eventoFimParada);
//			}
//			
//		}
//		
//		return retorno;
//	}

//	private EventoColetado geraEventoFimParada(LinhaArquivoSonyTALARM linhaAnteriorMesmoShopOrder) {
//		EventoColetado eventoColetado = null;
//		Date dateFimEventoAnterior = null;
//		
//		String dateFimParadaEventoAnterior = null;
//		
//		if(linhaAnteriorMesmoShopOrder != null)
//			dateFimParadaEventoAnterior = linhaAnteriorMesmoShopOrder.getdEndDateTime();
//		if((dateFimParadaEventoAnterior != null) && (!dateFimParadaEventoAnterior.equals(""))) {
//			dateFimEventoAnterior = UtilsString.convertToDateLogSony(dateFimParadaEventoAnterior);
//		}
//		
//		if((dEndDateTime != null) && (!dEndDateTime.equals(""))) {
//			
//			Date dateFimEvento = UtilsString.convertToDateLogSony(dEndDateTime);
//			
//			if(dateFimEventoAnterior != null) {
//				if(dateFimEvento.after(dateFimEventoAnterior)) {
//					eventoColetado = new EventoColetado();
//					
//					eventoColetado.setTipoEvento(ServicoFactory._FIM_PARADA); // Fim de Ciclo
//					eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dEndDateTime));
//					eventoColetado.setCdop(sShopOrderNumber);
//					eventoColetado.setCb("");
//					eventoColetado.setIcUpDTO(icUpDTO);
//					eventoColetado.setOrigem(origem);
//					
//					eventoColetado.setCdparada(sAlarmCode);
//				}
//				
//			} else {
//			
//				eventoColetado = new EventoColetado();
//				
//				eventoColetado.setTipoEvento(ServicoFactory._FIM_PARADA); // Fim de Ciclo
//				eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dEndDateTime));
//				eventoColetado.setCdop(sShopOrderNumber);
//				eventoColetado.setCb("");
//				eventoColetado.setIcUpDTO(icUpDTO);
//				eventoColetado.setOrigem(origem);
//				
//				eventoColetado.setCdparada(sAlarmCode);
//			}
//		}
//		
//		return eventoColetado;
//	}
//
//	private EventoColetado geraEventoInicioParada(LinhaArquivoSonyTALARM linhaAnteriorMesmoShopOrder) {
//		EventoColetado eventoColetado = null;
//		String dateFimParadaEventoAnterior = null;
//		
//		Date dateInicioEvento = UtilsString.convertToDateLogSony(dStartDateTime);
//		
//		if(linhaAnteriorMesmoShopOrder != null)
//			dateFimParadaEventoAnterior = linhaAnteriorMesmoShopOrder.getdEndDateTime();
//		
//		if((dateFimParadaEventoAnterior != null) && (!dateFimParadaEventoAnterior.equals(""))) {
//			
//			Date dateFimEventoAnterior = UtilsString.convertToDateLogSony(dateFimParadaEventoAnterior);
//			
//			if(dateInicioEvento.after(dateFimEventoAnterior)) {
//				
//				eventoColetado = new EventoColetado();		
//				eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA); // Fim de Ciclo
//				eventoColetado.setDthrEvento(dateInicioEvento);
//				eventoColetado.setCdop(sShopOrderNumber);
//				eventoColetado.setCb("");
//				eventoColetado.setIcUpDTO(icUpDTO);
//				eventoColetado.setOrigem(origem);
//				
//				eventoColetado.setCdparada(sAlarmCode);
//			}
//		} else if(linhaAnteriorMesmoShopOrder == null) {
//			
//			eventoColetado = new EventoColetado();		
//			eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA); // Fim de Ciclo
//			eventoColetado.setDthrEvento(dateInicioEvento);
//			eventoColetado.setCdop(sShopOrderNumber);
//			eventoColetado.setCb("");
//			eventoColetado.setIcUpDTO(icUpDTO);
//			eventoColetado.setOrigem(origem);
//			
//			eventoColetado.setCdparada(sAlarmCode);
//		}
//		
//		return eventoColetado;
//	}

	private String getMachineID() {
		return sMachineId;
	}

	public String getShopOrder() {
		return sShopOrderNumber;
	}

	protected String getdStartDateTime() {
		return dStartDateTime;
	}

	protected void setdStartDateTime(String dStartDateTime) {
		this.dStartDateTime = dStartDateTime;
	}

	protected String getdEndDateTime() {
		return dEndDateTime;
	}

	protected void setdEndDateTime(String dEndDateTime) {
		this.dEndDateTime = dEndDateTime;
	}

	protected String getsStatus() {
		return sStatus;
	}

	protected void setsStatus(String sStatus) {
		this.sStatus = sStatus;
	}

	protected String getsAlarmCode() {
		return sAlarmCode;
	}

	protected void setsAlarmCode(String sAlarmCode) {
		this.sAlarmCode = sAlarmCode;
	}

	protected String getsShopOrderNumber() {
		return sShopOrderNumber;
	}

	protected void setsShopOrderNumber(String sShopOrderNumber) {
		this.sShopOrderNumber = sShopOrderNumber;
	}

	protected String getsMachineId() {
		return sMachineId;
	}

	protected void setsMachineId(String sMachineId) {
		this.sMachineId = sMachineId;
	}

	protected String getOrigem() {
		return origem;
	}

	protected void setOrigem(String origem) {
		this.origem = origem;
	}

	protected String getLinha() {
		return linha;
	}

	protected void setLinha(String linha) {
		this.linha = linha;
	}

	protected String getLinhaResumida() {
		return linhaResumida;
	}

	protected void setLinhaResumida(String linhaResumida) {
		this.linhaResumida = linhaResumida;
	}

	protected String[] getLinhas() {
		return linhas;
	}

	protected void setLinhas(String[] linhas) {
		this.linhas = linhas;
	}

	protected IdwLogger getLog() {
		return log;
	}

	protected void setLog(IdwLogger log) {
		this.log = log;
	}

	protected ICSony getIc() {
		return ic;
	}

	protected void setIc(ICSony ic) {
		this.ic = ic;
	}

	protected IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	protected void setIcUpDTO(IcUpDTO icUpDTO) {
		this.icUpDTO = icUpDTO;
	}

	protected Map<String, LinhaArquivoSonyTALARM> getUltimaParadaPorOP() {
		return ultimaParadaPorMachineID;
	}

	protected void setUltimaParadaPorOP(
			Map<String, LinhaArquivoSonyTALARM> ultimaParadaPorOP) {
		this.ultimaParadaPorMachineID = ultimaParadaPorOP;
	}

}
