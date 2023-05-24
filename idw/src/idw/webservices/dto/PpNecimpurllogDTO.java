package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpNecimpurllog;

@SuppressWarnings("serial")
public class PpNecimpurllogDTO extends PpNecimpurllog implements Serializable {
	
	public PpNecimpurllogDTO() {
	}
	
	public PpNecimpurllogDTO(PpNecimpurllog ppnecimpurllog) {
		this.setDthrIimportacao(ppnecimpurllog.getDthrIimportacao());
		this.setDthrFimportacao(ppnecimpurllog.getDthrFimportacao());
		this.setPpNecimpurl(ppnecimpurllog.getPpNecimpurl());
		
		if(ppnecimpurllog.getPpNecimpurl() != null) {
			this.setIdNecimpurllog(ppnecimpurllog.getPpNecimpurl().getIdNecimpurl());
		}
		else {
			this.setIdNecimpurllog(null);
		}
		
		this.setStImp(ppnecimpurllog.getStImp());
		this.setDsErro(ppnecimpurllog.getDsErro());
		this.setUrlArquivo(ppnecimpurllog.getUrlArquivo());
		this.setAba(ppnecimpurllog.getAba());
	}
	
}
