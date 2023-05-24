/**
 * IjlogsenhatmId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjlogsenhatmId  implements java.io.Serializable {
    private java.lang.String cdadmin;

    private java.lang.String cdusuario;

    private java.util.Calendar dthrtroca;

    public IjlogsenhatmId() {
    }

    public IjlogsenhatmId(
           java.lang.String cdadmin,
           java.lang.String cdusuario,
           java.util.Calendar dthrtroca) {
           this.cdadmin = cdadmin;
           this.cdusuario = cdusuario;
           this.dthrtroca = dthrtroca;
    }


    /**
     * Gets the cdadmin value for this IjlogsenhatmId.
     * 
     * @return cdadmin
     */
    public java.lang.String getCdadmin() {
        return cdadmin;
    }


    /**
     * Sets the cdadmin value for this IjlogsenhatmId.
     * 
     * @param cdadmin
     */
    public void setCdadmin(java.lang.String cdadmin) {
        this.cdadmin = cdadmin;
    }


    /**
     * Gets the cdusuario value for this IjlogsenhatmId.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this IjlogsenhatmId.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the dthrtroca value for this IjlogsenhatmId.
     * 
     * @return dthrtroca
     */
    public java.util.Calendar getDthrtroca() {
        return dthrtroca;
    }


    /**
     * Sets the dthrtroca value for this IjlogsenhatmId.
     * 
     * @param dthrtroca
     */
    public void setDthrtroca(java.util.Calendar dthrtroca) {
        this.dthrtroca = dthrtroca;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjlogsenhatmId)) return false;
        IjlogsenhatmId other = (IjlogsenhatmId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdadmin==null && other.getCdadmin()==null) || 
             (this.cdadmin!=null &&
              this.cdadmin.equals(other.getCdadmin()))) &&
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.dthrtroca==null && other.getDthrtroca()==null) || 
             (this.dthrtroca!=null &&
              this.dthrtroca.equals(other.getDthrtroca())));
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
        if (getCdadmin() != null) {
            _hashCode += getCdadmin().hashCode();
        }
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getDthrtroca() != null) {
            _hashCode += getDthrtroca().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjlogsenhatmId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogsenhatmId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdadmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdadmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrtroca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrtroca"));
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
