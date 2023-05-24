package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

import ms.coleta.dto.SessaoRefugoDTO;

public class ArquivoRefugos {

	private DwTRefugo dwtrefugo;
	private DwConsolrelog dwConsolrelog;
	private DwPassagem dwPassagem;
	private OmPt ompt = null;
	private String cdRefugo;
	private String dsRefugo;
	private Boolean isRequerCausa;
	private Boolean isRequerAcao;
	private IdwLogger log;
	
	private SessaoRefugoDTO refugoDTO;

	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOS]");
		if(dwtrefugo.getDsTrefugo() != null ) {
			arquivoInovaSA.addLineToBeWritten("DS=" + dwtrefugo.getDsTrefugo());	
		} else {
			arquivoInovaSA.addLineToBeWritten("DS=NULL");
		}			
		if(ompt != null) {
			arquivoInovaSA.addLineToBeWritten("TPPT=" + ompt.getOmTppt().getIdTppt());
		} else {
			arquivoInovaSA.addLineToBeWritten("TPPT=NULL");
		}
		arquivoInovaSA.addLineToBeWritten("ISREQCAUSA=" + dwtrefugo.getIsRequerCausa());
		arquivoInovaSA.addLineToBeWritten("ISREQACAO=" + dwtrefugo.getIsRequerAcao());
		
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
			arquivoInovaSA.addLineToBeWritten("CDREFUGO=" + refugoDTO.getCdRefugo());
			arquivoInovaSA.addLineToBeWritten("DS=" + refugoDTO.getDsRefugo());
			arquivoInovaSA.addLineToBeWritten("CDPRODUTO=" +  refugoDTO.getCdProduto());
			arquivoInovaSA.addLineToBeWritten("QTD=" + refugoDTO.getQtd());
			arquivoInovaSA.addLineToBeWritten("CB=" + refugoDTO.getCb());
			arquivoInovaSA.addLineToBeWritten("DTHR=" + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(refugoDTO.getDthrRefugo()));
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public DwTRefugo getDwtrefugo() {
		return dwtrefugo;
	}

	public void setDwtrefugo(DwTRefugo dwtrefugo) {
		this.dwtrefugo = dwtrefugo;
	}

	public DwConsolrelog getDwConsolrelog() {
		return dwConsolrelog;
	}

	public void setDwConsolrelog(DwConsolrelog dwConsolrelog) {
		this.dwConsolrelog = dwConsolrelog;
	}

	public DwPassagem getDwPassagem() {
		return dwPassagem;
	}

	public void setDwPassagem(DwPassagem dwPassagem) {
		this.dwPassagem = dwPassagem;
	}

	public OmPt getOmpt() {
		return ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public String getCdRefugo() {
		return cdRefugo;
	}

	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}

	public String getDsRefugo() {
		return dsRefugo;
	}

	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}

	public Boolean getIsRequerCausa() {
		return isRequerCausa;
	}

	public void setIsRequerCausa(Boolean isRequerCausa) {
		this.isRequerCausa = isRequerCausa;
	}

	public Boolean getIsRequerAcao() {
		return isRequerAcao;
	}

	public void setIsRequerAcao(Boolean isRequerAcao) {
		this.isRequerAcao = isRequerAcao;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public SessaoRefugoDTO getRefugoDTO() {
		return refugoDTO;
	}

	public void setRefugoDTO(SessaoRefugoDTO refugoDTO) {
		this.refugoDTO = refugoDTO;
	}

}
