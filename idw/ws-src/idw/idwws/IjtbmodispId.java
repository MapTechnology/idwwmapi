/**
 * IjtbmodispId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbmodispId  implements java.io.Serializable {
    private java.lang.String cdturno;

    private java.util.Calendar dtturno;

    public IjtbmodispId() {
    }

    public IjtbmodispId(
           java.lang.String cdturno,
           java.util.Calendar dtturno) {
           this.cdturno = cdturno;
           this.dtturno = dtturno;
    }


    /**
     * Gets the cdturno value for this IjtbmodispId.
     * 
     * @return cdturno
     */
    public java.lang.String getCdturno() {
        return cdturno;
    }


    /**
     * Sets the cdturno value for this IjtbmodispId.
     * 
     * @param cdturno
     */
    public void setCdturno(java.lang.String cdturno) {
        this.cdturno = cdturno;
    }


    /**
     * Gets the dtturno value for this IjtbmodispId.
     * 
     * @return dtturno
     */
    public java.util.Calendar getDtturno() {
        return dtturno;
    }


    /**
     * Sets the dtturno value for this IjtbmodispId.
     * 
     * @param dtturno
     */
    public void setDtturno(java.util.Calendar dtturno) {
        this.dtturno = dtturno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbmodispId)) return false;
        IjtbmodispId other = (IjtbmodispId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdturno==null && other.getCdturno()==null) || 
             (this.cdturno!=null &&
              this.cdturno.equals(other.getCdturno()))) &&
            ((this.dtturno==null && other.getDtturno()==null) || 
             (this.dtturno!=null &&
              this.dtturno.equals(other.getDtturno())));
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
        if (getCdturno() != null) {
            _hashCode += getCdturno().hashCode();
        }
        if (getDtturno() != null) {
            _hashCode += getDtturno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbmodispId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodispId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
