/**
 * DwFtParam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFtParam  extends idw.idwws.DwFtParamTemplate  implements java.io.Serializable {
    private java.lang.String dsParametro;

    private java.lang.String dsValor1;

    private java.lang.String dsValor2;

    private java.lang.String dsValor3;

    private java.lang.String dsValor4;

    private idw.idwws.DwConsolmedparamlog[] dwConsolmedparamlogs;

    private idw.idwws.DwConsolmedparam[] dwConsolmedparams;

    private idw.idwws.DwFtSubparam[] dwFtSubparams;

    private idw.idwws.DwFtSub[] dwFtSubs;

    private long idFtParam;

    private java.lang.Boolean isCombo;

    private java.lang.Boolean isMaximo;

    private java.lang.Boolean isMeta;

    private java.lang.Boolean isMinimo;

    private idw.idwws.OmCfg[] omCfgsForIdFtParamCorrente;

    private idw.idwws.OmCfg[] omCfgsForIdFtParamFlusoS;

    private idw.idwws.OmCfg[] omCfgsForIdFtParamFluxoE;

    private idw.idwws.OmCfg[] omCfgsForIdFtParamTensao;

    private java.lang.Byte stValor1;

    private java.lang.Byte stValor2;

    private java.lang.Byte stValor3;

    private java.lang.Byte stValor4;

    public DwFtParam() {
    }

    public DwFtParam(
           java.lang.String dsParametro,
           java.lang.String dsValor1,
           java.lang.String dsValor2,
           java.lang.String dsValor3,
           java.lang.String dsValor4,
           idw.idwws.DwConsolmedparamlog[] dwConsolmedparamlogs,
           idw.idwws.DwConsolmedparam[] dwConsolmedparams,
           idw.idwws.DwFtSubparam[] dwFtSubparams,
           idw.idwws.DwFtSub[] dwFtSubs,
           long idFtParam,
           java.lang.Boolean isCombo,
           java.lang.Boolean isMaximo,
           java.lang.Boolean isMeta,
           java.lang.Boolean isMinimo,
           idw.idwws.OmCfg[] omCfgsForIdFtParamCorrente,
           idw.idwws.OmCfg[] omCfgsForIdFtParamFlusoS,
           idw.idwws.OmCfg[] omCfgsForIdFtParamFluxoE,
           idw.idwws.OmCfg[] omCfgsForIdFtParamTensao,
           java.lang.Byte stValor1,
           java.lang.Byte stValor2,
           java.lang.Byte stValor3,
           java.lang.Byte stValor4) {
        this.dsParametro = dsParametro;
        this.dsValor1 = dsValor1;
        this.dsValor2 = dsValor2;
        this.dsValor3 = dsValor3;
        this.dsValor4 = dsValor4;
        this.dwConsolmedparamlogs = dwConsolmedparamlogs;
        this.dwConsolmedparams = dwConsolmedparams;
        this.dwFtSubparams = dwFtSubparams;
        this.dwFtSubs = dwFtSubs;
        this.idFtParam = idFtParam;
        this.isCombo = isCombo;
        this.isMaximo = isMaximo;
        this.isMeta = isMeta;
        this.isMinimo = isMinimo;
        this.omCfgsForIdFtParamCorrente = omCfgsForIdFtParamCorrente;
        this.omCfgsForIdFtParamFlusoS = omCfgsForIdFtParamFlusoS;
        this.omCfgsForIdFtParamFluxoE = omCfgsForIdFtParamFluxoE;
        this.omCfgsForIdFtParamTensao = omCfgsForIdFtParamTensao;
        this.stValor1 = stValor1;
        this.stValor2 = stValor2;
        this.stValor3 = stValor3;
        this.stValor4 = stValor4;
    }


    /**
     * Gets the dsParametro value for this DwFtParam.
     * 
     * @return dsParametro
     */
    public java.lang.String getDsParametro() {
        return dsParametro;
    }


    /**
     * Sets the dsParametro value for this DwFtParam.
     * 
     * @param dsParametro
     */
    public void setDsParametro(java.lang.String dsParametro) {
        this.dsParametro = dsParametro;
    }


    /**
     * Gets the dsValor1 value for this DwFtParam.
     * 
     * @return dsValor1
     */
    public java.lang.String getDsValor1() {
        return dsValor1;
    }


    /**
     * Sets the dsValor1 value for this DwFtParam.
     * 
     * @param dsValor1
     */
    public void setDsValor1(java.lang.String dsValor1) {
        this.dsValor1 = dsValor1;
    }


    /**
     * Gets the dsValor2 value for this DwFtParam.
     * 
     * @return dsValor2
     */
    public java.lang.String getDsValor2() {
        return dsValor2;
    }


    /**
     * Sets the dsValor2 value for this DwFtParam.
     * 
     * @param dsValor2
     */
    public void setDsValor2(java.lang.String dsValor2) {
        this.dsValor2 = dsValor2;
    }


    /**
     * Gets the dsValor3 value for this DwFtParam.
     * 
     * @return dsValor3
     */
    public java.lang.String getDsValor3() {
        return dsValor3;
    }


    /**
     * Sets the dsValor3 value for this DwFtParam.
     * 
     * @param dsValor3
     */
    public void setDsValor3(java.lang.String dsValor3) {
        this.dsValor3 = dsValor3;
    }


    /**
     * Gets the dsValor4 value for this DwFtParam.
     * 
     * @return dsValor4
     */
    public java.lang.String getDsValor4() {
        return dsValor4;
    }


    /**
     * Sets the dsValor4 value for this DwFtParam.
     * 
     * @param dsValor4
     */
    public void setDsValor4(java.lang.String dsValor4) {
        this.dsValor4 = dsValor4;
    }


    /**
     * Gets the dwConsolmedparamlogs value for this DwFtParam.
     * 
     * @return dwConsolmedparamlogs
     */
    public idw.idwws.DwConsolmedparamlog[] getDwConsolmedparamlogs() {
        return dwConsolmedparamlogs;
    }


    /**
     * Sets the dwConsolmedparamlogs value for this DwFtParam.
     * 
     * @param dwConsolmedparamlogs
     */
    public void setDwConsolmedparamlogs(idw.idwws.DwConsolmedparamlog[] dwConsolmedparamlogs) {
        this.dwConsolmedparamlogs = dwConsolmedparamlogs;
    }

    public idw.idwws.DwConsolmedparamlog getDwConsolmedparamlogs(int i) {
        return this.dwConsolmedparamlogs[i];
    }

    public void setDwConsolmedparamlogs(int i, idw.idwws.DwConsolmedparamlog _value) {
        this.dwConsolmedparamlogs[i] = _value;
    }


    /**
     * Gets the dwConsolmedparams value for this DwFtParam.
     * 
     * @return dwConsolmedparams
     */
    public idw.idwws.DwConsolmedparam[] getDwConsolmedparams() {
        return dwConsolmedparams;
    }


    /**
     * Sets the dwConsolmedparams value for this DwFtParam.
     * 
     * @param dwConsolmedparams
     */
    public void setDwConsolmedparams(idw.idwws.DwConsolmedparam[] dwConsolmedparams) {
        this.dwConsolmedparams = dwConsolmedparams;
    }

    public idw.idwws.DwConsolmedparam getDwConsolmedparams(int i) {
        return this.dwConsolmedparams[i];
    }

    public void setDwConsolmedparams(int i, idw.idwws.DwConsolmedparam _value) {
        this.dwConsolmedparams[i] = _value;
    }


    /**
     * Gets the dwFtSubparams value for this DwFtParam.
     * 
     * @return dwFtSubparams
     */
    public idw.idwws.DwFtSubparam[] getDwFtSubparams() {
        return dwFtSubparams;
    }


    /**
     * Sets the dwFtSubparams value for this DwFtParam.
     * 
     * @param dwFtSubparams
     */
    public void setDwFtSubparams(idw.idwws.DwFtSubparam[] dwFtSubparams) {
        this.dwFtSubparams = dwFtSubparams;
    }

    public idw.idwws.DwFtSubparam getDwFtSubparams(int i) {
        return this.dwFtSubparams[i];
    }

    public void setDwFtSubparams(int i, idw.idwws.DwFtSubparam _value) {
        this.dwFtSubparams[i] = _value;
    }


    /**
     * Gets the dwFtSubs value for this DwFtParam.
     * 
     * @return dwFtSubs
     */
    public idw.idwws.DwFtSub[] getDwFtSubs() {
        return dwFtSubs;
    }


    /**
     * Sets the dwFtSubs value for this DwFtParam.
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
     * Gets the idFtParam value for this DwFtParam.
     * 
     * @return idFtParam
     */
    public long getIdFtParam() {
        return idFtParam;
    }


    /**
     * Sets the idFtParam value for this DwFtParam.
     * 
     * @param idFtParam
     */
    public void setIdFtParam(long idFtParam) {
        this.idFtParam = idFtParam;
    }


    /**
     * Gets the isCombo value for this DwFtParam.
     * 
     * @return isCombo
     */
    public java.lang.Boolean getIsCombo() {
        return isCombo;
    }


    /**
     * Sets the isCombo value for this DwFtParam.
     * 
     * @param isCombo
     */
    public void setIsCombo(java.lang.Boolean isCombo) {
        this.isCombo = isCombo;
    }


    /**
     * Gets the isMaximo value for this DwFtParam.
     * 
     * @return isMaximo
     */
    public java.lang.Boolean getIsMaximo() {
        return isMaximo;
    }


    /**
     * Sets the isMaximo value for this DwFtParam.
     * 
     * @param isMaximo
     */
    public void setIsMaximo(java.lang.Boolean isMaximo) {
        this.isMaximo = isMaximo;
    }


    /**
     * Gets the isMeta value for this DwFtParam.
     * 
     * @return isMeta
     */
    public java.lang.Boolean getIsMeta() {
        return isMeta;
    }


    /**
     * Sets the isMeta value for this DwFtParam.
     * 
     * @param isMeta
     */
    public void setIsMeta(java.lang.Boolean isMeta) {
        this.isMeta = isMeta;
    }


    /**
     * Gets the isMinimo value for this DwFtParam.
     * 
     * @return isMinimo
     */
    public java.lang.Boolean getIsMinimo() {
        return isMinimo;
    }


    /**
     * Sets the isMinimo value for this DwFtParam.
     * 
     * @param isMinimo
     */
    public void setIsMinimo(java.lang.Boolean isMinimo) {
        this.isMinimo = isMinimo;
    }


    /**
     * Gets the omCfgsForIdFtParamCorrente value for this DwFtParam.
     * 
     * @return omCfgsForIdFtParamCorrente
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdFtParamCorrente() {
        return omCfgsForIdFtParamCorrente;
    }


    /**
     * Sets the omCfgsForIdFtParamCorrente value for this DwFtParam.
     * 
     * @param omCfgsForIdFtParamCorrente
     */
    public void setOmCfgsForIdFtParamCorrente(idw.idwws.OmCfg[] omCfgsForIdFtParamCorrente) {
        this.omCfgsForIdFtParamCorrente = omCfgsForIdFtParamCorrente;
    }

    public idw.idwws.OmCfg getOmCfgsForIdFtParamCorrente(int i) {
        return this.omCfgsForIdFtParamCorrente[i];
    }

    public void setOmCfgsForIdFtParamCorrente(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdFtParamCorrente[i] = _value;
    }


    /**
     * Gets the omCfgsForIdFtParamFlusoS value for this DwFtParam.
     * 
     * @return omCfgsForIdFtParamFlusoS
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdFtParamFlusoS() {
        return omCfgsForIdFtParamFlusoS;
    }


    /**
     * Sets the omCfgsForIdFtParamFlusoS value for this DwFtParam.
     * 
     * @param omCfgsForIdFtParamFlusoS
     */
    public void setOmCfgsForIdFtParamFlusoS(idw.idwws.OmCfg[] omCfgsForIdFtParamFlusoS) {
        this.omCfgsForIdFtParamFlusoS = omCfgsForIdFtParamFlusoS;
    }

    public idw.idwws.OmCfg getOmCfgsForIdFtParamFlusoS(int i) {
        return this.omCfgsForIdFtParamFlusoS[i];
    }

    public void setOmCfgsForIdFtParamFlusoS(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdFtParamFlusoS[i] = _value;
    }


    /**
     * Gets the omCfgsForIdFtParamFluxoE value for this DwFtParam.
     * 
     * @return omCfgsForIdFtParamFluxoE
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdFtParamFluxoE() {
        return omCfgsForIdFtParamFluxoE;
    }


    /**
     * Sets the omCfgsForIdFtParamFluxoE value for this DwFtParam.
     * 
     * @param omCfgsForIdFtParamFluxoE
     */
    public void setOmCfgsForIdFtParamFluxoE(idw.idwws.OmCfg[] omCfgsForIdFtParamFluxoE) {
        this.omCfgsForIdFtParamFluxoE = omCfgsForIdFtParamFluxoE;
    }

    public idw.idwws.OmCfg getOmCfgsForIdFtParamFluxoE(int i) {
        return this.omCfgsForIdFtParamFluxoE[i];
    }

    public void setOmCfgsForIdFtParamFluxoE(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdFtParamFluxoE[i] = _value;
    }


    /**
     * Gets the omCfgsForIdFtParamTensao value for this DwFtParam.
     * 
     * @return omCfgsForIdFtParamTensao
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdFtParamTensao() {
        return omCfgsForIdFtParamTensao;
    }


    /**
     * Sets the omCfgsForIdFtParamTensao value for this DwFtParam.
     * 
     * @param omCfgsForIdFtParamTensao
     */
    public void setOmCfgsForIdFtParamTensao(idw.idwws.OmCfg[] omCfgsForIdFtParamTensao) {
        this.omCfgsForIdFtParamTensao = omCfgsForIdFtParamTensao;
    }

    public idw.idwws.OmCfg getOmCfgsForIdFtParamTensao(int i) {
        return this.omCfgsForIdFtParamTensao[i];
    }

    public void setOmCfgsForIdFtParamTensao(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdFtParamTensao[i] = _value;
    }


    /**
     * Gets the stValor1 value for this DwFtParam.
     * 
     * @return stValor1
     */
    public java.lang.Byte getStValor1() {
        return stValor1;
    }


    /**
     * Sets the stValor1 value for this DwFtParam.
     * 
     * @param stValor1
     */
    public void setStValor1(java.lang.Byte stValor1) {
        this.stValor1 = stValor1;
    }


    /**
     * Gets the stValor2 value for this DwFtParam.
     * 
     * @return stValor2
     */
    public java.lang.Byte getStValor2() {
        return stValor2;
    }


    /**
     * Sets the stValor2 value for this DwFtParam.
     * 
     * @param stValor2
     */
    public void setStValor2(java.lang.Byte stValor2) {
        this.stValor2 = stValor2;
    }


    /**
     * Gets the stValor3 value for this DwFtParam.
     * 
     * @return stValor3
     */
    public java.lang.Byte getStValor3() {
        return stValor3;
    }


    /**
     * Sets the stValor3 value for this DwFtParam.
     * 
     * @param stValor3
     */
    public void setStValor3(java.lang.Byte stValor3) {
        this.stValor3 = stValor3;
    }


    /**
     * Gets the stValor4 value for this DwFtParam.
     * 
     * @return stValor4
     */
    public java.lang.Byte getStValor4() {
        return stValor4;
    }


    /**
     * Sets the stValor4 value for this DwFtParam.
     * 
     * @param stValor4
     */
    public void setStValor4(java.lang.Byte stValor4) {
        this.stValor4 = stValor4;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFtParam)) return false;
        DwFtParam other = (DwFtParam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsParametro==null && other.getDsParametro()==null) || 
             (this.dsParametro!=null &&
              this.dsParametro.equals(other.getDsParametro()))) &&
            ((this.dsValor1==null && other.getDsValor1()==null) || 
             (this.dsValor1!=null &&
              this.dsValor1.equals(other.getDsValor1()))) &&
            ((this.dsValor2==null && other.getDsValor2()==null) || 
             (this.dsValor2!=null &&
              this.dsValor2.equals(other.getDsValor2()))) &&
            ((this.dsValor3==null && other.getDsValor3()==null) || 
             (this.dsValor3!=null &&
              this.dsValor3.equals(other.getDsValor3()))) &&
            ((this.dsValor4==null && other.getDsValor4()==null) || 
             (this.dsValor4!=null &&
              this.dsValor4.equals(other.getDsValor4()))) &&
            ((this.dwConsolmedparamlogs==null && other.getDwConsolmedparamlogs()==null) || 
             (this.dwConsolmedparamlogs!=null &&
              java.util.Arrays.equals(this.dwConsolmedparamlogs, other.getDwConsolmedparamlogs()))) &&
            ((this.dwConsolmedparams==null && other.getDwConsolmedparams()==null) || 
             (this.dwConsolmedparams!=null &&
              java.util.Arrays.equals(this.dwConsolmedparams, other.getDwConsolmedparams()))) &&
            ((this.dwFtSubparams==null && other.getDwFtSubparams()==null) || 
             (this.dwFtSubparams!=null &&
              java.util.Arrays.equals(this.dwFtSubparams, other.getDwFtSubparams()))) &&
            ((this.dwFtSubs==null && other.getDwFtSubs()==null) || 
             (this.dwFtSubs!=null &&
              java.util.Arrays.equals(this.dwFtSubs, other.getDwFtSubs()))) &&
            this.idFtParam == other.getIdFtParam() &&
            ((this.isCombo==null && other.getIsCombo()==null) || 
             (this.isCombo!=null &&
              this.isCombo.equals(other.getIsCombo()))) &&
            ((this.isMaximo==null && other.getIsMaximo()==null) || 
             (this.isMaximo!=null &&
              this.isMaximo.equals(other.getIsMaximo()))) &&
            ((this.isMeta==null && other.getIsMeta()==null) || 
             (this.isMeta!=null &&
              this.isMeta.equals(other.getIsMeta()))) &&
            ((this.isMinimo==null && other.getIsMinimo()==null) || 
             (this.isMinimo!=null &&
              this.isMinimo.equals(other.getIsMinimo()))) &&
            ((this.omCfgsForIdFtParamCorrente==null && other.getOmCfgsForIdFtParamCorrente()==null) || 
             (this.omCfgsForIdFtParamCorrente!=null &&
              java.util.Arrays.equals(this.omCfgsForIdFtParamCorrente, other.getOmCfgsForIdFtParamCorrente()))) &&
            ((this.omCfgsForIdFtParamFlusoS==null && other.getOmCfgsForIdFtParamFlusoS()==null) || 
             (this.omCfgsForIdFtParamFlusoS!=null &&
              java.util.Arrays.equals(this.omCfgsForIdFtParamFlusoS, other.getOmCfgsForIdFtParamFlusoS()))) &&
            ((this.omCfgsForIdFtParamFluxoE==null && other.getOmCfgsForIdFtParamFluxoE()==null) || 
             (this.omCfgsForIdFtParamFluxoE!=null &&
              java.util.Arrays.equals(this.omCfgsForIdFtParamFluxoE, other.getOmCfgsForIdFtParamFluxoE()))) &&
            ((this.omCfgsForIdFtParamTensao==null && other.getOmCfgsForIdFtParamTensao()==null) || 
             (this.omCfgsForIdFtParamTensao!=null &&
              java.util.Arrays.equals(this.omCfgsForIdFtParamTensao, other.getOmCfgsForIdFtParamTensao()))) &&
            ((this.stValor1==null && other.getStValor1()==null) || 
             (this.stValor1!=null &&
              this.stValor1.equals(other.getStValor1()))) &&
            ((this.stValor2==null && other.getStValor2()==null) || 
             (this.stValor2!=null &&
              this.stValor2.equals(other.getStValor2()))) &&
            ((this.stValor3==null && other.getStValor3()==null) || 
             (this.stValor3!=null &&
              this.stValor3.equals(other.getStValor3()))) &&
            ((this.stValor4==null && other.getStValor4()==null) || 
             (this.stValor4!=null &&
              this.stValor4.equals(other.getStValor4())));
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
        if (getDsParametro() != null) {
            _hashCode += getDsParametro().hashCode();
        }
        if (getDsValor1() != null) {
            _hashCode += getDsValor1().hashCode();
        }
        if (getDsValor2() != null) {
            _hashCode += getDsValor2().hashCode();
        }
        if (getDsValor3() != null) {
            _hashCode += getDsValor3().hashCode();
        }
        if (getDsValor4() != null) {
            _hashCode += getDsValor4().hashCode();
        }
        if (getDwConsolmedparamlogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmedparamlogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmedparamlogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolmedparams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmedparams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmedparams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFtSubparams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFtSubparams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFtSubparams(), i);
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
        _hashCode += new Long(getIdFtParam()).hashCode();
        if (getIsCombo() != null) {
            _hashCode += getIsCombo().hashCode();
        }
        if (getIsMaximo() != null) {
            _hashCode += getIsMaximo().hashCode();
        }
        if (getIsMeta() != null) {
            _hashCode += getIsMeta().hashCode();
        }
        if (getIsMinimo() != null) {
            _hashCode += getIsMinimo().hashCode();
        }
        if (getOmCfgsForIdFtParamCorrente() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdFtParamCorrente());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdFtParamCorrente(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdFtParamFlusoS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdFtParamFlusoS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdFtParamFlusoS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdFtParamFluxoE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdFtParamFluxoE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdFtParamFluxoE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdFtParamTensao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdFtParamTensao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdFtParamTensao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStValor1() != null) {
            _hashCode += getStValor1().hashCode();
        }
        if (getStValor2() != null) {
            _hashCode += getStValor2().hashCode();
        }
        if (getStValor3() != null) {
            _hashCode += getStValor3().hashCode();
        }
        if (getStValor4() != null) {
            _hashCode += getStValor4().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFtParam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsParametro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsParametro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsValor1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsValor1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsValor2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsValor2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsValor3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsValor3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsValor4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsValor4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmedparamlogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmedparamlogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparamlog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmedparams");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmedparams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtSubparams");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSubparams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSubparam"));
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
        elemField.setFieldName("idFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCombo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCombo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMaximo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMaximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMinimo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMinimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdFtParamCorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdFtParamCorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdFtParamFlusoS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdFtParamFlusoS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdFtParamFluxoE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdFtParamFluxoE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdFtParamTensao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdFtParamTensao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stValor1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stValor1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stValor2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stValor2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stValor3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stValor3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stValor4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stValor4"));
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
