/**
 * IjtbapresxslidesId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbapresxslidesId  implements java.io.Serializable {
    private java.lang.String cdapresentacao;

    private java.math.BigDecimal ordemapresentacao;

    public IjtbapresxslidesId() {
    }

    public IjtbapresxslidesId(
           java.lang.String cdapresentacao,
           java.math.BigDecimal ordemapresentacao) {
           this.cdapresentacao = cdapresentacao;
           this.ordemapresentacao = ordemapresentacao;
    }


    /**
     * Gets the cdapresentacao value for this IjtbapresxslidesId.
     * 
     * @return cdapresentacao
     */
    public java.lang.String getCdapresentacao() {
        return cdapresentacao;
    }


    /**
     * Sets the cdapresentacao value for this IjtbapresxslidesId.
     * 
     * @param cdapresentacao
     */
    public void setCdapresentacao(java.lang.String cdapresentacao) {
        this.cdapresentacao = cdapresentacao;
    }


    /**
     * Gets the ordemapresentacao value for this IjtbapresxslidesId.
     * 
     * @return ordemapresentacao
     */
    public java.math.BigDecimal getOrdemapresentacao() {
        return ordemapresentacao;
    }


    /**
     * Sets the ordemapresentacao value for this IjtbapresxslidesId.
     * 
     * @param ordemapresentacao
     */
    public void setOrdemapresentacao(java.math.BigDecimal ordemapresentacao) {
        this.ordemapresentacao = ordemapresentacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbapresxslidesId)) return false;
        IjtbapresxslidesId other = (IjtbapresxslidesId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdapresentacao==null && other.getCdapresentacao()==null) || 
             (this.cdapresentacao!=null &&
              this.cdapresentacao.equals(other.getCdapresentacao()))) &&
            ((this.ordemapresentacao==null && other.getOrdemapresentacao()==null) || 
             (this.ordemapresentacao!=null &&
              this.ordemapresentacao.equals(other.getOrdemapresentacao())));
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
        if (getCdapresentacao() != null) {
            _hashCode += getCdapresentacao().hashCode();
        }
        if (getOrdemapresentacao() != null) {
            _hashCode += getOrdemapresentacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbapresxslidesId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbapresxslidesId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdapresentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdapresentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemapresentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemapresentacao"));
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
