/**
 * IjcelxestagiosId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjcelxestagiosId  implements java.io.Serializable {
    private java.lang.String cdcelula;

    private java.math.BigDecimal estagio;

    public IjcelxestagiosId() {
    }

    public IjcelxestagiosId(
           java.lang.String cdcelula,
           java.math.BigDecimal estagio) {
           this.cdcelula = cdcelula;
           this.estagio = estagio;
    }


    /**
     * Gets the cdcelula value for this IjcelxestagiosId.
     * 
     * @return cdcelula
     */
    public java.lang.String getCdcelula() {
        return cdcelula;
    }


    /**
     * Sets the cdcelula value for this IjcelxestagiosId.
     * 
     * @param cdcelula
     */
    public void setCdcelula(java.lang.String cdcelula) {
        this.cdcelula = cdcelula;
    }


    /**
     * Gets the estagio value for this IjcelxestagiosId.
     * 
     * @return estagio
     */
    public java.math.BigDecimal getEstagio() {
        return estagio;
    }


    /**
     * Sets the estagio value for this IjcelxestagiosId.
     * 
     * @param estagio
     */
    public void setEstagio(java.math.BigDecimal estagio) {
        this.estagio = estagio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjcelxestagiosId)) return false;
        IjcelxestagiosId other = (IjcelxestagiosId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcelula==null && other.getCdcelula()==null) || 
             (this.cdcelula!=null &&
              this.cdcelula.equals(other.getCdcelula()))) &&
            ((this.estagio==null && other.getEstagio()==null) || 
             (this.estagio!=null &&
              this.estagio.equals(other.getEstagio())));
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
        if (getCdcelula() != null) {
            _hashCode += getCdcelula().hashCode();
        }
        if (getEstagio() != null) {
            _hashCode += getEstagio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjcelxestagiosId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxestagiosId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estagio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estagio"));
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
