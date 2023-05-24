/**
 * UsuarioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class UsuarioDTO  implements java.io.Serializable {
    private int ERRO_CARGO_DESCONHECIDO;

    private int ERRO_CC_DESCONHECIDO;

    private int ERRO_CDUSR_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_GRUPO_DESCONHECIDO;

    private int ERRO_LOGIN_INVALIDO;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_USUARIO_JA_EXISTE;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.HomologacoesDTO homologacoes;

    private int resultadoEvento;

    private idw.idwws.OmUsr usuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(
           int ERRO_CARGO_DESCONHECIDO,
           int ERRO_CC_DESCONHECIDO,
           int ERRO_CDUSR_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_GRUPO_DESCONHECIDO,
           int ERRO_LOGIN_INVALIDO,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_USUARIO_JA_EXISTE,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.HomologacoesDTO homologacoes,
           int resultadoEvento,
           idw.idwws.OmUsr usuario) {
           this.ERRO_CARGO_DESCONHECIDO = ERRO_CARGO_DESCONHECIDO;
           this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
           this.ERRO_CDUSR_INVALIDO = ERRO_CDUSR_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_GRUPO_DESCONHECIDO = ERRO_GRUPO_DESCONHECIDO;
           this.ERRO_LOGIN_INVALIDO = ERRO_LOGIN_INVALIDO;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_USUARIO_JA_EXISTE = ERRO_USUARIO_JA_EXISTE;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.homologacoes = homologacoes;
           this.resultadoEvento = resultadoEvento;
           this.usuario = usuario;
    }


    /**
     * Gets the ERRO_CARGO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @return ERRO_CARGO_DESCONHECIDO
     */
    public int getERRO_CARGO_DESCONHECIDO() {
        return ERRO_CARGO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CARGO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @param ERRO_CARGO_DESCONHECIDO
     */
    public void setERRO_CARGO_DESCONHECIDO(int ERRO_CARGO_DESCONHECIDO) {
        this.ERRO_CARGO_DESCONHECIDO = ERRO_CARGO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CC_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @return ERRO_CC_DESCONHECIDO
     */
    public int getERRO_CC_DESCONHECIDO() {
        return ERRO_CC_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CC_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @param ERRO_CC_DESCONHECIDO
     */
    public void setERRO_CC_DESCONHECIDO(int ERRO_CC_DESCONHECIDO) {
        this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CDUSR_INVALIDO value for this UsuarioDTO.
     * 
     * @return ERRO_CDUSR_INVALIDO
     */
    public int getERRO_CDUSR_INVALIDO() {
        return ERRO_CDUSR_INVALIDO;
    }


    /**
     * Sets the ERRO_CDUSR_INVALIDO value for this UsuarioDTO.
     * 
     * @param ERRO_CDUSR_INVALIDO
     */
    public void setERRO_CDUSR_INVALIDO(int ERRO_CDUSR_INVALIDO) {
        this.ERRO_CDUSR_INVALIDO = ERRO_CDUSR_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_GRUPO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @return ERRO_GRUPO_DESCONHECIDO
     */
    public int getERRO_GRUPO_DESCONHECIDO() {
        return ERRO_GRUPO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_GRUPO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @param ERRO_GRUPO_DESCONHECIDO
     */
    public void setERRO_GRUPO_DESCONHECIDO(int ERRO_GRUPO_DESCONHECIDO) {
        this.ERRO_GRUPO_DESCONHECIDO = ERRO_GRUPO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_LOGIN_INVALIDO value for this UsuarioDTO.
     * 
     * @return ERRO_LOGIN_INVALIDO
     */
    public int getERRO_LOGIN_INVALIDO() {
        return ERRO_LOGIN_INVALIDO;
    }


    /**
     * Sets the ERRO_LOGIN_INVALIDO value for this UsuarioDTO.
     * 
     * @param ERRO_LOGIN_INVALIDO
     */
    public void setERRO_LOGIN_INVALIDO(int ERRO_LOGIN_INVALIDO) {
        this.ERRO_LOGIN_INVALIDO = ERRO_LOGIN_INVALIDO;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this UsuarioDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this UsuarioDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_USUARIO_JA_EXISTE value for this UsuarioDTO.
     * 
     * @return ERRO_USUARIO_JA_EXISTE
     */
    public int getERRO_USUARIO_JA_EXISTE() {
        return ERRO_USUARIO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_USUARIO_JA_EXISTE value for this UsuarioDTO.
     * 
     * @param ERRO_USUARIO_JA_EXISTE
     */
    public void setERRO_USUARIO_JA_EXISTE(int ERRO_USUARIO_JA_EXISTE) {
        this.ERRO_USUARIO_JA_EXISTE = ERRO_USUARIO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this UsuarioDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this UsuarioDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this UsuarioDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the homologacoes value for this UsuarioDTO.
     * 
     * @return homologacoes
     */
    public idw.idwws.HomologacoesDTO getHomologacoes() {
        return homologacoes;
    }


    /**
     * Sets the homologacoes value for this UsuarioDTO.
     * 
     * @param homologacoes
     */
    public void setHomologacoes(idw.idwws.HomologacoesDTO homologacoes) {
        this.homologacoes = homologacoes;
    }


    /**
     * Gets the resultadoEvento value for this UsuarioDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this UsuarioDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the usuario value for this UsuarioDTO.
     * 
     * @return usuario
     */
    public idw.idwws.OmUsr getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this UsuarioDTO.
     * 
     * @param usuario
     */
    public void setUsuario(idw.idwws.OmUsr usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UsuarioDTO)) return false;
        UsuarioDTO other = (UsuarioDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_CARGO_DESCONHECIDO == other.getERRO_CARGO_DESCONHECIDO() &&
            this.ERRO_CC_DESCONHECIDO == other.getERRO_CC_DESCONHECIDO() &&
            this.ERRO_CDUSR_INVALIDO == other.getERRO_CDUSR_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_GRUPO_DESCONHECIDO == other.getERRO_GRUPO_DESCONHECIDO() &&
            this.ERRO_LOGIN_INVALIDO == other.getERRO_LOGIN_INVALIDO() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_USUARIO_JA_EXISTE == other.getERRO_USUARIO_JA_EXISTE() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.homologacoes==null && other.getHomologacoes()==null) || 
             (this.homologacoes!=null &&
              this.homologacoes.equals(other.getHomologacoes()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
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
        _hashCode += getERRO_CARGO_DESCONHECIDO();
        _hashCode += getERRO_CC_DESCONHECIDO();
        _hashCode += getERRO_CDUSR_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_GRUPO_DESCONHECIDO();
        _hashCode += getERRO_LOGIN_INVALIDO();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_USUARIO_JA_EXISTE();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getHomologacoes() != null) {
            _hashCode += getHomologacoes().hashCode();
        }
        _hashCode += getResultadoEvento();
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UsuarioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "usuarioDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CARGO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CARGO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CC_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CC_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDUSR_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDUSR_INVALIDO"));
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
        elemField.setFieldName("ERRO_GRUPO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_GRUPO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_LOGIN_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_LOGIN_INVALIDO"));
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
        elemField.setFieldName("ERRO_USUARIO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_JA_EXISTE"));
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
        elemField.setFieldName("homologacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "homologacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "homologacoesDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
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
