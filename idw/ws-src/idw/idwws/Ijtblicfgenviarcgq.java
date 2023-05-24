/**
 * Ijtblicfgenviarcgq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtblicfgenviarcgq  implements java.io.Serializable {
    private java.lang.String cdcliente;

    private org.apache.axis.types.UnsignedShort enviohabilitado;

    private org.apache.axis.types.UnsignedShort enviointernohab;

    private idw.idwws.Ijtbcli ijtbcli;

    public Ijtblicfgenviarcgq() {
    }

    public Ijtblicfgenviarcgq(
           java.lang.String cdcliente,
           org.apache.axis.types.UnsignedShort enviohabilitado,
           org.apache.axis.types.UnsignedShort enviointernohab,
           idw.idwws.Ijtbcli ijtbcli) {
           this.cdcliente = cdcliente;
           this.enviohabilitado = enviohabilitado;
           this.enviointernohab = enviointernohab;
           this.ijtbcli = ijtbcli;
    }


    /**
     * Gets the cdcliente value for this Ijtblicfgenviarcgq.
     * 
     * @return cdcliente
     */
    public java.lang.String getCdcliente() {
        return cdcliente;
    }


    /**
     * Sets the cdcliente value for this Ijtblicfgenviarcgq.
     * 
     * @param cdcliente
     */
    public void setCdcliente(java.lang.String cdcliente) {
        this.cdcliente = cdcliente;
    }


    /**
     * Gets the enviohabilitado value for this Ijtblicfgenviarcgq.
     * 
     * @return enviohabilitado
     */
    public org.apache.axis.types.UnsignedShort getEnviohabilitado() {
        return enviohabilitado;
    }


    /**
     * Sets the enviohabilitado value for this Ijtblicfgenviarcgq.
     * 
     * @param enviohabilitado
     */
    public void setEnviohabilitado(org.apache.axis.types.UnsignedShort enviohabilitado) {
        this.enviohabilitado = enviohabilitado;
    }


    /**
     * Gets the enviointernohab value for this Ijtblicfgenviarcgq.
     * 
     * @return enviointernohab
     */
    public org.apache.axis.types.UnsignedShort getEnviointernohab() {
        return enviointernohab;
    }


    /**
     * Sets the enviointernohab value for this Ijtblicfgenviarcgq.
     * 
     * @param enviointernohab
     */
    public void setEnviointernohab(org.apache.axis.types.UnsignedShort enviointernohab) {
        this.enviointernohab = enviointernohab;
    }


    /**
     * Gets the ijtbcli value for this Ijtblicfgenviarcgq.
     * 
     * @return ijtbcli
     */
    public idw.idwws.Ijtbcli getIjtbcli() {
        return ijtbcli;
    }


    /**
     * Sets the ijtbcli value for this Ijtblicfgenviarcgq.
     * 
     * @param ijtbcli
     */
    public void setIjtbcli(idw.idwws.Ijtbcli ijtbcli) {
        this.ijtbcli = ijtbcli;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtblicfgenviarcgq)) return false;
        Ijtblicfgenviarcgq other = (Ijtblicfgenviarcgq) obj;
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
            ((this.enviohabilitado==null && other.getEnviohabilitado()==null) || 
             (this.enviohabilitado!=null &&
              this.enviohabilitado.equals(other.getEnviohabilitado()))) &&
            ((this.enviointernohab==null && other.getEnviointernohab()==null) || 
             (this.enviointernohab!=null &&
              this.enviointernohab.equals(other.getEnviointernohab()))) &&
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
        if (getEnviohabilitado() != null) {
            _hashCode += getEnviohabilitado().hashCode();
        }
        if (getEnviointernohab() != null) {
            _hashCode += getEnviointernohab().hashCode();
        }
        if (getIjtbcli() != null) {
            _hashCode += getIjtbcli().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtblicfgenviarcgq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtblicfgenviarcgq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enviohabilitado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enviohabilitado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enviointernohab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enviointernohab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
