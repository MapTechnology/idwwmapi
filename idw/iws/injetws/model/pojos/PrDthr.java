package injetws.model.pojos;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "PR_DTHR", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "DTHR" }) })
public class PrDthr implements java.io.Serializable {

	private Date dtHr;

	public PrDthr(){		
	}

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR", nullable = false)
	public Date getDtHr() {
		return dtHr;
	}
	
	public void setDtHr(Date dtHr) {
		this.dtHr = dtHr;
	}
}
