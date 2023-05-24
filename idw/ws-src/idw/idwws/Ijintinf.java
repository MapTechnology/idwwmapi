/**
 * Ijintinf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijintinf  implements java.io.Serializable {
    private idw.idwws.IjintinfId id;

    private idw.idwws.Ijtbinf ijtbinf;

    private idw.idwws.Ijtbintemail ijtbintemail;

    public Ijintinf() {
    }

    public Ijintinf(
           idw.idwws.IjintinfId id,
           idw.idwws.Ijtbinf ijtbinf,
           idw.idwws.Ijtbintemail ijtbintemail) {
           this.id = id;
           this.ijtbinf = ijtbinf;
           this.ijtbintemail = ijtbintemail;
    }


    /**
     * Gets the id value for this Ijintinf.
     * 
     * @return id
     */
    public idw.idwws.IjintinfId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijintinf.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjintinfId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinf value for this Ijintinf.
     * 
     * @return ijtbinf
     */
    public idw.idwws.Ijtbinf getIjtbinf() {
        return ijtbinf;
    }


    /**
     * Sets the ijtbinf value for this Ijintinf.
     * 
     * @param ijtbinf
     */
    public void setIjtbinf(idw.idwws.Ijtbinf ijtbinf) {
        this.ijtbinf = ijtbinf;
    }


    /**
     * Gets the ijtbintemail value for this Ijintinf.
     * 
     * @return ijtbintemail
     */
    public idw.idwws.Ijtbintemail getIjtbintemail() {
        return ijtbintemail;
    }


    /**
     * Sets the ijtbintemail value for this Ijintinf.
     * 
     * @param ijtbintemail
     */
    public void setIjtbintemail(idw.idwws.Ijtbintemail ijtbintemail) {
        this.ijtbintemail = ijtbintemail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijintinf)) return false;
        Ijintinf other = (Ijintinf) obj;
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
            ((this.ijtbinf==null && other.getIjtbinf()==null) || 
             (this.ijtbinf!=null &&
              this.ijtbinf.equals(other.getIjtbinf()))) &&
            ((this.ijtbintemail==null && other.getIjtbintemail()==null) || 
             (this.ijtbintemail!=null &&
              this.ijtbintemail.equals(other.getIjtbintemail())));
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
        if (getIjtbinf() != null) {
            _hashCode += getIjtbinf().hashCode();
        }
        if (getIjtbintemail() != null) {
            _hashCode += getIjtbintemail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijintinf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijintinf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijintinfId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbintemail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbintemail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbintemail"));
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
