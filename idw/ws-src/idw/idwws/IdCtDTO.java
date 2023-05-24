/**
 * IdCtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IdCtDTO  implements java.io.Serializable {
    private idw.idwws.OmGt omgtEscolhido;

    private idw.idwws.OmPt omptEscolhido;

    public IdCtDTO() {
    }

    public IdCtDTO(
           idw.idwws.OmGt omgtEscolhido,
           idw.idwws.OmPt omptEscolhido) {
           this.omgtEscolhido = omgtEscolhido;
           this.omptEscolhido = omptEscolhido;
    }


    /**
     * Gets the omgtEscolhido value for this IdCtDTO.
     * 
     * @return omgtEscolhido
     */
    public idw.idwws.OmGt getOmgtEscolhido() {
        return omgtEscolhido;
    }


    /**
     * Sets the omgtEscolhido value for this IdCtDTO.
     * 
     * @param omgtEscolhido
     */
    public void setOmgtEscolhido(idw.idwws.OmGt omgtEscolhido) {
        this.omgtEscolhido = omgtEscolhido;
    }


    /**
     * Gets the omptEscolhido value for this IdCtDTO.
     * 
     * @return omptEscolhido
     */
    public idw.idwws.OmPt getOmptEscolhido() {
        return omptEscolhido;
    }


    /**
     * Sets the omptEscolhido value for this IdCtDTO.
     * 
     * @param omptEscolhido
     */
    public void setOmptEscolhido(idw.idwws.OmPt omptEscolhido) {
        this.omptEscolhido = omptEscolhido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdCtDTO)) return false;
        IdCtDTO other = (IdCtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.omgtEscolhido==null && other.getOmgtEscolhido()==null) || 
             (this.omgtEscolhido!=null &&
              this.omgtEscolhido.equals(other.getOmgtEscolhido()))) &&
            ((this.omptEscolhido==null && other.getOmptEscolhido()==null) || 
             (this.omptEscolhido!=null &&
              this.omptEscolhido.equals(other.getOmptEscolhido())));
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
        if (getOmgtEscolhido() != null) {
            _hashCode += getOmgtEscolhido().hashCode();
        }
        if (getOmptEscolhido() != null) {
            _hashCode += getOmptEscolhido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdCtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "idCtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omgtEscolhido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omgtEscolhido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omptEscolhido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omptEscolhido"));
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
