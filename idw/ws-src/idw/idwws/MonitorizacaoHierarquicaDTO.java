/**
 * MonitorizacaoHierarquicaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MonitorizacaoHierarquicaDTO  implements java.io.Serializable {
    private idw.idwws.IndicadorValorMinMetaMaxDTO[] indicadorValorMinMetaMaxDTOs;

    private idw.idwws.MonitorizacaoHierarquicaDTO[] monitorizacaoHierarquicaDTOs;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmObj omObj;

    public MonitorizacaoHierarquicaDTO() {
    }

    public MonitorizacaoHierarquicaDTO(
           idw.idwws.IndicadorValorMinMetaMaxDTO[] indicadorValorMinMetaMaxDTOs,
           idw.idwws.MonitorizacaoHierarquicaDTO[] monitorizacaoHierarquicaDTOs,
           idw.idwws.OmGt omGt,
           idw.idwws.OmObj omObj) {
           this.indicadorValorMinMetaMaxDTOs = indicadorValorMinMetaMaxDTOs;
           this.monitorizacaoHierarquicaDTOs = monitorizacaoHierarquicaDTOs;
           this.omGt = omGt;
           this.omObj = omObj;
    }


    /**
     * Gets the indicadorValorMinMetaMaxDTOs value for this MonitorizacaoHierarquicaDTO.
     * 
     * @return indicadorValorMinMetaMaxDTOs
     */
    public idw.idwws.IndicadorValorMinMetaMaxDTO[] getIndicadorValorMinMetaMaxDTOs() {
        return indicadorValorMinMetaMaxDTOs;
    }


    /**
     * Sets the indicadorValorMinMetaMaxDTOs value for this MonitorizacaoHierarquicaDTO.
     * 
     * @param indicadorValorMinMetaMaxDTOs
     */
    public void setIndicadorValorMinMetaMaxDTOs(idw.idwws.IndicadorValorMinMetaMaxDTO[] indicadorValorMinMetaMaxDTOs) {
        this.indicadorValorMinMetaMaxDTOs = indicadorValorMinMetaMaxDTOs;
    }

    public idw.idwws.IndicadorValorMinMetaMaxDTO getIndicadorValorMinMetaMaxDTOs(int i) {
        return this.indicadorValorMinMetaMaxDTOs[i];
    }

    public void setIndicadorValorMinMetaMaxDTOs(int i, idw.idwws.IndicadorValorMinMetaMaxDTO _value) {
        this.indicadorValorMinMetaMaxDTOs[i] = _value;
    }


    /**
     * Gets the monitorizacaoHierarquicaDTOs value for this MonitorizacaoHierarquicaDTO.
     * 
     * @return monitorizacaoHierarquicaDTOs
     */
    public idw.idwws.MonitorizacaoHierarquicaDTO[] getMonitorizacaoHierarquicaDTOs() {
        return monitorizacaoHierarquicaDTOs;
    }


    /**
     * Sets the monitorizacaoHierarquicaDTOs value for this MonitorizacaoHierarquicaDTO.
     * 
     * @param monitorizacaoHierarquicaDTOs
     */
    public void setMonitorizacaoHierarquicaDTOs(idw.idwws.MonitorizacaoHierarquicaDTO[] monitorizacaoHierarquicaDTOs) {
        this.monitorizacaoHierarquicaDTOs = monitorizacaoHierarquicaDTOs;
    }

    public idw.idwws.MonitorizacaoHierarquicaDTO getMonitorizacaoHierarquicaDTOs(int i) {
        return this.monitorizacaoHierarquicaDTOs[i];
    }

    public void setMonitorizacaoHierarquicaDTOs(int i, idw.idwws.MonitorizacaoHierarquicaDTO _value) {
        this.monitorizacaoHierarquicaDTOs[i] = _value;
    }


    /**
     * Gets the omGt value for this MonitorizacaoHierarquicaDTO.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this MonitorizacaoHierarquicaDTO.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omObj value for this MonitorizacaoHierarquicaDTO.
     * 
     * @return omObj
     */
    public idw.idwws.OmObj getOmObj() {
        return omObj;
    }


    /**
     * Sets the omObj value for this MonitorizacaoHierarquicaDTO.
     * 
     * @param omObj
     */
    public void setOmObj(idw.idwws.OmObj omObj) {
        this.omObj = omObj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MonitorizacaoHierarquicaDTO)) return false;
        MonitorizacaoHierarquicaDTO other = (MonitorizacaoHierarquicaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indicadorValorMinMetaMaxDTOs==null && other.getIndicadorValorMinMetaMaxDTOs()==null) || 
             (this.indicadorValorMinMetaMaxDTOs!=null &&
              java.util.Arrays.equals(this.indicadorValorMinMetaMaxDTOs, other.getIndicadorValorMinMetaMaxDTOs()))) &&
            ((this.monitorizacaoHierarquicaDTOs==null && other.getMonitorizacaoHierarquicaDTOs()==null) || 
             (this.monitorizacaoHierarquicaDTOs!=null &&
              java.util.Arrays.equals(this.monitorizacaoHierarquicaDTOs, other.getMonitorizacaoHierarquicaDTOs()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omObj==null && other.getOmObj()==null) || 
             (this.omObj!=null &&
              this.omObj.equals(other.getOmObj())));
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
        if (getIndicadorValorMinMetaMaxDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIndicadorValorMinMetaMaxDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIndicadorValorMinMetaMaxDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMonitorizacaoHierarquicaDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMonitorizacaoHierarquicaDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMonitorizacaoHierarquicaDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmObj() != null) {
            _hashCode += getOmObj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MonitorizacaoHierarquicaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "monitorizacaoHierarquicaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadorValorMinMetaMaxDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadorValorMinMetaMaxDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadorValorMinMetaMaxDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monitorizacaoHierarquicaDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monitorizacaoHierarquicaDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "monitorizacaoHierarquicaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
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
