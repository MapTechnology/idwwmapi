/**
 * ListaDetalheAnaliseTurnoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ListaDetalheAnaliseTurnoDTO  implements java.io.Serializable {
    private idw.idwws.DetalheAnaliseTurnoDTO[] analiseTurnoPorMaquina;

    private idw.idwws.DetalheAnaliseTurnoDTO analiseTurnoTodasMaquinas;

    public ListaDetalheAnaliseTurnoDTO() {
    }

    public ListaDetalheAnaliseTurnoDTO(
           idw.idwws.DetalheAnaliseTurnoDTO[] analiseTurnoPorMaquina,
           idw.idwws.DetalheAnaliseTurnoDTO analiseTurnoTodasMaquinas) {
           this.analiseTurnoPorMaquina = analiseTurnoPorMaquina;
           this.analiseTurnoTodasMaquinas = analiseTurnoTodasMaquinas;
    }


    /**
     * Gets the analiseTurnoPorMaquina value for this ListaDetalheAnaliseTurnoDTO.
     * 
     * @return analiseTurnoPorMaquina
     */
    public idw.idwws.DetalheAnaliseTurnoDTO[] getAnaliseTurnoPorMaquina() {
        return analiseTurnoPorMaquina;
    }


    /**
     * Sets the analiseTurnoPorMaquina value for this ListaDetalheAnaliseTurnoDTO.
     * 
     * @param analiseTurnoPorMaquina
     */
    public void setAnaliseTurnoPorMaquina(idw.idwws.DetalheAnaliseTurnoDTO[] analiseTurnoPorMaquina) {
        this.analiseTurnoPorMaquina = analiseTurnoPorMaquina;
    }

    public idw.idwws.DetalheAnaliseTurnoDTO getAnaliseTurnoPorMaquina(int i) {
        return this.analiseTurnoPorMaquina[i];
    }

    public void setAnaliseTurnoPorMaquina(int i, idw.idwws.DetalheAnaliseTurnoDTO _value) {
        this.analiseTurnoPorMaquina[i] = _value;
    }


    /**
     * Gets the analiseTurnoTodasMaquinas value for this ListaDetalheAnaliseTurnoDTO.
     * 
     * @return analiseTurnoTodasMaquinas
     */
    public idw.idwws.DetalheAnaliseTurnoDTO getAnaliseTurnoTodasMaquinas() {
        return analiseTurnoTodasMaquinas;
    }


    /**
     * Sets the analiseTurnoTodasMaquinas value for this ListaDetalheAnaliseTurnoDTO.
     * 
     * @param analiseTurnoTodasMaquinas
     */
    public void setAnaliseTurnoTodasMaquinas(idw.idwws.DetalheAnaliseTurnoDTO analiseTurnoTodasMaquinas) {
        this.analiseTurnoTodasMaquinas = analiseTurnoTodasMaquinas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaDetalheAnaliseTurnoDTO)) return false;
        ListaDetalheAnaliseTurnoDTO other = (ListaDetalheAnaliseTurnoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.analiseTurnoPorMaquina==null && other.getAnaliseTurnoPorMaquina()==null) || 
             (this.analiseTurnoPorMaquina!=null &&
              java.util.Arrays.equals(this.analiseTurnoPorMaquina, other.getAnaliseTurnoPorMaquina()))) &&
            ((this.analiseTurnoTodasMaquinas==null && other.getAnaliseTurnoTodasMaquinas()==null) || 
             (this.analiseTurnoTodasMaquinas!=null &&
              this.analiseTurnoTodasMaquinas.equals(other.getAnaliseTurnoTodasMaquinas())));
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
        if (getAnaliseTurnoPorMaquina() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnaliseTurnoPorMaquina());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnaliseTurnoPorMaquina(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAnaliseTurnoTodasMaquinas() != null) {
            _hashCode += getAnaliseTurnoTodasMaquinas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListaDetalheAnaliseTurnoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaDetalheAnaliseTurnoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("analiseTurnoPorMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "analiseTurnoPorMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheAnaliseTurnoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("analiseTurnoTodasMaquinas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "analiseTurnoTodasMaquinas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheAnaliseTurnoDTO"));
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
