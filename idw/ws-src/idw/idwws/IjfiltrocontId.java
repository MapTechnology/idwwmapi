/**
 * IjfiltrocontId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjfiltrocontId  implements java.io.Serializable {
    private java.lang.String cdcont;

    private java.lang.String cdtipofiltro;

    public IjfiltrocontId() {
    }

    public IjfiltrocontId(
           java.lang.String cdcont,
           java.lang.String cdtipofiltro) {
           this.cdcont = cdcont;
           this.cdtipofiltro = cdtipofiltro;
    }


    /**
     * Gets the cdcont value for this IjfiltrocontId.
     * 
     * @return cdcont
     */
    public java.lang.String getCdcont() {
        return cdcont;
    }


    /**
     * Sets the cdcont value for this IjfiltrocontId.
     * 
     * @param cdcont
     */
    public void setCdcont(java.lang.String cdcont) {
        this.cdcont = cdcont;
    }


    /**
     * Gets the cdtipofiltro value for this IjfiltrocontId.
     * 
     * @return cdtipofiltro
     */
    public java.lang.String getCdtipofiltro() {
        return cdtipofiltro;
    }


    /**
     * Sets the cdtipofiltro value for this IjfiltrocontId.
     * 
     * @param cdtipofiltro
     */
    public void setCdtipofiltro(java.lang.String cdtipofiltro) {
        this.cdtipofiltro = cdtipofiltro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjfiltrocontId)) return false;
        IjfiltrocontId other = (IjfiltrocontId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcont==null && other.getCdcont()==null) || 
             (this.cdcont!=null &&
              this.cdcont.equals(other.getCdcont()))) &&
            ((this.cdtipofiltro==null && other.getCdtipofiltro()==null) || 
             (this.cdtipofiltro!=null &&
              this.cdtipofiltro.equals(other.getCdtipofiltro())));
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
        if (getCdcont() != null) {
            _hashCode += getCdcont().hashCode();
        }
        if (getCdtipofiltro() != null) {
            _hashCode += getCdtipofiltro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjfiltrocontId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltrocontId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipofiltro"));
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
