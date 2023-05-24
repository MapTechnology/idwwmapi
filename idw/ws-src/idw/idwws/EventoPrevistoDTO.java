/**
 * EventoPrevistoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EventoPrevistoDTO  implements java.io.Serializable {
    private idw.idwws.PortaEthernetDTO portaEthernet;

    private idw.idwws.PortaSerial232DTO portaSerial232;

    private idw.idwws.PortaSerial485DTO portaSerial485;

    private idw.idwws.PortaUSBDTO portaUSB;

    private java.lang.String reflectionTratadorSinal;

    private java.lang.Integer tipoPorta;

    public EventoPrevistoDTO() {
    }

    public EventoPrevistoDTO(
           idw.idwws.PortaEthernetDTO portaEthernet,
           idw.idwws.PortaSerial232DTO portaSerial232,
           idw.idwws.PortaSerial485DTO portaSerial485,
           idw.idwws.PortaUSBDTO portaUSB,
           java.lang.String reflectionTratadorSinal,
           java.lang.Integer tipoPorta) {
           this.portaEthernet = portaEthernet;
           this.portaSerial232 = portaSerial232;
           this.portaSerial485 = portaSerial485;
           this.portaUSB = portaUSB;
           this.reflectionTratadorSinal = reflectionTratadorSinal;
           this.tipoPorta = tipoPorta;
    }


    /**
     * Gets the portaEthernet value for this EventoPrevistoDTO.
     * 
     * @return portaEthernet
     */
    public idw.idwws.PortaEthernetDTO getPortaEthernet() {
        return portaEthernet;
    }


    /**
     * Sets the portaEthernet value for this EventoPrevistoDTO.
     * 
     * @param portaEthernet
     */
    public void setPortaEthernet(idw.idwws.PortaEthernetDTO portaEthernet) {
        this.portaEthernet = portaEthernet;
    }


    /**
     * Gets the portaSerial232 value for this EventoPrevistoDTO.
     * 
     * @return portaSerial232
     */
    public idw.idwws.PortaSerial232DTO getPortaSerial232() {
        return portaSerial232;
    }


    /**
     * Sets the portaSerial232 value for this EventoPrevistoDTO.
     * 
     * @param portaSerial232
     */
    public void setPortaSerial232(idw.idwws.PortaSerial232DTO portaSerial232) {
        this.portaSerial232 = portaSerial232;
    }


    /**
     * Gets the portaSerial485 value for this EventoPrevistoDTO.
     * 
     * @return portaSerial485
     */
    public idw.idwws.PortaSerial485DTO getPortaSerial485() {
        return portaSerial485;
    }


    /**
     * Sets the portaSerial485 value for this EventoPrevistoDTO.
     * 
     * @param portaSerial485
     */
    public void setPortaSerial485(idw.idwws.PortaSerial485DTO portaSerial485) {
        this.portaSerial485 = portaSerial485;
    }


    /**
     * Gets the portaUSB value for this EventoPrevistoDTO.
     * 
     * @return portaUSB
     */
    public idw.idwws.PortaUSBDTO getPortaUSB() {
        return portaUSB;
    }


    /**
     * Sets the portaUSB value for this EventoPrevistoDTO.
     * 
     * @param portaUSB
     */
    public void setPortaUSB(idw.idwws.PortaUSBDTO portaUSB) {
        this.portaUSB = portaUSB;
    }


    /**
     * Gets the reflectionTratadorSinal value for this EventoPrevistoDTO.
     * 
     * @return reflectionTratadorSinal
     */
    public java.lang.String getReflectionTratadorSinal() {
        return reflectionTratadorSinal;
    }


    /**
     * Sets the reflectionTratadorSinal value for this EventoPrevistoDTO.
     * 
     * @param reflectionTratadorSinal
     */
    public void setReflectionTratadorSinal(java.lang.String reflectionTratadorSinal) {
        this.reflectionTratadorSinal = reflectionTratadorSinal;
    }


    /**
     * Gets the tipoPorta value for this EventoPrevistoDTO.
     * 
     * @return tipoPorta
     */
    public java.lang.Integer getTipoPorta() {
        return tipoPorta;
    }


    /**
     * Sets the tipoPorta value for this EventoPrevistoDTO.
     * 
     * @param tipoPorta
     */
    public void setTipoPorta(java.lang.Integer tipoPorta) {
        this.tipoPorta = tipoPorta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventoPrevistoDTO)) return false;
        EventoPrevistoDTO other = (EventoPrevistoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.portaEthernet==null && other.getPortaEthernet()==null) || 
             (this.portaEthernet!=null &&
              this.portaEthernet.equals(other.getPortaEthernet()))) &&
            ((this.portaSerial232==null && other.getPortaSerial232()==null) || 
             (this.portaSerial232!=null &&
              this.portaSerial232.equals(other.getPortaSerial232()))) &&
            ((this.portaSerial485==null && other.getPortaSerial485()==null) || 
             (this.portaSerial485!=null &&
              this.portaSerial485.equals(other.getPortaSerial485()))) &&
            ((this.portaUSB==null && other.getPortaUSB()==null) || 
             (this.portaUSB!=null &&
              this.portaUSB.equals(other.getPortaUSB()))) &&
            ((this.reflectionTratadorSinal==null && other.getReflectionTratadorSinal()==null) || 
             (this.reflectionTratadorSinal!=null &&
              this.reflectionTratadorSinal.equals(other.getReflectionTratadorSinal()))) &&
            ((this.tipoPorta==null && other.getTipoPorta()==null) || 
             (this.tipoPorta!=null &&
              this.tipoPorta.equals(other.getTipoPorta())));
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
        if (getPortaEthernet() != null) {
            _hashCode += getPortaEthernet().hashCode();
        }
        if (getPortaSerial232() != null) {
            _hashCode += getPortaSerial232().hashCode();
        }
        if (getPortaSerial485() != null) {
            _hashCode += getPortaSerial485().hashCode();
        }
        if (getPortaUSB() != null) {
            _hashCode += getPortaUSB().hashCode();
        }
        if (getReflectionTratadorSinal() != null) {
            _hashCode += getReflectionTratadorSinal().hashCode();
        }
        if (getTipoPorta() != null) {
            _hashCode += getTipoPorta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventoPrevistoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eventoPrevistoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaEthernet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaEthernet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaEthernetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaSerial232");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaSerial232"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaSerial232DTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaSerial485");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaSerial485"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaSerial485DTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaUSB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaUSB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "portaUSBDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reflectionTratadorSinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reflectionTratadorSinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPorta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoPorta"));
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
