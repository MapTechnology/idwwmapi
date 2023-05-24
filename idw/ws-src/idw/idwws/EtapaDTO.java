/**
 * EtapaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EtapaDTO  implements java.io.Serializable {
    private int ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA;

    private int ERRO_CDETAPA_INVALIDO;

    private int ERRO_COMPARADOR_INVALIDO;

    private int ERRO_COMPONENTE_DESCONHECIDO;

    private int ERRO_CONSIDACAO_DESCONHECIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_ETAPA_JA_EXISTE;

    private int ERRO_MSGNOK_INVALIDA;

    private int ERRO_MSGOK_INVALIDA;

    private int ERRO_PARAMETROS_9998_DESCONHECIDOS;

    private int ERRO_PARAMETRO_EVENTO_DESCONHECIDO;

    private int ERRO_PARAMETRO_MEDICAO_DESCONHECIDO;

    private int ERRO_TIPO_SUBETAPA_DESCONHECIDO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int ERRO_VALOR_EVENTO_INVALIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.DwFtEtapa etapa;

    private int resultadoEvento;

    private idw.idwws.EtapaSubDTO[] subs;

    private idw.idwws.EtapaSubDTO[] subsParaExclusao;

    public EtapaDTO() {
    }

    public EtapaDTO(
           int ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA,
           int ERRO_CDETAPA_INVALIDO,
           int ERRO_COMPARADOR_INVALIDO,
           int ERRO_COMPONENTE_DESCONHECIDO,
           int ERRO_CONSIDACAO_DESCONHECIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_ETAPA_JA_EXISTE,
           int ERRO_MSGNOK_INVALIDA,
           int ERRO_MSGOK_INVALIDA,
           int ERRO_PARAMETROS_9998_DESCONHECIDOS,
           int ERRO_PARAMETRO_EVENTO_DESCONHECIDO,
           int ERRO_PARAMETRO_MEDICAO_DESCONHECIDO,
           int ERRO_TIPO_SUBETAPA_DESCONHECIDO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int ERRO_VALOR_EVENTO_INVALIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.DwFtEtapa etapa,
           int resultadoEvento,
           idw.idwws.EtapaSubDTO[] subs,
           idw.idwws.EtapaSubDTO[] subsParaExclusao) {
           this.ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA = ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA;
           this.ERRO_CDETAPA_INVALIDO = ERRO_CDETAPA_INVALIDO;
           this.ERRO_COMPARADOR_INVALIDO = ERRO_COMPARADOR_INVALIDO;
           this.ERRO_COMPONENTE_DESCONHECIDO = ERRO_COMPONENTE_DESCONHECIDO;
           this.ERRO_CONSIDACAO_DESCONHECIDO = ERRO_CONSIDACAO_DESCONHECIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_ETAPA_JA_EXISTE = ERRO_ETAPA_JA_EXISTE;
           this.ERRO_MSGNOK_INVALIDA = ERRO_MSGNOK_INVALIDA;
           this.ERRO_MSGOK_INVALIDA = ERRO_MSGOK_INVALIDA;
           this.ERRO_PARAMETROS_9998_DESCONHECIDOS = ERRO_PARAMETROS_9998_DESCONHECIDOS;
           this.ERRO_PARAMETRO_EVENTO_DESCONHECIDO = ERRO_PARAMETRO_EVENTO_DESCONHECIDO;
           this.ERRO_PARAMETRO_MEDICAO_DESCONHECIDO = ERRO_PARAMETRO_MEDICAO_DESCONHECIDO;
           this.ERRO_TIPO_SUBETAPA_DESCONHECIDO = ERRO_TIPO_SUBETAPA_DESCONHECIDO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.ERRO_VALOR_EVENTO_INVALIDO = ERRO_VALOR_EVENTO_INVALIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.etapa = etapa;
           this.resultadoEvento = resultadoEvento;
           this.subs = subs;
           this.subsParaExclusao = subsParaExclusao;
    }


    /**
     * Gets the ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA value for this EtapaDTO.
     * 
     * @return ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA
     */
    public int getERRO_CATEGORIA_SUBETAPA_DESCONHECIDA() {
        return ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA;
    }


    /**
     * Sets the ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA value for this EtapaDTO.
     * 
     * @param ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA
     */
    public void setERRO_CATEGORIA_SUBETAPA_DESCONHECIDA(int ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA) {
        this.ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA = ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA;
    }


    /**
     * Gets the ERRO_CDETAPA_INVALIDO value for this EtapaDTO.
     * 
     * @return ERRO_CDETAPA_INVALIDO
     */
    public int getERRO_CDETAPA_INVALIDO() {
        return ERRO_CDETAPA_INVALIDO;
    }


    /**
     * Sets the ERRO_CDETAPA_INVALIDO value for this EtapaDTO.
     * 
     * @param ERRO_CDETAPA_INVALIDO
     */
    public void setERRO_CDETAPA_INVALIDO(int ERRO_CDETAPA_INVALIDO) {
        this.ERRO_CDETAPA_INVALIDO = ERRO_CDETAPA_INVALIDO;
    }


    /**
     * Gets the ERRO_COMPARADOR_INVALIDO value for this EtapaDTO.
     * 
     * @return ERRO_COMPARADOR_INVALIDO
     */
    public int getERRO_COMPARADOR_INVALIDO() {
        return ERRO_COMPARADOR_INVALIDO;
    }


    /**
     * Sets the ERRO_COMPARADOR_INVALIDO value for this EtapaDTO.
     * 
     * @param ERRO_COMPARADOR_INVALIDO
     */
    public void setERRO_COMPARADOR_INVALIDO(int ERRO_COMPARADOR_INVALIDO) {
        this.ERRO_COMPARADOR_INVALIDO = ERRO_COMPARADOR_INVALIDO;
    }


    /**
     * Gets the ERRO_COMPONENTE_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_COMPONENTE_DESCONHECIDO
     */
    public int getERRO_COMPONENTE_DESCONHECIDO() {
        return ERRO_COMPONENTE_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_COMPONENTE_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_COMPONENTE_DESCONHECIDO
     */
    public void setERRO_COMPONENTE_DESCONHECIDO(int ERRO_COMPONENTE_DESCONHECIDO) {
        this.ERRO_COMPONENTE_DESCONHECIDO = ERRO_COMPONENTE_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CONSIDACAO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_CONSIDACAO_DESCONHECIDO
     */
    public int getERRO_CONSIDACAO_DESCONHECIDO() {
        return ERRO_CONSIDACAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CONSIDACAO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_CONSIDACAO_DESCONHECIDO
     */
    public void setERRO_CONSIDACAO_DESCONHECIDO(int ERRO_CONSIDACAO_DESCONHECIDO) {
        this.ERRO_CONSIDACAO_DESCONHECIDO = ERRO_CONSIDACAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_ETAPA_JA_EXISTE value for this EtapaDTO.
     * 
     * @return ERRO_ETAPA_JA_EXISTE
     */
    public int getERRO_ETAPA_JA_EXISTE() {
        return ERRO_ETAPA_JA_EXISTE;
    }


    /**
     * Sets the ERRO_ETAPA_JA_EXISTE value for this EtapaDTO.
     * 
     * @param ERRO_ETAPA_JA_EXISTE
     */
    public void setERRO_ETAPA_JA_EXISTE(int ERRO_ETAPA_JA_EXISTE) {
        this.ERRO_ETAPA_JA_EXISTE = ERRO_ETAPA_JA_EXISTE;
    }


    /**
     * Gets the ERRO_MSGNOK_INVALIDA value for this EtapaDTO.
     * 
     * @return ERRO_MSGNOK_INVALIDA
     */
    public int getERRO_MSGNOK_INVALIDA() {
        return ERRO_MSGNOK_INVALIDA;
    }


    /**
     * Sets the ERRO_MSGNOK_INVALIDA value for this EtapaDTO.
     * 
     * @param ERRO_MSGNOK_INVALIDA
     */
    public void setERRO_MSGNOK_INVALIDA(int ERRO_MSGNOK_INVALIDA) {
        this.ERRO_MSGNOK_INVALIDA = ERRO_MSGNOK_INVALIDA;
    }


    /**
     * Gets the ERRO_MSGOK_INVALIDA value for this EtapaDTO.
     * 
     * @return ERRO_MSGOK_INVALIDA
     */
    public int getERRO_MSGOK_INVALIDA() {
        return ERRO_MSGOK_INVALIDA;
    }


    /**
     * Sets the ERRO_MSGOK_INVALIDA value for this EtapaDTO.
     * 
     * @param ERRO_MSGOK_INVALIDA
     */
    public void setERRO_MSGOK_INVALIDA(int ERRO_MSGOK_INVALIDA) {
        this.ERRO_MSGOK_INVALIDA = ERRO_MSGOK_INVALIDA;
    }


    /**
     * Gets the ERRO_PARAMETROS_9998_DESCONHECIDOS value for this EtapaDTO.
     * 
     * @return ERRO_PARAMETROS_9998_DESCONHECIDOS
     */
    public int getERRO_PARAMETROS_9998_DESCONHECIDOS() {
        return ERRO_PARAMETROS_9998_DESCONHECIDOS;
    }


    /**
     * Sets the ERRO_PARAMETROS_9998_DESCONHECIDOS value for this EtapaDTO.
     * 
     * @param ERRO_PARAMETROS_9998_DESCONHECIDOS
     */
    public void setERRO_PARAMETROS_9998_DESCONHECIDOS(int ERRO_PARAMETROS_9998_DESCONHECIDOS) {
        this.ERRO_PARAMETROS_9998_DESCONHECIDOS = ERRO_PARAMETROS_9998_DESCONHECIDOS;
    }


    /**
     * Gets the ERRO_PARAMETRO_EVENTO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_PARAMETRO_EVENTO_DESCONHECIDO
     */
    public int getERRO_PARAMETRO_EVENTO_DESCONHECIDO() {
        return ERRO_PARAMETRO_EVENTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PARAMETRO_EVENTO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_PARAMETRO_EVENTO_DESCONHECIDO
     */
    public void setERRO_PARAMETRO_EVENTO_DESCONHECIDO(int ERRO_PARAMETRO_EVENTO_DESCONHECIDO) {
        this.ERRO_PARAMETRO_EVENTO_DESCONHECIDO = ERRO_PARAMETRO_EVENTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PARAMETRO_MEDICAO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_PARAMETRO_MEDICAO_DESCONHECIDO
     */
    public int getERRO_PARAMETRO_MEDICAO_DESCONHECIDO() {
        return ERRO_PARAMETRO_MEDICAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PARAMETRO_MEDICAO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_PARAMETRO_MEDICAO_DESCONHECIDO
     */
    public void setERRO_PARAMETRO_MEDICAO_DESCONHECIDO(int ERRO_PARAMETRO_MEDICAO_DESCONHECIDO) {
        this.ERRO_PARAMETRO_MEDICAO_DESCONHECIDO = ERRO_PARAMETRO_MEDICAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_TIPO_SUBETAPA_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_TIPO_SUBETAPA_DESCONHECIDO
     */
    public int getERRO_TIPO_SUBETAPA_DESCONHECIDO() {
        return ERRO_TIPO_SUBETAPA_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TIPO_SUBETAPA_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_TIPO_SUBETAPA_DESCONHECIDO
     */
    public void setERRO_TIPO_SUBETAPA_DESCONHECIDO(int ERRO_TIPO_SUBETAPA_DESCONHECIDO) {
        this.ERRO_TIPO_SUBETAPA_DESCONHECIDO = ERRO_TIPO_SUBETAPA_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this EtapaDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this EtapaDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_VALOR_EVENTO_INVALIDO value for this EtapaDTO.
     * 
     * @return ERRO_VALOR_EVENTO_INVALIDO
     */
    public int getERRO_VALOR_EVENTO_INVALIDO() {
        return ERRO_VALOR_EVENTO_INVALIDO;
    }


    /**
     * Sets the ERRO_VALOR_EVENTO_INVALIDO value for this EtapaDTO.
     * 
     * @param ERRO_VALOR_EVENTO_INVALIDO
     */
    public void setERRO_VALOR_EVENTO_INVALIDO(int ERRO_VALOR_EVENTO_INVALIDO) {
        this.ERRO_VALOR_EVENTO_INVALIDO = ERRO_VALOR_EVENTO_INVALIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this EtapaDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this EtapaDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the etapa value for this EtapaDTO.
     * 
     * @return etapa
     */
    public idw.idwws.DwFtEtapa getEtapa() {
        return etapa;
    }


    /**
     * Sets the etapa value for this EtapaDTO.
     * 
     * @param etapa
     */
    public void setEtapa(idw.idwws.DwFtEtapa etapa) {
        this.etapa = etapa;
    }


    /**
     * Gets the resultadoEvento value for this EtapaDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this EtapaDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the subs value for this EtapaDTO.
     * 
     * @return subs
     */
    public idw.idwws.EtapaSubDTO[] getSubs() {
        return subs;
    }


    /**
     * Sets the subs value for this EtapaDTO.
     * 
     * @param subs
     */
    public void setSubs(idw.idwws.EtapaSubDTO[] subs) {
        this.subs = subs;
    }


    /**
     * Gets the subsParaExclusao value for this EtapaDTO.
     * 
     * @return subsParaExclusao
     */
    public idw.idwws.EtapaSubDTO[] getSubsParaExclusao() {
        return subsParaExclusao;
    }


    /**
     * Sets the subsParaExclusao value for this EtapaDTO.
     * 
     * @param subsParaExclusao
     */
    public void setSubsParaExclusao(idw.idwws.EtapaSubDTO[] subsParaExclusao) {
        this.subsParaExclusao = subsParaExclusao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EtapaDTO)) return false;
        EtapaDTO other = (EtapaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA == other.getERRO_CATEGORIA_SUBETAPA_DESCONHECIDA() &&
            this.ERRO_CDETAPA_INVALIDO == other.getERRO_CDETAPA_INVALIDO() &&
            this.ERRO_COMPARADOR_INVALIDO == other.getERRO_COMPARADOR_INVALIDO() &&
            this.ERRO_COMPONENTE_DESCONHECIDO == other.getERRO_COMPONENTE_DESCONHECIDO() &&
            this.ERRO_CONSIDACAO_DESCONHECIDO == other.getERRO_CONSIDACAO_DESCONHECIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_ETAPA_JA_EXISTE == other.getERRO_ETAPA_JA_EXISTE() &&
            this.ERRO_MSGNOK_INVALIDA == other.getERRO_MSGNOK_INVALIDA() &&
            this.ERRO_MSGOK_INVALIDA == other.getERRO_MSGOK_INVALIDA() &&
            this.ERRO_PARAMETROS_9998_DESCONHECIDOS == other.getERRO_PARAMETROS_9998_DESCONHECIDOS() &&
            this.ERRO_PARAMETRO_EVENTO_DESCONHECIDO == other.getERRO_PARAMETRO_EVENTO_DESCONHECIDO() &&
            this.ERRO_PARAMETRO_MEDICAO_DESCONHECIDO == other.getERRO_PARAMETRO_MEDICAO_DESCONHECIDO() &&
            this.ERRO_TIPO_SUBETAPA_DESCONHECIDO == other.getERRO_TIPO_SUBETAPA_DESCONHECIDO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.ERRO_VALOR_EVENTO_INVALIDO == other.getERRO_VALOR_EVENTO_INVALIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.etapa==null && other.getEtapa()==null) || 
             (this.etapa!=null &&
              this.etapa.equals(other.getEtapa()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.subs==null && other.getSubs()==null) || 
             (this.subs!=null &&
              java.util.Arrays.equals(this.subs, other.getSubs()))) &&
            ((this.subsParaExclusao==null && other.getSubsParaExclusao()==null) || 
             (this.subsParaExclusao!=null &&
              java.util.Arrays.equals(this.subsParaExclusao, other.getSubsParaExclusao())));
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
        _hashCode += getERRO_CATEGORIA_SUBETAPA_DESCONHECIDA();
        _hashCode += getERRO_CDETAPA_INVALIDO();
        _hashCode += getERRO_COMPARADOR_INVALIDO();
        _hashCode += getERRO_COMPONENTE_DESCONHECIDO();
        _hashCode += getERRO_CONSIDACAO_DESCONHECIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_ETAPA_JA_EXISTE();
        _hashCode += getERRO_MSGNOK_INVALIDA();
        _hashCode += getERRO_MSGOK_INVALIDA();
        _hashCode += getERRO_PARAMETROS_9998_DESCONHECIDOS();
        _hashCode += getERRO_PARAMETRO_EVENTO_DESCONHECIDO();
        _hashCode += getERRO_PARAMETRO_MEDICAO_DESCONHECIDO();
        _hashCode += getERRO_TIPO_SUBETAPA_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getERRO_VALOR_EVENTO_INVALIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getEtapa() != null) {
            _hashCode += getEtapa().hashCode();
        }
        _hashCode += getResultadoEvento();
        if (getSubs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubsParaExclusao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubsParaExclusao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubsParaExclusao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EtapaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "etapaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CATEGORIA_SUBETAPA_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDETAPA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDETAPA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_COMPARADOR_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_COMPARADOR_INVALIDO"));
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
        elemField.setFieldName("ERRO_CONSIDACAO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CONSIDACAO_DESCONHECIDO"));
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
        elemField.setFieldName("ERRO_ETAPA_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_ETAPA_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_MSGNOK_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_MSGNOK_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_MSGOK_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_MSGOK_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PARAMETROS_9998_DESCONHECIDOS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PARAMETROS_9998_DESCONHECIDOS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PARAMETRO_EVENTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PARAMETRO_EVENTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PARAMETRO_MEDICAO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PARAMETRO_MEDICAO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPO_SUBETAPA_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPO_SUBETAPA_DESCONHECIDO"));
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
        elemField.setFieldName("ERRO_VALOR_EVENTO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_VALOR_EVENTO_INVALIDO"));
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
        elemField.setFieldName("etapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "etapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
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
        elemField.setFieldName("subs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "etapaSubDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "dwFtSubs"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsParaExclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsParaExclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "etapaSubDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "dwFtSubs"));
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
