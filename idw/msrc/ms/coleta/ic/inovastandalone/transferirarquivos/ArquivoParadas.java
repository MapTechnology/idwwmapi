package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwTParada;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

import ms.coleta.dto.SessaoParadaDTO;

public class ArquivoParadas   {

	private DwTParada dwtparada;
	private DwConsolpalog dwConsolpalog;
	private IdwLogger log;

	private SessaoParadaDTO sessaoParada;

	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOSPARADA]");
		if(dwtparada.getCdTparada()!=null) {
			arquivoInovaSA.addLineToBeWritten("CDPAR=" + dwtparada.getCdTparada());	
		} else {
			arquivoInovaSA.addLineToBeWritten("CDPAR=NULL");
		}
		if(dwtparada.getDsTparada()!=null ) {
			arquivoInovaSA.addLineToBeWritten("DSPAR=" + dwtparada.getDsTparada());	
		} else {
			arquivoInovaSA.addLineToBeWritten("DSPAR=NULL");
		}
		arquivoInovaSA.addLineToBeWritten("TPPT=" + dwtparada.getOmTppt().getIdTppt());
		
		arquivoInovaSA.addLineToBeWritten("[REQUSITOSPARADA]");
		arquivoInovaSA.addLineToBeWritten("ISREQCAUSA=" + dwtparada.getIsRequerCausa());
		arquivoInovaSA.addLineToBeWritten("ISREQACAO=" + dwtparada.getIsRequerAcao());
		arquivoInovaSA.addLineToBeWritten("ISREQJUST=" + dwtparada.getIsRequerJust());
		arquivoInovaSA.addLineToBeWritten("QTTEC=" + dwtparada.getQtTec());
		arquivoInovaSA.addLineToBeWritten("[ATRIBUTOSPARADA]");
		arquivoInovaSA.addLineToBeWritten("ISPERMITECORRECAO=" + dwtparada.getIsPermitecorrecao());
		arquivoInovaSA.addLineToBeWritten("ISPESA=" + dwtparada.getIsPesa());
		arquivoInovaSA.addLineToBeWritten("ISREGULAGEM=" + dwtparada.getIsRegulagem());
		if(dwtparada.getSegTimeoutalerta() != null)
			arquivoInovaSA.addLineToBeWritten("TIMEOUTALERTA=" + (dwtparada.getSegTimeoutalerta().doubleValue()));
		if(dwtparada.getDwTAlerta() != null)
			arquivoInovaSA.addLineToBeWritten("CDALERTA=" + dwtparada.getDwTAlerta().getCdTalerta());
		if(dwtparada.getSegExtrapolacao() != null)
			arquivoInovaSA.addLineToBeWritten("EXTRAPOLACAO=" + (dwtparada.getSegExtrapolacao().doubleValue()));
		if(dwtparada.getDwTParadaextra() != null)
			arquivoInovaSA.addLineToBeWritten("CDPARADAEXTRA=" + dwtparada.getDwTParadaextra().getCdTparada());
		
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

		arquivoInovaSA.addLineToBeWritten("[DADOSPARADA]");
		arquivoInovaSA.addLineToBeWritten("CDPAR=" + sessaoParada.getCdParada());	
		arquivoInovaSA.addLineToBeWritten("DSPAR=" + sessaoParada.getDsParada());	
		arquivoInovaSA.addLineToBeWritten("TPPT=" + sessaoParada.getIdTppt());
		arquivoInovaSA.addLineToBeWritten("DATAHORA=" + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(sessaoParada.getDthrIParada()) );
		arquivoInovaSA.addLineToBeWritten("ISPARADO=" + (sessaoParada.isParado() ? "1" : "0"));
		
		arquivoInovaSA.addLineToBeWritten("[REQUSITOSPARADA]");
		arquivoInovaSA.addLineToBeWritten("ISREQCAUSA=" + sessaoParada.isRequerCausa());
		arquivoInovaSA.addLineToBeWritten("ISREQACAO=" + sessaoParada.isRequerAcao());
		arquivoInovaSA.addLineToBeWritten("ISREQJUST=" + sessaoParada.isRequerJustificativa());
		arquivoInovaSA.addLineToBeWritten("QTTEC=" + sessaoParada.getQtdTecnico());
		arquivoInovaSA.addLineToBeWritten("[ATRIBUTOSPARADA]");
		arquivoInovaSA.addLineToBeWritten("ISPERMITECORRECAO=" + sessaoParada.isPermiteCorrecao());
		arquivoInovaSA.addLineToBeWritten("ISPESA=" + sessaoParada.isPesaEficiencia());
		arquivoInovaSA.addLineToBeWritten("ISREGULAGEM=" + sessaoParada.isRegulagem());
		arquivoInovaSA.addLineToBeWritten("TIMEOUTALERTA=" + sessaoParada.getTimeoutAlerta());
		if(sessaoParada.getCdAlerta() != null)
			arquivoInovaSA.addLineToBeWritten("CDALERTA=" + sessaoParada.getCdAlerta());
		arquivoInovaSA.addLineToBeWritten("EXTRAPOLACAO=" + sessaoParada.getExtrapolacao());
		if(sessaoParada.getCdParadaExtra() != null)
			arquivoInovaSA.addLineToBeWritten("CDPARADAEXTRA=" + sessaoParada.getCdParadaExtra());

		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}
	

	public DwTParada getDwtparada() {
		return dwtparada;
	}
	public void setDwtparada(DwTParada dwtparada) {
		this.dwtparada = dwtparada;
	}
	public DwConsolpalog getDwConsolpalog() {
		return dwConsolpalog;
	}

	public void setDwConsolpalog(DwConsolpalog dwConsolpalog) {
		this.dwConsolpalog = dwConsolpalog;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public SessaoParadaDTO getSessaoParada() {
		return sessaoParada;
	}

	public void setSessaoParada(SessaoParadaDTO sessaoParada) {
		this.sessaoParada = sessaoParada;
	}

	
	
}
