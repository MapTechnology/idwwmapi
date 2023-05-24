/**
 * DetalheProducaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalheProducaoDTO  implements java.io.Serializable {
    private double eficiencia_ciclo;

    private double eficiencia_realizacao;

    private java.lang.String ferramenta;

    private java.lang.String ferramenta_agrupada;

    private java.lang.String maquina;

    private double perdas_ciclo;

    private double prod_boas;

    private double prod_prevista;

    private double prod_realizada;

    private double prod_refugadas;

    private java.lang.String produto;

    public DetalheProducaoDTO() {
    }

    public DetalheProducaoDTO(
           double eficiencia_ciclo,
           double eficiencia_realizacao,
           java.lang.String ferramenta,
           java.lang.String ferramenta_agrupada,
           java.lang.String maquina,
           double perdas_ciclo,
           double prod_boas,
           double prod_prevista,
           double prod_realizada,
           double prod_refugadas,
           java.lang.String produto) {
           this.eficiencia_ciclo = eficiencia_ciclo;
           this.eficiencia_realizacao = eficiencia_realizacao;
           this.ferramenta = ferramenta;
           this.ferramenta_agrupada = ferramenta_agrupada;
           this.maquina = maquina;
           this.perdas_ciclo = perdas_ciclo;
           this.prod_boas = prod_boas;
           this.prod_prevista = prod_prevista;
           this.prod_realizada = prod_realizada;
           this.prod_refugadas = prod_refugadas;
           this.produto = produto;
    }


    /**
     * Gets the eficiencia_ciclo value for this DetalheProducaoDTO.
     * 
     * @return eficiencia_ciclo
     */
    public double getEficiencia_ciclo() {
        return eficiencia_ciclo;
    }


    /**
     * Sets the eficiencia_ciclo value for this DetalheProducaoDTO.
     * 
     * @param eficiencia_ciclo
     */
    public void setEficiencia_ciclo(double eficiencia_ciclo) {
        this.eficiencia_ciclo = eficiencia_ciclo;
    }


    /**
     * Gets the eficiencia_realizacao value for this DetalheProducaoDTO.
     * 
     * @return eficiencia_realizacao
     */
    public double getEficiencia_realizacao() {
        return eficiencia_realizacao;
    }


    /**
     * Sets the eficiencia_realizacao value for this DetalheProducaoDTO.
     * 
     * @param eficiencia_realizacao
     */
    public void setEficiencia_realizacao(double eficiencia_realizacao) {
        this.eficiencia_realizacao = eficiencia_realizacao;
    }


    /**
     * Gets the ferramenta value for this DetalheProducaoDTO.
     * 
     * @return ferramenta
     */
    public java.lang.String getFerramenta() {
        return ferramenta;
    }


    /**
     * Sets the ferramenta value for this DetalheProducaoDTO.
     * 
     * @param ferramenta
     */
    public void setFerramenta(java.lang.String ferramenta) {
        this.ferramenta = ferramenta;
    }


    /**
     * Gets the ferramenta_agrupada value for this DetalheProducaoDTO.
     * 
     * @return ferramenta_agrupada
     */
    public java.lang.String getFerramenta_agrupada() {
        return ferramenta_agrupada;
    }


    /**
     * Sets the ferramenta_agrupada value for this DetalheProducaoDTO.
     * 
     * @param ferramenta_agrupada
     */
    public void setFerramenta_agrupada(java.lang.String ferramenta_agrupada) {
        this.ferramenta_agrupada = ferramenta_agrupada;
    }


    /**
     * Gets the maquina value for this DetalheProducaoDTO.
     * 
     * @return maquina
     */
    public java.lang.String getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this DetalheProducaoDTO.
     * 
     * @param maquina
     */
    public void setMaquina(java.lang.String maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the perdas_ciclo value for this DetalheProducaoDTO.
     * 
     * @return perdas_ciclo
     */
    public double getPerdas_ciclo() {
        return perdas_ciclo;
    }


    /**
     * Sets the perdas_ciclo value for this DetalheProducaoDTO.
     * 
     * @param perdas_ciclo
     */
    public void setPerdas_ciclo(double perdas_ciclo) {
        this.perdas_ciclo = perdas_ciclo;
    }


    /**
     * Gets the prod_boas value for this DetalheProducaoDTO.
     * 
     * @return prod_boas
     */
    public double getProd_boas() {
        return prod_boas;
    }


    /**
     * Sets the prod_boas value for this DetalheProducaoDTO.
     * 
     * @param prod_boas
     */
    public void setProd_boas(double prod_boas) {
        this.prod_boas = prod_boas;
    }


    /**
     * Gets the prod_prevista value for this DetalheProducaoDTO.
     * 
     * @return prod_prevista
     */
    public double getProd_prevista() {
        return prod_prevista;
    }


    /**
     * Sets the prod_prevista value for this DetalheProducaoDTO.
     * 
     * @param prod_prevista
     */
    public void setProd_prevista(double prod_prevista) {
        this.prod_prevista = prod_prevista;
    }


    /**
     * Gets the prod_realizada value for this DetalheProducaoDTO.
     * 
     * @return prod_realizada
     */
    public double getProd_realizada() {
        return prod_realizada;
    }


    /**
     * Sets the prod_realizada value for this DetalheProducaoDTO.
     * 
     * @param prod_realizada
     */
    public void setProd_realizada(double prod_realizada) {
        this.prod_realizada = prod_realizada;
    }


    /**
     * Gets the prod_refugadas value for this DetalheProducaoDTO.
     * 
     * @return prod_refugadas
     */
    public double getProd_refugadas() {
        return prod_refugadas;
    }


    /**
     * Sets the prod_refugadas value for this DetalheProducaoDTO.
     * 
     * @param prod_refugadas
     */
    public void setProd_refugadas(double prod_refugadas) {
        this.prod_refugadas = prod_refugadas;
    }


    /**
     * Gets the produto value for this DetalheProducaoDTO.
     * 
     * @return produto
     */
    public java.lang.String getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this DetalheProducaoDTO.
     * 
     * @param produto
     */
    public void setProduto(java.lang.String produto) {
        this.produto = produto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalheProducaoDTO)) return false;
        DetalheProducaoDTO other = (DetalheProducaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.eficiencia_ciclo == other.getEficiencia_ciclo() &&
            this.eficiencia_realizacao == other.getEficiencia_realizacao() &&
            ((this.ferramenta==null && other.getFerramenta()==null) || 
             (this.ferramenta!=null &&
              this.ferramenta.equals(other.getFerramenta()))) &&
            ((this.ferramenta_agrupada==null && other.getFerramenta_agrupada()==null) || 
             (this.ferramenta_agrupada!=null &&
              this.ferramenta_agrupada.equals(other.getFerramenta_agrupada()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            this.perdas_ciclo == other.getPerdas_ciclo() &&
            this.prod_boas == other.getProd_boas() &&
            this.prod_prevista == other.getProd_prevista() &&
            this.prod_realizada == other.getProd_realizada() &&
            this.prod_refugadas == other.getProd_refugadas() &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto())));
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
        _hashCode += new Double(getEficiencia_ciclo()).hashCode();
        _hashCode += new Double(getEficiencia_realizacao()).hashCode();
        if (getFerramenta() != null) {
            _hashCode += getFerramenta().hashCode();
        }
        if (getFerramenta_agrupada() != null) {
            _hashCode += getFerramenta_agrupada().hashCode();
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        _hashCode += new Double(getPerdas_ciclo()).hashCode();
        _hashCode += new Double(getProd_boas()).hashCode();
        _hashCode += new Double(getProd_prevista()).hashCode();
        _hashCode += new Double(getProd_realizada()).hashCode();
        _hashCode += new Double(getProd_refugadas()).hashCode();
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalheProducaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheProducaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficiencia_ciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficiencia_ciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficiencia_realizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficiencia_realizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("ferramenta_agrupada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ferramenta_agrupada"));
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
        elemField.setFieldName("perdas_ciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdas_ciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prod_boas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prod_boas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prod_prevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prod_prevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prod_realizada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prod_realizada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prod_refugadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prod_refugadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
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
