/**
 * Ijtbpro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbpro  implements java.io.Serializable {
    private java.lang.String acabamento;

    private java.lang.String cdproduto;

    private org.apache.axis.types.UnsignedShort classificacao;

    private java.lang.String cor;

    private java.lang.String dsproduto;

    private java.lang.String espessura;

    private idw.idwws.Exportacao004[] exportacao004S;

    private java.lang.Double fatorconversao;

    private java.lang.String idproduto;

    private idw.idwws.Ijaledbqld[] ijaledbqlds;

    private idw.idwws.Ijbroneprosecao[] ijbroneprosecaosForCdproduto;

    private idw.idwws.Ijbroneprosecao[] ijbroneprosecaosForCdprodutocomp;

    private idw.idwws.Ijbroneproseccomp[] ijbroneproseccomps;

    private idw.idwws.Ijcomppromprima[] ijcomppromprimas;

    private idw.idwws.Ijctrlcgqalt[] ijctrlcgqalts;

    private idw.idwws.Ijctrlcgq[] ijctrlcgqs;

    private idw.idwws.Ijdeparapro[] ijdeparapros;

    private idw.idwws.Ijembapont[] ijembaponts;

    private idw.idwws.Ijespecinsppro[] ijespecinsppros;

    private idw.idwws.Ijespecinsproatrib[] ijespecinsproatribs;

    private idw.idwws.Ijestruprod[] ijestruprodsForCdproduto;

    private idw.idwws.Ijestruprod[] ijestruprodsForCdprodutoseq;

    private idw.idwws.Ijetqfaixa[] ijetqfaixas;

    private idw.idwws.Ijetqproduto[] ijetqprodutos;

    private idw.idwws.Ijfilakanbanintbet[] ijfilakanbanintbets;

    private idw.idwws.Ijgrpdetprocgq[] ijgrpdetprocgqs;

    private idw.idwws.Ijgrpdetpro[] ijgrpdetpros;

    private idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos;

    private idw.idwws.Ijkanbanlote[] ijkanbanlotes;

    private idw.idwws.Ijmdoalocmaq[] ijmdoalocmaqs;

    private idw.idwws.Ijmdoaloc[] ijmdoalocs;

    private idw.idwws.Ijmolproautorizpro[] ijmolproautorizpros;

    private idw.idwws.Ijmolpro[] ijmolpros;

    private idw.idwws.Ijocorvarritmo[] ijocorvarritmos;

    private idw.idwws.Ijopagrupada[] ijopagrupadas;

    private idw.idwws.Ijoplotes[] ijoploteses;

    private idw.idwws.Ijoppmedioprod[] ijoppmedioprods;

    private idw.idwws.Ijopprodutos[] ijopprodutoses;

    private idw.idwws.Ijopproqtope[] ijopproqtopes;

    private idw.idwws.Ijopsagrupprod[] ijopsagrupprods;

    private idw.idwws.Ijprocarteira[] ijprocarteiras;

    private idw.idwws.Ijprocompmprimacgq[] ijprocompmprimacgqs;

    private idw.idwws.Ijprodinspfreq[] ijprodinspfreqs;

    private idw.idwws.Ijprodxgrpparam[] ijprodxgrpparams;

    private idw.idwws.Ijpromolestpadrao[] ijpromolestpadraos;

    private idw.idwws.Ijpropeso[] ijpropesos;

    private idw.idwws.Ijproplano[] ijproplanos;

    private idw.idwws.Ijproqtope[] ijproqtopes;

    private idw.idwws.Ijprotempolimdbqld[] ijprotempolimdbqlds;

    private idw.idwws.Ijproultop[] ijproultops;

    private idw.idwws.Ijproxgrcarcrtctrl[] ijproxgrcarcrtctrls;

    private idw.idwws.Ijqldprodnivelinsp[] ijqldprodnivelinsps;

    private idw.idwws.Ijreainspprod[] ijreainspprods;

    private idw.idwws.Ijrefextra[] ijrefextras;

    private idw.idwws.Ijrelproref[] ijrelprorefs;

    private idw.idwws.Ijroteiroprodhst[] ijroteiroprodhsts;

    private idw.idwws.Ijroteiroprod[] ijroteiroprods;

    private idw.idwws.Ijtbprocfgespqld[] ijtbprocfgespqlds;

    private idw.idwws.Ijtbprocgq[] ijtbprocgqs;

    private idw.idwws.Ijtbprodeflote[] ijtbprodeflotes;

    private idw.idwws.Ijtbprodescont[] ijtbprodesconts;

    private idw.idwws.Ijtbprousu[] ijtbprousus;

    private idw.idwws.Ijversaoproducao[] ijversaoproducaos;

    private java.lang.Double pbrutomedio;

    private java.lang.Double perclotekanban;

    private java.lang.Double pliquidomedio;

    private java.math.BigDecimal tamlotekanban;

    private java.lang.Double tampulmaomax;

    private java.lang.Double tampulmaomin;

    private java.lang.Double tampulmaopadrao;

    private java.lang.Double temperaturamaxestu;

    private java.lang.Double temperaturaminestu;

    private java.lang.Double tempomaxestufagem;

    private java.lang.Double tempominestufagem;

    private java.math.BigDecimal tmpliminspqld;

    private java.math.BigDecimal tmptrocaprdt;

    private java.math.BigDecimal tmptrocapstc;

    private org.apache.axis.types.UnsignedShort tpinspqld;

    private java.math.BigDecimal tpproduto;

    private java.lang.String unidmedsap;

    private java.lang.String unproduto;

    private java.lang.Double vlproduto;

    public Ijtbpro() {
    }

    public Ijtbpro(
           java.lang.String acabamento,
           java.lang.String cdproduto,
           org.apache.axis.types.UnsignedShort classificacao,
           java.lang.String cor,
           java.lang.String dsproduto,
           java.lang.String espessura,
           idw.idwws.Exportacao004[] exportacao004S,
           java.lang.Double fatorconversao,
           java.lang.String idproduto,
           idw.idwws.Ijaledbqld[] ijaledbqlds,
           idw.idwws.Ijbroneprosecao[] ijbroneprosecaosForCdproduto,
           idw.idwws.Ijbroneprosecao[] ijbroneprosecaosForCdprodutocomp,
           idw.idwws.Ijbroneproseccomp[] ijbroneproseccomps,
           idw.idwws.Ijcomppromprima[] ijcomppromprimas,
           idw.idwws.Ijctrlcgqalt[] ijctrlcgqalts,
           idw.idwws.Ijctrlcgq[] ijctrlcgqs,
           idw.idwws.Ijdeparapro[] ijdeparapros,
           idw.idwws.Ijembapont[] ijembaponts,
           idw.idwws.Ijespecinsppro[] ijespecinsppros,
           idw.idwws.Ijespecinsproatrib[] ijespecinsproatribs,
           idw.idwws.Ijestruprod[] ijestruprodsForCdproduto,
           idw.idwws.Ijestruprod[] ijestruprodsForCdprodutoseq,
           idw.idwws.Ijetqfaixa[] ijetqfaixas,
           idw.idwws.Ijetqproduto[] ijetqprodutos,
           idw.idwws.Ijfilakanbanintbet[] ijfilakanbanintbets,
           idw.idwws.Ijgrpdetprocgq[] ijgrpdetprocgqs,
           idw.idwws.Ijgrpdetpro[] ijgrpdetpros,
           idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos,
           idw.idwws.Ijkanbanlote[] ijkanbanlotes,
           idw.idwws.Ijmdoalocmaq[] ijmdoalocmaqs,
           idw.idwws.Ijmdoaloc[] ijmdoalocs,
           idw.idwws.Ijmolproautorizpro[] ijmolproautorizpros,
           idw.idwws.Ijmolpro[] ijmolpros,
           idw.idwws.Ijocorvarritmo[] ijocorvarritmos,
           idw.idwws.Ijopagrupada[] ijopagrupadas,
           idw.idwws.Ijoplotes[] ijoploteses,
           idw.idwws.Ijoppmedioprod[] ijoppmedioprods,
           idw.idwws.Ijopprodutos[] ijopprodutoses,
           idw.idwws.Ijopproqtope[] ijopproqtopes,
           idw.idwws.Ijopsagrupprod[] ijopsagrupprods,
           idw.idwws.Ijprocarteira[] ijprocarteiras,
           idw.idwws.Ijprocompmprimacgq[] ijprocompmprimacgqs,
           idw.idwws.Ijprodinspfreq[] ijprodinspfreqs,
           idw.idwws.Ijprodxgrpparam[] ijprodxgrpparams,
           idw.idwws.Ijpromolestpadrao[] ijpromolestpadraos,
           idw.idwws.Ijpropeso[] ijpropesos,
           idw.idwws.Ijproplano[] ijproplanos,
           idw.idwws.Ijproqtope[] ijproqtopes,
           idw.idwws.Ijprotempolimdbqld[] ijprotempolimdbqlds,
           idw.idwws.Ijproultop[] ijproultops,
           idw.idwws.Ijproxgrcarcrtctrl[] ijproxgrcarcrtctrls,
           idw.idwws.Ijqldprodnivelinsp[] ijqldprodnivelinsps,
           idw.idwws.Ijreainspprod[] ijreainspprods,
           idw.idwws.Ijrefextra[] ijrefextras,
           idw.idwws.Ijrelproref[] ijrelprorefs,
           idw.idwws.Ijroteiroprodhst[] ijroteiroprodhsts,
           idw.idwws.Ijroteiroprod[] ijroteiroprods,
           idw.idwws.Ijtbprocfgespqld[] ijtbprocfgespqlds,
           idw.idwws.Ijtbprocgq[] ijtbprocgqs,
           idw.idwws.Ijtbprodeflote[] ijtbprodeflotes,
           idw.idwws.Ijtbprodescont[] ijtbprodesconts,
           idw.idwws.Ijtbprousu[] ijtbprousus,
           idw.idwws.Ijversaoproducao[] ijversaoproducaos,
           java.lang.Double pbrutomedio,
           java.lang.Double perclotekanban,
           java.lang.Double pliquidomedio,
           java.math.BigDecimal tamlotekanban,
           java.lang.Double tampulmaomax,
           java.lang.Double tampulmaomin,
           java.lang.Double tampulmaopadrao,
           java.lang.Double temperaturamaxestu,
           java.lang.Double temperaturaminestu,
           java.lang.Double tempomaxestufagem,
           java.lang.Double tempominestufagem,
           java.math.BigDecimal tmpliminspqld,
           java.math.BigDecimal tmptrocaprdt,
           java.math.BigDecimal tmptrocapstc,
           org.apache.axis.types.UnsignedShort tpinspqld,
           java.math.BigDecimal tpproduto,
           java.lang.String unidmedsap,
           java.lang.String unproduto,
           java.lang.Double vlproduto) {
           this.acabamento = acabamento;
           this.cdproduto = cdproduto;
           this.classificacao = classificacao;
           this.cor = cor;
           this.dsproduto = dsproduto;
           this.espessura = espessura;
           this.exportacao004S = exportacao004S;
           this.fatorconversao = fatorconversao;
           this.idproduto = idproduto;
           this.ijaledbqlds = ijaledbqlds;
           this.ijbroneprosecaosForCdproduto = ijbroneprosecaosForCdproduto;
           this.ijbroneprosecaosForCdprodutocomp = ijbroneprosecaosForCdprodutocomp;
           this.ijbroneproseccomps = ijbroneproseccomps;
           this.ijcomppromprimas = ijcomppromprimas;
           this.ijctrlcgqalts = ijctrlcgqalts;
           this.ijctrlcgqs = ijctrlcgqs;
           this.ijdeparapros = ijdeparapros;
           this.ijembaponts = ijembaponts;
           this.ijespecinsppros = ijespecinsppros;
           this.ijespecinsproatribs = ijespecinsproatribs;
           this.ijestruprodsForCdproduto = ijestruprodsForCdproduto;
           this.ijestruprodsForCdprodutoseq = ijestruprodsForCdprodutoseq;
           this.ijetqfaixas = ijetqfaixas;
           this.ijetqprodutos = ijetqprodutos;
           this.ijfilakanbanintbets = ijfilakanbanintbets;
           this.ijgrpdetprocgqs = ijgrpdetprocgqs;
           this.ijgrpdetpros = ijgrpdetpros;
           this.ijkanbanidcartaos = ijkanbanidcartaos;
           this.ijkanbanlotes = ijkanbanlotes;
           this.ijmdoalocmaqs = ijmdoalocmaqs;
           this.ijmdoalocs = ijmdoalocs;
           this.ijmolproautorizpros = ijmolproautorizpros;
           this.ijmolpros = ijmolpros;
           this.ijocorvarritmos = ijocorvarritmos;
           this.ijopagrupadas = ijopagrupadas;
           this.ijoploteses = ijoploteses;
           this.ijoppmedioprods = ijoppmedioprods;
           this.ijopprodutoses = ijopprodutoses;
           this.ijopproqtopes = ijopproqtopes;
           this.ijopsagrupprods = ijopsagrupprods;
           this.ijprocarteiras = ijprocarteiras;
           this.ijprocompmprimacgqs = ijprocompmprimacgqs;
           this.ijprodinspfreqs = ijprodinspfreqs;
           this.ijprodxgrpparams = ijprodxgrpparams;
           this.ijpromolestpadraos = ijpromolestpadraos;
           this.ijpropesos = ijpropesos;
           this.ijproplanos = ijproplanos;
           this.ijproqtopes = ijproqtopes;
           this.ijprotempolimdbqlds = ijprotempolimdbqlds;
           this.ijproultops = ijproultops;
           this.ijproxgrcarcrtctrls = ijproxgrcarcrtctrls;
           this.ijqldprodnivelinsps = ijqldprodnivelinsps;
           this.ijreainspprods = ijreainspprods;
           this.ijrefextras = ijrefextras;
           this.ijrelprorefs = ijrelprorefs;
           this.ijroteiroprodhsts = ijroteiroprodhsts;
           this.ijroteiroprods = ijroteiroprods;
           this.ijtbprocfgespqlds = ijtbprocfgespqlds;
           this.ijtbprocgqs = ijtbprocgqs;
           this.ijtbprodeflotes = ijtbprodeflotes;
           this.ijtbprodesconts = ijtbprodesconts;
           this.ijtbprousus = ijtbprousus;
           this.ijversaoproducaos = ijversaoproducaos;
           this.pbrutomedio = pbrutomedio;
           this.perclotekanban = perclotekanban;
           this.pliquidomedio = pliquidomedio;
           this.tamlotekanban = tamlotekanban;
           this.tampulmaomax = tampulmaomax;
           this.tampulmaomin = tampulmaomin;
           this.tampulmaopadrao = tampulmaopadrao;
           this.temperaturamaxestu = temperaturamaxestu;
           this.temperaturaminestu = temperaturaminestu;
           this.tempomaxestufagem = tempomaxestufagem;
           this.tempominestufagem = tempominestufagem;
           this.tmpliminspqld = tmpliminspqld;
           this.tmptrocaprdt = tmptrocaprdt;
           this.tmptrocapstc = tmptrocapstc;
           this.tpinspqld = tpinspqld;
           this.tpproduto = tpproduto;
           this.unidmedsap = unidmedsap;
           this.unproduto = unproduto;
           this.vlproduto = vlproduto;
    }


    /**
     * Gets the acabamento value for this Ijtbpro.
     * 
     * @return acabamento
     */
    public java.lang.String getAcabamento() {
        return acabamento;
    }


    /**
     * Sets the acabamento value for this Ijtbpro.
     * 
     * @param acabamento
     */
    public void setAcabamento(java.lang.String acabamento) {
        this.acabamento = acabamento;
    }


    /**
     * Gets the cdproduto value for this Ijtbpro.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this Ijtbpro.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the classificacao value for this Ijtbpro.
     * 
     * @return classificacao
     */
    public org.apache.axis.types.UnsignedShort getClassificacao() {
        return classificacao;
    }


    /**
     * Sets the classificacao value for this Ijtbpro.
     * 
     * @param classificacao
     */
    public void setClassificacao(org.apache.axis.types.UnsignedShort classificacao) {
        this.classificacao = classificacao;
    }


    /**
     * Gets the cor value for this Ijtbpro.
     * 
     * @return cor
     */
    public java.lang.String getCor() {
        return cor;
    }


    /**
     * Sets the cor value for this Ijtbpro.
     * 
     * @param cor
     */
    public void setCor(java.lang.String cor) {
        this.cor = cor;
    }


    /**
     * Gets the dsproduto value for this Ijtbpro.
     * 
     * @return dsproduto
     */
    public java.lang.String getDsproduto() {
        return dsproduto;
    }


    /**
     * Sets the dsproduto value for this Ijtbpro.
     * 
     * @param dsproduto
     */
    public void setDsproduto(java.lang.String dsproduto) {
        this.dsproduto = dsproduto;
    }


    /**
     * Gets the espessura value for this Ijtbpro.
     * 
     * @return espessura
     */
    public java.lang.String getEspessura() {
        return espessura;
    }


    /**
     * Sets the espessura value for this Ijtbpro.
     * 
     * @param espessura
     */
    public void setEspessura(java.lang.String espessura) {
        this.espessura = espessura;
    }


    /**
     * Gets the exportacao004S value for this Ijtbpro.
     * 
     * @return exportacao004S
     */
    public idw.idwws.Exportacao004[] getExportacao004S() {
        return exportacao004S;
    }


    /**
     * Sets the exportacao004S value for this Ijtbpro.
     * 
     * @param exportacao004S
     */
    public void setExportacao004S(idw.idwws.Exportacao004[] exportacao004S) {
        this.exportacao004S = exportacao004S;
    }

    public idw.idwws.Exportacao004 getExportacao004S(int i) {
        return this.exportacao004S[i];
    }

    public void setExportacao004S(int i, idw.idwws.Exportacao004 _value) {
        this.exportacao004S[i] = _value;
    }


    /**
     * Gets the fatorconversao value for this Ijtbpro.
     * 
     * @return fatorconversao
     */
    public java.lang.Double getFatorconversao() {
        return fatorconversao;
    }


    /**
     * Sets the fatorconversao value for this Ijtbpro.
     * 
     * @param fatorconversao
     */
    public void setFatorconversao(java.lang.Double fatorconversao) {
        this.fatorconversao = fatorconversao;
    }


    /**
     * Gets the idproduto value for this Ijtbpro.
     * 
     * @return idproduto
     */
    public java.lang.String getIdproduto() {
        return idproduto;
    }


    /**
     * Sets the idproduto value for this Ijtbpro.
     * 
     * @param idproduto
     */
    public void setIdproduto(java.lang.String idproduto) {
        this.idproduto = idproduto;
    }


    /**
     * Gets the ijaledbqlds value for this Ijtbpro.
     * 
     * @return ijaledbqlds
     */
    public idw.idwws.Ijaledbqld[] getIjaledbqlds() {
        return ijaledbqlds;
    }


    /**
     * Sets the ijaledbqlds value for this Ijtbpro.
     * 
     * @param ijaledbqlds
     */
    public void setIjaledbqlds(idw.idwws.Ijaledbqld[] ijaledbqlds) {
        this.ijaledbqlds = ijaledbqlds;
    }

    public idw.idwws.Ijaledbqld getIjaledbqlds(int i) {
        return this.ijaledbqlds[i];
    }

    public void setIjaledbqlds(int i, idw.idwws.Ijaledbqld _value) {
        this.ijaledbqlds[i] = _value;
    }


    /**
     * Gets the ijbroneprosecaosForCdproduto value for this Ijtbpro.
     * 
     * @return ijbroneprosecaosForCdproduto
     */
    public idw.idwws.Ijbroneprosecao[] getIjbroneprosecaosForCdproduto() {
        return ijbroneprosecaosForCdproduto;
    }


    /**
     * Sets the ijbroneprosecaosForCdproduto value for this Ijtbpro.
     * 
     * @param ijbroneprosecaosForCdproduto
     */
    public void setIjbroneprosecaosForCdproduto(idw.idwws.Ijbroneprosecao[] ijbroneprosecaosForCdproduto) {
        this.ijbroneprosecaosForCdproduto = ijbroneprosecaosForCdproduto;
    }

    public idw.idwws.Ijbroneprosecao getIjbroneprosecaosForCdproduto(int i) {
        return this.ijbroneprosecaosForCdproduto[i];
    }

    public void setIjbroneprosecaosForCdproduto(int i, idw.idwws.Ijbroneprosecao _value) {
        this.ijbroneprosecaosForCdproduto[i] = _value;
    }


    /**
     * Gets the ijbroneprosecaosForCdprodutocomp value for this Ijtbpro.
     * 
     * @return ijbroneprosecaosForCdprodutocomp
     */
    public idw.idwws.Ijbroneprosecao[] getIjbroneprosecaosForCdprodutocomp() {
        return ijbroneprosecaosForCdprodutocomp;
    }


    /**
     * Sets the ijbroneprosecaosForCdprodutocomp value for this Ijtbpro.
     * 
     * @param ijbroneprosecaosForCdprodutocomp
     */
    public void setIjbroneprosecaosForCdprodutocomp(idw.idwws.Ijbroneprosecao[] ijbroneprosecaosForCdprodutocomp) {
        this.ijbroneprosecaosForCdprodutocomp = ijbroneprosecaosForCdprodutocomp;
    }

    public idw.idwws.Ijbroneprosecao getIjbroneprosecaosForCdprodutocomp(int i) {
        return this.ijbroneprosecaosForCdprodutocomp[i];
    }

    public void setIjbroneprosecaosForCdprodutocomp(int i, idw.idwws.Ijbroneprosecao _value) {
        this.ijbroneprosecaosForCdprodutocomp[i] = _value;
    }


    /**
     * Gets the ijbroneproseccomps value for this Ijtbpro.
     * 
     * @return ijbroneproseccomps
     */
    public idw.idwws.Ijbroneproseccomp[] getIjbroneproseccomps() {
        return ijbroneproseccomps;
    }


    /**
     * Sets the ijbroneproseccomps value for this Ijtbpro.
     * 
     * @param ijbroneproseccomps
     */
    public void setIjbroneproseccomps(idw.idwws.Ijbroneproseccomp[] ijbroneproseccomps) {
        this.ijbroneproseccomps = ijbroneproseccomps;
    }

    public idw.idwws.Ijbroneproseccomp getIjbroneproseccomps(int i) {
        return this.ijbroneproseccomps[i];
    }

    public void setIjbroneproseccomps(int i, idw.idwws.Ijbroneproseccomp _value) {
        this.ijbroneproseccomps[i] = _value;
    }


    /**
     * Gets the ijcomppromprimas value for this Ijtbpro.
     * 
     * @return ijcomppromprimas
     */
    public idw.idwws.Ijcomppromprima[] getIjcomppromprimas() {
        return ijcomppromprimas;
    }


    /**
     * Sets the ijcomppromprimas value for this Ijtbpro.
     * 
     * @param ijcomppromprimas
     */
    public void setIjcomppromprimas(idw.idwws.Ijcomppromprima[] ijcomppromprimas) {
        this.ijcomppromprimas = ijcomppromprimas;
    }

    public idw.idwws.Ijcomppromprima getIjcomppromprimas(int i) {
        return this.ijcomppromprimas[i];
    }

    public void setIjcomppromprimas(int i, idw.idwws.Ijcomppromprima _value) {
        this.ijcomppromprimas[i] = _value;
    }


    /**
     * Gets the ijctrlcgqalts value for this Ijtbpro.
     * 
     * @return ijctrlcgqalts
     */
    public idw.idwws.Ijctrlcgqalt[] getIjctrlcgqalts() {
        return ijctrlcgqalts;
    }


    /**
     * Sets the ijctrlcgqalts value for this Ijtbpro.
     * 
     * @param ijctrlcgqalts
     */
    public void setIjctrlcgqalts(idw.idwws.Ijctrlcgqalt[] ijctrlcgqalts) {
        this.ijctrlcgqalts = ijctrlcgqalts;
    }

    public idw.idwws.Ijctrlcgqalt getIjctrlcgqalts(int i) {
        return this.ijctrlcgqalts[i];
    }

    public void setIjctrlcgqalts(int i, idw.idwws.Ijctrlcgqalt _value) {
        this.ijctrlcgqalts[i] = _value;
    }


    /**
     * Gets the ijctrlcgqs value for this Ijtbpro.
     * 
     * @return ijctrlcgqs
     */
    public idw.idwws.Ijctrlcgq[] getIjctrlcgqs() {
        return ijctrlcgqs;
    }


    /**
     * Sets the ijctrlcgqs value for this Ijtbpro.
     * 
     * @param ijctrlcgqs
     */
    public void setIjctrlcgqs(idw.idwws.Ijctrlcgq[] ijctrlcgqs) {
        this.ijctrlcgqs = ijctrlcgqs;
    }

    public idw.idwws.Ijctrlcgq getIjctrlcgqs(int i) {
        return this.ijctrlcgqs[i];
    }

    public void setIjctrlcgqs(int i, idw.idwws.Ijctrlcgq _value) {
        this.ijctrlcgqs[i] = _value;
    }


    /**
     * Gets the ijdeparapros value for this Ijtbpro.
     * 
     * @return ijdeparapros
     */
    public idw.idwws.Ijdeparapro[] getIjdeparapros() {
        return ijdeparapros;
    }


    /**
     * Sets the ijdeparapros value for this Ijtbpro.
     * 
     * @param ijdeparapros
     */
    public void setIjdeparapros(idw.idwws.Ijdeparapro[] ijdeparapros) {
        this.ijdeparapros = ijdeparapros;
    }

    public idw.idwws.Ijdeparapro getIjdeparapros(int i) {
        return this.ijdeparapros[i];
    }

    public void setIjdeparapros(int i, idw.idwws.Ijdeparapro _value) {
        this.ijdeparapros[i] = _value;
    }


    /**
     * Gets the ijembaponts value for this Ijtbpro.
     * 
     * @return ijembaponts
     */
    public idw.idwws.Ijembapont[] getIjembaponts() {
        return ijembaponts;
    }


    /**
     * Sets the ijembaponts value for this Ijtbpro.
     * 
     * @param ijembaponts
     */
    public void setIjembaponts(idw.idwws.Ijembapont[] ijembaponts) {
        this.ijembaponts = ijembaponts;
    }

    public idw.idwws.Ijembapont getIjembaponts(int i) {
        return this.ijembaponts[i];
    }

    public void setIjembaponts(int i, idw.idwws.Ijembapont _value) {
        this.ijembaponts[i] = _value;
    }


    /**
     * Gets the ijespecinsppros value for this Ijtbpro.
     * 
     * @return ijespecinsppros
     */
    public idw.idwws.Ijespecinsppro[] getIjespecinsppros() {
        return ijespecinsppros;
    }


    /**
     * Sets the ijespecinsppros value for this Ijtbpro.
     * 
     * @param ijespecinsppros
     */
    public void setIjespecinsppros(idw.idwws.Ijespecinsppro[] ijespecinsppros) {
        this.ijespecinsppros = ijespecinsppros;
    }

    public idw.idwws.Ijespecinsppro getIjespecinsppros(int i) {
        return this.ijespecinsppros[i];
    }

    public void setIjespecinsppros(int i, idw.idwws.Ijespecinsppro _value) {
        this.ijespecinsppros[i] = _value;
    }


    /**
     * Gets the ijespecinsproatribs value for this Ijtbpro.
     * 
     * @return ijespecinsproatribs
     */
    public idw.idwws.Ijespecinsproatrib[] getIjespecinsproatribs() {
        return ijespecinsproatribs;
    }


    /**
     * Sets the ijespecinsproatribs value for this Ijtbpro.
     * 
     * @param ijespecinsproatribs
     */
    public void setIjespecinsproatribs(idw.idwws.Ijespecinsproatrib[] ijespecinsproatribs) {
        this.ijespecinsproatribs = ijespecinsproatribs;
    }

    public idw.idwws.Ijespecinsproatrib getIjespecinsproatribs(int i) {
        return this.ijespecinsproatribs[i];
    }

    public void setIjespecinsproatribs(int i, idw.idwws.Ijespecinsproatrib _value) {
        this.ijespecinsproatribs[i] = _value;
    }


    /**
     * Gets the ijestruprodsForCdproduto value for this Ijtbpro.
     * 
     * @return ijestruprodsForCdproduto
     */
    public idw.idwws.Ijestruprod[] getIjestruprodsForCdproduto() {
        return ijestruprodsForCdproduto;
    }


    /**
     * Sets the ijestruprodsForCdproduto value for this Ijtbpro.
     * 
     * @param ijestruprodsForCdproduto
     */
    public void setIjestruprodsForCdproduto(idw.idwws.Ijestruprod[] ijestruprodsForCdproduto) {
        this.ijestruprodsForCdproduto = ijestruprodsForCdproduto;
    }

    public idw.idwws.Ijestruprod getIjestruprodsForCdproduto(int i) {
        return this.ijestruprodsForCdproduto[i];
    }

    public void setIjestruprodsForCdproduto(int i, idw.idwws.Ijestruprod _value) {
        this.ijestruprodsForCdproduto[i] = _value;
    }


    /**
     * Gets the ijestruprodsForCdprodutoseq value for this Ijtbpro.
     * 
     * @return ijestruprodsForCdprodutoseq
     */
    public idw.idwws.Ijestruprod[] getIjestruprodsForCdprodutoseq() {
        return ijestruprodsForCdprodutoseq;
    }


    /**
     * Sets the ijestruprodsForCdprodutoseq value for this Ijtbpro.
     * 
     * @param ijestruprodsForCdprodutoseq
     */
    public void setIjestruprodsForCdprodutoseq(idw.idwws.Ijestruprod[] ijestruprodsForCdprodutoseq) {
        this.ijestruprodsForCdprodutoseq = ijestruprodsForCdprodutoseq;
    }

    public idw.idwws.Ijestruprod getIjestruprodsForCdprodutoseq(int i) {
        return this.ijestruprodsForCdprodutoseq[i];
    }

    public void setIjestruprodsForCdprodutoseq(int i, idw.idwws.Ijestruprod _value) {
        this.ijestruprodsForCdprodutoseq[i] = _value;
    }


    /**
     * Gets the ijetqfaixas value for this Ijtbpro.
     * 
     * @return ijetqfaixas
     */
    public idw.idwws.Ijetqfaixa[] getIjetqfaixas() {
        return ijetqfaixas;
    }


    /**
     * Sets the ijetqfaixas value for this Ijtbpro.
     * 
     * @param ijetqfaixas
     */
    public void setIjetqfaixas(idw.idwws.Ijetqfaixa[] ijetqfaixas) {
        this.ijetqfaixas = ijetqfaixas;
    }

    public idw.idwws.Ijetqfaixa getIjetqfaixas(int i) {
        return this.ijetqfaixas[i];
    }

    public void setIjetqfaixas(int i, idw.idwws.Ijetqfaixa _value) {
        this.ijetqfaixas[i] = _value;
    }


    /**
     * Gets the ijetqprodutos value for this Ijtbpro.
     * 
     * @return ijetqprodutos
     */
    public idw.idwws.Ijetqproduto[] getIjetqprodutos() {
        return ijetqprodutos;
    }


    /**
     * Sets the ijetqprodutos value for this Ijtbpro.
     * 
     * @param ijetqprodutos
     */
    public void setIjetqprodutos(idw.idwws.Ijetqproduto[] ijetqprodutos) {
        this.ijetqprodutos = ijetqprodutos;
    }

    public idw.idwws.Ijetqproduto getIjetqprodutos(int i) {
        return this.ijetqprodutos[i];
    }

    public void setIjetqprodutos(int i, idw.idwws.Ijetqproduto _value) {
        this.ijetqprodutos[i] = _value;
    }


    /**
     * Gets the ijfilakanbanintbets value for this Ijtbpro.
     * 
     * @return ijfilakanbanintbets
     */
    public idw.idwws.Ijfilakanbanintbet[] getIjfilakanbanintbets() {
        return ijfilakanbanintbets;
    }


    /**
     * Sets the ijfilakanbanintbets value for this Ijtbpro.
     * 
     * @param ijfilakanbanintbets
     */
    public void setIjfilakanbanintbets(idw.idwws.Ijfilakanbanintbet[] ijfilakanbanintbets) {
        this.ijfilakanbanintbets = ijfilakanbanintbets;
    }

    public idw.idwws.Ijfilakanbanintbet getIjfilakanbanintbets(int i) {
        return this.ijfilakanbanintbets[i];
    }

    public void setIjfilakanbanintbets(int i, idw.idwws.Ijfilakanbanintbet _value) {
        this.ijfilakanbanintbets[i] = _value;
    }


    /**
     * Gets the ijgrpdetprocgqs value for this Ijtbpro.
     * 
     * @return ijgrpdetprocgqs
     */
    public idw.idwws.Ijgrpdetprocgq[] getIjgrpdetprocgqs() {
        return ijgrpdetprocgqs;
    }


    /**
     * Sets the ijgrpdetprocgqs value for this Ijtbpro.
     * 
     * @param ijgrpdetprocgqs
     */
    public void setIjgrpdetprocgqs(idw.idwws.Ijgrpdetprocgq[] ijgrpdetprocgqs) {
        this.ijgrpdetprocgqs = ijgrpdetprocgqs;
    }

    public idw.idwws.Ijgrpdetprocgq getIjgrpdetprocgqs(int i) {
        return this.ijgrpdetprocgqs[i];
    }

    public void setIjgrpdetprocgqs(int i, idw.idwws.Ijgrpdetprocgq _value) {
        this.ijgrpdetprocgqs[i] = _value;
    }


    /**
     * Gets the ijgrpdetpros value for this Ijtbpro.
     * 
     * @return ijgrpdetpros
     */
    public idw.idwws.Ijgrpdetpro[] getIjgrpdetpros() {
        return ijgrpdetpros;
    }


    /**
     * Sets the ijgrpdetpros value for this Ijtbpro.
     * 
     * @param ijgrpdetpros
     */
    public void setIjgrpdetpros(idw.idwws.Ijgrpdetpro[] ijgrpdetpros) {
        this.ijgrpdetpros = ijgrpdetpros;
    }

    public idw.idwws.Ijgrpdetpro getIjgrpdetpros(int i) {
        return this.ijgrpdetpros[i];
    }

    public void setIjgrpdetpros(int i, idw.idwws.Ijgrpdetpro _value) {
        this.ijgrpdetpros[i] = _value;
    }


    /**
     * Gets the ijkanbanidcartaos value for this Ijtbpro.
     * 
     * @return ijkanbanidcartaos
     */
    public idw.idwws.Ijkanbanidcartao[] getIjkanbanidcartaos() {
        return ijkanbanidcartaos;
    }


    /**
     * Sets the ijkanbanidcartaos value for this Ijtbpro.
     * 
     * @param ijkanbanidcartaos
     */
    public void setIjkanbanidcartaos(idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos) {
        this.ijkanbanidcartaos = ijkanbanidcartaos;
    }

    public idw.idwws.Ijkanbanidcartao getIjkanbanidcartaos(int i) {
        return this.ijkanbanidcartaos[i];
    }

    public void setIjkanbanidcartaos(int i, idw.idwws.Ijkanbanidcartao _value) {
        this.ijkanbanidcartaos[i] = _value;
    }


    /**
     * Gets the ijkanbanlotes value for this Ijtbpro.
     * 
     * @return ijkanbanlotes
     */
    public idw.idwws.Ijkanbanlote[] getIjkanbanlotes() {
        return ijkanbanlotes;
    }


    /**
     * Sets the ijkanbanlotes value for this Ijtbpro.
     * 
     * @param ijkanbanlotes
     */
    public void setIjkanbanlotes(idw.idwws.Ijkanbanlote[] ijkanbanlotes) {
        this.ijkanbanlotes = ijkanbanlotes;
    }

    public idw.idwws.Ijkanbanlote getIjkanbanlotes(int i) {
        return this.ijkanbanlotes[i];
    }

    public void setIjkanbanlotes(int i, idw.idwws.Ijkanbanlote _value) {
        this.ijkanbanlotes[i] = _value;
    }


    /**
     * Gets the ijmdoalocmaqs value for this Ijtbpro.
     * 
     * @return ijmdoalocmaqs
     */
    public idw.idwws.Ijmdoalocmaq[] getIjmdoalocmaqs() {
        return ijmdoalocmaqs;
    }


    /**
     * Sets the ijmdoalocmaqs value for this Ijtbpro.
     * 
     * @param ijmdoalocmaqs
     */
    public void setIjmdoalocmaqs(idw.idwws.Ijmdoalocmaq[] ijmdoalocmaqs) {
        this.ijmdoalocmaqs = ijmdoalocmaqs;
    }

    public idw.idwws.Ijmdoalocmaq getIjmdoalocmaqs(int i) {
        return this.ijmdoalocmaqs[i];
    }

    public void setIjmdoalocmaqs(int i, idw.idwws.Ijmdoalocmaq _value) {
        this.ijmdoalocmaqs[i] = _value;
    }


    /**
     * Gets the ijmdoalocs value for this Ijtbpro.
     * 
     * @return ijmdoalocs
     */
    public idw.idwws.Ijmdoaloc[] getIjmdoalocs() {
        return ijmdoalocs;
    }


    /**
     * Sets the ijmdoalocs value for this Ijtbpro.
     * 
     * @param ijmdoalocs
     */
    public void setIjmdoalocs(idw.idwws.Ijmdoaloc[] ijmdoalocs) {
        this.ijmdoalocs = ijmdoalocs;
    }

    public idw.idwws.Ijmdoaloc getIjmdoalocs(int i) {
        return this.ijmdoalocs[i];
    }

    public void setIjmdoalocs(int i, idw.idwws.Ijmdoaloc _value) {
        this.ijmdoalocs[i] = _value;
    }


    /**
     * Gets the ijmolproautorizpros value for this Ijtbpro.
     * 
     * @return ijmolproautorizpros
     */
    public idw.idwws.Ijmolproautorizpro[] getIjmolproautorizpros() {
        return ijmolproautorizpros;
    }


    /**
     * Sets the ijmolproautorizpros value for this Ijtbpro.
     * 
     * @param ijmolproautorizpros
     */
    public void setIjmolproautorizpros(idw.idwws.Ijmolproautorizpro[] ijmolproautorizpros) {
        this.ijmolproautorizpros = ijmolproautorizpros;
    }

    public idw.idwws.Ijmolproautorizpro getIjmolproautorizpros(int i) {
        return this.ijmolproautorizpros[i];
    }

    public void setIjmolproautorizpros(int i, idw.idwws.Ijmolproautorizpro _value) {
        this.ijmolproautorizpros[i] = _value;
    }


    /**
     * Gets the ijmolpros value for this Ijtbpro.
     * 
     * @return ijmolpros
     */
    public idw.idwws.Ijmolpro[] getIjmolpros() {
        return ijmolpros;
    }


    /**
     * Sets the ijmolpros value for this Ijtbpro.
     * 
     * @param ijmolpros
     */
    public void setIjmolpros(idw.idwws.Ijmolpro[] ijmolpros) {
        this.ijmolpros = ijmolpros;
    }

    public idw.idwws.Ijmolpro getIjmolpros(int i) {
        return this.ijmolpros[i];
    }

    public void setIjmolpros(int i, idw.idwws.Ijmolpro _value) {
        this.ijmolpros[i] = _value;
    }


    /**
     * Gets the ijocorvarritmos value for this Ijtbpro.
     * 
     * @return ijocorvarritmos
     */
    public idw.idwws.Ijocorvarritmo[] getIjocorvarritmos() {
        return ijocorvarritmos;
    }


    /**
     * Sets the ijocorvarritmos value for this Ijtbpro.
     * 
     * @param ijocorvarritmos
     */
    public void setIjocorvarritmos(idw.idwws.Ijocorvarritmo[] ijocorvarritmos) {
        this.ijocorvarritmos = ijocorvarritmos;
    }

    public idw.idwws.Ijocorvarritmo getIjocorvarritmos(int i) {
        return this.ijocorvarritmos[i];
    }

    public void setIjocorvarritmos(int i, idw.idwws.Ijocorvarritmo _value) {
        this.ijocorvarritmos[i] = _value;
    }


    /**
     * Gets the ijopagrupadas value for this Ijtbpro.
     * 
     * @return ijopagrupadas
     */
    public idw.idwws.Ijopagrupada[] getIjopagrupadas() {
        return ijopagrupadas;
    }


    /**
     * Sets the ijopagrupadas value for this Ijtbpro.
     * 
     * @param ijopagrupadas
     */
    public void setIjopagrupadas(idw.idwws.Ijopagrupada[] ijopagrupadas) {
        this.ijopagrupadas = ijopagrupadas;
    }

    public idw.idwws.Ijopagrupada getIjopagrupadas(int i) {
        return this.ijopagrupadas[i];
    }

    public void setIjopagrupadas(int i, idw.idwws.Ijopagrupada _value) {
        this.ijopagrupadas[i] = _value;
    }


    /**
     * Gets the ijoploteses value for this Ijtbpro.
     * 
     * @return ijoploteses
     */
    public idw.idwws.Ijoplotes[] getIjoploteses() {
        return ijoploteses;
    }


    /**
     * Sets the ijoploteses value for this Ijtbpro.
     * 
     * @param ijoploteses
     */
    public void setIjoploteses(idw.idwws.Ijoplotes[] ijoploteses) {
        this.ijoploteses = ijoploteses;
    }

    public idw.idwws.Ijoplotes getIjoploteses(int i) {
        return this.ijoploteses[i];
    }

    public void setIjoploteses(int i, idw.idwws.Ijoplotes _value) {
        this.ijoploteses[i] = _value;
    }


    /**
     * Gets the ijoppmedioprods value for this Ijtbpro.
     * 
     * @return ijoppmedioprods
     */
    public idw.idwws.Ijoppmedioprod[] getIjoppmedioprods() {
        return ijoppmedioprods;
    }


    /**
     * Sets the ijoppmedioprods value for this Ijtbpro.
     * 
     * @param ijoppmedioprods
     */
    public void setIjoppmedioprods(idw.idwws.Ijoppmedioprod[] ijoppmedioprods) {
        this.ijoppmedioprods = ijoppmedioprods;
    }

    public idw.idwws.Ijoppmedioprod getIjoppmedioprods(int i) {
        return this.ijoppmedioprods[i];
    }

    public void setIjoppmedioprods(int i, idw.idwws.Ijoppmedioprod _value) {
        this.ijoppmedioprods[i] = _value;
    }


    /**
     * Gets the ijopprodutoses value for this Ijtbpro.
     * 
     * @return ijopprodutoses
     */
    public idw.idwws.Ijopprodutos[] getIjopprodutoses() {
        return ijopprodutoses;
    }


    /**
     * Sets the ijopprodutoses value for this Ijtbpro.
     * 
     * @param ijopprodutoses
     */
    public void setIjopprodutoses(idw.idwws.Ijopprodutos[] ijopprodutoses) {
        this.ijopprodutoses = ijopprodutoses;
    }

    public idw.idwws.Ijopprodutos getIjopprodutoses(int i) {
        return this.ijopprodutoses[i];
    }

    public void setIjopprodutoses(int i, idw.idwws.Ijopprodutos _value) {
        this.ijopprodutoses[i] = _value;
    }


    /**
     * Gets the ijopproqtopes value for this Ijtbpro.
     * 
     * @return ijopproqtopes
     */
    public idw.idwws.Ijopproqtope[] getIjopproqtopes() {
        return ijopproqtopes;
    }


    /**
     * Sets the ijopproqtopes value for this Ijtbpro.
     * 
     * @param ijopproqtopes
     */
    public void setIjopproqtopes(idw.idwws.Ijopproqtope[] ijopproqtopes) {
        this.ijopproqtopes = ijopproqtopes;
    }

    public idw.idwws.Ijopproqtope getIjopproqtopes(int i) {
        return this.ijopproqtopes[i];
    }

    public void setIjopproqtopes(int i, idw.idwws.Ijopproqtope _value) {
        this.ijopproqtopes[i] = _value;
    }


    /**
     * Gets the ijopsagrupprods value for this Ijtbpro.
     * 
     * @return ijopsagrupprods
     */
    public idw.idwws.Ijopsagrupprod[] getIjopsagrupprods() {
        return ijopsagrupprods;
    }


    /**
     * Sets the ijopsagrupprods value for this Ijtbpro.
     * 
     * @param ijopsagrupprods
     */
    public void setIjopsagrupprods(idw.idwws.Ijopsagrupprod[] ijopsagrupprods) {
        this.ijopsagrupprods = ijopsagrupprods;
    }

    public idw.idwws.Ijopsagrupprod getIjopsagrupprods(int i) {
        return this.ijopsagrupprods[i];
    }

    public void setIjopsagrupprods(int i, idw.idwws.Ijopsagrupprod _value) {
        this.ijopsagrupprods[i] = _value;
    }


    /**
     * Gets the ijprocarteiras value for this Ijtbpro.
     * 
     * @return ijprocarteiras
     */
    public idw.idwws.Ijprocarteira[] getIjprocarteiras() {
        return ijprocarteiras;
    }


    /**
     * Sets the ijprocarteiras value for this Ijtbpro.
     * 
     * @param ijprocarteiras
     */
    public void setIjprocarteiras(idw.idwws.Ijprocarteira[] ijprocarteiras) {
        this.ijprocarteiras = ijprocarteiras;
    }

    public idw.idwws.Ijprocarteira getIjprocarteiras(int i) {
        return this.ijprocarteiras[i];
    }

    public void setIjprocarteiras(int i, idw.idwws.Ijprocarteira _value) {
        this.ijprocarteiras[i] = _value;
    }


    /**
     * Gets the ijprocompmprimacgqs value for this Ijtbpro.
     * 
     * @return ijprocompmprimacgqs
     */
    public idw.idwws.Ijprocompmprimacgq[] getIjprocompmprimacgqs() {
        return ijprocompmprimacgqs;
    }


    /**
     * Sets the ijprocompmprimacgqs value for this Ijtbpro.
     * 
     * @param ijprocompmprimacgqs
     */
    public void setIjprocompmprimacgqs(idw.idwws.Ijprocompmprimacgq[] ijprocompmprimacgqs) {
        this.ijprocompmprimacgqs = ijprocompmprimacgqs;
    }

    public idw.idwws.Ijprocompmprimacgq getIjprocompmprimacgqs(int i) {
        return this.ijprocompmprimacgqs[i];
    }

    public void setIjprocompmprimacgqs(int i, idw.idwws.Ijprocompmprimacgq _value) {
        this.ijprocompmprimacgqs[i] = _value;
    }


    /**
     * Gets the ijprodinspfreqs value for this Ijtbpro.
     * 
     * @return ijprodinspfreqs
     */
    public idw.idwws.Ijprodinspfreq[] getIjprodinspfreqs() {
        return ijprodinspfreqs;
    }


    /**
     * Sets the ijprodinspfreqs value for this Ijtbpro.
     * 
     * @param ijprodinspfreqs
     */
    public void setIjprodinspfreqs(idw.idwws.Ijprodinspfreq[] ijprodinspfreqs) {
        this.ijprodinspfreqs = ijprodinspfreqs;
    }

    public idw.idwws.Ijprodinspfreq getIjprodinspfreqs(int i) {
        return this.ijprodinspfreqs[i];
    }

    public void setIjprodinspfreqs(int i, idw.idwws.Ijprodinspfreq _value) {
        this.ijprodinspfreqs[i] = _value;
    }


    /**
     * Gets the ijprodxgrpparams value for this Ijtbpro.
     * 
     * @return ijprodxgrpparams
     */
    public idw.idwws.Ijprodxgrpparam[] getIjprodxgrpparams() {
        return ijprodxgrpparams;
    }


    /**
     * Sets the ijprodxgrpparams value for this Ijtbpro.
     * 
     * @param ijprodxgrpparams
     */
    public void setIjprodxgrpparams(idw.idwws.Ijprodxgrpparam[] ijprodxgrpparams) {
        this.ijprodxgrpparams = ijprodxgrpparams;
    }

    public idw.idwws.Ijprodxgrpparam getIjprodxgrpparams(int i) {
        return this.ijprodxgrpparams[i];
    }

    public void setIjprodxgrpparams(int i, idw.idwws.Ijprodxgrpparam _value) {
        this.ijprodxgrpparams[i] = _value;
    }


    /**
     * Gets the ijpromolestpadraos value for this Ijtbpro.
     * 
     * @return ijpromolestpadraos
     */
    public idw.idwws.Ijpromolestpadrao[] getIjpromolestpadraos() {
        return ijpromolestpadraos;
    }


    /**
     * Sets the ijpromolestpadraos value for this Ijtbpro.
     * 
     * @param ijpromolestpadraos
     */
    public void setIjpromolestpadraos(idw.idwws.Ijpromolestpadrao[] ijpromolestpadraos) {
        this.ijpromolestpadraos = ijpromolestpadraos;
    }

    public idw.idwws.Ijpromolestpadrao getIjpromolestpadraos(int i) {
        return this.ijpromolestpadraos[i];
    }

    public void setIjpromolestpadraos(int i, idw.idwws.Ijpromolestpadrao _value) {
        this.ijpromolestpadraos[i] = _value;
    }


    /**
     * Gets the ijpropesos value for this Ijtbpro.
     * 
     * @return ijpropesos
     */
    public idw.idwws.Ijpropeso[] getIjpropesos() {
        return ijpropesos;
    }


    /**
     * Sets the ijpropesos value for this Ijtbpro.
     * 
     * @param ijpropesos
     */
    public void setIjpropesos(idw.idwws.Ijpropeso[] ijpropesos) {
        this.ijpropesos = ijpropesos;
    }

    public idw.idwws.Ijpropeso getIjpropesos(int i) {
        return this.ijpropesos[i];
    }

    public void setIjpropesos(int i, idw.idwws.Ijpropeso _value) {
        this.ijpropesos[i] = _value;
    }


    /**
     * Gets the ijproplanos value for this Ijtbpro.
     * 
     * @return ijproplanos
     */
    public idw.idwws.Ijproplano[] getIjproplanos() {
        return ijproplanos;
    }


    /**
     * Sets the ijproplanos value for this Ijtbpro.
     * 
     * @param ijproplanos
     */
    public void setIjproplanos(idw.idwws.Ijproplano[] ijproplanos) {
        this.ijproplanos = ijproplanos;
    }

    public idw.idwws.Ijproplano getIjproplanos(int i) {
        return this.ijproplanos[i];
    }

    public void setIjproplanos(int i, idw.idwws.Ijproplano _value) {
        this.ijproplanos[i] = _value;
    }


    /**
     * Gets the ijproqtopes value for this Ijtbpro.
     * 
     * @return ijproqtopes
     */
    public idw.idwws.Ijproqtope[] getIjproqtopes() {
        return ijproqtopes;
    }


    /**
     * Sets the ijproqtopes value for this Ijtbpro.
     * 
     * @param ijproqtopes
     */
    public void setIjproqtopes(idw.idwws.Ijproqtope[] ijproqtopes) {
        this.ijproqtopes = ijproqtopes;
    }

    public idw.idwws.Ijproqtope getIjproqtopes(int i) {
        return this.ijproqtopes[i];
    }

    public void setIjproqtopes(int i, idw.idwws.Ijproqtope _value) {
        this.ijproqtopes[i] = _value;
    }


    /**
     * Gets the ijprotempolimdbqlds value for this Ijtbpro.
     * 
     * @return ijprotempolimdbqlds
     */
    public idw.idwws.Ijprotempolimdbqld[] getIjprotempolimdbqlds() {
        return ijprotempolimdbqlds;
    }


    /**
     * Sets the ijprotempolimdbqlds value for this Ijtbpro.
     * 
     * @param ijprotempolimdbqlds
     */
    public void setIjprotempolimdbqlds(idw.idwws.Ijprotempolimdbqld[] ijprotempolimdbqlds) {
        this.ijprotempolimdbqlds = ijprotempolimdbqlds;
    }

    public idw.idwws.Ijprotempolimdbqld getIjprotempolimdbqlds(int i) {
        return this.ijprotempolimdbqlds[i];
    }

    public void setIjprotempolimdbqlds(int i, idw.idwws.Ijprotempolimdbqld _value) {
        this.ijprotempolimdbqlds[i] = _value;
    }


    /**
     * Gets the ijproultops value for this Ijtbpro.
     * 
     * @return ijproultops
     */
    public idw.idwws.Ijproultop[] getIjproultops() {
        return ijproultops;
    }


    /**
     * Sets the ijproultops value for this Ijtbpro.
     * 
     * @param ijproultops
     */
    public void setIjproultops(idw.idwws.Ijproultop[] ijproultops) {
        this.ijproultops = ijproultops;
    }

    public idw.idwws.Ijproultop getIjproultops(int i) {
        return this.ijproultops[i];
    }

    public void setIjproultops(int i, idw.idwws.Ijproultop _value) {
        this.ijproultops[i] = _value;
    }


    /**
     * Gets the ijproxgrcarcrtctrls value for this Ijtbpro.
     * 
     * @return ijproxgrcarcrtctrls
     */
    public idw.idwws.Ijproxgrcarcrtctrl[] getIjproxgrcarcrtctrls() {
        return ijproxgrcarcrtctrls;
    }


    /**
     * Sets the ijproxgrcarcrtctrls value for this Ijtbpro.
     * 
     * @param ijproxgrcarcrtctrls
     */
    public void setIjproxgrcarcrtctrls(idw.idwws.Ijproxgrcarcrtctrl[] ijproxgrcarcrtctrls) {
        this.ijproxgrcarcrtctrls = ijproxgrcarcrtctrls;
    }

    public idw.idwws.Ijproxgrcarcrtctrl getIjproxgrcarcrtctrls(int i) {
        return this.ijproxgrcarcrtctrls[i];
    }

    public void setIjproxgrcarcrtctrls(int i, idw.idwws.Ijproxgrcarcrtctrl _value) {
        this.ijproxgrcarcrtctrls[i] = _value;
    }


    /**
     * Gets the ijqldprodnivelinsps value for this Ijtbpro.
     * 
     * @return ijqldprodnivelinsps
     */
    public idw.idwws.Ijqldprodnivelinsp[] getIjqldprodnivelinsps() {
        return ijqldprodnivelinsps;
    }


    /**
     * Sets the ijqldprodnivelinsps value for this Ijtbpro.
     * 
     * @param ijqldprodnivelinsps
     */
    public void setIjqldprodnivelinsps(idw.idwws.Ijqldprodnivelinsp[] ijqldprodnivelinsps) {
        this.ijqldprodnivelinsps = ijqldprodnivelinsps;
    }

    public idw.idwws.Ijqldprodnivelinsp getIjqldprodnivelinsps(int i) {
        return this.ijqldprodnivelinsps[i];
    }

    public void setIjqldprodnivelinsps(int i, idw.idwws.Ijqldprodnivelinsp _value) {
        this.ijqldprodnivelinsps[i] = _value;
    }


    /**
     * Gets the ijreainspprods value for this Ijtbpro.
     * 
     * @return ijreainspprods
     */
    public idw.idwws.Ijreainspprod[] getIjreainspprods() {
        return ijreainspprods;
    }


    /**
     * Sets the ijreainspprods value for this Ijtbpro.
     * 
     * @param ijreainspprods
     */
    public void setIjreainspprods(idw.idwws.Ijreainspprod[] ijreainspprods) {
        this.ijreainspprods = ijreainspprods;
    }

    public idw.idwws.Ijreainspprod getIjreainspprods(int i) {
        return this.ijreainspprods[i];
    }

    public void setIjreainspprods(int i, idw.idwws.Ijreainspprod _value) {
        this.ijreainspprods[i] = _value;
    }


    /**
     * Gets the ijrefextras value for this Ijtbpro.
     * 
     * @return ijrefextras
     */
    public idw.idwws.Ijrefextra[] getIjrefextras() {
        return ijrefextras;
    }


    /**
     * Sets the ijrefextras value for this Ijtbpro.
     * 
     * @param ijrefextras
     */
    public void setIjrefextras(idw.idwws.Ijrefextra[] ijrefextras) {
        this.ijrefextras = ijrefextras;
    }

    public idw.idwws.Ijrefextra getIjrefextras(int i) {
        return this.ijrefextras[i];
    }

    public void setIjrefextras(int i, idw.idwws.Ijrefextra _value) {
        this.ijrefextras[i] = _value;
    }


    /**
     * Gets the ijrelprorefs value for this Ijtbpro.
     * 
     * @return ijrelprorefs
     */
    public idw.idwws.Ijrelproref[] getIjrelprorefs() {
        return ijrelprorefs;
    }


    /**
     * Sets the ijrelprorefs value for this Ijtbpro.
     * 
     * @param ijrelprorefs
     */
    public void setIjrelprorefs(idw.idwws.Ijrelproref[] ijrelprorefs) {
        this.ijrelprorefs = ijrelprorefs;
    }

    public idw.idwws.Ijrelproref getIjrelprorefs(int i) {
        return this.ijrelprorefs[i];
    }

    public void setIjrelprorefs(int i, idw.idwws.Ijrelproref _value) {
        this.ijrelprorefs[i] = _value;
    }


    /**
     * Gets the ijroteiroprodhsts value for this Ijtbpro.
     * 
     * @return ijroteiroprodhsts
     */
    public idw.idwws.Ijroteiroprodhst[] getIjroteiroprodhsts() {
        return ijroteiroprodhsts;
    }


    /**
     * Sets the ijroteiroprodhsts value for this Ijtbpro.
     * 
     * @param ijroteiroprodhsts
     */
    public void setIjroteiroprodhsts(idw.idwws.Ijroteiroprodhst[] ijroteiroprodhsts) {
        this.ijroteiroprodhsts = ijroteiroprodhsts;
    }

    public idw.idwws.Ijroteiroprodhst getIjroteiroprodhsts(int i) {
        return this.ijroteiroprodhsts[i];
    }

    public void setIjroteiroprodhsts(int i, idw.idwws.Ijroteiroprodhst _value) {
        this.ijroteiroprodhsts[i] = _value;
    }


    /**
     * Gets the ijroteiroprods value for this Ijtbpro.
     * 
     * @return ijroteiroprods
     */
    public idw.idwws.Ijroteiroprod[] getIjroteiroprods() {
        return ijroteiroprods;
    }


    /**
     * Sets the ijroteiroprods value for this Ijtbpro.
     * 
     * @param ijroteiroprods
     */
    public void setIjroteiroprods(idw.idwws.Ijroteiroprod[] ijroteiroprods) {
        this.ijroteiroprods = ijroteiroprods;
    }

    public idw.idwws.Ijroteiroprod getIjroteiroprods(int i) {
        return this.ijroteiroprods[i];
    }

    public void setIjroteiroprods(int i, idw.idwws.Ijroteiroprod _value) {
        this.ijroteiroprods[i] = _value;
    }


    /**
     * Gets the ijtbprocfgespqlds value for this Ijtbpro.
     * 
     * @return ijtbprocfgespqlds
     */
    public idw.idwws.Ijtbprocfgespqld[] getIjtbprocfgespqlds() {
        return ijtbprocfgespqlds;
    }


    /**
     * Sets the ijtbprocfgespqlds value for this Ijtbpro.
     * 
     * @param ijtbprocfgespqlds
     */
    public void setIjtbprocfgespqlds(idw.idwws.Ijtbprocfgespqld[] ijtbprocfgespqlds) {
        this.ijtbprocfgespqlds = ijtbprocfgespqlds;
    }

    public idw.idwws.Ijtbprocfgespqld getIjtbprocfgespqlds(int i) {
        return this.ijtbprocfgespqlds[i];
    }

    public void setIjtbprocfgespqlds(int i, idw.idwws.Ijtbprocfgespqld _value) {
        this.ijtbprocfgespqlds[i] = _value;
    }


    /**
     * Gets the ijtbprocgqs value for this Ijtbpro.
     * 
     * @return ijtbprocgqs
     */
    public idw.idwws.Ijtbprocgq[] getIjtbprocgqs() {
        return ijtbprocgqs;
    }


    /**
     * Sets the ijtbprocgqs value for this Ijtbpro.
     * 
     * @param ijtbprocgqs
     */
    public void setIjtbprocgqs(idw.idwws.Ijtbprocgq[] ijtbprocgqs) {
        this.ijtbprocgqs = ijtbprocgqs;
    }

    public idw.idwws.Ijtbprocgq getIjtbprocgqs(int i) {
        return this.ijtbprocgqs[i];
    }

    public void setIjtbprocgqs(int i, idw.idwws.Ijtbprocgq _value) {
        this.ijtbprocgqs[i] = _value;
    }


    /**
     * Gets the ijtbprodeflotes value for this Ijtbpro.
     * 
     * @return ijtbprodeflotes
     */
    public idw.idwws.Ijtbprodeflote[] getIjtbprodeflotes() {
        return ijtbprodeflotes;
    }


    /**
     * Sets the ijtbprodeflotes value for this Ijtbpro.
     * 
     * @param ijtbprodeflotes
     */
    public void setIjtbprodeflotes(idw.idwws.Ijtbprodeflote[] ijtbprodeflotes) {
        this.ijtbprodeflotes = ijtbprodeflotes;
    }

    public idw.idwws.Ijtbprodeflote getIjtbprodeflotes(int i) {
        return this.ijtbprodeflotes[i];
    }

    public void setIjtbprodeflotes(int i, idw.idwws.Ijtbprodeflote _value) {
        this.ijtbprodeflotes[i] = _value;
    }


    /**
     * Gets the ijtbprodesconts value for this Ijtbpro.
     * 
     * @return ijtbprodesconts
     */
    public idw.idwws.Ijtbprodescont[] getIjtbprodesconts() {
        return ijtbprodesconts;
    }


    /**
     * Sets the ijtbprodesconts value for this Ijtbpro.
     * 
     * @param ijtbprodesconts
     */
    public void setIjtbprodesconts(idw.idwws.Ijtbprodescont[] ijtbprodesconts) {
        this.ijtbprodesconts = ijtbprodesconts;
    }

    public idw.idwws.Ijtbprodescont getIjtbprodesconts(int i) {
        return this.ijtbprodesconts[i];
    }

    public void setIjtbprodesconts(int i, idw.idwws.Ijtbprodescont _value) {
        this.ijtbprodesconts[i] = _value;
    }


    /**
     * Gets the ijtbprousus value for this Ijtbpro.
     * 
     * @return ijtbprousus
     */
    public idw.idwws.Ijtbprousu[] getIjtbprousus() {
        return ijtbprousus;
    }


    /**
     * Sets the ijtbprousus value for this Ijtbpro.
     * 
     * @param ijtbprousus
     */
    public void setIjtbprousus(idw.idwws.Ijtbprousu[] ijtbprousus) {
        this.ijtbprousus = ijtbprousus;
    }

    public idw.idwws.Ijtbprousu getIjtbprousus(int i) {
        return this.ijtbprousus[i];
    }

    public void setIjtbprousus(int i, idw.idwws.Ijtbprousu _value) {
        this.ijtbprousus[i] = _value;
    }


    /**
     * Gets the ijversaoproducaos value for this Ijtbpro.
     * 
     * @return ijversaoproducaos
     */
    public idw.idwws.Ijversaoproducao[] getIjversaoproducaos() {
        return ijversaoproducaos;
    }


    /**
     * Sets the ijversaoproducaos value for this Ijtbpro.
     * 
     * @param ijversaoproducaos
     */
    public void setIjversaoproducaos(idw.idwws.Ijversaoproducao[] ijversaoproducaos) {
        this.ijversaoproducaos = ijversaoproducaos;
    }

    public idw.idwws.Ijversaoproducao getIjversaoproducaos(int i) {
        return this.ijversaoproducaos[i];
    }

    public void setIjversaoproducaos(int i, idw.idwws.Ijversaoproducao _value) {
        this.ijversaoproducaos[i] = _value;
    }


    /**
     * Gets the pbrutomedio value for this Ijtbpro.
     * 
     * @return pbrutomedio
     */
    public java.lang.Double getPbrutomedio() {
        return pbrutomedio;
    }


    /**
     * Sets the pbrutomedio value for this Ijtbpro.
     * 
     * @param pbrutomedio
     */
    public void setPbrutomedio(java.lang.Double pbrutomedio) {
        this.pbrutomedio = pbrutomedio;
    }


    /**
     * Gets the perclotekanban value for this Ijtbpro.
     * 
     * @return perclotekanban
     */
    public java.lang.Double getPerclotekanban() {
        return perclotekanban;
    }


    /**
     * Sets the perclotekanban value for this Ijtbpro.
     * 
     * @param perclotekanban
     */
    public void setPerclotekanban(java.lang.Double perclotekanban) {
        this.perclotekanban = perclotekanban;
    }


    /**
     * Gets the pliquidomedio value for this Ijtbpro.
     * 
     * @return pliquidomedio
     */
    public java.lang.Double getPliquidomedio() {
        return pliquidomedio;
    }


    /**
     * Sets the pliquidomedio value for this Ijtbpro.
     * 
     * @param pliquidomedio
     */
    public void setPliquidomedio(java.lang.Double pliquidomedio) {
        this.pliquidomedio = pliquidomedio;
    }


    /**
     * Gets the tamlotekanban value for this Ijtbpro.
     * 
     * @return tamlotekanban
     */
    public java.math.BigDecimal getTamlotekanban() {
        return tamlotekanban;
    }


    /**
     * Sets the tamlotekanban value for this Ijtbpro.
     * 
     * @param tamlotekanban
     */
    public void setTamlotekanban(java.math.BigDecimal tamlotekanban) {
        this.tamlotekanban = tamlotekanban;
    }


    /**
     * Gets the tampulmaomax value for this Ijtbpro.
     * 
     * @return tampulmaomax
     */
    public java.lang.Double getTampulmaomax() {
        return tampulmaomax;
    }


    /**
     * Sets the tampulmaomax value for this Ijtbpro.
     * 
     * @param tampulmaomax
     */
    public void setTampulmaomax(java.lang.Double tampulmaomax) {
        this.tampulmaomax = tampulmaomax;
    }


    /**
     * Gets the tampulmaomin value for this Ijtbpro.
     * 
     * @return tampulmaomin
     */
    public java.lang.Double getTampulmaomin() {
        return tampulmaomin;
    }


    /**
     * Sets the tampulmaomin value for this Ijtbpro.
     * 
     * @param tampulmaomin
     */
    public void setTampulmaomin(java.lang.Double tampulmaomin) {
        this.tampulmaomin = tampulmaomin;
    }


    /**
     * Gets the tampulmaopadrao value for this Ijtbpro.
     * 
     * @return tampulmaopadrao
     */
    public java.lang.Double getTampulmaopadrao() {
        return tampulmaopadrao;
    }


    /**
     * Sets the tampulmaopadrao value for this Ijtbpro.
     * 
     * @param tampulmaopadrao
     */
    public void setTampulmaopadrao(java.lang.Double tampulmaopadrao) {
        this.tampulmaopadrao = tampulmaopadrao;
    }


    /**
     * Gets the temperaturamaxestu value for this Ijtbpro.
     * 
     * @return temperaturamaxestu
     */
    public java.lang.Double getTemperaturamaxestu() {
        return temperaturamaxestu;
    }


    /**
     * Sets the temperaturamaxestu value for this Ijtbpro.
     * 
     * @param temperaturamaxestu
     */
    public void setTemperaturamaxestu(java.lang.Double temperaturamaxestu) {
        this.temperaturamaxestu = temperaturamaxestu;
    }


    /**
     * Gets the temperaturaminestu value for this Ijtbpro.
     * 
     * @return temperaturaminestu
     */
    public java.lang.Double getTemperaturaminestu() {
        return temperaturaminestu;
    }


    /**
     * Sets the temperaturaminestu value for this Ijtbpro.
     * 
     * @param temperaturaminestu
     */
    public void setTemperaturaminestu(java.lang.Double temperaturaminestu) {
        this.temperaturaminestu = temperaturaminestu;
    }


    /**
     * Gets the tempomaxestufagem value for this Ijtbpro.
     * 
     * @return tempomaxestufagem
     */
    public java.lang.Double getTempomaxestufagem() {
        return tempomaxestufagem;
    }


    /**
     * Sets the tempomaxestufagem value for this Ijtbpro.
     * 
     * @param tempomaxestufagem
     */
    public void setTempomaxestufagem(java.lang.Double tempomaxestufagem) {
        this.tempomaxestufagem = tempomaxestufagem;
    }


    /**
     * Gets the tempominestufagem value for this Ijtbpro.
     * 
     * @return tempominestufagem
     */
    public java.lang.Double getTempominestufagem() {
        return tempominestufagem;
    }


    /**
     * Sets the tempominestufagem value for this Ijtbpro.
     * 
     * @param tempominestufagem
     */
    public void setTempominestufagem(java.lang.Double tempominestufagem) {
        this.tempominestufagem = tempominestufagem;
    }


    /**
     * Gets the tmpliminspqld value for this Ijtbpro.
     * 
     * @return tmpliminspqld
     */
    public java.math.BigDecimal getTmpliminspqld() {
        return tmpliminspqld;
    }


    /**
     * Sets the tmpliminspqld value for this Ijtbpro.
     * 
     * @param tmpliminspqld
     */
    public void setTmpliminspqld(java.math.BigDecimal tmpliminspqld) {
        this.tmpliminspqld = tmpliminspqld;
    }


    /**
     * Gets the tmptrocaprdt value for this Ijtbpro.
     * 
     * @return tmptrocaprdt
     */
    public java.math.BigDecimal getTmptrocaprdt() {
        return tmptrocaprdt;
    }


    /**
     * Sets the tmptrocaprdt value for this Ijtbpro.
     * 
     * @param tmptrocaprdt
     */
    public void setTmptrocaprdt(java.math.BigDecimal tmptrocaprdt) {
        this.tmptrocaprdt = tmptrocaprdt;
    }


    /**
     * Gets the tmptrocapstc value for this Ijtbpro.
     * 
     * @return tmptrocapstc
     */
    public java.math.BigDecimal getTmptrocapstc() {
        return tmptrocapstc;
    }


    /**
     * Sets the tmptrocapstc value for this Ijtbpro.
     * 
     * @param tmptrocapstc
     */
    public void setTmptrocapstc(java.math.BigDecimal tmptrocapstc) {
        this.tmptrocapstc = tmptrocapstc;
    }


    /**
     * Gets the tpinspqld value for this Ijtbpro.
     * 
     * @return tpinspqld
     */
    public org.apache.axis.types.UnsignedShort getTpinspqld() {
        return tpinspqld;
    }


    /**
     * Sets the tpinspqld value for this Ijtbpro.
     * 
     * @param tpinspqld
     */
    public void setTpinspqld(org.apache.axis.types.UnsignedShort tpinspqld) {
        this.tpinspqld = tpinspqld;
    }


    /**
     * Gets the tpproduto value for this Ijtbpro.
     * 
     * @return tpproduto
     */
    public java.math.BigDecimal getTpproduto() {
        return tpproduto;
    }


    /**
     * Sets the tpproduto value for this Ijtbpro.
     * 
     * @param tpproduto
     */
    public void setTpproduto(java.math.BigDecimal tpproduto) {
        this.tpproduto = tpproduto;
    }


    /**
     * Gets the unidmedsap value for this Ijtbpro.
     * 
     * @return unidmedsap
     */
    public java.lang.String getUnidmedsap() {
        return unidmedsap;
    }


    /**
     * Sets the unidmedsap value for this Ijtbpro.
     * 
     * @param unidmedsap
     */
    public void setUnidmedsap(java.lang.String unidmedsap) {
        this.unidmedsap = unidmedsap;
    }


    /**
     * Gets the unproduto value for this Ijtbpro.
     * 
     * @return unproduto
     */
    public java.lang.String getUnproduto() {
        return unproduto;
    }


    /**
     * Sets the unproduto value for this Ijtbpro.
     * 
     * @param unproduto
     */
    public void setUnproduto(java.lang.String unproduto) {
        this.unproduto = unproduto;
    }


    /**
     * Gets the vlproduto value for this Ijtbpro.
     * 
     * @return vlproduto
     */
    public java.lang.Double getVlproduto() {
        return vlproduto;
    }


    /**
     * Sets the vlproduto value for this Ijtbpro.
     * 
     * @param vlproduto
     */
    public void setVlproduto(java.lang.Double vlproduto) {
        this.vlproduto = vlproduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbpro)) return false;
        Ijtbpro other = (Ijtbpro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acabamento==null && other.getAcabamento()==null) || 
             (this.acabamento!=null &&
              this.acabamento.equals(other.getAcabamento()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.classificacao==null && other.getClassificacao()==null) || 
             (this.classificacao!=null &&
              this.classificacao.equals(other.getClassificacao()))) &&
            ((this.cor==null && other.getCor()==null) || 
             (this.cor!=null &&
              this.cor.equals(other.getCor()))) &&
            ((this.dsproduto==null && other.getDsproduto()==null) || 
             (this.dsproduto!=null &&
              this.dsproduto.equals(other.getDsproduto()))) &&
            ((this.espessura==null && other.getEspessura()==null) || 
             (this.espessura!=null &&
              this.espessura.equals(other.getEspessura()))) &&
            ((this.exportacao004S==null && other.getExportacao004S()==null) || 
             (this.exportacao004S!=null &&
              java.util.Arrays.equals(this.exportacao004S, other.getExportacao004S()))) &&
            ((this.fatorconversao==null && other.getFatorconversao()==null) || 
             (this.fatorconversao!=null &&
              this.fatorconversao.equals(other.getFatorconversao()))) &&
            ((this.idproduto==null && other.getIdproduto()==null) || 
             (this.idproduto!=null &&
              this.idproduto.equals(other.getIdproduto()))) &&
            ((this.ijaledbqlds==null && other.getIjaledbqlds()==null) || 
             (this.ijaledbqlds!=null &&
              java.util.Arrays.equals(this.ijaledbqlds, other.getIjaledbqlds()))) &&
            ((this.ijbroneprosecaosForCdproduto==null && other.getIjbroneprosecaosForCdproduto()==null) || 
             (this.ijbroneprosecaosForCdproduto!=null &&
              java.util.Arrays.equals(this.ijbroneprosecaosForCdproduto, other.getIjbroneprosecaosForCdproduto()))) &&
            ((this.ijbroneprosecaosForCdprodutocomp==null && other.getIjbroneprosecaosForCdprodutocomp()==null) || 
             (this.ijbroneprosecaosForCdprodutocomp!=null &&
              java.util.Arrays.equals(this.ijbroneprosecaosForCdprodutocomp, other.getIjbroneprosecaosForCdprodutocomp()))) &&
            ((this.ijbroneproseccomps==null && other.getIjbroneproseccomps()==null) || 
             (this.ijbroneproseccomps!=null &&
              java.util.Arrays.equals(this.ijbroneproseccomps, other.getIjbroneproseccomps()))) &&
            ((this.ijcomppromprimas==null && other.getIjcomppromprimas()==null) || 
             (this.ijcomppromprimas!=null &&
              java.util.Arrays.equals(this.ijcomppromprimas, other.getIjcomppromprimas()))) &&
            ((this.ijctrlcgqalts==null && other.getIjctrlcgqalts()==null) || 
             (this.ijctrlcgqalts!=null &&
              java.util.Arrays.equals(this.ijctrlcgqalts, other.getIjctrlcgqalts()))) &&
            ((this.ijctrlcgqs==null && other.getIjctrlcgqs()==null) || 
             (this.ijctrlcgqs!=null &&
              java.util.Arrays.equals(this.ijctrlcgqs, other.getIjctrlcgqs()))) &&
            ((this.ijdeparapros==null && other.getIjdeparapros()==null) || 
             (this.ijdeparapros!=null &&
              java.util.Arrays.equals(this.ijdeparapros, other.getIjdeparapros()))) &&
            ((this.ijembaponts==null && other.getIjembaponts()==null) || 
             (this.ijembaponts!=null &&
              java.util.Arrays.equals(this.ijembaponts, other.getIjembaponts()))) &&
            ((this.ijespecinsppros==null && other.getIjespecinsppros()==null) || 
             (this.ijespecinsppros!=null &&
              java.util.Arrays.equals(this.ijespecinsppros, other.getIjespecinsppros()))) &&
            ((this.ijespecinsproatribs==null && other.getIjespecinsproatribs()==null) || 
             (this.ijespecinsproatribs!=null &&
              java.util.Arrays.equals(this.ijespecinsproatribs, other.getIjespecinsproatribs()))) &&
            ((this.ijestruprodsForCdproduto==null && other.getIjestruprodsForCdproduto()==null) || 
             (this.ijestruprodsForCdproduto!=null &&
              java.util.Arrays.equals(this.ijestruprodsForCdproduto, other.getIjestruprodsForCdproduto()))) &&
            ((this.ijestruprodsForCdprodutoseq==null && other.getIjestruprodsForCdprodutoseq()==null) || 
             (this.ijestruprodsForCdprodutoseq!=null &&
              java.util.Arrays.equals(this.ijestruprodsForCdprodutoseq, other.getIjestruprodsForCdprodutoseq()))) &&
            ((this.ijetqfaixas==null && other.getIjetqfaixas()==null) || 
             (this.ijetqfaixas!=null &&
              java.util.Arrays.equals(this.ijetqfaixas, other.getIjetqfaixas()))) &&
            ((this.ijetqprodutos==null && other.getIjetqprodutos()==null) || 
             (this.ijetqprodutos!=null &&
              java.util.Arrays.equals(this.ijetqprodutos, other.getIjetqprodutos()))) &&
            ((this.ijfilakanbanintbets==null && other.getIjfilakanbanintbets()==null) || 
             (this.ijfilakanbanintbets!=null &&
              java.util.Arrays.equals(this.ijfilakanbanintbets, other.getIjfilakanbanintbets()))) &&
            ((this.ijgrpdetprocgqs==null && other.getIjgrpdetprocgqs()==null) || 
             (this.ijgrpdetprocgqs!=null &&
              java.util.Arrays.equals(this.ijgrpdetprocgqs, other.getIjgrpdetprocgqs()))) &&
            ((this.ijgrpdetpros==null && other.getIjgrpdetpros()==null) || 
             (this.ijgrpdetpros!=null &&
              java.util.Arrays.equals(this.ijgrpdetpros, other.getIjgrpdetpros()))) &&
            ((this.ijkanbanidcartaos==null && other.getIjkanbanidcartaos()==null) || 
             (this.ijkanbanidcartaos!=null &&
              java.util.Arrays.equals(this.ijkanbanidcartaos, other.getIjkanbanidcartaos()))) &&
            ((this.ijkanbanlotes==null && other.getIjkanbanlotes()==null) || 
             (this.ijkanbanlotes!=null &&
              java.util.Arrays.equals(this.ijkanbanlotes, other.getIjkanbanlotes()))) &&
            ((this.ijmdoalocmaqs==null && other.getIjmdoalocmaqs()==null) || 
             (this.ijmdoalocmaqs!=null &&
              java.util.Arrays.equals(this.ijmdoalocmaqs, other.getIjmdoalocmaqs()))) &&
            ((this.ijmdoalocs==null && other.getIjmdoalocs()==null) || 
             (this.ijmdoalocs!=null &&
              java.util.Arrays.equals(this.ijmdoalocs, other.getIjmdoalocs()))) &&
            ((this.ijmolproautorizpros==null && other.getIjmolproautorizpros()==null) || 
             (this.ijmolproautorizpros!=null &&
              java.util.Arrays.equals(this.ijmolproautorizpros, other.getIjmolproautorizpros()))) &&
            ((this.ijmolpros==null && other.getIjmolpros()==null) || 
             (this.ijmolpros!=null &&
              java.util.Arrays.equals(this.ijmolpros, other.getIjmolpros()))) &&
            ((this.ijocorvarritmos==null && other.getIjocorvarritmos()==null) || 
             (this.ijocorvarritmos!=null &&
              java.util.Arrays.equals(this.ijocorvarritmos, other.getIjocorvarritmos()))) &&
            ((this.ijopagrupadas==null && other.getIjopagrupadas()==null) || 
             (this.ijopagrupadas!=null &&
              java.util.Arrays.equals(this.ijopagrupadas, other.getIjopagrupadas()))) &&
            ((this.ijoploteses==null && other.getIjoploteses()==null) || 
             (this.ijoploteses!=null &&
              java.util.Arrays.equals(this.ijoploteses, other.getIjoploteses()))) &&
            ((this.ijoppmedioprods==null && other.getIjoppmedioprods()==null) || 
             (this.ijoppmedioprods!=null &&
              java.util.Arrays.equals(this.ijoppmedioprods, other.getIjoppmedioprods()))) &&
            ((this.ijopprodutoses==null && other.getIjopprodutoses()==null) || 
             (this.ijopprodutoses!=null &&
              java.util.Arrays.equals(this.ijopprodutoses, other.getIjopprodutoses()))) &&
            ((this.ijopproqtopes==null && other.getIjopproqtopes()==null) || 
             (this.ijopproqtopes!=null &&
              java.util.Arrays.equals(this.ijopproqtopes, other.getIjopproqtopes()))) &&
            ((this.ijopsagrupprods==null && other.getIjopsagrupprods()==null) || 
             (this.ijopsagrupprods!=null &&
              java.util.Arrays.equals(this.ijopsagrupprods, other.getIjopsagrupprods()))) &&
            ((this.ijprocarteiras==null && other.getIjprocarteiras()==null) || 
             (this.ijprocarteiras!=null &&
              java.util.Arrays.equals(this.ijprocarteiras, other.getIjprocarteiras()))) &&
            ((this.ijprocompmprimacgqs==null && other.getIjprocompmprimacgqs()==null) || 
             (this.ijprocompmprimacgqs!=null &&
              java.util.Arrays.equals(this.ijprocompmprimacgqs, other.getIjprocompmprimacgqs()))) &&
            ((this.ijprodinspfreqs==null && other.getIjprodinspfreqs()==null) || 
             (this.ijprodinspfreqs!=null &&
              java.util.Arrays.equals(this.ijprodinspfreqs, other.getIjprodinspfreqs()))) &&
            ((this.ijprodxgrpparams==null && other.getIjprodxgrpparams()==null) || 
             (this.ijprodxgrpparams!=null &&
              java.util.Arrays.equals(this.ijprodxgrpparams, other.getIjprodxgrpparams()))) &&
            ((this.ijpromolestpadraos==null && other.getIjpromolestpadraos()==null) || 
             (this.ijpromolestpadraos!=null &&
              java.util.Arrays.equals(this.ijpromolestpadraos, other.getIjpromolestpadraos()))) &&
            ((this.ijpropesos==null && other.getIjpropesos()==null) || 
             (this.ijpropesos!=null &&
              java.util.Arrays.equals(this.ijpropesos, other.getIjpropesos()))) &&
            ((this.ijproplanos==null && other.getIjproplanos()==null) || 
             (this.ijproplanos!=null &&
              java.util.Arrays.equals(this.ijproplanos, other.getIjproplanos()))) &&
            ((this.ijproqtopes==null && other.getIjproqtopes()==null) || 
             (this.ijproqtopes!=null &&
              java.util.Arrays.equals(this.ijproqtopes, other.getIjproqtopes()))) &&
            ((this.ijprotempolimdbqlds==null && other.getIjprotempolimdbqlds()==null) || 
             (this.ijprotempolimdbqlds!=null &&
              java.util.Arrays.equals(this.ijprotempolimdbqlds, other.getIjprotempolimdbqlds()))) &&
            ((this.ijproultops==null && other.getIjproultops()==null) || 
             (this.ijproultops!=null &&
              java.util.Arrays.equals(this.ijproultops, other.getIjproultops()))) &&
            ((this.ijproxgrcarcrtctrls==null && other.getIjproxgrcarcrtctrls()==null) || 
             (this.ijproxgrcarcrtctrls!=null &&
              java.util.Arrays.equals(this.ijproxgrcarcrtctrls, other.getIjproxgrcarcrtctrls()))) &&
            ((this.ijqldprodnivelinsps==null && other.getIjqldprodnivelinsps()==null) || 
             (this.ijqldprodnivelinsps!=null &&
              java.util.Arrays.equals(this.ijqldprodnivelinsps, other.getIjqldprodnivelinsps()))) &&
            ((this.ijreainspprods==null && other.getIjreainspprods()==null) || 
             (this.ijreainspprods!=null &&
              java.util.Arrays.equals(this.ijreainspprods, other.getIjreainspprods()))) &&
            ((this.ijrefextras==null && other.getIjrefextras()==null) || 
             (this.ijrefextras!=null &&
              java.util.Arrays.equals(this.ijrefextras, other.getIjrefextras()))) &&
            ((this.ijrelprorefs==null && other.getIjrelprorefs()==null) || 
             (this.ijrelprorefs!=null &&
              java.util.Arrays.equals(this.ijrelprorefs, other.getIjrelprorefs()))) &&
            ((this.ijroteiroprodhsts==null && other.getIjroteiroprodhsts()==null) || 
             (this.ijroteiroprodhsts!=null &&
              java.util.Arrays.equals(this.ijroteiroprodhsts, other.getIjroteiroprodhsts()))) &&
            ((this.ijroteiroprods==null && other.getIjroteiroprods()==null) || 
             (this.ijroteiroprods!=null &&
              java.util.Arrays.equals(this.ijroteiroprods, other.getIjroteiroprods()))) &&
            ((this.ijtbprocfgespqlds==null && other.getIjtbprocfgespqlds()==null) || 
             (this.ijtbprocfgespqlds!=null &&
              java.util.Arrays.equals(this.ijtbprocfgespqlds, other.getIjtbprocfgespqlds()))) &&
            ((this.ijtbprocgqs==null && other.getIjtbprocgqs()==null) || 
             (this.ijtbprocgqs!=null &&
              java.util.Arrays.equals(this.ijtbprocgqs, other.getIjtbprocgqs()))) &&
            ((this.ijtbprodeflotes==null && other.getIjtbprodeflotes()==null) || 
             (this.ijtbprodeflotes!=null &&
              java.util.Arrays.equals(this.ijtbprodeflotes, other.getIjtbprodeflotes()))) &&
            ((this.ijtbprodesconts==null && other.getIjtbprodesconts()==null) || 
             (this.ijtbprodesconts!=null &&
              java.util.Arrays.equals(this.ijtbprodesconts, other.getIjtbprodesconts()))) &&
            ((this.ijtbprousus==null && other.getIjtbprousus()==null) || 
             (this.ijtbprousus!=null &&
              java.util.Arrays.equals(this.ijtbprousus, other.getIjtbprousus()))) &&
            ((this.ijversaoproducaos==null && other.getIjversaoproducaos()==null) || 
             (this.ijversaoproducaos!=null &&
              java.util.Arrays.equals(this.ijversaoproducaos, other.getIjversaoproducaos()))) &&
            ((this.pbrutomedio==null && other.getPbrutomedio()==null) || 
             (this.pbrutomedio!=null &&
              this.pbrutomedio.equals(other.getPbrutomedio()))) &&
            ((this.perclotekanban==null && other.getPerclotekanban()==null) || 
             (this.perclotekanban!=null &&
              this.perclotekanban.equals(other.getPerclotekanban()))) &&
            ((this.pliquidomedio==null && other.getPliquidomedio()==null) || 
             (this.pliquidomedio!=null &&
              this.pliquidomedio.equals(other.getPliquidomedio()))) &&
            ((this.tamlotekanban==null && other.getTamlotekanban()==null) || 
             (this.tamlotekanban!=null &&
              this.tamlotekanban.equals(other.getTamlotekanban()))) &&
            ((this.tampulmaomax==null && other.getTampulmaomax()==null) || 
             (this.tampulmaomax!=null &&
              this.tampulmaomax.equals(other.getTampulmaomax()))) &&
            ((this.tampulmaomin==null && other.getTampulmaomin()==null) || 
             (this.tampulmaomin!=null &&
              this.tampulmaomin.equals(other.getTampulmaomin()))) &&
            ((this.tampulmaopadrao==null && other.getTampulmaopadrao()==null) || 
             (this.tampulmaopadrao!=null &&
              this.tampulmaopadrao.equals(other.getTampulmaopadrao()))) &&
            ((this.temperaturamaxestu==null && other.getTemperaturamaxestu()==null) || 
             (this.temperaturamaxestu!=null &&
              this.temperaturamaxestu.equals(other.getTemperaturamaxestu()))) &&
            ((this.temperaturaminestu==null && other.getTemperaturaminestu()==null) || 
             (this.temperaturaminestu!=null &&
              this.temperaturaminestu.equals(other.getTemperaturaminestu()))) &&
            ((this.tempomaxestufagem==null && other.getTempomaxestufagem()==null) || 
             (this.tempomaxestufagem!=null &&
              this.tempomaxestufagem.equals(other.getTempomaxestufagem()))) &&
            ((this.tempominestufagem==null && other.getTempominestufagem()==null) || 
             (this.tempominestufagem!=null &&
              this.tempominestufagem.equals(other.getTempominestufagem()))) &&
            ((this.tmpliminspqld==null && other.getTmpliminspqld()==null) || 
             (this.tmpliminspqld!=null &&
              this.tmpliminspqld.equals(other.getTmpliminspqld()))) &&
            ((this.tmptrocaprdt==null && other.getTmptrocaprdt()==null) || 
             (this.tmptrocaprdt!=null &&
              this.tmptrocaprdt.equals(other.getTmptrocaprdt()))) &&
            ((this.tmptrocapstc==null && other.getTmptrocapstc()==null) || 
             (this.tmptrocapstc!=null &&
              this.tmptrocapstc.equals(other.getTmptrocapstc()))) &&
            ((this.tpinspqld==null && other.getTpinspqld()==null) || 
             (this.tpinspqld!=null &&
              this.tpinspqld.equals(other.getTpinspqld()))) &&
            ((this.tpproduto==null && other.getTpproduto()==null) || 
             (this.tpproduto!=null &&
              this.tpproduto.equals(other.getTpproduto()))) &&
            ((this.unidmedsap==null && other.getUnidmedsap()==null) || 
             (this.unidmedsap!=null &&
              this.unidmedsap.equals(other.getUnidmedsap()))) &&
            ((this.unproduto==null && other.getUnproduto()==null) || 
             (this.unproduto!=null &&
              this.unproduto.equals(other.getUnproduto()))) &&
            ((this.vlproduto==null && other.getVlproduto()==null) || 
             (this.vlproduto!=null &&
              this.vlproduto.equals(other.getVlproduto())));
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
        if (getAcabamento() != null) {
            _hashCode += getAcabamento().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getClassificacao() != null) {
            _hashCode += getClassificacao().hashCode();
        }
        if (getCor() != null) {
            _hashCode += getCor().hashCode();
        }
        if (getDsproduto() != null) {
            _hashCode += getDsproduto().hashCode();
        }
        if (getEspessura() != null) {
            _hashCode += getEspessura().hashCode();
        }
        if (getExportacao004S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao004S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao004S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFatorconversao() != null) {
            _hashCode += getFatorconversao().hashCode();
        }
        if (getIdproduto() != null) {
            _hashCode += getIdproduto().hashCode();
        }
        if (getIjaledbqlds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjaledbqlds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjaledbqlds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjbroneprosecaosForCdproduto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjbroneprosecaosForCdproduto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjbroneprosecaosForCdproduto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjbroneprosecaosForCdprodutocomp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjbroneprosecaosForCdprodutocomp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjbroneprosecaosForCdprodutocomp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjbroneproseccomps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjbroneproseccomps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjbroneproseccomps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcomppromprimas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcomppromprimas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcomppromprimas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlcgqalts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqalts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqalts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjdeparapros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdeparapros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdeparapros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjembaponts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjembaponts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjembaponts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjespecinsppros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjespecinsppros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjespecinsppros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjespecinsproatribs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjespecinsproatribs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjespecinsproatribs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjestruprodsForCdproduto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjestruprodsForCdproduto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjestruprodsForCdproduto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjestruprodsForCdprodutoseq() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjestruprodsForCdprodutoseq());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjestruprodsForCdprodutoseq(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjetqfaixas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjetqfaixas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjetqfaixas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjetqprodutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjetqprodutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjetqprodutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjfilakanbanintbets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfilakanbanintbets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfilakanbanintbets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpdetprocgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetprocgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetprocgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpdetpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanidcartaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanidcartaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanidcartaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanlotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanlotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanlotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmdoalocmaqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmdoalocmaqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmdoalocmaqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmdoalocs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmdoalocs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmdoalocs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmolproautorizpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproautorizpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproautorizpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmolpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjocorvarritmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjocorvarritmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjocorvarritmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopagrupadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopagrupadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopagrupadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoploteses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoploteses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoploteses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoppmedioprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoppmedioprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoppmedioprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopprodutoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopprodutoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopprodutoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopproqtopes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopproqtopes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopproqtopes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopsagrupprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopsagrupprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopsagrupprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjprocarteiras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprocarteiras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprocarteiras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjprocompmprimacgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprocompmprimacgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprocompmprimacgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjprodinspfreqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprodinspfreqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprodinspfreqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjprodxgrpparams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprodxgrpparams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprodxgrpparams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpromolestpadraos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpromolestpadraos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpromolestpadraos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpropesos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpropesos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpropesos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjproplanos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjproplanos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjproplanos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjproqtopes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjproqtopes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjproqtopes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjprotempolimdbqlds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprotempolimdbqlds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprotempolimdbqlds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjproultops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjproultops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjproultops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjproxgrcarcrtctrls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjproxgrcarcrtctrls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjproxgrcarcrtctrls(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjqldprodnivelinsps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjqldprodnivelinsps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjqldprodnivelinsps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreainspprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreainspprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreainspprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrefextras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrefextras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrefextras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrelprorefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrelprorefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrelprorefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjroteiroprodhsts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjroteiroprodhsts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjroteiroprodhsts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjroteiroprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjroteiroprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjroteiroprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbprocfgespqlds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbprocfgespqlds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbprocfgespqlds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbprocgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbprocgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbprocgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbprodeflotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbprodeflotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbprodeflotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbprodesconts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbprodesconts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbprodesconts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbprousus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbprousus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbprousus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjversaoproducaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjversaoproducaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjversaoproducaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPbrutomedio() != null) {
            _hashCode += getPbrutomedio().hashCode();
        }
        if (getPerclotekanban() != null) {
            _hashCode += getPerclotekanban().hashCode();
        }
        if (getPliquidomedio() != null) {
            _hashCode += getPliquidomedio().hashCode();
        }
        if (getTamlotekanban() != null) {
            _hashCode += getTamlotekanban().hashCode();
        }
        if (getTampulmaomax() != null) {
            _hashCode += getTampulmaomax().hashCode();
        }
        if (getTampulmaomin() != null) {
            _hashCode += getTampulmaomin().hashCode();
        }
        if (getTampulmaopadrao() != null) {
            _hashCode += getTampulmaopadrao().hashCode();
        }
        if (getTemperaturamaxestu() != null) {
            _hashCode += getTemperaturamaxestu().hashCode();
        }
        if (getTemperaturaminestu() != null) {
            _hashCode += getTemperaturaminestu().hashCode();
        }
        if (getTempomaxestufagem() != null) {
            _hashCode += getTempomaxestufagem().hashCode();
        }
        if (getTempominestufagem() != null) {
            _hashCode += getTempominestufagem().hashCode();
        }
        if (getTmpliminspqld() != null) {
            _hashCode += getTmpliminspqld().hashCode();
        }
        if (getTmptrocaprdt() != null) {
            _hashCode += getTmptrocaprdt().hashCode();
        }
        if (getTmptrocapstc() != null) {
            _hashCode += getTmptrocapstc().hashCode();
        }
        if (getTpinspqld() != null) {
            _hashCode += getTpinspqld().hashCode();
        }
        if (getTpproduto() != null) {
            _hashCode += getTpproduto().hashCode();
        }
        if (getUnidmedsap() != null) {
            _hashCode += getUnidmedsap().hashCode();
        }
        if (getUnproduto() != null) {
            _hashCode += getUnproduto().hashCode();
        }
        if (getVlproduto() != null) {
            _hashCode += getVlproduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbpro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acabamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acabamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classificacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classificacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("espessura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "espessura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao004S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao004s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao004"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fatorconversao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fatorconversao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqlds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqlds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqld"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijbroneprosecaosForCdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijbroneprosecaosForCdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneprosecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijbroneprosecaosForCdprodutocomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijbroneprosecaosForCdprodutocomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneprosecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijbroneproseccomps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijbroneproseccomps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneproseccomp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcomppromprimas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcomppromprimas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomppromprima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqalts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqalts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqalt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdeparapros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdeparapros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdeparapro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijembaponts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijembaponts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijembapont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijespecinsppros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijespecinsppros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinsppro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijespecinsproatribs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijespecinsproatribs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinsproatrib"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestruprodsForCdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestruprodsForCdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestruprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestruprodsForCdprodutoseq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestruprodsForCdprodutoseq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestruprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijetqfaixas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijetqfaixas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijetqfaixa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijetqprodutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijetqprodutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijetqproduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfilakanbanintbets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfilakanbanintbets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfilakanbanintbet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetprocgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetprocgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetprocgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanidcartaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanidcartaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanidcartao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmdoalocmaqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmdoalocmaqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocmaq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmdoalocs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmdoalocs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoaloc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproautorizpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproautorizpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorvarritmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorvarritmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorvarritmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopagrupadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopagrupadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopagrupada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoploteses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoploteses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoppmedioprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoppmedioprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoppmedioprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopprodutoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopprodutoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopprodutos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopproqtopes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopproqtopes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopproqtope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopsagrupprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopsagrupprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopsagrupprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprocarteiras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprocarteiras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprocarteira"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprocompmprimacgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprocompmprimacgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprocompmprimacgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprodinspfreqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprodinspfreqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodinspfreq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprodxgrpparams");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprodxgrpparams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxgrpparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpromolestpadraos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpromolestpadraos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpromolestpadrao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpropesos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpropesos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpropeso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijproplanos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijproplanos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproplano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijproqtopes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijproqtopes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproqtope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprotempolimdbqlds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprotempolimdbqlds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprotempolimdbqld"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijproultops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijproultops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproultop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijproxgrcarcrtctrls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijproxgrcarcrtctrls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproxgrcarcrtctrl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldprodnivelinsps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldprodnivelinsps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldprodnivelinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreainspprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreainspprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreainspprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrefextras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrefextras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefextra"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrelprorefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrelprorefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrelproref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijroteiroprodhsts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijroteiroprodhsts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijroteiroprodhst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijroteiroprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijroteiroprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijroteiroprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbprocfgespqlds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbprocfgespqlds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbprocfgespqld"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbprocgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbprocgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbprocgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbprodeflotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbprodeflotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbprodeflote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbprodesconts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbprodesconts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbprodescont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbprousus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbprousus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbprousu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijversaoproducaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijversaoproducaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijversaoproducao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pbrutomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pbrutomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perclotekanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perclotekanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pliquidomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pliquidomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamlotekanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamlotekanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tampulmaomax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tampulmaomax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tampulmaomin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tampulmaomin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tampulmaopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tampulmaopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperaturamaxestu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperaturamaxestu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperaturaminestu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperaturaminestu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempomaxestufagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempomaxestufagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempominestufagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempominestufagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpliminspqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpliminspqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmptrocaprdt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmptrocaprdt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmptrocapstc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmptrocapstc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpinspqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpinspqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidmedsap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidmedsap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlproduto"));
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
