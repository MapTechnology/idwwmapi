/**
 * IjmatrizsetupId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmatrizsetupId  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cdmoldeentra;

    private java.lang.String cdmoldesai;

    public IjmatrizsetupId() {
    }

    public IjmatrizsetupId(
           java.lang.String cdinjetora,
           java.lang.String cdmoldeentra,
           java.lang.String cdmoldesai) {
           this.cdinjetora = cdinjetora;
           this.cdmoldeentra = cdmoldeentra;
           this.cdmoldesai = cdmoldesai;
    }


    /**
     * Gets the cdinjetora value for this IjmatrizsetupId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjmatrizsetupId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdmoldeentra value for this IjmatrizsetupId.
     * 
     * @return cdmoldeentra
     */
    public java.lang.String getCdmoldeentra() {
        return cdmoldeentra;
    }


    /**
     * Sets the cdmoldeentra value for this IjmatrizsetupId.
     * 
     * @param cdmoldeentra
     */
    public void setCdmoldeentra(java.lang.String cdmoldeentra) {
        this.cdmoldeentra = cdmoldeentra;
    }


    /**
     * Gets the cdmoldesai value for this IjmatrizsetupId.
     * 
     * @return cdmoldesai
     */
    public java.lang.String getCdmoldesai() {
        return cdmoldesai;
    }


    /**
     * Sets the cdmoldesai value for this IjmatrizsetupId.
     * 
     * @param cdmoldesai
     */
    public void setCdmoldesai(java.lang.String cdmoldesai) {
        this.cdmoldesai = cdmoldesai;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmatrizsetupId)) return false;
        IjmatrizsetupId other = (IjmatrizsetupId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdmoldeentra==null && other.getCdmoldeentra()==null) || 
             (this.cdmoldeentra!=null &&
              this.cdmoldeentra.equals(other.getCdmoldeentra()))) &&
            ((this.cdmoldesai==null && other.getCdmoldesai()==null) || 
             (this.cdmoldesai!=null &&
              this.cdmoldesai.equals(other.getCdmoldesai())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdmoldeentra() != null) {
            _hashCode += getCdmoldeentra().hashCode();
        }
        if (getCdmoldesai() != null) {
            _hashCode += getCdmoldesai().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmatrizsetupId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmatrizsetupId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmoldeentra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmoldeentra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmoldesai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmoldesai"));
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
