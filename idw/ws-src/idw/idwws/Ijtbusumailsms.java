/**
 * Ijtbusumailsms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbusumailsms  implements java.io.Serializable {
    private idw.idwws.IjtbusumailsmsId id;

    private idw.idwws.Ijtbusumail ijtbusumail;

    public Ijtbusumailsms() {
    }

    public Ijtbusumailsms(
           idw.idwws.IjtbusumailsmsId id,
           idw.idwws.Ijtbusumail ijtbusumail) {
           this.id = id;
           this.ijtbusumail = ijtbusumail;
    }


    /**
     * Gets the id value for this Ijtbusumailsms.
     * 
     * @return id
     */
    public idw.idwws.IjtbusumailsmsId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbusumailsms.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbusumailsmsId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbusumail value for this Ijtbusumailsms.
     * 
     * @return ijtbusumail
     */
    public idw.idwws.Ijtbusumail getIjtbusumail() {
        return ijtbusumail;
    }


    /**
     * Sets the ijtbusumail value for this Ijtbusumailsms.
     * 
     * @param ijtbusumail
     */
    public void setIjtbusumail(idw.idwws.Ijtbusumail ijtbusumail) {
        this.ijtbusumail = ijtbusumail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbusumailsms)) return false;
        Ijtbusumailsms other = (Ijtbusumailsms) obj;
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
            ((this.ijtbusumail==null && other.getIjtbusumail()==null) || 
             (this.ijtbusumail!=null &&
              this.ijtbusumail.equals(other.getIjtbusumail())));
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
        if (getIjtbusumail() != null) {
            _hashCode += getIjtbusumail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbusumailsms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumailsms"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumailsmsId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusumail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusumail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumail"));
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
