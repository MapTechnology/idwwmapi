/**
 * Ijdeparapro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdeparapro  implements java.io.Serializable {
    private java.lang.String cdprodutoauxiliar;

    private idw.idwws.Ijtbpro ijtbpro;

    public Ijdeparapro() {
    }

    public Ijdeparapro(
           java.lang.String cdprodutoauxiliar,
           idw.idwws.Ijtbpro ijtbpro) {
           this.cdprodutoauxiliar = cdprodutoauxiliar;
           this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the cdprodutoauxiliar value for this Ijdeparapro.
     * 
     * @return cdprodutoauxiliar
     */
    public java.lang.String getCdprodutoauxiliar() {
        return cdprodutoauxiliar;
    }


    /**
     * Sets the cdprodutoauxiliar value for this Ijdeparapro.
     * 
     * @param cdprodutoauxiliar
     */
    public void setCdprodutoauxiliar(java.lang.String cdprodutoauxiliar) {
        this.cdprodutoauxiliar = cdprodutoauxiliar;
    }


    /**
     * Gets the ijtbpro value for this Ijdeparapro.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijdeparapro.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdeparapro)) return false;
        Ijdeparapro other = (Ijdeparapro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdprodutoauxiliar==null && other.getCdprodutoauxiliar()==null) || 
             (this.cdprodutoauxiliar!=null &&
              this.cdprodutoauxiliar.equals(other.getCdprodutoauxiliar()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro())));
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
        if (getCdprodutoauxiliar() != null) {
            _hashCode += getCdprodutoauxiliar().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijdeparapro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdeparapro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdprodutoauxiliar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdprodutoauxiliar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
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
