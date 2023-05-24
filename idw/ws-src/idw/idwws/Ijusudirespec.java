/**
 * Ijusudirespec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijusudirespec  implements java.io.Serializable {
    private idw.idwws.IjusudirespecId id;

    private idw.idwws.Ijtbdirespec ijtbdirespec;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijusudirespec() {
    }

    public Ijusudirespec(
           idw.idwws.IjusudirespecId id,
           idw.idwws.Ijtbdirespec ijtbdirespec,
           idw.idwws.Ijtbusu ijtbusu) {
           this.id = id;
           this.ijtbdirespec = ijtbdirespec;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the id value for this Ijusudirespec.
     * 
     * @return id
     */
    public idw.idwws.IjusudirespecId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijusudirespec.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjusudirespecId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbdirespec value for this Ijusudirespec.
     * 
     * @return ijtbdirespec
     */
    public idw.idwws.Ijtbdirespec getIjtbdirespec() {
        return ijtbdirespec;
    }


    /**
     * Sets the ijtbdirespec value for this Ijusudirespec.
     * 
     * @param ijtbdirespec
     */
    public void setIjtbdirespec(idw.idwws.Ijtbdirespec ijtbdirespec) {
        this.ijtbdirespec = ijtbdirespec;
    }


    /**
     * Gets the ijtbusu value for this Ijusudirespec.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijusudirespec.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijusudirespec)) return false;
        Ijusudirespec other = (Ijusudirespec) obj;
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
            ((this.ijtbdirespec==null && other.getIjtbdirespec()==null) || 
             (this.ijtbdirespec!=null &&
              this.ijtbdirespec.equals(other.getIjtbdirespec()))) &&
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
        if (getIjtbdirespec() != null) {
            _hashCode += getIjtbdirespec().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijusudirespec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijusudirespec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijusudirespecId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbdirespec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbdirespec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbdirespec"));
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
