package idw.model.pojos.agramkow;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ResultsHeaderId generated by hbm2java
 */
@Embeddable
public class ResultsHeaderId implements java.io.Serializable {

	private Long seqno;
	private Byte server;

	public ResultsHeaderId() {
	}

	public ResultsHeaderId(Long seqno, Byte server) {
		this.seqno = seqno;
		this.server = server;
	}

	@Column(name = "SEQNO", nullable = false)
	public Long getSeqno() {
		return this.seqno;
	}

	public void setSeqno(Long seqno) {
		this.seqno = seqno;
	}

	@Column(name = "SERVER", nullable = false)
	public Byte getServer() {
		return this.server;
	}

	public void setServer(Byte server) {
		this.server = server;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ResultsHeaderId))
			return false;
		ResultsHeaderId castOther = (ResultsHeaderId) other;

		return (this.getSeqno() == castOther.getSeqno())
				&& (this.getServer() == castOther.getServer());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getSeqno().intValue();
		result = 37 * result + this.getServer();
		return result;
	}

}