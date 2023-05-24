/**
 * IjgrpparaminspxordId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjgrpparaminspxordId  implements java.io.Serializable {
    private java.lang.String cdgrpparam;

    private java.lang.String idespecific;

    public IjgrpparaminspxordId() {
    }

    public IjgrpparaminspxordId(
           java.lang.String cdgrpparam,
           java.lang.String idespecific) {
           this.cdgrpparam = cdgrpparam;
           this.idespecific = idespecific;
    }


    /**
     * Gets the cdgrpparam value for this IjgrpparaminspxordId.
     * 
     * @return cdgrpparam
     */
    public java.lang.String getCdgrpparam() {
        return cdgrpparam;
    }


    /**
     * Sets the cdgrpparam value for this IjgrpparaminspxordId.
     * 
     * @param cdgrpparam
     */
    public void setCdgrpparam(java.lang.String cdgrpparam) {
        this.cdgrpparam = cdgrpparam;
    }


    /**
     * Gets the idespecific value for this IjgrpparaminspxordId.
     * 
     * @return idespecific
     */
    public java.lang.String getIdespecific() {
        return idespecific;
    }


    /**
     * Sets the idespecific value for this IjgrpparaminspxordId.
     * 
     * @param idespecific
     */
    public void setIdespecific(java.lang.String idespecific) {
        this.idespecific = idespecific;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjgrpparaminspxordId)) return false;
        IjgrpparaminspxordId other = (IjgrpparaminspxordId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrpparam==null && other.getCdgrpparam()==null) || 
             (this.cdgrpparam!=null &&
              this.cdgrpparam.equals(other.getCdgrpparam()))) &&
            ((this.idespecific==null && other.getIdespecific()==null) || 
             (this.idespecific!=null &&
              this.idespecific.equals(other.getIdespecific())));
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
        if (getCdgrpparam() != null) {
            _hashCode += getCdgrpparam().hashCode();
        }
        if (getIdespecific() != null) {
            _hashCode += getIdespecific().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjgrpparaminspxordId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminspxordId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrpparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrpparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idespecific"));
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
