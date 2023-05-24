/**
 * GraficoBIParetoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoBIParetoDTO  implements java.io.Serializable {
    private idw.idwws.GraficoBIParetoPerdasDTO[] grafBIMaquinaGanhos;

    private idw.idwws.GraficoBIParetoPerdasDTO[] grafBIMaquinaPerdas;

    private idw.idwws.GraficoBIParetoPerdasDTO[] grafBIProdutoGanhos;

    private idw.idwws.GraficoBIParetoPerdasDTO[] grafBIProdutoPerdas;

    public GraficoBIParetoDTO() {
    }

    public GraficoBIParetoDTO(
           idw.idwws.GraficoBIParetoPerdasDTO[] grafBIMaquinaGanhos,
           idw.idwws.GraficoBIParetoPerdasDTO[] grafBIMaquinaPerdas,
           idw.idwws.GraficoBIParetoPerdasDTO[] grafBIProdutoGanhos,
           idw.idwws.GraficoBIParetoPerdasDTO[] grafBIProdutoPerdas) {
           this.grafBIMaquinaGanhos = grafBIMaquinaGanhos;
           this.grafBIMaquinaPerdas = grafBIMaquinaPerdas;
           this.grafBIProdutoGanhos = grafBIProdutoGanhos;
           this.grafBIProdutoPerdas = grafBIProdutoPerdas;
    }


    /**
     * Gets the grafBIMaquinaGanhos value for this GraficoBIParetoDTO.
     * 
     * @return grafBIMaquinaGanhos
     */
    public idw.idwws.GraficoBIParetoPerdasDTO[] getGrafBIMaquinaGanhos() {
        return grafBIMaquinaGanhos;
    }


    /**
     * Sets the grafBIMaquinaGanhos value for this GraficoBIParetoDTO.
     * 
     * @param grafBIMaquinaGanhos
     */
    public void setGrafBIMaquinaGanhos(idw.idwws.GraficoBIParetoPerdasDTO[] grafBIMaquinaGanhos) {
        this.grafBIMaquinaGanhos = grafBIMaquinaGanhos;
    }

    public idw.idwws.GraficoBIParetoPerdasDTO getGrafBIMaquinaGanhos(int i) {
        return this.grafBIMaquinaGanhos[i];
    }

    public void setGrafBIMaquinaGanhos(int i, idw.idwws.GraficoBIParetoPerdasDTO _value) {
        this.grafBIMaquinaGanhos[i] = _value;
    }


    /**
     * Gets the grafBIMaquinaPerdas value for this GraficoBIParetoDTO.
     * 
     * @return grafBIMaquinaPerdas
     */
    public idw.idwws.GraficoBIParetoPerdasDTO[] getGrafBIMaquinaPerdas() {
        return grafBIMaquinaPerdas;
    }


    /**
     * Sets the grafBIMaquinaPerdas value for this GraficoBIParetoDTO.
     * 
     * @param grafBIMaquinaPerdas
     */
    public void setGrafBIMaquinaPerdas(idw.idwws.GraficoBIParetoPerdasDTO[] grafBIMaquinaPerdas) {
        this.grafBIMaquinaPerdas = grafBIMaquinaPerdas;
    }

    public idw.idwws.GraficoBIParetoPerdasDTO getGrafBIMaquinaPerdas(int i) {
        return this.grafBIMaquinaPerdas[i];
    }

    public void setGrafBIMaquinaPerdas(int i, idw.idwws.GraficoBIParetoPerdasDTO _value) {
        this.grafBIMaquinaPerdas[i] = _value;
    }


    /**
     * Gets the grafBIProdutoGanhos value for this GraficoBIParetoDTO.
     * 
     * @return grafBIProdutoGanhos
     */
    public idw.idwws.GraficoBIParetoPerdasDTO[] getGrafBIProdutoGanhos() {
        return grafBIProdutoGanhos;
    }


    /**
     * Sets the grafBIProdutoGanhos value for this GraficoBIParetoDTO.
     * 
     * @param grafBIProdutoGanhos
     */
    public void setGrafBIProdutoGanhos(idw.idwws.GraficoBIParetoPerdasDTO[] grafBIProdutoGanhos) {
        this.grafBIProdutoGanhos = grafBIProdutoGanhos;
    }

    public idw.idwws.GraficoBIParetoPerdasDTO getGrafBIProdutoGanhos(int i) {
        return this.grafBIProdutoGanhos[i];
    }

    public void setGrafBIProdutoGanhos(int i, idw.idwws.GraficoBIParetoPerdasDTO _value) {
        this.grafBIProdutoGanhos[i] = _value;
    }


    /**
     * Gets the grafBIProdutoPerdas value for this GraficoBIParetoDTO.
     * 
     * @return grafBIProdutoPerdas
     */
    public idw.idwws.GraficoBIParetoPerdasDTO[] getGrafBIProdutoPerdas() {
        return grafBIProdutoPerdas;
    }


    /**
     * Sets the grafBIProdutoPerdas value for this GraficoBIParetoDTO.
     * 
     * @param grafBIProdutoPerdas
     */
    public void setGrafBIProdutoPerdas(idw.idwws.GraficoBIParetoPerdasDTO[] grafBIProdutoPerdas) {
        this.grafBIProdutoPerdas = grafBIProdutoPerdas;
    }

    public idw.idwws.GraficoBIParetoPerdasDTO getGrafBIProdutoPerdas(int i) {
        return this.grafBIProdutoPerdas[i];
    }

    public void setGrafBIProdutoPerdas(int i, idw.idwws.GraficoBIParetoPerdasDTO _value) {
        this.grafBIProdutoPerdas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoBIParetoDTO)) return false;
        GraficoBIParetoDTO other = (GraficoBIParetoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.grafBIMaquinaGanhos==null && other.getGrafBIMaquinaGanhos()==null) || 
             (this.grafBIMaquinaGanhos!=null &&
              java.util.Arrays.equals(this.grafBIMaquinaGanhos, other.getGrafBIMaquinaGanhos()))) &&
            ((this.grafBIMaquinaPerdas==null && other.getGrafBIMaquinaPerdas()==null) || 
             (this.grafBIMaquinaPerdas!=null &&
              java.util.Arrays.equals(this.grafBIMaquinaPerdas, other.getGrafBIMaquinaPerdas()))) &&
            ((this.grafBIProdutoGanhos==null && other.getGrafBIProdutoGanhos()==null) || 
             (this.grafBIProdutoGanhos!=null &&
              java.util.Arrays.equals(this.grafBIProdutoGanhos, other.getGrafBIProdutoGanhos()))) &&
            ((this.grafBIProdutoPerdas==null && other.getGrafBIProdutoPerdas()==null) || 
             (this.grafBIProdutoPerdas!=null &&
              java.util.Arrays.equals(this.grafBIProdutoPerdas, other.getGrafBIProdutoPerdas())));
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
        if (getGrafBIMaquinaGanhos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrafBIMaquinaGanhos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrafBIMaquinaGanhos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGrafBIMaquinaPerdas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrafBIMaquinaPerdas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrafBIMaquinaPerdas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGrafBIProdutoGanhos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrafBIProdutoGanhos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrafBIProdutoGanhos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGrafBIProdutoPerdas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrafBIProdutoPerdas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrafBIProdutoPerdas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GraficoBIParetoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoBIParetoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grafBIMaquinaGanhos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grafBIMaquinaGanhos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoBIParetoPerdasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grafBIMaquinaPerdas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grafBIMaquinaPerdas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoBIParetoPerdasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grafBIProdutoGanhos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grafBIProdutoGanhos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoBIParetoPerdasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grafBIProdutoPerdas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grafBIProdutoPerdas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoBIParetoPerdasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
