/**
 * OmUsr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmUsr  extends idw.idwws.OmUsrTemplate  implements java.io.Serializable {
    private java.lang.String cdUsr;

    private java.lang.String dsApelido;

    private java.lang.String dsNome;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwCal[] dwCalsForIdUsrrevisao;

    private idw.idwws.DwCal[] dwCalsForIdUsrstativo;

    private idw.idwws.DwConsollog[] dwConsollogs;

    private idw.idwws.DwConsolmolog[] dwConsolmologs;

    private idw.idwws.DwConsolmo[] dwConsolmos;

    private idw.idwws.DwConsolpalogtec[] dwConsolpalogtecs;

    private idw.idwws.DwEstlocal[] dwEstlocalsForIdUsrrevisao;

    private idw.idwws.DwEstlocal[] dwEstlocalsForIdUsrstativo;

    private idw.idwws.DwEst[] dwEstsForIdUsrrevisao;

    private idw.idwws.DwEst[] dwEstsForIdUsrstativo;

    private idw.idwws.DwFolha[] dwFolhasForIdUsrrevisao;

    private idw.idwws.DwFolha[] dwFolhasForIdUsrstativo;

    private idw.idwws.DwFtEtapa[] dwFtEtapasForIdUsrrevisao;

    private idw.idwws.DwFtEtapa[] dwFtEtapasForIdUsrstativo;

    private idw.idwws.DwPassagem[] dwPassagemsForIdUsroperador;

    private idw.idwws.DwPassagem[] dwPassagemsForIdUsrsupervisor;

    private idw.idwws.DwRota[] dwRotaForIdUsrrevisao;

    private idw.idwws.DwRota[] dwRotaForIdUsrstativo;

    private idw.idwws.DwTAcao[] dwTAcaosForIdUsrrevisao;

    private idw.idwws.DwTAcao[] dwTAcaosForIdUsrstativo;

    private idw.idwws.DwTAlerta[] dwTAlertasForIdUsrrevisao;

    private idw.idwws.DwTAlerta[] dwTAlertasForIdUsrstativo;

    private idw.idwws.DwTDefeito[] dwTDefeitosForIdUsrrevisao;

    private idw.idwws.DwTDefeito[] dwTDefeitosForIdUsrstativo;

    private idw.idwws.DwTParada[] dwTParadasForIdUsrrevisao;

    private idw.idwws.DwTParada[] dwTParadasForIdUsrstativo;

    private idw.idwws.DwTRefugo[] dwTRefugosForIdUsrrevisao;

    private idw.idwws.DwTRefugo[] dwTRefugosForIdUsrstativo;

    private idw.idwws.DwTurno[] dwTurnosForIdUsrrevisao;

    private idw.idwws.DwTurno[] dwTurnosForIdUsrstativo;

    private long idUsr;

    private java.lang.String login;

    private idw.idwws.OmAlimrea[] omAlimreas;

    private idw.idwws.OmAlim[] omAlims;

    private idw.idwws.OmCargo omCargo;

    private idw.idwws.OmCc omCc;

    private idw.idwws.OmCc[] omCcsForIdUsrrevisao;

    private idw.idwws.OmCc[] omCcsForIdUsrstativo;

    private idw.idwws.OmCfg[] omCfgs;

    private idw.idwws.OmClp[] omClpsForIdUsrrevisao;

    private idw.idwws.OmClp[] omClpsForIdUsrstativo;

    private idw.idwws.OmFor[] omForsForIdUsrrevisao;

    private idw.idwws.OmFor[] omForsForIdUsrstativo;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmGt[] omGtsForIdUsrrevisao;

    private idw.idwws.OmGt[] omGtsForIdUsrstativo;

    private idw.idwws.OmHomogt[] omHomogtsForIdUsr;

    private idw.idwws.OmHomogt[] omHomogtsForIdUsrhomologado;

    private idw.idwws.OmHomopt[] omHomoptsForIdUsr;

    private idw.idwws.OmHomopt[] omHomoptsForIdUsrhomologado;

    private idw.idwws.OmImg[] omImgsForIdUsrrevisao;

    private idw.idwws.OmImg[] omImgsForIdUsrstativo;

    private idw.idwws.OmIm[] omImsForIdUsrsrc;

    private idw.idwws.OmIm[] omImsForIdUsrtrg;

    private idw.idwws.OmMapa[] omMapasForIdUsrrevisao;

    private idw.idwws.OmMapa[] omMapasForIdUsrstativo;

    private idw.idwws.OmPa[] omPasForIdUsrrevisao;

    private idw.idwws.OmPa[] omPasForIdUsrstativo;

    private idw.idwws.OmProduto[] omProdutosForIdUsrrevisao;

    private idw.idwws.OmProduto[] omProdutosForIdUsrstativo;

    private idw.idwws.OmProgrp[] omProgrpsForIdUsrrevisao;

    private idw.idwws.OmProgrp[] omProgrpsForIdUsrstativo;

    private idw.idwws.OmPt[] omPtsForIdUsrrevisao;

    private idw.idwws.OmPt[] omPtsForIdUsrstativo;

    private idw.idwws.OmTpgt[] omTpgtsForIdUsrrevisao;

    private idw.idwws.OmTpgt[] omTpgtsForIdUsrstativo;

    private idw.idwws.OmTppt[] omTpptsForIdUsrrevisao;

    private idw.idwws.OmTppt[] omTpptsForIdUsrstativo;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.OmUsrgrp omUsrgrp;

    private idw.idwws.OmUsr[] omUsrsForIdUsrrevisao;

    private idw.idwws.OmUsr[] omUsrsForIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.String senha;

    private java.lang.Byte stAtivo;

    private java.lang.String urlEmail;

    private java.lang.String urlSms;

    public OmUsr() {
    }

    public OmUsr(
           java.lang.Long id,
           java.lang.String cdUsr,
           java.lang.String dsApelido,
           java.lang.String dsNome,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwCal[] dwCalsForIdUsrrevisao,
           idw.idwws.DwCal[] dwCalsForIdUsrstativo,
           idw.idwws.DwConsollog[] dwConsollogs,
           idw.idwws.DwConsolmolog[] dwConsolmologs,
           idw.idwws.DwConsolmo[] dwConsolmos,
           idw.idwws.DwConsolpalogtec[] dwConsolpalogtecs,
           idw.idwws.DwEstlocal[] dwEstlocalsForIdUsrrevisao,
           idw.idwws.DwEstlocal[] dwEstlocalsForIdUsrstativo,
           idw.idwws.DwEst[] dwEstsForIdUsrrevisao,
           idw.idwws.DwEst[] dwEstsForIdUsrstativo,
           idw.idwws.DwFolha[] dwFolhasForIdUsrrevisao,
           idw.idwws.DwFolha[] dwFolhasForIdUsrstativo,
           idw.idwws.DwFtEtapa[] dwFtEtapasForIdUsrrevisao,
           idw.idwws.DwFtEtapa[] dwFtEtapasForIdUsrstativo,
           idw.idwws.DwPassagem[] dwPassagemsForIdUsroperador,
           idw.idwws.DwPassagem[] dwPassagemsForIdUsrsupervisor,
           idw.idwws.DwRota[] dwRotaForIdUsrrevisao,
           idw.idwws.DwRota[] dwRotaForIdUsrstativo,
           idw.idwws.DwTAcao[] dwTAcaosForIdUsrrevisao,
           idw.idwws.DwTAcao[] dwTAcaosForIdUsrstativo,
           idw.idwws.DwTAlerta[] dwTAlertasForIdUsrrevisao,
           idw.idwws.DwTAlerta[] dwTAlertasForIdUsrstativo,
           idw.idwws.DwTDefeito[] dwTDefeitosForIdUsrrevisao,
           idw.idwws.DwTDefeito[] dwTDefeitosForIdUsrstativo,
           idw.idwws.DwTParada[] dwTParadasForIdUsrrevisao,
           idw.idwws.DwTParada[] dwTParadasForIdUsrstativo,
           idw.idwws.DwTRefugo[] dwTRefugosForIdUsrrevisao,
           idw.idwws.DwTRefugo[] dwTRefugosForIdUsrstativo,
           idw.idwws.DwTurno[] dwTurnosForIdUsrrevisao,
           idw.idwws.DwTurno[] dwTurnosForIdUsrstativo,
           long idUsr,
           java.lang.String login,
           idw.idwws.OmAlimrea[] omAlimreas,
           idw.idwws.OmAlim[] omAlims,
           idw.idwws.OmCargo omCargo,
           idw.idwws.OmCc omCc,
           idw.idwws.OmCc[] omCcsForIdUsrrevisao,
           idw.idwws.OmCc[] omCcsForIdUsrstativo,
           idw.idwws.OmCfg[] omCfgs,
           idw.idwws.OmClp[] omClpsForIdUsrrevisao,
           idw.idwws.OmClp[] omClpsForIdUsrstativo,
           idw.idwws.OmFor[] omForsForIdUsrrevisao,
           idw.idwws.OmFor[] omForsForIdUsrstativo,
           idw.idwws.OmGt omGt,
           idw.idwws.OmGt[] omGtsForIdUsrrevisao,
           idw.idwws.OmGt[] omGtsForIdUsrstativo,
           idw.idwws.OmHomogt[] omHomogtsForIdUsr,
           idw.idwws.OmHomogt[] omHomogtsForIdUsrhomologado,
           idw.idwws.OmHomopt[] omHomoptsForIdUsr,
           idw.idwws.OmHomopt[] omHomoptsForIdUsrhomologado,
           idw.idwws.OmImg[] omImgsForIdUsrrevisao,
           idw.idwws.OmImg[] omImgsForIdUsrstativo,
           idw.idwws.OmIm[] omImsForIdUsrsrc,
           idw.idwws.OmIm[] omImsForIdUsrtrg,
           idw.idwws.OmMapa[] omMapasForIdUsrrevisao,
           idw.idwws.OmMapa[] omMapasForIdUsrstativo,
           idw.idwws.OmPa[] omPasForIdUsrrevisao,
           idw.idwws.OmPa[] omPasForIdUsrstativo,
           idw.idwws.OmProduto[] omProdutosForIdUsrrevisao,
           idw.idwws.OmProduto[] omProdutosForIdUsrstativo,
           idw.idwws.OmProgrp[] omProgrpsForIdUsrrevisao,
           idw.idwws.OmProgrp[] omProgrpsForIdUsrstativo,
           idw.idwws.OmPt[] omPtsForIdUsrrevisao,
           idw.idwws.OmPt[] omPtsForIdUsrstativo,
           idw.idwws.OmTpgt[] omTpgtsForIdUsrrevisao,
           idw.idwws.OmTpgt[] omTpgtsForIdUsrstativo,
           idw.idwws.OmTppt[] omTpptsForIdUsrrevisao,
           idw.idwws.OmTppt[] omTpptsForIdUsrstativo,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.OmUsrgrp omUsrgrp,
           idw.idwws.OmUsr[] omUsrsForIdUsrrevisao,
           idw.idwws.OmUsr[] omUsrsForIdUsrstativo,
           java.lang.Long revisao,
           java.lang.String senha,
           java.lang.Byte stAtivo,
           java.lang.String urlEmail,
           java.lang.String urlSms) {
        super(
            id);
        this.cdUsr = cdUsr;
        this.dsApelido = dsApelido;
        this.dsNome = dsNome;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwCalsForIdUsrrevisao = dwCalsForIdUsrrevisao;
        this.dwCalsForIdUsrstativo = dwCalsForIdUsrstativo;
        this.dwConsollogs = dwConsollogs;
        this.dwConsolmologs = dwConsolmologs;
        this.dwConsolmos = dwConsolmos;
        this.dwConsolpalogtecs = dwConsolpalogtecs;
        this.dwEstlocalsForIdUsrrevisao = dwEstlocalsForIdUsrrevisao;
        this.dwEstlocalsForIdUsrstativo = dwEstlocalsForIdUsrstativo;
        this.dwEstsForIdUsrrevisao = dwEstsForIdUsrrevisao;
        this.dwEstsForIdUsrstativo = dwEstsForIdUsrstativo;
        this.dwFolhasForIdUsrrevisao = dwFolhasForIdUsrrevisao;
        this.dwFolhasForIdUsrstativo = dwFolhasForIdUsrstativo;
        this.dwFtEtapasForIdUsrrevisao = dwFtEtapasForIdUsrrevisao;
        this.dwFtEtapasForIdUsrstativo = dwFtEtapasForIdUsrstativo;
        this.dwPassagemsForIdUsroperador = dwPassagemsForIdUsroperador;
        this.dwPassagemsForIdUsrsupervisor = dwPassagemsForIdUsrsupervisor;
        this.dwRotaForIdUsrrevisao = dwRotaForIdUsrrevisao;
        this.dwRotaForIdUsrstativo = dwRotaForIdUsrstativo;
        this.dwTAcaosForIdUsrrevisao = dwTAcaosForIdUsrrevisao;
        this.dwTAcaosForIdUsrstativo = dwTAcaosForIdUsrstativo;
        this.dwTAlertasForIdUsrrevisao = dwTAlertasForIdUsrrevisao;
        this.dwTAlertasForIdUsrstativo = dwTAlertasForIdUsrstativo;
        this.dwTDefeitosForIdUsrrevisao = dwTDefeitosForIdUsrrevisao;
        this.dwTDefeitosForIdUsrstativo = dwTDefeitosForIdUsrstativo;
        this.dwTParadasForIdUsrrevisao = dwTParadasForIdUsrrevisao;
        this.dwTParadasForIdUsrstativo = dwTParadasForIdUsrstativo;
        this.dwTRefugosForIdUsrrevisao = dwTRefugosForIdUsrrevisao;
        this.dwTRefugosForIdUsrstativo = dwTRefugosForIdUsrstativo;
        this.dwTurnosForIdUsrrevisao = dwTurnosForIdUsrrevisao;
        this.dwTurnosForIdUsrstativo = dwTurnosForIdUsrstativo;
        this.idUsr = idUsr;
        this.login = login;
        this.omAlimreas = omAlimreas;
        this.omAlims = omAlims;
        this.omCargo = omCargo;
        this.omCc = omCc;
        this.omCcsForIdUsrrevisao = omCcsForIdUsrrevisao;
        this.omCcsForIdUsrstativo = omCcsForIdUsrstativo;
        this.omCfgs = omCfgs;
        this.omClpsForIdUsrrevisao = omClpsForIdUsrrevisao;
        this.omClpsForIdUsrstativo = omClpsForIdUsrstativo;
        this.omForsForIdUsrrevisao = omForsForIdUsrrevisao;
        this.omForsForIdUsrstativo = omForsForIdUsrstativo;
        this.omGt = omGt;
        this.omGtsForIdUsrrevisao = omGtsForIdUsrrevisao;
        this.omGtsForIdUsrstativo = omGtsForIdUsrstativo;
        this.omHomogtsForIdUsr = omHomogtsForIdUsr;
        this.omHomogtsForIdUsrhomologado = omHomogtsForIdUsrhomologado;
        this.omHomoptsForIdUsr = omHomoptsForIdUsr;
        this.omHomoptsForIdUsrhomologado = omHomoptsForIdUsrhomologado;
        this.omImgsForIdUsrrevisao = omImgsForIdUsrrevisao;
        this.omImgsForIdUsrstativo = omImgsForIdUsrstativo;
        this.omImsForIdUsrsrc = omImsForIdUsrsrc;
        this.omImsForIdUsrtrg = omImsForIdUsrtrg;
        this.omMapasForIdUsrrevisao = omMapasForIdUsrrevisao;
        this.omMapasForIdUsrstativo = omMapasForIdUsrstativo;
        this.omPasForIdUsrrevisao = omPasForIdUsrrevisao;
        this.omPasForIdUsrstativo = omPasForIdUsrstativo;
        this.omProdutosForIdUsrrevisao = omProdutosForIdUsrrevisao;
        this.omProdutosForIdUsrstativo = omProdutosForIdUsrstativo;
        this.omProgrpsForIdUsrrevisao = omProgrpsForIdUsrrevisao;
        this.omProgrpsForIdUsrstativo = omProgrpsForIdUsrstativo;
        this.omPtsForIdUsrrevisao = omPtsForIdUsrrevisao;
        this.omPtsForIdUsrstativo = omPtsForIdUsrstativo;
        this.omTpgtsForIdUsrrevisao = omTpgtsForIdUsrrevisao;
        this.omTpgtsForIdUsrstativo = omTpgtsForIdUsrstativo;
        this.omTpptsForIdUsrrevisao = omTpptsForIdUsrrevisao;
        this.omTpptsForIdUsrstativo = omTpptsForIdUsrstativo;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.omUsrgrp = omUsrgrp;
        this.omUsrsForIdUsrrevisao = omUsrsForIdUsrrevisao;
        this.omUsrsForIdUsrstativo = omUsrsForIdUsrstativo;
        this.revisao = revisao;
        this.senha = senha;
        this.stAtivo = stAtivo;
        this.urlEmail = urlEmail;
        this.urlSms = urlSms;
    }


    /**
     * Gets the cdUsr value for this OmUsr.
     * 
     * @return cdUsr
     */
    public java.lang.String getCdUsr() {
        return cdUsr;
    }


    /**
     * Sets the cdUsr value for this OmUsr.
     * 
     * @param cdUsr
     */
    public void setCdUsr(java.lang.String cdUsr) {
        this.cdUsr = cdUsr;
    }


    /**
     * Gets the dsApelido value for this OmUsr.
     * 
     * @return dsApelido
     */
    public java.lang.String getDsApelido() {
        return dsApelido;
    }


    /**
     * Sets the dsApelido value for this OmUsr.
     * 
     * @param dsApelido
     */
    public void setDsApelido(java.lang.String dsApelido) {
        this.dsApelido = dsApelido;
    }


    /**
     * Gets the dsNome value for this OmUsr.
     * 
     * @return dsNome
     */
    public java.lang.String getDsNome() {
        return dsNome;
    }


    /**
     * Sets the dsNome value for this OmUsr.
     * 
     * @param dsNome
     */
    public void setDsNome(java.lang.String dsNome) {
        this.dsNome = dsNome;
    }


    /**
     * Gets the dtRevisao value for this OmUsr.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmUsr.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmUsr.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmUsr.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwCalsForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwCalsForIdUsrrevisao
     */
    public idw.idwws.DwCal[] getDwCalsForIdUsrrevisao() {
        return dwCalsForIdUsrrevisao;
    }


    /**
     * Sets the dwCalsForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwCalsForIdUsrrevisao
     */
    public void setDwCalsForIdUsrrevisao(idw.idwws.DwCal[] dwCalsForIdUsrrevisao) {
        this.dwCalsForIdUsrrevisao = dwCalsForIdUsrrevisao;
    }

    public idw.idwws.DwCal getDwCalsForIdUsrrevisao(int i) {
        return this.dwCalsForIdUsrrevisao[i];
    }

    public void setDwCalsForIdUsrrevisao(int i, idw.idwws.DwCal _value) {
        this.dwCalsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwCalsForIdUsrstativo value for this OmUsr.
     * 
     * @return dwCalsForIdUsrstativo
     */
    public idw.idwws.DwCal[] getDwCalsForIdUsrstativo() {
        return dwCalsForIdUsrstativo;
    }


    /**
     * Sets the dwCalsForIdUsrstativo value for this OmUsr.
     * 
     * @param dwCalsForIdUsrstativo
     */
    public void setDwCalsForIdUsrstativo(idw.idwws.DwCal[] dwCalsForIdUsrstativo) {
        this.dwCalsForIdUsrstativo = dwCalsForIdUsrstativo;
    }

    public idw.idwws.DwCal getDwCalsForIdUsrstativo(int i) {
        return this.dwCalsForIdUsrstativo[i];
    }

    public void setDwCalsForIdUsrstativo(int i, idw.idwws.DwCal _value) {
        this.dwCalsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwConsollogs value for this OmUsr.
     * 
     * @return dwConsollogs
     */
    public idw.idwws.DwConsollog[] getDwConsollogs() {
        return dwConsollogs;
    }


    /**
     * Sets the dwConsollogs value for this OmUsr.
     * 
     * @param dwConsollogs
     */
    public void setDwConsollogs(idw.idwws.DwConsollog[] dwConsollogs) {
        this.dwConsollogs = dwConsollogs;
    }

    public idw.idwws.DwConsollog getDwConsollogs(int i) {
        return this.dwConsollogs[i];
    }

    public void setDwConsollogs(int i, idw.idwws.DwConsollog _value) {
        this.dwConsollogs[i] = _value;
    }


    /**
     * Gets the dwConsolmologs value for this OmUsr.
     * 
     * @return dwConsolmologs
     */
    public idw.idwws.DwConsolmolog[] getDwConsolmologs() {
        return dwConsolmologs;
    }


    /**
     * Sets the dwConsolmologs value for this OmUsr.
     * 
     * @param dwConsolmologs
     */
    public void setDwConsolmologs(idw.idwws.DwConsolmolog[] dwConsolmologs) {
        this.dwConsolmologs = dwConsolmologs;
    }

    public idw.idwws.DwConsolmolog getDwConsolmologs(int i) {
        return this.dwConsolmologs[i];
    }

    public void setDwConsolmologs(int i, idw.idwws.DwConsolmolog _value) {
        this.dwConsolmologs[i] = _value;
    }


    /**
     * Gets the dwConsolmos value for this OmUsr.
     * 
     * @return dwConsolmos
     */
    public idw.idwws.DwConsolmo[] getDwConsolmos() {
        return dwConsolmos;
    }


    /**
     * Sets the dwConsolmos value for this OmUsr.
     * 
     * @param dwConsolmos
     */
    public void setDwConsolmos(idw.idwws.DwConsolmo[] dwConsolmos) {
        this.dwConsolmos = dwConsolmos;
    }

    public idw.idwws.DwConsolmo getDwConsolmos(int i) {
        return this.dwConsolmos[i];
    }

    public void setDwConsolmos(int i, idw.idwws.DwConsolmo _value) {
        this.dwConsolmos[i] = _value;
    }


    /**
     * Gets the dwConsolpalogtecs value for this OmUsr.
     * 
     * @return dwConsolpalogtecs
     */
    public idw.idwws.DwConsolpalogtec[] getDwConsolpalogtecs() {
        return dwConsolpalogtecs;
    }


    /**
     * Sets the dwConsolpalogtecs value for this OmUsr.
     * 
     * @param dwConsolpalogtecs
     */
    public void setDwConsolpalogtecs(idw.idwws.DwConsolpalogtec[] dwConsolpalogtecs) {
        this.dwConsolpalogtecs = dwConsolpalogtecs;
    }

    public idw.idwws.DwConsolpalogtec getDwConsolpalogtecs(int i) {
        return this.dwConsolpalogtecs[i];
    }

    public void setDwConsolpalogtecs(int i, idw.idwws.DwConsolpalogtec _value) {
        this.dwConsolpalogtecs[i] = _value;
    }


    /**
     * Gets the dwEstlocalsForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwEstlocalsForIdUsrrevisao
     */
    public idw.idwws.DwEstlocal[] getDwEstlocalsForIdUsrrevisao() {
        return dwEstlocalsForIdUsrrevisao;
    }


    /**
     * Sets the dwEstlocalsForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwEstlocalsForIdUsrrevisao
     */
    public void setDwEstlocalsForIdUsrrevisao(idw.idwws.DwEstlocal[] dwEstlocalsForIdUsrrevisao) {
        this.dwEstlocalsForIdUsrrevisao = dwEstlocalsForIdUsrrevisao;
    }

    public idw.idwws.DwEstlocal getDwEstlocalsForIdUsrrevisao(int i) {
        return this.dwEstlocalsForIdUsrrevisao[i];
    }

    public void setDwEstlocalsForIdUsrrevisao(int i, idw.idwws.DwEstlocal _value) {
        this.dwEstlocalsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwEstlocalsForIdUsrstativo value for this OmUsr.
     * 
     * @return dwEstlocalsForIdUsrstativo
     */
    public idw.idwws.DwEstlocal[] getDwEstlocalsForIdUsrstativo() {
        return dwEstlocalsForIdUsrstativo;
    }


    /**
     * Sets the dwEstlocalsForIdUsrstativo value for this OmUsr.
     * 
     * @param dwEstlocalsForIdUsrstativo
     */
    public void setDwEstlocalsForIdUsrstativo(idw.idwws.DwEstlocal[] dwEstlocalsForIdUsrstativo) {
        this.dwEstlocalsForIdUsrstativo = dwEstlocalsForIdUsrstativo;
    }

    public idw.idwws.DwEstlocal getDwEstlocalsForIdUsrstativo(int i) {
        return this.dwEstlocalsForIdUsrstativo[i];
    }

    public void setDwEstlocalsForIdUsrstativo(int i, idw.idwws.DwEstlocal _value) {
        this.dwEstlocalsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwEstsForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwEstsForIdUsrrevisao
     */
    public idw.idwws.DwEst[] getDwEstsForIdUsrrevisao() {
        return dwEstsForIdUsrrevisao;
    }


    /**
     * Sets the dwEstsForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwEstsForIdUsrrevisao
     */
    public void setDwEstsForIdUsrrevisao(idw.idwws.DwEst[] dwEstsForIdUsrrevisao) {
        this.dwEstsForIdUsrrevisao = dwEstsForIdUsrrevisao;
    }

    public idw.idwws.DwEst getDwEstsForIdUsrrevisao(int i) {
        return this.dwEstsForIdUsrrevisao[i];
    }

    public void setDwEstsForIdUsrrevisao(int i, idw.idwws.DwEst _value) {
        this.dwEstsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwEstsForIdUsrstativo value for this OmUsr.
     * 
     * @return dwEstsForIdUsrstativo
     */
    public idw.idwws.DwEst[] getDwEstsForIdUsrstativo() {
        return dwEstsForIdUsrstativo;
    }


    /**
     * Sets the dwEstsForIdUsrstativo value for this OmUsr.
     * 
     * @param dwEstsForIdUsrstativo
     */
    public void setDwEstsForIdUsrstativo(idw.idwws.DwEst[] dwEstsForIdUsrstativo) {
        this.dwEstsForIdUsrstativo = dwEstsForIdUsrstativo;
    }

    public idw.idwws.DwEst getDwEstsForIdUsrstativo(int i) {
        return this.dwEstsForIdUsrstativo[i];
    }

    public void setDwEstsForIdUsrstativo(int i, idw.idwws.DwEst _value) {
        this.dwEstsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwFolhasForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwFolhasForIdUsrrevisao
     */
    public idw.idwws.DwFolha[] getDwFolhasForIdUsrrevisao() {
        return dwFolhasForIdUsrrevisao;
    }


    /**
     * Sets the dwFolhasForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwFolhasForIdUsrrevisao
     */
    public void setDwFolhasForIdUsrrevisao(idw.idwws.DwFolha[] dwFolhasForIdUsrrevisao) {
        this.dwFolhasForIdUsrrevisao = dwFolhasForIdUsrrevisao;
    }

    public idw.idwws.DwFolha getDwFolhasForIdUsrrevisao(int i) {
        return this.dwFolhasForIdUsrrevisao[i];
    }

    public void setDwFolhasForIdUsrrevisao(int i, idw.idwws.DwFolha _value) {
        this.dwFolhasForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwFolhasForIdUsrstativo value for this OmUsr.
     * 
     * @return dwFolhasForIdUsrstativo
     */
    public idw.idwws.DwFolha[] getDwFolhasForIdUsrstativo() {
        return dwFolhasForIdUsrstativo;
    }


    /**
     * Sets the dwFolhasForIdUsrstativo value for this OmUsr.
     * 
     * @param dwFolhasForIdUsrstativo
     */
    public void setDwFolhasForIdUsrstativo(idw.idwws.DwFolha[] dwFolhasForIdUsrstativo) {
        this.dwFolhasForIdUsrstativo = dwFolhasForIdUsrstativo;
    }

    public idw.idwws.DwFolha getDwFolhasForIdUsrstativo(int i) {
        return this.dwFolhasForIdUsrstativo[i];
    }

    public void setDwFolhasForIdUsrstativo(int i, idw.idwws.DwFolha _value) {
        this.dwFolhasForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwFtEtapasForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwFtEtapasForIdUsrrevisao
     */
    public idw.idwws.DwFtEtapa[] getDwFtEtapasForIdUsrrevisao() {
        return dwFtEtapasForIdUsrrevisao;
    }


    /**
     * Sets the dwFtEtapasForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwFtEtapasForIdUsrrevisao
     */
    public void setDwFtEtapasForIdUsrrevisao(idw.idwws.DwFtEtapa[] dwFtEtapasForIdUsrrevisao) {
        this.dwFtEtapasForIdUsrrevisao = dwFtEtapasForIdUsrrevisao;
    }

    public idw.idwws.DwFtEtapa getDwFtEtapasForIdUsrrevisao(int i) {
        return this.dwFtEtapasForIdUsrrevisao[i];
    }

    public void setDwFtEtapasForIdUsrrevisao(int i, idw.idwws.DwFtEtapa _value) {
        this.dwFtEtapasForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwFtEtapasForIdUsrstativo value for this OmUsr.
     * 
     * @return dwFtEtapasForIdUsrstativo
     */
    public idw.idwws.DwFtEtapa[] getDwFtEtapasForIdUsrstativo() {
        return dwFtEtapasForIdUsrstativo;
    }


    /**
     * Sets the dwFtEtapasForIdUsrstativo value for this OmUsr.
     * 
     * @param dwFtEtapasForIdUsrstativo
     */
    public void setDwFtEtapasForIdUsrstativo(idw.idwws.DwFtEtapa[] dwFtEtapasForIdUsrstativo) {
        this.dwFtEtapasForIdUsrstativo = dwFtEtapasForIdUsrstativo;
    }

    public idw.idwws.DwFtEtapa getDwFtEtapasForIdUsrstativo(int i) {
        return this.dwFtEtapasForIdUsrstativo[i];
    }

    public void setDwFtEtapasForIdUsrstativo(int i, idw.idwws.DwFtEtapa _value) {
        this.dwFtEtapasForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwPassagemsForIdUsroperador value for this OmUsr.
     * 
     * @return dwPassagemsForIdUsroperador
     */
    public idw.idwws.DwPassagem[] getDwPassagemsForIdUsroperador() {
        return dwPassagemsForIdUsroperador;
    }


    /**
     * Sets the dwPassagemsForIdUsroperador value for this OmUsr.
     * 
     * @param dwPassagemsForIdUsroperador
     */
    public void setDwPassagemsForIdUsroperador(idw.idwws.DwPassagem[] dwPassagemsForIdUsroperador) {
        this.dwPassagemsForIdUsroperador = dwPassagemsForIdUsroperador;
    }

    public idw.idwws.DwPassagem getDwPassagemsForIdUsroperador(int i) {
        return this.dwPassagemsForIdUsroperador[i];
    }

    public void setDwPassagemsForIdUsroperador(int i, idw.idwws.DwPassagem _value) {
        this.dwPassagemsForIdUsroperador[i] = _value;
    }


    /**
     * Gets the dwPassagemsForIdUsrsupervisor value for this OmUsr.
     * 
     * @return dwPassagemsForIdUsrsupervisor
     */
    public idw.idwws.DwPassagem[] getDwPassagemsForIdUsrsupervisor() {
        return dwPassagemsForIdUsrsupervisor;
    }


    /**
     * Sets the dwPassagemsForIdUsrsupervisor value for this OmUsr.
     * 
     * @param dwPassagemsForIdUsrsupervisor
     */
    public void setDwPassagemsForIdUsrsupervisor(idw.idwws.DwPassagem[] dwPassagemsForIdUsrsupervisor) {
        this.dwPassagemsForIdUsrsupervisor = dwPassagemsForIdUsrsupervisor;
    }

    public idw.idwws.DwPassagem getDwPassagemsForIdUsrsupervisor(int i) {
        return this.dwPassagemsForIdUsrsupervisor[i];
    }

    public void setDwPassagemsForIdUsrsupervisor(int i, idw.idwws.DwPassagem _value) {
        this.dwPassagemsForIdUsrsupervisor[i] = _value;
    }


    /**
     * Gets the dwRotaForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwRotaForIdUsrrevisao
     */
    public idw.idwws.DwRota[] getDwRotaForIdUsrrevisao() {
        return dwRotaForIdUsrrevisao;
    }


    /**
     * Sets the dwRotaForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwRotaForIdUsrrevisao
     */
    public void setDwRotaForIdUsrrevisao(idw.idwws.DwRota[] dwRotaForIdUsrrevisao) {
        this.dwRotaForIdUsrrevisao = dwRotaForIdUsrrevisao;
    }

    public idw.idwws.DwRota getDwRotaForIdUsrrevisao(int i) {
        return this.dwRotaForIdUsrrevisao[i];
    }

    public void setDwRotaForIdUsrrevisao(int i, idw.idwws.DwRota _value) {
        this.dwRotaForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwRotaForIdUsrstativo value for this OmUsr.
     * 
     * @return dwRotaForIdUsrstativo
     */
    public idw.idwws.DwRota[] getDwRotaForIdUsrstativo() {
        return dwRotaForIdUsrstativo;
    }


    /**
     * Sets the dwRotaForIdUsrstativo value for this OmUsr.
     * 
     * @param dwRotaForIdUsrstativo
     */
    public void setDwRotaForIdUsrstativo(idw.idwws.DwRota[] dwRotaForIdUsrstativo) {
        this.dwRotaForIdUsrstativo = dwRotaForIdUsrstativo;
    }

    public idw.idwws.DwRota getDwRotaForIdUsrstativo(int i) {
        return this.dwRotaForIdUsrstativo[i];
    }

    public void setDwRotaForIdUsrstativo(int i, idw.idwws.DwRota _value) {
        this.dwRotaForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwTAcaosForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwTAcaosForIdUsrrevisao
     */
    public idw.idwws.DwTAcao[] getDwTAcaosForIdUsrrevisao() {
        return dwTAcaosForIdUsrrevisao;
    }


    /**
     * Sets the dwTAcaosForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwTAcaosForIdUsrrevisao
     */
    public void setDwTAcaosForIdUsrrevisao(idw.idwws.DwTAcao[] dwTAcaosForIdUsrrevisao) {
        this.dwTAcaosForIdUsrrevisao = dwTAcaosForIdUsrrevisao;
    }

    public idw.idwws.DwTAcao getDwTAcaosForIdUsrrevisao(int i) {
        return this.dwTAcaosForIdUsrrevisao[i];
    }

    public void setDwTAcaosForIdUsrrevisao(int i, idw.idwws.DwTAcao _value) {
        this.dwTAcaosForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwTAcaosForIdUsrstativo value for this OmUsr.
     * 
     * @return dwTAcaosForIdUsrstativo
     */
    public idw.idwws.DwTAcao[] getDwTAcaosForIdUsrstativo() {
        return dwTAcaosForIdUsrstativo;
    }


    /**
     * Sets the dwTAcaosForIdUsrstativo value for this OmUsr.
     * 
     * @param dwTAcaosForIdUsrstativo
     */
    public void setDwTAcaosForIdUsrstativo(idw.idwws.DwTAcao[] dwTAcaosForIdUsrstativo) {
        this.dwTAcaosForIdUsrstativo = dwTAcaosForIdUsrstativo;
    }

    public idw.idwws.DwTAcao getDwTAcaosForIdUsrstativo(int i) {
        return this.dwTAcaosForIdUsrstativo[i];
    }

    public void setDwTAcaosForIdUsrstativo(int i, idw.idwws.DwTAcao _value) {
        this.dwTAcaosForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwTAlertasForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwTAlertasForIdUsrrevisao
     */
    public idw.idwws.DwTAlerta[] getDwTAlertasForIdUsrrevisao() {
        return dwTAlertasForIdUsrrevisao;
    }


    /**
     * Sets the dwTAlertasForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwTAlertasForIdUsrrevisao
     */
    public void setDwTAlertasForIdUsrrevisao(idw.idwws.DwTAlerta[] dwTAlertasForIdUsrrevisao) {
        this.dwTAlertasForIdUsrrevisao = dwTAlertasForIdUsrrevisao;
    }

    public idw.idwws.DwTAlerta getDwTAlertasForIdUsrrevisao(int i) {
        return this.dwTAlertasForIdUsrrevisao[i];
    }

    public void setDwTAlertasForIdUsrrevisao(int i, idw.idwws.DwTAlerta _value) {
        this.dwTAlertasForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwTAlertasForIdUsrstativo value for this OmUsr.
     * 
     * @return dwTAlertasForIdUsrstativo
     */
    public idw.idwws.DwTAlerta[] getDwTAlertasForIdUsrstativo() {
        return dwTAlertasForIdUsrstativo;
    }


    /**
     * Sets the dwTAlertasForIdUsrstativo value for this OmUsr.
     * 
     * @param dwTAlertasForIdUsrstativo
     */
    public void setDwTAlertasForIdUsrstativo(idw.idwws.DwTAlerta[] dwTAlertasForIdUsrstativo) {
        this.dwTAlertasForIdUsrstativo = dwTAlertasForIdUsrstativo;
    }

    public idw.idwws.DwTAlerta getDwTAlertasForIdUsrstativo(int i) {
        return this.dwTAlertasForIdUsrstativo[i];
    }

    public void setDwTAlertasForIdUsrstativo(int i, idw.idwws.DwTAlerta _value) {
        this.dwTAlertasForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwTDefeitosForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwTDefeitosForIdUsrrevisao
     */
    public idw.idwws.DwTDefeito[] getDwTDefeitosForIdUsrrevisao() {
        return dwTDefeitosForIdUsrrevisao;
    }


    /**
     * Sets the dwTDefeitosForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwTDefeitosForIdUsrrevisao
     */
    public void setDwTDefeitosForIdUsrrevisao(idw.idwws.DwTDefeito[] dwTDefeitosForIdUsrrevisao) {
        this.dwTDefeitosForIdUsrrevisao = dwTDefeitosForIdUsrrevisao;
    }

    public idw.idwws.DwTDefeito getDwTDefeitosForIdUsrrevisao(int i) {
        return this.dwTDefeitosForIdUsrrevisao[i];
    }

    public void setDwTDefeitosForIdUsrrevisao(int i, idw.idwws.DwTDefeito _value) {
        this.dwTDefeitosForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwTDefeitosForIdUsrstativo value for this OmUsr.
     * 
     * @return dwTDefeitosForIdUsrstativo
     */
    public idw.idwws.DwTDefeito[] getDwTDefeitosForIdUsrstativo() {
        return dwTDefeitosForIdUsrstativo;
    }


    /**
     * Sets the dwTDefeitosForIdUsrstativo value for this OmUsr.
     * 
     * @param dwTDefeitosForIdUsrstativo
     */
    public void setDwTDefeitosForIdUsrstativo(idw.idwws.DwTDefeito[] dwTDefeitosForIdUsrstativo) {
        this.dwTDefeitosForIdUsrstativo = dwTDefeitosForIdUsrstativo;
    }

    public idw.idwws.DwTDefeito getDwTDefeitosForIdUsrstativo(int i) {
        return this.dwTDefeitosForIdUsrstativo[i];
    }

    public void setDwTDefeitosForIdUsrstativo(int i, idw.idwws.DwTDefeito _value) {
        this.dwTDefeitosForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwTParadasForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwTParadasForIdUsrrevisao
     */
    public idw.idwws.DwTParada[] getDwTParadasForIdUsrrevisao() {
        return dwTParadasForIdUsrrevisao;
    }


    /**
     * Sets the dwTParadasForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwTParadasForIdUsrrevisao
     */
    public void setDwTParadasForIdUsrrevisao(idw.idwws.DwTParada[] dwTParadasForIdUsrrevisao) {
        this.dwTParadasForIdUsrrevisao = dwTParadasForIdUsrrevisao;
    }

    public idw.idwws.DwTParada getDwTParadasForIdUsrrevisao(int i) {
        return this.dwTParadasForIdUsrrevisao[i];
    }

    public void setDwTParadasForIdUsrrevisao(int i, idw.idwws.DwTParada _value) {
        this.dwTParadasForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwTParadasForIdUsrstativo value for this OmUsr.
     * 
     * @return dwTParadasForIdUsrstativo
     */
    public idw.idwws.DwTParada[] getDwTParadasForIdUsrstativo() {
        return dwTParadasForIdUsrstativo;
    }


    /**
     * Sets the dwTParadasForIdUsrstativo value for this OmUsr.
     * 
     * @param dwTParadasForIdUsrstativo
     */
    public void setDwTParadasForIdUsrstativo(idw.idwws.DwTParada[] dwTParadasForIdUsrstativo) {
        this.dwTParadasForIdUsrstativo = dwTParadasForIdUsrstativo;
    }

    public idw.idwws.DwTParada getDwTParadasForIdUsrstativo(int i) {
        return this.dwTParadasForIdUsrstativo[i];
    }

    public void setDwTParadasForIdUsrstativo(int i, idw.idwws.DwTParada _value) {
        this.dwTParadasForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwTRefugosForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwTRefugosForIdUsrrevisao
     */
    public idw.idwws.DwTRefugo[] getDwTRefugosForIdUsrrevisao() {
        return dwTRefugosForIdUsrrevisao;
    }


    /**
     * Sets the dwTRefugosForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwTRefugosForIdUsrrevisao
     */
    public void setDwTRefugosForIdUsrrevisao(idw.idwws.DwTRefugo[] dwTRefugosForIdUsrrevisao) {
        this.dwTRefugosForIdUsrrevisao = dwTRefugosForIdUsrrevisao;
    }

    public idw.idwws.DwTRefugo getDwTRefugosForIdUsrrevisao(int i) {
        return this.dwTRefugosForIdUsrrevisao[i];
    }

    public void setDwTRefugosForIdUsrrevisao(int i, idw.idwws.DwTRefugo _value) {
        this.dwTRefugosForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwTRefugosForIdUsrstativo value for this OmUsr.
     * 
     * @return dwTRefugosForIdUsrstativo
     */
    public idw.idwws.DwTRefugo[] getDwTRefugosForIdUsrstativo() {
        return dwTRefugosForIdUsrstativo;
    }


    /**
     * Sets the dwTRefugosForIdUsrstativo value for this OmUsr.
     * 
     * @param dwTRefugosForIdUsrstativo
     */
    public void setDwTRefugosForIdUsrstativo(idw.idwws.DwTRefugo[] dwTRefugosForIdUsrstativo) {
        this.dwTRefugosForIdUsrstativo = dwTRefugosForIdUsrstativo;
    }

    public idw.idwws.DwTRefugo getDwTRefugosForIdUsrstativo(int i) {
        return this.dwTRefugosForIdUsrstativo[i];
    }

    public void setDwTRefugosForIdUsrstativo(int i, idw.idwws.DwTRefugo _value) {
        this.dwTRefugosForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the dwTurnosForIdUsrrevisao value for this OmUsr.
     * 
     * @return dwTurnosForIdUsrrevisao
     */
    public idw.idwws.DwTurno[] getDwTurnosForIdUsrrevisao() {
        return dwTurnosForIdUsrrevisao;
    }


    /**
     * Sets the dwTurnosForIdUsrrevisao value for this OmUsr.
     * 
     * @param dwTurnosForIdUsrrevisao
     */
    public void setDwTurnosForIdUsrrevisao(idw.idwws.DwTurno[] dwTurnosForIdUsrrevisao) {
        this.dwTurnosForIdUsrrevisao = dwTurnosForIdUsrrevisao;
    }

    public idw.idwws.DwTurno getDwTurnosForIdUsrrevisao(int i) {
        return this.dwTurnosForIdUsrrevisao[i];
    }

    public void setDwTurnosForIdUsrrevisao(int i, idw.idwws.DwTurno _value) {
        this.dwTurnosForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the dwTurnosForIdUsrstativo value for this OmUsr.
     * 
     * @return dwTurnosForIdUsrstativo
     */
    public idw.idwws.DwTurno[] getDwTurnosForIdUsrstativo() {
        return dwTurnosForIdUsrstativo;
    }


    /**
     * Sets the dwTurnosForIdUsrstativo value for this OmUsr.
     * 
     * @param dwTurnosForIdUsrstativo
     */
    public void setDwTurnosForIdUsrstativo(idw.idwws.DwTurno[] dwTurnosForIdUsrstativo) {
        this.dwTurnosForIdUsrstativo = dwTurnosForIdUsrstativo;
    }

    public idw.idwws.DwTurno getDwTurnosForIdUsrstativo(int i) {
        return this.dwTurnosForIdUsrstativo[i];
    }

    public void setDwTurnosForIdUsrstativo(int i, idw.idwws.DwTurno _value) {
        this.dwTurnosForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the idUsr value for this OmUsr.
     * 
     * @return idUsr
     */
    public long getIdUsr() {
        return idUsr;
    }


    /**
     * Sets the idUsr value for this OmUsr.
     * 
     * @param idUsr
     */
    public void setIdUsr(long idUsr) {
        this.idUsr = idUsr;
    }


    /**
     * Gets the login value for this OmUsr.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this OmUsr.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the omAlimreas value for this OmUsr.
     * 
     * @return omAlimreas
     */
    public idw.idwws.OmAlimrea[] getOmAlimreas() {
        return omAlimreas;
    }


    /**
     * Sets the omAlimreas value for this OmUsr.
     * 
     * @param omAlimreas
     */
    public void setOmAlimreas(idw.idwws.OmAlimrea[] omAlimreas) {
        this.omAlimreas = omAlimreas;
    }

    public idw.idwws.OmAlimrea getOmAlimreas(int i) {
        return this.omAlimreas[i];
    }

    public void setOmAlimreas(int i, idw.idwws.OmAlimrea _value) {
        this.omAlimreas[i] = _value;
    }


    /**
     * Gets the omAlims value for this OmUsr.
     * 
     * @return omAlims
     */
    public idw.idwws.OmAlim[] getOmAlims() {
        return omAlims;
    }


    /**
     * Sets the omAlims value for this OmUsr.
     * 
     * @param omAlims
     */
    public void setOmAlims(idw.idwws.OmAlim[] omAlims) {
        this.omAlims = omAlims;
    }

    public idw.idwws.OmAlim getOmAlims(int i) {
        return this.omAlims[i];
    }

    public void setOmAlims(int i, idw.idwws.OmAlim _value) {
        this.omAlims[i] = _value;
    }


    /**
     * Gets the omCargo value for this OmUsr.
     * 
     * @return omCargo
     */
    public idw.idwws.OmCargo getOmCargo() {
        return omCargo;
    }


    /**
     * Sets the omCargo value for this OmUsr.
     * 
     * @param omCargo
     */
    public void setOmCargo(idw.idwws.OmCargo omCargo) {
        this.omCargo = omCargo;
    }


    /**
     * Gets the omCc value for this OmUsr.
     * 
     * @return omCc
     */
    public idw.idwws.OmCc getOmCc() {
        return omCc;
    }


    /**
     * Sets the omCc value for this OmUsr.
     * 
     * @param omCc
     */
    public void setOmCc(idw.idwws.OmCc omCc) {
        this.omCc = omCc;
    }


    /**
     * Gets the omCcsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omCcsForIdUsrrevisao
     */
    public idw.idwws.OmCc[] getOmCcsForIdUsrrevisao() {
        return omCcsForIdUsrrevisao;
    }


    /**
     * Sets the omCcsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omCcsForIdUsrrevisao
     */
    public void setOmCcsForIdUsrrevisao(idw.idwws.OmCc[] omCcsForIdUsrrevisao) {
        this.omCcsForIdUsrrevisao = omCcsForIdUsrrevisao;
    }

    public idw.idwws.OmCc getOmCcsForIdUsrrevisao(int i) {
        return this.omCcsForIdUsrrevisao[i];
    }

    public void setOmCcsForIdUsrrevisao(int i, idw.idwws.OmCc _value) {
        this.omCcsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omCcsForIdUsrstativo value for this OmUsr.
     * 
     * @return omCcsForIdUsrstativo
     */
    public idw.idwws.OmCc[] getOmCcsForIdUsrstativo() {
        return omCcsForIdUsrstativo;
    }


    /**
     * Sets the omCcsForIdUsrstativo value for this OmUsr.
     * 
     * @param omCcsForIdUsrstativo
     */
    public void setOmCcsForIdUsrstativo(idw.idwws.OmCc[] omCcsForIdUsrstativo) {
        this.omCcsForIdUsrstativo = omCcsForIdUsrstativo;
    }

    public idw.idwws.OmCc getOmCcsForIdUsrstativo(int i) {
        return this.omCcsForIdUsrstativo[i];
    }

    public void setOmCcsForIdUsrstativo(int i, idw.idwws.OmCc _value) {
        this.omCcsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omCfgs value for this OmUsr.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this OmUsr.
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
     * Gets the omClpsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omClpsForIdUsrrevisao
     */
    public idw.idwws.OmClp[] getOmClpsForIdUsrrevisao() {
        return omClpsForIdUsrrevisao;
    }


    /**
     * Sets the omClpsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omClpsForIdUsrrevisao
     */
    public void setOmClpsForIdUsrrevisao(idw.idwws.OmClp[] omClpsForIdUsrrevisao) {
        this.omClpsForIdUsrrevisao = omClpsForIdUsrrevisao;
    }

    public idw.idwws.OmClp getOmClpsForIdUsrrevisao(int i) {
        return this.omClpsForIdUsrrevisao[i];
    }

    public void setOmClpsForIdUsrrevisao(int i, idw.idwws.OmClp _value) {
        this.omClpsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omClpsForIdUsrstativo value for this OmUsr.
     * 
     * @return omClpsForIdUsrstativo
     */
    public idw.idwws.OmClp[] getOmClpsForIdUsrstativo() {
        return omClpsForIdUsrstativo;
    }


    /**
     * Sets the omClpsForIdUsrstativo value for this OmUsr.
     * 
     * @param omClpsForIdUsrstativo
     */
    public void setOmClpsForIdUsrstativo(idw.idwws.OmClp[] omClpsForIdUsrstativo) {
        this.omClpsForIdUsrstativo = omClpsForIdUsrstativo;
    }

    public idw.idwws.OmClp getOmClpsForIdUsrstativo(int i) {
        return this.omClpsForIdUsrstativo[i];
    }

    public void setOmClpsForIdUsrstativo(int i, idw.idwws.OmClp _value) {
        this.omClpsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omForsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omForsForIdUsrrevisao
     */
    public idw.idwws.OmFor[] getOmForsForIdUsrrevisao() {
        return omForsForIdUsrrevisao;
    }


    /**
     * Sets the omForsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omForsForIdUsrrevisao
     */
    public void setOmForsForIdUsrrevisao(idw.idwws.OmFor[] omForsForIdUsrrevisao) {
        this.omForsForIdUsrrevisao = omForsForIdUsrrevisao;
    }

    public idw.idwws.OmFor getOmForsForIdUsrrevisao(int i) {
        return this.omForsForIdUsrrevisao[i];
    }

    public void setOmForsForIdUsrrevisao(int i, idw.idwws.OmFor _value) {
        this.omForsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omForsForIdUsrstativo value for this OmUsr.
     * 
     * @return omForsForIdUsrstativo
     */
    public idw.idwws.OmFor[] getOmForsForIdUsrstativo() {
        return omForsForIdUsrstativo;
    }


    /**
     * Sets the omForsForIdUsrstativo value for this OmUsr.
     * 
     * @param omForsForIdUsrstativo
     */
    public void setOmForsForIdUsrstativo(idw.idwws.OmFor[] omForsForIdUsrstativo) {
        this.omForsForIdUsrstativo = omForsForIdUsrstativo;
    }

    public idw.idwws.OmFor getOmForsForIdUsrstativo(int i) {
        return this.omForsForIdUsrstativo[i];
    }

    public void setOmForsForIdUsrstativo(int i, idw.idwws.OmFor _value) {
        this.omForsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omGt value for this OmUsr.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this OmUsr.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omGtsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omGtsForIdUsrrevisao
     */
    public idw.idwws.OmGt[] getOmGtsForIdUsrrevisao() {
        return omGtsForIdUsrrevisao;
    }


    /**
     * Sets the omGtsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omGtsForIdUsrrevisao
     */
    public void setOmGtsForIdUsrrevisao(idw.idwws.OmGt[] omGtsForIdUsrrevisao) {
        this.omGtsForIdUsrrevisao = omGtsForIdUsrrevisao;
    }

    public idw.idwws.OmGt getOmGtsForIdUsrrevisao(int i) {
        return this.omGtsForIdUsrrevisao[i];
    }

    public void setOmGtsForIdUsrrevisao(int i, idw.idwws.OmGt _value) {
        this.omGtsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omGtsForIdUsrstativo value for this OmUsr.
     * 
     * @return omGtsForIdUsrstativo
     */
    public idw.idwws.OmGt[] getOmGtsForIdUsrstativo() {
        return omGtsForIdUsrstativo;
    }


    /**
     * Sets the omGtsForIdUsrstativo value for this OmUsr.
     * 
     * @param omGtsForIdUsrstativo
     */
    public void setOmGtsForIdUsrstativo(idw.idwws.OmGt[] omGtsForIdUsrstativo) {
        this.omGtsForIdUsrstativo = omGtsForIdUsrstativo;
    }

    public idw.idwws.OmGt getOmGtsForIdUsrstativo(int i) {
        return this.omGtsForIdUsrstativo[i];
    }

    public void setOmGtsForIdUsrstativo(int i, idw.idwws.OmGt _value) {
        this.omGtsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omHomogtsForIdUsr value for this OmUsr.
     * 
     * @return omHomogtsForIdUsr
     */
    public idw.idwws.OmHomogt[] getOmHomogtsForIdUsr() {
        return omHomogtsForIdUsr;
    }


    /**
     * Sets the omHomogtsForIdUsr value for this OmUsr.
     * 
     * @param omHomogtsForIdUsr
     */
    public void setOmHomogtsForIdUsr(idw.idwws.OmHomogt[] omHomogtsForIdUsr) {
        this.omHomogtsForIdUsr = omHomogtsForIdUsr;
    }

    public idw.idwws.OmHomogt getOmHomogtsForIdUsr(int i) {
        return this.omHomogtsForIdUsr[i];
    }

    public void setOmHomogtsForIdUsr(int i, idw.idwws.OmHomogt _value) {
        this.omHomogtsForIdUsr[i] = _value;
    }


    /**
     * Gets the omHomogtsForIdUsrhomologado value for this OmUsr.
     * 
     * @return omHomogtsForIdUsrhomologado
     */
    public idw.idwws.OmHomogt[] getOmHomogtsForIdUsrhomologado() {
        return omHomogtsForIdUsrhomologado;
    }


    /**
     * Sets the omHomogtsForIdUsrhomologado value for this OmUsr.
     * 
     * @param omHomogtsForIdUsrhomologado
     */
    public void setOmHomogtsForIdUsrhomologado(idw.idwws.OmHomogt[] omHomogtsForIdUsrhomologado) {
        this.omHomogtsForIdUsrhomologado = omHomogtsForIdUsrhomologado;
    }

    public idw.idwws.OmHomogt getOmHomogtsForIdUsrhomologado(int i) {
        return this.omHomogtsForIdUsrhomologado[i];
    }

    public void setOmHomogtsForIdUsrhomologado(int i, idw.idwws.OmHomogt _value) {
        this.omHomogtsForIdUsrhomologado[i] = _value;
    }


    /**
     * Gets the omHomoptsForIdUsr value for this OmUsr.
     * 
     * @return omHomoptsForIdUsr
     */
    public idw.idwws.OmHomopt[] getOmHomoptsForIdUsr() {
        return omHomoptsForIdUsr;
    }


    /**
     * Sets the omHomoptsForIdUsr value for this OmUsr.
     * 
     * @param omHomoptsForIdUsr
     */
    public void setOmHomoptsForIdUsr(idw.idwws.OmHomopt[] omHomoptsForIdUsr) {
        this.omHomoptsForIdUsr = omHomoptsForIdUsr;
    }

    public idw.idwws.OmHomopt getOmHomoptsForIdUsr(int i) {
        return this.omHomoptsForIdUsr[i];
    }

    public void setOmHomoptsForIdUsr(int i, idw.idwws.OmHomopt _value) {
        this.omHomoptsForIdUsr[i] = _value;
    }


    /**
     * Gets the omHomoptsForIdUsrhomologado value for this OmUsr.
     * 
     * @return omHomoptsForIdUsrhomologado
     */
    public idw.idwws.OmHomopt[] getOmHomoptsForIdUsrhomologado() {
        return omHomoptsForIdUsrhomologado;
    }


    /**
     * Sets the omHomoptsForIdUsrhomologado value for this OmUsr.
     * 
     * @param omHomoptsForIdUsrhomologado
     */
    public void setOmHomoptsForIdUsrhomologado(idw.idwws.OmHomopt[] omHomoptsForIdUsrhomologado) {
        this.omHomoptsForIdUsrhomologado = omHomoptsForIdUsrhomologado;
    }

    public idw.idwws.OmHomopt getOmHomoptsForIdUsrhomologado(int i) {
        return this.omHomoptsForIdUsrhomologado[i];
    }

    public void setOmHomoptsForIdUsrhomologado(int i, idw.idwws.OmHomopt _value) {
        this.omHomoptsForIdUsrhomologado[i] = _value;
    }


    /**
     * Gets the omImgsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omImgsForIdUsrrevisao
     */
    public idw.idwws.OmImg[] getOmImgsForIdUsrrevisao() {
        return omImgsForIdUsrrevisao;
    }


    /**
     * Sets the omImgsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omImgsForIdUsrrevisao
     */
    public void setOmImgsForIdUsrrevisao(idw.idwws.OmImg[] omImgsForIdUsrrevisao) {
        this.omImgsForIdUsrrevisao = omImgsForIdUsrrevisao;
    }

    public idw.idwws.OmImg getOmImgsForIdUsrrevisao(int i) {
        return this.omImgsForIdUsrrevisao[i];
    }

    public void setOmImgsForIdUsrrevisao(int i, idw.idwws.OmImg _value) {
        this.omImgsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omImgsForIdUsrstativo value for this OmUsr.
     * 
     * @return omImgsForIdUsrstativo
     */
    public idw.idwws.OmImg[] getOmImgsForIdUsrstativo() {
        return omImgsForIdUsrstativo;
    }


    /**
     * Sets the omImgsForIdUsrstativo value for this OmUsr.
     * 
     * @param omImgsForIdUsrstativo
     */
    public void setOmImgsForIdUsrstativo(idw.idwws.OmImg[] omImgsForIdUsrstativo) {
        this.omImgsForIdUsrstativo = omImgsForIdUsrstativo;
    }

    public idw.idwws.OmImg getOmImgsForIdUsrstativo(int i) {
        return this.omImgsForIdUsrstativo[i];
    }

    public void setOmImgsForIdUsrstativo(int i, idw.idwws.OmImg _value) {
        this.omImgsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omImsForIdUsrsrc value for this OmUsr.
     * 
     * @return omImsForIdUsrsrc
     */
    public idw.idwws.OmIm[] getOmImsForIdUsrsrc() {
        return omImsForIdUsrsrc;
    }


    /**
     * Sets the omImsForIdUsrsrc value for this OmUsr.
     * 
     * @param omImsForIdUsrsrc
     */
    public void setOmImsForIdUsrsrc(idw.idwws.OmIm[] omImsForIdUsrsrc) {
        this.omImsForIdUsrsrc = omImsForIdUsrsrc;
    }

    public idw.idwws.OmIm getOmImsForIdUsrsrc(int i) {
        return this.omImsForIdUsrsrc[i];
    }

    public void setOmImsForIdUsrsrc(int i, idw.idwws.OmIm _value) {
        this.omImsForIdUsrsrc[i] = _value;
    }


    /**
     * Gets the omImsForIdUsrtrg value for this OmUsr.
     * 
     * @return omImsForIdUsrtrg
     */
    public idw.idwws.OmIm[] getOmImsForIdUsrtrg() {
        return omImsForIdUsrtrg;
    }


    /**
     * Sets the omImsForIdUsrtrg value for this OmUsr.
     * 
     * @param omImsForIdUsrtrg
     */
    public void setOmImsForIdUsrtrg(idw.idwws.OmIm[] omImsForIdUsrtrg) {
        this.omImsForIdUsrtrg = omImsForIdUsrtrg;
    }

    public idw.idwws.OmIm getOmImsForIdUsrtrg(int i) {
        return this.omImsForIdUsrtrg[i];
    }

    public void setOmImsForIdUsrtrg(int i, idw.idwws.OmIm _value) {
        this.omImsForIdUsrtrg[i] = _value;
    }


    /**
     * Gets the omMapasForIdUsrrevisao value for this OmUsr.
     * 
     * @return omMapasForIdUsrrevisao
     */
    public idw.idwws.OmMapa[] getOmMapasForIdUsrrevisao() {
        return omMapasForIdUsrrevisao;
    }


    /**
     * Sets the omMapasForIdUsrrevisao value for this OmUsr.
     * 
     * @param omMapasForIdUsrrevisao
     */
    public void setOmMapasForIdUsrrevisao(idw.idwws.OmMapa[] omMapasForIdUsrrevisao) {
        this.omMapasForIdUsrrevisao = omMapasForIdUsrrevisao;
    }

    public idw.idwws.OmMapa getOmMapasForIdUsrrevisao(int i) {
        return this.omMapasForIdUsrrevisao[i];
    }

    public void setOmMapasForIdUsrrevisao(int i, idw.idwws.OmMapa _value) {
        this.omMapasForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omMapasForIdUsrstativo value for this OmUsr.
     * 
     * @return omMapasForIdUsrstativo
     */
    public idw.idwws.OmMapa[] getOmMapasForIdUsrstativo() {
        return omMapasForIdUsrstativo;
    }


    /**
     * Sets the omMapasForIdUsrstativo value for this OmUsr.
     * 
     * @param omMapasForIdUsrstativo
     */
    public void setOmMapasForIdUsrstativo(idw.idwws.OmMapa[] omMapasForIdUsrstativo) {
        this.omMapasForIdUsrstativo = omMapasForIdUsrstativo;
    }

    public idw.idwws.OmMapa getOmMapasForIdUsrstativo(int i) {
        return this.omMapasForIdUsrstativo[i];
    }

    public void setOmMapasForIdUsrstativo(int i, idw.idwws.OmMapa _value) {
        this.omMapasForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omPasForIdUsrrevisao value for this OmUsr.
     * 
     * @return omPasForIdUsrrevisao
     */
    public idw.idwws.OmPa[] getOmPasForIdUsrrevisao() {
        return omPasForIdUsrrevisao;
    }


    /**
     * Sets the omPasForIdUsrrevisao value for this OmUsr.
     * 
     * @param omPasForIdUsrrevisao
     */
    public void setOmPasForIdUsrrevisao(idw.idwws.OmPa[] omPasForIdUsrrevisao) {
        this.omPasForIdUsrrevisao = omPasForIdUsrrevisao;
    }

    public idw.idwws.OmPa getOmPasForIdUsrrevisao(int i) {
        return this.omPasForIdUsrrevisao[i];
    }

    public void setOmPasForIdUsrrevisao(int i, idw.idwws.OmPa _value) {
        this.omPasForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omPasForIdUsrstativo value for this OmUsr.
     * 
     * @return omPasForIdUsrstativo
     */
    public idw.idwws.OmPa[] getOmPasForIdUsrstativo() {
        return omPasForIdUsrstativo;
    }


    /**
     * Sets the omPasForIdUsrstativo value for this OmUsr.
     * 
     * @param omPasForIdUsrstativo
     */
    public void setOmPasForIdUsrstativo(idw.idwws.OmPa[] omPasForIdUsrstativo) {
        this.omPasForIdUsrstativo = omPasForIdUsrstativo;
    }

    public idw.idwws.OmPa getOmPasForIdUsrstativo(int i) {
        return this.omPasForIdUsrstativo[i];
    }

    public void setOmPasForIdUsrstativo(int i, idw.idwws.OmPa _value) {
        this.omPasForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omProdutosForIdUsrrevisao value for this OmUsr.
     * 
     * @return omProdutosForIdUsrrevisao
     */
    public idw.idwws.OmProduto[] getOmProdutosForIdUsrrevisao() {
        return omProdutosForIdUsrrevisao;
    }


    /**
     * Sets the omProdutosForIdUsrrevisao value for this OmUsr.
     * 
     * @param omProdutosForIdUsrrevisao
     */
    public void setOmProdutosForIdUsrrevisao(idw.idwws.OmProduto[] omProdutosForIdUsrrevisao) {
        this.omProdutosForIdUsrrevisao = omProdutosForIdUsrrevisao;
    }

    public idw.idwws.OmProduto getOmProdutosForIdUsrrevisao(int i) {
        return this.omProdutosForIdUsrrevisao[i];
    }

    public void setOmProdutosForIdUsrrevisao(int i, idw.idwws.OmProduto _value) {
        this.omProdutosForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omProdutosForIdUsrstativo value for this OmUsr.
     * 
     * @return omProdutosForIdUsrstativo
     */
    public idw.idwws.OmProduto[] getOmProdutosForIdUsrstativo() {
        return omProdutosForIdUsrstativo;
    }


    /**
     * Sets the omProdutosForIdUsrstativo value for this OmUsr.
     * 
     * @param omProdutosForIdUsrstativo
     */
    public void setOmProdutosForIdUsrstativo(idw.idwws.OmProduto[] omProdutosForIdUsrstativo) {
        this.omProdutosForIdUsrstativo = omProdutosForIdUsrstativo;
    }

    public idw.idwws.OmProduto getOmProdutosForIdUsrstativo(int i) {
        return this.omProdutosForIdUsrstativo[i];
    }

    public void setOmProdutosForIdUsrstativo(int i, idw.idwws.OmProduto _value) {
        this.omProdutosForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omProgrpsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omProgrpsForIdUsrrevisao
     */
    public idw.idwws.OmProgrp[] getOmProgrpsForIdUsrrevisao() {
        return omProgrpsForIdUsrrevisao;
    }


    /**
     * Sets the omProgrpsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omProgrpsForIdUsrrevisao
     */
    public void setOmProgrpsForIdUsrrevisao(idw.idwws.OmProgrp[] omProgrpsForIdUsrrevisao) {
        this.omProgrpsForIdUsrrevisao = omProgrpsForIdUsrrevisao;
    }

    public idw.idwws.OmProgrp getOmProgrpsForIdUsrrevisao(int i) {
        return this.omProgrpsForIdUsrrevisao[i];
    }

    public void setOmProgrpsForIdUsrrevisao(int i, idw.idwws.OmProgrp _value) {
        this.omProgrpsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omProgrpsForIdUsrstativo value for this OmUsr.
     * 
     * @return omProgrpsForIdUsrstativo
     */
    public idw.idwws.OmProgrp[] getOmProgrpsForIdUsrstativo() {
        return omProgrpsForIdUsrstativo;
    }


    /**
     * Sets the omProgrpsForIdUsrstativo value for this OmUsr.
     * 
     * @param omProgrpsForIdUsrstativo
     */
    public void setOmProgrpsForIdUsrstativo(idw.idwws.OmProgrp[] omProgrpsForIdUsrstativo) {
        this.omProgrpsForIdUsrstativo = omProgrpsForIdUsrstativo;
    }

    public idw.idwws.OmProgrp getOmProgrpsForIdUsrstativo(int i) {
        return this.omProgrpsForIdUsrstativo[i];
    }

    public void setOmProgrpsForIdUsrstativo(int i, idw.idwws.OmProgrp _value) {
        this.omProgrpsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omPtsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omPtsForIdUsrrevisao
     */
    public idw.idwws.OmPt[] getOmPtsForIdUsrrevisao() {
        return omPtsForIdUsrrevisao;
    }


    /**
     * Sets the omPtsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omPtsForIdUsrrevisao
     */
    public void setOmPtsForIdUsrrevisao(idw.idwws.OmPt[] omPtsForIdUsrrevisao) {
        this.omPtsForIdUsrrevisao = omPtsForIdUsrrevisao;
    }

    public idw.idwws.OmPt getOmPtsForIdUsrrevisao(int i) {
        return this.omPtsForIdUsrrevisao[i];
    }

    public void setOmPtsForIdUsrrevisao(int i, idw.idwws.OmPt _value) {
        this.omPtsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omPtsForIdUsrstativo value for this OmUsr.
     * 
     * @return omPtsForIdUsrstativo
     */
    public idw.idwws.OmPt[] getOmPtsForIdUsrstativo() {
        return omPtsForIdUsrstativo;
    }


    /**
     * Sets the omPtsForIdUsrstativo value for this OmUsr.
     * 
     * @param omPtsForIdUsrstativo
     */
    public void setOmPtsForIdUsrstativo(idw.idwws.OmPt[] omPtsForIdUsrstativo) {
        this.omPtsForIdUsrstativo = omPtsForIdUsrstativo;
    }

    public idw.idwws.OmPt getOmPtsForIdUsrstativo(int i) {
        return this.omPtsForIdUsrstativo[i];
    }

    public void setOmPtsForIdUsrstativo(int i, idw.idwws.OmPt _value) {
        this.omPtsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omTpgtsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omTpgtsForIdUsrrevisao
     */
    public idw.idwws.OmTpgt[] getOmTpgtsForIdUsrrevisao() {
        return omTpgtsForIdUsrrevisao;
    }


    /**
     * Sets the omTpgtsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omTpgtsForIdUsrrevisao
     */
    public void setOmTpgtsForIdUsrrevisao(idw.idwws.OmTpgt[] omTpgtsForIdUsrrevisao) {
        this.omTpgtsForIdUsrrevisao = omTpgtsForIdUsrrevisao;
    }

    public idw.idwws.OmTpgt getOmTpgtsForIdUsrrevisao(int i) {
        return this.omTpgtsForIdUsrrevisao[i];
    }

    public void setOmTpgtsForIdUsrrevisao(int i, idw.idwws.OmTpgt _value) {
        this.omTpgtsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omTpgtsForIdUsrstativo value for this OmUsr.
     * 
     * @return omTpgtsForIdUsrstativo
     */
    public idw.idwws.OmTpgt[] getOmTpgtsForIdUsrstativo() {
        return omTpgtsForIdUsrstativo;
    }


    /**
     * Sets the omTpgtsForIdUsrstativo value for this OmUsr.
     * 
     * @param omTpgtsForIdUsrstativo
     */
    public void setOmTpgtsForIdUsrstativo(idw.idwws.OmTpgt[] omTpgtsForIdUsrstativo) {
        this.omTpgtsForIdUsrstativo = omTpgtsForIdUsrstativo;
    }

    public idw.idwws.OmTpgt getOmTpgtsForIdUsrstativo(int i) {
        return this.omTpgtsForIdUsrstativo[i];
    }

    public void setOmTpgtsForIdUsrstativo(int i, idw.idwws.OmTpgt _value) {
        this.omTpgtsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omTpptsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omTpptsForIdUsrrevisao
     */
    public idw.idwws.OmTppt[] getOmTpptsForIdUsrrevisao() {
        return omTpptsForIdUsrrevisao;
    }


    /**
     * Sets the omTpptsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omTpptsForIdUsrrevisao
     */
    public void setOmTpptsForIdUsrrevisao(idw.idwws.OmTppt[] omTpptsForIdUsrrevisao) {
        this.omTpptsForIdUsrrevisao = omTpptsForIdUsrrevisao;
    }

    public idw.idwws.OmTppt getOmTpptsForIdUsrrevisao(int i) {
        return this.omTpptsForIdUsrrevisao[i];
    }

    public void setOmTpptsForIdUsrrevisao(int i, idw.idwws.OmTppt _value) {
        this.omTpptsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omTpptsForIdUsrstativo value for this OmUsr.
     * 
     * @return omTpptsForIdUsrstativo
     */
    public idw.idwws.OmTppt[] getOmTpptsForIdUsrstativo() {
        return omTpptsForIdUsrstativo;
    }


    /**
     * Sets the omTpptsForIdUsrstativo value for this OmUsr.
     * 
     * @param omTpptsForIdUsrstativo
     */
    public void setOmTpptsForIdUsrstativo(idw.idwws.OmTppt[] omTpptsForIdUsrstativo) {
        this.omTpptsForIdUsrstativo = omTpptsForIdUsrstativo;
    }

    public idw.idwws.OmTppt getOmTpptsForIdUsrstativo(int i) {
        return this.omTpptsForIdUsrstativo[i];
    }

    public void setOmTpptsForIdUsrstativo(int i, idw.idwws.OmTppt _value) {
        this.omTpptsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmUsr.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmUsr.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmUsr.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmUsr.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the omUsrgrp value for this OmUsr.
     * 
     * @return omUsrgrp
     */
    public idw.idwws.OmUsrgrp getOmUsrgrp() {
        return omUsrgrp;
    }


    /**
     * Sets the omUsrgrp value for this OmUsr.
     * 
     * @param omUsrgrp
     */
    public void setOmUsrgrp(idw.idwws.OmUsrgrp omUsrgrp) {
        this.omUsrgrp = omUsrgrp;
    }


    /**
     * Gets the omUsrsForIdUsrrevisao value for this OmUsr.
     * 
     * @return omUsrsForIdUsrrevisao
     */
    public idw.idwws.OmUsr[] getOmUsrsForIdUsrrevisao() {
        return omUsrsForIdUsrrevisao;
    }


    /**
     * Sets the omUsrsForIdUsrrevisao value for this OmUsr.
     * 
     * @param omUsrsForIdUsrrevisao
     */
    public void setOmUsrsForIdUsrrevisao(idw.idwws.OmUsr[] omUsrsForIdUsrrevisao) {
        this.omUsrsForIdUsrrevisao = omUsrsForIdUsrrevisao;
    }

    public idw.idwws.OmUsr getOmUsrsForIdUsrrevisao(int i) {
        return this.omUsrsForIdUsrrevisao[i];
    }

    public void setOmUsrsForIdUsrrevisao(int i, idw.idwws.OmUsr _value) {
        this.omUsrsForIdUsrrevisao[i] = _value;
    }


    /**
     * Gets the omUsrsForIdUsrstativo value for this OmUsr.
     * 
     * @return omUsrsForIdUsrstativo
     */
    public idw.idwws.OmUsr[] getOmUsrsForIdUsrstativo() {
        return omUsrsForIdUsrstativo;
    }


    /**
     * Sets the omUsrsForIdUsrstativo value for this OmUsr.
     * 
     * @param omUsrsForIdUsrstativo
     */
    public void setOmUsrsForIdUsrstativo(idw.idwws.OmUsr[] omUsrsForIdUsrstativo) {
        this.omUsrsForIdUsrstativo = omUsrsForIdUsrstativo;
    }

    public idw.idwws.OmUsr getOmUsrsForIdUsrstativo(int i) {
        return this.omUsrsForIdUsrstativo[i];
    }

    public void setOmUsrsForIdUsrstativo(int i, idw.idwws.OmUsr _value) {
        this.omUsrsForIdUsrstativo[i] = _value;
    }


    /**
     * Gets the revisao value for this OmUsr.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmUsr.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the senha value for this OmUsr.
     * 
     * @return senha
     */
    public java.lang.String getSenha() {
        return senha;
    }


    /**
     * Sets the senha value for this OmUsr.
     * 
     * @param senha
     */
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }


    /**
     * Gets the stAtivo value for this OmUsr.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmUsr.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the urlEmail value for this OmUsr.
     * 
     * @return urlEmail
     */
    public java.lang.String getUrlEmail() {
        return urlEmail;
    }


    /**
     * Sets the urlEmail value for this OmUsr.
     * 
     * @param urlEmail
     */
    public void setUrlEmail(java.lang.String urlEmail) {
        this.urlEmail = urlEmail;
    }


    /**
     * Gets the urlSms value for this OmUsr.
     * 
     * @return urlSms
     */
    public java.lang.String getUrlSms() {
        return urlSms;
    }


    /**
     * Sets the urlSms value for this OmUsr.
     * 
     * @param urlSms
     */
    public void setUrlSms(java.lang.String urlSms) {
        this.urlSms = urlSms;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmUsr)) return false;
        OmUsr other = (OmUsr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdUsr==null && other.getCdUsr()==null) || 
             (this.cdUsr!=null &&
              this.cdUsr.equals(other.getCdUsr()))) &&
            ((this.dsApelido==null && other.getDsApelido()==null) || 
             (this.dsApelido!=null &&
              this.dsApelido.equals(other.getDsApelido()))) &&
            ((this.dsNome==null && other.getDsNome()==null) || 
             (this.dsNome!=null &&
              this.dsNome.equals(other.getDsNome()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwCalsForIdUsrrevisao==null && other.getDwCalsForIdUsrrevisao()==null) || 
             (this.dwCalsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwCalsForIdUsrrevisao, other.getDwCalsForIdUsrrevisao()))) &&
            ((this.dwCalsForIdUsrstativo==null && other.getDwCalsForIdUsrstativo()==null) || 
             (this.dwCalsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwCalsForIdUsrstativo, other.getDwCalsForIdUsrstativo()))) &&
            ((this.dwConsollogs==null && other.getDwConsollogs()==null) || 
             (this.dwConsollogs!=null &&
              java.util.Arrays.equals(this.dwConsollogs, other.getDwConsollogs()))) &&
            ((this.dwConsolmologs==null && other.getDwConsolmologs()==null) || 
             (this.dwConsolmologs!=null &&
              java.util.Arrays.equals(this.dwConsolmologs, other.getDwConsolmologs()))) &&
            ((this.dwConsolmos==null && other.getDwConsolmos()==null) || 
             (this.dwConsolmos!=null &&
              java.util.Arrays.equals(this.dwConsolmos, other.getDwConsolmos()))) &&
            ((this.dwConsolpalogtecs==null && other.getDwConsolpalogtecs()==null) || 
             (this.dwConsolpalogtecs!=null &&
              java.util.Arrays.equals(this.dwConsolpalogtecs, other.getDwConsolpalogtecs()))) &&
            ((this.dwEstlocalsForIdUsrrevisao==null && other.getDwEstlocalsForIdUsrrevisao()==null) || 
             (this.dwEstlocalsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwEstlocalsForIdUsrrevisao, other.getDwEstlocalsForIdUsrrevisao()))) &&
            ((this.dwEstlocalsForIdUsrstativo==null && other.getDwEstlocalsForIdUsrstativo()==null) || 
             (this.dwEstlocalsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwEstlocalsForIdUsrstativo, other.getDwEstlocalsForIdUsrstativo()))) &&
            ((this.dwEstsForIdUsrrevisao==null && other.getDwEstsForIdUsrrevisao()==null) || 
             (this.dwEstsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwEstsForIdUsrrevisao, other.getDwEstsForIdUsrrevisao()))) &&
            ((this.dwEstsForIdUsrstativo==null && other.getDwEstsForIdUsrstativo()==null) || 
             (this.dwEstsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwEstsForIdUsrstativo, other.getDwEstsForIdUsrstativo()))) &&
            ((this.dwFolhasForIdUsrrevisao==null && other.getDwFolhasForIdUsrrevisao()==null) || 
             (this.dwFolhasForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwFolhasForIdUsrrevisao, other.getDwFolhasForIdUsrrevisao()))) &&
            ((this.dwFolhasForIdUsrstativo==null && other.getDwFolhasForIdUsrstativo()==null) || 
             (this.dwFolhasForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwFolhasForIdUsrstativo, other.getDwFolhasForIdUsrstativo()))) &&
            ((this.dwFtEtapasForIdUsrrevisao==null && other.getDwFtEtapasForIdUsrrevisao()==null) || 
             (this.dwFtEtapasForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwFtEtapasForIdUsrrevisao, other.getDwFtEtapasForIdUsrrevisao()))) &&
            ((this.dwFtEtapasForIdUsrstativo==null && other.getDwFtEtapasForIdUsrstativo()==null) || 
             (this.dwFtEtapasForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwFtEtapasForIdUsrstativo, other.getDwFtEtapasForIdUsrstativo()))) &&
            ((this.dwPassagemsForIdUsroperador==null && other.getDwPassagemsForIdUsroperador()==null) || 
             (this.dwPassagemsForIdUsroperador!=null &&
              java.util.Arrays.equals(this.dwPassagemsForIdUsroperador, other.getDwPassagemsForIdUsroperador()))) &&
            ((this.dwPassagemsForIdUsrsupervisor==null && other.getDwPassagemsForIdUsrsupervisor()==null) || 
             (this.dwPassagemsForIdUsrsupervisor!=null &&
              java.util.Arrays.equals(this.dwPassagemsForIdUsrsupervisor, other.getDwPassagemsForIdUsrsupervisor()))) &&
            ((this.dwRotaForIdUsrrevisao==null && other.getDwRotaForIdUsrrevisao()==null) || 
             (this.dwRotaForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwRotaForIdUsrrevisao, other.getDwRotaForIdUsrrevisao()))) &&
            ((this.dwRotaForIdUsrstativo==null && other.getDwRotaForIdUsrstativo()==null) || 
             (this.dwRotaForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwRotaForIdUsrstativo, other.getDwRotaForIdUsrstativo()))) &&
            ((this.dwTAcaosForIdUsrrevisao==null && other.getDwTAcaosForIdUsrrevisao()==null) || 
             (this.dwTAcaosForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwTAcaosForIdUsrrevisao, other.getDwTAcaosForIdUsrrevisao()))) &&
            ((this.dwTAcaosForIdUsrstativo==null && other.getDwTAcaosForIdUsrstativo()==null) || 
             (this.dwTAcaosForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwTAcaosForIdUsrstativo, other.getDwTAcaosForIdUsrstativo()))) &&
            ((this.dwTAlertasForIdUsrrevisao==null && other.getDwTAlertasForIdUsrrevisao()==null) || 
             (this.dwTAlertasForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwTAlertasForIdUsrrevisao, other.getDwTAlertasForIdUsrrevisao()))) &&
            ((this.dwTAlertasForIdUsrstativo==null && other.getDwTAlertasForIdUsrstativo()==null) || 
             (this.dwTAlertasForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwTAlertasForIdUsrstativo, other.getDwTAlertasForIdUsrstativo()))) &&
            ((this.dwTDefeitosForIdUsrrevisao==null && other.getDwTDefeitosForIdUsrrevisao()==null) || 
             (this.dwTDefeitosForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwTDefeitosForIdUsrrevisao, other.getDwTDefeitosForIdUsrrevisao()))) &&
            ((this.dwTDefeitosForIdUsrstativo==null && other.getDwTDefeitosForIdUsrstativo()==null) || 
             (this.dwTDefeitosForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwTDefeitosForIdUsrstativo, other.getDwTDefeitosForIdUsrstativo()))) &&
            ((this.dwTParadasForIdUsrrevisao==null && other.getDwTParadasForIdUsrrevisao()==null) || 
             (this.dwTParadasForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwTParadasForIdUsrrevisao, other.getDwTParadasForIdUsrrevisao()))) &&
            ((this.dwTParadasForIdUsrstativo==null && other.getDwTParadasForIdUsrstativo()==null) || 
             (this.dwTParadasForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwTParadasForIdUsrstativo, other.getDwTParadasForIdUsrstativo()))) &&
            ((this.dwTRefugosForIdUsrrevisao==null && other.getDwTRefugosForIdUsrrevisao()==null) || 
             (this.dwTRefugosForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwTRefugosForIdUsrrevisao, other.getDwTRefugosForIdUsrrevisao()))) &&
            ((this.dwTRefugosForIdUsrstativo==null && other.getDwTRefugosForIdUsrstativo()==null) || 
             (this.dwTRefugosForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwTRefugosForIdUsrstativo, other.getDwTRefugosForIdUsrstativo()))) &&
            ((this.dwTurnosForIdUsrrevisao==null && other.getDwTurnosForIdUsrrevisao()==null) || 
             (this.dwTurnosForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.dwTurnosForIdUsrrevisao, other.getDwTurnosForIdUsrrevisao()))) &&
            ((this.dwTurnosForIdUsrstativo==null && other.getDwTurnosForIdUsrstativo()==null) || 
             (this.dwTurnosForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.dwTurnosForIdUsrstativo, other.getDwTurnosForIdUsrstativo()))) &&
            this.idUsr == other.getIdUsr() &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.omAlimreas==null && other.getOmAlimreas()==null) || 
             (this.omAlimreas!=null &&
              java.util.Arrays.equals(this.omAlimreas, other.getOmAlimreas()))) &&
            ((this.omAlims==null && other.getOmAlims()==null) || 
             (this.omAlims!=null &&
              java.util.Arrays.equals(this.omAlims, other.getOmAlims()))) &&
            ((this.omCargo==null && other.getOmCargo()==null) || 
             (this.omCargo!=null &&
              this.omCargo.equals(other.getOmCargo()))) &&
            ((this.omCc==null && other.getOmCc()==null) || 
             (this.omCc!=null &&
              this.omCc.equals(other.getOmCc()))) &&
            ((this.omCcsForIdUsrrevisao==null && other.getOmCcsForIdUsrrevisao()==null) || 
             (this.omCcsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omCcsForIdUsrrevisao, other.getOmCcsForIdUsrrevisao()))) &&
            ((this.omCcsForIdUsrstativo==null && other.getOmCcsForIdUsrstativo()==null) || 
             (this.omCcsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omCcsForIdUsrstativo, other.getOmCcsForIdUsrstativo()))) &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.omClpsForIdUsrrevisao==null && other.getOmClpsForIdUsrrevisao()==null) || 
             (this.omClpsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omClpsForIdUsrrevisao, other.getOmClpsForIdUsrrevisao()))) &&
            ((this.omClpsForIdUsrstativo==null && other.getOmClpsForIdUsrstativo()==null) || 
             (this.omClpsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omClpsForIdUsrstativo, other.getOmClpsForIdUsrstativo()))) &&
            ((this.omForsForIdUsrrevisao==null && other.getOmForsForIdUsrrevisao()==null) || 
             (this.omForsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omForsForIdUsrrevisao, other.getOmForsForIdUsrrevisao()))) &&
            ((this.omForsForIdUsrstativo==null && other.getOmForsForIdUsrstativo()==null) || 
             (this.omForsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omForsForIdUsrstativo, other.getOmForsForIdUsrstativo()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omGtsForIdUsrrevisao==null && other.getOmGtsForIdUsrrevisao()==null) || 
             (this.omGtsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omGtsForIdUsrrevisao, other.getOmGtsForIdUsrrevisao()))) &&
            ((this.omGtsForIdUsrstativo==null && other.getOmGtsForIdUsrstativo()==null) || 
             (this.omGtsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omGtsForIdUsrstativo, other.getOmGtsForIdUsrstativo()))) &&
            ((this.omHomogtsForIdUsr==null && other.getOmHomogtsForIdUsr()==null) || 
             (this.omHomogtsForIdUsr!=null &&
              java.util.Arrays.equals(this.omHomogtsForIdUsr, other.getOmHomogtsForIdUsr()))) &&
            ((this.omHomogtsForIdUsrhomologado==null && other.getOmHomogtsForIdUsrhomologado()==null) || 
             (this.omHomogtsForIdUsrhomologado!=null &&
              java.util.Arrays.equals(this.omHomogtsForIdUsrhomologado, other.getOmHomogtsForIdUsrhomologado()))) &&
            ((this.omHomoptsForIdUsr==null && other.getOmHomoptsForIdUsr()==null) || 
             (this.omHomoptsForIdUsr!=null &&
              java.util.Arrays.equals(this.omHomoptsForIdUsr, other.getOmHomoptsForIdUsr()))) &&
            ((this.omHomoptsForIdUsrhomologado==null && other.getOmHomoptsForIdUsrhomologado()==null) || 
             (this.omHomoptsForIdUsrhomologado!=null &&
              java.util.Arrays.equals(this.omHomoptsForIdUsrhomologado, other.getOmHomoptsForIdUsrhomologado()))) &&
            ((this.omImgsForIdUsrrevisao==null && other.getOmImgsForIdUsrrevisao()==null) || 
             (this.omImgsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omImgsForIdUsrrevisao, other.getOmImgsForIdUsrrevisao()))) &&
            ((this.omImgsForIdUsrstativo==null && other.getOmImgsForIdUsrstativo()==null) || 
             (this.omImgsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omImgsForIdUsrstativo, other.getOmImgsForIdUsrstativo()))) &&
            ((this.omImsForIdUsrsrc==null && other.getOmImsForIdUsrsrc()==null) || 
             (this.omImsForIdUsrsrc!=null &&
              java.util.Arrays.equals(this.omImsForIdUsrsrc, other.getOmImsForIdUsrsrc()))) &&
            ((this.omImsForIdUsrtrg==null && other.getOmImsForIdUsrtrg()==null) || 
             (this.omImsForIdUsrtrg!=null &&
              java.util.Arrays.equals(this.omImsForIdUsrtrg, other.getOmImsForIdUsrtrg()))) &&
            ((this.omMapasForIdUsrrevisao==null && other.getOmMapasForIdUsrrevisao()==null) || 
             (this.omMapasForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omMapasForIdUsrrevisao, other.getOmMapasForIdUsrrevisao()))) &&
            ((this.omMapasForIdUsrstativo==null && other.getOmMapasForIdUsrstativo()==null) || 
             (this.omMapasForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omMapasForIdUsrstativo, other.getOmMapasForIdUsrstativo()))) &&
            ((this.omPasForIdUsrrevisao==null && other.getOmPasForIdUsrrevisao()==null) || 
             (this.omPasForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omPasForIdUsrrevisao, other.getOmPasForIdUsrrevisao()))) &&
            ((this.omPasForIdUsrstativo==null && other.getOmPasForIdUsrstativo()==null) || 
             (this.omPasForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omPasForIdUsrstativo, other.getOmPasForIdUsrstativo()))) &&
            ((this.omProdutosForIdUsrrevisao==null && other.getOmProdutosForIdUsrrevisao()==null) || 
             (this.omProdutosForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omProdutosForIdUsrrevisao, other.getOmProdutosForIdUsrrevisao()))) &&
            ((this.omProdutosForIdUsrstativo==null && other.getOmProdutosForIdUsrstativo()==null) || 
             (this.omProdutosForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omProdutosForIdUsrstativo, other.getOmProdutosForIdUsrstativo()))) &&
            ((this.omProgrpsForIdUsrrevisao==null && other.getOmProgrpsForIdUsrrevisao()==null) || 
             (this.omProgrpsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omProgrpsForIdUsrrevisao, other.getOmProgrpsForIdUsrrevisao()))) &&
            ((this.omProgrpsForIdUsrstativo==null && other.getOmProgrpsForIdUsrstativo()==null) || 
             (this.omProgrpsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omProgrpsForIdUsrstativo, other.getOmProgrpsForIdUsrstativo()))) &&
            ((this.omPtsForIdUsrrevisao==null && other.getOmPtsForIdUsrrevisao()==null) || 
             (this.omPtsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omPtsForIdUsrrevisao, other.getOmPtsForIdUsrrevisao()))) &&
            ((this.omPtsForIdUsrstativo==null && other.getOmPtsForIdUsrstativo()==null) || 
             (this.omPtsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omPtsForIdUsrstativo, other.getOmPtsForIdUsrstativo()))) &&
            ((this.omTpgtsForIdUsrrevisao==null && other.getOmTpgtsForIdUsrrevisao()==null) || 
             (this.omTpgtsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omTpgtsForIdUsrrevisao, other.getOmTpgtsForIdUsrrevisao()))) &&
            ((this.omTpgtsForIdUsrstativo==null && other.getOmTpgtsForIdUsrstativo()==null) || 
             (this.omTpgtsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omTpgtsForIdUsrstativo, other.getOmTpgtsForIdUsrstativo()))) &&
            ((this.omTpptsForIdUsrrevisao==null && other.getOmTpptsForIdUsrrevisao()==null) || 
             (this.omTpptsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omTpptsForIdUsrrevisao, other.getOmTpptsForIdUsrrevisao()))) &&
            ((this.omTpptsForIdUsrstativo==null && other.getOmTpptsForIdUsrstativo()==null) || 
             (this.omTpptsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omTpptsForIdUsrstativo, other.getOmTpptsForIdUsrstativo()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.omUsrgrp==null && other.getOmUsrgrp()==null) || 
             (this.omUsrgrp!=null &&
              this.omUsrgrp.equals(other.getOmUsrgrp()))) &&
            ((this.omUsrsForIdUsrrevisao==null && other.getOmUsrsForIdUsrrevisao()==null) || 
             (this.omUsrsForIdUsrrevisao!=null &&
              java.util.Arrays.equals(this.omUsrsForIdUsrrevisao, other.getOmUsrsForIdUsrrevisao()))) &&
            ((this.omUsrsForIdUsrstativo==null && other.getOmUsrsForIdUsrstativo()==null) || 
             (this.omUsrsForIdUsrstativo!=null &&
              java.util.Arrays.equals(this.omUsrsForIdUsrstativo, other.getOmUsrsForIdUsrstativo()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.senha==null && other.getSenha()==null) || 
             (this.senha!=null &&
              this.senha.equals(other.getSenha()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.urlEmail==null && other.getUrlEmail()==null) || 
             (this.urlEmail!=null &&
              this.urlEmail.equals(other.getUrlEmail()))) &&
            ((this.urlSms==null && other.getUrlSms()==null) || 
             (this.urlSms!=null &&
              this.urlSms.equals(other.getUrlSms())));
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
        if (getCdUsr() != null) {
            _hashCode += getCdUsr().hashCode();
        }
        if (getDsApelido() != null) {
            _hashCode += getDsApelido().hashCode();
        }
        if (getDsNome() != null) {
            _hashCode += getDsNome().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwCalsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwCalsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsollogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsollogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsollogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolmologs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmologs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmologs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolpalogtecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpalogtecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpalogtecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwEstlocalsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwEstlocalsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwEstlocalsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwEstlocalsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwEstlocalsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwEstlocalsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwEstsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwEstsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwEstsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwEstsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwEstsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwEstsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhasForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhasForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhasForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhasForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhasForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhasForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFtEtapasForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFtEtapasForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFtEtapasForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFtEtapasForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFtEtapasForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFtEtapasForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPassagemsForIdUsroperador() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassagemsForIdUsroperador());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassagemsForIdUsroperador(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPassagemsForIdUsrsupervisor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassagemsForIdUsrsupervisor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassagemsForIdUsrsupervisor(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRotaForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotaForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotaForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRotaForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotaForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotaForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAcaosForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTAcaosForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTAcaosForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAcaosForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTAcaosForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTAcaosForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAlertasForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTAlertasForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTAlertasForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAlertasForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTAlertasForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTAlertasForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTDefeitosForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTDefeitosForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTDefeitosForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTDefeitosForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTDefeitosForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTDefeitosForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTParadasForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTParadasForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTParadasForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTParadasForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTParadasForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTParadasForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTRefugosForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTRefugosForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTRefugosForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTRefugosForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTRefugosForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTRefugosForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTurnosForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTurnosForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTurnosForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTurnosForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTurnosForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTurnosForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdUsr()).hashCode();
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getOmAlimreas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmAlimreas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmAlimreas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmAlims() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmAlims());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmAlims(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCargo() != null) {
            _hashCode += getOmCargo().hashCode();
        }
        if (getOmCc() != null) {
            _hashCode += getOmCc().hashCode();
        }
        if (getOmCcsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCcsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCcsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCcsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCcsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCcsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getOmClpsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmClpsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmClpsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmClpsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmClpsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmClpsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmForsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmForsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmForsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmForsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmForsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmForsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmGtsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGtsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGtsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmGtsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGtsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGtsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmHomogtsForIdUsr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmHomogtsForIdUsr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmHomogtsForIdUsr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmHomogtsForIdUsrhomologado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmHomogtsForIdUsrhomologado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmHomogtsForIdUsrhomologado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmHomoptsForIdUsr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmHomoptsForIdUsr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmHomoptsForIdUsr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmHomoptsForIdUsrhomologado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmHomoptsForIdUsrhomologado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmHomoptsForIdUsrhomologado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmImgsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmImgsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmImgsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmImgsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmImgsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmImgsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmImsForIdUsrsrc() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmImsForIdUsrsrc());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmImsForIdUsrsrc(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmImsForIdUsrtrg() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmImsForIdUsrtrg());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmImsForIdUsrtrg(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmMapasForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmMapasForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmMapasForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmMapasForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmMapasForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmMapasForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPasForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPasForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPasForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPasForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPasForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPasForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProdutosForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProdutosForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProdutosForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProdutosForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProdutosForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProdutosForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProgrpsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProgrpsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProgrpsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProgrpsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProgrpsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProgrpsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPtsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPtsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPtsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPtsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPtsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPtsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmTpgtsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmTpgtsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmTpgtsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmTpgtsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmTpgtsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmTpgtsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmTpptsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmTpptsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmTpptsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmTpptsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmTpptsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmTpptsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getOmUsrgrp() != null) {
            _hashCode += getOmUsrgrp().hashCode();
        }
        if (getOmUsrsForIdUsrrevisao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmUsrsForIdUsrrevisao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmUsrsForIdUsrrevisao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUsrsForIdUsrstativo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmUsrsForIdUsrstativo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmUsrsForIdUsrstativo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSenha() != null) {
            _hashCode += getSenha().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getUrlEmail() != null) {
            _hashCode += getUrlEmail().hashCode();
        }
        if (getUrlSms() != null) {
            _hashCode += getUrlSms().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmUsr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsApelido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsApelido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsNome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsNome"));
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
        elemField.setFieldName("dwCalsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsollogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsollogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsollog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmologs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmologs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmolog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpalogtecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpalogtecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalogtec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstlocalsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstlocalsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstlocal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstlocalsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstlocalsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstlocal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhasForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhasForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhasForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhasForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtEtapasForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtEtapasForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtEtapasForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtEtapasForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagemsForIdUsroperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagemsForIdUsroperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagemsForIdUsrsupervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagemsForIdUsrsupervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotaForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotaForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotaForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotaForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAcaosForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAcaosForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAcaosForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAcaosForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAlertasForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAlertasForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAlerta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAlertasForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAlertasForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAlerta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeitosForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeitosForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeitosForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeitosForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTParadasForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParadasForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTParadasForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParadasForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTRefugosForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTRefugosForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTRefugosForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTRefugosForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurnosForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurnosForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurnosForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurnosForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlimreas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlimreas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlimrea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlims");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlims"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlim"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCargo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCargo"));
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
        elemField.setFieldName("omCcsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCcsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCcsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCcsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("omClpsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omClpsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omClp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omClpsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omClpsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omClp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omForsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omForsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omFor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omForsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omForsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omFor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGtsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGtsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGtsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGtsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omHomogtsForIdUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omHomogtsForIdUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomogt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omHomogtsForIdUsrhomologado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omHomogtsForIdUsrhomologado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomogt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omHomoptsForIdUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omHomoptsForIdUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomopt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omHomoptsForIdUsrhomologado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omHomoptsForIdUsrhomologado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomopt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omImgsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omImgsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omImg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omImgsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omImgsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omImg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omImsForIdUsrsrc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omImsForIdUsrsrc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omImsForIdUsrtrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omImsForIdUsrtrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapasForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapasForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapasForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapasForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPasForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPasForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPasForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPasForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutosForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutosForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutosForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutosForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProgrpsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProgrpsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProgrpsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProgrpsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPtsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPtsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPtsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPtsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpgtsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpgtsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTpgt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpgtsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpgtsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTpgt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("omUsrgrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrgrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsrgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrsForIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrsForIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrsForIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrsForIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("urlEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlSms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlSms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
