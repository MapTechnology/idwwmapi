/**
 * Ijpdcafiltroproj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijpdcafiltroproj  implements java.io.Serializable {
    private idw.idwws.IjpdcafiltroprojId id;

    private idw.idwws.Ijpdcaprojeto ijpdcaprojeto;

    public Ijpdcafiltroproj() {
    }

    public Ijpdcafiltroproj(
           idw.idwws.IjpdcafiltroprojId id,
           idw.idwws.Ijpdcaprojeto ijpdcaprojeto) {
           this.id = id;
           this.ijpdcaprojeto = ijpdcaprojeto;
    }


    /**
     * Gets the id value for this Ijpdcafiltroproj.
     * 
     * @return id
     */
    public idw.idwws.IjpdcafiltroprojId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijpdcafiltroproj.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjpdcafiltroprojId id) {
        this.id = id;
    }


    /**
     * Gets the ijpdcaprojeto value for this Ijpdcafiltroproj.
     * 
     * @return ijpdcaprojeto
     */
    public idw.idwws.Ijpdcaprojeto getIjpdcaprojeto() {
        return ijpdcaprojeto;
    }


    /**
     * Sets the ijpdcaprojeto value for this Ijpdcafiltroproj.
     * 
     * @param ijpdcaprojeto
     */
    public void setIjpdcaprojeto(idw.idwws.Ijpdcaprojeto ijpdcaprojeto) {
        this.ijpdcaprojeto = ijpdcaprojeto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijpdcafiltroproj)) return false;
        Ijpdcafiltroproj other = (Ijpdcafiltroproj) obj;
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
            ((this.ijpdcaprojeto==null && other.getIjpdcaprojeto()==null) || 
             (this.ijpdcaprojeto!=null &&
              this.ijpdcaprojeto.equals(other.getIjpdcaprojeto())));
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
        if (getIjpdcaprojeto() != null) {
            _hashCode += getIjpdcaprojeto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijpdcafiltroproj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcafiltroproj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcafiltroprojId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaprojeto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaprojeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaprojeto"));
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
