	package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.detalhemonitorizacao.EnergiaConsumidaProducaoDTO;
import idw.model.rn.monitorizacao.detalhes.dto.HistoricoSmedDTO;

public class DetalheMonitorizacaoPTInjetDTO {
	
	private String periodo;
	private String maquina;
	private String produto;
	private String produtoDs;
	private String ordemproducao;
	private String dtinicioOP;
	
	private String molde;
	private String dtReferencia;
	private String dtInicioPlanejado;
	private String dtFimPlanejado;
	private OmPt omPt;
	private DwTurno dwTurno;
	
	private DwFolha dwFolha;
	private String identificacaomolde;
	private String cav_ativas;
	private Double pcsPorCicloAtivas;
	private Double pcsPorCicloTotais;
	
	private long idrt; 
	private Double tempoAtivo;
	private Double indiceParadas;
	private Double indiceParadasSemPeso;
	private Double perdasParadas;
	private Double perdasParadasSemPeso;
	private Double perdasCiclos;
	private Double pci;
	private Double qtdPrevista;
	private Double qtdProduzida;
	private Double qtdPecasBoas;
	private Double qtdRefugadas;
	private Double indiceCavAtivas;
	private Double indicePerdas;
	private Double indiceRefugos;
	private Double efiRealizacao;
	private Double efiCiclos;
	private Double eficiclosPond;
	private Double totalPerdas;
	private Double tempoParadas;
	private Double tempoNaoDisponivel;
	private Double tempoCiclosImprodutivos;
	private Double tempoRefugos;
	private Double tempoRitmo;
	private Double tempoCavIsoladas;
	private Double tempoTotais;
	private Double tempoDisponiveis;
	private Double tempoTrabalhadas;
	private Double tempoCiclosProdutivos;
	private Double tempoBoas;
	private Double tempoProdutivas;
	private Double produtividadeOEE;
	private Double produtividadeOEECapital;
	private Double utilizacao;
	private Double eficiencia;
	
	private Boolean isForaMetaIndiceRefugos;
	private Boolean isForaMetaIefiRealizacao;
	private Boolean isForaMetaIefiCiclos;
	private Boolean isForaMetaEficienciaUltCic;
	private Boolean isForaMetaIndiceParadas;
	
	private Double ciclosEficienciaCic;
	private Double ciclosCicPadrao;
	private Double ciclosCicMedio;
	private Double ciclosUltimoCic;
	private Double ciclosEficienciaUltCic;
	private Double qtdeCiclosExecutar;
	private Double projPCIHoras;
	
	private Double paradasIndiceParadas;
	private Double paradasTempoParadas;
	private String paradaAtualUltParada;
	private String tempoParadaAtualUltParada;
	private String paradaDtInicio;
	private String paradaHrIncio;
	private String paradaAreaResponsavel;
	private Double paradaMTBF;
	private Double paradaMTTR;
	private Double metaHora;
	private Integer tempoCalendario;
	private Integer tempoSemColeta;
	private Integer tempoDuplicadoColeta;
	
	private ProdutosDTO produtosandroidDTO;
	private AlertasDTO alertasandroidDTO;
	private ListaOperadoresDTO operadoresandroidDTO;
	private ListaPerdasDTO perdasandroidDTO;
	private List<OperadorDTO> listaOperadores;
	private List<AlertaDTO> listaAlertas;
	private List<ProdutoDTO> listaProdutos;
	private List<PerdasDTO> listaPerdas;
	private List<GraficoCicloDTO> listaCiclos;
	private List<GraficoTempoDTO> listaGraficoTempoDTO;
	private List<DetalheMonitorizacaoPTInjetDTO> listaTurnos;
	private DwConsolidDTOs listaDwConsolidTurno;
	private List<DwConsolid> listaDwConsolId;
	private List<PpCp> opsNoTurno;
	private List<HistoricoSmedDTO> historicoSmed;
	private List<EnergiaConsumidaProducaoDTO> energiaConsumidaProducao;
    private List<CIPDTO> listacips;
    
	private Double indiceProducao;
	private String dtFimPrevisto;
	private String gargalo;
	private String dsPt;
	private Date dtRefMin;
	private Date DtRefMax;
	private List<GraficoCicloDTO> listaIndicadoresMaquinas; 
	private List<ProdutoResumoBIDTO> listaIndicadoresProdutoConjunto;
	private List<PtRapResumoDTO> listaIndicadoresPt;
	private List<PtRapResumoDTO> listaIndicadoresPtRap;
	
