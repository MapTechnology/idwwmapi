package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.util.ArrayList;
import java.util.List;

import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.PtTemposDTO;

public class BiIndicadoresTurnoDTO  {

	private String cdTurno;
	private String dsTurno;
	private BiFiltroDTO filtro = new BiFiltroDTO();
	private BiIndicadoresDTO indicadores = new BiIndicadoresDTO();
	
	/*
	private List<GraficoPizzaDTO> graficoPerdasPizza = new ArrayList<GraficoPizzaDTO>();
	private List<BiIndicadoresDtRefDTO> indicadoresDtRef = new ArrayList<BiIndicadoresDtRefDTO>();
	private List<BiIndicadoresAnoMesDTO> indicadoresAnoMes = new ArrayList<BiIndicadoresAnoMesDTO>();
	private PtTemposDTO temposDiagrama;
	*/
	
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
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
	
	/*
	public List<GraficoPizzaDTO> getGraficoPerdasPizza() {
		return graficoPerdasPizza;
	}
	public void setGraficoPerdasPizza(List<GraficoPizzaDTO> graficoPerdasPizza) {
		this.graficoPerdasPizza = graficoPerdasPizza;
	}
	public List<BiIndicadoresDtRefDTO> getIndicadoresDtRef() {
		return indicadoresDtRef;
	}
	public void setIndicadoresDtRef(List<BiIndicadoresDtRefDTO> indicadoresDtRef) {
		this.indicadoresDtRef = indicadoresDtRef;
	}
	public List<BiIndicadoresAnoMesDTO> getIndicadoresAnoMes() {
		return indicadoresAnoMes;
	}
	public void setIndicadoresAnoMes(List<BiIndicadoresAnoMesDTO> indicadoresAnoMes) {
		this.indicadoresAnoMes = indicadoresAnoMes;
	}
	public PtTemposDTO getTemposDiagrama() {
		return temposDiagrama;
	}
	public void setTemposDiagrama(PtTemposDTO temposDiagrama) {
		this.temposDiagrama = temposDiagrama;
	}
	*/
	
}
