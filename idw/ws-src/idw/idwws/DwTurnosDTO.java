/**
 * DwTurnosDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTurnosDTO  implements java.io.Serializable {
    private idw.idwws.DwTurnoDTO[] listaDwTurnoDTO;

    private int resultadoEvento;

    public DwTurnosDTO() {
    }

    public DwTurnosDTO(
           idw.idwws.DwTurnoDTO[] listaDwTurnoDTO,
           int resultadoEvento) {
           this.listaDwTurnoDTO = listaDwTurnoDTO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the listaDwTurnoDTO value for this DwTurnosDTO.
     * 
     * @return listaDwTurnoDTO
     */
    public idw.idwws.DwTurnoDTO[] getListaDwTurnoDTO() {
        return listaDwTurnoDTO;
    }


    /**
     * Sets the listaDwTurnoDTO value for this DwTurnosDTO.
     * 
     * @param listaDwTurnoDTO
     */
    public void setListaDwTurnoDTO(idw.idwws.DwTurnoDTO[] listaDwTurnoDTO) {
        this.listaDwTurnoDTO = listaDwTurnoDTO;
    }

    public idw.idwws.DwTurnoDTO getListaDwTurnoDTO(int i) {
        return this.listaDwTurnoDTO[i];
    }

    public void setListaDwTurnoDTO(int i, idw.idwws.DwTurnoDTO _value) {
        this.listaDwTurnoDTO[i] = _value;
    }


    /**
     * Gets the resultadoEvento value for this DwTurnosDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this DwTurnosDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTurnosDTO)) return false;
        DwTurnosDTO other = (DwTurnosDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaDwTurnoDTO==null && other.getListaDwTurnoDTO()==null) || 
             (this.listaDwTurnoDTO!=null &&
              java.util.Arrays.equals(this.listaDwTurnoDTO, other.getListaDwTurnoDTO()))) &&
            this.resultadoEvento == other.getResultadoEvento();
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
        if (getListaDwTurnoDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDwTurnoDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDwTurnoDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTurnosDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurnosDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDwTurnoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaDwTurnoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurnoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
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
