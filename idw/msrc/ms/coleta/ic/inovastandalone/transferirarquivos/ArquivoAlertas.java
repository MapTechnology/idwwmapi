package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.OmPt;
import idw.util.IdwLogger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import ms.coleta.dto.SessaoAlertaDTO;

public class ArquivoAlertas {
	
	private DwTAlerta dwtalerta;
	private OmPt ompt = null;
	private String cdAlerta;
	private String dsAlerta;
	private boolean isAutomatico;
	private List<DwConsolallog> alertas;
	private IdwLogger log;
	
	private List<SessaoAlertaDTO> alertasDTO;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {

		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOS]");
		if(dwtalerta.getDsTalerta() != null ) {
			arquivoInovaSA.addLineToBeWritten("DS=" + dwtalerta.getDsTalerta());
		} else {
			arquivoInovaSA.addLineToBeWritten("DS=NULL");
		}
		arquivoInovaSA.addLineToBeWritten("ISTIMEOUT=" + dwtalerta.getIsTimeout());
		arquivoInovaSA.addLineToBeWritten("ISAUTOMATICO=" + dwtalerta.getIsAutomatico());
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public boolean gerarArquivoStatus(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOS]");
		arquivoInovaSA.addLineToBeWritten("QTD=" + alertasDTO.size()); 
		int i = 1;
		for(SessaoAlertaDTO item : alertasDTO){
			arquivoInovaSA.addLineToBeWritten("[ALERTA"+ i + "]");
			arquivoInovaSA.addLineToBeWritten("CD=" + item.getCdAlerta());
			arquivoInovaSA.addLineToBeWritten("DS=" + item.getDsAlerta());	
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
			arquivoInovaSA.addLineToBeWritten("DTHR=" + dateFormat.format(item.getDthrIAlerta()));
			arquivoInovaSA.addLineToBeWritten("ISTIMEOUT=" + item.isTimeout());
			arquivoInovaSA.addLineToBeWritten("ISAUTOMATICO=" + item.isAutomatico());
			i++;
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}
	
	public DwTAlerta getDwtalerta() {
		return dwtalerta;
	}

	public void setDwtalerta(DwTAlerta dwtalerta) {
		this.dwtalerta = dwtalerta;
	}

	public OmPt getOmpt() {
		return ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public String getCdAlerta() {
		return cdAlerta;
	}

	public void setCdAlerta(String cdAlerta) {
		this.cdAlerta = cdAlerta;
	}

	public String getDsAlerta() {
		return dsAlerta;
	}

	public void setDsAlerta(String dsAlerta) {
		this.dsAlerta = dsAlerta;
	}

	public boolean isAutomatico() {
		return isAutomatico;
	}

	public void setAutomatico(boolean isAutomatico) {
		this.isAutomatico = isAutomatico;
	}

	public List<DwConsolallog> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<DwConsolallog> alertas) {
		this.alertas = alertas;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public List<SessaoAlertaDTO> getAlertasDTO() {
		return alertasDTO;
	}

	public void setAlertasDTO(List<SessaoAlertaDTO> alertasDTO) {
		this.alertasDTO = alertasDTO;
	}

}
