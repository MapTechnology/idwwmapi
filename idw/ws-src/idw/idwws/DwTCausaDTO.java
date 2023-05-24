/**
 * DwTCausaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTCausaDTO  implements java.io.Serializable {
    private idw.idwws.DwTCausa dwTCausa;

    public DwTCausaDTO() {
    }

    public DwTCausaDTO(
           idw.idwws.DwTCausa dwTCausa) {
           this.dwTCausa = dwTCausa;
    }


    /**
     * Gets the dwTCausa value for this DwTCausaDTO.
     * 
     * @return dwTCausa
     */
    public idw.idwws.DwTCausa getDwTCausa() {
        return dwTCausa;
    }


    /**
     * Sets the dwTCausa value for this DwTCausaDTO.
     * 
     * @param dwTCausa
     */
    public void setDwTCausa(idw.idwws.DwTCausa dwTCausa) {
        this.dwTCausa = dwTCausa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTCausaDTO)) return false;
        DwTCausaDTO other = (DwTCausaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwTCausa==null && other.getDwTCausa()==null) || 
             (this.dwTCausa!=null &&
              this.dwTCausa.equals(other.getDwTCausa())));
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
        if (getDwTCausa() != null) {
            _hashCode += getDwTCausa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTCausaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTCausaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTCausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTCausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTCausa"));
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
