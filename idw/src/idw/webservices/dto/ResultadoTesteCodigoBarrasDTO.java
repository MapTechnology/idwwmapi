package idw.webservices.dto;

public class ResultadoTesteCodigoBarrasDTO {
	private String cdBarras;
	private String cdPt;
	private String dtHr;
	private int resultado;
	private String detalheResultado;
	
	public ResultadoTesteCodigoBarrasDTO() {	
	}
	
	public ResultadoTesteCodigoBarrasDTO(String cdBarras, String cdPt, String dtHr, int resultado) {
		super();
		this.cdBarras = cdBarras;
		this.cdPt = cdPt;
		this.dtHr = dtHr;
		this.resultado = resultado;
	}

	public String getCdBarras() {
		return cdBarras;
	}

	public void setCdBarras(String cdBarras) {
		this.cdBarras = cdBarras;
	}

	public String getCdPt() {
		return cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

	public String getDtHr() {
		return dtHr;
	}

	public void setDtHr(String dtHr) {
		this.dtHr = dtHr;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
		
	public String getDetalheResultado() {
		return detalheResultado;
	}

	public void setDetalheResultado(String detalheResultado) {
		this.detalheResultado = detalheResultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdBarras == null) ? 0 : cdBarras.hashCode());
		result = prime * result + ((cdPt == null) ? 0 : cdPt.hashCode());
		result = prime * result + ((dtHr == null) ? 0 : dtHr.hashCode());
		result = prime * result + resultado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoTesteCodigoBarrasDTO other = (ResultadoTesteCodigoBarrasDTO) obj;
		if (cdBarras == null) {
			if (other.cdBarras != null)
				return false;
		} else if (!cdBarras.equals(other.cdBarras))
			return false;
		if (cdPt == null) {
			if (other.cdPt != null)
				return false;
		} else if (!cdPt.equals(other.cdPt))
			return false;
		if (dtHr == null) {
			if (other.dtHr != null)
				return false;
		} else if (!dtHr.equals(other.dtHr))
			return false;
		if (resultado != other.resultado)
			return false;
		return true;
	}
	
}
