/**
 * DetalhamentoParadaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalhamentoParadaDTO  implements java.io.Serializable {
    private java.lang.String duracaoParadas;

    private idw.idwws.DetalheParadaDTO[] listaparadas;

    private java.lang.String parada;

    public DetalhamentoParadaDTO() {
    }

    public DetalhamentoParadaDTO(
           java.lang.String duracaoParadas,
           idw.idwws.DetalheParadaDTO[] listaparadas,
           java.lang.String parada) {
           this.duracaoParadas = duracaoParadas;
           this.listaparadas = listaparadas;
           this.parada = parada;
    }


    /**
     * Gets the duracaoParadas value for this DetalhamentoParadaDTO.
     * 
     * @return duracaoParadas
     */
    public java.lang.String getDuracaoParadas() {
        return duracaoParadas;
    }


    /**
     * Sets the duracaoParadas value for this DetalhamentoParadaDTO.
     * 
     * @param duracaoParadas
     */
    public void setDuracaoParadas(java.lang.String duracaoParadas) {
        this.duracaoParadas = duracaoParadas;
    }


    /**
     * Gets the listaparadas value for this DetalhamentoParadaDTO.
     * 
     * @return listaparadas
     */
    public idw.idwws.DetalheParadaDTO[] getListaparadas() {
        return listaparadas;
    }


    /**
     * Sets the listaparadas value for this DetalhamentoParadaDTO.
     * 
     * @param listaparadas
     */
    public void setListaparadas(idw.idwws.DetalheParadaDTO[] listaparadas) {
        this.listaparadas = listaparadas;
    }

    public idw.idwws.DetalheParadaDTO getListaparadas(int i) {
        return this.listaparadas[i];
    }

    public void setListaparadas(int i, idw.idwws.DetalheParadaDTO _value) {
        this.listaparadas[i] = _value;
    }


    /**
     * Gets the parada value for this DetalhamentoParadaDTO.
     * 
     * @return parada
     */
    public java.lang.String getParada() {
        return parada;
    }


    /**
     * Sets the parada value for this DetalhamentoParadaDTO.
     * 
     * @param parada
     */
    public void setParada(java.lang.String parada) {
        this.parada = parada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalhamentoParadaDTO)) return false;
        DetalhamentoParadaDTO other = (DetalhamentoParadaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.duracaoParadas==null && other.getDuracaoParadas()==null) || 
             (this.duracaoParadas!=null &&
              this.duracaoParadas.equals(other.getDuracaoParadas()))) &&
            ((this.listaparadas==null && other.getListaparadas()==null) || 
             (this.listaparadas!=null &&
              java.util.Arrays.equals(this.listaparadas, other.getListaparadas()))) &&
            ((this.parada==null && other.getParada()==null) || 
             (this.parada!=null &&
              this.parada.equals(other.getParada())));
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
        if (getDuracaoParadas() != null) {
            _hashCode += getDuracaoParadas().hashCode();
        }
        if (getListaparadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaparadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaparadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParada() != null) {
            _hashCode += getParada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalhamentoParadaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalhamentoParadaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracaoParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracaoParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaparadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaparadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheParadaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parada"));
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
