package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwEstsalma;

/**
 *
 * @author Adriano souza
 */
@SuppressWarnings("serial")
public class EstoquesDTO implements Serializable {
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
    private List<EstoqueDTO> estoques;
    private List<DwEstsalma> saldosAnteriores =  new ArrayList<DwEstsalma>();
    private List<DwEstsalma> saldosAnterioresExcluidos =  new ArrayList<DwEstsalma>();

	public List<EstoqueDTO> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<EstoqueDTO> estoques) {
		this.estoques = estoques;
	}

	public List<DwEstsalma> getSaldosAnteriores() {
		return saldosAnteriores;
	}

	public void setSaldosAnteriores(List<DwEstsalma> saldosAnteriores) {
		this.saldosAnteriores = saldosAnteriores;
	}

	public List<DwEstsalma> getSaldosAnterioresExcluidos() {
		return saldosAnterioresExcluidos;
	}

	public void setSaldosAnterioresExcluidos(
			List<DwEstsalma> saldosAnterioresExcluidos) {
		this.saldosAnterioresExcluidos = saldosAnterioresExcluidos;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}
}