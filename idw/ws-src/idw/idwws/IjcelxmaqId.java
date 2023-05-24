/**
 * IjcelxmaqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjcelxmaqId  implements java.io.Serializable {
    private java.lang.String cdcelula;

    private java.lang.String cdinjetora;

    private java.lang.String cdmaqdestino;

    private java.math.BigDecimal estagio;

    public IjcelxmaqId() {
    }

    public IjcelxmaqId(
           java.lang.String cdcelula,
           java.lang.String cdinjetora,
           java.lang.String cdmaqdestino,
           java.math.BigDecimal estagio) {
           this.cdcelula = cdcelula;
           this.cdinjetora = cdinjetora;
           this.cdmaqdestino = cdmaqdestino;
           this.estagio = estagio;
    }


    /**
     * Gets the cdcelula value for this IjcelxmaqId.
     * 
     * @return cdcelula
     */
    public java.lang.String getCdcelula() {
        return cdcelula;
    }


    /**
     * Sets the cdcelula value for this IjcelxmaqId.
     * 
     * @param cdcelula
     */
    public void setCdcelula(java.lang.String cdcelula) {
        this.cdcelula = cdcelula;
    }


    /**
     * Gets the cdinjetora value for this IjcelxmaqId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjcelxmaqId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdmaqdestino value for this IjcelxmaqId.
     * 
     * @return cdmaqdestino
     */
    public java.lang.String getCdmaqdestino() {
        return cdmaqdestino;
    }


    /**
     * Sets the cdmaqdestino value for this IjcelxmaqId.
     * 
     * @param cdmaqdestino
     */
    public void setCdmaqdestino(java.lang.String cdmaqdestino) {
        this.cdmaqdestino = cdmaqdestino;
    }


    /**
     * Gets the estagio value for this IjcelxmaqId.
     * 
     * @return estagio
     */
    public java.math.BigDecimal getEstagio() {
        return estagio;
    }


    /**
     * Sets the estagio value for this IjcelxmaqId.
     * 
     * @param estagio
     */
    public void setEstagio(java.math.BigDecimal estagio) {
        this.estagio = estagio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjcelxmaqId)) return false;
        IjcelxmaqId other = (IjcelxmaqId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcelula==null && other.getCdcelula()==null) || 
             (this.cdcelula!=null &&
              this.cdcelula.equals(other.getCdcelula()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdmaqdestino==null && other.getCdmaqdestino()==null) || 
             (this.cdmaqdestino!=null &&
              this.cdmaqdestino.equals(other.getCdmaqdestino()))) &&
            ((this.estagio==null && other.getEstagio()==null) || 
             (this.estagio!=null &&
              this.estagio.equals(other.getEstagio())));
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
        if (getCdcelula() != null) {
            _hashCode += getCdcelula().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdmaqdestino() != null) {
            _hashCode += getCdmaqdestino().hashCode();
        }
        if (getEstagio() != null) {
            _hashCode += getEstagio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjcelxmaqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxmaqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmaqdestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmaqdestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estagio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estagio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
