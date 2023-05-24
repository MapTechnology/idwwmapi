/**
 * IjdirempId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjdirempId  implements java.io.Serializable {
    private java.lang.String cdopcao;

    private java.math.BigDecimal idempresa;

    public IjdirempId() {
    }

    public IjdirempId(
           java.lang.String cdopcao,
           java.math.BigDecimal idempresa) {
           this.cdopcao = cdopcao;
           this.idempresa = idempresa;
    }


    /**
     * Gets the cdopcao value for this IjdirempId.
     * 
     * @return cdopcao
     */
    public java.lang.String getCdopcao() {
        return cdopcao;
    }


    /**
     * Sets the cdopcao value for this IjdirempId.
     * 
     * @param cdopcao
     */
    public void setCdopcao(java.lang.String cdopcao) {
        this.cdopcao = cdopcao;
    }


    /**
     * Gets the idempresa value for this IjdirempId.
     * 
     * @return idempresa
     */
    public java.math.BigDecimal getIdempresa() {
        return idempresa;
    }


    /**
     * Sets the idempresa value for this IjdirempId.
     * 
     * @param idempresa
     */
    public void setIdempresa(java.math.BigDecimal idempresa) {
        this.idempresa = idempresa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjdirempId)) return false;
        IjdirempId other = (IjdirempId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdopcao==null && other.getCdopcao()==null) || 
             (this.cdopcao!=null &&
              this.cdopcao.equals(other.getCdopcao()))) &&
            ((this.idempresa==null && other.getIdempresa()==null) || 
             (this.idempresa!=null &&
              this.idempresa.equals(other.getIdempresa())));
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
        if (getCdopcao() != null) {
            _hashCode += getCdopcao().hashCode();
        }
        if (getIdempresa() != null) {
            _hashCode += getIdempresa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjdirempId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdirempId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdopcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idempresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idempresa"));
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
