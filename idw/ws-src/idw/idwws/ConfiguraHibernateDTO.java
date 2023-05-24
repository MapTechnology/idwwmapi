/**
 * ConfiguraHibernateDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ConfiguraHibernateDTO  implements java.io.Serializable {
    private java.lang.String autenticacao;

    private java.lang.String caminhoArquivo;

    private java.lang.String instanciaBanco;

    private java.lang.String nomeBanco;

    private java.lang.String nomeHost;

    private java.lang.String portaBanco;

    private java.lang.String senha;

    private java.lang.Integer tipoBanco;

    private java.lang.String usuario;

    public ConfiguraHibernateDTO() {
    }

    public ConfiguraHibernateDTO(
           java.lang.String autenticacao,
           java.lang.String caminhoArquivo,
           java.lang.String instanciaBanco,
           java.lang.String nomeBanco,
           java.lang.String nomeHost,
           java.lang.String portaBanco,
           java.lang.String senha,
           java.lang.Integer tipoBanco,
           java.lang.String usuario) {
           this.autenticacao = autenticacao;
           this.caminhoArquivo = caminhoArquivo;
           this.instanciaBanco = instanciaBanco;
           this.nomeBanco = nomeBanco;
           this.nomeHost = nomeHost;
           this.portaBanco = portaBanco;
           this.senha = senha;
           this.tipoBanco = tipoBanco;
           this.usuario = usuario;
    }


    /**
     * Gets the autenticacao value for this ConfiguraHibernateDTO.
     * 
     * @return autenticacao
     */
    public java.lang.String getAutenticacao() {
        return autenticacao;
    }


    /**
     * Sets the autenticacao value for this ConfiguraHibernateDTO.
     * 
     * @param autenticacao
     */
    public void setAutenticacao(java.lang.String autenticacao) {
        this.autenticacao = autenticacao;
    }


    /**
     * Gets the caminhoArquivo value for this ConfiguraHibernateDTO.
     * 
     * @return caminhoArquivo
     */
    public java.lang.String getCaminhoArquivo() {
        return caminhoArquivo;
    }


    /**
     * Sets the caminhoArquivo value for this ConfiguraHibernateDTO.
     * 
     * @param caminhoArquivo
     */
    public void setCaminhoArquivo(java.lang.String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }


    /**
     * Gets the instanciaBanco value for this ConfiguraHibernateDTO.
     * 
     * @return instanciaBanco
     */
    public java.lang.String getInstanciaBanco() {
        return instanciaBanco;
    }


    /**
     * Sets the instanciaBanco value for this ConfiguraHibernateDTO.
     * 
     * @param instanciaBanco
     */
    public void setInstanciaBanco(java.lang.String instanciaBanco) {
        this.instanciaBanco = instanciaBanco;
    }


    /**
     * Gets the nomeBanco value for this ConfiguraHibernateDTO.
     * 
     * @return nomeBanco
     */
    public java.lang.String getNomeBanco() {
        return nomeBanco;
    }


    /**
     * Sets the nomeBanco value for this ConfiguraHibernateDTO.
     * 
     * @param nomeBanco
     */
    public void setNomeBanco(java.lang.String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }


    /**
     * Gets the nomeHost value for this ConfiguraHibernateDTO.
     * 
     * @return nomeHost
     */
    public java.lang.String getNomeHost() {
        return nomeHost;
    }


    /**
     * Sets the nomeHost value for this ConfiguraHibernateDTO.
     * 
     * @param nomeHost
     */
    public void setNomeHost(java.lang.String nomeHost) {
        this.nomeHost = nomeHost;
    }


    /**
     * Gets the portaBanco value for this ConfiguraHibernateDTO.
     * 
     * @return portaBanco
     */
    public java.lang.String getPortaBanco() {
        return portaBanco;
    }


    /**
     * Sets the portaBanco value for this ConfiguraHibernateDTO.
     * 
     * @param portaBanco
     */
    public void setPortaBanco(java.lang.String portaBanco) {
        this.portaBanco = portaBanco;
    }


    /**
     * Gets the senha value for this ConfiguraHibernateDTO.
     * 
     * @return senha
     */
    public java.lang.String getSenha() {
        return senha;
    }


    /**
     * Sets the senha value for this ConfiguraHibernateDTO.
     * 
     * @param senha
     */
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }


    /**
     * Gets the tipoBanco value for this ConfiguraHibernateDTO.
     * 
     * @return tipoBanco
     */
    public java.lang.Integer getTipoBanco() {
        return tipoBanco;
    }


    /**
     * Sets the tipoBanco value for this ConfiguraHibernateDTO.
     * 
     * @param tipoBanco
     */
    public void setTipoBanco(java.lang.Integer tipoBanco) {
        this.tipoBanco = tipoBanco;
    }


    /**
     * Gets the usuario value for this ConfiguraHibernateDTO.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this ConfiguraHibernateDTO.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfiguraHibernateDTO)) return false;
        ConfiguraHibernateDTO other = (ConfiguraHibernateDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autenticacao==null && other.getAutenticacao()==null) || 
             (this.autenticacao!=null &&
              this.autenticacao.equals(other.getAutenticacao()))) &&
            ((this.caminhoArquivo==null && other.getCaminhoArquivo()==null) || 
             (this.caminhoArquivo!=null &&
              this.caminhoArquivo.equals(other.getCaminhoArquivo()))) &&
            ((this.instanciaBanco==null && other.getInstanciaBanco()==null) || 
             (this.instanciaBanco!=null &&
              this.instanciaBanco.equals(other.getInstanciaBanco()))) &&
            ((this.nomeBanco==null && other.getNomeBanco()==null) || 
             (this.nomeBanco!=null &&
              this.nomeBanco.equals(other.getNomeBanco()))) &&
            ((this.nomeHost==null && other.getNomeHost()==null) || 
             (this.nomeHost!=null &&
              this.nomeHost.equals(other.getNomeHost()))) &&
            ((this.portaBanco==null && other.getPortaBanco()==null) || 
             (this.portaBanco!=null &&
              this.portaBanco.equals(other.getPortaBanco()))) &&
            ((this.senha==null && other.getSenha()==null) || 
             (this.senha!=null &&
              this.senha.equals(other.getSenha()))) &&
            ((this.tipoBanco==null && other.getTipoBanco()==null) || 
             (this.tipoBanco!=null &&
              this.tipoBanco.equals(other.getTipoBanco()))) &&
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
        if (getAutenticacao() != null) {
            _hashCode += getAutenticacao().hashCode();
        }
        if (getCaminhoArquivo() != null) {
            _hashCode += getCaminhoArquivo().hashCode();
        }
        if (getInstanciaBanco() != null) {
            _hashCode += getInstanciaBanco().hashCode();
        }
        if (getNomeBanco() != null) {
            _hashCode += getNomeBanco().hashCode();
        }
        if (getNomeHost() != null) {
            _hashCode += getNomeHost().hashCode();
        }
        if (getPortaBanco() != null) {
            _hashCode += getPortaBanco().hashCode();
        }
        if (getSenha() != null) {
            _hashCode += getSenha().hashCode();
        }
        if (getTipoBanco() != null) {
            _hashCode += getTipoBanco().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfiguraHibernateDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "configuraHibernateDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autenticacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autenticacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caminhoArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caminhoArquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanciaBanco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instanciaBanco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeBanco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeBanco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeHost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeHost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portaBanco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portaBanco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoBanco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoBanco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
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
