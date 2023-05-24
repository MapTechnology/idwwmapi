/**
 * IjproxgrcarcrtctrlId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjproxgrcarcrtctrlId  implements java.io.Serializable {
    private java.lang.String cdgrproctrctrl;

    private java.lang.String cdproduto;

    public IjproxgrcarcrtctrlId() {
    }

    public IjproxgrcarcrtctrlId(
           java.lang.String cdgrproctrctrl,
           java.lang.String cdproduto) {
           this.cdgrproctrctrl = cdgrproctrctrl;
           this.cdproduto = cdproduto;
    }


    /**
     * Gets the cdgrproctrctrl value for this IjproxgrcarcrtctrlId.
     * 
     * @return cdgrproctrctrl
     */
    public java.lang.String getCdgrproctrctrl() {
        return cdgrproctrctrl;
    }


    /**
     * Sets the cdgrproctrctrl value for this IjproxgrcarcrtctrlId.
     * 
     * @param cdgrproctrctrl
     */
    public void setCdgrproctrctrl(java.lang.String cdgrproctrctrl) {
        this.cdgrproctrctrl = cdgrproctrctrl;
    }


    /**
     * Gets the cdproduto value for this IjproxgrcarcrtctrlId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjproxgrcarcrtctrlId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjproxgrcarcrtctrlId)) return false;
        IjproxgrcarcrtctrlId other = (IjproxgrcarcrtctrlId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrproctrctrl==null && other.getCdgrproctrctrl()==null) || 
             (this.cdgrproctrctrl!=null &&
              this.cdgrproctrctrl.equals(other.getCdgrproctrctrl()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto())));
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
        if (getCdgrproctrctrl() != null) {
            _hashCode += getCdgrproctrctrl().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjproxgrcarcrtctrlId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproxgrcarcrtctrlId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrproctrctrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrproctrctrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
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
