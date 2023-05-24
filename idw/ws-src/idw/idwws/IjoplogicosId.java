/**
 * IjoplogicosId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjoplogicosId  implements java.io.Serializable {
    private java.lang.String cdlingua;

    private java.lang.String cdoplogico;

    public IjoplogicosId() {
    }

    public IjoplogicosId(
           java.lang.String cdlingua,
           java.lang.String cdoplogico) {
           this.cdlingua = cdlingua;
           this.cdoplogico = cdoplogico;
    }


    /**
     * Gets the cdlingua value for this IjoplogicosId.
     * 
     * @return cdlingua
     */
    public java.lang.String getCdlingua() {
        return cdlingua;
    }


    /**
     * Sets the cdlingua value for this IjoplogicosId.
     * 
     * @param cdlingua
     */
    public void setCdlingua(java.lang.String cdlingua) {
        this.cdlingua = cdlingua;
    }


    /**
     * Gets the cdoplogico value for this IjoplogicosId.
     * 
     * @return cdoplogico
     */
    public java.lang.String getCdoplogico() {
        return cdoplogico;
    }


    /**
     * Sets the cdoplogico value for this IjoplogicosId.
     * 
     * @param cdoplogico
     */
    public void setCdoplogico(java.lang.String cdoplogico) {
        this.cdoplogico = cdoplogico;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjoplogicosId)) return false;
        IjoplogicosId other = (IjoplogicosId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdlingua==null && other.getCdlingua()==null) || 
             (this.cdlingua!=null &&
              this.cdlingua.equals(other.getCdlingua()))) &&
            ((this.cdoplogico==null && other.getCdoplogico()==null) || 
             (this.cdoplogico!=null &&
              this.cdoplogico.equals(other.getCdoplogico())));
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
        if (getCdlingua() != null) {
            _hashCode += getCdlingua().hashCode();
        }
        if (getCdoplogico() != null) {
            _hashCode += getCdoplogico().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjoplogicosId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplogicosId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlingua");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlingua"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoplogico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoplogico"));
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
