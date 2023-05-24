/**
 * IjestruprodId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjestruprodId  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private java.lang.String cdprodutoseq;

    private java.math.BigDecimal sequencia;

    public IjestruprodId() {
    }

    public IjestruprodId(
           java.lang.String cdproduto,
           java.lang.String cdprodutoseq,
           java.math.BigDecimal sequencia) {
           this.cdproduto = cdproduto;
           this.cdprodutoseq = cdprodutoseq;
           this.sequencia = sequencia;
    }


    /**
     * Gets the cdproduto value for this IjestruprodId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjestruprodId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the cdprodutoseq value for this IjestruprodId.
     * 
     * @return cdprodutoseq
     */
    public java.lang.String getCdprodutoseq() {
        return cdprodutoseq;
    }


    /**
     * Sets the cdprodutoseq value for this IjestruprodId.
     * 
     * @param cdprodutoseq
     */
    public void setCdprodutoseq(java.lang.String cdprodutoseq) {
        this.cdprodutoseq = cdprodutoseq;
    }


    /**
     * Gets the sequencia value for this IjestruprodId.
     * 
     * @return sequencia
     */
    public java.math.BigDecimal getSequencia() {
        return sequencia;
    }


    /**
     * Sets the sequencia value for this IjestruprodId.
     * 
     * @param sequencia
     */
    public void setSequencia(java.math.BigDecimal sequencia) {
        this.sequencia = sequencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjestruprodId)) return false;
        IjestruprodId other = (IjestruprodId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.cdprodutoseq==null && other.getCdprodutoseq()==null) || 
             (this.cdprodutoseq!=null &&
              this.cdprodutoseq.equals(other.getCdprodutoseq()))) &&
            ((this.sequencia==null && other.getSequencia()==null) || 
             (this.sequencia!=null &&
              this.sequencia.equals(other.getSequencia())));
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
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getCdprodutoseq() != null) {
            _hashCode += getCdprodutoseq().hashCode();
        }
        if (getSequencia() != null) {
            _hashCode += getSequencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjestruprodId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestruprodId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdprodutoseq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdprodutoseq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequencia"));
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
