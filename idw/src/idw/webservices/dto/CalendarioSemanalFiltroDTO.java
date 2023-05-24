/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class CalendarioSemanalFiltroDTO implements Serializable {
	private long idCal;
    private Date dthrCalendario;
    private Date dthrICalendario;
    private Date dthrFCalendario;
	public long getIdCal() {
		return idCal;
	}
	public void setIdCal(long idCal) {
		this.idCal = idCal;
	}
	public Date getDthrCalendario() {
		return dthrCalendario;
	}
	public void setDthrCalendario(Date dthrCalendario) {
		this.dthrCalendario = dthrCalendario;
	}
	public Date getDthrICalendario() {
		return dthrICalendario;
	}
	public void setDthrICalendario(Date dthrICalendario) {
		this.dthrICalendario = dthrICalendario;
	}
	public Date getDthrFCalendario() {
		return dthrFCalendario;
	}
	public void setDthrFCalendario(Date dthrFCalendario) {
		this.dthrFCalendario = dthrFCalendario;
	}
	
	    			
}