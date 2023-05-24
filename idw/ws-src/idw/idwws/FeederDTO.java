/**
 * FeederDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FeederDTO  implements java.io.Serializable {
    private java.lang.String componente;

    private java.lang.Boolean isErro;

    private java.lang.String modulo;

    private java.lang.String origem;

    private int quantidadeErro;

    private int quantidadeUsada;

    private java.lang.String slot;

    public FeederDTO() {
    }

    public FeederDTO(
           java.lang.String componente,
           java.lang.Boolean isErro,
           java.lang.String modulo,
           java.lang.String origem,
           int quantidadeErro,
           int quantidadeUsada,
           java.lang.String slot) {
           this.componente = componente;
           this.isErro = isErro;
           this.modulo = modulo;
           this.origem = origem;
           this.quantidadeErro = quantidadeErro;
           this.quantidadeUsada = quantidadeUsada;
           this.slot = slot;
    }


    /**
     * Gets the componente value for this FeederDTO.
     * 
     * @return componente
     */
    public java.lang.String getComponente() {
        return componente;
    }


    /**
     * Sets the componente value for this FeederDTO.
     * 
     * @param componente
     */
    public void setComponente(java.lang.String componente) {
        this.componente = componente;
    }


    /**
     * Gets the isErro value for this FeederDTO.
     * 
     * @return isErro
     */
    public java.lang.Boolean getIsErro() {
        return isErro;
    }


    /**
     * Sets the isErro value for this FeederDTO.
     * 
     * @param isErro
     */
    public void setIsErro(java.lang.Boolean isErro) {
        this.isErro = isErro;
    }


    /**
     * Gets the modulo value for this FeederDTO.
     * 
     * @return modulo
     */
    public java.lang.String getModulo() {
        return modulo;
    }


    /**
     * Sets the modulo value for this FeederDTO.
     * 
     * @param modulo
     */
    public void setModulo(java.lang.String modulo) {
        this.modulo = modulo;
    }


    /**
     * Gets the origem value for this FeederDTO.
     * 
     * @return origem
     */
    public java.lang.String getOrigem() {
        return origem;
    }


    /**
     * Sets the origem value for this FeederDTO.
     * 
     * @param origem
     */
    public void setOrigem(java.lang.String origem) {
        this.origem = origem;
    }


    /**
     * Gets the quantidadeErro value for this FeederDTO.
     * 
     * @return quantidadeErro
     */
    public int getQuantidadeErro() {
        return quantidadeErro;
    }


    /**
     * Sets the quantidadeErro value for this FeederDTO.
     * 
     * @param quantidadeErro
     */
    public void setQuantidadeErro(int quantidadeErro) {
        this.quantidadeErro = quantidadeErro;
    }


    /**
     * Gets the quantidadeUsada value for this FeederDTO.
     * 
     * @return quantidadeUsada
     */
    public int getQuantidadeUsada() {
        return quantidadeUsada;
    }


    /**
     * Sets the quantidadeUsada value for this FeederDTO.
     * 
     * @param quantidadeUsada
     */
    public void setQuantidadeUsada(int quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }


    /**
     * Gets the slot value for this FeederDTO.
     * 
     * @return slot
     */
    public java.lang.String getSlot() {
        return slot;
    }


    /**
     * Sets the slot value for this FeederDTO.
     * 
     * @param slot
     */
    public void setSlot(java.lang.String slot) {
        this.slot = slot;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FeederDTO)) return false;
        FeederDTO other = (FeederDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.componente==null && other.getComponente()==null) || 
             (this.componente!=null &&
              this.componente.equals(other.getComponente()))) &&
            ((this.isErro==null && other.getIsErro()==null) || 
             (this.isErro!=null &&
              this.isErro.equals(other.getIsErro()))) &&
            ((this.modulo==null && other.getModulo()==null) || 
             (this.modulo!=null &&
              this.modulo.equals(other.getModulo()))) &&
            ((this.origem==null && other.getOrigem()==null) || 
             (this.origem!=null &&
              this.origem.equals(other.getOrigem()))) &&
            this.quantidadeErro == other.getQuantidadeErro() &&
            this.quantidadeUsada == other.getQuantidadeUsada() &&
            ((this.slot==null && other.getSlot()==null) || 
             (this.slot!=null &&
              this.slot.equals(other.getSlot())));
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
        if (getComponente() != null) {
            _hashCode += getComponente().hashCode();
        }
        if (getIsErro() != null) {
            _hashCode += getIsErro().hashCode();
        }
        if (getModulo() != null) {
            _hashCode += getModulo().hashCode();
        }
        if (getOrigem() != null) {
            _hashCode += getOrigem().hashCode();
        }
        _hashCode += getQuantidadeErro();
        _hashCode += getQuantidadeUsada();
        if (getSlot() != null) {
            _hashCode += getSlot().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FeederDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "feederDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "componente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("quantidadeErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidadeErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadeUsada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidadeUsada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("slot");
        elemField.setXmlName(new javax.xml.namespace.QName("", "slot"));
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
