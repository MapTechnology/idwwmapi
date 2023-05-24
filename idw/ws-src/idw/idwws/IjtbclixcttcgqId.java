/**
 * IjtbclixcttcgqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbclixcttcgqId  implements java.io.Serializable {
    private java.lang.String cdcliente;

    private java.lang.String emailctt;

    private java.lang.String planta;

    public IjtbclixcttcgqId() {
    }

    public IjtbclixcttcgqId(
           java.lang.String cdcliente,
           java.lang.String emailctt,
           java.lang.String planta) {
           this.cdcliente = cdcliente;
           this.emailctt = emailctt;
           this.planta = planta;
    }


    /**
     * Gets the cdcliente value for this IjtbclixcttcgqId.
     * 
     * @return cdcliente
     */
    public java.lang.String getCdcliente() {
        return cdcliente;
    }


    /**
     * Sets the cdcliente value for this IjtbclixcttcgqId.
     * 
     * @param cdcliente
     */
    public void setCdcliente(java.lang.String cdcliente) {
        this.cdcliente = cdcliente;
    }


    /**
     * Gets the emailctt value for this IjtbclixcttcgqId.
     * 
     * @return emailctt
     */
    public java.lang.String getEmailctt() {
        return emailctt;
    }


    /**
     * Sets the emailctt value for this IjtbclixcttcgqId.
     * 
     * @param emailctt
     */
    public void setEmailctt(java.lang.String emailctt) {
        this.emailctt = emailctt;
    }


    /**
     * Gets the planta value for this IjtbclixcttcgqId.
     * 
     * @return planta
     */
    public java.lang.String getPlanta() {
        return planta;
    }


    /**
     * Sets the planta value for this IjtbclixcttcgqId.
     * 
     * @param planta
     */
    public void setPlanta(java.lang.String planta) {
        this.planta = planta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbclixcttcgqId)) return false;
        IjtbclixcttcgqId other = (IjtbclixcttcgqId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcliente==null && other.getCdcliente()==null) || 
             (this.cdcliente!=null &&
              this.cdcliente.equals(other.getCdcliente()))) &&
            ((this.emailctt==null && other.getEmailctt()==null) || 
             (this.emailctt!=null &&
              this.emailctt.equals(other.getEmailctt()))) &&
            ((this.planta==null && other.getPlanta()==null) || 
             (this.planta!=null &&
              this.planta.equals(other.getPlanta())));
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
        if (getCdcliente() != null) {
            _hashCode += getCdcliente().hashCode();
        }
        if (getEmailctt() != null) {
            _hashCode += getEmailctt().hashCode();
        }
        if (getPlanta() != null) {
            _hashCode += getPlanta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbclixcttcgqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixcttcgqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailctt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailctt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planta"));
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
