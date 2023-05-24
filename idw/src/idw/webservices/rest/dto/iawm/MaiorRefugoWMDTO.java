package idw.webservices.rest.dto.iawm;

import java.math.BigDecimal;

public class MaiorRefugoWMDTO {
	private String cdRefugo;
	private String dsRefugo;
	private BigDecimal qtdRefugada;
	private boolean isTendenciaAlta;
	
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getDsRefugo() {
		return dsRefugo;
	}
	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}
	public BigDecimal getQtdRefugada() {
		return qtdRefugada;
	}
	public void setQtdRefugada(BigDecimal qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}
	public boolean isTendenciaAlta() {
		return isTendenciaAlta;
	}
	public void setTendenciaAlta(boolean isTendenciaAlta) {
		this.isTendenciaAlta = isTendenciaAlta;
	}
	
	
}
