package injetws.model.pojos;
// default package
// Generated 16/10/2008 15:14:14 by Hibernate Tools 3.2.0.CR1

import injetws.model.pojos.template.PrColetorEventosTemplate;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PrColetorEventos generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PR_COLETOR_EVENTOS")
public class PrColetorEventos extends PrColetorEventosTemplate implements java.io.Serializable {

	private Integer ideventocoletor;
	private PrUp prUp;
	private BigDecimal tpevento;
	private String ideventomasterbridgecollectodb;
	private Date dthr1evento;
	private double msdthr1evento;
	private Date dthr2evento;
	private double msdthr2evento;
	private String nrop;
	private String cdmolde;
	private String cdestrutura;
	private Date dthriniplanejada;
	private String inf01;
	private String inf02;
	private String inf03;
	private String inf04;
	private String inf05;
	private String inf06;
	private String inf07;
	private String inf08;
	private String inf09;
	private String inf10;
	private String inf11;
	private String inf12;
	private String inf13;
	private String inf14;
	private String inf15;
	private String inf16;
	private String inf17;
	private String inf18;
	private String inf19;
	private String inf20;
	private String stevento;
	private String txtmensagem;

	public PrColetorEventos() {
	}

	public PrColetorEventos(Integer ideventocoletor, PrUp prUp,
			BigDecimal tpevento, Date dthr1evento, double msdthr1evento,
			Date dthr2evento, double msdthr2evento, String stevento) {
		this.ideventocoletor = ideventocoletor;
		this.prUp = prUp;
		this.tpevento = tpevento;
		this.dthr1evento = dthr1evento;
		this.msdthr1evento = msdthr1evento;
		this.dthr2evento = dthr2evento;
		this.msdthr2evento = msdthr2evento;
		this.stevento = stevento;
	}

