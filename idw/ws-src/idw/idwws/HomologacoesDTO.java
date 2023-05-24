/**
 * HomologacoesDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class HomologacoesDTO  implements java.io.Serializable {
    private int ERRO_GT_DESCONHECIDO;

    private int ERRO_PT_DESCONHECIDO;

    private int ERRO_TIPOHOMOLOGACAO_INVALIDA;

    private int ERRO_USUARIO_DESCONHECIDO;

    private int ERRO_USUARIO_JA_HOMOLOGADO;

    private int ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR;

    private int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.HomologacaoDTO[] homologacoesGt;

    private idw.idwws.HomologacaoDTO[] homologacoesPt;

    private int resultadoEvento;

    public HomologacoesDTO() {
    }

    public HomologacoesDTO(
           int ERRO_GT_DESCONHECIDO,
           int ERRO_PT_DESCONHECIDO,
           int ERRO_TIPOHOMOLOGACAO_INVALIDA,
           int ERRO_USUARIO_DESCONHECIDO,
           int ERRO_USUARIO_JA_HOMOLOGADO,
           int ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR,
           int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.HomologacaoDTO[] homologacoesGt,
           idw.idwws.HomologacaoDTO[] homologacoesPt,
           int resultadoEvento) {
           this.ERRO_GT_DESCONHECIDO = ERRO_GT_DESCONHECIDO;
           this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
           this.ERRO_TIPOHOMOLOGACAO_INVALIDA = ERRO_TIPOHOMOLOGACAO_INVALIDA;
           this.ERRO_USUARIO_DESCONHECIDO = ERRO_USUARIO_DESCONHECIDO;
           this.ERRO_USUARIO_JA_HOMOLOGADO = ERRO_USUARIO_JA_HOMOLOGADO;
           this.ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR = ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR;
           this.ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.homologacoesGt = homologacoesGt;
           this.homologacoesPt = homologacoesPt;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_GT_DESCONHECIDO value for this HomologacoesDTO.
     * 
     * @return ERRO_GT_DESCONHECIDO
     */
    public int getERRO_GT_DESCONHECIDO() {
        return ERRO_GT_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_GT_DESCONHECIDO value for this HomologacoesDTO.
     * 
     * @param ERRO_GT_DESCONHECIDO
     */
    public void setERRO_GT_DESCONHECIDO(int ERRO_GT_DESCONHECIDO) {
        this.ERRO_GT_DESCONHECIDO = ERRO_GT_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PT_DESCONHECIDO value for this HomologacoesDTO.
     * 
     * @return ERRO_PT_DESCONHECIDO
     */
    public int getERRO_PT_DESCONHECIDO() {
        return ERRO_PT_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PT_DESCONHECIDO value for this HomologacoesDTO.
     * 
     * @param ERRO_PT_DESCONHECIDO
     */
    public void setERRO_PT_DESCONHECIDO(int ERRO_PT_DESCONHECIDO) {
        this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_TIPOHOMOLOGACAO_INVALIDA value for this HomologacoesDTO.
     * 
     * @return ERRO_TIPOHOMOLOGACAO_INVALIDA
     */
    public int getERRO_TIPOHOMOLOGACAO_INVALIDA() {
        return ERRO_TIPOHOMOLOGACAO_INVALIDA;
    }


    /**
     * Sets the ERRO_TIPOHOMOLOGACAO_INVALIDA value for this HomologacoesDTO.
     * 
     * @param ERRO_TIPOHOMOLOGACAO_INVALIDA
     */
    public void setERRO_TIPOHOMOLOGACAO_INVALIDA(int ERRO_TIPOHOMOLOGACAO_INVALIDA) {
        this.ERRO_TIPOHOMOLOGACAO_INVALIDA = ERRO_TIPOHOMOLOGACAO_INVALIDA;
    }


    /**
     * Gets the ERRO_USUARIO_DESCONHECIDO value for this HomologacoesDTO.
     * 
     * @return ERRO_USUARIO_DESCONHECIDO
     */
    public int getERRO_USUARIO_DESCONHECIDO() {
        return ERRO_USUARIO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_DESCONHECIDO value for this HomologacoesDTO.
     * 
     * @param ERRO_USUARIO_DESCONHECIDO
     */
    public void setERRO_USUARIO_DESCONHECIDO(int ERRO_USUARIO_DESCONHECIDO) {
        this.ERRO_USUARIO_DESCONHECIDO = ERRO_USUARIO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_JA_HOMOLOGADO value for this HomologacoesDTO.
     * 
     * @return ERRO_USUARIO_JA_HOMOLOGADO
     */
    public int getERRO_USUARIO_JA_HOMOLOGADO() {
        return ERRO_USUARIO_JA_HOMOLOGADO;
    }


    /**
     * Sets the ERRO_USUARIO_JA_HOMOLOGADO value for this HomologacoesDTO.
     * 
     * @param ERRO_USUARIO_JA_HOMOLOGADO
     */
    public void setERRO_USUARIO_JA_HOMOLOGADO(int ERRO_USUARIO_JA_HOMOLOGADO) {
        this.ERRO_USUARIO_JA_HOMOLOGADO = ERRO_USUARIO_JA_HOMOLOGADO;
    }


    /**
     * Gets the ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR value for this HomologacoesDTO.
     * 
     * @return ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR
     */
    public int getERRO_USUARIO_JA_HOMOLOGADO_OPERADOR() {
        return ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR;
    }


    /**
     * Sets the ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR value for this HomologacoesDTO.
     * 
     * @param ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR
     */
    public void setERRO_USUARIO_JA_HOMOLOGADO_OPERADOR(int ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR) {
        this.ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR = ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR;
    }


    /**
     * Gets the ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR value for this HomologacoesDTO.
     * 
     * @return ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR
     */
    public int getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR() {
        return ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
    }


    /**
     * Sets the ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR value for this HomologacoesDTO.
     * 
     * @param ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR
     */
    public void setERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR(int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR) {
        this.ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this HomologacoesDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this HomologacoesDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the homologacoesGt value for this HomologacoesDTO.
     * 
     * @return homologacoesGt
     */
    public idw.idwws.HomologacaoDTO[] getHomologacoesGt() {
        return homologacoesGt;
    }


    /**
     * Sets the homologacoesGt value for this HomologacoesDTO.
     * 
     * @param homologacoesGt
     */
    public void setHomologacoesGt(idw.idwws.HomologacaoDTO[] homologacoesGt) {
        this.homologacoesGt = homologacoesGt;
    }

    public idw.idwws.HomologacaoDTO getHomologacoesGt(int i) {
        return this.homologacoesGt[i];
    }

    public void setHomologacoesGt(int i, idw.idwws.HomologacaoDTO _value) {
        this.homologacoesGt[i] = _value;
    }


    /**
     * Gets the homologacoesPt value for this HomologacoesDTO.
     * 
     * @return homologacoesPt
     */
    public idw.idwws.HomologacaoDTO[] getHomologacoesPt() {
        return homologacoesPt;
    }


    /**
     * Sets the homologacoesPt value for this HomologacoesDTO.
     * 
     * @param homologacoesPt
     */
    public void setHomologacoesPt(idw.idwws.HomologacaoDTO[] homologacoesPt) {
        this.homologacoesPt = homologacoesPt;
    }

    public idw.idwws.HomologacaoDTO getHomologacoesPt(int i) {
        return this.homologacoesPt[i];
    }

    public void setHomologacoesPt(int i, idw.idwws.HomologacaoDTO _value) {
        this.homologacoesPt[i] = _value;
    }


    /**
     * Gets the resultadoEvento value for this HomologacoesDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this HomologacoesDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HomologacoesDTO)) return false;
        HomologacoesDTO other = (HomologacoesDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_GT_DESCONHECIDO == other.getERRO_GT_DESCONHECIDO() &&
            this.ERRO_PT_DESCONHECIDO == other.getERRO_PT_DESCONHECIDO() &&
            this.ERRO_TIPOHOMOLOGACAO_INVALIDA == other.getERRO_TIPOHOMOLOGACAO_INVALIDA() &&
            this.ERRO_USUARIO_DESCONHECIDO == other.getERRO_USUARIO_DESCONHECIDO() &&
            this.ERRO_USUARIO_JA_HOMOLOGADO == other.getERRO_USUARIO_JA_HOMOLOGADO() &&
            this.ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR == other.getERRO_USUARIO_JA_HOMOLOGADO_OPERADOR() &&
            this.ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR == other.getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.homologacoesGt==null && other.getHomologacoesGt()==null) || 
             (this.homologacoesGt!=null &&
              java.util.Arrays.equals(this.homologacoesGt, other.getHomologacoesGt()))) &&
            ((this.homologacoesPt==null && other.getHomologacoesPt()==null) || 
             (this.homologacoesPt!=null &&
              java.util.Arrays.equals(this.homologacoesPt, other.getHomologacoesPt()))) &&
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
        _hashCode += getERRO_GT_DESCONHECIDO();
        _hashCode += getERRO_PT_DESCONHECIDO();
        _hashCode += getERRO_TIPOHOMOLOGACAO_INVALIDA();
        _hashCode += getERRO_USUARIO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_JA_HOMOLOGADO();
        _hashCode += getERRO_USUARIO_JA_HOMOLOGADO_OPERADOR();
        _hashCode += getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getHomologacoesGt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHomologacoesGt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHomologacoesGt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHomologacoesPt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHomologacoesPt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHomologacoesPt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HomologacoesDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "homologacoesDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_GT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_GT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR"));
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
        elemField.setFieldName("homologacoesGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "homologacoesGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "homologacaoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homologacoesPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "homologacoesPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "homologacaoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
