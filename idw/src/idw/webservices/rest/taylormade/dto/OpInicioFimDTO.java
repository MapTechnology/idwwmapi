package idw.webservices.rest.taylormade.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="opiniciofim")
public class OpInicioFimDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idCp;
	private String cdCp;
	private String statusCp;
	private String nomeStatusCp;
	private String dthrInicio;
	private String dthrFim;
	
	public OpInicioFimDTO() {
		super();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public String getIdCp() {
		return idCp;
	}

	public void setIdCp(String idCp) {
		this.idCp = idCp;
	}

	public String getCdCp() {
		return cdCp;
	}

	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}

	public String getStatusCp() {
		return statusCp;
	}

	public void setStatusCp(String statusCp) {
		this.statusCp = statusCp;
	}

	public String getNomeStatusCp() {
		return nomeStatusCp;
	}

	public void setNomeStatusCp(String nomeStatusCp) {
		this.nomeStatusCp = nomeStatusCp;
	}

	public String getDthrInicio() {
		return dthrInicio;
	}

	public void setDthrInicio(String dthrInicio) {
		this.dthrInicio = dthrInicio;
	}

	public String getDthrFim() {
		return dthrFim;
	}

	public void setDthrFim(String dthrFim) {
		this.dthrFim = dthrFim;
	}


	
}
