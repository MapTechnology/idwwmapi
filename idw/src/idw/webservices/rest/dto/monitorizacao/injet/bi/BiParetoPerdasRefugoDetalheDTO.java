package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.util.List;

public class BiParetoPerdasRefugoDetalheDTO {
	private String totalCusto;
	
	private String totalRefugoUB;
	private String totalRefugoKg;
	private String totalRefugoTon;
	
	private String totalProdUB;
	private String totalProdKg;
	private String totalProdTon;
	
	private String indRef;
	private String indRefGr;
	
	private List<BiParetoPerdasRefugoDetDTO> detalhes;

	public String getTotalCusto() {
		return totalCusto;
	}

	public void setTotalCusto(String totalCusto) {
		this.totalCusto = totalCusto;
	}

	public String getTotalRefugoUB() {
		return totalRefugoUB;
	}

	public void setTotalRefugoUB(String totalRefugoUB) {
		this.totalRefugoUB = totalRefugoUB;
	}

	public String getTotalRefugoKg() {
		return totalRefugoKg;
	}

	public void setTotalRefugoKg(String totalRefugoKg) {
		this.totalRefugoKg = totalRefugoKg;
	}

	public String getTotalRefugoTon() {
		return totalRefugoTon;
	}

	public void setTotalRefugoTon(String totalRefugoTon) {
		this.totalRefugoTon = totalRefugoTon;
	}

	public String getTotalProdUB() {
		return totalProdUB;
	}

	public void setTotalProdUB(String totalProdUB) {
		this.totalProdUB = totalProdUB;
	}

	public String getTotalProdKg() {
		return totalProdKg;
	}

	public void setTotalProdKg(String totalProdKg) {
		this.totalProdKg = totalProdKg;
	}

	public String getTotalProdTon() {
		return totalProdTon;
	}

	public void setTotalProdTon(String totalProdTon) {
		this.totalProdTon = totalProdTon;
	}

	public String getIndRef() {
		return indRef;
	}

	public void setIndRef(String indRef) {
		this.indRef = indRef;
	}

	public String getIndRefGr() {
		return indRefGr;
	}

	public void setIndRefGr(String indRefGr) {
		this.indRefGr = indRefGr;
	}

	public List<BiParetoPerdasRefugoDetDTO> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(List<BiParetoPerdasRefugoDetDTO> detalhes) {
		this.detalhes = detalhes;
	}
	
	
}
