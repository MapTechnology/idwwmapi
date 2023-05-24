package idw.webservices.rest.v2.injet.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gtMonitorizacao")
public class GtMonitorizacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String cdGt;
	private String dsGt;
	private String dsGtView;
	private String caminhoIcone;
	private String corFundo;
	private String indiceOEE;
	private String indiceOEEMeta;
	private int quantidadePostos;
	private FiltroMonitorizacaoDTO filtroDetalhe;

	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getDsGt() {
		return dsGt;
	}
	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}
	public String getDsGtView() {
		return dsGtView;
	}
	public void setDsGtView(String dsGtView) {
		this.dsGtView = dsGtView;
	}
	public String getCaminhoIcone() {
		return caminhoIcone;
	}
	public void setCaminhoIcone(String caminhoIcone) {
		this.caminhoIcone = caminhoIcone;
	}
	public String getCorFundo() {
		return corFundo;
	}
	public void setCorFundo(String corFundo) {
		this.corFundo = corFundo;
	}
	public String getIndiceOEE() {
		return indiceOEE;
	}
	public void setIndiceOEE(String indiceOEE) {
		this.indiceOEE = indiceOEE;
	}
	public String getIndiceOEEMeta() {
		return indiceOEEMeta;
	}
	public void setIndiceOEEMeta(String indiceOEEMeta) {
		this.indiceOEEMeta = indiceOEEMeta;
	}
	public int getQuantidadePostos() {
		return quantidadePostos;
	}
	public void setQuantidadePostos(int quantidadePostos) {
		this.quantidadePostos = quantidadePostos;
	}
	public FiltroMonitorizacaoDTO getFiltroDetalhe() {
		return filtroDetalhe;
	}
	public void setFiltroDetalhe(FiltroMonitorizacaoDTO filtroDetalhe) {
		this.filtroDetalhe = filtroDetalhe;
	}
	
	
	
}
