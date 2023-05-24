package idw.webservices.rest.dto.monitorizacao.injet;

public class CfgUnidadeMedidaInjetDTO {
	private int unidadeContagemBasica;
	private String formatoContagemBasica;
	private long divisorContagemBasica;
	private String siglaContagemBasica;
	
	
	public int getUnidadeContagemBasica() {
		return unidadeContagemBasica;
	}
	public void setUnidadeContagemBasica(int unidadeContagemBasica) {
		this.unidadeContagemBasica = unidadeContagemBasica;
	}
	public String getFormatoContagemBasica() {
		return formatoContagemBasica;
	}
	public void setFormatoContagemBasica(String formatoContagemBasica) {
		this.formatoContagemBasica = formatoContagemBasica;
	}
	public long getDivisorContagemBasica() {
		return divisorContagemBasica;
	}
	public void setDivisorContagemBasica(long divisorContagemBasica) {
		this.divisorContagemBasica = divisorContagemBasica;
	}
	public String getSiglaContagemBasica() {
		return siglaContagemBasica;
	}
	public void setSiglaContagemBasica(String siglaContagemBasica) {
		this.siglaContagemBasica = siglaContagemBasica;
	}
}
