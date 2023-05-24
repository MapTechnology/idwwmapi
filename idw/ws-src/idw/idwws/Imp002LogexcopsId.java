/**
 * Imp002LogexcopsId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Imp002LogexcopsId  implements java.io.Serializable {
    private java.lang.String cdusuario;

    private java.util.Calendar dthrexclusao;

    private java.math.BigDecimal excdadosprod;

    private java.lang.String nrop;

    public Imp002LogexcopsId() {
    }

    public Imp002LogexcopsId(
           java.lang.String cdusuario,
           java.util.Calendar dthrexclusao,
           java.math.BigDecimal excdadosprod,
           java.lang.String nrop) {
           this.cdusuario = cdusuario;
           this.dthrexclusao = dthrexclusao;
           this.excdadosprod = excdadosprod;
           this.nrop = nrop;
    }


    /**
     * Gets the cdusuario value for this Imp002LogexcopsId.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this Imp002LogexcopsId.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the dthrexclusao value for this Imp002LogexcopsId.
     * 
     * @return dthrexclusao
     */
    public java.util.Calendar getDthrexclusao() {
        return dthrexclusao;
    }


    /**
     * Sets the dthrexclusao value for this Imp002LogexcopsId.
     * 
     * @param dthrexclusao
     */
    public void setDthrexclusao(java.util.Calendar dthrexclusao) {
        this.dthrexclusao = dthrexclusao;
    }


    /**
     * Gets the excdadosprod value for this Imp002LogexcopsId.
     * 
     * @return excdadosprod
     */
    public java.math.BigDecimal getExcdadosprod() {
        return excdadosprod;
    }


    /**
     * Sets the excdadosprod value for this Imp002LogexcopsId.
     * 
     * @param excdadosprod
     */
    public void setExcdadosprod(java.math.BigDecimal excdadosprod) {
        this.excdadosprod = excdadosprod;
    }


    /**
     * Gets the nrop value for this Imp002LogexcopsId.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Imp002LogexcopsId.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Imp002LogexcopsId)) return false;
        Imp002LogexcopsId other = (Imp002LogexcopsId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.dthrexclusao==null && other.getDthrexclusao()==null) || 
             (this.dthrexclusao!=null &&
              this.dthrexclusao.equals(other.getDthrexclusao()))) &&
            ((this.excdadosprod==null && other.getExcdadosprod()==null) || 
             (this.excdadosprod!=null &&
              this.excdadosprod.equals(other.getExcdadosprod()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop())));
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
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getDthrexclusao() != null) {
            _hashCode += getDthrexclusao().hashCode();
        }
        if (getExcdadosprod() != null) {
            _hashCode += getExcdadosprod().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Imp002LogexcopsId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "imp002LogexcopsId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrexclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrexclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excdadosprod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "excdadosprod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
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
