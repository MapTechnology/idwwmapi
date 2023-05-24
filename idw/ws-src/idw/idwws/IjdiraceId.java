/**
 * IjdiraceId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjdiraceId  implements java.io.Serializable {
    private java.lang.String cdgrupo;

    private java.lang.String cdopcao;

    public IjdiraceId() {
    }

    public IjdiraceId(
           java.lang.String cdgrupo,
           java.lang.String cdopcao) {
           this.cdgrupo = cdgrupo;
           this.cdopcao = cdopcao;
    }


    /**
     * Gets the cdgrupo value for this IjdiraceId.
     * 
     * @return cdgrupo
     */
    public java.lang.String getCdgrupo() {
        return cdgrupo;
    }


    /**
     * Sets the cdgrupo value for this IjdiraceId.
     * 
     * @param cdgrupo
     */
    public void setCdgrupo(java.lang.String cdgrupo) {
        this.cdgrupo = cdgrupo;
    }


    /**
     * Gets the cdopcao value for this IjdiraceId.
     * 
     * @return cdopcao
     */
    public java.lang.String getCdopcao() {
        return cdopcao;
    }


    /**
     * Sets the cdopcao value for this IjdiraceId.
     * 
     * @param cdopcao
     */
    public void setCdopcao(java.lang.String cdopcao) {
        this.cdopcao = cdopcao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjdiraceId)) return false;
        IjdiraceId other = (IjdiraceId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrupo==null && other.getCdgrupo()==null) || 
             (this.cdgrupo!=null &&
              this.cdgrupo.equals(other.getCdgrupo()))) &&
            ((this.cdopcao==null && other.getCdopcao()==null) || 
             (this.cdopcao!=null &&
              this.cdopcao.equals(other.getCdopcao())));
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
        if (getCdgrupo() != null) {
            _hashCode += getCdgrupo().hashCode();
        }
        if (getCdopcao() != null) {
            _hashCode += getCdopcao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjdiraceId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdiraceId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdopcao"));
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
