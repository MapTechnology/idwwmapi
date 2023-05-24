package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.util.List;

public class BiParetoPerdasCicloDetalheDTO {
	private String efiCiclo;
	private String totalCusto;
	private String totalGanhoUB;
	private String totalGanhoKg;
	private String totalGanhoTon;
	private String totalPerdaUB;
	private String totalPerdaKg;
	private String totalPerdaTon;
	private String totalSaldoUB;
	private String totalSaldoKg;
	private String totalSaldoTon;
	private List<BiParetoPerdasCicloDetDTO> detalhes;
	
	public String getEfiCiclo() {
		return efiCiclo;
	}
	public void setEfiCiclo(String efiCiclo) {
		this.efiCiclo = efiCiclo;
	}
	public String getTotalCusto() {
		return totalCusto;
	}
	public void setTotalCusto(String totalCusto) {
		this.totalCusto = totalCusto;
	}
	public String getTotalGanhoUB() {
		return totalGanhoUB;
	}
	public void setTotalGanhoUB(String totalGanhoUB) {
		this.totalGanhoUB = totalGanhoUB;
	}
	public String getTotalGanhoKg() {
		return totalGanhoKg;
	}
	public void setTotalGanhoKg(String totalGanhoKg) {
		this.totalGanhoKg = totalGanhoKg;
	}
	public String getTotalGanhoTon() {
		return totalGanhoTon;
	}
	public void setTotalGanhoTon(String totalGanhoTon) {
		this.totalGanhoTon = totalGanhoTon;
	}
	public String getTotalPerdaUB() {
		return totalPerdaUB;
	}
	public void setTotalPerdaUB(String totalPerdaUB) {
		this.totalPerdaUB = totalPerdaUB;
	}
	public String getTotalPerdaKg() {
		return totalPerdaKg;
	}
	public void setTotalPerdaKg(String totalPerdaKg) {
		this.totalPerdaKg = totalPerdaKg;
	}
	public String getTotalPerdaTon() {
		return totalPerdaTon;
	}
	public void setTotalPerdaTon(String totalPerdaTon) {
		this.totalPerdaTon = totalPerdaTon;
	}
	public String getTotalSaldoUB() {
		return totalSaldoUB;
	}
	public void setTotalSaldoUB(String totalSaldoUB) {
		this.totalSaldoUB = totalSaldoUB;
	}
	public String getTotalSaldoKg() {
		return totalSaldoKg;
	}
	public void setTotalSaldoKg(String totalSaldoKg) {
		this.totalSaldoKg = totalSaldoKg;
	}
	public String getTotalSaldoTon() {
		return totalSaldoTon;
	}
	public void setTotalSaldoTon(String totalSaldoTon) {
		this.totalSaldoTon = totalSaldoTon;
	}
	public List<BiParetoPerdasCicloDetDTO> getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(List<BiParetoPerdasCicloDetDTO> detalhes) {
		this.detalhes = detalhes;
	}
	
	
	
}
