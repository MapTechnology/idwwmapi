/**
 * Ijtmpultst.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtmpultst  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.util.Calendar dthrfimst;

    private java.util.Calendar dthrinist;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private org.apache.axis.types.UnsignedShort situacao;

    public Ijtmpultst() {
    }

    public Ijtmpultst(
           java.lang.String cdinjetora,
           java.util.Calendar dthrfimst,
           java.util.Calendar dthrinist,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           org.apache.axis.types.UnsignedShort situacao) {
           this.cdinjetora = cdinjetora;
           this.dthrfimst = dthrfimst;
           this.dthrinist = dthrinist;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.situacao = situacao;
    }


    /**
     * Gets the cdinjetora value for this Ijtmpultst.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijtmpultst.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the dthrfimst value for this Ijtmpultst.
     * 
     * @return dthrfimst
     */
    public java.util.Calendar getDthrfimst() {
        return dthrfimst;
    }


    /**
     * Sets the dthrfimst value for this Ijtmpultst.
     * 
     * @param dthrfimst
     */
    public void setDthrfimst(java.util.Calendar dthrfimst) {
        this.dthrfimst = dthrfimst;
    }


    /**
     * Gets the dthrinist value for this Ijtmpultst.
     * 
     * @return dthrinist
     */
    public java.util.Calendar getDthrinist() {
        return dthrinist;
    }


    /**
     * Sets the dthrinist value for this Ijtmpultst.
     * 
     * @param dthrinist
     */
    public void setDthrinist(java.util.Calendar dthrinist) {
        this.dthrinist = dthrinist;
    }


    /**
     * Gets the ijop value for this Ijtmpultst.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijtmpultst.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijtmpultst.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtmpultst.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the situacao value for this Ijtmpultst.
     * 
     * @return situacao
     */
    public org.apache.axis.types.UnsignedShort getSituacao() {
        return situacao;
    }


    /**
     * Sets the situacao value for this Ijtmpultst.
     * 
     * @param situacao
     */
    public void setSituacao(org.apache.axis.types.UnsignedShort situacao) {
        this.situacao = situacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtmpultst)) return false;
        Ijtmpultst other = (Ijtmpultst) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.dthrfimst==null && other.getDthrfimst()==null) || 
             (this.dthrfimst!=null &&
              this.dthrfimst.equals(other.getDthrfimst()))) &&
            ((this.dthrinist==null && other.getDthrinist()==null) || 
             (this.dthrinist!=null &&
              this.dthrinist.equals(other.getDthrinist()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.situacao==null && other.getSituacao()==null) || 
             (this.situacao!=null &&
              this.situacao.equals(other.getSituacao())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getDthrfimst() != null) {
            _hashCode += getDthrfimst().hashCode();
        }
        if (getDthrinist() != null) {
            _hashCode += getDthrinist().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getSituacao() != null) {
            _hashCode += getSituacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtmpultst.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtmpultst"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfimst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfimst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinist");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "situacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
