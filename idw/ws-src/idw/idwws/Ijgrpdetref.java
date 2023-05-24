/**
 * Ijgrpdetref.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpdetref  implements java.io.Serializable {
    private idw.idwws.IjgrpdetrefId id;

    private idw.idwws.Ijgrpref ijgrpref;

    private idw.idwws.Ijtbref ijtbref;

    public Ijgrpdetref() {
    }

    public Ijgrpdetref(
           idw.idwws.IjgrpdetrefId id,
           idw.idwws.Ijgrpref ijgrpref,
           idw.idwws.Ijtbref ijtbref) {
           this.id = id;
           this.ijgrpref = ijgrpref;
           this.ijtbref = ijtbref;
    }


    /**
     * Gets the id value for this Ijgrpdetref.
     * 
     * @return id
     */
    public idw.idwws.IjgrpdetrefId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpdetref.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpdetrefId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpref value for this Ijgrpdetref.
     * 
     * @return ijgrpref
     */
    public idw.idwws.Ijgrpref getIjgrpref() {
        return ijgrpref;
    }


    /**
     * Sets the ijgrpref value for this Ijgrpdetref.
     * 
     * @param ijgrpref
     */
    public void setIjgrpref(idw.idwws.Ijgrpref ijgrpref) {
        this.ijgrpref = ijgrpref;
    }


    /**
     * Gets the ijtbref value for this Ijgrpdetref.
     * 
     * @return ijtbref
     */
    public idw.idwws.Ijtbref getIjtbref() {
        return ijtbref;
    }


    /**
     * Sets the ijtbref value for this Ijgrpdetref.
     * 
     * @param ijtbref
     */
    public void setIjtbref(idw.idwws.Ijtbref ijtbref) {
        this.ijtbref = ijtbref;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpdetref)) return false;
        Ijgrpdetref other = (Ijgrpdetref) obj;
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
            ((this.ijgrpref==null && other.getIjgrpref()==null) || 
             (this.ijgrpref!=null &&
              this.ijgrpref.equals(other.getIjgrpref()))) &&
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
        if (getIjgrpref() != null) {
            _hashCode += getIjgrpref().hashCode();
        }
        if (getIjtbref() != null) {
            _hashCode += getIjtbref().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpdetref.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetref"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetrefId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpref");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpref"));
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
