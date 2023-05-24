/**
 * FiltroRelatorioParadaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroRelatorioParadaDTO  implements java.io.Serializable {
    private idw.idwws.OmTppt omTppt;

    private boolean ordenar;

    public FiltroRelatorioParadaDTO() {
    }

    public FiltroRelatorioParadaDTO(
           idw.idwws.OmTppt omTppt,
           boolean ordenar) {
           this.omTppt = omTppt;
           this.ordenar = ordenar;
    }


    /**
     * Gets the omTppt value for this FiltroRelatorioParadaDTO.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this FiltroRelatorioParadaDTO.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the ordenar value for this FiltroRelatorioParadaDTO.
     * 
     * @return ordenar
     */
    public boolean isOrdenar() {
        return ordenar;
    }


    /**
     * Sets the ordenar value for this FiltroRelatorioParadaDTO.
     * 
     * @param ordenar
     */
    public void setOrdenar(boolean ordenar) {
        this.ordenar = ordenar;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroRelatorioParadaDTO)) return false;
        FiltroRelatorioParadaDTO other = (FiltroRelatorioParadaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.omTppt==null && other.getOmTppt()==null) || 
             (this.omTppt!=null &&
              this.omTppt.equals(other.getOmTppt()))) &&
            this.ordenar == other.isOrdenar();
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
        if (getOmTppt() != null) {
            _hashCode += getOmTppt().hashCode();
        }
        _hashCode += (isOrdenar() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroRelatorioParadaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroRelatorioParadaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordenar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordenar"));
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
