/**
 * IndicadorValorMinMetaMaxDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IndicadorValorMinMetaMaxDTO  implements java.io.Serializable {
    private boolean abaixoMeta;

    private boolean abaixoMinimo;

    private boolean acimaMeta;

    private idw.idwws.IndicadorMinMetaMaxDTO indicadorMinMetaMaxDTO;

    private idw.idwws.IndicadorValorDTO indicadorValorDTO;

    public IndicadorValorMinMetaMaxDTO() {
    }

    public IndicadorValorMinMetaMaxDTO(
           boolean abaixoMeta,
           boolean abaixoMinimo,
           boolean acimaMeta,
           idw.idwws.IndicadorMinMetaMaxDTO indicadorMinMetaMaxDTO,
           idw.idwws.IndicadorValorDTO indicadorValorDTO) {
           this.abaixoMeta = abaixoMeta;
           this.abaixoMinimo = abaixoMinimo;
           this.acimaMeta = acimaMeta;
           this.indicadorMinMetaMaxDTO = indicadorMinMetaMaxDTO;
           this.indicadorValorDTO = indicadorValorDTO;
    }


    /**
     * Gets the abaixoMeta value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @return abaixoMeta
     */
    public boolean isAbaixoMeta() {
        return abaixoMeta;
    }


    /**
     * Sets the abaixoMeta value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @param abaixoMeta
     */
    public void setAbaixoMeta(boolean abaixoMeta) {
        this.abaixoMeta = abaixoMeta;
    }


    /**
     * Gets the abaixoMinimo value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @return abaixoMinimo
     */
    public boolean isAbaixoMinimo() {
        return abaixoMinimo;
    }


    /**
     * Sets the abaixoMinimo value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @param abaixoMinimo
     */
    public void setAbaixoMinimo(boolean abaixoMinimo) {
        this.abaixoMinimo = abaixoMinimo;
    }


    /**
     * Gets the acimaMeta value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @return acimaMeta
     */
    public boolean isAcimaMeta() {
        return acimaMeta;
    }


    /**
     * Sets the acimaMeta value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @param acimaMeta
     */
    public void setAcimaMeta(boolean acimaMeta) {
        this.acimaMeta = acimaMeta;
    }


    /**
     * Gets the indicadorMinMetaMaxDTO value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @return indicadorMinMetaMaxDTO
     */
    public idw.idwws.IndicadorMinMetaMaxDTO getIndicadorMinMetaMaxDTO() {
        return indicadorMinMetaMaxDTO;
    }


    /**
     * Sets the indicadorMinMetaMaxDTO value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @param indicadorMinMetaMaxDTO
     */
    public void setIndicadorMinMetaMaxDTO(idw.idwws.IndicadorMinMetaMaxDTO indicadorMinMetaMaxDTO) {
        this.indicadorMinMetaMaxDTO = indicadorMinMetaMaxDTO;
    }


    /**
     * Gets the indicadorValorDTO value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @return indicadorValorDTO
     */
    public idw.idwws.IndicadorValorDTO getIndicadorValorDTO() {
        return indicadorValorDTO;
    }


    /**
     * Sets the indicadorValorDTO value for this IndicadorValorMinMetaMaxDTO.
     * 
     * @param indicadorValorDTO
     */
    public void setIndicadorValorDTO(idw.idwws.IndicadorValorDTO indicadorValorDTO) {
        this.indicadorValorDTO = indicadorValorDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndicadorValorMinMetaMaxDTO)) return false;
        IndicadorValorMinMetaMaxDTO other = (IndicadorValorMinMetaMaxDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.abaixoMeta == other.isAbaixoMeta() &&
            this.abaixoMinimo == other.isAbaixoMinimo() &&
            this.acimaMeta == other.isAcimaMeta() &&
            ((this.indicadorMinMetaMaxDTO==null && other.getIndicadorMinMetaMaxDTO()==null) || 
             (this.indicadorMinMetaMaxDTO!=null &&
              this.indicadorMinMetaMaxDTO.equals(other.getIndicadorMinMetaMaxDTO()))) &&
            ((this.indicadorValorDTO==null && other.getIndicadorValorDTO()==null) || 
             (this.indicadorValorDTO!=null &&
              this.indicadorValorDTO.equals(other.getIndicadorValorDTO())));
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
        _hashCode += (isAbaixoMeta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAbaixoMinimo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAcimaMeta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIndicadorMinMetaMaxDTO() != null) {
            _hashCode += getIndicadorMinMetaMaxDTO().hashCode();
        }
        if (getIndicadorValorDTO() != null) {
            _hashCode += getIndicadorValorDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndicadorValorMinMetaMaxDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadorValorMinMetaMaxDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abaixoMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "abaixoMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abaixoMinimo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "abaixoMinimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acimaMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acimaMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadorMinMetaMaxDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadorMinMetaMaxDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadorMinMetaMaxDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadorValorDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadorValorDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadorValorDTO"));
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