	public PrColetorEventos(Integer ideventocoletor, PrUp prUp,
			BigDecimal tpevento, String ideventomasterbridgecollectodb,
			Date dthr1evento, double msdthr1evento, Date dthr2evento,
			double msdthr2evento, String nrop, String cdmolde,
			String cdestrutura, Date dthriniplanejada, String inf01,
			String inf02, String inf03, String inf04, String inf05,
			String inf06, String inf07, String inf08, String inf09,
			String inf10, String inf11, String inf12, String inf13,
			String inf14, String inf15, String inf16, String inf17,
			String inf18, String inf19, String inf20, String stevento,
			String txtmensagem) {
		this.ideventocoletor = ideventocoletor;
		this.prUp = prUp;
		this.tpevento = tpevento;
		this.ideventomasterbridgecollectodb = ideventomasterbridgecollectodb;
		this.dthr1evento = dthr1evento;
		this.msdthr1evento = msdthr1evento;
		this.dthr2evento = dthr2evento;
		this.msdthr2evento = msdthr2evento;
		this.nrop = nrop;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthriniplanejada = dthriniplanejada;
		this.inf01 = inf01;
		this.inf02 = inf02;
		this.inf03 = inf03;
		this.inf04 = inf04;
		this.inf05 = inf05;
		this.inf06 = inf06;
		this.inf07 = inf07;
		this.inf08 = inf08;
		this.inf09 = inf09;
		this.inf10 = inf10;
		this.inf11 = inf11;
		this.inf12 = inf12;
		this.inf13 = inf13;
		this.inf14 = inf14;
		this.inf15 = inf15;
		this.inf16 = inf16;
		this.inf17 = inf17;
		this.inf18 = inf18;
		this.inf19 = inf19;
		this.inf20 = inf20;
		this.stevento = stevento;
		this.txtmensagem =txtmensagem;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PR_COLETOR_EVENTOS_SEQ")
	@SequenceGenerator(name = "PR_COLETOR_EVENTOS_SEQ", sequenceName = "S_PR_COLETOR_EVENTOS")
	@Column(name = "IDEVENTOCOLETOR", unique = true, nullable = false, length = 36)
	public Integer getIdeventocoletor() {
		return this.ideventocoletor;
	}

	public void setIdeventocoletor(Integer ideventocoletor) {
		this.ideventocoletor = ideventocoletor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUP", nullable = false)
	public PrUp getPrUp() {
		return this.prUp;
	}

	public void setPrUp(PrUp prUp) {
		this.prUp = prUp;
	}

	@Column(name = "TPEVENTO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTpevento() {
		return this.tpevento;
	}

	public void setTpevento(BigDecimal tpevento) {
		this.tpevento = tpevento;
	}

	@Column(name = "IDEVENTOMASTERBRIDGECOLLECTODB", length = 36)
	public String getIdeventomasterbridgecollectodb() {
		return this.ideventomasterbridgecollectodb;
	}

	public void setIdeventomasterbridgecollectodb(
			String ideventomasterbridgecollectodb) {
		this.ideventomasterbridgecollectodb = ideventomasterbridgecollectodb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR1EVENTO", nullable = false)
	public Date getDthr1evento() {
		return this.dthr1evento;
	}

	public void setDthr1evento(Date dthr1evento) {
		this.dthr1evento = dthr1evento;
	}

	@Column(name = "MSDTHR1EVENTO", nullable = false, precision = 126, scale = 0)
	public double getMsdthr1evento() {
		return this.msdthr1evento;
	}

	public void setMsdthr1evento(double msdthr1evento) {
		this.msdthr1evento = msdthr1evento;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR2EVENTO", nullable = false)
	public Date getDthr2evento() {
		return this.dthr2evento;
	}

	public void setDthr2evento(Date dthr2evento) {
		this.dthr2evento = dthr2evento;
	}

	@Column(name = "MSDTHR2EVENTO", nullable = false, precision = 126, scale = 0)
	public double getMsdthr2evento() {
		return this.msdthr2evento;
	}

	public void setMsdthr2evento(double msdthr2evento) {
		this.msdthr2evento = msdthr2evento;
	}

	@Column(name = "NROP", length = 20)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDMOLDE", length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHRINIPLANEJADA")
	public Date getDthriniplanejada() {
		return this.dthriniplanejada;
	}

	public void setDthriniplanejada(Date dthriniplanejada) {
		this.dthriniplanejada = dthriniplanejada;
	}

	@Column(name = "INF01", length = 40)
	public String getInf01() {
		return this.inf01;
	}

	public void setInf01(String inf01) {
		this.inf01 = inf01;
	}

	@Column(name = "INF02", length = 40)
	public String getInf02() {
		return this.inf02;
	}

	public void setInf02(String inf02) {
		this.inf02 = inf02;
	}

	@Column(name = "INF03", length = 40)
	public String getInf03() {
		return this.inf03;
	}

	public void setInf03(String inf03) {
		this.inf03 = inf03;
	}

	@Column(name = "INF04", length = 40)
	public String getInf04() {
		return this.inf04;
	}

	public void setInf04(String inf04) {
		this.inf04 = inf04;
	}

	@Column(name = "INF05", length = 40)
	public String getInf05() {
		return this.inf05;
	}

	public void setInf05(String inf05) {
		this.inf05 = inf05;
	}

	@Column(name = "INF06", length = 40)
	public String getInf06() {
		return this.inf06;
	}

	public void setInf06(String inf06) {
		this.inf06 = inf06;
	}

	@Column(name = "INF07", length = 40)
	public String getInf07() {
		return this.inf07;
	}

	public void setInf07(String inf07) {
		this.inf07 = inf07;
	}

	@Column(name = "INF08", length = 40)
	public String getInf08() {
		return this.inf08;
	}

	public void setInf08(String inf08) {
		this.inf08 = inf08;
	}

	@Column(name = "INF09", length = 40)
	public String getInf09() {
		return this.inf09;
	}

	public void setInf09(String inf09) {
		this.inf09 = inf09;
	}

	@Column(name = "INF10", length = 40)
	public String getInf10() {
		return this.inf10;
	}

	public void setInf10(String inf10) {
		this.inf10 = inf10;
	}

	@Column(name = "INF11", length = 40)
	public String getInf11() {
		return this.inf11;
	}

	public void setInf11(String inf11) {
		this.inf11 = inf11;
	}

	@Column(name = "INF12", length = 40)
	public String getInf12() {
		return this.inf12;
	}

	public void setInf12(String inf12) {
		this.inf12 = inf12;
	}

	@Column(name = "INF13", length = 40)
	public String getInf13() {
		return this.inf13;
	}

	public void setInf13(String inf13) {
		this.inf13 = inf13;
	}

	@Column(name = "INF14", length = 40)
	public String getInf14() {
		return this.inf14;
	}

	public void setInf14(String inf14) {
		this.inf14 = inf14;
	}

	@Column(name = "INF15", length = 40)
	public String getInf15() {
		return this.inf15;
	}

	public void setInf15(String inf15) {
		this.inf15 = inf15;
	}

	@Column(name = "INF16", length = 40)
	public String getInf16() {
		return this.inf16;
	}

	public void setInf16(String inf16) {
		this.inf16 = inf16;
	}

	@Column(name = "INF17", length = 40)
	public String getInf17() {
		return this.inf17;
	}

	public void setInf17(String inf17) {
		this.inf17 = inf17;
	}

	@Column(name = "INF18", length = 40)
	public String getInf18() {
		return this.inf18;
	}

	public void setInf18(String inf18) {
		this.inf18 = inf18;
	}

	@Column(name = "INF19", length = 40)
	public String getInf19() {
		return this.inf19;
	}

	public void setInf19(String inf19) {
		this.inf19 = inf19;
	}

	@Column(name = "INF20", length = 40)
	public String getInf20() {
		return this.inf20;
	}

	public void setInf20(String inf20) {
		this.inf20 = inf20;
	}

	@Column(name = "STEVENTO", nullable = false, length = 1)
	public String getStevento() {
		return this.stevento;
	}

	public void setStevento(String stevento) {
		this.stevento = stevento;
	}
	
	@Column(name = "TxtMensagem", length = 500)
	public String getTxtMensagem() {
		return this.txtmensagem;
	}

	public void setTxtMensagem(String txtmensagem) {
		this.txtmensagem = txtmensagem;
	}

}