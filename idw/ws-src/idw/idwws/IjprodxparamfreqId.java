/**
 * IjprodxparamfreqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjprodxparamfreqId  implements java.io.Serializable {
    private java.lang.String cdgrpparam;

    private java.lang.String cdproduto;

    private double vlreferencia;

    public IjprodxparamfreqId() {
    }

    public IjprodxparamfreqId(
           java.lang.String cdgrpparam,
           java.lang.String cdproduto,
           double vlreferencia) {
           this.cdgrpparam = cdgrpparam;
           this.cdproduto = cdproduto;
           this.vlreferencia = vlreferencia;
    }


    /**
     * Gets the cdgrpparam value for this IjprodxparamfreqId.
     * 
     * @return cdgrpparam
     */
    public java.lang.String getCdgrpparam() {
        return cdgrpparam;
    }


    /**
     * Sets the cdgrpparam value for this IjprodxparamfreqId.
     * 
     * @param cdgrpparam
     */
    public void setCdgrpparam(java.lang.String cdgrpparam) {
        this.cdgrpparam = cdgrpparam;
    }


    /**
     * Gets the cdproduto value for this IjprodxparamfreqId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjprodxparamfreqId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the vlreferencia value for this IjprodxparamfreqId.
     * 
     * @return vlreferencia
     */
    public double getVlreferencia() {
        return vlreferencia;
    }


    /**
     * Sets the vlreferencia value for this IjprodxparamfreqId.
     * 
     * @param vlreferencia
     */
    public void setVlreferencia(double vlreferencia) {
        this.vlreferencia = vlreferencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjprodxparamfreqId)) return false;
        IjprodxparamfreqId other = (IjprodxparamfreqId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrpparam==null && other.getCdgrpparam()==null) || 
             (this.cdgrpparam!=null &&
              this.cdgrpparam.equals(other.getCdgrpparam()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            this.vlreferencia == other.getVlreferencia();
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
        if (getCdgrpparam() != null) {
            _hashCode += getCdgrpparam().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        _hashCode += new Double(getVlreferencia()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjprodxparamfreqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxparamfreqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrpparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrpparam"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlreferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlreferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
