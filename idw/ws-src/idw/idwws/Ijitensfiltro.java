/**
 * Ijitensfiltro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijitensfiltro  implements java.io.Serializable {
    private idw.idwws.IjitensfiltroId id;

    private idw.idwws.Ijfiltroitensmen ijfiltroitensmen;

    private idw.idwws.Ijtbtipofiltro ijtbtipofiltro;

    public Ijitensfiltro() {
    }

    public Ijitensfiltro(
           idw.idwws.IjitensfiltroId id,
           idw.idwws.Ijfiltroitensmen ijfiltroitensmen,
           idw.idwws.Ijtbtipofiltro ijtbtipofiltro) {
           this.id = id;
           this.ijfiltroitensmen = ijfiltroitensmen;
           this.ijtbtipofiltro = ijtbtipofiltro;
    }


    /**
     * Gets the id value for this Ijitensfiltro.
     * 
     * @return id
     */
    public idw.idwws.IjitensfiltroId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijitensfiltro.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjitensfiltroId id) {
        this.id = id;
    }


    /**
     * Gets the ijfiltroitensmen value for this Ijitensfiltro.
     * 
     * @return ijfiltroitensmen
     */
    public idw.idwws.Ijfiltroitensmen getIjfiltroitensmen() {
        return ijfiltroitensmen;
    }


    /**
     * Sets the ijfiltroitensmen value for this Ijitensfiltro.
     * 
     * @param ijfiltroitensmen
     */
    public void setIjfiltroitensmen(idw.idwws.Ijfiltroitensmen ijfiltroitensmen) {
        this.ijfiltroitensmen = ijfiltroitensmen;
    }


    /**
     * Gets the ijtbtipofiltro value for this Ijitensfiltro.
     * 
     * @return ijtbtipofiltro
     */
    public idw.idwws.Ijtbtipofiltro getIjtbtipofiltro() {
        return ijtbtipofiltro;
    }


    /**
     * Sets the ijtbtipofiltro value for this Ijitensfiltro.
     * 
     * @param ijtbtipofiltro
     */
    public void setIjtbtipofiltro(idw.idwws.Ijtbtipofiltro ijtbtipofiltro) {
        this.ijtbtipofiltro = ijtbtipofiltro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijitensfiltro)) return false;
        Ijitensfiltro other = (Ijitensfiltro) obj;
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
            ((this.ijfiltroitensmen==null && other.getIjfiltroitensmen()==null) || 
             (this.ijfiltroitensmen!=null &&
              this.ijfiltroitensmen.equals(other.getIjfiltroitensmen()))) &&
            ((this.ijtbtipofiltro==null && other.getIjtbtipofiltro()==null) || 
             (this.ijtbtipofiltro!=null &&
              this.ijtbtipofiltro.equals(other.getIjtbtipofiltro())));
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
        if (getIjfiltroitensmen() != null) {
            _hashCode += getIjfiltroitensmen().hashCode();
        }
        if (getIjtbtipofiltro() != null) {
            _hashCode += getIjtbtipofiltro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijitensfiltro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijitensfiltro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijitensfiltroId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfiltroitensmen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfiltroitensmen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltroitensmen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtipofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtipofiltro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipofiltro"));
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
