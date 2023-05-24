/**
 * IjrearefId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjrearefId  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedShort cdidentificacao;

    private java.lang.String cdinjetora;

    private java.util.Calendar dthrirefugo;

    public IjrearefId() {
    }

    public IjrearefId(
           org.apache.axis.types.UnsignedShort cdidentificacao,
           java.lang.String cdinjetora,
           java.util.Calendar dthrirefugo) {
           this.cdidentificacao = cdidentificacao;
           this.cdinjetora = cdinjetora;
           this.dthrirefugo = dthrirefugo;
    }


    /**
     * Gets the cdidentificacao value for this IjrearefId.
     * 
     * @return cdidentificacao
     */
    public org.apache.axis.types.UnsignedShort getCdidentificacao() {
        return cdidentificacao;
    }


    /**
     * Sets the cdidentificacao value for this IjrearefId.
     * 
     * @param cdidentificacao
     */
    public void setCdidentificacao(org.apache.axis.types.UnsignedShort cdidentificacao) {
        this.cdidentificacao = cdidentificacao;
    }


    /**
     * Gets the cdinjetora value for this IjrearefId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjrearefId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the dthrirefugo value for this IjrearefId.
     * 
     * @return dthrirefugo
     */
    public java.util.Calendar getDthrirefugo() {
        return dthrirefugo;
    }


    /**
     * Sets the dthrirefugo value for this IjrearefId.
     * 
     * @param dthrirefugo
     */
    public void setDthrirefugo(java.util.Calendar dthrirefugo) {
        this.dthrirefugo = dthrirefugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjrearefId)) return false;
        IjrearefId other = (IjrearefId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdidentificacao==null && other.getCdidentificacao()==null) || 
             (this.cdidentificacao!=null &&
              this.cdidentificacao.equals(other.getCdidentificacao()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.dthrirefugo==null && other.getDthrirefugo()==null) || 
             (this.dthrirefugo!=null &&
              this.dthrirefugo.equals(other.getDthrirefugo())));
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
        if (getCdidentificacao() != null) {
            _hashCode += getCdidentificacao().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getDthrirefugo() != null) {
            _hashCode += getDthrirefugo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjrearefId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearefId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdidentificacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdidentificacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
        elemField.setFieldName("dthrirefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrirefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
