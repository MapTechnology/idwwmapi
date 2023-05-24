/**
 * Ijcentrocustoxmaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcentrocustoxmaq  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private idw.idwws.Ijtbcentrocusto ijtbcentrocusto;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijcentrocustoxmaq() {
    }

    public Ijcentrocustoxmaq(
           java.lang.String cdinjetora,
           idw.idwws.Ijtbcentrocusto ijtbcentrocusto,
           idw.idwws.Ijtbinj ijtbinj) {
           this.cdinjetora = cdinjetora;
           this.ijtbcentrocusto = ijtbcentrocusto;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the cdinjetora value for this Ijcentrocustoxmaq.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijcentrocustoxmaq.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the ijtbcentrocusto value for this Ijcentrocustoxmaq.
     * 
     * @return ijtbcentrocusto
     */
    public idw.idwws.Ijtbcentrocusto getIjtbcentrocusto() {
        return ijtbcentrocusto;
    }


    /**
     * Sets the ijtbcentrocusto value for this Ijcentrocustoxmaq.
     * 
     * @param ijtbcentrocusto
     */
    public void setIjtbcentrocusto(idw.idwws.Ijtbcentrocusto ijtbcentrocusto) {
        this.ijtbcentrocusto = ijtbcentrocusto;
    }


    /**
     * Gets the ijtbinj value for this Ijcentrocustoxmaq.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijcentrocustoxmaq.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcentrocustoxmaq)) return false;
        Ijcentrocustoxmaq other = (Ijcentrocustoxmaq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.ijtbcentrocusto==null && other.getIjtbcentrocusto()==null) || 
             (this.ijtbcentrocusto!=null &&
              this.ijtbcentrocusto.equals(other.getIjtbcentrocusto()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getIjtbcentrocusto() != null) {
            _hashCode += getIjtbcentrocusto().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcentrocustoxmaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcentrocustoxmaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcentrocusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcentrocusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcentrocusto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
