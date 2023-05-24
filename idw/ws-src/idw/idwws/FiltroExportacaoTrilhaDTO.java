/**
 * FiltroExportacaoTrilhaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroExportacaoTrilhaDTO  implements java.io.Serializable {
    private idw.idwws.PpPlano plano;

    public FiltroExportacaoTrilhaDTO() {
    }

    public FiltroExportacaoTrilhaDTO(
           idw.idwws.PpPlano plano) {
           this.plano = plano;
    }


    /**
     * Gets the plano value for this FiltroExportacaoTrilhaDTO.
     * 
     * @return plano
     */
    public idw.idwws.PpPlano getPlano() {
        return plano;
    }


    /**
     * Sets the plano value for this FiltroExportacaoTrilhaDTO.
     * 
     * @param plano
     */
    public void setPlano(idw.idwws.PpPlano plano) {
        this.plano = plano;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroExportacaoTrilhaDTO)) return false;
        FiltroExportacaoTrilhaDTO other = (FiltroExportacaoTrilhaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.plano==null && other.getPlano()==null) || 
             (this.plano!=null &&
              this.plano.equals(other.getPlano())));
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
        if (getPlano() != null) {
            _hashCode += getPlano().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroExportacaoTrilhaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroExportacaoTrilhaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlano"));
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
