/**
 * Ijrearefoprd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijrearefoprd  implements java.io.Serializable {
    private idw.idwws.IjrearefoprdId id;

    private idw.idwws.Ijrearef ijrearef;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijrearefoprd() {
    }

    public Ijrearefoprd(
           idw.idwws.IjrearefoprdId id,
           idw.idwws.Ijrearef ijrearef,
           idw.idwws.Ijtbusu ijtbusu) {
           this.id = id;
           this.ijrearef = ijrearef;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the id value for this Ijrearefoprd.
     * 
     * @return id
     */
    public idw.idwws.IjrearefoprdId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijrearefoprd.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjrearefoprdId id) {
        this.id = id;
    }


    /**
     * Gets the ijrearef value for this Ijrearefoprd.
     * 
     * @return ijrearef
     */
    public idw.idwws.Ijrearef getIjrearef() {
        return ijrearef;
    }


    /**
     * Sets the ijrearef value for this Ijrearefoprd.
     * 
     * @param ijrearef
     */
    public void setIjrearef(idw.idwws.Ijrearef ijrearef) {
        this.ijrearef = ijrearef;
    }


    /**
     * Gets the ijtbusu value for this Ijrearefoprd.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijrearefoprd.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijrearefoprd)) return false;
        Ijrearefoprd other = (Ijrearefoprd) obj;
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
            ((this.ijrearef==null && other.getIjrearef()==null) || 
             (this.ijrearef!=null &&
              this.ijrearef.equals(other.getIjrearef()))) &&
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
        if (getIjrearef() != null) {
            _hashCode += getIjrearef().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijrearefoprd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearefoprd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearefoprdId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrearef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrearef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearef"));
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
