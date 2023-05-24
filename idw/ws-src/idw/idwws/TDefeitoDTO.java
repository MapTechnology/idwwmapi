/**
 * TDefeitoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TDefeitoDTO  implements java.io.Serializable {
    private idw.idwws.DwTDefeito defeito;

    private int ERRO_CDDEFEITO_INVALIDO;

    private int ERRO_COMPONENTE_DESCONHECIDO;

    private int ERRO_DEFEITO_JA_EXISTE;

    private int ERRO_DESCONHECIDO;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_TIPOPOSTO_DESCONHECIDO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    public TDefeitoDTO() {
    }

    public TDefeitoDTO(
           idw.idwws.DwTDefeito defeito,
           int ERRO_CDDEFEITO_INVALIDO,
           int ERRO_COMPONENTE_DESCONHECIDO,
           int ERRO_DEFEITO_JA_EXISTE,
           int ERRO_DESCONHECIDO,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_TIPOPOSTO_DESCONHECIDO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento) {
           this.defeito = defeito;
           this.ERRO_CDDEFEITO_INVALIDO = ERRO_CDDEFEITO_INVALIDO;
           this.ERRO_COMPONENTE_DESCONHECIDO = ERRO_COMPONENTE_DESCONHECIDO;
           this.ERRO_DEFEITO_JA_EXISTE = ERRO_DEFEITO_JA_EXISTE;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the defeito value for this TDefeitoDTO.
     * 
     * @return defeito
     */
    public idw.idwws.DwTDefeito getDefeito() {
        return defeito;
    }


    /**
     * Sets the defeito value for this TDefeitoDTO.
     * 
     * @param defeito
     */
    public void setDefeito(idw.idwws.DwTDefeito defeito) {
        this.defeito = defeito;
    }


    /**
     * Gets the ERRO_CDDEFEITO_INVALIDO value for this TDefeitoDTO.
     * 
     * @return ERRO_CDDEFEITO_INVALIDO
     */
    public int getERRO_CDDEFEITO_INVALIDO() {
        return ERRO_CDDEFEITO_INVALIDO;
    }


    /**
     * Sets the ERRO_CDDEFEITO_INVALIDO value for this TDefeitoDTO.
     * 
     * @param ERRO_CDDEFEITO_INVALIDO
     */
    public void setERRO_CDDEFEITO_INVALIDO(int ERRO_CDDEFEITO_INVALIDO) {
        this.ERRO_CDDEFEITO_INVALIDO = ERRO_CDDEFEITO_INVALIDO;
    }


    /**
     * Gets the ERRO_COMPONENTE_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @return ERRO_COMPONENTE_DESCONHECIDO
     */
    public int getERRO_COMPONENTE_DESCONHECIDO() {
        return ERRO_COMPONENTE_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_COMPONENTE_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @param ERRO_COMPONENTE_DESCONHECIDO
     */
    public void setERRO_COMPONENTE_DESCONHECIDO(int ERRO_COMPONENTE_DESCONHECIDO) {
        this.ERRO_COMPONENTE_DESCONHECIDO = ERRO_COMPONENTE_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DEFEITO_JA_EXISTE value for this TDefeitoDTO.
     * 
     * @return ERRO_DEFEITO_JA_EXISTE
     */
    public int getERRO_DEFEITO_JA_EXISTE() {
        return ERRO_DEFEITO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_DEFEITO_JA_EXISTE value for this TDefeitoDTO.
     * 
     * @param ERRO_DEFEITO_JA_EXISTE
     */
    public void setERRO_DEFEITO_JA_EXISTE(int ERRO_DEFEITO_JA_EXISTE) {
        this.ERRO_DEFEITO_JA_EXISTE = ERRO_DEFEITO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this TDefeitoDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this TDefeitoDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_TIPOPOSTO_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @return ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public int getERRO_TIPOPOSTO_DESCONHECIDO() {
        return ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TIPOPOSTO_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @param ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public void setERRO_TIPOPOSTO_DESCONHECIDO(int ERRO_TIPOPOSTO_DESCONHECIDO) {
        this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this TDefeitoDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this TDefeitoDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this TDefeitoDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this TDefeitoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this TDefeitoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TDefeitoDTO)) return false;
        TDefeitoDTO other = (TDefeitoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.defeito==null && other.getDefeito()==null) || 
             (this.defeito!=null &&
              this.defeito.equals(other.getDefeito()))) &&
            this.ERRO_CDDEFEITO_INVALIDO == other.getERRO_CDDEFEITO_INVALIDO() &&
            this.ERRO_COMPONENTE_DESCONHECIDO == other.getERRO_COMPONENTE_DESCONHECIDO() &&
            this.ERRO_DEFEITO_JA_EXISTE == other.getERRO_DEFEITO_JA_EXISTE() &&
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
        if (getDefeito() != null) {
            _hashCode += getDefeito().hashCode();
        }
        _hashCode += getERRO_CDDEFEITO_INVALIDO();
        _hashCode += getERRO_COMPONENTE_DESCONHECIDO();
        _hashCode += getERRO_DEFEITO_JA_EXISTE();
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
        new org.apache.axis.description.TypeDesc(TDefeitoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "tDefeitoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defeito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDDEFEITO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDDEFEITO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_COMPONENTE_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_COMPONENTE_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DEFEITO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DEFEITO_JA_EXISTE"));
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
