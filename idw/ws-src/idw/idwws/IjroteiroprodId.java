/**
 * IjroteiroprodId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjroteiroprodId  implements java.io.Serializable {
    private java.lang.String cdoperacao;

    private java.lang.String cdproduto;

    private java.math.BigDecimal estagio;

    public IjroteiroprodId() {
    }

    public IjroteiroprodId(
           java.lang.String cdoperacao,
           java.lang.String cdproduto,
           java.math.BigDecimal estagio) {
           this.cdoperacao = cdoperacao;
           this.cdproduto = cdproduto;
           this.estagio = estagio;
    }


    /**
     * Gets the cdoperacao value for this IjroteiroprodId.
     * 
     * @return cdoperacao
     */
    public java.lang.String getCdoperacao() {
        return cdoperacao;
    }


    /**
     * Sets the cdoperacao value for this IjroteiroprodId.
     * 
     * @param cdoperacao
     */
    public void setCdoperacao(java.lang.String cdoperacao) {
        this.cdoperacao = cdoperacao;
    }


    /**
     * Gets the cdproduto value for this IjroteiroprodId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjroteiroprodId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the estagio value for this IjroteiroprodId.
     * 
     * @return estagio
     */
    public java.math.BigDecimal getEstagio() {
        return estagio;
    }


    /**
     * Sets the estagio value for this IjroteiroprodId.
     * 
     * @param estagio
     */
    public void setEstagio(java.math.BigDecimal estagio) {
        this.estagio = estagio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjroteiroprodId)) return false;
        IjroteiroprodId other = (IjroteiroprodId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdoperacao==null && other.getCdoperacao()==null) || 
             (this.cdoperacao!=null &&
              this.cdoperacao.equals(other.getCdoperacao()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.estagio==null && other.getEstagio()==null) || 
             (this.estagio!=null &&
              this.estagio.equals(other.getEstagio())));
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
        if (getCdoperacao() != null) {
            _hashCode += getCdoperacao().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getEstagio() != null) {
            _hashCode += getEstagio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjroteiroprodId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijroteiroprodId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoperacao"));
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
        elemField.setFieldName("estagio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estagio"));
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
