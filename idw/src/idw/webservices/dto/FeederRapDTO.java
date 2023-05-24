package idw.webservices.dto;

@SuppressWarnings("serial")
public class FeederRapDTO implements java.io.Serializable{
	private String cdFeeder;
	private String descFeeder;
	
	public FeederRapDTO(){
		
	}
	
	public FeederRapDTO(String CdFeeder, String DescFeeder){
		this.setCdFeeder(CdFeeder);
		this.setDescFeeder(DescFeeder);
	}

	public void setCdFeeder(String cdFeeder) {
		this.cdFeeder = cdFeeder;
	}

	public String getCdFeeder() {
		return cdFeeder;
	}

	public void setDescFeeder(String descFeeder) {
		this.descFeeder = descFeeder;
	}

	public String getDescFeeder() {
		return descFeeder;
	}
	
	
}
