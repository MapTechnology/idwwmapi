/**
 * Ijtbref.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbref  implements java.io.Serializable {
    private java.lang.String cdrefugo;

    private java.lang.String dsrefugo;

    private idw.idwws.Ijareres ijareres;

    private idw.idwws.Ijgrpdetref[] ijgrpdetrefs;

    private idw.idwws.Ijpdcapadrao[] ijpdcapadraos;

    private idw.idwws.Ijqldinspecao[] ijqldinspecaos;

    private idw.idwws.Ijqldinsploterep[] ijqldinsplotereps;

    private idw.idwws.Ijrearef[] ijrearefs;

    private idw.idwws.Ijrefman[] ijrefmans;

    private idw.idwws.Ijrelproref[] ijrelprorefs;

    private java.lang.Double indtolerqld;

    private java.math.BigDecimal lrequeracao;

    private java.math.BigDecimal lrequercausa;

    private org.apache.axis.types.UnsignedShort refreprocesso;

    private java.lang.Integer stativo;

    public Ijtbref() {
    }

    public Ijtbref(
           java.lang.String cdrefugo,
           java.lang.String dsrefugo,
           idw.idwws.Ijareres ijareres,
           idw.idwws.Ijgrpdetref[] ijgrpdetrefs,
           idw.idwws.Ijpdcapadrao[] ijpdcapadraos,
           idw.idwws.Ijqldinspecao[] ijqldinspecaos,
           idw.idwws.Ijqldinsploterep[] ijqldinsplotereps,
           idw.idwws.Ijrearef[] ijrearefs,
           idw.idwws.Ijrefman[] ijrefmans,
           idw.idwws.Ijrelproref[] ijrelprorefs,
           java.lang.Double indtolerqld,
           java.math.BigDecimal lrequeracao,
           java.math.BigDecimal lrequercausa,
           org.apache.axis.types.UnsignedShort refreprocesso,
           java.lang.Integer stativo) {
           this.cdrefugo = cdrefugo;
           this.dsrefugo = dsrefugo;
           this.ijareres = ijareres;
           this.ijgrpdetrefs = ijgrpdetrefs;
           this.ijpdcapadraos = ijpdcapadraos;
           this.ijqldinspecaos = ijqldinspecaos;
           this.ijqldinsplotereps = ijqldinsplotereps;
           this.ijrearefs = ijrearefs;
           this.ijrefmans = ijrefmans;
           this.ijrelprorefs = ijrelprorefs;
           this.indtolerqld = indtolerqld;
           this.lrequeracao = lrequeracao;
           this.lrequercausa = lrequercausa;
           this.refreprocesso = refreprocesso;
           this.stativo = stativo;
    }


    /**
     * Gets the cdrefugo value for this Ijtbref.
     * 
     * @return cdrefugo
     */
    public java.lang.String getCdrefugo() {
        return cdrefugo;
    }


    /**
     * Sets the cdrefugo value for this Ijtbref.
     * 
     * @param cdrefugo
     */
    public void setCdrefugo(java.lang.String cdrefugo) {
        this.cdrefugo = cdrefugo;
    }


    /**
     * Gets the dsrefugo value for this Ijtbref.
     * 
     * @return dsrefugo
     */
    public java.lang.String getDsrefugo() {
        return dsrefugo;
    }


    /**
     * Sets the dsrefugo value for this Ijtbref.
     * 
     * @param dsrefugo
     */
    public void setDsrefugo(java.lang.String dsrefugo) {
        this.dsrefugo = dsrefugo;
    }


    /**
     * Gets the ijareres value for this Ijtbref.
     * 
     * @return ijareres
     */
    public idw.idwws.Ijareres getIjareres() {
        return ijareres;
    }


    /**
     * Sets the ijareres value for this Ijtbref.
     * 
     * @param ijareres
     */
    public void setIjareres(idw.idwws.Ijareres ijareres) {
        this.ijareres = ijareres;
    }


    /**
     * Gets the ijgrpdetrefs value for this Ijtbref.
     * 
     * @return ijgrpdetrefs
     */
    public idw.idwws.Ijgrpdetref[] getIjgrpdetrefs() {
        return ijgrpdetrefs;
    }


    /**
     * Sets the ijgrpdetrefs value for this Ijtbref.
     * 
     * @param ijgrpdetrefs
     */
    public void setIjgrpdetrefs(idw.idwws.Ijgrpdetref[] ijgrpdetrefs) {
        this.ijgrpdetrefs = ijgrpdetrefs;
    }

    public idw.idwws.Ijgrpdetref getIjgrpdetrefs(int i) {
        return this.ijgrpdetrefs[i];
    }

    public void setIjgrpdetrefs(int i, idw.idwws.Ijgrpdetref _value) {
        this.ijgrpdetrefs[i] = _value;
    }


    /**
     * Gets the ijpdcapadraos value for this Ijtbref.
     * 
     * @return ijpdcapadraos
     */
    public idw.idwws.Ijpdcapadrao[] getIjpdcapadraos() {
        return ijpdcapadraos;
    }


    /**
     * Sets the ijpdcapadraos value for this Ijtbref.
     * 
     * @param ijpdcapadraos
     */
    public void setIjpdcapadraos(idw.idwws.Ijpdcapadrao[] ijpdcapadraos) {
        this.ijpdcapadraos = ijpdcapadraos;
    }

    public idw.idwws.Ijpdcapadrao getIjpdcapadraos(int i) {
        return this.ijpdcapadraos[i];
    }

    public void setIjpdcapadraos(int i, idw.idwws.Ijpdcapadrao _value) {
        this.ijpdcapadraos[i] = _value;
    }


    /**
     * Gets the ijqldinspecaos value for this Ijtbref.
     * 
     * @return ijqldinspecaos
     */
    public idw.idwws.Ijqldinspecao[] getIjqldinspecaos() {
        return ijqldinspecaos;
    }


    /**
     * Sets the ijqldinspecaos value for this Ijtbref.
     * 
     * @param ijqldinspecaos
     */
    public void setIjqldinspecaos(idw.idwws.Ijqldinspecao[] ijqldinspecaos) {
        this.ijqldinspecaos = ijqldinspecaos;
    }

    public idw.idwws.Ijqldinspecao getIjqldinspecaos(int i) {
        return this.ijqldinspecaos[i];
    }

    public void setIjqldinspecaos(int i, idw.idwws.Ijqldinspecao _value) {
        this.ijqldinspecaos[i] = _value;
    }


    /**
     * Gets the ijqldinsplotereps value for this Ijtbref.
     * 
     * @return ijqldinsplotereps
     */
    public idw.idwws.Ijqldinsploterep[] getIjqldinsplotereps() {
        return ijqldinsplotereps;
    }


    /**
     * Sets the ijqldinsplotereps value for this Ijtbref.
     * 
     * @param ijqldinsplotereps
     */
    public void setIjqldinsplotereps(idw.idwws.Ijqldinsploterep[] ijqldinsplotereps) {
        this.ijqldinsplotereps = ijqldinsplotereps;
    }

    public idw.idwws.Ijqldinsploterep getIjqldinsplotereps(int i) {
        return this.ijqldinsplotereps[i];
    }

    public void setIjqldinsplotereps(int i, idw.idwws.Ijqldinsploterep _value) {
        this.ijqldinsplotereps[i] = _value;
    }


    /**
     * Gets the ijrearefs value for this Ijtbref.
     * 
     * @return ijrearefs
     */
    public idw.idwws.Ijrearef[] getIjrearefs() {
        return ijrearefs;
    }


    /**
     * Sets the ijrearefs value for this Ijtbref.
     * 
     * @param ijrearefs
     */
    public void setIjrearefs(idw.idwws.Ijrearef[] ijrearefs) {
        this.ijrearefs = ijrearefs;
    }

    public idw.idwws.Ijrearef getIjrearefs(int i) {
        return this.ijrearefs[i];
    }

    public void setIjrearefs(int i, idw.idwws.Ijrearef _value) {
        this.ijrearefs[i] = _value;
    }


    /**
     * Gets the ijrefmans value for this Ijtbref.
     * 
     * @return ijrefmans
     */
    public idw.idwws.Ijrefman[] getIjrefmans() {
        return ijrefmans;
    }


    /**
     * Sets the ijrefmans value for this Ijtbref.
     * 
     * @param ijrefmans
     */
    public void setIjrefmans(idw.idwws.Ijrefman[] ijrefmans) {
        this.ijrefmans = ijrefmans;
    }

    public idw.idwws.Ijrefman getIjrefmans(int i) {
        return this.ijrefmans[i];
    }

    public void setIjrefmans(int i, idw.idwws.Ijrefman _value) {
        this.ijrefmans[i] = _value;
    }


    /**
     * Gets the ijrelprorefs value for this Ijtbref.
     * 
     * @return ijrelprorefs
     */
    public idw.idwws.Ijrelproref[] getIjrelprorefs() {
        return ijrelprorefs;
    }


    /**
     * Sets the ijrelprorefs value for this Ijtbref.
     * 
     * @param ijrelprorefs
     */
    public void setIjrelprorefs(idw.idwws.Ijrelproref[] ijrelprorefs) {
        this.ijrelprorefs = ijrelprorefs;
    }

    public idw.idwws.Ijrelproref getIjrelprorefs(int i) {
        return this.ijrelprorefs[i];
    }

    public void setIjrelprorefs(int i, idw.idwws.Ijrelproref _value) {
        this.ijrelprorefs[i] = _value;
    }


    /**
     * Gets the indtolerqld value for this Ijtbref.
     * 
     * @return indtolerqld
     */
    public java.lang.Double getIndtolerqld() {
        return indtolerqld;
    }


    /**
     * Sets the indtolerqld value for this Ijtbref.
     * 
     * @param indtolerqld
     */
    public void setIndtolerqld(java.lang.Double indtolerqld) {
        this.indtolerqld = indtolerqld;
    }


    /**
     * Gets the lrequeracao value for this Ijtbref.
     * 
     * @return lrequeracao
     */
    public java.math.BigDecimal getLrequeracao() {
        return lrequeracao;
    }


    /**
     * Sets the lrequeracao value for this Ijtbref.
     * 
     * @param lrequeracao
     */
    public void setLrequeracao(java.math.BigDecimal lrequeracao) {
        this.lrequeracao = lrequeracao;
    }


    /**
     * Gets the lrequercausa value for this Ijtbref.
     * 
     * @return lrequercausa
     */
    public java.math.BigDecimal getLrequercausa() {
        return lrequercausa;
    }


    /**
     * Sets the lrequercausa value for this Ijtbref.
     * 
     * @param lrequercausa
     */
    public void setLrequercausa(java.math.BigDecimal lrequercausa) {
        this.lrequercausa = lrequercausa;
    }


    /**
     * Gets the refreprocesso value for this Ijtbref.
     * 
     * @return refreprocesso
     */
    public org.apache.axis.types.UnsignedShort getRefreprocesso() {
        return refreprocesso;
    }


    /**
     * Sets the refreprocesso value for this Ijtbref.
     * 
     * @param refreprocesso
     */
    public void setRefreprocesso(org.apache.axis.types.UnsignedShort refreprocesso) {
        this.refreprocesso = refreprocesso;
    }


    /**
     * Gets the stativo value for this Ijtbref.
     * 
     * @return stativo
     */
    public java.lang.Integer getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbref.
     * 
     * @param stativo
     */
    public void setStativo(java.lang.Integer stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbref)) return false;
        Ijtbref other = (Ijtbref) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdrefugo==null && other.getCdrefugo()==null) || 
             (this.cdrefugo!=null &&
              this.cdrefugo.equals(other.getCdrefugo()))) &&
            ((this.dsrefugo==null && other.getDsrefugo()==null) || 
             (this.dsrefugo!=null &&
              this.dsrefugo.equals(other.getDsrefugo()))) &&
            ((this.ijareres==null && other.getIjareres()==null) || 
             (this.ijareres!=null &&
              this.ijareres.equals(other.getIjareres()))) &&
            ((this.ijgrpdetrefs==null && other.getIjgrpdetrefs()==null) || 
             (this.ijgrpdetrefs!=null &&
              java.util.Arrays.equals(this.ijgrpdetrefs, other.getIjgrpdetrefs()))) &&
            ((this.ijpdcapadraos==null && other.getIjpdcapadraos()==null) || 
             (this.ijpdcapadraos!=null &&
              java.util.Arrays.equals(this.ijpdcapadraos, other.getIjpdcapadraos()))) &&
            ((this.ijqldinspecaos==null && other.getIjqldinspecaos()==null) || 
             (this.ijqldinspecaos!=null &&
              java.util.Arrays.equals(this.ijqldinspecaos, other.getIjqldinspecaos()))) &&
            ((this.ijqldinsplotereps==null && other.getIjqldinsplotereps()==null) || 
             (this.ijqldinsplotereps!=null &&
              java.util.Arrays.equals(this.ijqldinsplotereps, other.getIjqldinsplotereps()))) &&
            ((this.ijrearefs==null && other.getIjrearefs()==null) || 
             (this.ijrearefs!=null &&
              java.util.Arrays.equals(this.ijrearefs, other.getIjrearefs()))) &&
            ((this.ijrefmans==null && other.getIjrefmans()==null) || 
             (this.ijrefmans!=null &&
              java.util.Arrays.equals(this.ijrefmans, other.getIjrefmans()))) &&
            ((this.ijrelprorefs==null && other.getIjrelprorefs()==null) || 
             (this.ijrelprorefs!=null &&
              java.util.Arrays.equals(this.ijrelprorefs, other.getIjrelprorefs()))) &&
            ((this.indtolerqld==null && other.getIndtolerqld()==null) || 
             (this.indtolerqld!=null &&
              this.indtolerqld.equals(other.getIndtolerqld()))) &&
            ((this.lrequeracao==null && other.getLrequeracao()==null) || 
             (this.lrequeracao!=null &&
              this.lrequeracao.equals(other.getLrequeracao()))) &&
            ((this.lrequercausa==null && other.getLrequercausa()==null) || 
             (this.lrequercausa!=null &&
              this.lrequercausa.equals(other.getLrequercausa()))) &&
            ((this.refreprocesso==null && other.getRefreprocesso()==null) || 
             (this.refreprocesso!=null &&
              this.refreprocesso.equals(other.getRefreprocesso()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo())));
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
        if (getCdrefugo() != null) {
            _hashCode += getCdrefugo().hashCode();
        }
        if (getDsrefugo() != null) {
            _hashCode += getDsrefugo().hashCode();
        }
        if (getIjareres() != null) {
            _hashCode += getIjareres().hashCode();
        }
        if (getIjgrpdetrefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetrefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetrefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcapadraos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcapadraos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcapadraos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjqldinspecaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjqldinspecaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjqldinspecaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjqldinsplotereps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjqldinsplotereps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjqldinsplotereps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrearefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrearefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrearefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrefmans() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrefmans());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrefmans(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrelprorefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrelprorefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrelprorefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndtolerqld() != null) {
            _hashCode += getIndtolerqld().hashCode();
        }
        if (getLrequeracao() != null) {
            _hashCode += getLrequeracao().hashCode();
        }
        if (getLrequercausa() != null) {
            _hashCode += getLrequercausa().hashCode();
        }
        if (getRefreprocesso() != null) {
            _hashCode += getRefreprocesso().hashCode();
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbref.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbref"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijareres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijareres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijareres"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetrefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetrefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcapadraos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcapadraos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcapadrao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldinspecaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldinspecaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldinsplotereps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldinsplotereps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldinsploterep"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrearefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrearefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrefmans");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrefmans"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefman"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrelprorefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrelprorefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrelproref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indtolerqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indtolerqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lrequeracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lrequeracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lrequercausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lrequercausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refreprocesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "refreprocesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
