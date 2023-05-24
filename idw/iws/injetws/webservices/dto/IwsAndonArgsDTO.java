package injetws.webservices.dto;

import injetws.model.pojos.PrUpAndonArg;

import java.math.BigDecimal;

public class IwsAndonArgsDTO {
	
	private String idup;
	private double ideventoandon;
	private BigDecimal ordemcondicao;
	private String operadorlogico;
	private String operadorcalculo;
	private BigDecimal tpvlreferencia;
	private String vlreferenciastr ="";
	private Double vlreferencianum;
	private boolean isFoitratado=false;

	public void copyPrUpAndonArg(PrUpAndonArg andonarg)
	{
		this.ideventoandon = andonarg.getId().getIdeventoandon();
		this.idup = andonarg.getId().getIdup();
		this.operadorcalculo = andonarg.getOperadorcalculo();
		this.operadorlogico = andonarg.getOperadorlogico();
		this.ordemcondicao = andonarg.getId().getOrdemcondicao();
		this.tpvlreferencia = andonarg.getTpvlreferencia();
		this.vlreferencianum = andonarg.getVlreferencianum();
		this.vlreferenciastr = andonarg.getVlreferenciastr();
		
	}
	
	public boolean getIsFoiTratado(){
		return this.isFoitratado;
	}
	
	public void setIsFoiTratado(boolean isFoitratado){
		this.isFoitratado=isFoitratado;
	}
	
	public String getIdup() {
		return this.idup;
	}

	public void setIdup(String idup) {
		this.idup = idup;
	}

	public double getIdeventoandon() {
		return this.ideventoandon;
	}

	public void setIdeventoandon(double ideventoandon) {
		this.ideventoandon = ideventoandon;
	}

	public BigDecimal getOrdemcondicao() {
		return this.ordemcondicao;
	}

	public void setOrdemcondicao(BigDecimal ordemcondicao) {
		this.ordemcondicao = ordemcondicao;
	}
	
    public String getOperadorlogico() {
	    return this.operadorlogico;
    }

    public void setOperadorlogico(String operadorlogico) {
	    this.operadorlogico = operadorlogico;
    }

    public String getOperadorcalculo() {
	    return this.operadorcalculo;
    }

    public void setOperadorcalculo(String operadorcalculo) {
	    this.operadorcalculo = operadorcalculo;
    }

    public BigDecimal getTpvlreferencia() {
	    return this.tpvlreferencia;
    }

    public void setTpvlreferencia(BigDecimal tpvlreferencia) {
	    this.tpvlreferencia = tpvlreferencia;
    }

    public String getVlreferenciastr() {
	    return this.vlreferenciastr;
    }

    public void setVlreferenciastr(String vlreferenciastr) {
	    this.vlreferenciastr = vlreferenciastr;
    }

    public Double getVlreferencianum() {
	    return this.vlreferencianum;
    }

    public void setVlreferencianum(Double vlreferencianum) {
	    this.vlreferencianum = vlreferencianum;
    }
}
