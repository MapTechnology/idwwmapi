/**
 * OmPt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmPt  extends idw.idwws.OmPtTemplate  implements java.io.Serializable {
    private java.lang.String cdPt;

    private java.lang.String depara;

    private java.lang.String dsCurta;

    private java.lang.String dsPt;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwCalpt[] dwCalpts;

    private idw.idwws.DwConsolatlog[] dwConsolatlogs;

    private idw.idwws.DwConsolid[] dwConsolids;

    private idw.idwws.DwConsolmolog[] dwConsolmologs;

    private idw.idwws.DwConsolpalog[] dwConsolpalogs;

    private idw.idwws.DwConsolpt[] dwConsolpts;

    private idw.idwws.DwExpcvs[] dwExpcvses;

    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwOperacao[] dwOperacaos;

    private idw.idwws.DwPassagem[] dwPassagems;

    private idw.idwws.DwRotapassoPt[] dwRotapassoPts;

    private idw.idwws.DwRotapasso[] dwRotapassos;

    private idw.idwws.DwRt[] dwRts;

    private java.lang.Integer estagio;

    private java.lang.Long idPt;

    private java.math.BigDecimal indOee;

    private java.lang.Boolean isAlimcorexc;

    private java.lang.Boolean isApongt;

    private java.lang.Boolean isPlangt;

    private idw.idwws.MsTrigger[] msTriggers;

    private idw.idwws.OmAlim omAlimByIdAlim;

    private idw.idwws.OmAlim omAlimByIdAlimcorrente;

    private idw.idwws.OmAlim omAlimByIdAlimpre;

    private idw.idwws.OmCc omCc;

    private idw.idwws.OmCfgptdetcoleta[] omCfgptdetcoletas;

    private idw.idwws.OmClp omClp;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmHomopt[] omHomopts;

    private idw.idwws.OmIndpt[] omIndpts;

    private idw.idwws.OmMapa[] omMapas;

    private idw.idwws.OmObj[] omObjs;

    private idw.idwws.OmPapro[] omPapros;

    private idw.idwws.OmPa[] omPas;

    private idw.idwws.OmPrg[] omPrgs;

    private idw.idwws.OmTppt omTppt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpCp[] ppCps;

    private idw.idwws.PpIndispRappt[] ppIndispRappts;

    private idw.idwws.PpPlanptgt[] ppPlanptgts;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    private java.lang.Byte tpImpprog;

    private java.lang.String urlConexao;

    public OmPt() {
    }

    public OmPt(
           java.lang.Long id,
           java.lang.String cdPt,
           java.lang.String depara,
           java.lang.String dsCurta,
           java.lang.String dsPt,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwCalpt[] dwCalpts,
           idw.idwws.DwConsolatlog[] dwConsolatlogs,
           idw.idwws.DwConsolid[] dwConsolids,
           idw.idwws.DwConsolmolog[] dwConsolmologs,
           idw.idwws.DwConsolpalog[] dwConsolpalogs,
           idw.idwws.DwConsolpt[] dwConsolpts,
           idw.idwws.DwExpcvs[] dwExpcvses,
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwOperacao[] dwOperacaos,
           idw.idwws.DwPassagem[] dwPassagems,
           idw.idwws.DwRotapassoPt[] dwRotapassoPts,
           idw.idwws.DwRotapasso[] dwRotapassos,
           idw.idwws.DwRt[] dwRts,
           java.lang.Integer estagio,
           java.lang.Long idPt,
           java.math.BigDecimal indOee,
           java.lang.Boolean isAlimcorexc,
           java.lang.Boolean isApongt,
           java.lang.Boolean isPlangt,
           idw.idwws.MsTrigger[] msTriggers,
           idw.idwws.OmAlim omAlimByIdAlim,
           idw.idwws.OmAlim omAlimByIdAlimcorrente,
           idw.idwws.OmAlim omAlimByIdAlimpre,
           idw.idwws.OmCc omCc,
           idw.idwws.OmCfgptdetcoleta[] omCfgptdetcoletas,
           idw.idwws.OmClp omClp,
           idw.idwws.OmGt omGt,
           idw.idwws.OmHomopt[] omHomopts,
           idw.idwws.OmIndpt[] omIndpts,
           idw.idwws.OmMapa[] omMapas,
           idw.idwws.OmObj[] omObjs,
           idw.idwws.OmPapro[] omPapros,
           idw.idwws.OmPa[] omPas,
           idw.idwws.OmPrg[] omPrgs,
           idw.idwws.OmTppt omTppt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCp[] ppCps,
           idw.idwws.PpIndispRappt[] ppIndispRappts,
           idw.idwws.PpPlanptgt[] ppPlanptgts,
           java.lang.Long revisao,
           java.lang.Byte stAtivo,
           java.lang.Byte tpImpprog,
           java.lang.String urlConexao) {
        super(
            id);
        this.cdPt = cdPt;
        this.depara = depara;
        this.dsCurta = dsCurta;
        this.dsPt = dsPt;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwCalpts = dwCalpts;
        this.dwConsolatlogs = dwConsolatlogs;
        this.dwConsolids = dwConsolids;
        this.dwConsolmologs = dwConsolmologs;
        this.dwConsolpalogs = dwConsolpalogs;
        this.dwConsolpts = dwConsolpts;
        this.dwExpcvses = dwExpcvses;
        this.dwFolha = dwFolha;
        this.dwOperacaos = dwOperacaos;
        this.dwPassagems = dwPassagems;
        this.dwRotapassoPts = dwRotapassoPts;
        this.dwRotapassos = dwRotapassos;
        this.dwRts = dwRts;
        this.estagio = estagio;
        this.idPt = idPt;
        this.indOee = indOee;
        this.isAlimcorexc = isAlimcorexc;
        this.isApongt = isApongt;
        this.isPlangt = isPlangt;
        this.msTriggers = msTriggers;
        this.omAlimByIdAlim = omAlimByIdAlim;
        this.omAlimByIdAlimcorrente = omAlimByIdAlimcorrente;
        this.omAlimByIdAlimpre = omAlimByIdAlimpre;
        this.omCc = omCc;
        this.omCfgptdetcoletas = omCfgptdetcoletas;
        this.omClp = omClp;
        this.omGt = omGt;
        this.omHomopts = omHomopts;
        this.omIndpts = omIndpts;
        this.omMapas = omMapas;
        this.omObjs = omObjs;
        this.omPapros = omPapros;
        this.omPas = omPas;
        this.omPrgs = omPrgs;
        this.omTppt = omTppt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppCps = ppCps;
        this.ppIndispRappts = ppIndispRappts;
        this.ppPlanptgts = ppPlanptgts;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.tpImpprog = tpImpprog;
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the cdPt value for this OmPt.
     * 
     * @return cdPt
     */
    public java.lang.String getCdPt() {
        return cdPt;
    }


    /**
     * Sets the cdPt value for this OmPt.
     * 
     * @param cdPt
     */
    public void setCdPt(java.lang.String cdPt) {
        this.cdPt = cdPt;
    }


    /**
     * Gets the depara value for this OmPt.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this OmPt.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the dsCurta value for this OmPt.
     * 
     * @return dsCurta
     */
    public java.lang.String getDsCurta() {
        return dsCurta;
    }


    /**
     * Sets the dsCurta value for this OmPt.
     * 
     * @param dsCurta
     */
    public void setDsCurta(java.lang.String dsCurta) {
        this.dsCurta = dsCurta;
    }


    /**
     * Gets the dsPt value for this OmPt.
     * 
     * @return dsPt
     */
    public java.lang.String getDsPt() {
        return dsPt;
    }


    /**
     * Sets the dsPt value for this OmPt.
     * 
     * @param dsPt
     */
    public void setDsPt(java.lang.String dsPt) {
        this.dsPt = dsPt;
    }


    /**
     * Gets the dtRevisao value for this OmPt.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmPt.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmPt.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmPt.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwCalpts value for this OmPt.
     * 
     * @return dwCalpts
     */
    public idw.idwws.DwCalpt[] getDwCalpts() {
        return dwCalpts;
    }


    /**
     * Sets the dwCalpts value for this OmPt.
     * 
     * @param dwCalpts
     */
    public void setDwCalpts(idw.idwws.DwCalpt[] dwCalpts) {
        this.dwCalpts = dwCalpts;
    }

    public idw.idwws.DwCalpt getDwCalpts(int i) {
        return this.dwCalpts[i];
    }

    public void setDwCalpts(int i, idw.idwws.DwCalpt _value) {
        this.dwCalpts[i] = _value;
    }


    /**
     * Gets the dwConsolatlogs value for this OmPt.
     * 
     * @return dwConsolatlogs
     */
    public idw.idwws.DwConsolatlog[] getDwConsolatlogs() {
        return dwConsolatlogs;
    }


    /**
     * Sets the dwConsolatlogs value for this OmPt.
     * 
     * @param dwConsolatlogs
     */
    public void setDwConsolatlogs(idw.idwws.DwConsolatlog[] dwConsolatlogs) {
        this.dwConsolatlogs = dwConsolatlogs;
    }

    public idw.idwws.DwConsolatlog getDwConsolatlogs(int i) {
        return this.dwConsolatlogs[i];
    }

    public void setDwConsolatlogs(int i, idw.idwws.DwConsolatlog _value) {
        this.dwConsolatlogs[i] = _value;
    }


    /**
     * Gets the dwConsolids value for this OmPt.
     * 
     * @return dwConsolids
     */
    public idw.idwws.DwConsolid[] getDwConsolids() {
        return dwConsolids;
    }


    /**
     * Sets the dwConsolids value for this OmPt.
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
     * Gets the dwConsolmologs value for this OmPt.
     * 
     * @return dwConsolmologs
     */
    public idw.idwws.DwConsolmolog[] getDwConsolmologs() {
        return dwConsolmologs;
    }


    /**
     * Sets the dwConsolmologs value for this OmPt.
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
     * Gets the dwConsolpalogs value for this OmPt.
     * 
     * @return dwConsolpalogs
     */
    public idw.idwws.DwConsolpalog[] getDwConsolpalogs() {
        return dwConsolpalogs;
    }


    /**
     * Sets the dwConsolpalogs value for this OmPt.
     * 
     * @param dwConsolpalogs
     */
    public void setDwConsolpalogs(idw.idwws.DwConsolpalog[] dwConsolpalogs) {
        this.dwConsolpalogs = dwConsolpalogs;
    }

    public idw.idwws.DwConsolpalog getDwConsolpalogs(int i) {
        return this.dwConsolpalogs[i];
    }

    public void setDwConsolpalogs(int i, idw.idwws.DwConsolpalog _value) {
        this.dwConsolpalogs[i] = _value;
    }


    /**
     * Gets the dwConsolpts value for this OmPt.
     * 
     * @return dwConsolpts
     */
    public idw.idwws.DwConsolpt[] getDwConsolpts() {
        return dwConsolpts;
    }


    /**
     * Sets the dwConsolpts value for this OmPt.
     * 
     * @param dwConsolpts
     */
    public void setDwConsolpts(idw.idwws.DwConsolpt[] dwConsolpts) {
        this.dwConsolpts = dwConsolpts;
    }

    public idw.idwws.DwConsolpt getDwConsolpts(int i) {
        return this.dwConsolpts[i];
    }

    public void setDwConsolpts(int i, idw.idwws.DwConsolpt _value) {
        this.dwConsolpts[i] = _value;
    }


    /**
     * Gets the dwExpcvses value for this OmPt.
     * 
     * @return dwExpcvses
     */
    public idw.idwws.DwExpcvs[] getDwExpcvses() {
        return dwExpcvses;
    }


    /**
     * Sets the dwExpcvses value for this OmPt.
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
     * Gets the dwFolha value for this OmPt.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this OmPt.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwOperacaos value for this OmPt.
     * 
     * @return dwOperacaos
     */
    public idw.idwws.DwOperacao[] getDwOperacaos() {
        return dwOperacaos;
    }


    /**
     * Sets the dwOperacaos value for this OmPt.
     * 
     * @param dwOperacaos
     */
    public void setDwOperacaos(idw.idwws.DwOperacao[] dwOperacaos) {
        this.dwOperacaos = dwOperacaos;
    }

    public idw.idwws.DwOperacao getDwOperacaos(int i) {
        return this.dwOperacaos[i];
    }

    public void setDwOperacaos(int i, idw.idwws.DwOperacao _value) {
        this.dwOperacaos[i] = _value;
    }


    /**
     * Gets the dwPassagems value for this OmPt.
     * 
     * @return dwPassagems
     */
    public idw.idwws.DwPassagem[] getDwPassagems() {
        return dwPassagems;
    }


    /**
     * Sets the dwPassagems value for this OmPt.
     * 
     * @param dwPassagems
     */
    public void setDwPassagems(idw.idwws.DwPassagem[] dwPassagems) {
        this.dwPassagems = dwPassagems;
    }

    public idw.idwws.DwPassagem getDwPassagems(int i) {
        return this.dwPassagems[i];
    }

    public void setDwPassagems(int i, idw.idwws.DwPassagem _value) {
        this.dwPassagems[i] = _value;
    }


    /**
     * Gets the dwRotapassoPts value for this OmPt.
     * 
     * @return dwRotapassoPts
     */
    public idw.idwws.DwRotapassoPt[] getDwRotapassoPts() {
        return dwRotapassoPts;
    }


    /**
     * Sets the dwRotapassoPts value for this OmPt.
     * 
     * @param dwRotapassoPts
     */
    public void setDwRotapassoPts(idw.idwws.DwRotapassoPt[] dwRotapassoPts) {
        this.dwRotapassoPts = dwRotapassoPts;
    }

    public idw.idwws.DwRotapassoPt getDwRotapassoPts(int i) {
        return this.dwRotapassoPts[i];
    }

    public void setDwRotapassoPts(int i, idw.idwws.DwRotapassoPt _value) {
        this.dwRotapassoPts[i] = _value;
    }


    /**
     * Gets the dwRotapassos value for this OmPt.
     * 
     * @return dwRotapassos
     */
    public idw.idwws.DwRotapasso[] getDwRotapassos() {
        return dwRotapassos;
    }


    /**
     * Sets the dwRotapassos value for this OmPt.
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
     * Gets the dwRts value for this OmPt.
     * 
     * @return dwRts
     */
    public idw.idwws.DwRt[] getDwRts() {
        return dwRts;
    }


    /**
     * Sets the dwRts value for this OmPt.
     * 
     * @param dwRts
     */
    public void setDwRts(idw.idwws.DwRt[] dwRts) {
        this.dwRts = dwRts;
    }

    public idw.idwws.DwRt getDwRts(int i) {
        return this.dwRts[i];
    }

    public void setDwRts(int i, idw.idwws.DwRt _value) {
        this.dwRts[i] = _value;
    }


    /**
     * Gets the estagio value for this OmPt.
     * 
     * @return estagio
     */
    public java.lang.Integer getEstagio() {
        return estagio;
    }


    /**
     * Sets the estagio value for this OmPt.
     * 
     * @param estagio
     */
    public void setEstagio(java.lang.Integer estagio) {
        this.estagio = estagio;
    }


    /**
     * Gets the idPt value for this OmPt.
     * 
     * @return idPt
     */
    public java.lang.Long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this OmPt.
     * 
     * @param idPt
     */
    public void setIdPt(java.lang.Long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the indOee value for this OmPt.
     * 
     * @return indOee
     */
    public java.math.BigDecimal getIndOee() {
        return indOee;
    }


    /**
     * Sets the indOee value for this OmPt.
     * 
     * @param indOee
     */
    public void setIndOee(java.math.BigDecimal indOee) {
        this.indOee = indOee;
    }


    /**
     * Gets the isAlimcorexc value for this OmPt.
     * 
     * @return isAlimcorexc
     */
    public java.lang.Boolean getIsAlimcorexc() {
        return isAlimcorexc;
    }


    /**
     * Sets the isAlimcorexc value for this OmPt.
     * 
     * @param isAlimcorexc
     */
    public void setIsAlimcorexc(java.lang.Boolean isAlimcorexc) {
        this.isAlimcorexc = isAlimcorexc;
    }


    /**
     * Gets the isApongt value for this OmPt.
     * 
     * @return isApongt
     */
    public java.lang.Boolean getIsApongt() {
        return isApongt;
    }


    /**
     * Sets the isApongt value for this OmPt.
     * 
     * @param isApongt
     */
    public void setIsApongt(java.lang.Boolean isApongt) {
        this.isApongt = isApongt;
    }


    /**
     * Gets the isPlangt value for this OmPt.
     * 
     * @return isPlangt
     */
    public java.lang.Boolean getIsPlangt() {
        return isPlangt;
    }


    /**
     * Sets the isPlangt value for this OmPt.
     * 
     * @param isPlangt
     */
    public void setIsPlangt(java.lang.Boolean isPlangt) {
        this.isPlangt = isPlangt;
    }


    /**
     * Gets the msTriggers value for this OmPt.
     * 
     * @return msTriggers
     */
    public idw.idwws.MsTrigger[] getMsTriggers() {
        return msTriggers;
    }


    /**
     * Sets the msTriggers value for this OmPt.
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
     * Gets the omAlimByIdAlim value for this OmPt.
     * 
     * @return omAlimByIdAlim
     */
    public idw.idwws.OmAlim getOmAlimByIdAlim() {
        return omAlimByIdAlim;
    }


    /**
     * Sets the omAlimByIdAlim value for this OmPt.
     * 
     * @param omAlimByIdAlim
     */
    public void setOmAlimByIdAlim(idw.idwws.OmAlim omAlimByIdAlim) {
        this.omAlimByIdAlim = omAlimByIdAlim;
    }


    /**
     * Gets the omAlimByIdAlimcorrente value for this OmPt.
     * 
     * @return omAlimByIdAlimcorrente
     */
    public idw.idwws.OmAlim getOmAlimByIdAlimcorrente() {
        return omAlimByIdAlimcorrente;
    }


    /**
     * Sets the omAlimByIdAlimcorrente value for this OmPt.
     * 
     * @param omAlimByIdAlimcorrente
     */
    public void setOmAlimByIdAlimcorrente(idw.idwws.OmAlim omAlimByIdAlimcorrente) {
        this.omAlimByIdAlimcorrente = omAlimByIdAlimcorrente;
    }


    /**
     * Gets the omAlimByIdAlimpre value for this OmPt.
     * 
     * @return omAlimByIdAlimpre
     */
    public idw.idwws.OmAlim getOmAlimByIdAlimpre() {
        return omAlimByIdAlimpre;
    }


    /**
     * Sets the omAlimByIdAlimpre value for this OmPt.
     * 
     * @param omAlimByIdAlimpre
     */
    public void setOmAlimByIdAlimpre(idw.idwws.OmAlim omAlimByIdAlimpre) {
        this.omAlimByIdAlimpre = omAlimByIdAlimpre;
    }


    /**
     * Gets the omCc value for this OmPt.
     * 
     * @return omCc
     */
    public idw.idwws.OmCc getOmCc() {
        return omCc;
    }


    /**
     * Sets the omCc value for this OmPt.
     * 
     * @param omCc
     */
    public void setOmCc(idw.idwws.OmCc omCc) {
        this.omCc = omCc;
    }


    /**
     * Gets the omCfgptdetcoletas value for this OmPt.
     * 
     * @return omCfgptdetcoletas
     */
    public idw.idwws.OmCfgptdetcoleta[] getOmCfgptdetcoletas() {
        return omCfgptdetcoletas;
    }


    /**
     * Sets the omCfgptdetcoletas value for this OmPt.
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
     * Gets the omClp value for this OmPt.
     * 
     * @return omClp
     */
    public idw.idwws.OmClp getOmClp() {
        return omClp;
    }


    /**
     * Sets the omClp value for this OmPt.
     * 
     * @param omClp
     */
    public void setOmClp(idw.idwws.OmClp omClp) {
        this.omClp = omClp;
    }


    /**
     * Gets the omGt value for this OmPt.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this OmPt.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omHomopts value for this OmPt.
     * 
     * @return omHomopts
     */
    public idw.idwws.OmHomopt[] getOmHomopts() {
        return omHomopts;
    }


    /**
     * Sets the omHomopts value for this OmPt.
     * 
     * @param omHomopts
     */
    public void setOmHomopts(idw.idwws.OmHomopt[] omHomopts) {
        this.omHomopts = omHomopts;
    }

    public idw.idwws.OmHomopt getOmHomopts(int i) {
        return this.omHomopts[i];
    }

    public void setOmHomopts(int i, idw.idwws.OmHomopt _value) {
        this.omHomopts[i] = _value;
    }


    /**
     * Gets the omIndpts value for this OmPt.
     * 
     * @return omIndpts
     */
    public idw.idwws.OmIndpt[] getOmIndpts() {
        return omIndpts;
    }


    /**
     * Sets the omIndpts value for this OmPt.
     * 
     * @param omIndpts
     */
    public void setOmIndpts(idw.idwws.OmIndpt[] omIndpts) {
        this.omIndpts = omIndpts;
    }

    public idw.idwws.OmIndpt getOmIndpts(int i) {
        return this.omIndpts[i];
    }

    public void setOmIndpts(int i, idw.idwws.OmIndpt _value) {
        this.omIndpts[i] = _value;
    }


    /**
     * Gets the omMapas value for this OmPt.
     * 
     * @return omMapas
     */
    public idw.idwws.OmMapa[] getOmMapas() {
        return omMapas;
    }


    /**
     * Sets the omMapas value for this OmPt.
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
     * Gets the omObjs value for this OmPt.
     * 
     * @return omObjs
     */
    public idw.idwws.OmObj[] getOmObjs() {
        return omObjs;
    }


    /**
     * Sets the omObjs value for this OmPt.
     * 
     * @param omObjs
     */
    public void setOmObjs(idw.idwws.OmObj[] omObjs) {
        this.omObjs = omObjs;
    }

    public idw.idwws.OmObj getOmObjs(int i) {
        return this.omObjs[i];
    }

    public void setOmObjs(int i, idw.idwws.OmObj _value) {
        this.omObjs[i] = _value;
    }


    /**
     * Gets the omPapros value for this OmPt.
     * 
     * @return omPapros
     */
    public idw.idwws.OmPapro[] getOmPapros() {
        return omPapros;
    }


    /**
     * Sets the omPapros value for this OmPt.
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
     * Gets the omPas value for this OmPt.
     * 
     * @return omPas
     */
    public idw.idwws.OmPa[] getOmPas() {
        return omPas;
    }


    /**
     * Sets the omPas value for this OmPt.
     * 
     * @param omPas
     */
    public void setOmPas(idw.idwws.OmPa[] omPas) {
        this.omPas = omPas;
    }

    public idw.idwws.OmPa getOmPas(int i) {
        return this.omPas[i];
    }

    public void setOmPas(int i, idw.idwws.OmPa _value) {
        this.omPas[i] = _value;
    }


    /**
     * Gets the omPrgs value for this OmPt.
     * 
     * @return omPrgs
     */
    public idw.idwws.OmPrg[] getOmPrgs() {
        return omPrgs;
    }


    /**
     * Sets the omPrgs value for this OmPt.
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
     * Gets the omTppt value for this OmPt.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this OmPt.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmPt.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmPt.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmPt.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmPt.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppCps value for this OmPt.
     * 
     * @return ppCps
     */
    public idw.idwws.PpCp[] getPpCps() {
        return ppCps;
    }


    /**
     * Sets the ppCps value for this OmPt.
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
     * Gets the ppIndispRappts value for this OmPt.
     * 
     * @return ppIndispRappts
     */
    public idw.idwws.PpIndispRappt[] getPpIndispRappts() {
        return ppIndispRappts;
    }


    /**
     * Sets the ppIndispRappts value for this OmPt.
     * 
     * @param ppIndispRappts
     */
    public void setPpIndispRappts(idw.idwws.PpIndispRappt[] ppIndispRappts) {
        this.ppIndispRappts = ppIndispRappts;
    }

    public idw.idwws.PpIndispRappt getPpIndispRappts(int i) {
        return this.ppIndispRappts[i];
    }

    public void setPpIndispRappts(int i, idw.idwws.PpIndispRappt _value) {
        this.ppIndispRappts[i] = _value;
    }


    /**
     * Gets the ppPlanptgts value for this OmPt.
     * 
     * @return ppPlanptgts
     */
    public idw.idwws.PpPlanptgt[] getPpPlanptgts() {
        return ppPlanptgts;
    }


    /**
     * Sets the ppPlanptgts value for this OmPt.
     * 
     * @param ppPlanptgts
     */
    public void setPpPlanptgts(idw.idwws.PpPlanptgt[] ppPlanptgts) {
        this.ppPlanptgts = ppPlanptgts;
    }

    public idw.idwws.PpPlanptgt getPpPlanptgts(int i) {
        return this.ppPlanptgts[i];
    }

    public void setPpPlanptgts(int i, idw.idwws.PpPlanptgt _value) {
        this.ppPlanptgts[i] = _value;
    }


    /**
     * Gets the revisao value for this OmPt.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmPt.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmPt.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmPt.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpImpprog value for this OmPt.
     * 
     * @return tpImpprog
     */
    public java.lang.Byte getTpImpprog() {
        return tpImpprog;
    }


    /**
     * Sets the tpImpprog value for this OmPt.
     * 
     * @param tpImpprog
     */
    public void setTpImpprog(java.lang.Byte tpImpprog) {
        this.tpImpprog = tpImpprog;
    }


    /**
     * Gets the urlConexao value for this OmPt.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this OmPt.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmPt)) return false;
        OmPt other = (OmPt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdPt==null && other.getCdPt()==null) || 
             (this.cdPt!=null &&
              this.cdPt.equals(other.getCdPt()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.dsCurta==null && other.getDsCurta()==null) || 
             (this.dsCurta!=null &&
              this.dsCurta.equals(other.getDsCurta()))) &&
            ((this.dsPt==null && other.getDsPt()==null) || 
             (this.dsPt!=null &&
              this.dsPt.equals(other.getDsPt()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwCalpts==null && other.getDwCalpts()==null) || 
             (this.dwCalpts!=null &&
              java.util.Arrays.equals(this.dwCalpts, other.getDwCalpts()))) &&
            ((this.dwConsolatlogs==null && other.getDwConsolatlogs()==null) || 
             (this.dwConsolatlogs!=null &&
              java.util.Arrays.equals(this.dwConsolatlogs, other.getDwConsolatlogs()))) &&
            ((this.dwConsolids==null && other.getDwConsolids()==null) || 
             (this.dwConsolids!=null &&
              java.util.Arrays.equals(this.dwConsolids, other.getDwConsolids()))) &&
            ((this.dwConsolmologs==null && other.getDwConsolmologs()==null) || 
             (this.dwConsolmologs!=null &&
              java.util.Arrays.equals(this.dwConsolmologs, other.getDwConsolmologs()))) &&
            ((this.dwConsolpalogs==null && other.getDwConsolpalogs()==null) || 
             (this.dwConsolpalogs!=null &&
              java.util.Arrays.equals(this.dwConsolpalogs, other.getDwConsolpalogs()))) &&
            ((this.dwConsolpts==null && other.getDwConsolpts()==null) || 
             (this.dwConsolpts!=null &&
              java.util.Arrays.equals(this.dwConsolpts, other.getDwConsolpts()))) &&
            ((this.dwExpcvses==null && other.getDwExpcvses()==null) || 
             (this.dwExpcvses!=null &&
              java.util.Arrays.equals(this.dwExpcvses, other.getDwExpcvses()))) &&
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.dwOperacaos==null && other.getDwOperacaos()==null) || 
             (this.dwOperacaos!=null &&
              java.util.Arrays.equals(this.dwOperacaos, other.getDwOperacaos()))) &&
            ((this.dwPassagems==null && other.getDwPassagems()==null) || 
             (this.dwPassagems!=null &&
              java.util.Arrays.equals(this.dwPassagems, other.getDwPassagems()))) &&
            ((this.dwRotapassoPts==null && other.getDwRotapassoPts()==null) || 
             (this.dwRotapassoPts!=null &&
              java.util.Arrays.equals(this.dwRotapassoPts, other.getDwRotapassoPts()))) &&
            ((this.dwRotapassos==null && other.getDwRotapassos()==null) || 
             (this.dwRotapassos!=null &&
              java.util.Arrays.equals(this.dwRotapassos, other.getDwRotapassos()))) &&
            ((this.dwRts==null && other.getDwRts()==null) || 
             (this.dwRts!=null &&
              java.util.Arrays.equals(this.dwRts, other.getDwRts()))) &&
            ((this.estagio==null && other.getEstagio()==null) || 
             (this.estagio!=null &&
              this.estagio.equals(other.getEstagio()))) &&
            ((this.idPt==null && other.getIdPt()==null) || 
             (this.idPt!=null &&
              this.idPt.equals(other.getIdPt()))) &&
            ((this.indOee==null && other.getIndOee()==null) || 
             (this.indOee!=null &&
              this.indOee.equals(other.getIndOee()))) &&
            ((this.isAlimcorexc==null && other.getIsAlimcorexc()==null) || 
             (this.isAlimcorexc!=null &&
              this.isAlimcorexc.equals(other.getIsAlimcorexc()))) &&
            ((this.isApongt==null && other.getIsApongt()==null) || 
             (this.isApongt!=null &&
              this.isApongt.equals(other.getIsApongt()))) &&
            ((this.isPlangt==null && other.getIsPlangt()==null) || 
             (this.isPlangt!=null &&
              this.isPlangt.equals(other.getIsPlangt()))) &&
            ((this.msTriggers==null && other.getMsTriggers()==null) || 
             (this.msTriggers!=null &&
              java.util.Arrays.equals(this.msTriggers, other.getMsTriggers()))) &&
            ((this.omAlimByIdAlim==null && other.getOmAlimByIdAlim()==null) || 
             (this.omAlimByIdAlim!=null &&
              this.omAlimByIdAlim.equals(other.getOmAlimByIdAlim()))) &&
            ((this.omAlimByIdAlimcorrente==null && other.getOmAlimByIdAlimcorrente()==null) || 
             (this.omAlimByIdAlimcorrente!=null &&
              this.omAlimByIdAlimcorrente.equals(other.getOmAlimByIdAlimcorrente()))) &&
            ((this.omAlimByIdAlimpre==null && other.getOmAlimByIdAlimpre()==null) || 
             (this.omAlimByIdAlimpre!=null &&
              this.omAlimByIdAlimpre.equals(other.getOmAlimByIdAlimpre()))) &&
            ((this.omCc==null && other.getOmCc()==null) || 
             (this.omCc!=null &&
              this.omCc.equals(other.getOmCc()))) &&
            ((this.omCfgptdetcoletas==null && other.getOmCfgptdetcoletas()==null) || 
             (this.omCfgptdetcoletas!=null &&
              java.util.Arrays.equals(this.omCfgptdetcoletas, other.getOmCfgptdetcoletas()))) &&
            ((this.omClp==null && other.getOmClp()==null) || 
             (this.omClp!=null &&
              this.omClp.equals(other.getOmClp()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omHomopts==null && other.getOmHomopts()==null) || 
             (this.omHomopts!=null &&
              java.util.Arrays.equals(this.omHomopts, other.getOmHomopts()))) &&
            ((this.omIndpts==null && other.getOmIndpts()==null) || 
             (this.omIndpts!=null &&
              java.util.Arrays.equals(this.omIndpts, other.getOmIndpts()))) &&
            ((this.omMapas==null && other.getOmMapas()==null) || 
             (this.omMapas!=null &&
              java.util.Arrays.equals(this.omMapas, other.getOmMapas()))) &&
            ((this.omObjs==null && other.getOmObjs()==null) || 
             (this.omObjs!=null &&
              java.util.Arrays.equals(this.omObjs, other.getOmObjs()))) &&
            ((this.omPapros==null && other.getOmPapros()==null) || 
             (this.omPapros!=null &&
              java.util.Arrays.equals(this.omPapros, other.getOmPapros()))) &&
            ((this.omPas==null && other.getOmPas()==null) || 
             (this.omPas!=null &&
              java.util.Arrays.equals(this.omPas, other.getOmPas()))) &&
            ((this.omPrgs==null && other.getOmPrgs()==null) || 
             (this.omPrgs!=null &&
              java.util.Arrays.equals(this.omPrgs, other.getOmPrgs()))) &&
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
            ((this.ppIndispRappts==null && other.getPpIndispRappts()==null) || 
             (this.ppIndispRappts!=null &&
              java.util.Arrays.equals(this.ppIndispRappts, other.getPpIndispRappts()))) &&
            ((this.ppPlanptgts==null && other.getPpPlanptgts()==null) || 
             (this.ppPlanptgts!=null &&
              java.util.Arrays.equals(this.ppPlanptgts, other.getPpPlanptgts()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpImpprog==null && other.getTpImpprog()==null) || 
             (this.tpImpprog!=null &&
              this.tpImpprog.equals(other.getTpImpprog()))) &&
            ((this.urlConexao==null && other.getUrlConexao()==null) || 
             (this.urlConexao!=null &&
              this.urlConexao.equals(other.getUrlConexao())));
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
        if (getCdPt() != null) {
            _hashCode += getCdPt().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDsCurta() != null) {
            _hashCode += getDsCurta().hashCode();
        }
        if (getDsPt() != null) {
            _hashCode += getDsPt().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwCalpts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalpts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalpts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolatlogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolatlogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolatlogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getDwConsolpalogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpalogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpalogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolpts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpts(), i);
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
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getDwOperacaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwOperacaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwOperacaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPassagems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassagems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassagems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRotapassoPts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotapassoPts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotapassoPts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getDwRts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEstagio() != null) {
            _hashCode += getEstagio().hashCode();
        }
        if (getIdPt() != null) {
            _hashCode += getIdPt().hashCode();
        }
        if (getIndOee() != null) {
            _hashCode += getIndOee().hashCode();
        }
        if (getIsAlimcorexc() != null) {
            _hashCode += getIsAlimcorexc().hashCode();
        }
        if (getIsApongt() != null) {
            _hashCode += getIsApongt().hashCode();
        }
        if (getIsPlangt() != null) {
            _hashCode += getIsPlangt().hashCode();
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
        if (getOmAlimByIdAlim() != null) {
            _hashCode += getOmAlimByIdAlim().hashCode();
        }
        if (getOmAlimByIdAlimcorrente() != null) {
            _hashCode += getOmAlimByIdAlimcorrente().hashCode();
        }
        if (getOmAlimByIdAlimpre() != null) {
            _hashCode += getOmAlimByIdAlimpre().hashCode();
        }
        if (getOmCc() != null) {
            _hashCode += getOmCc().hashCode();
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
        if (getOmClp() != null) {
            _hashCode += getOmClp().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmHomopts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmHomopts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmHomopts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmIndpts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmIndpts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmIndpts(), i);
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
        if (getOmObjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjs(), i);
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
        if (getOmPas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPas(), i);
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
        if (getPpIndispRappts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpIndispRappts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpIndispRappts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpPlanptgts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpPlanptgts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpPlanptgts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpImpprog() != null) {
            _hashCode += getTpImpprog().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmPt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdPt"));
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
        elemField.setFieldName("dsCurta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCurta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPt"));
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
        elemField.setFieldName("dwCalpts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalpts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolatlogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolatlogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolatlog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("dwConsolmologs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmologs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmolog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpalogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpalogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpt"));
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
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwOperacaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwOperacaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwOperacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassoPts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassoPts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapassoPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("dwRts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estagio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estagio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indOee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indOee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlimcorexc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAlimcorexc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isApongt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isApongt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPlangt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPlangt"));
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
        elemField.setFieldName("omAlimByIdAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlimByIdAlim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlim"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlimByIdAlimcorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlimByIdAlimcorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlim"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlimByIdAlimpre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlimByIdAlimpre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlim"));
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
        elemField.setFieldName("omCfgptdetcoletas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgptdetcoletas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgptdetcoleta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omClp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omClp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omClp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omHomopts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omHomopts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomopt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omIndpts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omIndpts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndpt"));
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
        elemField.setFieldName("omObjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
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
        elemField.setFieldName("omPas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPa"));
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
        elemField.setFieldName("ppIndispRappts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppIndispRappts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppIndispRappt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlanptgts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlanptgts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlanptgt"));
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
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpImpprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpImpprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlConexao"));
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
