package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapasCODTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3591038565922175994L;
	
	private String cdPt;
	
	private long mapaConferidoParaPT;
	private long mapaPreConferidoParaPT;
	private long mapaCorrenteParaPT;
	
	private MapaCODTO mapaAtual;
	private List<MapaCODTO> mapas;	
	private MapaCODTO mapaCorrente;
	private String programaNaMaquina;
	private boolean isMapaCorrenteExclusivo = false;
	
	public boolean isMapaCorrenteExclusivo() {
		return isMapaCorrenteExclusivo;
	}
	public void setMapaCorrenteExclusivo(boolean isMapaCorrenteExclusivo) {
		this.isMapaCorrenteExclusivo = isMapaCorrenteExclusivo;
	}
	public MapaCODTO getMapaCorrente() {
		return mapaCorrente;
	}
	public void setMapaCorrente(MapaCODTO mapaCorrente) {
		this.mapaCorrente = mapaCorrente;
	}
	public long getMapaCorrenteParaPT() {
		return mapaCorrenteParaPT;
	}
	public void setMapaCorrenteParaPT(long mapaCorrenteParaPT) {
		this.mapaCorrenteParaPT = mapaCorrenteParaPT;
	}

	public long getMapaConferidoParaPT() {
		return mapaConferidoParaPT;
	}
	public void setMapaConferidoParaPT(long mapaConferidoParaPT) {
		this.mapaConferidoParaPT = mapaConferidoParaPT;
	}
	public long getMapaPreConferidoParaPT() {
		return mapaPreConferidoParaPT;
	}
	public void setMapaPreConferidoParaPT(long mapaPreConferidoParaPT) {
		this.mapaPreConferidoParaPT = mapaPreConferidoParaPT;
	}
	public List<MapaCODTO> getMapas() {
		return mapas;
	}
	public void setMapas(List<MapaCODTO> mapas) {
		this.mapas = mapas;
	}
	public MapaCODTO getMapaAtual() {
		return mapaAtual;
	}
	public void setMapaAtual(MapaCODTO mapaAtual) {
		this.mapaAtual = mapaAtual;
	}
	public String getProgramaNaMaquina() {
		return programaNaMaquina;
	}
	public void setProgramaNaMaquina(String mapaNaMaquina) {
		this.programaNaMaquina = mapaNaMaquina;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

}
