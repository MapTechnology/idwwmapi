/**
 * IjprocompmprimacgqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjprocompmprimacgqId  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private java.util.Calendar dthrivalcompmprima;

    private java.math.BigDecimal ordem;

    public IjprocompmprimacgqId() {
    }

    public IjprocompmprimacgqId(
           java.lang.String cdproduto,
           java.util.Calendar dthrivalcompmprima,
           java.math.BigDecimal ordem) {
           this.cdproduto = cdproduto;
           this.dthrivalcompmprima = dthrivalcompmprima;
           this.ordem = ordem;
    }


    /**
     * Gets the cdproduto value for this IjprocompmprimacgqId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjprocompmprimacgqId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dthrivalcompmprima value for this IjprocompmprimacgqId.
     * 
     * @return dthrivalcompmprima
     */
    public java.util.Calendar getDthrivalcompmprima() {
        return dthrivalcompmprima;
    }


    /**
     * Sets the dthrivalcompmprima value for this IjprocompmprimacgqId.
     * 
     * @param dthrivalcompmprima
     */
    public void setDthrivalcompmprima(java.util.Calendar dthrivalcompmprima) {
        this.dthrivalcompmprima = dthrivalcompmprima;
    }


    /**
     * Gets the ordem value for this IjprocompmprimacgqId.
     * 
     * @return ordem
     */
    public java.math.BigDecimal getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this IjprocompmprimacgqId.
     * 
     * @param ordem
     */
    public void setOrdem(java.math.BigDecimal ordem) {
        this.ordem = ordem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjprocompmprimacgqId)) return false;
        IjprocompmprimacgqId other = (IjprocompmprimacgqId) obj;
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
            ((this.dthrivalcompmprima==null && other.getDthrivalcompmprima()==null) || 
             (this.dthrivalcompmprima!=null &&
              this.dthrivalcompmprima.equals(other.getDthrivalcompmprima()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem())));
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
        if (getDthrivalcompmprima() != null) {
            _hashCode += getDthrivalcompmprima().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjprocompmprimacgqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprocompmprimacgqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalcompmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalcompmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
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
