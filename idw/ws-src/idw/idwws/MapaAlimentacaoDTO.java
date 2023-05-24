/**
 * MapaAlimentacaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MapaAlimentacaoDTO  implements java.io.Serializable {
    private int ERRO_CDMAPAPA_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_MAPA_JA_EXISTE;

    private int ERRO_POSTO_DESCONHECIDO;

    private int ERRO_PRODUTO_DESCONHECIDO;

    private int ERRO_PROGRAMA_DESCONHECIDO;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_SEM_CONFIGURACAO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.MapaPaDTO[] mapaPas;

    private idw.idwws.MapaPaDTO[] mapaPasParaExclusao;

    private idw.idwws.OmMapa ommapa;

    private int resultadoEvento;

    public MapaAlimentacaoDTO() {
    }

    public MapaAlimentacaoDTO(
           int ERRO_CDMAPAPA_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_MAPA_JA_EXISTE,
           int ERRO_POSTO_DESCONHECIDO,
           int ERRO_PRODUTO_DESCONHECIDO,
           int ERRO_PROGRAMA_DESCONHECIDO,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_SEM_CONFIGURACAO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.MapaPaDTO[] mapaPas,
           idw.idwws.MapaPaDTO[] mapaPasParaExclusao,
           idw.idwws.OmMapa ommapa,
           int resultadoEvento) {
           this.ERRO_CDMAPAPA_INVALIDO = ERRO_CDMAPAPA_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_MAPA_JA_EXISTE = ERRO_MAPA_JA_EXISTE;
           this.ERRO_POSTO_DESCONHECIDO = ERRO_POSTO_DESCONHECIDO;
           this.ERRO_PRODUTO_DESCONHECIDO = ERRO_PRODUTO_DESCONHECIDO;
           this.ERRO_PROGRAMA_DESCONHECIDO = ERRO_PROGRAMA_DESCONHECIDO;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_SEM_CONFIGURACAO = ERRO_SEM_CONFIGURACAO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.mapaPas = mapaPas;
           this.mapaPasParaExclusao = mapaPasParaExclusao;
           this.ommapa = ommapa;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_CDMAPAPA_INVALIDO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_CDMAPAPA_INVALIDO
     */
    public int getERRO_CDMAPAPA_INVALIDO() {
        return ERRO_CDMAPAPA_INVALIDO;
    }


    /**
     * Sets the ERRO_CDMAPAPA_INVALIDO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_CDMAPAPA_INVALIDO
     */
    public void setERRO_CDMAPAPA_INVALIDO(int ERRO_CDMAPAPA_INVALIDO) {
        this.ERRO_CDMAPAPA_INVALIDO = ERRO_CDMAPAPA_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_MAPA_JA_EXISTE value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_MAPA_JA_EXISTE
     */
    public int getERRO_MAPA_JA_EXISTE() {
        return ERRO_MAPA_JA_EXISTE;
    }


    /**
     * Sets the ERRO_MAPA_JA_EXISTE value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_MAPA_JA_EXISTE
     */
    public void setERRO_MAPA_JA_EXISTE(int ERRO_MAPA_JA_EXISTE) {
        this.ERRO_MAPA_JA_EXISTE = ERRO_MAPA_JA_EXISTE;
    }


    /**
     * Gets the ERRO_POSTO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_POSTO_DESCONHECIDO
     */
    public int getERRO_POSTO_DESCONHECIDO() {
        return ERRO_POSTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_POSTO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_POSTO_DESCONHECIDO
     */
    public void setERRO_POSTO_DESCONHECIDO(int ERRO_POSTO_DESCONHECIDO) {
        this.ERRO_POSTO_DESCONHECIDO = ERRO_POSTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PRODUTO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_PRODUTO_DESCONHECIDO
     */
    public int getERRO_PRODUTO_DESCONHECIDO() {
        return ERRO_PRODUTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PRODUTO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_PRODUTO_DESCONHECIDO
     */
    public void setERRO_PRODUTO_DESCONHECIDO(int ERRO_PRODUTO_DESCONHECIDO) {
        this.ERRO_PRODUTO_DESCONHECIDO = ERRO_PRODUTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PROGRAMA_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_PROGRAMA_DESCONHECIDO
     */
    public int getERRO_PROGRAMA_DESCONHECIDO() {
        return ERRO_PROGRAMA_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PROGRAMA_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_PROGRAMA_DESCONHECIDO
     */
    public void setERRO_PROGRAMA_DESCONHECIDO(int ERRO_PROGRAMA_DESCONHECIDO) {
        this.ERRO_PROGRAMA_DESCONHECIDO = ERRO_PROGRAMA_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_SEM_CONFIGURACAO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_SEM_CONFIGURACAO
     */
    public int getERRO_SEM_CONFIGURACAO() {
        return ERRO_SEM_CONFIGURACAO;
    }


    /**
     * Sets the ERRO_SEM_CONFIGURACAO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_SEM_CONFIGURACAO
     */
    public void setERRO_SEM_CONFIGURACAO(int ERRO_SEM_CONFIGURACAO) {
        this.ERRO_SEM_CONFIGURACAO = ERRO_SEM_CONFIGURACAO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this MapaAlimentacaoDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this MapaAlimentacaoDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this MapaAlimentacaoDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the mapaPas value for this MapaAlimentacaoDTO.
     * 
     * @return mapaPas
     */
    public idw.idwws.MapaPaDTO[] getMapaPas() {
        return mapaPas;
    }


    /**
     * Sets the mapaPas value for this MapaAlimentacaoDTO.
     * 
     * @param mapaPas
     */
    public void setMapaPas(idw.idwws.MapaPaDTO[] mapaPas) {
        this.mapaPas = mapaPas;
    }


    /**
     * Gets the mapaPasParaExclusao value for this MapaAlimentacaoDTO.
     * 
     * @return mapaPasParaExclusao
     */
    public idw.idwws.MapaPaDTO[] getMapaPasParaExclusao() {
        return mapaPasParaExclusao;
    }


    /**
     * Sets the mapaPasParaExclusao value for this MapaAlimentacaoDTO.
     * 
     * @param mapaPasParaExclusao
     */
    public void setMapaPasParaExclusao(idw.idwws.MapaPaDTO[] mapaPasParaExclusao) {
        this.mapaPasParaExclusao = mapaPasParaExclusao;
    }


    /**
     * Gets the ommapa value for this MapaAlimentacaoDTO.
     * 
     * @return ommapa
     */
    public idw.idwws.OmMapa getOmmapa() {
        return ommapa;
    }


    /**
     * Sets the ommapa value for this MapaAlimentacaoDTO.
     * 
     * @param ommapa
     */
    public void setOmmapa(idw.idwws.OmMapa ommapa) {
        this.ommapa = ommapa;
    }


    /**
     * Gets the resultadoEvento value for this MapaAlimentacaoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this MapaAlimentacaoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MapaAlimentacaoDTO)) return false;
        MapaAlimentacaoDTO other = (MapaAlimentacaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_CDMAPAPA_INVALIDO == other.getERRO_CDMAPAPA_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_MAPA_JA_EXISTE == other.getERRO_MAPA_JA_EXISTE() &&
            this.ERRO_POSTO_DESCONHECIDO == other.getERRO_POSTO_DESCONHECIDO() &&
            this.ERRO_PRODUTO_DESCONHECIDO == other.getERRO_PRODUTO_DESCONHECIDO() &&
            this.ERRO_PROGRAMA_DESCONHECIDO == other.getERRO_PROGRAMA_DESCONHECIDO() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_SEM_CONFIGURACAO == other.getERRO_SEM_CONFIGURACAO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.mapaPas==null && other.getMapaPas()==null) || 
             (this.mapaPas!=null &&
              java.util.Arrays.equals(this.mapaPas, other.getMapaPas()))) &&
            ((this.mapaPasParaExclusao==null && other.getMapaPasParaExclusao()==null) || 
             (this.mapaPasParaExclusao!=null &&
              java.util.Arrays.equals(this.mapaPasParaExclusao, other.getMapaPasParaExclusao()))) &&
            ((this.ommapa==null && other.getOmmapa()==null) || 
             (this.ommapa!=null &&
              this.ommapa.equals(other.getOmmapa()))) &&
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
        _hashCode += getERRO_CDMAPAPA_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_MAPA_JA_EXISTE();
        _hashCode += getERRO_POSTO_DESCONHECIDO();
        _hashCode += getERRO_PRODUTO_DESCONHECIDO();
        _hashCode += getERRO_PROGRAMA_DESCONHECIDO();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_SEM_CONFIGURACAO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getMapaPas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMapaPas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMapaPas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMapaPasParaExclusao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMapaPasParaExclusao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMapaPasParaExclusao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmmapa() != null) {
            _hashCode += getOmmapa().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MapaAlimentacaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaAlimentacaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDMAPAPA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDMAPAPA_INVALIDO"));
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
        elemField.setFieldName("ERRO_MAPA_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_MAPA_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_POSTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_POSTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PRODUTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PRODUTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PROGRAMA_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PROGRAMA_DESCONHECIDO"));
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
        elemField.setFieldName("ERRO_SEM_CONFIGURACAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_SEM_CONFIGURACAO"));
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
        elemField.setFieldName("mapaPas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaPas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaPaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "mapaPas"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapaPasParaExclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaPasParaExclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaPaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "mapaPas"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ommapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ommapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapa"));
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
