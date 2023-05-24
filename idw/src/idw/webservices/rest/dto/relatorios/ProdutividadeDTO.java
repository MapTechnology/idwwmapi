package idw.webservices.rest.dto.relatorios;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="produtividade")
public class ProdutividadeDTO {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String dthrIni;
	private String dthrFim;
	private String op;
	private String fase;
	private String linha;
	private String modelo;
	
	public void setDthrIni(String dthrIni){
		this.dthrIni = dthrIni;
	}
	
	public String getDthrIni(){
		return this.dthrIni;
	}
	
	public void setDthrFim(String dthrFim){
		this.dthrFim = dthrFim;
	}
	
	public String getDthrFim(){
		return this.dthrFim;
	}
	
	public void setOp(String op){
		this.op = op;
	}
	
	public String getOp(){
		return this.op;
	}
	
	public void setFase(String fase){
		this.fase = fase;
	}
	
	public String getFase(){
		return this.fase;
	}
	
	public void setLinha(String linha){
		this.linha = linha;
	}
	
	public String getLinha(){
		return this.linha;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public String getModelo(){
		return this.modelo;
	}
}
