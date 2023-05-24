package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwConsolvaritmolog;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTRitmo;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

import ms.coleta.dto.SessaoVarRitmoDTO;

public class ArquivoRitmos {
	private DwTRitmo dwtritmo = null;
	private DwConsolvaritmolog dwConsolritmolog = null;
	private DwRtcic dwRtcic = null;
	private IdwLogger log;

	private SessaoVarRitmoDTO varRitmoDTO;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOS]");
		arquivoInovaSA.addLineToBeWritten("CD=" + dwtritmo.getCdTritmo());
		arquivoInovaSA.addLineToBeWritten("DS=" + dwtritmo.getDsTritmo());
		if(dwtritmo.getOmTppt() != null)
			arquivoInovaSA.addLineToBeWritten("TPPT=" + dwtritmo.getOmTppt().getIdTppt());
		
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

		if(varRitmoDTO != null) {
			arquivoInovaSA.addLineToBeWritten("CD=" + varRitmoDTO.getCdVarRitmo());
			arquivoInovaSA.addLineToBeWritten("DS=" + varRitmoDTO.getDsVarRitmo());
			if(varRitmoDTO.getDthrIVarRitmo() != null)
				arquivoInovaSA.addLineToBeWritten("DTHRINI=" + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(varRitmoDTO.getDthrIVarRitmo()));
			arquivoInovaSA.addLineToBeWritten("ISVARABERTO=" + varRitmoDTO.isVarRitmoAberto());
			arquivoInovaSA.addLineToBeWritten("DURACAOCICLO=" + varRitmoDTO.getDuracao()*1000.0);
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}
	
	public DwTRitmo getDwtritmo() {
		return dwtritmo;
	}

	public void setDwtritmo(DwTRitmo dwtritmo) {
		this.dwtritmo = dwtritmo;
	}
	
	public DwConsolvaritmolog getDwConsolritmolog() {
		return dwConsolritmolog;
	}

	public void setDwConsolritmolog(DwConsolvaritmolog dwConsolritmolog) {
		this.dwConsolritmolog = dwConsolritmolog;
	}

	public DwRtcic getDwRtcic() {
		return dwRtcic;
	}

	public void setDwRtcic(DwRtcic dwRtcic) {
		this.dwRtcic = dwRtcic;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public SessaoVarRitmoDTO getVarRitmoDTO() {
		return varRitmoDTO;
	}

	public void setVarRitmoDTO(SessaoVarRitmoDTO varRitmoDTO) {
		this.varRitmoDTO = varRitmoDTO;
	}

}
