/**
 * Ijtbsubcoletores.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbsubcoletores  implements java.io.Serializable {
    private idw.idwws.IjtbsubcoletoresId id;

    private idw.idwws.Ijtbcoletores ijtbcoletores;

    public Ijtbsubcoletores() {
    }

    public Ijtbsubcoletores(
           idw.idwws.IjtbsubcoletoresId id,
           idw.idwws.Ijtbcoletores ijtbcoletores) {
           this.id = id;
           this.ijtbcoletores = ijtbcoletores;
    }


    /**
     * Gets the id value for this Ijtbsubcoletores.
     * 
     * @return id
     */
    public idw.idwws.IjtbsubcoletoresId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbsubcoletores.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbsubcoletoresId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbcoletores value for this Ijtbsubcoletores.
     * 
     * @return ijtbcoletores
     */
    public idw.idwws.Ijtbcoletores getIjtbcoletores() {
        return ijtbcoletores;
    }


    /**
     * Sets the ijtbcoletores value for this Ijtbsubcoletores.
     * 
     * @param ijtbcoletores
     */
    public void setIjtbcoletores(idw.idwws.Ijtbcoletores ijtbcoletores) {
        this.ijtbcoletores = ijtbcoletores;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbsubcoletores)) return false;
        Ijtbsubcoletores other = (Ijtbsubcoletores) obj;
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
            ((this.ijtbcoletores==null && other.getIjtbcoletores()==null) || 
             (this.ijtbcoletores!=null &&
              this.ijtbcoletores.equals(other.getIjtbcoletores())));
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
        if (getIjtbcoletores() != null) {
            _hashCode += getIjtbcoletores().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbsubcoletores.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbsubcoletores"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbsubcoletoresId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcoletores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcoletores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcoletores"));
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
