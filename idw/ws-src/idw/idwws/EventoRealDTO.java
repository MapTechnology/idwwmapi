/**
 * EventoRealDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EventoRealDTO  implements java.io.Serializable {
    private java.util.Calendar dthrEvento;

    private java.lang.Integer tipoEvento;

    public EventoRealDTO() {
    }

    public EventoRealDTO(
           java.util.Calendar dthrEvento,
           java.lang.Integer tipoEvento) {
           this.dthrEvento = dthrEvento;
           this.tipoEvento = tipoEvento;
    }


    /**
     * Gets the dthrEvento value for this EventoRealDTO.
     * 
     * @return dthrEvento
     */
    public java.util.Calendar getDthrEvento() {
        return dthrEvento;
    }


    /**
     * Sets the dthrEvento value for this EventoRealDTO.
     * 
     * @param dthrEvento
     */
    public void setDthrEvento(java.util.Calendar dthrEvento) {
        this.dthrEvento = dthrEvento;
    }


    /**
     * Gets the tipoEvento value for this EventoRealDTO.
     * 
     * @return tipoEvento
     */
    public java.lang.Integer getTipoEvento() {
        return tipoEvento;
    }


    /**
     * Sets the tipoEvento value for this EventoRealDTO.
     * 
     * @param tipoEvento
     */
    public void setTipoEvento(java.lang.Integer tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventoRealDTO)) return false;
        EventoRealDTO other = (EventoRealDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrEvento==null && other.getDthrEvento()==null) || 
             (this.dthrEvento!=null &&
              this.dthrEvento.equals(other.getDthrEvento()))) &&
            ((this.tipoEvento==null && other.getTipoEvento()==null) || 
             (this.tipoEvento!=null &&
              this.tipoEvento.equals(other.getTipoEvento())));
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
        if (getDthrEvento() != null) {
            _hashCode += getDthrEvento().hashCode();
        }
        if (getTipoEvento() != null) {
            _hashCode += getTipoEvento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventoRealDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eventoRealDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
