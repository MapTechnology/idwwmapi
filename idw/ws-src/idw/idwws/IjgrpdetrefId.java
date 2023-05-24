/**
 * IjgrpdetrefId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjgrpdetrefId  implements java.io.Serializable {
    private java.lang.String cdgruporef;

    private java.lang.String cdrefugo;

    public IjgrpdetrefId() {
    }

    public IjgrpdetrefId(
           java.lang.String cdgruporef,
           java.lang.String cdrefugo) {
           this.cdgruporef = cdgruporef;
           this.cdrefugo = cdrefugo;
    }


    /**
     * Gets the cdgruporef value for this IjgrpdetrefId.
     * 
     * @return cdgruporef
     */
    public java.lang.String getCdgruporef() {
        return cdgruporef;
    }


    /**
     * Sets the cdgruporef value for this IjgrpdetrefId.
     * 
     * @param cdgruporef
     */
    public void setCdgruporef(java.lang.String cdgruporef) {
        this.cdgruporef = cdgruporef;
    }


    /**
     * Gets the cdrefugo value for this IjgrpdetrefId.
     * 
     * @return cdrefugo
     */
    public java.lang.String getCdrefugo() {
        return cdrefugo;
    }


    /**
     * Sets the cdrefugo value for this IjgrpdetrefId.
     * 
     * @param cdrefugo
     */
    public void setCdrefugo(java.lang.String cdrefugo) {
        this.cdrefugo = cdrefugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjgrpdetrefId)) return false;
        IjgrpdetrefId other = (IjgrpdetrefId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgruporef==null && other.getCdgruporef()==null) || 
             (this.cdgruporef!=null &&
              this.cdgruporef.equals(other.getCdgruporef()))) &&
            ((this.cdrefugo==null && other.getCdrefugo()==null) || 
             (this.cdrefugo!=null &&
              this.cdrefugo.equals(other.getCdrefugo())));
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
        if (getCdgruporef() != null) {
            _hashCode += getCdgruporef().hashCode();
        }
        if (getCdrefugo() != null) {
            _hashCode += getCdrefugo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjgrpdetrefId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetrefId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgruporef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgruporef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdrefugo"));
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
