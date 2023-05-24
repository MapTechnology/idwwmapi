/**
 * Ijduimpxplantas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijduimpxplantas  implements java.io.Serializable {
    private idw.idwws.IjduimpxplantasId id;

    private idw.idwws.Ijduimpressaocgq ijduimpressaocgq;

    public Ijduimpxplantas() {
    }

    public Ijduimpxplantas(
           idw.idwws.IjduimpxplantasId id,
           idw.idwws.Ijduimpressaocgq ijduimpressaocgq) {
           this.id = id;
           this.ijduimpressaocgq = ijduimpressaocgq;
    }


    /**
     * Gets the id value for this Ijduimpxplantas.
     * 
     * @return id
     */
    public idw.idwws.IjduimpxplantasId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijduimpxplantas.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjduimpxplantasId id) {
        this.id = id;
    }


    /**
     * Gets the ijduimpressaocgq value for this Ijduimpxplantas.
     * 
     * @return ijduimpressaocgq
     */
    public idw.idwws.Ijduimpressaocgq getIjduimpressaocgq() {
        return ijduimpressaocgq;
    }


    /**
     * Sets the ijduimpressaocgq value for this Ijduimpxplantas.
     * 
     * @param ijduimpressaocgq
     */
    public void setIjduimpressaocgq(idw.idwws.Ijduimpressaocgq ijduimpressaocgq) {
        this.ijduimpressaocgq = ijduimpressaocgq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijduimpxplantas)) return false;
        Ijduimpxplantas other = (Ijduimpxplantas) obj;
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
            ((this.ijduimpressaocgq==null && other.getIjduimpressaocgq()==null) || 
             (this.ijduimpressaocgq!=null &&
              this.ijduimpressaocgq.equals(other.getIjduimpressaocgq())));
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
        if (getIjduimpressaocgq() != null) {
            _hashCode += getIjduimpressaocgq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijduimpxplantas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijduimpxplantas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijduimpxplantasId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijduimpressaocgq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijduimpressaocgq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijduimpressaocgq"));
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
