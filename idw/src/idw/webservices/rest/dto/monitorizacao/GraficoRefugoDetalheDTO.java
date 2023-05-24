package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoRefugoDetalhe")
public class GraficoRefugoDetalheDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cdRefugo;
	private String dsRefugo;
	private String quantidadeRefugada;
	private String indiceRefugo;
	private String indiceRefugoCor;
	private long idTRefugo;
	
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getDsRefugo() {
		return dsRefugo;
	}
	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}
	public String getQuantidadeRefugada() {
		return quantidadeRefugada;
	}
	public void setQuantidadeRefugada(String quantidadeRefugada) {
		this.quantidadeRefugada = quantidadeRefugada;
	}
	public String getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(String indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public String getIndiceRefugoCor() {
		return indiceRefugoCor;
	}
	public void setIndiceRefugoCor(String indiceRefugoCor) {
		this.indiceRefugoCor = indiceRefugoCor;
	}
	public long getIdTRefugo() {
		return idTRefugo;
	}
	public void setIdTRefugo(long idTRefugo) {
		this.idTRefugo = idTRefugo;
	}
	
	
}
