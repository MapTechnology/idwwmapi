/**
 * IjtbesttabId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbesttabId  implements java.io.Serializable {
    private java.lang.String cdlingua;

    private java.lang.String cdtabela;

    private java.math.BigDecimal ordemcoluna;

    public IjtbesttabId() {
    }

    public IjtbesttabId(
           java.lang.String cdlingua,
           java.lang.String cdtabela,
           java.math.BigDecimal ordemcoluna) {
           this.cdlingua = cdlingua;
           this.cdtabela = cdtabela;
           this.ordemcoluna = ordemcoluna;
    }


    /**
     * Gets the cdlingua value for this IjtbesttabId.
     * 
     * @return cdlingua
     */
    public java.lang.String getCdlingua() {
        return cdlingua;
    }


    /**
     * Sets the cdlingua value for this IjtbesttabId.
     * 
     * @param cdlingua
     */
    public void setCdlingua(java.lang.String cdlingua) {
        this.cdlingua = cdlingua;
    }


    /**
     * Gets the cdtabela value for this IjtbesttabId.
     * 
     * @return cdtabela
     */
    public java.lang.String getCdtabela() {
        return cdtabela;
    }


    /**
     * Sets the cdtabela value for this IjtbesttabId.
     * 
     * @param cdtabela
     */
    public void setCdtabela(java.lang.String cdtabela) {
        this.cdtabela = cdtabela;
    }


    /**
     * Gets the ordemcoluna value for this IjtbesttabId.
     * 
     * @return ordemcoluna
     */
    public java.math.BigDecimal getOrdemcoluna() {
        return ordemcoluna;
    }


    /**
     * Sets the ordemcoluna value for this IjtbesttabId.
     * 
     * @param ordemcoluna
     */
    public void setOrdemcoluna(java.math.BigDecimal ordemcoluna) {
        this.ordemcoluna = ordemcoluna;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbesttabId)) return false;
        IjtbesttabId other = (IjtbesttabId) obj;
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
            ((this.cdtabela==null && other.getCdtabela()==null) || 
             (this.cdtabela!=null &&
              this.cdtabela.equals(other.getCdtabela()))) &&
            ((this.ordemcoluna==null && other.getOrdemcoluna()==null) || 
             (this.ordemcoluna!=null &&
              this.ordemcoluna.equals(other.getOrdemcoluna())));
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
        if (getCdtabela() != null) {
            _hashCode += getCdtabela().hashCode();
        }
        if (getOrdemcoluna() != null) {
            _hashCode += getOrdemcoluna().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbesttabId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbesttabId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlingua");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlingua"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtabela");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtabela"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemcoluna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemcoluna"));
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
