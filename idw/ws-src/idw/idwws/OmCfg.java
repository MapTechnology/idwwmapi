/**
 * OmCfg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmCfg  extends idw.idwws.OmCfgTemplate  implements java.io.Serializable {
    private java.lang.String dsMensagemsobretensao;

    private java.lang.String dsMensagemsubtensao;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.util.Calendar dthrEstliberado;

    private idw.idwws.DwCal dwCal;

    private idw.idwws.DwEst dwEstByIdEstexpedicao;

    private idw.idwws.DwEst dwEstByIdEstliberado;

    private idw.idwws.DwEst dwEstByIdEstmp;

    private idw.idwws.DwEst dwEstByIdEstproducao;

    private idw.idwws.DwEst dwEstByIdEstrefugo;

    private idw.idwws.DwFtParam dwFtParamByIdFtParamcorrente;

    private idw.idwws.DwFtParam dwFtParamByIdFtParamflusos;

    private idw.idwws.DwFtParam dwFtParamByIdFtParamfluxoe;

    private idw.idwws.DwFtParam dwFtParamByIdFtParamtensao;

    private idw.idwws.DwPepro dwPeproByIdPeproctreproc;

    private idw.idwws.DwPepro dwPeproByIdPepronormal;

    private idw.idwws.DwRap dwRap;

    private idw.idwws.DwTParada dwTParada;

    private long idCfg;

    private java.lang.Boolean isCompensaapont;

    private java.lang.Boolean isLogonobrigatorio;

    private java.lang.Boolean isNivelfeeder;

    private java.lang.Boolean isProcessaiacidw;

    private java.lang.Boolean isProcessaiacinsert;

    private java.lang.String mascaraQtd;

    private java.lang.String mascaracb;

    private java.lang.String mascaracdcomponenteiac;

    private java.lang.String mascaracdprodutofilho;

    private java.lang.String mascaracdprodutoiac;

    private java.lang.String mascaracdprodutopai;

    private java.lang.String mascaracdprogramaiac;

    private idw.idwws.OmAlgocor omAlgocor;

    private idw.idwws.OmCc omCcdefault;

    private idw.idwws.OmCfgind[] omCfginds;

    private idw.idwws.OmCfgptdetcoleta[] omCfgptdetcoletas;

    private idw.idwws.OmCfgscrpimp[] omCfgscrpimps;

    private idw.idwws.OmCfgurl[] omCfgurls;

    private idw.idwws.OmEmpresa omEmpresa;

    private idw.idwws.OmGt omGtimpcic;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmResgui omResgui;

    private idw.idwws.OmTpgt omTpgtByIdTpgtfabrica;

    private idw.idwws.OmTpgt omTpgtByIdTpgtlogsuper;

    private idw.idwws.OmTppt omTpptByIdTpptinsersora;

    private idw.idwws.OmTppt omTpptByIdTpptpm;

    private idw.idwws.OmTppt omTpptByIdTpptppass;

    private idw.idwws.OmTppt omTpptByIdTpptprepro;

    private idw.idwws.OmTppt omTpptByIdTpptptf;

    private idw.idwws.OmTppt omTpptByIdTpptpts;

    private idw.idwws.OmTppt omTpptByIdTpptptscd;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.OmUsrgrp omUsrgrpByIdUsrgrpoperador;

    private idw.idwws.OmUsrgrp omUsrgrpByIdUsrgrpsupervisor;

    private idw.idwws.OmUsr omUsrimpprog;

    private java.math.BigDecimal qtMaxetapateste;

    private java.math.BigDecimal qtMaxptcoletafull;

    private java.math.BigDecimal qtMaxsubetapas;

    private java.lang.Long revisao;

    private java.math.BigDecimal segAutologout;

    private java.math.BigDecimal segFeedbacklogin;

    private java.math.BigDecimal segHeartbeat;

    private java.lang.Byte stAtivo;

    private java.lang.Integer tpLayoutplano;

    public OmCfg() {
    }

    public OmCfg(
           java.lang.Long id,
           java.lang.String dsMensagemsobretensao,
           java.lang.String dsMensagemsubtensao,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.util.Calendar dthrEstliberado,
           idw.idwws.DwCal dwCal,
           idw.idwws.DwEst dwEstByIdEstexpedicao,
           idw.idwws.DwEst dwEstByIdEstliberado,
           idw.idwws.DwEst dwEstByIdEstmp,
           idw.idwws.DwEst dwEstByIdEstproducao,
           idw.idwws.DwEst dwEstByIdEstrefugo,
           idw.idwws.DwFtParam dwFtParamByIdFtParamcorrente,
           idw.idwws.DwFtParam dwFtParamByIdFtParamflusos,
           idw.idwws.DwFtParam dwFtParamByIdFtParamfluxoe,
           idw.idwws.DwFtParam dwFtParamByIdFtParamtensao,
           idw.idwws.DwPepro dwPeproByIdPeproctreproc,
           idw.idwws.DwPepro dwPeproByIdPepronormal,
           idw.idwws.DwRap dwRap,
           idw.idwws.DwTParada dwTParada,
           long idCfg,
           java.lang.Boolean isCompensaapont,
           java.lang.Boolean isLogonobrigatorio,
           java.lang.Boolean isNivelfeeder,
           java.lang.Boolean isProcessaiacidw,
           java.lang.Boolean isProcessaiacinsert,
           java.lang.String mascaraQtd,
           java.lang.String mascaracb,
           java.lang.String mascaracdcomponenteiac,
           java.lang.String mascaracdprodutofilho,
           java.lang.String mascaracdprodutoiac,
           java.lang.String mascaracdprodutopai,
           java.lang.String mascaracdprogramaiac,
           idw.idwws.OmAlgocor omAlgocor,
           idw.idwws.OmCc omCcdefault,
           idw.idwws.OmCfgind[] omCfginds,
           idw.idwws.OmCfgptdetcoleta[] omCfgptdetcoletas,
           idw.idwws.OmCfgscrpimp[] omCfgscrpimps,
           idw.idwws.OmCfgurl[] omCfgurls,
           idw.idwws.OmEmpresa omEmpresa,
           idw.idwws.OmGt omGtimpcic,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmResgui omResgui,
           idw.idwws.OmTpgt omTpgtByIdTpgtfabrica,
           idw.idwws.OmTpgt omTpgtByIdTpgtlogsuper,
           idw.idwws.OmTppt omTpptByIdTpptinsersora,
           idw.idwws.OmTppt omTpptByIdTpptpm,
           idw.idwws.OmTppt omTpptByIdTpptppass,
           idw.idwws.OmTppt omTpptByIdTpptprepro,
           idw.idwws.OmTppt omTpptByIdTpptptf,
           idw.idwws.OmTppt omTpptByIdTpptpts,
           idw.idwws.OmTppt omTpptByIdTpptptscd,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.OmUsrgrp omUsrgrpByIdUsrgrpoperador,
           idw.idwws.OmUsrgrp omUsrgrpByIdUsrgrpsupervisor,
           idw.idwws.OmUsr omUsrimpprog,
           java.math.BigDecimal qtMaxetapateste,
           java.math.BigDecimal qtMaxptcoletafull,
           java.math.BigDecimal qtMaxsubetapas,
           java.lang.Long revisao,
           java.math.BigDecimal segAutologout,
           java.math.BigDecimal segFeedbacklogin,
           java.math.BigDecimal segHeartbeat,
           java.lang.Byte stAtivo,
           java.lang.Integer tpLayoutplano) {
        super(
            id);
        this.dsMensagemsobretensao = dsMensagemsobretensao;
        this.dsMensagemsubtensao = dsMensagemsubtensao;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dthrEstliberado = dthrEstliberado;
        this.dwCal = dwCal;
        this.dwEstByIdEstexpedicao = dwEstByIdEstexpedicao;
        this.dwEstByIdEstliberado = dwEstByIdEstliberado;
        this.dwEstByIdEstmp = dwEstByIdEstmp;
        this.dwEstByIdEstproducao = dwEstByIdEstproducao;
        this.dwEstByIdEstrefugo = dwEstByIdEstrefugo;
        this.dwFtParamByIdFtParamcorrente = dwFtParamByIdFtParamcorrente;
        this.dwFtParamByIdFtParamflusos = dwFtParamByIdFtParamflusos;
        this.dwFtParamByIdFtParamfluxoe = dwFtParamByIdFtParamfluxoe;
        this.dwFtParamByIdFtParamtensao = dwFtParamByIdFtParamtensao;
        this.dwPeproByIdPeproctreproc = dwPeproByIdPeproctreproc;
        this.dwPeproByIdPepronormal = dwPeproByIdPepronormal;
        this.dwRap = dwRap;
        this.dwTParada = dwTParada;
        this.idCfg = idCfg;
        this.isCompensaapont = isCompensaapont;
        this.isLogonobrigatorio = isLogonobrigatorio;
        this.isNivelfeeder = isNivelfeeder;
        this.isProcessaiacidw = isProcessaiacidw;
        this.isProcessaiacinsert = isProcessaiacinsert;
        this.mascaraQtd = mascaraQtd;
        this.mascaracb = mascaracb;
        this.mascaracdcomponenteiac = mascaracdcomponenteiac;
        this.mascaracdprodutofilho = mascaracdprodutofilho;
        this.mascaracdprodutoiac = mascaracdprodutoiac;
        this.mascaracdprodutopai = mascaracdprodutopai;
        this.mascaracdprogramaiac = mascaracdprogramaiac;
        this.omAlgocor = omAlgocor;
        this.omCcdefault = omCcdefault;
        this.omCfginds = omCfginds;
        this.omCfgptdetcoletas = omCfgptdetcoletas;
        this.omCfgscrpimps = omCfgscrpimps;
        this.omCfgurls = omCfgurls;
        this.omEmpresa = omEmpresa;
        this.omGtimpcic = omGtimpcic;
        this.omProduto = omProduto;
        this.omResgui = omResgui;
        this.omTpgtByIdTpgtfabrica = omTpgtByIdTpgtfabrica;
        this.omTpgtByIdTpgtlogsuper = omTpgtByIdTpgtlogsuper;
        this.omTpptByIdTpptinsersora = omTpptByIdTpptinsersora;
        this.omTpptByIdTpptpm = omTpptByIdTpptpm;
        this.omTpptByIdTpptppass = omTpptByIdTpptppass;
        this.omTpptByIdTpptprepro = omTpptByIdTpptprepro;
        this.omTpptByIdTpptptf = omTpptByIdTpptptf;
        this.omTpptByIdTpptpts = omTpptByIdTpptpts;
        this.omTpptByIdTpptptscd = omTpptByIdTpptptscd;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.omUsrgrpByIdUsrgrpoperador = omUsrgrpByIdUsrgrpoperador;
        this.omUsrgrpByIdUsrgrpsupervisor = omUsrgrpByIdUsrgrpsupervisor;
        this.omUsrimpprog = omUsrimpprog;
        this.qtMaxetapateste = qtMaxetapateste;
        this.qtMaxptcoletafull = qtMaxptcoletafull;
        this.qtMaxsubetapas = qtMaxsubetapas;
        this.revisao = revisao;
        this.segAutologout = segAutologout;
        this.segFeedbacklogin = segFeedbacklogin;
        this.segHeartbeat = segHeartbeat;
        this.stAtivo = stAtivo;
        this.tpLayoutplano = tpLayoutplano;
    }


    /**
     * Gets the dsMensagemsobretensao value for this OmCfg.
     * 
     * @return dsMensagemsobretensao
     */
    public java.lang.String getDsMensagemsobretensao() {
        return dsMensagemsobretensao;
    }


    /**
     * Sets the dsMensagemsobretensao value for this OmCfg.
     * 
     * @param dsMensagemsobretensao
     */
    public void setDsMensagemsobretensao(java.lang.String dsMensagemsobretensao) {
        this.dsMensagemsobretensao = dsMensagemsobretensao;
    }


    /**
     * Gets the dsMensagemsubtensao value for this OmCfg.
     * 
     * @return dsMensagemsubtensao
     */
    public java.lang.String getDsMensagemsubtensao() {
        return dsMensagemsubtensao;
    }


    /**
     * Sets the dsMensagemsubtensao value for this OmCfg.
     * 
     * @param dsMensagemsubtensao
     */
    public void setDsMensagemsubtensao(java.lang.String dsMensagemsubtensao) {
        this.dsMensagemsubtensao = dsMensagemsubtensao;
    }


    /**
     * Gets the dtRevisao value for this OmCfg.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmCfg.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmCfg.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmCfg.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dthrEstliberado value for this OmCfg.
     * 
     * @return dthrEstliberado
     */
    public java.util.Calendar getDthrEstliberado() {
        return dthrEstliberado;
    }


    /**
     * Sets the dthrEstliberado value for this OmCfg.
     * 
     * @param dthrEstliberado
     */
    public void setDthrEstliberado(java.util.Calendar dthrEstliberado) {
        this.dthrEstliberado = dthrEstliberado;
    }


    /**
     * Gets the dwCal value for this OmCfg.
     * 
     * @return dwCal
     */
    public idw.idwws.DwCal getDwCal() {
        return dwCal;
    }


    /**
     * Sets the dwCal value for this OmCfg.
     * 
     * @param dwCal
     */
    public void setDwCal(idw.idwws.DwCal dwCal) {
        this.dwCal = dwCal;
    }


    /**
     * Gets the dwEstByIdEstexpedicao value for this OmCfg.
     * 
     * @return dwEstByIdEstexpedicao
     */
    public idw.idwws.DwEst getDwEstByIdEstexpedicao() {
        return dwEstByIdEstexpedicao;
    }


    /**
     * Sets the dwEstByIdEstexpedicao value for this OmCfg.
     * 
     * @param dwEstByIdEstexpedicao
     */
    public void setDwEstByIdEstexpedicao(idw.idwws.DwEst dwEstByIdEstexpedicao) {
        this.dwEstByIdEstexpedicao = dwEstByIdEstexpedicao;
    }


    /**
     * Gets the dwEstByIdEstliberado value for this OmCfg.
     * 
     * @return dwEstByIdEstliberado
     */
    public idw.idwws.DwEst getDwEstByIdEstliberado() {
        return dwEstByIdEstliberado;
    }


    /**
     * Sets the dwEstByIdEstliberado value for this OmCfg.
     * 
     * @param dwEstByIdEstliberado
     */
    public void setDwEstByIdEstliberado(idw.idwws.DwEst dwEstByIdEstliberado) {
        this.dwEstByIdEstliberado = dwEstByIdEstliberado;
    }


    /**
     * Gets the dwEstByIdEstmp value for this OmCfg.
     * 
     * @return dwEstByIdEstmp
     */
    public idw.idwws.DwEst getDwEstByIdEstmp() {
        return dwEstByIdEstmp;
    }


    /**
     * Sets the dwEstByIdEstmp value for this OmCfg.
     * 
     * @param dwEstByIdEstmp
     */
    public void setDwEstByIdEstmp(idw.idwws.DwEst dwEstByIdEstmp) {
        this.dwEstByIdEstmp = dwEstByIdEstmp;
    }


    /**
     * Gets the dwEstByIdEstproducao value for this OmCfg.
     * 
     * @return dwEstByIdEstproducao
     */
    public idw.idwws.DwEst getDwEstByIdEstproducao() {
        return dwEstByIdEstproducao;
    }


    /**
     * Sets the dwEstByIdEstproducao value for this OmCfg.
     * 
     * @param dwEstByIdEstproducao
     */
    public void setDwEstByIdEstproducao(idw.idwws.DwEst dwEstByIdEstproducao) {
        this.dwEstByIdEstproducao = dwEstByIdEstproducao;
    }


    /**
     * Gets the dwEstByIdEstrefugo value for this OmCfg.
     * 
     * @return dwEstByIdEstrefugo
     */
    public idw.idwws.DwEst getDwEstByIdEstrefugo() {
        return dwEstByIdEstrefugo;
    }


    /**
     * Sets the dwEstByIdEstrefugo value for this OmCfg.
     * 
     * @param dwEstByIdEstrefugo
     */
    public void setDwEstByIdEstrefugo(idw.idwws.DwEst dwEstByIdEstrefugo) {
        this.dwEstByIdEstrefugo = dwEstByIdEstrefugo;
    }


    /**
     * Gets the dwFtParamByIdFtParamcorrente value for this OmCfg.
     * 
     * @return dwFtParamByIdFtParamcorrente
     */
    public idw.idwws.DwFtParam getDwFtParamByIdFtParamcorrente() {
        return dwFtParamByIdFtParamcorrente;
    }


    /**
     * Sets the dwFtParamByIdFtParamcorrente value for this OmCfg.
     * 
     * @param dwFtParamByIdFtParamcorrente
     */
    public void setDwFtParamByIdFtParamcorrente(idw.idwws.DwFtParam dwFtParamByIdFtParamcorrente) {
        this.dwFtParamByIdFtParamcorrente = dwFtParamByIdFtParamcorrente;
    }


    /**
     * Gets the dwFtParamByIdFtParamflusos value for this OmCfg.
     * 
     * @return dwFtParamByIdFtParamflusos
     */
    public idw.idwws.DwFtParam getDwFtParamByIdFtParamflusos() {
        return dwFtParamByIdFtParamflusos;
    }


    /**
     * Sets the dwFtParamByIdFtParamflusos value for this OmCfg.
     * 
     * @param dwFtParamByIdFtParamflusos
     */
    public void setDwFtParamByIdFtParamflusos(idw.idwws.DwFtParam dwFtParamByIdFtParamflusos) {
        this.dwFtParamByIdFtParamflusos = dwFtParamByIdFtParamflusos;
    }


    /**
     * Gets the dwFtParamByIdFtParamfluxoe value for this OmCfg.
     * 
     * @return dwFtParamByIdFtParamfluxoe
     */
    public idw.idwws.DwFtParam getDwFtParamByIdFtParamfluxoe() {
        return dwFtParamByIdFtParamfluxoe;
    }


    /**
     * Sets the dwFtParamByIdFtParamfluxoe value for this OmCfg.
     * 
     * @param dwFtParamByIdFtParamfluxoe
     */
    public void setDwFtParamByIdFtParamfluxoe(idw.idwws.DwFtParam dwFtParamByIdFtParamfluxoe) {
        this.dwFtParamByIdFtParamfluxoe = dwFtParamByIdFtParamfluxoe;
    }


    /**
     * Gets the dwFtParamByIdFtParamtensao value for this OmCfg.
     * 
     * @return dwFtParamByIdFtParamtensao
     */
    public idw.idwws.DwFtParam getDwFtParamByIdFtParamtensao() {
        return dwFtParamByIdFtParamtensao;
    }


    /**
     * Sets the dwFtParamByIdFtParamtensao value for this OmCfg.
     * 
     * @param dwFtParamByIdFtParamtensao
     */
    public void setDwFtParamByIdFtParamtensao(idw.idwws.DwFtParam dwFtParamByIdFtParamtensao) {
        this.dwFtParamByIdFtParamtensao = dwFtParamByIdFtParamtensao;
    }


    /**
     * Gets the dwPeproByIdPeproctreproc value for this OmCfg.
     * 
     * @return dwPeproByIdPeproctreproc
     */
    public idw.idwws.DwPepro getDwPeproByIdPeproctreproc() {
        return dwPeproByIdPeproctreproc;
    }


    /**
     * Sets the dwPeproByIdPeproctreproc value for this OmCfg.
     * 
     * @param dwPeproByIdPeproctreproc
     */
    public void setDwPeproByIdPeproctreproc(idw.idwws.DwPepro dwPeproByIdPeproctreproc) {
        this.dwPeproByIdPeproctreproc = dwPeproByIdPeproctreproc;
    }


    /**
     * Gets the dwPeproByIdPepronormal value for this OmCfg.
     * 
     * @return dwPeproByIdPepronormal
     */
    public idw.idwws.DwPepro getDwPeproByIdPepronormal() {
        return dwPeproByIdPepronormal;
    }


    /**
     * Sets the dwPeproByIdPepronormal value for this OmCfg.
     * 
     * @param dwPeproByIdPepronormal
     */
    public void setDwPeproByIdPepronormal(idw.idwws.DwPepro dwPeproByIdPepronormal) {
        this.dwPeproByIdPepronormal = dwPeproByIdPepronormal;
    }


    /**
     * Gets the dwRap value for this OmCfg.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this OmCfg.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the dwTParada value for this OmCfg.
     * 
     * @return dwTParada
     */
    public idw.idwws.DwTParada getDwTParada() {
        return dwTParada;
    }


    /**
     * Sets the dwTParada value for this OmCfg.
     * 
     * @param dwTParada
     */
    public void setDwTParada(idw.idwws.DwTParada dwTParada) {
        this.dwTParada = dwTParada;
    }


    /**
     * Gets the idCfg value for this OmCfg.
     * 
     * @return idCfg
     */
    public long getIdCfg() {
        return idCfg;
    }


    /**
     * Sets the idCfg value for this OmCfg.
     * 
     * @param idCfg
     */
    public void setIdCfg(long idCfg) {
        this.idCfg = idCfg;
    }


    /**
     * Gets the isCompensaapont value for this OmCfg.
     * 
     * @return isCompensaapont
     */
    public java.lang.Boolean getIsCompensaapont() {
        return isCompensaapont;
    }


    /**
     * Sets the isCompensaapont value for this OmCfg.
     * 
     * @param isCompensaapont
     */
    public void setIsCompensaapont(java.lang.Boolean isCompensaapont) {
        this.isCompensaapont = isCompensaapont;
    }


    /**
     * Gets the isLogonobrigatorio value for this OmCfg.
     * 
     * @return isLogonobrigatorio
     */
    public java.lang.Boolean getIsLogonobrigatorio() {
        return isLogonobrigatorio;
    }


    /**
     * Sets the isLogonobrigatorio value for this OmCfg.
     * 
     * @param isLogonobrigatorio
     */
    public void setIsLogonobrigatorio(java.lang.Boolean isLogonobrigatorio) {
        this.isLogonobrigatorio = isLogonobrigatorio;
    }


    /**
     * Gets the isNivelfeeder value for this OmCfg.
     * 
     * @return isNivelfeeder
     */
    public java.lang.Boolean getIsNivelfeeder() {
        return isNivelfeeder;
    }


    /**
     * Sets the isNivelfeeder value for this OmCfg.
     * 
     * @param isNivelfeeder
     */
    public void setIsNivelfeeder(java.lang.Boolean isNivelfeeder) {
        this.isNivelfeeder = isNivelfeeder;
    }


    /**
     * Gets the isProcessaiacidw value for this OmCfg.
     * 
     * @return isProcessaiacidw
     */
    public java.lang.Boolean getIsProcessaiacidw() {
        return isProcessaiacidw;
    }


    /**
     * Sets the isProcessaiacidw value for this OmCfg.
     * 
     * @param isProcessaiacidw
     */
    public void setIsProcessaiacidw(java.lang.Boolean isProcessaiacidw) {
        this.isProcessaiacidw = isProcessaiacidw;
    }


    /**
     * Gets the isProcessaiacinsert value for this OmCfg.
     * 
     * @return isProcessaiacinsert
     */
    public java.lang.Boolean getIsProcessaiacinsert() {
        return isProcessaiacinsert;
    }


    /**
     * Sets the isProcessaiacinsert value for this OmCfg.
     * 
     * @param isProcessaiacinsert
     */
    public void setIsProcessaiacinsert(java.lang.Boolean isProcessaiacinsert) {
        this.isProcessaiacinsert = isProcessaiacinsert;
    }


    /**
     * Gets the mascaraQtd value for this OmCfg.
     * 
     * @return mascaraQtd
     */
    public java.lang.String getMascaraQtd() {
        return mascaraQtd;
    }


    /**
     * Sets the mascaraQtd value for this OmCfg.
     * 
     * @param mascaraQtd
     */
    public void setMascaraQtd(java.lang.String mascaraQtd) {
        this.mascaraQtd = mascaraQtd;
    }


    /**
     * Gets the mascaracb value for this OmCfg.
     * 
     * @return mascaracb
     */
    public java.lang.String getMascaracb() {
        return mascaracb;
    }


    /**
     * Sets the mascaracb value for this OmCfg.
     * 
     * @param mascaracb
     */
    public void setMascaracb(java.lang.String mascaracb) {
        this.mascaracb = mascaracb;
    }


    /**
     * Gets the mascaracdcomponenteiac value for this OmCfg.
     * 
     * @return mascaracdcomponenteiac
     */
    public java.lang.String getMascaracdcomponenteiac() {
        return mascaracdcomponenteiac;
    }


    /**
     * Sets the mascaracdcomponenteiac value for this OmCfg.
     * 
     * @param mascaracdcomponenteiac
     */
    public void setMascaracdcomponenteiac(java.lang.String mascaracdcomponenteiac) {
        this.mascaracdcomponenteiac = mascaracdcomponenteiac;
    }


    /**
     * Gets the mascaracdprodutofilho value for this OmCfg.
     * 
     * @return mascaracdprodutofilho
     */
    public java.lang.String getMascaracdprodutofilho() {
        return mascaracdprodutofilho;
    }


    /**
     * Sets the mascaracdprodutofilho value for this OmCfg.
     * 
     * @param mascaracdprodutofilho
     */
    public void setMascaracdprodutofilho(java.lang.String mascaracdprodutofilho) {
        this.mascaracdprodutofilho = mascaracdprodutofilho;
    }


    /**
     * Gets the mascaracdprodutoiac value for this OmCfg.
     * 
     * @return mascaracdprodutoiac
     */
    public java.lang.String getMascaracdprodutoiac() {
        return mascaracdprodutoiac;
    }


    /**
     * Sets the mascaracdprodutoiac value for this OmCfg.
     * 
     * @param mascaracdprodutoiac
     */
    public void setMascaracdprodutoiac(java.lang.String mascaracdprodutoiac) {
        this.mascaracdprodutoiac = mascaracdprodutoiac;
    }


    /**
     * Gets the mascaracdprodutopai value for this OmCfg.
     * 
     * @return mascaracdprodutopai
     */
    public java.lang.String getMascaracdprodutopai() {
        return mascaracdprodutopai;
    }


    /**
     * Sets the mascaracdprodutopai value for this OmCfg.
     * 
     * @param mascaracdprodutopai
     */
    public void setMascaracdprodutopai(java.lang.String mascaracdprodutopai) {
        this.mascaracdprodutopai = mascaracdprodutopai;
    }


    /**
     * Gets the mascaracdprogramaiac value for this OmCfg.
     * 
     * @return mascaracdprogramaiac
     */
    public java.lang.String getMascaracdprogramaiac() {
        return mascaracdprogramaiac;
    }


    /**
     * Sets the mascaracdprogramaiac value for this OmCfg.
     * 
     * @param mascaracdprogramaiac
     */
    public void setMascaracdprogramaiac(java.lang.String mascaracdprogramaiac) {
        this.mascaracdprogramaiac = mascaracdprogramaiac;
    }


    /**
     * Gets the omAlgocor value for this OmCfg.
     * 
     * @return omAlgocor
     */
    public idw.idwws.OmAlgocor getOmAlgocor() {
        return omAlgocor;
    }


    /**
     * Sets the omAlgocor value for this OmCfg.
     * 
     * @param omAlgocor
     */
    public void setOmAlgocor(idw.idwws.OmAlgocor omAlgocor) {
        this.omAlgocor = omAlgocor;
    }


    /**
     * Gets the omCcdefault value for this OmCfg.
     * 
     * @return omCcdefault
     */
    public idw.idwws.OmCc getOmCcdefault() {
        return omCcdefault;
    }


    /**
     * Sets the omCcdefault value for this OmCfg.
     * 
     * @param omCcdefault
     */
    public void setOmCcdefault(idw.idwws.OmCc omCcdefault) {
        this.omCcdefault = omCcdefault;
    }


    /**
     * Gets the omCfginds value for this OmCfg.
     * 
     * @return omCfginds
     */
    public idw.idwws.OmCfgind[] getOmCfginds() {
        return omCfginds;
    }


    /**
     * Sets the omCfginds value for this OmCfg.
     * 
     * @param omCfginds
     */
    public void setOmCfginds(idw.idwws.OmCfgind[] omCfginds) {
        this.omCfginds = omCfginds;
    }

    public idw.idwws.OmCfgind getOmCfginds(int i) {
        return this.omCfginds[i];
    }

    public void setOmCfginds(int i, idw.idwws.OmCfgind _value) {
        this.omCfginds[i] = _value;
    }


    /**
     * Gets the omCfgptdetcoletas value for this OmCfg.
     * 
     * @return omCfgptdetcoletas
     */
    public idw.idwws.OmCfgptdetcoleta[] getOmCfgptdetcoletas() {
        return omCfgptdetcoletas;
    }


    /**
     * Sets the omCfgptdetcoletas value for this OmCfg.
     * 
     * @param omCfgptdetcoletas
     */
    public void setOmCfgptdetcoletas(idw.idwws.OmCfgptdetcoleta[] omCfgptdetcoletas) {
        this.omCfgptdetcoletas = omCfgptdetcoletas;
    }

    public idw.idwws.OmCfgptdetcoleta getOmCfgptdetcoletas(int i) {
        return this.omCfgptdetcoletas[i];
    }

    public void setOmCfgptdetcoletas(int i, idw.idwws.OmCfgptdetcoleta _value) {
        this.omCfgptdetcoletas[i] = _value;
    }


    /**
     * Gets the omCfgscrpimps value for this OmCfg.
     * 
     * @return omCfgscrpimps
     */
    public idw.idwws.OmCfgscrpimp[] getOmCfgscrpimps() {
        return omCfgscrpimps;
    }


    /**
     * Sets the omCfgscrpimps value for this OmCfg.
     * 
     * @param omCfgscrpimps
     */
    public void setOmCfgscrpimps(idw.idwws.OmCfgscrpimp[] omCfgscrpimps) {
        this.omCfgscrpimps = omCfgscrpimps;
    }

    public idw.idwws.OmCfgscrpimp getOmCfgscrpimps(int i) {
        return this.omCfgscrpimps[i];
    }

    public void setOmCfgscrpimps(int i, idw.idwws.OmCfgscrpimp _value) {
        this.omCfgscrpimps[i] = _value;
    }


    /**
     * Gets the omCfgurls value for this OmCfg.
     * 
     * @return omCfgurls
     */
    public idw.idwws.OmCfgurl[] getOmCfgurls() {
        return omCfgurls;
    }


    /**
     * Sets the omCfgurls value for this OmCfg.
     * 
     * @param omCfgurls
     */
    public void setOmCfgurls(idw.idwws.OmCfgurl[] omCfgurls) {
        this.omCfgurls = omCfgurls;
    }

    public idw.idwws.OmCfgurl getOmCfgurls(int i) {
        return this.omCfgurls[i];
    }

    public void setOmCfgurls(int i, idw.idwws.OmCfgurl _value) {
        this.omCfgurls[i] = _value;
    }


    /**
     * Gets the omEmpresa value for this OmCfg.
     * 
     * @return omEmpresa
     */
    public idw.idwws.OmEmpresa getOmEmpresa() {
        return omEmpresa;
    }


    /**
     * Sets the omEmpresa value for this OmCfg.
     * 
     * @param omEmpresa
     */
    public void setOmEmpresa(idw.idwws.OmEmpresa omEmpresa) {
        this.omEmpresa = omEmpresa;
    }


    /**
     * Gets the omGtimpcic value for this OmCfg.
     * 
     * @return omGtimpcic
     */
    public idw.idwws.OmGt getOmGtimpcic() {
        return omGtimpcic;
    }


    /**
     * Sets the omGtimpcic value for this OmCfg.
     * 
     * @param omGtimpcic
     */
    public void setOmGtimpcic(idw.idwws.OmGt omGtimpcic) {
        this.omGtimpcic = omGtimpcic;
    }


    /**
     * Gets the omProduto value for this OmCfg.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmCfg.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omResgui value for this OmCfg.
     * 
     * @return omResgui
     */
    public idw.idwws.OmResgui getOmResgui() {
        return omResgui;
    }


    /**
     * Sets the omResgui value for this OmCfg.
     * 
     * @param omResgui
     */
    public void setOmResgui(idw.idwws.OmResgui omResgui) {
        this.omResgui = omResgui;
    }


    /**
     * Gets the omTpgtByIdTpgtfabrica value for this OmCfg.
     * 
     * @return omTpgtByIdTpgtfabrica
     */
    public idw.idwws.OmTpgt getOmTpgtByIdTpgtfabrica() {
        return omTpgtByIdTpgtfabrica;
    }


    /**
     * Sets the omTpgtByIdTpgtfabrica value for this OmCfg.
     * 
     * @param omTpgtByIdTpgtfabrica
     */
    public void setOmTpgtByIdTpgtfabrica(idw.idwws.OmTpgt omTpgtByIdTpgtfabrica) {
        this.omTpgtByIdTpgtfabrica = omTpgtByIdTpgtfabrica;
    }


    /**
     * Gets the omTpgtByIdTpgtlogsuper value for this OmCfg.
     * 
     * @return omTpgtByIdTpgtlogsuper
     */
    public idw.idwws.OmTpgt getOmTpgtByIdTpgtlogsuper() {
        return omTpgtByIdTpgtlogsuper;
    }


    /**
     * Sets the omTpgtByIdTpgtlogsuper value for this OmCfg.
     * 
     * @param omTpgtByIdTpgtlogsuper
     */
    public void setOmTpgtByIdTpgtlogsuper(idw.idwws.OmTpgt omTpgtByIdTpgtlogsuper) {
        this.omTpgtByIdTpgtlogsuper = omTpgtByIdTpgtlogsuper;
    }


    /**
     * Gets the omTpptByIdTpptinsersora value for this OmCfg.
     * 
     * @return omTpptByIdTpptinsersora
     */
    public idw.idwws.OmTppt getOmTpptByIdTpptinsersora() {
        return omTpptByIdTpptinsersora;
    }


    /**
     * Sets the omTpptByIdTpptinsersora value for this OmCfg.
     * 
     * @param omTpptByIdTpptinsersora
     */
    public void setOmTpptByIdTpptinsersora(idw.idwws.OmTppt omTpptByIdTpptinsersora) {
        this.omTpptByIdTpptinsersora = omTpptByIdTpptinsersora;
    }


    /**
     * Gets the omTpptByIdTpptpm value for this OmCfg.
     * 
     * @return omTpptByIdTpptpm
     */
    public idw.idwws.OmTppt getOmTpptByIdTpptpm() {
        return omTpptByIdTpptpm;
    }


    /**
     * Sets the omTpptByIdTpptpm value for this OmCfg.
     * 
     * @param omTpptByIdTpptpm
     */
    public void setOmTpptByIdTpptpm(idw.idwws.OmTppt omTpptByIdTpptpm) {
        this.omTpptByIdTpptpm = omTpptByIdTpptpm;
    }


    /**
     * Gets the omTpptByIdTpptppass value for this OmCfg.
     * 
     * @return omTpptByIdTpptppass
     */
    public idw.idwws.OmTppt getOmTpptByIdTpptppass() {
        return omTpptByIdTpptppass;
    }


    /**
     * Sets the omTpptByIdTpptppass value for this OmCfg.
     * 
     * @param omTpptByIdTpptppass
     */
    public void setOmTpptByIdTpptppass(idw.idwws.OmTppt omTpptByIdTpptppass) {
        this.omTpptByIdTpptppass = omTpptByIdTpptppass;
    }


    /**
     * Gets the omTpptByIdTpptprepro value for this OmCfg.
     * 
     * @return omTpptByIdTpptprepro
     */
    public idw.idwws.OmTppt getOmTpptByIdTpptprepro() {
        return omTpptByIdTpptprepro;
    }


    /**
     * Sets the omTpptByIdTpptprepro value for this OmCfg.
     * 
     * @param omTpptByIdTpptprepro
     */
    public void setOmTpptByIdTpptprepro(idw.idwws.OmTppt omTpptByIdTpptprepro) {
        this.omTpptByIdTpptprepro = omTpptByIdTpptprepro;
    }


    /**
     * Gets the omTpptByIdTpptptf value for this OmCfg.
     * 
     * @return omTpptByIdTpptptf
     */
    public idw.idwws.OmTppt getOmTpptByIdTpptptf() {
        return omTpptByIdTpptptf;
    }


    /**
     * Sets the omTpptByIdTpptptf value for this OmCfg.
     * 
     * @param omTpptByIdTpptptf
     */
    public void setOmTpptByIdTpptptf(idw.idwws.OmTppt omTpptByIdTpptptf) {
        this.omTpptByIdTpptptf = omTpptByIdTpptptf;
    }


    /**
     * Gets the omTpptByIdTpptpts value for this OmCfg.
     * 
     * @return omTpptByIdTpptpts
     */
    public idw.idwws.OmTppt getOmTpptByIdTpptpts() {
        return omTpptByIdTpptpts;
    }


    /**
     * Sets the omTpptByIdTpptpts value for this OmCfg.
     * 
     * @param omTpptByIdTpptpts
     */
    public void setOmTpptByIdTpptpts(idw.idwws.OmTppt omTpptByIdTpptpts) {
        this.omTpptByIdTpptpts = omTpptByIdTpptpts;
    }


    /**
     * Gets the omTpptByIdTpptptscd value for this OmCfg.
     * 
     * @return omTpptByIdTpptptscd
     */
    public idw.idwws.OmTppt getOmTpptByIdTpptptscd() {
        return omTpptByIdTpptptscd;
    }


    /**
     * Sets the omTpptByIdTpptptscd value for this OmCfg.
     * 
     * @param omTpptByIdTpptptscd
     */
    public void setOmTpptByIdTpptptscd(idw.idwws.OmTppt omTpptByIdTpptptscd) {
        this.omTpptByIdTpptptscd = omTpptByIdTpptptscd;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmCfg.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmCfg.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmCfg.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmCfg.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the omUsrgrpByIdUsrgrpoperador value for this OmCfg.
     * 
     * @return omUsrgrpByIdUsrgrpoperador
     */
    public idw.idwws.OmUsrgrp getOmUsrgrpByIdUsrgrpoperador() {
        return omUsrgrpByIdUsrgrpoperador;
    }


    /**
     * Sets the omUsrgrpByIdUsrgrpoperador value for this OmCfg.
     * 
     * @param omUsrgrpByIdUsrgrpoperador
     */
    public void setOmUsrgrpByIdUsrgrpoperador(idw.idwws.OmUsrgrp omUsrgrpByIdUsrgrpoperador) {
        this.omUsrgrpByIdUsrgrpoperador = omUsrgrpByIdUsrgrpoperador;
    }


    /**
     * Gets the omUsrgrpByIdUsrgrpsupervisor value for this OmCfg.
     * 
     * @return omUsrgrpByIdUsrgrpsupervisor
     */
    public idw.idwws.OmUsrgrp getOmUsrgrpByIdUsrgrpsupervisor() {
        return omUsrgrpByIdUsrgrpsupervisor;
    }


    /**
     * Sets the omUsrgrpByIdUsrgrpsupervisor value for this OmCfg.
     * 
     * @param omUsrgrpByIdUsrgrpsupervisor
     */
    public void setOmUsrgrpByIdUsrgrpsupervisor(idw.idwws.OmUsrgrp omUsrgrpByIdUsrgrpsupervisor) {
        this.omUsrgrpByIdUsrgrpsupervisor = omUsrgrpByIdUsrgrpsupervisor;
    }


    /**
     * Gets the omUsrimpprog value for this OmCfg.
     * 
     * @return omUsrimpprog
     */
    public idw.idwws.OmUsr getOmUsrimpprog() {
        return omUsrimpprog;
    }


    /**
     * Sets the omUsrimpprog value for this OmCfg.
     * 
     * @param omUsrimpprog
     */
    public void setOmUsrimpprog(idw.idwws.OmUsr omUsrimpprog) {
        this.omUsrimpprog = omUsrimpprog;
    }


    /**
     * Gets the qtMaxetapateste value for this OmCfg.
     * 
     * @return qtMaxetapateste
     */
    public java.math.BigDecimal getQtMaxetapateste() {
        return qtMaxetapateste;
    }


    /**
     * Sets the qtMaxetapateste value for this OmCfg.
     * 
     * @param qtMaxetapateste
     */
    public void setQtMaxetapateste(java.math.BigDecimal qtMaxetapateste) {
        this.qtMaxetapateste = qtMaxetapateste;
    }


    /**
     * Gets the qtMaxptcoletafull value for this OmCfg.
     * 
     * @return qtMaxptcoletafull
     */
    public java.math.BigDecimal getQtMaxptcoletafull() {
        return qtMaxptcoletafull;
    }


    /**
     * Sets the qtMaxptcoletafull value for this OmCfg.
     * 
     * @param qtMaxptcoletafull
     */
    public void setQtMaxptcoletafull(java.math.BigDecimal qtMaxptcoletafull) {
        this.qtMaxptcoletafull = qtMaxptcoletafull;
    }


    /**
     * Gets the qtMaxsubetapas value for this OmCfg.
     * 
     * @return qtMaxsubetapas
     */
    public java.math.BigDecimal getQtMaxsubetapas() {
        return qtMaxsubetapas;
    }


    /**
     * Sets the qtMaxsubetapas value for this OmCfg.
     * 
     * @param qtMaxsubetapas
     */
    public void setQtMaxsubetapas(java.math.BigDecimal qtMaxsubetapas) {
        this.qtMaxsubetapas = qtMaxsubetapas;
    }


    /**
     * Gets the revisao value for this OmCfg.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmCfg.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the segAutologout value for this OmCfg.
     * 
     * @return segAutologout
     */
    public java.math.BigDecimal getSegAutologout() {
        return segAutologout;
    }


    /**
     * Sets the segAutologout value for this OmCfg.
     * 
     * @param segAutologout
     */
    public void setSegAutologout(java.math.BigDecimal segAutologout) {
        this.segAutologout = segAutologout;
    }


    /**
     * Gets the segFeedbacklogin value for this OmCfg.
     * 
     * @return segFeedbacklogin
     */
    public java.math.BigDecimal getSegFeedbacklogin() {
        return segFeedbacklogin;
    }


    /**
     * Sets the segFeedbacklogin value for this OmCfg.
     * 
     * @param segFeedbacklogin
     */
    public void setSegFeedbacklogin(java.math.BigDecimal segFeedbacklogin) {
        this.segFeedbacklogin = segFeedbacklogin;
    }


    /**
     * Gets the segHeartbeat value for this OmCfg.
     * 
     * @return segHeartbeat
     */
    public java.math.BigDecimal getSegHeartbeat() {
        return segHeartbeat;
    }


    /**
     * Sets the segHeartbeat value for this OmCfg.
     * 
     * @param segHeartbeat
     */
    public void setSegHeartbeat(java.math.BigDecimal segHeartbeat) {
        this.segHeartbeat = segHeartbeat;
    }


    /**
     * Gets the stAtivo value for this OmCfg.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmCfg.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpLayoutplano value for this OmCfg.
     * 
     * @return tpLayoutplano
     */
    public java.lang.Integer getTpLayoutplano() {
        return tpLayoutplano;
    }


    /**
     * Sets the tpLayoutplano value for this OmCfg.
     * 
     * @param tpLayoutplano
     */
    public void setTpLayoutplano(java.lang.Integer tpLayoutplano) {
        this.tpLayoutplano = tpLayoutplano;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmCfg)) return false;
        OmCfg other = (OmCfg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsMensagemsobretensao==null && other.getDsMensagemsobretensao()==null) || 
             (this.dsMensagemsobretensao!=null &&
              this.dsMensagemsobretensao.equals(other.getDsMensagemsobretensao()))) &&
            ((this.dsMensagemsubtensao==null && other.getDsMensagemsubtensao()==null) || 
             (this.dsMensagemsubtensao!=null &&
              this.dsMensagemsubtensao.equals(other.getDsMensagemsubtensao()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dthrEstliberado==null && other.getDthrEstliberado()==null) || 
             (this.dthrEstliberado!=null &&
              this.dthrEstliberado.equals(other.getDthrEstliberado()))) &&
            ((this.dwCal==null && other.getDwCal()==null) || 
             (this.dwCal!=null &&
              this.dwCal.equals(other.getDwCal()))) &&
            ((this.dwEstByIdEstexpedicao==null && other.getDwEstByIdEstexpedicao()==null) || 
             (this.dwEstByIdEstexpedicao!=null &&
              this.dwEstByIdEstexpedicao.equals(other.getDwEstByIdEstexpedicao()))) &&
            ((this.dwEstByIdEstliberado==null && other.getDwEstByIdEstliberado()==null) || 
             (this.dwEstByIdEstliberado!=null &&
              this.dwEstByIdEstliberado.equals(other.getDwEstByIdEstliberado()))) &&
            ((this.dwEstByIdEstmp==null && other.getDwEstByIdEstmp()==null) || 
             (this.dwEstByIdEstmp!=null &&
              this.dwEstByIdEstmp.equals(other.getDwEstByIdEstmp()))) &&
            ((this.dwEstByIdEstproducao==null && other.getDwEstByIdEstproducao()==null) || 
             (this.dwEstByIdEstproducao!=null &&
              this.dwEstByIdEstproducao.equals(other.getDwEstByIdEstproducao()))) &&
            ((this.dwEstByIdEstrefugo==null && other.getDwEstByIdEstrefugo()==null) || 
             (this.dwEstByIdEstrefugo!=null &&
              this.dwEstByIdEstrefugo.equals(other.getDwEstByIdEstrefugo()))) &&
            ((this.dwFtParamByIdFtParamcorrente==null && other.getDwFtParamByIdFtParamcorrente()==null) || 
             (this.dwFtParamByIdFtParamcorrente!=null &&
              this.dwFtParamByIdFtParamcorrente.equals(other.getDwFtParamByIdFtParamcorrente()))) &&
            ((this.dwFtParamByIdFtParamflusos==null && other.getDwFtParamByIdFtParamflusos()==null) || 
             (this.dwFtParamByIdFtParamflusos!=null &&
              this.dwFtParamByIdFtParamflusos.equals(other.getDwFtParamByIdFtParamflusos()))) &&
            ((this.dwFtParamByIdFtParamfluxoe==null && other.getDwFtParamByIdFtParamfluxoe()==null) || 
             (this.dwFtParamByIdFtParamfluxoe!=null &&
              this.dwFtParamByIdFtParamfluxoe.equals(other.getDwFtParamByIdFtParamfluxoe()))) &&
            ((this.dwFtParamByIdFtParamtensao==null && other.getDwFtParamByIdFtParamtensao()==null) || 
             (this.dwFtParamByIdFtParamtensao!=null &&
              this.dwFtParamByIdFtParamtensao.equals(other.getDwFtParamByIdFtParamtensao()))) &&
            ((this.dwPeproByIdPeproctreproc==null && other.getDwPeproByIdPeproctreproc()==null) || 
             (this.dwPeproByIdPeproctreproc!=null &&
              this.dwPeproByIdPeproctreproc.equals(other.getDwPeproByIdPeproctreproc()))) &&
            ((this.dwPeproByIdPepronormal==null && other.getDwPeproByIdPepronormal()==null) || 
             (this.dwPeproByIdPepronormal!=null &&
              this.dwPeproByIdPepronormal.equals(other.getDwPeproByIdPepronormal()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.dwTParada==null && other.getDwTParada()==null) || 
             (this.dwTParada!=null &&
              this.dwTParada.equals(other.getDwTParada()))) &&
            this.idCfg == other.getIdCfg() &&
            ((this.isCompensaapont==null && other.getIsCompensaapont()==null) || 
             (this.isCompensaapont!=null &&
              this.isCompensaapont.equals(other.getIsCompensaapont()))) &&
            ((this.isLogonobrigatorio==null && other.getIsLogonobrigatorio()==null) || 
             (this.isLogonobrigatorio!=null &&
              this.isLogonobrigatorio.equals(other.getIsLogonobrigatorio()))) &&
            ((this.isNivelfeeder==null && other.getIsNivelfeeder()==null) || 
             (this.isNivelfeeder!=null &&
              this.isNivelfeeder.equals(other.getIsNivelfeeder()))) &&
            ((this.isProcessaiacidw==null && other.getIsProcessaiacidw()==null) || 
             (this.isProcessaiacidw!=null &&
              this.isProcessaiacidw.equals(other.getIsProcessaiacidw()))) &&
            ((this.isProcessaiacinsert==null && other.getIsProcessaiacinsert()==null) || 
             (this.isProcessaiacinsert!=null &&
              this.isProcessaiacinsert.equals(other.getIsProcessaiacinsert()))) &&
            ((this.mascaraQtd==null && other.getMascaraQtd()==null) || 
             (this.mascaraQtd!=null &&
              this.mascaraQtd.equals(other.getMascaraQtd()))) &&
            ((this.mascaracb==null && other.getMascaracb()==null) || 
             (this.mascaracb!=null &&
              this.mascaracb.equals(other.getMascaracb()))) &&
            ((this.mascaracdcomponenteiac==null && other.getMascaracdcomponenteiac()==null) || 
             (this.mascaracdcomponenteiac!=null &&
              this.mascaracdcomponenteiac.equals(other.getMascaracdcomponenteiac()))) &&
            ((this.mascaracdprodutofilho==null && other.getMascaracdprodutofilho()==null) || 
             (this.mascaracdprodutofilho!=null &&
              this.mascaracdprodutofilho.equals(other.getMascaracdprodutofilho()))) &&
            ((this.mascaracdprodutoiac==null && other.getMascaracdprodutoiac()==null) || 
             (this.mascaracdprodutoiac!=null &&
              this.mascaracdprodutoiac.equals(other.getMascaracdprodutoiac()))) &&
            ((this.mascaracdprodutopai==null && other.getMascaracdprodutopai()==null) || 
             (this.mascaracdprodutopai!=null &&
              this.mascaracdprodutopai.equals(other.getMascaracdprodutopai()))) &&
            ((this.mascaracdprogramaiac==null && other.getMascaracdprogramaiac()==null) || 
             (this.mascaracdprogramaiac!=null &&
              this.mascaracdprogramaiac.equals(other.getMascaracdprogramaiac()))) &&
            ((this.omAlgocor==null && other.getOmAlgocor()==null) || 
             (this.omAlgocor!=null &&
              this.omAlgocor.equals(other.getOmAlgocor()))) &&
            ((this.omCcdefault==null && other.getOmCcdefault()==null) || 
             (this.omCcdefault!=null &&
              this.omCcdefault.equals(other.getOmCcdefault()))) &&
            ((this.omCfginds==null && other.getOmCfginds()==null) || 
             (this.omCfginds!=null &&
              java.util.Arrays.equals(this.omCfginds, other.getOmCfginds()))) &&
            ((this.omCfgptdetcoletas==null && other.getOmCfgptdetcoletas()==null) || 
             (this.omCfgptdetcoletas!=null &&
              java.util.Arrays.equals(this.omCfgptdetcoletas, other.getOmCfgptdetcoletas()))) &&
            ((this.omCfgscrpimps==null && other.getOmCfgscrpimps()==null) || 
             (this.omCfgscrpimps!=null &&
              java.util.Arrays.equals(this.omCfgscrpimps, other.getOmCfgscrpimps()))) &&
            ((this.omCfgurls==null && other.getOmCfgurls()==null) || 
             (this.omCfgurls!=null &&
              java.util.Arrays.equals(this.omCfgurls, other.getOmCfgurls()))) &&
            ((this.omEmpresa==null && other.getOmEmpresa()==null) || 
             (this.omEmpresa!=null &&
              this.omEmpresa.equals(other.getOmEmpresa()))) &&
            ((this.omGtimpcic==null && other.getOmGtimpcic()==null) || 
             (this.omGtimpcic!=null &&
              this.omGtimpcic.equals(other.getOmGtimpcic()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omResgui==null && other.getOmResgui()==null) || 
             (this.omResgui!=null &&
              this.omResgui.equals(other.getOmResgui()))) &&
            ((this.omTpgtByIdTpgtfabrica==null && other.getOmTpgtByIdTpgtfabrica()==null) || 
             (this.omTpgtByIdTpgtfabrica!=null &&
              this.omTpgtByIdTpgtfabrica.equals(other.getOmTpgtByIdTpgtfabrica()))) &&
            ((this.omTpgtByIdTpgtlogsuper==null && other.getOmTpgtByIdTpgtlogsuper()==null) || 
             (this.omTpgtByIdTpgtlogsuper!=null &&
              this.omTpgtByIdTpgtlogsuper.equals(other.getOmTpgtByIdTpgtlogsuper()))) &&
            ((this.omTpptByIdTpptinsersora==null && other.getOmTpptByIdTpptinsersora()==null) || 
             (this.omTpptByIdTpptinsersora!=null &&
              this.omTpptByIdTpptinsersora.equals(other.getOmTpptByIdTpptinsersora()))) &&
            ((this.omTpptByIdTpptpm==null && other.getOmTpptByIdTpptpm()==null) || 
             (this.omTpptByIdTpptpm!=null &&
              this.omTpptByIdTpptpm.equals(other.getOmTpptByIdTpptpm()))) &&
            ((this.omTpptByIdTpptppass==null && other.getOmTpptByIdTpptppass()==null) || 
             (this.omTpptByIdTpptppass!=null &&
              this.omTpptByIdTpptppass.equals(other.getOmTpptByIdTpptppass()))) &&
            ((this.omTpptByIdTpptprepro==null && other.getOmTpptByIdTpptprepro()==null) || 
             (this.omTpptByIdTpptprepro!=null &&
              this.omTpptByIdTpptprepro.equals(other.getOmTpptByIdTpptprepro()))) &&
            ((this.omTpptByIdTpptptf==null && other.getOmTpptByIdTpptptf()==null) || 
             (this.omTpptByIdTpptptf!=null &&
              this.omTpptByIdTpptptf.equals(other.getOmTpptByIdTpptptf()))) &&
            ((this.omTpptByIdTpptpts==null && other.getOmTpptByIdTpptpts()==null) || 
             (this.omTpptByIdTpptpts!=null &&
              this.omTpptByIdTpptpts.equals(other.getOmTpptByIdTpptpts()))) &&
            ((this.omTpptByIdTpptptscd==null && other.getOmTpptByIdTpptptscd()==null) || 
             (this.omTpptByIdTpptptscd!=null &&
              this.omTpptByIdTpptptscd.equals(other.getOmTpptByIdTpptptscd()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.omUsrgrpByIdUsrgrpoperador==null && other.getOmUsrgrpByIdUsrgrpoperador()==null) || 
             (this.omUsrgrpByIdUsrgrpoperador!=null &&
              this.omUsrgrpByIdUsrgrpoperador.equals(other.getOmUsrgrpByIdUsrgrpoperador()))) &&
            ((this.omUsrgrpByIdUsrgrpsupervisor==null && other.getOmUsrgrpByIdUsrgrpsupervisor()==null) || 
             (this.omUsrgrpByIdUsrgrpsupervisor!=null &&
              this.omUsrgrpByIdUsrgrpsupervisor.equals(other.getOmUsrgrpByIdUsrgrpsupervisor()))) &&
            ((this.omUsrimpprog==null && other.getOmUsrimpprog()==null) || 
             (this.omUsrimpprog!=null &&
              this.omUsrimpprog.equals(other.getOmUsrimpprog()))) &&
            ((this.qtMaxetapateste==null && other.getQtMaxetapateste()==null) || 
             (this.qtMaxetapateste!=null &&
              this.qtMaxetapateste.equals(other.getQtMaxetapateste()))) &&
            ((this.qtMaxptcoletafull==null && other.getQtMaxptcoletafull()==null) || 
             (this.qtMaxptcoletafull!=null &&
              this.qtMaxptcoletafull.equals(other.getQtMaxptcoletafull()))) &&
            ((this.qtMaxsubetapas==null && other.getQtMaxsubetapas()==null) || 
             (this.qtMaxsubetapas!=null &&
              this.qtMaxsubetapas.equals(other.getQtMaxsubetapas()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.segAutologout==null && other.getSegAutologout()==null) || 
             (this.segAutologout!=null &&
              this.segAutologout.equals(other.getSegAutologout()))) &&
            ((this.segFeedbacklogin==null && other.getSegFeedbacklogin()==null) || 
             (this.segFeedbacklogin!=null &&
              this.segFeedbacklogin.equals(other.getSegFeedbacklogin()))) &&
            ((this.segHeartbeat==null && other.getSegHeartbeat()==null) || 
             (this.segHeartbeat!=null &&
              this.segHeartbeat.equals(other.getSegHeartbeat()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpLayoutplano==null && other.getTpLayoutplano()==null) || 
             (this.tpLayoutplano!=null &&
              this.tpLayoutplano.equals(other.getTpLayoutplano())));
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
        if (getDsMensagemsobretensao() != null) {
            _hashCode += getDsMensagemsobretensao().hashCode();
        }
        if (getDsMensagemsubtensao() != null) {
            _hashCode += getDsMensagemsubtensao().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDthrEstliberado() != null) {
            _hashCode += getDthrEstliberado().hashCode();
        }
        if (getDwCal() != null) {
            _hashCode += getDwCal().hashCode();
        }
        if (getDwEstByIdEstexpedicao() != null) {
            _hashCode += getDwEstByIdEstexpedicao().hashCode();
        }
        if (getDwEstByIdEstliberado() != null) {
            _hashCode += getDwEstByIdEstliberado().hashCode();
        }
        if (getDwEstByIdEstmp() != null) {
            _hashCode += getDwEstByIdEstmp().hashCode();
        }
        if (getDwEstByIdEstproducao() != null) {
            _hashCode += getDwEstByIdEstproducao().hashCode();
        }
        if (getDwEstByIdEstrefugo() != null) {
            _hashCode += getDwEstByIdEstrefugo().hashCode();
        }
        if (getDwFtParamByIdFtParamcorrente() != null) {
            _hashCode += getDwFtParamByIdFtParamcorrente().hashCode();
        }
        if (getDwFtParamByIdFtParamflusos() != null) {
            _hashCode += getDwFtParamByIdFtParamflusos().hashCode();
        }
        if (getDwFtParamByIdFtParamfluxoe() != null) {
            _hashCode += getDwFtParamByIdFtParamfluxoe().hashCode();
        }
        if (getDwFtParamByIdFtParamtensao() != null) {
            _hashCode += getDwFtParamByIdFtParamtensao().hashCode();
        }
        if (getDwPeproByIdPeproctreproc() != null) {
            _hashCode += getDwPeproByIdPeproctreproc().hashCode();
        }
        if (getDwPeproByIdPepronormal() != null) {
            _hashCode += getDwPeproByIdPepronormal().hashCode();
        }
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getDwTParada() != null) {
            _hashCode += getDwTParada().hashCode();
        }
        _hashCode += new Long(getIdCfg()).hashCode();
        if (getIsCompensaapont() != null) {
            _hashCode += getIsCompensaapont().hashCode();
        }
        if (getIsLogonobrigatorio() != null) {
            _hashCode += getIsLogonobrigatorio().hashCode();
        }
        if (getIsNivelfeeder() != null) {
            _hashCode += getIsNivelfeeder().hashCode();
        }
        if (getIsProcessaiacidw() != null) {
            _hashCode += getIsProcessaiacidw().hashCode();
        }
        if (getIsProcessaiacinsert() != null) {
            _hashCode += getIsProcessaiacinsert().hashCode();
        }
        if (getMascaraQtd() != null) {
            _hashCode += getMascaraQtd().hashCode();
        }
        if (getMascaracb() != null) {
            _hashCode += getMascaracb().hashCode();
        }
        if (getMascaracdcomponenteiac() != null) {
            _hashCode += getMascaracdcomponenteiac().hashCode();
        }
        if (getMascaracdprodutofilho() != null) {
            _hashCode += getMascaracdprodutofilho().hashCode();
        }
        if (getMascaracdprodutoiac() != null) {
            _hashCode += getMascaracdprodutoiac().hashCode();
        }
        if (getMascaracdprodutopai() != null) {
            _hashCode += getMascaracdprodutopai().hashCode();
        }
        if (getMascaracdprogramaiac() != null) {
            _hashCode += getMascaracdprogramaiac().hashCode();
        }
        if (getOmAlgocor() != null) {
            _hashCode += getOmAlgocor().hashCode();
        }
        if (getOmCcdefault() != null) {
            _hashCode += getOmCcdefault().hashCode();
        }
        if (getOmCfginds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfginds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfginds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgptdetcoletas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgptdetcoletas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgptdetcoletas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgscrpimps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgscrpimps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgscrpimps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgurls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgurls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgurls(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmEmpresa() != null) {
            _hashCode += getOmEmpresa().hashCode();
        }
        if (getOmGtimpcic() != null) {
            _hashCode += getOmGtimpcic().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmResgui() != null) {
            _hashCode += getOmResgui().hashCode();
        }
        if (getOmTpgtByIdTpgtfabrica() != null) {
            _hashCode += getOmTpgtByIdTpgtfabrica().hashCode();
        }
        if (getOmTpgtByIdTpgtlogsuper() != null) {
            _hashCode += getOmTpgtByIdTpgtlogsuper().hashCode();
        }
        if (getOmTpptByIdTpptinsersora() != null) {
            _hashCode += getOmTpptByIdTpptinsersora().hashCode();
        }
        if (getOmTpptByIdTpptpm() != null) {
            _hashCode += getOmTpptByIdTpptpm().hashCode();
        }
        if (getOmTpptByIdTpptppass() != null) {
            _hashCode += getOmTpptByIdTpptppass().hashCode();
        }
        if (getOmTpptByIdTpptprepro() != null) {
            _hashCode += getOmTpptByIdTpptprepro().hashCode();
        }
        if (getOmTpptByIdTpptptf() != null) {
            _hashCode += getOmTpptByIdTpptptf().hashCode();
        }
        if (getOmTpptByIdTpptpts() != null) {
            _hashCode += getOmTpptByIdTpptpts().hashCode();
        }
        if (getOmTpptByIdTpptptscd() != null) {
            _hashCode += getOmTpptByIdTpptptscd().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getOmUsrgrpByIdUsrgrpoperador() != null) {
            _hashCode += getOmUsrgrpByIdUsrgrpoperador().hashCode();
        }
        if (getOmUsrgrpByIdUsrgrpsupervisor() != null) {
            _hashCode += getOmUsrgrpByIdUsrgrpsupervisor().hashCode();
        }
        if (getOmUsrimpprog() != null) {
            _hashCode += getOmUsrimpprog().hashCode();
        }
        if (getQtMaxetapateste() != null) {
            _hashCode += getQtMaxetapateste().hashCode();
        }
        if (getQtMaxptcoletafull() != null) {
            _hashCode += getQtMaxptcoletafull().hashCode();
        }
        if (getQtMaxsubetapas() != null) {
            _hashCode += getQtMaxsubetapas().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSegAutologout() != null) {
            _hashCode += getSegAutologout().hashCode();
        }
        if (getSegFeedbacklogin() != null) {
            _hashCode += getSegFeedbacklogin().hashCode();
        }
        if (getSegHeartbeat() != null) {
            _hashCode += getSegHeartbeat().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpLayoutplano() != null) {
            _hashCode += getTpLayoutplano().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmCfg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMensagemsobretensao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMensagemsobretensao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMensagemsubtensao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMensagemsubtensao"));
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
        elemField.setFieldName("dthrEstliberado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrEstliberado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstByIdEstexpedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstByIdEstexpedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstByIdEstliberado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstByIdEstliberado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstByIdEstmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstByIdEstmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstByIdEstproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstByIdEstproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstByIdEstrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstByIdEstrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParamByIdFtParamcorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParamByIdFtParamcorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParamByIdFtParamflusos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParamByIdFtParamflusos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParamByIdFtParamfluxoe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParamByIdFtParamfluxoe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParamByIdFtParamtensao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParamByIdFtParamtensao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPeproByIdPeproctreproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPeproByIdPeproctreproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPepro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPeproByIdPepronormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPeproByIdPepronormal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPepro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCompensaapont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCompensaapont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLogonobrigatorio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isLogonobrigatorio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isNivelfeeder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isNivelfeeder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isProcessaiacidw");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isProcessaiacidw"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isProcessaiacinsert");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isProcessaiacinsert"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaraQtd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaraQtd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaracb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaracb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaracdcomponenteiac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaracdcomponenteiac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaracdprodutofilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaracdprodutofilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaracdprodutoiac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaracdprodutoiac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaracdprodutopai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaracdprodutopai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaracdprogramaiac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaracdprogramaiac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlgocor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlgocor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlgocor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCcdefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCcdefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfginds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfginds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgind"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgptdetcoletas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgptdetcoletas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgptdetcoleta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgscrpimps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgscrpimps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgscrpimp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgurls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgurls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgurl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omEmpresa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGtimpcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGtimpcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omResgui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omResgui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omResgui"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpgtByIdTpgtfabrica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpgtByIdTpgtfabrica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTpgt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpgtByIdTpgtlogsuper");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpgtByIdTpgtlogsuper"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTpgt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptByIdTpptinsersora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptByIdTpptinsersora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptByIdTpptpm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptByIdTpptpm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptByIdTpptppass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptByIdTpptppass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptByIdTpptprepro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptByIdTpptprepro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptByIdTpptptf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptByIdTpptptf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptByIdTpptpts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptByIdTpptpts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptByIdTpptptscd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptByIdTpptptscd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
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
        elemField.setFieldName("omUsrgrpByIdUsrgrpoperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrgrpByIdUsrgrpoperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsrgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrgrpByIdUsrgrpsupervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrgrpByIdUsrgrpsupervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsrgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrimpprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrimpprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMaxetapateste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMaxetapateste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMaxptcoletafull");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMaxptcoletafull"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMaxsubetapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMaxsubetapas"));
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
        elemField.setFieldName("segAutologout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutologout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segFeedbacklogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segFeedbacklogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segHeartbeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segHeartbeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("tpLayoutplano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpLayoutplano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
