/**
 * Ijficinj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijficinj  implements java.io.Serializable {
    private idw.idwws.IjficinjId id;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbitemcnc ijtbitemcnc;

    public Ijficinj() {
    }

    public Ijficinj(
           idw.idwws.IjficinjId id,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbitemcnc ijtbitemcnc) {
           this.id = id;
           this.ijtbinj = ijtbinj;
           this.ijtbitemcnc = ijtbitemcnc;
    }


    /**
     * Gets the id value for this Ijficinj.
     * 
     * @return id
     */
    public idw.idwws.IjficinjId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijficinj.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjficinjId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinj value for this Ijficinj.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijficinj.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbitemcnc value for this Ijficinj.
     * 
     * @return ijtbitemcnc
     */
    public idw.idwws.Ijtbitemcnc getIjtbitemcnc() {
        return ijtbitemcnc;
    }


    /**
     * Sets the ijtbitemcnc value for this Ijficinj.
     * 
     * @param ijtbitemcnc
     */
    public void setIjtbitemcnc(idw.idwws.Ijtbitemcnc ijtbitemcnc) {
        this.ijtbitemcnc = ijtbitemcnc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijficinj)) return false;
        Ijficinj other = (Ijficinj) obj;
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
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbitemcnc==null && other.getIjtbitemcnc()==null) || 
             (this.ijtbitemcnc!=null &&
              this.ijtbitemcnc.equals(other.getIjtbitemcnc())));
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
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbitemcnc() != null) {
            _hashCode += getIjtbitemcnc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijficinj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficinj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficinjId"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbitemcnc"));
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
