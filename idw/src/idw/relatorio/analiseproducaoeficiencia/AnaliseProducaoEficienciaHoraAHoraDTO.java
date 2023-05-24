package idw.relatorio.analiseproducaoeficiencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public class AnaliseProducaoEficienciaHoraAHoraDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigoProduto;
	private String descricaoProduto;
	private Double gPesoLiquidoProduto;
	private List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> itensProducaoEficienciaHoraAHora = new ArrayList<>();
	private Double totalProducaoPrevista = 0d;
	private Double totalProducaoLiquida = 0d;
	private Float totalIndiceMAtivas = 0f;
	private Double totalTempoAtivo = 0d;
	private Float totalIndiceParadas = 0f;
	private Double totalProducaoBruta = 0d;
	private Double totalProducaoRefugada = 0d;
	private Double totalTempoParadaCP = 0d;
	private Float totalIndiceRefugo = 0f;
	private Float totalIndiceEficienciaRealizacao = 0f;
	private String totalTempoAtivoFormatado;
	private String totalTempoParadaCPFormatado;
	private List<OperadorLogDTO> listaOperadoresDTO = new ArrayList<>();

	@Transient
	private Double totalCavidadesAtivas;

	@Transient
	private Double totalCavidadesTotais;

	public List<OperadorLogDTO> getListaOperadoresDTO() {
		return listaOperadoresDTO;
	}

	public void setListaOperadoresDTO(List<OperadorLogDTO> listaOperadoresDTO) {
		this.listaOperadoresDTO = listaOperadoresDTO;
	}

	public AnaliseProducaoEficienciaHoraAHoraDTO() {
		super();
	}

	public Double getTotalCavidadesAtivas() {
		return totalCavidadesAtivas;
	}

	public void setTotalCavidadesAtivas(Double totalCavidadesAtivas) {
		this.totalCavidadesAtivas = totalCavidadesAtivas;
	}

	public Double getTotalCavidadesTotais() {
		return totalCavidadesTotais;
	}

	public void setTotalCavidadesTotais(Double totalCavidadesTotais) {
		this.totalCavidadesTotais = totalCavidadesTotais;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> getItensProducaoEficienciaHoraAHora() {
		return itensProducaoEficienciaHoraAHora;
	}

	public void setItensProducaoEficienciaHoraAHora(List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> itens) {
		this.itensProducaoEficienciaHoraAHora = itens;
	}

	public Double getTotalProducaoPrevista() {
		return totalProducaoPrevista;
	}

	public void setTotalProducaoPrevista(Double totalProducaoPrevista) {
		this.totalProducaoPrevista = totalProducaoPrevista;
	}

	public Double getTotalProducaoLiquida() {
		return totalProducaoLiquida;
	}

	public void setTotalProducaoLiquida(Double totalProducaoLiquida) {
		this.totalProducaoLiquida = totalProducaoLiquida;
	}

	public Float getTotalIndiceMAtivas() {
		return totalIndiceMAtivas;
	}

	public void setTotalIndiceMAtivas(Float totalIndiceMAtivas) {
		this.totalIndiceMAtivas = totalIndiceMAtivas;
	}

	public Double getTotalTempoAtivo() {
		return totalTempoAtivo;
	}

	public void setTotalTempoAtivo(Double totalTempoAtivo) {
		this.totalTempoAtivo = totalTempoAtivo;
	}

	public Float getTotalIndiceParadas() {
		return totalIndiceParadas;
	}

	public void setTotalIndiceParadas(Float totalIndiceParadas) {
		this.totalIndiceParadas = totalIndiceParadas;
	}

	public Double getTotalProducaoBruta() {
		return totalProducaoBruta;
	}

	public void setTotalProducaoBruta(Double totalProducaoBruta) {
		this.totalProducaoBruta = totalProducaoBruta;
	}

	public Double getTotalProducaoRefugada() {
		return totalProducaoRefugada;
	}

	public void setTotalProducaoRefugada(Double totalProducaoRefugada) {
		this.totalProducaoRefugada = totalProducaoRefugada;
	}

	public Double getTotalTempoParadaCP() {
		return totalTempoParadaCP;
	}

	public void setTotalTempoParadaCP(Double totalTempoParadaCP) {
		this.totalTempoParadaCP = totalTempoParadaCP;
	}

	public Float getTotalIndiceRefugo() {
		return totalIndiceRefugo;
	}

	public void setTotalIndiceRefugo(Float totalIndiceRefugo) {
		this.totalIndiceRefugo = totalIndiceRefugo;
	}

	public Float getTotalIndiceEficienciaRealizacao() {
		return totalIndiceEficienciaRealizacao;
	}

	public void setTotalIndiceEficienciaRealizacao(Float totalIndiceEficienciaRealizacao) {
		this.totalIndiceEficienciaRealizacao = totalIndiceEficienciaRealizacao;
	}

	public String getTotalTempoAtivoFormatado() {
		return totalTempoAtivoFormatado;
	}

	public void setTotalTempoAtivoFormatado(String totalTempoAtivoFormatado) {
		this.totalTempoAtivoFormatado = totalTempoAtivoFormatado;
	}

	public String getTotalTempoParadaCPFormatado() {
		return totalTempoParadaCPFormatado;
	}

	public void setTotalTempoParadaCPFormatado(String totalTempoParadaCPFormatado) {
		this.totalTempoParadaCPFormatado = totalTempoParadaCPFormatado;
	}

	public Double getgPesoLiquidoProduto() {
		return gPesoLiquidoProduto;
	}

	public void setgPesoLiquidoProduto(Double gPesoLiquidoProduto) {
		this.gPesoLiquidoProduto = gPesoLiquidoProduto;
	}

}
