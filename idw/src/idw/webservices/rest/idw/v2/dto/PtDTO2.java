package idw.webservices.rest.idw.v2.dto;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="posto")
public class PtDTO2 implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Long idPt;
	
	private String cdPt;
	private String dsPt;
	private String dsCurta;
	private String cdGt;
	private String tpPt;
	private Integer sessaoCLP;
	private String classeABC;
	private Boolean paradaFechaCiclo;
	
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdPt() {
		return idPt;
	}
	public void setIdPt(Long idPt) {
		this.idPt = idPt;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public String getDsCurta() {
		return dsCurta;
	}
	public void setDsCurta(String dsCurta) {
		this.dsCurta = dsCurta;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getTpPt() {
		return tpPt;
	}
	public void setTpPt(String tpPt) {
		this.tpPt = tpPt;
	}
	public Integer getSessaoCLP() {
		return sessaoCLP;
	}
	public void setSessaoCLP(Integer sessaoCLP) {
		this.sessaoCLP = sessaoCLP;
	}
	public String getClasseABC() {
		return classeABC;
	}
	public void setClasseABC(String classeABC) {
		this.classeABC = classeABC;
	}
	public Boolean isParadaFechaCiclo() {
		return paradaFechaCiclo;
	}
	public void setParadaFechaCiclo(Boolean paradaFechaCiclo) {
		this.paradaFechaCiclo = paradaFechaCiclo;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	 
}
