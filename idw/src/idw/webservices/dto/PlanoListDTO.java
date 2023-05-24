package idw.webservices.dto;

import java.util.Date;
import java.util.List;

import idw.model.pojos.OmCfg;

public class PlanoListDTO {
	
	private List<PlanoDTO> planos;
	private ResultadoDTO resultado;
	private OmCfg configuracao;
	private Date dthrAtualConsulta;
	

	public void setPlanos(List<PlanoDTO> planos) {
		this.planos = planos;
	}

	public List<PlanoDTO> getPlanos() {
		return planos;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setConfiguracao(OmCfg configuracao) {
		this.configuracao = configuracao;
	}
	public OmCfg getConfiguracao() {
		return configuracao;
	}

	public void setDthrAtualConsulta(Date dthrAtualConsulta) {
		this.dthrAtualConsulta = dthrAtualConsulta;
	}

	public Date getDthrAtualConsulta() {
		return dthrAtualConsulta;
	}
	
}
