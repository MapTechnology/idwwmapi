package ms.coleta.dto;



public class ItemGraficoOEEHoraHoraInjetDTO {
	private IntervaloTempoInjetDTO intervalo;
	private Integer ordemhora;
	private Double meta;
	private Double oee;
	private Double oeeAcumulado;
		
	public Integer getOrdemhora() {
		return ordemhora;
	}
	public void setOrdemhora(Integer ordemhora) {
		this.ordemhora = ordemhora;
	}
	public Double getMeta() {
		return meta;
	}
	public void setMeta(Double meta) {
		this.meta = meta;
	}
	public Double getOee() {
		return oee;
	}
	public void setOee(Double oee) {
		this.oee = oee;
	}
	public Double getOeeAcumulado() {
		return oeeAcumulado;
	}
	public void setOeeAcumulado(Double oeeAcumulado) {
		this.oeeAcumulado = oeeAcumulado;
	}
	public IntervaloTempoInjetDTO getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(IntervaloTempoInjetDTO intervalo) {
		this.intervalo = intervalo;
	}
	
	
}
