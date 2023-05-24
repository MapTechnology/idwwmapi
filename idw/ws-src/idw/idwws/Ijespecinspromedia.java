/**
 * Ijespecinspromedia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijespecinspromedia  implements java.io.Serializable {
    private idw.idwws.IjespecinspromediaId id;

    private idw.idwws.Ijespecinsppro ijespecinsppro;

    private idw.idwws.Ijparaminspec ijparaminspec;

    public Ijespecinspromedia() {
    }

    public Ijespecinspromedia(
           idw.idwws.IjespecinspromediaId id,
           idw.idwws.Ijespecinsppro ijespecinsppro,
           idw.idwws.Ijparaminspec ijparaminspec) {
           this.id = id;
           this.ijespecinsppro = ijespecinsppro;
           this.ijparaminspec = ijparaminspec;
    }


    /**
     * Gets the id value for this Ijespecinspromedia.
     * 
     * @return id
     */
    public idw.idwws.IjespecinspromediaId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijespecinspromedia.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjespecinspromediaId id) {
        this.id = id;
    }


    /**
     * Gets the ijespecinsppro value for this Ijespecinspromedia.
     * 
     * @return ijespecinsppro
     */
    public idw.idwws.Ijespecinsppro getIjespecinsppro() {
        return ijespecinsppro;
    }


    /**
     * Sets the ijespecinsppro value for this Ijespecinspromedia.
     * 
     * @param ijespecinsppro
     */
    public void setIjespecinsppro(idw.idwws.Ijespecinsppro ijespecinsppro) {
        this.ijespecinsppro = ijespecinsppro;
    }


    /**
     * Gets the ijparaminspec value for this Ijespecinspromedia.
     * 
     * @return ijparaminspec
     */
    public idw.idwws.Ijparaminspec getIjparaminspec() {
        return ijparaminspec;
    }


    /**
     * Sets the ijparaminspec value for this Ijespecinspromedia.
     * 
     * @param ijparaminspec
     */
    public void setIjparaminspec(idw.idwws.Ijparaminspec ijparaminspec) {
        this.ijparaminspec = ijparaminspec;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijespecinspromedia)) return false;
        Ijespecinspromedia other = (Ijespecinspromedia) obj;
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
            ((this.ijespecinsppro==null && other.getIjespecinsppro()==null) || 
             (this.ijespecinsppro!=null &&
              this.ijespecinsppro.equals(other.getIjespecinsppro()))) &&
            ((this.ijparaminspec==null && other.getIjparaminspec()==null) || 
             (this.ijparaminspec!=null &&
              this.ijparaminspec.equals(other.getIjparaminspec())));
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
        if (getIjespecinsppro() != null) {
            _hashCode += getIjespecinsppro().hashCode();
        }
        if (getIjparaminspec() != null) {
            _hashCode += getIjparaminspec().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijespecinspromedia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinspromedia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinspromediaId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijespecinsppro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijespecinsppro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinsppro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparaminspec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparaminspec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminspec"));
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
