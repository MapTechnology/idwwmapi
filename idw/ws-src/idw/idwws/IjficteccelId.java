/**
 * IjficteccelId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjficteccelId  implements java.io.Serializable {
    private java.lang.String cdcelula;

    private java.util.Calendar dthrivalciccel;

    public IjficteccelId() {
    }

    public IjficteccelId(
           java.lang.String cdcelula,
           java.util.Calendar dthrivalciccel) {
           this.cdcelula = cdcelula;
           this.dthrivalciccel = dthrivalciccel;
    }


    /**
     * Gets the cdcelula value for this IjficteccelId.
     * 
     * @return cdcelula
     */
    public java.lang.String getCdcelula() {
        return cdcelula;
    }


    /**
     * Sets the cdcelula value for this IjficteccelId.
     * 
     * @param cdcelula
     */
    public void setCdcelula(java.lang.String cdcelula) {
        this.cdcelula = cdcelula;
    }


    /**
     * Gets the dthrivalciccel value for this IjficteccelId.
     * 
     * @return dthrivalciccel
     */
    public java.util.Calendar getDthrivalciccel() {
        return dthrivalciccel;
    }


    /**
     * Sets the dthrivalciccel value for this IjficteccelId.
     * 
     * @param dthrivalciccel
     */
    public void setDthrivalciccel(java.util.Calendar dthrivalciccel) {
        this.dthrivalciccel = dthrivalciccel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjficteccelId)) return false;
        IjficteccelId other = (IjficteccelId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcelula==null && other.getCdcelula()==null) || 
             (this.cdcelula!=null &&
              this.cdcelula.equals(other.getCdcelula()))) &&
            ((this.dthrivalciccel==null && other.getDthrivalciccel()==null) || 
             (this.dthrivalciccel!=null &&
              this.dthrivalciccel.equals(other.getDthrivalciccel())));
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
        if (getCdcelula() != null) {
            _hashCode += getCdcelula().hashCode();
        }
        if (getDthrivalciccel() != null) {
            _hashCode += getDthrivalciccel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjficteccelId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficteccelId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalciccel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalciccel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
