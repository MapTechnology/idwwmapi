/**
 * GrupoUsuarioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GrupoUsuarioDTO  implements java.io.Serializable {
    private idw.idwws.DireitoAcessoDTO[] direitosAcesso;

    private idw.idwws.DireitoAcessoDTO[] direitosAcessoParaExclusao;

    private int ERRO_CDUSRGRP_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_DESCRICAO_INVALIDA;

    private int ERRO_GRUPO_USUARIO_JA_EXISTE;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_RESGUI_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.OmUsrgrp grupoUsuario;

    private int resultadoEvento;

    public GrupoUsuarioDTO() {
    }

    public GrupoUsuarioDTO(
           idw.idwws.DireitoAcessoDTO[] direitosAcesso,
           idw.idwws.DireitoAcessoDTO[] direitosAcessoParaExclusao,
           int ERRO_CDUSRGRP_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_DESCRICAO_INVALIDA,
           int ERRO_GRUPO_USUARIO_JA_EXISTE,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_RESGUI_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.OmUsrgrp grupoUsuario,
           int resultadoEvento) {
           this.direitosAcesso = direitosAcesso;
           this.direitosAcessoParaExclusao = direitosAcessoParaExclusao;
           this.ERRO_CDUSRGRP_INVALIDO = ERRO_CDUSRGRP_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_DESCRICAO_INVALIDA = ERRO_DESCRICAO_INVALIDA;
           this.ERRO_GRUPO_USUARIO_JA_EXISTE = ERRO_GRUPO_USUARIO_JA_EXISTE;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_RESGUI_DESCONHECIDO = ERRO_RESGUI_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.grupoUsuario = grupoUsuario;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the direitosAcesso value for this GrupoUsuarioDTO.
     * 
     * @return direitosAcesso
     */
    public idw.idwws.DireitoAcessoDTO[] getDireitosAcesso() {
        return direitosAcesso;
    }


    /**
     * Sets the direitosAcesso value for this GrupoUsuarioDTO.
     * 
     * @param direitosAcesso
     */
    public void setDireitosAcesso(idw.idwws.DireitoAcessoDTO[] direitosAcesso) {
        this.direitosAcesso = direitosAcesso;
    }


    /**
     * Gets the direitosAcessoParaExclusao value for this GrupoUsuarioDTO.
     * 
     * @return direitosAcessoParaExclusao
     */
    public idw.idwws.DireitoAcessoDTO[] getDireitosAcessoParaExclusao() {
        return direitosAcessoParaExclusao;
    }


    /**
     * Sets the direitosAcessoParaExclusao value for this GrupoUsuarioDTO.
     * 
     * @param direitosAcessoParaExclusao
     */
    public void setDireitosAcessoParaExclusao(idw.idwws.DireitoAcessoDTO[] direitosAcessoParaExclusao) {
        this.direitosAcessoParaExclusao = direitosAcessoParaExclusao;
    }


    /**
     * Gets the ERRO_CDUSRGRP_INVALIDO value for this GrupoUsuarioDTO.
     * 
     * @return ERRO_CDUSRGRP_INVALIDO
     */
    public int getERRO_CDUSRGRP_INVALIDO() {
        return ERRO_CDUSRGRP_INVALIDO;
    }


    /**
     * Sets the ERRO_CDUSRGRP_INVALIDO value for this GrupoUsuarioDTO.
     * 
     * @param ERRO_CDUSRGRP_INVALIDO
     */
    public void setERRO_CDUSRGRP_INVALIDO(int ERRO_CDUSRGRP_INVALIDO) {
        this.ERRO_CDUSRGRP_INVALIDO = ERRO_CDUSRGRP_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this GrupoUsuarioDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this GrupoUsuarioDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DESCRICAO_INVALIDA value for this GrupoUsuarioDTO.
     * 
     * @return ERRO_DESCRICAO_INVALIDA
     */
    public int getERRO_DESCRICAO_INVALIDA() {
        return ERRO_DESCRICAO_INVALIDA;
    }


    /**
     * Sets the ERRO_DESCRICAO_INVALIDA value for this GrupoUsuarioDTO.
     * 
     * @param ERRO_DESCRICAO_INVALIDA
     */
    public void setERRO_DESCRICAO_INVALIDA(int ERRO_DESCRICAO_INVALIDA) {
        this.ERRO_DESCRICAO_INVALIDA = ERRO_DESCRICAO_INVALIDA;
    }


    /**
     * Gets the ERRO_GRUPO_USUARIO_JA_EXISTE value for this GrupoUsuarioDTO.
     * 
     * @return ERRO_GRUPO_USUARIO_JA_EXISTE
     */
    public int getERRO_GRUPO_USUARIO_JA_EXISTE() {
        return ERRO_GRUPO_USUARIO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_GRUPO_USUARIO_JA_EXISTE value for this GrupoUsuarioDTO.
     * 
     * @param ERRO_GRUPO_USUARIO_JA_EXISTE
     */
    public void setERRO_GRUPO_USUARIO_JA_EXISTE(int ERRO_GRUPO_USUARIO_JA_EXISTE) {
        this.ERRO_GRUPO_USUARIO_JA_EXISTE = ERRO_GRUPO_USUARIO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this GrupoUsuarioDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this GrupoUsuarioDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_RESGUI_DESCONHECIDO value for this GrupoUsuarioDTO.
     * 
     * @return ERRO_RESGUI_DESCONHECIDO
     */
    public int getERRO_RESGUI_DESCONHECIDO() {
        return ERRO_RESGUI_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_RESGUI_DESCONHECIDO value for this GrupoUsuarioDTO.
     * 
     * @param ERRO_RESGUI_DESCONHECIDO
     */
    public void setERRO_RESGUI_DESCONHECIDO(int ERRO_RESGUI_DESCONHECIDO) {
        this.ERRO_RESGUI_DESCONHECIDO = ERRO_RESGUI_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this GrupoUsuarioDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this GrupoUsuarioDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the grupoUsuario value for this GrupoUsuarioDTO.
     * 
     * @return grupoUsuario
     */
    public idw.idwws.OmUsrgrp getGrupoUsuario() {
        return grupoUsuario;
    }


    /**
     * Sets the grupoUsuario value for this GrupoUsuarioDTO.
     * 
     * @param grupoUsuario
     */
    public void setGrupoUsuario(idw.idwws.OmUsrgrp grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }


    /**
     * Gets the resultadoEvento value for this GrupoUsuarioDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this GrupoUsuarioDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GrupoUsuarioDTO)) return false;
        GrupoUsuarioDTO other = (GrupoUsuarioDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.direitosAcesso==null && other.getDireitosAcesso()==null) || 
             (this.direitosAcesso!=null &&
              java.util.Arrays.equals(this.direitosAcesso, other.getDireitosAcesso()))) &&
            ((this.direitosAcessoParaExclusao==null && other.getDireitosAcessoParaExclusao()==null) || 
             (this.direitosAcessoParaExclusao!=null &&
              java.util.Arrays.equals(this.direitosAcessoParaExclusao, other.getDireitosAcessoParaExclusao()))) &&
            this.ERRO_CDUSRGRP_INVALIDO == other.getERRO_CDUSRGRP_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_DESCRICAO_INVALIDA == other.getERRO_DESCRICAO_INVALIDA() &&
            this.ERRO_GRUPO_USUARIO_JA_EXISTE == other.getERRO_GRUPO_USUARIO_JA_EXISTE() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_RESGUI_DESCONHECIDO == other.getERRO_RESGUI_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.grupoUsuario==null && other.getGrupoUsuario()==null) || 
             (this.grupoUsuario!=null &&
              this.grupoUsuario.equals(other.getGrupoUsuario()))) &&
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
        if (getDireitosAcesso() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDireitosAcesso());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDireitosAcesso(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDireitosAcessoParaExclusao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDireitosAcessoParaExclusao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDireitosAcessoParaExclusao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getERRO_CDUSRGRP_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_DESCRICAO_INVALIDA();
        _hashCode += getERRO_GRUPO_USUARIO_JA_EXISTE();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_RESGUI_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getGrupoUsuario() != null) {
            _hashCode += getGrupoUsuario().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GrupoUsuarioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "grupoUsuarioDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direitosAcesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direitosAcesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "direitoAcessoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "direitosAcesso"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direitosAcessoParaExclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direitosAcessoParaExclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "direitoAcessoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "direitosAcesso"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDUSRGRP_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDUSRGRP_INVALIDO"));
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
        elemField.setFieldName("ERRO_DESCRICAO_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCRICAO_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_GRUPO_USUARIO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_GRUPO_USUARIO_JA_EXISTE"));
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
        elemField.setFieldName("ERRO_RESGUI_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_RESGUI_DESCONHECIDO"));
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
        elemField.setFieldName("grupoUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grupoUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsrgrp"));
        elemField.setMinOccurs(0);
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
