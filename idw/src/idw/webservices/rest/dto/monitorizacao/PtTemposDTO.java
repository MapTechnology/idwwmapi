package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptTempos")
public class PtTemposDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String tempoCalendario;
	private String tempoColeta;
	private String tempoSemColeta;
	private String tempoDisponivel;
	private String tempoTrabalhado;
	private String ciclosProdutivos;
	private String tempoProduzidoLiquido;
	private String tempoProdutivo;
	private String tempoDuplicadoColeta;
	private String tempoParadas;
	private String tempoNaoDisponivel;
	private String ciclosImprodutivo;
	private String tempoProducaoRefugada;
	private String ritmo;
	private String blankInativo;

	private String tempoCalendarioDec;
	private String tempoColetaDec;
	private String tempoSemColetaDec;
	private String tempoDisponivelDec;
	private String tempoTrabalhadoDec;
	private String ciclosProdutivosDec;
	private String tempoProduzidoLiquidoDec;
	private String tempoProdutivoDec;
	private String tempoDuplicadoColetaDec;
	private String tempoParadasDec;
	private String tempoNaoDisponivelDec;
	private String ciclosImprodutivoDec;
	private String tempoProducaoRefugadaDec;
	private String ritmoDec;
	private String blankInativoDec;
	
	
	private String ritmoSegundos;
	private String blankInativoSegundos;
	private String tempoProducaoRefugadaSegundos;
	private String ciclosImprodutivoSegundos;
	private String tempoParadasSegundos;
	private String tempoNaoDisponivelSegundos;
	private String tempoProdutivoSegundos;
	
	private String tempoColetaCor;
	private String tempoDisponivelCor;
	private String tempoTrabalhadoCor;
	private String ciclosProdutivosCor;
	private String tempoProduzidoLiquidoCor;
	private String tempoProdutivoCor;
	
	private String ritmoCor;
	private String blankInativoCor;
	private String tempoProducaoRefugadaCor;
	private String ciclosImprodutivoCor;
	private String tempoParadasCor;
	private String tempoNaoDisponivelCor;
	private String tempoProdutivoGraficoCor;
	
	private String indiceA;
	private String indiceB;
	private String indiceC;
	private String indiceD;
	private String indiceE;
	private String indiceF;
	private String indiceNaoDisp;
	private String indiceParadas;
	private String indiceRefugos;
	private String indiceRitmo;
	private String indicePCI;
	private String indiceCicImprodutivos;
	
	private String indicePizzaRitmo;
	private String indicePizzaPCI;
	private String indicePizzaRefugo;
	private String indicePizzaCicImprodutivo;
	private String indicePizzaParCP;
	private String indicePizzaParSP;
	private String indicePizzaProdutiva;
	
		
	public String getIndicePizzaRitmo() {
		return indicePizzaRitmo;
	}
	public void setIndicePizzaRitmo(String indicePizzaRitmo) {
		this.indicePizzaRitmo = indicePizzaRitmo;
	}
	public String getIndicePizzaPCI() {
		return indicePizzaPCI;
	}
	public void setIndicePizzaPCI(String indicePizzaPCI) {
		this.indicePizzaPCI = indicePizzaPCI;
	}
	public String getIndicePizzaRefugo() {
		return indicePizzaRefugo;
	}
	public void setIndicePizzaRefugo(String indicePizzaRefugo) {
		this.indicePizzaRefugo = indicePizzaRefugo;
	}
	public String getIndicePizzaCicImprodutivo() {
		return indicePizzaCicImprodutivo;
	}
	public void setIndicePizzaCicImprodutivo(String indicePizzaCicImprodutivo) {
		this.indicePizzaCicImprodutivo = indicePizzaCicImprodutivo;
	}
	public String getIndicePizzaParCP() {
		return indicePizzaParCP;
	}
	public void setIndicePizzaParCP(String indicePizzaParCP) {
		this.indicePizzaParCP = indicePizzaParCP;
	}
	public String getIndicePizzaParSP() {
		return indicePizzaParSP;
	}
	public void setIndicePizzaParSP(String indicePizzaParSP) {
		this.indicePizzaParSP = indicePizzaParSP;
	}
	public String getIndicePizzaProdutiva() {
		return indicePizzaProdutiva;
	}
	public void setIndicePizzaProdutiva(String indicePizzaProdutiva) {
		this.indicePizzaProdutiva = indicePizzaProdutiva;
	}
	public String getIndiceA() {
		return indiceA;
	}
	public void setIndiceA(String indiceA) {
		this.indiceA = indiceA;
	}
	public String getIndiceB() {
		return indiceB;
	}
	public void setIndiceB(String indiceB) {
		this.indiceB = indiceB;
	}
	public String getIndiceC() {
		return indiceC;
	}
	public void setIndiceC(String indiceC) {
		this.indiceC = indiceC;
	}
	public String getIndiceD() {
		return indiceD;
	}
	public void setIndiceD(String indiceD) {
		this.indiceD = indiceD;
	}
	public String getIndiceE() {
		return indiceE;
	}
	public void setIndiceE(String indiceE) {
		this.indiceE = indiceE;
	}
	public String getIndiceF() {
		return indiceF;
	}
	public void setIndiceF(String indiceF) {
		this.indiceF = indiceF;
	}
	public String getIndiceNaoDisp() {
		return indiceNaoDisp;
	}
	public void setIndiceNaoDisp(String indiceNaoDisp) {
		this.indiceNaoDisp = indiceNaoDisp;
	}
	public String getIndiceParadas() {
		return indiceParadas;
	}
	public void setIndiceParadas(String indiceParadas) {
		this.indiceParadas = indiceParadas;
	}
	public String getIndiceRefugos() {
		return indiceRefugos;
	}
	public void setIndiceRefugos(String indiceRefugos) {
		this.indiceRefugos = indiceRefugos;
	}
	public String getIndiceRitmo() {
		return indiceRitmo;
	}
	public void setIndiceRitmo(String indiceRitmo) {
		this.indiceRitmo = indiceRitmo;
	}
	public String getIndicePCI() {
		return indicePCI;
	}
	public void setIndicePCI(String indicePCI) {
		this.indicePCI = indicePCI;
	}
	public String getIndiceCicImprodutivos() {
		return indiceCicImprodutivos;
	}
	public void setIndiceCicImprodutivos(String indiceCicImprodutivos) {
		this.indiceCicImprodutivos = indiceCicImprodutivos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTempoCalendarioDec() {
		return tempoCalendarioDec;
	}
	public void setTempoCalendarioDec(String tempoCalendarioDec) {
		this.tempoCalendarioDec = tempoCalendarioDec;
	}
	public String getTempoColetaDec() {
		return tempoColetaDec;
	}
	public void setTempoColetaDec(String tempoColetaDec) {
		this.tempoColetaDec = tempoColetaDec;
	}
	public String getTempoSemColetaDec() {
		return tempoSemColetaDec;
	}
	public void setTempoSemColetaDec(String tempoSemColetaDec) {
		this.tempoSemColetaDec = tempoSemColetaDec;
	}
	public String getTempoDisponivelDec() {
		return tempoDisponivelDec;
	}
	public void setTempoDisponivelDec(String tempoDisponivelDec) {
		this.tempoDisponivelDec = tempoDisponivelDec;
	}
	public String getTempoTrabalhadoDec() {
		return tempoTrabalhadoDec;
	}
	public void setTempoTrabalhadoDec(String tempoTrabalhadoDec) {
		this.tempoTrabalhadoDec = tempoTrabalhadoDec;
	}
	public String getCiclosProdutivosDec() {
		return ciclosProdutivosDec;
	}
	public void setCiclosProdutivosDec(String ciclosProdutivosDec) {
		this.ciclosProdutivosDec = ciclosProdutivosDec;
	}
	public String getTempoProduzidoLiquidoDec() {
		return tempoProduzidoLiquidoDec;
	}
	public void setTempoProduzidoLiquidoDec(String tempoProduzidoLiquidoDec) {
		this.tempoProduzidoLiquidoDec = tempoProduzidoLiquidoDec;
	}
	public String getTempoProdutivoDec() {
		return tempoProdutivoDec;
	}
	public void setTempoProdutivoDec(String tempoProdutivoDec) {
		this.tempoProdutivoDec = tempoProdutivoDec;
	}
	public String getTempoDuplicadoColetaDec() {
		return tempoDuplicadoColetaDec;
	}
	public void setTempoDuplicadoColetaDec(String tempoDuplicadoColetaDec) {
		this.tempoDuplicadoColetaDec = tempoDuplicadoColetaDec;
	}
	public String getTempoParadasDec() {
		return tempoParadasDec;
	}
	public void setTempoParadasDec(String tempoParadasDec) {
		this.tempoParadasDec = tempoParadasDec;
	}
	public String getTempoNaoDisponivelDec() {
		return tempoNaoDisponivelDec;
	}
	public void setTempoNaoDisponivelDec(String tempoNaoDisponivelDec) {
		this.tempoNaoDisponivelDec = tempoNaoDisponivelDec;
	}
	public String getCiclosImprodutivoDec() {
		return ciclosImprodutivoDec;
	}
	public void setCiclosImprodutivoDec(String ciclosImprodutivoDec) {
		this.ciclosImprodutivoDec = ciclosImprodutivoDec;
	}
	public String getTempoProducaoRefugadaDec() {
		return tempoProducaoRefugadaDec;
	}
	public void setTempoProducaoRefugadaDec(String tempoProducaoRefugadaDec) {
		this.tempoProducaoRefugadaDec = tempoProducaoRefugadaDec;
	}
	public String getRitmoDec() {
		return ritmoDec;
	}
	public void setRitmoDec(String ritmoDec) {
		this.ritmoDec = ritmoDec;
	}
	public String getBlankInativoDec() {
		return blankInativoDec;
	}
	public void setBlankInativoDec(String blankInativoDec) {
		this.blankInativoDec = blankInativoDec;
	}
	public String getTempoCalendario() {
		return tempoCalendario;
	}
	public void setTempoCalendario(String tempoCalendario) {
		this.tempoCalendario = tempoCalendario;
	}
	public String getTempoColeta() {
		return tempoColeta;
	}
	public void setTempoColeta(String tempoColeta) {
		this.tempoColeta = tempoColeta;
	}
	public String getTempoSemColeta() {
		return tempoSemColeta;
	}
	public void setTempoSemColeta(String tempoSemColeta) {
		this.tempoSemColeta = tempoSemColeta;
	}
	public String getTempoDisponivel() {
		return tempoDisponivel;
	}
	public void setTempoDisponivel(String tempoDisponivel) {
		this.tempoDisponivel = tempoDisponivel;
	}
	public String getTempoTrabalhado() {
		return tempoTrabalhado;
	}
	public void setTempoTrabalhado(String tempoTrabalhado) {
		this.tempoTrabalhado = tempoTrabalhado;
	}
	public String getCiclosProdutivos() {
		return ciclosProdutivos;
	}
	public void setCiclosProdutivos(String ciclosProdutivos) {
		this.ciclosProdutivos = ciclosProdutivos;
	}
	public String getTempoProduzidoLiquido() {
		return tempoProduzidoLiquido;
	}
	public void setTempoProduzidoLiquido(String tempoProduzidoLiquido) {
		this.tempoProduzidoLiquido = tempoProduzidoLiquido;
	}
	public String getTempoProdutivo() {
		return tempoProdutivo;
	}
	public void setTempoProdutivo(String tempoProdutivo) {
		this.tempoProdutivo = tempoProdutivo;
	}
	public String getTempoDuplicadoColeta() {
		return tempoDuplicadoColeta;
	}
	public void setTempoDuplicadoColeta(String tempoDuplicadoColeta) {
		this.tempoDuplicadoColeta = tempoDuplicadoColeta;
	}
	public String getTempoParadas() {
		return tempoParadas;
	}
	public void setTempoParadas(String tempoParadas) {
		this.tempoParadas = tempoParadas;
	}
	public String getTempoNaoDisponivel() {
		return tempoNaoDisponivel;
	}
	public void setTempoNaoDisponivel(String tempoNaoDisponivel) {
		this.tempoNaoDisponivel = tempoNaoDisponivel;
	}
	public String getCiclosImprodutivo() {
		return ciclosImprodutivo;
	}
	public void setCiclosImprodutivo(String ciclosImprodutivo) {
		this.ciclosImprodutivo = ciclosImprodutivo;
	}
	public String getTempoProducaoRefugada() {
		return tempoProducaoRefugada;
	}
	public void setTempoProducaoRefugada(String tempoProducaoRefugada) {
		this.tempoProducaoRefugada = tempoProducaoRefugada;
	}
	public String getRitmo() {
		return ritmo;
	}
	public void setRitmo(String ritmo) {
		this.ritmo = ritmo;
	}
	public String getBlankInativo() {
		return blankInativo;
	}
	public void setBlankInativo(String blankInativo) {
		this.blankInativo = blankInativo;
	}
	public String getRitmoSegundos() {
		return ritmoSegundos;
	}
	public void setRitmoSegundos(String ritmoSegundos) {
		this.ritmoSegundos = ritmoSegundos;
	}
	public String getBlankInativoSegundos() {
		return blankInativoSegundos;
	}
	public void setBlankInativoSegundos(String blankInativoSegundos) {
		this.blankInativoSegundos = blankInativoSegundos;
	}
	public String getTempoProducaoRefugadaSegundos() {
		return tempoProducaoRefugadaSegundos;
	}
	public void setTempoProducaoRefugadaSegundos(
			String tempoProducaoRefugadaSegundos) {
		this.tempoProducaoRefugadaSegundos = tempoProducaoRefugadaSegundos;
	}
	public String getCiclosImprodutivoSegundos() {
		return ciclosImprodutivoSegundos;
	}
	public void setCiclosImprodutivoSegundos(String ciclosImprodutivoSegundos) {
		this.ciclosImprodutivoSegundos = ciclosImprodutivoSegundos;
	}
	public String getTempoParadasSegundos() {
		return tempoParadasSegundos;
	}
	public void setTempoParadasSegundos(String tempoParadasSegundos) {
		this.tempoParadasSegundos = tempoParadasSegundos;
	}
	public String getTempoNaoDisponivelSegundos() {
		return tempoNaoDisponivelSegundos;
	}
	public void setTempoNaoDisponivelSegundos(String tempoNaoDisponivelSegundos) {
		this.tempoNaoDisponivelSegundos = tempoNaoDisponivelSegundos;
	}
	public String getTempoProdutivoSegundos() {
		return tempoProdutivoSegundos;
	}
	public void setTempoProdutivoSegundos(String tempoProdutivoSegundos) {
		this.tempoProdutivoSegundos = tempoProdutivoSegundos;
	}
	public String getTempoColetaCor() {
		return tempoColetaCor;
	}
	public void setTempoColetaCor(String tempoColetaCor) {
		this.tempoColetaCor = tempoColetaCor;
	}
	public String getTempoDisponivelCor() {
		return tempoDisponivelCor;
	}
	public void setTempoDisponivelCor(String tempoDisponivelCor) {
		this.tempoDisponivelCor = tempoDisponivelCor;
	}
	public String getTempoTrabalhadoCor() {
		return tempoTrabalhadoCor;
	}
	public void setTempoTrabalhadoCor(String tempoTrabalhadoCor) {
		this.tempoTrabalhadoCor = tempoTrabalhadoCor;
	}
	public String getCiclosProdutivosCor() {
		return ciclosProdutivosCor;
	}
	public void setCiclosProdutivosCor(String ciclosProdutivosCor) {
		this.ciclosProdutivosCor = ciclosProdutivosCor;
	}
	public String getTempoProduzidoLiquidoCor() {
		return tempoProduzidoLiquidoCor;
	}
	public void setTempoProduzidoLiquidoCor(String tempoProduzidoLiquidoCor) {
		this.tempoProduzidoLiquidoCor = tempoProduzidoLiquidoCor;
	}
	public String getTempoProdutivoCor() {
		return tempoProdutivoCor;
	}
	public void setTempoProdutivoCor(String tempoProdutivoCor) {
		this.tempoProdutivoCor = tempoProdutivoCor;
	}
	public String getRitmoCor() {
		return ritmoCor;
	}
	public void setRitmoCor(String ritmoCor) {
		this.ritmoCor = ritmoCor;
	}
	public String getBlankInativoCor() {
		return blankInativoCor;
	}
	public void setBlankInativoCor(String blankInativoCor) {
		this.blankInativoCor = blankInativoCor;
	}
	public String getTempoProducaoRefugadaCor() {
		return tempoProducaoRefugadaCor;
	}
	public void setTempoProducaoRefugadaCor(String tempoProducaoRefugadaCor) {
		this.tempoProducaoRefugadaCor = tempoProducaoRefugadaCor;
	}
	public String getCiclosImprodutivoCor() {
		return ciclosImprodutivoCor;
	}
	public void setCiclosImprodutivoCor(String ciclosImprodutivoCor) {
		this.ciclosImprodutivoCor = ciclosImprodutivoCor;
	}
	public String getTempoParadasCor() {
		return tempoParadasCor;
	}
	public void setTempoParadasCor(String tempoParadasCor) {
		this.tempoParadasCor = tempoParadasCor;
	}
	public String getTempoNaoDisponivelCor() {
		return tempoNaoDisponivelCor;
	}
	public void setTempoNaoDisponivelCor(String tempoNaoDisponivelCor) {
		this.tempoNaoDisponivelCor = tempoNaoDisponivelCor;
	}
	public String getTempoProdutivoGraficoCor() {
		return tempoProdutivoGraficoCor;
	}
	public void setTempoProdutivoGraficoCor(String tempoProdutivoGraficoCor) {
		this.tempoProdutivoGraficoCor = tempoProdutivoGraficoCor;
	}
	
	
		
	
}
