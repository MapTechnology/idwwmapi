/**
 * Ijtboperacoes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtboperacoes  implements java.io.Serializable {
    private java.lang.String cdoperacao;

    private java.lang.String dsoperacao;

    private idw.idwws.Ijgrpdetestproc[] ijgrpdetestprocs;

    private idw.idwws.Ijgrpestproc[] ijgrpestprocs;

    private idw.idwws.Ijmovpostos[] ijmovpostoses;

    private idw.idwws.Ijoprotoper[] ijoprotopers;

    private idw.idwws.Ijroteiroprodhst[] ijroteiroprodhsts;

    private idw.idwws.Ijroteiroprod[] ijroteiroprods;

    private idw.idwws.Ijtbmol[] ijtbmols;

    private idw.idwws.Ijtbunidmedida ijtbunidmedida;

    private java.math.BigDecimal permiteopergrupo;

    private java.math.BigDecimal reqfim;

    private java.math.BigDecimal reqmaq;

    private java.math.BigDecimal reqop;

    private java.math.BigDecimal reqoper;

    private java.math.BigDecimal reqqtd;

    private java.math.BigDecimal tpoperacao;

    public Ijtboperacoes() {
    }

    public Ijtboperacoes(
           java.lang.String cdoperacao,
           java.lang.String dsoperacao,
           idw.idwws.Ijgrpdetestproc[] ijgrpdetestprocs,
           idw.idwws.Ijgrpestproc[] ijgrpestprocs,
           idw.idwws.Ijmovpostos[] ijmovpostoses,
           idw.idwws.Ijoprotoper[] ijoprotopers,
           idw.idwws.Ijroteiroprodhst[] ijroteiroprodhsts,
           idw.idwws.Ijroteiroprod[] ijroteiroprods,
           idw.idwws.Ijtbmol[] ijtbmols,
           idw.idwws.Ijtbunidmedida ijtbunidmedida,
           java.math.BigDecimal permiteopergrupo,
           java.math.BigDecimal reqfim,
           java.math.BigDecimal reqmaq,
           java.math.BigDecimal reqop,
           java.math.BigDecimal reqoper,
           java.math.BigDecimal reqqtd,
           java.math.BigDecimal tpoperacao) {
           this.cdoperacao = cdoperacao;
           this.dsoperacao = dsoperacao;
           this.ijgrpdetestprocs = ijgrpdetestprocs;
           this.ijgrpestprocs = ijgrpestprocs;
           this.ijmovpostoses = ijmovpostoses;
           this.ijoprotopers = ijoprotopers;
           this.ijroteiroprodhsts = ijroteiroprodhsts;
           this.ijroteiroprods = ijroteiroprods;
           this.ijtbmols = ijtbmols;
           this.ijtbunidmedida = ijtbunidmedida;
           this.permiteopergrupo = permiteopergrupo;
           this.reqfim = reqfim;
           this.reqmaq = reqmaq;
           this.reqop = reqop;
           this.reqoper = reqoper;
           this.reqqtd = reqqtd;
           this.tpoperacao = tpoperacao;
    }


    /**
     * Gets the cdoperacao value for this Ijtboperacoes.
     * 
     * @return cdoperacao
     */
    public java.lang.String getCdoperacao() {
        return cdoperacao;
    }


    /**
     * Sets the cdoperacao value for this Ijtboperacoes.
     * 
     * @param cdoperacao
     */
    public void setCdoperacao(java.lang.String cdoperacao) {
        this.cdoperacao = cdoperacao;
    }


    /**
     * Gets the dsoperacao value for this Ijtboperacoes.
     * 
     * @return dsoperacao
     */
    public java.lang.String getDsoperacao() {
        return dsoperacao;
    }


    /**
     * Sets the dsoperacao value for this Ijtboperacoes.
     * 
     * @param dsoperacao
     */
    public void setDsoperacao(java.lang.String dsoperacao) {
        this.dsoperacao = dsoperacao;
    }


    /**
     * Gets the ijgrpdetestprocs value for this Ijtboperacoes.
     * 
     * @return ijgrpdetestprocs
     */
    public idw.idwws.Ijgrpdetestproc[] getIjgrpdetestprocs() {
        return ijgrpdetestprocs;
    }


    /**
     * Sets the ijgrpdetestprocs value for this Ijtboperacoes.
     * 
     * @param ijgrpdetestprocs
     */
    public void setIjgrpdetestprocs(idw.idwws.Ijgrpdetestproc[] ijgrpdetestprocs) {
        this.ijgrpdetestprocs = ijgrpdetestprocs;
    }

    public idw.idwws.Ijgrpdetestproc getIjgrpdetestprocs(int i) {
        return this.ijgrpdetestprocs[i];
    }

    public void setIjgrpdetestprocs(int i, idw.idwws.Ijgrpdetestproc _value) {
        this.ijgrpdetestprocs[i] = _value;
    }


    /**
     * Gets the ijgrpestprocs value for this Ijtboperacoes.
     * 
     * @return ijgrpestprocs
     */
    public idw.idwws.Ijgrpestproc[] getIjgrpestprocs() {
        return ijgrpestprocs;
    }


    /**
     * Sets the ijgrpestprocs value for this Ijtboperacoes.
     * 
     * @param ijgrpestprocs
     */
    public void setIjgrpestprocs(idw.idwws.Ijgrpestproc[] ijgrpestprocs) {
        this.ijgrpestprocs = ijgrpestprocs;
    }

    public idw.idwws.Ijgrpestproc getIjgrpestprocs(int i) {
        return this.ijgrpestprocs[i];
    }

    public void setIjgrpestprocs(int i, idw.idwws.Ijgrpestproc _value) {
        this.ijgrpestprocs[i] = _value;
    }


    /**
     * Gets the ijmovpostoses value for this Ijtboperacoes.
     * 
     * @return ijmovpostoses
     */
    public idw.idwws.Ijmovpostos[] getIjmovpostoses() {
        return ijmovpostoses;
    }


    /**
     * Sets the ijmovpostoses value for this Ijtboperacoes.
     * 
     * @param ijmovpostoses
     */
    public void setIjmovpostoses(idw.idwws.Ijmovpostos[] ijmovpostoses) {
        this.ijmovpostoses = ijmovpostoses;
    }

    public idw.idwws.Ijmovpostos getIjmovpostoses(int i) {
        return this.ijmovpostoses[i];
    }

    public void setIjmovpostoses(int i, idw.idwws.Ijmovpostos _value) {
        this.ijmovpostoses[i] = _value;
    }


    /**
     * Gets the ijoprotopers value for this Ijtboperacoes.
     * 
     * @return ijoprotopers
     */
    public idw.idwws.Ijoprotoper[] getIjoprotopers() {
        return ijoprotopers;
    }


    /**
     * Sets the ijoprotopers value for this Ijtboperacoes.
     * 
     * @param ijoprotopers
     */
    public void setIjoprotopers(idw.idwws.Ijoprotoper[] ijoprotopers) {
        this.ijoprotopers = ijoprotopers;
    }

    public idw.idwws.Ijoprotoper getIjoprotopers(int i) {
        return this.ijoprotopers[i];
    }

    public void setIjoprotopers(int i, idw.idwws.Ijoprotoper _value) {
        this.ijoprotopers[i] = _value;
    }


    /**
     * Gets the ijroteiroprodhsts value for this Ijtboperacoes.
     * 
     * @return ijroteiroprodhsts
     */
    public idw.idwws.Ijroteiroprodhst[] getIjroteiroprodhsts() {
        return ijroteiroprodhsts;
    }


    /**
     * Sets the ijroteiroprodhsts value for this Ijtboperacoes.
     * 
     * @param ijroteiroprodhsts
     */
    public void setIjroteiroprodhsts(idw.idwws.Ijroteiroprodhst[] ijroteiroprodhsts) {
        this.ijroteiroprodhsts = ijroteiroprodhsts;
    }

    public idw.idwws.Ijroteiroprodhst getIjroteiroprodhsts(int i) {
        return this.ijroteiroprodhsts[i];
    }

    public void setIjroteiroprodhsts(int i, idw.idwws.Ijroteiroprodhst _value) {
        this.ijroteiroprodhsts[i] = _value;
    }


    /**
     * Gets the ijroteiroprods value for this Ijtboperacoes.
     * 
     * @return ijroteiroprods
     */
    public idw.idwws.Ijroteiroprod[] getIjroteiroprods() {
        return ijroteiroprods;
    }


    /**
     * Sets the ijroteiroprods value for this Ijtboperacoes.
     * 
     * @param ijroteiroprods
     */
    public void setIjroteiroprods(idw.idwws.Ijroteiroprod[] ijroteiroprods) {
        this.ijroteiroprods = ijroteiroprods;
    }

    public idw.idwws.Ijroteiroprod getIjroteiroprods(int i) {
        return this.ijroteiroprods[i];
    }

    public void setIjroteiroprods(int i, idw.idwws.Ijroteiroprod _value) {
        this.ijroteiroprods[i] = _value;
    }


    /**
     * Gets the ijtbmols value for this Ijtboperacoes.
     * 
     * @return ijtbmols
     */
    public idw.idwws.Ijtbmol[] getIjtbmols() {
        return ijtbmols;
    }


    /**
     * Sets the ijtbmols value for this Ijtboperacoes.
     * 
     * @param ijtbmols
     */
    public void setIjtbmols(idw.idwws.Ijtbmol[] ijtbmols) {
        this.ijtbmols = ijtbmols;
    }

    public idw.idwws.Ijtbmol getIjtbmols(int i) {
        return this.ijtbmols[i];
    }

    public void setIjtbmols(int i, idw.idwws.Ijtbmol _value) {
        this.ijtbmols[i] = _value;
    }


    /**
     * Gets the ijtbunidmedida value for this Ijtboperacoes.
     * 
     * @return ijtbunidmedida
     */
    public idw.idwws.Ijtbunidmedida getIjtbunidmedida() {
        return ijtbunidmedida;
    }


    /**
     * Sets the ijtbunidmedida value for this Ijtboperacoes.
     * 
     * @param ijtbunidmedida
     */
    public void setIjtbunidmedida(idw.idwws.Ijtbunidmedida ijtbunidmedida) {
        this.ijtbunidmedida = ijtbunidmedida;
    }


    /**
     * Gets the permiteopergrupo value for this Ijtboperacoes.
     * 
     * @return permiteopergrupo
     */
    public java.math.BigDecimal getPermiteopergrupo() {
        return permiteopergrupo;
    }


    /**
     * Sets the permiteopergrupo value for this Ijtboperacoes.
     * 
     * @param permiteopergrupo
     */
    public void setPermiteopergrupo(java.math.BigDecimal permiteopergrupo) {
        this.permiteopergrupo = permiteopergrupo;
    }


    /**
     * Gets the reqfim value for this Ijtboperacoes.
     * 
     * @return reqfim
     */
    public java.math.BigDecimal getReqfim() {
        return reqfim;
    }


    /**
     * Sets the reqfim value for this Ijtboperacoes.
     * 
     * @param reqfim
     */
    public void setReqfim(java.math.BigDecimal reqfim) {
        this.reqfim = reqfim;
    }


    /**
     * Gets the reqmaq value for this Ijtboperacoes.
     * 
     * @return reqmaq
     */
    public java.math.BigDecimal getReqmaq() {
        return reqmaq;
    }


    /**
     * Sets the reqmaq value for this Ijtboperacoes.
     * 
     * @param reqmaq
     */
    public void setReqmaq(java.math.BigDecimal reqmaq) {
        this.reqmaq = reqmaq;
    }


    /**
     * Gets the reqop value for this Ijtboperacoes.
     * 
     * @return reqop
     */
    public java.math.BigDecimal getReqop() {
        return reqop;
    }


    /**
     * Sets the reqop value for this Ijtboperacoes.
     * 
     * @param reqop
     */
    public void setReqop(java.math.BigDecimal reqop) {
        this.reqop = reqop;
    }


    /**
     * Gets the reqoper value for this Ijtboperacoes.
     * 
     * @return reqoper
     */
    public java.math.BigDecimal getReqoper() {
        return reqoper;
    }


    /**
     * Sets the reqoper value for this Ijtboperacoes.
     * 
     * @param reqoper
     */
    public void setReqoper(java.math.BigDecimal reqoper) {
        this.reqoper = reqoper;
    }


    /**
     * Gets the reqqtd value for this Ijtboperacoes.
     * 
     * @return reqqtd
     */
    public java.math.BigDecimal getReqqtd() {
        return reqqtd;
    }


    /**
     * Sets the reqqtd value for this Ijtboperacoes.
     * 
     * @param reqqtd
     */
    public void setReqqtd(java.math.BigDecimal reqqtd) {
        this.reqqtd = reqqtd;
    }


    /**
     * Gets the tpoperacao value for this Ijtboperacoes.
     * 
     * @return tpoperacao
     */
    public java.math.BigDecimal getTpoperacao() {
        return tpoperacao;
    }


    /**
     * Sets the tpoperacao value for this Ijtboperacoes.
     * 
     * @param tpoperacao
     */
    public void setTpoperacao(java.math.BigDecimal tpoperacao) {
        this.tpoperacao = tpoperacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtboperacoes)) return false;
        Ijtboperacoes other = (Ijtboperacoes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdoperacao==null && other.getCdoperacao()==null) || 
             (this.cdoperacao!=null &&
              this.cdoperacao.equals(other.getCdoperacao()))) &&
            ((this.dsoperacao==null && other.getDsoperacao()==null) || 
             (this.dsoperacao!=null &&
              this.dsoperacao.equals(other.getDsoperacao()))) &&
            ((this.ijgrpdetestprocs==null && other.getIjgrpdetestprocs()==null) || 
             (this.ijgrpdetestprocs!=null &&
              java.util.Arrays.equals(this.ijgrpdetestprocs, other.getIjgrpdetestprocs()))) &&
            ((this.ijgrpestprocs==null && other.getIjgrpestprocs()==null) || 
             (this.ijgrpestprocs!=null &&
              java.util.Arrays.equals(this.ijgrpestprocs, other.getIjgrpestprocs()))) &&
            ((this.ijmovpostoses==null && other.getIjmovpostoses()==null) || 
             (this.ijmovpostoses!=null &&
              java.util.Arrays.equals(this.ijmovpostoses, other.getIjmovpostoses()))) &&
            ((this.ijoprotopers==null && other.getIjoprotopers()==null) || 
             (this.ijoprotopers!=null &&
              java.util.Arrays.equals(this.ijoprotopers, other.getIjoprotopers()))) &&
            ((this.ijroteiroprodhsts==null && other.getIjroteiroprodhsts()==null) || 
             (this.ijroteiroprodhsts!=null &&
              java.util.Arrays.equals(this.ijroteiroprodhsts, other.getIjroteiroprodhsts()))) &&
            ((this.ijroteiroprods==null && other.getIjroteiroprods()==null) || 
             (this.ijroteiroprods!=null &&
              java.util.Arrays.equals(this.ijroteiroprods, other.getIjroteiroprods()))) &&
            ((this.ijtbmols==null && other.getIjtbmols()==null) || 
             (this.ijtbmols!=null &&
              java.util.Arrays.equals(this.ijtbmols, other.getIjtbmols()))) &&
            ((this.ijtbunidmedida==null && other.getIjtbunidmedida()==null) || 
             (this.ijtbunidmedida!=null &&
              this.ijtbunidmedida.equals(other.getIjtbunidmedida()))) &&
            ((this.permiteopergrupo==null && other.getPermiteopergrupo()==null) || 
             (this.permiteopergrupo!=null &&
              this.permiteopergrupo.equals(other.getPermiteopergrupo()))) &&
            ((this.reqfim==null && other.getReqfim()==null) || 
             (this.reqfim!=null &&
              this.reqfim.equals(other.getReqfim()))) &&
            ((this.reqmaq==null && other.getReqmaq()==null) || 
             (this.reqmaq!=null &&
              this.reqmaq.equals(other.getReqmaq()))) &&
            ((this.reqop==null && other.getReqop()==null) || 
             (this.reqop!=null &&
              this.reqop.equals(other.getReqop()))) &&
            ((this.reqoper==null && other.getReqoper()==null) || 
             (this.reqoper!=null &&
              this.reqoper.equals(other.getReqoper()))) &&
            ((this.reqqtd==null && other.getReqqtd()==null) || 
             (this.reqqtd!=null &&
              this.reqqtd.equals(other.getReqqtd()))) &&
            ((this.tpoperacao==null && other.getTpoperacao()==null) || 
             (this.tpoperacao!=null &&
              this.tpoperacao.equals(other.getTpoperacao())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCdoperacao() != null) {
            _hashCode += getCdoperacao().hashCode();
        }
        if (getDsoperacao() != null) {
            _hashCode += getDsoperacao().hashCode();
        }
        if (getIjgrpdetestprocs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetestprocs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetestprocs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpestprocs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpestprocs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpestprocs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmovpostoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmovpostoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmovpostoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoprotopers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoprotopers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoprotopers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjroteiroprodhsts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjroteiroprodhsts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjroteiroprodhsts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjroteiroprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjroteiroprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjroteiroprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmols(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbunidmedida() != null) {
            _hashCode += getIjtbunidmedida().hashCode();
        }
        if (getPermiteopergrupo() != null) {
            _hashCode += getPermiteopergrupo().hashCode();
        }
        if (getReqfim() != null) {
            _hashCode += getReqfim().hashCode();
        }
        if (getReqmaq() != null) {
            _hashCode += getReqmaq().hashCode();
        }
        if (getReqop() != null) {
            _hashCode += getReqop().hashCode();
        }
        if (getReqoper() != null) {
            _hashCode += getReqoper().hashCode();
        }
        if (getReqqtd() != null) {
            _hashCode += getReqqtd().hashCode();
        }
        if (getTpoperacao() != null) {
            _hashCode += getTpoperacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtboperacoes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsoperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsoperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetestprocs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetestprocs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetestproc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpestprocs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpestprocs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpestproc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmovpostoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmovpostoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmovpostos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoprotopers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoprotopers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoprotoper"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijroteiroprodhsts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijroteiroprodhsts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijroteiroprodhst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijroteiroprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijroteiroprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijroteiroprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbunidmedida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbunidmedida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbunidmedida"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permiteopergrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "permiteopergrupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqfim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqfim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqmaq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqmaq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqoper");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqoper"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqqtd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqqtd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpoperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpoperacao"));
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
