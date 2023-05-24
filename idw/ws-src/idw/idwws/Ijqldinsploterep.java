/**
 * Ijqldinsploterep.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijqldinsploterep  implements java.io.Serializable {
    private idw.idwws.IjqldinsploterepId id;

    private idw.idwws.Ijqldprodinsplote ijqldprodinsplote;

    private idw.idwws.Ijtbref ijtbref;

    public Ijqldinsploterep() {
    }

    public Ijqldinsploterep(
           idw.idwws.IjqldinsploterepId id,
           idw.idwws.Ijqldprodinsplote ijqldprodinsplote,
           idw.idwws.Ijtbref ijtbref) {
           this.id = id;
           this.ijqldprodinsplote = ijqldprodinsplote;
           this.ijtbref = ijtbref;
    }


    /**
     * Gets the id value for this Ijqldinsploterep.
     * 
     * @return id
     */
    public idw.idwws.IjqldinsploterepId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijqldinsploterep.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjqldinsploterepId id) {
        this.id = id;
    }


    /**
     * Gets the ijqldprodinsplote value for this Ijqldinsploterep.
     * 
     * @return ijqldprodinsplote
     */
    public idw.idwws.Ijqldprodinsplote getIjqldprodinsplote() {
        return ijqldprodinsplote;
    }


    /**
     * Sets the ijqldprodinsplote value for this Ijqldinsploterep.
     * 
     * @param ijqldprodinsplote
     */
    public void setIjqldprodinsplote(idw.idwws.Ijqldprodinsplote ijqldprodinsplote) {
        this.ijqldprodinsplote = ijqldprodinsplote;
    }


    /**
     * Gets the ijtbref value for this Ijqldinsploterep.
     * 
     * @return ijtbref
     */
    public idw.idwws.Ijtbref getIjtbref() {
        return ijtbref;
    }


    /**
     * Sets the ijtbref value for this Ijqldinsploterep.
     * 
     * @param ijtbref
     */
    public void setIjtbref(idw.idwws.Ijtbref ijtbref) {
        this.ijtbref = ijtbref;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijqldinsploterep)) return false;
        Ijqldinsploterep other = (Ijqldinsploterep) obj;
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
            ((this.ijqldprodinsplote==null && other.getIjqldprodinsplote()==null) || 
             (this.ijqldprodinsplote!=null &&
              this.ijqldprodinsplote.equals(other.getIjqldprodinsplote()))) &&
            ((this.ijtbref==null && other.getIjtbref()==null) || 
             (this.ijtbref!=null &&
              this.ijtbref.equals(other.getIjtbref())));
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
        if (getIjqldprodinsplote() != null) {
            _hashCode += getIjqldprodinsplote().hashCode();
        }
        if (getIjtbref() != null) {
            _hashCode += getIjtbref().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijqldinsploterep.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldinsploterep"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldinsploterepId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldprodinsplote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldprodinsplote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldprodinsplote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbref");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbref"));
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
