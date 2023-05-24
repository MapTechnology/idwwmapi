/**
 * Ijregultinspqld1Fr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijregultinspqld1Fr  implements java.io.Serializable {
    private idw.idwws.Ijregultinspqld1FrId id;

    private idw.idwws.Ijregultinspqld1 ijregultinspqld1;

    public Ijregultinspqld1Fr() {
    }

    public Ijregultinspqld1Fr(
           idw.idwws.Ijregultinspqld1FrId id,
           idw.idwws.Ijregultinspqld1 ijregultinspqld1) {
           this.id = id;
           this.ijregultinspqld1 = ijregultinspqld1;
    }


    /**
     * Gets the id value for this Ijregultinspqld1Fr.
     * 
     * @return id
     */
    public idw.idwws.Ijregultinspqld1FrId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijregultinspqld1Fr.
     * 
     * @param id
     */
    public void setId(idw.idwws.Ijregultinspqld1FrId id) {
        this.id = id;
    }


    /**
     * Gets the ijregultinspqld1 value for this Ijregultinspqld1Fr.
     * 
     * @return ijregultinspqld1
     */
    public idw.idwws.Ijregultinspqld1 getIjregultinspqld1() {
        return ijregultinspqld1;
    }


    /**
     * Sets the ijregultinspqld1 value for this Ijregultinspqld1Fr.
     * 
     * @param ijregultinspqld1
     */
    public void setIjregultinspqld1(idw.idwws.Ijregultinspqld1 ijregultinspqld1) {
        this.ijregultinspqld1 = ijregultinspqld1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijregultinspqld1Fr)) return false;
        Ijregultinspqld1Fr other = (Ijregultinspqld1Fr) obj;
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
            ((this.ijregultinspqld1==null && other.getIjregultinspqld1()==null) || 
             (this.ijregultinspqld1!=null &&
              this.ijregultinspqld1.equals(other.getIjregultinspqld1())));
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
        if (getIjregultinspqld1() != null) {
            _hashCode += getIjregultinspqld1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijregultinspqld1Fr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijregultinspqld1Fr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijregultinspqld1FrId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijregultinspqld1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijregultinspqld1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijregultinspqld1"));
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
