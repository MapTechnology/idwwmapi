package ms.coleta.ic.sony.bd;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ICSony;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoSonyTDOWNTIME {
	
	private IdwLogger log;
	private ICSony ic;
	private IcUpDTO icUpDTO;

	private String linha;
	
	// Posicoes
	private int posDDateTime = 0;
	private int posNDownTimeCode = 3;
	private int posSDownTimeName = 4;
	private int posSMachineId = 6;
	private int posDuration = 8;
	
	// Valores
	private String dDateTime;
	private String nDownTimeCode;
	private String sDownTimeName;
	private String sMachineId;
	private String duration;
	
	private String[] valoresLinha;
	private String linhaResumida;

	public LinhaArquivoSonyTDOWNTIME(IdwLogger log, ICSony ic, IcUpDTO icUpDTO, String linha) {
		super();
		this.log = log;
		this.ic = ic;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		
		parseLinhaTratada();
	}

	private void parseLinhaTratada() {
		valoresLinha =  idw.util.UtilsString.quebrarStringEmVetor(linha, ",").toArray(new String[0]);
		
		this.dDateTime = UtilsString.removeApas(valoresLinha[posDDateTime]);
		this.nDownTimeCode = UtilsString.removeApas(valoresLinha[posNDownTimeCode]);
		this.sDownTimeName = UtilsString.removeApas(valoresLinha[posSDownTimeName]);
		this.sMachineId = UtilsString.removeApas(valoresLinha[posSMachineId]);
		this.duration = UtilsString.removeApas(valoresLinha[posDuration]);
		
		linhaResumida = toString();
	}

	@Override
	public String toString() {
		return (dDateTime + "," + nDownTimeCode + "," + sDownTimeName + ","  + sMachineId + "," + duration);
	}
	
	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public boolean isLinhaNoPadraoEsperado() {
		if ( (dDateTime != null ) && (nDownTimeCode != null) && (sDownTimeName != null) && (sMachineId != null) && (duration != null))
			return true;
		return false;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		// ------------------------------------------
		// Inicio de Parada + Fim de Parada
		EventoColetado eventoInicioParada = geraEventoInicioParada();
		if (eventoInicioParada != null) {
			retorno.add(eventoInicioParada);
			log.info("EventoLogSony: Gerou evento de Inicio de Parada:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoInicioParada.getDthrEvento()) 
					+ ";" + eventoInicioParada.getCdop());
		}
		
		EventoColetado eventoFimParada = geraEventoFimParada();
		if (eventoInicioParada != null && eventoFimParada != null) {
			retorno.add(eventoFimParada);
			log.info("EventoLogSony: Gerou evento de Fim de Parada:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoFimParada.getDthrEvento()) 
					+ ";" + eventoFimParada.getCdop());
		}
		if (retorno.size() > 0)
			ic.getUltimasLinhasProcessadasTDOWNTIME().put(icUpDTO.getUpDTO().getCd_up(), this);
		
		return retorno;
	}
	
	private EventoColetado geraEventoInicioParada() {
		Date dateInicioParada = UtilsString.convertToDateLogSony(dDateTime);
		
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA); // Inicio de Parada
		eventoColetado.setDthrEvento(dateInicioParada);
		// eventoColetado.setCdop(shopOrder);
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(linhaResumida);
		eventoColetado.setCdparada(nDownTimeCode);
		eventoColetado.setCb(sDownTimeName);
		
		return eventoColetado;
	}
	
	private EventoColetado geraEventoFimParada() {
		Date dateInicioParada = UtilsString.convertToDateLogSony(dDateTime);
		// long longDateFimParada = dateInicioParada.getTime() + safeParseToInt(duration) * 60 * 1000;
		// o tempo de duration nao vai ser mais considerado como minutos e sim como segundos
		// long longDateFimParada = dateInicioParada.getTime() + safeParseToInt(duration) * 1000;
		// o tempo de duration nao vai ser mais considerado como segundos e sim como minutos
		long longDateFimParada = dateInicioParada.getTime() + safeParseToInt(duration) * 60 * 1000;
		Date dateFimParada = new Date(longDateFimParada);
		
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._FIM_PARADA); // Fim de Parada
		eventoColetado.setDthrEvento(dateFimParada);
		// eventoColetado.setCdop(shopOrder);
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(linhaResumida);
		eventoColetado.setCdparada(nDownTimeCode);
		eventoColetado.setCb(sDownTimeName);
		
		return eventoColetado;
	}


	int safeParseToInt(String valor) {
		int retorno = 0;
		try {
			retorno = Integer.parseInt(valor);
		} catch (Exception e) {
			log.error("Falha ao realizar o parser do valor: " + valor + " da linha " + toString());
			log.error("Excecao: " + e.toString());
			retorno = 0;
		}
		return retorno;
	}
	
}
