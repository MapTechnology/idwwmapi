/**
 * IjgrpfiltroId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjgrpfiltroId  implements java.io.Serializable {
    private java.lang.String cdcontprinc;

    private java.lang.String cdcontsec;

    private java.lang.String cdtipofiltprinc;

    private java.lang.String cdtipofiltsec;

    public IjgrpfiltroId() {
    }

    public IjgrpfiltroId(
           java.lang.String cdcontprinc,
           java.lang.String cdcontsec,
           java.lang.String cdtipofiltprinc,
           java.lang.String cdtipofiltsec) {
           this.cdcontprinc = cdcontprinc;
           this.cdcontsec = cdcontsec;
           this.cdtipofiltprinc = cdtipofiltprinc;
           this.cdtipofiltsec = cdtipofiltsec;
    }


    /**
     * Gets the cdcontprinc value for this IjgrpfiltroId.
     * 
     * @return cdcontprinc
     */
    public java.lang.String getCdcontprinc() {
        return cdcontprinc;
    }


    /**
     * Sets the cdcontprinc value for this IjgrpfiltroId.
     * 
     * @param cdcontprinc
     */
    public void setCdcontprinc(java.lang.String cdcontprinc) {
        this.cdcontprinc = cdcontprinc;
    }


    /**
     * Gets the cdcontsec value for this IjgrpfiltroId.
     * 
     * @return cdcontsec
     */
    public java.lang.String getCdcontsec() {
        return cdcontsec;
    }


    /**
     * Sets the cdcontsec value for this IjgrpfiltroId.
     * 
     * @param cdcontsec
     */
    public void setCdcontsec(java.lang.String cdcontsec) {
        this.cdcontsec = cdcontsec;
    }


    /**
     * Gets the cdtipofiltprinc value for this IjgrpfiltroId.
     * 
     * @return cdtipofiltprinc
     */
    public java.lang.String getCdtipofiltprinc() {
        return cdtipofiltprinc;
    }


    /**
     * Sets the cdtipofiltprinc value for this IjgrpfiltroId.
     * 
     * @param cdtipofiltprinc
     */
    public void setCdtipofiltprinc(java.lang.String cdtipofiltprinc) {
        this.cdtipofiltprinc = cdtipofiltprinc;
    }


    /**
     * Gets the cdtipofiltsec value for this IjgrpfiltroId.
     * 
     * @return cdtipofiltsec
     */
    public java.lang.String getCdtipofiltsec() {
        return cdtipofiltsec;
    }


    /**
     * Sets the cdtipofiltsec value for this IjgrpfiltroId.
     * 
     * @param cdtipofiltsec
     */
    public void setCdtipofiltsec(java.lang.String cdtipofiltsec) {
        this.cdtipofiltsec = cdtipofiltsec;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjgrpfiltroId)) return false;
        IjgrpfiltroId other = (IjgrpfiltroId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcontprinc==null && other.getCdcontprinc()==null) || 
             (this.cdcontprinc!=null &&
              this.cdcontprinc.equals(other.getCdcontprinc()))) &&
            ((this.cdcontsec==null && other.getCdcontsec()==null) || 
             (this.cdcontsec!=null &&
              this.cdcontsec.equals(other.getCdcontsec()))) &&
            ((this.cdtipofiltprinc==null && other.getCdtipofiltprinc()==null) || 
             (this.cdtipofiltprinc!=null &&
              this.cdtipofiltprinc.equals(other.getCdtipofiltprinc()))) &&
            ((this.cdtipofiltsec==null && other.getCdtipofiltsec()==null) || 
             (this.cdtipofiltsec!=null &&
              this.cdtipofiltsec.equals(other.getCdtipofiltsec())));
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
        if (getCdcontprinc() != null) {
            _hashCode += getCdcontprinc().hashCode();
        }
        if (getCdcontsec() != null) {
            _hashCode += getCdcontsec().hashCode();
        }
        if (getCdtipofiltprinc() != null) {
            _hashCode += getCdtipofiltprinc().hashCode();
        }
        if (getCdtipofiltsec() != null) {
            _hashCode += getCdtipofiltsec().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjgrpfiltroId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpfiltroId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcontprinc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcontprinc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcontsec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcontsec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipofiltprinc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipofiltprinc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipofiltsec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipofiltsec"));
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
