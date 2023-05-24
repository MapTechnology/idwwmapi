/**
 * DwTRefugoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTRefugoDTO  implements java.io.Serializable {
    private idw.idwws.DwTRefugo dwTRefugo;

    public DwTRefugoDTO() {
    }

    public DwTRefugoDTO(
           idw.idwws.DwTRefugo dwTRefugo) {
           this.dwTRefugo = dwTRefugo;
    }


    /**
     * Gets the dwTRefugo value for this DwTRefugoDTO.
     * 
     * @return dwTRefugo
     */
    public idw.idwws.DwTRefugo getDwTRefugo() {
        return dwTRefugo;
    }


    /**
     * Sets the dwTRefugo value for this DwTRefugoDTO.
     * 
     * @param dwTRefugo
     */
    public void setDwTRefugo(idw.idwws.DwTRefugo dwTRefugo) {
        this.dwTRefugo = dwTRefugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTRefugoDTO)) return false;
        DwTRefugoDTO other = (DwTRefugoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwTRefugo==null && other.getDwTRefugo()==null) || 
             (this.dwTRefugo!=null &&
              this.dwTRefugo.equals(other.getDwTRefugo())));
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
        if (getDwTRefugo() != null) {
            _hashCode += getDwTRefugo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTRefugoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
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
