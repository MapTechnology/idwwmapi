/**
 * IwsDadosBCDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IwsDadosBCDTO  implements java.io.Serializable {
    private java.lang.Double qtdProducaoLiquida;

    private int totalCavAtivas;

    public IwsDadosBCDTO() {
    }

    public IwsDadosBCDTO(
           java.lang.Double qtdProducaoLiquida,
           int totalCavAtivas) {
           this.qtdProducaoLiquida = qtdProducaoLiquida;
           this.totalCavAtivas = totalCavAtivas;
    }


    /**
     * Gets the qtdProducaoLiquida value for this IwsDadosBCDTO.
     * 
     * @return qtdProducaoLiquida
     */
    public java.lang.Double getQtdProducaoLiquida() {
        return qtdProducaoLiquida;
    }


    /**
     * Sets the qtdProducaoLiquida value for this IwsDadosBCDTO.
     * 
     * @param qtdProducaoLiquida
     */
    public void setQtdProducaoLiquida(java.lang.Double qtdProducaoLiquida) {
        this.qtdProducaoLiquida = qtdProducaoLiquida;
    }


    /**
     * Gets the totalCavAtivas value for this IwsDadosBCDTO.
     * 
     * @return totalCavAtivas
     */
    public int getTotalCavAtivas() {
        return totalCavAtivas;
    }


    /**
     * Sets the totalCavAtivas value for this IwsDadosBCDTO.
     * 
     * @param totalCavAtivas
     */
    public void setTotalCavAtivas(int totalCavAtivas) {
        this.totalCavAtivas = totalCavAtivas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IwsDadosBCDTO)) return false;
        IwsDadosBCDTO other = (IwsDadosBCDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.qtdProducaoLiquida==null && other.getQtdProducaoLiquida()==null) || 
             (this.qtdProducaoLiquida!=null &&
              this.qtdProducaoLiquida.equals(other.getQtdProducaoLiquida()))) &&
            this.totalCavAtivas == other.getTotalCavAtivas();
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
        if (getQtdProducaoLiquida() != null) {
            _hashCode += getQtdProducaoLiquida().hashCode();
        }
        _hashCode += getTotalCavAtivas();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IwsDadosBCDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsDadosBCDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdProducaoLiquida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdProducaoLiquida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalCavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
