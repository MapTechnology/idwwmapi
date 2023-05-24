package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.util.ArrayList;
import java.util.List;

import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtTemposDTO;

public class BiResumoDTO  {

	private BiFiltroDTO filtroBI = new BiFiltroDTO();
	private BiIndicadoresDTO indicadores = new BiIndicadoresDTO();
	private List<MetaIndicadorDTO> metaIndicadores = new ArrayList<MetaIndicadorDTO>();;
	private List<MetaIndicadorDTO> metaIndicadoresGraficoPontos= new ArrayList<MetaIndicadorDTO>();
	private List<BiIndicadoresTurnoDTO> indicadoresTurno = new ArrayList<BiIndicadoresTurnoDTO>();
	private List<BiIndicadoresAnoMesDTO> indicadoresAnoMes = new ArrayList<BiIndicadoresAnoMesDTO>();
	private List<BiIndicadoresDtRefDTO> indicadoresDtRef = new ArrayList<BiIndicadoresDtRefDTO>();
	private List<BiIndicadoresPTDTO> indicadoresPt = new ArrayList<BiIndicadoresPTDTO>();
	private List<BiIndicadoresFicTecDTO> indicadoresFichaTec = new ArrayList<BiIndicadoresFicTecDTO>(); 
	private List<GraficoPizzaDTO> graficoPerdasPizza = new ArrayList<GraficoPizzaDTO>();
	private PtTemposDTO temposDiagrama = new PtTemposDTO();
	
	
	public BiFiltroDTO getFiltroBI() {
		return filtroBI;
	}
	public void setFiltroBI(BiFiltroDTO filtroBI) {
		this.filtroBI = filtroBI;
	}
	public BiIndicadoresDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(BiIndicadoresDTO indicadores) {
		this.indicadores = indicadores;
	}
	public List<MetaIndicadorDTO> getMetaIndicadores() {
		return metaIndicadores;
	}
	public void setMetaIndicadores(List<MetaIndicadorDTO> metaIndicadores) {
		this.metaIndicadores = metaIndicadores;
	}
	public List<BiIndicadoresTurnoDTO> getIndicadoresTurno() {
		return indicadoresTurno;
	}
	public void setIndicadoresTurno(List<BiIndicadoresTurnoDTO> indicadoresTurno) {
		this.indicadoresTurno = indicadoresTurno;
	}
	public List<BiIndicadoresAnoMesDTO> getIndicadoresAnoMes() {
		return indicadoresAnoMes;
	}
	public void setIndicadoresAnoMes(List<BiIndicadoresAnoMesDTO> indicadoresAnoMes) {
		this.indicadoresAnoMes = indicadoresAnoMes;
	}
	public List<BiIndicadoresDtRefDTO> getIndicadoresDtRef() {
		return indicadoresDtRef;
	}
	public void setIndicadoresDtRef(List<BiIndicadoresDtRefDTO> indicadoresDtRef) {
		this.indicadoresDtRef = indicadoresDtRef;
	}
	public List<BiIndicadoresPTDTO> getIndicadoresPt() {
		return indicadoresPt;
	}
	public void setIndicadoresPt(List<BiIndicadoresPTDTO> indicadoresPt) {
		this.indicadoresPt = indicadoresPt;
	}
	public PtTemposDTO getTemposDiagrama() {
		return temposDiagrama;
	}
	public void setTemposDiagrama(PtTemposDTO temposDiagrama) {
		this.temposDiagrama = temposDiagrama;
	}
	public List<MetaIndicadorDTO> getMetaIndicadoresGraficoPontos() {
		return metaIndicadoresGraficoPontos;
	}
	public void setMetaIndicadoresGraficoPontos(List<MetaIndicadorDTO> metaIndicadoresGraficoPontos) {
		this.metaIndicadoresGraficoPontos = metaIndicadoresGraficoPontos;
	}
	public List<GraficoPizzaDTO> getGraficoPerdasPizza() {
		return graficoPerdasPizza;
	}
	public void setGraficoPerdasPizza(List<GraficoPizzaDTO> graficoPerdasPizza) {
		this.graficoPerdasPizza = graficoPerdasPizza;
	}
	public List<BiIndicadoresFicTecDTO> getIndicadoresFichaTec() {
		return indicadoresFichaTec;
	}
	public void setIndicadoresFichaTec(List<BiIndicadoresFicTecDTO> indicadoresFichaTec) {
		this.indicadoresFichaTec = indicadoresFichaTec;
	}
}
