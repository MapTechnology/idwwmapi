/**
 * IjselitensmenId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjselitensmenId  implements java.io.Serializable {
    private java.lang.String cdcont;

    private java.lang.String cdselecao;

    private java.lang.String cdtipoinf;

    public IjselitensmenId() {
    }

    public IjselitensmenId(
           java.lang.String cdcont,
           java.lang.String cdselecao,
           java.lang.String cdtipoinf) {
           this.cdcont = cdcont;
           this.cdselecao = cdselecao;
           this.cdtipoinf = cdtipoinf;
    }


    /**
     * Gets the cdcont value for this IjselitensmenId.
     * 
     * @return cdcont
     */
    public java.lang.String getCdcont() {
        return cdcont;
    }


    /**
     * Sets the cdcont value for this IjselitensmenId.
     * 
     * @param cdcont
     */
    public void setCdcont(java.lang.String cdcont) {
        this.cdcont = cdcont;
    }


    /**
     * Gets the cdselecao value for this IjselitensmenId.
     * 
     * @return cdselecao
     */
    public java.lang.String getCdselecao() {
        return cdselecao;
    }


    /**
     * Sets the cdselecao value for this IjselitensmenId.
     * 
     * @param cdselecao
     */
    public void setCdselecao(java.lang.String cdselecao) {
        this.cdselecao = cdselecao;
    }


    /**
     * Gets the cdtipoinf value for this IjselitensmenId.
     * 
     * @return cdtipoinf
     */
    public java.lang.String getCdtipoinf() {
        return cdtipoinf;
    }


    /**
     * Sets the cdtipoinf value for this IjselitensmenId.
     * 
     * @param cdtipoinf
     */
    public void setCdtipoinf(java.lang.String cdtipoinf) {
        this.cdtipoinf = cdtipoinf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjselitensmenId)) return false;
        IjselitensmenId other = (IjselitensmenId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcont==null && other.getCdcont()==null) || 
             (this.cdcont!=null &&
              this.cdcont.equals(other.getCdcont()))) &&
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
        if (getCdcont() != null) {
            _hashCode += getCdcont().hashCode();
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
        new org.apache.axis.description.TypeDesc(IjselitensmenId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensmenId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcont"));
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
