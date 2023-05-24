/**
 * Ijcncop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcncop  implements java.io.Serializable {
    private idw.idwws.IjcncopId id;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbitemcnc ijtbitemcnc;

    private java.lang.Double vlmedio;

    public Ijcncop() {
    }

    public Ijcncop(
           idw.idwws.IjcncopId id,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbitemcnc ijtbitemcnc,
           java.lang.Double vlmedio) {
           this.id = id;
           this.ijop = ijop;
           this.ijtbitemcnc = ijtbitemcnc;
           this.vlmedio = vlmedio;
    }


    /**
     * Gets the id value for this Ijcncop.
     * 
     * @return id
     */
    public idw.idwws.IjcncopId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcncop.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcncopId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijcncop.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijcncop.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbitemcnc value for this Ijcncop.
     * 
     * @return ijtbitemcnc
     */
    public idw.idwws.Ijtbitemcnc getIjtbitemcnc() {
        return ijtbitemcnc;
    }


    /**
     * Sets the ijtbitemcnc value for this Ijcncop.
     * 
     * @param ijtbitemcnc
     */
    public void setIjtbitemcnc(idw.idwws.Ijtbitemcnc ijtbitemcnc) {
        this.ijtbitemcnc = ijtbitemcnc;
    }


    /**
     * Gets the vlmedio value for this Ijcncop.
     * 
     * @return vlmedio
     */
    public java.lang.Double getVlmedio() {
        return vlmedio;
    }


    /**
     * Sets the vlmedio value for this Ijcncop.
     * 
     * @param vlmedio
     */
    public void setVlmedio(java.lang.Double vlmedio) {
        this.vlmedio = vlmedio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcncop)) return false;
        Ijcncop other = (Ijcncop) obj;
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
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbitemcnc==null && other.getIjtbitemcnc()==null) || 
             (this.ijtbitemcnc!=null &&
              this.ijtbitemcnc.equals(other.getIjtbitemcnc()))) &&
            ((this.vlmedio==null && other.getVlmedio()==null) || 
             (this.vlmedio!=null &&
              this.vlmedio.equals(other.getVlmedio())));
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
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbitemcnc() != null) {
            _hashCode += getIjtbitemcnc().hashCode();
        }
        if (getVlmedio() != null) {
            _hashCode += getVlmedio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcncop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncopId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbitemcnc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlmedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlmedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
