/**
 * IjalertasId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjalertasId  implements java.io.Serializable {
    private java.lang.String cdalerta;

    private java.lang.String cdinjetora;

    private java.util.Calendar dthrialerta;

    public IjalertasId() {
    }

    public IjalertasId(
           java.lang.String cdalerta,
           java.lang.String cdinjetora,
           java.util.Calendar dthrialerta) {
           this.cdalerta = cdalerta;
           this.cdinjetora = cdinjetora;
           this.dthrialerta = dthrialerta;
    }


    /**
     * Gets the cdalerta value for this IjalertasId.
     * 
     * @return cdalerta
     */
    public java.lang.String getCdalerta() {
        return cdalerta;
    }


    /**
     * Sets the cdalerta value for this IjalertasId.
     * 
     * @param cdalerta
     */
    public void setCdalerta(java.lang.String cdalerta) {
        this.cdalerta = cdalerta;
    }


    /**
     * Gets the cdinjetora value for this IjalertasId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjalertasId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the dthrialerta value for this IjalertasId.
     * 
     * @return dthrialerta
     */
    public java.util.Calendar getDthrialerta() {
        return dthrialerta;
    }


    /**
     * Sets the dthrialerta value for this IjalertasId.
     * 
     * @param dthrialerta
     */
    public void setDthrialerta(java.util.Calendar dthrialerta) {
        this.dthrialerta = dthrialerta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjalertasId)) return false;
        IjalertasId other = (IjalertasId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdalerta==null && other.getCdalerta()==null) || 
             (this.cdalerta!=null &&
              this.cdalerta.equals(other.getCdalerta()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.dthrialerta==null && other.getDthrialerta()==null) || 
             (this.dthrialerta!=null &&
              this.dthrialerta.equals(other.getDthrialerta())));
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
        if (getCdalerta() != null) {
            _hashCode += getCdalerta().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getDthrialerta() != null) {
            _hashCode += getDthrialerta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjalertasId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertasId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdalerta"));
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
        elemField.setFieldName("dthrialerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrialerta"));
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
