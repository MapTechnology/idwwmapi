/**
 * DadosDiaPlanProdDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DadosDiaPlanProdDTO  implements java.io.Serializable {
    private java.lang.Boolean coberto;

    private java.lang.Double valorDia;

    public DadosDiaPlanProdDTO() {
    }

    public DadosDiaPlanProdDTO(
           java.lang.Boolean coberto,
           java.lang.Double valorDia) {
           this.coberto = coberto;
           this.valorDia = valorDia;
    }


    /**
     * Gets the coberto value for this DadosDiaPlanProdDTO.
     * 
     * @return coberto
     */
    public java.lang.Boolean getCoberto() {
        return coberto;
    }


    /**
     * Sets the coberto value for this DadosDiaPlanProdDTO.
     * 
     * @param coberto
     */
    public void setCoberto(java.lang.Boolean coberto) {
        this.coberto = coberto;
    }


    /**
     * Gets the valorDia value for this DadosDiaPlanProdDTO.
     * 
     * @return valorDia
     */
    public java.lang.Double getValorDia() {
        return valorDia;
    }


    /**
     * Sets the valorDia value for this DadosDiaPlanProdDTO.
     * 
     * @param valorDia
     */
    public void setValorDia(java.lang.Double valorDia) {
        this.valorDia = valorDia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosDiaPlanProdDTO)) return false;
        DadosDiaPlanProdDTO other = (DadosDiaPlanProdDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.coberto==null && other.getCoberto()==null) || 
             (this.coberto!=null &&
              this.coberto.equals(other.getCoberto()))) &&
            ((this.valorDia==null && other.getValorDia()==null) || 
             (this.valorDia!=null &&
              this.valorDia.equals(other.getValorDia())));
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
        if (getCoberto() != null) {
            _hashCode += getCoberto().hashCode();
        }
        if (getValorDia() != null) {
            _hashCode += getValorDia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosDiaPlanProdDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dadosDiaPlanProdDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorDia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valorDia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
