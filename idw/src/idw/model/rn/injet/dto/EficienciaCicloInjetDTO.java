package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class EficienciaCicloInjetDTO implements Serializable{

	private String cdInjetora;
	private String cdMolde;
	private String cdEstrutura;
	private Date dthrvalcic;
	private BigDecimal tmpcicnormal = new BigDecimal(0);
	private BigDecimal qtinjnormal = new BigDecimal(0);
	private BigDecimal cicloPadrao = new BigDecimal(0);
	
	public EficienciaCicloInjetDTO() {
		super();
	}
	
	public EficienciaCicloInjetDTO(String cdInjetora, String cdMolde, String cdEstrutura, Date dthrvalcic){
		this.cdInjetora = cdInjetora;
		this.cdMolde = cdMolde;
		this.cdEstrutura = cdEstrutura;
		this.dthrvalcic = dthrvalcic;
	}
	
	@Override
	public boolean equals(Object valor){
		EficienciaCicloInjetDTO comparar = (EficienciaCicloInjetDTO) valor;
		return (this.cdInjetora.equals(comparar.getCdInjetora()) && 
				this.cdMolde.equals(comparar.getCdMolde()) &&
				this.cdEstrutura.equals(comparar.getCdEstrutura()) &&
				this.dthrvalcic.equals(comparar.getDthrvalcic()));
	}
	
	public void addTmpcicnormal(BigDecimal valor){
		this.tmpcicnormal = this.tmpcicnormal.add(valor);
	}
	public void addQtinjnormal(BigDecimal valor){
		this.qtinjnormal = this.qtinjnormal.add(valor);
	}
	/**
	 * @return the cdInjetora
	 */
	public String getCdInjetora() {
		return cdInjetora;
	}
	/**
	 * @param cdInjetora the cdInjetora to set
	 */
	public void setCdInjetora(String cdInjetora) {
		this.cdInjetora = cdInjetora;
	}
	/**
	 * @return the cdMolde
	 */
	public String getCdMolde() {
		return cdMolde;
	}
	/**
	 * @param cdMolde the cdMolde to set
	 */
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	/**
	 * @return the cdEstrutura
	 */
	public String getCdEstrutura() {
		return cdEstrutura;
	}
	/**
	 * @param cdEstrutura the cdEstrutura to set
	 */
	public void setCdEstrutura(String cdEstrutura) {
		this.cdEstrutura = cdEstrutura;
	}
	/**
	 * @return the dthrvalcic
	 */
	public Date getDthrvalcic() {
		return dthrvalcic;
	}
	/**
	 * @param dthrvalcic the dthrvalcic to set
	 */
	public void setDthrvalcic(Date dthrvalcic) {
		this.dthrvalcic = dthrvalcic;
	}
	/**
	 * @return the tmpcicnormal
	 */
	public BigDecimal getTmpcicnormal() {
		return tmpcicnormal;
	}
	/**
	 * @param tmpcicnormal the tmpcicnormal to set
	 */
	public void setTmpcicnormal(BigDecimal tmpcicnormal) {
		this.tmpcicnormal = tmpcicnormal;
	}
	/**
	 * @return the qtinjnormal
	 */
	public BigDecimal getQtinjnormal() {
		return qtinjnormal;
	}
	/**
	 * @param qtinjnormal the qtinjnormal to set
	 */
	public void setQtinjnormal(BigDecimal qtinjnormal) {
		this.qtinjnormal = qtinjnormal;
	}

	/**
	 * @return the cicloPadrao
	 */
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}

	/**
	 * @param cicloPadrao the cicloPadrao to set
	 */
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
}
