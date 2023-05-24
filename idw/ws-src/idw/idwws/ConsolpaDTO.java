/**
 * ConsolpaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ConsolpaDTO  implements java.io.Serializable {
    private idw.idwws.DwConsolpa dwConsolpa;

    public ConsolpaDTO() {
    }

    public ConsolpaDTO(
           idw.idwws.DwConsolpa dwConsolpa) {
           this.dwConsolpa = dwConsolpa;
    }


    /**
     * Gets the dwConsolpa value for this ConsolpaDTO.
     * 
     * @return dwConsolpa
     */
    public idw.idwws.DwConsolpa getDwConsolpa() {
        return dwConsolpa;
    }


    /**
     * Sets the dwConsolpa value for this ConsolpaDTO.
     * 
     * @param dwConsolpa
     */
    public void setDwConsolpa(idw.idwws.DwConsolpa dwConsolpa) {
        this.dwConsolpa = dwConsolpa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsolpaDTO)) return false;
        ConsolpaDTO other = (ConsolpaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsolpa==null && other.getDwConsolpa()==null) || 
             (this.dwConsolpa!=null &&
              this.dwConsolpa.equals(other.getDwConsolpa())));
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
        if (getDwConsolpa() != null) {
            _hashCode += getDwConsolpa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsolpaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "consolpaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpa"));
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
