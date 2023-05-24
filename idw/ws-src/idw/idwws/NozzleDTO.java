/**
 * NozzleDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class NozzleDTO  implements java.io.Serializable {
    private java.lang.String cabeca;

    private java.lang.String modulo;

    private java.lang.String origem;

    private java.lang.String posicao;

    private int quantidadUsada;

    public NozzleDTO() {
    }

    public NozzleDTO(
           java.lang.String cabeca,
           java.lang.String modulo,
           java.lang.String origem,
           java.lang.String posicao,
           int quantidadUsada) {
           this.cabeca = cabeca;
           this.modulo = modulo;
           this.origem = origem;
           this.posicao = posicao;
           this.quantidadUsada = quantidadUsada;
    }


    /**
     * Gets the cabeca value for this NozzleDTO.
     * 
     * @return cabeca
     */
    public java.lang.String getCabeca() {
        return cabeca;
    }


    /**
     * Sets the cabeca value for this NozzleDTO.
     * 
     * @param cabeca
     */
    public void setCabeca(java.lang.String cabeca) {
        this.cabeca = cabeca;
    }


    /**
     * Gets the modulo value for this NozzleDTO.
     * 
     * @return modulo
     */
    public java.lang.String getModulo() {
        return modulo;
    }


    /**
     * Sets the modulo value for this NozzleDTO.
     * 
     * @param modulo
     */
    public void setModulo(java.lang.String modulo) {
        this.modulo = modulo;
    }


    /**
     * Gets the origem value for this NozzleDTO.
     * 
     * @return origem
     */
    public java.lang.String getOrigem() {
        return origem;
    }


    /**
     * Sets the origem value for this NozzleDTO.
     * 
     * @param origem
     */
    public void setOrigem(java.lang.String origem) {
        this.origem = origem;
    }


    /**
     * Gets the posicao value for this NozzleDTO.
     * 
     * @return posicao
     */
    public java.lang.String getPosicao() {
        return posicao;
    }


    /**
     * Sets the posicao value for this NozzleDTO.
     * 
     * @param posicao
     */
    public void setPosicao(java.lang.String posicao) {
        this.posicao = posicao;
    }


    /**
     * Gets the quantidadUsada value for this NozzleDTO.
     * 
     * @return quantidadUsada
     */
    public int getQuantidadUsada() {
        return quantidadUsada;
    }


    /**
     * Sets the quantidadUsada value for this NozzleDTO.
     * 
     * @param quantidadUsada
     */
    public void setQuantidadUsada(int quantidadUsada) {
        this.quantidadUsada = quantidadUsada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NozzleDTO)) return false;
        NozzleDTO other = (NozzleDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cabeca==null && other.getCabeca()==null) || 
             (this.cabeca!=null &&
              this.cabeca.equals(other.getCabeca()))) &&
            ((this.modulo==null && other.getModulo()==null) || 
             (this.modulo!=null &&
              this.modulo.equals(other.getModulo()))) &&
            ((this.origem==null && other.getOrigem()==null) || 
             (this.origem!=null &&
              this.origem.equals(other.getOrigem()))) &&
            ((this.posicao==null && other.getPosicao()==null) || 
             (this.posicao!=null &&
              this.posicao.equals(other.getPosicao()))) &&
            this.quantidadUsada == other.getQuantidadUsada();
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
        if (getCabeca() != null) {
            _hashCode += getCabeca().hashCode();
        }
        if (getModulo() != null) {
            _hashCode += getModulo().hashCode();
        }
        if (getOrigem() != null) {
            _hashCode += getOrigem().hashCode();
        }
        if (getPosicao() != null) {
            _hashCode += getPosicao().hashCode();
        }
        _hashCode += getQuantidadUsada();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NozzleDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "nozzleDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cabeca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cabeca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadUsada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidadUsada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
