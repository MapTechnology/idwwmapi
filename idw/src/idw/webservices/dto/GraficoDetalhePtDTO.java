package idw.webservices.dto;

import java.util.Calendar;


/**
 * @author desen
 *
 */
public class GraficoDetalhePtDTO {
	private DwConsolidDTOs dwConsolidDTOs;
	private DwConsolidDTO dwConsolid;
	
	private Double limiteinferior;
	private Double limitesuperior;
	private Double meta ;
	private Double cicloPadrao;
	private Double cavAtivas;
	private Double metaHora;
	private boolean isComParadas;
	
	private Calendar dataIocorrencia;
    private Calendar dataFocorrencia;

    public GraficoDetalhePtDTO() {
    	super();
    }

	public Calendar getDataIocorrencia() {
		return dataIocorrencia;
	}

	public void setDataIocorrencia(Calendar dataIocorrencia) {
		this.dataIocorrencia = dataIocorrencia;
	}

	public Calendar getDataFocorrencia() {
		return dataFocorrencia;
	}

	public void setDataFocorrencia(Calendar dataFocorrencia) {
		this.dataFocorrencia = dataFocorrencia;
	}
	
	public Double getMetaHora() {
		return metaHora;
	}

	public void setMetaHora(Double metaHora) {
		this.metaHora = metaHora;
	}

	public Double getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(Double ciclosPadrao) {
		this.cicloPadrao = ciclosPadrao;
	}

	public Double getCavAtivas() {
		return cavAtivas;
	}

	public void setCavAtivas(Double cavAtivas) {
		this.cavAtivas = cavAtivas;
	}

	public DwConsolidDTO getDwConsolid() {
		return dwConsolid;
	}

	public void setDwConsolid(DwConsolidDTO dwConsolid) {
		this.dwConsolid = dwConsolid;
	}

	private int tpgrafico = 0;

	public int getTpgrafico() {
		return tpgrafico;
	}

	public void setTpgrafico(int tpgrafico) {
		this.tpgrafico = tpgrafico;
	}

	public DwConsolidDTOs getDwConsolidDTOs() {
		return dwConsolidDTOs;
	}

	public void setDwConsolidDTOs(DwConsolidDTOs dwConsolidDTOs) {
		this.dwConsolidDTOs = dwConsolidDTOs;
	}

	public Double getLimiteinferior() {
		return limiteinferior;
	}

	public void setLimiteinferior(Double limiteinferior) {
		this.limiteinferior = limiteinferior;
	}

	public Double getLimitesuperior() {
		return limitesuperior;
	}

	public void setLimitesuperior(Double limitesuperior) {
		this.limitesuperior = limitesuperior;
	}

	public Double getMeta() {
		return meta;
	}

	public void setMeta(Double meta) {
		this.meta = meta;
	}

	public boolean isComParadas() {
		return isComParadas;
	}

	public void setComParadas(boolean isComParadas) {
		this.isComParadas = isComParadas;
	}
	
}
