/**
 * IjamostragemdetId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjamostragemdetId  implements java.io.Serializable {
    private java.math.BigDecimal amostra;

    private java.lang.String idamostragem;

    public IjamostragemdetId() {
    }

    public IjamostragemdetId(
           java.math.BigDecimal amostra,
           java.lang.String idamostragem) {
           this.amostra = amostra;
           this.idamostragem = idamostragem;
    }


    /**
     * Gets the amostra value for this IjamostragemdetId.
     * 
     * @return amostra
     */
    public java.math.BigDecimal getAmostra() {
        return amostra;
    }


    /**
     * Sets the amostra value for this IjamostragemdetId.
     * 
     * @param amostra
     */
    public void setAmostra(java.math.BigDecimal amostra) {
        this.amostra = amostra;
    }


    /**
     * Gets the idamostragem value for this IjamostragemdetId.
     * 
     * @return idamostragem
     */
    public java.lang.String getIdamostragem() {
        return idamostragem;
    }


    /**
     * Sets the idamostragem value for this IjamostragemdetId.
     * 
     * @param idamostragem
     */
    public void setIdamostragem(java.lang.String idamostragem) {
        this.idamostragem = idamostragem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjamostragemdetId)) return false;
        IjamostragemdetId other = (IjamostragemdetId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amostra==null && other.getAmostra()==null) || 
             (this.amostra!=null &&
              this.amostra.equals(other.getAmostra()))) &&
            ((this.idamostragem==null && other.getIdamostragem()==null) || 
             (this.idamostragem!=null &&
              this.idamostragem.equals(other.getIdamostragem())));
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
        if (getAmostra() != null) {
            _hashCode += getAmostra().hashCode();
        }
        if (getIdamostragem() != null) {
            _hashCode += getIdamostragem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjamostragemdetId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdetId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amostra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amostra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idamostragem"));
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
