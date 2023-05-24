/**
 * IjtbusumailsmsId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbusumailsmsId  implements java.io.Serializable {
    private java.lang.String cdusumail;

    private java.math.BigDecimal idoperadora;

    private java.lang.String numtelcelular;

    public IjtbusumailsmsId() {
    }

    public IjtbusumailsmsId(
           java.lang.String cdusumail,
           java.math.BigDecimal idoperadora,
           java.lang.String numtelcelular) {
           this.cdusumail = cdusumail;
           this.idoperadora = idoperadora;
           this.numtelcelular = numtelcelular;
    }


    /**
     * Gets the cdusumail value for this IjtbusumailsmsId.
     * 
     * @return cdusumail
     */
    public java.lang.String getCdusumail() {
        return cdusumail;
    }


    /**
     * Sets the cdusumail value for this IjtbusumailsmsId.
     * 
     * @param cdusumail
     */
    public void setCdusumail(java.lang.String cdusumail) {
        this.cdusumail = cdusumail;
    }


    /**
     * Gets the idoperadora value for this IjtbusumailsmsId.
     * 
     * @return idoperadora
     */
    public java.math.BigDecimal getIdoperadora() {
        return idoperadora;
    }


    /**
     * Sets the idoperadora value for this IjtbusumailsmsId.
     * 
     * @param idoperadora
     */
    public void setIdoperadora(java.math.BigDecimal idoperadora) {
        this.idoperadora = idoperadora;
    }


    /**
     * Gets the numtelcelular value for this IjtbusumailsmsId.
     * 
     * @return numtelcelular
     */
    public java.lang.String getNumtelcelular() {
        return numtelcelular;
    }


    /**
     * Sets the numtelcelular value for this IjtbusumailsmsId.
     * 
     * @param numtelcelular
     */
    public void setNumtelcelular(java.lang.String numtelcelular) {
        this.numtelcelular = numtelcelular;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbusumailsmsId)) return false;
        IjtbusumailsmsId other = (IjtbusumailsmsId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdusumail==null && other.getCdusumail()==null) || 
             (this.cdusumail!=null &&
              this.cdusumail.equals(other.getCdusumail()))) &&
            ((this.idoperadora==null && other.getIdoperadora()==null) || 
             (this.idoperadora!=null &&
              this.idoperadora.equals(other.getIdoperadora()))) &&
            ((this.numtelcelular==null && other.getNumtelcelular()==null) || 
             (this.numtelcelular!=null &&
              this.numtelcelular.equals(other.getNumtelcelular())));
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
        if (getCdusumail() != null) {
            _hashCode += getCdusumail().hashCode();
        }
        if (getIdoperadora() != null) {
            _hashCode += getIdoperadora().hashCode();
        }
        if (getNumtelcelular() != null) {
            _hashCode += getNumtelcelular().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbusumailsmsId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumailsmsId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusumail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusumail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idoperadora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idoperadora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numtelcelular");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numtelcelular"));
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
