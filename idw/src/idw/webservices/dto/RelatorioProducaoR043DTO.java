package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.List;

import ms.util.ConversaoTipos;

public class RelatorioProducaoR043DTO {
	
	private List<RelatorioProducaoR043DTO> lista;
	
	private List<LinhaTabelaSubRelatorioProducaoR043DTO> refugos;
	private LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalRefugos;
	
	private List<LinhaTabelaSubRelatorioProducaoR043DTO> paradas;
	private LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalParadasComPeso;
	private LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalParadasSemPeso;
	private LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalParadas;
	
	private String labelData;
	private String data;
	private boolean realizada;
	private boolean vazio;
	
	private String numeroMaquinasFormatada;
	private String horasPeriodoFormatada;
	private String diasDaSemanaFormatada;
	
	private String producaoBrutaPecaFormatada;
	private String producaoBrutaKgFormatada;	
	private String producaoRefugoPecaFormatada;
	private String producaoRefugoKgFormatada;	
	private String producaoLiquidaPecaFormatada;
	private String producaoLiquidaKgFormatada;	
	private String producaoPCMPecaFormatada;
	private String producaoPrevistaPecaFormatada;
	
	private String ciclosProdutivosHoraFormatada;
	private String ciclosImprodutivosHoraFormatada;
	private String paradasHoraFormatada;
	private String naoDisponivelHoraFormatada;
	private String disponivelHoraFormatada;
	private String totaisHoraFormatada;
	private String trabalhadasHoraFormatada;
	private String refugosHoraFormatada;
	private String ritmoHoraFormatada;
	private String produtivasHoraFormatada;
	private String pciHoraFormatada;
	
	private String numeroDeSetupFormatada;
	private String duracaoSetupMinutosFormatada;
	private String padraoMedioSetupMinutosFormatada;
	private String eficienciaSetupFormatada;
	
	private String numeroDeTryOutFormatada;
	private String tempoMedioTryOutMinutosFormatada;
	
	private String atendimentoFormatada;
	private String utilizacaoFormatada;
	private String eficienciaFormatada;
	private String produtividadeFormatada;
	private String produtividadeCFormatada;
	private String ppmilFormatada;
	
	private String eficienciaSetupMeta;
	private String atendimentoMeta;
	private String utilizacaoMeta;
	private String eficienciaMeta;
	private String produtividadeMeta;
	private String produtividadeCMeta;
	private String ppmilMeta;
	
	private BigDecimal numeroMaquinas;
	private BigDecimal horasPeriodo;
	private BigDecimal diasDaSemana;
	
	private BigDecimal producaoBrutaPeca;
	private BigDecimal producaoBrutaKg;	
	private BigDecimal producaoRefugoPeca;
	private BigDecimal producaoRefugoKg;	
	private BigDecimal producaoLiquidaPeca;
	private BigDecimal producaoLiquidaKg;	
	private BigDecimal producaoPCMPeca;
	private BigDecimal producaoPrevistaPeca;
	
	private BigDecimal ciclosProdutivosHora;
	private BigDecimal ciclosImprodutivosHora;
	private BigDecimal paradasHora;
	private BigDecimal naoDisponivelHora;
	private BigDecimal disponivelHora;
	private BigDecimal totaisHora;
	private BigDecimal trabalhadasHora;
	private BigDecimal refugosHora;
	private BigDecimal ritmoHora;
	private BigDecimal produtivasHora;
	private BigDecimal pciHora;
	
	private BigDecimal numeroDeSetup;
	private BigDecimal duracaoSetupMinutos;
	private BigDecimal padraoMedioSetupMinutos;
	private BigDecimal eficienciaSetup;
	
	private BigDecimal numeroDeTryOut;
	private BigDecimal tempoMedioTryOut;
	
	private BigDecimal atendimento;
	private BigDecimal utilizacao;
	private BigDecimal eficiencia;
	private BigDecimal produtividade;
	private BigDecimal produtividadeC;
	private BigDecimal ppmil;
	
