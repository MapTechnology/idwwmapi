/**
 * IjmdoalocdetId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmdoalocdetId  implements java.io.Serializable {
    private java.lang.String cdcargo;

    private java.lang.String idmdoaloc;

    public IjmdoalocdetId() {
    }

    public IjmdoalocdetId(
           java.lang.String cdcargo,
           java.lang.String idmdoaloc) {
           this.cdcargo = cdcargo;
           this.idmdoaloc = idmdoaloc;
    }


    /**
     * Gets the cdcargo value for this IjmdoalocdetId.
     * 
     * @return cdcargo
     */
    public java.lang.String getCdcargo() {
        return cdcargo;
    }


    /**
     * Sets the cdcargo value for this IjmdoalocdetId.
     * 
     * @param cdcargo
     */
    public void setCdcargo(java.lang.String cdcargo) {
        this.cdcargo = cdcargo;
    }


    /**
     * Gets the idmdoaloc value for this IjmdoalocdetId.
     * 
     * @return idmdoaloc
     */
    public java.lang.String getIdmdoaloc() {
        return idmdoaloc;
    }


    /**
     * Sets the idmdoaloc value for this IjmdoalocdetId.
     * 
     * @param idmdoaloc
     */
    public void setIdmdoaloc(java.lang.String idmdoaloc) {
        this.idmdoaloc = idmdoaloc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmdoalocdetId)) return false;
        IjmdoalocdetId other = (IjmdoalocdetId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcargo==null && other.getCdcargo()==null) || 
             (this.cdcargo!=null &&
              this.cdcargo.equals(other.getCdcargo()))) &&
            ((this.idmdoaloc==null && other.getIdmdoaloc()==null) || 
             (this.idmdoaloc!=null &&
              this.idmdoaloc.equals(other.getIdmdoaloc())));
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
        if (getCdcargo() != null) {
            _hashCode += getCdcargo().hashCode();
        }
        if (getIdmdoaloc() != null) {
            _hashCode += getIdmdoaloc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmdoalocdetId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocdetId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcargo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idmdoaloc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idmdoaloc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
