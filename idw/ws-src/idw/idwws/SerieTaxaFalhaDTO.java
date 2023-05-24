/**
 * SerieTaxaFalhaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class SerieTaxaFalhaDTO  implements java.io.Serializable {
    private java.lang.String descricao;

    private java.util.Calendar fimIndice;

    private java.lang.Double indiceFalha;

    private java.util.Calendar inicioIndice;

    private java.math.BigDecimal producaoBruta;

    private java.math.BigDecimal qtdeFalhas;

    public SerieTaxaFalhaDTO() {
    }

    public SerieTaxaFalhaDTO(
           java.lang.String descricao,
           java.util.Calendar fimIndice,
           java.lang.Double indiceFalha,
           java.util.Calendar inicioIndice,
           java.math.BigDecimal producaoBruta,
           java.math.BigDecimal qtdeFalhas) {
           this.descricao = descricao;
           this.fimIndice = fimIndice;
           this.indiceFalha = indiceFalha;
           this.inicioIndice = inicioIndice;
           this.producaoBruta = producaoBruta;
           this.qtdeFalhas = qtdeFalhas;
    }


    /**
     * Gets the descricao value for this SerieTaxaFalhaDTO.
     * 
     * @return descricao
     */
    public java.lang.String getDescricao() {
        return descricao;
    }


    /**
     * Sets the descricao value for this SerieTaxaFalhaDTO.
     * 
     * @param descricao
     */
    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }


    /**
     * Gets the fimIndice value for this SerieTaxaFalhaDTO.
     * 
     * @return fimIndice
     */
    public java.util.Calendar getFimIndice() {
        return fimIndice;
    }


    /**
     * Sets the fimIndice value for this SerieTaxaFalhaDTO.
     * 
     * @param fimIndice
     */
    public void setFimIndice(java.util.Calendar fimIndice) {
        this.fimIndice = fimIndice;
    }


    /**
     * Gets the indiceFalha value for this SerieTaxaFalhaDTO.
     * 
     * @return indiceFalha
     */
    public java.lang.Double getIndiceFalha() {
        return indiceFalha;
    }


    /**
     * Sets the indiceFalha value for this SerieTaxaFalhaDTO.
     * 
     * @param indiceFalha
     */
    public void setIndiceFalha(java.lang.Double indiceFalha) {
        this.indiceFalha = indiceFalha;
    }


    /**
     * Gets the inicioIndice value for this SerieTaxaFalhaDTO.
     * 
     * @return inicioIndice
     */
    public java.util.Calendar getInicioIndice() {
        return inicioIndice;
    }


    /**
     * Sets the inicioIndice value for this SerieTaxaFalhaDTO.
     * 
     * @param inicioIndice
     */
    public void setInicioIndice(java.util.Calendar inicioIndice) {
        this.inicioIndice = inicioIndice;
    }


    /**
     * Gets the producaoBruta value for this SerieTaxaFalhaDTO.
     * 
     * @return producaoBruta
     */
    public java.math.BigDecimal getProducaoBruta() {
        return producaoBruta;
    }


    /**
     * Sets the producaoBruta value for this SerieTaxaFalhaDTO.
     * 
     * @param producaoBruta
     */
    public void setProducaoBruta(java.math.BigDecimal producaoBruta) {
        this.producaoBruta = producaoBruta;
    }


    /**
     * Gets the qtdeFalhas value for this SerieTaxaFalhaDTO.
     * 
     * @return qtdeFalhas
     */
    public java.math.BigDecimal getQtdeFalhas() {
        return qtdeFalhas;
    }


    /**
     * Sets the qtdeFalhas value for this SerieTaxaFalhaDTO.
     * 
     * @param qtdeFalhas
     */
    public void setQtdeFalhas(java.math.BigDecimal qtdeFalhas) {
        this.qtdeFalhas = qtdeFalhas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SerieTaxaFalhaDTO)) return false;
        SerieTaxaFalhaDTO other = (SerieTaxaFalhaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descricao==null && other.getDescricao()==null) || 
             (this.descricao!=null &&
              this.descricao.equals(other.getDescricao()))) &&
            ((this.fimIndice==null && other.getFimIndice()==null) || 
             (this.fimIndice!=null &&
              this.fimIndice.equals(other.getFimIndice()))) &&
            ((this.indiceFalha==null && other.getIndiceFalha()==null) || 
             (this.indiceFalha!=null &&
              this.indiceFalha.equals(other.getIndiceFalha()))) &&
            ((this.inicioIndice==null && other.getInicioIndice()==null) || 
             (this.inicioIndice!=null &&
              this.inicioIndice.equals(other.getInicioIndice()))) &&
            ((this.producaoBruta==null && other.getProducaoBruta()==null) || 
             (this.producaoBruta!=null &&
              this.producaoBruta.equals(other.getProducaoBruta()))) &&
            ((this.qtdeFalhas==null && other.getQtdeFalhas()==null) || 
             (this.qtdeFalhas!=null &&
              this.qtdeFalhas.equals(other.getQtdeFalhas())));
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
        if (getDescricao() != null) {
            _hashCode += getDescricao().hashCode();
        }
        if (getFimIndice() != null) {
            _hashCode += getFimIndice().hashCode();
        }
        if (getIndiceFalha() != null) {
            _hashCode += getIndiceFalha().hashCode();
        }
        if (getInicioIndice() != null) {
            _hashCode += getInicioIndice().hashCode();
        }
        if (getProducaoBruta() != null) {
            _hashCode += getProducaoBruta().hashCode();
        }
        if (getQtdeFalhas() != null) {
            _hashCode += getQtdeFalhas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SerieTaxaFalhaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "serieTaxaFalhaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoBruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoBruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeFalhas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeFalhas"));
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
