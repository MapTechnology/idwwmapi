/**
 * IwsModDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IwsModDTO  implements java.io.Serializable {
    private java.util.Calendar dthrLogin;

    private java.util.Calendar dthrLogout;

    private java.lang.String idGrupoUsu;

    private java.lang.String idUsuario;

    private java.lang.String login;

    private java.lang.String nome;

    public IwsModDTO() {
    }

    public IwsModDTO(
           java.util.Calendar dthrLogin,
           java.util.Calendar dthrLogout,
           java.lang.String idGrupoUsu,
           java.lang.String idUsuario,
           java.lang.String login,
           java.lang.String nome) {
           this.dthrLogin = dthrLogin;
           this.dthrLogout = dthrLogout;
           this.idGrupoUsu = idGrupoUsu;
           this.idUsuario = idUsuario;
           this.login = login;
           this.nome = nome;
    }


    /**
     * Gets the dthrLogin value for this IwsModDTO.
     * 
     * @return dthrLogin
     */
    public java.util.Calendar getDthrLogin() {
        return dthrLogin;
    }


    /**
     * Sets the dthrLogin value for this IwsModDTO.
     * 
     * @param dthrLogin
     */
    public void setDthrLogin(java.util.Calendar dthrLogin) {
        this.dthrLogin = dthrLogin;
    }


    /**
     * Gets the dthrLogout value for this IwsModDTO.
     * 
     * @return dthrLogout
     */
    public java.util.Calendar getDthrLogout() {
        return dthrLogout;
    }


    /**
     * Sets the dthrLogout value for this IwsModDTO.
     * 
     * @param dthrLogout
     */
    public void setDthrLogout(java.util.Calendar dthrLogout) {
        this.dthrLogout = dthrLogout;
    }


    /**
     * Gets the idGrupoUsu value for this IwsModDTO.
     * 
     * @return idGrupoUsu
     */
    public java.lang.String getIdGrupoUsu() {
        return idGrupoUsu;
    }


    /**
     * Sets the idGrupoUsu value for this IwsModDTO.
     * 
     * @param idGrupoUsu
     */
    public void setIdGrupoUsu(java.lang.String idGrupoUsu) {
        this.idGrupoUsu = idGrupoUsu;
    }


    /**
     * Gets the idUsuario value for this IwsModDTO.
     * 
     * @return idUsuario
     */
    public java.lang.String getIdUsuario() {
        return idUsuario;
    }


    /**
     * Sets the idUsuario value for this IwsModDTO.
     * 
     * @param idUsuario
     */
    public void setIdUsuario(java.lang.String idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Gets the login value for this IwsModDTO.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this IwsModDTO.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the nome value for this IwsModDTO.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this IwsModDTO.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IwsModDTO)) return false;
        IwsModDTO other = (IwsModDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrLogin==null && other.getDthrLogin()==null) || 
             (this.dthrLogin!=null &&
              this.dthrLogin.equals(other.getDthrLogin()))) &&
            ((this.dthrLogout==null && other.getDthrLogout()==null) || 
             (this.dthrLogout!=null &&
              this.dthrLogout.equals(other.getDthrLogout()))) &&
            ((this.idGrupoUsu==null && other.getIdGrupoUsu()==null) || 
             (this.idGrupoUsu!=null &&
              this.idGrupoUsu.equals(other.getIdGrupoUsu()))) &&
            ((this.idUsuario==null && other.getIdUsuario()==null) || 
             (this.idUsuario!=null &&
              this.idUsuario.equals(other.getIdUsuario()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome())));
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
        if (getDthrLogin() != null) {
            _hashCode += getDthrLogin().hashCode();
        }
        if (getDthrLogout() != null) {
            _hashCode += getDthrLogout().hashCode();
        }
        if (getIdGrupoUsu() != null) {
            _hashCode += getIdGrupoUsu().hashCode();
        }
        if (getIdUsuario() != null) {
            _hashCode += getIdUsuario().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IwsModDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsModDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrLogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrLogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrLogout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrLogout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGrupoUsu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGrupoUsu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
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
