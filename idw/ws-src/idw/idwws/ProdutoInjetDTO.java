/**
 * ProdutoInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ProdutoInjetDTO  implements java.io.Serializable {
    private java.lang.String cdMolde;

    private java.lang.String cdProduto;

    private java.lang.String dsProduto;

    private idw.idwws.Ijtbpro ijtbpro;

    private java.math.BigDecimal qtcavativas;

    private java.math.BigDecimal qtcavidades;

    public ProdutoInjetDTO() {
    }

    public ProdutoInjetDTO(
           java.lang.String cdMolde,
           java.lang.String cdProduto,
           java.lang.String dsProduto,
           idw.idwws.Ijtbpro ijtbpro,
           java.math.BigDecimal qtcavativas,
           java.math.BigDecimal qtcavidades) {
           this.cdMolde = cdMolde;
           this.cdProduto = cdProduto;
           this.dsProduto = dsProduto;
           this.ijtbpro = ijtbpro;
           this.qtcavativas = qtcavativas;
           this.qtcavidades = qtcavidades;
    }


    /**
     * Gets the cdMolde value for this ProdutoInjetDTO.
     * 
     * @return cdMolde
     */
    public java.lang.String getCdMolde() {
        return cdMolde;
    }


    /**
     * Sets the cdMolde value for this ProdutoInjetDTO.
     * 
     * @param cdMolde
     */
    public void setCdMolde(java.lang.String cdMolde) {
        this.cdMolde = cdMolde;
    }


    /**
     * Gets the cdProduto value for this ProdutoInjetDTO.
     * 
     * @return cdProduto
     */
    public java.lang.String getCdProduto() {
        return cdProduto;
    }


    /**
     * Sets the cdProduto value for this ProdutoInjetDTO.
     * 
     * @param cdProduto
     */
    public void setCdProduto(java.lang.String cdProduto) {
        this.cdProduto = cdProduto;
    }


    /**
     * Gets the dsProduto value for this ProdutoInjetDTO.
     * 
     * @return dsProduto
     */
    public java.lang.String getDsProduto() {
        return dsProduto;
    }


    /**
     * Sets the dsProduto value for this ProdutoInjetDTO.
     * 
     * @param dsProduto
     */
    public void setDsProduto(java.lang.String dsProduto) {
        this.dsProduto = dsProduto;
    }


    /**
     * Gets the ijtbpro value for this ProdutoInjetDTO.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this ProdutoInjetDTO.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the qtcavativas value for this ProdutoInjetDTO.
     * 
     * @return qtcavativas
     */
    public java.math.BigDecimal getQtcavativas() {
        return qtcavativas;
    }


    /**
     * Sets the qtcavativas value for this ProdutoInjetDTO.
     * 
     * @param qtcavativas
     */
    public void setQtcavativas(java.math.BigDecimal qtcavativas) {
        this.qtcavativas = qtcavativas;
    }


    /**
     * Gets the qtcavidades value for this ProdutoInjetDTO.
     * 
     * @return qtcavidades
     */
    public java.math.BigDecimal getQtcavidades() {
        return qtcavidades;
    }


    /**
     * Sets the qtcavidades value for this ProdutoInjetDTO.
     * 
     * @param qtcavidades
     */
    public void setQtcavidades(java.math.BigDecimal qtcavidades) {
        this.qtcavidades = qtcavidades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProdutoInjetDTO)) return false;
        ProdutoInjetDTO other = (ProdutoInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdMolde==null && other.getCdMolde()==null) || 
             (this.cdMolde!=null &&
              this.cdMolde.equals(other.getCdMolde()))) &&
            ((this.cdProduto==null && other.getCdProduto()==null) || 
             (this.cdProduto!=null &&
              this.cdProduto.equals(other.getCdProduto()))) &&
            ((this.dsProduto==null && other.getDsProduto()==null) || 
             (this.dsProduto!=null &&
              this.dsProduto.equals(other.getDsProduto()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.qtcavativas==null && other.getQtcavativas()==null) || 
             (this.qtcavativas!=null &&
              this.qtcavativas.equals(other.getQtcavativas()))) &&
            ((this.qtcavidades==null && other.getQtcavidades()==null) || 
             (this.qtcavidades!=null &&
              this.qtcavidades.equals(other.getQtcavidades())));
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
        if (getCdMolde() != null) {
            _hashCode += getCdMolde().hashCode();
        }
        if (getCdProduto() != null) {
            _hashCode += getCdProduto().hashCode();
        }
        if (getDsProduto() != null) {
            _hashCode += getDsProduto().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getQtcavativas() != null) {
            _hashCode += getQtcavativas().hashCode();
        }
        if (getQtcavidades() != null) {
            _hashCode += getQtcavidades().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProdutoInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtoInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsProduto"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavativas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavidades"));
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
