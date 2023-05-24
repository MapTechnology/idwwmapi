/**
 * DwFolha.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolha  extends idw.idwws.DwFolhaTemplate  implements java.io.Serializable {
    private java.lang.String cdFolha;

    private java.lang.String dsFolha;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolid[] dwConsolids;

    private idw.idwws.DwFolhacic[] dwFolhacics;

    private idw.idwws.DwFolhaiac[] dwFolhaiacs;

    private idw.idwws.DwFolhamedtemp[] dwFolhamedtemps;

    private idw.idwws.DwFolhamon[] dwFolhamons;

    private idw.idwws.DwFolharap[] dwFolharaps;

    private idw.idwws.DwFolhasetup[] dwFolhasetupsForIdFolhaentrando;

    private idw.idwws.DwFolhasetup[] dwFolhasetupsForIdFolhasaindo;

    private idw.idwws.DwFolhateste[] dwFolhatestes;

    private idw.idwws.DwFolhatv[] dwFolhatvs;

    private idw.idwws.DwProcedimento dwProcedimento;

    private idw.idwws.DwRotapasso[] dwRotapassos;

    private java.lang.Long idFolha;

    private java.lang.Boolean isLogonobrigatorio;

    private java.lang.Boolean isModelo;

    private idw.idwws.MsTrigger[] msTriggers;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmObj[] omObjsForIdFolha;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmPt[] omPts;

    private idw.idwws.OmTppt omTppt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpCp[] ppCps;

    private java.lang.Long revisao;

    private java.math.BigDecimal segCiclominimo;

    private java.math.BigDecimal segCiclopadrao;

    private java.math.BigDecimal segCiclotimeout;

    private java.math.BigDecimal segLogoutauto;

    private java.lang.Integer segSetup;

    private java.lang.Byte stAtivo;

    private java.lang.Byte tpFolha;

    public DwFolha() {
    }

    public DwFolha(
           java.lang.Long id,
           java.lang.String cdFolha,
           java.lang.String dsFolha,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolid[] dwConsolids,
           idw.idwws.DwFolhacic[] dwFolhacics,
           idw.idwws.DwFolhaiac[] dwFolhaiacs,
           idw.idwws.DwFolhamedtemp[] dwFolhamedtemps,
           idw.idwws.DwFolhamon[] dwFolhamons,
           idw.idwws.DwFolharap[] dwFolharaps,
           idw.idwws.DwFolhasetup[] dwFolhasetupsForIdFolhaentrando,
           idw.idwws.DwFolhasetup[] dwFolhasetupsForIdFolhasaindo,
           idw.idwws.DwFolhateste[] dwFolhatestes,
           idw.idwws.DwFolhatv[] dwFolhatvs,
           idw.idwws.DwProcedimento dwProcedimento,
           idw.idwws.DwRotapasso[] dwRotapassos,
           java.lang.Long idFolha,
           java.lang.Boolean isLogonobrigatorio,
           java.lang.Boolean isModelo,
           idw.idwws.MsTrigger[] msTriggers,
           idw.idwws.OmGt omGt,
           idw.idwws.OmObj[] omObjsForIdFolha,
           idw.idwws.OmPt omPt,
           idw.idwws.OmPt[] omPts,
           idw.idwws.OmTppt omTppt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCp[] ppCps,
           java.lang.Long revisao,
           java.math.BigDecimal segCiclominimo,
           java.math.BigDecimal segCiclopadrao,
           java.math.BigDecimal segCiclotimeout,
           java.math.BigDecimal segLogoutauto,
           java.lang.Integer segSetup,
           java.lang.Byte stAtivo,
           java.lang.Byte tpFolha) {
        super(
            id);
        this.cdFolha = cdFolha;
        this.dsFolha = dsFolha;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolids = dwConsolids;
        this.dwFolhacics = dwFolhacics;
        this.dwFolhaiacs = dwFolhaiacs;
        this.dwFolhamedtemps = dwFolhamedtemps;
        this.dwFolhamons = dwFolhamons;
        this.dwFolharaps = dwFolharaps;
        this.dwFolhasetupsForIdFolhaentrando = dwFolhasetupsForIdFolhaentrando;
        this.dwFolhasetupsForIdFolhasaindo = dwFolhasetupsForIdFolhasaindo;
        this.dwFolhatestes = dwFolhatestes;
        this.dwFolhatvs = dwFolhatvs;
        this.dwProcedimento = dwProcedimento;
        this.dwRotapassos = dwRotapassos;
        this.idFolha = idFolha;
        this.isLogonobrigatorio = isLogonobrigatorio;
        this.isModelo = isModelo;
        this.msTriggers = msTriggers;
        this.omGt = omGt;
        this.omObjsForIdFolha = omObjsForIdFolha;
        this.omPt = omPt;
        this.omPts = omPts;
        this.omTppt = omTppt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppCps = ppCps;
        this.revisao = revisao;
        this.segCiclominimo = segCiclominimo;
        this.segCiclopadrao = segCiclopadrao;
        this.segCiclotimeout = segCiclotimeout;
        this.segLogoutauto = segLogoutauto;
        this.segSetup = segSetup;
        this.stAtivo = stAtivo;
        this.tpFolha = tpFolha;
    }


    /**
     * Gets the cdFolha value for this DwFolha.
     * 
     * @return cdFolha
     */
    public java.lang.String getCdFolha() {
        return cdFolha;
    }


    /**
     * Sets the cdFolha value for this DwFolha.
     * 
     * @param cdFolha
     */
    public void setCdFolha(java.lang.String cdFolha) {
        this.cdFolha = cdFolha;
    }


    /**
     * Gets the dsFolha value for this DwFolha.
     * 
     * @return dsFolha
     */
    public java.lang.String getDsFolha() {
        return dsFolha;
    }


    /**
     * Sets the dsFolha value for this DwFolha.
     * 
     * @param dsFolha
     */
    public void setDsFolha(java.lang.String dsFolha) {
        this.dsFolha = dsFolha;
    }


    /**
     * Gets the dtRevisao value for this DwFolha.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwFolha.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwFolha.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwFolha.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolids value for this DwFolha.
     * 
     * @return dwConsolids
     */
    public idw.idwws.DwConsolid[] getDwConsolids() {
        return dwConsolids;
    }


    /**
     * Sets the dwConsolids value for this DwFolha.
     * 
     * @param dwConsolids
     */
    public void setDwConsolids(idw.idwws.DwConsolid[] dwConsolids) {
        this.dwConsolids = dwConsolids;
    }

    public idw.idwws.DwConsolid getDwConsolids(int i) {
        return this.dwConsolids[i];
    }

    public void setDwConsolids(int i, idw.idwws.DwConsolid _value) {
        this.dwConsolids[i] = _value;
    }


    /**
     * Gets the dwFolhacics value for this DwFolha.
     * 
     * @return dwFolhacics
     */
    public idw.idwws.DwFolhacic[] getDwFolhacics() {
        return dwFolhacics;
    }


    /**
     * Sets the dwFolhacics value for this DwFolha.
     * 
     * @param dwFolhacics
     */
    public void setDwFolhacics(idw.idwws.DwFolhacic[] dwFolhacics) {
        this.dwFolhacics = dwFolhacics;
    }

    public idw.idwws.DwFolhacic getDwFolhacics(int i) {
        return this.dwFolhacics[i];
    }

    public void setDwFolhacics(int i, idw.idwws.DwFolhacic _value) {
        this.dwFolhacics[i] = _value;
    }


    /**
     * Gets the dwFolhaiacs value for this DwFolha.
     * 
     * @return dwFolhaiacs
     */
    public idw.idwws.DwFolhaiac[] getDwFolhaiacs() {
        return dwFolhaiacs;
    }


    /**
     * Sets the dwFolhaiacs value for this DwFolha.
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
     * Gets the dwFolhamedtemps value for this DwFolha.
     * 
     * @return dwFolhamedtemps
     */
    public idw.idwws.DwFolhamedtemp[] getDwFolhamedtemps() {
        return dwFolhamedtemps;
    }


    /**
     * Sets the dwFolhamedtemps value for this DwFolha.
     * 
     * @param dwFolhamedtemps
     */
    public void setDwFolhamedtemps(idw.idwws.DwFolhamedtemp[] dwFolhamedtemps) {
        this.dwFolhamedtemps = dwFolhamedtemps;
    }

    public idw.idwws.DwFolhamedtemp getDwFolhamedtemps(int i) {
        return this.dwFolhamedtemps[i];
    }

    public void setDwFolhamedtemps(int i, idw.idwws.DwFolhamedtemp _value) {
        this.dwFolhamedtemps[i] = _value;
    }


    /**
     * Gets the dwFolhamons value for this DwFolha.
     * 
     * @return dwFolhamons
     */
    public idw.idwws.DwFolhamon[] getDwFolhamons() {
        return dwFolhamons;
    }


    /**
     * Sets the dwFolhamons value for this DwFolha.
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
     * Gets the dwFolharaps value for this DwFolha.
     * 
     * @return dwFolharaps
     */
    public idw.idwws.DwFolharap[] getDwFolharaps() {
        return dwFolharaps;
    }


    /**
     * Sets the dwFolharaps value for this DwFolha.
     * 
     * @param dwFolharaps
     */
    public void setDwFolharaps(idw.idwws.DwFolharap[] dwFolharaps) {
        this.dwFolharaps = dwFolharaps;
    }

    public idw.idwws.DwFolharap getDwFolharaps(int i) {
        return this.dwFolharaps[i];
    }

    public void setDwFolharaps(int i, idw.idwws.DwFolharap _value) {
        this.dwFolharaps[i] = _value;
    }


    /**
     * Gets the dwFolhasetupsForIdFolhaentrando value for this DwFolha.
     * 
     * @return dwFolhasetupsForIdFolhaentrando
     */
    public idw.idwws.DwFolhasetup[] getDwFolhasetupsForIdFolhaentrando() {
        return dwFolhasetupsForIdFolhaentrando;
    }


    /**
     * Sets the dwFolhasetupsForIdFolhaentrando value for this DwFolha.
     * 
     * @param dwFolhasetupsForIdFolhaentrando
     */
    public void setDwFolhasetupsForIdFolhaentrando(idw.idwws.DwFolhasetup[] dwFolhasetupsForIdFolhaentrando) {
        this.dwFolhasetupsForIdFolhaentrando = dwFolhasetupsForIdFolhaentrando;
    }

    public idw.idwws.DwFolhasetup getDwFolhasetupsForIdFolhaentrando(int i) {
        return this.dwFolhasetupsForIdFolhaentrando[i];
    }

    public void setDwFolhasetupsForIdFolhaentrando(int i, idw.idwws.DwFolhasetup _value) {
        this.dwFolhasetupsForIdFolhaentrando[i] = _value;
    }


    /**
     * Gets the dwFolhasetupsForIdFolhasaindo value for this DwFolha.
     * 
     * @return dwFolhasetupsForIdFolhasaindo
     */
    public idw.idwws.DwFolhasetup[] getDwFolhasetupsForIdFolhasaindo() {
        return dwFolhasetupsForIdFolhasaindo;
    }


    /**
     * Sets the dwFolhasetupsForIdFolhasaindo value for this DwFolha.
     * 
     * @param dwFolhasetupsForIdFolhasaindo
     */
    public void setDwFolhasetupsForIdFolhasaindo(idw.idwws.DwFolhasetup[] dwFolhasetupsForIdFolhasaindo) {
        this.dwFolhasetupsForIdFolhasaindo = dwFolhasetupsForIdFolhasaindo;
    }

    public idw.idwws.DwFolhasetup getDwFolhasetupsForIdFolhasaindo(int i) {
        return this.dwFolhasetupsForIdFolhasaindo[i];
    }

    public void setDwFolhasetupsForIdFolhasaindo(int i, idw.idwws.DwFolhasetup _value) {
        this.dwFolhasetupsForIdFolhasaindo[i] = _value;
    }


    /**
     * Gets the dwFolhatestes value for this DwFolha.
     * 
     * @return dwFolhatestes
     */
    public idw.idwws.DwFolhateste[] getDwFolhatestes() {
        return dwFolhatestes;
    }


    /**
     * Sets the dwFolhatestes value for this DwFolha.
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
     * Gets the dwFolhatvs value for this DwFolha.
     * 
     * @return dwFolhatvs
     */
    public idw.idwws.DwFolhatv[] getDwFolhatvs() {
        return dwFolhatvs;
    }


    /**
     * Sets the dwFolhatvs value for this DwFolha.
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
     * Gets the dwProcedimento value for this DwFolha.
     * 
     * @return dwProcedimento
     */
    public idw.idwws.DwProcedimento getDwProcedimento() {
        return dwProcedimento;
    }


    /**
     * Sets the dwProcedimento value for this DwFolha.
     * 
     * @param dwProcedimento
     */
    public void setDwProcedimento(idw.idwws.DwProcedimento dwProcedimento) {
        this.dwProcedimento = dwProcedimento;
    }


    /**
     * Gets the dwRotapassos value for this DwFolha.
     * 
     * @return dwRotapassos
     */
    public idw.idwws.DwRotapasso[] getDwRotapassos() {
        return dwRotapassos;
    }


    /**
     * Sets the dwRotapassos value for this DwFolha.
     * 
     * @param dwRotapassos
     */
    public void setDwRotapassos(idw.idwws.DwRotapasso[] dwRotapassos) {
        this.dwRotapassos = dwRotapassos;
    }

    public idw.idwws.DwRotapasso getDwRotapassos(int i) {
        return this.dwRotapassos[i];
    }

    public void setDwRotapassos(int i, idw.idwws.DwRotapasso _value) {
        this.dwRotapassos[i] = _value;
    }


    /**
     * Gets the idFolha value for this DwFolha.
     * 
     * @return idFolha
     */
    public java.lang.Long getIdFolha() {
        return idFolha;
    }


    /**
     * Sets the idFolha value for this DwFolha.
     * 
     * @param idFolha
     */
    public void setIdFolha(java.lang.Long idFolha) {
        this.idFolha = idFolha;
    }


    /**
     * Gets the isLogonobrigatorio value for this DwFolha.
     * 
     * @return isLogonobrigatorio
     */
    public java.lang.Boolean getIsLogonobrigatorio() {
        return isLogonobrigatorio;
    }


    /**
     * Sets the isLogonobrigatorio value for this DwFolha.
     * 
     * @param isLogonobrigatorio
     */
    public void setIsLogonobrigatorio(java.lang.Boolean isLogonobrigatorio) {
        this.isLogonobrigatorio = isLogonobrigatorio;
    }


    /**
     * Gets the isModelo value for this DwFolha.
     * 
     * @return isModelo
     */
    public java.lang.Boolean getIsModelo() {
        return isModelo;
    }


    /**
     * Sets the isModelo value for this DwFolha.
     * 
     * @param isModelo
     */
    public void setIsModelo(java.lang.Boolean isModelo) {
        this.isModelo = isModelo;
    }


    /**
     * Gets the msTriggers value for this DwFolha.
     * 
     * @return msTriggers
     */
    public idw.idwws.MsTrigger[] getMsTriggers() {
        return msTriggers;
    }


    /**
     * Sets the msTriggers value for this DwFolha.
     * 
     * @param msTriggers
     */
    public void setMsTriggers(idw.idwws.MsTrigger[] msTriggers) {
        this.msTriggers = msTriggers;
    }

    public idw.idwws.MsTrigger getMsTriggers(int i) {
        return this.msTriggers[i];
    }

    public void setMsTriggers(int i, idw.idwws.MsTrigger _value) {
        this.msTriggers[i] = _value;
    }


    /**
     * Gets the omGt value for this DwFolha.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this DwFolha.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omObjsForIdFolha value for this DwFolha.
     * 
     * @return omObjsForIdFolha
     */
    public idw.idwws.OmObj[] getOmObjsForIdFolha() {
        return omObjsForIdFolha;
    }


    /**
     * Sets the omObjsForIdFolha value for this DwFolha.
     * 
     * @param omObjsForIdFolha
     */
    public void setOmObjsForIdFolha(idw.idwws.OmObj[] omObjsForIdFolha) {
        this.omObjsForIdFolha = omObjsForIdFolha;
    }

    public idw.idwws.OmObj getOmObjsForIdFolha(int i) {
        return this.omObjsForIdFolha[i];
    }

    public void setOmObjsForIdFolha(int i, idw.idwws.OmObj _value) {
        this.omObjsForIdFolha[i] = _value;
    }


    /**
     * Gets the omPt value for this DwFolha.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwFolha.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omPts value for this DwFolha.
     * 
     * @return omPts
     */
    public idw.idwws.OmPt[] getOmPts() {
        return omPts;
    }


    /**
     * Sets the omPts value for this DwFolha.
     * 
     * @param omPts
     */
    public void setOmPts(idw.idwws.OmPt[] omPts) {
        this.omPts = omPts;
    }

    public idw.idwws.OmPt getOmPts(int i) {
        return this.omPts[i];
    }

    public void setOmPts(int i, idw.idwws.OmPt _value) {
        this.omPts[i] = _value;
    }


    /**
     * Gets the omTppt value for this DwFolha.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this DwFolha.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwFolha.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwFolha.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwFolha.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwFolha.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppCps value for this DwFolha.
     * 
     * @return ppCps
     */
    public idw.idwws.PpCp[] getPpCps() {
        return ppCps;
    }


    /**
     * Sets the ppCps value for this DwFolha.
     * 
     * @param ppCps
     */
    public void setPpCps(idw.idwws.PpCp[] ppCps) {
        this.ppCps = ppCps;
    }

    public idw.idwws.PpCp getPpCps(int i) {
        return this.ppCps[i];
    }

    public void setPpCps(int i, idw.idwws.PpCp _value) {
        this.ppCps[i] = _value;
    }


    /**
     * Gets the revisao value for this DwFolha.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwFolha.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the segCiclominimo value for this DwFolha.
     * 
     * @return segCiclominimo
     */
    public java.math.BigDecimal getSegCiclominimo() {
        return segCiclominimo;
    }


    /**
     * Sets the segCiclominimo value for this DwFolha.
     * 
     * @param segCiclominimo
     */
    public void setSegCiclominimo(java.math.BigDecimal segCiclominimo) {
        this.segCiclominimo = segCiclominimo;
    }


    /**
     * Gets the segCiclopadrao value for this DwFolha.
     * 
     * @return segCiclopadrao
     */
    public java.math.BigDecimal getSegCiclopadrao() {
        return segCiclopadrao;
    }


    /**
     * Sets the segCiclopadrao value for this DwFolha.
     * 
     * @param segCiclopadrao
     */
    public void setSegCiclopadrao(java.math.BigDecimal segCiclopadrao) {
        this.segCiclopadrao = segCiclopadrao;
    }


    /**
     * Gets the segCiclotimeout value for this DwFolha.
     * 
     * @return segCiclotimeout
     */
    public java.math.BigDecimal getSegCiclotimeout() {
        return segCiclotimeout;
    }


    /**
     * Sets the segCiclotimeout value for this DwFolha.
     * 
     * @param segCiclotimeout
     */
    public void setSegCiclotimeout(java.math.BigDecimal segCiclotimeout) {
        this.segCiclotimeout = segCiclotimeout;
    }


    /**
     * Gets the segLogoutauto value for this DwFolha.
     * 
     * @return segLogoutauto
     */
    public java.math.BigDecimal getSegLogoutauto() {
        return segLogoutauto;
    }


    /**
     * Sets the segLogoutauto value for this DwFolha.
     * 
     * @param segLogoutauto
     */
    public void setSegLogoutauto(java.math.BigDecimal segLogoutauto) {
        this.segLogoutauto = segLogoutauto;
    }


    /**
     * Gets the segSetup value for this DwFolha.
     * 
     * @return segSetup
     */
    public java.lang.Integer getSegSetup() {
        return segSetup;
    }


    /**
     * Sets the segSetup value for this DwFolha.
     * 
     * @param segSetup
     */
    public void setSegSetup(java.lang.Integer segSetup) {
        this.segSetup = segSetup;
    }


    /**
     * Gets the stAtivo value for this DwFolha.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwFolha.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpFolha value for this DwFolha.
     * 
     * @return tpFolha
     */
    public java.lang.Byte getTpFolha() {
        return tpFolha;
    }


    /**
     * Sets the tpFolha value for this DwFolha.
     * 
     * @param tpFolha
     */
    public void setTpFolha(java.lang.Byte tpFolha) {
        this.tpFolha = tpFolha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolha)) return false;
        DwFolha other = (DwFolha) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdFolha==null && other.getCdFolha()==null) || 
             (this.cdFolha!=null &&
              this.cdFolha.equals(other.getCdFolha()))) &&
            ((this.dsFolha==null && other.getDsFolha()==null) || 
             (this.dsFolha!=null &&
              this.dsFolha.equals(other.getDsFolha()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwConsolids==null && other.getDwConsolids()==null) || 
             (this.dwConsolids!=null &&
              java.util.Arrays.equals(this.dwConsolids, other.getDwConsolids()))) &&
            ((this.dwFolhacics==null && other.getDwFolhacics()==null) || 
             (this.dwFolhacics!=null &&
              java.util.Arrays.equals(this.dwFolhacics, other.getDwFolhacics()))) &&
            ((this.dwFolhaiacs==null && other.getDwFolhaiacs()==null) || 
             (this.dwFolhaiacs!=null &&
              java.util.Arrays.equals(this.dwFolhaiacs, other.getDwFolhaiacs()))) &&
            ((this.dwFolhamedtemps==null && other.getDwFolhamedtemps()==null) || 
             (this.dwFolhamedtemps!=null &&
              java.util.Arrays.equals(this.dwFolhamedtemps, other.getDwFolhamedtemps()))) &&
            ((this.dwFolhamons==null && other.getDwFolhamons()==null) || 
             (this.dwFolhamons!=null &&
              java.util.Arrays.equals(this.dwFolhamons, other.getDwFolhamons()))) &&
            ((this.dwFolharaps==null && other.getDwFolharaps()==null) || 
             (this.dwFolharaps!=null &&
              java.util.Arrays.equals(this.dwFolharaps, other.getDwFolharaps()))) &&
            ((this.dwFolhasetupsForIdFolhaentrando==null && other.getDwFolhasetupsForIdFolhaentrando()==null) || 
             (this.dwFolhasetupsForIdFolhaentrando!=null &&
              java.util.Arrays.equals(this.dwFolhasetupsForIdFolhaentrando, other.getDwFolhasetupsForIdFolhaentrando()))) &&
            ((this.dwFolhasetupsForIdFolhasaindo==null && other.getDwFolhasetupsForIdFolhasaindo()==null) || 
             (this.dwFolhasetupsForIdFolhasaindo!=null &&
              java.util.Arrays.equals(this.dwFolhasetupsForIdFolhasaindo, other.getDwFolhasetupsForIdFolhasaindo()))) &&
            ((this.dwFolhatestes==null && other.getDwFolhatestes()==null) || 
             (this.dwFolhatestes!=null &&
              java.util.Arrays.equals(this.dwFolhatestes, other.getDwFolhatestes()))) &&
            ((this.dwFolhatvs==null && other.getDwFolhatvs()==null) || 
             (this.dwFolhatvs!=null &&
              java.util.Arrays.equals(this.dwFolhatvs, other.getDwFolhatvs()))) &&
            ((this.dwProcedimento==null && other.getDwProcedimento()==null) || 
             (this.dwProcedimento!=null &&
              this.dwProcedimento.equals(other.getDwProcedimento()))) &&
            ((this.dwRotapassos==null && other.getDwRotapassos()==null) || 
             (this.dwRotapassos!=null &&
              java.util.Arrays.equals(this.dwRotapassos, other.getDwRotapassos()))) &&
            ((this.idFolha==null && other.getIdFolha()==null) || 
             (this.idFolha!=null &&
              this.idFolha.equals(other.getIdFolha()))) &&
            ((this.isLogonobrigatorio==null && other.getIsLogonobrigatorio()==null) || 
             (this.isLogonobrigatorio!=null &&
              this.isLogonobrigatorio.equals(other.getIsLogonobrigatorio()))) &&
            ((this.isModelo==null && other.getIsModelo()==null) || 
             (this.isModelo!=null &&
              this.isModelo.equals(other.getIsModelo()))) &&
            ((this.msTriggers==null && other.getMsTriggers()==null) || 
             (this.msTriggers!=null &&
              java.util.Arrays.equals(this.msTriggers, other.getMsTriggers()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omObjsForIdFolha==null && other.getOmObjsForIdFolha()==null) || 
             (this.omObjsForIdFolha!=null &&
              java.util.Arrays.equals(this.omObjsForIdFolha, other.getOmObjsForIdFolha()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omPts==null && other.getOmPts()==null) || 
             (this.omPts!=null &&
              java.util.Arrays.equals(this.omPts, other.getOmPts()))) &&
            ((this.omTppt==null && other.getOmTppt()==null) || 
             (this.omTppt!=null &&
              this.omTppt.equals(other.getOmTppt()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppCps==null && other.getPpCps()==null) || 
             (this.ppCps!=null &&
              java.util.Arrays.equals(this.ppCps, other.getPpCps()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.segCiclominimo==null && other.getSegCiclominimo()==null) || 
             (this.segCiclominimo!=null &&
              this.segCiclominimo.equals(other.getSegCiclominimo()))) &&
            ((this.segCiclopadrao==null && other.getSegCiclopadrao()==null) || 
             (this.segCiclopadrao!=null &&
              this.segCiclopadrao.equals(other.getSegCiclopadrao()))) &&
            ((this.segCiclotimeout==null && other.getSegCiclotimeout()==null) || 
             (this.segCiclotimeout!=null &&
              this.segCiclotimeout.equals(other.getSegCiclotimeout()))) &&
            ((this.segLogoutauto==null && other.getSegLogoutauto()==null) || 
             (this.segLogoutauto!=null &&
              this.segLogoutauto.equals(other.getSegLogoutauto()))) &&
            ((this.segSetup==null && other.getSegSetup()==null) || 
             (this.segSetup!=null &&
              this.segSetup.equals(other.getSegSetup()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpFolha==null && other.getTpFolha()==null) || 
             (this.tpFolha!=null &&
              this.tpFolha.equals(other.getTpFolha())));
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
        if (getCdFolha() != null) {
            _hashCode += getCdFolha().hashCode();
        }
        if (getDsFolha() != null) {
            _hashCode += getDsFolha().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwConsolids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhacics() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhacics());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhacics(), i);
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
        if (getDwFolhamedtemps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhamedtemps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhamedtemps(), i);
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
        if (getDwFolharaps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolharaps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolharaps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhasetupsForIdFolhaentrando() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhasetupsForIdFolhaentrando());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhasetupsForIdFolhaentrando(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolhasetupsForIdFolhasaindo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhasetupsForIdFolhasaindo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhasetupsForIdFolhasaindo(), i);
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
        if (getDwProcedimento() != null) {
            _hashCode += getDwProcedimento().hashCode();
        }
        if (getDwRotapassos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotapassos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotapassos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdFolha() != null) {
            _hashCode += getIdFolha().hashCode();
        }
        if (getIsLogonobrigatorio() != null) {
            _hashCode += getIsLogonobrigatorio().hashCode();
        }
        if (getIsModelo() != null) {
            _hashCode += getIsModelo().hashCode();
        }
        if (getMsTriggers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsTriggers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsTriggers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmObjsForIdFolha() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjsForIdFolha());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjsForIdFolha(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmPts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmTppt() != null) {
            _hashCode += getOmTppt().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpCps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSegCiclominimo() != null) {
            _hashCode += getSegCiclominimo().hashCode();
        }
        if (getSegCiclopadrao() != null) {
            _hashCode += getSegCiclopadrao().hashCode();
        }
        if (getSegCiclotimeout() != null) {
            _hashCode += getSegCiclotimeout().hashCode();
        }
        if (getSegLogoutauto() != null) {
            _hashCode += getSegLogoutauto().hashCode();
        }
        if (getSegSetup() != null) {
            _hashCode += getSegSetup().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpFolha() != null) {
            _hashCode += getTpFolha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolha.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsFolha"));
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
        elemField.setFieldName("dwConsolids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhacics");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhacics"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhacic"));
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
        elemField.setFieldName("dwFolhamedtemps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamedtemps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemp"));
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
        elemField.setFieldName("dwFolharaps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolharaps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolharap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhasetupsForIdFolhaentrando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhasetupsForIdFolhaentrando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhasetup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhasetupsForIdFolhasaindo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhasetupsForIdFolhasaindo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhasetup"));
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
        elemField.setFieldName("dwProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcedimento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("isModelo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isModelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msTriggers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msTriggers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msTrigger"));
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
        elemField.setFieldName("omObjsForIdFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjsForIdFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTppt"));
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
        elemField.setFieldName("ppCps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
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
        elemField.setFieldName("segCiclominimo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCiclominimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCiclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCiclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCiclotimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCiclotimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segLogoutauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segLogoutauto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segSetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segSetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("tpFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
