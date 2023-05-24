package idw.model.pojos.agramkow;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LineId generated by hbm2java
 */
@Embeddable
public class LineId implements java.io.Serializable {

	private Long lineId;
	private Byte server;

	public LineId() {
	}

	public LineId(Long lineId, Byte server) {
		this.lineId = lineId;
		this.server = server;
	}

	@Column(name = "LINE_ID", nullable = false)
	public Long getLineId() {
		return this.lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
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
		if (!(other instanceof LineId))
			return false;
		LineId castOther = (LineId) other;

		return (this.getLineId() == castOther.getLineId())
				&& (this.getServer() == castOther.getServer());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getLineId().intValue();
		result = 37 * result + this.getServer().intValue();
		return result;
	}

}