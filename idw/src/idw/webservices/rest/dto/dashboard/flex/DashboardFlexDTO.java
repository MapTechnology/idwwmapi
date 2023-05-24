package idw.webservices.rest.dto.dashboard.flex;

import java.util.List;

public class DashboardFlexDTO {
	private String cdGt;
	private String data;
	private String turno;
	private String hora;
	private List<DashboardFlexOpProdutoDTO> opsProdutos;
	
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public List<DashboardFlexOpProdutoDTO> getOpsProdutos() {
		return opsProdutos;
	}
	public void setOpsProdutos(List<DashboardFlexOpProdutoDTO> opsProdutos) {
		this.opsProdutos = opsProdutos;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
