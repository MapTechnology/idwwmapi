/**
 * Ijprodxparamfreq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijprodxparamfreq  implements java.io.Serializable {
    private idw.idwws.IjprodxparamfreqId id;

    private idw.idwws.Ijprodxgrpparam ijprodxgrpparam;

    public Ijprodxparamfreq() {
    }

    public Ijprodxparamfreq(
           idw.idwws.IjprodxparamfreqId id,
           idw.idwws.Ijprodxgrpparam ijprodxgrpparam) {
           this.id = id;
           this.ijprodxgrpparam = ijprodxgrpparam;
    }


    /**
     * Gets the id value for this Ijprodxparamfreq.
     * 
     * @return id
     */
    public idw.idwws.IjprodxparamfreqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijprodxparamfreq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjprodxparamfreqId id) {
        this.id = id;
    }


    /**
     * Gets the ijprodxgrpparam value for this Ijprodxparamfreq.
     * 
     * @return ijprodxgrpparam
     */
    public idw.idwws.Ijprodxgrpparam getIjprodxgrpparam() {
        return ijprodxgrpparam;
    }


    /**
     * Sets the ijprodxgrpparam value for this Ijprodxparamfreq.
     * 
     * @param ijprodxgrpparam
     */
    public void setIjprodxgrpparam(idw.idwws.Ijprodxgrpparam ijprodxgrpparam) {
        this.ijprodxgrpparam = ijprodxgrpparam;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijprodxparamfreq)) return false;
        Ijprodxparamfreq other = (Ijprodxparamfreq) obj;
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
            ((this.ijprodxgrpparam==null && other.getIjprodxgrpparam()==null) || 
             (this.ijprodxgrpparam!=null &&
              this.ijprodxgrpparam.equals(other.getIjprodxgrpparam())));
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
        if (getIjprodxgrpparam() != null) {
            _hashCode += getIjprodxgrpparam().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijprodxparamfreq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxparamfreq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxparamfreqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprodxgrpparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprodxgrpparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxgrpparam"));
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
