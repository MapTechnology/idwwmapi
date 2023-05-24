package idw.webservices.dto;

public class CapabilidadeProcessoDTO {
    private double media;
    private double desvioPadrao;
    private double variancia;
    private double lie;
    private double lse;
    private double cp;
	private double cpk;
    private double cpi;
    private double cps;
    private long n;
    private double maximo;
	private double minimo;    

	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public double getDesvioPadrao() {
		return desvioPadrao;
	}
	public void setDesvioPadrao(double desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	public double getLie() {
		return lie;
	}
	public void setLie(double lie) {
		this.lie = lie;
	}
	public double getLse() {
		return lse;
	}
	public void setLse(double lse) {
		this.lse = lse;
	}
	public double getCp() {
		return cp;
	}
	public void setCp(double cp) {
		this.cp = cp;
	}
	public double getCpk() {
		return cpk;
	}
	public void setCpk(double cpk) {
		this.cpk = cpk;
	}
	public double getCpi() {
		return cpi;
	}
	public void setCpi(double cpi) {
		this.cpi = cpi;
	}
	public double getCps() {
		return cps;
	}
	public void setCps(double cps) {
		this.cps = cps;
	}
	public long getN() {
		return n;
	}
	public void setN(long n) {
		this.n = n;
	}
	public double getMaximo() {
		return maximo;
	}
	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}
	public double getMinimo() {
		return minimo;
	}
	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}
	public double getVariancia() {
		return variancia;
	}
	public void setVariancia(double variancia) {
		this.variancia = variancia;
	}
	
	

}
