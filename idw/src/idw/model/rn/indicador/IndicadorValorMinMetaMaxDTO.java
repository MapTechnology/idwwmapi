package idw.model.rn.indicador;

import idw.webservices.dto.IndicadorMinMetaMaxDTO;

public class IndicadorValorMinMetaMaxDTO {
	private IndicadorValorDTO indicadorValorDTO;
	private IndicadorMinMetaMaxDTO indicadorMinMetaMaxDTO;
	private boolean isAbaixoMinimo;
	private boolean isAbaixoMeta;
	private boolean isAcimaMeta;
	private boolean isAcimaMaximo;
	private boolean isCorVermelho;
	private boolean isCorAmarelo;
	private boolean isCorVerde;
	
	// Marcos Sardinha: 2015-03-24
	private boolean isCorPink;
	private boolean isParadaComPeso;
	private boolean isParadaSemPeso;
	private boolean isSemPlanejamento;
	
	public IndicadorValorDTO getIndicadorValorDTO() {
		return indicadorValorDTO;
	}
	public void setIndicadorValorDTO(IndicadorValorDTO indicadorValorDTO) {
		this.indicadorValorDTO = indicadorValorDTO;
	}
	public IndicadorMinMetaMaxDTO getIndicadorMinMetaMaxDTO() {
		return indicadorMinMetaMaxDTO;
	}
	public void setIndicadorMinMetaMaxDTO(IndicadorMinMetaMaxDTO indicadorMinMetaMaxDTO) {
		this.indicadorMinMetaMaxDTO = indicadorMinMetaMaxDTO;
	}
	
	public boolean isAbaixoMinimo(){	
		return isAbaixoMinimo;
	}
	
	public void setAbaixoMinimo(boolean isAbaixoMinimo){
		this.isAbaixoMinimo = isAbaixoMinimo;
	}
	
	public boolean isAbaixoMeta(){
		return isAbaixoMeta;
	}	
	
	public void setAbaixoMeta(boolean isAbaixoMeta){
		this.isAbaixoMeta = isAbaixoMeta;
	}
	
	public boolean isAcimaMeta(){
		return this.isAcimaMeta;
	}	
	
	public void setAcimaMeta(boolean isAcimaMeta){
		this.isAcimaMeta = isAcimaMeta;
	}	

	
	public boolean isAcimaMaximo(){
		return this.isAcimaMaximo;
	}	

	public void setAcimaMaximo(boolean isAcimaMaximo){
		this.isAcimaMaximo = isAcimaMaximo;
	}

	public boolean isCorVerde(){
		return this.isCorVerde;
	}	

	public void setCorVerde(boolean isCorVerde){
		this.isCorVerde = isCorVerde;
	}

	public boolean isCorAmarelo(){
		return this.isCorAmarelo;
	}	

	public void setCorAmarelo(boolean isCorAmarelo){
		this.isCorAmarelo = isCorAmarelo;
	}
	
	public boolean isCorVermelho(){
		return this.isCorVermelho;
	}	

	public void setCorVermelho(boolean isCorVermelho){
		this.isCorVermelho = isCorVermelho;
	}
	public boolean isCorPink() {
		return isCorPink;
	}
	public void setCorPink(boolean isCorPink) {
		this.isCorPink = isCorPink;
	}
	public boolean isParadaComPeso() {
		return isParadaComPeso;
	}
	public void setParadaComPeso(boolean isParadaComPeso) {
		this.isParadaComPeso = isParadaComPeso;
	}
	public boolean isParadaSemPeso() {
		return isParadaSemPeso;
	}
	public void setParadaSemPeso(boolean isParadaSemPeso) {
		this.isParadaSemPeso = isParadaSemPeso;
	}
	public boolean isSemPlanejamento() {
		return isSemPlanejamento;
	}
	public void setSemPlanejamento(boolean isSemPlanejamento) {
		this.isSemPlanejamento = isSemPlanejamento;
	}

}
