package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.OmAlim;

@SuppressWarnings("serial")
public class AlimentacaoDTO implements Serializable {
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	
	private OmAlim alimentacao;
	private Date dtILeitura;
	private Date dtFLeitura;
    private int resultadoEvento;
    private String cdGt;
    private boolean isApenasRealimentacao;
    private String cdProduto;
    private boolean isUltimaAlimentacaoSucesso;
	
    public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
    
	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}
	
	public OmAlim getAlimentacao() {
		return alimentacao;
	}
	
	public void setAlimentacao(OmAlim alimentacao) {
		this.alimentacao = alimentacao;
	}
	
	public Date getDtILeitura() {
		return dtILeitura;
	}
	
	public void setDtILeitura(Date dtILeitura) {
		this.dtILeitura = dtILeitura;
	}
	
	public Date getDtFLeitura() {
		return dtFLeitura;
	}
	
	public void setDtFLeitura(Date dtFLeitura) {
		this.dtFLeitura = dtFLeitura;
	}
	
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public String getCdGt() {
		return cdGt;
	}

	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}

	public String getCdProduto() {
		return cdProduto;
	}
	
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	
	public boolean isApenasRealimentacao() {
		return isApenasRealimentacao;
	}

	public void setApenasRealimentacao(boolean isApenasRealimentacao) {
		this.isApenasRealimentacao = isApenasRealimentacao;
	}

	public boolean isUltimaAlimentacaoSucesso() {
		return isUltimaAlimentacaoSucesso;
	}

	public void setUltimaAlimentacaoSucesso(boolean isUltimaAlimentacaoSucesso) {
		this.isUltimaAlimentacaoSucesso = isUltimaAlimentacaoSucesso;
	}
	
	
}