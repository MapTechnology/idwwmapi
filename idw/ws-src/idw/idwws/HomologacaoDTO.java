/**
 * HomologacaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class HomologacaoDTO  implements java.io.Serializable {
    private int ERRO_PT_DESCONHECIDO;

    private int ERRO_TIPOHOMOLOGACAO_INVALIDA;

    private int ERRO_USUARIO_DESCONHECIDO;

    private int ERRO_USUARIO_JA_HOMOLOGADO;

    private int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.OmHomogt homologacaoGt;

    private idw.idwws.OmHomopt homologacaoPt;

    private int resultadoEvento;

    public HomologacaoDTO() {
    }

    public HomologacaoDTO(
           int ERRO_PT_DESCONHECIDO,
           int ERRO_TIPOHOMOLOGACAO_INVALIDA,
           int ERRO_USUARIO_DESCONHECIDO,
           int ERRO_USUARIO_JA_HOMOLOGADO,
           int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.OmHomogt homologacaoGt,
           idw.idwws.OmHomopt homologacaoPt,
           int resultadoEvento) {
           this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
           this.ERRO_TIPOHOMOLOGACAO_INVALIDA = ERRO_TIPOHOMOLOGACAO_INVALIDA;
           this.ERRO_USUARIO_DESCONHECIDO = ERRO_USUARIO_DESCONHECIDO;
           this.ERRO_USUARIO_JA_HOMOLOGADO = ERRO_USUARIO_JA_HOMOLOGADO;
           this.ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.homologacaoGt = homologacaoGt;
           this.homologacaoPt = homologacaoPt;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_PT_DESCONHECIDO value for this HomologacaoDTO.
     * 
     * @return ERRO_PT_DESCONHECIDO
     */
    public int getERRO_PT_DESCONHECIDO() {
        return ERRO_PT_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PT_DESCONHECIDO value for this HomologacaoDTO.
     * 
     * @param ERRO_PT_DESCONHECIDO
     */
    public void setERRO_PT_DESCONHECIDO(int ERRO_PT_DESCONHECIDO) {
        this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_TIPOHOMOLOGACAO_INVALIDA value for this HomologacaoDTO.
     * 
     * @return ERRO_TIPOHOMOLOGACAO_INVALIDA
     */
    public int getERRO_TIPOHOMOLOGACAO_INVALIDA() {
        return ERRO_TIPOHOMOLOGACAO_INVALIDA;
    }


    /**
     * Sets the ERRO_TIPOHOMOLOGACAO_INVALIDA value for this HomologacaoDTO.
     * 
     * @param ERRO_TIPOHOMOLOGACAO_INVALIDA
     */
    public void setERRO_TIPOHOMOLOGACAO_INVALIDA(int ERRO_TIPOHOMOLOGACAO_INVALIDA) {
        this.ERRO_TIPOHOMOLOGACAO_INVALIDA = ERRO_TIPOHOMOLOGACAO_INVALIDA;
    }


    /**
     * Gets the ERRO_USUARIO_DESCONHECIDO value for this HomologacaoDTO.
     * 
     * @return ERRO_USUARIO_DESCONHECIDO
     */
    public int getERRO_USUARIO_DESCONHECIDO() {
        return ERRO_USUARIO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_DESCONHECIDO value for this HomologacaoDTO.
     * 
     * @param ERRO_USUARIO_DESCONHECIDO
     */
    public void setERRO_USUARIO_DESCONHECIDO(int ERRO_USUARIO_DESCONHECIDO) {
        this.ERRO_USUARIO_DESCONHECIDO = ERRO_USUARIO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_JA_HOMOLOGADO value for this HomologacaoDTO.
     * 
     * @return ERRO_USUARIO_JA_HOMOLOGADO
     */
    public int getERRO_USUARIO_JA_HOMOLOGADO() {
        return ERRO_USUARIO_JA_HOMOLOGADO;
    }


    /**
     * Sets the ERRO_USUARIO_JA_HOMOLOGADO value for this HomologacaoDTO.
     * 
     * @param ERRO_USUARIO_JA_HOMOLOGADO
     */
    public void setERRO_USUARIO_JA_HOMOLOGADO(int ERRO_USUARIO_JA_HOMOLOGADO) {
        this.ERRO_USUARIO_JA_HOMOLOGADO = ERRO_USUARIO_JA_HOMOLOGADO;
    }


    /**
     * Gets the ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR value for this HomologacaoDTO.
     * 
     * @return ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR
     */
    public int getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR() {
        return ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
    }


    /**
     * Sets the ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR value for this HomologacaoDTO.
     * 
     * @param ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR
     */
    public void setERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR(int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR) {
        this.ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this HomologacaoDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this HomologacaoDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the homologacaoGt value for this HomologacaoDTO.
     * 
     * @return homologacaoGt
     */
    public idw.idwws.OmHomogt getHomologacaoGt() {
        return homologacaoGt;
    }


    /**
     * Sets the homologacaoGt value for this HomologacaoDTO.
     * 
     * @param homologacaoGt
     */
    public void setHomologacaoGt(idw.idwws.OmHomogt homologacaoGt) {
        this.homologacaoGt = homologacaoGt;
    }


    /**
     * Gets the homologacaoPt value for this HomologacaoDTO.
     * 
     * @return homologacaoPt
     */
    public idw.idwws.OmHomopt getHomologacaoPt() {
        return homologacaoPt;
    }


    /**
     * Sets the homologacaoPt value for this HomologacaoDTO.
     * 
     * @param homologacaoPt
     */
    public void setHomologacaoPt(idw.idwws.OmHomopt homologacaoPt) {
        this.homologacaoPt = homologacaoPt;
    }


    /**
     * Gets the resultadoEvento value for this HomologacaoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this HomologacaoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HomologacaoDTO)) return false;
        HomologacaoDTO other = (HomologacaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_PT_DESCONHECIDO == other.getERRO_PT_DESCONHECIDO() &&
            this.ERRO_TIPOHOMOLOGACAO_INVALIDA == other.getERRO_TIPOHOMOLOGACAO_INVALIDA() &&
            this.ERRO_USUARIO_DESCONHECIDO == other.getERRO_USUARIO_DESCONHECIDO() &&
            this.ERRO_USUARIO_JA_HOMOLOGADO == other.getERRO_USUARIO_JA_HOMOLOGADO() &&
            this.ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR == other.getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.homologacaoGt==null && other.getHomologacaoGt()==null) || 
             (this.homologacaoGt!=null &&
              this.homologacaoGt.equals(other.getHomologacaoGt()))) &&
            ((this.homologacaoPt==null && other.getHomologacaoPt()==null) || 
             (this.homologacaoPt!=null &&
              this.homologacaoPt.equals(other.getHomologacaoPt()))) &&
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
        _hashCode += getERRO_PT_DESCONHECIDO();
        _hashCode += getERRO_TIPOHOMOLOGACAO_INVALIDA();
        _hashCode += getERRO_USUARIO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_JA_HOMOLOGADO();
        _hashCode += getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getHomologacaoGt() != null) {
            _hashCode += getHomologacaoGt().hashCode();
        }
        if (getHomologacaoPt() != null) {
            _hashCode += getHomologacaoPt().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HomologacaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "homologacaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPOHOMOLOGACAO_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPOHOMOLOGACAO_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_JA_HOMOLOGADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_JA_HOMOLOGADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR"));
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
        elemField.setFieldName("homologacaoGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "homologacaoGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomogt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homologacaoPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "homologacaoPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomopt"));
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
