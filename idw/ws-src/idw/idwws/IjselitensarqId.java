/**
 * IjselitensarqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjselitensarqId  implements java.io.Serializable {
    private java.lang.String cdinf;

    private java.lang.String cdselecao;

    private java.lang.String cdtipoinf;

    public IjselitensarqId() {
    }

    public IjselitensarqId(
           java.lang.String cdinf,
           java.lang.String cdselecao,
           java.lang.String cdtipoinf) {
           this.cdinf = cdinf;
           this.cdselecao = cdselecao;
           this.cdtipoinf = cdtipoinf;
    }


    /**
     * Gets the cdinf value for this IjselitensarqId.
     * 
     * @return cdinf
     */
    public java.lang.String getCdinf() {
        return cdinf;
    }


    /**
     * Sets the cdinf value for this IjselitensarqId.
     * 
     * @param cdinf
     */
    public void setCdinf(java.lang.String cdinf) {
        this.cdinf = cdinf;
    }


    /**
     * Gets the cdselecao value for this IjselitensarqId.
     * 
     * @return cdselecao
     */
    public java.lang.String getCdselecao() {
        return cdselecao;
    }


    /**
     * Sets the cdselecao value for this IjselitensarqId.
     * 
     * @param cdselecao
     */
    public void setCdselecao(java.lang.String cdselecao) {
        this.cdselecao = cdselecao;
    }


    /**
     * Gets the cdtipoinf value for this IjselitensarqId.
     * 
     * @return cdtipoinf
     */
    public java.lang.String getCdtipoinf() {
        return cdtipoinf;
    }


    /**
     * Sets the cdtipoinf value for this IjselitensarqId.
     * 
     * @param cdtipoinf
     */
    public void setCdtipoinf(java.lang.String cdtipoinf) {
        this.cdtipoinf = cdtipoinf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjselitensarqId)) return false;
        IjselitensarqId other = (IjselitensarqId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinf==null && other.getCdinf()==null) || 
             (this.cdinf!=null &&
              this.cdinf.equals(other.getCdinf()))) &&
            ((this.cdselecao==null && other.getCdselecao()==null) || 
             (this.cdselecao!=null &&
              this.cdselecao.equals(other.getCdselecao()))) &&
            ((this.cdtipoinf==null && other.getCdtipoinf()==null) || 
             (this.cdtipoinf!=null &&
              this.cdtipoinf.equals(other.getCdtipoinf())));
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
        if (getCdinf() != null) {
            _hashCode += getCdinf().hashCode();
        }
        if (getCdselecao() != null) {
            _hashCode += getCdselecao().hashCode();
        }
        if (getCdtipoinf() != null) {
            _hashCode += getCdtipoinf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjselitensarqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensarqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdselecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdselecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipoinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipoinf"));
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
