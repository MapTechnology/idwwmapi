/**
 * Ijfictecautorizusu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfictecautorizusu  implements java.io.Serializable {
    private java.util.Calendar dthrautoriz;

    private idw.idwws.IjfictecautorizusuId id;

    private idw.idwws.Ijfictecautorizmod ijfictecautorizmod;

    private idw.idwws.Ijtbusu ijtbusuByCdusuarioaut;

    private idw.idwws.Ijtbusu ijtbusuByCdususubstituto;

    private org.apache.axis.types.UnsignedShort stautoriz;

    public Ijfictecautorizusu() {
    }

    public Ijfictecautorizusu(
           java.util.Calendar dthrautoriz,
           idw.idwws.IjfictecautorizusuId id,
           idw.idwws.Ijfictecautorizmod ijfictecautorizmod,
           idw.idwws.Ijtbusu ijtbusuByCdusuarioaut,
           idw.idwws.Ijtbusu ijtbusuByCdususubstituto,
           org.apache.axis.types.UnsignedShort stautoriz) {
           this.dthrautoriz = dthrautoriz;
           this.id = id;
           this.ijfictecautorizmod = ijfictecautorizmod;
           this.ijtbusuByCdusuarioaut = ijtbusuByCdusuarioaut;
           this.ijtbusuByCdususubstituto = ijtbusuByCdususubstituto;
           this.stautoriz = stautoriz;
    }


    /**
     * Gets the dthrautoriz value for this Ijfictecautorizusu.
     * 
     * @return dthrautoriz
     */
    public java.util.Calendar getDthrautoriz() {
        return dthrautoriz;
    }


    /**
     * Sets the dthrautoriz value for this Ijfictecautorizusu.
     * 
     * @param dthrautoriz
     */
    public void setDthrautoriz(java.util.Calendar dthrautoriz) {
        this.dthrautoriz = dthrautoriz;
    }


    /**
     * Gets the id value for this Ijfictecautorizusu.
     * 
     * @return id
     */
    public idw.idwws.IjfictecautorizusuId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijfictecautorizusu.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjfictecautorizusuId id) {
        this.id = id;
    }


    /**
     * Gets the ijfictecautorizmod value for this Ijfictecautorizusu.
     * 
     * @return ijfictecautorizmod
     */
    public idw.idwws.Ijfictecautorizmod getIjfictecautorizmod() {
        return ijfictecautorizmod;
    }


    /**
     * Sets the ijfictecautorizmod value for this Ijfictecautorizusu.
     * 
     * @param ijfictecautorizmod
     */
    public void setIjfictecautorizmod(idw.idwws.Ijfictecautorizmod ijfictecautorizmod) {
        this.ijfictecautorizmod = ijfictecautorizmod;
    }


    /**
     * Gets the ijtbusuByCdusuarioaut value for this Ijfictecautorizusu.
     * 
     * @return ijtbusuByCdusuarioaut
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuarioaut() {
        return ijtbusuByCdusuarioaut;
    }


    /**
     * Sets the ijtbusuByCdusuarioaut value for this Ijfictecautorizusu.
     * 
     * @param ijtbusuByCdusuarioaut
     */
    public void setIjtbusuByCdusuarioaut(idw.idwws.Ijtbusu ijtbusuByCdusuarioaut) {
        this.ijtbusuByCdusuarioaut = ijtbusuByCdusuarioaut;
    }


    /**
     * Gets the ijtbusuByCdususubstituto value for this Ijfictecautorizusu.
     * 
     * @return ijtbusuByCdususubstituto
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdususubstituto() {
        return ijtbusuByCdususubstituto;
    }


    /**
     * Sets the ijtbusuByCdususubstituto value for this Ijfictecautorizusu.
     * 
     * @param ijtbusuByCdususubstituto
     */
    public void setIjtbusuByCdususubstituto(idw.idwws.Ijtbusu ijtbusuByCdususubstituto) {
        this.ijtbusuByCdususubstituto = ijtbusuByCdususubstituto;
    }


    /**
     * Gets the stautoriz value for this Ijfictecautorizusu.
     * 
     * @return stautoriz
     */
    public org.apache.axis.types.UnsignedShort getStautoriz() {
        return stautoriz;
    }


    /**
     * Sets the stautoriz value for this Ijfictecautorizusu.
     * 
     * @param stautoriz
     */
    public void setStautoriz(org.apache.axis.types.UnsignedShort stautoriz) {
        this.stautoriz = stautoriz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfictecautorizusu)) return false;
        Ijfictecautorizusu other = (Ijfictecautorizusu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrautoriz==null && other.getDthrautoriz()==null) || 
             (this.dthrautoriz!=null &&
              this.dthrautoriz.equals(other.getDthrautoriz()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijfictecautorizmod==null && other.getIjfictecautorizmod()==null) || 
             (this.ijfictecautorizmod!=null &&
              this.ijfictecautorizmod.equals(other.getIjfictecautorizmod()))) &&
            ((this.ijtbusuByCdusuarioaut==null && other.getIjtbusuByCdusuarioaut()==null) || 
             (this.ijtbusuByCdusuarioaut!=null &&
              this.ijtbusuByCdusuarioaut.equals(other.getIjtbusuByCdusuarioaut()))) &&
            ((this.ijtbusuByCdususubstituto==null && other.getIjtbusuByCdususubstituto()==null) || 
             (this.ijtbusuByCdususubstituto!=null &&
              this.ijtbusuByCdususubstituto.equals(other.getIjtbusuByCdususubstituto()))) &&
            ((this.stautoriz==null && other.getStautoriz()==null) || 
             (this.stautoriz!=null &&
              this.stautoriz.equals(other.getStautoriz())));
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
        if (getDthrautoriz() != null) {
            _hashCode += getDthrautoriz().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjfictecautorizmod() != null) {
            _hashCode += getIjfictecautorizmod().hashCode();
        }
        if (getIjtbusuByCdusuarioaut() != null) {
            _hashCode += getIjtbusuByCdusuarioaut().hashCode();
        }
        if (getIjtbusuByCdususubstituto() != null) {
            _hashCode += getIjtbusuByCdususubstituto().hashCode();
        }
        if (getStautoriz() != null) {
            _hashCode += getStautoriz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfictecautorizusu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecautorizusu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrautoriz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrautoriz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecautorizusuId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictecautorizmod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictecautorizmod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecautorizmod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusuarioaut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusuarioaut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdususubstituto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdususubstituto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stautoriz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stautoriz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
