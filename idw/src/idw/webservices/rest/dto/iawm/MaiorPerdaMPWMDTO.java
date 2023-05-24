package idw.webservices.rest.dto.iawm;

public class MaiorPerdaMPWMDTO {
	private String cdComponente;
	private String dsComponente;
	private String cdFeeder;
	private int qtdPerdida;
	
	public String getCdComponente() {
		return cdComponente;
	}
	public void setCdComponente(String cdComponente) {
		this.cdComponente = cdComponente;
	}
	public String getDsComponente() {
		return dsComponente;
	}
	public void setDsComponente(String dsComponente) {
		this.dsComponente = dsComponente;
	}
	public String getCdFeeder() {
		return cdFeeder;
	}
	public void setCdFeeder(String cdFeeder) {
		this.cdFeeder = cdFeeder;
	}
	public int getQtdPerdida() {
		return qtdPerdida;
	}
	public void setQtdPerdida(int qtdPerdida) {
		this.qtdPerdida = qtdPerdida;
	}
	
	
}

