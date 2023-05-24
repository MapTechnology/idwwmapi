/**
 * GraficosParettoParadaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficosParettoParadaDTO  implements java.io.Serializable {
    private idw.idwws.DatasDTO corAmarela;

    private idw.idwws.DatasDTO corLaranja;

    private idw.idwws.DatasDTO corVerde;

    private idw.idwws.DatasDTO corVermelho;

    private idw.idwws.GraficoParettoParadaDTO[] paradas;

    public GraficosParettoParadaDTO() {
    }

    public GraficosParettoParadaDTO(
           idw.idwws.DatasDTO corAmarela,
           idw.idwws.DatasDTO corLaranja,
           idw.idwws.DatasDTO corVerde,
           idw.idwws.DatasDTO corVermelho,
           idw.idwws.GraficoParettoParadaDTO[] paradas) {
           this.corAmarela = corAmarela;
           this.corLaranja = corLaranja;
           this.corVerde = corVerde;
           this.corVermelho = corVermelho;
           this.paradas = paradas;
    }


    /**
     * Gets the corAmarela value for this GraficosParettoParadaDTO.
     * 
     * @return corAmarela
     */
    public idw.idwws.DatasDTO getCorAmarela() {
        return corAmarela;
    }


    /**
     * Sets the corAmarela value for this GraficosParettoParadaDTO.
     * 
     * @param corAmarela
     */
    public void setCorAmarela(idw.idwws.DatasDTO corAmarela) {
        this.corAmarela = corAmarela;
    }


    /**
     * Gets the corLaranja value for this GraficosParettoParadaDTO.
     * 
     * @return corLaranja
     */
    public idw.idwws.DatasDTO getCorLaranja() {
        return corLaranja;
    }


    /**
     * Sets the corLaranja value for this GraficosParettoParadaDTO.
     * 
     * @param corLaranja
     */
    public void setCorLaranja(idw.idwws.DatasDTO corLaranja) {
        this.corLaranja = corLaranja;
    }


    /**
     * Gets the corVerde value for this GraficosParettoParadaDTO.
     * 
     * @return corVerde
     */
    public idw.idwws.DatasDTO getCorVerde() {
        return corVerde;
    }


    /**
     * Sets the corVerde value for this GraficosParettoParadaDTO.
     * 
     * @param corVerde
     */
    public void setCorVerde(idw.idwws.DatasDTO corVerde) {
        this.corVerde = corVerde;
    }


    /**
     * Gets the corVermelho value for this GraficosParettoParadaDTO.
     * 
     * @return corVermelho
     */
    public idw.idwws.DatasDTO getCorVermelho() {
        return corVermelho;
    }


    /**
     * Sets the corVermelho value for this GraficosParettoParadaDTO.
     * 
     * @param corVermelho
     */
    public void setCorVermelho(idw.idwws.DatasDTO corVermelho) {
        this.corVermelho = corVermelho;
    }


    /**
     * Gets the paradas value for this GraficosParettoParadaDTO.
     * 
     * @return paradas
     */
    public idw.idwws.GraficoParettoParadaDTO[] getParadas() {
        return paradas;
    }


    /**
     * Sets the paradas value for this GraficosParettoParadaDTO.
     * 
     * @param paradas
     */
    public void setParadas(idw.idwws.GraficoParettoParadaDTO[] paradas) {
        this.paradas = paradas;
    }

    public idw.idwws.GraficoParettoParadaDTO getParadas(int i) {
        return this.paradas[i];
    }

    public void setParadas(int i, idw.idwws.GraficoParettoParadaDTO _value) {
        this.paradas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficosParettoParadaDTO)) return false;
        GraficosParettoParadaDTO other = (GraficosParettoParadaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.corAmarela==null && other.getCorAmarela()==null) || 
             (this.corAmarela!=null &&
              this.corAmarela.equals(other.getCorAmarela()))) &&
            ((this.corLaranja==null && other.getCorLaranja()==null) || 
             (this.corLaranja!=null &&
              this.corLaranja.equals(other.getCorLaranja()))) &&
            ((this.corVerde==null && other.getCorVerde()==null) || 
             (this.corVerde!=null &&
              this.corVerde.equals(other.getCorVerde()))) &&
            ((this.corVermelho==null && other.getCorVermelho()==null) || 
             (this.corVermelho!=null &&
              this.corVermelho.equals(other.getCorVermelho()))) &&
            ((this.paradas==null && other.getParadas()==null) || 
             (this.paradas!=null &&
              java.util.Arrays.equals(this.paradas, other.getParadas())));
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
        if (getCorAmarela() != null) {
            _hashCode += getCorAmarela().hashCode();
        }
        if (getCorLaranja() != null) {
            _hashCode += getCorLaranja().hashCode();
        }
        if (getCorVerde() != null) {
            _hashCode += getCorVerde().hashCode();
        }
        if (getCorVermelho() != null) {
            _hashCode += getCorVermelho().hashCode();
        }
        if (getParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParadas(), i);
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
        new org.apache.axis.description.TypeDesc(GraficosParettoParadaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficosParettoParadaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corAmarela");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corAmarela"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "datasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corLaranja");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corLaranja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "datasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corVerde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corVerde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "datasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corVermelho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corVermelho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "datasDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoParettoParadaDTO"));
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
