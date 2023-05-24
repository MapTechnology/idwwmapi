package idw.webservices.rest.wmapi;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="DadosRespostaDTO")
public class DadosRespostaDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String melhordesempenhoCdGt;
	private String melhordesempenhoDsGt;
	private String melhordesempenhoCdPt;
	private String melhordesempenhoDsPt;
	private String melhordesempenhoIdTurno;
	private String melhordesempenhoCdTurno;
	private String melhordesempenhoDsTurno;
	private Double melhordesempenhoOEE;

	private String piordesempenhoCdGt;
	private String piordesempenhoDsGt;
	private String piordesempenhoCdPt;
	private String piordesempenhoDsPt;
	private String piordesempenhoIdTurno;
	private String piordesempenhoCdTurno;
	private String piordesempenhoDsTurno;
	private Double piordesempenhoOEE;
	
	private List<DadosRespostaMaquinaDTO> listaMaquinasParadas;

	public String getMelhordesempenhoCdGt() {
		return melhordesempenhoCdGt;
	}

	public void setMelhordesempenhoCdGt(String melhordesempenhoCdGt) {
		this.melhordesempenhoCdGt = melhordesempenhoCdGt;
	}

	public String getMelhordesempenhoDsGt() {
		return melhordesempenhoDsGt;
	}

	public void setMelhordesempenhoDsGt(String melhordesempenhoDsGt) {
		this.melhordesempenhoDsGt = melhordesempenhoDsGt;
	}

	public String getMelhordesempenhoCdPt() {
		return melhordesempenhoCdPt;
	}

	public void setMelhordesempenhoCdPt(String melhordesempenhoCdPt) {
		this.melhordesempenhoCdPt = melhordesempenhoCdPt;
	}

	public String getMelhordesempenhoDsPt() {
		return melhordesempenhoDsPt;
	}

	public void setMelhordesempenhoDsPt(String melhordesempenhoDsPt) {
		this.melhordesempenhoDsPt = melhordesempenhoDsPt;
	}

	public String getMelhordesempenhoIdTurno() {
		return melhordesempenhoIdTurno;
	}

	public void setMelhordesempenhoIdTurno(String melhordesempenhoIdTurno) {
		this.melhordesempenhoIdTurno = melhordesempenhoIdTurno;
	}

	public String getMelhordesempenhoCdTurno() {
		return melhordesempenhoCdTurno;
	}

	public void setMelhordesempenhoCdTurno(String melhordesempenhoCdTurno) {
		this.melhordesempenhoCdTurno = melhordesempenhoCdTurno;
	}

	public String getMelhordesempenhoDsTurno() {
		return melhordesempenhoDsTurno;
	}

	public void setMelhordesempenhoDsTurno(String melhordesempenhoDsTurno) {
		this.melhordesempenhoDsTurno = melhordesempenhoDsTurno;
	}

	public Double getMelhordesempenhoOEE() {
		return melhordesempenhoOEE;
	}

	public void setMelhordesempenhoOEE(Double melhordesempenhoOEE) {
		this.melhordesempenhoOEE = melhordesempenhoOEE;
	}

	public String getPiordesempenhoCdGt() {
		return piordesempenhoCdGt;
	}

	public void setPiordesempenhoCdGt(String piordesempenhoCdGt) {
		this.piordesempenhoCdGt = piordesempenhoCdGt;
	}

	public String getPiordesempenhoDsGt() {
		return piordesempenhoDsGt;
	}

	public void setPiordesempenhoDsGt(String piordesempenhoDsGt) {
		this.piordesempenhoDsGt = piordesempenhoDsGt;
	}

	public String getPiordesempenhoCdPt() {
		return piordesempenhoCdPt;
	}

	public void setPiordesempenhoCdPt(String piordesempenhoCdPt) {
		this.piordesempenhoCdPt = piordesempenhoCdPt;
	}

	public String getPiordesempenhoDsPt() {
		return piordesempenhoDsPt;
	}

	public void setPiordesempenhoDsPt(String piordesempenhoDsPt) {
		this.piordesempenhoDsPt = piordesempenhoDsPt;
	}

	public String getPiordesempenhoIdTurno() {
		return piordesempenhoIdTurno;
	}

	public void setPiordesempenhoIdTurno(String piordesempenhoIdTurno) {
		this.piordesempenhoIdTurno = piordesempenhoIdTurno;
	}

	public String getPiordesempenhoCdTurno() {
		return piordesempenhoCdTurno;
	}

	public void setPiordesempenhoCdTurno(String piordesempenhoCdTurno) {
		this.piordesempenhoCdTurno = piordesempenhoCdTurno;
	}

	public String getPiordesempenhoDsTurno() {
		return piordesempenhoDsTurno;
	}

	public void setPiordesempenhoDsTurno(String piordesempenhoDsTurno) {
		this.piordesempenhoDsTurno = piordesempenhoDsTurno;
	}

	public Double getPiordesempenhoOEE() {
		return piordesempenhoOEE;
	}

	public void setPiordesempenhoOEE(Double piordesempenhoOEE) {
		this.piordesempenhoOEE = piordesempenhoOEE;
	}

	public List<DadosRespostaMaquinaDTO> getListaMaquinasParadas() {
		return listaMaquinasParadas;
	}

	public void setListaMaquinasParadas(List<DadosRespostaMaquinaDTO> listaMaquinasParadas) {
		this.listaMaquinasParadas = listaMaquinasParadas;
	}
	
	
	
	
	

	
}
