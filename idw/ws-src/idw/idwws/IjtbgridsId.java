/**
 * IjtbgridsId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbgridsId  implements java.io.Serializable {
    private java.lang.String cdlingua;

    private java.lang.String nmform;

    private java.lang.String nmgrid;

    private java.math.BigDecimal ordemcol;

    public IjtbgridsId() {
    }

    public IjtbgridsId(
           java.lang.String cdlingua,
           java.lang.String nmform,
           java.lang.String nmgrid,
           java.math.BigDecimal ordemcol) {
           this.cdlingua = cdlingua;
           this.nmform = nmform;
           this.nmgrid = nmgrid;
           this.ordemcol = ordemcol;
    }


    /**
     * Gets the cdlingua value for this IjtbgridsId.
     * 
     * @return cdlingua
     */
    public java.lang.String getCdlingua() {
        return cdlingua;
    }


    /**
     * Sets the cdlingua value for this IjtbgridsId.
     * 
     * @param cdlingua
     */
    public void setCdlingua(java.lang.String cdlingua) {
        this.cdlingua = cdlingua;
    }


    /**
     * Gets the nmform value for this IjtbgridsId.
     * 
     * @return nmform
     */
    public java.lang.String getNmform() {
        return nmform;
    }


    /**
     * Sets the nmform value for this IjtbgridsId.
     * 
     * @param nmform
     */
    public void setNmform(java.lang.String nmform) {
        this.nmform = nmform;
    }


    /**
     * Gets the nmgrid value for this IjtbgridsId.
     * 
     * @return nmgrid
     */
    public java.lang.String getNmgrid() {
        return nmgrid;
    }


    /**
     * Sets the nmgrid value for this IjtbgridsId.
     * 
     * @param nmgrid
     */
    public void setNmgrid(java.lang.String nmgrid) {
        this.nmgrid = nmgrid;
    }


    /**
     * Gets the ordemcol value for this IjtbgridsId.
     * 
     * @return ordemcol
     */
    public java.math.BigDecimal getOrdemcol() {
        return ordemcol;
    }


    /**
     * Sets the ordemcol value for this IjtbgridsId.
     * 
     * @param ordemcol
     */
    public void setOrdemcol(java.math.BigDecimal ordemcol) {
        this.ordemcol = ordemcol;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbgridsId)) return false;
        IjtbgridsId other = (IjtbgridsId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdlingua==null && other.getCdlingua()==null) || 
             (this.cdlingua!=null &&
              this.cdlingua.equals(other.getCdlingua()))) &&
            ((this.nmform==null && other.getNmform()==null) || 
             (this.nmform!=null &&
              this.nmform.equals(other.getNmform()))) &&
            ((this.nmgrid==null && other.getNmgrid()==null) || 
             (this.nmgrid!=null &&
              this.nmgrid.equals(other.getNmgrid()))) &&
            ((this.ordemcol==null && other.getOrdemcol()==null) || 
             (this.ordemcol!=null &&
              this.ordemcol.equals(other.getOrdemcol())));
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
        if (getCdlingua() != null) {
            _hashCode += getCdlingua().hashCode();
        }
        if (getNmform() != null) {
            _hashCode += getNmform().hashCode();
        }
        if (getNmgrid() != null) {
            _hashCode += getNmgrid().hashCode();
        }
        if (getOrdemcol() != null) {
            _hashCode += getOrdemcol().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbgridsId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgridsId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlingua");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlingua"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmform");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmform"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmgrid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmgrid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemcol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemcol"));
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
