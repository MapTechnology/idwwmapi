package idw.webservices.rest.v2.injet.dto.monitorizacao;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="wsdataturnoreferenciadto")
public class DataTurnoReferenciaDTO implements Serializable {

	Date dtref; 
	String cdturno; 
	Date dthrini; 
	Date dthrfim;
	
	
	public Date getDtref() {
		return dtref;
	}
	public void setDtref(Date dtref) {
		this.dtref = dtref;
	}
	public String getCdturno() {
		return cdturno;
	}
	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}
	public Date getDthrini() {
		return dthrini;
	}
	public void setDthrini(Date dthrini) {
		this.dthrini = dthrini;
	}
	public Date getDthrfim() {
		return dthrfim;
	}
	public void setDthrfim(Date dthrfim) {
		this.dthrfim = dthrfim;
	}	


}