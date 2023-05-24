/**
 * IjtbidrptId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbidrptId  implements java.io.Serializable {
    private java.lang.String cdmodulo;

    private java.lang.String nmform;

    private java.lang.String nmmenurpt;

    public IjtbidrptId() {
    }

    public IjtbidrptId(
           java.lang.String cdmodulo,
           java.lang.String nmform,
           java.lang.String nmmenurpt) {
           this.cdmodulo = cdmodulo;
           this.nmform = nmform;
           this.nmmenurpt = nmmenurpt;
    }


    /**
     * Gets the cdmodulo value for this IjtbidrptId.
     * 
     * @return cdmodulo
     */
    public java.lang.String getCdmodulo() {
        return cdmodulo;
    }


    /**
     * Sets the cdmodulo value for this IjtbidrptId.
     * 
     * @param cdmodulo
     */
    public void setCdmodulo(java.lang.String cdmodulo) {
        this.cdmodulo = cdmodulo;
    }


    /**
     * Gets the nmform value for this IjtbidrptId.
     * 
     * @return nmform
     */
    public java.lang.String getNmform() {
        return nmform;
    }


    /**
     * Sets the nmform value for this IjtbidrptId.
     * 
     * @param nmform
     */
    public void setNmform(java.lang.String nmform) {
        this.nmform = nmform;
    }


    /**
     * Gets the nmmenurpt value for this IjtbidrptId.
     * 
     * @return nmmenurpt
     */
    public java.lang.String getNmmenurpt() {
        return nmmenurpt;
    }


    /**
     * Sets the nmmenurpt value for this IjtbidrptId.
     * 
     * @param nmmenurpt
     */
    public void setNmmenurpt(java.lang.String nmmenurpt) {
        this.nmmenurpt = nmmenurpt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbidrptId)) return false;
        IjtbidrptId other = (IjtbidrptId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmodulo==null && other.getCdmodulo()==null) || 
             (this.cdmodulo!=null &&
              this.cdmodulo.equals(other.getCdmodulo()))) &&
            ((this.nmform==null && other.getNmform()==null) || 
             (this.nmform!=null &&
              this.nmform.equals(other.getNmform()))) &&
            ((this.nmmenurpt==null && other.getNmmenurpt()==null) || 
             (this.nmmenurpt!=null &&
              this.nmmenurpt.equals(other.getNmmenurpt())));
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
        if (getCdmodulo() != null) {
            _hashCode += getCdmodulo().hashCode();
        }
        if (getNmform() != null) {
            _hashCode += getNmform().hashCode();
        }
        if (getNmmenurpt() != null) {
            _hashCode += getNmmenurpt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbidrptId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidrptId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmodulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmodulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmform");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmform"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmmenurpt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmmenurpt"));
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
