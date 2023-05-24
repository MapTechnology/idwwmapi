package idw.webservices.rest.dto.relatorios;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import idw.webservices.dto.TurnoDTO;

@XmlRootElement(name="indicadoresProdutividade")
public class IndicadoresProdutividadeDTO {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String dthrIni;
	private String dthrFim;
	private String cdPt;
	private String cdGt;
	private TurnoDTO TurnoDTO;
	
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
	
	public void setTurno(TurnoDTO turno){
		this.TurnoDTO = turno;
	}
	
	public TurnoDTO getTurno(){
		return this.TurnoDTO;
	}

}
