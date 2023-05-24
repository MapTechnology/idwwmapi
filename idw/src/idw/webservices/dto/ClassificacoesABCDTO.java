package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

public class ClassificacoesABCDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	private List<ClassificacaoABCDTO> listaClassificacaoABCDTO;
	private ResultadoDTO resultado;

	public List<ClassificacaoABCDTO> getListaDTO() {
		return listaClassificacaoABCDTO;
	}
	public void setListaDTO(List<ClassificacaoABCDTO> listaClassificacaoABCDTO) {
		this.listaClassificacaoABCDTO = listaClassificacaoABCDTO;
	}
    public ResultadoDTO getResultado() {
        return resultado;
    }
    public void setResultado(ResultadoDTO resultado) {
        this.resultado = resultado;
    }
	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}
	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}	
	
}
