/**
 * Ijparamitensarq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijparamitensarq  implements java.io.Serializable {
    private idw.idwws.IjparamitensarqId id;

    private idw.idwws.Ijselitensarq ijselitensarq;

    private idw.idwws.Ijtbparam ijtbparam;

    public Ijparamitensarq() {
    }

    public Ijparamitensarq(
           idw.idwws.IjparamitensarqId id,
           idw.idwws.Ijselitensarq ijselitensarq,
           idw.idwws.Ijtbparam ijtbparam) {
           this.id = id;
           this.ijselitensarq = ijselitensarq;
           this.ijtbparam = ijtbparam;
    }


    /**
     * Gets the id value for this Ijparamitensarq.
     * 
     * @return id
     */
    public idw.idwws.IjparamitensarqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijparamitensarq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjparamitensarqId id) {
        this.id = id;
    }


    /**
     * Gets the ijselitensarq value for this Ijparamitensarq.
     * 
     * @return ijselitensarq
     */
    public idw.idwws.Ijselitensarq getIjselitensarq() {
        return ijselitensarq;
    }


    /**
     * Sets the ijselitensarq value for this Ijparamitensarq.
     * 
     * @param ijselitensarq
     */
    public void setIjselitensarq(idw.idwws.Ijselitensarq ijselitensarq) {
        this.ijselitensarq = ijselitensarq;
    }


    /**
     * Gets the ijtbparam value for this Ijparamitensarq.
     * 
     * @return ijtbparam
     */
    public idw.idwws.Ijtbparam getIjtbparam() {
        return ijtbparam;
    }


    /**
     * Sets the ijtbparam value for this Ijparamitensarq.
     * 
     * @param ijtbparam
     */
    public void setIjtbparam(idw.idwws.Ijtbparam ijtbparam) {
        this.ijtbparam = ijtbparam;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijparamitensarq)) return false;
        Ijparamitensarq other = (Ijparamitensarq) obj;
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
            ((this.ijselitensarq==null && other.getIjselitensarq()==null) || 
             (this.ijselitensarq!=null &&
              this.ijselitensarq.equals(other.getIjselitensarq()))) &&
            ((this.ijtbparam==null && other.getIjtbparam()==null) || 
             (this.ijtbparam!=null &&
              this.ijtbparam.equals(other.getIjtbparam())));
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
        if (getIjselitensarq() != null) {
            _hashCode += getIjselitensarq().hashCode();
        }
        if (getIjtbparam() != null) {
            _hashCode += getIjtbparam().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijparamitensarq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparamitensarq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparamitensarqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselitensarq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselitensarq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensarq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbparam"));
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
