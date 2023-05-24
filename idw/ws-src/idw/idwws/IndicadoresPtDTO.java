/**
 * IndicadoresPtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IndicadoresPtDTO  implements java.io.Serializable {
    private idw.idwws.IndicadoresDTO indicadoresDTO;

    private idw.idwws.OmPt omPt;

    public IndicadoresPtDTO() {
    }

    public IndicadoresPtDTO(
           idw.idwws.IndicadoresDTO indicadoresDTO,
           idw.idwws.OmPt omPt) {
           this.indicadoresDTO = indicadoresDTO;
           this.omPt = omPt;
    }


    /**
     * Gets the indicadoresDTO value for this IndicadoresPtDTO.
     * 
     * @return indicadoresDTO
     */
    public idw.idwws.IndicadoresDTO getIndicadoresDTO() {
        return indicadoresDTO;
    }


    /**
     * Sets the indicadoresDTO value for this IndicadoresPtDTO.
     * 
     * @param indicadoresDTO
     */
    public void setIndicadoresDTO(idw.idwws.IndicadoresDTO indicadoresDTO) {
        this.indicadoresDTO = indicadoresDTO;
    }


    /**
     * Gets the omPt value for this IndicadoresPtDTO.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this IndicadoresPtDTO.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndicadoresPtDTO)) return false;
        IndicadoresPtDTO other = (IndicadoresPtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indicadoresDTO==null && other.getIndicadoresDTO()==null) || 
             (this.indicadoresDTO!=null &&
              this.indicadoresDTO.equals(other.getIndicadoresDTO()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt())));
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
        if (getIndicadoresDTO() != null) {
            _hashCode += getIndicadoresDTO().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndicadoresPtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadoresPtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadoresDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadoresDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadoresDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
