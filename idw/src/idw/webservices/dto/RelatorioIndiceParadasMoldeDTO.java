package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwRap;

public class RelatorioIndiceParadasMoldeDTO {
	
	private String molde;
	private String tempoAtivoMolde;
	private String maquina;
	private String tempoAtivoMaquina;
	private String parada;
	private String dsParada;
	private BigDecimal tempo;
	private String indiceBaseB;
	private String indiceBaseA;
	private Double indice;
	private String padrao;
    private String modelo1;
    private String modelo2;
    private String descMolde;
    private Integer numeroLinhaRel;
    private String totalMaquinaTempo;
    private String totalMaquinaIndiceBaseB;
    private String totalMaquinaIndiceBaseA;
    private String totalMoldeTempo;
    private String totalMoldeIndiceBaseB;
    private String totalMoldeIndiceBaseA;
    private String totalMoldeIndiceBaseC;
    private BigDecimal tempoPorMaquina;
    
    public RelatorioIndiceParadasMoldeDTO() {
    	super();
    }
    
    public RelatorioIndiceParadasMoldeDTO(DwConsolpa pa) {
    	String cdMolde = "";
    	String dsMolde = "";
    	
    	if(pa.getDwConsol().getDwConsolid() != null
    			&& pa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps() != null
    			&& pa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps().size() > 0){
    		
    		List<DwFolharap> raps = new ArrayList<>();
    		raps.addAll(pa.getDwConsol().getDwConsolid().getDwFolha().getDwFolharaps());
    		DwRap rap = raps.get(0).getDwRap();
    		
    		cdMolde = rap != null ? rap.getCdRap(): "";
    		dsMolde = rap != null ? rap.getDsRap(): "";
    	}
		String cdPt = pa.getDwConsol().getDwConsolid().getOmPt() != null ? pa.getDwConsol().getDwConsolid().getOmPt().getCdPt() : "";
		
		setMolde(cdMolde);
		setDescMolde(dsMolde);
		setMaquina(cdPt);
		setParada(pa.getDwTParada().getCdTparada());
		setDsParada(pa.getDwTParada().getDsTparada());
		setTempo(BigDecimal.ZERO);

    }
    public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	public String getTempoAtivoMolde() {
		return tempoAtivoMolde;
	}
	public void setTempoAtivoMolde(String tempoAtivoMolde) {
		this.tempoAtivoMolde = tempoAtivoMolde;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getTempoAtivoMaquina() {
		return tempoAtivoMaquina;
	}
	public void setTempoAtivoMaquina(String tempoAtivoMaquina) {
		this.tempoAtivoMaquina = tempoAtivoMaquina;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public BigDecimal getTempo() {
		return tempo;
	}
	public void setTempo(BigDecimal tempo) {
		this.tempo = tempo;
	}
	public String getIndiceBaseB() {
		return indiceBaseB;
	}
	public void setIndiceBaseB(String indiceBaseB) {
		this.indiceBaseB = indiceBaseB;
	}
	public String getIndiceBaseA() {
		return indiceBaseA;
	}
	public void setIndiceBaseA(String indiceBaseA) {
		this.indiceBaseA = indiceBaseA;
	}
	public String getPadrao() {
		return padrao;
	}
	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}
	public String getModelo1() {
		return modelo1;
	}
	public void setModelo1(String modelo1) {
		this.modelo1 = modelo1;
	}
	public String getModelo2() {
		return modelo2;
	}
	public void setModelo2(String modelo2) {
		this.modelo2 = modelo2;
	}
	public String getDescMolde() {
		return descMolde;
	}
	public void setDescMolde(String descMolde) {
		this.descMolde = descMolde;
	}
	public Integer getNumeroLinhaRel() {
		return numeroLinhaRel;
	}
	public void setNumeroLinhaRel(Integer numeroLinhaRel) {
		this.numeroLinhaRel = numeroLinhaRel;
	}
	public String getTotalMaquinaTempo() {
		return totalMaquinaTempo;
	}
	public void setTotalMaquinaTempo(String totalMaquinaTempo) {
		this.totalMaquinaTempo = totalMaquinaTempo;
	}
	public String getTotalMaquinaIndiceBaseB() {
		return totalMaquinaIndiceBaseB;
	}
	public void setTotalMaquinaIndiceBaseB(String totalMaquinaIndiceBaseB) {
		this.totalMaquinaIndiceBaseB = totalMaquinaIndiceBaseB;
	}
	public String getTotalMaquinaIndiceBaseA() {
		return totalMaquinaIndiceBaseA;
	}
	public void setTotalMaquinaIndiceBaseA(String totalMaquinaIndiceBaseA) {
		this.totalMaquinaIndiceBaseA = totalMaquinaIndiceBaseA;
	}
	public String getTotalMoldeTempo() {
		return totalMoldeTempo;
	}
	public void setTotalMoldeTempo(String totalMoldeTempo) {
		this.totalMoldeTempo = totalMoldeTempo;
	}
	public String getTotalMoldeIndiceBaseB() {
		return totalMoldeIndiceBaseB;
	}
	public void setTotalMoldeIndiceBaseB(String totalMoldeIndiceBaseB) {
		this.totalMoldeIndiceBaseB = totalMoldeIndiceBaseB;
	}
	public String getTotalMoldeIndiceBaseA() {
		return totalMoldeIndiceBaseA;
	}
	public void setTotalMoldeIndiceBaseA(String totalMoldeIndiceBaseA) {
		this.totalMoldeIndiceBaseA = totalMoldeIndiceBaseA;
	}
	public Double getIndice() {
		return indice;
	}
	public void setIndice(Double indice) {
		this.indice = indice;
	}
	public BigDecimal getTempoPorMaquina() {
		return tempoPorMaquina;
	}
	public void setTempoPorMaquina(BigDecimal tempoPorMaquina) {
		this.tempoPorMaquina = tempoPorMaquina;
	}

	
	public boolean isExiste(DwConsolpa pa) {
		RelatorioIndiceParadasMoldeDTO from = new RelatorioIndiceParadasMoldeDTO(pa);
		return this.equals(from);
	}

	@Override
	public boolean equals(Object value) {
		RelatorioIndiceParadasMoldeDTO dto = (RelatorioIndiceParadasMoldeDTO) value;
		return getMolde().equals(dto.getMolde()) && getMaquina().equals(dto.getMaquina()) && getParada().equals(dto.getParada());
	}

	public String getTotalMoldeIndiceBaseC() {
		return totalMoldeIndiceBaseC;
	}

	public void setTotalMoldeIndiceBaseC(String totalMoldeIndiceBaseC) {
		this.totalMoldeIndiceBaseC = totalMoldeIndiceBaseC;
	}

	public String getDsParada() {
		return dsParada;
	}

	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}
}
