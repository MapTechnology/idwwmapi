/**
 * ListaIhmDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ListaIhmDTO  implements java.io.Serializable {
    private idw.idwws.IhmDTO[] listaIhmDTO;

    private idw.idwws.ResultadoMSDTO resultadoDTO;

    public ListaIhmDTO() {
    }

    public ListaIhmDTO(
           idw.idwws.IhmDTO[] listaIhmDTO,
           idw.idwws.ResultadoMSDTO resultadoDTO) {
           this.listaIhmDTO = listaIhmDTO;
           this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the listaIhmDTO value for this ListaIhmDTO.
     * 
     * @return listaIhmDTO
     */
    public idw.idwws.IhmDTO[] getListaIhmDTO() {
        return listaIhmDTO;
    }


    /**
     * Sets the listaIhmDTO value for this ListaIhmDTO.
     * 
     * @param listaIhmDTO
     */
    public void setListaIhmDTO(idw.idwws.IhmDTO[] listaIhmDTO) {
        this.listaIhmDTO = listaIhmDTO;
    }

    public idw.idwws.IhmDTO getListaIhmDTO(int i) {
        return this.listaIhmDTO[i];
    }

    public void setListaIhmDTO(int i, idw.idwws.IhmDTO _value) {
        this.listaIhmDTO[i] = _value;
    }


    /**
     * Gets the resultadoDTO value for this ListaIhmDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoMSDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this ListaIhmDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoMSDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaIhmDTO)) return false;
        ListaIhmDTO other = (ListaIhmDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaIhmDTO==null && other.getListaIhmDTO()==null) || 
             (this.listaIhmDTO!=null &&
              java.util.Arrays.equals(this.listaIhmDTO, other.getListaIhmDTO()))) &&
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
        if (getListaIhmDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaIhmDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaIhmDTO(), i);
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
        new org.apache.axis.description.TypeDesc(ListaIhmDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaIhmDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaIhmDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaIhmDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ihmDTO"));
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
