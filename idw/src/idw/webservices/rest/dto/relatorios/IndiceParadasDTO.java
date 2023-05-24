package idw.webservices.rest.dto.relatorios;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.webservices.dto.TurnoDTO;

@XmlRootElement(name="indiceParadas")
public class IndiceParadasDTO {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String dthrIni;
	private String dthrFim;
	private String tipo;
	private String op;
	private String cdPt;
	private List<DwTParada> dwTParadas;
	private List<DwTArea> dwTAreas;
	private Boolean isTodasAreas;
	private Boolean isTodasParadas;
	private Boolean isRetirarParadasPequenas;
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
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public void setOp(String op){
		this.op = op;
	}
	
	public String getOp(){
		return this.op;
	}
	
	public void setCdPt(String cdPt){
		this.cdPt = cdPt;
	}
	
	public String getCdPt(){
		return this.cdPt;
	}
	
	public void setParadas (List<DwTParada> dwTParadas){
		this.dwTParadas = dwTParadas;
	}
	
	public List<DwTParada> getParadas(){
		return this.dwTParadas;
	}
	
	public void setAreas (List<DwTArea> dwTAreas){
		this.dwTAreas = dwTAreas;
	}
	
	public List<DwTArea> getAreas(){
		return this.dwTAreas;
	}
	
	public void setIsTodasAreas (boolean isTodasAreas){
		this.isTodasAreas = isTodasAreas;
	}
	
	public boolean getIsTodasAreas (){
		return this.isTodasAreas;
	}
	
	public void setIsTodasParadas (boolean isTodasParadas){
		this.isTodasParadas = isTodasParadas;
	}
	
	public boolean getIsTodasParadas (){
		return this.isTodasParadas;
	}
	
	public void setIsRetirarParadasPequenas (boolean isRetirarParadasPequenas){
		this.isRetirarParadasPequenas = isRetirarParadasPequenas;
	}
	
	public boolean getIsRetirarParadasPequenas (){
		return this.isRetirarParadasPequenas;
	}
	
	public void setTurno(TurnoDTO turno){
		this.TurnoDTO = turno;
	}
	
	public TurnoDTO getTurno(){
		return this.TurnoDTO;
	}

}
