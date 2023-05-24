/**
 * Ijtbclierp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbclierp  implements java.io.Serializable {
    private java.lang.String cdcliente;

    private idw.idwws.Ijtbcli ijtbcli;

    public Ijtbclierp() {
    }

    public Ijtbclierp(
           java.lang.String cdcliente,
           idw.idwws.Ijtbcli ijtbcli) {
           this.cdcliente = cdcliente;
           this.ijtbcli = ijtbcli;
    }


    /**
     * Gets the cdcliente value for this Ijtbclierp.
     * 
     * @return cdcliente
     */
    public java.lang.String getCdcliente() {
        return cdcliente;
    }


    /**
     * Sets the cdcliente value for this Ijtbclierp.
     * 
     * @param cdcliente
     */
    public void setCdcliente(java.lang.String cdcliente) {
        this.cdcliente = cdcliente;
    }


    /**
     * Gets the ijtbcli value for this Ijtbclierp.
     * 
     * @return ijtbcli
     */
    public idw.idwws.Ijtbcli getIjtbcli() {
        return ijtbcli;
    }


    /**
     * Sets the ijtbcli value for this Ijtbclierp.
     * 
     * @param ijtbcli
     */
    public void setIjtbcli(idw.idwws.Ijtbcli ijtbcli) {
        this.ijtbcli = ijtbcli;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbclierp)) return false;
        Ijtbclierp other = (Ijtbclierp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcliente==null && other.getCdcliente()==null) || 
             (this.cdcliente!=null &&
              this.cdcliente.equals(other.getCdcliente()))) &&
            ((this.ijtbcli==null && other.getIjtbcli()==null) || 
             (this.ijtbcli!=null &&
              this.ijtbcli.equals(other.getIjtbcli())));
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
        if (getCdcliente() != null) {
            _hashCode += getCdcliente().hashCode();
        }
        if (getIjtbcli() != null) {
            _hashCode += getIjtbcli().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbclierp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclierp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcli");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcli"));
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
