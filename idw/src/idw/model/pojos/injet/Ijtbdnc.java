package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijtbdnc generated by hbm2java
 */
@Entity
@Table(name = "IJTBDNC")
public class Ijtbdnc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1770528658348335147L;
	private String cdinjetora;
	private Ijtbinj ijtbinj;
	private char stativo;
	private String uploadpath;
	private String uploadext;
	private String downloadpath;
	private String downloadext;
	private char serialport;
	private double baudrate;
	private BigDecimal databit;
	private String parity;
	private BigDecimal stopbit;
	private String flowcontrol;
	private char recignbeffrsteob;
	private char recignaftlasteob;
	private double rectimeout;
	private String sndstartprog;
	private String sndendprog;
	private String sndendblock;
	private String sndignore;
	private String sndrts;
	private BigDecimal snddelaybyte;
	private char sndcnvtucase;
	private char sndignemptyblock;
	private char stsincronismo;

	public Ijtbdnc() {
	}

	public Ijtbdnc(String cdinjetora, Ijtbinj ijtbinj, char stativo,
			char serialport, double baudrate, BigDecimal databit,
			String parity, BigDecimal stopbit, String flowcontrol,
			char recignbeffrsteob, char recignaftlasteob, double rectimeout,
			String sndendblock, BigDecimal snddelaybyte, char sndcnvtucase,
			char sndignemptyblock, char stsincronismo) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
		this.stativo = stativo;
		this.serialport = serialport;
		this.baudrate = baudrate;
		this.databit = databit;
		this.parity = parity;
		this.stopbit = stopbit;
		this.flowcontrol = flowcontrol;
		this.recignbeffrsteob = recignbeffrsteob;
		this.recignaftlasteob = recignaftlasteob;
		this.rectimeout = rectimeout;
		this.sndendblock = sndendblock;
		this.snddelaybyte = snddelaybyte;
		this.sndcnvtucase = sndcnvtucase;
		this.sndignemptyblock = sndignemptyblock;
		this.stsincronismo = stsincronismo;
	}

	public Ijtbdnc(String cdinjetora, Ijtbinj ijtbinj, char stativo,
			String uploadpath, String uploadext, String downloadpath,
			String downloadext, char serialport, double baudrate,
			BigDecimal databit, String parity, BigDecimal stopbit,
			String flowcontrol, char recignbeffrsteob, char recignaftlasteob,
			double rectimeout, String sndstartprog, String sndendprog,
			String sndendblock, String sndignore, String sndrts,
			BigDecimal snddelaybyte, char sndcnvtucase, char sndignemptyblock,
			char stsincronismo) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
		this.stativo = stativo;
		this.uploadpath = uploadpath;
		this.uploadext = uploadext;
		this.downloadpath = downloadpath;
		this.downloadext = downloadext;
		this.serialport = serialport;
		this.baudrate = baudrate;
		this.databit = databit;
		this.parity = parity;
		this.stopbit = stopbit;
		this.flowcontrol = flowcontrol;
		this.recignbeffrsteob = recignbeffrsteob;
		this.recignaftlasteob = recignaftlasteob;
		this.rectimeout = rectimeout;
		this.sndstartprog = sndstartprog;
		this.sndendprog = sndendprog;
		this.sndendblock = sndendblock;
		this.sndignore = sndignore;
		this.sndrts = sndrts;
		this.snddelaybyte = snddelaybyte;
		this.sndcnvtucase = sndcnvtucase;
		this.sndignemptyblock = sndignemptyblock;
		this.stsincronismo = stsincronismo;
	}

	@Id
	@Column(name = "CDINJETORA", unique = true, nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@Column(name = "STATIVO", nullable = false, length = 1)
	public char getStativo() {
		return this.stativo;
	}

	public void setStativo(char stativo) {
		this.stativo = stativo;
	}

	@Column(name = "UPLOADPATH", length = 200)
	public String getUploadpath() {
		return this.uploadpath;
	}

	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}

	@Column(name = "UPLOADEXT", length = 50)
	public String getUploadext() {
		return this.uploadext;
	}

	public void setUploadext(String uploadext) {
		this.uploadext = uploadext;
	}

	@Column(name = "DOWNLOADPATH", length = 200)
	public String getDownloadpath() {
		return this.downloadpath;
	}

	public void setDownloadpath(String downloadpath) {
		this.downloadpath = downloadpath;
	}

	@Column(name = "DOWNLOADEXT", length = 50)
	public String getDownloadext() {
		return this.downloadext;
	}

	public void setDownloadext(String downloadext) {
		this.downloadext = downloadext;
	}

	@Column(name = "SERIALPORT", nullable = false, length = 1)
	public char getSerialport() {
		return this.serialport;
	}

	public void setSerialport(char serialport) {
		this.serialport = serialport;
	}

	@Column(name = "BAUDRATE", nullable = false, precision = 126, scale = 0)
	public double getBaudrate() {
		return this.baudrate;
	}

	public void setBaudrate(double baudrate) {
		this.baudrate = baudrate;
	}

	@Column(name = "DATABIT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDatabit() {
		return this.databit;
	}

	public void setDatabit(BigDecimal databit) {
		this.databit = databit;
	}

	@Column(name = "PARITY", nullable = false, length = 4)
	public String getParity() {
		return this.parity;
	}

	public void setParity(String parity) {
		this.parity = parity;
	}

	@Column(name = "STOPBIT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStopbit() {
		return this.stopbit;
	}

	public void setStopbit(BigDecimal stopbit) {
		this.stopbit = stopbit;
	}

	@Column(name = "FLOWCONTROL", nullable = false, length = 20)
	public String getFlowcontrol() {
		return this.flowcontrol;
	}

	public void setFlowcontrol(String flowcontrol) {
		this.flowcontrol = flowcontrol;
	}

	@Column(name = "RECIGNBEFFRSTEOB", nullable = false, length = 1)
	public char getRecignbeffrsteob() {
		return this.recignbeffrsteob;
	}

	public void setRecignbeffrsteob(char recignbeffrsteob) {
		this.recignbeffrsteob = recignbeffrsteob;
	}

	@Column(name = "RECIGNAFTLASTEOB", nullable = false, length = 1)
	public char getRecignaftlasteob() {
		return this.recignaftlasteob;
	}

	public void setRecignaftlasteob(char recignaftlasteob) {
		this.recignaftlasteob = recignaftlasteob;
	}

	@Column(name = "RECTIMEOUT", nullable = false, precision = 126, scale = 0)
	public double getRectimeout() {
		return this.rectimeout;
	}

	public void setRectimeout(double rectimeout) {
		this.rectimeout = rectimeout;
	}

	@Column(name = "SNDSTARTPROG", length = 50)
	public String getSndstartprog() {
		return this.sndstartprog;
	}

	public void setSndstartprog(String sndstartprog) {
		this.sndstartprog = sndstartprog;
	}

	@Column(name = "SNDENDPROG", length = 50)
	public String getSndendprog() {
		return this.sndendprog;
	}

	public void setSndendprog(String sndendprog) {
		this.sndendprog = sndendprog;
	}

	@Column(name = "SNDENDBLOCK", nullable = false, length = 20)
	public String getSndendblock() {
		return this.sndendblock;
	}

	public void setSndendblock(String sndendblock) {
		this.sndendblock = sndendblock;
	}

	@Column(name = "SNDIGNORE", length = 50)
	public String getSndignore() {
		return this.sndignore;
	}

	public void setSndignore(String sndignore) {
		this.sndignore = sndignore;
	}

	@Column(name = "SNDRTS", length = 20)
	public String getSndrts() {
		return this.sndrts;
	}

	public void setSndrts(String sndrts) {
		this.sndrts = sndrts;
	}

	@Column(name = "SNDDELAYBYTE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSnddelaybyte() {
		return this.snddelaybyte;
	}

	public void setSnddelaybyte(BigDecimal snddelaybyte) {
		this.snddelaybyte = snddelaybyte;
	}

	@Column(name = "SNDCNVTUCASE", nullable = false, length = 1)
	public char getSndcnvtucase() {
		return this.sndcnvtucase;
	}

	public void setSndcnvtucase(char sndcnvtucase) {
		this.sndcnvtucase = sndcnvtucase;
	}

	@Column(name = "SNDIGNEMPTYBLOCK", nullable = false, length = 1)
	public char getSndignemptyblock() {
		return this.sndignemptyblock;
	}

	public void setSndignemptyblock(char sndignemptyblock) {
		this.sndignemptyblock = sndignemptyblock;
	}

	@Column(name = "STSINCRONISMO", nullable = false, length = 1)
	public char getStsincronismo() {
		return this.stsincronismo;
	}

	public void setStsincronismo(char stsincronismo) {
		this.stsincronismo = stsincronismo;
	}

}
