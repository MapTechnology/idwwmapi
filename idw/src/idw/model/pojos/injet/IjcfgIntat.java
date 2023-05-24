package idw.model.pojos.injet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "ijcfgIntAT", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "HRINIREFERENCIA" }) })
public class IjcfgIntat implements java.io.Serializable {

	private Long hrinireferencia;
	private Long intervaloquebra;
		
	public IjcfgIntat(){		
	}
	
	public IjcfgIntat(Long hrinireferencia,Long intervaloquebra){	
		this.hrinireferencia=hrinireferencia;
		this.intervaloquebra=intervaloquebra;
	}
	
	@Id
	@Column(name = "HRINIREFERENCIA", precision = 126, scale = 0)
	public Long getHrinireferencia() {
		return hrinireferencia;
	}

	public void setHrinireferencia(Long hrinireferencia) {
		this.hrinireferencia = hrinireferencia;
	}
	
	@Column(name = "INTERVALOQUEBRA", precision = 126, scale = 0)
	public Long getIntervaloquebra() {
		return intervaloquebra;
	}

	public void setIntervaloquebra(Long intervaloquebra) {
		this.intervaloquebra = intervaloquebra;
	}
	
}