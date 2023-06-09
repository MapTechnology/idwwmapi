package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijmaqevtultreg generated by hbm2java
 */
@Entity
@Table(name = "IJMAQEVTULTREG")
public class Ijmaqevtultreg implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -176738138053146816L;
	private String cdinjetora;
	private char evento;
	private Date dthrinievento;
	private Date dthrfimevento;
	private String cdparada;
	private String nrop;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrivalestru;
	private Date dthrivalcic;

	public Ijmaqevtultreg() {
	}

	public Ijmaqevtultreg(String cdinjetora, char evento, Date dthrinievento,
			Date dthrfimevento, String nrop, String cdmolde,
			String cdestrutura, Date dthrivalestru, Date dthrivalcic) {
		this.cdinjetora = cdinjetora;
		this.evento = evento;
		this.dthrinievento = dthrinievento;
		this.dthrfimevento = dthrfimevento;
		this.nrop = nrop;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrivalestru = dthrivalestru;
		this.dthrivalcic = dthrivalcic;
	}

	public Ijmaqevtultreg(String cdinjetora, char evento, Date dthrinievento,
			Date dthrfimevento, String cdparada, String nrop, String cdmolde,
			String cdestrutura, Date dthrivalestru, Date dthrivalcic) {
		this.cdinjetora = cdinjetora;
		this.evento = evento;
		this.dthrinievento = dthrinievento;
		this.dthrfimevento = dthrfimevento;
		this.cdparada = cdparada;
		this.nrop = nrop;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrivalestru = dthrivalestru;
		this.dthrivalcic = dthrivalcic;
	}

	@Id
	@Column(name = "CDINJETORA", unique = true, nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "EVENTO", nullable = false, length = 1)
	public char getEvento() {
		return this.evento;
	}

	public void setEvento(char evento) {
		this.evento = evento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINIEVENTO", nullable = false, length = 7)
	public Date getDthrinievento() {
		return this.dthrinievento;
	}

	public void setDthrinievento(Date dthrinievento) {
		this.dthrinievento = dthrinievento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFIMEVENTO", nullable = false, length = 7)
	public Date getDthrfimevento() {
		return this.dthrfimevento;
	}

	public void setDthrfimevento(Date dthrfimevento) {
		this.dthrfimevento = dthrfimevento;
	}

	@Column(name = "CDPARADA", length = 6)
	public String getCdparada() {
		return this.cdparada;
	}

	public void setCdparada(String cdparada) {
		this.cdparada = cdparada;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDMOLDE", nullable = false, length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", nullable = false, length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALESTRU", nullable = false, length = 7)
	public Date getDthrivalestru() {
		return this.dthrivalestru;
	}

	public void setDthrivalestru(Date dthrivalestru) {
		this.dthrivalestru = dthrivalestru;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALCIC", nullable = false, length = 7)
	public Date getDthrivalcic() {
		return this.dthrivalcic;
	}

	public void setDthrivalcic(Date dthrivalcic) {
		this.dthrivalcic = dthrivalcic;
	}

}
