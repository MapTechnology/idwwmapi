/**
 * GtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GtDTO  implements java.io.Serializable {
    private boolean considerarObjs;

    private int ERRO_CC_DESCONHECIDO;

    private int ERRO_CDGT_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_GT_JA_EXISTE;

    private int ERRO_IMG_DESCONHECIDO;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_SALVAR_OBJETOS;

    private int ERRO_TIPOGT_DESCONHECIDO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.OmGt gt;

    private idw.idwws.HomologacoesDTO homologacoes;

    private int resultadoEvento;

    public GtDTO() {
    }

    public GtDTO(
           boolean considerarObjs,
           int ERRO_CC_DESCONHECIDO,
           int ERRO_CDGT_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_GT_JA_EXISTE,
           int ERRO_IMG_DESCONHECIDO,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_SALVAR_OBJETOS,
           int ERRO_TIPOGT_DESCONHECIDO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.OmGt gt,
           idw.idwws.HomologacoesDTO homologacoes,
           int resultadoEvento) {
           this.considerarObjs = considerarObjs;
           this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
           this.ERRO_CDGT_INVALIDO = ERRO_CDGT_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_GT_JA_EXISTE = ERRO_GT_JA_EXISTE;
           this.ERRO_IMG_DESCONHECIDO = ERRO_IMG_DESCONHECIDO;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_SALVAR_OBJETOS = ERRO_SALVAR_OBJETOS;
           this.ERRO_TIPOGT_DESCONHECIDO = ERRO_TIPOGT_DESCONHECIDO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.gt = gt;
           this.homologacoes = homologacoes;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the considerarObjs value for this GtDTO.
     * 
     * @return considerarObjs
     */
    public boolean isConsiderarObjs() {
        return considerarObjs;
    }


    /**
     * Sets the considerarObjs value for this GtDTO.
     * 
     * @param considerarObjs
     */
    public void setConsiderarObjs(boolean considerarObjs) {
        this.considerarObjs = considerarObjs;
    }


    /**
     * Gets the ERRO_CC_DESCONHECIDO value for this GtDTO.
     * 
     * @return ERRO_CC_DESCONHECIDO
     */
    public int getERRO_CC_DESCONHECIDO() {
        return ERRO_CC_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CC_DESCONHECIDO value for this GtDTO.
     * 
     * @param ERRO_CC_DESCONHECIDO
     */
    public void setERRO_CC_DESCONHECIDO(int ERRO_CC_DESCONHECIDO) {
        this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CDGT_INVALIDO value for this GtDTO.
     * 
     * @return ERRO_CDGT_INVALIDO
     */
    public int getERRO_CDGT_INVALIDO() {
        return ERRO_CDGT_INVALIDO;
    }


    /**
     * Sets the ERRO_CDGT_INVALIDO value for this GtDTO.
     * 
     * @param ERRO_CDGT_INVALIDO
     */
    public void setERRO_CDGT_INVALIDO(int ERRO_CDGT_INVALIDO) {
        this.ERRO_CDGT_INVALIDO = ERRO_CDGT_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this GtDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this GtDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_GT_JA_EXISTE value for this GtDTO.
     * 
     * @return ERRO_GT_JA_EXISTE
     */
    public int getERRO_GT_JA_EXISTE() {
        return ERRO_GT_JA_EXISTE;
    }


    /**
     * Sets the ERRO_GT_JA_EXISTE value for this GtDTO.
     * 
     * @param ERRO_GT_JA_EXISTE
     */
    public void setERRO_GT_JA_EXISTE(int ERRO_GT_JA_EXISTE) {
        this.ERRO_GT_JA_EXISTE = ERRO_GT_JA_EXISTE;
    }


    /**
     * Gets the ERRO_IMG_DESCONHECIDO value for this GtDTO.
     * 
     * @return ERRO_IMG_DESCONHECIDO
     */
    public int getERRO_IMG_DESCONHECIDO() {
        return ERRO_IMG_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_IMG_DESCONHECIDO value for this GtDTO.
     * 
     * @param ERRO_IMG_DESCONHECIDO
     */
    public void setERRO_IMG_DESCONHECIDO(int ERRO_IMG_DESCONHECIDO) {
        this.ERRO_IMG_DESCONHECIDO = ERRO_IMG_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this GtDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this GtDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_SALVAR_OBJETOS value for this GtDTO.
     * 
     * @return ERRO_SALVAR_OBJETOS
     */
    public int getERRO_SALVAR_OBJETOS() {
        return ERRO_SALVAR_OBJETOS;
    }


    /**
     * Sets the ERRO_SALVAR_OBJETOS value for this GtDTO.
     * 
     * @param ERRO_SALVAR_OBJETOS
     */
    public void setERRO_SALVAR_OBJETOS(int ERRO_SALVAR_OBJETOS) {
        this.ERRO_SALVAR_OBJETOS = ERRO_SALVAR_OBJETOS;
    }


    /**
     * Gets the ERRO_TIPOGT_DESCONHECIDO value for this GtDTO.
     * 
     * @return ERRO_TIPOGT_DESCONHECIDO
     */
    public int getERRO_TIPOGT_DESCONHECIDO() {
        return ERRO_TIPOGT_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TIPOGT_DESCONHECIDO value for this GtDTO.
     * 
     * @param ERRO_TIPOGT_DESCONHECIDO
     */
    public void setERRO_TIPOGT_DESCONHECIDO(int ERRO_TIPOGT_DESCONHECIDO) {
        this.ERRO_TIPOGT_DESCONHECIDO = ERRO_TIPOGT_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this GtDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this GtDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this GtDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this GtDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this GtDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this GtDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the gt value for this GtDTO.
     * 
     * @return gt
     */
    public idw.idwws.OmGt getGt() {
        return gt;
    }


    /**
     * Sets the gt value for this GtDTO.
     * 
     * @param gt
     */
    public void setGt(idw.idwws.OmGt gt) {
        this.gt = gt;
    }


    /**
     * Gets the homologacoes value for this GtDTO.
     * 
     * @return homologacoes
     */
    public idw.idwws.HomologacoesDTO getHomologacoes() {
        return homologacoes;
    }


    /**
     * Sets the homologacoes value for this GtDTO.
     * 
     * @param homologacoes
     */
    public void setHomologacoes(idw.idwws.HomologacoesDTO homologacoes) {
        this.homologacoes = homologacoes;
    }


    /**
     * Gets the resultadoEvento value for this GtDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this GtDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GtDTO)) return false;
        GtDTO other = (GtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.considerarObjs == other.isConsiderarObjs() &&
            this.ERRO_CC_DESCONHECIDO == other.getERRO_CC_DESCONHECIDO() &&
            this.ERRO_CDGT_INVALIDO == other.getERRO_CDGT_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_GT_JA_EXISTE == other.getERRO_GT_JA_EXISTE() &&
            this.ERRO_IMG_DESCONHECIDO == other.getERRO_IMG_DESCONHECIDO() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_SALVAR_OBJETOS == other.getERRO_SALVAR_OBJETOS() &&
            this.ERRO_TIPOGT_DESCONHECIDO == other.getERRO_TIPOGT_DESCONHECIDO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.gt==null && other.getGt()==null) || 
             (this.gt!=null &&
              this.gt.equals(other.getGt()))) &&
            ((this.homologacoes==null && other.getHomologacoes()==null) || 
             (this.homologacoes!=null &&
              this.homologacoes.equals(other.getHomologacoes()))) &&
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
        _hashCode += (isConsiderarObjs() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getERRO_CC_DESCONHECIDO();
        _hashCode += getERRO_CDGT_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_GT_JA_EXISTE();
        _hashCode += getERRO_IMG_DESCONHECIDO();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_SALVAR_OBJETOS();
        _hashCode += getERRO_TIPOGT_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getGt() != null) {
            _hashCode += getGt().hashCode();
        }
        if (getHomologacoes() != null) {
            _hashCode += getHomologacoes().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "gtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("considerarObjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "considerarObjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CC_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CC_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDGT_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDGT_INVALIDO"));
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
        elemField.setFieldName("ERRO_GT_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_GT_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_IMG_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_IMG_DESCONHECIDO"));
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
        elemField.setFieldName("ERRO_SALVAR_OBJETOS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_SALVAR_OBJETOS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPOGT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPOGT_DESCONHECIDO"));
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
        elemField.setFieldName("gt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
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
