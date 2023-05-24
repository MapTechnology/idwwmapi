/**
 * Ijtbtpocorea.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtpocorea  implements java.io.Serializable {
    private java.lang.String dstipooco;

    private idw.idwws.IjtbtpocoreaId id;

    private idw.idwws.Ijlinguas ijlinguas;

    public Ijtbtpocorea() {
    }

    public Ijtbtpocorea(
           java.lang.String dstipooco,
           idw.idwws.IjtbtpocoreaId id,
           idw.idwws.Ijlinguas ijlinguas) {
           this.dstipooco = dstipooco;
           this.id = id;
           this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the dstipooco value for this Ijtbtpocorea.
     * 
     * @return dstipooco
     */
    public java.lang.String getDstipooco() {
        return dstipooco;
    }


    /**
     * Sets the dstipooco value for this Ijtbtpocorea.
     * 
     * @param dstipooco
     */
    public void setDstipooco(java.lang.String dstipooco) {
        this.dstipooco = dstipooco;
    }


    /**
     * Gets the id value for this Ijtbtpocorea.
     * 
     * @return id
     */
    public idw.idwws.IjtbtpocoreaId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbtpocorea.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbtpocoreaId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijtbtpocorea.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbtpocorea.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtpocorea)) return false;
        Ijtbtpocorea other = (Ijtbtpocorea) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dstipooco==null && other.getDstipooco()==null) || 
             (this.dstipooco!=null &&
              this.dstipooco.equals(other.getDstipooco()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas())));
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
        if (getDstipooco() != null) {
            _hashCode += getDstipooco().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtpocorea.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpocorea"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstipooco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstipooco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpocoreaId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
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
