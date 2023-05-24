package idw.webservices.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class ElementoDTO implements Serializable{
	private String descricao;
	private double valor;
	private Date dtInicial;
	private Date dtFim;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDtInicial() {
		return dtInicial;
	}
	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	public String getDtInicioFormatada(){
		DateFormat dateFormat = new SimpleDateFormat("dd");
		return dateFormat.format(this.dtInicial);
	}

	public String getDtFimFormatada(){
		DateFormat dateFormat = new SimpleDateFormat("dd");
		
		return dateFormat.format(this.dtFim);
	}
}
