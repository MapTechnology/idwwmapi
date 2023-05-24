/**
 * Ijrelproref.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijrelproref  implements java.io.Serializable {
    private idw.idwws.IjrelprorefId id;

    private idw.idwws.Ijtbpro ijtbpro;

    private idw.idwws.Ijtbref ijtbref;

    public Ijrelproref() {
    }

    public Ijrelproref(
           idw.idwws.IjrelprorefId id,
           idw.idwws.Ijtbpro ijtbpro,
           idw.idwws.Ijtbref ijtbref) {
           this.id = id;
           this.ijtbpro = ijtbpro;
           this.ijtbref = ijtbref;
    }


    /**
     * Gets the id value for this Ijrelproref.
     * 
     * @return id
     */
    public idw.idwws.IjrelprorefId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijrelproref.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjrelprorefId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbpro value for this Ijrelproref.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijrelproref.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the ijtbref value for this Ijrelproref.
     * 
     * @return ijtbref
     */
    public idw.idwws.Ijtbref getIjtbref() {
        return ijtbref;
    }


    /**
     * Sets the ijtbref value for this Ijrelproref.
     * 
     * @param ijtbref
     */
    public void setIjtbref(idw.idwws.Ijtbref ijtbref) {
        this.ijtbref = ijtbref;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijrelproref)) return false;
        Ijrelproref other = (Ijrelproref) obj;
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
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.ijtbref==null && other.getIjtbref()==null) || 
             (this.ijtbref!=null &&
              this.ijtbref.equals(other.getIjtbref())));
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
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getIjtbref() != null) {
            _hashCode += getIjtbref().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijrelproref.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrelproref"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrelprorefId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbref");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbref"));
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
