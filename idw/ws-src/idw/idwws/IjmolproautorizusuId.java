/**
 * IjmolproautorizusuId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmolproautorizusuId  implements java.io.Serializable {
    private java.lang.String cdusuarioaut;

    private java.lang.String nrsolicmodificest;

    public IjmolproautorizusuId() {
    }

    public IjmolproautorizusuId(
           java.lang.String cdusuarioaut,
           java.lang.String nrsolicmodificest) {
           this.cdusuarioaut = cdusuarioaut;
           this.nrsolicmodificest = nrsolicmodificest;
    }


    /**
     * Gets the cdusuarioaut value for this IjmolproautorizusuId.
     * 
     * @return cdusuarioaut
     */
    public java.lang.String getCdusuarioaut() {
        return cdusuarioaut;
    }


    /**
     * Sets the cdusuarioaut value for this IjmolproautorizusuId.
     * 
     * @param cdusuarioaut
     */
    public void setCdusuarioaut(java.lang.String cdusuarioaut) {
        this.cdusuarioaut = cdusuarioaut;
    }


    /**
     * Gets the nrsolicmodificest value for this IjmolproautorizusuId.
     * 
     * @return nrsolicmodificest
     */
    public java.lang.String getNrsolicmodificest() {
        return nrsolicmodificest;
    }


    /**
     * Sets the nrsolicmodificest value for this IjmolproautorizusuId.
     * 
     * @param nrsolicmodificest
     */
    public void setNrsolicmodificest(java.lang.String nrsolicmodificest) {
        this.nrsolicmodificest = nrsolicmodificest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmolproautorizusuId)) return false;
        IjmolproautorizusuId other = (IjmolproautorizusuId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdusuarioaut==null && other.getCdusuarioaut()==null) || 
             (this.cdusuarioaut!=null &&
              this.cdusuarioaut.equals(other.getCdusuarioaut()))) &&
            ((this.nrsolicmodificest==null && other.getNrsolicmodificest()==null) || 
             (this.nrsolicmodificest!=null &&
              this.nrsolicmodificest.equals(other.getNrsolicmodificest())));
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
        if (getCdusuarioaut() != null) {
            _hashCode += getCdusuarioaut().hashCode();
        }
        if (getNrsolicmodificest() != null) {
            _hashCode += getNrsolicmodificest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmolproautorizusuId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizusuId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuarioaut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuarioaut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrsolicmodificest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrsolicmodificest"));
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
