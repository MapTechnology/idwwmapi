/**
 * IjamstrdetaltmediaId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjamstrdetaltmediaId  implements java.io.Serializable {
    private double idctrlaltcgammedia;

    private double idctrlaltcgqamstr;

    public IjamstrdetaltmediaId() {
    }

    public IjamstrdetaltmediaId(
           double idctrlaltcgammedia,
           double idctrlaltcgqamstr) {
           this.idctrlaltcgammedia = idctrlaltcgammedia;
           this.idctrlaltcgqamstr = idctrlaltcgqamstr;
    }


    /**
     * Gets the idctrlaltcgammedia value for this IjamstrdetaltmediaId.
     * 
     * @return idctrlaltcgammedia
     */
    public double getIdctrlaltcgammedia() {
        return idctrlaltcgammedia;
    }


    /**
     * Sets the idctrlaltcgammedia value for this IjamstrdetaltmediaId.
     * 
     * @param idctrlaltcgammedia
     */
    public void setIdctrlaltcgammedia(double idctrlaltcgammedia) {
        this.idctrlaltcgammedia = idctrlaltcgammedia;
    }


    /**
     * Gets the idctrlaltcgqamstr value for this IjamstrdetaltmediaId.
     * 
     * @return idctrlaltcgqamstr
     */
    public double getIdctrlaltcgqamstr() {
        return idctrlaltcgqamstr;
    }


    /**
     * Sets the idctrlaltcgqamstr value for this IjamstrdetaltmediaId.
     * 
     * @param idctrlaltcgqamstr
     */
    public void setIdctrlaltcgqamstr(double idctrlaltcgqamstr) {
        this.idctrlaltcgqamstr = idctrlaltcgqamstr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjamstrdetaltmediaId)) return false;
        IjamstrdetaltmediaId other = (IjamstrdetaltmediaId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idctrlaltcgammedia == other.getIdctrlaltcgammedia() &&
            this.idctrlaltcgqamstr == other.getIdctrlaltcgqamstr();
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
        _hashCode += new Double(getIdctrlaltcgammedia()).hashCode();
        _hashCode += new Double(getIdctrlaltcgqamstr()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjamstrdetaltmediaId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrdetaltmediaId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idctrlaltcgammedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idctrlaltcgammedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idctrlaltcgqamstr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idctrlaltcgqamstr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
