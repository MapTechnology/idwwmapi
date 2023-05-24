/**
 * DwRotapasso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwRotapasso  extends idw.idwws.DwRotapassoTemplate  implements java.io.Serializable {
    private idw.idwws.DwEst dwEst;

    private idw.idwws.DwEst dwEstConsumir;

    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwRota dwRota;

    private idw.idwws.DwRotapasso dwRotapassoByIdRotapassosucessoNc;

    private idw.idwws.DwRotapasso dwRotapassoByIdRotapassosucessoraC;

    private idw.idwws.DwRotapassoPt[] dwRotapassoPts;

    private idw.idwws.DwRotapasso[] dwRotapassosForIdRotapassosucessoNc;

    private idw.idwws.DwRotapasso[] dwRotapassosForIdRotapassosucessoraC;

    private idw.idwws.DwRpPredecessora[] dwRpPredecessorasForIdRotapassoFilho;

    private idw.idwws.DwRpPredecessora[] dwRpPredecessorasForIdRotapassoPai;

    private long idRotapasso;

    private java.lang.Boolean isLiberacao;

    private java.lang.String obs;

    private idw.idwws.OmObj[] omObjs;

    private idw.idwws.OmPt omPt;

    private java.math.BigDecimal passo;

    private java.lang.Double qtMovimentacao;

    private java.math.BigDecimal tpMovimentacao;

    public DwRotapasso() {
    }

    public DwRotapasso(
           idw.idwws.DwEst dwEst,
           idw.idwws.DwEst dwEstConsumir,
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwRota dwRota,
           idw.idwws.DwRotapasso dwRotapassoByIdRotapassosucessoNc,
           idw.idwws.DwRotapasso dwRotapassoByIdRotapassosucessoraC,
           idw.idwws.DwRotapassoPt[] dwRotapassoPts,
           idw.idwws.DwRotapasso[] dwRotapassosForIdRotapassosucessoNc,
           idw.idwws.DwRotapasso[] dwRotapassosForIdRotapassosucessoraC,
           idw.idwws.DwRpPredecessora[] dwRpPredecessorasForIdRotapassoFilho,
           idw.idwws.DwRpPredecessora[] dwRpPredecessorasForIdRotapassoPai,
           long idRotapasso,
           java.lang.Boolean isLiberacao,
           java.lang.String obs,
           idw.idwws.OmObj[] omObjs,
           idw.idwws.OmPt omPt,
           java.math.BigDecimal passo,
           java.lang.Double qtMovimentacao,
           java.math.BigDecimal tpMovimentacao) {
        this.dwEst = dwEst;
        this.dwEstConsumir = dwEstConsumir;
        this.dwFolha = dwFolha;
        this.dwRota = dwRota;
        this.dwRotapassoByIdRotapassosucessoNc = dwRotapassoByIdRotapassosucessoNc;
        this.dwRotapassoByIdRotapassosucessoraC = dwRotapassoByIdRotapassosucessoraC;
        this.dwRotapassoPts = dwRotapassoPts;
        this.dwRotapassosForIdRotapassosucessoNc = dwRotapassosForIdRotapassosucessoNc;
        this.dwRotapassosForIdRotapassosucessoraC = dwRotapassosForIdRotapassosucessoraC;
        this.dwRpPredecessorasForIdRotapassoFilho = dwRpPredecessorasForIdRotapassoFilho;
        this.dwRpPredecessorasForIdRotapassoPai = dwRpPredecessorasForIdRotapassoPai;
        this.idRotapasso = idRotapasso;
        this.isLiberacao = isLiberacao;
        this.obs = obs;
        this.omObjs = omObjs;
        this.omPt = omPt;
        this.passo = passo;
        this.qtMovimentacao = qtMovimentacao;
        this.tpMovimentacao = tpMovimentacao;
    }


    /**
     * Gets the dwEst value for this DwRotapasso.
     * 
     * @return dwEst
     */
    public idw.idwws.DwEst getDwEst() {
        return dwEst;
    }


    /**
     * Sets the dwEst value for this DwRotapasso.
     * 
     * @param dwEst
     */
    public void setDwEst(idw.idwws.DwEst dwEst) {
        this.dwEst = dwEst;
    }


    /**
     * Gets the dwEstConsumir value for this DwRotapasso.
     * 
     * @return dwEstConsumir
     */
    public idw.idwws.DwEst getDwEstConsumir() {
        return dwEstConsumir;
    }


    /**
     * Sets the dwEstConsumir value for this DwRotapasso.
     * 
     * @param dwEstConsumir
     */
    public void setDwEstConsumir(idw.idwws.DwEst dwEstConsumir) {
        this.dwEstConsumir = dwEstConsumir;
    }


    /**
     * Gets the dwFolha value for this DwRotapasso.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwRotapasso.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwRota value for this DwRotapasso.
     * 
     * @return dwRota
     */
    public idw.idwws.DwRota getDwRota() {
        return dwRota;
    }


    /**
     * Sets the dwRota value for this DwRotapasso.
     * 
     * @param dwRota
     */
    public void setDwRota(idw.idwws.DwRota dwRota) {
        this.dwRota = dwRota;
    }


    /**
     * Gets the dwRotapassoByIdRotapassosucessoNc value for this DwRotapasso.
     * 
     * @return dwRotapassoByIdRotapassosucessoNc
     */
    public idw.idwws.DwRotapasso getDwRotapassoByIdRotapassosucessoNc() {
        return dwRotapassoByIdRotapassosucessoNc;
    }


    /**
     * Sets the dwRotapassoByIdRotapassosucessoNc value for this DwRotapasso.
     * 
     * @param dwRotapassoByIdRotapassosucessoNc
     */
    public void setDwRotapassoByIdRotapassosucessoNc(idw.idwws.DwRotapasso dwRotapassoByIdRotapassosucessoNc) {
        this.dwRotapassoByIdRotapassosucessoNc = dwRotapassoByIdRotapassosucessoNc;
    }


    /**
     * Gets the dwRotapassoByIdRotapassosucessoraC value for this DwRotapasso.
     * 
     * @return dwRotapassoByIdRotapassosucessoraC
     */
    public idw.idwws.DwRotapasso getDwRotapassoByIdRotapassosucessoraC() {
        return dwRotapassoByIdRotapassosucessoraC;
    }


    /**
     * Sets the dwRotapassoByIdRotapassosucessoraC value for this DwRotapasso.
     * 
     * @param dwRotapassoByIdRotapassosucessoraC
     */
    public void setDwRotapassoByIdRotapassosucessoraC(idw.idwws.DwRotapasso dwRotapassoByIdRotapassosucessoraC) {
        this.dwRotapassoByIdRotapassosucessoraC = dwRotapassoByIdRotapassosucessoraC;
    }


    /**
     * Gets the dwRotapassoPts value for this DwRotapasso.
     * 
     * @return dwRotapassoPts
     */
    public idw.idwws.DwRotapassoPt[] getDwRotapassoPts() {
        return dwRotapassoPts;
    }


    /**
     * Sets the dwRotapassoPts value for this DwRotapasso.
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
     * Gets the dwRotapassosForIdRotapassosucessoNc value for this DwRotapasso.
     * 
     * @return dwRotapassosForIdRotapassosucessoNc
     */
    public idw.idwws.DwRotapasso[] getDwRotapassosForIdRotapassosucessoNc() {
        return dwRotapassosForIdRotapassosucessoNc;
    }


    /**
     * Sets the dwRotapassosForIdRotapassosucessoNc value for this DwRotapasso.
     * 
     * @param dwRotapassosForIdRotapassosucessoNc
     */
    public void setDwRotapassosForIdRotapassosucessoNc(idw.idwws.DwRotapasso[] dwRotapassosForIdRotapassosucessoNc) {
        this.dwRotapassosForIdRotapassosucessoNc = dwRotapassosForIdRotapassosucessoNc;
    }

    public idw.idwws.DwRotapasso getDwRotapassosForIdRotapassosucessoNc(int i) {
        return this.dwRotapassosForIdRotapassosucessoNc[i];
    }

    public void setDwRotapassosForIdRotapassosucessoNc(int i, idw.idwws.DwRotapasso _value) {
        this.dwRotapassosForIdRotapassosucessoNc[i] = _value;
    }


    /**
     * Gets the dwRotapassosForIdRotapassosucessoraC value for this DwRotapasso.
     * 
     * @return dwRotapassosForIdRotapassosucessoraC
     */
    public idw.idwws.DwRotapasso[] getDwRotapassosForIdRotapassosucessoraC() {
        return dwRotapassosForIdRotapassosucessoraC;
    }


    /**
     * Sets the dwRotapassosForIdRotapassosucessoraC value for this DwRotapasso.
     * 
     * @param dwRotapassosForIdRotapassosucessoraC
     */
    public void setDwRotapassosForIdRotapassosucessoraC(idw.idwws.DwRotapasso[] dwRotapassosForIdRotapassosucessoraC) {
        this.dwRotapassosForIdRotapassosucessoraC = dwRotapassosForIdRotapassosucessoraC;
    }

    public idw.idwws.DwRotapasso getDwRotapassosForIdRotapassosucessoraC(int i) {
        return this.dwRotapassosForIdRotapassosucessoraC[i];
    }

    public void setDwRotapassosForIdRotapassosucessoraC(int i, idw.idwws.DwRotapasso _value) {
        this.dwRotapassosForIdRotapassosucessoraC[i] = _value;
    }


    /**
     * Gets the dwRpPredecessorasForIdRotapassoFilho value for this DwRotapasso.
     * 
     * @return dwRpPredecessorasForIdRotapassoFilho
     */
    public idw.idwws.DwRpPredecessora[] getDwRpPredecessorasForIdRotapassoFilho() {
        return dwRpPredecessorasForIdRotapassoFilho;
    }


    /**
     * Sets the dwRpPredecessorasForIdRotapassoFilho value for this DwRotapasso.
     * 
     * @param dwRpPredecessorasForIdRotapassoFilho
     */
    public void setDwRpPredecessorasForIdRotapassoFilho(idw.idwws.DwRpPredecessora[] dwRpPredecessorasForIdRotapassoFilho) {
        this.dwRpPredecessorasForIdRotapassoFilho = dwRpPredecessorasForIdRotapassoFilho;
    }

    public idw.idwws.DwRpPredecessora getDwRpPredecessorasForIdRotapassoFilho(int i) {
        return this.dwRpPredecessorasForIdRotapassoFilho[i];
    }

    public void setDwRpPredecessorasForIdRotapassoFilho(int i, idw.idwws.DwRpPredecessora _value) {
        this.dwRpPredecessorasForIdRotapassoFilho[i] = _value;
    }


    /**
     * Gets the dwRpPredecessorasForIdRotapassoPai value for this DwRotapasso.
     * 
     * @return dwRpPredecessorasForIdRotapassoPai
     */
    public idw.idwws.DwRpPredecessora[] getDwRpPredecessorasForIdRotapassoPai() {
        return dwRpPredecessorasForIdRotapassoPai;
    }


    /**
     * Sets the dwRpPredecessorasForIdRotapassoPai value for this DwRotapasso.
     * 
     * @param dwRpPredecessorasForIdRotapassoPai
     */
    public void setDwRpPredecessorasForIdRotapassoPai(idw.idwws.DwRpPredecessora[] dwRpPredecessorasForIdRotapassoPai) {
        this.dwRpPredecessorasForIdRotapassoPai = dwRpPredecessorasForIdRotapassoPai;
    }

    public idw.idwws.DwRpPredecessora getDwRpPredecessorasForIdRotapassoPai(int i) {
        return this.dwRpPredecessorasForIdRotapassoPai[i];
    }

    public void setDwRpPredecessorasForIdRotapassoPai(int i, idw.idwws.DwRpPredecessora _value) {
        this.dwRpPredecessorasForIdRotapassoPai[i] = _value;
    }


    /**
     * Gets the idRotapasso value for this DwRotapasso.
     * 
     * @return idRotapasso
     */
    public long getIdRotapasso() {
        return idRotapasso;
    }


    /**
     * Sets the idRotapasso value for this DwRotapasso.
     * 
     * @param idRotapasso
     */
    public void setIdRotapasso(long idRotapasso) {
        this.idRotapasso = idRotapasso;
    }


    /**
     * Gets the isLiberacao value for this DwRotapasso.
     * 
     * @return isLiberacao
     */
    public java.lang.Boolean getIsLiberacao() {
        return isLiberacao;
    }


    /**
     * Sets the isLiberacao value for this DwRotapasso.
     * 
     * @param isLiberacao
     */
    public void setIsLiberacao(java.lang.Boolean isLiberacao) {
        this.isLiberacao = isLiberacao;
    }


    /**
     * Gets the obs value for this DwRotapasso.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this DwRotapasso.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the omObjs value for this DwRotapasso.
     * 
     * @return omObjs
     */
    public idw.idwws.OmObj[] getOmObjs() {
        return omObjs;
    }


    /**
     * Sets the omObjs value for this DwRotapasso.
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
     * Gets the omPt value for this DwRotapasso.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwRotapasso.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the passo value for this DwRotapasso.
     * 
     * @return passo
     */
    public java.math.BigDecimal getPasso() {
        return passo;
    }


    /**
     * Sets the passo value for this DwRotapasso.
     * 
     * @param passo
     */
    public void setPasso(java.math.BigDecimal passo) {
        this.passo = passo;
    }


    /**
     * Gets the qtMovimentacao value for this DwRotapasso.
     * 
     * @return qtMovimentacao
     */
    public java.lang.Double getQtMovimentacao() {
        return qtMovimentacao;
    }


    /**
     * Sets the qtMovimentacao value for this DwRotapasso.
     * 
     * @param qtMovimentacao
     */
    public void setQtMovimentacao(java.lang.Double qtMovimentacao) {
        this.qtMovimentacao = qtMovimentacao;
    }


    /**
     * Gets the tpMovimentacao value for this DwRotapasso.
     * 
     * @return tpMovimentacao
     */
    public java.math.BigDecimal getTpMovimentacao() {
        return tpMovimentacao;
    }


    /**
     * Sets the tpMovimentacao value for this DwRotapasso.
     * 
     * @param tpMovimentacao
     */
    public void setTpMovimentacao(java.math.BigDecimal tpMovimentacao) {
        this.tpMovimentacao = tpMovimentacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwRotapasso)) return false;
        DwRotapasso other = (DwRotapasso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwEst==null && other.getDwEst()==null) || 
             (this.dwEst!=null &&
              this.dwEst.equals(other.getDwEst()))) &&
            ((this.dwEstConsumir==null && other.getDwEstConsumir()==null) || 
             (this.dwEstConsumir!=null &&
              this.dwEstConsumir.equals(other.getDwEstConsumir()))) &&
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.dwRota==null && other.getDwRota()==null) || 
             (this.dwRota!=null &&
              this.dwRota.equals(other.getDwRota()))) &&
            ((this.dwRotapassoByIdRotapassosucessoNc==null && other.getDwRotapassoByIdRotapassosucessoNc()==null) || 
             (this.dwRotapassoByIdRotapassosucessoNc!=null &&
              this.dwRotapassoByIdRotapassosucessoNc.equals(other.getDwRotapassoByIdRotapassosucessoNc()))) &&
            ((this.dwRotapassoByIdRotapassosucessoraC==null && other.getDwRotapassoByIdRotapassosucessoraC()==null) || 
             (this.dwRotapassoByIdRotapassosucessoraC!=null &&
              this.dwRotapassoByIdRotapassosucessoraC.equals(other.getDwRotapassoByIdRotapassosucessoraC()))) &&
            ((this.dwRotapassoPts==null && other.getDwRotapassoPts()==null) || 
             (this.dwRotapassoPts!=null &&
              java.util.Arrays.equals(this.dwRotapassoPts, other.getDwRotapassoPts()))) &&
            ((this.dwRotapassosForIdRotapassosucessoNc==null && other.getDwRotapassosForIdRotapassosucessoNc()==null) || 
             (this.dwRotapassosForIdRotapassosucessoNc!=null &&
              java.util.Arrays.equals(this.dwRotapassosForIdRotapassosucessoNc, other.getDwRotapassosForIdRotapassosucessoNc()))) &&
            ((this.dwRotapassosForIdRotapassosucessoraC==null && other.getDwRotapassosForIdRotapassosucessoraC()==null) || 
             (this.dwRotapassosForIdRotapassosucessoraC!=null &&
              java.util.Arrays.equals(this.dwRotapassosForIdRotapassosucessoraC, other.getDwRotapassosForIdRotapassosucessoraC()))) &&
            ((this.dwRpPredecessorasForIdRotapassoFilho==null && other.getDwRpPredecessorasForIdRotapassoFilho()==null) || 
             (this.dwRpPredecessorasForIdRotapassoFilho!=null &&
              java.util.Arrays.equals(this.dwRpPredecessorasForIdRotapassoFilho, other.getDwRpPredecessorasForIdRotapassoFilho()))) &&
            ((this.dwRpPredecessorasForIdRotapassoPai==null && other.getDwRpPredecessorasForIdRotapassoPai()==null) || 
             (this.dwRpPredecessorasForIdRotapassoPai!=null &&
              java.util.Arrays.equals(this.dwRpPredecessorasForIdRotapassoPai, other.getDwRpPredecessorasForIdRotapassoPai()))) &&
            this.idRotapasso == other.getIdRotapasso() &&
            ((this.isLiberacao==null && other.getIsLiberacao()==null) || 
             (this.isLiberacao!=null &&
              this.isLiberacao.equals(other.getIsLiberacao()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.omObjs==null && other.getOmObjs()==null) || 
             (this.omObjs!=null &&
              java.util.Arrays.equals(this.omObjs, other.getOmObjs()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.passo==null && other.getPasso()==null) || 
             (this.passo!=null &&
              this.passo.equals(other.getPasso()))) &&
            ((this.qtMovimentacao==null && other.getQtMovimentacao()==null) || 
             (this.qtMovimentacao!=null &&
              this.qtMovimentacao.equals(other.getQtMovimentacao()))) &&
            ((this.tpMovimentacao==null && other.getTpMovimentacao()==null) || 
             (this.tpMovimentacao!=null &&
              this.tpMovimentacao.equals(other.getTpMovimentacao())));
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
        if (getDwEst() != null) {
            _hashCode += getDwEst().hashCode();
        }
        if (getDwEstConsumir() != null) {
            _hashCode += getDwEstConsumir().hashCode();
        }
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getDwRota() != null) {
            _hashCode += getDwRota().hashCode();
        }
        if (getDwRotapassoByIdRotapassosucessoNc() != null) {
            _hashCode += getDwRotapassoByIdRotapassosucessoNc().hashCode();
        }
        if (getDwRotapassoByIdRotapassosucessoraC() != null) {
            _hashCode += getDwRotapassoByIdRotapassosucessoraC().hashCode();
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
        if (getDwRotapassosForIdRotapassosucessoNc() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotapassosForIdRotapassosucessoNc());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotapassosForIdRotapassosucessoNc(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRotapassosForIdRotapassosucessoraC() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotapassosForIdRotapassosucessoraC());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotapassosForIdRotapassosucessoraC(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRpPredecessorasForIdRotapassoFilho() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRpPredecessorasForIdRotapassoFilho());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRpPredecessorasForIdRotapassoFilho(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRpPredecessorasForIdRotapassoPai() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRpPredecessorasForIdRotapassoPai());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRpPredecessorasForIdRotapassoPai(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdRotapasso()).hashCode();
        if (getIsLiberacao() != null) {
            _hashCode += getIsLiberacao().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
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
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPasso() != null) {
            _hashCode += getPasso().hashCode();
        }
        if (getQtMovimentacao() != null) {
            _hashCode += getQtMovimentacao().hashCode();
        }
        if (getTpMovimentacao() != null) {
            _hashCode += getTpMovimentacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwRotapasso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstConsumir");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstConsumir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassoByIdRotapassosucessoNc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassoByIdRotapassosucessoNc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassoByIdRotapassosucessoraC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassoByIdRotapassosucessoraC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("dwRotapassosForIdRotapassosucessoNc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassosForIdRotapassosucessoNc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassosForIdRotapassosucessoraC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassosForIdRotapassosucessoraC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRpPredecessorasForIdRotapassoFilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRpPredecessorasForIdRotapassoFilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRpPredecessora"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRpPredecessorasForIdRotapassoPai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRpPredecessorasForIdRotapassoPai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRpPredecessora"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRotapasso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRotapasso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLiberacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isLiberacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMovimentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMovimentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpMovimentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpMovimentacao"));
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
