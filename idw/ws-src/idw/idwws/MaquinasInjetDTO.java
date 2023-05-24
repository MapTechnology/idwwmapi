/**
 * MaquinasInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MaquinasInjetDTO  implements java.io.Serializable {
    private idw.idwws.MaquinaInjetDTO[] maquinas;

    private int resultado;

    public MaquinasInjetDTO() {
    }

    public MaquinasInjetDTO(
           idw.idwws.MaquinaInjetDTO[] maquinas,
           int resultado) {
           this.maquinas = maquinas;
           this.resultado = resultado;
    }


    /**
     * Gets the maquinas value for this MaquinasInjetDTO.
     * 
     * @return maquinas
     */
    public idw.idwws.MaquinaInjetDTO[] getMaquinas() {
        return maquinas;
    }


    /**
     * Sets the maquinas value for this MaquinasInjetDTO.
     * 
     * @param maquinas
     */
    public void setMaquinas(idw.idwws.MaquinaInjetDTO[] maquinas) {
        this.maquinas = maquinas;
    }

    public idw.idwws.MaquinaInjetDTO getMaquinas(int i) {
        return this.maquinas[i];
    }

    public void setMaquinas(int i, idw.idwws.MaquinaInjetDTO _value) {
        this.maquinas[i] = _value;
    }


    /**
     * Gets the resultado value for this MaquinasInjetDTO.
     * 
     * @return resultado
     */
    public int getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this MaquinasInjetDTO.
     * 
     * @param resultado
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MaquinasInjetDTO)) return false;
        MaquinasInjetDTO other = (MaquinasInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.maquinas==null && other.getMaquinas()==null) || 
             (this.maquinas!=null &&
              java.util.Arrays.equals(this.maquinas, other.getMaquinas()))) &&
            this.resultado == other.getResultado();
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
        if (getMaquinas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMaquinas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMaquinas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getResultado();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MaquinasInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "maquinasInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquinas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquinas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "maquinaInjetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
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
