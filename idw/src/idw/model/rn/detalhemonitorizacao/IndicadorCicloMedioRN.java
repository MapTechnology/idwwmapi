package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;

// TODO milton - mover classe e substituir chamada por FormulasInjet.calcularCicloMedio
public class IndicadorCicloMedioRN {

	private final BigDecimal segAutoTempoCicloProdutivo;
	private final BigDecimal segAutoQtCicloProdutivo;
	
	public IndicadorCicloMedioRN(OmCfg omcfg, OmPt ompt, BigDecimal segAutoTempoCicloProdutivo, BigDecimal setAutoQtCicloProdutivo, BigDecimal segAutoTempoparadasp) {
		super();
		this.segAutoQtCicloProdutivo = setAutoQtCicloProdutivo;
		this.segAutoTempoCicloProdutivo = segAutoTempoCicloProdutivo;
	}
	
	public BigDecimal calcularCicloMedio() {
		BigDecimal retorno = this.segAutoTempoCicloProdutivo;
		
		if (retorno == null) {
			return BigDecimal.ZERO;
		}
		
		//if (ompt.getOmTppt().equals(omcfg.getOmTpptByIdTpptinsersora()) && segAutoTempoParadasp != null) {
		//	retorno = retorno.subtract(segAutoTempoParadasp);
		//}
		if (segAutoQtCicloProdutivo != null && retorno != null) {
			if (segAutoQtCicloProdutivo.intValue() != 0)
				retorno = retorno.divide(segAutoQtCicloProdutivo, RoundingMode.HALF_DOWN);
			else
				retorno = BigDecimal.ZERO;
		} else {
			retorno = BigDecimal.ZERO;
		}
		if (retorno == null)
			retorno = BigDecimal.ZERO;
		return retorno;
	}
}
