/**
 * IjhorturId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjhorturId  implements java.io.Serializable {
    private java.lang.String cdagenda;

    private java.lang.String cddiasem;

    private java.lang.String cdturno;

    public IjhorturId() {
    }

    public IjhorturId(
           java.lang.String cdagenda,
           java.lang.String cddiasem,
           java.lang.String cdturno) {
           this.cdagenda = cdagenda;
           this.cddiasem = cddiasem;
           this.cdturno = cdturno;
    }


    /**
     * Gets the cdagenda value for this IjhorturId.
     * 
     * @return cdagenda
     */
    public java.lang.String getCdagenda() {
        return cdagenda;
    }


    /**
     * Sets the cdagenda value for this IjhorturId.
     * 
     * @param cdagenda
     */
    public void setCdagenda(java.lang.String cdagenda) {
        this.cdagenda = cdagenda;
    }


    /**
     * Gets the cddiasem value for this IjhorturId.
     * 
     * @return cddiasem
     */
    public java.lang.String getCddiasem() {
        return cddiasem;
    }


    /**
     * Sets the cddiasem value for this IjhorturId.
     * 
     * @param cddiasem
     */
    public void setCddiasem(java.lang.String cddiasem) {
        this.cddiasem = cddiasem;
    }


    /**
     * Gets the cdturno value for this IjhorturId.
     * 
     * @return cdturno
     */
    public java.lang.String getCdturno() {
        return cdturno;
    }


    /**
     * Sets the cdturno value for this IjhorturId.
     * 
     * @param cdturno
     */
    public void setCdturno(java.lang.String cdturno) {
        this.cdturno = cdturno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjhorturId)) return false;
        IjhorturId other = (IjhorturId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdagenda==null && other.getCdagenda()==null) || 
             (this.cdagenda!=null &&
              this.cdagenda.equals(other.getCdagenda()))) &&
            ((this.cddiasem==null && other.getCddiasem()==null) || 
             (this.cddiasem!=null &&
              this.cddiasem.equals(other.getCddiasem()))) &&
            ((this.cdturno==null && other.getCdturno()==null) || 
             (this.cdturno!=null &&
              this.cdturno.equals(other.getCdturno())));
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
        if (getCdagenda() != null) {
            _hashCode += getCdagenda().hashCode();
        }
        if (getCddiasem() != null) {
            _hashCode += getCddiasem().hashCode();
        }
        if (getCdturno() != null) {
            _hashCode += getCdturno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjhorturId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhorturId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdagenda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdagenda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cddiasem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cddiasem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturno"));
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
