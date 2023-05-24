/**
 * Ijgrcarcrtctrlxesp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrcarcrtctrlxesp  implements java.io.Serializable {
    private idw.idwws.IjgrcarcrtctrlxespId id;

    private idw.idwws.Ijgrcarcrtctrl ijgrcarcrtctrl;

    private idw.idwws.Ijparaminspec ijparaminspec;

    public Ijgrcarcrtctrlxesp() {
    }

    public Ijgrcarcrtctrlxesp(
           idw.idwws.IjgrcarcrtctrlxespId id,
           idw.idwws.Ijgrcarcrtctrl ijgrcarcrtctrl,
           idw.idwws.Ijparaminspec ijparaminspec) {
           this.id = id;
           this.ijgrcarcrtctrl = ijgrcarcrtctrl;
           this.ijparaminspec = ijparaminspec;
    }


    /**
     * Gets the id value for this Ijgrcarcrtctrlxesp.
     * 
     * @return id
     */
    public idw.idwws.IjgrcarcrtctrlxespId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrcarcrtctrlxesp.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrcarcrtctrlxespId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrcarcrtctrl value for this Ijgrcarcrtctrlxesp.
     * 
     * @return ijgrcarcrtctrl
     */
    public idw.idwws.Ijgrcarcrtctrl getIjgrcarcrtctrl() {
        return ijgrcarcrtctrl;
    }


    /**
     * Sets the ijgrcarcrtctrl value for this Ijgrcarcrtctrlxesp.
     * 
     * @param ijgrcarcrtctrl
     */
    public void setIjgrcarcrtctrl(idw.idwws.Ijgrcarcrtctrl ijgrcarcrtctrl) {
        this.ijgrcarcrtctrl = ijgrcarcrtctrl;
    }


    /**
     * Gets the ijparaminspec value for this Ijgrcarcrtctrlxesp.
     * 
     * @return ijparaminspec
     */
    public idw.idwws.Ijparaminspec getIjparaminspec() {
        return ijparaminspec;
    }


    /**
     * Sets the ijparaminspec value for this Ijgrcarcrtctrlxesp.
     * 
     * @param ijparaminspec
     */
    public void setIjparaminspec(idw.idwws.Ijparaminspec ijparaminspec) {
        this.ijparaminspec = ijparaminspec;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrcarcrtctrlxesp)) return false;
        Ijgrcarcrtctrlxesp other = (Ijgrcarcrtctrlxesp) obj;
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
            ((this.ijgrcarcrtctrl==null && other.getIjgrcarcrtctrl()==null) || 
             (this.ijgrcarcrtctrl!=null &&
              this.ijgrcarcrtctrl.equals(other.getIjgrcarcrtctrl()))) &&
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
        if (getIjgrcarcrtctrl() != null) {
            _hashCode += getIjgrcarcrtctrl().hashCode();
        }
        if (getIjparaminspec() != null) {
            _hashCode += getIjparaminspec().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrcarcrtctrlxesp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrcarcrtctrlxesp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrcarcrtctrlxespId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrcarcrtctrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrcarcrtctrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrcarcrtctrl"));
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
