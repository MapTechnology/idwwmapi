/**
 * IjhorexcId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjhorexcId  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cdtphor;

    private java.util.Calendar dthriexchor;

    public IjhorexcId() {
    }

    public IjhorexcId(
           java.lang.String cdinjetora,
           java.lang.String cdtphor,
           java.util.Calendar dthriexchor) {
           this.cdinjetora = cdinjetora;
           this.cdtphor = cdtphor;
           this.dthriexchor = dthriexchor;
    }


    /**
     * Gets the cdinjetora value for this IjhorexcId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjhorexcId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdtphor value for this IjhorexcId.
     * 
     * @return cdtphor
     */
    public java.lang.String getCdtphor() {
        return cdtphor;
    }


    /**
     * Sets the cdtphor value for this IjhorexcId.
     * 
     * @param cdtphor
     */
    public void setCdtphor(java.lang.String cdtphor) {
        this.cdtphor = cdtphor;
    }


    /**
     * Gets the dthriexchor value for this IjhorexcId.
     * 
     * @return dthriexchor
     */
    public java.util.Calendar getDthriexchor() {
        return dthriexchor;
    }


    /**
     * Sets the dthriexchor value for this IjhorexcId.
     * 
     * @param dthriexchor
     */
    public void setDthriexchor(java.util.Calendar dthriexchor) {
        this.dthriexchor = dthriexchor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjhorexcId)) return false;
        IjhorexcId other = (IjhorexcId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdtphor==null && other.getCdtphor()==null) || 
             (this.cdtphor!=null &&
              this.cdtphor.equals(other.getCdtphor()))) &&
            ((this.dthriexchor==null && other.getDthriexchor()==null) || 
             (this.dthriexchor!=null &&
              this.dthriexchor.equals(other.getDthriexchor())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdtphor() != null) {
            _hashCode += getCdtphor().hashCode();
        }
        if (getDthriexchor() != null) {
            _hashCode += getDthriexchor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjhorexcId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhorexcId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtphor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtphor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriexchor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriexchor"));
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
