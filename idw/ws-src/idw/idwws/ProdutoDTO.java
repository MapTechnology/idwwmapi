/**
 * ProdutoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ProdutoDTO  implements java.io.Serializable {
    private java.lang.Long aproduzir;

    private idw.idwws.DwCal calendario;

    private java.lang.Double cicloMedio;

    private java.lang.Double cicloPadrao;

    private java.lang.String dsTurno;

    private java.util.Calendar dtReferencia;

    private java.util.Calendar dtRevisaoFolha;

    private int ERRO_AGRUPADOR_DESCONHECIDO;

    private int ERRO_CC_DESCONHECIDO;

    private int ERRO_CDPRODUTO_INVALIDO;

    private int ERRO_CLIENTE_DESCONHECIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_FOR_DESCONHECIDO;

    private int ERRO_GRUPOPRODUTO_DESCONHECIDO;

    private int ERRO_INTEGRACAO_JA_REALIZADA;

    private int ERRO_ITEM_DENTRO_DE_SEU_SUBITEM;

    private int ERRO_PRODUTO_JA_EXISTE;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_TIPOPRODUTO_VAZIO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private java.lang.Double eficiencia;

    private java.math.BigDecimal estoqueProducao;

    private idw.idwws.OmPt maquina;

    private java.lang.Long metaInstantanea;

    private idw.idwws.PpCp ordemproducao;

    private java.lang.Long pcsProducaoRefugada;

    private java.lang.Long pcsProducaobruta;

    private java.lang.Long pcsProducaoliquida;

    private idw.idwws.OmProduto produto;

    private java.math.BigDecimal qtdAtiva;

    private int resultadoEvento;

    private java.math.BigDecimal tempoAtivo;

    private java.lang.Double ultimoCiclo;

    public ProdutoDTO() {
    }

    public ProdutoDTO(
           java.lang.Long aproduzir,
           idw.idwws.DwCal calendario,
           java.lang.Double cicloMedio,
           java.lang.Double cicloPadrao,
           java.lang.String dsTurno,
           java.util.Calendar dtReferencia,
           java.util.Calendar dtRevisaoFolha,
           int ERRO_AGRUPADOR_DESCONHECIDO,
           int ERRO_CC_DESCONHECIDO,
           int ERRO_CDPRODUTO_INVALIDO,
           int ERRO_CLIENTE_DESCONHECIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_FOR_DESCONHECIDO,
           int ERRO_GRUPOPRODUTO_DESCONHECIDO,
           int ERRO_INTEGRACAO_JA_REALIZADA,
           int ERRO_ITEM_DENTRO_DE_SEU_SUBITEM,
           int ERRO_PRODUTO_JA_EXISTE,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_TIPOPRODUTO_VAZIO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           java.lang.Double eficiencia,
           java.math.BigDecimal estoqueProducao,
           idw.idwws.OmPt maquina,
           java.lang.Long metaInstantanea,
           idw.idwws.PpCp ordemproducao,
           java.lang.Long pcsProducaoRefugada,
           java.lang.Long pcsProducaobruta,
           java.lang.Long pcsProducaoliquida,
           idw.idwws.OmProduto produto,
           java.math.BigDecimal qtdAtiva,
           int resultadoEvento,
           java.math.BigDecimal tempoAtivo,
           java.lang.Double ultimoCiclo) {
           this.aproduzir = aproduzir;
           this.calendario = calendario;
           this.cicloMedio = cicloMedio;
           this.cicloPadrao = cicloPadrao;
           this.dsTurno = dsTurno;
           this.dtReferencia = dtReferencia;
           this.dtRevisaoFolha = dtRevisaoFolha;
           this.ERRO_AGRUPADOR_DESCONHECIDO = ERRO_AGRUPADOR_DESCONHECIDO;
           this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
           this.ERRO_CDPRODUTO_INVALIDO = ERRO_CDPRODUTO_INVALIDO;
           this.ERRO_CLIENTE_DESCONHECIDO = ERRO_CLIENTE_DESCONHECIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_FOR_DESCONHECIDO = ERRO_FOR_DESCONHECIDO;
           this.ERRO_GRUPOPRODUTO_DESCONHECIDO = ERRO_GRUPOPRODUTO_DESCONHECIDO;
           this.ERRO_INTEGRACAO_JA_REALIZADA = ERRO_INTEGRACAO_JA_REALIZADA;
           this.ERRO_ITEM_DENTRO_DE_SEU_SUBITEM = ERRO_ITEM_DENTRO_DE_SEU_SUBITEM;
           this.ERRO_PRODUTO_JA_EXISTE = ERRO_PRODUTO_JA_EXISTE;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_TIPOPRODUTO_VAZIO = ERRO_TIPOPRODUTO_VAZIO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.eficiencia = eficiencia;
           this.estoqueProducao = estoqueProducao;
           this.maquina = maquina;
           this.metaInstantanea = metaInstantanea;
           this.ordemproducao = ordemproducao;
           this.pcsProducaoRefugada = pcsProducaoRefugada;
           this.pcsProducaobruta = pcsProducaobruta;
           this.pcsProducaoliquida = pcsProducaoliquida;
           this.produto = produto;
           this.qtdAtiva = qtdAtiva;
           this.resultadoEvento = resultadoEvento;
           this.tempoAtivo = tempoAtivo;
           this.ultimoCiclo = ultimoCiclo;
    }


    /**
     * Gets the aproduzir value for this ProdutoDTO.
     * 
     * @return aproduzir
     */
    public java.lang.Long getAproduzir() {
        return aproduzir;
    }


    /**
     * Sets the aproduzir value for this ProdutoDTO.
     * 
     * @param aproduzir
     */
    public void setAproduzir(java.lang.Long aproduzir) {
        this.aproduzir = aproduzir;
    }


    /**
     * Gets the calendario value for this ProdutoDTO.
     * 
     * @return calendario
     */
    public idw.idwws.DwCal getCalendario() {
        return calendario;
    }


    /**
     * Sets the calendario value for this ProdutoDTO.
     * 
     * @param calendario
     */
    public void setCalendario(idw.idwws.DwCal calendario) {
        this.calendario = calendario;
    }


    /**
     * Gets the cicloMedio value for this ProdutoDTO.
     * 
     * @return cicloMedio
     */
    public java.lang.Double getCicloMedio() {
        return cicloMedio;
    }


    /**
     * Sets the cicloMedio value for this ProdutoDTO.
     * 
     * @param cicloMedio
     */
    public void setCicloMedio(java.lang.Double cicloMedio) {
        this.cicloMedio = cicloMedio;
    }


    /**
     * Gets the cicloPadrao value for this ProdutoDTO.
     * 
     * @return cicloPadrao
     */
    public java.lang.Double getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this ProdutoDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.lang.Double cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the dsTurno value for this ProdutoDTO.
     * 
     * @return dsTurno
     */
    public java.lang.String getDsTurno() {
        return dsTurno;
    }


    /**
     * Sets the dsTurno value for this ProdutoDTO.
     * 
     * @param dsTurno
     */
    public void setDsTurno(java.lang.String dsTurno) {
        this.dsTurno = dsTurno;
    }


    /**
     * Gets the dtReferencia value for this ProdutoDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this ProdutoDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dtRevisaoFolha value for this ProdutoDTO.
     * 
     * @return dtRevisaoFolha
     */
    public java.util.Calendar getDtRevisaoFolha() {
        return dtRevisaoFolha;
    }


    /**
     * Sets the dtRevisaoFolha value for this ProdutoDTO.
     * 
     * @param dtRevisaoFolha
     */
    public void setDtRevisaoFolha(java.util.Calendar dtRevisaoFolha) {
        this.dtRevisaoFolha = dtRevisaoFolha;
    }


    /**
     * Gets the ERRO_AGRUPADOR_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_AGRUPADOR_DESCONHECIDO
     */
    public int getERRO_AGRUPADOR_DESCONHECIDO() {
        return ERRO_AGRUPADOR_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_AGRUPADOR_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_AGRUPADOR_DESCONHECIDO
     */
    public void setERRO_AGRUPADOR_DESCONHECIDO(int ERRO_AGRUPADOR_DESCONHECIDO) {
        this.ERRO_AGRUPADOR_DESCONHECIDO = ERRO_AGRUPADOR_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CC_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_CC_DESCONHECIDO
     */
    public int getERRO_CC_DESCONHECIDO() {
        return ERRO_CC_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CC_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_CC_DESCONHECIDO
     */
    public void setERRO_CC_DESCONHECIDO(int ERRO_CC_DESCONHECIDO) {
        this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CDPRODUTO_INVALIDO value for this ProdutoDTO.
     * 
     * @return ERRO_CDPRODUTO_INVALIDO
     */
    public int getERRO_CDPRODUTO_INVALIDO() {
        return ERRO_CDPRODUTO_INVALIDO;
    }


    /**
     * Sets the ERRO_CDPRODUTO_INVALIDO value for this ProdutoDTO.
     * 
     * @param ERRO_CDPRODUTO_INVALIDO
     */
    public void setERRO_CDPRODUTO_INVALIDO(int ERRO_CDPRODUTO_INVALIDO) {
        this.ERRO_CDPRODUTO_INVALIDO = ERRO_CDPRODUTO_INVALIDO;
    }


    /**
     * Gets the ERRO_CLIENTE_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_CLIENTE_DESCONHECIDO
     */
    public int getERRO_CLIENTE_DESCONHECIDO() {
        return ERRO_CLIENTE_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CLIENTE_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_CLIENTE_DESCONHECIDO
     */
    public void setERRO_CLIENTE_DESCONHECIDO(int ERRO_CLIENTE_DESCONHECIDO) {
        this.ERRO_CLIENTE_DESCONHECIDO = ERRO_CLIENTE_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_FOR_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_FOR_DESCONHECIDO
     */
    public int getERRO_FOR_DESCONHECIDO() {
        return ERRO_FOR_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_FOR_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_FOR_DESCONHECIDO
     */
    public void setERRO_FOR_DESCONHECIDO(int ERRO_FOR_DESCONHECIDO) {
        this.ERRO_FOR_DESCONHECIDO = ERRO_FOR_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_GRUPOPRODUTO_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_GRUPOPRODUTO_DESCONHECIDO
     */
    public int getERRO_GRUPOPRODUTO_DESCONHECIDO() {
        return ERRO_GRUPOPRODUTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_GRUPOPRODUTO_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_GRUPOPRODUTO_DESCONHECIDO
     */
    public void setERRO_GRUPOPRODUTO_DESCONHECIDO(int ERRO_GRUPOPRODUTO_DESCONHECIDO) {
        this.ERRO_GRUPOPRODUTO_DESCONHECIDO = ERRO_GRUPOPRODUTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_INTEGRACAO_JA_REALIZADA value for this ProdutoDTO.
     * 
     * @return ERRO_INTEGRACAO_JA_REALIZADA
     */
    public int getERRO_INTEGRACAO_JA_REALIZADA() {
        return ERRO_INTEGRACAO_JA_REALIZADA;
    }


    /**
     * Sets the ERRO_INTEGRACAO_JA_REALIZADA value for this ProdutoDTO.
     * 
     * @param ERRO_INTEGRACAO_JA_REALIZADA
     */
    public void setERRO_INTEGRACAO_JA_REALIZADA(int ERRO_INTEGRACAO_JA_REALIZADA) {
        this.ERRO_INTEGRACAO_JA_REALIZADA = ERRO_INTEGRACAO_JA_REALIZADA;
    }


    /**
     * Gets the ERRO_ITEM_DENTRO_DE_SEU_SUBITEM value for this ProdutoDTO.
     * 
     * @return ERRO_ITEM_DENTRO_DE_SEU_SUBITEM
     */
    public int getERRO_ITEM_DENTRO_DE_SEU_SUBITEM() {
        return ERRO_ITEM_DENTRO_DE_SEU_SUBITEM;
    }


    /**
     * Sets the ERRO_ITEM_DENTRO_DE_SEU_SUBITEM value for this ProdutoDTO.
     * 
     * @param ERRO_ITEM_DENTRO_DE_SEU_SUBITEM
     */
    public void setERRO_ITEM_DENTRO_DE_SEU_SUBITEM(int ERRO_ITEM_DENTRO_DE_SEU_SUBITEM) {
        this.ERRO_ITEM_DENTRO_DE_SEU_SUBITEM = ERRO_ITEM_DENTRO_DE_SEU_SUBITEM;
    }


    /**
     * Gets the ERRO_PRODUTO_JA_EXISTE value for this ProdutoDTO.
     * 
     * @return ERRO_PRODUTO_JA_EXISTE
     */
    public int getERRO_PRODUTO_JA_EXISTE() {
        return ERRO_PRODUTO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_PRODUTO_JA_EXISTE value for this ProdutoDTO.
     * 
     * @param ERRO_PRODUTO_JA_EXISTE
     */
    public void setERRO_PRODUTO_JA_EXISTE(int ERRO_PRODUTO_JA_EXISTE) {
        this.ERRO_PRODUTO_JA_EXISTE = ERRO_PRODUTO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this ProdutoDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this ProdutoDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_TIPOPRODUTO_VAZIO value for this ProdutoDTO.
     * 
     * @return ERRO_TIPOPRODUTO_VAZIO
     */
    public int getERRO_TIPOPRODUTO_VAZIO() {
        return ERRO_TIPOPRODUTO_VAZIO;
    }


    /**
     * Sets the ERRO_TIPOPRODUTO_VAZIO value for this ProdutoDTO.
     * 
     * @param ERRO_TIPOPRODUTO_VAZIO
     */
    public void setERRO_TIPOPRODUTO_VAZIO(int ERRO_TIPOPRODUTO_VAZIO) {
        this.ERRO_TIPOPRODUTO_VAZIO = ERRO_TIPOPRODUTO_VAZIO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this ProdutoDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this ProdutoDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this ProdutoDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the eficiencia value for this ProdutoDTO.
     * 
     * @return eficiencia
     */
    public java.lang.Double getEficiencia() {
        return eficiencia;
    }


    /**
     * Sets the eficiencia value for this ProdutoDTO.
     * 
     * @param eficiencia
     */
    public void setEficiencia(java.lang.Double eficiencia) {
        this.eficiencia = eficiencia;
    }


    /**
     * Gets the estoqueProducao value for this ProdutoDTO.
     * 
     * @return estoqueProducao
     */
    public java.math.BigDecimal getEstoqueProducao() {
        return estoqueProducao;
    }


    /**
     * Sets the estoqueProducao value for this ProdutoDTO.
     * 
     * @param estoqueProducao
     */
    public void setEstoqueProducao(java.math.BigDecimal estoqueProducao) {
        this.estoqueProducao = estoqueProducao;
    }


    /**
     * Gets the maquina value for this ProdutoDTO.
     * 
     * @return maquina
     */
    public idw.idwws.OmPt getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this ProdutoDTO.
     * 
     * @param maquina
     */
    public void setMaquina(idw.idwws.OmPt maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the metaInstantanea value for this ProdutoDTO.
     * 
     * @return metaInstantanea
     */
    public java.lang.Long getMetaInstantanea() {
        return metaInstantanea;
    }


    /**
     * Sets the metaInstantanea value for this ProdutoDTO.
     * 
     * @param metaInstantanea
     */
    public void setMetaInstantanea(java.lang.Long metaInstantanea) {
        this.metaInstantanea = metaInstantanea;
    }


    /**
     * Gets the ordemproducao value for this ProdutoDTO.
     * 
     * @return ordemproducao
     */
    public idw.idwws.PpCp getOrdemproducao() {
        return ordemproducao;
    }


    /**
     * Sets the ordemproducao value for this ProdutoDTO.
     * 
     * @param ordemproducao
     */
    public void setOrdemproducao(idw.idwws.PpCp ordemproducao) {
        this.ordemproducao = ordemproducao;
    }


    /**
     * Gets the pcsProducaoRefugada value for this ProdutoDTO.
     * 
     * @return pcsProducaoRefugada
     */
    public java.lang.Long getPcsProducaoRefugada() {
        return pcsProducaoRefugada;
    }


    /**
     * Sets the pcsProducaoRefugada value for this ProdutoDTO.
     * 
     * @param pcsProducaoRefugada
     */
    public void setPcsProducaoRefugada(java.lang.Long pcsProducaoRefugada) {
        this.pcsProducaoRefugada = pcsProducaoRefugada;
    }


    /**
     * Gets the pcsProducaobruta value for this ProdutoDTO.
     * 
     * @return pcsProducaobruta
     */
    public java.lang.Long getPcsProducaobruta() {
        return pcsProducaobruta;
    }


    /**
     * Sets the pcsProducaobruta value for this ProdutoDTO.
     * 
     * @param pcsProducaobruta
     */
    public void setPcsProducaobruta(java.lang.Long pcsProducaobruta) {
        this.pcsProducaobruta = pcsProducaobruta;
    }


    /**
     * Gets the pcsProducaoliquida value for this ProdutoDTO.
     * 
     * @return pcsProducaoliquida
     */
    public java.lang.Long getPcsProducaoliquida() {
        return pcsProducaoliquida;
    }


    /**
     * Sets the pcsProducaoliquida value for this ProdutoDTO.
     * 
     * @param pcsProducaoliquida
     */
    public void setPcsProducaoliquida(java.lang.Long pcsProducaoliquida) {
        this.pcsProducaoliquida = pcsProducaoliquida;
    }


    /**
     * Gets the produto value for this ProdutoDTO.
     * 
     * @return produto
     */
    public idw.idwws.OmProduto getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this ProdutoDTO.
     * 
     * @param produto
     */
    public void setProduto(idw.idwws.OmProduto produto) {
        this.produto = produto;
    }


    /**
     * Gets the qtdAtiva value for this ProdutoDTO.
     * 
     * @return qtdAtiva
     */
    public java.math.BigDecimal getQtdAtiva() {
        return qtdAtiva;
    }


    /**
     * Sets the qtdAtiva value for this ProdutoDTO.
     * 
     * @param qtdAtiva
     */
    public void setQtdAtiva(java.math.BigDecimal qtdAtiva) {
        this.qtdAtiva = qtdAtiva;
    }


    /**
     * Gets the resultadoEvento value for this ProdutoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this ProdutoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the tempoAtivo value for this ProdutoDTO.
     * 
     * @return tempoAtivo
     */
    public java.math.BigDecimal getTempoAtivo() {
        return tempoAtivo;
    }


    /**
     * Sets the tempoAtivo value for this ProdutoDTO.
     * 
     * @param tempoAtivo
     */
    public void setTempoAtivo(java.math.BigDecimal tempoAtivo) {
        this.tempoAtivo = tempoAtivo;
    }


    /**
     * Gets the ultimoCiclo value for this ProdutoDTO.
     * 
     * @return ultimoCiclo
     */
    public java.lang.Double getUltimoCiclo() {
        return ultimoCiclo;
    }


    /**
     * Sets the ultimoCiclo value for this ProdutoDTO.
     * 
     * @param ultimoCiclo
     */
    public void setUltimoCiclo(java.lang.Double ultimoCiclo) {
        this.ultimoCiclo = ultimoCiclo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProdutoDTO)) return false;
        ProdutoDTO other = (ProdutoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aproduzir==null && other.getAproduzir()==null) || 
             (this.aproduzir!=null &&
              this.aproduzir.equals(other.getAproduzir()))) &&
            ((this.calendario==null && other.getCalendario()==null) || 
             (this.calendario!=null &&
              this.calendario.equals(other.getCalendario()))) &&
            ((this.cicloMedio==null && other.getCicloMedio()==null) || 
             (this.cicloMedio!=null &&
              this.cicloMedio.equals(other.getCicloMedio()))) &&
            ((this.cicloPadrao==null && other.getCicloPadrao()==null) || 
             (this.cicloPadrao!=null &&
              this.cicloPadrao.equals(other.getCicloPadrao()))) &&
            ((this.dsTurno==null && other.getDsTurno()==null) || 
             (this.dsTurno!=null &&
              this.dsTurno.equals(other.getDsTurno()))) &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dtRevisaoFolha==null && other.getDtRevisaoFolha()==null) || 
             (this.dtRevisaoFolha!=null &&
              this.dtRevisaoFolha.equals(other.getDtRevisaoFolha()))) &&
            this.ERRO_AGRUPADOR_DESCONHECIDO == other.getERRO_AGRUPADOR_DESCONHECIDO() &&
            this.ERRO_CC_DESCONHECIDO == other.getERRO_CC_DESCONHECIDO() &&
            this.ERRO_CDPRODUTO_INVALIDO == other.getERRO_CDPRODUTO_INVALIDO() &&
            this.ERRO_CLIENTE_DESCONHECIDO == other.getERRO_CLIENTE_DESCONHECIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_FOR_DESCONHECIDO == other.getERRO_FOR_DESCONHECIDO() &&
            this.ERRO_GRUPOPRODUTO_DESCONHECIDO == other.getERRO_GRUPOPRODUTO_DESCONHECIDO() &&
            this.ERRO_INTEGRACAO_JA_REALIZADA == other.getERRO_INTEGRACAO_JA_REALIZADA() &&
            this.ERRO_ITEM_DENTRO_DE_SEU_SUBITEM == other.getERRO_ITEM_DENTRO_DE_SEU_SUBITEM() &&
            this.ERRO_PRODUTO_JA_EXISTE == other.getERRO_PRODUTO_JA_EXISTE() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_TIPOPRODUTO_VAZIO == other.getERRO_TIPOPRODUTO_VAZIO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.eficiencia==null && other.getEficiencia()==null) || 
             (this.eficiencia!=null &&
              this.eficiencia.equals(other.getEficiencia()))) &&
            ((this.estoqueProducao==null && other.getEstoqueProducao()==null) || 
             (this.estoqueProducao!=null &&
              this.estoqueProducao.equals(other.getEstoqueProducao()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            ((this.metaInstantanea==null && other.getMetaInstantanea()==null) || 
             (this.metaInstantanea!=null &&
              this.metaInstantanea.equals(other.getMetaInstantanea()))) &&
            ((this.ordemproducao==null && other.getOrdemproducao()==null) || 
             (this.ordemproducao!=null &&
              this.ordemproducao.equals(other.getOrdemproducao()))) &&
            ((this.pcsProducaoRefugada==null && other.getPcsProducaoRefugada()==null) || 
             (this.pcsProducaoRefugada!=null &&
              this.pcsProducaoRefugada.equals(other.getPcsProducaoRefugada()))) &&
            ((this.pcsProducaobruta==null && other.getPcsProducaobruta()==null) || 
             (this.pcsProducaobruta!=null &&
              this.pcsProducaobruta.equals(other.getPcsProducaobruta()))) &&
            ((this.pcsProducaoliquida==null && other.getPcsProducaoliquida()==null) || 
             (this.pcsProducaoliquida!=null &&
              this.pcsProducaoliquida.equals(other.getPcsProducaoliquida()))) &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            ((this.qtdAtiva==null && other.getQtdAtiva()==null) || 
             (this.qtdAtiva!=null &&
              this.qtdAtiva.equals(other.getQtdAtiva()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.tempoAtivo==null && other.getTempoAtivo()==null) || 
             (this.tempoAtivo!=null &&
              this.tempoAtivo.equals(other.getTempoAtivo()))) &&
            ((this.ultimoCiclo==null && other.getUltimoCiclo()==null) || 
             (this.ultimoCiclo!=null &&
              this.ultimoCiclo.equals(other.getUltimoCiclo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAproduzir() != null) {
            _hashCode += getAproduzir().hashCode();
        }
        if (getCalendario() != null) {
            _hashCode += getCalendario().hashCode();
        }
        if (getCicloMedio() != null) {
            _hashCode += getCicloMedio().hashCode();
        }
        if (getCicloPadrao() != null) {
            _hashCode += getCicloPadrao().hashCode();
        }
        if (getDsTurno() != null) {
            _hashCode += getDsTurno().hashCode();
        }
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDtRevisaoFolha() != null) {
            _hashCode += getDtRevisaoFolha().hashCode();
        }
        _hashCode += getERRO_AGRUPADOR_DESCONHECIDO();
        _hashCode += getERRO_CC_DESCONHECIDO();
        _hashCode += getERRO_CDPRODUTO_INVALIDO();
        _hashCode += getERRO_CLIENTE_DESCONHECIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_FOR_DESCONHECIDO();
        _hashCode += getERRO_GRUPOPRODUTO_DESCONHECIDO();
        _hashCode += getERRO_INTEGRACAO_JA_REALIZADA();
        _hashCode += getERRO_ITEM_DENTRO_DE_SEU_SUBITEM();
        _hashCode += getERRO_PRODUTO_JA_EXISTE();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_TIPOPRODUTO_VAZIO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getEficiencia() != null) {
            _hashCode += getEficiencia().hashCode();
        }
        if (getEstoqueProducao() != null) {
            _hashCode += getEstoqueProducao().hashCode();
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        if (getMetaInstantanea() != null) {
            _hashCode += getMetaInstantanea().hashCode();
        }
        if (getOrdemproducao() != null) {
            _hashCode += getOrdemproducao().hashCode();
        }
        if (getPcsProducaoRefugada() != null) {
            _hashCode += getPcsProducaoRefugada().hashCode();
        }
        if (getPcsProducaobruta() != null) {
            _hashCode += getPcsProducaobruta().hashCode();
        }
        if (getPcsProducaoliquida() != null) {
            _hashCode += getPcsProducaoliquida().hashCode();
        }
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        if (getQtdAtiva() != null) {
            _hashCode += getQtdAtiva().hashCode();
        }
        _hashCode += getResultadoEvento();
        if (getTempoAtivo() != null) {
            _hashCode += getTempoAtivo().hashCode();
        }
        if (getUltimoCiclo() != null) {
            _hashCode += getUltimoCiclo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProdutoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aproduzir");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aproduzir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloMedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloMedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisaoFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisaoFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_AGRUPADOR_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_AGRUPADOR_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CC_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CC_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDPRODUTO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDPRODUTO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CLIENTE_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CLIENTE_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_FOR_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_FOR_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_GRUPOPRODUTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_GRUPOPRODUTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_INTEGRACAO_JA_REALIZADA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_INTEGRACAO_JA_REALIZADA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_ITEM_DENTRO_DE_SEU_SUBITEM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_ITEM_DENTRO_DE_SEU_SUBITEM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PRODUTO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PRODUTO_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_REATIVACAO_INDISPONIVEL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_REATIVACAO_INDISPONIVEL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPOPRODUTO_VAZIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPOPRODUTO_VAZIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_REVISAO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_REVISAO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_STATUS_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_STATUS_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficiencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficiencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estoqueProducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estoqueProducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaInstantanea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaInstantanea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaoRefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaoRefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaoliquida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaoliquida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdAtiva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdAtiva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimoCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
