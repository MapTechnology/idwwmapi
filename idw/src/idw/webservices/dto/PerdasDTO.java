package idw.webservices.dto;

import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class PerdasDTO {
	private OmPt maquina;
	private PpCp ordemproducao;
	private OmProduto produto;
	private Double eficienciaciclo;
	private Double perdasineficienciaciclo;
	private Double indiceparadas;
	private Double perdasparada;
	private Double indicerefugos;
	private Double perdasrefugos;
	private Double indicecavativas;
	private Double perdascavativas;
	private Double totalperdas;
	public OmProduto getProduto() {
		return produto;
	}
	public void setProduto(OmProduto produto) {
		this.produto = produto;
	}
	public Double getEficienciaciclo() {
		return eficienciaciclo;
	}
	public void setEficienciaciclo(Double eficienciaciclo) {
		this.eficienciaciclo = eficienciaciclo;
	}
	public Double getPerdasineficienciaciclo() {
		return perdasineficienciaciclo;
	}
	public void setPerdasineficienciaciclo(Double perdasineficienciaciclo) {
		this.perdasineficienciaciclo = perdasineficienciaciclo;
	}
	public Double getIndiceparadas() {
		return indiceparadas;
	}
	public void setIndiceparadas(Double indiceparadas) {
		this.indiceparadas = indiceparadas;
	}
	public Double getPerdasparada() {
		return perdasparada;
	}
	public void setPerdasparada(Double perdasparada) {
		this.perdasparada = perdasparada;
	}
	public Double getIndicerefugos() {
		return indicerefugos;
	}
	public void setIndicerefugos(Double indicerefugos) {
		this.indicerefugos = indicerefugos;
	}
	public Double getPerdasrefugos() {
		return perdasrefugos;
	}
	public void setPerdasrefugos(Double perdasrefugos) {
		this.perdasrefugos = perdasrefugos;
	}
	public Double getIndicecavativas() {
		return indicecavativas;
	}
	public void setIndicecavativas(Double indicecavativas) {
		this.indicecavativas = indicecavativas;
	}
	public Double getPerdascavativas() {
		return perdascavativas;
	}
	public void setPerdascavativas(Double perdascavativas) {
		this.perdascavativas = perdascavativas;
	}
	public Double getTotalperdas() {
		return totalperdas;
	}
	public void setTotalperdas(Double totalperdas) {
		this.totalperdas = totalperdas;
	}
	public OmPt getMaquina() {
		return maquina;
	}
	public void setMaquina(OmPt maquina) {
		this.maquina = maquina;
	}
	public PpCp getOrdemproducao() {
		return ordemproducao;
	}
	public void setOrdemproducao(PpCp ordemproducao) {
		this.ordemproducao = ordemproducao;
	}
	
	
}
