/**
 * GraficoBIParetoPerdasDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoBIParetoPerdasDTO  implements java.io.Serializable {
    private java.lang.String cdItemPareto;

    private java.lang.String dsItemPareto;

    private java.lang.Long idItemPareto;

    private java.lang.Double indItem;

    private java.lang.Double qtdItem;

    private java.lang.String toolTipItem;

    public GraficoBIParetoPerdasDTO() {
    }

    public GraficoBIParetoPerdasDTO(
           java.lang.String cdItemPareto,
           java.lang.String dsItemPareto,
           java.lang.Long idItemPareto,
           java.lang.Double indItem,
           java.lang.Double qtdItem,
           java.lang.String toolTipItem) {
           this.cdItemPareto = cdItemPareto;
           this.dsItemPareto = dsItemPareto;
           this.idItemPareto = idItemPareto;
           this.indItem = indItem;
           this.qtdItem = qtdItem;
           this.toolTipItem = toolTipItem;
    }


    /**
     * Gets the cdItemPareto value for this GraficoBIParetoPerdasDTO.
     * 
     * @return cdItemPareto
     */
    public java.lang.String getCdItemPareto() {
        return cdItemPareto;
    }


    /**
     * Sets the cdItemPareto value for this GraficoBIParetoPerdasDTO.
     * 
     * @param cdItemPareto
     */
    public void setCdItemPareto(java.lang.String cdItemPareto) {
        this.cdItemPareto = cdItemPareto;
    }


    /**
     * Gets the dsItemPareto value for this GraficoBIParetoPerdasDTO.
     * 
     * @return dsItemPareto
     */
    public java.lang.String getDsItemPareto() {
        return dsItemPareto;
    }


    /**
     * Sets the dsItemPareto value for this GraficoBIParetoPerdasDTO.
     * 
     * @param dsItemPareto
     */
    public void setDsItemPareto(java.lang.String dsItemPareto) {
        this.dsItemPareto = dsItemPareto;
    }


    /**
     * Gets the idItemPareto value for this GraficoBIParetoPerdasDTO.
     * 
     * @return idItemPareto
     */
    public java.lang.Long getIdItemPareto() {
        return idItemPareto;
    }


    /**
     * Sets the idItemPareto value for this GraficoBIParetoPerdasDTO.
     * 
     * @param idItemPareto
     */
    public void setIdItemPareto(java.lang.Long idItemPareto) {
        this.idItemPareto = idItemPareto;
    }


    /**
     * Gets the indItem value for this GraficoBIParetoPerdasDTO.
     * 
     * @return indItem
     */
    public java.lang.Double getIndItem() {
        return indItem;
    }


    /**
     * Sets the indItem value for this GraficoBIParetoPerdasDTO.
     * 
     * @param indItem
     */
    public void setIndItem(java.lang.Double indItem) {
        this.indItem = indItem;
    }


    /**
     * Gets the qtdItem value for this GraficoBIParetoPerdasDTO.
     * 
     * @return qtdItem
     */
    public java.lang.Double getQtdItem() {
        return qtdItem;
    }


    /**
     * Sets the qtdItem value for this GraficoBIParetoPerdasDTO.
     * 
     * @param qtdItem
     */
    public void setQtdItem(java.lang.Double qtdItem) {
        this.qtdItem = qtdItem;
    }


    /**
     * Gets the toolTipItem value for this GraficoBIParetoPerdasDTO.
     * 
     * @return toolTipItem
     */
    public java.lang.String getToolTipItem() {
        return toolTipItem;
    }


    /**
     * Sets the toolTipItem value for this GraficoBIParetoPerdasDTO.
     * 
     * @param toolTipItem
     */
    public void setToolTipItem(java.lang.String toolTipItem) {
        this.toolTipItem = toolTipItem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoBIParetoPerdasDTO)) return false;
        GraficoBIParetoPerdasDTO other = (GraficoBIParetoPerdasDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdItemPareto==null && other.getCdItemPareto()==null) || 
             (this.cdItemPareto!=null &&
              this.cdItemPareto.equals(other.getCdItemPareto()))) &&
            ((this.dsItemPareto==null && other.getDsItemPareto()==null) || 
             (this.dsItemPareto!=null &&
              this.dsItemPareto.equals(other.getDsItemPareto()))) &&
            ((this.idItemPareto==null && other.getIdItemPareto()==null) || 
             (this.idItemPareto!=null &&
              this.idItemPareto.equals(other.getIdItemPareto()))) &&
            ((this.indItem==null && other.getIndItem()==null) || 
             (this.indItem!=null &&
              this.indItem.equals(other.getIndItem()))) &&
            ((this.qtdItem==null && other.getQtdItem()==null) || 
             (this.qtdItem!=null &&
              this.qtdItem.equals(other.getQtdItem()))) &&
            ((this.toolTipItem==null && other.getToolTipItem()==null) || 
             (this.toolTipItem!=null &&
              this.toolTipItem.equals(other.getToolTipItem())));
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
        if (getCdItemPareto() != null) {
            _hashCode += getCdItemPareto().hashCode();
        }
        if (getDsItemPareto() != null) {
            _hashCode += getDsItemPareto().hashCode();
        }
        if (getIdItemPareto() != null) {
            _hashCode += getIdItemPareto().hashCode();
        }
        if (getIndItem() != null) {
            _hashCode += getIndItem().hashCode();
        }
        if (getQtdItem() != null) {
            _hashCode += getQtdItem().hashCode();
        }
        if (getToolTipItem() != null) {
            _hashCode += getToolTipItem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GraficoBIParetoPerdasDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoBIParetoPerdasDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdItemPareto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdItemPareto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsItemPareto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsItemPareto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idItemPareto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idItemPareto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toolTipItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "toolTipItem"));
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
