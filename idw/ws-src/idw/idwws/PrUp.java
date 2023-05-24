/**
 * PrUp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrUp  extends idw.idwws.PrUpTemplate  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdmaqestendido;

    private java.lang.String cdmaquina;

    private java.lang.String cdmolde;

    private java.lang.String cdmolestendido;

    private java.lang.String cdultimaparada;

    private java.lang.String cdultimorefugo;

    private java.lang.Double cfgdbc;

    private org.apache.axis.types.UnsignedShort cfginterrupcaociclo;

    private java.lang.Double cfgperctmpcicloinicializacao;

    private java.lang.Double cfgperctmpcicloparauto;

    private java.lang.Double cfgperctoleranciasinalciclo;

    private java.lang.Double cfgtamanhoumpacoteciclos;

    private java.lang.Long cfgtolertmpcicloparauto;

    private java.lang.String cfgtpsessaoproducao;

    private java.util.Calendar dthriniplanejada;

    private java.util.Calendar dthriniultimaparada;

    private java.util.Calendar dthrultimorefugo;

    private org.apache.axis.types.UnsignedShort idreduzidaproduto;

    private java.math.BigDecimal idup;

    private java.lang.String infoAdicional;

    private org.apache.axis.types.UnsignedShort isBloqueioParadaSemConexao;

    private org.apache.axis.types.UnsignedShort isOpSemColeta;

    private java.lang.Double msdthriniultimaparada;

    private java.lang.Double msdthrultimorefugo;

    private java.lang.String nrop;

    private java.lang.String nropestendido;

    private idw.idwws.PrColetorEventos[] prColetorEventoses;

    private idw.idwws.PrConexoesInjet prConexoesInjet;

    private idw.idwws.PrEventosBridgeCollecDb[] prEventosBridgeCollecDbs;

    private idw.idwws.PrSubColetor prSubColetor;

    private idw.idwws.PrUpAlertasEmAberto[] prUpAlertasEmAbertos;

    private idw.idwws.PrUpConfiguracoes[] prUpConfiguracoeses;

    private idw.idwws.PrUpLoginsEmAberto[] prUpLoginsEmAbertos;

    private idw.idwws.PrUpProdutoMatPrima[] prUpProdutoMatPrimas;

    private idw.idwws.PrUpProdutoValidacao[] prUpProdutoValidacaos;

    private idw.idwws.PrUpProduto[] prUpProdutos;

    private java.math.BigDecimal qtdciclosexecutados;

    private java.lang.Double qtdproducaoliquida;

    private java.lang.Double qtdrefugada;

    private java.lang.String staguardrespmasterbridgecldb;

    private org.apache.axis.types.UnsignedShort stalimintegdoal;

    private org.apache.axis.types.UnsignedShort stativa;

    private org.apache.axis.types.UnsignedShort stcicloemaberto;

    private org.apache.axis.types.UnsignedShort stintegdoal;

    private org.apache.axis.types.UnsignedShort stparadaemaberto;

    private org.apache.axis.types.UnsignedShort stvertelaintegdoal;

    private java.lang.Double tmpciclopadrao;

    private java.math.BigDecimal tpup;

    private java.lang.Double vleficultciclo;

    public PrUp() {
    }

    public PrUp(
           java.lang.Boolean isSemPrograma,
           java.lang.Boolean isEmRegulagem,
           java.lang.Boolean isParadaEmAberto,
           java.util.Calendar dthrUltimoHeartBeat,
           java.lang.Double msDthrUltimoHeartBeat,
           java.lang.Boolean isReiniciarUp,
           java.util.Calendar dthrReferenciaParaEventos,
           java.lang.Boolean deveLiparUsuarios,
           idw.idwws.IwsDadosCIPDTO dadosCIP,
           idw.idwws.IwsDadosBCDTO dadosBC,
           idw.idwws.IwsDadosApontamentoDTO dadosApontamento,
           java.lang.Boolean isLogoutNaViradaTurno,
           java.lang.Boolean isFechaParadaNaViradaTurno,
           java.lang.Boolean isAlertaProbQuali,
           java.lang.Boolean isInspecaoPendente,
           idw.idwws.IwsVariacaoRitmoDTO variacaoRitmoDTO,
           java.lang.Integer resultadoUltimaInspecao,
           java.lang.String isComApntSAP,
           java.lang.String statusApntSap,
           java.lang.String txtMessage,
           idw.idwws.IwsModDTO[] listaLoginsEmAberto,
           idw.idwws.IwsAlertaDTO[] listaAlertasEmAberto,
           idw.idwws.IwsAlertaDTO[] listaAlertasDiarioDeBordo,
           boolean isInjOuLiner,
           boolean isOPConcluida,
           java.lang.String cdestrutura,
           java.lang.String cdmaqestendido,
           java.lang.String cdmaquina,
           java.lang.String cdmolde,
           java.lang.String cdmolestendido,
           java.lang.String cdultimaparada,
           java.lang.String cdultimorefugo,
           java.lang.Double cfgdbc,
           org.apache.axis.types.UnsignedShort cfginterrupcaociclo,
           java.lang.Double cfgperctmpcicloinicializacao,
           java.lang.Double cfgperctmpcicloparauto,
           java.lang.Double cfgperctoleranciasinalciclo,
           java.lang.Double cfgtamanhoumpacoteciclos,
           java.lang.Long cfgtolertmpcicloparauto,
           java.lang.String cfgtpsessaoproducao,
           java.util.Calendar dthriniplanejada,
           java.util.Calendar dthriniultimaparada,
           java.util.Calendar dthrultimorefugo,
           org.apache.axis.types.UnsignedShort idreduzidaproduto,
           java.math.BigDecimal idup,
           java.lang.String infoAdicional,
           org.apache.axis.types.UnsignedShort isBloqueioParadaSemConexao,
           org.apache.axis.types.UnsignedShort isOpSemColeta,
           java.lang.Double msdthriniultimaparada,
           java.lang.Double msdthrultimorefugo,
           java.lang.String nrop,
           java.lang.String nropestendido,
           idw.idwws.PrColetorEventos[] prColetorEventoses,
           idw.idwws.PrConexoesInjet prConexoesInjet,
           idw.idwws.PrEventosBridgeCollecDb[] prEventosBridgeCollecDbs,
           idw.idwws.PrSubColetor prSubColetor,
           idw.idwws.PrUpAlertasEmAberto[] prUpAlertasEmAbertos,
           idw.idwws.PrUpConfiguracoes[] prUpConfiguracoeses,
           idw.idwws.PrUpLoginsEmAberto[] prUpLoginsEmAbertos,
           idw.idwws.PrUpProdutoMatPrima[] prUpProdutoMatPrimas,
           idw.idwws.PrUpProdutoValidacao[] prUpProdutoValidacaos,
           idw.idwws.PrUpProduto[] prUpProdutos,
           java.math.BigDecimal qtdciclosexecutados,
           java.lang.Double qtdproducaoliquida,
           java.lang.Double qtdrefugada,
           java.lang.String staguardrespmasterbridgecldb,
           org.apache.axis.types.UnsignedShort stalimintegdoal,
           org.apache.axis.types.UnsignedShort stativa,
           org.apache.axis.types.UnsignedShort stcicloemaberto,
           org.apache.axis.types.UnsignedShort stintegdoal,
           org.apache.axis.types.UnsignedShort stparadaemaberto,
           org.apache.axis.types.UnsignedShort stvertelaintegdoal,
           java.lang.Double tmpciclopadrao,
           java.math.BigDecimal tpup,
           java.lang.Double vleficultciclo) {
        super(
            isSemPrograma,
            isEmRegulagem,
            isParadaEmAberto,
            dthrUltimoHeartBeat,
            msDthrUltimoHeartBeat,
            isReiniciarUp,
            dthrReferenciaParaEventos,
            deveLiparUsuarios,
            dadosCIP,
            dadosBC,
            dadosApontamento,
            isLogoutNaViradaTurno,
            isFechaParadaNaViradaTurno,
            isAlertaProbQuali,
            isInspecaoPendente,
            variacaoRitmoDTO,
            resultadoUltimaInspecao,
            isComApntSAP,
            statusApntSap,
            txtMessage,
            listaLoginsEmAberto,
            listaAlertasEmAberto,
            listaAlertasDiarioDeBordo,
            isInjOuLiner,
            isOPConcluida);
        this.cdestrutura = cdestrutura;
        this.cdmaqestendido = cdmaqestendido;
        this.cdmaquina = cdmaquina;
        this.cdmolde = cdmolde;
        this.cdmolestendido = cdmolestendido;
        this.cdultimaparada = cdultimaparada;
        this.cdultimorefugo = cdultimorefugo;
        this.cfgdbc = cfgdbc;
        this.cfginterrupcaociclo = cfginterrupcaociclo;
        this.cfgperctmpcicloinicializacao = cfgperctmpcicloinicializacao;
        this.cfgperctmpcicloparauto = cfgperctmpcicloparauto;
        this.cfgperctoleranciasinalciclo = cfgperctoleranciasinalciclo;
        this.cfgtamanhoumpacoteciclos = cfgtamanhoumpacoteciclos;
        this.cfgtolertmpcicloparauto = cfgtolertmpcicloparauto;
        this.cfgtpsessaoproducao = cfgtpsessaoproducao;
        this.dthriniplanejada = dthriniplanejada;
        this.dthriniultimaparada = dthriniultimaparada;
        this.dthrultimorefugo = dthrultimorefugo;
        this.idreduzidaproduto = idreduzidaproduto;
        this.idup = idup;
        this.infoAdicional = infoAdicional;
        this.isBloqueioParadaSemConexao = isBloqueioParadaSemConexao;
        this.isOpSemColeta = isOpSemColeta;
        this.msdthriniultimaparada = msdthriniultimaparada;
        this.msdthrultimorefugo = msdthrultimorefugo;
        this.nrop = nrop;
        this.nropestendido = nropestendido;
        this.prColetorEventoses = prColetorEventoses;
        this.prConexoesInjet = prConexoesInjet;
        this.prEventosBridgeCollecDbs = prEventosBridgeCollecDbs;
        this.prSubColetor = prSubColetor;
        this.prUpAlertasEmAbertos = prUpAlertasEmAbertos;
        this.prUpConfiguracoeses = prUpConfiguracoeses;
        this.prUpLoginsEmAbertos = prUpLoginsEmAbertos;
        this.prUpProdutoMatPrimas = prUpProdutoMatPrimas;
        this.prUpProdutoValidacaos = prUpProdutoValidacaos;
        this.prUpProdutos = prUpProdutos;
        this.qtdciclosexecutados = qtdciclosexecutados;
        this.qtdproducaoliquida = qtdproducaoliquida;
        this.qtdrefugada = qtdrefugada;
        this.staguardrespmasterbridgecldb = staguardrespmasterbridgecldb;
        this.stalimintegdoal = stalimintegdoal;
        this.stativa = stativa;
        this.stcicloemaberto = stcicloemaberto;
        this.stintegdoal = stintegdoal;
        this.stparadaemaberto = stparadaemaberto;
        this.stvertelaintegdoal = stvertelaintegdoal;
        this.tmpciclopadrao = tmpciclopadrao;
        this.tpup = tpup;
        this.vleficultciclo = vleficultciclo;
    }


    /**
     * Gets the cdestrutura value for this PrUp.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this PrUp.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdmaqestendido value for this PrUp.
     * 
     * @return cdmaqestendido
     */
    public java.lang.String getCdmaqestendido() {
        return cdmaqestendido;
    }


    /**
     * Sets the cdmaqestendido value for this PrUp.
     * 
     * @param cdmaqestendido
     */
    public void setCdmaqestendido(java.lang.String cdmaqestendido) {
        this.cdmaqestendido = cdmaqestendido;
    }


    /**
     * Gets the cdmaquina value for this PrUp.
     * 
     * @return cdmaquina
     */
    public java.lang.String getCdmaquina() {
        return cdmaquina;
    }


    /**
     * Sets the cdmaquina value for this PrUp.
     * 
     * @param cdmaquina
     */
    public void setCdmaquina(java.lang.String cdmaquina) {
        this.cdmaquina = cdmaquina;
    }


    /**
     * Gets the cdmolde value for this PrUp.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this PrUp.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdmolestendido value for this PrUp.
     * 
     * @return cdmolestendido
     */
    public java.lang.String getCdmolestendido() {
        return cdmolestendido;
    }


    /**
     * Sets the cdmolestendido value for this PrUp.
     * 
     * @param cdmolestendido
     */
    public void setCdmolestendido(java.lang.String cdmolestendido) {
        this.cdmolestendido = cdmolestendido;
    }


    /**
     * Gets the cdultimaparada value for this PrUp.
     * 
     * @return cdultimaparada
     */
    public java.lang.String getCdultimaparada() {
        return cdultimaparada;
    }


    /**
     * Sets the cdultimaparada value for this PrUp.
     * 
     * @param cdultimaparada
     */
    public void setCdultimaparada(java.lang.String cdultimaparada) {
        this.cdultimaparada = cdultimaparada;
    }


    /**
     * Gets the cdultimorefugo value for this PrUp.
     * 
     * @return cdultimorefugo
     */
    public java.lang.String getCdultimorefugo() {
        return cdultimorefugo;
    }


    /**
     * Sets the cdultimorefugo value for this PrUp.
     * 
     * @param cdultimorefugo
     */
    public void setCdultimorefugo(java.lang.String cdultimorefugo) {
        this.cdultimorefugo = cdultimorefugo;
    }


    /**
     * Gets the cfgdbc value for this PrUp.
     * 
     * @return cfgdbc
     */
    public java.lang.Double getCfgdbc() {
        return cfgdbc;
    }


    /**
     * Sets the cfgdbc value for this PrUp.
     * 
     * @param cfgdbc
     */
    public void setCfgdbc(java.lang.Double cfgdbc) {
        this.cfgdbc = cfgdbc;
    }


    /**
     * Gets the cfginterrupcaociclo value for this PrUp.
     * 
     * @return cfginterrupcaociclo
     */
    public org.apache.axis.types.UnsignedShort getCfginterrupcaociclo() {
        return cfginterrupcaociclo;
    }


    /**
     * Sets the cfginterrupcaociclo value for this PrUp.
     * 
     * @param cfginterrupcaociclo
     */
    public void setCfginterrupcaociclo(org.apache.axis.types.UnsignedShort cfginterrupcaociclo) {
        this.cfginterrupcaociclo = cfginterrupcaociclo;
    }


    /**
     * Gets the cfgperctmpcicloinicializacao value for this PrUp.
     * 
     * @return cfgperctmpcicloinicializacao
     */
    public java.lang.Double getCfgperctmpcicloinicializacao() {
        return cfgperctmpcicloinicializacao;
    }


    /**
     * Sets the cfgperctmpcicloinicializacao value for this PrUp.
     * 
     * @param cfgperctmpcicloinicializacao
     */
    public void setCfgperctmpcicloinicializacao(java.lang.Double cfgperctmpcicloinicializacao) {
        this.cfgperctmpcicloinicializacao = cfgperctmpcicloinicializacao;
    }


    /**
     * Gets the cfgperctmpcicloparauto value for this PrUp.
     * 
     * @return cfgperctmpcicloparauto
     */
    public java.lang.Double getCfgperctmpcicloparauto() {
        return cfgperctmpcicloparauto;
    }


    /**
     * Sets the cfgperctmpcicloparauto value for this PrUp.
     * 
     * @param cfgperctmpcicloparauto
     */
    public void setCfgperctmpcicloparauto(java.lang.Double cfgperctmpcicloparauto) {
        this.cfgperctmpcicloparauto = cfgperctmpcicloparauto;
    }


    /**
     * Gets the cfgperctoleranciasinalciclo value for this PrUp.
     * 
     * @return cfgperctoleranciasinalciclo
     */
    public java.lang.Double getCfgperctoleranciasinalciclo() {
        return cfgperctoleranciasinalciclo;
    }


    /**
     * Sets the cfgperctoleranciasinalciclo value for this PrUp.
     * 
     * @param cfgperctoleranciasinalciclo
     */
    public void setCfgperctoleranciasinalciclo(java.lang.Double cfgperctoleranciasinalciclo) {
        this.cfgperctoleranciasinalciclo = cfgperctoleranciasinalciclo;
    }


    /**
     * Gets the cfgtamanhoumpacoteciclos value for this PrUp.
     * 
     * @return cfgtamanhoumpacoteciclos
     */
    public java.lang.Double getCfgtamanhoumpacoteciclos() {
        return cfgtamanhoumpacoteciclos;
    }


    /**
     * Sets the cfgtamanhoumpacoteciclos value for this PrUp.
     * 
     * @param cfgtamanhoumpacoteciclos
     */
    public void setCfgtamanhoumpacoteciclos(java.lang.Double cfgtamanhoumpacoteciclos) {
        this.cfgtamanhoumpacoteciclos = cfgtamanhoumpacoteciclos;
    }


    /**
     * Gets the cfgtolertmpcicloparauto value for this PrUp.
     * 
     * @return cfgtolertmpcicloparauto
     */
    public java.lang.Long getCfgtolertmpcicloparauto() {
        return cfgtolertmpcicloparauto;
    }


    /**
     * Sets the cfgtolertmpcicloparauto value for this PrUp.
     * 
     * @param cfgtolertmpcicloparauto
     */
    public void setCfgtolertmpcicloparauto(java.lang.Long cfgtolertmpcicloparauto) {
        this.cfgtolertmpcicloparauto = cfgtolertmpcicloparauto;
    }


    /**
     * Gets the cfgtpsessaoproducao value for this PrUp.
     * 
     * @return cfgtpsessaoproducao
     */
    public java.lang.String getCfgtpsessaoproducao() {
        return cfgtpsessaoproducao;
    }


    /**
     * Sets the cfgtpsessaoproducao value for this PrUp.
     * 
     * @param cfgtpsessaoproducao
     */
    public void setCfgtpsessaoproducao(java.lang.String cfgtpsessaoproducao) {
        this.cfgtpsessaoproducao = cfgtpsessaoproducao;
    }


    /**
     * Gets the dthriniplanejada value for this PrUp.
     * 
     * @return dthriniplanejada
     */
    public java.util.Calendar getDthriniplanejada() {
        return dthriniplanejada;
    }


    /**
     * Sets the dthriniplanejada value for this PrUp.
     * 
     * @param dthriniplanejada
     */
    public void setDthriniplanejada(java.util.Calendar dthriniplanejada) {
        this.dthriniplanejada = dthriniplanejada;
    }


    /**
     * Gets the dthriniultimaparada value for this PrUp.
     * 
     * @return dthriniultimaparada
     */
    public java.util.Calendar getDthriniultimaparada() {
        return dthriniultimaparada;
    }


    /**
     * Sets the dthriniultimaparada value for this PrUp.
     * 
     * @param dthriniultimaparada
     */
    public void setDthriniultimaparada(java.util.Calendar dthriniultimaparada) {
        this.dthriniultimaparada = dthriniultimaparada;
    }


    /**
     * Gets the dthrultimorefugo value for this PrUp.
     * 
     * @return dthrultimorefugo
     */
    public java.util.Calendar getDthrultimorefugo() {
        return dthrultimorefugo;
    }


    /**
     * Sets the dthrultimorefugo value for this PrUp.
     * 
     * @param dthrultimorefugo
     */
    public void setDthrultimorefugo(java.util.Calendar dthrultimorefugo) {
        this.dthrultimorefugo = dthrultimorefugo;
    }


    /**
     * Gets the idreduzidaproduto value for this PrUp.
     * 
     * @return idreduzidaproduto
     */
    public org.apache.axis.types.UnsignedShort getIdreduzidaproduto() {
        return idreduzidaproduto;
    }


    /**
     * Sets the idreduzidaproduto value for this PrUp.
     * 
     * @param idreduzidaproduto
     */
    public void setIdreduzidaproduto(org.apache.axis.types.UnsignedShort idreduzidaproduto) {
        this.idreduzidaproduto = idreduzidaproduto;
    }


    /**
     * Gets the idup value for this PrUp.
     * 
     * @return idup
     */
    public java.math.BigDecimal getIdup() {
        return idup;
    }


    /**
     * Sets the idup value for this PrUp.
     * 
     * @param idup
     */
    public void setIdup(java.math.BigDecimal idup) {
        this.idup = idup;
    }


    /**
     * Gets the infoAdicional value for this PrUp.
     * 
     * @return infoAdicional
     */
    public java.lang.String getInfoAdicional() {
        return infoAdicional;
    }


    /**
     * Sets the infoAdicional value for this PrUp.
     * 
     * @param infoAdicional
     */
    public void setInfoAdicional(java.lang.String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }


    /**
     * Gets the isBloqueioParadaSemConexao value for this PrUp.
     * 
     * @return isBloqueioParadaSemConexao
     */
    public org.apache.axis.types.UnsignedShort getIsBloqueioParadaSemConexao() {
        return isBloqueioParadaSemConexao;
    }


    /**
     * Sets the isBloqueioParadaSemConexao value for this PrUp.
     * 
     * @param isBloqueioParadaSemConexao
     */
    public void setIsBloqueioParadaSemConexao(org.apache.axis.types.UnsignedShort isBloqueioParadaSemConexao) {
        this.isBloqueioParadaSemConexao = isBloqueioParadaSemConexao;
    }


    /**
     * Gets the isOpSemColeta value for this PrUp.
     * 
     * @return isOpSemColeta
     */
    public org.apache.axis.types.UnsignedShort getIsOpSemColeta() {
        return isOpSemColeta;
    }


    /**
     * Sets the isOpSemColeta value for this PrUp.
     * 
     * @param isOpSemColeta
     */
    public void setIsOpSemColeta(org.apache.axis.types.UnsignedShort isOpSemColeta) {
        this.isOpSemColeta = isOpSemColeta;
    }


    /**
     * Gets the msdthriniultimaparada value for this PrUp.
     * 
     * @return msdthriniultimaparada
     */
    public java.lang.Double getMsdthriniultimaparada() {
        return msdthriniultimaparada;
    }


    /**
     * Sets the msdthriniultimaparada value for this PrUp.
     * 
     * @param msdthriniultimaparada
     */
    public void setMsdthriniultimaparada(java.lang.Double msdthriniultimaparada) {
        this.msdthriniultimaparada = msdthriniultimaparada;
    }


    /**
     * Gets the msdthrultimorefugo value for this PrUp.
     * 
     * @return msdthrultimorefugo
     */
    public java.lang.Double getMsdthrultimorefugo() {
        return msdthrultimorefugo;
    }


    /**
     * Sets the msdthrultimorefugo value for this PrUp.
     * 
     * @param msdthrultimorefugo
     */
    public void setMsdthrultimorefugo(java.lang.Double msdthrultimorefugo) {
        this.msdthrultimorefugo = msdthrultimorefugo;
    }


    /**
     * Gets the nrop value for this PrUp.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this PrUp.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the nropestendido value for this PrUp.
     * 
     * @return nropestendido
     */
    public java.lang.String getNropestendido() {
        return nropestendido;
    }


    /**
     * Sets the nropestendido value for this PrUp.
     * 
     * @param nropestendido
     */
    public void setNropestendido(java.lang.String nropestendido) {
        this.nropestendido = nropestendido;
    }


    /**
     * Gets the prColetorEventoses value for this PrUp.
     * 
     * @return prColetorEventoses
     */
    public idw.idwws.PrColetorEventos[] getPrColetorEventoses() {
        return prColetorEventoses;
    }


    /**
     * Sets the prColetorEventoses value for this PrUp.
     * 
     * @param prColetorEventoses
     */
    public void setPrColetorEventoses(idw.idwws.PrColetorEventos[] prColetorEventoses) {
        this.prColetorEventoses = prColetorEventoses;
    }

    public idw.idwws.PrColetorEventos getPrColetorEventoses(int i) {
        return this.prColetorEventoses[i];
    }

    public void setPrColetorEventoses(int i, idw.idwws.PrColetorEventos _value) {
        this.prColetorEventoses[i] = _value;
    }


    /**
     * Gets the prConexoesInjet value for this PrUp.
     * 
     * @return prConexoesInjet
     */
    public idw.idwws.PrConexoesInjet getPrConexoesInjet() {
        return prConexoesInjet;
    }


    /**
     * Sets the prConexoesInjet value for this PrUp.
     * 
     * @param prConexoesInjet
     */
    public void setPrConexoesInjet(idw.idwws.PrConexoesInjet prConexoesInjet) {
        this.prConexoesInjet = prConexoesInjet;
    }


    /**
     * Gets the prEventosBridgeCollecDbs value for this PrUp.
     * 
     * @return prEventosBridgeCollecDbs
     */
    public idw.idwws.PrEventosBridgeCollecDb[] getPrEventosBridgeCollecDbs() {
        return prEventosBridgeCollecDbs;
    }


    /**
     * Sets the prEventosBridgeCollecDbs value for this PrUp.
     * 
     * @param prEventosBridgeCollecDbs
     */
    public void setPrEventosBridgeCollecDbs(idw.idwws.PrEventosBridgeCollecDb[] prEventosBridgeCollecDbs) {
        this.prEventosBridgeCollecDbs = prEventosBridgeCollecDbs;
    }

    public idw.idwws.PrEventosBridgeCollecDb getPrEventosBridgeCollecDbs(int i) {
        return this.prEventosBridgeCollecDbs[i];
    }

    public void setPrEventosBridgeCollecDbs(int i, idw.idwws.PrEventosBridgeCollecDb _value) {
        this.prEventosBridgeCollecDbs[i] = _value;
    }


    /**
     * Gets the prSubColetor value for this PrUp.
     * 
     * @return prSubColetor
     */
    public idw.idwws.PrSubColetor getPrSubColetor() {
        return prSubColetor;
    }


    /**
     * Sets the prSubColetor value for this PrUp.
     * 
     * @param prSubColetor
     */
    public void setPrSubColetor(idw.idwws.PrSubColetor prSubColetor) {
        this.prSubColetor = prSubColetor;
    }


    /**
     * Gets the prUpAlertasEmAbertos value for this PrUp.
     * 
     * @return prUpAlertasEmAbertos
     */
    public idw.idwws.PrUpAlertasEmAberto[] getPrUpAlertasEmAbertos() {
        return prUpAlertasEmAbertos;
    }


    /**
     * Sets the prUpAlertasEmAbertos value for this PrUp.
     * 
     * @param prUpAlertasEmAbertos
     */
    public void setPrUpAlertasEmAbertos(idw.idwws.PrUpAlertasEmAberto[] prUpAlertasEmAbertos) {
        this.prUpAlertasEmAbertos = prUpAlertasEmAbertos;
    }

    public idw.idwws.PrUpAlertasEmAberto getPrUpAlertasEmAbertos(int i) {
        return this.prUpAlertasEmAbertos[i];
    }

    public void setPrUpAlertasEmAbertos(int i, idw.idwws.PrUpAlertasEmAberto _value) {
        this.prUpAlertasEmAbertos[i] = _value;
    }


    /**
     * Gets the prUpConfiguracoeses value for this PrUp.
     * 
     * @return prUpConfiguracoeses
     */
    public idw.idwws.PrUpConfiguracoes[] getPrUpConfiguracoeses() {
        return prUpConfiguracoeses;
    }


    /**
     * Sets the prUpConfiguracoeses value for this PrUp.
     * 
     * @param prUpConfiguracoeses
     */
    public void setPrUpConfiguracoeses(idw.idwws.PrUpConfiguracoes[] prUpConfiguracoeses) {
        this.prUpConfiguracoeses = prUpConfiguracoeses;
    }

    public idw.idwws.PrUpConfiguracoes getPrUpConfiguracoeses(int i) {
        return this.prUpConfiguracoeses[i];
    }

    public void setPrUpConfiguracoeses(int i, idw.idwws.PrUpConfiguracoes _value) {
        this.prUpConfiguracoeses[i] = _value;
    }


    /**
     * Gets the prUpLoginsEmAbertos value for this PrUp.
     * 
     * @return prUpLoginsEmAbertos
     */
    public idw.idwws.PrUpLoginsEmAberto[] getPrUpLoginsEmAbertos() {
        return prUpLoginsEmAbertos;
    }


    /**
     * Sets the prUpLoginsEmAbertos value for this PrUp.
     * 
     * @param prUpLoginsEmAbertos
     */
    public void setPrUpLoginsEmAbertos(idw.idwws.PrUpLoginsEmAberto[] prUpLoginsEmAbertos) {
        this.prUpLoginsEmAbertos = prUpLoginsEmAbertos;
    }

    public idw.idwws.PrUpLoginsEmAberto getPrUpLoginsEmAbertos(int i) {
        return this.prUpLoginsEmAbertos[i];
    }

    public void setPrUpLoginsEmAbertos(int i, idw.idwws.PrUpLoginsEmAberto _value) {
        this.prUpLoginsEmAbertos[i] = _value;
    }


    /**
     * Gets the prUpProdutoMatPrimas value for this PrUp.
     * 
     * @return prUpProdutoMatPrimas
     */
    public idw.idwws.PrUpProdutoMatPrima[] getPrUpProdutoMatPrimas() {
        return prUpProdutoMatPrimas;
    }


    /**
     * Sets the prUpProdutoMatPrimas value for this PrUp.
     * 
     * @param prUpProdutoMatPrimas
     */
    public void setPrUpProdutoMatPrimas(idw.idwws.PrUpProdutoMatPrima[] prUpProdutoMatPrimas) {
        this.prUpProdutoMatPrimas = prUpProdutoMatPrimas;
    }

    public idw.idwws.PrUpProdutoMatPrima getPrUpProdutoMatPrimas(int i) {
        return this.prUpProdutoMatPrimas[i];
    }

    public void setPrUpProdutoMatPrimas(int i, idw.idwws.PrUpProdutoMatPrima _value) {
        this.prUpProdutoMatPrimas[i] = _value;
    }


    /**
     * Gets the prUpProdutoValidacaos value for this PrUp.
     * 
     * @return prUpProdutoValidacaos
     */
    public idw.idwws.PrUpProdutoValidacao[] getPrUpProdutoValidacaos() {
        return prUpProdutoValidacaos;
    }


    /**
     * Sets the prUpProdutoValidacaos value for this PrUp.
     * 
     * @param prUpProdutoValidacaos
     */
    public void setPrUpProdutoValidacaos(idw.idwws.PrUpProdutoValidacao[] prUpProdutoValidacaos) {
        this.prUpProdutoValidacaos = prUpProdutoValidacaos;
    }

    public idw.idwws.PrUpProdutoValidacao getPrUpProdutoValidacaos(int i) {
        return this.prUpProdutoValidacaos[i];
    }

    public void setPrUpProdutoValidacaos(int i, idw.idwws.PrUpProdutoValidacao _value) {
        this.prUpProdutoValidacaos[i] = _value;
    }


    /**
     * Gets the prUpProdutos value for this PrUp.
     * 
     * @return prUpProdutos
     */
    public idw.idwws.PrUpProduto[] getPrUpProdutos() {
        return prUpProdutos;
    }


    /**
     * Sets the prUpProdutos value for this PrUp.
     * 
     * @param prUpProdutos
     */
    public void setPrUpProdutos(idw.idwws.PrUpProduto[] prUpProdutos) {
        this.prUpProdutos = prUpProdutos;
    }

    public idw.idwws.PrUpProduto getPrUpProdutos(int i) {
        return this.prUpProdutos[i];
    }

    public void setPrUpProdutos(int i, idw.idwws.PrUpProduto _value) {
        this.prUpProdutos[i] = _value;
    }


    /**
     * Gets the qtdciclosexecutados value for this PrUp.
     * 
     * @return qtdciclosexecutados
     */
    public java.math.BigDecimal getQtdciclosexecutados() {
        return qtdciclosexecutados;
    }


    /**
     * Sets the qtdciclosexecutados value for this PrUp.
     * 
     * @param qtdciclosexecutados
     */
    public void setQtdciclosexecutados(java.math.BigDecimal qtdciclosexecutados) {
        this.qtdciclosexecutados = qtdciclosexecutados;
    }


    /**
     * Gets the qtdproducaoliquida value for this PrUp.
     * 
     * @return qtdproducaoliquida
     */
    public java.lang.Double getQtdproducaoliquida() {
        return qtdproducaoliquida;
    }


    /**
     * Sets the qtdproducaoliquida value for this PrUp.
     * 
     * @param qtdproducaoliquida
     */
    public void setQtdproducaoliquida(java.lang.Double qtdproducaoliquida) {
        this.qtdproducaoliquida = qtdproducaoliquida;
    }


    /**
     * Gets the qtdrefugada value for this PrUp.
     * 
     * @return qtdrefugada
     */
    public java.lang.Double getQtdrefugada() {
        return qtdrefugada;
    }


    /**
     * Sets the qtdrefugada value for this PrUp.
     * 
     * @param qtdrefugada
     */
    public void setQtdrefugada(java.lang.Double qtdrefugada) {
        this.qtdrefugada = qtdrefugada;
    }


    /**
     * Gets the staguardrespmasterbridgecldb value for this PrUp.
     * 
     * @return staguardrespmasterbridgecldb
     */
    public java.lang.String getStaguardrespmasterbridgecldb() {
        return staguardrespmasterbridgecldb;
    }


    /**
     * Sets the staguardrespmasterbridgecldb value for this PrUp.
     * 
     * @param staguardrespmasterbridgecldb
     */
    public void setStaguardrespmasterbridgecldb(java.lang.String staguardrespmasterbridgecldb) {
        this.staguardrespmasterbridgecldb = staguardrespmasterbridgecldb;
    }


    /**
     * Gets the stalimintegdoal value for this PrUp.
     * 
     * @return stalimintegdoal
     */
    public org.apache.axis.types.UnsignedShort getStalimintegdoal() {
        return stalimintegdoal;
    }


    /**
     * Sets the stalimintegdoal value for this PrUp.
     * 
     * @param stalimintegdoal
     */
    public void setStalimintegdoal(org.apache.axis.types.UnsignedShort stalimintegdoal) {
        this.stalimintegdoal = stalimintegdoal;
    }


    /**
     * Gets the stativa value for this PrUp.
     * 
     * @return stativa
     */
    public org.apache.axis.types.UnsignedShort getStativa() {
        return stativa;
    }


    /**
     * Sets the stativa value for this PrUp.
     * 
     * @param stativa
     */
    public void setStativa(org.apache.axis.types.UnsignedShort stativa) {
        this.stativa = stativa;
    }


    /**
     * Gets the stcicloemaberto value for this PrUp.
     * 
     * @return stcicloemaberto
     */
    public org.apache.axis.types.UnsignedShort getStcicloemaberto() {
        return stcicloemaberto;
    }


    /**
     * Sets the stcicloemaberto value for this PrUp.
     * 
     * @param stcicloemaberto
     */
    public void setStcicloemaberto(org.apache.axis.types.UnsignedShort stcicloemaberto) {
        this.stcicloemaberto = stcicloemaberto;
    }


    /**
     * Gets the stintegdoal value for this PrUp.
     * 
     * @return stintegdoal
     */
    public org.apache.axis.types.UnsignedShort getStintegdoal() {
        return stintegdoal;
    }


    /**
     * Sets the stintegdoal value for this PrUp.
     * 
     * @param stintegdoal
     */
    public void setStintegdoal(org.apache.axis.types.UnsignedShort stintegdoal) {
        this.stintegdoal = stintegdoal;
    }


    /**
     * Gets the stparadaemaberto value for this PrUp.
     * 
     * @return stparadaemaberto
     */
    public org.apache.axis.types.UnsignedShort getStparadaemaberto() {
        return stparadaemaberto;
    }


    /**
     * Sets the stparadaemaberto value for this PrUp.
     * 
     * @param stparadaemaberto
     */
    public void setStparadaemaberto(org.apache.axis.types.UnsignedShort stparadaemaberto) {
        this.stparadaemaberto = stparadaemaberto;
    }


    /**
     * Gets the stvertelaintegdoal value for this PrUp.
     * 
     * @return stvertelaintegdoal
     */
    public org.apache.axis.types.UnsignedShort getStvertelaintegdoal() {
        return stvertelaintegdoal;
    }


    /**
     * Sets the stvertelaintegdoal value for this PrUp.
     * 
     * @param stvertelaintegdoal
     */
    public void setStvertelaintegdoal(org.apache.axis.types.UnsignedShort stvertelaintegdoal) {
        this.stvertelaintegdoal = stvertelaintegdoal;
    }


    /**
     * Gets the tmpciclopadrao value for this PrUp.
     * 
     * @return tmpciclopadrao
     */
    public java.lang.Double getTmpciclopadrao() {
        return tmpciclopadrao;
    }


    /**
     * Sets the tmpciclopadrao value for this PrUp.
     * 
     * @param tmpciclopadrao
     */
    public void setTmpciclopadrao(java.lang.Double tmpciclopadrao) {
        this.tmpciclopadrao = tmpciclopadrao;
    }


    /**
     * Gets the tpup value for this PrUp.
     * 
     * @return tpup
     */
    public java.math.BigDecimal getTpup() {
        return tpup;
    }


    /**
     * Sets the tpup value for this PrUp.
     * 
     * @param tpup
     */
    public void setTpup(java.math.BigDecimal tpup) {
        this.tpup = tpup;
    }


    /**
     * Gets the vleficultciclo value for this PrUp.
     * 
     * @return vleficultciclo
     */
    public java.lang.Double getVleficultciclo() {
        return vleficultciclo;
    }


    /**
     * Sets the vleficultciclo value for this PrUp.
     * 
     * @param vleficultciclo
     */
    public void setVleficultciclo(java.lang.Double vleficultciclo) {
        this.vleficultciclo = vleficultciclo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrUp)) return false;
        PrUp other = (PrUp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.cdmaqestendido==null && other.getCdmaqestendido()==null) || 
             (this.cdmaqestendido!=null &&
              this.cdmaqestendido.equals(other.getCdmaqestendido()))) &&
            ((this.cdmaquina==null && other.getCdmaquina()==null) || 
             (this.cdmaquina!=null &&
              this.cdmaquina.equals(other.getCdmaquina()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdmolestendido==null && other.getCdmolestendido()==null) || 
             (this.cdmolestendido!=null &&
              this.cdmolestendido.equals(other.getCdmolestendido()))) &&
            ((this.cdultimaparada==null && other.getCdultimaparada()==null) || 
             (this.cdultimaparada!=null &&
              this.cdultimaparada.equals(other.getCdultimaparada()))) &&
            ((this.cdultimorefugo==null && other.getCdultimorefugo()==null) || 
             (this.cdultimorefugo!=null &&
              this.cdultimorefugo.equals(other.getCdultimorefugo()))) &&
            ((this.cfgdbc==null && other.getCfgdbc()==null) || 
             (this.cfgdbc!=null &&
              this.cfgdbc.equals(other.getCfgdbc()))) &&
            ((this.cfginterrupcaociclo==null && other.getCfginterrupcaociclo()==null) || 
             (this.cfginterrupcaociclo!=null &&
              this.cfginterrupcaociclo.equals(other.getCfginterrupcaociclo()))) &&
            ((this.cfgperctmpcicloinicializacao==null && other.getCfgperctmpcicloinicializacao()==null) || 
             (this.cfgperctmpcicloinicializacao!=null &&
              this.cfgperctmpcicloinicializacao.equals(other.getCfgperctmpcicloinicializacao()))) &&
            ((this.cfgperctmpcicloparauto==null && other.getCfgperctmpcicloparauto()==null) || 
             (this.cfgperctmpcicloparauto!=null &&
              this.cfgperctmpcicloparauto.equals(other.getCfgperctmpcicloparauto()))) &&
            ((this.cfgperctoleranciasinalciclo==null && other.getCfgperctoleranciasinalciclo()==null) || 
             (this.cfgperctoleranciasinalciclo!=null &&
              this.cfgperctoleranciasinalciclo.equals(other.getCfgperctoleranciasinalciclo()))) &&
            ((this.cfgtamanhoumpacoteciclos==null && other.getCfgtamanhoumpacoteciclos()==null) || 
             (this.cfgtamanhoumpacoteciclos!=null &&
              this.cfgtamanhoumpacoteciclos.equals(other.getCfgtamanhoumpacoteciclos()))) &&
            ((this.cfgtolertmpcicloparauto==null && other.getCfgtolertmpcicloparauto()==null) || 
             (this.cfgtolertmpcicloparauto!=null &&
              this.cfgtolertmpcicloparauto.equals(other.getCfgtolertmpcicloparauto()))) &&
            ((this.cfgtpsessaoproducao==null && other.getCfgtpsessaoproducao()==null) || 
             (this.cfgtpsessaoproducao!=null &&
              this.cfgtpsessaoproducao.equals(other.getCfgtpsessaoproducao()))) &&
            ((this.dthriniplanejada==null && other.getDthriniplanejada()==null) || 
             (this.dthriniplanejada!=null &&
              this.dthriniplanejada.equals(other.getDthriniplanejada()))) &&
            ((this.dthriniultimaparada==null && other.getDthriniultimaparada()==null) || 
             (this.dthriniultimaparada!=null &&
              this.dthriniultimaparada.equals(other.getDthriniultimaparada()))) &&
            ((this.dthrultimorefugo==null && other.getDthrultimorefugo()==null) || 
             (this.dthrultimorefugo!=null &&
              this.dthrultimorefugo.equals(other.getDthrultimorefugo()))) &&
            ((this.idreduzidaproduto==null && other.getIdreduzidaproduto()==null) || 
             (this.idreduzidaproduto!=null &&
              this.idreduzidaproduto.equals(other.getIdreduzidaproduto()))) &&
            ((this.idup==null && other.getIdup()==null) || 
             (this.idup!=null &&
              this.idup.equals(other.getIdup()))) &&
            ((this.infoAdicional==null && other.getInfoAdicional()==null) || 
             (this.infoAdicional!=null &&
              this.infoAdicional.equals(other.getInfoAdicional()))) &&
            ((this.isBloqueioParadaSemConexao==null && other.getIsBloqueioParadaSemConexao()==null) || 
             (this.isBloqueioParadaSemConexao!=null &&
              this.isBloqueioParadaSemConexao.equals(other.getIsBloqueioParadaSemConexao()))) &&
            ((this.isOpSemColeta==null && other.getIsOpSemColeta()==null) || 
             (this.isOpSemColeta!=null &&
              this.isOpSemColeta.equals(other.getIsOpSemColeta()))) &&
            ((this.msdthriniultimaparada==null && other.getMsdthriniultimaparada()==null) || 
             (this.msdthriniultimaparada!=null &&
              this.msdthriniultimaparada.equals(other.getMsdthriniultimaparada()))) &&
            ((this.msdthrultimorefugo==null && other.getMsdthrultimorefugo()==null) || 
             (this.msdthrultimorefugo!=null &&
              this.msdthrultimorefugo.equals(other.getMsdthrultimorefugo()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.nropestendido==null && other.getNropestendido()==null) || 
             (this.nropestendido!=null &&
              this.nropestendido.equals(other.getNropestendido()))) &&
            ((this.prColetorEventoses==null && other.getPrColetorEventoses()==null) || 
             (this.prColetorEventoses!=null &&
              java.util.Arrays.equals(this.prColetorEventoses, other.getPrColetorEventoses()))) &&
            ((this.prConexoesInjet==null && other.getPrConexoesInjet()==null) || 
             (this.prConexoesInjet!=null &&
              this.prConexoesInjet.equals(other.getPrConexoesInjet()))) &&
            ((this.prEventosBridgeCollecDbs==null && other.getPrEventosBridgeCollecDbs()==null) || 
             (this.prEventosBridgeCollecDbs!=null &&
              java.util.Arrays.equals(this.prEventosBridgeCollecDbs, other.getPrEventosBridgeCollecDbs()))) &&
            ((this.prSubColetor==null && other.getPrSubColetor()==null) || 
             (this.prSubColetor!=null &&
              this.prSubColetor.equals(other.getPrSubColetor()))) &&
            ((this.prUpAlertasEmAbertos==null && other.getPrUpAlertasEmAbertos()==null) || 
             (this.prUpAlertasEmAbertos!=null &&
              java.util.Arrays.equals(this.prUpAlertasEmAbertos, other.getPrUpAlertasEmAbertos()))) &&
            ((this.prUpConfiguracoeses==null && other.getPrUpConfiguracoeses()==null) || 
             (this.prUpConfiguracoeses!=null &&
              java.util.Arrays.equals(this.prUpConfiguracoeses, other.getPrUpConfiguracoeses()))) &&
            ((this.prUpLoginsEmAbertos==null && other.getPrUpLoginsEmAbertos()==null) || 
             (this.prUpLoginsEmAbertos!=null &&
              java.util.Arrays.equals(this.prUpLoginsEmAbertos, other.getPrUpLoginsEmAbertos()))) &&
            ((this.prUpProdutoMatPrimas==null && other.getPrUpProdutoMatPrimas()==null) || 
             (this.prUpProdutoMatPrimas!=null &&
              java.util.Arrays.equals(this.prUpProdutoMatPrimas, other.getPrUpProdutoMatPrimas()))) &&
            ((this.prUpProdutoValidacaos==null && other.getPrUpProdutoValidacaos()==null) || 
             (this.prUpProdutoValidacaos!=null &&
              java.util.Arrays.equals(this.prUpProdutoValidacaos, other.getPrUpProdutoValidacaos()))) &&
            ((this.prUpProdutos==null && other.getPrUpProdutos()==null) || 
             (this.prUpProdutos!=null &&
              java.util.Arrays.equals(this.prUpProdutos, other.getPrUpProdutos()))) &&
            ((this.qtdciclosexecutados==null && other.getQtdciclosexecutados()==null) || 
             (this.qtdciclosexecutados!=null &&
              this.qtdciclosexecutados.equals(other.getQtdciclosexecutados()))) &&
            ((this.qtdproducaoliquida==null && other.getQtdproducaoliquida()==null) || 
             (this.qtdproducaoliquida!=null &&
              this.qtdproducaoliquida.equals(other.getQtdproducaoliquida()))) &&
            ((this.qtdrefugada==null && other.getQtdrefugada()==null) || 
             (this.qtdrefugada!=null &&
              this.qtdrefugada.equals(other.getQtdrefugada()))) &&
            ((this.staguardrespmasterbridgecldb==null && other.getStaguardrespmasterbridgecldb()==null) || 
             (this.staguardrespmasterbridgecldb!=null &&
              this.staguardrespmasterbridgecldb.equals(other.getStaguardrespmasterbridgecldb()))) &&
            ((this.stalimintegdoal==null && other.getStalimintegdoal()==null) || 
             (this.stalimintegdoal!=null &&
              this.stalimintegdoal.equals(other.getStalimintegdoal()))) &&
            ((this.stativa==null && other.getStativa()==null) || 
             (this.stativa!=null &&
              this.stativa.equals(other.getStativa()))) &&
            ((this.stcicloemaberto==null && other.getStcicloemaberto()==null) || 
             (this.stcicloemaberto!=null &&
              this.stcicloemaberto.equals(other.getStcicloemaberto()))) &&
            ((this.stintegdoal==null && other.getStintegdoal()==null) || 
             (this.stintegdoal!=null &&
              this.stintegdoal.equals(other.getStintegdoal()))) &&
            ((this.stparadaemaberto==null && other.getStparadaemaberto()==null) || 
             (this.stparadaemaberto!=null &&
              this.stparadaemaberto.equals(other.getStparadaemaberto()))) &&
            ((this.stvertelaintegdoal==null && other.getStvertelaintegdoal()==null) || 
             (this.stvertelaintegdoal!=null &&
              this.stvertelaintegdoal.equals(other.getStvertelaintegdoal()))) &&
            ((this.tmpciclopadrao==null && other.getTmpciclopadrao()==null) || 
             (this.tmpciclopadrao!=null &&
              this.tmpciclopadrao.equals(other.getTmpciclopadrao()))) &&
            ((this.tpup==null && other.getTpup()==null) || 
             (this.tpup!=null &&
              this.tpup.equals(other.getTpup()))) &&
            ((this.vleficultciclo==null && other.getVleficultciclo()==null) || 
             (this.vleficultciclo!=null &&
              this.vleficultciclo.equals(other.getVleficultciclo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getCdmaqestendido() != null) {
            _hashCode += getCdmaqestendido().hashCode();
        }
        if (getCdmaquina() != null) {
            _hashCode += getCdmaquina().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdmolestendido() != null) {
            _hashCode += getCdmolestendido().hashCode();
        }
        if (getCdultimaparada() != null) {
            _hashCode += getCdultimaparada().hashCode();
        }
        if (getCdultimorefugo() != null) {
            _hashCode += getCdultimorefugo().hashCode();
        }
        if (getCfgdbc() != null) {
            _hashCode += getCfgdbc().hashCode();
        }
        if (getCfginterrupcaociclo() != null) {
            _hashCode += getCfginterrupcaociclo().hashCode();
        }
        if (getCfgperctmpcicloinicializacao() != null) {
            _hashCode += getCfgperctmpcicloinicializacao().hashCode();
        }
        if (getCfgperctmpcicloparauto() != null) {
            _hashCode += getCfgperctmpcicloparauto().hashCode();
        }
        if (getCfgperctoleranciasinalciclo() != null) {
            _hashCode += getCfgperctoleranciasinalciclo().hashCode();
        }
        if (getCfgtamanhoumpacoteciclos() != null) {
            _hashCode += getCfgtamanhoumpacoteciclos().hashCode();
        }
        if (getCfgtolertmpcicloparauto() != null) {
            _hashCode += getCfgtolertmpcicloparauto().hashCode();
        }
        if (getCfgtpsessaoproducao() != null) {
            _hashCode += getCfgtpsessaoproducao().hashCode();
        }
        if (getDthriniplanejada() != null) {
            _hashCode += getDthriniplanejada().hashCode();
        }
        if (getDthriniultimaparada() != null) {
            _hashCode += getDthriniultimaparada().hashCode();
        }
        if (getDthrultimorefugo() != null) {
            _hashCode += getDthrultimorefugo().hashCode();
        }
        if (getIdreduzidaproduto() != null) {
            _hashCode += getIdreduzidaproduto().hashCode();
        }
        if (getIdup() != null) {
            _hashCode += getIdup().hashCode();
        }
        if (getInfoAdicional() != null) {
            _hashCode += getInfoAdicional().hashCode();
        }
        if (getIsBloqueioParadaSemConexao() != null) {
            _hashCode += getIsBloqueioParadaSemConexao().hashCode();
        }
        if (getIsOpSemColeta() != null) {
            _hashCode += getIsOpSemColeta().hashCode();
        }
        if (getMsdthriniultimaparada() != null) {
            _hashCode += getMsdthriniultimaparada().hashCode();
        }
        if (getMsdthrultimorefugo() != null) {
            _hashCode += getMsdthrultimorefugo().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getNropestendido() != null) {
            _hashCode += getNropestendido().hashCode();
        }
        if (getPrColetorEventoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrColetorEventoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrColetorEventoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrConexoesInjet() != null) {
            _hashCode += getPrConexoesInjet().hashCode();
        }
        if (getPrEventosBridgeCollecDbs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrEventosBridgeCollecDbs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrEventosBridgeCollecDbs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrSubColetor() != null) {
            _hashCode += getPrSubColetor().hashCode();
        }
        if (getPrUpAlertasEmAbertos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUpAlertasEmAbertos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUpAlertasEmAbertos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrUpConfiguracoeses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUpConfiguracoeses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUpConfiguracoeses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrUpLoginsEmAbertos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUpLoginsEmAbertos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUpLoginsEmAbertos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrUpProdutoMatPrimas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUpProdutoMatPrimas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUpProdutoMatPrimas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrUpProdutoValidacaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUpProdutoValidacaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUpProdutoValidacaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrUpProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUpProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUpProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQtdciclosexecutados() != null) {
            _hashCode += getQtdciclosexecutados().hashCode();
        }
        if (getQtdproducaoliquida() != null) {
            _hashCode += getQtdproducaoliquida().hashCode();
        }
        if (getQtdrefugada() != null) {
            _hashCode += getQtdrefugada().hashCode();
        }
        if (getStaguardrespmasterbridgecldb() != null) {
            _hashCode += getStaguardrespmasterbridgecldb().hashCode();
        }
        if (getStalimintegdoal() != null) {
            _hashCode += getStalimintegdoal().hashCode();
        }
        if (getStativa() != null) {
            _hashCode += getStativa().hashCode();
        }
        if (getStcicloemaberto() != null) {
            _hashCode += getStcicloemaberto().hashCode();
        }
        if (getStintegdoal() != null) {
            _hashCode += getStintegdoal().hashCode();
        }
        if (getStparadaemaberto() != null) {
            _hashCode += getStparadaemaberto().hashCode();
        }
        if (getStvertelaintegdoal() != null) {
            _hashCode += getStvertelaintegdoal().hashCode();
        }
        if (getTmpciclopadrao() != null) {
            _hashCode += getTmpciclopadrao().hashCode();
        }
        if (getTpup() != null) {
            _hashCode += getTpup().hashCode();
        }
        if (getVleficultciclo() != null) {
            _hashCode += getVleficultciclo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrUp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmaqestendido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmaqestendido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolestendido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolestendido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdultimaparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdultimaparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdultimorefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdultimorefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfgdbc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfgdbc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfginterrupcaociclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfginterrupcaociclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfgperctmpcicloinicializacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfgperctmpcicloinicializacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfgperctmpcicloparauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfgperctmpcicloparauto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfgperctoleranciasinalciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfgperctoleranciasinalciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfgtamanhoumpacoteciclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfgtamanhoumpacoteciclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfgtolertmpcicloparauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfgtolertmpcicloparauto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfgtpsessaoproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cfgtpsessaoproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriniplanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriniplanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriniultimaparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriniultimaparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrultimorefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrultimorefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idreduzidaproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idreduzidaproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoAdicional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoAdicional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isBloqueioParadaSemConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isBloqueioParadaSemConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isOpSemColeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isOpSemColeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthriniultimaparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthriniultimaparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthrultimorefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthrultimorefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropestendido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropestendido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prColetorEventoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prColetorEventoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prColetorEventos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prConexoesInjet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prConexoesInjet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prConexoesInjet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prEventosBridgeCollecDbs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prEventosBridgeCollecDbs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prEventosBridgeCollecDb"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prSubColetor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prSubColetor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prSubColetor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUpAlertasEmAbertos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUpAlertasEmAbertos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpAlertasEmAberto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUpConfiguracoeses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUpConfiguracoeses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpConfiguracoes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUpLoginsEmAbertos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUpLoginsEmAbertos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpLoginsEmAberto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUpProdutoMatPrimas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUpProdutoMatPrimas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpProdutoMatPrima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUpProdutoValidacaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUpProdutoValidacaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpProdutoValidacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUpProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUpProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdciclosexecutados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdciclosexecutados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdproducaoliquida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdproducaoliquida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdrefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdrefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staguardrespmasterbridgecldb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "staguardrespmasterbridgecldb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stalimintegdoal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stalimintegdoal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stcicloemaberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stcicloemaberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stintegdoal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stintegdoal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stparadaemaberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stparadaemaberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stvertelaintegdoal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stvertelaintegdoal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpciclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpciclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vleficultciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vleficultciclo"));
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
