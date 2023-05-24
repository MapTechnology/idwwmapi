package idw.model.pojos.agramkow;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AreasId generated by hbm2java
 */
@Embeddable
public class AreasId implements java.io.Serializable {

	private Long areaId;
	private Byte server;

	public AreasId() {
	}

	public AreasId(Long areaId, Byte server) {
		this.areaId = areaId;
		this.server = server;
	}

	@Column(name = "AREA_ID", nullable = false)
	public Long getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
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
		if (!(other instanceof AreasId))
			return false;
		AreasId castOther = (AreasId) other;

		return (this.getAreaId() == castOther.getAreaId())
				&& (this.getServer() == castOther.getServer());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getAreaId().intValue();
		result = 37 * result + this.getServer().intValue();
		return result;
	}

}
