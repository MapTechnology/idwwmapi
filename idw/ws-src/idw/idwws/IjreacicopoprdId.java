/**
 * IjreacicopoprdId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjreacicopoprdId  implements java.io.Serializable {
    private java.lang.String cdoperador;

    private java.util.Calendar dthriciclo;

    private java.lang.String nrop;

    public IjreacicopoprdId() {
    }

    public IjreacicopoprdId(
           java.lang.String cdoperador,
           java.util.Calendar dthriciclo,
           java.lang.String nrop) {
           this.cdoperador = cdoperador;
           this.dthriciclo = dthriciclo;
           this.nrop = nrop;
    }


    /**
     * Gets the cdoperador value for this IjreacicopoprdId.
     * 
     * @return cdoperador
     */
    public java.lang.String getCdoperador() {
        return cdoperador;
    }


    /**
     * Sets the cdoperador value for this IjreacicopoprdId.
     * 
     * @param cdoperador
     */
    public void setCdoperador(java.lang.String cdoperador) {
        this.cdoperador = cdoperador;
    }


    /**
     * Gets the dthriciclo value for this IjreacicopoprdId.
     * 
     * @return dthriciclo
     */
    public java.util.Calendar getDthriciclo() {
        return dthriciclo;
    }


    /**
     * Sets the dthriciclo value for this IjreacicopoprdId.
     * 
     * @param dthriciclo
     */
    public void setDthriciclo(java.util.Calendar dthriciclo) {
        this.dthriciclo = dthriciclo;
    }


    /**
     * Gets the nrop value for this IjreacicopoprdId.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this IjreacicopoprdId.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjreacicopoprdId)) return false;
        IjreacicopoprdId other = (IjreacicopoprdId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdoperador==null && other.getCdoperador()==null) || 
             (this.cdoperador!=null &&
              this.cdoperador.equals(other.getCdoperador()))) &&
            ((this.dthriciclo==null && other.getDthriciclo()==null) || 
             (this.dthriciclo!=null &&
              this.dthriciclo.equals(other.getDthriciclo()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop())));
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
        if (getCdoperador() != null) {
            _hashCode += getCdoperador().hashCode();
        }
        if (getDthriciclo() != null) {
            _hashCode += getDthriciclo().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjreacicopoprdId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacicopoprdId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
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
