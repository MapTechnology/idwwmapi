/**
 * Ijmolproidcav.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmolproidcav  implements java.io.Serializable {
    private idw.idwws.IjmolproidcavId id;

    private idw.idwws.Ijmolpro ijmolpro;

    private idw.idwws.Ijtbmolidcav ijtbmolidcav;

    public Ijmolproidcav() {
    }

    public Ijmolproidcav(
           idw.idwws.IjmolproidcavId id,
           idw.idwws.Ijmolpro ijmolpro,
           idw.idwws.Ijtbmolidcav ijtbmolidcav) {
           this.id = id;
           this.ijmolpro = ijmolpro;
           this.ijtbmolidcav = ijtbmolidcav;
    }


    /**
     * Gets the id value for this Ijmolproidcav.
     * 
     * @return id
     */
    public idw.idwws.IjmolproidcavId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmolproidcav.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmolproidcavId id) {
        this.id = id;
    }


    /**
     * Gets the ijmolpro value for this Ijmolproidcav.
     * 
     * @return ijmolpro
     */
    public idw.idwws.Ijmolpro getIjmolpro() {
        return ijmolpro;
    }


    /**
     * Sets the ijmolpro value for this Ijmolproidcav.
     * 
     * @param ijmolpro
     */
    public void setIjmolpro(idw.idwws.Ijmolpro ijmolpro) {
        this.ijmolpro = ijmolpro;
    }


    /**
     * Gets the ijtbmolidcav value for this Ijmolproidcav.
     * 
     * @return ijtbmolidcav
     */
    public idw.idwws.Ijtbmolidcav getIjtbmolidcav() {
        return ijtbmolidcav;
    }


    /**
     * Sets the ijtbmolidcav value for this Ijmolproidcav.
     * 
     * @param ijtbmolidcav
     */
    public void setIjtbmolidcav(idw.idwws.Ijtbmolidcav ijtbmolidcav) {
        this.ijtbmolidcav = ijtbmolidcav;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmolproidcav)) return false;
        Ijmolproidcav other = (Ijmolproidcav) obj;
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
            ((this.ijmolpro==null && other.getIjmolpro()==null) || 
             (this.ijmolpro!=null &&
              this.ijmolpro.equals(other.getIjmolpro()))) &&
            ((this.ijtbmolidcav==null && other.getIjtbmolidcav()==null) || 
             (this.ijtbmolidcav!=null &&
              this.ijtbmolidcav.equals(other.getIjtbmolidcav())));
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
        if (getIjmolpro() != null) {
            _hashCode += getIjmolpro().hashCode();
        }
        if (getIjtbmolidcav() != null) {
            _hashCode += getIjtbmolidcav().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmolproidcav.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproidcav"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproidcavId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmolidcav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmolidcav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmolidcav"));
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
