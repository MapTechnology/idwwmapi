/**
 * PpTpplanoListDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpTpplanoListDTO  implements java.io.Serializable {
    private idw.idwws.ResultadoDTO resultado;

    private idw.idwws.PpTpplanoDTO[] tpPlanos;

    public PpTpplanoListDTO() {
    }

    public PpTpplanoListDTO(
           idw.idwws.ResultadoDTO resultado,
           idw.idwws.PpTpplanoDTO[] tpPlanos) {
           this.resultado = resultado;
           this.tpPlanos = tpPlanos;
    }


    /**
     * Gets the resultado value for this PpTpplanoListDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this PpTpplanoListDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the tpPlanos value for this PpTpplanoListDTO.
     * 
     * @return tpPlanos
     */
    public idw.idwws.PpTpplanoDTO[] getTpPlanos() {
        return tpPlanos;
    }


    /**
     * Sets the tpPlanos value for this PpTpplanoListDTO.
     * 
     * @param tpPlanos
     */
    public void setTpPlanos(idw.idwws.PpTpplanoDTO[] tpPlanos) {
        this.tpPlanos = tpPlanos;
    }

    public idw.idwws.PpTpplanoDTO getTpPlanos(int i) {
        return this.tpPlanos[i];
    }

    public void setTpPlanos(int i, idw.idwws.PpTpplanoDTO _value) {
        this.tpPlanos[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpTpplanoListDTO)) return false;
        PpTpplanoListDTO other = (PpTpplanoListDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.tpPlanos==null && other.getTpPlanos()==null) || 
             (this.tpPlanos!=null &&
              java.util.Arrays.equals(this.tpPlanos, other.getTpPlanos())));
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
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getTpPlanos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTpPlanos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTpPlanos(), i);
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
        new org.apache.axis.description.TypeDesc(PpTpplanoListDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppTpplanoListDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpPlanos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpPlanos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppTpplanoDTO"));
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
