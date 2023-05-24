/**
 * IjtbtpocoreaId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbtpocoreaId  implements java.io.Serializable {
    private java.lang.String cdlingua;

    private java.math.BigDecimal cdtipooco;

    public IjtbtpocoreaId() {
    }

    public IjtbtpocoreaId(
           java.lang.String cdlingua,
           java.math.BigDecimal cdtipooco) {
           this.cdlingua = cdlingua;
           this.cdtipooco = cdtipooco;
    }


    /**
     * Gets the cdlingua value for this IjtbtpocoreaId.
     * 
     * @return cdlingua
     */
    public java.lang.String getCdlingua() {
        return cdlingua;
    }


    /**
     * Sets the cdlingua value for this IjtbtpocoreaId.
     * 
     * @param cdlingua
     */
    public void setCdlingua(java.lang.String cdlingua) {
        this.cdlingua = cdlingua;
    }


    /**
     * Gets the cdtipooco value for this IjtbtpocoreaId.
     * 
     * @return cdtipooco
     */
    public java.math.BigDecimal getCdtipooco() {
        return cdtipooco;
    }


    /**
     * Sets the cdtipooco value for this IjtbtpocoreaId.
     * 
     * @param cdtipooco
     */
    public void setCdtipooco(java.math.BigDecimal cdtipooco) {
        this.cdtipooco = cdtipooco;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbtpocoreaId)) return false;
        IjtbtpocoreaId other = (IjtbtpocoreaId) obj;
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
            ((this.cdtipooco==null && other.getCdtipooco()==null) || 
             (this.cdtipooco!=null &&
              this.cdtipooco.equals(other.getCdtipooco())));
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
        if (getCdtipooco() != null) {
            _hashCode += getCdtipooco().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbtpocoreaId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpocoreaId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlingua");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlingua"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipooco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipooco"));
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
