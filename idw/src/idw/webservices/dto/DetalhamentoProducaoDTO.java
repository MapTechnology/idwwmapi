package idw.webservices.dto;

import java.util.Date;
import java.util.List;

public class DetalhamentoProducaoDTO {
	
	private Date   dthrinicio;
	private Date   dthrfim;
	private String duracaointervalo;
	private Double tempodisponivel;
	private Double horastrabalhadas;
	private Double horasparadas;
	private Double indiceparadas;
	private Double ultimocicpadrao;
	private Double cicpadraomedio;
	private Double cicmedio;
	private Double perdascic;
	private Double perdasparadas;
	private Double perdasrefugos;
	private Double totalperdas;
	
	private List<DetalheProducaoDTO> listaproducao;
	private List<DetalheRefugoDTO> listarefugos;
	private List<DetalheParadaDTO> listaparadas;

	public Date getDthrinicio() {
		return dthrinicio;
	}
	public void setDthrinicio(Date dthrinicio) {
		this.dthrinicio = dthrinicio;
	}
	public Date getDthrfim() {
		return dthrfim;
	}
	public void setDthrfim(Date dthrfim) {
		this.dthrfim = dthrfim;
	}
	public String getDuracaointervalo() {
		return duracaointervalo;
	}
	public void setDuracaointervalo(String duracaointervalo) {
		this.duracaointervalo = duracaointervalo;
	}
	public Double getTempodisponivel() {
		return tempodisponivel;
	}
	public void setTempodisponivel(Double tempodisponivel) {
		this.tempodisponivel = tempodisponivel;
	}
	public Double getHorastrabalhadas() {
		return horastrabalhadas;
	}
	public void setHorastrabalhadas(Double horastrabalhadas) {
		this.horastrabalhadas = horastrabalhadas;
	}
	public Double getHorasparadas() {
		return horasparadas;
	}
	public void setHorasparadas(Double horasparadas) {
		this.horasparadas = horasparadas;
	}
	public Double getIndiceparadas() {
		return indiceparadas;
	}
	public void setIndiceparadas(Double indiceparadas) {
		this.indiceparadas = indiceparadas;
	}
	public Double getUltimocicpadrao() {
		return ultimocicpadrao;
	}
	public void setUltimocicpadrao(Double ultimocicpadrao) {
		this.ultimocicpadrao = ultimocicpadrao;
	}
	public Double getCicpadraomedio() {
		return cicpadraomedio;
	}
	public void setCicpadraomedio(Double cicpadraomedio) {
		this.cicpadraomedio = cicpadraomedio;
	}
	public Double getCicmedio() {
		return cicmedio;
	}
	public void setCicmedio(Double cicmedio) {
		this.cicmedio = cicmedio;
	}
	public Double getPerdascic() {
		return perdascic;
	}
	public void setPerdascic(Double perdascic) {
		this.perdascic = perdascic;
	}
	public Double getPerdasparadas() {
		return perdasparadas;
	}
	public void setPerdasparadas(Double perdasparadas) {
		this.perdasparadas = perdasparadas;
	}
	public Double getPerdasrefugos() {
		return perdasrefugos;
	}
	public void setPerdasrefugos(Double perdasrefugos) {
		this.perdasrefugos = perdasrefugos;
	}
	public Double getTotalperdas() {
		return totalperdas;
	}
	public void setTotalperdas(Double totalperdas) {
		this.totalperdas = totalperdas;
	}
	public List<DetalheProducaoDTO> getListaproducao() {
		return listaproducao;
	}
	public void setListaproducao(List<DetalheProducaoDTO> listaproducao) {
		this.listaproducao = listaproducao;
	}
	public List<DetalheRefugoDTO> getListarefugos() {
		return listarefugos;
	}
	public void setListarefugos(List<DetalheRefugoDTO> listarefugos) {
		this.listarefugos = listarefugos;
	}
	public List<DetalheParadaDTO> getListaparadas() {
		return listaparadas;
	}
	public void setListaparadas(List<DetalheParadaDTO> listaparadas) {
		this.listaparadas = listaparadas;
	}	
}
