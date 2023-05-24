package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class MontagemDTO implements Serializable {
	
	private long idProdutoEsperado;
	private long idProdutoAcoplado;
	private long idProdutoAgrupador;

	private String cb;
	private String dsProdutoEsperado;
	private String cdProdutoEsperado;
	private String cdPt;
	private String cdCp;

	private String serial;
	
	private int ordem;
	
	private Date dthrMontagem;
	
	// O que foi montado em um semiacabado pode ter uma montagem tambem, nesse caso  vetor abaixo deve ser preenchido
	private List<MontagemDTO> montagens = new ArrayList<>();
	
	
	private Integer tpValidacao;
	private String mascaraValidacao;
	private Boolean isAvaliarLimites;
	private Integer limiteMin;
	private Integer limiteMax;
	
	public long getIdProdutoAgrupador() {
		return idProdutoAgrupador;
	}
	public void setIdProdutoAgrupador(long idProdutoAgrupador) {
		this.idProdutoAgrupador = idProdutoAgrupador;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	public String getDsProdutoEsperado() {
		return dsProdutoEsperado;
	}
	public void setDsProdutoEsperado(String dsProdutoEsperado) {
		this.dsProdutoEsperado = dsProdutoEsperado;
	}
	public long getIdProdutoEsperado() {
		return idProdutoEsperado;
	}
	public void setIdProdutoEsperado(long idProdutoEsperado) {
		this.idProdutoEsperado = idProdutoEsperado;
	}
	
	public long getIdProdutoAcoplado() {
		return idProdutoAcoplado;
	}
	public void setIdProdutoAcoplado(long idProdutoAcoplado) {
		this.idProdutoAcoplado = idProdutoAcoplado;
	}
	public String getCdProdutoEsperado() {
		return cdProdutoEsperado;
	}
	public void setCdProdutoEsperado(String cdProdutoEsperado) {
		this.cdProdutoEsperado = cdProdutoEsperado;
	}
	public Date getDthrMontagem() {
		return dthrMontagem;
	}
	public void setDthrMontagem(Date dthrMontagem) {
		this.dthrMontagem = dthrMontagem;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public List<MontagemDTO> getMontagens() {
		return montagens;
	}
	public void setMontagens(List<MontagemDTO> montagens) {
		this.montagens = montagens;
	}
	public Integer getTpValidacao() {
		return tpValidacao;
	}
	public void setTpValidacao(Integer tpValidacao) {
		this.tpValidacao = tpValidacao;
	}
	public String getMascaraValidacao() {
		return mascaraValidacao;
	}
	public void setMascaraValidacao(String mascaraValidacao) {
		this.mascaraValidacao = mascaraValidacao;
	}
	public Boolean getIsAvaliarLimites() {
		return isAvaliarLimites;
	}
	public void setIsAvaliarLimites(Boolean isAvaliarLimites) {
		this.isAvaliarLimites = isAvaliarLimites;
	}
	public Integer getLimiteMin() {
		return limiteMin;
	}
	public void setLimiteMin(Integer limiteMin) {
		this.limiteMin = limiteMin;
	}
	public Integer getLimiteMax() {
		return limiteMax;
	}
	public void setLimiteMax(Integer limiteMax) {
		this.limiteMax = limiteMax;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	
	
}
