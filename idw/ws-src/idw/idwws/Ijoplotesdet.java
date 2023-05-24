/**
 * Ijoplotesdet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijoplotesdet  implements java.io.Serializable {
    private idw.idwws.IjoplotesdetId id;

    private idw.idwws.Ijoplotes ijoplotes;

    public Ijoplotesdet() {
    }

    public Ijoplotesdet(
           idw.idwws.IjoplotesdetId id,
           idw.idwws.Ijoplotes ijoplotes) {
           this.id = id;
           this.ijoplotes = ijoplotes;
    }


    /**
     * Gets the id value for this Ijoplotesdet.
     * 
     * @return id
     */
    public idw.idwws.IjoplotesdetId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijoplotesdet.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjoplotesdetId id) {
        this.id = id;
    }


    /**
     * Gets the ijoplotes value for this Ijoplotesdet.
     * 
     * @return ijoplotes
     */
    public idw.idwws.Ijoplotes getIjoplotes() {
        return ijoplotes;
    }


    /**
     * Sets the ijoplotes value for this Ijoplotesdet.
     * 
     * @param ijoplotes
     */
    public void setIjoplotes(idw.idwws.Ijoplotes ijoplotes) {
        this.ijoplotes = ijoplotes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijoplotesdet)) return false;
        Ijoplotesdet other = (Ijoplotesdet) obj;
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
            ((this.ijoplotes==null && other.getIjoplotes()==null) || 
             (this.ijoplotes!=null &&
              this.ijoplotes.equals(other.getIjoplotes())));
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
        if (getIjoplotes() != null) {
            _hashCode += getIjoplotes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijoplotesdet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotesdet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotesdetId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoplotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoplotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotes"));
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
