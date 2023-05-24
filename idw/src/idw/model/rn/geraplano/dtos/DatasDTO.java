package idw.model.rn.geraplano.dtos;

import java.util.Date;

import idw.model.rn.DataHoraRN;

public class DatasDTO {

	private String dtIAtendimentoStr;
	private String dtFAtendimentoStr;
	private Date dtIAtendimento;
	private Date dtFAtendimento;
	private int qtAtivas;
	private double ultimoTempoNecessario;
	private double producaoAjustada;
	private String corHexa;
	
	public double getProducaoAjustada() {
		return producaoAjustada;
	}
	public void setProducaoAjustada(double producaoAjustada) {
		this.producaoAjustada = producaoAjustada;
	}
	public int getQtAtivas() {
		return qtAtivas;
	}
	public void setQtAtivas(int qtAtivas) {
		this.qtAtivas = qtAtivas;
	}
	public double getUltimoTempoNecessario() {
		return ultimoTempoNecessario;
	}
	public void setUltimoTempoNecessario(double ultimoTempoNecessario) {
		this.ultimoTempoNecessario = ultimoTempoNecessario;
	}
	public Date getDtIAtendimento() {
		return dtIAtendimento;
	}
	public void setDtIAtendimento(Date dtIAtendimento) {
		this.dtIAtendimentoStr = DataHoraRN.dateToStringYYYYDDMMHHMMSS(dtIAtendimento);
		this.dtIAtendimento = dtIAtendimento;
	}
	public Date getDtFAtendimento() {
		return dtFAtendimento;
	}
	public void setDtFAtendimento(Date dtFAtendimento) {
		this.dtFAtendimentoStr = DataHoraRN.dateToStringYYYYDDMMHHMMSS(dtFAtendimento);
		this.dtFAtendimento = dtFAtendimento;
	}
	public String getDtIAtendimentoStr() {
		return dtIAtendimentoStr;
	}
	public String getDtFAtendimentoStr() {
		return dtFAtendimentoStr;
	}
	public String getCorHexa() {
		return corHexa;
	}
	public void setCorHexa(String corHexa) {
		this.corHexa = corHexa;
	}
	
	
}
