/**
 * IjdrivercentprtdefId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjdrivercentprtdefId  implements java.io.Serializable {
    private java.lang.String cdcentinsp;

    private java.lang.String iddriver;

    public IjdrivercentprtdefId() {
    }

    public IjdrivercentprtdefId(
           java.lang.String cdcentinsp,
           java.lang.String iddriver) {
           this.cdcentinsp = cdcentinsp;
           this.iddriver = iddriver;
    }


    /**
     * Gets the cdcentinsp value for this IjdrivercentprtdefId.
     * 
     * @return cdcentinsp
     */
    public java.lang.String getCdcentinsp() {
        return cdcentinsp;
    }


    /**
     * Sets the cdcentinsp value for this IjdrivercentprtdefId.
     * 
     * @param cdcentinsp
     */
    public void setCdcentinsp(java.lang.String cdcentinsp) {
        this.cdcentinsp = cdcentinsp;
    }


    /**
     * Gets the iddriver value for this IjdrivercentprtdefId.
     * 
     * @return iddriver
     */
    public java.lang.String getIddriver() {
        return iddriver;
    }


    /**
     * Sets the iddriver value for this IjdrivercentprtdefId.
     * 
     * @param iddriver
     */
    public void setIddriver(java.lang.String iddriver) {
        this.iddriver = iddriver;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjdrivercentprtdefId)) return false;
        IjdrivercentprtdefId other = (IjdrivercentprtdefId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcentinsp==null && other.getCdcentinsp()==null) || 
             (this.cdcentinsp!=null &&
              this.cdcentinsp.equals(other.getCdcentinsp()))) &&
            ((this.iddriver==null && other.getIddriver()==null) || 
             (this.iddriver!=null &&
              this.iddriver.equals(other.getIddriver())));
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
        if (getCdcentinsp() != null) {
            _hashCode += getCdcentinsp().hashCode();
        }
        if (getIddriver() != null) {
            _hashCode += getIddriver().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjdrivercentprtdefId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercentprtdefId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcentinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcentinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iddriver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iddriver"));
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
