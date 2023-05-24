/**
 * ListaEvtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ListaEvtDTO  implements java.io.Serializable {
    private idw.idwws.EvtDTO[] listaEvtDTO;

    private idw.idwws.ResultadoMSDTO resultadoDTO;

    public ListaEvtDTO() {
    }

    public ListaEvtDTO(
           idw.idwws.EvtDTO[] listaEvtDTO,
           idw.idwws.ResultadoMSDTO resultadoDTO) {
           this.listaEvtDTO = listaEvtDTO;
           this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the listaEvtDTO value for this ListaEvtDTO.
     * 
     * @return listaEvtDTO
     */
    public idw.idwws.EvtDTO[] getListaEvtDTO() {
        return listaEvtDTO;
    }


    /**
     * Sets the listaEvtDTO value for this ListaEvtDTO.
     * 
     * @param listaEvtDTO
     */
    public void setListaEvtDTO(idw.idwws.EvtDTO[] listaEvtDTO) {
        this.listaEvtDTO = listaEvtDTO;
    }

    public idw.idwws.EvtDTO getListaEvtDTO(int i) {
        return this.listaEvtDTO[i];
    }

    public void setListaEvtDTO(int i, idw.idwws.EvtDTO _value) {
        this.listaEvtDTO[i] = _value;
    }


    /**
     * Gets the resultadoDTO value for this ListaEvtDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoMSDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this ListaEvtDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoMSDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaEvtDTO)) return false;
        ListaEvtDTO other = (ListaEvtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaEvtDTO==null && other.getListaEvtDTO()==null) || 
             (this.listaEvtDTO!=null &&
              java.util.Arrays.equals(this.listaEvtDTO, other.getListaEvtDTO()))) &&
            ((this.resultadoDTO==null && other.getResultadoDTO()==null) || 
             (this.resultadoDTO!=null &&
              this.resultadoDTO.equals(other.getResultadoDTO())));
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
        if (getListaEvtDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaEvtDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaEvtDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultadoDTO() != null) {
            _hashCode += getResultadoDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListaEvtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaEvtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaEvtDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaEvtDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "evtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoMSDTO"));
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
