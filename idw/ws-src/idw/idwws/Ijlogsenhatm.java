/**
 * Ijlogsenhatm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijlogsenhatm  implements java.io.Serializable {
    private idw.idwws.IjlogsenhatmId id;

    private idw.idwws.Ijtbusu ijtbusuByCdadmin;

    private idw.idwws.Ijtbusu ijtbusuByCdusuario;

    public Ijlogsenhatm() {
    }

    public Ijlogsenhatm(
           idw.idwws.IjlogsenhatmId id,
           idw.idwws.Ijtbusu ijtbusuByCdadmin,
           idw.idwws.Ijtbusu ijtbusuByCdusuario) {
           this.id = id;
           this.ijtbusuByCdadmin = ijtbusuByCdadmin;
           this.ijtbusuByCdusuario = ijtbusuByCdusuario;
    }


    /**
     * Gets the id value for this Ijlogsenhatm.
     * 
     * @return id
     */
    public idw.idwws.IjlogsenhatmId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijlogsenhatm.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjlogsenhatmId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbusuByCdadmin value for this Ijlogsenhatm.
     * 
     * @return ijtbusuByCdadmin
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdadmin() {
        return ijtbusuByCdadmin;
    }


    /**
     * Sets the ijtbusuByCdadmin value for this Ijlogsenhatm.
     * 
     * @param ijtbusuByCdadmin
     */
    public void setIjtbusuByCdadmin(idw.idwws.Ijtbusu ijtbusuByCdadmin) {
        this.ijtbusuByCdadmin = ijtbusuByCdadmin;
    }


    /**
     * Gets the ijtbusuByCdusuario value for this Ijlogsenhatm.
     * 
     * @return ijtbusuByCdusuario
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuario() {
        return ijtbusuByCdusuario;
    }


    /**
     * Sets the ijtbusuByCdusuario value for this Ijlogsenhatm.
     * 
     * @param ijtbusuByCdusuario
     */
    public void setIjtbusuByCdusuario(idw.idwws.Ijtbusu ijtbusuByCdusuario) {
        this.ijtbusuByCdusuario = ijtbusuByCdusuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijlogsenhatm)) return false;
        Ijlogsenhatm other = (Ijlogsenhatm) obj;
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
            ((this.ijtbusuByCdadmin==null && other.getIjtbusuByCdadmin()==null) || 
             (this.ijtbusuByCdadmin!=null &&
              this.ijtbusuByCdadmin.equals(other.getIjtbusuByCdadmin()))) &&
            ((this.ijtbusuByCdusuario==null && other.getIjtbusuByCdusuario()==null) || 
             (this.ijtbusuByCdusuario!=null &&
              this.ijtbusuByCdusuario.equals(other.getIjtbusuByCdusuario())));
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
        if (getIjtbusuByCdadmin() != null) {
            _hashCode += getIjtbusuByCdadmin().hashCode();
        }
        if (getIjtbusuByCdusuario() != null) {
            _hashCode += getIjtbusuByCdusuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijlogsenhatm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogsenhatm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogsenhatmId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdadmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdadmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusuario"));
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
