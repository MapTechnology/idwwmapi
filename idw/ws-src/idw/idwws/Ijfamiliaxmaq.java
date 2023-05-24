/**
 * Ijfamiliaxmaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfamiliaxmaq  implements java.io.Serializable {
    private idw.idwws.IjfamiliaxmaqId id;

    private idw.idwws.Ijtbfamiliamaq ijtbfamiliamaq;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijfamiliaxmaq() {
    }

    public Ijfamiliaxmaq(
           idw.idwws.IjfamiliaxmaqId id,
           idw.idwws.Ijtbfamiliamaq ijtbfamiliamaq,
           idw.idwws.Ijtbinj ijtbinj) {
           this.id = id;
           this.ijtbfamiliamaq = ijtbfamiliamaq;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the id value for this Ijfamiliaxmaq.
     * 
     * @return id
     */
    public idw.idwws.IjfamiliaxmaqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijfamiliaxmaq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjfamiliaxmaqId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbfamiliamaq value for this Ijfamiliaxmaq.
     * 
     * @return ijtbfamiliamaq
     */
    public idw.idwws.Ijtbfamiliamaq getIjtbfamiliamaq() {
        return ijtbfamiliamaq;
    }


    /**
     * Sets the ijtbfamiliamaq value for this Ijfamiliaxmaq.
     * 
     * @param ijtbfamiliamaq
     */
    public void setIjtbfamiliamaq(idw.idwws.Ijtbfamiliamaq ijtbfamiliamaq) {
        this.ijtbfamiliamaq = ijtbfamiliamaq;
    }


    /**
     * Gets the ijtbinj value for this Ijfamiliaxmaq.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijfamiliaxmaq.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfamiliaxmaq)) return false;
        Ijfamiliaxmaq other = (Ijfamiliaxmaq) obj;
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
            ((this.ijtbfamiliamaq==null && other.getIjtbfamiliamaq()==null) || 
             (this.ijtbfamiliamaq!=null &&
              this.ijtbfamiliamaq.equals(other.getIjtbfamiliamaq()))) &&
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
        if (getIjtbfamiliamaq() != null) {
            _hashCode += getIjtbfamiliamaq().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfamiliaxmaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfamiliaxmaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfamiliaxmaqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbfamiliamaq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbfamiliamaq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbfamiliamaq"));
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