	public List<RelatorioProducaoR043DTO> getLista() {
		return lista;
	}
	public void setLista(List<RelatorioProducaoR043DTO> lista) {
		this.lista = lista;
	}
	public String getLabelData() {
		return labelData;
	}	
	public boolean isRealizada() {
		return realizada;
	}
	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	public void setLabelData(String labelData) {
		this.labelData = labelData;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNumeroMaquinasFormatada() {
		return numeroMaquinasFormatada;
	}
	public void setNumeroMaquinasFormatada(String numeroMaquinasFormatada) {
		this.numeroMaquinasFormatada = numeroMaquinasFormatada;
	}
	public String getHorasPeriodoFormatada() {
		return horasPeriodoFormatada;
	}
	public void setHorasPeriodoFormatada(String horasPeriodoFormatada) {
		this.horasPeriodoFormatada = horasPeriodoFormatada;
	}
	public String getDiasDaSemanaFormatada() {
		return diasDaSemanaFormatada;
	}
	public void setDiasDaSemanaFormatada(String diasDaSemanaFormatada) {
		this.diasDaSemanaFormatada = diasDaSemanaFormatada;
	}
	public String getProducaoBrutaPecaFormatada() {
		return producaoBrutaPecaFormatada;
	}
	public void setProducaoBrutaPecaFormatada(String producaoBrutaPecaFormatada) {
		this.producaoBrutaPecaFormatada = producaoBrutaPecaFormatada;
	}
	public String getProducaoBrutaKgFormatada() {
		return producaoBrutaKgFormatada;
	}
	public void setProducaoBrutaKgFormatada(String producaoBrutaKgFormatada) {
		this.producaoBrutaKgFormatada = producaoBrutaKgFormatada;
	}
	public String getProducaoRefugoPecaFormatada() {
		return producaoRefugoPecaFormatada;
	}
	public void setProducaoRefugoPecaFormatada(String producaoRefugoPecaFormatada) {
		this.producaoRefugoPecaFormatada = producaoRefugoPecaFormatada;
	}
	public String getProducaoRefugoKgFormatada() {
		return producaoRefugoKgFormatada;
	}
	public void setProducaoRefugoKgFormatada(String producaoRefugoKgFormatada) {
		this.producaoRefugoKgFormatada = producaoRefugoKgFormatada;
	}
	public String getProducaoLiquidaPecaFormatada() {
		return producaoLiquidaPecaFormatada;
	}
	public void setProducaoLiquidaPecaFormatada(String producaoLiquidaPecaFormatada) {
		this.producaoLiquidaPecaFormatada = producaoLiquidaPecaFormatada;
	}
	public String getProducaoLiquidaKgFormatada() {
		return producaoLiquidaKgFormatada;
	}
	public void setProducaoLiquidaKgFormatada(String producaoLiquidaKgFormatada) {
		this.producaoLiquidaKgFormatada = producaoLiquidaKgFormatada;
	}
	public String getProducaoPCMPecaFormatada() {
		return producaoPCMPecaFormatada;
	}
	public void setProducaoPCMPecaFormatada(String producaoPCMPecaFormatada) {
		this.producaoPCMPecaFormatada = producaoPCMPecaFormatada;
	}
	public String getProducaoPrevistaPecaFormatada() {
		return producaoPrevistaPecaFormatada;
	}
	public void setProducaoPrevistaPecaFormatada(
			String producaoPrevistaPecaFormatada) {
		this.producaoPrevistaPecaFormatada = producaoPrevistaPecaFormatada;
	}
	public String getCiclosProdutivosHoraFormatada() {
		return ciclosProdutivosHoraFormatada;
	}
	public void setCiclosProdutivosHoraFormatada(
			String ciclosProdutivosHoraFormatada) {
		this.ciclosProdutivosHoraFormatada = ciclosProdutivosHoraFormatada;
	}
	public String getCiclosImprodutivosHoraFormatada() {
		return ciclosImprodutivosHoraFormatada;
	}
	public void setCiclosImprodutivosHoraFormatada(
			String ciclosImprodutivosHoraFormatada) {
		this.ciclosImprodutivosHoraFormatada = ciclosImprodutivosHoraFormatada;
	}
	public String getParadasHoraFormatada() {
		return paradasHoraFormatada;
	}
	public void setParadasHoraFormatada(String paradasHoraFormatada) {
		this.paradasHoraFormatada = paradasHoraFormatada;
	}
	public String getNaoDisponivelHoraFormatada() {
		return naoDisponivelHoraFormatada;
	}
	public void setNaoDisponivelHoraFormatada(String naoDisponivelHoraFormatada) {
		this.naoDisponivelHoraFormatada = naoDisponivelHoraFormatada;
	}
	public String getDisponivelHoraFormatada() {
		return disponivelHoraFormatada;
	}
	public void setDisponivelHoraFormatada(String disponivelHoraFormatada) {
		this.disponivelHoraFormatada = disponivelHoraFormatada;
	}
	public String getTotaisHoraFormatada() {
		return totaisHoraFormatada;
	}
	public void setTotaisHoraFormatada(String totaisHoraFormatada) {
		this.totaisHoraFormatada = totaisHoraFormatada;
	}
	public String getTrabalhadasHoraFormatada() {
		return trabalhadasHoraFormatada;
	}
	public void setTrabalhadasHoraFormatada(String trabalhadasHoraFormatada) {
		this.trabalhadasHoraFormatada = trabalhadasHoraFormatada;
	}
	public String getRefugosHoraFormatada() {
		return refugosHoraFormatada;
	}
	public void setRefugosHoraFormatada(String refugosHoraFormatada) {
		this.refugosHoraFormatada = refugosHoraFormatada;
	}
	public String getRitmoHoraFormatada() {
		return ritmoHoraFormatada;
	}
	public void setRitmoHoraFormatada(String ritmoHoraFormatada) {
		this.ritmoHoraFormatada = ritmoHoraFormatada;
	}
	public String getProdutivasHoraFormatada() {
		return produtivasHoraFormatada;
	}
	public void setProdutivasHoraFormatada(String produtivasHoraFormatada) {
		this.produtivasHoraFormatada = produtivasHoraFormatada;
	}
	public String getPciHoraFormatada() {
		return pciHoraFormatada;
	}
	public void setPciHoraFormatada(String pciHoraFormatada) {
		this.pciHoraFormatada = pciHoraFormatada;
	}
	public BigDecimal getNumeroMaquinas() {
		return numeroMaquinas;
	}
	public void setNumeroMaquinas(BigDecimal numeroMaquinas) {
		this.numeroMaquinas = numeroMaquinas;
	}
	public BigDecimal getHorasPeriodo() {
		return horasPeriodo;
	}
	public void setHorasPeriodo(BigDecimal horasPeriodo) {
		this.horasPeriodo = horasPeriodo;
	}
	public BigDecimal getDiasDaSemana() {
		return diasDaSemana;
	}
	public void setDiasDaSemana(BigDecimal diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
	public BigDecimal getProducaoBrutaPeca() {
		return producaoBrutaPeca;
	}
	public void setProducaoBrutaPeca(BigDecimal producaoBrutaPeca) {
		this.producaoBrutaPeca = producaoBrutaPeca;
	}
	public BigDecimal getProducaoBrutaKg() {
		return producaoBrutaKg;
	}
	public void setProducaoBrutaKg(BigDecimal producaoBrutaKg) {
		this.producaoBrutaKg = producaoBrutaKg;
	}
	public BigDecimal getProducaoRefugoPeca() {
		return producaoRefugoPeca;
	}
	public void setProducaoRefugoPeca(BigDecimal producaoRefugoPeca) {
		this.producaoRefugoPeca = producaoRefugoPeca;
	}
	public BigDecimal getProducaoRefugoKg() {
		return producaoRefugoKg;
	}
	public void setProducaoRefugoKg(BigDecimal producaoRefugoKg) {
		this.producaoRefugoKg = producaoRefugoKg;
	}
	public BigDecimal getProducaoLiquidaPeca() {
		return producaoLiquidaPeca;
	}
	public void setProducaoLiquidaPeca(BigDecimal producaoLiquidaPeca) {
		this.producaoLiquidaPeca = producaoLiquidaPeca;
	}
	public BigDecimal getProducaoLiquidaKg() {
		return producaoLiquidaKg;
	}
	public void setProducaoLiquidaKg(BigDecimal producaoLiquidaKg) {
		this.producaoLiquidaKg = producaoLiquidaKg;
	}
	public BigDecimal getProducaoPCMPeca() {
		return producaoPCMPeca;
	}
	public void setProducaoPCMPeca(BigDecimal producaoPCMPeca) {
		this.producaoPCMPeca = producaoPCMPeca;
	}
	public BigDecimal getProducaoPrevistaPeca() {
		return producaoPrevistaPeca;
	}
	public void setProducaoPrevistaPeca(BigDecimal producaoPrevistaPeca) {
		this.producaoPrevistaPeca = producaoPrevistaPeca;
	}
	public BigDecimal getCiclosProdutivosHora() {
		return ciclosProdutivosHora;
	}
	public void setCiclosProdutivosHora(BigDecimal ciclosProdutivosHora) {
		this.ciclosProdutivosHora = ciclosProdutivosHora;
	}
	public BigDecimal getCiclosImprodutivosHora() {
		return ciclosImprodutivosHora;
	}
	public void setCiclosImprodutivosHora(BigDecimal ciclosImprodutivosHora) {
		this.ciclosImprodutivosHora = ciclosImprodutivosHora;
	}
	public BigDecimal getParadasHora() {
		return paradasHora;
	}
	public void setParadasHora(BigDecimal paradasHora) {
		this.paradasHora = paradasHora;
	}
	public BigDecimal getNaoDisponivelHora() {
		return naoDisponivelHora;
	}
	public void setNaoDisponivelHora(BigDecimal naoDisponivelHora) {
		this.naoDisponivelHora = naoDisponivelHora;
	}
	public BigDecimal getDisponivelHora() {
		return disponivelHora;
	}
	public void setDisponivelHora(BigDecimal disponivelHora) {
		this.disponivelHora = disponivelHora;
	}
	public BigDecimal getTotaisHora() {
		return totaisHora;
	}
	public void setTotaisHora(BigDecimal totaisHora) {
		this.totaisHora = totaisHora;
	}
	public BigDecimal getTrabalhadasHora() {
		return trabalhadasHora;
	}
	public void setTrabalhadasHora(BigDecimal trabalhadasHora) {
		this.trabalhadasHora = trabalhadasHora;
	}
	public BigDecimal getRefugosHora() {
		return refugosHora;
	}
	public void setRefugosHora(BigDecimal refugosHora) {
		this.refugosHora = refugosHora;
	}
	public BigDecimal getRitmoHora() {
		return ritmoHora;
	}
	public void setRitmoHora(BigDecimal ritmoHora) {
		this.ritmoHora = ritmoHora;
	}
	public BigDecimal getProdutivasHora() {
		return produtivasHora;
	}
	public void setProdutivasHora(BigDecimal produtivasHora) {
		this.produtivasHora = produtivasHora;
	}
	public BigDecimal getPciHora() {
		return pciHora;
	}
	public void setPciHora(BigDecimal pciHora) {
		this.pciHora = pciHora;
	}
	public List<LinhaTabelaSubRelatorioProducaoR043DTO> getParadas() {
		return paradas;
	}
	public void setParadas(List<LinhaTabelaSubRelatorioProducaoR043DTO> paradas) {
		this.paradas = paradas;
	}
	public LinhaTabelaSubRelatorioProducaoR043DTO getTempoTotalParadasComPeso() {
		return tempoTotalParadasComPeso;
	}
	public void setTempoTotalParadasComPeso(
			LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalParadasComPeso) {
		this.tempoTotalParadasComPeso = tempoTotalParadasComPeso;
	}
	public LinhaTabelaSubRelatorioProducaoR043DTO getTempoTotalParadasSemPeso() {
		return tempoTotalParadasSemPeso;
	}
	public void setTempoTotalParadasSemPeso(
			LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalParadasSemPeso) {
		this.tempoTotalParadasSemPeso = tempoTotalParadasSemPeso;
	}
	public LinhaTabelaSubRelatorioProducaoR043DTO getTempoTotalParadas() {
		return tempoTotalParadas;
	}
	public void setTempoTotalParadas(
			LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalParadas) {
		this.tempoTotalParadas = tempoTotalParadas;
	}
	public List<LinhaTabelaSubRelatorioProducaoR043DTO> getRefugos() {
		return refugos;
	}
	public void setRefugos(List<LinhaTabelaSubRelatorioProducaoR043DTO> refugos) {
		this.refugos = refugos;
	}
	public LinhaTabelaSubRelatorioProducaoR043DTO getTempoTotalRefugos() {
		return tempoTotalRefugos;
	}
	public void setTempoTotalRefugos(
			LinhaTabelaSubRelatorioProducaoR043DTO tempoTotalRefugos) {
		this.tempoTotalRefugos = tempoTotalRefugos;
	}
	public String getNumeroDeSetupFormatada() {
		return numeroDeSetupFormatada;
	}
	public void setNumeroDeSetupFormatada(String numeroDeSetupFormatada) {
		this.numeroDeSetupFormatada = numeroDeSetupFormatada;
	}
	public String getEficienciaSetupFormatada() {
		return eficienciaSetupFormatada;
	}
	public void setEficienciaSetupFormatada(String eficienciaSetupFormatada) {
		this.eficienciaSetupFormatada = eficienciaSetupFormatada;
	}
	public String getNumeroDeTryOutFormatada() {
		return numeroDeTryOutFormatada;
	}
	public void setNumeroDeTryOutFormatada(String numeroDeTryOutFormatada) {
		this.numeroDeTryOutFormatada = numeroDeTryOutFormatada;
	}	
	public String getAtendimentoFormatada() {
		return atendimentoFormatada;
	}
	public void setAtendimentoFormatada(String atendimentoFormatada) {
		this.atendimentoFormatada = atendimentoFormatada;
	}
	public String getUtilizacaoFormatada() {
		return utilizacaoFormatada;
	}
	public void setUtilizacaoFormatada(String utilizacaoFormatada) {
		this.utilizacaoFormatada = utilizacaoFormatada;
	}
	public String getEficienciaFormatada() {
		return eficienciaFormatada;
	}
	public void setEficienciaFormatada(String eficienciaFormatada) {
		this.eficienciaFormatada = eficienciaFormatada;
	}
	public String getProdutividadeFormatada() {
		return produtividadeFormatada;
	}
	public void setProdutividadeFormatada(String produtividadeFormatada) {
		this.produtividadeFormatada = produtividadeFormatada;
	}
	public String getProdutividadeCFormatada() {
		return produtividadeCFormatada;
	}
	public void setProdutividadeCFormatada(String produtividadeCFormatada) {
		this.produtividadeCFormatada = produtividadeCFormatada;
	}
	public String getPpmilFormatada() {
		return ppmilFormatada;
	}
	public void setPpmilFormatada(String ppmilFormatada) {
		this.ppmilFormatada = ppmilFormatada;
	}
	public BigDecimal getNumeroDeSetup() {
		return numeroDeSetup;
	}
	public void setNumeroDeSetup(BigDecimal numeroDeSetup) {
		this.numeroDeSetup = numeroDeSetup;
	}
	public BigDecimal getEficienciaSetup() {
		return eficienciaSetup;
	}
	public void setEficienciaSetup(BigDecimal eficienciaSetup) {
		this.eficienciaSetup = eficienciaSetup;
	}
	public BigDecimal getNumeroDeTryOut() {
		return numeroDeTryOut;
	}
	public void setNumeroDeTryOut(BigDecimal numeroDeTryOut) {
		this.numeroDeTryOut = numeroDeTryOut;
	}
	public BigDecimal getTempoMedioTryOut() {
		return tempoMedioTryOut;
	}
	public void setTempoMedioTryOut(BigDecimal tempoMedioTryOut) {
		this.tempoMedioTryOut = tempoMedioTryOut;
	}
	public BigDecimal getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(BigDecimal atendimento) {
		this.atendimento = atendimento;
	}
	public BigDecimal getUtilizacao() {
		return utilizacao;
	}
	public void setUtilizacao(BigDecimal utilizacao) {
		this.utilizacao = utilizacao;
	}
	public BigDecimal getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(BigDecimal eficiencia) {
		this.eficiencia = eficiencia;
	}
	public BigDecimal getProdutividade() {
		return produtividade;
	}
	public void setProdutividade(BigDecimal produtividade) {
		this.produtividade = produtividade;
	}
	public BigDecimal getProdutividadeC() {
		return produtividadeC;
	}
	public void setProdutividadeC(BigDecimal produtividadeC) {
		this.produtividadeC = produtividadeC;
	}
	public BigDecimal getPpmil() {
		return ppmil;
	}
	public void setPpmil(BigDecimal ppmil) {
		this.ppmil = ppmil;
	}
	public String getDuracaoSetupMinutosFormatada() {
		return duracaoSetupMinutosFormatada;
	}
	public void setDuracaoSetupMinutosFormatada(String duracaoSetupMinutosFormatada) {
		this.duracaoSetupMinutosFormatada = duracaoSetupMinutosFormatada;
	}
	public String getPadraoMedioSetupMinutosFormatada() {
		return padraoMedioSetupMinutosFormatada;
	}
	public void setPadraoMedioSetupMinutosFormatada(
			String padraoMedioSetupMinutosFormatada) {
		this.padraoMedioSetupMinutosFormatada = padraoMedioSetupMinutosFormatada;
	}
	public String getTempoMedioTryOutMinutosFormatada() {
		return tempoMedioTryOutMinutosFormatada;
	}
	public void setTempoMedioTryOutMinutosFormatada(
			String tempoMedioTryOutMinutosFormatada) {
		this.tempoMedioTryOutMinutosFormatada = tempoMedioTryOutMinutosFormatada;
	}
	public BigDecimal getDuracaoSetupMinutos() {
		return duracaoSetupMinutos;
	}
	public void setDuracaoSetupMinutos(BigDecimal duracaoSetupMinutos) {
		this.duracaoSetupMinutos = duracaoSetupMinutos;
	}
	public BigDecimal getPadraoMedioSetupMinutos() {
		return padraoMedioSetupMinutos;
	}
	public void setPadraoMedioSetupMinutos(BigDecimal padraoMedioSetupMinutos) {
		this.padraoMedioSetupMinutos = padraoMedioSetupMinutos;
	}	
	public boolean isVazio() {
		return vazio;
	}
	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}	
	public String getEficienciaSetupMeta() {
		return eficienciaSetupMeta;
	}
	public void setEficienciaSetupMeta(String eficienciaSetupMeta) {
		this.eficienciaSetupMeta = eficienciaSetupMeta;
	}
	public String getAtendimentoMeta() {
		return atendimentoMeta;
	}
	public void setAtendimentoMeta(String atendimentoMeta) {
		this.atendimentoMeta = atendimentoMeta;
	}
	public String getUtilizacaoMeta() {
		return utilizacaoMeta;
	}
	public void setUtilizacaoMeta(String utilizacaoMeta) {
		this.utilizacaoMeta = utilizacaoMeta;
	}
	public String getEficienciaMeta() {
		return eficienciaMeta;
	}
	public void setEficienciaMeta(String eficienciaMeta) {
		this.eficienciaMeta = eficienciaMeta;
	}
	public String getProdutividadeMeta() {
		return produtividadeMeta;
	}
	public void setProdutividadeMeta(String produtividadeMeta) {
		this.produtividadeMeta = produtividadeMeta;
	}
	public String getProdutividadeCMeta() {
		return produtividadeCMeta;
	}
	public void setProdutividadeCMeta(String produtividadeCMeta) {
		this.produtividadeCMeta = produtividadeCMeta;
	}
	public String getPpmilMeta() {
		return ppmilMeta;
	}
	public void setPpmilMeta(String ppmilMeta) {
		this.ppmilMeta = ppmilMeta;
	}
	
	//GETTERS E SETTERS BASEADO NO VALOR DO RELATORIO R043
	public void setAFormatandoCampoFilho(BigDecimal valor){
		numeroMaquinas = valor;
		if (numeroMaquinas != null) {
			numeroMaquinasFormatada = ConversaoTipos.converteParaStringUsandoVirgula(numeroMaquinas, 0);
		}
	}
	
	public BigDecimal getA(){
		if(numeroMaquinas == null){
			return BigDecimal.ZERO;
		}
		return numeroMaquinas;
	}
	
	public void setBFormatandoCampoFilho(BigDecimal valor){
		horasPeriodo = valor;
		if (horasPeriodo != null) {
			horasPeriodoFormatada = ConversaoTipos.converteParaStringUsandoVirgula(horasPeriodo, 2);
		}
	}
	
	public BigDecimal getB(){
		if(horasPeriodo == null){
			return BigDecimal.ZERO;
		}
		return horasPeriodo;
	}
	
	public void setCFormatandoCampoFilho(BigDecimal valor){
		diasDaSemana = valor;
		if (diasDaSemana != null) {
			diasDaSemanaFormatada = ConversaoTipos.converteParaStringUsandoVirgula(diasDaSemana, 0);
		}
	}
	
	public BigDecimal getC(){
		if(diasDaSemana == null){
			return BigDecimal.ZERO;
		}
		return diasDaSemana;
	}
	
	public void setDFormatandoCampoFilho(BigDecimal valor){
		producaoBrutaPeca = valor;
		if (producaoBrutaPeca != null) {
			producaoBrutaPecaFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoBrutaPeca, 0);
		}
	}
	
