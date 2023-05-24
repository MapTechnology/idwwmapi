/**
 * PpClienteDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpClienteDTO  implements java.io.Serializable {
    private idw.idwws.PpCliente ppCliente;

    public PpClienteDTO() {
    }

    public PpClienteDTO(
           idw.idwws.PpCliente ppCliente) {
           this.ppCliente = ppCliente;
    }


    /**
     * Gets the ppCliente value for this PpClienteDTO.
     * 
     * @return ppCliente
     */
    public idw.idwws.PpCliente getPpCliente() {
        return ppCliente;
    }


    /**
     * Sets the ppCliente value for this PpClienteDTO.
     * 
     * @param ppCliente
     */
    public void setPpCliente(idw.idwws.PpCliente ppCliente) {
        this.ppCliente = ppCliente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpClienteDTO)) return false;
        PpClienteDTO other = (PpClienteDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ppCliente==null && other.getPpCliente()==null) || 
             (this.ppCliente!=null &&
              this.ppCliente.equals(other.getPpCliente())));
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
        if (getPpCliente() != null) {
            _hashCode += getPpCliente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpClienteDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppClienteDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
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
