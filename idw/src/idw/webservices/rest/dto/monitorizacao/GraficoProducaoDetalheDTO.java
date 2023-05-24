package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoProducaoDetalhe")
public class GraficoProducaoDetalheDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String hora;
	
	private String marcadorDs;
	private String marcadorCor;
	private boolean isMostrarMarcador;
	
	private String eficienciaRealizacaoComRefugo;
	private String eficienciaRealizacaoSemRefugo;
	private String eficienciaUtilizacao;
	private String eficienciaProdutividade;
	private String producaoLiquida;
	private String eficienciaRealizacaoComRefugoCor;
	private String eficienciaRealizacaoSemRefugoCor;
	private String eficienciaUtilizacaoCor;
	private String eficienciaProdutividadeCor;
	private String producaoLiquidaCor;
	
	private String dataHoraInicio;
	private String dataHoraFim;
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMarcadorDs() {
		return marcadorDs;
	}
	public void setMarcadorDs(String marcadorDs) {
		this.marcadorDs = marcadorDs;
	}
	public String getMarcadorCor() {
		return marcadorCor;
	}
	public void setMarcadorCor(String marcadorCor) {
		this.marcadorCor = marcadorCor;
	}
	public boolean isMostrarMarcador() {
		return isMostrarMarcador;
	}
	public void setMostrarMarcador(boolean isMostrarMarcador) {
		this.isMostrarMarcador = isMostrarMarcador;
	}
	public String getEficienciaRealizacaoComRefugo() {
		return eficienciaRealizacaoComRefugo;
	}
	public void setEficienciaRealizacaoComRefugo(
			String eficienciaRealizacaoComRefugo) {
		this.eficienciaRealizacaoComRefugo = eficienciaRealizacaoComRefugo;
	}
	public String getEficienciaRealizacaoSemRefugo() {
		return eficienciaRealizacaoSemRefugo;
	}
	public void setEficienciaRealizacaoSemRefugo(
			String eficienciaRealizacaoSemRefugo) {
		this.eficienciaRealizacaoSemRefugo = eficienciaRealizacaoSemRefugo;
	}
	public String getEficienciaUtilizacao() {
		return eficienciaUtilizacao;
	}
	public void setEficienciaUtilizacao(String eficienciaUtilizacao) {
		this.eficienciaUtilizacao = eficienciaUtilizacao;
	}
	public String getEficienciaProdutividade() {
		return eficienciaProdutividade;
	}
	public void setEficienciaProdutividade(String eficienciaProdutividade) {
		this.eficienciaProdutividade = eficienciaProdutividade;
	}
	public String getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(String producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public String getEficienciaRealizacaoComRefugoCor() {
		return eficienciaRealizacaoComRefugoCor;
	}
	public void setEficienciaRealizacaoComRefugoCor(
			String eficienciaRealizacaoComRefugoCor) {
		this.eficienciaRealizacaoComRefugoCor = eficienciaRealizacaoComRefugoCor;
	}
	public String getEficienciaRealizacaoSemRefugoCor() {
		return eficienciaRealizacaoSemRefugoCor;
	}
	public void setEficienciaRealizacaoSemRefugoCor(
			String eficienciaRealizacaoSemRefugoCor) {
		this.eficienciaRealizacaoSemRefugoCor = eficienciaRealizacaoSemRefugoCor;
	}
	public String getEficienciaUtilizacaoCor() {
		return eficienciaUtilizacaoCor;
	}
	public void setEficienciaUtilizacaoCor(String eficienciaUtilizacaoCor) {
		this.eficienciaUtilizacaoCor = eficienciaUtilizacaoCor;
	}
	public String getEficienciaProdutividadeCor() {
		return eficienciaProdutividadeCor;
	}
	public void setEficienciaProdutividadeCor(String eficienciaProdutividadeCor) {
		this.eficienciaProdutividadeCor = eficienciaProdutividadeCor;
	}
	public String getProducaoLiquidaCor() {
		return producaoLiquidaCor;
	}
	public void setProducaoLiquidaCor(String producaoLiquidaCor) {
		this.producaoLiquidaCor = producaoLiquidaCor;
	}
	public String getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public String getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	
	
	
	
	
}
