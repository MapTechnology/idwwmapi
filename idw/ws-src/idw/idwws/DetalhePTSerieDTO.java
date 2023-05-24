/**
 * DetalhePTSerieDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalhePTSerieDTO  implements java.io.Serializable {
    private idw.idwws.DwNserie serie;

    private idw.idwws.DwPassagem ultimaPassagem;

    public DetalhePTSerieDTO() {
    }

    public DetalhePTSerieDTO(
           idw.idwws.DwNserie serie,
           idw.idwws.DwPassagem ultimaPassagem) {
           this.serie = serie;
           this.ultimaPassagem = ultimaPassagem;
    }


    /**
     * Gets the serie value for this DetalhePTSerieDTO.
     * 
     * @return serie
     */
    public idw.idwws.DwNserie getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this DetalhePTSerieDTO.
     * 
     * @param serie
     */
    public void setSerie(idw.idwws.DwNserie serie) {
        this.serie = serie;
    }


    /**
     * Gets the ultimaPassagem value for this DetalhePTSerieDTO.
     * 
     * @return ultimaPassagem
     */
    public idw.idwws.DwPassagem getUltimaPassagem() {
        return ultimaPassagem;
    }


    /**
     * Sets the ultimaPassagem value for this DetalhePTSerieDTO.
     * 
     * @param ultimaPassagem
     */
    public void setUltimaPassagem(idw.idwws.DwPassagem ultimaPassagem) {
        this.ultimaPassagem = ultimaPassagem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalhePTSerieDTO)) return false;
        DetalhePTSerieDTO other = (DetalhePTSerieDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie()))) &&
            ((this.ultimaPassagem==null && other.getUltimaPassagem()==null) || 
             (this.ultimaPassagem!=null &&
              this.ultimaPassagem.equals(other.getUltimaPassagem())));
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
        if (getSerie() != null) {
            _hashCode += getSerie().hashCode();
        }
        if (getUltimaPassagem() != null) {
            _hashCode += getUltimaPassagem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalhePTSerieDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalhePTSerieDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwNserie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimaPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimaPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
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
