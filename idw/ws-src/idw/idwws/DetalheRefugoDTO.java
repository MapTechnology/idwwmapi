/**
 * DetalheRefugoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalheRefugoDTO  implements java.io.Serializable {
    private java.lang.String acao;

    private java.lang.String causa;

    private java.util.Calendar dthrocorrencia;

    private java.lang.String ferramenta;

    private java.lang.String maquina;

    private java.lang.String produto;

    private double qtde_refugo;

    private java.lang.String refugo;

    public DetalheRefugoDTO() {
    }

    public DetalheRefugoDTO(
           java.lang.String acao,
           java.lang.String causa,
           java.util.Calendar dthrocorrencia,
           java.lang.String ferramenta,
           java.lang.String maquina,
           java.lang.String produto,
           double qtde_refugo,
           java.lang.String refugo) {
           this.acao = acao;
           this.causa = causa;
           this.dthrocorrencia = dthrocorrencia;
           this.ferramenta = ferramenta;
           this.maquina = maquina;
           this.produto = produto;
           this.qtde_refugo = qtde_refugo;
           this.refugo = refugo;
    }


    /**
     * Gets the acao value for this DetalheRefugoDTO.
     * 
     * @return acao
     */
    public java.lang.String getAcao() {
        return acao;
    }


    /**
     * Sets the acao value for this DetalheRefugoDTO.
     * 
     * @param acao
     */
    public void setAcao(java.lang.String acao) {
        this.acao = acao;
    }


    /**
     * Gets the causa value for this DetalheRefugoDTO.
     * 
     * @return causa
     */
    public java.lang.String getCausa() {
        return causa;
    }


    /**
     * Sets the causa value for this DetalheRefugoDTO.
     * 
     * @param causa
     */
    public void setCausa(java.lang.String causa) {
        this.causa = causa;
    }


    /**
     * Gets the dthrocorrencia value for this DetalheRefugoDTO.
     * 
     * @return dthrocorrencia
     */
    public java.util.Calendar getDthrocorrencia() {
        return dthrocorrencia;
    }


    /**
     * Sets the dthrocorrencia value for this DetalheRefugoDTO.
     * 
     * @param dthrocorrencia
     */
    public void setDthrocorrencia(java.util.Calendar dthrocorrencia) {
        this.dthrocorrencia = dthrocorrencia;
    }


    /**
     * Gets the ferramenta value for this DetalheRefugoDTO.
     * 
     * @return ferramenta
     */
    public java.lang.String getFerramenta() {
        return ferramenta;
    }


    /**
     * Sets the ferramenta value for this DetalheRefugoDTO.
     * 
     * @param ferramenta
     */
    public void setFerramenta(java.lang.String ferramenta) {
        this.ferramenta = ferramenta;
    }


    /**
     * Gets the maquina value for this DetalheRefugoDTO.
     * 
     * @return maquina
     */
    public java.lang.String getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this DetalheRefugoDTO.
     * 
     * @param maquina
     */
    public void setMaquina(java.lang.String maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the produto value for this DetalheRefugoDTO.
     * 
     * @return produto
     */
    public java.lang.String getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this DetalheRefugoDTO.
     * 
     * @param produto
     */
    public void setProduto(java.lang.String produto) {
        this.produto = produto;
    }


    /**
     * Gets the qtde_refugo value for this DetalheRefugoDTO.
     * 
     * @return qtde_refugo
     */
    public double getQtde_refugo() {
        return qtde_refugo;
    }


    /**
     * Sets the qtde_refugo value for this DetalheRefugoDTO.
     * 
     * @param qtde_refugo
     */
    public void setQtde_refugo(double qtde_refugo) {
        this.qtde_refugo = qtde_refugo;
    }


    /**
     * Gets the refugo value for this DetalheRefugoDTO.
     * 
     * @return refugo
     */
    public java.lang.String getRefugo() {
        return refugo;
    }


    /**
     * Sets the refugo value for this DetalheRefugoDTO.
     * 
     * @param refugo
     */
    public void setRefugo(java.lang.String refugo) {
        this.refugo = refugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalheRefugoDTO)) return false;
        DetalheRefugoDTO other = (DetalheRefugoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acao==null && other.getAcao()==null) || 
             (this.acao!=null &&
              this.acao.equals(other.getAcao()))) &&
            ((this.causa==null && other.getCausa()==null) || 
             (this.causa!=null &&
              this.causa.equals(other.getCausa()))) &&
            ((this.dthrocorrencia==null && other.getDthrocorrencia()==null) || 
             (this.dthrocorrencia!=null &&
              this.dthrocorrencia.equals(other.getDthrocorrencia()))) &&
            ((this.ferramenta==null && other.getFerramenta()==null) || 
             (this.ferramenta!=null &&
              this.ferramenta.equals(other.getFerramenta()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            this.qtde_refugo == other.getQtde_refugo() &&
            ((this.refugo==null && other.getRefugo()==null) || 
             (this.refugo!=null &&
              this.refugo.equals(other.getRefugo())));
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
        if (getAcao() != null) {
            _hashCode += getAcao().hashCode();
        }
        if (getCausa() != null) {
            _hashCode += getCausa().hashCode();
        }
        if (getDthrocorrencia() != null) {
            _hashCode += getDthrocorrencia().hashCode();
        }
        if (getFerramenta() != null) {
            _hashCode += getFerramenta().hashCode();
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        _hashCode += new Double(getQtde_refugo()).hashCode();
        if (getRefugo() != null) {
            _hashCode += getRefugo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalheRefugoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheRefugoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("causa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "causa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrocorrencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrocorrencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ferramenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ferramenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtde_refugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtde_refugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "refugo"));
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
