package idw.webservices.dto;

import java.util.Date;
import java.util.List;

public class RelatorioPeriodoSemOpDTO {
	
	private String maquina;
	private Date dtHrInicio;
	private Date dtHrFim;
	private long duracao;
	private List<RelatorioPeriodoSemOpDTO> itens;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public long getDuracao() {
		return duracao;
	}
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}
	public List<RelatorioPeriodoSemOpDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioPeriodoSemOpDTO> itens) {
		this.itens = itens;
	}
	public Date getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(Date dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}
	public Date getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(Date dtHrFim) {
		this.dtHrFim = dtHrFim;
	}
	
}
