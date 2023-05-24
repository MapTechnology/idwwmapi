/**
 * TAcaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TAcaoDTO  implements java.io.Serializable {
    private idw.idwws.DwTAcao acao;

    private int ERRO_ACAO_JA_EXISTE;

    private int ERRO_CDACAO_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_TIPOPOSTO_DESCONHECIDO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    public TAcaoDTO() {
    }

    public TAcaoDTO(
           idw.idwws.DwTAcao acao,
           int ERRO_ACAO_JA_EXISTE,
           int ERRO_CDACAO_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_TIPOPOSTO_DESCONHECIDO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento) {
           this.acao = acao;
           this.ERRO_ACAO_JA_EXISTE = ERRO_ACAO_JA_EXISTE;
           this.ERRO_CDACAO_INVALIDO = ERRO_CDACAO_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the acao value for this TAcaoDTO.
     * 
     * @return acao
     */
    public idw.idwws.DwTAcao getAcao() {
        return acao;
    }


    /**
     * Sets the acao value for this TAcaoDTO.
     * 
     * @param acao
     */
    public void setAcao(idw.idwws.DwTAcao acao) {
        this.acao = acao;
    }


    /**
     * Gets the ERRO_ACAO_JA_EXISTE value for this TAcaoDTO.
     * 
     * @return ERRO_ACAO_JA_EXISTE
     */
    public int getERRO_ACAO_JA_EXISTE() {
        return ERRO_ACAO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_ACAO_JA_EXISTE value for this TAcaoDTO.
     * 
     * @param ERRO_ACAO_JA_EXISTE
     */
    public void setERRO_ACAO_JA_EXISTE(int ERRO_ACAO_JA_EXISTE) {
        this.ERRO_ACAO_JA_EXISTE = ERRO_ACAO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_CDACAO_INVALIDO value for this TAcaoDTO.
     * 
     * @return ERRO_CDACAO_INVALIDO
     */
    public int getERRO_CDACAO_INVALIDO() {
        return ERRO_CDACAO_INVALIDO;
    }


    /**
     * Sets the ERRO_CDACAO_INVALIDO value for this TAcaoDTO.
     * 
     * @param ERRO_CDACAO_INVALIDO
     */
    public void setERRO_CDACAO_INVALIDO(int ERRO_CDACAO_INVALIDO) {
        this.ERRO_CDACAO_INVALIDO = ERRO_CDACAO_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this TAcaoDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this TAcaoDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_TIPOPOSTO_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @return ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public int getERRO_TIPOPOSTO_DESCONHECIDO() {
        return ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TIPOPOSTO_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @param ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public void setERRO_TIPOPOSTO_DESCONHECIDO(int ERRO_TIPOPOSTO_DESCONHECIDO) {
        this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this TAcaoDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this TAcaoDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this TAcaoDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this TAcaoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this TAcaoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TAcaoDTO)) return false;
        TAcaoDTO other = (TAcaoDTO) obj;
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
            this.ERRO_ACAO_JA_EXISTE == other.getERRO_ACAO_JA_EXISTE() &&
            this.ERRO_CDACAO_INVALIDO == other.getERRO_CDACAO_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_TIPOPOSTO_DESCONHECIDO == other.getERRO_TIPOPOSTO_DESCONHECIDO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            this.resultadoEvento == other.getResultadoEvento();
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
        _hashCode += getERRO_ACAO_JA_EXISTE();
        _hashCode += getERRO_CDACAO_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_TIPOPOSTO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TAcaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "tAcaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_ACAO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_ACAO_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDACAO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDACAO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_REATIVACAO_INDISPONIVEL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_REATIVACAO_INDISPONIVEL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPOPOSTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPOPOSTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_REVISAO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_REVISAO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_STATUS_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_STATUS_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
