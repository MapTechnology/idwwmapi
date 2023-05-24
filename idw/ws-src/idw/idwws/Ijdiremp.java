/**
 * Ijdiremp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdiremp  implements java.io.Serializable {
    private idw.idwws.IjdirempId id;

    private idw.idwws.Ijtbopcmenu ijtbopcmenu;

    public Ijdiremp() {
    }

    public Ijdiremp(
           idw.idwws.IjdirempId id,
           idw.idwws.Ijtbopcmenu ijtbopcmenu) {
           this.id = id;
           this.ijtbopcmenu = ijtbopcmenu;
    }


    /**
     * Gets the id value for this Ijdiremp.
     * 
     * @return id
     */
    public idw.idwws.IjdirempId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijdiremp.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjdirempId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbopcmenu value for this Ijdiremp.
     * 
     * @return ijtbopcmenu
     */
    public idw.idwws.Ijtbopcmenu getIjtbopcmenu() {
        return ijtbopcmenu;
    }


    /**
     * Sets the ijtbopcmenu value for this Ijdiremp.
     * 
     * @param ijtbopcmenu
     */
    public void setIjtbopcmenu(idw.idwws.Ijtbopcmenu ijtbopcmenu) {
        this.ijtbopcmenu = ijtbopcmenu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdiremp)) return false;
        Ijdiremp other = (Ijdiremp) obj;
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
            ((this.ijtbopcmenu==null && other.getIjtbopcmenu()==null) || 
             (this.ijtbopcmenu!=null &&
              this.ijtbopcmenu.equals(other.getIjtbopcmenu())));
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
        if (getIjtbopcmenu() != null) {
            _hashCode += getIjtbopcmenu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijdiremp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdiremp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdirempId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbopcmenu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbopcmenu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbopcmenu"));
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
