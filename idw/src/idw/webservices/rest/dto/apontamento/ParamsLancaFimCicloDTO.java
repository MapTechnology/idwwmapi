package idw.webservices.rest.dto.apontamento;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="paramsLancaFimCicloDTO")
public class ParamsLancaFimCicloDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long idPt;
	private String cdPt;
	private String cdCp;
	private long qtde;

	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public long getQtde() {
		return qtde;
	}
	public void setQtde(long qtde) {
		this.qtde = qtde;
	}
	
}