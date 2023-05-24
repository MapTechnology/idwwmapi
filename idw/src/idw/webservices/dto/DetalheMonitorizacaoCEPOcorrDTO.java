package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DetalheMonitorizacaoCEPOcorrDTO 
{
	private Long idFtParam;
	private String dsParamentro;
	private Date dthrMedicao;
	private int msDthrmedicao;
	private BigDecimal vlrLido;
    private BigDecimal vlMonetario;
    
	public Long getIdFtParam() {
		return idFtParam;
	}
	public void setIdFtParam(Long idFtParam) {
		this.idFtParam = idFtParam;
	}
	public String getDsParamentro() {
		return dsParamentro;
	}
	public void setDsParamentro(String dsParamentro) {
		this.dsParamentro = dsParamentro;
	}
	public Date getDthrMedicao() {
		return dthrMedicao;
	}
	public void setDthrMedicao(Date dthrMedicao) {
		this.dthrMedicao = dthrMedicao;
	}
	public int getMsDthrmedicao() {
		return msDthrmedicao;
	}
	public void setMsDthrmedicao(int msDthrmedicao) {
		this.msDthrmedicao = msDthrmedicao;
	}
	public BigDecimal getVlrLido() {
		return vlrLido;
	}
	public void setVlrLido(BigDecimal vlrLido) {
		this.vlrLido = vlrLido;
	}
	public BigDecimal getVlMonetario() {
		return vlMonetario;
	}
	public void setVlMonetario(BigDecimal vlMonetario) {
		this.vlMonetario = vlMonetario;
	}

}
