package idw.webservices.rest.v2.injet.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtIconeDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;

@XmlRootElement(name="ptMonitorizacaoV2")
public class PtMonitorizacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdPt;
	private String dsPt;
	private String dsView;
	private int ordem;
	private int tipoPosto;
	
	private String data;
	private String turno;
	private long idTurno;
	
	private String cdProduto;
	private String dsProduto;
	
//	private String ferramenta;
	
//	private String filtroCdCp;
//	private String filtroQuantidadeRefugada;
	
//	private String opSelecionada;
	
//	private String cdFolha;
	
	private String metaHora;
	private String cavidadesAtivasView;
	
	private PtIconeDTO icone;
	private MetaIndicadorDTO metaIndicador;
	
	private PtIndicadorDTO indicadores;


	/*
	private List<MetaIndicadorDTO> metaIndicadores;
	private List<TurnoIndicadorDTO> turnoIndicadores;
	private List<GraficoIndicadorDTO> graficoIndicadores;
	private PtIndicadorDTO indicadores;
	private PtTemposDTO tempos;
	private PtProducaoDTO producao;
	private PtParadaResumoDTO paradaResumo;
	private PtCicloDTO ciclo;
	private PtMateriaPrimaResumo materiaPrimaResumo;
	private List<OperadorDTO> operadores;
	private List<AlertaDTO> alertas;
	private List<PerdaProducaoDTO> perdasProducao;
	private List<GraficoPizzaDTO> graficoPerdas;
	private List<OpDTO> ops;
	private List<MpBrutaPostoDTO> graficoInsercoesMp;
	private List<PtProdutoDTO> produtos;
	private List<PtEnergiaDTO> energiaConsumidaProducao;
	*/
	
	private String cdTipoPosto; 
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public String getDsView() {
		return dsView;
	}
	public void setDsView(String dsView) {
		this.dsView = dsView;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public int getTipoPosto() {
		return tipoPosto;
	}
	public void setTipoPosto(int tipoPosto) {
		this.tipoPosto = tipoPosto;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	
	
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	
	/*
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getFiltroCdCp() {
		return filtroCdCp;
	}
	public void setFiltroCdCp(String filtroCdCp) {
		this.filtroCdCp = filtroCdCp;
	}
	public String getFiltroQuantidadeRefugada() {
		return filtroQuantidadeRefugada;
	}
	public void setFiltroQuantidadeRefugada(String filtroQuantidadeRefugada) {
		this.filtroQuantidadeRefugada = filtroQuantidadeRefugada;
	}
	*/
	
	/*
	public String getOpSelecionada() {
		return opSelecionada;
	}
	public void setOpSelecionada(String opSelecionada) {
		this.opSelecionada = opSelecionada;
	}
	*/
	
	
	public PtIconeDTO getIcone() {
		return icone;
	}
	public void setIcone(PtIconeDTO icone) {
		this.icone = icone;
	}
	
	/*
	public List<MetaIndicadorDTO> getMetaIndicadores() {
		return metaIndicadores;
	}
	public void setMetaIndicadores(List<MetaIndicadorDTO> metaIndicadores) {
		this.metaIndicadores = metaIndicadores;
	}
	public List<TurnoIndicadorDTO> getTurnoIndicadores() {
		return turnoIndicadores;
	}
	public void setTurnoIndicadores(List<TurnoIndicadorDTO> turnoIndicadores) {
		this.turnoIndicadores = turnoIndicadores;
	}
	public List<GraficoIndicadorDTO> getGraficoIndicadores() {
		return graficoIndicadores;
	}
	public void setGraficoIndicadores(List<GraficoIndicadorDTO> graficoIndicadores) {
		this.graficoIndicadores = graficoIndicadores;
	}
	public PtIndicadorDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(PtIndicadorDTO indicadores) {
		this.indicadores = indicadores;
	}
	*/
	public PtIndicadorDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(PtIndicadorDTO indicadores) {
		this.indicadores = indicadores;
	}
	
	
	/*
	public PtTemposDTO getTempos() {
		return tempos;
	}
	public void setTempos(PtTemposDTO tempos) {
		this.tempos = tempos;
	}
	public PtProducaoDTO getProducao() {
		return producao;
	}
	public void setProducao(PtProducaoDTO producao) {
		this.producao = producao;
	}
	public PtParadaResumoDTO getParadaResumo() {
		return paradaResumo;
	}
	public void setParadaResumo(PtParadaResumoDTO paradaResumo) {
		this.paradaResumo = paradaResumo;
	}
	public PtCicloDTO getCiclo() {
		return ciclo;
	}
	public void setCiclo(PtCicloDTO ciclo) {
		this.ciclo = ciclo;
	}
	public PtMateriaPrimaResumo getMateriaPrimaResumo() {
		return materiaPrimaResumo;
	}
	public void setMateriaPrimaResumo(PtMateriaPrimaResumo materiaPrimaResumo) {
		this.materiaPrimaResumo = materiaPrimaResumo;
	}
	public List<OperadorDTO> getOperadores() {
		return operadores;
	}
	public void setOperadores(List<OperadorDTO> operadores) {
		this.operadores = operadores;
	}
	public List<AlertaDTO> getAlertas() {
		return alertas;
	}
	public void setAlertas(List<AlertaDTO> alertas) {
		this.alertas = alertas;
	}
	public List<PerdaProducaoDTO> getPerdasProducao() {
		return perdasProducao;
	}
	public void setPerdasProducao(List<PerdaProducaoDTO> perdasProducao) {
		this.perdasProducao = perdasProducao;
	}
	public List<GraficoPizzaDTO> getGraficoPerdas() {
		return graficoPerdas;
	}
	public void setGraficoPerdas(List<GraficoPizzaDTO> graficoPerdas) {
		this.graficoPerdas = graficoPerdas;
	}
	public List<OpDTO> getOps() {
		return ops;
	}
	public void setOps(List<OpDTO> ops) {
		this.ops = ops;
	}
	public List<MpBrutaPostoDTO> getGraficoInsercoesMp() {
		return graficoInsercoesMp;
	}
	public void setGraficoInsercoesMp(List<MpBrutaPostoDTO> graficoInsercoesMp) {
		this.graficoInsercoesMp = graficoInsercoesMp;
	}
	public List<PtProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<PtProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	public List<PtEnergiaDTO> getEnergiaConsumidaProducao() {
		return energiaConsumidaProducao;
	}
	public void setEnergiaConsumidaProducao(
			List<PtEnergiaDTO> energiaConsumidaProducao) {
		this.energiaConsumidaProducao = energiaConsumidaProducao;
	}
	
	*/
	
	public String getCavidadesAtivasView() {
		return cavidadesAtivasView;
	}
	public void setCavidadesAtivasView(String cavidadesAtivasView) {
		this.cavidadesAtivasView = cavidadesAtivasView;
	}
	public String getMetaHora() {
		return metaHora;
	}
	public void setMetaHora(String metaHora) {
		this.metaHora = metaHora;
	}
	
	/*
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	*/
	
	
	public String getCdTipoPosto() {
		return cdTipoPosto;
	}
	public void setCdTipoPosto(String cdTipoPosto) {
		this.cdTipoPosto = cdTipoPosto;
	}
	

}