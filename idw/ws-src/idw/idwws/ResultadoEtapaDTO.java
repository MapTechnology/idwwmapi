/**
 * ResultadoEtapaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ResultadoEtapaDTO  implements java.io.Serializable {
    private long idEtapa;

    private int ordemEtapa;

    private idw.idwws.ResultadoSubetapaDTO[] subetapas;

    public ResultadoEtapaDTO() {
    }

    public ResultadoEtapaDTO(
           long idEtapa,
           int ordemEtapa,
           idw.idwws.ResultadoSubetapaDTO[] subetapas) {
           this.idEtapa = idEtapa;
           this.ordemEtapa = ordemEtapa;
           this.subetapas = subetapas;
    }


    /**
     * Gets the idEtapa value for this ResultadoEtapaDTO.
     * 
     * @return idEtapa
     */
    public long getIdEtapa() {
        return idEtapa;
    }


    /**
     * Sets the idEtapa value for this ResultadoEtapaDTO.
     * 
     * @param idEtapa
     */
    public void setIdEtapa(long idEtapa) {
        this.idEtapa = idEtapa;
    }


    /**
     * Gets the ordemEtapa value for this ResultadoEtapaDTO.
     * 
     * @return ordemEtapa
     */
    public int getOrdemEtapa() {
        return ordemEtapa;
    }


    /**
     * Sets the ordemEtapa value for this ResultadoEtapaDTO.
     * 
     * @param ordemEtapa
     */
    public void setOrdemEtapa(int ordemEtapa) {
        this.ordemEtapa = ordemEtapa;
    }


    /**
     * Gets the subetapas value for this ResultadoEtapaDTO.
     * 
     * @return subetapas
     */
    public idw.idwws.ResultadoSubetapaDTO[] getSubetapas() {
        return subetapas;
    }


    /**
     * Sets the subetapas value for this ResultadoEtapaDTO.
     * 
     * @param subetapas
     */
    public void setSubetapas(idw.idwws.ResultadoSubetapaDTO[] subetapas) {
        this.subetapas = subetapas;
    }

    public idw.idwws.ResultadoSubetapaDTO getSubetapas(int i) {
        return this.subetapas[i];
    }

    public void setSubetapas(int i, idw.idwws.ResultadoSubetapaDTO _value) {
        this.subetapas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoEtapaDTO)) return false;
        ResultadoEtapaDTO other = (ResultadoEtapaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idEtapa == other.getIdEtapa() &&
            this.ordemEtapa == other.getOrdemEtapa() &&
            ((this.subetapas==null && other.getSubetapas()==null) || 
             (this.subetapas!=null &&
              java.util.Arrays.equals(this.subetapas, other.getSubetapas())));
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
        _hashCode += new Long(getIdEtapa()).hashCode();
        _hashCode += getOrdemEtapa();
        if (getSubetapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubetapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubetapas(), i);
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
        new org.apache.axis.description.TypeDesc(ResultadoEtapaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoEtapaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subetapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subetapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoSubetapaDTO"));
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
