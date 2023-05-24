/**
 * OmGt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmGt  extends idw.idwws.OmGtTemplate  implements java.io.Serializable {
    private java.math.BigDecimal altura;

    private java.lang.String cdGt;

    private java.lang.String depara;

    private java.lang.String dsCurta;

    private java.lang.String dsGt;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolmolog[] dwConsolmologs;

    private idw.idwws.DwFolha[] dwFolhas;

    private idw.idwws.DwFolhateste[] dwFolhatestes;

    private idw.idwws.DwRota[] dwRotas;

    private java.math.BigDecimal gridx;

    private java.math.BigDecimal gridy;

    private java.lang.Long idGt;

    private java.math.BigDecimal indOee;

    private java.math.BigDecimal largura;

    private idw.idwws.OmCc omCc;

    private idw.idwws.OmHomogt[] omHomogts;

    private idw.idwws.OmImg omImg;

    private idw.idwws.OmIndgt[] omIndgts;

    private idw.idwws.OmObj[] omObjsForIdGt;

    private idw.idwws.OmObj[] omObjsForIdGtfilho;

    private idw.idwws.OmPt[] omPts;

    private idw.idwws.OmTpgt omTpgt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.OmUsr[] omUsrs;

    private idw.idwws.PpCp[] ppCps;

    private idw.idwws.PpPlanptgt[] ppPlanptgts;

    private java.lang.Long revisao;

    private java.math.BigDecimal segX;

    private java.math.BigDecimal segY;

    private java.math.BigDecimal segZ;

    private java.lang.Byte stAtivo;

    private java.math.BigDecimal tensaoMax;

    private java.math.BigDecimal tensaoMin;

    private java.math.BigDecimal tensaoNom;

    public OmGt() {
    }

    public OmGt(
           java.lang.Long id,
           java.math.BigDecimal altura,
           java.lang.String cdGt,
           java.lang.String depara,
           java.lang.String dsCurta,
           java.lang.String dsGt,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolmolog[] dwConsolmologs,
           idw.idwws.DwFolha[] dwFolhas,
           idw.idwws.DwFolhateste[] dwFolhatestes,
           idw.idwws.DwRota[] dwRotas,
           java.math.BigDecimal gridx,
           java.math.BigDecimal gridy,
           java.lang.Long idGt,
           java.math.BigDecimal indOee,
           java.math.BigDecimal largura,
           idw.idwws.OmCc omCc,
           idw.idwws.OmHomogt[] omHomogts,
           idw.idwws.OmImg omImg,
           idw.idwws.OmIndgt[] omIndgts,
           idw.idwws.OmObj[] omObjsForIdGt,
           idw.idwws.OmObj[] omObjsForIdGtfilho,
           idw.idwws.OmPt[] omPts,
           idw.idwws.OmTpgt omTpgt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.OmUsr[] omUsrs,
           idw.idwws.PpCp[] ppCps,
           idw.idwws.PpPlanptgt[] ppPlanptgts,
           java.lang.Long revisao,
           java.math.BigDecimal segX,
           java.math.BigDecimal segY,
           java.math.BigDecimal segZ,
           java.lang.Byte stAtivo,
           java.math.BigDecimal tensaoMax,
           java.math.BigDecimal tensaoMin,
           java.math.BigDecimal tensaoNom) {
        super(
            id);
        this.altura = altura;
        this.cdGt = cdGt;
        this.depara = depara;
        this.dsCurta = dsCurta;
        this.dsGt = dsGt;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolmologs = dwConsolmologs;
        this.dwFolhas = dwFolhas;
        this.dwFolhatestes = dwFolhatestes;
        this.dwRotas = dwRotas;
        this.gridx = gridx;
        this.gridy = gridy;
        this.idGt = idGt;
        this.indOee = indOee;
        this.largura = largura;
        this.omCc = omCc;
        this.omHomogts = omHomogts;
        this.omImg = omImg;
        this.omIndgts = omIndgts;
        this.omObjsForIdGt = omObjsForIdGt;
        this.omObjsForIdGtfilho = omObjsForIdGtfilho;
        this.omPts = omPts;
        this.omTpgt = omTpgt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.omUsrs = omUsrs;
        this.ppCps = ppCps;
        this.ppPlanptgts = ppPlanptgts;
        this.revisao = revisao;
        this.segX = segX;
        this.segY = segY;
        this.segZ = segZ;
        this.stAtivo = stAtivo;
        this.tensaoMax = tensaoMax;
        this.tensaoMin = tensaoMin;
        this.tensaoNom = tensaoNom;
    }


    /**
     * Gets the altura value for this OmGt.
     * 
     * @return altura
     */
    public java.math.BigDecimal getAltura() {
        return altura;
    }


    /**
     * Sets the altura value for this OmGt.
     * 
     * @param altura
     */
    public void setAltura(java.math.BigDecimal altura) {
        this.altura = altura;
    }


    /**
     * Gets the cdGt value for this OmGt.
     * 
     * @return cdGt
     */
    public java.lang.String getCdGt() {
        return cdGt;
    }


    /**
     * Sets the cdGt value for this OmGt.
     * 
     * @param cdGt
     */
    public void setCdGt(java.lang.String cdGt) {
        this.cdGt = cdGt;
    }


    /**
     * Gets the depara value for this OmGt.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this OmGt.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the dsCurta value for this OmGt.
     * 
     * @return dsCurta
     */
    public java.lang.String getDsCurta() {
        return dsCurta;
    }


    /**
     * Sets the dsCurta value for this OmGt.
     * 
     * @param dsCurta
     */
    public void setDsCurta(java.lang.String dsCurta) {
        this.dsCurta = dsCurta;
    }


    /**
     * Gets the dsGt value for this OmGt.
     * 
     * @return dsGt
     */
    public java.lang.String getDsGt() {
        return dsGt;
    }


    /**
     * Sets the dsGt value for this OmGt.
     * 
     * @param dsGt
     */
    public void setDsGt(java.lang.String dsGt) {
        this.dsGt = dsGt;
    }


    /**
     * Gets the dtRevisao value for this OmGt.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmGt.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmGt.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmGt.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolmologs value for this OmGt.
     * 
     * @return dwConsolmologs
     */
    public idw.idwws.DwConsolmolog[] getDwConsolmologs() {
        return dwConsolmologs;
    }


    /**
     * Sets the dwConsolmologs value for this OmGt.
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
     * Gets the dwFolhas value for this OmGt.
     * 
     * @return dwFolhas
     */
    public idw.idwws.DwFolha[] getDwFolhas() {
        return dwFolhas;
    }


    /**
     * Sets the dwFolhas value for this OmGt.
     * 
     * @param dwFolhas
     */
    public void setDwFolhas(idw.idwws.DwFolha[] dwFolhas) {
        this.dwFolhas = dwFolhas;
    }

    public idw.idwws.DwFolha getDwFolhas(int i) {
        return this.dwFolhas[i];
    }

    public void setDwFolhas(int i, idw.idwws.DwFolha _value) {
        this.dwFolhas[i] = _value;
    }


    /**
     * Gets the dwFolhatestes value for this OmGt.
     * 
     * @return dwFolhatestes
     */
    public idw.idwws.DwFolhateste[] getDwFolhatestes() {
        return dwFolhatestes;
    }


    /**
     * Sets the dwFolhatestes value for this OmGt.
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
     * Gets the dwRotas value for this OmGt.
     * 
     * @return dwRotas
     */
    public idw.idwws.DwRota[] getDwRotas() {
        return dwRotas;
    }


    /**
     * Sets the dwRotas value for this OmGt.
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
     * Gets the gridx value for this OmGt.
     * 
     * @return gridx
     */
    public java.math.BigDecimal getGridx() {
        return gridx;
    }


    /**
     * Sets the gridx value for this OmGt.
     * 
     * @param gridx
     */
    public void setGridx(java.math.BigDecimal gridx) {
        this.gridx = gridx;
    }


    /**
     * Gets the gridy value for this OmGt.
     * 
     * @return gridy
     */
    public java.math.BigDecimal getGridy() {
        return gridy;
    }


    /**
     * Sets the gridy value for this OmGt.
     * 
     * @param gridy
     */
    public void setGridy(java.math.BigDecimal gridy) {
        this.gridy = gridy;
    }


    /**
     * Gets the idGt value for this OmGt.
     * 
     * @return idGt
     */
    public java.lang.Long getIdGt() {
        return idGt;
    }


    /**
     * Sets the idGt value for this OmGt.
     * 
     * @param idGt
     */
    public void setIdGt(java.lang.Long idGt) {
        this.idGt = idGt;
    }


    /**
     * Gets the indOee value for this OmGt.
     * 
     * @return indOee
     */
    public java.math.BigDecimal getIndOee() {
        return indOee;
    }


    /**
     * Sets the indOee value for this OmGt.
     * 
     * @param indOee
     */
    public void setIndOee(java.math.BigDecimal indOee) {
        this.indOee = indOee;
    }


    /**
     * Gets the largura value for this OmGt.
     * 
     * @return largura
     */
    public java.math.BigDecimal getLargura() {
        return largura;
    }


    /**
     * Sets the largura value for this OmGt.
     * 
     * @param largura
     */
    public void setLargura(java.math.BigDecimal largura) {
        this.largura = largura;
    }


    /**
     * Gets the omCc value for this OmGt.
     * 
     * @return omCc
     */
    public idw.idwws.OmCc getOmCc() {
        return omCc;
    }


    /**
     * Sets the omCc value for this OmGt.
     * 
     * @param omCc
     */
    public void setOmCc(idw.idwws.OmCc omCc) {
        this.omCc = omCc;
    }


    /**
     * Gets the omHomogts value for this OmGt.
     * 
     * @return omHomogts
     */
    public idw.idwws.OmHomogt[] getOmHomogts() {
        return omHomogts;
    }


    /**
     * Sets the omHomogts value for this OmGt.
     * 
     * @param omHomogts
     */
    public void setOmHomogts(idw.idwws.OmHomogt[] omHomogts) {
        this.omHomogts = omHomogts;
    }

    public idw.idwws.OmHomogt getOmHomogts(int i) {
        return this.omHomogts[i];
    }

    public void setOmHomogts(int i, idw.idwws.OmHomogt _value) {
        this.omHomogts[i] = _value;
    }


    /**
     * Gets the omImg value for this OmGt.
     * 
     * @return omImg
     */
    public idw.idwws.OmImg getOmImg() {
        return omImg;
    }


    /**
     * Sets the omImg value for this OmGt.
     * 
     * @param omImg
     */
    public void setOmImg(idw.idwws.OmImg omImg) {
        this.omImg = omImg;
    }


    /**
     * Gets the omIndgts value for this OmGt.
     * 
     * @return omIndgts
     */
    public idw.idwws.OmIndgt[] getOmIndgts() {
        return omIndgts;
    }


    /**
     * Sets the omIndgts value for this OmGt.
     * 
     * @param omIndgts
     */
    public void setOmIndgts(idw.idwws.OmIndgt[] omIndgts) {
        this.omIndgts = omIndgts;
    }

    public idw.idwws.OmIndgt getOmIndgts(int i) {
        return this.omIndgts[i];
    }

    public void setOmIndgts(int i, idw.idwws.OmIndgt _value) {
        this.omIndgts[i] = _value;
    }


    /**
     * Gets the omObjsForIdGt value for this OmGt.
     * 
     * @return omObjsForIdGt
     */
    public idw.idwws.OmObj[] getOmObjsForIdGt() {
        return omObjsForIdGt;
    }


    /**
     * Sets the omObjsForIdGt value for this OmGt.
     * 
     * @param omObjsForIdGt
     */
    public void setOmObjsForIdGt(idw.idwws.OmObj[] omObjsForIdGt) {
        this.omObjsForIdGt = omObjsForIdGt;
    }

    public idw.idwws.OmObj getOmObjsForIdGt(int i) {
        return this.omObjsForIdGt[i];
    }

    public void setOmObjsForIdGt(int i, idw.idwws.OmObj _value) {
        this.omObjsForIdGt[i] = _value;
    }


    /**
     * Gets the omObjsForIdGtfilho value for this OmGt.
     * 
     * @return omObjsForIdGtfilho
     */
    public idw.idwws.OmObj[] getOmObjsForIdGtfilho() {
        return omObjsForIdGtfilho;
    }


    /**
     * Sets the omObjsForIdGtfilho value for this OmGt.
     * 
     * @param omObjsForIdGtfilho
     */
    public void setOmObjsForIdGtfilho(idw.idwws.OmObj[] omObjsForIdGtfilho) {
        this.omObjsForIdGtfilho = omObjsForIdGtfilho;
    }

    public idw.idwws.OmObj getOmObjsForIdGtfilho(int i) {
        return this.omObjsForIdGtfilho[i];
    }

    public void setOmObjsForIdGtfilho(int i, idw.idwws.OmObj _value) {
        this.omObjsForIdGtfilho[i] = _value;
    }


    /**
     * Gets the omPts value for this OmGt.
     * 
     * @return omPts
     */
    public idw.idwws.OmPt[] getOmPts() {
        return omPts;
    }


    /**
     * Sets the omPts value for this OmGt.
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
     * Gets the omTpgt value for this OmGt.
     * 
     * @return omTpgt
     */
    public idw.idwws.OmTpgt getOmTpgt() {
        return omTpgt;
    }


    /**
     * Sets the omTpgt value for this OmGt.
     * 
     * @param omTpgt
     */
    public void setOmTpgt(idw.idwws.OmTpgt omTpgt) {
        this.omTpgt = omTpgt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmGt.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmGt.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmGt.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmGt.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the omUsrs value for this OmGt.
     * 
     * @return omUsrs
     */
    public idw.idwws.OmUsr[] getOmUsrs() {
        return omUsrs;
    }


    /**
     * Sets the omUsrs value for this OmGt.
     * 
     * @param omUsrs
     */
    public void setOmUsrs(idw.idwws.OmUsr[] omUsrs) {
        this.omUsrs = omUsrs;
    }

    public idw.idwws.OmUsr getOmUsrs(int i) {
        return this.omUsrs[i];
    }

    public void setOmUsrs(int i, idw.idwws.OmUsr _value) {
        this.omUsrs[i] = _value;
    }


    /**
     * Gets the ppCps value for this OmGt.
     * 
     * @return ppCps
     */
    public idw.idwws.PpCp[] getPpCps() {
        return ppCps;
    }


    /**
     * Sets the ppCps value for this OmGt.
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
     * Gets the ppPlanptgts value for this OmGt.
     * 
     * @return ppPlanptgts
     */
    public idw.idwws.PpPlanptgt[] getPpPlanptgts() {
        return ppPlanptgts;
    }


    /**
     * Sets the ppPlanptgts value for this OmGt.
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
     * Gets the revisao value for this OmGt.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmGt.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the segX value for this OmGt.
     * 
     * @return segX
     */
    public java.math.BigDecimal getSegX() {
        return segX;
    }


    /**
     * Sets the segX value for this OmGt.
     * 
     * @param segX
     */
    public void setSegX(java.math.BigDecimal segX) {
        this.segX = segX;
    }


    /**
     * Gets the segY value for this OmGt.
     * 
     * @return segY
     */
    public java.math.BigDecimal getSegY() {
        return segY;
    }


    /**
     * Sets the segY value for this OmGt.
     * 
     * @param segY
     */
    public void setSegY(java.math.BigDecimal segY) {
        this.segY = segY;
    }


    /**
     * Gets the segZ value for this OmGt.
     * 
     * @return segZ
     */
    public java.math.BigDecimal getSegZ() {
        return segZ;
    }


    /**
     * Sets the segZ value for this OmGt.
     * 
     * @param segZ
     */
    public void setSegZ(java.math.BigDecimal segZ) {
        this.segZ = segZ;
    }


    /**
     * Gets the stAtivo value for this OmGt.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmGt.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tensaoMax value for this OmGt.
     * 
     * @return tensaoMax
     */
    public java.math.BigDecimal getTensaoMax() {
        return tensaoMax;
    }


    /**
     * Sets the tensaoMax value for this OmGt.
     * 
     * @param tensaoMax
     */
    public void setTensaoMax(java.math.BigDecimal tensaoMax) {
        this.tensaoMax = tensaoMax;
    }


    /**
     * Gets the tensaoMin value for this OmGt.
     * 
     * @return tensaoMin
     */
    public java.math.BigDecimal getTensaoMin() {
        return tensaoMin;
    }


    /**
     * Sets the tensaoMin value for this OmGt.
     * 
     * @param tensaoMin
     */
    public void setTensaoMin(java.math.BigDecimal tensaoMin) {
        this.tensaoMin = tensaoMin;
    }


    /**
     * Gets the tensaoNom value for this OmGt.
     * 
     * @return tensaoNom
     */
    public java.math.BigDecimal getTensaoNom() {
        return tensaoNom;
    }


    /**
     * Sets the tensaoNom value for this OmGt.
     * 
     * @param tensaoNom
     */
    public void setTensaoNom(java.math.BigDecimal tensaoNom) {
        this.tensaoNom = tensaoNom;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmGt)) return false;
        OmGt other = (OmGt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.altura==null && other.getAltura()==null) || 
             (this.altura!=null &&
              this.altura.equals(other.getAltura()))) &&
            ((this.cdGt==null && other.getCdGt()==null) || 
             (this.cdGt!=null &&
              this.cdGt.equals(other.getCdGt()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.dsCurta==null && other.getDsCurta()==null) || 
             (this.dsCurta!=null &&
              this.dsCurta.equals(other.getDsCurta()))) &&
            ((this.dsGt==null && other.getDsGt()==null) || 
             (this.dsGt!=null &&
              this.dsGt.equals(other.getDsGt()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwConsolmologs==null && other.getDwConsolmologs()==null) || 
             (this.dwConsolmologs!=null &&
              java.util.Arrays.equals(this.dwConsolmologs, other.getDwConsolmologs()))) &&
            ((this.dwFolhas==null && other.getDwFolhas()==null) || 
             (this.dwFolhas!=null &&
              java.util.Arrays.equals(this.dwFolhas, other.getDwFolhas()))) &&
            ((this.dwFolhatestes==null && other.getDwFolhatestes()==null) || 
             (this.dwFolhatestes!=null &&
              java.util.Arrays.equals(this.dwFolhatestes, other.getDwFolhatestes()))) &&
            ((this.dwRotas==null && other.getDwRotas()==null) || 
             (this.dwRotas!=null &&
              java.util.Arrays.equals(this.dwRotas, other.getDwRotas()))) &&
            ((this.gridx==null && other.getGridx()==null) || 
             (this.gridx!=null &&
              this.gridx.equals(other.getGridx()))) &&
            ((this.gridy==null && other.getGridy()==null) || 
             (this.gridy!=null &&
              this.gridy.equals(other.getGridy()))) &&
            ((this.idGt==null && other.getIdGt()==null) || 
             (this.idGt!=null &&
              this.idGt.equals(other.getIdGt()))) &&
            ((this.indOee==null && other.getIndOee()==null) || 
             (this.indOee!=null &&
              this.indOee.equals(other.getIndOee()))) &&
            ((this.largura==null && other.getLargura()==null) || 
             (this.largura!=null &&
              this.largura.equals(other.getLargura()))) &&
            ((this.omCc==null && other.getOmCc()==null) || 
             (this.omCc!=null &&
              this.omCc.equals(other.getOmCc()))) &&
            ((this.omHomogts==null && other.getOmHomogts()==null) || 
             (this.omHomogts!=null &&
              java.util.Arrays.equals(this.omHomogts, other.getOmHomogts()))) &&
            ((this.omImg==null && other.getOmImg()==null) || 
             (this.omImg!=null &&
              this.omImg.equals(other.getOmImg()))) &&
            ((this.omIndgts==null && other.getOmIndgts()==null) || 
             (this.omIndgts!=null &&
              java.util.Arrays.equals(this.omIndgts, other.getOmIndgts()))) &&
            ((this.omObjsForIdGt==null && other.getOmObjsForIdGt()==null) || 
             (this.omObjsForIdGt!=null &&
              java.util.Arrays.equals(this.omObjsForIdGt, other.getOmObjsForIdGt()))) &&
            ((this.omObjsForIdGtfilho==null && other.getOmObjsForIdGtfilho()==null) || 
             (this.omObjsForIdGtfilho!=null &&
              java.util.Arrays.equals(this.omObjsForIdGtfilho, other.getOmObjsForIdGtfilho()))) &&
            ((this.omPts==null && other.getOmPts()==null) || 
             (this.omPts!=null &&
              java.util.Arrays.equals(this.omPts, other.getOmPts()))) &&
            ((this.omTpgt==null && other.getOmTpgt()==null) || 
             (this.omTpgt!=null &&
              this.omTpgt.equals(other.getOmTpgt()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.omUsrs==null && other.getOmUsrs()==null) || 
             (this.omUsrs!=null &&
              java.util.Arrays.equals(this.omUsrs, other.getOmUsrs()))) &&
            ((this.ppCps==null && other.getPpCps()==null) || 
             (this.ppCps!=null &&
              java.util.Arrays.equals(this.ppCps, other.getPpCps()))) &&
            ((this.ppPlanptgts==null && other.getPpPlanptgts()==null) || 
             (this.ppPlanptgts!=null &&
              java.util.Arrays.equals(this.ppPlanptgts, other.getPpPlanptgts()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.segX==null && other.getSegX()==null) || 
             (this.segX!=null &&
              this.segX.equals(other.getSegX()))) &&
            ((this.segY==null && other.getSegY()==null) || 
             (this.segY!=null &&
              this.segY.equals(other.getSegY()))) &&
            ((this.segZ==null && other.getSegZ()==null) || 
             (this.segZ!=null &&
              this.segZ.equals(other.getSegZ()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tensaoMax==null && other.getTensaoMax()==null) || 
             (this.tensaoMax!=null &&
              this.tensaoMax.equals(other.getTensaoMax()))) &&
            ((this.tensaoMin==null && other.getTensaoMin()==null) || 
             (this.tensaoMin!=null &&
              this.tensaoMin.equals(other.getTensaoMin()))) &&
            ((this.tensaoNom==null && other.getTensaoNom()==null) || 
             (this.tensaoNom!=null &&
              this.tensaoNom.equals(other.getTensaoNom())));
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
        if (getAltura() != null) {
            _hashCode += getAltura().hashCode();
        }
        if (getCdGt() != null) {
            _hashCode += getCdGt().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDsCurta() != null) {
            _hashCode += getDsCurta().hashCode();
        }
        if (getDsGt() != null) {
            _hashCode += getDsGt().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
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
        if (getDwFolhas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhas(), i);
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
        if (getGridx() != null) {
            _hashCode += getGridx().hashCode();
        }
        if (getGridy() != null) {
            _hashCode += getGridy().hashCode();
        }
        if (getIdGt() != null) {
            _hashCode += getIdGt().hashCode();
        }
        if (getIndOee() != null) {
            _hashCode += getIndOee().hashCode();
        }
        if (getLargura() != null) {
            _hashCode += getLargura().hashCode();
        }
        if (getOmCc() != null) {
            _hashCode += getOmCc().hashCode();
        }
        if (getOmHomogts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmHomogts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmHomogts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmImg() != null) {
            _hashCode += getOmImg().hashCode();
        }
        if (getOmIndgts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmIndgts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmIndgts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmObjsForIdGt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjsForIdGt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjsForIdGt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmObjsForIdGtfilho() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjsForIdGtfilho());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjsForIdGtfilho(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getOmTpgt() != null) {
            _hashCode += getOmTpgt().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getOmUsrs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmUsrs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmUsrs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getSegX() != null) {
            _hashCode += getSegX().hashCode();
        }
        if (getSegY() != null) {
            _hashCode += getSegY().hashCode();
        }
        if (getSegZ() != null) {
            _hashCode += getSegZ().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTensaoMax() != null) {
            _hashCode += getTensaoMax().hashCode();
        }
        if (getTensaoMin() != null) {
            _hashCode += getTensaoMin().hashCode();
        }
        if (getTensaoNom() != null) {
            _hashCode += getTensaoNom().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmGt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("altura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "altura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdGt"));
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
        elemField.setFieldName("dsGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsGt"));
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
        elemField.setFieldName("dwConsolmologs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmologs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmolog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
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
        elemField.setFieldName("dwRotas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gridx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gridx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gridy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gridy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGt"));
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
        elemField.setFieldName("largura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "largura"));
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
        elemField.setFieldName("omHomogts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omHomogts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomogt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omImg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omImg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omIndgts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omIndgts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndgt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjsForIdGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjsForIdGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjsForIdGtfilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjsForIdGtfilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("omTpgt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpgt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTpgt"));
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
        elemField.setFieldName("omUsrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("segX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segZ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segZ"));
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
        elemField.setFieldName("tensaoMax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaoMax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tensaoMin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaoMin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tensaoNom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaoNom"));
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
