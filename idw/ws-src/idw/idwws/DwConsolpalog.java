/**
 * DwConsolpalog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpalog  extends idw.idwws.DwConsolpalogTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFparada;

    private java.util.Calendar dthrFparadaAb;

    private java.util.Calendar dthrIparada;

    private idw.idwws.DwConsolpalogtec[] dwConsolpalogtecs;

    private idw.idwws.DwConsolpaoco[] dwConsolpaocos;

    private idw.idwws.DwRt[] dwRts;

    private idw.idwws.DwTAcao dwTAcao;

    private idw.idwws.DwTCausa dwTCausa;

    private idw.idwws.DwTJust dwTJust;

    private idw.idwws.DwTParada dwTParada;

    private java.lang.Long idConsolpalog;

    private java.lang.Boolean isVarritmo;

    private java.lang.Integer msDthrfparada;

    private java.lang.Integer msDthrfparadaAb;

    private java.lang.Integer msDthriparada;

    private idw.idwws.OmPt omPt;

    private java.math.BigDecimal segAutoCta;

    private java.math.BigDecimal segAutoTempoparadaAb;

    private java.math.BigDecimal segAutoTempoparadaCp;

    private java.math.BigDecimal segAutoTempoparadaSp;

    private java.math.BigDecimal segManuCta;

    private java.math.BigDecimal segManuTempoparadaCp;

    private java.math.BigDecimal segManuTempoparadaSp;

    public DwConsolpalog() {
    }

    public DwConsolpalog(
           java.util.Calendar dthrFparada,
           java.util.Calendar dthrFparadaAb,
           java.util.Calendar dthrIparada,
           idw.idwws.DwConsolpalogtec[] dwConsolpalogtecs,
           idw.idwws.DwConsolpaoco[] dwConsolpaocos,
           idw.idwws.DwRt[] dwRts,
           idw.idwws.DwTAcao dwTAcao,
           idw.idwws.DwTCausa dwTCausa,
           idw.idwws.DwTJust dwTJust,
           idw.idwws.DwTParada dwTParada,
           java.lang.Long idConsolpalog,
           java.lang.Boolean isVarritmo,
           java.lang.Integer msDthrfparada,
           java.lang.Integer msDthrfparadaAb,
           java.lang.Integer msDthriparada,
           idw.idwws.OmPt omPt,
           java.math.BigDecimal segAutoCta,
           java.math.BigDecimal segAutoTempoparadaAb,
           java.math.BigDecimal segAutoTempoparadaCp,
           java.math.BigDecimal segAutoTempoparadaSp,
           java.math.BigDecimal segManuCta,
           java.math.BigDecimal segManuTempoparadaCp,
           java.math.BigDecimal segManuTempoparadaSp) {
        this.dthrFparada = dthrFparada;
        this.dthrFparadaAb = dthrFparadaAb;
        this.dthrIparada = dthrIparada;
        this.dwConsolpalogtecs = dwConsolpalogtecs;
        this.dwConsolpaocos = dwConsolpaocos;
        this.dwRts = dwRts;
        this.dwTAcao = dwTAcao;
        this.dwTCausa = dwTCausa;
        this.dwTJust = dwTJust;
        this.dwTParada = dwTParada;
        this.idConsolpalog = idConsolpalog;
        this.isVarritmo = isVarritmo;
        this.msDthrfparada = msDthrfparada;
        this.msDthrfparadaAb = msDthrfparadaAb;
        this.msDthriparada = msDthriparada;
        this.omPt = omPt;
        this.segAutoCta = segAutoCta;
        this.segAutoTempoparadaAb = segAutoTempoparadaAb;
        this.segAutoTempoparadaCp = segAutoTempoparadaCp;
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
        this.segManuCta = segManuCta;
        this.segManuTempoparadaCp = segManuTempoparadaCp;
        this.segManuTempoparadaSp = segManuTempoparadaSp;
    }


    /**
     * Gets the dthrFparada value for this DwConsolpalog.
     * 
     * @return dthrFparada
     */
    public java.util.Calendar getDthrFparada() {
        return dthrFparada;
    }


    /**
     * Sets the dthrFparada value for this DwConsolpalog.
     * 
     * @param dthrFparada
     */
    public void setDthrFparada(java.util.Calendar dthrFparada) {
        this.dthrFparada = dthrFparada;
    }


    /**
     * Gets the dthrFparadaAb value for this DwConsolpalog.
     * 
     * @return dthrFparadaAb
     */
    public java.util.Calendar getDthrFparadaAb() {
        return dthrFparadaAb;
    }


    /**
     * Sets the dthrFparadaAb value for this DwConsolpalog.
     * 
     * @param dthrFparadaAb
     */
    public void setDthrFparadaAb(java.util.Calendar dthrFparadaAb) {
        this.dthrFparadaAb = dthrFparadaAb;
    }


    /**
     * Gets the dthrIparada value for this DwConsolpalog.
     * 
     * @return dthrIparada
     */
    public java.util.Calendar getDthrIparada() {
        return dthrIparada;
    }


    /**
     * Sets the dthrIparada value for this DwConsolpalog.
     * 
     * @param dthrIparada
     */
    public void setDthrIparada(java.util.Calendar dthrIparada) {
        this.dthrIparada = dthrIparada;
    }


    /**
     * Gets the dwConsolpalogtecs value for this DwConsolpalog.
     * 
     * @return dwConsolpalogtecs
     */
    public idw.idwws.DwConsolpalogtec[] getDwConsolpalogtecs() {
        return dwConsolpalogtecs;
    }


    /**
     * Sets the dwConsolpalogtecs value for this DwConsolpalog.
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
     * Gets the dwConsolpaocos value for this DwConsolpalog.
     * 
     * @return dwConsolpaocos
     */
    public idw.idwws.DwConsolpaoco[] getDwConsolpaocos() {
        return dwConsolpaocos;
    }


    /**
     * Sets the dwConsolpaocos value for this DwConsolpalog.
     * 
     * @param dwConsolpaocos
     */
    public void setDwConsolpaocos(idw.idwws.DwConsolpaoco[] dwConsolpaocos) {
        this.dwConsolpaocos = dwConsolpaocos;
    }

    public idw.idwws.DwConsolpaoco getDwConsolpaocos(int i) {
        return this.dwConsolpaocos[i];
    }

    public void setDwConsolpaocos(int i, idw.idwws.DwConsolpaoco _value) {
        this.dwConsolpaocos[i] = _value;
    }


    /**
     * Gets the dwRts value for this DwConsolpalog.
     * 
     * @return dwRts
     */
    public idw.idwws.DwRt[] getDwRts() {
        return dwRts;
    }


    /**
     * Sets the dwRts value for this DwConsolpalog.
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
     * Gets the dwTAcao value for this DwConsolpalog.
     * 
     * @return dwTAcao
     */
    public idw.idwws.DwTAcao getDwTAcao() {
        return dwTAcao;
    }


    /**
     * Sets the dwTAcao value for this DwConsolpalog.
     * 
     * @param dwTAcao
     */
    public void setDwTAcao(idw.idwws.DwTAcao dwTAcao) {
        this.dwTAcao = dwTAcao;
    }


    /**
     * Gets the dwTCausa value for this DwConsolpalog.
     * 
     * @return dwTCausa
     */
    public idw.idwws.DwTCausa getDwTCausa() {
        return dwTCausa;
    }


    /**
     * Sets the dwTCausa value for this DwConsolpalog.
     * 
     * @param dwTCausa
     */
    public void setDwTCausa(idw.idwws.DwTCausa dwTCausa) {
        this.dwTCausa = dwTCausa;
    }


    /**
     * Gets the dwTJust value for this DwConsolpalog.
     * 
     * @return dwTJust
     */
    public idw.idwws.DwTJust getDwTJust() {
        return dwTJust;
    }


    /**
     * Sets the dwTJust value for this DwConsolpalog.
     * 
     * @param dwTJust
     */
    public void setDwTJust(idw.idwws.DwTJust dwTJust) {
        this.dwTJust = dwTJust;
    }


    /**
     * Gets the dwTParada value for this DwConsolpalog.
     * 
     * @return dwTParada
     */
    public idw.idwws.DwTParada getDwTParada() {
        return dwTParada;
    }


    /**
     * Sets the dwTParada value for this DwConsolpalog.
     * 
     * @param dwTParada
     */
    public void setDwTParada(idw.idwws.DwTParada dwTParada) {
        this.dwTParada = dwTParada;
    }


    /**
     * Gets the idConsolpalog value for this DwConsolpalog.
     * 
     * @return idConsolpalog
     */
    public java.lang.Long getIdConsolpalog() {
        return idConsolpalog;
    }


    /**
     * Sets the idConsolpalog value for this DwConsolpalog.
     * 
     * @param idConsolpalog
     */
    public void setIdConsolpalog(java.lang.Long idConsolpalog) {
        this.idConsolpalog = idConsolpalog;
    }


    /**
     * Gets the isVarritmo value for this DwConsolpalog.
     * 
     * @return isVarritmo
     */
    public java.lang.Boolean getIsVarritmo() {
        return isVarritmo;
    }


    /**
     * Sets the isVarritmo value for this DwConsolpalog.
     * 
     * @param isVarritmo
     */
    public void setIsVarritmo(java.lang.Boolean isVarritmo) {
        this.isVarritmo = isVarritmo;
    }


    /**
     * Gets the msDthrfparada value for this DwConsolpalog.
     * 
     * @return msDthrfparada
     */
    public java.lang.Integer getMsDthrfparada() {
        return msDthrfparada;
    }


    /**
     * Sets the msDthrfparada value for this DwConsolpalog.
     * 
     * @param msDthrfparada
     */
    public void setMsDthrfparada(java.lang.Integer msDthrfparada) {
        this.msDthrfparada = msDthrfparada;
    }


    /**
     * Gets the msDthrfparadaAb value for this DwConsolpalog.
     * 
     * @return msDthrfparadaAb
     */
    public java.lang.Integer getMsDthrfparadaAb() {
        return msDthrfparadaAb;
    }


    /**
     * Sets the msDthrfparadaAb value for this DwConsolpalog.
     * 
     * @param msDthrfparadaAb
     */
    public void setMsDthrfparadaAb(java.lang.Integer msDthrfparadaAb) {
        this.msDthrfparadaAb = msDthrfparadaAb;
    }


    /**
     * Gets the msDthriparada value for this DwConsolpalog.
     * 
     * @return msDthriparada
     */
    public java.lang.Integer getMsDthriparada() {
        return msDthriparada;
    }


    /**
     * Sets the msDthriparada value for this DwConsolpalog.
     * 
     * @param msDthriparada
     */
    public void setMsDthriparada(java.lang.Integer msDthriparada) {
        this.msDthriparada = msDthriparada;
    }


    /**
     * Gets the omPt value for this DwConsolpalog.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwConsolpalog.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the segAutoCta value for this DwConsolpalog.
     * 
     * @return segAutoCta
     */
    public java.math.BigDecimal getSegAutoCta() {
        return segAutoCta;
    }


    /**
     * Sets the segAutoCta value for this DwConsolpalog.
     * 
     * @param segAutoCta
     */
    public void setSegAutoCta(java.math.BigDecimal segAutoCta) {
        this.segAutoCta = segAutoCta;
    }


    /**
     * Gets the segAutoTempoparadaAb value for this DwConsolpalog.
     * 
     * @return segAutoTempoparadaAb
     */
    public java.math.BigDecimal getSegAutoTempoparadaAb() {
        return segAutoTempoparadaAb;
    }


    /**
     * Sets the segAutoTempoparadaAb value for this DwConsolpalog.
     * 
     * @param segAutoTempoparadaAb
     */
    public void setSegAutoTempoparadaAb(java.math.BigDecimal segAutoTempoparadaAb) {
        this.segAutoTempoparadaAb = segAutoTempoparadaAb;
    }


    /**
     * Gets the segAutoTempoparadaCp value for this DwConsolpalog.
     * 
     * @return segAutoTempoparadaCp
     */
    public java.math.BigDecimal getSegAutoTempoparadaCp() {
        return segAutoTempoparadaCp;
    }


    /**
     * Sets the segAutoTempoparadaCp value for this DwConsolpalog.
     * 
     * @param segAutoTempoparadaCp
     */
    public void setSegAutoTempoparadaCp(java.math.BigDecimal segAutoTempoparadaCp) {
        this.segAutoTempoparadaCp = segAutoTempoparadaCp;
    }


    /**
     * Gets the segAutoTempoparadaSp value for this DwConsolpalog.
     * 
     * @return segAutoTempoparadaSp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSp() {
        return segAutoTempoparadaSp;
    }


    /**
     * Sets the segAutoTempoparadaSp value for this DwConsolpalog.
     * 
     * @param segAutoTempoparadaSp
     */
    public void setSegAutoTempoparadaSp(java.math.BigDecimal segAutoTempoparadaSp) {
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
    }


    /**
     * Gets the segManuCta value for this DwConsolpalog.
     * 
     * @return segManuCta
     */
    public java.math.BigDecimal getSegManuCta() {
        return segManuCta;
    }


    /**
     * Sets the segManuCta value for this DwConsolpalog.
     * 
     * @param segManuCta
     */
    public void setSegManuCta(java.math.BigDecimal segManuCta) {
        this.segManuCta = segManuCta;
    }


    /**
     * Gets the segManuTempoparadaCp value for this DwConsolpalog.
     * 
     * @return segManuTempoparadaCp
     */
    public java.math.BigDecimal getSegManuTempoparadaCp() {
        return segManuTempoparadaCp;
    }


    /**
     * Sets the segManuTempoparadaCp value for this DwConsolpalog.
     * 
     * @param segManuTempoparadaCp
     */
    public void setSegManuTempoparadaCp(java.math.BigDecimal segManuTempoparadaCp) {
        this.segManuTempoparadaCp = segManuTempoparadaCp;
    }


    /**
     * Gets the segManuTempoparadaSp value for this DwConsolpalog.
     * 
     * @return segManuTempoparadaSp
     */
    public java.math.BigDecimal getSegManuTempoparadaSp() {
        return segManuTempoparadaSp;
    }


    /**
     * Sets the segManuTempoparadaSp value for this DwConsolpalog.
     * 
     * @param segManuTempoparadaSp
     */
    public void setSegManuTempoparadaSp(java.math.BigDecimal segManuTempoparadaSp) {
        this.segManuTempoparadaSp = segManuTempoparadaSp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpalog)) return false;
        DwConsolpalog other = (DwConsolpalog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFparada==null && other.getDthrFparada()==null) || 
             (this.dthrFparada!=null &&
              this.dthrFparada.equals(other.getDthrFparada()))) &&
            ((this.dthrFparadaAb==null && other.getDthrFparadaAb()==null) || 
             (this.dthrFparadaAb!=null &&
              this.dthrFparadaAb.equals(other.getDthrFparadaAb()))) &&
            ((this.dthrIparada==null && other.getDthrIparada()==null) || 
             (this.dthrIparada!=null &&
              this.dthrIparada.equals(other.getDthrIparada()))) &&
            ((this.dwConsolpalogtecs==null && other.getDwConsolpalogtecs()==null) || 
             (this.dwConsolpalogtecs!=null &&
              java.util.Arrays.equals(this.dwConsolpalogtecs, other.getDwConsolpalogtecs()))) &&
            ((this.dwConsolpaocos==null && other.getDwConsolpaocos()==null) || 
             (this.dwConsolpaocos!=null &&
              java.util.Arrays.equals(this.dwConsolpaocos, other.getDwConsolpaocos()))) &&
            ((this.dwRts==null && other.getDwRts()==null) || 
             (this.dwRts!=null &&
              java.util.Arrays.equals(this.dwRts, other.getDwRts()))) &&
            ((this.dwTAcao==null && other.getDwTAcao()==null) || 
             (this.dwTAcao!=null &&
              this.dwTAcao.equals(other.getDwTAcao()))) &&
            ((this.dwTCausa==null && other.getDwTCausa()==null) || 
             (this.dwTCausa!=null &&
              this.dwTCausa.equals(other.getDwTCausa()))) &&
            ((this.dwTJust==null && other.getDwTJust()==null) || 
             (this.dwTJust!=null &&
              this.dwTJust.equals(other.getDwTJust()))) &&
            ((this.dwTParada==null && other.getDwTParada()==null) || 
             (this.dwTParada!=null &&
              this.dwTParada.equals(other.getDwTParada()))) &&
            ((this.idConsolpalog==null && other.getIdConsolpalog()==null) || 
             (this.idConsolpalog!=null &&
              this.idConsolpalog.equals(other.getIdConsolpalog()))) &&
            ((this.isVarritmo==null && other.getIsVarritmo()==null) || 
             (this.isVarritmo!=null &&
              this.isVarritmo.equals(other.getIsVarritmo()))) &&
            ((this.msDthrfparada==null && other.getMsDthrfparada()==null) || 
             (this.msDthrfparada!=null &&
              this.msDthrfparada.equals(other.getMsDthrfparada()))) &&
            ((this.msDthrfparadaAb==null && other.getMsDthrfparadaAb()==null) || 
             (this.msDthrfparadaAb!=null &&
              this.msDthrfparadaAb.equals(other.getMsDthrfparadaAb()))) &&
            ((this.msDthriparada==null && other.getMsDthriparada()==null) || 
             (this.msDthriparada!=null &&
              this.msDthriparada.equals(other.getMsDthriparada()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.segAutoCta==null && other.getSegAutoCta()==null) || 
             (this.segAutoCta!=null &&
              this.segAutoCta.equals(other.getSegAutoCta()))) &&
            ((this.segAutoTempoparadaAb==null && other.getSegAutoTempoparadaAb()==null) || 
             (this.segAutoTempoparadaAb!=null &&
              this.segAutoTempoparadaAb.equals(other.getSegAutoTempoparadaAb()))) &&
            ((this.segAutoTempoparadaCp==null && other.getSegAutoTempoparadaCp()==null) || 
             (this.segAutoTempoparadaCp!=null &&
              this.segAutoTempoparadaCp.equals(other.getSegAutoTempoparadaCp()))) &&
            ((this.segAutoTempoparadaSp==null && other.getSegAutoTempoparadaSp()==null) || 
             (this.segAutoTempoparadaSp!=null &&
              this.segAutoTempoparadaSp.equals(other.getSegAutoTempoparadaSp()))) &&
            ((this.segManuCta==null && other.getSegManuCta()==null) || 
             (this.segManuCta!=null &&
              this.segManuCta.equals(other.getSegManuCta()))) &&
            ((this.segManuTempoparadaCp==null && other.getSegManuTempoparadaCp()==null) || 
             (this.segManuTempoparadaCp!=null &&
              this.segManuTempoparadaCp.equals(other.getSegManuTempoparadaCp()))) &&
            ((this.segManuTempoparadaSp==null && other.getSegManuTempoparadaSp()==null) || 
             (this.segManuTempoparadaSp!=null &&
              this.segManuTempoparadaSp.equals(other.getSegManuTempoparadaSp())));
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
        if (getDthrFparada() != null) {
            _hashCode += getDthrFparada().hashCode();
        }
        if (getDthrFparadaAb() != null) {
            _hashCode += getDthrFparadaAb().hashCode();
        }
        if (getDthrIparada() != null) {
            _hashCode += getDthrIparada().hashCode();
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
        if (getDwConsolpaocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpaocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpaocos(), i);
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
        if (getDwTAcao() != null) {
            _hashCode += getDwTAcao().hashCode();
        }
        if (getDwTCausa() != null) {
            _hashCode += getDwTCausa().hashCode();
        }
        if (getDwTJust() != null) {
            _hashCode += getDwTJust().hashCode();
        }
        if (getDwTParada() != null) {
            _hashCode += getDwTParada().hashCode();
        }
        if (getIdConsolpalog() != null) {
            _hashCode += getIdConsolpalog().hashCode();
        }
        if (getIsVarritmo() != null) {
            _hashCode += getIsVarritmo().hashCode();
        }
        if (getMsDthrfparada() != null) {
            _hashCode += getMsDthrfparada().hashCode();
        }
        if (getMsDthrfparadaAb() != null) {
            _hashCode += getMsDthrfparadaAb().hashCode();
        }
        if (getMsDthriparada() != null) {
            _hashCode += getMsDthriparada().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getSegAutoCta() != null) {
            _hashCode += getSegAutoCta().hashCode();
        }
        if (getSegAutoTempoparadaAb() != null) {
            _hashCode += getSegAutoTempoparadaAb().hashCode();
        }
        if (getSegAutoTempoparadaCp() != null) {
            _hashCode += getSegAutoTempoparadaCp().hashCode();
        }
        if (getSegAutoTempoparadaSp() != null) {
            _hashCode += getSegAutoTempoparadaSp().hashCode();
        }
        if (getSegManuCta() != null) {
            _hashCode += getSegManuCta().hashCode();
        }
        if (getSegManuTempoparadaCp() != null) {
            _hashCode += getSegManuTempoparadaCp().hashCode();
        }
        if (getSegManuTempoparadaSp() != null) {
            _hashCode += getSegManuTempoparadaSp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpalog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFparadaAb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFparadaAb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("dwConsolpaocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpaocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpaoco"));
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
        elemField.setFieldName("dwTAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTCausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTCausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTCausa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTJust");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTJust"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTJust"));
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
        elemField.setFieldName("idConsolpalog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpalog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isVarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isVarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfparadaAb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfparadaAb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthriparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthriparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaAb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaAb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSp"));
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
