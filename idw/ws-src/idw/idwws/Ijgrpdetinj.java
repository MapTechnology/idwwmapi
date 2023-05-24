/**
 * Ijgrpdetinj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpdetinj  implements java.io.Serializable {
    private idw.idwws.IjgrpdetinjId id;

    private idw.idwws.Ijgrpinj ijgrpinj;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijgrpdetinj() {
    }

    public Ijgrpdetinj(
           idw.idwws.IjgrpdetinjId id,
           idw.idwws.Ijgrpinj ijgrpinj,
           idw.idwws.Ijtbinj ijtbinj) {
           this.id = id;
           this.ijgrpinj = ijgrpinj;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the id value for this Ijgrpdetinj.
     * 
     * @return id
     */
    public idw.idwws.IjgrpdetinjId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpdetinj.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpdetinjId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpinj value for this Ijgrpdetinj.
     * 
     * @return ijgrpinj
     */
    public idw.idwws.Ijgrpinj getIjgrpinj() {
        return ijgrpinj;
    }


    /**
     * Sets the ijgrpinj value for this Ijgrpdetinj.
     * 
     * @param ijgrpinj
     */
    public void setIjgrpinj(idw.idwws.Ijgrpinj ijgrpinj) {
        this.ijgrpinj = ijgrpinj;
    }


    /**
     * Gets the ijtbinj value for this Ijgrpdetinj.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijgrpdetinj.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpdetinj)) return false;
        Ijgrpdetinj other = (Ijgrpdetinj) obj;
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
            ((this.ijgrpinj==null && other.getIjgrpinj()==null) || 
             (this.ijgrpinj!=null &&
              this.ijgrpinj.equals(other.getIjgrpinj()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj())));
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
        if (getIjgrpinj() != null) {
            _hashCode += getIjgrpinj().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpdetinj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetinj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetinjId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
