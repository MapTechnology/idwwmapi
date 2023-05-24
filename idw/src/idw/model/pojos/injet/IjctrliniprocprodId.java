package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjctrliniprocprodId generated by hbm2java
 */
@Embeddable
public class IjctrliniprocprodId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 463928540902586748L;
	private String idctrlinicproc;
	private String nrop;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrivalestru;
	private Date dthrivalcic;

	public IjctrliniprocprodId() {
	}

	public IjctrliniprocprodId(String idctrlinicproc, String nrop,
			String cdmolde, String cdestrutura, Date dthrivalestru,
			Date dthrivalcic) {
		this.idctrlinicproc = idctrlinicproc;
		this.nrop = nrop;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrivalestru = dthrivalestru;
		this.dthrivalcic = dthrivalcic;
	}

	@Column(name = "IDCTRLINICPROC", nullable = false, length = 15)
	public String getIdctrlinicproc() {
		return this.idctrlinicproc;
	}

	public void setIdctrlinicproc(String idctrlinicproc) {
		this.idctrlinicproc = idctrlinicproc;
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

	@Column(name = "DTHRIVALESTRU", nullable = false, length = 7)
	public Date getDthrivalestru() {
		return this.dthrivalestru;
	}

	public void setDthrivalestru(Date dthrivalestru) {
		this.dthrivalestru = dthrivalestru;
	}

	@Column(name = "DTHRIVALCIC", nullable = false, length = 7)
	public Date getDthrivalcic() {
		return this.dthrivalcic;
	}

	public void setDthrivalcic(Date dthrivalcic) {
		this.dthrivalcic = dthrivalcic;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjctrliniprocprodId))
			return false;
		IjctrliniprocprodId castOther = (IjctrliniprocprodId) other;

		return ((this.getIdctrlinicproc() == castOther.getIdctrlinicproc()) || (this
				.getIdctrlinicproc() != null
				&& castOther.getIdctrlinicproc() != null && this
				.getIdctrlinicproc().equals(castOther.getIdctrlinicproc())))
				&& ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
						&& castOther.getNrop() != null && this.getNrop()
						.equals(castOther.getNrop())))
				&& ((this.getCdmolde() == castOther.getCdmolde()) || (this
						.getCdmolde() != null && castOther.getCdmolde() != null && this
						.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getCdestrutura() == castOther.getCdestrutura()) || (this
						.getCdestrutura() != null
						&& castOther.getCdestrutura() != null && this
						.getCdestrutura().equals(castOther.getCdestrutura())))
				&& ((this.getDthrivalestru() == castOther.getDthrivalestru()) || (this
						.getDthrivalestru() != null
						&& castOther.getDthrivalestru() != null && this
						.getDthrivalestru()
						.equals(castOther.getDthrivalestru())))
				&& ((this.getDthrivalcic() == castOther.getDthrivalcic()) || (this
						.getDthrivalcic() != null
						&& castOther.getDthrivalcic() != null && this
						.getDthrivalcic().equals(castOther.getDthrivalcic())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdctrlinicproc() == null ? 0 : this.getIdctrlinicproc()
						.hashCode());
		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		result = 37
				* result
				+ (getCdestrutura() == null ? 0 : this.getCdestrutura()
						.hashCode());
		result = 37
				* result
				+ (getDthrivalestru() == null ? 0 : this.getDthrivalestru()
						.hashCode());
		result = 37
				* result
				+ (getDthrivalcic() == null ? 0 : this.getDthrivalcic()
						.hashCode());
		return result;
	}

}
