/**
 * Ijamstrdetaltmedia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamstrdetaltmedia  implements java.io.Serializable {
    private idw.idwws.IjamstrdetaltmediaId id;

    private idw.idwws.Ijamstraltcgq ijamstraltcgqByIdctrlaltcgammedia;

    private idw.idwws.Ijamstraltcgq ijamstraltcgqByIdctrlaltcgqamstr;

    public Ijamstrdetaltmedia() {
    }

    public Ijamstrdetaltmedia(
           idw.idwws.IjamstrdetaltmediaId id,
           idw.idwws.Ijamstraltcgq ijamstraltcgqByIdctrlaltcgammedia,
           idw.idwws.Ijamstraltcgq ijamstraltcgqByIdctrlaltcgqamstr) {
           this.id = id;
           this.ijamstraltcgqByIdctrlaltcgammedia = ijamstraltcgqByIdctrlaltcgammedia;
           this.ijamstraltcgqByIdctrlaltcgqamstr = ijamstraltcgqByIdctrlaltcgqamstr;
    }


    /**
     * Gets the id value for this Ijamstrdetaltmedia.
     * 
     * @return id
     */
    public idw.idwws.IjamstrdetaltmediaId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijamstrdetaltmedia.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjamstrdetaltmediaId id) {
        this.id = id;
    }


    /**
     * Gets the ijamstraltcgqByIdctrlaltcgammedia value for this Ijamstrdetaltmedia.
     * 
     * @return ijamstraltcgqByIdctrlaltcgammedia
     */
    public idw.idwws.Ijamstraltcgq getIjamstraltcgqByIdctrlaltcgammedia() {
        return ijamstraltcgqByIdctrlaltcgammedia;
    }


    /**
     * Sets the ijamstraltcgqByIdctrlaltcgammedia value for this Ijamstrdetaltmedia.
     * 
     * @param ijamstraltcgqByIdctrlaltcgammedia
     */
    public void setIjamstraltcgqByIdctrlaltcgammedia(idw.idwws.Ijamstraltcgq ijamstraltcgqByIdctrlaltcgammedia) {
        this.ijamstraltcgqByIdctrlaltcgammedia = ijamstraltcgqByIdctrlaltcgammedia;
    }


    /**
     * Gets the ijamstraltcgqByIdctrlaltcgqamstr value for this Ijamstrdetaltmedia.
     * 
     * @return ijamstraltcgqByIdctrlaltcgqamstr
     */
    public idw.idwws.Ijamstraltcgq getIjamstraltcgqByIdctrlaltcgqamstr() {
        return ijamstraltcgqByIdctrlaltcgqamstr;
    }


    /**
     * Sets the ijamstraltcgqByIdctrlaltcgqamstr value for this Ijamstrdetaltmedia.
     * 
     * @param ijamstraltcgqByIdctrlaltcgqamstr
     */
    public void setIjamstraltcgqByIdctrlaltcgqamstr(idw.idwws.Ijamstraltcgq ijamstraltcgqByIdctrlaltcgqamstr) {
        this.ijamstraltcgqByIdctrlaltcgqamstr = ijamstraltcgqByIdctrlaltcgqamstr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamstrdetaltmedia)) return false;
        Ijamstrdetaltmedia other = (Ijamstrdetaltmedia) obj;
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
            ((this.ijamstraltcgqByIdctrlaltcgammedia==null && other.getIjamstraltcgqByIdctrlaltcgammedia()==null) || 
             (this.ijamstraltcgqByIdctrlaltcgammedia!=null &&
              this.ijamstraltcgqByIdctrlaltcgammedia.equals(other.getIjamstraltcgqByIdctrlaltcgammedia()))) &&
            ((this.ijamstraltcgqByIdctrlaltcgqamstr==null && other.getIjamstraltcgqByIdctrlaltcgqamstr()==null) || 
             (this.ijamstraltcgqByIdctrlaltcgqamstr!=null &&
              this.ijamstraltcgqByIdctrlaltcgqamstr.equals(other.getIjamstraltcgqByIdctrlaltcgqamstr())));
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
        if (getIjamstraltcgqByIdctrlaltcgammedia() != null) {
            _hashCode += getIjamstraltcgqByIdctrlaltcgammedia().hashCode();
        }
        if (getIjamstraltcgqByIdctrlaltcgqamstr() != null) {
            _hashCode += getIjamstraltcgqByIdctrlaltcgqamstr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamstrdetaltmedia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrdetaltmedia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrdetaltmediaId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstraltcgqByIdctrlaltcgammedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstraltcgqByIdctrlaltcgammedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstraltcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstraltcgqByIdctrlaltcgqamstr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstraltcgqByIdctrlaltcgqamstr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstraltcgq"));
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
