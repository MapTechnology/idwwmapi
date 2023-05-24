/**
 * PrUpProdutoMatPrima.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrUpProdutoMatPrima  implements java.io.Serializable {
    private java.lang.String cdestoque;

    private java.lang.String cdmateriaprima;

    private java.lang.String cdproduto;

    private org.apache.axis.types.UnsignedShort controlalote;

    private java.lang.String dsmateriaprima;

    private java.lang.String idprodutomatprima;

    private java.lang.String nrlote;

    private idw.idwws.PrUp prUp;

    private java.lang.String unidade;

    public PrUpProdutoMatPrima() {
    }

    public PrUpProdutoMatPrima(
           java.lang.String cdestoque,
           java.lang.String cdmateriaprima,
           java.lang.String cdproduto,
           org.apache.axis.types.UnsignedShort controlalote,
           java.lang.String dsmateriaprima,
           java.lang.String idprodutomatprima,
           java.lang.String nrlote,
           idw.idwws.PrUp prUp,
           java.lang.String unidade) {
           this.cdestoque = cdestoque;
           this.cdmateriaprima = cdmateriaprima;
           this.cdproduto = cdproduto;
           this.controlalote = controlalote;
           this.dsmateriaprima = dsmateriaprima;
           this.idprodutomatprima = idprodutomatprima;
           this.nrlote = nrlote;
           this.prUp = prUp;
           this.unidade = unidade;
    }


    /**
     * Gets the cdestoque value for this PrUpProdutoMatPrima.
     * 
     * @return cdestoque
     */
    public java.lang.String getCdestoque() {
        return cdestoque;
    }


    /**
     * Sets the cdestoque value for this PrUpProdutoMatPrima.
     * 
     * @param cdestoque
     */
    public void setCdestoque(java.lang.String cdestoque) {
        this.cdestoque = cdestoque;
    }


    /**
     * Gets the cdmateriaprima value for this PrUpProdutoMatPrima.
     * 
     * @return cdmateriaprima
     */
    public java.lang.String getCdmateriaprima() {
        return cdmateriaprima;
    }


    /**
     * Sets the cdmateriaprima value for this PrUpProdutoMatPrima.
     * 
     * @param cdmateriaprima
     */
    public void setCdmateriaprima(java.lang.String cdmateriaprima) {
        this.cdmateriaprima = cdmateriaprima;
    }


    /**
     * Gets the cdproduto value for this PrUpProdutoMatPrima.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this PrUpProdutoMatPrima.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the controlalote value for this PrUpProdutoMatPrima.
     * 
     * @return controlalote
     */
    public org.apache.axis.types.UnsignedShort getControlalote() {
        return controlalote;
    }


    /**
     * Sets the controlalote value for this PrUpProdutoMatPrima.
     * 
     * @param controlalote
     */
    public void setControlalote(org.apache.axis.types.UnsignedShort controlalote) {
        this.controlalote = controlalote;
    }


    /**
     * Gets the dsmateriaprima value for this PrUpProdutoMatPrima.
     * 
     * @return dsmateriaprima
     */
    public java.lang.String getDsmateriaprima() {
        return dsmateriaprima;
    }


    /**
     * Sets the dsmateriaprima value for this PrUpProdutoMatPrima.
     * 
     * @param dsmateriaprima
     */
    public void setDsmateriaprima(java.lang.String dsmateriaprima) {
        this.dsmateriaprima = dsmateriaprima;
    }


    /**
     * Gets the idprodutomatprima value for this PrUpProdutoMatPrima.
     * 
     * @return idprodutomatprima
     */
    public java.lang.String getIdprodutomatprima() {
        return idprodutomatprima;
    }


    /**
     * Sets the idprodutomatprima value for this PrUpProdutoMatPrima.
     * 
     * @param idprodutomatprima
     */
    public void setIdprodutomatprima(java.lang.String idprodutomatprima) {
        this.idprodutomatprima = idprodutomatprima;
    }


    /**
     * Gets the nrlote value for this PrUpProdutoMatPrima.
     * 
     * @return nrlote
     */
    public java.lang.String getNrlote() {
        return nrlote;
    }


    /**
     * Sets the nrlote value for this PrUpProdutoMatPrima.
     * 
     * @param nrlote
     */
    public void setNrlote(java.lang.String nrlote) {
        this.nrlote = nrlote;
    }


    /**
     * Gets the prUp value for this PrUpProdutoMatPrima.
     * 
     * @return prUp
     */
    public idw.idwws.PrUp getPrUp() {
        return prUp;
    }


    /**
     * Sets the prUp value for this PrUpProdutoMatPrima.
     * 
     * @param prUp
     */
    public void setPrUp(idw.idwws.PrUp prUp) {
        this.prUp = prUp;
    }


    /**
     * Gets the unidade value for this PrUpProdutoMatPrima.
     * 
     * @return unidade
     */
    public java.lang.String getUnidade() {
        return unidade;
    }


    /**
     * Sets the unidade value for this PrUpProdutoMatPrima.
     * 
     * @param unidade
     */
    public void setUnidade(java.lang.String unidade) {
        this.unidade = unidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrUpProdutoMatPrima)) return false;
        PrUpProdutoMatPrima other = (PrUpProdutoMatPrima) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdestoque==null && other.getCdestoque()==null) || 
             (this.cdestoque!=null &&
              this.cdestoque.equals(other.getCdestoque()))) &&
            ((this.cdmateriaprima==null && other.getCdmateriaprima()==null) || 
             (this.cdmateriaprima!=null &&
              this.cdmateriaprima.equals(other.getCdmateriaprima()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.controlalote==null && other.getControlalote()==null) || 
             (this.controlalote!=null &&
              this.controlalote.equals(other.getControlalote()))) &&
            ((this.dsmateriaprima==null && other.getDsmateriaprima()==null) || 
             (this.dsmateriaprima!=null &&
              this.dsmateriaprima.equals(other.getDsmateriaprima()))) &&
            ((this.idprodutomatprima==null && other.getIdprodutomatprima()==null) || 
             (this.idprodutomatprima!=null &&
              this.idprodutomatprima.equals(other.getIdprodutomatprima()))) &&
            ((this.nrlote==null && other.getNrlote()==null) || 
             (this.nrlote!=null &&
              this.nrlote.equals(other.getNrlote()))) &&
            ((this.prUp==null && other.getPrUp()==null) || 
             (this.prUp!=null &&
              this.prUp.equals(other.getPrUp()))) &&
            ((this.unidade==null && other.getUnidade()==null) || 
             (this.unidade!=null &&
              this.unidade.equals(other.getUnidade())));
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
        if (getCdestoque() != null) {
            _hashCode += getCdestoque().hashCode();
        }
        if (getCdmateriaprima() != null) {
            _hashCode += getCdmateriaprima().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getControlalote() != null) {
            _hashCode += getControlalote().hashCode();
        }
        if (getDsmateriaprima() != null) {
            _hashCode += getDsmateriaprima().hashCode();
        }
        if (getIdprodutomatprima() != null) {
            _hashCode += getIdprodutomatprima().hashCode();
        }
        if (getNrlote() != null) {
            _hashCode += getNrlote().hashCode();
        }
        if (getPrUp() != null) {
            _hashCode += getPrUp().hashCode();
        }
        if (getUnidade() != null) {
            _hashCode += getUnidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrUpProdutoMatPrima.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpProdutoMatPrima"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmateriaprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmateriaprima"));
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
        elemField.setFieldName("controlalote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "controlalote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmateriaprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmateriaprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idprodutomatprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idprodutomatprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidade"));
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