	public BigDecimal getD(){
		if(producaoBrutaPeca == null){
			return BigDecimal.ZERO;
		}
		return producaoBrutaPeca;
	}
	
	public void setEFormatandoCampoFilho(BigDecimal valor){
		producaoBrutaKg = valor;
		if (producaoBrutaKg != null) {
			producaoBrutaKgFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoBrutaKg, 4);
		}
	}
	
	public BigDecimal getE(){
		if(producaoBrutaKg == null){
			return BigDecimal.ZERO;
		}
		return producaoBrutaKg;
	}
	
	public void setFFormatandoCampoFilho(BigDecimal valor){
		producaoRefugoPeca = valor;
		if (producaoRefugoPeca != null) {
			producaoRefugoPecaFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoRefugoPeca, 0);
		}
	}
	
	public BigDecimal getF(){
		if(producaoRefugoPeca == null){
			return BigDecimal.ZERO;
		}
		return producaoRefugoPeca;
	}
	
	public void setGFormatandoCampoFilho(BigDecimal valor){
		producaoRefugoKg = valor;
		if (producaoRefugoKg != null) {
			producaoRefugoKgFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoRefugoKg, 4);
		}
	}
	
	public BigDecimal getG(){
		if(producaoRefugoKg == null){
			return BigDecimal.ZERO;
		}
		return producaoRefugoKg;
	}
	
	public void setHFormatandoCampoFilho(BigDecimal valor){
		producaoLiquidaPeca = valor;
		if (producaoLiquidaPeca != null) {
			producaoLiquidaPecaFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoLiquidaPeca, 0);
		}
	}
	
	public BigDecimal getH(){
		if(producaoLiquidaPeca == null){
			return BigDecimal.ZERO;
		}
		return producaoLiquidaPeca;
	}
	
	public void setIFormatandoCampoFilho(BigDecimal valor){
		producaoLiquidaKg = valor;
		if (producaoLiquidaKg != null) {
			producaoLiquidaKgFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoLiquidaKg, 4);
		}
	}
	
	public BigDecimal getI(){
		if(producaoLiquidaKg == null){
			return BigDecimal.ZERO;
		}
		return producaoLiquidaKg;
	}
	
	public void setJFormatandoCampoFilho(BigDecimal valor){
		producaoPCMPeca = valor;
		if (producaoPCMPeca != null) {
			producaoPCMPecaFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoPCMPeca, 4);
		}
	}
	
	public BigDecimal getJ(){
		if(producaoPCMPeca == null){
			return BigDecimal.ZERO;
		}
		return producaoPCMPeca;
	}
	
	public void setADFormatandoCampoFilho(BigDecimal valor){
		producaoPrevistaPeca = valor;
		if (producaoPrevistaPeca != null) {
			producaoPrevistaPecaFormatada = ConversaoTipos.converteParaStringUsandoVirgula(producaoPrevistaPeca, 4);
		}
	}
	
	public BigDecimal getAD(){
		if(producaoPrevistaPeca == null){
			return BigDecimal.ZERO;
		}
		return producaoPrevistaPeca;
	}
	
	public void setKFormatandoCampoFilho(BigDecimal valor){
		ciclosProdutivosHora = valor;
		if (ciclosProdutivosHora != null) {
			ciclosProdutivosHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(ciclosProdutivosHora, 2);
		}
	}
	
	public BigDecimal getK(){
		if(ciclosProdutivosHora == null){
			return BigDecimal.ZERO;
		}
		return ciclosProdutivosHora;
	}
	
	public void setLFormatandoCampoFilho(BigDecimal valor){
		ciclosImprodutivosHora = valor;
		if (ciclosImprodutivosHora != null) {
			ciclosImprodutivosHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(ciclosImprodutivosHora, 2);
		}
	}
	
	public BigDecimal getL(){
		if(ciclosImprodutivosHora == null){
			return BigDecimal.ZERO;
		}
		return ciclosImprodutivosHora;
	}
	
	public void setMFormatandoCampoFilho(BigDecimal valor){
		paradasHora = valor;
		if (paradasHora != null) {
			paradasHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(paradasHora, 2);
		}
	}
	
	public BigDecimal getM(){
		if(paradasHora == null){
			return BigDecimal.ZERO;
		}
		return paradasHora;
	}
	
	public void setNFormatandoCampoFilho(BigDecimal valor){
		naoDisponivelHora = valor;
		if (naoDisponivelHora != null) {
			naoDisponivelHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(naoDisponivelHora, 2);
		}
	}
	
	public BigDecimal getN(){
		if(naoDisponivelHora == null){
			return BigDecimal.ZERO;
		}
		return naoDisponivelHora;
	}
	
	public void setAEFormatandoCampoFilho(BigDecimal valor){
		disponivelHora = valor;
		if (disponivelHora != null) {
			disponivelHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(disponivelHora, 4);
		}
	}
	
	public BigDecimal getAE(){
		if(disponivelHora == null){
			return BigDecimal.ZERO;
		}
		return disponivelHora;
	}
	
	public void setAFFormatandoCampoFilho(BigDecimal valor){
		totaisHora = valor;
		if (totaisHora != null) {
			totaisHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(totaisHora, 4);
		}
	}
	
	public BigDecimal getAF(){
		if(totaisHora == null){
			return BigDecimal.ZERO;
		}
		return totaisHora;
	}
	
	public void setOFormatandoCampoFilho(BigDecimal valor){
		trabalhadasHora = valor;
		if (trabalhadasHora != null) {
			trabalhadasHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(trabalhadasHora, 4);
		}
	}
	
	public BigDecimal getO(){
		if(trabalhadasHora == null){
			return BigDecimal.ZERO;
		}
		return trabalhadasHora;
	}
	
	public void setPFormatandoCampoFilho(BigDecimal valor){
		refugosHora = valor;
		if (refugosHora != null) {
			refugosHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(refugosHora, 2);
		}
	}
	
	public BigDecimal getP(){
		if(refugosHora == null){
			return BigDecimal.ZERO;
		}
		return refugosHora;
	}
	
	public void setQFormatandoCampoFilho(BigDecimal valor){
		ritmoHora = valor;
		if (ritmoHora != null) {
			ritmoHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(ritmoHora, 2);
		}
	}
	
	public BigDecimal getQ(){
		if(ritmoHora == null){
			return BigDecimal.ZERO;
		}
		return ritmoHora;
	}
	
	public void setRFormatandoCampoFilho(BigDecimal valor){
		produtivasHora = valor;
		if (produtivasHora != null) {
			produtivasHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(produtivasHora, 4);
		}
	}
	
	public BigDecimal getR(){
		if(produtivasHora == null){
			return BigDecimal.ZERO;
		}
		return produtivasHora;
	}
	
	public void setANFormatandoCampoFilho(BigDecimal valor){
		pciHora = valor;
		if (pciHora != null) {
			pciHoraFormatada = ConversaoTipos.converteParaStringUsandoVirgula(pciHora, 2);
		}
	}
	
	public BigDecimal getAN(){
		if(pciHora == null){
			return BigDecimal.ZERO;
		}
		return pciHora;
	}
	
	public void setSFormatandoCampoFilho(BigDecimal valor){
		numeroDeSetup = valor;
		if (numeroDeSetup != null) {
			numeroDeSetupFormatada = ConversaoTipos.converteParaStringUsandoVirgula(numeroDeSetup, 0);
		}
	}
	
	public BigDecimal getS(){
		if(numeroDeSetup == null){
			return BigDecimal.ZERO;
		}
		return numeroDeSetup;
	}
	
	public void setTFormatandoCampoFilho(BigDecimal valor){
		duracaoSetupMinutos = valor;
		if (duracaoSetupMinutos != null) {
			duracaoSetupMinutosFormatada = ConversaoTipos.converteParaStringUsandoVirgula(duracaoSetupMinutos, 2);
		}
	}
	
	public BigDecimal getT(){
		if(duracaoSetupMinutos == null){
			return BigDecimal.ZERO;
		}
		return duracaoSetupMinutos;
	}
	
	public void setUFormatandoCampoFilho(BigDecimal valor){
		padraoMedioSetupMinutos = valor;
		if (padraoMedioSetupMinutos != null) {
			padraoMedioSetupMinutosFormatada = ConversaoTipos.converteParaStringUsandoVirgula(padraoMedioSetupMinutos, 2);
		}
	}
	
	public BigDecimal getU(){
		if(padraoMedioSetupMinutos == null){
			return BigDecimal.ZERO;
		}
		return padraoMedioSetupMinutos;
	}
	
	public void setVFormatandoCampoFilho(BigDecimal valor){
		eficienciaSetup = valor;
		if (eficienciaSetup != null) {
			eficienciaSetupFormatada = ConversaoTipos.converteParaStringUsandoVirgula(eficienciaSetup, 2);
		}
	}
	
	public BigDecimal getV(){
		if(eficienciaSetup == null){
			return BigDecimal.ZERO;
		}
		return eficienciaSetup;
	}
	
	public void setWFormatandoCampoFilho(BigDecimal valor){
		numeroDeTryOut = valor;
		if (numeroDeTryOut != null) {
			numeroDeTryOutFormatada = ConversaoTipos.converteParaStringUsandoVirgula(numeroDeTryOut, 2);
		}
	}
	
	public BigDecimal getW(){
		if(numeroDeTryOut == null){
			return BigDecimal.ZERO;
		}
		return numeroDeTryOut;
	}
	
	public void setXFormatandoCampoFilho(BigDecimal valor){
		tempoMedioTryOut = valor;
		if (tempoMedioTryOut != null) {
			tempoMedioTryOutMinutosFormatada = ConversaoTipos.converteParaStringUsandoVirgula(tempoMedioTryOut, 2);
		}
	}
	
	public BigDecimal getX(){
		if(tempoMedioTryOut == null){
			return BigDecimal.ZERO;
		}
		return tempoMedioTryOut;
	}
	
	public void setYFormatandoCampoFilho(BigDecimal valor){
		atendimento = valor;
		if (atendimento != null) {
			atendimentoFormatada = ConversaoTipos.converteParaStringUsandoVirgula(atendimento, 2);
		}
	}
	
	public BigDecimal getY(){
		if(atendimento == null){
			return BigDecimal.ZERO;
		}
		return atendimento;
	}
	
	public void setZFormatandoCampoFilho(BigDecimal valor){
		utilizacao = valor;
		if (utilizacao != null) {
			utilizacaoFormatada = ConversaoTipos.converteParaStringUsandoVirgula(utilizacao, 2);
		}
	}
	
	public BigDecimal getZ(){
		if(utilizacao == null){
			return BigDecimal.ZERO;
		}
		return utilizacao;
	}
	
	public void setAAFormatandoCampoFilho(BigDecimal valor){
		eficiencia = valor;
		if (eficiencia != null) {
			eficienciaFormatada = ConversaoTipos.converteParaStringUsandoVirgula(eficiencia, 2);
		}
	}
	
	public BigDecimal getAA(){
		if(eficiencia == null){
			return BigDecimal.ZERO;
		}
		return eficiencia;
	}
	
	public void setABFormatandoCampoFilho(BigDecimal valor){
		produtividade = valor;
		if (produtividade != null) {
			produtividadeFormatada = ConversaoTipos.converteParaStringUsandoVirgula(produtividade, 2);
		}
	}
	
	public BigDecimal getAB(){
		if(produtividade == null){
			return BigDecimal.ZERO;
		}
		return produtividade;
	}
	
	public void setAGFormatandoCampoFilho(BigDecimal valor){
		produtividadeC = valor;
		if (produtividadeC != null) {
			produtividadeCFormatada = ConversaoTipos.converteParaStringUsandoVirgula(produtividadeC, 2);
		}
	}
	
	public BigDecimal getAG(){
		if(produtividadeC == null){
			return BigDecimal.ZERO;
		}
		return produtividadeC;
	}
	
	public void setACFormatandoCampoFilho(BigDecimal valor){
		ppmil = valor;
		if (ppmil != null) {
			ppmilFormatada = ConversaoTipos.converteParaStringUsandoVirgula(ppmil, 2);
		}
	}
	
	public BigDecimal getAC(){
		if(ppmil == null){
			return BigDecimal.ZERO;
		}
		return ppmil;
	}
	
	
}
