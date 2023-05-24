package idw.webservices.dto;

import java.util.List;

public class DashboardDTO {
	private Long idGt;
	private String linha;
	private String modelo;
	private String dsModelo;
	private String op;
	private String qtdOp;
	private String meta;
	private String yield;
	private String prodHoraAnt;
	private String planTurno;
	private String acumDia;
	private String prodHora;
	private String oee;
	private String oeeMeta;
	private String producaoLiquida;
	private String segCicloMedioAtual;
	private String segCicloPadrao;
	private String qtdRefugada;
	private List<String> ptsParados;
	private List<DashboardParadasDTO> infoPtsParados;
	
	
	public String getDsModelo() {
		return dsModelo;
	}
	public void setDsModelo(String dsModelo) {
		this.dsModelo = dsModelo;
	}
	public String getQtdRefugada() {
		return qtdRefugada;
	}
	public void setQtdRefugada(String qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getQtdOp() {
		return qtdOp;
	}
	public void setQtdOp(String qtdOp) {
		this.qtdOp = qtdOp;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getYield() {
		return yield;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	public String getProdHoraAnt() {
		return prodHoraAnt;
	}
	public void setProdHoraAnt(String prodHoraAnt) {
		this.prodHoraAnt = prodHoraAnt;
	}
	public String getPlanTurno() {
		return planTurno;
	}
	public void setPlanTurno(String planTurno) {
		this.planTurno = planTurno;
	}
	public String getAcumDia() {
		return acumDia;
	}
	public void setAcumDia(String acumDia) {
		this.acumDia = acumDia;
	}
	public String getProdHora() {
		return prodHora;
	}
	public void setProdHora(String prodHora) {
		this.prodHora = prodHora;
	}
	public Long getIdGt() {
		return idGt;
	}
	public void setIdGt(Long idGt) {
		this.idGt = idGt;
	}
	public List<String> getPtsParados() {
		return ptsParados;
	}
	public void setPtsParados(List<String> ptsParados) {
		this.ptsParados = ptsParados;
	}
	public List<DashboardParadasDTO> getInfoPtsParados() {
		return infoPtsParados;
	}
	public void setInfoPtsParados(List<DashboardParadasDTO> infoPtsParados) {
		this.infoPtsParados = infoPtsParados;
	}
	public String getOee() {
		return oee;
	}
	public void setOee(String oee) {
		this.oee = oee;
	}
	public String getSegCicloMedioAtual() {
		return segCicloMedioAtual;
	}
	public void setSegCicloMedioAtual(String segCicloMedioAtual) {
		this.segCicloMedioAtual = segCicloMedioAtual;
	}
	public String getSegCicloPadrao() {
		return segCicloPadrao;
	}
	public void setSegCicloPadrao(String segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}
	public String getOeeMeta() {
		return oeeMeta;
	}
	public void setOeeMeta(String oeeMeta) {
		this.oeeMeta = oeeMeta;
	}
	public String getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(String producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	
}
