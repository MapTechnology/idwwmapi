/**
 * IjparaminfId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjparaminfId  implements java.io.Serializable {
    private java.lang.String cdinf;

    private java.lang.String cdparam;

    public IjparaminfId() {
    }

    public IjparaminfId(
           java.lang.String cdinf,
           java.lang.String cdparam) {
           this.cdinf = cdinf;
           this.cdparam = cdparam;
    }


    /**
     * Gets the cdinf value for this IjparaminfId.
     * 
     * @return cdinf
     */
    public java.lang.String getCdinf() {
        return cdinf;
    }


    /**
     * Sets the cdinf value for this IjparaminfId.
     * 
     * @param cdinf
     */
    public void setCdinf(java.lang.String cdinf) {
        this.cdinf = cdinf;
    }


    /**
     * Gets the cdparam value for this IjparaminfId.
     * 
     * @return cdparam
     */
    public java.lang.String getCdparam() {
        return cdparam;
    }


    /**
     * Sets the cdparam value for this IjparaminfId.
     * 
     * @param cdparam
     */
    public void setCdparam(java.lang.String cdparam) {
        this.cdparam = cdparam;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjparaminfId)) return false;
        IjparaminfId other = (IjparaminfId) obj;
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
            ((this.cdparam==null && other.getCdparam()==null) || 
             (this.cdparam!=null &&
              this.cdparam.equals(other.getCdparam())));
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
        if (getCdparam() != null) {
            _hashCode += getCdparam().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjparaminfId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminfId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdparam"));
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