	private List<MpBrutaPorMaquinaDTO> listaMpBrutaPorMaquina;
	private BigDecimal consumoMPProducaoBruta;
	private BigDecimal consumoMPProducaoLiquira;
	private BigDecimal consumoMPProducaoRefugada;
	
	private BigDecimal custoMPTotalDeInsercao;
	private BigDecimal custoMPTotalDePerdas;
	private BigDecimal custoMPTotalDeInsercaoLiquida;
	
	private BigDecimal producaoPrevistaKg;
	private BigDecimal producaoLiquidaKg;
	private BigDecimal producaoBrutaKg;
	private BigDecimal producaoRefugadaKg;
	private BigDecimal perdaParadaKg;
	private BigDecimal pciKg;
	private BigDecimal perdaCicloKg;
	

	private BigDecimal producaoPrevistaTn;
	private BigDecimal producaoLiquidaTn;
	private BigDecimal producaoBrutaTn;
	private BigDecimal producaoRefugadaTn;
	private BigDecimal perdaParadaTn;
	private BigDecimal pciTn;
	private BigDecimal perdaCicloTn;
	
	private Double indiceRefugoGr;
	private Double efiRealizacaoGr;
	private Double indicePerdasGr;
	
	private Double indiceFPY;
	
	private BigDecimal qtTestes;
	private BigDecimal qtDefeitos;
	private Double indiceDefeito;
	
