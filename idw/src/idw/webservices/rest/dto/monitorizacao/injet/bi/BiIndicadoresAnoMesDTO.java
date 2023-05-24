package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.util.ArrayList;
import java.util.List;

import idw.webservices.rest.dto.monitorizacao.GraficoIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.PtTemposDTO;

public class BiIndicadoresAnoMesDTO {
	private String ano;
	private String mes;
	private BiFiltroDTO filtro = new BiFiltroDTO();
	private BiIndicadoresDTO indicadores = new BiIndicadoresDTO();
	private GraficoIndicadorDTO indicadoresGrafico = new GraficoIndicadorDTO();
	private GraficoIndicadorPerdaDTO indicadoresGraficoPerda = new GraficoIndicadorPerdaDTO();
	private PtTemposDTO temposDiagrama = new PtTemposDTO();
	private List<GraficoPizzaDTO> graficoPerdasPizza = new ArrayList<GraficoPizzaDTO>();
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public BiFiltroDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(BiFiltroDTO filtro) {
		this.filtro = filtro;
	}
	public BiIndicadoresDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(BiIndicadoresDTO indicadores) {
		this.indicadores = indicadores;
	}
	public GraficoIndicadorDTO getIndicadoresGrafico() {
		return indicadoresGrafico;
	}
	public void setIndicadoresGrafico(GraficoIndicadorDTO indicadoresGrafico) {
		this.indicadoresGrafico = indicadoresGrafico;
	}
	public GraficoIndicadorPerdaDTO getIndicadoresGraficoPerda() {
		return indicadoresGraficoPerda;
	}
	public void setIndicadoresGraficoPerda(GraficoIndicadorPerdaDTO indicadoresGraficoPerda) {
		this.indicadoresGraficoPerda = indicadoresGraficoPerda;
	}
	public PtTemposDTO getTemposDiagrama() {
		return temposDiagrama;
	}
	public void setTemposDiagrama(PtTemposDTO temposDiagrama) {
		this.temposDiagrama = temposDiagrama;
	}
	public List<GraficoPizzaDTO> getGraficoPerdasPizza() {
		return graficoPerdasPizza;
	}
	public void setGraficoPerdasPizza(List<GraficoPizzaDTO> graficoPerdasPizza) {
		this.graficoPerdasPizza = graficoPerdasPizza;
	}
		
}
