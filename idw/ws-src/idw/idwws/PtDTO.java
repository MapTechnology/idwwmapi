/**
 * PtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PtDTO  implements java.io.Serializable {
    private int ERRO_CC_DESCONHECIDO;

    private int ERRO_CDPT_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_GRUPOTRABALHO_DESCONHECIDO;

    private int ERRO_PT_JA_EXISTE;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_TIPOPOSTO_DESCONHECIDO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.HomologacoesDTO homologacoes;

    private idw.idwws.PaDTO[] pas;

    private idw.idwws.PaDTO[] pasParaExclusao;

    private idw.idwws.OmPt pt;

    private int resultadoEvento;

    public PtDTO() {
    }

    public PtDTO(
           int ERRO_CC_DESCONHECIDO,
           int ERRO_CDPT_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_GRUPOTRABALHO_DESCONHECIDO,
           int ERRO_PT_JA_EXISTE,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_TIPOPOSTO_DESCONHECIDO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.HomologacoesDTO homologacoes,
           idw.idwws.PaDTO[] pas,
           idw.idwws.PaDTO[] pasParaExclusao,
           idw.idwws.OmPt pt,
           int resultadoEvento) {
           this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
           this.ERRO_CDPT_INVALIDO = ERRO_CDPT_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_GRUPOTRABALHO_DESCONHECIDO = ERRO_GRUPOTRABALHO_DESCONHECIDO;
           this.ERRO_PT_JA_EXISTE = ERRO_PT_JA_EXISTE;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.homologacoes = homologacoes;
           this.pas = pas;
           this.pasParaExclusao = pasParaExclusao;
           this.pt = pt;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_CC_DESCONHECIDO value for this PtDTO.
     * 
     * @return ERRO_CC_DESCONHECIDO
     */
    public int getERRO_CC_DESCONHECIDO() {
        return ERRO_CC_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CC_DESCONHECIDO value for this PtDTO.
     * 
     * @param ERRO_CC_DESCONHECIDO
     */
    public void setERRO_CC_DESCONHECIDO(int ERRO_CC_DESCONHECIDO) {
        this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CDPT_INVALIDO value for this PtDTO.
     * 
     * @return ERRO_CDPT_INVALIDO
     */
    public int getERRO_CDPT_INVALIDO() {
        return ERRO_CDPT_INVALIDO;
    }


    /**
     * Sets the ERRO_CDPT_INVALIDO value for this PtDTO.
     * 
     * @param ERRO_CDPT_INVALIDO
     */
    public void setERRO_CDPT_INVALIDO(int ERRO_CDPT_INVALIDO) {
        this.ERRO_CDPT_INVALIDO = ERRO_CDPT_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this PtDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this PtDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_GRUPOTRABALHO_DESCONHECIDO value for this PtDTO.
     * 
     * @return ERRO_GRUPOTRABALHO_DESCONHECIDO
     */
    public int getERRO_GRUPOTRABALHO_DESCONHECIDO() {
        return ERRO_GRUPOTRABALHO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_GRUPOTRABALHO_DESCONHECIDO value for this PtDTO.
     * 
     * @param ERRO_GRUPOTRABALHO_DESCONHECIDO
     */
    public void setERRO_GRUPOTRABALHO_DESCONHECIDO(int ERRO_GRUPOTRABALHO_DESCONHECIDO) {
        this.ERRO_GRUPOTRABALHO_DESCONHECIDO = ERRO_GRUPOTRABALHO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PT_JA_EXISTE value for this PtDTO.
     * 
     * @return ERRO_PT_JA_EXISTE
     */
    public int getERRO_PT_JA_EXISTE() {
        return ERRO_PT_JA_EXISTE;
    }


    /**
     * Sets the ERRO_PT_JA_EXISTE value for this PtDTO.
     * 
     * @param ERRO_PT_JA_EXISTE
     */
    public void setERRO_PT_JA_EXISTE(int ERRO_PT_JA_EXISTE) {
        this.ERRO_PT_JA_EXISTE = ERRO_PT_JA_EXISTE;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this PtDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this PtDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_TIPOPOSTO_DESCONHECIDO value for this PtDTO.
     * 
     * @return ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public int getERRO_TIPOPOSTO_DESCONHECIDO() {
        return ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TIPOPOSTO_DESCONHECIDO value for this PtDTO.
     * 
     * @param ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public void setERRO_TIPOPOSTO_DESCONHECIDO(int ERRO_TIPOPOSTO_DESCONHECIDO) {
        this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this PtDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this PtDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this PtDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this PtDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this PtDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this PtDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the homologacoes value for this PtDTO.
     * 
     * @return homologacoes
     */
    public idw.idwws.HomologacoesDTO getHomologacoes() {
        return homologacoes;
    }


    /**
     * Sets the homologacoes value for this PtDTO.
     * 
     * @param homologacoes
     */
    public void setHomologacoes(idw.idwws.HomologacoesDTO homologacoes) {
        this.homologacoes = homologacoes;
    }


    /**
     * Gets the pas value for this PtDTO.
     * 
     * @return pas
     */
    public idw.idwws.PaDTO[] getPas() {
        return pas;
    }


    /**
     * Sets the pas value for this PtDTO.
     * 
     * @param pas
     */
    public void setPas(idw.idwws.PaDTO[] pas) {
        this.pas = pas;
    }


    /**
     * Gets the pasParaExclusao value for this PtDTO.
     * 
     * @return pasParaExclusao
     */
    public idw.idwws.PaDTO[] getPasParaExclusao() {
        return pasParaExclusao;
    }


    /**
     * Sets the pasParaExclusao value for this PtDTO.
     * 
     * @param pasParaExclusao
     */
    public void setPasParaExclusao(idw.idwws.PaDTO[] pasParaExclusao) {
        this.pasParaExclusao = pasParaExclusao;
    }


    /**
     * Gets the pt value for this PtDTO.
     * 
     * @return pt
     */
    public idw.idwws.OmPt getPt() {
        return pt;
    }


    /**
     * Sets the pt value for this PtDTO.
     * 
     * @param pt
     */
    public void setPt(idw.idwws.OmPt pt) {
        this.pt = pt;
    }


    /**
     * Gets the resultadoEvento value for this PtDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this PtDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PtDTO)) return false;
        PtDTO other = (PtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_CC_DESCONHECIDO == other.getERRO_CC_DESCONHECIDO() &&
            this.ERRO_CDPT_INVALIDO == other.getERRO_CDPT_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_GRUPOTRABALHO_DESCONHECIDO == other.getERRO_GRUPOTRABALHO_DESCONHECIDO() &&
            this.ERRO_PT_JA_EXISTE == other.getERRO_PT_JA_EXISTE() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_TIPOPOSTO_DESCONHECIDO == other.getERRO_TIPOPOSTO_DESCONHECIDO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.homologacoes==null && other.getHomologacoes()==null) || 
             (this.homologacoes!=null &&
              this.homologacoes.equals(other.getHomologacoes()))) &&
            ((this.pas==null && other.getPas()==null) || 
             (this.pas!=null &&
              java.util.Arrays.equals(this.pas, other.getPas()))) &&
            ((this.pasParaExclusao==null && other.getPasParaExclusao()==null) || 
             (this.pasParaExclusao!=null &&
              java.util.Arrays.equals(this.pasParaExclusao, other.getPasParaExclusao()))) &&
            ((this.pt==null && other.getPt()==null) || 
             (this.pt!=null &&
              this.pt.equals(other.getPt()))) &&
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
        _hashCode += getERRO_CC_DESCONHECIDO();
        _hashCode += getERRO_CDPT_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_GRUPOTRABALHO_DESCONHECIDO();
        _hashCode += getERRO_PT_JA_EXISTE();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_TIPOPOSTO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getHomologacoes() != null) {
            _hashCode += getHomologacoes().hashCode();
        }
        if (getPas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPasParaExclusao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPasParaExclusao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPasParaExclusao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPt() != null) {
            _hashCode += getPt().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ptDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CC_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CC_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDPT_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDPT_INVALIDO"));
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
        elemField.setFieldName("ERRO_GRUPOTRABALHO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_GRUPOTRABALHO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PT_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PT_JA_EXISTE"));
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
        elemField.setFieldName("homologacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "homologacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "homologacoesDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "pas"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pasParaExclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pasParaExclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "pas"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
