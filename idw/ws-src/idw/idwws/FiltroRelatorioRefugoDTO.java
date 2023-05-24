/**
 * FiltroRelatorioRefugoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroRelatorioRefugoDTO  implements java.io.Serializable {
    private idw.idwws.OmTppt omTpptRefugo;

    private boolean ordenarRefugo;

    public FiltroRelatorioRefugoDTO() {
    }

    public FiltroRelatorioRefugoDTO(
           idw.idwws.OmTppt omTpptRefugo,
           boolean ordenarRefugo) {
           this.omTpptRefugo = omTpptRefugo;
           this.ordenarRefugo = ordenarRefugo;
    }


    /**
     * Gets the omTpptRefugo value for this FiltroRelatorioRefugoDTO.
     * 
     * @return omTpptRefugo
     */
    public idw.idwws.OmTppt getOmTpptRefugo() {
        return omTpptRefugo;
    }


    /**
     * Sets the omTpptRefugo value for this FiltroRelatorioRefugoDTO.
     * 
     * @param omTpptRefugo
     */
    public void setOmTpptRefugo(idw.idwws.OmTppt omTpptRefugo) {
        this.omTpptRefugo = omTpptRefugo;
    }


    /**
     * Gets the ordenarRefugo value for this FiltroRelatorioRefugoDTO.
     * 
     * @return ordenarRefugo
     */
    public boolean isOrdenarRefugo() {
        return ordenarRefugo;
    }


    /**
     * Sets the ordenarRefugo value for this FiltroRelatorioRefugoDTO.
     * 
     * @param ordenarRefugo
     */
    public void setOrdenarRefugo(boolean ordenarRefugo) {
        this.ordenarRefugo = ordenarRefugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroRelatorioRefugoDTO)) return false;
        FiltroRelatorioRefugoDTO other = (FiltroRelatorioRefugoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.omTpptRefugo==null && other.getOmTpptRefugo()==null) || 
             (this.omTpptRefugo!=null &&
              this.omTpptRefugo.equals(other.getOmTpptRefugo()))) &&
            this.ordenarRefugo == other.isOrdenarRefugo();
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
        if (getOmTpptRefugo() != null) {
            _hashCode += getOmTpptRefugo().hashCode();
        }
        _hashCode += (isOrdenarRefugo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroRelatorioRefugoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroRelatorioRefugoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTpptRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTpptRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordenarRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordenarRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
