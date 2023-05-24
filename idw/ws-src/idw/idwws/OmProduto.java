/**
 * OmProduto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmProduto  extends idw.idwws.OmProdutoTemplate  implements java.io.Serializable {
    private java.lang.String cdProduto;

    private java.lang.String depara;

    private java.lang.String dsComplemento;

    private java.lang.String dsCurta;

    private java.lang.String dsProduto;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolpr[] dwConsolprs;

    private idw.idwws.DwEst dwEst;

    private idw.idwws.DwEstpro[] dwEstpros;

    private idw.idwws.DwExpcvs[] dwExpcvses;

    private idw.idwws.DwFolhaiac[] dwFolhaiacs;

    private idw.idwws.DwFolhamoncomp[] dwFolhamoncomps;

    private idw.idwws.DwFolhamon[] dwFolhamons;

    private idw.idwws.DwFolharapcom[] dwFolharapcoms;

    private idw.idwws.DwFolhateste[] dwFolhatestes;

    private idw.idwws.DwFolhatv[] dwFolhatvs;

    private idw.idwws.DwFtSub[] dwFtSubs;

    private idw.idwws.DwNserie[] dwNseries;

    private idw.idwws.DwOperacao[] dwOperacaosForIdProdutoAcabado;

    private idw.idwws.DwOperacao[] dwOperacaosForIdProdutoSemiacabado;

    private idw.idwws.DwPasscau[] dwPasscaus;

    private idw.idwws.DwPassmon[] dwPassmons;

    private idw.idwws.DwProdutoconjugado[] dwProdutoconjugadosForIdProdutofilho;

    private idw.idwws.DwProdutoconjugado[] dwProdutoconjugadosForIdProdutopai;

    private idw.idwws.DwRota[] dwRotas;

    private idw.idwws.DwTDefeito[] dwTDefeitos;

    private java.math.BigDecimal GPesoBruto;

    private java.math.BigDecimal GPesoLiquido;

    private java.math.BigDecimal hrLeadtimeentrada;

    private java.math.BigDecimal hrLeadtimesaida;

    private long idProduto;

    private java.math.BigDecimal indPerdaproducao;

    private java.lang.Boolean isDat;

    private java.math.BigDecimal minValposalim;

    private idw.idwws.OmCc omCc;

    private idw.idwws.OmCfg[] omCfgs;

    private idw.idwws.OmFor omFor;

    private idw.idwws.OmGarpro[] omGarpros;

    private idw.idwws.OmMapapa[] omMapapas;

    private idw.idwws.OmMapa[] omMapas;

    private idw.idwws.OmPapro[] omPapros;

    private idw.idwws.OmPrgpos[] omPrgposes;

    private idw.idwws.OmPrg[] omPrgs;

    private idw.idwws.OmProaltglo[] omProaltglosForIdProdutoFilho;

    private idw.idwws.OmProaltglo[] omProaltglosForIdProdutoMae;

    private idw.idwws.OmProcomest[] omProcomestsForIdProduto;

    private idw.idwws.OmProcomest[] omProcomestsForIdProdutomp;

    private idw.idwws.OmProduto omProdutoByIdProdutoagru;

    private idw.idwws.OmProduto[] omProdutos;

    private idw.idwws.OmProgrp omProgrp;

    private idw.idwws.OmPropaihomo[] omPropaihomosForIdProduto;

    private idw.idwws.OmPropaihomo[] omPropaihomosForIdProdutopai;

    private idw.idwws.OmProturno[] omProturnos;

    private idw.idwws.OmUnidmedida omUnidmedida;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpCliente ppCliente;

    private idw.idwws.PpCmcom[] ppCmcomsForFinal;

    private idw.idwws.PpCmcom[] ppCmcomsForIdProdutoentra;

    private idw.idwws.PpCmcom[] ppCmcomsForIdProdutosai;

    private idw.idwws.PpCpproduto[] ppCpprodutos;

    private idw.idwws.PpNec[] ppNecs;

    private java.math.BigDecimal qtLoteminprod;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    private java.lang.Integer tpOrigem;

    private java.math.BigDecimal tpProducao;

    private java.lang.Byte tpProduto;

    private java.lang.Byte tpSemiacabado;

    private java.math.BigDecimal vlCustounit;

    public OmProduto() {
    }

    public OmProduto(
           java.lang.Long id,
           java.lang.String cdProduto,
           java.lang.String depara,
           java.lang.String dsComplemento,
           java.lang.String dsCurta,
           java.lang.String dsProduto,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolpr[] dwConsolprs,
           idw.idwws.DwEst dwEst,
           idw.idwws.DwEstpro[] dwEstpros,
           idw.idwws.DwExpcvs[] dwExpcvses,
           idw.idwws.DwFolhaiac[] dwFolhaiacs,
           idw.idwws.DwFolhamoncomp[] dwFolhamoncomps,
           idw.idwws.DwFolhamon[] dwFolhamons,
           idw.idwws.DwFolharapcom[] dwFolharapcoms,
           idw.idwws.DwFolhateste[] dwFolhatestes,
           idw.idwws.DwFolhatv[] dwFolhatvs,
           idw.idwws.DwFtSub[] dwFtSubs,
           idw.idwws.DwNserie[] dwNseries,
           idw.idwws.DwOperacao[] dwOperacaosForIdProdutoAcabado,
           idw.idwws.DwOperacao[] dwOperacaosForIdProdutoSemiacabado,
           idw.idwws.DwPasscau[] dwPasscaus,
           idw.idwws.DwPassmon[] dwPassmons,
           idw.idwws.DwProdutoconjugado[] dwProdutoconjugadosForIdProdutofilho,
           idw.idwws.DwProdutoconjugado[] dwProdutoconjugadosForIdProdutopai,
           idw.idwws.DwRota[] dwRotas,
           idw.idwws.DwTDefeito[] dwTDefeitos,
           java.math.BigDecimal GPesoBruto,
           java.math.BigDecimal GPesoLiquido,
           java.math.BigDecimal hrLeadtimeentrada,
           java.math.BigDecimal hrLeadtimesaida,
           long idProduto,
           java.math.BigDecimal indPerdaproducao,
           java.lang.Boolean isDat,
           java.math.BigDecimal minValposalim,
           idw.idwws.OmCc omCc,
           idw.idwws.OmCfg[] omCfgs,
           idw.idwws.OmFor omFor,
           idw.idwws.OmGarpro[] omGarpros,
           idw.idwws.OmMapapa[] omMapapas,
           idw.idwws.OmMapa[] omMapas,
           idw.idwws.OmPapro[] omPapros,
           idw.idwws.OmPrgpos[] omPrgposes,
           idw.idwws.OmPrg[] omPrgs,
           idw.idwws.OmProaltglo[] omProaltglosForIdProdutoFilho,
           idw.idwws.OmProaltglo[] omProaltglosForIdProdutoMae,
           idw.idwws.OmProcomest[] omProcomestsForIdProduto,
           idw.idwws.OmProcomest[] omProcomestsForIdProdutomp,
           idw.idwws.OmProduto omProdutoByIdProdutoagru,
           idw.idwws.OmProduto[] omProdutos,
           idw.idwws.OmProgrp omProgrp,
           idw.idwws.OmPropaihomo[] omPropaihomosForIdProduto,
           idw.idwws.OmPropaihomo[] omPropaihomosForIdProdutopai,
           idw.idwws.OmProturno[] omProturnos,
           idw.idwws.OmUnidmedida omUnidmedida,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCliente ppCliente,
           idw.idwws.PpCmcom[] ppCmcomsForFinal,
           idw.idwws.PpCmcom[] ppCmcomsForIdProdutoentra,
           idw.idwws.PpCmcom[] ppCmcomsForIdProdutosai,
           idw.idwws.PpCpproduto[] ppCpprodutos,
           idw.idwws.PpNec[] ppNecs,
           java.math.BigDecimal qtLoteminprod,
           java.lang.Long revisao,
           java.lang.Byte stAtivo,
           java.lang.Integer tpOrigem,
           java.math.BigDecimal tpProducao,
           java.lang.Byte tpProduto,
           java.lang.Byte tpSemiacabado,
           java.math.BigDecimal vlCustounit) {
        super(
            id);
        this.cdProduto = cdProduto;
        this.depara = depara;
        this.dsComplemento = dsComplemento;
        this.dsCurta = dsCurta;
        this.dsProduto = dsProduto;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolprs = dwConsolprs;
        this.dwEst = dwEst;
        this.dwEstpros = dwEstpros;
        this.dwExpcvses = dwExpcvses;
        this.dwFolhaiacs = dwFolhaiacs;
        this.dwFolhamoncomps = dwFolhamoncomps;
        this.dwFolhamons = dwFolhamons;
        this.dwFolharapcoms = dwFolharapcoms;
        this.dwFolhatestes = dwFolhatestes;
        this.dwFolhatvs = dwFolhatvs;
        this.dwFtSubs = dwFtSubs;
        this.dwNseries = dwNseries;
        this.dwOperacaosForIdProdutoAcabado = dwOperacaosForIdProdutoAcabado;
        this.dwOperacaosForIdProdutoSemiacabado = dwOperacaosForIdProdutoSemiacabado;
        this.dwPasscaus = dwPasscaus;
        this.dwPassmons = dwPassmons;
        this.dwProdutoconjugadosForIdProdutofilho = dwProdutoconjugadosForIdProdutofilho;
        this.dwProdutoconjugadosForIdProdutopai = dwProdutoconjugadosForIdProdutopai;
        this.dwRotas = dwRotas;
        this.dwTDefeitos = dwTDefeitos;
        this.GPesoBruto = GPesoBruto;
        this.GPesoLiquido = GPesoLiquido;
        this.hrLeadtimeentrada = hrLeadtimeentrada;
        this.hrLeadtimesaida = hrLeadtimesaida;
        this.idProduto = idProduto;
        this.indPerdaproducao = indPerdaproducao;
        this.isDat = isDat;
        this.minValposalim = minValposalim;
        this.omCc = omCc;
        this.omCfgs = omCfgs;
        this.omFor = omFor;
        this.omGarpros = omGarpros;
        this.omMapapas = omMapapas;
        this.omMapas = omMapas;
        this.omPapros = omPapros;
        this.omPrgposes = omPrgposes;
        this.omPrgs = omPrgs;
        this.omProaltglosForIdProdutoFilho = omProaltglosForIdProdutoFilho;
        this.omProaltglosForIdProdutoMae = omProaltglosForIdProdutoMae;
        this.omProcomestsForIdProduto = omProcomestsForIdProduto;
        this.omProcomestsForIdProdutomp = omProcomestsForIdProdutomp;
        this.omProdutoByIdProdutoagru = omProdutoByIdProdutoagru;
        this.omProdutos = omProdutos;
        this.omProgrp = omProgrp;
        this.omPropaihomosForIdProduto = omPropaihomosForIdProduto;
        this.omPropaihomosForIdProdutopai = omPropaihomosForIdProdutopai;
        this.omProturnos = omProturnos;
        this.omUnidmedida = omUnidmedida;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppCliente = ppCliente;
        this.ppCmcomsForFinal = ppCmcomsForFinal;
        this.ppCmcomsForIdProdutoentra = ppCmcomsForIdProdutoentra;
        this.ppCmcomsForIdProdutosai = ppCmcomsForIdProdutosai;
        this.ppCpprodutos = ppCpprodutos;
        this.ppNecs = ppNecs;
        this.qtLoteminprod = qtLoteminprod;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.tpOrigem = tpOrigem;
        this.tpProducao = tpProducao;
        this.tpProduto = tpProduto;
        this.tpSemiacabado = tpSemiacabado;
        this.vlCustounit = vlCustounit;
    }


    /**
     * Gets the cdProduto value for this OmProduto.
     * 
     * @return cdProduto
     */
    public java.lang.String getCdProduto() {
        return cdProduto;
    }


    /**
     * Sets the cdProduto value for this OmProduto.
     * 
     * @param cdProduto
     */
    public void setCdProduto(java.lang.String cdProduto) {
        this.cdProduto = cdProduto;
    }


    /**
     * Gets the depara value for this OmProduto.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this OmProduto.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the dsComplemento value for this OmProduto.
     * 
     * @return dsComplemento
     */
    public java.lang.String getDsComplemento() {
        return dsComplemento;
    }


    /**
     * Sets the dsComplemento value for this OmProduto.
     * 
     * @param dsComplemento
     */
    public void setDsComplemento(java.lang.String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }


    /**
     * Gets the dsCurta value for this OmProduto.
     * 
     * @return dsCurta
     */
    public java.lang.String getDsCurta() {
        return dsCurta;
    }


    /**
     * Sets the dsCurta value for this OmProduto.
     * 
     * @param dsCurta
     */
    public void setDsCurta(java.lang.String dsCurta) {
        this.dsCurta = dsCurta;
    }


    /**
     * Gets the dsProduto value for this OmProduto.
     * 
     * @return dsProduto
     */
    public java.lang.String getDsProduto() {
        return dsProduto;
    }


    /**
     * Sets the dsProduto value for this OmProduto.
     * 
     * @param dsProduto
     */
    public void setDsProduto(java.lang.String dsProduto) {
        this.dsProduto = dsProduto;
    }


    /**
     * Gets the dtRevisao value for this OmProduto.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmProduto.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmProduto.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmProduto.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolprs value for this OmProduto.
     * 
     * @return dwConsolprs
     */
    public idw.idwws.DwConsolpr[] getDwConsolprs() {
        return dwConsolprs;
    }


    /**
     * Sets the dwConsolprs value for this OmProduto.
     * 
     * @param dwConsolprs
     */
    public void setDwConsolprs(idw.idwws.DwConsolpr[] dwConsolprs) {
        this.dwConsolprs = dwConsolprs;
    }

    public idw.idwws.DwConsolpr getDwConsolprs(int i) {
        return this.dwConsolprs[i];
    }

    public void setDwConsolprs(int i, idw.idwws.DwConsolpr _value) {
        this.dwConsolprs[i] = _value;
    }


    /**
     * Gets the dwEst value for this OmProduto.
     * 
     * @return dwEst
     */
    public idw.idwws.DwEst getDwEst() {
        return dwEst;
    }


    /**
     * Sets the dwEst value for this OmProduto.
     * 
     * @param dwEst
     */
    public void setDwEst(idw.idwws.DwEst dwEst) {
        this.dwEst = dwEst;
    }


    /**
     * Gets the dwEstpros value for this OmProduto.
     * 
     * @return dwEstpros
     */
    public idw.idwws.DwEstpro[] getDwEstpros() {
        return dwEstpros;
    }


    /**
     * Sets the dwEstpros value for this OmProduto.
     * 
     * @param dwEstpros
     */
    public void setDwEstpros(idw.idwws.DwEstpro[] dwEstpros) {
        this.dwEstpros = dwEstpros;
    }

    public idw.idwws.DwEstpro getDwEstpros(int i) {
        return this.dwEstpros[i];
    }

    public void setDwEstpros(int i, idw.idwws.DwEstpro _value) {
        this.dwEstpros[i] = _value;
    }


    /**
     * Gets the dwExpcvses value for this OmProduto.
     * 
     * @return dwExpcvses
     */
    public idw.idwws.DwExpcvs[] getDwExpcvses() {
        return dwExpcvses;
    }


    /**
     * Sets the dwExpcvses value for this OmProduto.
     * 
     * @param dwExpcvses
     */
    public void setDwExpcvses(idw.idwws.DwExpcvs[] dwExpcvses) {
        this.dwExpcvses = dwExpcvses;
    }

    public idw.idwws.DwExpcvs getDwExpcvses(int i) {
        return this.dwExpcvses[i];
    }

    public void setDwExpcvses(int i, idw.idwws.DwExpcvs _value) {
        this.dwExpcvses[i] = _value;
    }


    /**
     * Gets the dwFolhaiacs value for this OmProduto.
     * 
     * @return dwFolhaiacs
     */
    public idw.idwws.DwFolhaiac[] getDwFolhaiacs() {
        return dwFolhaiacs;
    }


    /**
     * Sets the dwFolhaiacs value for this OmProduto.
     * 
     * @param dwFolhaiacs
     */
    public void setDwFolhaiacs(idw.idwws.DwFolhaiac[] dwFolhaiacs) {
        this.dwFolhaiacs = dwFolhaiacs;
    }

    public idw.idwws.DwFolhaiac getDwFolhaiacs(int i) {
        return this.dwFolhaiacs[i];
    }

    public void setDwFolhaiacs(int i, idw.idwws.DwFolhaiac _value) {
        this.dwFolhaiacs[i] = _value;
    }


    /**
     * Gets the dwFolhamoncomps value for this OmProduto.
     * 
     * @return dwFolhamoncomps
     */
    public idw.idwws.DwFolhamoncomp[] getDwFolhamoncomps() {
        return dwFolhamoncomps;
    }


    /**
     * Sets the dwFolhamoncomps value for this OmProduto.
     * 
     * @param dwFolhamoncomps
     */
    public void setDwFolhamoncomps(idw.idwws.DwFolhamoncomp[] dwFolhamoncomps) {
        this.dwFolhamoncomps = dwFolhamoncomps;
    }

    public idw.idwws.DwFolhamoncomp getDwFolhamoncomps(int i) {
        return this.dwFolhamoncomps[i];
    }

    public void setDwFolhamoncomps(int i, idw.idwws.DwFolhamoncomp _value) {
        this.dwFolhamoncomps[i] = _value;
    }


    /**
     * Gets the dwFolhamons value for this OmProduto.
     * 
     * @return dwFolhamons
     */
    public idw.idwws.DwFolhamon[] getDwFolhamons() {
        return dwFolhamons;
    }


    /**
     * Sets the dwFolhamons value for this OmProduto.
     * 
     * @param dwFolhamons
     */
    public void setDwFolhamons(idw.idwws.DwFolhamon[] dwFolhamons) {
        this.dwFolhamons = dwFolhamons;
    }

    public idw.idwws.DwFolhamon getDwFolhamons(int i) {
        return this.dwFolhamons[i];
    }

    public void setDwFolhamons(int i, idw.idwws.DwFolhamon _value) {
        this.dwFolhamons[i] = _value;
    }


    /**
     * Gets the dwFolharapcoms value for this OmProduto.
     * 
     * @return dwFolharapcoms
     */
    public idw.idwws.DwFolharapcom[] getDwFolharapcoms() {
        return dwFolharapcoms;
    }


    /**
     * Sets the dwFolharapcoms value for this OmProduto.
     * 
     * @param dwFolharapcoms
     */
    public void setDwFolharapcoms(idw.idwws.DwFolharapcom[] dwFolharapcoms) {
        this.dwFolharapcoms = dwFolharapcoms;
    }

    public idw.idwws.DwFolharapcom getDwFolharapcoms(int i) {
        return this.dwFolharapcoms[i];
    }

    public void setDwFolharapcoms(int i, idw.idwws.DwFolharapcom _value) {
        this.dwFolharapcoms[i] = _value;
    }


    /**
     * Gets the dwFolhatestes value for this OmProduto.
     * 
     * @return dwFolhatestes
     */
    public idw.idwws.DwFolhateste[] getDwFolhatestes() {
        return dwFolhatestes;
    }


    /**
     * Sets the dwFolhatestes value for this OmProduto.
     * 
     * @param dwFolhatestes
     */
    public void setDwFolhatestes(idw.idwws.DwFolhateste[] dwFolhatestes) {
        this.dwFolhatestes = dwFolhatestes;
    }

    public idw.idwws.DwFolhateste getDwFolhatestes(int i) {
        return this.dwFolhatestes[i];
    }

    public void setDwFolhatestes(int i, idw.idwws.DwFolhateste _value) {
        this.dwFolhatestes[i] = _value;
    }


    /**
     * Gets the dwFolhatvs value for this OmProduto.
     * 
     * @return dwFolhatvs
     */
    public idw.idwws.DwFolhatv[] getDwFolhatvs() {
        return dwFolhatvs;
    }


    /**
     * Sets the dwFolhatvs value for this OmProduto.
     * 
     * @param dwFolhatvs
     */
    public void setDwFolhatvs(idw.idwws.DwFolhatv[] dwFolhatvs) {
        this.dwFolhatvs = dwFolhatvs;
    }

    public idw.idwws.DwFolhatv getDwFolhatvs(int i) {
        return this.dwFolhatvs[i];
    }

    public void setDwFolhatvs(int i, idw.idwws.DwFolhatv _value) {
        this.dwFolhatvs[i] = _value;
    }


    /**
     * Gets the dwFtSubs value for this OmProduto.
     * 
     * @return dwFtSubs
     */
    public idw.idwws.DwFtSub[] getDwFtSubs() {
        return dwFtSubs;
    }


    /**
     * Sets the dwFtSubs value for this OmProduto.
     * 
     * @param dwFtSubs
     */
    public void setDwFtSubs(idw.idwws.DwFtSub[] dwFtSubs) {
        this.dwFtSubs = dwFtSubs;
    }

    public idw.idwws.DwFtSub getDwFtSubs(int i) {
        return this.dwFtSubs[i];
    }

    public void setDwFtSubs(int i, idw.idwws.DwFtSub _value) {
        this.dwFtSubs[i] = _value;
    }


    /**
     * Gets the dwNseries value for this OmProduto.
     * 
     * @return dwNseries
     */
    public idw.idwws.DwNserie[] getDwNseries() {
        return dwNseries;
    }


    /**
     * Sets the dwNseries value for this OmProduto.
     * 
     * @param dwNseries
     */
    public void setDwNseries(idw.idwws.DwNserie[] dwNseries) {
        this.dwNseries = dwNseries;
    }

    public idw.idwws.DwNserie getDwNseries(int i) {
        return this.dwNseries[i];
    }

    public void setDwNseries(int i, idw.idwws.DwNserie _value) {
        this.dwNseries[i] = _value;
    }


    /**
     * Gets the dwOperacaosForIdProdutoAcabado value for this OmProduto.
     * 
     * @return dwOperacaosForIdProdutoAcabado
     */
    public idw.idwws.DwOperacao[] getDwOperacaosForIdProdutoAcabado() {
        return dwOperacaosForIdProdutoAcabado;
    }


    /**
     * Sets the dwOperacaosForIdProdutoAcabado value for this OmProduto.
     * 
     * @param dwOperacaosForIdProdutoAcabado
     */
    public void setDwOperacaosForIdProdutoAcabado(idw.idwws.DwOperacao[] dwOperacaosForIdProdutoAcabado) {
        this.dwOperacaosForIdProdutoAcabado = dwOperacaosForIdProdutoAcabado;
    }

    public idw.idwws.DwOperacao getDwOperacaosForIdProdutoAcabado(int i) {
        return this.dwOperacaosForIdProdutoAcabado[i];
    }

    public void setDwOperacaosForIdProdutoAcabado(int i, idw.idwws.DwOperacao _value) {
        this.dwOperacaosForIdProdutoAcabado[i] = _value;
    }


    /**
     * Gets the dwOperacaosForIdProdutoSemiacabado value for this OmProduto.
     * 
     * @return dwOperacaosForIdProdutoSemiacabado
     */
    public idw.idwws.DwOperacao[] getDwOperacaosForIdProdutoSemiacabado() {
        return dwOperacaosForIdProdutoSemiacabado;
    }


    /**
     * Sets the dwOperacaosForIdProdutoSemiacabado value for this OmProduto.
     * 
     * @param dwOperacaosForIdProdutoSemiacabado
     */
    public void setDwOperacaosForIdProdutoSemiacabado(idw.idwws.DwOperacao[] dwOperacaosForIdProdutoSemiacabado) {
        this.dwOperacaosForIdProdutoSemiacabado = dwOperacaosForIdProdutoSemiacabado;
    }

    public idw.idwws.DwOperacao getDwOperacaosForIdProdutoSemiacabado(int i) {
        return this.dwOperacaosForIdProdutoSemiacabado[i];
    }

    public void setDwOperacaosForIdProdutoSemiacabado(int i, idw.idwws.DwOperacao _value) {
        this.dwOperacaosForIdProdutoSemiacabado[i] = _value;
    }


    /**
     * Gets the dwPasscaus value for this OmProduto.
     * 
     * @return dwPasscaus
     */
    public idw.idwws.DwPasscau[] getDwPasscaus() {
        return dwPasscaus;
    }


    /**
     * Sets the dwPasscaus value for this OmProduto.
     * 
     * @param dwPasscaus
     */
    public void setDwPasscaus(idw.idwws.DwPasscau[] dwPasscaus) {
        this.dwPasscaus = dwPasscaus;
    }

    public idw.idwws.DwPasscau getDwPasscaus(int i) {
        return this.dwPasscaus[i];
    }

    public void setDwPasscaus(int i, idw.idwws.DwPasscau _value) {
        this.dwPasscaus[i] = _value;
    }


    /**
     * Gets the dwPassmons value for this OmProduto.
     * 
     * @return dwPassmons
     */
    public idw.idwws.DwPassmon[] getDwPassmons() {
        return dwPassmons;
    }


    /**
     * Sets the dwPassmons value for this OmProduto.
     * 
     * @param dwPassmons
     */
    public void setDwPassmons(idw.idwws.DwPassmon[] dwPassmons) {
        this.dwPassmons = dwPassmons;
    }

    public idw.idwws.DwPassmon getDwPassmons(int i) {
        return this.dwPassmons[i];
    }

    public void setDwPassmons(int i, idw.idwws.DwPassmon _value) {
        this.dwPassmons[i] = _value;
    }


    /**
     * Gets the dwProdutoconjugadosForIdProdutofilho value for this OmProduto.
     * 
     * @return dwProdutoconjugadosForIdProdutofilho
     */
    public idw.idwws.DwProdutoconjugado[] getDwProdutoconjugadosForIdProdutofilho() {
        return dwProdutoconjugadosForIdProdutofilho;
    }


    /**
     * Sets the dwProdutoconjugadosForIdProdutofilho value for this OmProduto.
     * 
     * @param dwProdutoconjugadosForIdProdutofilho
     */
    public void setDwProdutoconjugadosForIdProdutofilho(idw.idwws.DwProdutoconjugado[] dwProdutoconjugadosForIdProdutofilho) {
        this.dwProdutoconjugadosForIdProdutofilho = dwProdutoconjugadosForIdProdutofilho;
    }

    public idw.idwws.DwProdutoconjugado getDwProdutoconjugadosForIdProdutofilho(int i) {
        return this.dwProdutoconjugadosForIdProdutofilho[i];
    }

    public void setDwProdutoconjugadosForIdProdutofilho(int i, idw.idwws.DwProdutoconjugado _value) {
        this.dwProdutoconjugadosForIdProdutofilho[i] = _value;
    }


    /**
     * Gets the dwProdutoconjugadosForIdProdutopai value for this OmProduto.
     * 
     * @return dwProdutoconjugadosForIdProdutopai
     */
    public idw.idwws.DwProdutoconjugado[] getDwProdutoconjugadosForIdProdutopai() {
        return dwProdutoconjugadosForIdProdutopai;
    }


    /**
     * Sets the dwProdutoconjugadosForIdProdutopai value for this OmProduto.
     * 
     * @param dwProdutoconjugadosForIdProdutopai
     */
    public void setDwProdutoconjugadosForIdProdutopai(idw.idwws.DwProdutoconjugado[] dwProdutoconjugadosForIdProdutopai) {
        this.dwProdutoconjugadosForIdProdutopai = dwProdutoconjugadosForIdProdutopai;
    }

    public idw.idwws.DwProdutoconjugado getDwProdutoconjugadosForIdProdutopai(int i) {
        return this.dwProdutoconjugadosForIdProdutopai[i];
    }

    public void setDwProdutoconjugadosForIdProdutopai(int i, idw.idwws.DwProdutoconjugado _value) {
        this.dwProdutoconjugadosForIdProdutopai[i] = _value;
    }


    /**
     * Gets the dwRotas value for this OmProduto.
     * 
     * @return dwRotas
     */
    public idw.idwws.DwRota[] getDwRotas() {
        return dwRotas;
    }


    /**
     * Sets the dwRotas value for this OmProduto.
     * 
     * @param dwRotas
     */
    public void setDwRotas(idw.idwws.DwRota[] dwRotas) {
        this.dwRotas = dwRotas;
    }

    public idw.idwws.DwRota getDwRotas(int i) {
        return this.dwRotas[i];
    }

    public void setDwRotas(int i, idw.idwws.DwRota _value) {
        this.dwRotas[i] = _value;
    }


    /**
     * Gets the dwTDefeitos value for this OmProduto.
     * 
     * @return dwTDefeitos
     */
    public idw.idwws.DwTDefeito[] getDwTDefeitos() {
        return dwTDefeitos;
    }


    /**
     * Sets the dwTDefeitos value for this OmProduto.
     * 
     * @param dwTDefeitos
     */
    public void setDwTDefeitos(idw.idwws.DwTDefeito[] dwTDefeitos) {
        this.dwTDefeitos = dwTDefeitos;
    }

    public idw.idwws.DwTDefeito getDwTDefeitos(int i) {
        return this.dwTDefeitos[i];
    }

    public void setDwTDefeitos(int i, idw.idwws.DwTDefeito _value) {
        this.dwTDefeitos[i] = _value;
    }


    /**
     * Gets the GPesoBruto value for this OmProduto.
     * 
     * @return GPesoBruto
     */
    public java.math.BigDecimal getGPesoBruto() {
        return GPesoBruto;
    }


    /**
     * Sets the GPesoBruto value for this OmProduto.
     * 
     * @param GPesoBruto
     */
    public void setGPesoBruto(java.math.BigDecimal GPesoBruto) {
        this.GPesoBruto = GPesoBruto;
    }


    /**
     * Gets the GPesoLiquido value for this OmProduto.
     * 
     * @return GPesoLiquido
     */
    public java.math.BigDecimal getGPesoLiquido() {
        return GPesoLiquido;
    }


    /**
     * Sets the GPesoLiquido value for this OmProduto.
     * 
     * @param GPesoLiquido
     */
    public void setGPesoLiquido(java.math.BigDecimal GPesoLiquido) {
        this.GPesoLiquido = GPesoLiquido;
    }


    /**
     * Gets the hrLeadtimeentrada value for this OmProduto.
     * 
     * @return hrLeadtimeentrada
     */
    public java.math.BigDecimal getHrLeadtimeentrada() {
        return hrLeadtimeentrada;
    }


    /**
     * Sets the hrLeadtimeentrada value for this OmProduto.
     * 
     * @param hrLeadtimeentrada
     */
    public void setHrLeadtimeentrada(java.math.BigDecimal hrLeadtimeentrada) {
        this.hrLeadtimeentrada = hrLeadtimeentrada;
    }


    /**
     * Gets the hrLeadtimesaida value for this OmProduto.
     * 
     * @return hrLeadtimesaida
     */
    public java.math.BigDecimal getHrLeadtimesaida() {
        return hrLeadtimesaida;
    }


    /**
     * Sets the hrLeadtimesaida value for this OmProduto.
     * 
     * @param hrLeadtimesaida
     */
    public void setHrLeadtimesaida(java.math.BigDecimal hrLeadtimesaida) {
        this.hrLeadtimesaida = hrLeadtimesaida;
    }


    /**
     * Gets the idProduto value for this OmProduto.
     * 
     * @return idProduto
     */
    public long getIdProduto() {
        return idProduto;
    }


    /**
     * Sets the idProduto value for this OmProduto.
     * 
     * @param idProduto
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }


    /**
     * Gets the indPerdaproducao value for this OmProduto.
     * 
     * @return indPerdaproducao
     */
    public java.math.BigDecimal getIndPerdaproducao() {
        return indPerdaproducao;
    }


    /**
     * Sets the indPerdaproducao value for this OmProduto.
     * 
     * @param indPerdaproducao
     */
    public void setIndPerdaproducao(java.math.BigDecimal indPerdaproducao) {
        this.indPerdaproducao = indPerdaproducao;
    }


    /**
     * Gets the isDat value for this OmProduto.
     * 
     * @return isDat
     */
    public java.lang.Boolean getIsDat() {
        return isDat;
    }


    /**
     * Sets the isDat value for this OmProduto.
     * 
     * @param isDat
     */
    public void setIsDat(java.lang.Boolean isDat) {
        this.isDat = isDat;
    }


    /**
     * Gets the minValposalim value for this OmProduto.
     * 
     * @return minValposalim
     */
    public java.math.BigDecimal getMinValposalim() {
        return minValposalim;
    }


    /**
     * Sets the minValposalim value for this OmProduto.
     * 
     * @param minValposalim
     */
    public void setMinValposalim(java.math.BigDecimal minValposalim) {
        this.minValposalim = minValposalim;
    }


    /**
     * Gets the omCc value for this OmProduto.
     * 
     * @return omCc
     */
    public idw.idwws.OmCc getOmCc() {
        return omCc;
    }


    /**
     * Sets the omCc value for this OmProduto.
     * 
     * @param omCc
     */
    public void setOmCc(idw.idwws.OmCc omCc) {
        this.omCc = omCc;
    }


    /**
     * Gets the omCfgs value for this OmProduto.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this OmProduto.
     * 
     * @param omCfgs
     */
    public void setOmCfgs(idw.idwws.OmCfg[] omCfgs) {
        this.omCfgs = omCfgs;
    }

    public idw.idwws.OmCfg getOmCfgs(int i) {
        return this.omCfgs[i];
    }

    public void setOmCfgs(int i, idw.idwws.OmCfg _value) {
        this.omCfgs[i] = _value;
    }


    /**
     * Gets the omFor value for this OmProduto.
     * 
     * @return omFor
     */
    public idw.idwws.OmFor getOmFor() {
        return omFor;
    }


    /**
     * Sets the omFor value for this OmProduto.
     * 
     * @param omFor
     */
    public void setOmFor(idw.idwws.OmFor omFor) {
        this.omFor = omFor;
    }


    /**
     * Gets the omGarpros value for this OmProduto.
     * 
     * @return omGarpros
     */
    public idw.idwws.OmGarpro[] getOmGarpros() {
        return omGarpros;
    }


    /**
     * Sets the omGarpros value for this OmProduto.
     * 
     * @param omGarpros
     */
    public void setOmGarpros(idw.idwws.OmGarpro[] omGarpros) {
        this.omGarpros = omGarpros;
    }

    public idw.idwws.OmGarpro getOmGarpros(int i) {
        return this.omGarpros[i];
    }

    public void setOmGarpros(int i, idw.idwws.OmGarpro _value) {
        this.omGarpros[i] = _value;
    }


    /**
     * Gets the omMapapas value for this OmProduto.
     * 
     * @return omMapapas
     */
    public idw.idwws.OmMapapa[] getOmMapapas() {
        return omMapapas;
    }


    /**
     * Sets the omMapapas value for this OmProduto.
     * 
     * @param omMapapas
     */
    public void setOmMapapas(idw.idwws.OmMapapa[] omMapapas) {
        this.omMapapas = omMapapas;
    }

    public idw.idwws.OmMapapa getOmMapapas(int i) {
        return this.omMapapas[i];
    }

    public void setOmMapapas(int i, idw.idwws.OmMapapa _value) {
        this.omMapapas[i] = _value;
    }


    /**
     * Gets the omMapas value for this OmProduto.
     * 
     * @return omMapas
     */
    public idw.idwws.OmMapa[] getOmMapas() {
        return omMapas;
    }


    /**
     * Sets the omMapas value for this OmProduto.
     * 
     * @param omMapas
     */
    public void setOmMapas(idw.idwws.OmMapa[] omMapas) {
        this.omMapas = omMapas;
    }

    public idw.idwws.OmMapa getOmMapas(int i) {
        return this.omMapas[i];
    }

    public void setOmMapas(int i, idw.idwws.OmMapa _value) {
        this.omMapas[i] = _value;
    }


    /**
     * Gets the omPapros value for this OmProduto.
     * 
     * @return omPapros
     */
    public idw.idwws.OmPapro[] getOmPapros() {
        return omPapros;
    }


    /**
     * Sets the omPapros value for this OmProduto.
     * 
     * @param omPapros
     */
    public void setOmPapros(idw.idwws.OmPapro[] omPapros) {
        this.omPapros = omPapros;
    }

    public idw.idwws.OmPapro getOmPapros(int i) {
        return this.omPapros[i];
    }

    public void setOmPapros(int i, idw.idwws.OmPapro _value) {
        this.omPapros[i] = _value;
    }


    /**
     * Gets the omPrgposes value for this OmProduto.
     * 
     * @return omPrgposes
     */
    public idw.idwws.OmPrgpos[] getOmPrgposes() {
        return omPrgposes;
    }


    /**
     * Sets the omPrgposes value for this OmProduto.
     * 
     * @param omPrgposes
     */
    public void setOmPrgposes(idw.idwws.OmPrgpos[] omPrgposes) {
        this.omPrgposes = omPrgposes;
    }

    public idw.idwws.OmPrgpos getOmPrgposes(int i) {
        return this.omPrgposes[i];
    }

    public void setOmPrgposes(int i, idw.idwws.OmPrgpos _value) {
        this.omPrgposes[i] = _value;
    }


    /**
     * Gets the omPrgs value for this OmProduto.
     * 
     * @return omPrgs
     */
    public idw.idwws.OmPrg[] getOmPrgs() {
        return omPrgs;
    }


    /**
     * Sets the omPrgs value for this OmProduto.
     * 
     * @param omPrgs
     */
    public void setOmPrgs(idw.idwws.OmPrg[] omPrgs) {
        this.omPrgs = omPrgs;
    }

    public idw.idwws.OmPrg getOmPrgs(int i) {
        return this.omPrgs[i];
    }

    public void setOmPrgs(int i, idw.idwws.OmPrg _value) {
        this.omPrgs[i] = _value;
    }


    /**
     * Gets the omProaltglosForIdProdutoFilho value for this OmProduto.
     * 
     * @return omProaltglosForIdProdutoFilho
     */
    public idw.idwws.OmProaltglo[] getOmProaltglosForIdProdutoFilho() {
        return omProaltglosForIdProdutoFilho;
    }


    /**
     * Sets the omProaltglosForIdProdutoFilho value for this OmProduto.
     * 
     * @param omProaltglosForIdProdutoFilho
     */
    public void setOmProaltglosForIdProdutoFilho(idw.idwws.OmProaltglo[] omProaltglosForIdProdutoFilho) {
        this.omProaltglosForIdProdutoFilho = omProaltglosForIdProdutoFilho;
    }

    public idw.idwws.OmProaltglo getOmProaltglosForIdProdutoFilho(int i) {
        return this.omProaltglosForIdProdutoFilho[i];
    }

    public void setOmProaltglosForIdProdutoFilho(int i, idw.idwws.OmProaltglo _value) {
        this.omProaltglosForIdProdutoFilho[i] = _value;
    }


    /**
     * Gets the omProaltglosForIdProdutoMae value for this OmProduto.
     * 
     * @return omProaltglosForIdProdutoMae
     */
    public idw.idwws.OmProaltglo[] getOmProaltglosForIdProdutoMae() {
        return omProaltglosForIdProdutoMae;
    }


    /**
     * Sets the omProaltglosForIdProdutoMae value for this OmProduto.
     * 
     * @param omProaltglosForIdProdutoMae
     */
    public void setOmProaltglosForIdProdutoMae(idw.idwws.OmProaltglo[] omProaltglosForIdProdutoMae) {
        this.omProaltglosForIdProdutoMae = omProaltglosForIdProdutoMae;
    }

    public idw.idwws.OmProaltglo getOmProaltglosForIdProdutoMae(int i) {
        return this.omProaltglosForIdProdutoMae[i];
    }

    public void setOmProaltglosForIdProdutoMae(int i, idw.idwws.OmProaltglo _value) {
        this.omProaltglosForIdProdutoMae[i] = _value;
    }


    /**
     * Gets the omProcomestsForIdProduto value for this OmProduto.
     * 
     * @return omProcomestsForIdProduto
     */
    public idw.idwws.OmProcomest[] getOmProcomestsForIdProduto() {
        return omProcomestsForIdProduto;
    }


    /**
     * Sets the omProcomestsForIdProduto value for this OmProduto.
     * 
     * @param omProcomestsForIdProduto
     */
    public void setOmProcomestsForIdProduto(idw.idwws.OmProcomest[] omProcomestsForIdProduto) {
        this.omProcomestsForIdProduto = omProcomestsForIdProduto;
    }

    public idw.idwws.OmProcomest getOmProcomestsForIdProduto(int i) {
        return this.omProcomestsForIdProduto[i];
    }

    public void setOmProcomestsForIdProduto(int i, idw.idwws.OmProcomest _value) {
        this.omProcomestsForIdProduto[i] = _value;
    }


    /**
     * Gets the omProcomestsForIdProdutomp value for this OmProduto.
     * 
     * @return omProcomestsForIdProdutomp
     */
    public idw.idwws.OmProcomest[] getOmProcomestsForIdProdutomp() {
        return omProcomestsForIdProdutomp;
    }


    /**
     * Sets the omProcomestsForIdProdutomp value for this OmProduto.
     * 
     * @param omProcomestsForIdProdutomp
     */
    public void setOmProcomestsForIdProdutomp(idw.idwws.OmProcomest[] omProcomestsForIdProdutomp) {
        this.omProcomestsForIdProdutomp = omProcomestsForIdProdutomp;
    }

    public idw.idwws.OmProcomest getOmProcomestsForIdProdutomp(int i) {
        return this.omProcomestsForIdProdutomp[i];
    }

    public void setOmProcomestsForIdProdutomp(int i, idw.idwws.OmProcomest _value) {
        this.omProcomestsForIdProdutomp[i] = _value;
    }


    /**
     * Gets the omProdutoByIdProdutoagru value for this OmProduto.
     * 
     * @return omProdutoByIdProdutoagru
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutoagru() {
        return omProdutoByIdProdutoagru;
    }


    /**
     * Sets the omProdutoByIdProdutoagru value for this OmProduto.
     * 
     * @param omProdutoByIdProdutoagru
     */
    public void setOmProdutoByIdProdutoagru(idw.idwws.OmProduto omProdutoByIdProdutoagru) {
        this.omProdutoByIdProdutoagru = omProdutoByIdProdutoagru;
    }


    /**
     * Gets the omProdutos value for this OmProduto.
     * 
     * @return omProdutos
     */
    public idw.idwws.OmProduto[] getOmProdutos() {
        return omProdutos;
    }


    /**
     * Sets the omProdutos value for this OmProduto.
     * 
     * @param omProdutos
     */
    public void setOmProdutos(idw.idwws.OmProduto[] omProdutos) {
        this.omProdutos = omProdutos;
    }

    public idw.idwws.OmProduto getOmProdutos(int i) {
        return this.omProdutos[i];
    }

    public void setOmProdutos(int i, idw.idwws.OmProduto _value) {
        this.omProdutos[i] = _value;
    }


    /**
     * Gets the omProgrp value for this OmProduto.
     * 
     * @return omProgrp
     */
    public idw.idwws.OmProgrp getOmProgrp() {
        return omProgrp;
    }


    /**
     * Sets the omProgrp value for this OmProduto.
     * 
     * @param omProgrp
     */
    public void setOmProgrp(idw.idwws.OmProgrp omProgrp) {
        this.omProgrp = omProgrp;
    }


    /**
     * Gets the omPropaihomosForIdProduto value for this OmProduto.
     * 
     * @return omPropaihomosForIdProduto
     */
    public idw.idwws.OmPropaihomo[] getOmPropaihomosForIdProduto() {
        return omPropaihomosForIdProduto;
    }


    /**
     * Sets the omPropaihomosForIdProduto value for this OmProduto.
     * 
     * @param omPropaihomosForIdProduto
     */
    public void setOmPropaihomosForIdProduto(idw.idwws.OmPropaihomo[] omPropaihomosForIdProduto) {
        this.omPropaihomosForIdProduto = omPropaihomosForIdProduto;
    }

    public idw.idwws.OmPropaihomo getOmPropaihomosForIdProduto(int i) {
        return this.omPropaihomosForIdProduto[i];
    }

    public void setOmPropaihomosForIdProduto(int i, idw.idwws.OmPropaihomo _value) {
        this.omPropaihomosForIdProduto[i] = _value;
    }


    /**
     * Gets the omPropaihomosForIdProdutopai value for this OmProduto.
     * 
     * @return omPropaihomosForIdProdutopai
     */
    public idw.idwws.OmPropaihomo[] getOmPropaihomosForIdProdutopai() {
        return omPropaihomosForIdProdutopai;
    }


    /**
     * Sets the omPropaihomosForIdProdutopai value for this OmProduto.
     * 
     * @param omPropaihomosForIdProdutopai
     */
    public void setOmPropaihomosForIdProdutopai(idw.idwws.OmPropaihomo[] omPropaihomosForIdProdutopai) {
        this.omPropaihomosForIdProdutopai = omPropaihomosForIdProdutopai;
    }

    public idw.idwws.OmPropaihomo getOmPropaihomosForIdProdutopai(int i) {
        return this.omPropaihomosForIdProdutopai[i];
    }

    public void setOmPropaihomosForIdProdutopai(int i, idw.idwws.OmPropaihomo _value) {
        this.omPropaihomosForIdProdutopai[i] = _value;
    }


    /**
     * Gets the omProturnos value for this OmProduto.
     * 
     * @return omProturnos
     */
    public idw.idwws.OmProturno[] getOmProturnos() {
        return omProturnos;
    }


    /**
     * Sets the omProturnos value for this OmProduto.
     * 
     * @param omProturnos
     */
    public void setOmProturnos(idw.idwws.OmProturno[] omProturnos) {
        this.omProturnos = omProturnos;
    }

    public idw.idwws.OmProturno getOmProturnos(int i) {
        return this.omProturnos[i];
    }

    public void setOmProturnos(int i, idw.idwws.OmProturno _value) {
        this.omProturnos[i] = _value;
    }


    /**
     * Gets the omUnidmedida value for this OmProduto.
     * 
     * @return omUnidmedida
     */
    public idw.idwws.OmUnidmedida getOmUnidmedida() {
        return omUnidmedida;
    }


    /**
     * Sets the omUnidmedida value for this OmProduto.
     * 
     * @param omUnidmedida
     */
    public void setOmUnidmedida(idw.idwws.OmUnidmedida omUnidmedida) {
        this.omUnidmedida = omUnidmedida;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmProduto.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmProduto.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmProduto.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmProduto.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppCliente value for this OmProduto.
     * 
     * @return ppCliente
     */
    public idw.idwws.PpCliente getPpCliente() {
        return ppCliente;
    }


    /**
     * Sets the ppCliente value for this OmProduto.
     * 
     * @param ppCliente
     */
    public void setPpCliente(idw.idwws.PpCliente ppCliente) {
        this.ppCliente = ppCliente;
    }


    /**
     * Gets the ppCmcomsForFinal value for this OmProduto.
     * 
     * @return ppCmcomsForFinal
     */
    public idw.idwws.PpCmcom[] getPpCmcomsForFinal() {
        return ppCmcomsForFinal;
    }


    /**
     * Sets the ppCmcomsForFinal value for this OmProduto.
     * 
     * @param ppCmcomsForFinal
     */
    public void setPpCmcomsForFinal(idw.idwws.PpCmcom[] ppCmcomsForFinal) {
        this.ppCmcomsForFinal = ppCmcomsForFinal;
    }

    public idw.idwws.PpCmcom getPpCmcomsForFinal(int i) {
        return this.ppCmcomsForFinal[i];
    }

    public void setPpCmcomsForFinal(int i, idw.idwws.PpCmcom _value) {
        this.ppCmcomsForFinal[i] = _value;
    }


    /**
     * Gets the ppCmcomsForIdProdutoentra value for this OmProduto.
     * 
     * @return ppCmcomsForIdProdutoentra
     */
    public idw.idwws.PpCmcom[] getPpCmcomsForIdProdutoentra() {
        return ppCmcomsForIdProdutoentra;
    }


    /**
     * Sets the ppCmcomsForIdProdutoentra value for this OmProduto.
     * 
     * @param ppCmcomsForIdProdutoentra
     */
    public void setPpCmcomsForIdProdutoentra(idw.idwws.PpCmcom[] ppCmcomsForIdProdutoentra) {
        this.ppCmcomsForIdProdutoentra = ppCmcomsForIdProdutoentra;
    }

    public idw.idwws.PpCmcom getPpCmcomsForIdProdutoentra(int i) {
        return this.ppCmcomsForIdProdutoentra[i];
    }

    public void setPpCmcomsForIdProdutoentra(int i, idw.idwws.PpCmcom _value) {
        this.ppCmcomsForIdProdutoentra[i] = _value;
    }


    /**
     * Gets the ppCmcomsForIdProdutosai value for this OmProduto.
     * 
     * @return ppCmcomsForIdProdutosai
     */
    public idw.idwws.PpCmcom[] getPpCmcomsForIdProdutosai() {
        return ppCmcomsForIdProdutosai;
    }


    /**
     * Sets the ppCmcomsForIdProdutosai value for this OmProduto.
     * 
     * @param ppCmcomsForIdProdutosai
     */
    public void setPpCmcomsForIdProdutosai(idw.idwws.PpCmcom[] ppCmcomsForIdProdutosai) {
        this.ppCmcomsForIdProdutosai = ppCmcomsForIdProdutosai;
    }

    public idw.idwws.PpCmcom getPpCmcomsForIdProdutosai(int i) {
        return this.ppCmcomsForIdProdutosai[i];
    }

    public void setPpCmcomsForIdProdutosai(int i, idw.idwws.PpCmcom _value) {
        this.ppCmcomsForIdProdutosai[i] = _value;
    }


    /**
     * Gets the ppCpprodutos value for this OmProduto.
     * 
     * @return ppCpprodutos
     */
    public idw.idwws.PpCpproduto[] getPpCpprodutos() {
        return ppCpprodutos;
    }


    /**
     * Sets the ppCpprodutos value for this OmProduto.
     * 
     * @param ppCpprodutos
     */
    public void setPpCpprodutos(idw.idwws.PpCpproduto[] ppCpprodutos) {
        this.ppCpprodutos = ppCpprodutos;
    }

    public idw.idwws.PpCpproduto getPpCpprodutos(int i) {
        return this.ppCpprodutos[i];
    }

    public void setPpCpprodutos(int i, idw.idwws.PpCpproduto _value) {
        this.ppCpprodutos[i] = _value;
    }


    /**
     * Gets the ppNecs value for this OmProduto.
     * 
     * @return ppNecs
     */
    public idw.idwws.PpNec[] getPpNecs() {
        return ppNecs;
    }


    /**
     * Sets the ppNecs value for this OmProduto.
     * 
     * @param ppNecs
     */
    public void setPpNecs(idw.idwws.PpNec[] ppNecs) {
        this.ppNecs = ppNecs;
    }

    public idw.idwws.PpNec getPpNecs(int i) {
        return this.ppNecs[i];
    }

    public void setPpNecs(int i, idw.idwws.PpNec _value) {
        this.ppNecs[i] = _value;
    }


    /**
     * Gets the qtLoteminprod value for this OmProduto.
     * 
     * @return qtLoteminprod
     */
    public java.math.BigDecimal getQtLoteminprod() {
        return qtLoteminprod;
    }


    /**
     * Sets the qtLoteminprod value for this OmProduto.
     * 
     * @param qtLoteminprod
     */
    public void setQtLoteminprod(java.math.BigDecimal qtLoteminprod) {
        this.qtLoteminprod = qtLoteminprod;
    }


    /**
     * Gets the revisao value for this OmProduto.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmProduto.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmProduto.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmProduto.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpOrigem value for this OmProduto.
     * 
     * @return tpOrigem
     */
    public java.lang.Integer getTpOrigem() {
        return tpOrigem;
    }


    /**
     * Sets the tpOrigem value for this OmProduto.
     * 
     * @param tpOrigem
     */
    public void setTpOrigem(java.lang.Integer tpOrigem) {
        this.tpOrigem = tpOrigem;
    }


    /**
     * Gets the tpProducao value for this OmProduto.
     * 
     * @return tpProducao
     */
    public java.math.BigDecimal getTpProducao() {
        return tpProducao;
    }


    /**
     * Sets the tpProducao value for this OmProduto.
     * 
     * @param tpProducao
     */
    public void setTpProducao(java.math.BigDecimal tpProducao) {
        this.tpProducao = tpProducao;
    }


    /**
     * Gets the tpProduto value for this OmProduto.
     * 
     * @return tpProduto
     */
    public java.lang.Byte getTpProduto() {
        return tpProduto;
    }


    /**
     * Sets the tpProduto value for this OmProduto.
     * 
     * @param tpProduto
     */
    public void setTpProduto(java.lang.Byte tpProduto) {
        this.tpProduto = tpProduto;
    }


    /**
     * Gets the tpSemiacabado value for this OmProduto.
     * 
     * @return tpSemiacabado
     */
    public java.lang.Byte getTpSemiacabado() {
        return tpSemiacabado;
    }


    /**
     * Sets the tpSemiacabado value for this OmProduto.
     * 
     * @param tpSemiacabado
     */
    public void setTpSemiacabado(java.lang.Byte tpSemiacabado) {
        this.tpSemiacabado = tpSemiacabado;
    }


    /**
     * Gets the vlCustounit value for this OmProduto.
     * 
     * @return vlCustounit
     */
    public java.math.BigDecimal getVlCustounit() {
        return vlCustounit;
    }


    /**
     * Sets the vlCustounit value for this OmProduto.
     * 
     * @param vlCustounit
     */
    public void setVlCustounit(java.math.BigDecimal vlCustounit) {
        this.vlCustounit = vlCustounit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmProduto)) return false;
        OmProduto other = (OmProduto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdProduto==null && other.getCdProduto()==null) || 
             (this.cdProduto!=null &&
              this.cdProduto.equals(other.getCdProduto()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.dsComplemento==null && other.getDsComplemento()==null) || 
             (this.dsComplemento!=null &&
              this.dsComplemento.equals(other.getDsComplemento()))) &&
            ((this.dsCurta==null && other.getDsCurta()==null) || 
             (this.dsCurta!=null &&
              this.dsCurta.equals(other.getDsCurta()))) &&
            ((this.dsProduto==null && other.getDsProduto()==null) || 
             (this.dsProduto!=null &&
              this.dsProduto.equals(other.getDsProduto()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwConsolprs==null && other.getDwConsolprs()==null) || 
             (this.dwConsolprs!=null &&
              java.util.Arrays.equals(this.dwConsolprs, other.getDwConsolprs()))) &&
            ((this.dwEst==null && other.getDwEst()==null) || 
             (this.dwEst!=null &&
              this.dwEst.equals(other.getDwEst()))) &&
            ((this.dwEstpros==null && other.getDwEstpros()==null) || 
             (this.dwEstpros!=null &&
              java.util.Arrays.equals(this.dwEstpros, other.getDwEstpros()))) &&
            ((this.dwExpcvses==null && other.getDwExpcvses()==null) || 
             (this.dwExpcvses!=null &&
              java.util.Arrays.equals(this.dwExpcvses, other.getDwExpcvses()))) &&
            ((this.dwFolhaiacs==null && other.getDwFolhaiacs()==null) || 
             (this.dwFolhaiacs!=null &&
              java.util.Arrays.equals(this.dwFolhaiacs, other.getDwFolhaiacs()))) &&
            ((this.dwFolhamoncomps==null && other.getDwFolhamoncomps()==null) || 
             (this.dwFolhamoncomps!=null &&
              java.util.Arrays.equals(this.dwFolhamoncomps, other.getDwFolhamoncomps()))) &&
            ((this.dwFolhamons==null && other.getDwFolhamons()==null) || 
             (this.dwFolhamons!=null &&
              java.util.Arrays.equals(this.dwFolhamons, other.getDwFolhamons()))) &&
            ((this.dwFolharapcoms==null && other.getDwFolharapcoms()==null) || 
             (this.dwFolharapcoms!=null &&
              java.util.Arrays.equals(this.dwFolharapcoms, other.getDwFolharapcoms()))) &&
            ((this.dwFolhatestes==null && other.getDwFolhatestes()==null) || 
             (this.dwFolhatestes!=null &&
              java.util.Arrays.equals(this.dwFolhatestes, other.getDwFolhatestes()))) &&
            ((this.dwFolhatvs==null && other.getDwFolhatvs()==null) || 
             (this.dwFolhatvs!=null &&
              java.util.Arrays.equals(this.dwFolhatvs, other.getDwFolhatvs()))) &&
            ((this.dwFtSubs==null && other.getDwFtSubs()==null) || 
             (this.dwFtSubs!=null &&
              java.util.Arrays.equals(this.dwFtSubs, other.getDwFtSubs()))) &&
            ((this.dwNseries==null && other.getDwNseries()==null) || 
             (this.dwNseries!=null &&
              java.util.Arrays.equals(this.dwNseries, other.getDwNseries()))) &&
            ((this.dwOperacaosForIdProdutoAcabado==null && other.getDwOperacaosForIdProdutoAcabado()==null) || 
             (this.dwOperacaosForIdProdutoAcabado!=null &&
              java.util.Arrays.equals(this.dwOperacaosForIdProdutoAcabado, other.getDwOperacaosForIdProdutoAcabado()))) &&
            ((this.dwOperacaosForIdProdutoSemiacabado==null && other.getDwOperacaosForIdProdutoSemiacabado()==null) || 
             (this.dwOperacaosForIdProdutoSemiacabado!=null &&
              java.util.Arrays.equals(this.dwOperacaosForIdProdutoSemiacabado, other.getDwOperacaosForIdProdutoSemiacabado()))) &&
            ((this.dwPasscaus==null && other.getDwPasscaus()==null) || 
             (this.dwPasscaus!=null &&
              java.util.Arrays.equals(this.dwPasscaus, other.getDwPasscaus()))) &&
            ((this.dwPassmons==null && other.getDwPassmons()==null) || 
             (this.dwPassmons!=null &&
              java.util.Arrays.equals(this.dwPassmons, other.getDwPassmons()))) &&
            ((this.dwProdutoconjugadosForIdProdutofilho==null && other.getDwProdutoconjugadosForIdProdutofilho()==null) || 
             (this.dwProdutoconjugadosForIdProdutofilho!=null &&
              java.util.Arrays.equals(this.dwProdutoconjugadosForIdProdutofilho, other.getDwProdutoconjugadosForIdProdutofilho()))) &&
            ((this.dwProdutoconjugadosForIdProdutopai==null && other.getDwProdutoconjugadosForIdProdutopai()==null) || 
             (this.dwProdutoconjugadosForIdProdutopai!=null &&
              java.util.Arrays.equals(this.dwProdutoconjugadosForIdProdutopai, other.getDwProdutoconjugadosForIdProdutopai()))) &&
            ((this.dwRotas==null && other.getDwRotas()==null) || 
             (this.dwRotas!=null &&
              java.util.Arrays.equals(this.dwRotas, other.getDwRotas()))) &&
            ((this.dwTDefeitos==null && other.getDwTDefeitos()==null) || 
             (this.dwTDefeitos!=null &&
              java.util.Arrays.equals(this.dwTDefeitos, other.getDwTDefeitos()))) &&
            ((this.GPesoBruto==null && other.getGPesoBruto()==null) || 
             (this.GPesoBruto!=null &&
              this.GPesoBruto.equals(other.getGPesoBruto()))) &&
            ((this.GPesoLiquido==null && other.getGPesoLiquido()==null) || 
             (this.GPesoLiquido!=null &&
              this.GPesoLiquido.equals(other.getGPesoLiquido()))) &&
            ((this.hrLeadtimeentrada==null && other.getHrLeadtimeentrada()==null) || 
             (this.hrLeadtimeentrada!=null &&
              this.hrLeadtimeentrada.equals(other.getHrLeadtimeentrada()))) &&
            ((this.hrLeadtimesaida==null && other.getHrLeadtimesaida()==null) || 
             (this.hrLeadtimesaida!=null &&
              this.hrLeadtimesaida.equals(other.getHrLeadtimesaida()))) &&
            this.idProduto == other.getIdProduto() &&
            ((this.indPerdaproducao==null && other.getIndPerdaproducao()==null) || 
             (this.indPerdaproducao!=null &&
              this.indPerdaproducao.equals(other.getIndPerdaproducao()))) &&
            ((this.isDat==null && other.getIsDat()==null) || 
             (this.isDat!=null &&
              this.isDat.equals(other.getIsDat()))) &&
            ((this.minValposalim==null && other.getMinValposalim()==null) || 
             (this.minValposalim!=null &&
              this.minValposalim.equals(other.getMinValposalim()))) &&
            ((this.omCc==null && other.getOmCc()==null) || 
             (this.omCc!=null &&
              this.omCc.equals(other.getOmCc()))) &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.omFor==null && other.getOmFor()==null) || 
             (this.omFor!=null &&
              this.omFor.equals(other.getOmFor()))) &&
            ((this.omGarpros==null && other.getOmGarpros()==null) || 
             (this.omGarpros!=null &&
              java.util.Arrays.equals(this.omGarpros, other.getOmGarpros()))) &&
            ((this.omMapapas==null && other.getOmMapapas()==null) || 
             (this.omMapapas!=null &&
              java.util.Arrays.equals(this.omMapapas, other.getOmMapapas()))) &&
            ((this.omMapas==null && other.getOmMapas()==null) || 
             (this.omMapas!=null &&
              java.util.Arrays.equals(this.omMapas, other.getOmMapas()))) &&
            ((this.omPapros==null && other.getOmPapros()==null) || 
             (this.omPapros!=null &&
              java.util.Arrays.equals(this.omPapros, other.getOmPapros()))) &&
            ((this.omPrgposes==null && other.getOmPrgposes()==null) || 
             (this.omPrgposes!=null &&
              java.util.Arrays.equals(this.omPrgposes, other.getOmPrgposes()))) &&
            ((this.omPrgs==null && other.getOmPrgs()==null) || 
             (this.omPrgs!=null &&
              java.util.Arrays.equals(this.omPrgs, other.getOmPrgs()))) &&
            ((this.omProaltglosForIdProdutoFilho==null && other.getOmProaltglosForIdProdutoFilho()==null) || 
             (this.omProaltglosForIdProdutoFilho!=null &&
              java.util.Arrays.equals(this.omProaltglosForIdProdutoFilho, other.getOmProaltglosForIdProdutoFilho()))) &&
            ((this.omProaltglosForIdProdutoMae==null && other.getOmProaltglosForIdProdutoMae()==null) || 
             (this.omProaltglosForIdProdutoMae!=null &&
              java.util.Arrays.equals(this.omProaltglosForIdProdutoMae, other.getOmProaltglosForIdProdutoMae()))) &&
            ((this.omProcomestsForIdProduto==null && other.getOmProcomestsForIdProduto()==null) || 
             (this.omProcomestsForIdProduto!=null &&
              java.util.Arrays.equals(this.omProcomestsForIdProduto, other.getOmProcomestsForIdProduto()))) &&
            ((this.omProcomestsForIdProdutomp==null && other.getOmProcomestsForIdProdutomp()==null) || 
             (this.omProcomestsForIdProdutomp!=null &&
              java.util.Arrays.equals(this.omProcomestsForIdProdutomp, other.getOmProcomestsForIdProdutomp()))) &&
            ((this.omProdutoByIdProdutoagru==null && other.getOmProdutoByIdProdutoagru()==null) || 
             (this.omProdutoByIdProdutoagru!=null &&
              this.omProdutoByIdProdutoagru.equals(other.getOmProdutoByIdProdutoagru()))) &&
            ((this.omProdutos==null && other.getOmProdutos()==null) || 
             (this.omProdutos!=null &&
              java.util.Arrays.equals(this.omProdutos, other.getOmProdutos()))) &&
            ((this.omProgrp==null && other.getOmProgrp()==null) || 
             (this.omProgrp!=null &&
              this.omProgrp.equals(other.getOmProgrp()))) &&
            ((this.omPropaihomosForIdProduto==null && other.getOmPropaihomosForIdProduto()==null) || 
             (this.omPropaihomosForIdProduto!=null &&
              java.util.Arrays.equals(this.omPropaihomosForIdProduto, other.getOmPropaihomosForIdProduto()))) &&
            ((this.omPropaihomosForIdProdutopai==null && other.getOmPropaihomosForIdProdutopai()==null) || 
             (this.omPropaihomosForIdProdutopai!=null &&
              java.util.Arrays.equals(this.omPropaihomosForIdProdutopai, other.getOmPropaihomosForIdProdutopai()))) &&
            ((this.omProturnos==null && other.getOmProturnos()==null) || 
             (this.omProturnos!=null &&
              java.util.Arrays.equals(this.omProturnos, other.getOmProturnos()))) &&
            ((this.omUnidmedida==null && other.getOmUnidmedida()==null) || 
             (this.omUnidmedida!=null &&
              this.omUnidmedida.equals(other.getOmUnidmedida()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppCliente==null && other.getPpCliente()==null) || 
             (this.ppCliente!=null &&
              this.ppCliente.equals(other.getPpCliente()))) &&
            ((this.ppCmcomsForFinal==null && other.getPpCmcomsForFinal()==null) || 
             (this.ppCmcomsForFinal!=null &&
              java.util.Arrays.equals(this.ppCmcomsForFinal, other.getPpCmcomsForFinal()))) &&
            ((this.ppCmcomsForIdProdutoentra==null && other.getPpCmcomsForIdProdutoentra()==null) || 
             (this.ppCmcomsForIdProdutoentra!=null &&
              java.util.Arrays.equals(this.ppCmcomsForIdProdutoentra, other.getPpCmcomsForIdProdutoentra()))) &&
            ((this.ppCmcomsForIdProdutosai==null && other.getPpCmcomsForIdProdutosai()==null) || 
             (this.ppCmcomsForIdProdutosai!=null &&
              java.util.Arrays.equals(this.ppCmcomsForIdProdutosai, other.getPpCmcomsForIdProdutosai()))) &&
            ((this.ppCpprodutos==null && other.getPpCpprodutos()==null) || 
             (this.ppCpprodutos!=null &&
              java.util.Arrays.equals(this.ppCpprodutos, other.getPpCpprodutos()))) &&
            ((this.ppNecs==null && other.getPpNecs()==null) || 
             (this.ppNecs!=null &&
              java.util.Arrays.equals(this.ppNecs, other.getPpNecs()))) &&
            ((this.qtLoteminprod==null && other.getQtLoteminprod()==null) || 
             (this.qtLoteminprod!=null &&
              this.qtLoteminprod.equals(other.getQtLoteminprod()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpOrigem==null && other.getTpOrigem()==null) || 
             (this.tpOrigem!=null &&
              this.tpOrigem.equals(other.getTpOrigem()))) &&
            ((this.tpProducao==null && other.getTpProducao()==null) || 
             (this.tpProducao!=null &&
              this.tpProducao.equals(other.getTpProducao()))) &&
            ((this.tpProduto==null && other.getTpProduto()==null) || 
             (this.tpProduto!=null &&
              this.tpProduto.equals(other.getTpProduto()))) &&
            ((this.tpSemiacabado==null && other.getTpSemiacabado()==null) || 
             (this.tpSemiacabado!=null &&
              this.tpSemiacabado.equals(other.getTpSemiacabado()))) &&
            ((this.vlCustounit==null && other.getVlCustounit()==null) || 
             (this.vlCustounit!=null &&
              this.vlCustounit.equals(other.getVlCustounit())));
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
        if (getCdProduto() != null) {
            _hashCode += getCdProduto().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDsComplemento() != null) {
            _hashCode += getDsComplemento().hashCode();
        }
        if (getDsCurta() != null) {
            _hashCode += getDsCurta().hashCode();
        }
        if (getDsProduto() != null) {
            _hashCode += getDsProduto().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwConsolprs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolprs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolprs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwEst() != null) {
            _hashCode += getDwEst().hashCode();
        }
        if (getDwEstpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwEstpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwEstpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwExpcvses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwExpcvses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwExpcvses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhaiacs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhaiacs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhaiacs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhamoncomps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhamoncomps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhamoncomps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhamons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhamons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhamons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolharapcoms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolharapcoms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolharapcoms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhatestes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhatestes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhatestes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhatvs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhatvs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhatvs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFtSubs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFtSubs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFtSubs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwNseries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwNseries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwNseries(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwOperacaosForIdProdutoAcabado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwOperacaosForIdProdutoAcabado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwOperacaosForIdProdutoAcabado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwOperacaosForIdProdutoSemiacabado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwOperacaosForIdProdutoSemiacabado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwOperacaosForIdProdutoSemiacabado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPasscaus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPasscaus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPasscaus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPassmons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassmons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassmons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwProdutoconjugadosForIdProdutofilho() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProdutoconjugadosForIdProdutofilho());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProdutoconjugadosForIdProdutofilho(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwProdutoconjugadosForIdProdutopai() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProdutoconjugadosForIdProdutopai());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProdutoconjugadosForIdProdutopai(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRotas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTDefeitos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTDefeitos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTDefeitos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGPesoBruto() != null) {
            _hashCode += getGPesoBruto().hashCode();
        }
        if (getGPesoLiquido() != null) {
            _hashCode += getGPesoLiquido().hashCode();
        }
        if (getHrLeadtimeentrada() != null) {
            _hashCode += getHrLeadtimeentrada().hashCode();
        }
        if (getHrLeadtimesaida() != null) {
            _hashCode += getHrLeadtimesaida().hashCode();
        }
        _hashCode += new Long(getIdProduto()).hashCode();
        if (getIndPerdaproducao() != null) {
            _hashCode += getIndPerdaproducao().hashCode();
        }
        if (getIsDat() != null) {
            _hashCode += getIsDat().hashCode();
        }
        if (getMinValposalim() != null) {
            _hashCode += getMinValposalim().hashCode();
        }
        if (getOmCc() != null) {
            _hashCode += getOmCc().hashCode();
        }
        if (getOmCfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmFor() != null) {
            _hashCode += getOmFor().hashCode();
        }
        if (getOmGarpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGarpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGarpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmMapapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmMapapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmMapapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmMapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmMapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmMapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPapros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPapros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPapros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPrgposes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPrgposes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPrgposes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPrgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPrgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPrgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProaltglosForIdProdutoFilho() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProaltglosForIdProdutoFilho());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProaltglosForIdProdutoFilho(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProaltglosForIdProdutoMae() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProaltglosForIdProdutoMae());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProaltglosForIdProdutoMae(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProcomestsForIdProduto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProcomestsForIdProduto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProcomestsForIdProduto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProcomestsForIdProdutomp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProcomestsForIdProdutomp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProcomestsForIdProdutomp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProdutoByIdProdutoagru() != null) {
            _hashCode += getOmProdutoByIdProdutoagru().hashCode();
        }
        if (getOmProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProgrp() != null) {
            _hashCode += getOmProgrp().hashCode();
        }
        if (getOmPropaihomosForIdProduto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPropaihomosForIdProduto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPropaihomosForIdProduto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPropaihomosForIdProdutopai() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPropaihomosForIdProdutopai());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPropaihomosForIdProdutopai(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProturnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProturnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProturnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUnidmedida() != null) {
            _hashCode += getOmUnidmedida().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpCliente() != null) {
            _hashCode += getPpCliente().hashCode();
        }
        if (getPpCmcomsForFinal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCmcomsForFinal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCmcomsForFinal(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCmcomsForIdProdutoentra() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCmcomsForIdProdutoentra());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCmcomsForIdProdutoentra(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCmcomsForIdProdutosai() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCmcomsForIdProdutosai());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCmcomsForIdProdutosai(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCpprodutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpprodutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpprodutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpNecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQtLoteminprod() != null) {
            _hashCode += getQtLoteminprod().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpOrigem() != null) {
            _hashCode += getTpOrigem().hashCode();
        }
        if (getTpProducao() != null) {
            _hashCode += getTpProducao().hashCode();
        }
        if (getTpProduto() != null) {
            _hashCode += getTpProduto().hashCode();
        }
        if (getTpSemiacabado() != null) {
            _hashCode += getTpSemiacabado().hashCode();
        }
        if (getVlCustounit() != null) {
            _hashCode += getVlCustounit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmProduto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsComplemento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsComplemento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCurta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCurta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolprs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolprs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwExpcvses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwExpcvses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwExpcvs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhaiacs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhaiacs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhaiac"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamoncomps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamoncomps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamoncomp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolharapcoms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolharapcoms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolharapcom"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhatestes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhatestes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhateste"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhatvs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhatvs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhatv"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtSubs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSubs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwNseries");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwNseries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwNserie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwOperacaosForIdProdutoAcabado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwOperacaosForIdProdutoAcabado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwOperacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwOperacaosForIdProdutoSemiacabado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwOperacaosForIdProdutoSemiacabado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwOperacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasscaus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasscaus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasscau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassmons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassmons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassmon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProdutoconjugadosForIdProdutofilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProdutoconjugadosForIdProdutofilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProdutoconjugado"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProdutoconjugadosForIdProdutopai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProdutoconjugadosForIdProdutopai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProdutoconjugado"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeitos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeitos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GPesoBruto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GPesoBruto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GPesoLiquido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GPesoLiquido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrLeadtimeentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrLeadtimeentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrLeadtimesaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrLeadtimesaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indPerdaproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indPerdaproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isDat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minValposalim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minValposalim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omFor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omFor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omFor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGarpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGarpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGarpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPapros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPapros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPapro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPrgposes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPrgposes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrgpos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPrgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPrgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProaltglosForIdProdutoFilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProaltglosForIdProdutoFilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProaltglo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProaltglosForIdProdutoMae");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProaltglosForIdProdutoMae"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProaltglo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProcomestsForIdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProcomestsForIdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProcomest"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProcomestsForIdProdutomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProcomestsForIdProdutomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProcomest"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutoagru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutoagru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProgrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProgrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPropaihomosForIdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPropaihomosForIdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPropaihomo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPropaihomosForIdProdutopai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPropaihomosForIdProdutopai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPropaihomo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProturnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProturnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProturno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUnidmedida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUnidmedida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUnidmedida"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCmcomsForFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCmcomsForFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCmcom"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCmcomsForIdProdutoentra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCmcomsForIdProdutoentra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCmcom"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCmcomsForIdProdutosai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCmcomsForIdProdutosai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCmcom"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpprodutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpprodutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpproduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtLoteminprod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtLoteminprod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpOrigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpOrigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpProducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpProducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpSemiacabado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpSemiacabado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlCustounit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlCustounit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
