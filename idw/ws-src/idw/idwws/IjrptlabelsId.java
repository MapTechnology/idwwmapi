/**
 * IjrptlabelsId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjrptlabelsId  implements java.io.Serializable {
    private java.lang.String cdlingua;

    private java.lang.String cdreport;

    private java.math.BigDecimal seqlabel;

    public IjrptlabelsId() {
    }

    public IjrptlabelsId(
           java.lang.String cdlingua,
           java.lang.String cdreport,
           java.math.BigDecimal seqlabel) {
           this.cdlingua = cdlingua;
           this.cdreport = cdreport;
           this.seqlabel = seqlabel;
    }


    /**
     * Gets the cdlingua value for this IjrptlabelsId.
     * 
     * @return cdlingua
     */
    public java.lang.String getCdlingua() {
        return cdlingua;
    }


    /**
     * Sets the cdlingua value for this IjrptlabelsId.
     * 
     * @param cdlingua
     */
    public void setCdlingua(java.lang.String cdlingua) {
        this.cdlingua = cdlingua;
    }


    /**
     * Gets the cdreport value for this IjrptlabelsId.
     * 
     * @return cdreport
     */
    public java.lang.String getCdreport() {
        return cdreport;
    }


    /**
     * Sets the cdreport value for this IjrptlabelsId.
     * 
     * @param cdreport
     */
    public void setCdreport(java.lang.String cdreport) {
        this.cdreport = cdreport;
    }


    /**
     * Gets the seqlabel value for this IjrptlabelsId.
     * 
     * @return seqlabel
     */
    public java.math.BigDecimal getSeqlabel() {
        return seqlabel;
    }


    /**
     * Sets the seqlabel value for this IjrptlabelsId.
     * 
     * @param seqlabel
     */
    public void setSeqlabel(java.math.BigDecimal seqlabel) {
        this.seqlabel = seqlabel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjrptlabelsId)) return false;
        IjrptlabelsId other = (IjrptlabelsId) obj;
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
            ((this.cdreport==null && other.getCdreport()==null) || 
             (this.cdreport!=null &&
              this.cdreport.equals(other.getCdreport()))) &&
            ((this.seqlabel==null && other.getSeqlabel()==null) || 
             (this.seqlabel!=null &&
              this.seqlabel.equals(other.getSeqlabel())));
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
        if (getCdreport() != null) {
            _hashCode += getCdreport().hashCode();
        }
        if (getSeqlabel() != null) {
            _hashCode += getSeqlabel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjrptlabelsId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrptlabelsId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlingua");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlingua"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdreport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdreport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqlabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seqlabel"));
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
