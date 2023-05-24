package idw.webservices.rest.dto.relatorios;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="alimentacao")
public class AlimentacaoWebDTO implements Serializable{
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private Byte tpAlim;
	private Byte stAlim; 
	private String cdPt;
	private String cdGt;
	private String cdMapa;
	private String cdProduto;
	private String dthrIni;
	private String dthrFim;
	
	public void setTpAlim(Byte tpAlim){
		this.tpAlim = tpAlim;
	}
	
	public Byte getTpAlim(){
		return this.tpAlim;
	}
	
	public void setStAlim(Byte stAlim){
		this.stAlim = stAlim;
	}
	
	public Byte getStAlim(){
		return this.stAlim;
	}
	
	public void setCdPt(String cdPt){
		this.cdPt = cdPt;
	}
	
	public String getCdPt(){
		return this.cdPt;
	}
	
	public void setCdGt(String cdGt){
		this.cdGt = cdGt;
	}
	
	public String getCdGt(){
		return this.cdGt;
	}
	
	public void setCdMapa(String cdMapa){
		this.cdMapa = cdMapa;
	}
	
	public String getCdMapa(){
		return this.cdMapa;
	}
	
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
	
	public void setCdProduto(String cdProduto){
		this.cdProduto = cdProduto;
	}
	
	public String getCdProduto(){
		return this.cdProduto;
	}
	

}
