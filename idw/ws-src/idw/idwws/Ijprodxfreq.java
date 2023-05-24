/**
 * Ijprodxfreq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijprodxfreq  implements java.io.Serializable {
    private idw.idwws.IjprodxfreqId id;

    private idw.idwws.Ijprodinspfreq ijprodinspfreq;

    public Ijprodxfreq() {
    }

    public Ijprodxfreq(
           idw.idwws.IjprodxfreqId id,
           idw.idwws.Ijprodinspfreq ijprodinspfreq) {
           this.id = id;
           this.ijprodinspfreq = ijprodinspfreq;
    }


    /**
     * Gets the id value for this Ijprodxfreq.
     * 
     * @return id
     */
    public idw.idwws.IjprodxfreqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijprodxfreq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjprodxfreqId id) {
        this.id = id;
    }


    /**
     * Gets the ijprodinspfreq value for this Ijprodxfreq.
     * 
     * @return ijprodinspfreq
     */
    public idw.idwws.Ijprodinspfreq getIjprodinspfreq() {
        return ijprodinspfreq;
    }


    /**
     * Sets the ijprodinspfreq value for this Ijprodxfreq.
     * 
     * @param ijprodinspfreq
     */
    public void setIjprodinspfreq(idw.idwws.Ijprodinspfreq ijprodinspfreq) {
        this.ijprodinspfreq = ijprodinspfreq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijprodxfreq)) return false;
        Ijprodxfreq other = (Ijprodxfreq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijprodinspfreq==null && other.getIjprodinspfreq()==null) || 
             (this.ijprodinspfreq!=null &&
              this.ijprodinspfreq.equals(other.getIjprodinspfreq())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjprodinspfreq() != null) {
            _hashCode += getIjprodinspfreq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijprodxfreq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxfreq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxfreqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprodinspfreq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprodinspfreq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodinspfreq"));
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
