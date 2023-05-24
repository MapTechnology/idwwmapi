/**
 * DetalhePTDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalhePTDTO  implements java.io.Serializable {
    private idw.idwws.OmCfg omCfg;

    private idw.idwws.ResultadoDTO resultado;

    private idw.idwws.DetalhePTSerieDTO[] series;

    public DetalhePTDTO() {
    }

    public DetalhePTDTO(
           idw.idwws.OmCfg omCfg,
           idw.idwws.ResultadoDTO resultado,
           idw.idwws.DetalhePTSerieDTO[] series) {
           this.omCfg = omCfg;
           this.resultado = resultado;
           this.series = series;
    }


    /**
     * Gets the omCfg value for this DetalhePTDTO.
     * 
     * @return omCfg
     */
    public idw.idwws.OmCfg getOmCfg() {
        return omCfg;
    }


    /**
     * Sets the omCfg value for this DetalhePTDTO.
     * 
     * @param omCfg
     */
    public void setOmCfg(idw.idwws.OmCfg omCfg) {
        this.omCfg = omCfg;
    }


    /**
     * Gets the resultado value for this DetalhePTDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this DetalhePTDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the series value for this DetalhePTDTO.
     * 
     * @return series
     */
    public idw.idwws.DetalhePTSerieDTO[] getSeries() {
        return series;
    }


    /**
     * Sets the series value for this DetalhePTDTO.
     * 
     * @param series
     */
    public void setSeries(idw.idwws.DetalhePTSerieDTO[] series) {
        this.series = series;
    }

    public idw.idwws.DetalhePTSerieDTO getSeries(int i) {
        return this.series[i];
    }

    public void setSeries(int i, idw.idwws.DetalhePTSerieDTO _value) {
        this.series[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalhePTDTO)) return false;
        DetalhePTDTO other = (DetalhePTDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.omCfg==null && other.getOmCfg()==null) || 
             (this.omCfg!=null &&
              this.omCfg.equals(other.getOmCfg()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.series==null && other.getSeries()==null) || 
             (this.series!=null &&
              java.util.Arrays.equals(this.series, other.getSeries())));
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
        if (getOmCfg() != null) {
            _hashCode += getOmCfg().hashCode();
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getSeries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSeries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSeries(), i);
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
        new org.apache.axis.description.TypeDesc(DetalhePTDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalhePTDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("series");
        elemField.setXmlName(new javax.xml.namespace.QName("", "series"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalhePTSerieDTO"));
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
