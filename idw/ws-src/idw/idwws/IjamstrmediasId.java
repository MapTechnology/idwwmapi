/**
 * IjamstrmediasId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjamstrmediasId  implements java.io.Serializable {
    private java.lang.String idamostragem;

    private java.lang.String idamstrmedia;

    public IjamstrmediasId() {
    }

    public IjamstrmediasId(
           java.lang.String idamostragem,
           java.lang.String idamstrmedia) {
           this.idamostragem = idamostragem;
           this.idamstrmedia = idamstrmedia;
    }


    /**
     * Gets the idamostragem value for this IjamstrmediasId.
     * 
     * @return idamostragem
     */
    public java.lang.String getIdamostragem() {
        return idamostragem;
    }


    /**
     * Sets the idamostragem value for this IjamstrmediasId.
     * 
     * @param idamostragem
     */
    public void setIdamostragem(java.lang.String idamostragem) {
        this.idamostragem = idamostragem;
    }


    /**
     * Gets the idamstrmedia value for this IjamstrmediasId.
     * 
     * @return idamstrmedia
     */
    public java.lang.String getIdamstrmedia() {
        return idamstrmedia;
    }


    /**
     * Sets the idamstrmedia value for this IjamstrmediasId.
     * 
     * @param idamstrmedia
     */
    public void setIdamstrmedia(java.lang.String idamstrmedia) {
        this.idamstrmedia = idamstrmedia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjamstrmediasId)) return false;
        IjamstrmediasId other = (IjamstrmediasId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idamostragem==null && other.getIdamostragem()==null) || 
             (this.idamostragem!=null &&
              this.idamostragem.equals(other.getIdamostragem()))) &&
            ((this.idamstrmedia==null && other.getIdamstrmedia()==null) || 
             (this.idamstrmedia!=null &&
              this.idamstrmedia.equals(other.getIdamstrmedia())));
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
        if (getIdamostragem() != null) {
            _hashCode += getIdamostragem().hashCode();
        }
        if (getIdamstrmedia() != null) {
            _hashCode += getIdamstrmedia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjamstrmediasId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrmediasId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idamostragem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idamstrmedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idamstrmedia"));
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
