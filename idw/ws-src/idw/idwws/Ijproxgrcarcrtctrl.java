/**
 * Ijproxgrcarcrtctrl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijproxgrcarcrtctrl  implements java.io.Serializable {
    private idw.idwws.IjproxgrcarcrtctrlId id;

    private idw.idwws.Ijgrcarcrtctrl ijgrcarcrtctrl;

    private idw.idwws.Ijtbpro ijtbpro;

    public Ijproxgrcarcrtctrl() {
    }

    public Ijproxgrcarcrtctrl(
           idw.idwws.IjproxgrcarcrtctrlId id,
           idw.idwws.Ijgrcarcrtctrl ijgrcarcrtctrl,
           idw.idwws.Ijtbpro ijtbpro) {
           this.id = id;
           this.ijgrcarcrtctrl = ijgrcarcrtctrl;
           this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the id value for this Ijproxgrcarcrtctrl.
     * 
     * @return id
     */
    public idw.idwws.IjproxgrcarcrtctrlId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijproxgrcarcrtctrl.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjproxgrcarcrtctrlId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrcarcrtctrl value for this Ijproxgrcarcrtctrl.
     * 
     * @return ijgrcarcrtctrl
     */
    public idw.idwws.Ijgrcarcrtctrl getIjgrcarcrtctrl() {
        return ijgrcarcrtctrl;
    }


    /**
     * Sets the ijgrcarcrtctrl value for this Ijproxgrcarcrtctrl.
     * 
     * @param ijgrcarcrtctrl
     */
    public void setIjgrcarcrtctrl(idw.idwws.Ijgrcarcrtctrl ijgrcarcrtctrl) {
        this.ijgrcarcrtctrl = ijgrcarcrtctrl;
    }


    /**
     * Gets the ijtbpro value for this Ijproxgrcarcrtctrl.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijproxgrcarcrtctrl.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijproxgrcarcrtctrl)) return false;
        Ijproxgrcarcrtctrl other = (Ijproxgrcarcrtctrl) obj;
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
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro())));
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
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijproxgrcarcrtctrl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproxgrcarcrtctrl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproxgrcarcrtctrlId"));
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
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
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