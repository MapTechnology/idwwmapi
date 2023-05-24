package idw.model.rn.injet.dto;

import java.io.Serializable;

import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class IndicadoresPorTurnoInjetDTO extends MaquinaTotalInjetDTO implements Serializable{

	private String cdTurno;
	private String dsTurno;
	
	public Float participacaoPerdasCavidadesNoTotalPerdas(){
		Float retorno = perdaCicloUnidade.floatValue();
		if (getPerdaTotalUnidade().floatValue() > 0){
			retorno = retorno / getPerdaTotalUnidade().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float participacaoPerdasRefugoNoTotalPerdas(){
		Float retorno = producaoRefugadaUnidade.floatValue();
		if (getPerdaTotalUnidade().floatValue() > 0){
			retorno = retorno / getPerdaTotalUnidade().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float participacaoPerdasCicloNoTotalPerdas(){
		Float retorno = perdaCicloUnidade.floatValue();
		if (getPerdaTotalUnidade().floatValue() > 0){
			retorno = retorno / getPerdaTotalUnidade().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float participacaoPerdasParadaNoTotalPerdas(){
		Float retorno = perdaParadasUnidade.floatValue();
		if (getPerdaTotalUnidade().floatValue() > 0){
			retorno = retorno / getPerdaTotalUnidade().floatValue();
			retorno = retorno * 100f;
		} else {
			retorno = 0f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	/**
	 * @return the cdTurno
	 */
	public String getCdTurno() {
		return cdTurno;
	}

	/**
	 * @param cdTurno the cdTurno to set
	 */
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}

	/**
	 * @return the dsTurno
	 */
	public String getDsTurno() {
		return dsTurno;
	}

	/**
	 * @param dsTurno the dsTurno to set
	 */
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
}
