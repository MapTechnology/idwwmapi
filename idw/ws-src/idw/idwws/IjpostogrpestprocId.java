/**
 * IjpostogrpestprocId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjpostogrpestprocId  implements java.io.Serializable {
    private java.lang.String cdgrupoestproc;

    private java.lang.String cdposto;

    public IjpostogrpestprocId() {
    }

    public IjpostogrpestprocId(
           java.lang.String cdgrupoestproc,
           java.lang.String cdposto) {
           this.cdgrupoestproc = cdgrupoestproc;
           this.cdposto = cdposto;
    }


    /**
     * Gets the cdgrupoestproc value for this IjpostogrpestprocId.
     * 
     * @return cdgrupoestproc
     */
    public java.lang.String getCdgrupoestproc() {
        return cdgrupoestproc;
    }


    /**
     * Sets the cdgrupoestproc value for this IjpostogrpestprocId.
     * 
     * @param cdgrupoestproc
     */
    public void setCdgrupoestproc(java.lang.String cdgrupoestproc) {
        this.cdgrupoestproc = cdgrupoestproc;
    }


    /**
     * Gets the cdposto value for this IjpostogrpestprocId.
     * 
     * @return cdposto
     */
    public java.lang.String getCdposto() {
        return cdposto;
    }


    /**
     * Sets the cdposto value for this IjpostogrpestprocId.
     * 
     * @param cdposto
     */
    public void setCdposto(java.lang.String cdposto) {
        this.cdposto = cdposto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjpostogrpestprocId)) return false;
        IjpostogrpestprocId other = (IjpostogrpestprocId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrupoestproc==null && other.getCdgrupoestproc()==null) || 
             (this.cdgrupoestproc!=null &&
              this.cdgrupoestproc.equals(other.getCdgrupoestproc()))) &&
            ((this.cdposto==null && other.getCdposto()==null) || 
             (this.cdposto!=null &&
              this.cdposto.equals(other.getCdposto())));
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
        if (getCdgrupoestproc() != null) {
            _hashCode += getCdgrupoestproc().hashCode();
        }
        if (getCdposto() != null) {
            _hashCode += getCdposto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjpostogrpestprocId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpostogrpestprocId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrupoestproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrupoestproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdposto"));
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
