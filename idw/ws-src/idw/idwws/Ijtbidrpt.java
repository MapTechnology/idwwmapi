/**
 * Ijtbidrpt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbidrpt  implements java.io.Serializable {
    private java.lang.String cdrpt;

    private idw.idwws.IjtbidrptId id;

    private idw.idwws.Ijtbmodulos ijtbmodulos;

    public Ijtbidrpt() {
    }

    public Ijtbidrpt(
           java.lang.String cdrpt,
           idw.idwws.IjtbidrptId id,
           idw.idwws.Ijtbmodulos ijtbmodulos) {
           this.cdrpt = cdrpt;
           this.id = id;
           this.ijtbmodulos = ijtbmodulos;
    }


    /**
     * Gets the cdrpt value for this Ijtbidrpt.
     * 
     * @return cdrpt
     */
    public java.lang.String getCdrpt() {
        return cdrpt;
    }


    /**
     * Sets the cdrpt value for this Ijtbidrpt.
     * 
     * @param cdrpt
     */
    public void setCdrpt(java.lang.String cdrpt) {
        this.cdrpt = cdrpt;
    }


    /**
     * Gets the id value for this Ijtbidrpt.
     * 
     * @return id
     */
    public idw.idwws.IjtbidrptId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbidrpt.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbidrptId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbmodulos value for this Ijtbidrpt.
     * 
     * @return ijtbmodulos
     */
    public idw.idwws.Ijtbmodulos getIjtbmodulos() {
        return ijtbmodulos;
    }


    /**
     * Sets the ijtbmodulos value for this Ijtbidrpt.
     * 
     * @param ijtbmodulos
     */
    public void setIjtbmodulos(idw.idwws.Ijtbmodulos ijtbmodulos) {
        this.ijtbmodulos = ijtbmodulos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbidrpt)) return false;
        Ijtbidrpt other = (Ijtbidrpt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdrpt==null && other.getCdrpt()==null) || 
             (this.cdrpt!=null &&
              this.cdrpt.equals(other.getCdrpt()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbmodulos==null && other.getIjtbmodulos()==null) || 
             (this.ijtbmodulos!=null &&
              this.ijtbmodulos.equals(other.getIjtbmodulos())));
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
        if (getCdrpt() != null) {
            _hashCode += getCdrpt().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbmodulos() != null) {
            _hashCode += getIjtbmodulos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbidrpt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidrpt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrpt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdrpt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidrptId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmodulos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmodulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodulos"));
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
