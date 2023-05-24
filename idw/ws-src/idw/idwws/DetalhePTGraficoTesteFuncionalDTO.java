/**
 * DetalhePTGraficoTesteFuncionalDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalhePTGraficoTesteFuncionalDTO  implements java.io.Serializable {
    private idw.idwws.DwPasstfsepm[] medicoes;

    private idw.idwws.ResultadoDTO resultado;

    public DetalhePTGraficoTesteFuncionalDTO() {
    }

    public DetalhePTGraficoTesteFuncionalDTO(
           idw.idwws.DwPasstfsepm[] medicoes,
           idw.idwws.ResultadoDTO resultado) {
           this.medicoes = medicoes;
           this.resultado = resultado;
    }


    /**
     * Gets the medicoes value for this DetalhePTGraficoTesteFuncionalDTO.
     * 
     * @return medicoes
     */
    public idw.idwws.DwPasstfsepm[] getMedicoes() {
        return medicoes;
    }


    /**
     * Sets the medicoes value for this DetalhePTGraficoTesteFuncionalDTO.
     * 
     * @param medicoes
     */
    public void setMedicoes(idw.idwws.DwPasstfsepm[] medicoes) {
        this.medicoes = medicoes;
    }

    public idw.idwws.DwPasstfsepm getMedicoes(int i) {
        return this.medicoes[i];
    }

    public void setMedicoes(int i, idw.idwws.DwPasstfsepm _value) {
        this.medicoes[i] = _value;
    }


    /**
     * Gets the resultado value for this DetalhePTGraficoTesteFuncionalDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this DetalhePTGraficoTesteFuncionalDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalhePTGraficoTesteFuncionalDTO)) return false;
        DetalhePTGraficoTesteFuncionalDTO other = (DetalhePTGraficoTesteFuncionalDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.medicoes==null && other.getMedicoes()==null) || 
             (this.medicoes!=null &&
              java.util.Arrays.equals(this.medicoes, other.getMedicoes()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado())));
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
        if (getMedicoes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMedicoes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMedicoes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalhePTGraficoTesteFuncionalDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalhePTGraficoTesteFuncionalDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medicoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medicoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfsepm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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
