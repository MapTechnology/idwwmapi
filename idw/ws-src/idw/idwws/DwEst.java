/**
 * DwEst.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwEst  extends idw.idwws.DwEstTemplate  implements java.io.Serializable {
    private java.lang.String cdEst;

    private java.lang.String depara;

    private java.lang.String dsEst;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwEstpro[] dwEstpros;

    private idw.idwws.DwNserie[] dwNseries;

    private idw.idwws.DwPassagem[] dwPassagems;

    private idw.idwws.DwRotapasso[] dwRotapassosC;

    private idw.idwws.DwRotapasso[] dwRotapassosE;

    private long idEst;

    private idw.idwws.OmCfg[] omCfgsForIdEstexpedicao;

    private idw.idwws.OmCfg[] omCfgsForIdEstliberado;

    private idw.idwws.OmCfg[] omCfgsForIdEstmp;

    private idw.idwws.OmCfg[] omCfgsForIdEstproducao;

    private idw.idwws.OmCfg[] omCfgsForIdEstrefugo;

    private idw.idwws.OmObj[] omObjsForIdEst;

    private idw.idwws.OmObj[] omObjsForIdRota;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwEst() {
    }

    public DwEst(
           java.lang.Long id,
           java.lang.String cdEst,
           java.lang.String depara,
           java.lang.String dsEst,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwEstpro[] dwEstpros,
           idw.idwws.DwNserie[] dwNseries,
           idw.idwws.DwPassagem[] dwPassagems,
           idw.idwws.DwRotapasso[] dwRotapassosC,
           idw.idwws.DwRotapasso[] dwRotapassosE,
           long idEst,
           idw.idwws.OmCfg[] omCfgsForIdEstexpedicao,
           idw.idwws.OmCfg[] omCfgsForIdEstliberado,
           idw.idwws.OmCfg[] omCfgsForIdEstmp,
           idw.idwws.OmCfg[] omCfgsForIdEstproducao,
           idw.idwws.OmCfg[] omCfgsForIdEstrefugo,
           idw.idwws.OmObj[] omObjsForIdEst,
           idw.idwws.OmObj[] omObjsForIdRota,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdEst = cdEst;
        this.depara = depara;
        this.dsEst = dsEst;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwEstpros = dwEstpros;
        this.dwNseries = dwNseries;
        this.dwPassagems = dwPassagems;
        this.dwRotapassosC = dwRotapassosC;
        this.dwRotapassosE = dwRotapassosE;
        this.idEst = idEst;
        this.omCfgsForIdEstexpedicao = omCfgsForIdEstexpedicao;
        this.omCfgsForIdEstliberado = omCfgsForIdEstliberado;
        this.omCfgsForIdEstmp = omCfgsForIdEstmp;
        this.omCfgsForIdEstproducao = omCfgsForIdEstproducao;
        this.omCfgsForIdEstrefugo = omCfgsForIdEstrefugo;
        this.omObjsForIdEst = omObjsForIdEst;
        this.omObjsForIdRota = omObjsForIdRota;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdEst value for this DwEst.
     * 
     * @return cdEst
     */
    public java.lang.String getCdEst() {
        return cdEst;
    }


    /**
     * Sets the cdEst value for this DwEst.
     * 
     * @param cdEst
     */
    public void setCdEst(java.lang.String cdEst) {
        this.cdEst = cdEst;
    }


    /**
     * Gets the depara value for this DwEst.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this DwEst.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the dsEst value for this DwEst.
     * 
     * @return dsEst
     */
    public java.lang.String getDsEst() {
        return dsEst;
    }


    /**
     * Sets the dsEst value for this DwEst.
     * 
     * @param dsEst
     */
    public void setDsEst(java.lang.String dsEst) {
        this.dsEst = dsEst;
    }


    /**
     * Gets the dtRevisao value for this DwEst.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwEst.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwEst.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwEst.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwEstpros value for this DwEst.
     * 
     * @return dwEstpros
     */
    public idw.idwws.DwEstpro[] getDwEstpros() {
        return dwEstpros;
    }


    /**
     * Sets the dwEstpros value for this DwEst.
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
     * Gets the dwNseries value for this DwEst.
     * 
     * @return dwNseries
     */
    public idw.idwws.DwNserie[] getDwNseries() {
        return dwNseries;
    }


    /**
     * Sets the dwNseries value for this DwEst.
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
     * Gets the dwPassagems value for this DwEst.
     * 
     * @return dwPassagems
     */
    public idw.idwws.DwPassagem[] getDwPassagems() {
        return dwPassagems;
    }


    /**
     * Sets the dwPassagems value for this DwEst.
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
     * Gets the dwRotapassosC value for this DwEst.
     * 
     * @return dwRotapassosC
     */
    public idw.idwws.DwRotapasso[] getDwRotapassosC() {
        return dwRotapassosC;
    }


    /**
     * Sets the dwRotapassosC value for this DwEst.
     * 
     * @param dwRotapassosC
     */
    public void setDwRotapassosC(idw.idwws.DwRotapasso[] dwRotapassosC) {
        this.dwRotapassosC = dwRotapassosC;
    }

    public idw.idwws.DwRotapasso getDwRotapassosC(int i) {
        return this.dwRotapassosC[i];
    }

    public void setDwRotapassosC(int i, idw.idwws.DwRotapasso _value) {
        this.dwRotapassosC[i] = _value;
    }


    /**
     * Gets the dwRotapassosE value for this DwEst.
     * 
     * @return dwRotapassosE
     */
    public idw.idwws.DwRotapasso[] getDwRotapassosE() {
        return dwRotapassosE;
    }


    /**
     * Sets the dwRotapassosE value for this DwEst.
     * 
     * @param dwRotapassosE
     */
    public void setDwRotapassosE(idw.idwws.DwRotapasso[] dwRotapassosE) {
        this.dwRotapassosE = dwRotapassosE;
    }

    public idw.idwws.DwRotapasso getDwRotapassosE(int i) {
        return this.dwRotapassosE[i];
    }

    public void setDwRotapassosE(int i, idw.idwws.DwRotapasso _value) {
        this.dwRotapassosE[i] = _value;
    }


    /**
     * Gets the idEst value for this DwEst.
     * 
     * @return idEst
     */
    public long getIdEst() {
        return idEst;
    }


    /**
     * Sets the idEst value for this DwEst.
     * 
     * @param idEst
     */
    public void setIdEst(long idEst) {
        this.idEst = idEst;
    }


    /**
     * Gets the omCfgsForIdEstexpedicao value for this DwEst.
     * 
     * @return omCfgsForIdEstexpedicao
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdEstexpedicao() {
        return omCfgsForIdEstexpedicao;
    }


    /**
     * Sets the omCfgsForIdEstexpedicao value for this DwEst.
     * 
     * @param omCfgsForIdEstexpedicao
     */
    public void setOmCfgsForIdEstexpedicao(idw.idwws.OmCfg[] omCfgsForIdEstexpedicao) {
        this.omCfgsForIdEstexpedicao = omCfgsForIdEstexpedicao;
    }

    public idw.idwws.OmCfg getOmCfgsForIdEstexpedicao(int i) {
        return this.omCfgsForIdEstexpedicao[i];
    }

    public void setOmCfgsForIdEstexpedicao(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdEstexpedicao[i] = _value;
    }


    /**
     * Gets the omCfgsForIdEstliberado value for this DwEst.
     * 
     * @return omCfgsForIdEstliberado
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdEstliberado() {
        return omCfgsForIdEstliberado;
    }


    /**
     * Sets the omCfgsForIdEstliberado value for this DwEst.
     * 
     * @param omCfgsForIdEstliberado
     */
    public void setOmCfgsForIdEstliberado(idw.idwws.OmCfg[] omCfgsForIdEstliberado) {
        this.omCfgsForIdEstliberado = omCfgsForIdEstliberado;
    }

    public idw.idwws.OmCfg getOmCfgsForIdEstliberado(int i) {
        return this.omCfgsForIdEstliberado[i];
    }

    public void setOmCfgsForIdEstliberado(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdEstliberado[i] = _value;
    }


    /**
     * Gets the omCfgsForIdEstmp value for this DwEst.
     * 
     * @return omCfgsForIdEstmp
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdEstmp() {
        return omCfgsForIdEstmp;
    }


    /**
     * Sets the omCfgsForIdEstmp value for this DwEst.
     * 
     * @param omCfgsForIdEstmp
     */
    public void setOmCfgsForIdEstmp(idw.idwws.OmCfg[] omCfgsForIdEstmp) {
        this.omCfgsForIdEstmp = omCfgsForIdEstmp;
    }

    public idw.idwws.OmCfg getOmCfgsForIdEstmp(int i) {
        return this.omCfgsForIdEstmp[i];
    }

    public void setOmCfgsForIdEstmp(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdEstmp[i] = _value;
    }


    /**
     * Gets the omCfgsForIdEstproducao value for this DwEst.
     * 
     * @return omCfgsForIdEstproducao
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdEstproducao() {
        return omCfgsForIdEstproducao;
    }


    /**
     * Sets the omCfgsForIdEstproducao value for this DwEst.
     * 
     * @param omCfgsForIdEstproducao
     */
    public void setOmCfgsForIdEstproducao(idw.idwws.OmCfg[] omCfgsForIdEstproducao) {
        this.omCfgsForIdEstproducao = omCfgsForIdEstproducao;
    }

    public idw.idwws.OmCfg getOmCfgsForIdEstproducao(int i) {
        return this.omCfgsForIdEstproducao[i];
    }

    public void setOmCfgsForIdEstproducao(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdEstproducao[i] = _value;
    }


    /**
     * Gets the omCfgsForIdEstrefugo value for this DwEst.
     * 
     * @return omCfgsForIdEstrefugo
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdEstrefugo() {
        return omCfgsForIdEstrefugo;
    }


    /**
     * Sets the omCfgsForIdEstrefugo value for this DwEst.
     * 
     * @param omCfgsForIdEstrefugo
     */
    public void setOmCfgsForIdEstrefugo(idw.idwws.OmCfg[] omCfgsForIdEstrefugo) {
        this.omCfgsForIdEstrefugo = omCfgsForIdEstrefugo;
    }

    public idw.idwws.OmCfg getOmCfgsForIdEstrefugo(int i) {
        return this.omCfgsForIdEstrefugo[i];
    }

    public void setOmCfgsForIdEstrefugo(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdEstrefugo[i] = _value;
    }


    /**
     * Gets the omObjsForIdEst value for this DwEst.
     * 
     * @return omObjsForIdEst
     */
    public idw.idwws.OmObj[] getOmObjsForIdEst() {
        return omObjsForIdEst;
    }


    /**
     * Sets the omObjsForIdEst value for this DwEst.
     * 
     * @param omObjsForIdEst
     */
    public void setOmObjsForIdEst(idw.idwws.OmObj[] omObjsForIdEst) {
        this.omObjsForIdEst = omObjsForIdEst;
    }

    public idw.idwws.OmObj getOmObjsForIdEst(int i) {
        return this.omObjsForIdEst[i];
    }

    public void setOmObjsForIdEst(int i, idw.idwws.OmObj _value) {
        this.omObjsForIdEst[i] = _value;
    }


    /**
     * Gets the omObjsForIdRota value for this DwEst.
     * 
     * @return omObjsForIdRota
     */
    public idw.idwws.OmObj[] getOmObjsForIdRota() {
        return omObjsForIdRota;
    }


    /**
     * Sets the omObjsForIdRota value for this DwEst.
     * 
     * @param omObjsForIdRota
     */
    public void setOmObjsForIdRota(idw.idwws.OmObj[] omObjsForIdRota) {
        this.omObjsForIdRota = omObjsForIdRota;
    }

    public idw.idwws.OmObj getOmObjsForIdRota(int i) {
        return this.omObjsForIdRota[i];
    }

    public void setOmObjsForIdRota(int i, idw.idwws.OmObj _value) {
        this.omObjsForIdRota[i] = _value;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwEst.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwEst.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwEst.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwEst.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwEst.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwEst.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwEst.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwEst.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwEst)) return false;
        DwEst other = (DwEst) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdEst==null && other.getCdEst()==null) || 
             (this.cdEst!=null &&
              this.cdEst.equals(other.getCdEst()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.dsEst==null && other.getDsEst()==null) || 
             (this.dsEst!=null &&
              this.dsEst.equals(other.getDsEst()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwEstpros==null && other.getDwEstpros()==null) || 
             (this.dwEstpros!=null &&
              java.util.Arrays.equals(this.dwEstpros, other.getDwEstpros()))) &&
            ((this.dwNseries==null && other.getDwNseries()==null) || 
             (this.dwNseries!=null &&
              java.util.Arrays.equals(this.dwNseries, other.getDwNseries()))) &&
            ((this.dwPassagems==null && other.getDwPassagems()==null) || 
             (this.dwPassagems!=null &&
              java.util.Arrays.equals(this.dwPassagems, other.getDwPassagems()))) &&
            ((this.dwRotapassosC==null && other.getDwRotapassosC()==null) || 
             (this.dwRotapassosC!=null &&
              java.util.Arrays.equals(this.dwRotapassosC, other.getDwRotapassosC()))) &&
            ((this.dwRotapassosE==null && other.getDwRotapassosE()==null) || 
             (this.dwRotapassosE!=null &&
              java.util.Arrays.equals(this.dwRotapassosE, other.getDwRotapassosE()))) &&
            this.idEst == other.getIdEst() &&
            ((this.omCfgsForIdEstexpedicao==null && other.getOmCfgsForIdEstexpedicao()==null) || 
             (this.omCfgsForIdEstexpedicao!=null &&
              java.util.Arrays.equals(this.omCfgsForIdEstexpedicao, other.getOmCfgsForIdEstexpedicao()))) &&
            ((this.omCfgsForIdEstliberado==null && other.getOmCfgsForIdEstliberado()==null) || 
             (this.omCfgsForIdEstliberado!=null &&
              java.util.Arrays.equals(this.omCfgsForIdEstliberado, other.getOmCfgsForIdEstliberado()))) &&
            ((this.omCfgsForIdEstmp==null && other.getOmCfgsForIdEstmp()==null) || 
             (this.omCfgsForIdEstmp!=null &&
              java.util.Arrays.equals(this.omCfgsForIdEstmp, other.getOmCfgsForIdEstmp()))) &&
            ((this.omCfgsForIdEstproducao==null && other.getOmCfgsForIdEstproducao()==null) || 
             (this.omCfgsForIdEstproducao!=null &&
              java.util.Arrays.equals(this.omCfgsForIdEstproducao, other.getOmCfgsForIdEstproducao()))) &&
            ((this.omCfgsForIdEstrefugo==null && other.getOmCfgsForIdEstrefugo()==null) || 
             (this.omCfgsForIdEstrefugo!=null &&
              java.util.Arrays.equals(this.omCfgsForIdEstrefugo, other.getOmCfgsForIdEstrefugo()))) &&
            ((this.omObjsForIdEst==null && other.getOmObjsForIdEst()==null) || 
             (this.omObjsForIdEst!=null &&
              java.util.Arrays.equals(this.omObjsForIdEst, other.getOmObjsForIdEst()))) &&
            ((this.omObjsForIdRota==null && other.getOmObjsForIdRota()==null) || 
             (this.omObjsForIdRota!=null &&
              java.util.Arrays.equals(this.omObjsForIdRota, other.getOmObjsForIdRota()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo())));
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
        if (getCdEst() != null) {
            _hashCode += getCdEst().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDsEst() != null) {
            _hashCode += getDsEst().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
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
        if (getDwRotapassosC() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotapassosC());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotapassosC(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRotapassosE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotapassosE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotapassosE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdEst()).hashCode();
        if (getOmCfgsForIdEstexpedicao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdEstexpedicao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdEstexpedicao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdEstliberado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdEstliberado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdEstliberado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdEstmp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdEstmp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdEstmp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdEstproducao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdEstproducao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdEstproducao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdEstrefugo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdEstrefugo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdEstrefugo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmObjsForIdEst() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjsForIdEst());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjsForIdEst(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmObjsForIdRota() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjsForIdRota());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjsForIdRota(), i);
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
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwEst.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdEst"));
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
        elemField.setFieldName("dsEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsEst"));
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
        elemField.setFieldName("dwEstpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstpro"));
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
        elemField.setFieldName("dwPassagems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassosC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassosC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassosE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassosE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdEstexpedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdEstexpedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdEstliberado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdEstliberado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdEstmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdEstmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdEstproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdEstproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdEstrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdEstrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjsForIdEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjsForIdEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjsForIdRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjsForIdRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
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
