/**
 * IndicadorValorDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IndicadorValorDTO  implements java.io.Serializable {
    private idw.idwws.OmInd omInd;

    private double valor;

    public IndicadorValorDTO() {
    }

    public IndicadorValorDTO(
           idw.idwws.OmInd omInd,
           double valor) {
           this.omInd = omInd;
           this.valor = valor;
    }


    /**
     * Gets the omInd value for this IndicadorValorDTO.
     * 
     * @return omInd
     */
    public idw.idwws.OmInd getOmInd() {
        return omInd;
    }


    /**
     * Sets the omInd value for this IndicadorValorDTO.
     * 
     * @param omInd
     */
    public void setOmInd(idw.idwws.OmInd omInd) {
        this.omInd = omInd;
    }


    /**
     * Gets the valor value for this IndicadorValorDTO.
     * 
     * @return valor
     */
    public double getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this IndicadorValorDTO.
     * 
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndicadorValorDTO)) return false;
        IndicadorValorDTO other = (IndicadorValorDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.omInd==null && other.getOmInd()==null) || 
             (this.omInd!=null &&
              this.omInd.equals(other.getOmInd()))) &&
            this.valor == other.getValor();
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
        if (getOmInd() != null) {
            _hashCode += getOmInd().hashCode();
        }
        _hashCode += new Double(getValor()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndicadorValorDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadorValorDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omInd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
