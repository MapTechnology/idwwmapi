package idw.webservices.rest.dto.dashboard.flex;

import java.util.List;

public class DashboardFlexOpProdutoDTO {
	private String cdCp;
	private String cliente;
	private String modelo;
	private double indiceDefeito;
	private double indiceDefeitoReal;
	private int metaDia;
	private int metaHoraAcumulado;
	private int statusProducao;
	private String statusProducaoDescricao;
	private int produzidos;
	private int defeitos;
	private int scraps;
	private double indfor;
	
	private String downtime;
	
	private List<DashboardFlexHoraDTO> horas;

	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getIndiceDefeito() {
		return indiceDefeito;
	}
	public void setIndiceDefeito(double indiceDefeito) {
		this.indiceDefeito = indiceDefeito;
	}
	public double getIndiceDefeitoReal() {
		return indiceDefeitoReal;
	}
	public void setIndiceDefeitoReal(double indiceDefeitoReal) {
		this.indiceDefeitoReal = indiceDefeitoReal;
	}
	public int getMetaDia() {
		return metaDia;
	}
	public void setMetaDia(int metaDia) {
		this.metaDia = metaDia;
	}
	public int getProduzidos() {
		return produzidos;
	}
	public void setProduzidos(int produzido) {
		this.produzidos = produzido;
	}
	public List<DashboardFlexHoraDTO> getHoras() {
		return horas;
	}
	public void setHoras(List<DashboardFlexHoraDTO> horas) {
		this.horas = horas;
	}
	public int getDefeitos() {
		return defeitos;
	}
	public void setDefeitos(int defeitos) {
		this.defeitos = defeitos;
	}
	public int getScraps() {
		return scraps;
	}
	public void setScraps(int scraps) {
		this.scraps = scraps;
	}
	public int getMetaHoraAcumulado() {
		return metaHoraAcumulado;
	}
	public void setMetaHoraAcumulado(int metaHoraAcumulado) {
		this.metaHoraAcumulado = metaHoraAcumulado;
	}
	public int getStatusProducao() {
		return statusProducao;
	}
	public void setStatusProducao(int statusProducao) {
		this.statusProducao = statusProducao;
	}
	public String getStatusProducaoDescricao() {
		return statusProducaoDescricao;
	}
	public void setStatusProducaoDescricao(String statusProducaoDescricao) {
		this.statusProducaoDescricao = statusProducaoDescricao;
	}
	public double getIndfor() {
		return indfor;
	}
	public void setIndfor(double indfor) {
		this.indfor = indfor;
	}
	public String getDowntime() {
		return downtime;
	}
	public void setDowntime(String downtime) {
		this.downtime = downtime;
	}

}
