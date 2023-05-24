package idw.webservices.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import idw.model.pojos.DwConsolciplog;
import idw.model.rn.DataHoraRN;
import ms.util.ConversaoTipos;

public class DadosRelEficienciaSetupDTO {
	
	private String maquina;
	private String molde;
	private String moldeSaida;
	private String inicioSaida;
	private String finalSaida;
	private String tempoSaida;
	private String moldeEntrada;
	private String inicioEntrada;
	private String finalEntrada;
	private String tempoEntrada;
	private String tecnico;
	
	private String inicioProcesso;
	private String finalProcesso;
	private String tempoProcesso; 
	private String tecnicoAbertura;
	private String tecnicoEncerramento;
	private String producaoBruta;
	private String producaoRefugada;
	private String producaoBoa;
	private String tempoParadas;
	private String tempoPadrao; 
	private String tempoTotal;
	private String eficiencia;
	
	private Date dataInicio;
	private Date dataFim;
	
	private Double segTempoInicioProcesso;
	private Double segTempoParada;
	
	private List<RelatorioParadasInicioProcessoDTO> listaParadas;
	
	@Transient
	private DwConsolciplog ciplog;
	
	private List<DadosRelEficienciaSetupDTO> itens;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	public String getMoldeSaida() {
		return moldeSaida;
	}
	public void setMoldeSaida(String moldeSaida) {
		this.moldeSaida = moldeSaida;
	}
	public String getInicioSaida() {
		return inicioSaida;
	}
	public void setInicioSaida(String inicioSaida) {
		this.inicioSaida = inicioSaida;
	}
	public String getFinalSaida() {
		return finalSaida;
	}
	public void setFinalSaida(String finalSaida) {
		this.finalSaida = finalSaida;
	}
	public String getTempoSaida() {
		return tempoSaida;
	}
	public void setTempoSaida(String tempoFinal) {
		this.tempoSaida = tempoFinal;
	}
	public String getMoldeEntrada() {
		return moldeEntrada;
	}
	public void setMoldeEntrada(String moldeEntrada) {
		this.moldeEntrada = moldeEntrada;
	}
	public String getInicioEntrada() {
		return inicioEntrada;
	}
	public void setInicioEntrada(String inicioEntrada) {
		this.inicioEntrada = inicioEntrada;
	}
	public String getFinalEntrada() {
		return finalEntrada;
	}
	public void setFinalEntrada(String finalEntrada) {
		this.finalEntrada = finalEntrada;
	}
	public String getTempoEntrada() {
		return tempoEntrada;
	}
	public void setTempoEntrada(String tempoEntrada) {
		this.tempoEntrada = tempoEntrada;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public String getInicioProcesso() {
		return inicioProcesso;
	}
	public void setInicioProcesso(String inicioProcesso) {
		this.inicioProcesso = inicioProcesso;
	}
	public String getFinalProcesso() {
		return finalProcesso;
	}
	public void setFinalProcesso(String finalProcesso) {
		this.finalProcesso = finalProcesso;
	}
	public String getTempoProcesso() {
		return tempoProcesso;
	}
	public void setTempoProcesso(String tempoProcesso) {
		this.tempoProcesso = tempoProcesso;
	}
	public String getTecnicoAbertura() {
		return tecnicoAbertura;
	}
	public void setTecnicoAbertura(String tecnicoAbertura) {
		this.tecnicoAbertura = tecnicoAbertura;
	}
	public String getTecnicoEncerramento() {
		return tecnicoEncerramento;
	}
	public void setTecnicoEncerramento(String tecnicoEncerramento) {
		this.tecnicoEncerramento = tecnicoEncerramento;
	}
	public String getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(String producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public String getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(String producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public String getProducaoBoa() {
		return producaoBoa;
	}
	public void setProducaoBoa(String producaoBoa) {
		this.producaoBoa = producaoBoa;
	}
	public String getTempoParadas() {
		return tempoParadas;
	}
	public void setTempoParadas(String tempoParadas) {
		this.tempoParadas = tempoParadas;
	}
	public String getTempoPadrao() {
		return tempoPadrao;
	}
	public void setTempoPadrao(String tempoPadrao) {
		this.tempoPadrao = tempoPadrao;
	}
	public String getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	public String getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(String eficiencia) {
		this.eficiencia = eficiencia;
	}
	public List<DadosRelEficienciaSetupDTO> getItens() {
		return itens;
	}
	public void setItens(List<DadosRelEficienciaSetupDTO> itens) {
		this.itens = itens;
	}
	public DwConsolciplog obtemCiplog() {
		return ciplog;
	}
	public void mudaCiplog(DwConsolciplog ciplog) {
		this.ciplog = ciplog;
	}
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

	public Double getSegTempoInicioProcesso() {
		return segTempoInicioProcesso;
	}
	public void setSegTempoInicioProcesso(Double segTempoInicioProcesso) {
		this.segTempoInicioProcesso = segTempoInicioProcesso;
	}
	public Double getSegTempoParada() {
		return segTempoParada;
	}
	public void setSegTempoParada(Double segTempoParada) {
		this.segTempoParada = segTempoParada;
	}
	public List<RelatorioParadasInicioProcessoDTO> getListaParadas() {
		return listaParadas;
	}
	public void setListaParadas(List<RelatorioParadasInicioProcessoDTO> listaParadas) {
		this.listaParadas = listaParadas;
	}
	
	public void add(DadosRelEficienciaSetupDTO dto) {
		setDataFim(dto.dataFim);
		setFinalProcesso(dto.getFinalProcesso());
		
		Double tempoTotalEmMinutos = ConversaoTipos.converteParaDouble(this.tempoTotal);
		Integer prodBruta = ConversaoTipos.converteParaInt(producaoBruta);
		Integer prodRefugada = ConversaoTipos.converteParaInt(producaoRefugada);
		Integer prodBoa = ConversaoTipos.converteParaInt(producaoBoa);

		Double tempoTotalEmMinutosAux = ConversaoTipos.converteParaDouble(dto.tempoTotal);
		Integer prodBrutaAux = ConversaoTipos.converteParaInt(dto.producaoBruta);
		Integer prodRefugadaAux = ConversaoTipos.converteParaInt(dto.producaoRefugada);
		Integer prodBoaAux = ConversaoTipos.converteParaInt(dto.producaoBoa);

		tempoTotalEmMinutos += tempoTotalEmMinutosAux;
		prodBruta += prodBrutaAux;
		prodRefugada += prodRefugadaAux;
		prodBoa += prodBoaAux;
		
		setTempoTotal(ConversaoTipos.converteDecimalParaString(tempoTotalEmMinutos, 2));
		
		setProducaoBruta(String.valueOf(prodBruta));
		setProducaoRefugada(String.valueOf(prodRefugada));
		setProducaoBoa(String.valueOf(prodBoa));

		this.segTempoParada += dto.segTempoParada;
		this.segTempoInicioProcesso += dto.segTempoInicioProcesso;

		setTempoParadas(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos(segTempoParada.intValue()), 2));
	}

}
