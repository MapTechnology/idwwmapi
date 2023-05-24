/**
 * Ijgrpdetmol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpdetmol  implements java.io.Serializable {
    private idw.idwws.IjgrpdetmolId id;

    private idw.idwws.Ijgrpmol ijgrpmol;

    private idw.idwws.Ijtbmol ijtbmol;

    public Ijgrpdetmol() {
    }

    public Ijgrpdetmol(
           idw.idwws.IjgrpdetmolId id,
           idw.idwws.Ijgrpmol ijgrpmol,
           idw.idwws.Ijtbmol ijtbmol) {
           this.id = id;
           this.ijgrpmol = ijgrpmol;
           this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the id value for this Ijgrpdetmol.
     * 
     * @return id
     */
    public idw.idwws.IjgrpdetmolId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpdetmol.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpdetmolId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpmol value for this Ijgrpdetmol.
     * 
     * @return ijgrpmol
     */
    public idw.idwws.Ijgrpmol getIjgrpmol() {
        return ijgrpmol;
    }


    /**
     * Sets the ijgrpmol value for this Ijgrpdetmol.
     * 
     * @param ijgrpmol
     */
    public void setIjgrpmol(idw.idwws.Ijgrpmol ijgrpmol) {
        this.ijgrpmol = ijgrpmol;
    }


    /**
     * Gets the ijtbmol value for this Ijgrpdetmol.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijgrpdetmol.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpdetmol)) return false;
        Ijgrpdetmol other = (Ijgrpdetmol) obj;
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
            ((this.ijgrpmol==null && other.getIjgrpmol()==null) || 
             (this.ijgrpmol!=null &&
              this.ijgrpmol.equals(other.getIjgrpmol()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol())));
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
        if (getIjgrpmol() != null) {
            _hashCode += getIjgrpmol().hashCode();
        }
        if (getIjtbmol() != null) {
            _hashCode += getIjtbmol().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpdetmol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetmol"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetmolId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
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
