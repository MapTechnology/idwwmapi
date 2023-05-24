/**
 * Ijgrpfiltro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpfiltro  implements java.io.Serializable {
    private idw.idwws.IjgrpfiltroId id;

    private idw.idwws.Ijfiltrocont ijfiltrocontBySysC0013021;

    private idw.idwws.Ijfiltrocont ijfiltrocontBySysC0013022;

    public Ijgrpfiltro() {
    }

    public Ijgrpfiltro(
           idw.idwws.IjgrpfiltroId id,
           idw.idwws.Ijfiltrocont ijfiltrocontBySysC0013021,
           idw.idwws.Ijfiltrocont ijfiltrocontBySysC0013022) {
           this.id = id;
           this.ijfiltrocontBySysC0013021 = ijfiltrocontBySysC0013021;
           this.ijfiltrocontBySysC0013022 = ijfiltrocontBySysC0013022;
    }


    /**
     * Gets the id value for this Ijgrpfiltro.
     * 
     * @return id
     */
    public idw.idwws.IjgrpfiltroId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpfiltro.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpfiltroId id) {
        this.id = id;
    }


    /**
     * Gets the ijfiltrocontBySysC0013021 value for this Ijgrpfiltro.
     * 
     * @return ijfiltrocontBySysC0013021
     */
    public idw.idwws.Ijfiltrocont getIjfiltrocontBySysC0013021() {
        return ijfiltrocontBySysC0013021;
    }


    /**
     * Sets the ijfiltrocontBySysC0013021 value for this Ijgrpfiltro.
     * 
     * @param ijfiltrocontBySysC0013021
     */
    public void setIjfiltrocontBySysC0013021(idw.idwws.Ijfiltrocont ijfiltrocontBySysC0013021) {
        this.ijfiltrocontBySysC0013021 = ijfiltrocontBySysC0013021;
    }


    /**
     * Gets the ijfiltrocontBySysC0013022 value for this Ijgrpfiltro.
     * 
     * @return ijfiltrocontBySysC0013022
     */
    public idw.idwws.Ijfiltrocont getIjfiltrocontBySysC0013022() {
        return ijfiltrocontBySysC0013022;
    }


    /**
     * Sets the ijfiltrocontBySysC0013022 value for this Ijgrpfiltro.
     * 
     * @param ijfiltrocontBySysC0013022
     */
    public void setIjfiltrocontBySysC0013022(idw.idwws.Ijfiltrocont ijfiltrocontBySysC0013022) {
        this.ijfiltrocontBySysC0013022 = ijfiltrocontBySysC0013022;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpfiltro)) return false;
        Ijgrpfiltro other = (Ijgrpfiltro) obj;
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
            ((this.ijfiltrocontBySysC0013021==null && other.getIjfiltrocontBySysC0013021()==null) || 
             (this.ijfiltrocontBySysC0013021!=null &&
              this.ijfiltrocontBySysC0013021.equals(other.getIjfiltrocontBySysC0013021()))) &&
            ((this.ijfiltrocontBySysC0013022==null && other.getIjfiltrocontBySysC0013022()==null) || 
             (this.ijfiltrocontBySysC0013022!=null &&
              this.ijfiltrocontBySysC0013022.equals(other.getIjfiltrocontBySysC0013022())));
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
        if (getIjfiltrocontBySysC0013021() != null) {
            _hashCode += getIjfiltrocontBySysC0013021().hashCode();
        }
        if (getIjfiltrocontBySysC0013022() != null) {
            _hashCode += getIjfiltrocontBySysC0013022().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpfiltro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpfiltro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpfiltroId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfiltrocontBySysC0013021");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfiltrocontBySysC0013021"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltrocont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfiltrocontBySysC0013022");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfiltrocontBySysC0013022"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltrocont"));
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
