package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptIndicador")
public class PtIndicadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String eficiencia;
	private String utilizacao;
	private String eficienciaRealizacao;
	private String eficienciaCiclo;
	private String eficienciaCiclosPond;
	private String indiceRefugo;
	private String indiceParada;
	private String indicePerdaOuNR;
	private String eficienciaInstantanea;
	private String indiceProducao;
	private String indiceCavidadesAtivas;
	private String indiceProdutividadeOEE;
	private String indiceProdutividadeOEECapital;
	
	private String eficienciaRealizacaoCor;
	private String eficienciaCicloCor;
	private String eficienciaInstantaneaCor;
	private String indiceRefugoCor;
	private String indiceParadaCor;
	private String indicePerdaCor;
	private String indiceCavidadesAtivasCor;
	private String indiceProdutividadeOEECor;

	private String indicePerdaProduto;
	private String eficienciaCicloMedio;
	private String indiceCavidadesInativas;
	
	private String indicePerdaProdutoCor;
	private String eficienciaCicloMedioCor;
	private String indiceCavidadesInativasCor;
	
	private String indicePerdaOuNRCor;
	
	
	public String getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(String eficiencia) {
		this.eficiencia = eficiencia;
	}
	public String getUtilizacao() {
		return utilizacao;
	}
	public void setUtilizacao(String utilizacao) {
		this.utilizacao = utilizacao;
	}
	public String getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(String eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	public String getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(String eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public String getEficienciaCiclosPond() {
		return eficienciaCiclosPond;
	}
	public void setEficienciaCiclosPond(String eficienciaCiclosPond) {
		this.eficienciaCiclosPond = eficienciaCiclosPond;
	}
	public String getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(String indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public String getIndiceParada() {
		return indiceParada;
	}
	public void setIndiceParada(String indiceParada) {
		this.indiceParada = indiceParada;
	}
	public String getIndicePerdaOuNR() {
		return indicePerdaOuNR;
	}
	public void setIndicePerdaOuNR(String indicePerdaOuNR) {
		this.indicePerdaOuNR = indicePerdaOuNR;
	}
	public String getEficienciaInstantanea() {
		return eficienciaInstantanea;
	}
	public void setEficienciaInstantanea(String eficienciaInstantanea) {
		this.eficienciaInstantanea = eficienciaInstantanea;
	}
	public String getIndiceProducao() {
		return indiceProducao;
	}
	public void setIndiceProducao(String indiceProducao) {
		this.indiceProducao = indiceProducao;
	}
	public String getIndiceCavidadesAtivas() {
		return indiceCavidadesAtivas;
	}
	public void setIndiceCavidadesAtivas(String indiceCavidadesAtivas) {
		this.indiceCavidadesAtivas = indiceCavidadesAtivas;
	}
	public String getIndiceProdutividadeOEE() {
		return indiceProdutividadeOEE;
	}
	public void setIndiceProdutividadeOEE(String indiceProdutividadeOEE) {
		this.indiceProdutividadeOEE = indiceProdutividadeOEE;
	}
	public String getIndiceProdutividadeOEECapital() {
		return indiceProdutividadeOEECapital;
	}
	public void setIndiceProdutividadeOEECapital(
			String indiceProdutividadeOEECapital) {
		this.indiceProdutividadeOEECapital = indiceProdutividadeOEECapital;
	}
	public String getEficienciaRealizacaoCor() {
		return eficienciaRealizacaoCor;
	}
	public void setEficienciaRealizacaoCor(String eficienciaRealizacaoCor) {
		this.eficienciaRealizacaoCor = eficienciaRealizacaoCor;
	}
	public String getEficienciaCicloCor() {
		return eficienciaCicloCor;
	}
	public void setEficienciaCicloCor(String eficienciaCicloCor) {
		this.eficienciaCicloCor = eficienciaCicloCor;
	}
	public String getEficienciaInstantaneaCor() {
		return eficienciaInstantaneaCor;
	}
	public void setEficienciaInstantaneaCor(String eficienciaInstantaneaCor) {
		this.eficienciaInstantaneaCor = eficienciaInstantaneaCor;
	}
	public String getIndiceRefugoCor() {
		return indiceRefugoCor;
	}
	public void setIndiceRefugoCor(String indiceRefugoCor) {
		this.indiceRefugoCor = indiceRefugoCor;
	}
	public String getIndiceParadaCor() {
		return indiceParadaCor;
	}
	public void setIndiceParadaCor(String indiceParadaCor) {
		this.indiceParadaCor = indiceParadaCor;
	}
	public String getIndicePerdaCor() {
		return indicePerdaCor;
	}
	public void setIndicePerdaCor(String indicePerdaCor) {
		this.indicePerdaCor = indicePerdaCor;
	}
	public String getIndiceCavidadesAtivasCor() {
		return indiceCavidadesAtivasCor;
	}
	public void setIndiceCavidadesAtivasCor(String indiceCavidadesAtivasCor) {
		this.indiceCavidadesAtivasCor = indiceCavidadesAtivasCor;
	}
	public String getIndiceProdutividadeOEECor() {
		return indiceProdutividadeOEECor;
	}
	public void setIndiceProdutividadeOEECor(String indiceProdutividadeOEECor) {
		this.indiceProdutividadeOEECor = indiceProdutividadeOEECor;
	}
	public String getIndicePerdaProduto() {
		return indicePerdaProduto;
	}
	public void setIndicePerdaProduto(String indicePerdaProduto) {
		this.indicePerdaProduto = indicePerdaProduto;
	}
	public String getEficienciaCicloMedio() {
		return eficienciaCicloMedio;
	}
	public void setEficienciaCicloMedio(String eficienciaCicloMedio) {
		this.eficienciaCicloMedio = eficienciaCicloMedio;
	}
	public String getIndiceCavidadesInativas() {
		return indiceCavidadesInativas;
	}
	public void setIndiceCavidadesInativas(String indiceCavidadesInativas) {
		this.indiceCavidadesInativas = indiceCavidadesInativas;
	}
	public String getIndicePerdaProdutoCor() {
		return indicePerdaProdutoCor;
	}
	public void setIndicePerdaProdutoCor(String indicePerdaProdutoCor) {
		this.indicePerdaProdutoCor = indicePerdaProdutoCor;
	}
	public String getEficienciaCicloMedioCor() {
		return eficienciaCicloMedioCor;
	}
	public void setEficienciaCicloMedioCor(String eficienciaCicloMedioCor) {
		this.eficienciaCicloMedioCor = eficienciaCicloMedioCor;
	}
	public String getIndiceCavidadesInativasCor() {
		return indiceCavidadesInativasCor;
	}
	public void setIndiceCavidadesInativasCor(String indiceCavidadesInativasCor) {
		this.indiceCavidadesInativasCor = indiceCavidadesInativasCor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIndicePerdaOuNRCor() {
		return indicePerdaOuNRCor;
	}
	public void setIndicePerdaOuNRCor(String indicePerdaOuNRCor) {
		this.indicePerdaOuNRCor = indicePerdaOuNRCor;
	}
	
	
	
	
}
