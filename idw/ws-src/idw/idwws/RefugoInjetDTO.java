/**
 * RefugoInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class RefugoInjetDTO  extends idw.idwws.RefugoTempoInjetDTO  implements java.io.Serializable {
    private java.lang.String cdRefugo;

    private java.lang.String dsRefugo;

    public RefugoInjetDTO() {
    }

    public RefugoInjetDTO(
           java.math.BigDecimal producaoRefugada,
           java.math.BigDecimal producaoRefugadaCusto,
           java.math.BigDecimal producaoRefugadaKg,
           java.math.BigDecimal qtCiclosRefugados,
           java.math.BigDecimal tempoRefugo,
           java.lang.String cdRefugo,
           java.lang.String dsRefugo) {
        super(
            producaoRefugada,
            producaoRefugadaCusto,
            producaoRefugadaKg,
            qtCiclosRefugados,
            tempoRefugo);
        this.cdRefugo = cdRefugo;
        this.dsRefugo = dsRefugo;
    }


    /**
     * Gets the cdRefugo value for this RefugoInjetDTO.
     * 
     * @return cdRefugo
     */
    public java.lang.String getCdRefugo() {
        return cdRefugo;
    }


    /**
     * Sets the cdRefugo value for this RefugoInjetDTO.
     * 
     * @param cdRefugo
     */
    public void setCdRefugo(java.lang.String cdRefugo) {
        this.cdRefugo = cdRefugo;
    }


    /**
     * Gets the dsRefugo value for this RefugoInjetDTO.
     * 
     * @return dsRefugo
     */
    public java.lang.String getDsRefugo() {
        return dsRefugo;
    }


    /**
     * Sets the dsRefugo value for this RefugoInjetDTO.
     * 
     * @param dsRefugo
     */
    public void setDsRefugo(java.lang.String dsRefugo) {
        this.dsRefugo = dsRefugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RefugoInjetDTO)) return false;
        RefugoInjetDTO other = (RefugoInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdRefugo==null && other.getCdRefugo()==null) || 
             (this.cdRefugo!=null &&
              this.cdRefugo.equals(other.getCdRefugo()))) &&
            ((this.dsRefugo==null && other.getDsRefugo()==null) || 
             (this.dsRefugo!=null &&
              this.dsRefugo.equals(other.getDsRefugo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCdRefugo() != null) {
            _hashCode += getCdRefugo().hashCode();
        }
        if (getDsRefugo() != null) {
            _hashCode += getDsRefugo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RefugoInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "refugoInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
