/**
 * EtiquetaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EtiquetaDTO  implements java.io.Serializable {
    private java.lang.String codigoBarra;

    private java.lang.String descricao;

    private java.lang.String descricao2;

    private java.lang.String descricao3;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    private java.lang.String script;

    public EtiquetaDTO() {
    }

    public EtiquetaDTO(
           java.lang.String codigoBarra,
           java.lang.String descricao,
           java.lang.String descricao2,
           java.lang.String descricao3,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento,
           java.lang.String script) {
           this.codigoBarra = codigoBarra;
           this.descricao = descricao;
           this.descricao2 = descricao2;
           this.descricao3 = descricao3;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
           this.script = script;
    }


    /**
     * Gets the codigoBarra value for this EtiquetaDTO.
     * 
     * @return codigoBarra
     */
    public java.lang.String getCodigoBarra() {
        return codigoBarra;
    }


    /**
     * Sets the codigoBarra value for this EtiquetaDTO.
     * 
     * @param codigoBarra
     */
    public void setCodigoBarra(java.lang.String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }


    /**
     * Gets the descricao value for this EtiquetaDTO.
     * 
     * @return descricao
     */
    public java.lang.String getDescricao() {
        return descricao;
    }


    /**
     * Sets the descricao value for this EtiquetaDTO.
     * 
     * @param descricao
     */
    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }


    /**
     * Gets the descricao2 value for this EtiquetaDTO.
     * 
     * @return descricao2
     */
    public java.lang.String getDescricao2() {
        return descricao2;
    }


    /**
     * Sets the descricao2 value for this EtiquetaDTO.
     * 
     * @param descricao2
     */
    public void setDescricao2(java.lang.String descricao2) {
        this.descricao2 = descricao2;
    }


    /**
     * Gets the descricao3 value for this EtiquetaDTO.
     * 
     * @return descricao3
     */
    public java.lang.String getDescricao3() {
        return descricao3;
    }


    /**
     * Sets the descricao3 value for this EtiquetaDTO.
     * 
     * @param descricao3
     */
    public void setDescricao3(java.lang.String descricao3) {
        this.descricao3 = descricao3;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this EtiquetaDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this EtiquetaDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this EtiquetaDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this EtiquetaDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the script value for this EtiquetaDTO.
     * 
     * @return script
     */
    public java.lang.String getScript() {
        return script;
    }


    /**
     * Sets the script value for this EtiquetaDTO.
     * 
     * @param script
     */
    public void setScript(java.lang.String script) {
        this.script = script;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EtiquetaDTO)) return false;
        EtiquetaDTO other = (EtiquetaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoBarra==null && other.getCodigoBarra()==null) || 
             (this.codigoBarra!=null &&
              this.codigoBarra.equals(other.getCodigoBarra()))) &&
            ((this.descricao==null && other.getDescricao()==null) || 
             (this.descricao!=null &&
              this.descricao.equals(other.getDescricao()))) &&
            ((this.descricao2==null && other.getDescricao2()==null) || 
             (this.descricao2!=null &&
              this.descricao2.equals(other.getDescricao2()))) &&
            ((this.descricao3==null && other.getDescricao3()==null) || 
             (this.descricao3!=null &&
              this.descricao3.equals(other.getDescricao3()))) &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.script==null && other.getScript()==null) || 
             (this.script!=null &&
              this.script.equals(other.getScript())));
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
        if (getCodigoBarra() != null) {
            _hashCode += getCodigoBarra().hashCode();
        }
        if (getDescricao() != null) {
            _hashCode += getDescricao().hashCode();
        }
        if (getDescricao2() != null) {
            _hashCode += getDescricao2().hashCode();
        }
        if (getDescricao3() != null) {
            _hashCode += getDescricao3().hashCode();
        }
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += getResultadoEvento();
        if (getScript() != null) {
            _hashCode += getScript().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EtiquetaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "etiquetaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoBarra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoBarra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricao2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricao2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricao3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricao3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("script");
        elemField.setXmlName(new javax.xml.namespace.QName("", "script"));
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
