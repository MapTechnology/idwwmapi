/**
 * Ijgruusu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgruusu  implements java.io.Serializable {
    private idw.idwws.IjgruusuId id;

    private idw.idwws.Ijtbgru ijtbgru;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijgruusu() {
    }

    public Ijgruusu(
           idw.idwws.IjgruusuId id,
           idw.idwws.Ijtbgru ijtbgru,
           idw.idwws.Ijtbusu ijtbusu) {
           this.id = id;
           this.ijtbgru = ijtbgru;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the id value for this Ijgruusu.
     * 
     * @return id
     */
    public idw.idwws.IjgruusuId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgruusu.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgruusuId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbgru value for this Ijgruusu.
     * 
     * @return ijtbgru
     */
    public idw.idwws.Ijtbgru getIjtbgru() {
        return ijtbgru;
    }


    /**
     * Sets the ijtbgru value for this Ijgruusu.
     * 
     * @param ijtbgru
     */
    public void setIjtbgru(idw.idwws.Ijtbgru ijtbgru) {
        this.ijtbgru = ijtbgru;
    }


    /**
     * Gets the ijtbusu value for this Ijgruusu.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijgruusu.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgruusu)) return false;
        Ijgruusu other = (Ijgruusu) obj;
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
            ((this.ijtbgru==null && other.getIjtbgru()==null) || 
             (this.ijtbgru!=null &&
              this.ijtbgru.equals(other.getIjtbgru()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu())));
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
        if (getIjtbgru() != null) {
            _hashCode += getIjtbgru().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgruusu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgruusu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgruusuId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbgru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbgru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgru"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
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
