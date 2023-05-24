/**
 * SerieParettoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class SerieParettoDTO  implements java.io.Serializable {
    private java.lang.String elemento;

    private java.lang.Double qtdeApontamento;

    public SerieParettoDTO() {
    }

    public SerieParettoDTO(
           java.lang.String elemento,
           java.lang.Double qtdeApontamento) {
           this.elemento = elemento;
           this.qtdeApontamento = qtdeApontamento;
    }


    /**
     * Gets the elemento value for this SerieParettoDTO.
     * 
     * @return elemento
     */
    public java.lang.String getElemento() {
        return elemento;
    }


    /**
     * Sets the elemento value for this SerieParettoDTO.
     * 
     * @param elemento
     */
    public void setElemento(java.lang.String elemento) {
        this.elemento = elemento;
    }


    /**
     * Gets the qtdeApontamento value for this SerieParettoDTO.
     * 
     * @return qtdeApontamento
     */
    public java.lang.Double getQtdeApontamento() {
        return qtdeApontamento;
    }


    /**
     * Sets the qtdeApontamento value for this SerieParettoDTO.
     * 
     * @param qtdeApontamento
     */
    public void setQtdeApontamento(java.lang.Double qtdeApontamento) {
        this.qtdeApontamento = qtdeApontamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SerieParettoDTO)) return false;
        SerieParettoDTO other = (SerieParettoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.elemento==null && other.getElemento()==null) || 
             (this.elemento!=null &&
              this.elemento.equals(other.getElemento()))) &&
            ((this.qtdeApontamento==null && other.getQtdeApontamento()==null) || 
             (this.qtdeApontamento!=null &&
              this.qtdeApontamento.equals(other.getQtdeApontamento())));
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
        if (getElemento() != null) {
            _hashCode += getElemento().hashCode();
        }
        if (getQtdeApontamento() != null) {
            _hashCode += getQtdeApontamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SerieParettoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "serieParettoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elemento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "elemento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeApontamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeApontamento"));
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
