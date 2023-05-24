/**
 * IjrelprorefId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjrelprorefId  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private java.lang.String cdrefugo;

    public IjrelprorefId() {
    }

    public IjrelprorefId(
           java.lang.String cdproduto,
           java.lang.String cdrefugo) {
           this.cdproduto = cdproduto;
           this.cdrefugo = cdrefugo;
    }


    /**
     * Gets the cdproduto value for this IjrelprorefId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjrelprorefId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the cdrefugo value for this IjrelprorefId.
     * 
     * @return cdrefugo
     */
    public java.lang.String getCdrefugo() {
        return cdrefugo;
    }


    /**
     * Sets the cdrefugo value for this IjrelprorefId.
     * 
     * @param cdrefugo
     */
    public void setCdrefugo(java.lang.String cdrefugo) {
        this.cdrefugo = cdrefugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjrelprorefId)) return false;
        IjrelprorefId other = (IjrelprorefId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
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
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getCdrefugo() != null) {
            _hashCode += getCdrefugo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjrelprorefId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrelprorefId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
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
