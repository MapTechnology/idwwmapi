/**
 * EstoqueDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EstoqueDTO  implements java.io.Serializable {
    private idw.idwws.DwEstpro dwEstPro;

    private idw.idwws.DwEstmov dwEstmov;

    private int ERRO_CDESTOQUE_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_ESTOQUE_JA_EXISTE;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.DwEst estoque;

    private java.lang.Integer mudarPara;

    private int resultadoEvento;

    public EstoqueDTO() {
    }

    public EstoqueDTO(
           idw.idwws.DwEstpro dwEstPro,
           idw.idwws.DwEstmov dwEstmov,
           int ERRO_CDESTOQUE_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_ESTOQUE_JA_EXISTE,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.DwEst estoque,
           java.lang.Integer mudarPara,
           int resultadoEvento) {
           this.dwEstPro = dwEstPro;
           this.dwEstmov = dwEstmov;
           this.ERRO_CDESTOQUE_INVALIDO = ERRO_CDESTOQUE_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_ESTOQUE_JA_EXISTE = ERRO_ESTOQUE_JA_EXISTE;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.estoque = estoque;
           this.mudarPara = mudarPara;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the dwEstPro value for this EstoqueDTO.
     * 
     * @return dwEstPro
     */
    public idw.idwws.DwEstpro getDwEstPro() {
        return dwEstPro;
    }


    /**
     * Sets the dwEstPro value for this EstoqueDTO.
     * 
     * @param dwEstPro
     */
    public void setDwEstPro(idw.idwws.DwEstpro dwEstPro) {
        this.dwEstPro = dwEstPro;
    }


    /**
     * Gets the dwEstmov value for this EstoqueDTO.
     * 
     * @return dwEstmov
     */
    public idw.idwws.DwEstmov getDwEstmov() {
        return dwEstmov;
    }


    /**
     * Sets the dwEstmov value for this EstoqueDTO.
     * 
     * @param dwEstmov
     */
    public void setDwEstmov(idw.idwws.DwEstmov dwEstmov) {
        this.dwEstmov = dwEstmov;
    }


    /**
     * Gets the ERRO_CDESTOQUE_INVALIDO value for this EstoqueDTO.
     * 
     * @return ERRO_CDESTOQUE_INVALIDO
     */
    public int getERRO_CDESTOQUE_INVALIDO() {
        return ERRO_CDESTOQUE_INVALIDO;
    }


    /**
     * Sets the ERRO_CDESTOQUE_INVALIDO value for this EstoqueDTO.
     * 
     * @param ERRO_CDESTOQUE_INVALIDO
     */
    public void setERRO_CDESTOQUE_INVALIDO(int ERRO_CDESTOQUE_INVALIDO) {
        this.ERRO_CDESTOQUE_INVALIDO = ERRO_CDESTOQUE_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this EstoqueDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this EstoqueDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_ESTOQUE_JA_EXISTE value for this EstoqueDTO.
     * 
     * @return ERRO_ESTOQUE_JA_EXISTE
     */
    public int getERRO_ESTOQUE_JA_EXISTE() {
        return ERRO_ESTOQUE_JA_EXISTE;
    }


    /**
     * Sets the ERRO_ESTOQUE_JA_EXISTE value for this EstoqueDTO.
     * 
     * @param ERRO_ESTOQUE_JA_EXISTE
     */
    public void setERRO_ESTOQUE_JA_EXISTE(int ERRO_ESTOQUE_JA_EXISTE) {
        this.ERRO_ESTOQUE_JA_EXISTE = ERRO_ESTOQUE_JA_EXISTE;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this EstoqueDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this EstoqueDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this EstoqueDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this EstoqueDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this EstoqueDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this EstoqueDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this EstoqueDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this EstoqueDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the estoque value for this EstoqueDTO.
     * 
     * @return estoque
     */
    public idw.idwws.DwEst getEstoque() {
        return estoque;
    }


    /**
     * Sets the estoque value for this EstoqueDTO.
     * 
     * @param estoque
     */
    public void setEstoque(idw.idwws.DwEst estoque) {
        this.estoque = estoque;
    }


    /**
     * Gets the mudarPara value for this EstoqueDTO.
     * 
     * @return mudarPara
     */
    public java.lang.Integer getMudarPara() {
        return mudarPara;
    }


    /**
     * Sets the mudarPara value for this EstoqueDTO.
     * 
     * @param mudarPara
     */
    public void setMudarPara(java.lang.Integer mudarPara) {
        this.mudarPara = mudarPara;
    }


    /**
     * Gets the resultadoEvento value for this EstoqueDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this EstoqueDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstoqueDTO)) return false;
        EstoqueDTO other = (EstoqueDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwEstPro==null && other.getDwEstPro()==null) || 
             (this.dwEstPro!=null &&
              this.dwEstPro.equals(other.getDwEstPro()))) &&
            ((this.dwEstmov==null && other.getDwEstmov()==null) || 
             (this.dwEstmov!=null &&
              this.dwEstmov.equals(other.getDwEstmov()))) &&
            this.ERRO_CDESTOQUE_INVALIDO == other.getERRO_CDESTOQUE_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_ESTOQUE_JA_EXISTE == other.getERRO_ESTOQUE_JA_EXISTE() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.estoque==null && other.getEstoque()==null) || 
             (this.estoque!=null &&
              this.estoque.equals(other.getEstoque()))) &&
            ((this.mudarPara==null && other.getMudarPara()==null) || 
             (this.mudarPara!=null &&
              this.mudarPara.equals(other.getMudarPara()))) &&
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
        if (getDwEstPro() != null) {
            _hashCode += getDwEstPro().hashCode();
        }
        if (getDwEstmov() != null) {
            _hashCode += getDwEstmov().hashCode();
        }
        _hashCode += getERRO_CDESTOQUE_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_ESTOQUE_JA_EXISTE();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getEstoque() != null) {
            _hashCode += getEstoque().hashCode();
        }
        if (getMudarPara() != null) {
            _hashCode += getMudarPara().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstoqueDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "estoqueDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstPro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstPro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstmov");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstmov"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstmov"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDESTOQUE_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDESTOQUE_INVALIDO"));
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
        elemField.setFieldName("ERRO_ESTOQUE_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_ESTOQUE_JA_EXISTE"));
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
        elemField.setFieldName("estoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mudarPara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mudarPara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
