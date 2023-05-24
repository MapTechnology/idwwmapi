/**
 * DwTJustDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTJustDTO  implements java.io.Serializable {
    private idw.idwws.DwTJust dwTJust;

    public DwTJustDTO() {
    }

    public DwTJustDTO(
           idw.idwws.DwTJust dwTJust) {
           this.dwTJust = dwTJust;
    }


    /**
     * Gets the dwTJust value for this DwTJustDTO.
     * 
     * @return dwTJust
     */
    public idw.idwws.DwTJust getDwTJust() {
        return dwTJust;
    }


    /**
     * Sets the dwTJust value for this DwTJustDTO.
     * 
     * @param dwTJust
     */
    public void setDwTJust(idw.idwws.DwTJust dwTJust) {
        this.dwTJust = dwTJust;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTJustDTO)) return false;
        DwTJustDTO other = (DwTJustDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwTJust==null && other.getDwTJust()==null) || 
             (this.dwTJust!=null &&
              this.dwTJust.equals(other.getDwTJust())));
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
        if (getDwTJust() != null) {
            _hashCode += getDwTJust().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTJustDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTJustDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTJust");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTJust"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTJust"));
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
