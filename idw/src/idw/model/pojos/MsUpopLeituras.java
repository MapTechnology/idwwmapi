package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.MsUpopLeiturasTemplate;

@Entity
@Table(name = "MS_UPOP_LEITURAS")
public class MsUpopLeituras extends MsUpopLeiturasTemplate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal idUpopLeituras;
	private Date dthrLeitura;
	private String cbprincipal;
	private String cb1;
	private String cb2;
	private String cb3;
	
	private MsUpOp msUpOp;

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_UPOP_LEITURAS_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_UPOP_LEITURAS_SEQ", sequenceName = "MS_UPOP_LEITURAS_SEQ")
	@Column(name = "ID_UPOP_LEITURAS", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUpopLeituras() {
		return idUpopLeituras;
	}

	public void setIdUpopLeituras(BigDecimal idUpopLeituras) {
		this.idUpopLeituras = idUpopLeituras;
	}

	@Column(name = "DTHR_LEITURA")
	public Date getDthrLeitura() {
		return dthrLeitura;
	}

	public void setDthrLeitura(Date dthrLeitura) {
		this.dthrLeitura = dthrLeitura;
	}

	@Column(name = "CBPRINCIPAL")
	public String getCbprincipal() {
		return cbprincipal;
	}

	public void setCbprincipal(String cbprincipal) {
		this.cbprincipal = cbprincipal;
	}

	@Column(name = "CB1")
	public String getCb1() {
		return cb1;
	}

	public void setCb1(String cb1) {
		this.cb1 = cb1;
	}

	@Column(name = "CB2")
	public String getCb2() {
		return cb2;
	}

	public void setCb2(String cb2) {
		this.cb2 = cb2;
	}

	@Column(name = "CB3")
	public String getCb3() {
		return cb3;
	}

	public void setCb3(String cb3) {
		this.cb3 = cb3;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UP_OP")
	public MsUpOp getMsUpOp() {
		return msUpOp;
	}

	public void setMsUpOp(MsUpOp msUpOp) {
		this.msUpOp = msUpOp;
	}
	
	

}
