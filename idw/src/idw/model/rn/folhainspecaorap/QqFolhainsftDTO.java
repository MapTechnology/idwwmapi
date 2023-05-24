package idw.model.rn.folhainspecaorap;

import java.io.Serializable;

public class QqFolhainsftDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idFolhainsft;
	private String dsVariavel;
	
	// Abaixo valores esperados conforme os flags setados
	private double minimo;
	private double meta;
	private double maximo;
	private int stEsperado;

	private boolean isMinimo;
	private boolean isMeta;
	private boolean isMaximo;
	private boolean isCombo;
	private int st1;
	private int st2;
	private int st3;
	private int st4;
	private String ds1;
	private String ds2;
	private String ds3;
	private String ds4;
	

	// Dados que serao preenchidos com os valores escolhidos pelo usuario
	private double valor;
	private int st;

	public long getIdFolhainsft() {
		return idFolhainsft;
	}
	public void setIdFolhainsft(long idFolhainsft) {
		this.idFolhainsft = idFolhainsft;
	}
	public double getMinimo() {
		return minimo;
	}
	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}
	public double getMeta() {
		return meta;
	}
	public void setMeta(double meta) {
		this.meta = meta;
	}
	public double getMaximo() {
		return maximo;
	}
	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}
	public int getSt() {
		return st;
	}
	public void setSt(int st) {
		this.st = st;
	}
	public String getDsVariavel() {
		return dsVariavel;
	}
	public void setDsVariavel(String dsVariavel) {
		this.dsVariavel = dsVariavel;
	}
	public boolean getIsMinimo() {
		return isMinimo;
	}
	public void setIsMinimo(boolean isMinimo) {
		this.isMinimo = isMinimo;
	}
	public boolean getIsMeta() {
		return isMeta;
	}
	public void setIsMeta(boolean isMeta) {
		this.isMeta = isMeta;
	}
	public boolean getIsMaximo() {
		return isMaximo;
	}
	public void setIsMaximo(boolean isMaximo) {
		this.isMaximo = isMaximo;
	}
	public int getSt1() {
		return st1;
	}
	public void setSt1(int st1) {
		this.st1 = st1;
	}
	public int getSt2() {
		return st2;
	}
	public void setSt2(int st2) {
		this.st2 = st2;
	}
	public int getSt3() {
		return st3;
	}
	public void setSt3(int st3) {
		this.st3 = st3;
	}
	public int getSt4() {
		return st4;
	}
	public void setSt4(int st4) {
		this.st4 = st4;
	}
	public String getDs1() {
		return ds1;
	}
	public void setDs1(String ds1) {
		this.ds1 = ds1;
	}
	public String getDs2() {
		return ds2;
	}
	public void setDs2(String ds2) {
		this.ds2 = ds2;
	}
	public String getDs3() {
		return ds3;
	}
	public void setDs3(String ds3) {
		this.ds3 = ds3;
	}
	public String getDs4() {
		return ds4;
	}
	public void setDs4(String ds4) {
		this.ds4 = ds4;
	}
	public double getValor() {
		return this.valor;
	}
	public void setValor(double value) {
		this.valor = value;
	}
	public Boolean getIsCombo() {
		return isCombo;
	}
	public void setIsCombo(Boolean isCombo) {
		this.isCombo = isCombo;
	}
	public Integer getStEsperado() {
		return stEsperado;
	}
	public void setStEsperado(Integer stEsperado) {
		this.stEsperado = stEsperado;
	}
}
