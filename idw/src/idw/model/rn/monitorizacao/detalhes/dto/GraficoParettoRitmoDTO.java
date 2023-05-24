package idw.model.rn.monitorizacao.detalhes.dto;

import java.util.ArrayList;
import java.util.List;

import idw.webservices.dto.OcorrenciasEvtDTO;

public class GraficoParettoRitmoDTO {

	private Long idTritmo;
	private String cdTritmo;
	private String dsTritmo;
	private String dataInicio;
	private String dataFim;
	private long duracao;
	private String duracaoFormatado;
	private String corBarra;
	
	private List<OcorrenciasEvtDTO> ocorrencias = new ArrayList<>();
	
	public Long getIdTritmo() {
		return idTritmo;
	}
	public void setIdTritmo(Long idTritmo) {
		this.idTritmo = idTritmo;
	}
	public String getCdTritmo() {
		return cdTritmo;
	}
	public void setCdTritmo(String cdTritmo) {
		this.cdTritmo = cdTritmo;
	}
	public String getDsTritmo() {
		return dsTritmo;
	}
	public void setDsTritmo(String dsTritmo) {
		this.dsTritmo = dsTritmo;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public long getDuracao() {
		return duracao;
	}
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}
	public String getDuracaoFormatado() {
		return duracaoFormatado;
	}
	public void setDuracaoFormatado(String duracaoFormatado) {
		this.duracaoFormatado = duracaoFormatado;
	}
	public String getCorBarra() {
		return corBarra;
	}
	public void setCorBarra(String corBarra) {
		this.corBarra = corBarra;
	}
	public List<OcorrenciasEvtDTO> getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(List<OcorrenciasEvtDTO> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	
}
