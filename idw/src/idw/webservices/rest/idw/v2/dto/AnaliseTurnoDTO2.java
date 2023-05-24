package idw.webservices.rest.idw.v2.dto;

import java.util.ArrayList;
import java.util.List;

import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;

public class AnaliseTurnoDTO2 {
	private AnaliseTurnoProducaoDTO producao;
	private AnaliseTurnoParadasDTO paradas;
	private AnaliseTurnoRefugosDTO refugos;
	private AnaliseTurnoCiclosDTO ciclos;
	private AnaliseTurnoQtdAlocDTO aloc;
	private List<AnaliseTurnoProducaoPTDTO> detalhesPts;
	private List<AnaliseTurnoIndicadoresPTDTO> graficosPts;
	private List<MetaIndicadorDTO> metaIndicadores = new ArrayList<MetaIndicadorDTO>();

	public AnaliseTurnoProducaoDTO getProducao() {
		return producao;
	}

	public void setProducao(AnaliseTurnoProducaoDTO producao) {
		this.producao = producao;
	}

	public AnaliseTurnoParadasDTO getParadas() {
		return paradas;
	}

	public void setParadas(AnaliseTurnoParadasDTO paradas) {
		this.paradas = paradas;
	}

	public AnaliseTurnoRefugosDTO getRefugos() {
		return refugos;
	}

	public void setRefugos(AnaliseTurnoRefugosDTO refugos) {
		this.refugos = refugos;
	}

	public AnaliseTurnoCiclosDTO getCiclos() {
		return ciclos;
	}

	public void setCiclos(AnaliseTurnoCiclosDTO ciclos) {
		this.ciclos = ciclos;
	}

	public AnaliseTurnoQtdAlocDTO getAloc() {
		return aloc;
	}

	public void setAloc(AnaliseTurnoQtdAlocDTO aloc) {
		this.aloc = aloc;
	}

	public List<AnaliseTurnoProducaoPTDTO> getDetalhesPts() {
		return detalhesPts;
	}

	public void setDetalhesPts(List<AnaliseTurnoProducaoPTDTO> detalhesPts) {
		this.detalhesPts = detalhesPts;
	}

	public List<AnaliseTurnoIndicadoresPTDTO> getGraficosPts() {
		return graficosPts;
	}

	public void setGraficosPts(List<AnaliseTurnoIndicadoresPTDTO> graficosPts) {
		this.graficosPts = graficosPts;
	}

	public List<MetaIndicadorDTO> getMetaIndicadores() {
		return metaIndicadores;
	}

	public void setMetaIndicadores(List<MetaIndicadorDTO> metaIndicadores) {
		this.metaIndicadores = metaIndicadores;
	}
}
