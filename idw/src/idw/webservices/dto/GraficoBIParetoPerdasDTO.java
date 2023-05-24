package idw.webservices.dto;

public class GraficoBIParetoPerdasDTO {
    private Long idItemPareto;
    private String cdItemPareto;
    private String dsItemPareto;
    private Double qtdItem;
    private Double indItem;
    
    private Double qtdItemEmKg;
    private Double indItemEmKg;
    private Double qtdItemEmTon;
    private Double indItemEmTon;
    private Double qtdItemEmUnidadeMonetaria;
    private Double indItemEmUnidadeMonetaria;
    
    private String toolTipItem;
    private String toolTipItemKg;
    private String toolTipItemTon;
    private String toolTipItemUnidadeMonetaria;
	
    private Double segTempo;
    
    private Boolean isParadaSemPeso = false;
    
    public String getToolTipItemKg() {
		return toolTipItemKg;
	}


	public void setToolTipItemKg(String toolTipItemKg) {
		this.toolTipItemKg = toolTipItemKg;
	}


	public String getToolTipItemTon() {
		return toolTipItemTon;
	}


	public void setToolTipItemTon(String toolTipItemTon) {
		this.toolTipItemTon = toolTipItemTon;
	}


	public String getToolTipItemUnidadeMonetaria() {
		return toolTipItemUnidadeMonetaria;
	}


	public void setToolTipItemUnidadeMonetaria(String toolTipItemUnidadeMonetaria) {
		this.toolTipItemUnidadeMonetaria = toolTipItemUnidadeMonetaria;
	}


	public GraficoBIParetoPerdasDTO()
    {
    	
    }
    
    
    public Double getQtdItemEmKg() {
		return qtdItemEmKg;
	}

	public void setQtdItemEmKg(Double qtdItemEmKg) {
		this.qtdItemEmKg = qtdItemEmKg;
	}

	public Double getIndItemEmKg() {
		return indItemEmKg;
	}

	public void setIndItemEmKg(Double indItemEmKg) {
		this.indItemEmKg = indItemEmKg;
	}

	public Double getQtdItemEmTon() {
		return qtdItemEmTon;
	}

	public void setQtdItemEmTon(Double qtdItemEmTon) {
		this.qtdItemEmTon = qtdItemEmTon;
	}

	public Double getIndItemEmTon() {
		return indItemEmTon;
	}

	public void setIndItemEmTon(Double indItemEmTon) {
		this.indItemEmTon = indItemEmTon;
	}

	public Double getQtdItemEmUnidadeMonetaria() {
		return qtdItemEmUnidadeMonetaria;
	}

	public void setQtdItemEmUnidadeMonetaria(Double qtdItemEmUnidadeMonetaria) {
		this.qtdItemEmUnidadeMonetaria = qtdItemEmUnidadeMonetaria;
	}

	public Double getIndItemEmUnidadeMonetaria() {
		return indItemEmUnidadeMonetaria;
	}

	public void setIndItemEmUnidadeMonetaria(Double indItemEmUnidadeMonetaria) {
		this.indItemEmUnidadeMonetaria = indItemEmUnidadeMonetaria;
	}


	public Long getIdItemPareto() {
		return idItemPareto;
	}

	public void setIdItemPareto(Long idItemPareto) {
		this.idItemPareto = idItemPareto;
	}

	public String getCdItemPareto() {
		return cdItemPareto;
	}

	public void setCdItemPareto(String cdItemPareto) {
		this.cdItemPareto = cdItemPareto;
	}

	public String getDsItemPareto() {
		return dsItemPareto;
	}

	public void setDsItemPareto(String dsItemPareto) {
		this.dsItemPareto = dsItemPareto;
	}

	public String getToolTipItem() {
		return toolTipItem;
	}

	public void setToolTipItem(String toolTipItem) {
		this.toolTipItem = toolTipItem;
	}

	public Double getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(Double qtdItem) {
		this.qtdItem = qtdItem;
	}

	public Double getIndItem() {
		return indItem;
	}

	public void setIndItem(Double indItem) {
		this.indItem = indItem;
	}


	public Double getSegTempo() {
		return segTempo;
	}


	public void setSegTempo(Double segTempo) {
		this.segTempo = segTempo;
	}


	public Boolean getIsParadaSemPeso() {
		return isParadaSemPeso;
	}


	public void setIsParadaSemPeso(Boolean isParadaSemPeso) {
		this.isParadaSemPeso = isParadaSemPeso;
	}
}
