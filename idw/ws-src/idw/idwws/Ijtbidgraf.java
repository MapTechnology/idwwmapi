/**
 * Ijtbidgraf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbidgraf  implements java.io.Serializable {
    private java.lang.String cdgraf;

    private idw.idwws.IjtbidgrafId id;

    private idw.idwws.Ijtbmodulos ijtbmodulos;

    public Ijtbidgraf() {
    }

    public Ijtbidgraf(
           java.lang.String cdgraf,
           idw.idwws.IjtbidgrafId id,
           idw.idwws.Ijtbmodulos ijtbmodulos) {
           this.cdgraf = cdgraf;
           this.id = id;
           this.ijtbmodulos = ijtbmodulos;
    }


    /**
     * Gets the cdgraf value for this Ijtbidgraf.
     * 
     * @return cdgraf
     */
    public java.lang.String getCdgraf() {
        return cdgraf;
    }


    /**
     * Sets the cdgraf value for this Ijtbidgraf.
     * 
     * @param cdgraf
     */
    public void setCdgraf(java.lang.String cdgraf) {
        this.cdgraf = cdgraf;
    }


    /**
     * Gets the id value for this Ijtbidgraf.
     * 
     * @return id
     */
    public idw.idwws.IjtbidgrafId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbidgraf.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbidgrafId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbmodulos value for this Ijtbidgraf.
     * 
     * @return ijtbmodulos
     */
    public idw.idwws.Ijtbmodulos getIjtbmodulos() {
        return ijtbmodulos;
    }


    /**
     * Sets the ijtbmodulos value for this Ijtbidgraf.
     * 
     * @param ijtbmodulos
     */
    public void setIjtbmodulos(idw.idwws.Ijtbmodulos ijtbmodulos) {
        this.ijtbmodulos = ijtbmodulos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbidgraf)) return false;
        Ijtbidgraf other = (Ijtbidgraf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgraf==null && other.getCdgraf()==null) || 
             (this.cdgraf!=null &&
              this.cdgraf.equals(other.getCdgraf()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbmodulos==null && other.getIjtbmodulos()==null) || 
             (this.ijtbmodulos!=null &&
              this.ijtbmodulos.equals(other.getIjtbmodulos())));
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
        if (getCdgraf() != null) {
            _hashCode += getCdgraf().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbmodulos() != null) {
            _hashCode += getIjtbmodulos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbidgraf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidgraf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgraf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgraf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidgrafId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmodulos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmodulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodulos"));
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
