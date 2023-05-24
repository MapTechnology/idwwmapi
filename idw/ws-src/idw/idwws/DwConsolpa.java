/**
 * DwConsolpa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpa  extends idw.idwws.DwConsolpaTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsol dwConsol;

    private idw.idwws.DwConsolpamo[] dwConsolpamos;

    private idw.idwws.DwConsolpaoco[] dwConsolpaocos;

    private idw.idwws.DwTParada dwTParada;

    private java.lang.Long idConsolpa;

    private java.math.BigDecimal qtAutoOcoparadaCp;

    private java.math.BigDecimal qtAutoOcoparadaCpVr;

    private java.math.BigDecimal qtAutoOcoparadaSp;

    private java.math.BigDecimal qtAutoOcoparadaSpVr;

    private java.math.BigDecimal qtAutoTempoparadaDefault;

    private java.math.BigDecimal qtAutoTempoparadaSemCnx;

    private java.math.BigDecimal qtAutoTempoparadaSemEvt;

    private java.math.BigDecimal qtAutoTempoparadaSemOp;

    private java.math.BigDecimal qtManuOcoparadaCp;

    private java.math.BigDecimal qtManuOcoparadaCpVr;

    private java.math.BigDecimal qtManuOcoparadaSp;

    private java.math.BigDecimal qtManuOcoparadaSpVr;

    private java.math.BigDecimal qtManuTempoparadaDefault;

    private java.math.BigDecimal qtManuTempoparadaSemCnx;

    private java.math.BigDecimal qtManuTempoparadaSemEvt;

    private java.math.BigDecimal qtManuTempoparadaSemOp;

    private java.math.BigDecimal segAutoCta;

    private java.math.BigDecimal segAutoTempoparadaAb;

    private java.math.BigDecimal segAutoTempoparadaCp;

    private java.math.BigDecimal segAutoTempoparadaCpVr;

    private java.math.BigDecimal segAutoTempoparadaDefault;

    private java.math.BigDecimal segAutoTempoparadaSemCnx;

    private java.math.BigDecimal segAutoTempoparadaSemEvt;

    private java.math.BigDecimal segAutoTempoparadaSemOp;

    private java.math.BigDecimal segAutoTempoparadaSp;

    private java.math.BigDecimal segAutoTempoparadaSpVr;

    private java.math.BigDecimal segManuCta;

    private java.math.BigDecimal segManuTempoparadaCp;

    private java.math.BigDecimal segManuTempoparadaCpVr;

    private java.math.BigDecimal segManuTempoparadaDefault;

    private java.math.BigDecimal segManuTempoparadaSemCnx;

    private java.math.BigDecimal segManuTempoparadaSemEvt;

    private java.math.BigDecimal segManuTempoparadaSemOp;

    private java.math.BigDecimal segManuTempoparadaSp;

    private java.math.BigDecimal segManuTempoparadaSpVr;

    public DwConsolpa() {
    }

    public DwConsolpa(
           idw.idwws.DwConsol dwConsol,
           idw.idwws.DwConsolpamo[] dwConsolpamos,
           idw.idwws.DwConsolpaoco[] dwConsolpaocos,
           idw.idwws.DwTParada dwTParada,
           java.lang.Long idConsolpa,
           java.math.BigDecimal qtAutoOcoparadaCp,
           java.math.BigDecimal qtAutoOcoparadaCpVr,
           java.math.BigDecimal qtAutoOcoparadaSp,
           java.math.BigDecimal qtAutoOcoparadaSpVr,
           java.math.BigDecimal qtAutoTempoparadaDefault,
           java.math.BigDecimal qtAutoTempoparadaSemCnx,
           java.math.BigDecimal qtAutoTempoparadaSemEvt,
           java.math.BigDecimal qtAutoTempoparadaSemOp,
           java.math.BigDecimal qtManuOcoparadaCp,
           java.math.BigDecimal qtManuOcoparadaCpVr,
           java.math.BigDecimal qtManuOcoparadaSp,
           java.math.BigDecimal qtManuOcoparadaSpVr,
           java.math.BigDecimal qtManuTempoparadaDefault,
           java.math.BigDecimal qtManuTempoparadaSemCnx,
           java.math.BigDecimal qtManuTempoparadaSemEvt,
           java.math.BigDecimal qtManuTempoparadaSemOp,
           java.math.BigDecimal segAutoCta,
           java.math.BigDecimal segAutoTempoparadaAb,
           java.math.BigDecimal segAutoTempoparadaCp,
           java.math.BigDecimal segAutoTempoparadaCpVr,
           java.math.BigDecimal segAutoTempoparadaDefault,
           java.math.BigDecimal segAutoTempoparadaSemCnx,
           java.math.BigDecimal segAutoTempoparadaSemEvt,
           java.math.BigDecimal segAutoTempoparadaSemOp,
           java.math.BigDecimal segAutoTempoparadaSp,
           java.math.BigDecimal segAutoTempoparadaSpVr,
           java.math.BigDecimal segManuCta,
           java.math.BigDecimal segManuTempoparadaCp,
           java.math.BigDecimal segManuTempoparadaCpVr,
           java.math.BigDecimal segManuTempoparadaDefault,
           java.math.BigDecimal segManuTempoparadaSemCnx,
           java.math.BigDecimal segManuTempoparadaSemEvt,
           java.math.BigDecimal segManuTempoparadaSemOp,
           java.math.BigDecimal segManuTempoparadaSp,
           java.math.BigDecimal segManuTempoparadaSpVr) {
        this.dwConsol = dwConsol;
        this.dwConsolpamos = dwConsolpamos;
        this.dwConsolpaocos = dwConsolpaocos;
        this.dwTParada = dwTParada;
        this.idConsolpa = idConsolpa;
        this.qtAutoOcoparadaCp = qtAutoOcoparadaCp;
        this.qtAutoOcoparadaCpVr = qtAutoOcoparadaCpVr;
        this.qtAutoOcoparadaSp = qtAutoOcoparadaSp;
        this.qtAutoOcoparadaSpVr = qtAutoOcoparadaSpVr;
        this.qtAutoTempoparadaDefault = qtAutoTempoparadaDefault;
        this.qtAutoTempoparadaSemCnx = qtAutoTempoparadaSemCnx;
        this.qtAutoTempoparadaSemEvt = qtAutoTempoparadaSemEvt;
        this.qtAutoTempoparadaSemOp = qtAutoTempoparadaSemOp;
        this.qtManuOcoparadaCp = qtManuOcoparadaCp;
        this.qtManuOcoparadaCpVr = qtManuOcoparadaCpVr;
        this.qtManuOcoparadaSp = qtManuOcoparadaSp;
        this.qtManuOcoparadaSpVr = qtManuOcoparadaSpVr;
        this.qtManuTempoparadaDefault = qtManuTempoparadaDefault;
        this.qtManuTempoparadaSemCnx = qtManuTempoparadaSemCnx;
        this.qtManuTempoparadaSemEvt = qtManuTempoparadaSemEvt;
        this.qtManuTempoparadaSemOp = qtManuTempoparadaSemOp;
        this.segAutoCta = segAutoCta;
        this.segAutoTempoparadaAb = segAutoTempoparadaAb;
        this.segAutoTempoparadaCp = segAutoTempoparadaCp;
        this.segAutoTempoparadaCpVr = segAutoTempoparadaCpVr;
        this.segAutoTempoparadaDefault = segAutoTempoparadaDefault;
        this.segAutoTempoparadaSemCnx = segAutoTempoparadaSemCnx;
        this.segAutoTempoparadaSemEvt = segAutoTempoparadaSemEvt;
        this.segAutoTempoparadaSemOp = segAutoTempoparadaSemOp;
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
        this.segAutoTempoparadaSpVr = segAutoTempoparadaSpVr;
        this.segManuCta = segManuCta;
        this.segManuTempoparadaCp = segManuTempoparadaCp;
        this.segManuTempoparadaCpVr = segManuTempoparadaCpVr;
        this.segManuTempoparadaDefault = segManuTempoparadaDefault;
        this.segManuTempoparadaSemCnx = segManuTempoparadaSemCnx;
        this.segManuTempoparadaSemEvt = segManuTempoparadaSemEvt;
        this.segManuTempoparadaSemOp = segManuTempoparadaSemOp;
        this.segManuTempoparadaSp = segManuTempoparadaSp;
        this.segManuTempoparadaSpVr = segManuTempoparadaSpVr;
    }


    /**
     * Gets the dwConsol value for this DwConsolpa.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsolpa.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the dwConsolpamos value for this DwConsolpa.
     * 
     * @return dwConsolpamos
     */
    public idw.idwws.DwConsolpamo[] getDwConsolpamos() {
        return dwConsolpamos;
    }


    /**
     * Sets the dwConsolpamos value for this DwConsolpa.
     * 
     * @param dwConsolpamos
     */
    public void setDwConsolpamos(idw.idwws.DwConsolpamo[] dwConsolpamos) {
        this.dwConsolpamos = dwConsolpamos;
    }

    public idw.idwws.DwConsolpamo getDwConsolpamos(int i) {
        return this.dwConsolpamos[i];
    }

    public void setDwConsolpamos(int i, idw.idwws.DwConsolpamo _value) {
        this.dwConsolpamos[i] = _value;
    }


    /**
     * Gets the dwConsolpaocos value for this DwConsolpa.
     * 
     * @return dwConsolpaocos
     */
    public idw.idwws.DwConsolpaoco[] getDwConsolpaocos() {
        return dwConsolpaocos;
    }


    /**
     * Sets the dwConsolpaocos value for this DwConsolpa.
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
     * Gets the dwTParada value for this DwConsolpa.
     * 
     * @return dwTParada
     */
    public idw.idwws.DwTParada getDwTParada() {
        return dwTParada;
    }


    /**
     * Sets the dwTParada value for this DwConsolpa.
     * 
     * @param dwTParada
     */
    public void setDwTParada(idw.idwws.DwTParada dwTParada) {
        this.dwTParada = dwTParada;
    }


    /**
     * Gets the idConsolpa value for this DwConsolpa.
     * 
     * @return idConsolpa
     */
    public java.lang.Long getIdConsolpa() {
        return idConsolpa;
    }


    /**
     * Sets the idConsolpa value for this DwConsolpa.
     * 
     * @param idConsolpa
     */
    public void setIdConsolpa(java.lang.Long idConsolpa) {
        this.idConsolpa = idConsolpa;
    }


    /**
     * Gets the qtAutoOcoparadaCp value for this DwConsolpa.
     * 
     * @return qtAutoOcoparadaCp
     */
    public java.math.BigDecimal getQtAutoOcoparadaCp() {
        return qtAutoOcoparadaCp;
    }


    /**
     * Sets the qtAutoOcoparadaCp value for this DwConsolpa.
     * 
     * @param qtAutoOcoparadaCp
     */
    public void setQtAutoOcoparadaCp(java.math.BigDecimal qtAutoOcoparadaCp) {
        this.qtAutoOcoparadaCp = qtAutoOcoparadaCp;
    }


    /**
     * Gets the qtAutoOcoparadaCpVr value for this DwConsolpa.
     * 
     * @return qtAutoOcoparadaCpVr
     */
    public java.math.BigDecimal getQtAutoOcoparadaCpVr() {
        return qtAutoOcoparadaCpVr;
    }


    /**
     * Sets the qtAutoOcoparadaCpVr value for this DwConsolpa.
     * 
     * @param qtAutoOcoparadaCpVr
     */
    public void setQtAutoOcoparadaCpVr(java.math.BigDecimal qtAutoOcoparadaCpVr) {
        this.qtAutoOcoparadaCpVr = qtAutoOcoparadaCpVr;
    }


    /**
     * Gets the qtAutoOcoparadaSp value for this DwConsolpa.
     * 
     * @return qtAutoOcoparadaSp
     */
    public java.math.BigDecimal getQtAutoOcoparadaSp() {
        return qtAutoOcoparadaSp;
    }


    /**
     * Sets the qtAutoOcoparadaSp value for this DwConsolpa.
     * 
     * @param qtAutoOcoparadaSp
     */
    public void setQtAutoOcoparadaSp(java.math.BigDecimal qtAutoOcoparadaSp) {
        this.qtAutoOcoparadaSp = qtAutoOcoparadaSp;
    }


    /**
     * Gets the qtAutoOcoparadaSpVr value for this DwConsolpa.
     * 
     * @return qtAutoOcoparadaSpVr
     */
    public java.math.BigDecimal getQtAutoOcoparadaSpVr() {
        return qtAutoOcoparadaSpVr;
    }


    /**
     * Sets the qtAutoOcoparadaSpVr value for this DwConsolpa.
     * 
     * @param qtAutoOcoparadaSpVr
     */
    public void setQtAutoOcoparadaSpVr(java.math.BigDecimal qtAutoOcoparadaSpVr) {
        this.qtAutoOcoparadaSpVr = qtAutoOcoparadaSpVr;
    }


    /**
     * Gets the qtAutoTempoparadaDefault value for this DwConsolpa.
     * 
     * @return qtAutoTempoparadaDefault
     */
    public java.math.BigDecimal getQtAutoTempoparadaDefault() {
        return qtAutoTempoparadaDefault;
    }


    /**
     * Sets the qtAutoTempoparadaDefault value for this DwConsolpa.
     * 
     * @param qtAutoTempoparadaDefault
     */
    public void setQtAutoTempoparadaDefault(java.math.BigDecimal qtAutoTempoparadaDefault) {
        this.qtAutoTempoparadaDefault = qtAutoTempoparadaDefault;
    }


    /**
     * Gets the qtAutoTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @return qtAutoTempoparadaSemCnx
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemCnx() {
        return qtAutoTempoparadaSemCnx;
    }


    /**
     * Sets the qtAutoTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @param qtAutoTempoparadaSemCnx
     */
    public void setQtAutoTempoparadaSemCnx(java.math.BigDecimal qtAutoTempoparadaSemCnx) {
        this.qtAutoTempoparadaSemCnx = qtAutoTempoparadaSemCnx;
    }


    /**
     * Gets the qtAutoTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @return qtAutoTempoparadaSemEvt
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemEvt() {
        return qtAutoTempoparadaSemEvt;
    }


    /**
     * Sets the qtAutoTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @param qtAutoTempoparadaSemEvt
     */
    public void setQtAutoTempoparadaSemEvt(java.math.BigDecimal qtAutoTempoparadaSemEvt) {
        this.qtAutoTempoparadaSemEvt = qtAutoTempoparadaSemEvt;
    }


    /**
     * Gets the qtAutoTempoparadaSemOp value for this DwConsolpa.
     * 
     * @return qtAutoTempoparadaSemOp
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemOp() {
        return qtAutoTempoparadaSemOp;
    }


    /**
     * Sets the qtAutoTempoparadaSemOp value for this DwConsolpa.
     * 
     * @param qtAutoTempoparadaSemOp
     */
    public void setQtAutoTempoparadaSemOp(java.math.BigDecimal qtAutoTempoparadaSemOp) {
        this.qtAutoTempoparadaSemOp = qtAutoTempoparadaSemOp;
    }


    /**
     * Gets the qtManuOcoparadaCp value for this DwConsolpa.
     * 
     * @return qtManuOcoparadaCp
     */
    public java.math.BigDecimal getQtManuOcoparadaCp() {
        return qtManuOcoparadaCp;
    }


    /**
     * Sets the qtManuOcoparadaCp value for this DwConsolpa.
     * 
     * @param qtManuOcoparadaCp
     */
    public void setQtManuOcoparadaCp(java.math.BigDecimal qtManuOcoparadaCp) {
        this.qtManuOcoparadaCp = qtManuOcoparadaCp;
    }


    /**
     * Gets the qtManuOcoparadaCpVr value for this DwConsolpa.
     * 
     * @return qtManuOcoparadaCpVr
     */
    public java.math.BigDecimal getQtManuOcoparadaCpVr() {
        return qtManuOcoparadaCpVr;
    }


    /**
     * Sets the qtManuOcoparadaCpVr value for this DwConsolpa.
     * 
     * @param qtManuOcoparadaCpVr
     */
    public void setQtManuOcoparadaCpVr(java.math.BigDecimal qtManuOcoparadaCpVr) {
        this.qtManuOcoparadaCpVr = qtManuOcoparadaCpVr;
    }


    /**
     * Gets the qtManuOcoparadaSp value for this DwConsolpa.
     * 
     * @return qtManuOcoparadaSp
     */
    public java.math.BigDecimal getQtManuOcoparadaSp() {
        return qtManuOcoparadaSp;
    }


    /**
     * Sets the qtManuOcoparadaSp value for this DwConsolpa.
     * 
     * @param qtManuOcoparadaSp
     */
    public void setQtManuOcoparadaSp(java.math.BigDecimal qtManuOcoparadaSp) {
        this.qtManuOcoparadaSp = qtManuOcoparadaSp;
    }


    /**
     * Gets the qtManuOcoparadaSpVr value for this DwConsolpa.
     * 
     * @return qtManuOcoparadaSpVr
     */
    public java.math.BigDecimal getQtManuOcoparadaSpVr() {
        return qtManuOcoparadaSpVr;
    }


    /**
     * Sets the qtManuOcoparadaSpVr value for this DwConsolpa.
     * 
     * @param qtManuOcoparadaSpVr
     */
    public void setQtManuOcoparadaSpVr(java.math.BigDecimal qtManuOcoparadaSpVr) {
        this.qtManuOcoparadaSpVr = qtManuOcoparadaSpVr;
    }


    /**
     * Gets the qtManuTempoparadaDefault value for this DwConsolpa.
     * 
     * @return qtManuTempoparadaDefault
     */
    public java.math.BigDecimal getQtManuTempoparadaDefault() {
        return qtManuTempoparadaDefault;
    }


    /**
     * Sets the qtManuTempoparadaDefault value for this DwConsolpa.
     * 
     * @param qtManuTempoparadaDefault
     */
    public void setQtManuTempoparadaDefault(java.math.BigDecimal qtManuTempoparadaDefault) {
        this.qtManuTempoparadaDefault = qtManuTempoparadaDefault;
    }


    /**
     * Gets the qtManuTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @return qtManuTempoparadaSemCnx
     */
    public java.math.BigDecimal getQtManuTempoparadaSemCnx() {
        return qtManuTempoparadaSemCnx;
    }


    /**
     * Sets the qtManuTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @param qtManuTempoparadaSemCnx
     */
    public void setQtManuTempoparadaSemCnx(java.math.BigDecimal qtManuTempoparadaSemCnx) {
        this.qtManuTempoparadaSemCnx = qtManuTempoparadaSemCnx;
    }


    /**
     * Gets the qtManuTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @return qtManuTempoparadaSemEvt
     */
    public java.math.BigDecimal getQtManuTempoparadaSemEvt() {
        return qtManuTempoparadaSemEvt;
    }


    /**
     * Sets the qtManuTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @param qtManuTempoparadaSemEvt
     */
    public void setQtManuTempoparadaSemEvt(java.math.BigDecimal qtManuTempoparadaSemEvt) {
        this.qtManuTempoparadaSemEvt = qtManuTempoparadaSemEvt;
    }


    /**
     * Gets the qtManuTempoparadaSemOp value for this DwConsolpa.
     * 
     * @return qtManuTempoparadaSemOp
     */
    public java.math.BigDecimal getQtManuTempoparadaSemOp() {
        return qtManuTempoparadaSemOp;
    }


    /**
     * Sets the qtManuTempoparadaSemOp value for this DwConsolpa.
     * 
     * @param qtManuTempoparadaSemOp
     */
    public void setQtManuTempoparadaSemOp(java.math.BigDecimal qtManuTempoparadaSemOp) {
        this.qtManuTempoparadaSemOp = qtManuTempoparadaSemOp;
    }


    /**
     * Gets the segAutoCta value for this DwConsolpa.
     * 
     * @return segAutoCta
     */
    public java.math.BigDecimal getSegAutoCta() {
        return segAutoCta;
    }


    /**
     * Sets the segAutoCta value for this DwConsolpa.
     * 
     * @param segAutoCta
     */
    public void setSegAutoCta(java.math.BigDecimal segAutoCta) {
        this.segAutoCta = segAutoCta;
    }


    /**
     * Gets the segAutoTempoparadaAb value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaAb
     */
    public java.math.BigDecimal getSegAutoTempoparadaAb() {
        return segAutoTempoparadaAb;
    }


    /**
     * Sets the segAutoTempoparadaAb value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaAb
     */
    public void setSegAutoTempoparadaAb(java.math.BigDecimal segAutoTempoparadaAb) {
        this.segAutoTempoparadaAb = segAutoTempoparadaAb;
    }


    /**
     * Gets the segAutoTempoparadaCp value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaCp
     */
    public java.math.BigDecimal getSegAutoTempoparadaCp() {
        return segAutoTempoparadaCp;
    }


    /**
     * Sets the segAutoTempoparadaCp value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaCp
     */
    public void setSegAutoTempoparadaCp(java.math.BigDecimal segAutoTempoparadaCp) {
        this.segAutoTempoparadaCp = segAutoTempoparadaCp;
    }


    /**
     * Gets the segAutoTempoparadaCpVr value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaCpVr
     */
    public java.math.BigDecimal getSegAutoTempoparadaCpVr() {
        return segAutoTempoparadaCpVr;
    }


    /**
     * Sets the segAutoTempoparadaCpVr value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaCpVr
     */
    public void setSegAutoTempoparadaCpVr(java.math.BigDecimal segAutoTempoparadaCpVr) {
        this.segAutoTempoparadaCpVr = segAutoTempoparadaCpVr;
    }


    /**
     * Gets the segAutoTempoparadaDefault value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaDefault
     */
    public java.math.BigDecimal getSegAutoTempoparadaDefault() {
        return segAutoTempoparadaDefault;
    }


    /**
     * Sets the segAutoTempoparadaDefault value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaDefault
     */
    public void setSegAutoTempoparadaDefault(java.math.BigDecimal segAutoTempoparadaDefault) {
        this.segAutoTempoparadaDefault = segAutoTempoparadaDefault;
    }


    /**
     * Gets the segAutoTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaSemCnx
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemCnx() {
        return segAutoTempoparadaSemCnx;
    }


    /**
     * Sets the segAutoTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaSemCnx
     */
    public void setSegAutoTempoparadaSemCnx(java.math.BigDecimal segAutoTempoparadaSemCnx) {
        this.segAutoTempoparadaSemCnx = segAutoTempoparadaSemCnx;
    }


    /**
     * Gets the segAutoTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaSemEvt
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemEvt() {
        return segAutoTempoparadaSemEvt;
    }


    /**
     * Sets the segAutoTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaSemEvt
     */
    public void setSegAutoTempoparadaSemEvt(java.math.BigDecimal segAutoTempoparadaSemEvt) {
        this.segAutoTempoparadaSemEvt = segAutoTempoparadaSemEvt;
    }


    /**
     * Gets the segAutoTempoparadaSemOp value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaSemOp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemOp() {
        return segAutoTempoparadaSemOp;
    }


    /**
     * Sets the segAutoTempoparadaSemOp value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaSemOp
     */
    public void setSegAutoTempoparadaSemOp(java.math.BigDecimal segAutoTempoparadaSemOp) {
        this.segAutoTempoparadaSemOp = segAutoTempoparadaSemOp;
    }


    /**
     * Gets the segAutoTempoparadaSp value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaSp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSp() {
        return segAutoTempoparadaSp;
    }


    /**
     * Sets the segAutoTempoparadaSp value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaSp
     */
    public void setSegAutoTempoparadaSp(java.math.BigDecimal segAutoTempoparadaSp) {
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
    }


    /**
     * Gets the segAutoTempoparadaSpVr value for this DwConsolpa.
     * 
     * @return segAutoTempoparadaSpVr
     */
    public java.math.BigDecimal getSegAutoTempoparadaSpVr() {
        return segAutoTempoparadaSpVr;
    }


    /**
     * Sets the segAutoTempoparadaSpVr value for this DwConsolpa.
     * 
     * @param segAutoTempoparadaSpVr
     */
    public void setSegAutoTempoparadaSpVr(java.math.BigDecimal segAutoTempoparadaSpVr) {
        this.segAutoTempoparadaSpVr = segAutoTempoparadaSpVr;
    }


    /**
     * Gets the segManuCta value for this DwConsolpa.
     * 
     * @return segManuCta
     */
    public java.math.BigDecimal getSegManuCta() {
        return segManuCta;
    }


    /**
     * Sets the segManuCta value for this DwConsolpa.
     * 
     * @param segManuCta
     */
    public void setSegManuCta(java.math.BigDecimal segManuCta) {
        this.segManuCta = segManuCta;
    }


    /**
     * Gets the segManuTempoparadaCp value for this DwConsolpa.
     * 
     * @return segManuTempoparadaCp
     */
    public java.math.BigDecimal getSegManuTempoparadaCp() {
        return segManuTempoparadaCp;
    }


    /**
     * Sets the segManuTempoparadaCp value for this DwConsolpa.
     * 
     * @param segManuTempoparadaCp
     */
    public void setSegManuTempoparadaCp(java.math.BigDecimal segManuTempoparadaCp) {
        this.segManuTempoparadaCp = segManuTempoparadaCp;
    }


    /**
     * Gets the segManuTempoparadaCpVr value for this DwConsolpa.
     * 
     * @return segManuTempoparadaCpVr
     */
    public java.math.BigDecimal getSegManuTempoparadaCpVr() {
        return segManuTempoparadaCpVr;
    }


    /**
     * Sets the segManuTempoparadaCpVr value for this DwConsolpa.
     * 
     * @param segManuTempoparadaCpVr
     */
    public void setSegManuTempoparadaCpVr(java.math.BigDecimal segManuTempoparadaCpVr) {
        this.segManuTempoparadaCpVr = segManuTempoparadaCpVr;
    }


    /**
     * Gets the segManuTempoparadaDefault value for this DwConsolpa.
     * 
     * @return segManuTempoparadaDefault
     */
    public java.math.BigDecimal getSegManuTempoparadaDefault() {
        return segManuTempoparadaDefault;
    }


    /**
     * Sets the segManuTempoparadaDefault value for this DwConsolpa.
     * 
     * @param segManuTempoparadaDefault
     */
    public void setSegManuTempoparadaDefault(java.math.BigDecimal segManuTempoparadaDefault) {
        this.segManuTempoparadaDefault = segManuTempoparadaDefault;
    }


    /**
     * Gets the segManuTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @return segManuTempoparadaSemCnx
     */
    public java.math.BigDecimal getSegManuTempoparadaSemCnx() {
        return segManuTempoparadaSemCnx;
    }


    /**
     * Sets the segManuTempoparadaSemCnx value for this DwConsolpa.
     * 
     * @param segManuTempoparadaSemCnx
     */
    public void setSegManuTempoparadaSemCnx(java.math.BigDecimal segManuTempoparadaSemCnx) {
        this.segManuTempoparadaSemCnx = segManuTempoparadaSemCnx;
    }


    /**
     * Gets the segManuTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @return segManuTempoparadaSemEvt
     */
    public java.math.BigDecimal getSegManuTempoparadaSemEvt() {
        return segManuTempoparadaSemEvt;
    }


    /**
     * Sets the segManuTempoparadaSemEvt value for this DwConsolpa.
     * 
     * @param segManuTempoparadaSemEvt
     */
    public void setSegManuTempoparadaSemEvt(java.math.BigDecimal segManuTempoparadaSemEvt) {
        this.segManuTempoparadaSemEvt = segManuTempoparadaSemEvt;
    }


    /**
     * Gets the segManuTempoparadaSemOp value for this DwConsolpa.
     * 
     * @return segManuTempoparadaSemOp
     */
    public java.math.BigDecimal getSegManuTempoparadaSemOp() {
        return segManuTempoparadaSemOp;
    }


    /**
     * Sets the segManuTempoparadaSemOp value for this DwConsolpa.
     * 
     * @param segManuTempoparadaSemOp
     */
    public void setSegManuTempoparadaSemOp(java.math.BigDecimal segManuTempoparadaSemOp) {
        this.segManuTempoparadaSemOp = segManuTempoparadaSemOp;
    }


    /**
     * Gets the segManuTempoparadaSp value for this DwConsolpa.
     * 
     * @return segManuTempoparadaSp
     */
    public java.math.BigDecimal getSegManuTempoparadaSp() {
        return segManuTempoparadaSp;
    }


    /**
     * Sets the segManuTempoparadaSp value for this DwConsolpa.
     * 
     * @param segManuTempoparadaSp
     */
    public void setSegManuTempoparadaSp(java.math.BigDecimal segManuTempoparadaSp) {
        this.segManuTempoparadaSp = segManuTempoparadaSp;
    }


    /**
     * Gets the segManuTempoparadaSpVr value for this DwConsolpa.
     * 
     * @return segManuTempoparadaSpVr
     */
    public java.math.BigDecimal getSegManuTempoparadaSpVr() {
        return segManuTempoparadaSpVr;
    }


    /**
     * Sets the segManuTempoparadaSpVr value for this DwConsolpa.
     * 
     * @param segManuTempoparadaSpVr
     */
    public void setSegManuTempoparadaSpVr(java.math.BigDecimal segManuTempoparadaSpVr) {
        this.segManuTempoparadaSpVr = segManuTempoparadaSpVr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpa)) return false;
        DwConsolpa other = (DwConsolpa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwConsol==null && other.getDwConsol()==null) || 
             (this.dwConsol!=null &&
              this.dwConsol.equals(other.getDwConsol()))) &&
            ((this.dwConsolpamos==null && other.getDwConsolpamos()==null) || 
             (this.dwConsolpamos!=null &&
              java.util.Arrays.equals(this.dwConsolpamos, other.getDwConsolpamos()))) &&
            ((this.dwConsolpaocos==null && other.getDwConsolpaocos()==null) || 
             (this.dwConsolpaocos!=null &&
              java.util.Arrays.equals(this.dwConsolpaocos, other.getDwConsolpaocos()))) &&
            ((this.dwTParada==null && other.getDwTParada()==null) || 
             (this.dwTParada!=null &&
              this.dwTParada.equals(other.getDwTParada()))) &&
            ((this.idConsolpa==null && other.getIdConsolpa()==null) || 
             (this.idConsolpa!=null &&
              this.idConsolpa.equals(other.getIdConsolpa()))) &&
            ((this.qtAutoOcoparadaCp==null && other.getQtAutoOcoparadaCp()==null) || 
             (this.qtAutoOcoparadaCp!=null &&
              this.qtAutoOcoparadaCp.equals(other.getQtAutoOcoparadaCp()))) &&
            ((this.qtAutoOcoparadaCpVr==null && other.getQtAutoOcoparadaCpVr()==null) || 
             (this.qtAutoOcoparadaCpVr!=null &&
              this.qtAutoOcoparadaCpVr.equals(other.getQtAutoOcoparadaCpVr()))) &&
            ((this.qtAutoOcoparadaSp==null && other.getQtAutoOcoparadaSp()==null) || 
             (this.qtAutoOcoparadaSp!=null &&
              this.qtAutoOcoparadaSp.equals(other.getQtAutoOcoparadaSp()))) &&
            ((this.qtAutoOcoparadaSpVr==null && other.getQtAutoOcoparadaSpVr()==null) || 
             (this.qtAutoOcoparadaSpVr!=null &&
              this.qtAutoOcoparadaSpVr.equals(other.getQtAutoOcoparadaSpVr()))) &&
            ((this.qtAutoTempoparadaDefault==null && other.getQtAutoTempoparadaDefault()==null) || 
             (this.qtAutoTempoparadaDefault!=null &&
              this.qtAutoTempoparadaDefault.equals(other.getQtAutoTempoparadaDefault()))) &&
            ((this.qtAutoTempoparadaSemCnx==null && other.getQtAutoTempoparadaSemCnx()==null) || 
             (this.qtAutoTempoparadaSemCnx!=null &&
              this.qtAutoTempoparadaSemCnx.equals(other.getQtAutoTempoparadaSemCnx()))) &&
            ((this.qtAutoTempoparadaSemEvt==null && other.getQtAutoTempoparadaSemEvt()==null) || 
             (this.qtAutoTempoparadaSemEvt!=null &&
              this.qtAutoTempoparadaSemEvt.equals(other.getQtAutoTempoparadaSemEvt()))) &&
            ((this.qtAutoTempoparadaSemOp==null && other.getQtAutoTempoparadaSemOp()==null) || 
             (this.qtAutoTempoparadaSemOp!=null &&
              this.qtAutoTempoparadaSemOp.equals(other.getQtAutoTempoparadaSemOp()))) &&
            ((this.qtManuOcoparadaCp==null && other.getQtManuOcoparadaCp()==null) || 
             (this.qtManuOcoparadaCp!=null &&
              this.qtManuOcoparadaCp.equals(other.getQtManuOcoparadaCp()))) &&
            ((this.qtManuOcoparadaCpVr==null && other.getQtManuOcoparadaCpVr()==null) || 
             (this.qtManuOcoparadaCpVr!=null &&
              this.qtManuOcoparadaCpVr.equals(other.getQtManuOcoparadaCpVr()))) &&
            ((this.qtManuOcoparadaSp==null && other.getQtManuOcoparadaSp()==null) || 
             (this.qtManuOcoparadaSp!=null &&
              this.qtManuOcoparadaSp.equals(other.getQtManuOcoparadaSp()))) &&
            ((this.qtManuOcoparadaSpVr==null && other.getQtManuOcoparadaSpVr()==null) || 
             (this.qtManuOcoparadaSpVr!=null &&
              this.qtManuOcoparadaSpVr.equals(other.getQtManuOcoparadaSpVr()))) &&
            ((this.qtManuTempoparadaDefault==null && other.getQtManuTempoparadaDefault()==null) || 
             (this.qtManuTempoparadaDefault!=null &&
              this.qtManuTempoparadaDefault.equals(other.getQtManuTempoparadaDefault()))) &&
            ((this.qtManuTempoparadaSemCnx==null && other.getQtManuTempoparadaSemCnx()==null) || 
             (this.qtManuTempoparadaSemCnx!=null &&
              this.qtManuTempoparadaSemCnx.equals(other.getQtManuTempoparadaSemCnx()))) &&
            ((this.qtManuTempoparadaSemEvt==null && other.getQtManuTempoparadaSemEvt()==null) || 
             (this.qtManuTempoparadaSemEvt!=null &&
              this.qtManuTempoparadaSemEvt.equals(other.getQtManuTempoparadaSemEvt()))) &&
            ((this.qtManuTempoparadaSemOp==null && other.getQtManuTempoparadaSemOp()==null) || 
             (this.qtManuTempoparadaSemOp!=null &&
              this.qtManuTempoparadaSemOp.equals(other.getQtManuTempoparadaSemOp()))) &&
            ((this.segAutoCta==null && other.getSegAutoCta()==null) || 
             (this.segAutoCta!=null &&
              this.segAutoCta.equals(other.getSegAutoCta()))) &&
            ((this.segAutoTempoparadaAb==null && other.getSegAutoTempoparadaAb()==null) || 
             (this.segAutoTempoparadaAb!=null &&
              this.segAutoTempoparadaAb.equals(other.getSegAutoTempoparadaAb()))) &&
            ((this.segAutoTempoparadaCp==null && other.getSegAutoTempoparadaCp()==null) || 
             (this.segAutoTempoparadaCp!=null &&
              this.segAutoTempoparadaCp.equals(other.getSegAutoTempoparadaCp()))) &&
            ((this.segAutoTempoparadaCpVr==null && other.getSegAutoTempoparadaCpVr()==null) || 
             (this.segAutoTempoparadaCpVr!=null &&
              this.segAutoTempoparadaCpVr.equals(other.getSegAutoTempoparadaCpVr()))) &&
            ((this.segAutoTempoparadaDefault==null && other.getSegAutoTempoparadaDefault()==null) || 
             (this.segAutoTempoparadaDefault!=null &&
              this.segAutoTempoparadaDefault.equals(other.getSegAutoTempoparadaDefault()))) &&
            ((this.segAutoTempoparadaSemCnx==null && other.getSegAutoTempoparadaSemCnx()==null) || 
             (this.segAutoTempoparadaSemCnx!=null &&
              this.segAutoTempoparadaSemCnx.equals(other.getSegAutoTempoparadaSemCnx()))) &&
            ((this.segAutoTempoparadaSemEvt==null && other.getSegAutoTempoparadaSemEvt()==null) || 
             (this.segAutoTempoparadaSemEvt!=null &&
              this.segAutoTempoparadaSemEvt.equals(other.getSegAutoTempoparadaSemEvt()))) &&
            ((this.segAutoTempoparadaSemOp==null && other.getSegAutoTempoparadaSemOp()==null) || 
             (this.segAutoTempoparadaSemOp!=null &&
              this.segAutoTempoparadaSemOp.equals(other.getSegAutoTempoparadaSemOp()))) &&
            ((this.segAutoTempoparadaSp==null && other.getSegAutoTempoparadaSp()==null) || 
             (this.segAutoTempoparadaSp!=null &&
              this.segAutoTempoparadaSp.equals(other.getSegAutoTempoparadaSp()))) &&
            ((this.segAutoTempoparadaSpVr==null && other.getSegAutoTempoparadaSpVr()==null) || 
             (this.segAutoTempoparadaSpVr!=null &&
              this.segAutoTempoparadaSpVr.equals(other.getSegAutoTempoparadaSpVr()))) &&
            ((this.segManuCta==null && other.getSegManuCta()==null) || 
             (this.segManuCta!=null &&
              this.segManuCta.equals(other.getSegManuCta()))) &&
            ((this.segManuTempoparadaCp==null && other.getSegManuTempoparadaCp()==null) || 
             (this.segManuTempoparadaCp!=null &&
              this.segManuTempoparadaCp.equals(other.getSegManuTempoparadaCp()))) &&
            ((this.segManuTempoparadaCpVr==null && other.getSegManuTempoparadaCpVr()==null) || 
             (this.segManuTempoparadaCpVr!=null &&
              this.segManuTempoparadaCpVr.equals(other.getSegManuTempoparadaCpVr()))) &&
            ((this.segManuTempoparadaDefault==null && other.getSegManuTempoparadaDefault()==null) || 
             (this.segManuTempoparadaDefault!=null &&
              this.segManuTempoparadaDefault.equals(other.getSegManuTempoparadaDefault()))) &&
            ((this.segManuTempoparadaSemCnx==null && other.getSegManuTempoparadaSemCnx()==null) || 
             (this.segManuTempoparadaSemCnx!=null &&
              this.segManuTempoparadaSemCnx.equals(other.getSegManuTempoparadaSemCnx()))) &&
            ((this.segManuTempoparadaSemEvt==null && other.getSegManuTempoparadaSemEvt()==null) || 
             (this.segManuTempoparadaSemEvt!=null &&
              this.segManuTempoparadaSemEvt.equals(other.getSegManuTempoparadaSemEvt()))) &&
            ((this.segManuTempoparadaSemOp==null && other.getSegManuTempoparadaSemOp()==null) || 
             (this.segManuTempoparadaSemOp!=null &&
              this.segManuTempoparadaSemOp.equals(other.getSegManuTempoparadaSemOp()))) &&
            ((this.segManuTempoparadaSp==null && other.getSegManuTempoparadaSp()==null) || 
             (this.segManuTempoparadaSp!=null &&
              this.segManuTempoparadaSp.equals(other.getSegManuTempoparadaSp()))) &&
            ((this.segManuTempoparadaSpVr==null && other.getSegManuTempoparadaSpVr()==null) || 
             (this.segManuTempoparadaSpVr!=null &&
              this.segManuTempoparadaSpVr.equals(other.getSegManuTempoparadaSpVr())));
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
        if (getDwConsol() != null) {
            _hashCode += getDwConsol().hashCode();
        }
        if (getDwConsolpamos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpamos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpamos(), i);
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
        if (getDwTParada() != null) {
            _hashCode += getDwTParada().hashCode();
        }
        if (getIdConsolpa() != null) {
            _hashCode += getIdConsolpa().hashCode();
        }
        if (getQtAutoOcoparadaCp() != null) {
            _hashCode += getQtAutoOcoparadaCp().hashCode();
        }
        if (getQtAutoOcoparadaCpVr() != null) {
            _hashCode += getQtAutoOcoparadaCpVr().hashCode();
        }
        if (getQtAutoOcoparadaSp() != null) {
            _hashCode += getQtAutoOcoparadaSp().hashCode();
        }
        if (getQtAutoOcoparadaSpVr() != null) {
            _hashCode += getQtAutoOcoparadaSpVr().hashCode();
        }
        if (getQtAutoTempoparadaDefault() != null) {
            _hashCode += getQtAutoTempoparadaDefault().hashCode();
        }
        if (getQtAutoTempoparadaSemCnx() != null) {
            _hashCode += getQtAutoTempoparadaSemCnx().hashCode();
        }
        if (getQtAutoTempoparadaSemEvt() != null) {
            _hashCode += getQtAutoTempoparadaSemEvt().hashCode();
        }
        if (getQtAutoTempoparadaSemOp() != null) {
            _hashCode += getQtAutoTempoparadaSemOp().hashCode();
        }
        if (getQtManuOcoparadaCp() != null) {
            _hashCode += getQtManuOcoparadaCp().hashCode();
        }
        if (getQtManuOcoparadaCpVr() != null) {
            _hashCode += getQtManuOcoparadaCpVr().hashCode();
        }
        if (getQtManuOcoparadaSp() != null) {
            _hashCode += getQtManuOcoparadaSp().hashCode();
        }
        if (getQtManuOcoparadaSpVr() != null) {
            _hashCode += getQtManuOcoparadaSpVr().hashCode();
        }
        if (getQtManuTempoparadaDefault() != null) {
            _hashCode += getQtManuTempoparadaDefault().hashCode();
        }
        if (getQtManuTempoparadaSemCnx() != null) {
            _hashCode += getQtManuTempoparadaSemCnx().hashCode();
        }
        if (getQtManuTempoparadaSemEvt() != null) {
            _hashCode += getQtManuTempoparadaSemEvt().hashCode();
        }
        if (getQtManuTempoparadaSemOp() != null) {
            _hashCode += getQtManuTempoparadaSemOp().hashCode();
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
        if (getSegAutoTempoparadaCpVr() != null) {
            _hashCode += getSegAutoTempoparadaCpVr().hashCode();
        }
        if (getSegAutoTempoparadaDefault() != null) {
            _hashCode += getSegAutoTempoparadaDefault().hashCode();
        }
        if (getSegAutoTempoparadaSemCnx() != null) {
            _hashCode += getSegAutoTempoparadaSemCnx().hashCode();
        }
        if (getSegAutoTempoparadaSemEvt() != null) {
            _hashCode += getSegAutoTempoparadaSemEvt().hashCode();
        }
        if (getSegAutoTempoparadaSemOp() != null) {
            _hashCode += getSegAutoTempoparadaSemOp().hashCode();
        }
        if (getSegAutoTempoparadaSp() != null) {
            _hashCode += getSegAutoTempoparadaSp().hashCode();
        }
        if (getSegAutoTempoparadaSpVr() != null) {
            _hashCode += getSegAutoTempoparadaSpVr().hashCode();
        }
        if (getSegManuCta() != null) {
            _hashCode += getSegManuCta().hashCode();
        }
        if (getSegManuTempoparadaCp() != null) {
            _hashCode += getSegManuTempoparadaCp().hashCode();
        }
        if (getSegManuTempoparadaCpVr() != null) {
            _hashCode += getSegManuTempoparadaCpVr().hashCode();
        }
        if (getSegManuTempoparadaDefault() != null) {
            _hashCode += getSegManuTempoparadaDefault().hashCode();
        }
        if (getSegManuTempoparadaSemCnx() != null) {
            _hashCode += getSegManuTempoparadaSemCnx().hashCode();
        }
        if (getSegManuTempoparadaSemEvt() != null) {
            _hashCode += getSegManuTempoparadaSemEvt().hashCode();
        }
        if (getSegManuTempoparadaSemOp() != null) {
            _hashCode += getSegManuTempoparadaSemOp().hashCode();
        }
        if (getSegManuTempoparadaSp() != null) {
            _hashCode += getSegManuTempoparadaSp().hashCode();
        }
        if (getSegManuTempoparadaSpVr() != null) {
            _hashCode += getSegManuTempoparadaSpVr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpamos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpamos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpamo"));
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
        elemField.setFieldName("dwTParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("segAutoTempoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemOp"));
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
        elemField.setFieldName("segAutoTempoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSpVr"));
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
        elemField.setFieldName("segManuTempoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemOp"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSpVr"));
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
