package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijalemanutprev generated by hbm2java
 */
@Entity
@Table(name = "IJALEMANUTPREV")
public class Ijalemanutprev implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6571236549882877762L;
	private String idalemp;
	private Ijtbusu ijtbusu;
	private Ijmanut ijmanut;
	private String tprecurso;
	private String idrecurso;
	private Date dthrinialemp;
	private Date dthrfimalemp;
	private char stfimalemp;
	private String obsfimalemp;
	private String idchklst;

	public Ijalemanutprev() {
	}

	public Ijalemanutprev(String idalemp, String tprecurso, String idrecurso,
			Date dthrinialemp, char stfimalemp, String idchklst) {
		this.idalemp = idalemp;
		this.tprecurso = tprecurso;
		this.idrecurso = idrecurso;
		this.dthrinialemp = dthrinialemp;
		this.stfimalemp = stfimalemp;
		this.idchklst = idchklst;
	}

	public Ijalemanutprev(String idalemp, Ijtbusu ijtbusu, Ijmanut ijmanut,
			String tprecurso, String idrecurso, Date dthrinialemp,
			Date dthrfimalemp, char stfimalemp, String obsfimalemp,
			String idchklst) {
		this.idalemp = idalemp;
		this.ijtbusu = ijtbusu;
		this.ijmanut = ijmanut;
		this.tprecurso = tprecurso;
		this.idrecurso = idrecurso;
		this.dthrinialemp = dthrinialemp;
		this.dthrfimalemp = dthrfimalemp;
		this.stfimalemp = stfimalemp;
		this.obsfimalemp = obsfimalemp;
		this.idchklst = idchklst;
	}

	@Id
	@Column(name = "IDALEMP", unique = true, nullable = false, length = 12)
	public String getIdalemp() {
		return this.idalemp;
	}

	public void setIdalemp(String idalemp) {
		this.idalemp = idalemp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSURESPFIMALEMP")
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROS")
	public Ijmanut getIjmanut() {
		return this.ijmanut;
	}

	public void setIjmanut(Ijmanut ijmanut) {
		this.ijmanut = ijmanut;
	}

	@Column(name = "TPRECURSO", nullable = false, length = 2)
	public String getTprecurso() {
		return this.tprecurso;
	}

	public void setTprecurso(String tprecurso) {
		this.tprecurso = tprecurso;
	}

	@Column(name = "IDRECURSO", nullable = false, length = 6)
	public String getIdrecurso() {
		return this.idrecurso;
	}

	public void setIdrecurso(String idrecurso) {
		this.idrecurso = idrecurso;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINIALEMP", nullable = false, length = 7)
	public Date getDthrinialemp() {
		return this.dthrinialemp;
	}

	public void setDthrinialemp(Date dthrinialemp) {
		this.dthrinialemp = dthrinialemp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFIMALEMP", length = 7)
	public Date getDthrfimalemp() {
		return this.dthrfimalemp;
	}

	public void setDthrfimalemp(Date dthrfimalemp) {
		this.dthrfimalemp = dthrfimalemp;
	}

	@Column(name = "STFIMALEMP", nullable = false, length = 1)
	public char getStfimalemp() {
		return this.stfimalemp;
	}

	public void setStfimalemp(char stfimalemp) {
		this.stfimalemp = stfimalemp;
	}

	@Column(name = "OBSFIMALEMP")
	public String getObsfimalemp() {
		return this.obsfimalemp;
	}

	public void setObsfimalemp(String obsfimalemp) {
		this.obsfimalemp = obsfimalemp;
	}

	@Column(name = "IDCHKLST", nullable = false, length = 15)
	public String getIdchklst() {
		return this.idchklst;
	}

	public void setIdchklst(String idchklst) {
		this.idchklst = idchklst;
	}

}
