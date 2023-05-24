package idw.webservices.dto;

import java.math.BigDecimal;

public class MpBrutaPorMaquinaDTO implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String maquina;
	private BigDecimal materiaPrimaBruta;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public BigDecimal getMateriaPrimaBruta() {
		return materiaPrimaBruta;
	}
	public void setMateriaPrimaBruta(BigDecimal materiaPrimaBruta) {
		this.materiaPrimaBruta = materiaPrimaBruta;
	}

}
