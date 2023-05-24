/**
 * TempoRealDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TempoRealDTO  implements java.io.Serializable {
    private idw.idwws.DwRt dwRt;

    public TempoRealDTO() {
    }

    public TempoRealDTO(
           idw.idwws.DwRt dwRt) {
           this.dwRt = dwRt;
    }


    /**
     * Gets the dwRt value for this TempoRealDTO.
     * 
     * @return dwRt
     */
    public idw.idwws.DwRt getDwRt() {
        return dwRt;
    }


    /**
     * Sets the dwRt value for this TempoRealDTO.
     * 
     * @param dwRt
     */
    public void setDwRt(idw.idwws.DwRt dwRt) {
        this.dwRt = dwRt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TempoRealDTO)) return false;
        TempoRealDTO other = (TempoRealDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwRt==null && other.getDwRt()==null) || 
             (this.dwRt!=null &&
              this.dwRt.equals(other.getDwRt())));
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
        if (getDwRt() != null) {
            _hashCode += getDwRt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TempoRealDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "tempoRealDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRt"));
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
