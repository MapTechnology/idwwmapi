/**
 * Ijmolproautorizusu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmolproautorizusu  implements java.io.Serializable {
    private java.util.Calendar dthrstautoriz;

    private idw.idwws.IjmolproautorizusuId id;

    private idw.idwws.Ijmolproautorizmod ijmolproautorizmod;

    private idw.idwws.Ijtbusu ijtbusuByCdusuarioaut;

    private idw.idwws.Ijtbusu ijtbusuByCdususubstituto;

    private org.apache.axis.types.UnsignedShort stautoriz;

    public Ijmolproautorizusu() {
    }

    public Ijmolproautorizusu(
           java.util.Calendar dthrstautoriz,
           idw.idwws.IjmolproautorizusuId id,
           idw.idwws.Ijmolproautorizmod ijmolproautorizmod,
           idw.idwws.Ijtbusu ijtbusuByCdusuarioaut,
           idw.idwws.Ijtbusu ijtbusuByCdususubstituto,
           org.apache.axis.types.UnsignedShort stautoriz) {
           this.dthrstautoriz = dthrstautoriz;
           this.id = id;
           this.ijmolproautorizmod = ijmolproautorizmod;
           this.ijtbusuByCdusuarioaut = ijtbusuByCdusuarioaut;
           this.ijtbusuByCdususubstituto = ijtbusuByCdususubstituto;
           this.stautoriz = stautoriz;
    }


    /**
     * Gets the dthrstautoriz value for this Ijmolproautorizusu.
     * 
     * @return dthrstautoriz
     */
    public java.util.Calendar getDthrstautoriz() {
        return dthrstautoriz;
    }


    /**
     * Sets the dthrstautoriz value for this Ijmolproautorizusu.
     * 
     * @param dthrstautoriz
     */
    public void setDthrstautoriz(java.util.Calendar dthrstautoriz) {
        this.dthrstautoriz = dthrstautoriz;
    }


    /**
     * Gets the id value for this Ijmolproautorizusu.
     * 
     * @return id
     */
    public idw.idwws.IjmolproautorizusuId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmolproautorizusu.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmolproautorizusuId id) {
        this.id = id;
    }


    /**
     * Gets the ijmolproautorizmod value for this Ijmolproautorizusu.
     * 
     * @return ijmolproautorizmod
     */
    public idw.idwws.Ijmolproautorizmod getIjmolproautorizmod() {
        return ijmolproautorizmod;
    }


    /**
     * Sets the ijmolproautorizmod value for this Ijmolproautorizusu.
     * 
     * @param ijmolproautorizmod
     */
    public void setIjmolproautorizmod(idw.idwws.Ijmolproautorizmod ijmolproautorizmod) {
        this.ijmolproautorizmod = ijmolproautorizmod;
    }


    /**
     * Gets the ijtbusuByCdusuarioaut value for this Ijmolproautorizusu.
     * 
     * @return ijtbusuByCdusuarioaut
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuarioaut() {
        return ijtbusuByCdusuarioaut;
    }


    /**
     * Sets the ijtbusuByCdusuarioaut value for this Ijmolproautorizusu.
     * 
     * @param ijtbusuByCdusuarioaut
     */
    public void setIjtbusuByCdusuarioaut(idw.idwws.Ijtbusu ijtbusuByCdusuarioaut) {
        this.ijtbusuByCdusuarioaut = ijtbusuByCdusuarioaut;
    }


    /**
     * Gets the ijtbusuByCdususubstituto value for this Ijmolproautorizusu.
     * 
     * @return ijtbusuByCdususubstituto
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdususubstituto() {
        return ijtbusuByCdususubstituto;
    }


    /**
     * Sets the ijtbusuByCdususubstituto value for this Ijmolproautorizusu.
     * 
     * @param ijtbusuByCdususubstituto
     */
    public void setIjtbusuByCdususubstituto(idw.idwws.Ijtbusu ijtbusuByCdususubstituto) {
        this.ijtbusuByCdususubstituto = ijtbusuByCdususubstituto;
    }


    /**
     * Gets the stautoriz value for this Ijmolproautorizusu.
     * 
     * @return stautoriz
     */
    public org.apache.axis.types.UnsignedShort getStautoriz() {
        return stautoriz;
    }


    /**
     * Sets the stautoriz value for this Ijmolproautorizusu.
     * 
     * @param stautoriz
     */
    public void setStautoriz(org.apache.axis.types.UnsignedShort stautoriz) {
        this.stautoriz = stautoriz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmolproautorizusu)) return false;
        Ijmolproautorizusu other = (Ijmolproautorizusu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrstautoriz==null && other.getDthrstautoriz()==null) || 
             (this.dthrstautoriz!=null &&
              this.dthrstautoriz.equals(other.getDthrstautoriz()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijmolproautorizmod==null && other.getIjmolproautorizmod()==null) || 
             (this.ijmolproautorizmod!=null &&
              this.ijmolproautorizmod.equals(other.getIjmolproautorizmod()))) &&
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
        if (getDthrstautoriz() != null) {
            _hashCode += getDthrstautoriz().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjmolproautorizmod() != null) {
            _hashCode += getIjmolproautorizmod().hashCode();
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
        new org.apache.axis.description.TypeDesc(Ijmolproautorizusu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizusu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrstautoriz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrstautoriz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizusuId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproautorizmod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproautorizmod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizmod"));
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