	public Double getMetaHora() {
		return metaHora;
	}
	public void setMetaHora(Double metaHora) {
		this.metaHora = metaHora;
	}	
	public AlertasDTO getAlertasandroidDTO() {
		return alertasandroidDTO;
	}
	public void setAlertasandroidDTO(AlertasDTO alertasandroidDTO) {
		this.alertasandroidDTO = alertasandroidDTO;
	}
	public ListaOperadoresDTO getOperadoresandroidDTO() {
		return operadoresandroidDTO;
	}
	public void setOperadoresandroidDTO(ListaOperadoresDTO operadoresandroidDTO) {
		this.operadoresandroidDTO = operadoresandroidDTO;
	}
	public ListaPerdasDTO getPerdasandroidDTO() {
		return perdasandroidDTO;
	}
	public void setPerdasandroidDTO(ListaPerdasDTO perdasandroidDTO) {
		this.perdasandroidDTO = perdasandroidDTO;
	}
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public String getDtInicioPlanejado() {
		return dtInicioPlanejado;
	}
	public void setDtInicioPlanejado(String dtInicioPlanejado) {
		this.dtInicioPlanejado = dtInicioPlanejado;
	}
	public String getDtFimPlanejado() {
		return dtFimPlanejado;
	}
	public void setDtFimPlanejado(String dtFimPlanejado) {
		this.dtFimPlanejado = dtFimPlanejado;
	}
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	
	public List<GraficoTempoDTO> getListaGraficoTempoDTO() {
		return listaGraficoTempoDTO;
	}
	public void setListaGraficoTempoDTO(List<GraficoTempoDTO> listaGraficoTempoDTO) {
		this.listaGraficoTempoDTO = listaGraficoTempoDTO;
	}
	public List<GraficoCicloDTO> getListaCiclos() {
		return listaCiclos;
	}
	public void setListaCiclos(List<GraficoCicloDTO> listaCiclos) {
		this.listaCiclos = listaCiclos;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getProdutoDs() {
		return produtoDs;
	}
	public void setProdutoDs(String produtoDs) {
		this.produtoDs = produtoDs;
	}
	public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	public Double getTempoAtivo() {
		return tempoAtivo;
	}
	public void setTempoAtivo(Double tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}
	public Double getIndiceParadas() {
		return indiceParadas;
	}
	public void setIndiceParadas(Double indiceParadas) {
		this.indiceParadas = indiceParadas;
	}
	public Double getPerdasParadas() {
		return perdasParadas;
	}
	public void setPerdasParadas(Double perdasParadas) {
		this.perdasParadas = perdasParadas;
	}
	public Double getPerdasCiclos() {
		return perdasCiclos;
	}
	public void setPerdasCiclos(Double perdasCiclos) {
		this.perdasCiclos = perdasCiclos;
	}
	public Double getPci() {
		return pci;
	}
	public void setPci(Double pci) {
		this.pci = pci;
	}
	public Double getQtdPrevista() {
		return qtdPrevista;
	}
	public void setQtdPrevista(Double qtdPrevista) {
		this.qtdPrevista = qtdPrevista;
	}
	public Double getQtdProduzida() {
		return qtdProduzida;
	}
	public void setQtdProduzida(Double qtdProduzida) {
		this.qtdProduzida = qtdProduzida;
	}
	public Double getQtdPecasBoas() {
		return qtdPecasBoas;
	}
	public void setQtdPecasBoas(Double qtdPecasBoas) {
		this.qtdPecasBoas = qtdPecasBoas;
	}
	public Double getQtdRefugadas() {
		return qtdRefugadas;
	}
	public void setQtdRefugadas(Double qtdRefugadas) {
		this.qtdRefugadas = qtdRefugadas;
	}
	public Double getIndiceCavAtivas() {
		return indiceCavAtivas;
	}
	public void setIndiceCavAtivas(Double indiceCavAtivas) {
		this.indiceCavAtivas = indiceCavAtivas;
	}
	public Double getIndicePerdas() {
		return indicePerdas;
	}
	public void setIndicePerdas(Double indicePerdas) {
		this.indicePerdas = indicePerdas;
	}
	public Double getIndiceRefugos() {
		return indiceRefugos;
	}
	public void setIndiceRefugos(Double indiceRefugos) {
		this.indiceRefugos = indiceRefugos;
	}
	public Double getEfiRealizacao() {
		return efiRealizacao;
	}
	public void setEfiRealizacao(Double efiRealizacao) {
		this.efiRealizacao = efiRealizacao;
	}
	public Double getEfiCiclos() {
		return efiCiclos;
	}
	public void setEfiCiclos(Double efiCiclos) {
		this.efiCiclos = efiCiclos;
	}
	public Double getEficiclosPond() {
		return eficiclosPond;
	}
	public void setEficiclosPond(Double eficiclosPond) {
		this.eficiclosPond = eficiclosPond;
	}
	public Double getTotalPerdas() {
		return totalPerdas;
	}
	public void setTotalPerdas(Double totalPerdas) {
		this.totalPerdas = totalPerdas;
	}
	public Double getTempoParadas() {
		return tempoParadas;
	}
	public void setTempoParadas(Double tempoParadas) {
		this.tempoParadas = tempoParadas;
	}
	public Double getTempoNaoDisponivel() {
		return tempoNaoDisponivel;
	}
	public void setTempoNaoDisponivel(Double tempoNaoDisponivel) {
		this.tempoNaoDisponivel = tempoNaoDisponivel;
	}
	public Double getTempoCiclosImprodutivos() {
		return tempoCiclosImprodutivos;
	}
	public void setTempoCiclosImprodutivos(Double tempoCiclosImprodutivos) {
		this.tempoCiclosImprodutivos = tempoCiclosImprodutivos;
	}
	public Double getTempoRefugos() {
		return tempoRefugos;
	}
	public void setTempoRefugos(Double tempoRefugos) {
		this.tempoRefugos = tempoRefugos;
	}
	public Double getTempoRitmo() {
		return tempoRitmo;
	}
	public void setTempoRitmo(Double tempoRitmo) {
		this.tempoRitmo = tempoRitmo;
	}
	public Double getTempoCavIsoladas() {
		return tempoCavIsoladas;
	}
	public void setTempoCavIsoladas(Double tempoCavIsoladas) {
		this.tempoCavIsoladas = tempoCavIsoladas;
	}
	public Double getTempoTotais() {
		return tempoTotais;
	}
	public void setTempoTotais(Double tempoTotais) {
		this.tempoTotais = tempoTotais;
	}
	public Double getTempoDisponiveis() {
		return tempoDisponiveis;
	}
	public void setTempoDisponiveis(Double tempoDisponiveis) {
		this.tempoDisponiveis = tempoDisponiveis;
	}
	public Double getTempoTrabalhadas() {
		return tempoTrabalhadas;
	}
	public void setTempoTrabalhadas(Double tempoTrabalhadas) {
		this.tempoTrabalhadas = tempoTrabalhadas;
	}
	public Double getTempoCiclosProdutivos() {
		return tempoCiclosProdutivos;
	}
	public void setTempoCiclosProdutivos(Double tempoCiclosProdutivos) {
		this.tempoCiclosProdutivos = tempoCiclosProdutivos;
	}
	public Double getTempoBoas() {
		return tempoBoas;
	}
	public void setTempoBoas(Double tempoBoas) {
		this.tempoBoas = tempoBoas;
	}
	public Double getTempoProdutivas() {
		return tempoProdutivas;
	}
	public void setTempoProdutivas(Double tempoProdutivas) {
		this.tempoProdutivas = tempoProdutivas;
	}
	public Double getProdutividadeOEE() {
		return produtividadeOEE;
	}
	public void setProdutividadeOEE(Double produtividadeOEE) {
		this.produtividadeOEE = produtividadeOEE;
	}
	public Double getProdutividadeOEECapital() {
		return produtividadeOEECapital;
	}
	public void setProdutividadeOEECapital(Double produtividadeOEECapital) {
		this.produtividadeOEECapital = produtividadeOEECapital;
	}
	public Double getUtilizacao() {
		return utilizacao;
	}
	public void setUtilizacao(Double utilizacao) {
		this.utilizacao = utilizacao;
	}
	public Double getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(Double eficiencia) {
		this.eficiencia = eficiencia;
	}
	public Double getCiclosEficienciaCic() {
		return ciclosEficienciaCic;
	}
	public void setCiclosEficienciaCic(Double ciclosEficienciaCic) {
		this.ciclosEficienciaCic = ciclosEficienciaCic;
	}
	public Double getCiclosCicPadrao() {
		return ciclosCicPadrao;
	}
	public void setCiclosCicPadrao(Double ciclosCicPadrao) {
		this.ciclosCicPadrao = ciclosCicPadrao;
	}
	public Double getCiclosCicMedio() {
		return ciclosCicMedio;
	}
	public void setCiclosCicMedio(Double ciclosCicMedio) {
		this.ciclosCicMedio = ciclosCicMedio;
	}
	public Double getCiclosUltimoCic() {
		return ciclosUltimoCic;
	}
	public void setCiclosUltimoCic(Double ciclosUltimoCic) {
		this.ciclosUltimoCic = ciclosUltimoCic;
	}
	public void setCiclosUltimoCic(DwRt dwrt) {
		this.ciclosUltimoCic = dwrt.getSegUltimociclo() != null ? dwrt.getSegUltimociclo().doubleValue() : 0d;
	}
	public Double getCiclosEficienciaUltCic() {
		return ciclosEficienciaUltCic;
	}
	public void setCiclosEficienciaUltCic(Double ciclosEficienciaUltCic) {
		this.ciclosEficienciaUltCic = ciclosEficienciaUltCic;
	}
	public Double getQtdeCiclosExecutar() {
		return qtdeCiclosExecutar;
	}
	public void setQtdeCiclosExecutar(Double qtdeCiclosExecutar) {
		this.qtdeCiclosExecutar = qtdeCiclosExecutar;
	}
	public Double getProjPCIHoras() {
		return projPCIHoras;
	}
	public void setProjPCIHoras(Double projPCIHoras) {
		this.projPCIHoras = projPCIHoras;
	}
	public Double getParadasIndiceParadas() {
		return paradasIndiceParadas;
	}
	public void setParadasIndiceParadas(Double paradasIndiceParadas) {
		this.paradasIndiceParadas = paradasIndiceParadas;
	}
	public Double getParadasTempoParadas() {
		return paradasTempoParadas;
	}
	public void setParadasTempoParadas(Double paradasTempoParadas) {
		this.paradasTempoParadas = paradasTempoParadas;
	}
	public Double getParadaMTBF() {
		return paradaMTBF;
	}
	public void setParadaMTBF(Double paradaMTBF) {
		this.paradaMTBF = paradaMTBF;
	}
	
	public String getParadaAreaResponsavel() {
		return paradaAreaResponsavel;
	}
	public void setParadaAreaResponsavel(String paradaAreaResponsavel) {
		this.paradaAreaResponsavel = paradaAreaResponsavel;
	}
	public String getParadaDtInicio() {
		return paradaDtInicio;
	}
	public void setParadaDtInicio(String paradaDtInicio) {
		this.paradaDtInicio = paradaDtInicio;
	}
	public String getParadaHrIncio() {
		return paradaHrIncio;
	}
	public void setParadaHrIncio(String paradaHrIncio) {
		this.paradaHrIncio = paradaHrIncio;
	}
	public Double getParadaMTTR() {
		return paradaMTTR;
	}
	public void setParadaMTTR(Double paradaMTTR) {
		this.paradaMTTR = paradaMTTR;
	}
	public List<OperadorDTO> getListaOperadores() {
		return listaOperadores;
	}
	public void setListaOperadores(List<OperadorDTO> listaOperadores) {
		this.listaOperadores = listaOperadores;
	}
	public List<AlertaDTO> getListaAlertas() {
		return listaAlertas;
	}
	public void setListaAlertas(List<AlertaDTO> listaAlertas) {
		this.listaAlertas = listaAlertas;
	}
	public List<ProdutoDTO> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<ProdutoDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public List<PerdasDTO> getListaPerdas() {
		return listaPerdas;
	}
	public void setListaPerdas(List<PerdasDTO> listaPerdas) {
		this.listaPerdas = listaPerdas;
	}
	public String getParadaAtualUltParada() {
		return paradaAtualUltParada;
	}
	public void setParadaAtualUltParada(String paradaAtualUltParada) {
		this.paradaAtualUltParada = paradaAtualUltParada;
	}
	public String getTempoParadaAtualUltParada() {
		return tempoParadaAtualUltParada;
	}
	public void setTempoParadaAtualUltParada(String tempoParadaAtualUltParada) {
		this.tempoParadaAtualUltParada = tempoParadaAtualUltParada;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}
	public DwFolha getDwFolha() {
		return dwFolha;
	}
	
	public String getOrdemproducao() {
		return ordemproducao;
	}
	public void setOrdemproducao(String ordemproducao) {
		this.ordemproducao = ordemproducao;
	}
	public String getDtinicioOP() {
		return dtinicioOP;
	}
	public void setDtinicioOP(String dtinicioOP) {
		this.dtinicioOP = dtinicioOP;
	}
	public String getIdentificacaomolde() {
		return identificacaomolde;
	}
	public void setIdentificacaomolde(String identificacaomolde) {
		this.identificacaomolde = identificacaomolde;
	}
	public String getCav_ativas() {
		return cav_ativas;
	}
	public void setCav_ativas(String cav_ativas) {
		this.cav_ativas = cav_ativas;
	}
	public void setProdutosandroidDTO(ProdutosDTO produtosandroidDTO) {
		this.produtosandroidDTO = produtosandroidDTO;
	}
	public ProdutosDTO getProdutosandroidDTO() {
		return produtosandroidDTO;
	}
	public long getIdrt() {
		return idrt;
	}
	public void setIdrt(long idrt) {
		this.idrt = idrt;
	}
	public List<DetalheMonitorizacaoPTInjetDTO> getListaTurnos() {
		return listaTurnos;
	}
	public void setListaTurnos(List<DetalheMonitorizacaoPTInjetDTO> listaTurnos) {
		this.listaTurnos = listaTurnos;
	}
	public DwConsolidDTOs getListaDwConsolidTurno() {
		return listaDwConsolidTurno;
	}
	public void setListaDwConsolidTurno(DwConsolidDTOs listaDwConsolidTurno) {
		this.listaDwConsolidTurno = listaDwConsolidTurno;
	}
	public Double getPcsPorCicloAtivas() {
		return pcsPorCicloAtivas;
	}
	public void setPcsPorCicloAtivas(Double pcsPorCicloAtivas) {
		this.pcsPorCicloAtivas = pcsPorCicloAtivas;
	}
	public List<DwConsolid> getListaDwConsolId() {
		return listaDwConsolId;
	}
	public void setListaDwConsolId(List<DwConsolid> listaDwConsolId) {
		this.listaDwConsolId = listaDwConsolId;
	}
	public Integer getTempoCalendario() {
		return tempoCalendario;
	}
	public void setTempoCalendario(Integer tempoCalendario) {
		this.tempoCalendario = tempoCalendario;
	}
	public Integer getTempoSemColeta() {
		return tempoSemColeta;
	}
	public void setTempoSemColeta(Integer tempoSemColeta) {
		this.tempoSemColeta = tempoSemColeta;
	}
	public Integer getTempoDuplicadoColeta() {
		return tempoDuplicadoColeta;
	}
	public void setTempoDuplicadoColeta(Integer tempoDuplicadoColeta) {
		this.tempoDuplicadoColeta = tempoDuplicadoColeta;
	}
	public List<PpCp> getOpsNoTurno() {
		return opsNoTurno;
	}
	public void setOpsNoTurno(List<PpCp> opsNoTurno) {
		this.opsNoTurno = opsNoTurno;
	}
	public Double getIndiceProducao() {
		return indiceProducao;
	}
	public void setIndiceProducao(Double indiceProducao) {
		this.indiceProducao = indiceProducao;
	}
	public String getDtFimPrevisto() {
		return dtFimPrevisto;
	}
	public void setDtFimPrevisto(String dtFimPrevisto) {
		this.dtFimPrevisto = dtFimPrevisto;
	}
	public String getGargalo() {
		return gargalo;
	}
	public void setGargalo(String gargalo) {
		this.gargalo = gargalo;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public Date getDtRefMin() {
		return dtRefMin;
	}
	public void setDtRefMin(Date dtRefMin) {
		this.dtRefMin = dtRefMin;
	}
	public Date getDtRefMax() {
		return DtRefMax;
	}
	public void setDtRefMax(Date dtRefMax) {
		DtRefMax = dtRefMax;
	}
	public Double getPcsPorCicloTotais() {
		return pcsPorCicloTotais;
	}
	public void setPcsPorCicloTotais(Double pcsPorCicloTotais) {
		this.pcsPorCicloTotais = pcsPorCicloTotais;
	}
	public List<GraficoCicloDTO> getListaIndicadoresMaquinas() {
		return listaIndicadoresMaquinas;
	}
	public void setListaIndicadoresMaquinas(List<GraficoCicloDTO> listaIndicadoresMaquinas) {
		this.listaIndicadoresMaquinas = listaIndicadoresMaquinas;
	}
	public List<ProdutoResumoBIDTO> getListaIndicadoresProdutoConjunto() {
		return listaIndicadoresProdutoConjunto;
	}
	public void setListaIndicadoresProdutoConjunto(
			List<ProdutoResumoBIDTO> listaIndicadoresProdutoConjunto) {
		this.listaIndicadoresProdutoConjunto = listaIndicadoresProdutoConjunto;
	}
	public List<PtRapResumoDTO> getListaIndicadoresPt() {
		return listaIndicadoresPt;
	}
	public void setListaIndicadoresPt(List<PtRapResumoDTO> listaIndicadoresPt) {
		this.listaIndicadoresPt = listaIndicadoresPt;
	}
	public List<PtRapResumoDTO> getListaIndicadoresPtRap() {
		return listaIndicadoresPtRap;
	}
	public void setListaIndicadoresPtRap(List<PtRapResumoDTO> listaIndicadoresPtRap) {
		this.listaIndicadoresPtRap = listaIndicadoresPtRap;
	}
	public List<HistoricoSmedDTO> getHistoricoSmed() {
		return historicoSmed;
	}
	public void setHistoricoSmed(List<HistoricoSmedDTO> historicoSmed) {
		this.historicoSmed = historicoSmed;
	}
	public BigDecimal getConsumoMPProducaoBruta() {
		return consumoMPProducaoBruta;
	}
	public void setConsumoMPProducaoBruta(BigDecimal consumoMPProducaoBruta) {
		this.consumoMPProducaoBruta = consumoMPProducaoBruta;
	}
	public BigDecimal getConsumoMPProducaoLiquira() {
		return consumoMPProducaoLiquira;
	}
	public void setConsumoMPProducaoLiquira(BigDecimal consumoMPProducaoLiquira) {
		this.consumoMPProducaoLiquira = consumoMPProducaoLiquira;
	}
	public BigDecimal getConsumoMPProducaoRefugada() {
		return consumoMPProducaoRefugada;
	}
	public void setConsumoMPProducaoRefugada(BigDecimal consumoMPProducaoRefugada) {
		this.consumoMPProducaoRefugada = consumoMPProducaoRefugada;
	}
	public BigDecimal getProducaoPrevistaKg() {
		return producaoPrevistaKg;
	}
	public void setProducaoPrevistaKg(BigDecimal producaoPrevistaKg) {
		this.producaoPrevistaKg = producaoPrevistaKg;
	}
	public BigDecimal getProducaoPrevistaTn() {
		return producaoPrevistaTn;
	}
	public void setProducaoPrevistaTn(BigDecimal producaoPrevistaTn) {
		this.producaoPrevistaTn = producaoPrevistaTn;
	}
	public BigDecimal getProducaoLiquidaKg() {
		return producaoLiquidaKg;
	}
	public void setProducaoLiquidaKg(BigDecimal producaoLiquidaKg) {
		this.producaoLiquidaKg = producaoLiquidaKg;
	}
	public BigDecimal getProducaoLiquidaTn() {
		return producaoLiquidaTn;
	}
	public void setProducaoLiquidaTn(BigDecimal producaoLiquidaTn) {
		this.producaoLiquidaTn = producaoLiquidaTn;
	}
	public List<EnergiaConsumidaProducaoDTO> getEnergiaConsumidaProducao() {
		return energiaConsumidaProducao;
	}
	public void setEnergiaConsumidaProducao(List<EnergiaConsumidaProducaoDTO> energiaConsumidaProducao) {
		this.energiaConsumidaProducao = energiaConsumidaProducao;
	}
	public List<CIPDTO> getListacips() {
		return listacips;
	}
	public void setListacips(List<CIPDTO> listacips) {
		this.listacips = listacips;
	}
	public List<MpBrutaPorMaquinaDTO> getListaMpBrutaPorMaquina() {
		return listaMpBrutaPorMaquina;
	}
	public void setListaMpBrutaPorMaquina(
			List<MpBrutaPorMaquinaDTO> listaMpBrutaPorMaquina) {
		this.listaMpBrutaPorMaquina = listaMpBrutaPorMaquina;
	}
	public BigDecimal getProducaoBrutaKg() {
		return producaoBrutaKg;
	}
	public void setProducaoBrutaKg(BigDecimal producaoBrutaKg) {
		this.producaoBrutaKg = producaoBrutaKg;
	}
	public BigDecimal getProducaoRefugadaKg() {
		return producaoRefugadaKg;
	}
	public void setProducaoRefugadaKg(BigDecimal producaoRefugadaKg) {
		this.producaoRefugadaKg = producaoRefugadaKg;
	}
	public BigDecimal getPerdaParadaKg() {
		return perdaParadaKg;
	}
	public void setPerdaParadaKg(BigDecimal perdaParadaKg) {
		this.perdaParadaKg = perdaParadaKg;
	}
	public BigDecimal getPciKg() {
		return pciKg;
	}
	public void setPciKg(BigDecimal pciKg) {
		this.pciKg = pciKg;
	}
	public BigDecimal getPerdaCicloKg() {
		return perdaCicloKg;
	}
	public void setPerdaCicloKg(BigDecimal perdaCicloKg) {
		this.perdaCicloKg = perdaCicloKg;
	}
	public BigDecimal getProducaoBrutaTn() {
		return producaoBrutaTn;
	}
	public void setProducaoBrutaTn(BigDecimal producaoBrutaTn) {
		this.producaoBrutaTn = producaoBrutaTn;
	}
	public BigDecimal getProducaoRefugadaTn() {
		return producaoRefugadaTn;
	}
	public void setProducaoRefugadaTn(BigDecimal producaoRefugadaTn) {
		this.producaoRefugadaTn = producaoRefugadaTn;
	}
	public BigDecimal getPerdaParadaTn() {
		return perdaParadaTn;
	}
	public void setPerdaParadaTn(BigDecimal perdaParadaTn) {
		this.perdaParadaTn = perdaParadaTn;
	}
	public BigDecimal getPciTn() {
		return pciTn;
	}
	public void setPciTn(BigDecimal pciTn) {
		this.pciTn = pciTn;
	}
	public BigDecimal getPerdaCicloTn() {
		return perdaCicloTn;
	}
	public void setPerdaCicloTn(BigDecimal perdaCicloTn) {
		this.perdaCicloTn = perdaCicloTn;
	}
	public Boolean getIsForaMetaIndiceRefugos() {
		return isForaMetaIndiceRefugos;
	}
	public void setIsForaMetaIndiceRefugos(Boolean isForaMetaIndiceRefugos) {
		this.isForaMetaIndiceRefugos = isForaMetaIndiceRefugos;
	}
	public Boolean getIsForaMetaIefiRealizacao() {
		return isForaMetaIefiRealizacao;
	}
	public void setIsForaMetaIefiRealizacao(Boolean isForaMetaIefiRealizacao) {
		this.isForaMetaIefiRealizacao = isForaMetaIefiRealizacao;
	}
	public Boolean getIsForaMetaIefiCiclos() {
		return isForaMetaIefiCiclos;
	}
	public void setIsForaMetaIefiCiclos(Boolean isForaMetaIefiCiclos) {
		this.isForaMetaIefiCiclos = isForaMetaIefiCiclos;
	}
	public Boolean getIsForaMetaEficienciaUltCic() {
		return isForaMetaEficienciaUltCic;
	}
	public void setIsForaMetaEficienciaUltCic(Boolean isForaMetaEficienciaUltCic) {
		this.isForaMetaEficienciaUltCic = isForaMetaEficienciaUltCic;
	}
	public Boolean getIsForaMetaIndiceParadas() {
		return isForaMetaIndiceParadas;
	}
	public void setIsForaMetaIndiceParadas(Boolean isForaMetaIndiceParadas) {
		this.isForaMetaIndiceParadas = isForaMetaIndiceParadas;
	}
	public Double getIndiceParadasSemPeso() {
		return indiceParadasSemPeso;
	}
	public void setIndiceParadasSemPeso(Double indiceParadasSemPeso) {
		this.indiceParadasSemPeso = indiceParadasSemPeso;
	}
	public Double getPerdasParadasSemPeso() {
		return perdasParadasSemPeso;
	}
	public void setPerdasParadasSemPeso(Double perdasParadasSemPeso) {
		this.perdasParadasSemPeso = perdasParadasSemPeso;
	}
    public Double getIndiceRefugoGr() {
        return indiceRefugoGr;
    }
    public void setIndiceRefugoGr(Double indiceRefugoGr) {
        this.indiceRefugoGr = indiceRefugoGr;
    }
	public BigDecimal getCustoMPTotalDeInsercao() {
		return custoMPTotalDeInsercao;
	}
	public void setCustoMPTotalDeInsercao(BigDecimal custoMPTotalDeInsercao) {
		this.custoMPTotalDeInsercao = custoMPTotalDeInsercao;
	}
	public BigDecimal getCustoMPTotalDePerdas() {
		return custoMPTotalDePerdas;
	}
	public void setCustoMPTotalDePerdas(BigDecimal custoMPTotalDePerdas) {
		this.custoMPTotalDePerdas = custoMPTotalDePerdas;
	}
	public BigDecimal getCustoMPTotalDeInsercaoLiquida() {
		return custoMPTotalDeInsercaoLiquida;
	}
	public void setCustoMPTotalDeInsercaoLiquida(
			BigDecimal custoMPTotalDeInsercaoLiquida) {
		this.custoMPTotalDeInsercaoLiquida = custoMPTotalDeInsercaoLiquida;
	}
	public Double getEfiRealizacaoGr() {
		return efiRealizacaoGr;
	}
	public void setEfiRealizacaoGr(Double efiRealizacaoGr) {
		this.efiRealizacaoGr = efiRealizacaoGr;
	}
	public Double getIndicePerdasGr() {
		return indicePerdasGr;
	}
	public void setIndicePerdasGr(Double indicePerdasGr) {
		this.indicePerdasGr = indicePerdasGr;
	} 

	
	public Double getIndiceFPY() {
		return indiceFPY;
	}
	public void setIndiceFPY(Double indiceFPY) {
		this.indiceFPY = indiceFPY;
	}
	public BigDecimal getQtTestes() {
		return qtTestes;
	}
	public void setQtTestes(BigDecimal qtTestes) {
		this.qtTestes = qtTestes;
	}
	public BigDecimal getQtDefeitos() {
		return qtDefeitos;
	}
	public void setQtDefeitos(BigDecimal qtDefeitos) {
		this.qtDefeitos = qtDefeitos;
	}
	public Double getIndiceDefeito() {
		return indiceDefeito;
	}
	public void setIndiceDefeito(Double indiceDefeito) {
		this.indiceDefeito = indiceDefeito;
	}

}
