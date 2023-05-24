package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import idw.model.pojos.template.MsUpOpTemplate;

@Entity
@Table(name = "MS_UP_OP")
public class MsUpOp extends MsUpOpTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal idUpOp;
	private String cdUp;
	private String nrop;
	private Date dthrCadastro;
	
	private Set<MsUpopLeituras> msUpopLeiturass = new HashSet<>();
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_UP_OP_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_UP_OP_SEQ", sequenceName = "MS_UP_OP_SEQ")
	@Column(name = "ID_UP_OP", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUpOp() {
		return idUpOp;
	}
	public void setIdUpOp(BigDecimal idUpOp) {
		this.idUpOp = idUpOp;
	}

	@Column(name = "CD_UP", length = 60)
	public String getCdUp() {
		return cdUp;
	}
	public void setCdUp(String cdUp) {
		this.cdUp = cdUp;
	}

	@Column(name = "NROP", length = 100)
	public String getNrop() {
		return nrop;
	}
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	
	@Column(name = "DTHR_CADASTRO")
	public Date getDthrCadastro() {
		return dthrCadastro;
	}
	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msUpOp")
	public Set<MsUpopLeituras> getMsUpopLeiturass() {
		return msUpopLeiturass;
	}
	public void setMsUpopLeiturass(Set<MsUpopLeituras> msUpopLeiturass) {
		this.msUpopLeiturass = msUpopLeiturass;
	}
	
	
}
