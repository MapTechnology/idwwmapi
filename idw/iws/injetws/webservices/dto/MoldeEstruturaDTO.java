package injetws.webservices.dto;

public class MoldeEstruturaDTO {
	private String cdmolde;
	private String cdestrutura;
	
	public MoldeEstruturaDTO(){
		
	}
	
	public MoldeEstruturaDTO(MoldeEstruturaDTO obj) {
		
		this.cdmolde = new String(obj.cdmolde);
		this.cdestrutura = new String(obj.cdestrutura);	

	}
	
	public MoldeEstruturaDTO(String cdmolde,String cdestrutura) {		
		this.cdmolde =cdmolde;
		this.cdestrutura = cdestrutura;
	}
	
	public String getCdmolde() {
		return cdmolde;
	}
	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}
	public String getCdestrutura() {
		return cdestrutura;
	}
	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}
	

}
