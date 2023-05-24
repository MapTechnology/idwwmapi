/**
 * IjfamiliaxmaqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjfamiliaxmaqId  implements java.io.Serializable {
    private java.lang.String cdfamilia;

    private java.lang.String cdinjetora;

    public IjfamiliaxmaqId() {
    }

    public IjfamiliaxmaqId(
           java.lang.String cdfamilia,
           java.lang.String cdinjetora) {
           this.cdfamilia = cdfamilia;
           this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdfamilia value for this IjfamiliaxmaqId.
     * 
     * @return cdfamilia
     */
    public java.lang.String getCdfamilia() {
        return cdfamilia;
    }


    /**
     * Sets the cdfamilia value for this IjfamiliaxmaqId.
     * 
     * @param cdfamilia
     */
    public void setCdfamilia(java.lang.String cdfamilia) {
        this.cdfamilia = cdfamilia;
    }


    /**
     * Gets the cdinjetora value for this IjfamiliaxmaqId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjfamiliaxmaqId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjfamiliaxmaqId)) return false;
        IjfamiliaxmaqId other = (IjfamiliaxmaqId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdfamilia==null && other.getCdfamilia()==null) || 
             (this.cdfamilia!=null &&
              this.cdfamilia.equals(other.getCdfamilia()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora())));
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
        if (getCdfamilia() != null) {
            _hashCode += getCdfamilia().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjfamiliaxmaqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfamiliaxmaqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdfamilia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdfamilia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
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
