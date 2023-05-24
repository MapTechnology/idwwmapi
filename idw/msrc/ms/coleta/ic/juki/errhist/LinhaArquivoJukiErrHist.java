package ms.coleta.ic.juki.errhist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.juki.ICJuki;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoJukiErrHist {
	private IdwLogger log;
	private ICJuki ic;
	private IcUpDTO icUpDTO;
	private Date lastModificationDate;
	private String line;
	
	private String dateFile;
	private String errorCode;
	private String errorDescription;
	private String origem;

	public LinhaArquivoJukiErrHist(IdwLogger log, String linha, ICJuki ic, IcUpDTO icUpDTO, Date dataUltimaModificacao) {
		this.log = log;
		this.line = linha;
		this.ic = ic;
		this.icUpDTO = icUpDTO;
		this.lastModificationDate = dataUltimaModificacao;
		parserLine();
	}

	private void parserLine() {
		origem = line;
		dateFile = line.substring(1, 20);
		errorCode = line.substring(22, 29);
		errorDescription = line.substring(29);
	}

	public boolean isLinhaNoPadraoEsperado() {
		if (line.length() > 3 && line.substring(0, 3).equals(" 20"))
			return true;
		return false;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		EventoColetado eventoInicioAlerta = geraEventoIniciAlerta();
		if (eventoInicioAlerta != null) {
			retorno.add(eventoInicioAlerta);
		}
		
		EventoColetado eventoRemoveAlerta = geraEventoRemoveAlerta();
		if (eventoRemoveAlerta != null) {
			retorno.add(eventoRemoveAlerta);
		}
		
		if (retorno.size() > 0) {
			ic.getUltimasLinhasProcessadasErrHist().put(icUpDTO.getUpDTO().getCd_up(), this);
		}
		
		return retorno;
	}

	private EventoColetado geraEventoRemoveAlerta() {
		EventoColetado evento = new EventoColetado();
		Date inicioAlerta = UtilsString.convertStringToDate(dateFile);
		Date fimAlerta = new Date(inicioAlerta.getTime() + 100);
		
		evento.setTipoEvento(ServicoFactory._REMOVE_ALERTA);
		evento.setCdalerta(errorCode);
		evento.setDthrEvento(fimAlerta);
		evento.setCb(errorDescription);
		// evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
		evento.setOrigem(line);
		evento.setLog(log);
		evento.setIcUpDTO(icUpDTO);
		
		return evento;
	}

	private EventoColetado geraEventoIniciAlerta() {
		EventoColetado evento = new EventoColetado();
		evento.setTipoEvento(ServicoFactory._INICIA_ALERTA);
		evento.setCdalerta(errorCode);
		evento.setDthrEvento(UtilsString.convertStringToDate(dateFile));
		evento.setCb(errorDescription);
		// evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
		evento.setOrigem(line);
		evento.setLog(log);
		evento.setIcUpDTO(icUpDTO);
		
		return evento;
	}

	public String getLinha() {
		return line;
	}

}
