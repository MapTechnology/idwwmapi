/**
 * IjtbidgrafId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbidgrafId  implements java.io.Serializable {
    private java.lang.String cdmodulo;

    private java.lang.String nmform;

    private java.lang.String nmformorigem;

    public IjtbidgrafId() {
    }

    public IjtbidgrafId(
           java.lang.String cdmodulo,
           java.lang.String nmform,
           java.lang.String nmformorigem) {
           this.cdmodulo = cdmodulo;
           this.nmform = nmform;
           this.nmformorigem = nmformorigem;
    }


    /**
     * Gets the cdmodulo value for this IjtbidgrafId.
     * 
     * @return cdmodulo
     */
    public java.lang.String getCdmodulo() {
        return cdmodulo;
    }


    /**
     * Sets the cdmodulo value for this IjtbidgrafId.
     * 
     * @param cdmodulo
     */
    public void setCdmodulo(java.lang.String cdmodulo) {
        this.cdmodulo = cdmodulo;
    }


    /**
     * Gets the nmform value for this IjtbidgrafId.
     * 
     * @return nmform
     */
    public java.lang.String getNmform() {
        return nmform;
    }


    /**
     * Sets the nmform value for this IjtbidgrafId.
     * 
     * @param nmform
     */
    public void setNmform(java.lang.String nmform) {
        this.nmform = nmform;
    }


    /**
     * Gets the nmformorigem value for this IjtbidgrafId.
     * 
     * @return nmformorigem
     */
    public java.lang.String getNmformorigem() {
        return nmformorigem;
    }


    /**
     * Sets the nmformorigem value for this IjtbidgrafId.
     * 
     * @param nmformorigem
     */
    public void setNmformorigem(java.lang.String nmformorigem) {
        this.nmformorigem = nmformorigem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbidgrafId)) return false;
        IjtbidgrafId other = (IjtbidgrafId) obj;
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
            ((this.nmformorigem==null && other.getNmformorigem()==null) || 
             (this.nmformorigem!=null &&
              this.nmformorigem.equals(other.getNmformorigem())));
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
        if (getNmformorigem() != null) {
            _hashCode += getNmformorigem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbidgrafId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidgrafId"));
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
        elemField.setFieldName("nmformorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmformorigem"));
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
