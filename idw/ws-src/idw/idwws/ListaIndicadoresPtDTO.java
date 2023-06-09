/**
 * ListaIndicadoresPtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ListaIndicadoresPtDTO  implements java.io.Serializable {
    private idw.idwws.IndicadoresDTO indicadoresDTO;

    private idw.idwws.IndicadoresPtDTO[] lista;

    public ListaIndicadoresPtDTO() {
    }

    public ListaIndicadoresPtDTO(
           idw.idwws.IndicadoresDTO indicadoresDTO,
           idw.idwws.IndicadoresPtDTO[] lista) {
           this.indicadoresDTO = indicadoresDTO;
           this.lista = lista;
    }


    /**
     * Gets the indicadoresDTO value for this ListaIndicadoresPtDTO.
     * 
     * @return indicadoresDTO
     */
    public idw.idwws.IndicadoresDTO getIndicadoresDTO() {
        return indicadoresDTO;
    }


    /**
     * Sets the indicadoresDTO value for this ListaIndicadoresPtDTO.
     * 
     * @param indicadoresDTO
     */
    public void setIndicadoresDTO(idw.idwws.IndicadoresDTO indicadoresDTO) {
        this.indicadoresDTO = indicadoresDTO;
    }


    /**
     * Gets the lista value for this ListaIndicadoresPtDTO.
     * 
     * @return lista
     */
    public idw.idwws.IndicadoresPtDTO[] getLista() {
        return lista;
    }


    /**
     * Sets the lista value for this ListaIndicadoresPtDTO.
     * 
     * @param lista
     */
    public void setLista(idw.idwws.IndicadoresPtDTO[] lista) {
        this.lista = lista;
    }

    public idw.idwws.IndicadoresPtDTO getLista(int i) {
        return this.lista[i];
    }

    public void setLista(int i, idw.idwws.IndicadoresPtDTO _value) {
        this.lista[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaIndicadoresPtDTO)) return false;
        ListaIndicadoresPtDTO other = (ListaIndicadoresPtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indicadoresDTO==null && other.getIndicadoresDTO()==null) || 
             (this.indicadoresDTO!=null &&
              this.indicadoresDTO.equals(other.getIndicadoresDTO()))) &&
            ((this.lista==null && other.getLista()==null) || 
             (this.lista!=null &&
              java.util.Arrays.equals(this.lista, other.getLista())));
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
        if (getIndicadoresDTO() != null) {
            _hashCode += getIndicadoresDTO().hashCode();
        }
        if (getLista() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLista());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLista(), i);
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
        new org.apache.axis.description.TypeDesc(ListaIndicadoresPtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaIndicadoresPtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadoresDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadoresDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadoresDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadoresPtDTO"));
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
