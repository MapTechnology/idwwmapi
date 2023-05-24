package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwPepro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;


public class ProdutoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1586946824168878454L;

	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_PRODUTO_JA_EXISTE = 1;
	private int ERRO_CC_DESCONHECIDO = 2;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_CDPRODUTO_INVALIDO = 6;
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	private int ERRO_FOR_DESCONHECIDO = 8;
	private int ERRO_GRUPOPRODUTO_DESCONHECIDO = 9;
	private int ERRO_TIPOPRODUTO_VAZIO = 10;
	private int ERRO_AGRUPADOR_DESCONHECIDO = 11;
	private int ERRO_CLIENTE_DESCONHECIDO = 12;
	private int ERRO_ITEM_DENTRO_DE_SEU_SUBITEM = 13;
	private int ERRO_INTEGRACAO_JA_REALIZADA = 14;
	private int ERRO_SEM_CONFIGURACAO = 15;
	private int ERRO_SEMIACABADO_INVALIDO = 16;
	private int ERRO_PESOS_INVALIDOS = 17;
	private int ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL = 18;
	private int ERRO_NS_INVALIDO = 19;
	private int ERRO_MULTIPLO = 20;
	
	
	private String ERRO_COMPLEMENTO;
	
	private OmProduto produto;
	private String dsProduto;
	private OmPt maquina;
	private PpCp ordemproducao;
	private DwCal calendario;
	private DwPepro dwpepro;
	private BigDecimal pcsProducaoRefugada;
	private BigDecimal pcsProducaobruta;
	private BigDecimal pcsProducaoliquida;
	private BigDecimal metaInstantanea;
	private Double eficiencia;
	private BigDecimal aproduzir;
	private Double cicloPadrao;
	private Double cicloMedio;
	private Double ultimoCiclo;
	private Date dtRevisaoFolha;
	private String dtInicioProducao;
	private String dsTurno;
	private BigDecimal estoqueProducao;
	private BigDecimal qtdAtiva;
	private BigDecimal qtdTotal; // pcs por ciclo totais 
	private Date dtReferencia;
	private BigDecimal tempoAtivo;
	private BigDecimal pesoLiquido;
	private BigDecimal pesoBruto;
	
	public BigDecimal getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public String getDsTurno() {
		return dsTurno;
	}

	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}

	public BigDecimal getQtdAtiva() {
		return qtdAtiva;
	}

	public void setQtdAtiva(BigDecimal qtdAtiva) {
		this.qtdAtiva = qtdAtiva;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	public BigDecimal getTempoAtivo() {
		return tempoAtivo;
	}

	public void setTempoAtivo(BigDecimal tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}

	public BigDecimal getEstoqueProducao() {
		return estoqueProducao;
	}

	public void setEstoqueProducao(BigDecimal estoqueProducao) {
		this.estoqueProducao = estoqueProducao;
	}
	
	public Date getDtRevisaoFolha() {
		return dtRevisaoFolha;
	}

	public void setDtRevisaoFolha(Date dtRevisaoFolha) {
		this.dtRevisaoFolha = dtRevisaoFolha;
	}

	public String getDtInicioProducao() {
		return dtInicioProducao;
	}

	public void setDtInicioProducao(String dtInicioProducao) {
		this.dtInicioProducao = dtInicioProducao;
	}

	private int resultadoEvento;

    public Double getCicloPadrao() {    	
		return cicloPadrao;
	}

	public void setCicloPadrao(Double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	
    public Double getCicloMedio() {
		return cicloMedio;
	}

	public void setCicloMedio(Double cicloMedio) {
		this.cicloMedio = cicloMedio;
	}

	public Double getUltimoCiclo() {
		return ultimoCiclo;
	}

	public void setUltimoCiclo(Double ultimoCiclo) {
		this.ultimoCiclo = ultimoCiclo;
	}

	/**
     * @return the produto
     */
    public OmProduto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(OmProduto produto) {
        this.produto = produto;
    }

    /**
	 * @return the dsProduto
	 */
	public String getDsProduto() {
		return dsProduto;
	}

	/**
	 * @param dsProduto the dsProduto to set
	 */
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	/**
     * @return the resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }

    /**
     * @param resultadoEvento the resultadoEvento to set
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}

	public int getERRO_PRODUTO_JA_EXISTE() {
		return ERRO_PRODUTO_JA_EXISTE;
	}

	public void setERRO_PRODUTO_JA_EXISTE(int erro_produto_ja_existe) {
		ERRO_PRODUTO_JA_EXISTE = erro_produto_ja_existe;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int erro_desconhecido) {
		ERRO_DESCONHECIDO = erro_desconhecido;
	}

	public int getERRO_CC_DESCONHECIDO() {
		return ERRO_CC_DESCONHECIDO;
	}

	public void setERRO_CC_DESCONHECIDO(int erro_cc_desconhecido) {
		ERRO_CC_DESCONHECIDO = erro_cc_desconhecido;
	}

	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int erro_usuario_revisao_desconhecido) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = erro_usuario_revisao_desconhecido;
	}

	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int erro_usuario_status_desconhecido) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = erro_usuario_status_desconhecido;
	}

	public int getERRO_CDPRODUTO_INVALIDO() {
		return ERRO_CDPRODUTO_INVALIDO;
	}

	public void setERRO_CDPRODUTO_INVALIDO(int erro_cdproduto_invalido) {
		ERRO_CDPRODUTO_INVALIDO = erro_cdproduto_invalido;
	}

	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}

	public void setERRO_REATIVACAO_INDISPONIVEL(int erro_reativacao_indisponivel) {
		ERRO_REATIVACAO_INDISPONIVEL = erro_reativacao_indisponivel;
	}

	public int getERRO_FOR_DESCONHECIDO() {
		return ERRO_FOR_DESCONHECIDO;
	}

	public void setERRO_FOR_DESCONHECIDO(int erro_for_desconhecido) {
		ERRO_FOR_DESCONHECIDO = erro_for_desconhecido;
	}

	public int getERRO_GRUPOPRODUTO_DESCONHECIDO() {
		return ERRO_GRUPOPRODUTO_DESCONHECIDO;
	}

	public void setERRO_GRUPOPRODUTO_DESCONHECIDO(int eRROGRUPOPRODUTODESCONHECIDO) {
		ERRO_GRUPOPRODUTO_DESCONHECIDO = eRROGRUPOPRODUTODESCONHECIDO;
	}
    public int getERRO_TIPOPRODUTO_VAZIO() {
		return ERRO_TIPOPRODUTO_VAZIO;
	}

	public void setERRO_TIPOPRODUTO_VAZIO(int eRROTIPOPRODUTOVAZIO) {
		ERRO_TIPOPRODUTO_VAZIO = eRROTIPOPRODUTOVAZIO;
	}
	public int getERRO_AGRUPADOR_DESCONHECIDO() {
		return ERRO_AGRUPADOR_DESCONHECIDO;
	}

	public void setERRO_AGRUPADOR_DESCONHECIDO(int eRROAGRUPADORDESCONHECIDO) {
		ERRO_AGRUPADOR_DESCONHECIDO = eRROAGRUPADORDESCONHECIDO;
	}

	public int getERRO_CLIENTE_DESCONHECIDO() {
		return ERRO_CLIENTE_DESCONHECIDO;
	}

	public void setERRO_CLIENTE_DESCONHECIDO(int eRRO_CLIENTE_DESCONHECIDO) {
		ERRO_CLIENTE_DESCONHECIDO = eRRO_CLIENTE_DESCONHECIDO;
	}
	
	public int getERRO_ITEM_DENTRO_DE_SEU_SUBITEM() {
		return ERRO_ITEM_DENTRO_DE_SEU_SUBITEM;
	}

	public void setERRO_ITEM_DENTRO_DE_SEU_SUBITEM(
			int eRRO_ITEM_DENTRO_DE_SEU_SUBITEM) {
		ERRO_ITEM_DENTRO_DE_SEU_SUBITEM = eRRO_ITEM_DENTRO_DE_SEU_SUBITEM;
	}

	public int getERRO_INTEGRACAO_JA_REALIZADA() {
		return ERRO_INTEGRACAO_JA_REALIZADA;
	}

	public void setERRO_INTEGRACAO_JA_REALIZADA(
			int eRRO_INTEGRACAO_JA_REALIZADA) {
		ERRO_INTEGRACAO_JA_REALIZADA = eRRO_INTEGRACAO_JA_REALIZADA;
	}
	
	public int getERRO_SEM_CONFIGURACAO() {
		return ERRO_SEM_CONFIGURACAO;
	}

	public void setERRO_SEM_CONFIGURACAO(int eRRO_SEM_CONFIGURACAO) {
		ERRO_SEM_CONFIGURACAO = eRRO_SEM_CONFIGURACAO;
	}

	public int getERRO_SEMIACABADO_INVALIDO() {
		return ERRO_SEMIACABADO_INVALIDO;
	}

	public void setERRO_SEMIACABADO_INVALIDO(int eRRO_SEMIACABADO_INVALIDO) {
		ERRO_SEMIACABADO_INVALIDO = eRRO_SEMIACABADO_INVALIDO;
	}

	public int getERRO_PESOS_INVALIDOS() {
		return ERRO_PESOS_INVALIDOS;
	}

	public void setERRO_PESOS_INVALIDOS(int eRRO_PESOS_INVALIDOS) {
		ERRO_PESOS_INVALIDOS = eRRO_PESOS_INVALIDOS;
	}
	
	public BigDecimal getPcsProducaoRefugada() {
		return pcsProducaoRefugada;
	}

	public void setPcsProducaoRefugada(BigDecimal pcsProducaoRefugada) {
		this.pcsProducaoRefugada = pcsProducaoRefugada;
	}

	public BigDecimal getPcsProducaobruta() {
		return pcsProducaobruta;
	}

	public void setPcsProducaobruta(BigDecimal pcsProducaobruta) {
		this.pcsProducaobruta = pcsProducaobruta;
	}

	public void setMetaInstantanea(BigDecimal metaInstantanea) {
		this.metaInstantanea = metaInstantanea;
	}

	public BigDecimal getMetaInstantanea() {
		return metaInstantanea;
	}

	public void setEficiencia(Double eficiencia) {
		this.eficiencia = eficiencia;
	}

	public Double getEficiencia() {
		return eficiencia;
	}

	public void setAproduzir(BigDecimal aproduzir) {
		this.aproduzir = aproduzir;
	}

	public BigDecimal getAproduzir() {
		return aproduzir;
	}

	public OmPt getMaquina() {
		return maquina;
	}

	public void setMaquina(OmPt maquina) {
		this.maquina = maquina;
	}

	public PpCp getOrdemproducao() {
		return ordemproducao;
	}

	public void setOrdemproducao(PpCp ordemproducao) {
		this.ordemproducao = ordemproducao;
	}

	public DwCal getCalendario() {
		return calendario;
	}

	public void setCalendario(DwCal calendario) {
		this.calendario = calendario;
	}

	public BigDecimal getPcsProducaoliquida() {
		return pcsProducaoliquida;
	}

	public void setPcsProducaoliquida(BigDecimal pcsProducaoliquida) {
		this.pcsProducaoliquida = pcsProducaoliquida;
	}

	public BigDecimal getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(BigDecimal qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public String getERRO_COMPLEMENTO() {
		return ERRO_COMPLEMENTO;
	}

	public void setERRO_COMPLEMENTO(String eRRO_COMPLEMENTO) {
		ERRO_COMPLEMENTO = eRRO_COMPLEMENTO;
	}

	public DwPepro getDwpepro() {
		return dwpepro;
	}

	public void setDwpepro(DwPepro dwpepro) {
		this.dwpepro = dwpepro;
	}

	public int getERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL() {
		return ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL;
	}

	public void setERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL(
			int eRRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL) {
		ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL = eRRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL;
	}

	
	public String getDescricaoResultado(int valor) {
		String retorno = "";
		switch (valor) {
		case 0:
			retorno = "EVENTO_BEM_SUCEDIDO";
			break;
		case 1:
			retorno = "ERRO_PRODUTO_JA_EXISTE";
			break;
		case 2:
			retorno = "ERRO_CC_DESCONHECIDO";
			break;
		case 3:
			retorno = "ERRO_DESCONHECIDO";
			break;
		case 4:
			retorno = "ERRO_USUARIO_REVISAO_DESCONHECIDO";
			break;
		case 5:
			retorno = "ERRO_USUARIO_STATUS_DESCONHECIDO";
			break;
		case 6:
			retorno = "ERRO_CDPRODUTO_INVALIDO";
			break;
		case 7:
			retorno = "ERRO_REATIVACAO_INDISPONIVEL";
			break;
		case 8:
			retorno = "ERRO_FOR_DESCONHECIDO";
			break;
		case 9:
			retorno = "ERRO_GRUPOPRODUTO_DESCONHECIDO";
			break;
		case 10:
			retorno = "ERRO_TIPOPRODUTO_VAZIO";
			break;
		
		case 11:
			retorno = "ERRO_AGRUPADOR_DESCONHECIDO";
			break;
		
		case 12:
			retorno = "ERRO_CLIENTE_DESCONHECIDO";
			break;
			
		case 13:
			retorno = "ERRO_ITEM_DENTRO_DE_SEU_SUBITEM";
			break;
			
		case 14:
			retorno = "ERRO_INTEGRACAO_JA_REALIZADA";
			break;
			
		case 15:
			retorno = "ERRO_SEM_CONFIGURACAO";
			break;
			
		case 16:
			retorno = "ERRO_SEMIACABADO_INVALIDO";
			break;
			
		case 17:
			retorno = "ERRO_PESOS_INVALIDOS";
			break;
		case 18:
			retorno = "ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL";
			break;
		}
		return retorno;
	}

	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "ProdutoDTO [";
		
		retorno += "EVENTO_BEM_SUCEDIDO=" + EVENTO_BEM_SUCEDIDO + ", ERRO_PRODUTO_JA_EXISTE=" + ERRO_PRODUTO_JA_EXISTE + ", " +
				   "ERRO_CC_DESCONHECIDO=" + ERRO_CC_DESCONHECIDO + ", ERRO_DESCONHECIDO=" + ERRO_DESCONHECIDO + ", " +
				   "ERRO_USUARIO_REVISAO_DESCONHECIDO=" + ERRO_USUARIO_REVISAO_DESCONHECIDO + ", ERRO_USUARIO_STATUS_DESCONHECIDO=" + ERRO_USUARIO_STATUS_DESCONHECIDO + ", " +
				   "ERRO_CDPRODUTO_INVALIDO=" + ERRO_CDPRODUTO_INVALIDO + ", ERRO_REATIVACAO_INDISPONIVEL=" + ERRO_REATIVACAO_INDISPONIVEL + ", " +
				   "ERRO_FOR_DESCONHECIDO=" + ERRO_FOR_DESCONHECIDO + ", ERRO_GRUPOPRODUTO_DESCONHECIDO=" + ERRO_GRUPOPRODUTO_DESCONHECIDO + ", " +
				   "ERRO_TIPOPRODUTO_VAZIO=" + ERRO_TIPOPRODUTO_VAZIO + ", ERRO_AGRUPADOR_DESCONHECIDO=" + ERRO_AGRUPADOR_DESCONHECIDO + ", " +
				   "ERRO_CLIENTE_DESCONHECIDO=" + ERRO_CLIENTE_DESCONHECIDO + ", ERRO_ITEM_DENTRO_DE_SEU_SUBITEM=" + ERRO_ITEM_DENTRO_DE_SEU_SUBITEM + ", " +
				   "ERRO_INTEGRACAO_JA_REALIZADA=" + ERRO_INTEGRACAO_JA_REALIZADA + ", ERRO_SEM_CONFIGURACAO=" + ERRO_SEM_CONFIGURACAO + ", " +
				   "ERRO_SEMIACABADO_INVALIDO=" + ERRO_SEMIACABADO_INVALIDO + ", ERRO_PESOS_INVALIDOS=" + ERRO_PESOS_INVALIDOS + ", " +
				   "ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL=" + ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL + ", ERRO_COMPLEMENTO=" + ERRO_COMPLEMENTO + ", ";
		
		retorno += "produto=";

		if (this.produto != null) {
			retorno += this.produto.getCd() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "dsProduto=" + dsProduto + ", ";
		
		retorno += "maquina=";

		if (this.maquina != null) {
			retorno += this.maquina.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "ordemproducao=";

		if (this.ordemproducao != null) {
			retorno += this.ordemproducao.getNrop() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "calendario=";

		if (this.calendario != null) {
			retorno += this.calendario.getCd() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "dwpepro=";

		if (this.dwpepro != null) {
			retorno += this.dwpepro.getIdPepro()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "pcsProducaoRefugada=" + this.pcsProducaoRefugada + ", " +
				   "pcsProducaobruta=" + this.pcsProducaobruta + ", " +
				   "pcsProducaoliquida=" + this.pcsProducaoliquida + ", " +
				   "metaInstantanea=" + this.metaInstantanea + ", " +
				   "eficiencia=" + this.eficiencia + ", " +
				   "aproduzir=" + this.aproduzir + ", " +
				   "cicloPadrao=" + this.cicloPadrao + ", " +
				   "cicloMedio=" + this.cicloMedio + ", " +
				   "ultimoCiclo=" + this.ultimoCiclo + ", " +
				   "dtRevisaoFolha=" + this.dtRevisaoFolha + ", " +
				   "dtInicioProducao=" + this.dtInicioProducao + ", " +
				   "dsTurno=" + this.dsTurno + ", " +
				   "estoqueProducao=" + this.estoqueProducao + ", " +
				   "qtdAtiva=" + this.qtdAtiva + ", " +
				   "qtdTotal=" + this.qtdTotal + ", " +
				   "dtReferencia=" + this.dtReferencia + ", " +
				   "tempoAtivo=" + this.tempoAtivo + ", " +
				   "pesoLiquido=" + this.pesoLiquido + ", " +
				   "pesoBruto=" + this.pesoBruto + ", " +
				   "resultadoEvento=" + this.resultadoEvento + "]";
		
		return retorno;
		/*
		return "ProdutoDTO [EVENTO_BEM_SUCEDIDO=" + EVENTO_BEM_SUCEDIDO + ", ERRO_PRODUTO_JA_EXISTE=" + ERRO_PRODUTO_JA_EXISTE
				+ ", ERRO_CC_DESCONHECIDO=" + ERRO_CC_DESCONHECIDO + ", ERRO_DESCONHECIDO=" + ERRO_DESCONHECIDO
				+ ", ERRO_USUARIO_REVISAO_DESCONHECIDO=" + ERRO_USUARIO_REVISAO_DESCONHECIDO + ", ERRO_USUARIO_STATUS_DESCONHECIDO="
				+ ERRO_USUARIO_STATUS_DESCONHECIDO + ", ERRO_CDPRODUTO_INVALIDO=" + ERRO_CDPRODUTO_INVALIDO
				+ ", ERRO_REATIVACAO_INDISPONIVEL=" + ERRO_REATIVACAO_INDISPONIVEL + ", ERRO_FOR_DESCONHECIDO=" + ERRO_FOR_DESCONHECIDO
				+ ", ERRO_GRUPOPRODUTO_DESCONHECIDO=" + ERRO_GRUPOPRODUTO_DESCONHECIDO + ", ERRO_TIPOPRODUTO_VAZIO="
				+ ERRO_TIPOPRODUTO_VAZIO + ", ERRO_AGRUPADOR_DESCONHECIDO=" + ERRO_AGRUPADOR_DESCONHECIDO + ", ERRO_CLIENTE_DESCONHECIDO="
				+ ERRO_CLIENTE_DESCONHECIDO + ", ERRO_ITEM_DENTRO_DE_SEU_SUBITEM=" + ERRO_ITEM_DENTRO_DE_SEU_SUBITEM
				+ ", ERRO_INTEGRACAO_JA_REALIZADA=" + ERRO_INTEGRACAO_JA_REALIZADA + ", ERRO_SEM_CONFIGURACAO=" + ERRO_SEM_CONFIGURACAO
				+ ", ERRO_SEMIACABADO_INVALIDO=" + ERRO_SEMIACABADO_INVALIDO + ", ERRO_PESOS_INVALIDOS=" + ERRO_PESOS_INVALIDOS
				+ ", ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL=" + ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL + ", ERRO_COMPLEMENTO="
				+ ERRO_COMPLEMENTO + ", produto=" + produto + ", dsProduto=" + dsProduto + ", maquina=" + maquina + ", ordemproducao="
				+ ordemproducao + ", calendario=" + calendario + ", dwpepro=" + dwpepro + ", pcsProducaoRefugada=" + pcsProducaoRefugada
				+ ", pcsProducaobruta=" + pcsProducaobruta + ", pcsProducaoliquida=" + pcsProducaoliquida + ", metaInstantanea="
				+ metaInstantanea + ", eficiencia=" + eficiencia + ", aproduzir=" + aproduzir + ", cicloPadrao=" + cicloPadrao
				+ ", cicloMedio=" + cicloMedio + ", ultimoCiclo=" + ultimoCiclo + ", dtRevisaoFolha=" + dtRevisaoFolha
				+ ", dtInicioProducao=" + dtInicioProducao + ", dsTurno=" + dsTurno + ", estoqueProducao=" + estoqueProducao
				+ ", qtdAtiva=" + qtdAtiva + ", qtdTotal=" + qtdTotal + ", dtReferencia=" + dtReferencia + ", tempoAtivo=" + tempoAtivo
				+ ", pesoLiquido=" + pesoLiquido + ", pesoBruto=" + pesoBruto + ", resultadoEvento=" + resultadoEvento + "]";
		*/
	}

	public int getERRO_NS_INVALIDO() {
		return ERRO_NS_INVALIDO;
	}

	public void setERRO_NS_INVALIDO(int eRRO_NS_INVALIDO) {
		ERRO_NS_INVALIDO = eRRO_NS_INVALIDO;
	}

	public int getERRO_MULTIPLO() {
		return ERRO_MULTIPLO;
	}

	public void setERRO_MULTIPLO(int eRRO_MULTIPLO) {
		ERRO_MULTIPLO = eRRO_MULTIPLO;
	}

	
	
}