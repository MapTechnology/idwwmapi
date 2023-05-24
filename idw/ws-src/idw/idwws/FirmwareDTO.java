/**
 * FirmwareDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FirmwareDTO  implements java.io.Serializable {
    private java.lang.String nomeFirmware;

    public FirmwareDTO() {
    }

    public FirmwareDTO(
           java.lang.String nomeFirmware) {
           this.nomeFirmware = nomeFirmware;
    }


    /**
     * Gets the nomeFirmware value for this FirmwareDTO.
     * 
     * @return nomeFirmware
     */
    public java.lang.String getNomeFirmware() {
        return nomeFirmware;
    }


    /**
     * Sets the nomeFirmware value for this FirmwareDTO.
     * 
     * @param nomeFirmware
     */
    public void setNomeFirmware(java.lang.String nomeFirmware) {
        this.nomeFirmware = nomeFirmware;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FirmwareDTO)) return false;
        FirmwareDTO other = (FirmwareDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nomeFirmware==null && other.getNomeFirmware()==null) || 
             (this.nomeFirmware!=null &&
              this.nomeFirmware.equals(other.getNomeFirmware())));
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
        if (getNomeFirmware() != null) {
            _hashCode += getNomeFirmware().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FirmwareDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "firmwareDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeFirmware");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeFirmware"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
