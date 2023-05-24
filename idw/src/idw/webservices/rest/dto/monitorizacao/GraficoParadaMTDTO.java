package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoParadaMT")
public class GraficoParadaMTDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tempoAtivo;
	private String tempoParadaMTTR;
	private String quantidadeOcorrenciasMTs;
	private String mtbf;
	private String mttr;
	private List<MTDTO> listaMTBF;
	private List<MTDTO> listaMTTR;
	
	public String getTempoAtivo() {
		return tempoAtivo;
	}
	public void setTempoAtivo(String tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}
	public String getTempoParadaMTTR() {
		return tempoParadaMTTR;
	}
	public void setTempoParadaMTTR(String tempoParadaMTTR) {
		this.tempoParadaMTTR = tempoParadaMTTR;
	}
	public String getQuantidadeOcorrenciasMTs() {
		return quantidadeOcorrenciasMTs;
	}
	public void setQuantidadeOcorrenciasMTs(String quantidadeOcorrenciasMTs) {
		this.quantidadeOcorrenciasMTs = quantidadeOcorrenciasMTs;
	}
	public String getMtbf() {
		return mtbf;
	}
	public void setMtbf(String mtbf) {
		this.mtbf = mtbf;
	}
	public String getMttr() {
		return mttr;
	}
	public void setMttr(String mttr) {
		this.mttr = mttr;
	}
	public List<MTDTO> getListaMTBF() {
		return listaMTBF;
	}
	public void setListaMTBF(List<MTDTO> listaMTBF) {
		this.listaMTBF = listaMTBF;
	}
	public List<MTDTO> getListaMTTR() {
		return listaMTTR;
	}
	public void setListaMTTR(List<MTDTO> listaMTTR) {
		this.listaMTTR = listaMTTR;
	}
	
	
}
