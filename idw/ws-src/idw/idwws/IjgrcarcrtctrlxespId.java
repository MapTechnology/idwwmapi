/**
 * IjgrcarcrtctrlxespId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjgrcarcrtctrlxespId  implements java.io.Serializable {
    private java.lang.String cdgrproctrctrl;

    private java.lang.String idespecific;

    public IjgrcarcrtctrlxespId() {
    }

    public IjgrcarcrtctrlxespId(
           java.lang.String cdgrproctrctrl,
           java.lang.String idespecific) {
           this.cdgrproctrctrl = cdgrproctrctrl;
           this.idespecific = idespecific;
    }


    /**
     * Gets the cdgrproctrctrl value for this IjgrcarcrtctrlxespId.
     * 
     * @return cdgrproctrctrl
     */
    public java.lang.String getCdgrproctrctrl() {
        return cdgrproctrctrl;
    }


    /**
     * Sets the cdgrproctrctrl value for this IjgrcarcrtctrlxespId.
     * 
     * @param cdgrproctrctrl
     */
    public void setCdgrproctrctrl(java.lang.String cdgrproctrctrl) {
        this.cdgrproctrctrl = cdgrproctrctrl;
    }


    /**
     * Gets the idespecific value for this IjgrcarcrtctrlxespId.
     * 
     * @return idespecific
     */
    public java.lang.String getIdespecific() {
        return idespecific;
    }


    /**
     * Sets the idespecific value for this IjgrcarcrtctrlxespId.
     * 
     * @param idespecific
     */
    public void setIdespecific(java.lang.String idespecific) {
        this.idespecific = idespecific;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjgrcarcrtctrlxespId)) return false;
        IjgrcarcrtctrlxespId other = (IjgrcarcrtctrlxespId) obj;
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
        if (getCdgrproctrctrl() != null) {
            _hashCode += getCdgrproctrctrl().hashCode();
        }
        if (getIdespecific() != null) {
            _hashCode += getIdespecific().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjgrcarcrtctrlxespId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrcarcrtctrlxespId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrproctrctrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrproctrctrl"));
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
