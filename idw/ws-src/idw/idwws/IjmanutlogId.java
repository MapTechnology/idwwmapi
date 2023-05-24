/**
 * IjmanutlogId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmanutlogId  implements java.io.Serializable {
    private java.lang.String dslog;

    private java.util.Calendar dthrlog;

    private java.lang.String nros;

    private java.math.BigDecimal seqitem;

    public IjmanutlogId() {
    }

    public IjmanutlogId(
           java.lang.String dslog,
           java.util.Calendar dthrlog,
           java.lang.String nros,
           java.math.BigDecimal seqitem) {
           this.dslog = dslog;
           this.dthrlog = dthrlog;
           this.nros = nros;
           this.seqitem = seqitem;
    }


    /**
     * Gets the dslog value for this IjmanutlogId.
     * 
     * @return dslog
     */
    public java.lang.String getDslog() {
        return dslog;
    }


    /**
     * Sets the dslog value for this IjmanutlogId.
     * 
     * @param dslog
     */
    public void setDslog(java.lang.String dslog) {
        this.dslog = dslog;
    }


    /**
     * Gets the dthrlog value for this IjmanutlogId.
     * 
     * @return dthrlog
     */
    public java.util.Calendar getDthrlog() {
        return dthrlog;
    }


    /**
     * Sets the dthrlog value for this IjmanutlogId.
     * 
     * @param dthrlog
     */
    public void setDthrlog(java.util.Calendar dthrlog) {
        this.dthrlog = dthrlog;
    }


    /**
     * Gets the nros value for this IjmanutlogId.
     * 
     * @return nros
     */
    public java.lang.String getNros() {
        return nros;
    }


    /**
     * Sets the nros value for this IjmanutlogId.
     * 
     * @param nros
     */
    public void setNros(java.lang.String nros) {
        this.nros = nros;
    }


    /**
     * Gets the seqitem value for this IjmanutlogId.
     * 
     * @return seqitem
     */
    public java.math.BigDecimal getSeqitem() {
        return seqitem;
    }


    /**
     * Sets the seqitem value for this IjmanutlogId.
     * 
     * @param seqitem
     */
    public void setSeqitem(java.math.BigDecimal seqitem) {
        this.seqitem = seqitem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmanutlogId)) return false;
        IjmanutlogId other = (IjmanutlogId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dslog==null && other.getDslog()==null) || 
             (this.dslog!=null &&
              this.dslog.equals(other.getDslog()))) &&
            ((this.dthrlog==null && other.getDthrlog()==null) || 
             (this.dthrlog!=null &&
              this.dthrlog.equals(other.getDthrlog()))) &&
            ((this.nros==null && other.getNros()==null) || 
             (this.nros!=null &&
              this.nros.equals(other.getNros()))) &&
            ((this.seqitem==null && other.getSeqitem()==null) || 
             (this.seqitem!=null &&
              this.seqitem.equals(other.getSeqitem())));
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
        if (getDslog() != null) {
            _hashCode += getDslog().hashCode();
        }
        if (getDthrlog() != null) {
            _hashCode += getDthrlog().hashCode();
        }
        if (getNros() != null) {
            _hashCode += getNros().hashCode();
        }
        if (getSeqitem() != null) {
            _hashCode += getSeqitem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmanutlogId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutlogId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dslog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dslog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrlog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrlog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqitem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seqitem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
