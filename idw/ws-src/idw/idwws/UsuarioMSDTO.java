/**
 * UsuarioMSDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class UsuarioMSDTO  implements java.io.Serializable {
    private java.lang.String cdusuario;

    private java.util.Calendar dthrLogin;

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

    private java.lang.Long idUsr;

    private java.lang.String login;

    private idw.idwws.MsUsr msusr;

    private java.lang.String nome;

    private int resultadoEvento;

    private java.lang.String senha;

    public UsuarioMSDTO() {
    }

    public UsuarioMSDTO(
           java.lang.String cdusuario,
           java.util.Calendar dthrLogin,
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
           java.lang.Long idUsr,
           java.lang.String login,
           idw.idwws.MsUsr msusr,
           java.lang.String nome,
           int resultadoEvento,
           java.lang.String senha) {
           this.cdusuario = cdusuario;
           this.dthrLogin = dthrLogin;
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
           this.idUsr = idUsr;
           this.login = login;
           this.msusr = msusr;
           this.nome = nome;
           this.resultadoEvento = resultadoEvento;
           this.senha = senha;
    }


    /**
     * Gets the cdusuario value for this UsuarioMSDTO.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this UsuarioMSDTO.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the dthrLogin value for this UsuarioMSDTO.
     * 
     * @return dthrLogin
     */
    public java.util.Calendar getDthrLogin() {
        return dthrLogin;
    }


    /**
     * Sets the dthrLogin value for this UsuarioMSDTO.
     * 
     * @param dthrLogin
     */
    public void setDthrLogin(java.util.Calendar dthrLogin) {
        this.dthrLogin = dthrLogin;
    }


    /**
     * Gets the ERRO_CC_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @return ERRO_CC_DESCONHECIDO
     */
    public int getERRO_CC_DESCONHECIDO() {
        return ERRO_CC_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CC_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @param ERRO_CC_DESCONHECIDO
     */
    public void setERRO_CC_DESCONHECIDO(int ERRO_CC_DESCONHECIDO) {
        this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CDUSR_INVALIDO value for this UsuarioMSDTO.
     * 
     * @return ERRO_CDUSR_INVALIDO
     */
    public int getERRO_CDUSR_INVALIDO() {
        return ERRO_CDUSR_INVALIDO;
    }


    /**
     * Sets the ERRO_CDUSR_INVALIDO value for this UsuarioMSDTO.
     * 
     * @param ERRO_CDUSR_INVALIDO
     */
    public void setERRO_CDUSR_INVALIDO(int ERRO_CDUSR_INVALIDO) {
        this.ERRO_CDUSR_INVALIDO = ERRO_CDUSR_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_GRUPO_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @return ERRO_GRUPO_DESCONHECIDO
     */
    public int getERRO_GRUPO_DESCONHECIDO() {
        return ERRO_GRUPO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_GRUPO_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @param ERRO_GRUPO_DESCONHECIDO
     */
    public void setERRO_GRUPO_DESCONHECIDO(int ERRO_GRUPO_DESCONHECIDO) {
        this.ERRO_GRUPO_DESCONHECIDO = ERRO_GRUPO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_LOGIN_INVALIDO value for this UsuarioMSDTO.
     * 
     * @return ERRO_LOGIN_INVALIDO
     */
    public int getERRO_LOGIN_INVALIDO() {
        return ERRO_LOGIN_INVALIDO;
    }


    /**
     * Sets the ERRO_LOGIN_INVALIDO value for this UsuarioMSDTO.
     * 
     * @param ERRO_LOGIN_INVALIDO
     */
    public void setERRO_LOGIN_INVALIDO(int ERRO_LOGIN_INVALIDO) {
        this.ERRO_LOGIN_INVALIDO = ERRO_LOGIN_INVALIDO;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this UsuarioMSDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this UsuarioMSDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_USUARIO_JA_EXISTE value for this UsuarioMSDTO.
     * 
     * @return ERRO_USUARIO_JA_EXISTE
     */
    public int getERRO_USUARIO_JA_EXISTE() {
        return ERRO_USUARIO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_USUARIO_JA_EXISTE value for this UsuarioMSDTO.
     * 
     * @param ERRO_USUARIO_JA_EXISTE
     */
    public void setERRO_USUARIO_JA_EXISTE(int ERRO_USUARIO_JA_EXISTE) {
        this.ERRO_USUARIO_JA_EXISTE = ERRO_USUARIO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this UsuarioMSDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this UsuarioMSDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this UsuarioMSDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the idUsr value for this UsuarioMSDTO.
     * 
     * @return idUsr
     */
    public java.lang.Long getIdUsr() {
        return idUsr;
    }


    /**
     * Sets the idUsr value for this UsuarioMSDTO.
     * 
     * @param idUsr
     */
    public void setIdUsr(java.lang.Long idUsr) {
        this.idUsr = idUsr;
    }


    /**
     * Gets the login value for this UsuarioMSDTO.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this UsuarioMSDTO.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the msusr value for this UsuarioMSDTO.
     * 
     * @return msusr
     */
    public idw.idwws.MsUsr getMsusr() {
        return msusr;
    }


    /**
     * Sets the msusr value for this UsuarioMSDTO.
     * 
     * @param msusr
     */
    public void setMsusr(idw.idwws.MsUsr msusr) {
        this.msusr = msusr;
    }


    /**
     * Gets the nome value for this UsuarioMSDTO.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this UsuarioMSDTO.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the resultadoEvento value for this UsuarioMSDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this UsuarioMSDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the senha value for this UsuarioMSDTO.
     * 
     * @return senha
     */
    public java.lang.String getSenha() {
        return senha;
    }


    /**
     * Sets the senha value for this UsuarioMSDTO.
     * 
     * @param senha
     */
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UsuarioMSDTO)) return false;
        UsuarioMSDTO other = (UsuarioMSDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.dthrLogin==null && other.getDthrLogin()==null) || 
             (this.dthrLogin!=null &&
              this.dthrLogin.equals(other.getDthrLogin()))) &&
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
            ((this.idUsr==null && other.getIdUsr()==null) || 
             (this.idUsr!=null &&
              this.idUsr.equals(other.getIdUsr()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.msusr==null && other.getMsusr()==null) || 
             (this.msusr!=null &&
              this.msusr.equals(other.getMsusr()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.senha==null && other.getSenha()==null) || 
             (this.senha!=null &&
              this.senha.equals(other.getSenha())));
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
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getDthrLogin() != null) {
            _hashCode += getDthrLogin().hashCode();
        }
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
        if (getIdUsr() != null) {
            _hashCode += getIdUsr().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getMsusr() != null) {
            _hashCode += getMsusr().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        _hashCode += getResultadoEvento();
        if (getSenha() != null) {
            _hashCode += getSenha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UsuarioMSDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "usuarioMSDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrLogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrLogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("idUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msusr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msusr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("senha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senha"));
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
