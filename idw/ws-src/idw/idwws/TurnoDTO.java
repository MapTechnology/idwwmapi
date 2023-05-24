/**
 * TurnoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TurnoDTO  implements java.io.Serializable {
    private int ERRO_CDTURNO_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_TURNO_JA_EXISTE;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private java.math.BigDecimal quantidade;

    private int resultadoEvento;

    private idw.idwws.DwTurno turno;

    public TurnoDTO() {
    }

    public TurnoDTO(
           int ERRO_CDTURNO_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_TURNO_JA_EXISTE,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           java.math.BigDecimal quantidade,
           int resultadoEvento,
           idw.idwws.DwTurno turno) {
           this.ERRO_CDTURNO_INVALIDO = ERRO_CDTURNO_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_TURNO_JA_EXISTE = ERRO_TURNO_JA_EXISTE;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.quantidade = quantidade;
           this.resultadoEvento = resultadoEvento;
           this.turno = turno;
    }


    /**
     * Gets the ERRO_CDTURNO_INVALIDO value for this TurnoDTO.
     * 
     * @return ERRO_CDTURNO_INVALIDO
     */
    public int getERRO_CDTURNO_INVALIDO() {
        return ERRO_CDTURNO_INVALIDO;
    }


    /**
     * Sets the ERRO_CDTURNO_INVALIDO value for this TurnoDTO.
     * 
     * @param ERRO_CDTURNO_INVALIDO
     */
    public void setERRO_CDTURNO_INVALIDO(int ERRO_CDTURNO_INVALIDO) {
        this.ERRO_CDTURNO_INVALIDO = ERRO_CDTURNO_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this TurnoDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this TurnoDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this TurnoDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this TurnoDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_TURNO_JA_EXISTE value for this TurnoDTO.
     * 
     * @return ERRO_TURNO_JA_EXISTE
     */
    public int getERRO_TURNO_JA_EXISTE() {
        return ERRO_TURNO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_TURNO_JA_EXISTE value for this TurnoDTO.
     * 
     * @param ERRO_TURNO_JA_EXISTE
     */
    public void setERRO_TURNO_JA_EXISTE(int ERRO_TURNO_JA_EXISTE) {
        this.ERRO_TURNO_JA_EXISTE = ERRO_TURNO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this TurnoDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this TurnoDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this TurnoDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this TurnoDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this TurnoDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this TurnoDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the quantidade value for this TurnoDTO.
     * 
     * @return quantidade
     */
    public java.math.BigDecimal getQuantidade() {
        return quantidade;
    }


    /**
     * Sets the quantidade value for this TurnoDTO.
     * 
     * @param quantidade
     */
    public void setQuantidade(java.math.BigDecimal quantidade) {
        this.quantidade = quantidade;
    }


    /**
     * Gets the resultadoEvento value for this TurnoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this TurnoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the turno value for this TurnoDTO.
     * 
     * @return turno
     */
    public idw.idwws.DwTurno getTurno() {
        return turno;
    }


    /**
     * Sets the turno value for this TurnoDTO.
     * 
     * @param turno
     */
    public void setTurno(idw.idwws.DwTurno turno) {
        this.turno = turno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TurnoDTO)) return false;
        TurnoDTO other = (TurnoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_CDTURNO_INVALIDO == other.getERRO_CDTURNO_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_TURNO_JA_EXISTE == other.getERRO_TURNO_JA_EXISTE() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.quantidade==null && other.getQuantidade()==null) || 
             (this.quantidade!=null &&
              this.quantidade.equals(other.getQuantidade()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.turno==null && other.getTurno()==null) || 
             (this.turno!=null &&
              this.turno.equals(other.getTurno())));
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
        _hashCode += getERRO_CDTURNO_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_TURNO_JA_EXISTE();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getQuantidade() != null) {
            _hashCode += getQuantidade().hashCode();
        }
        _hashCode += getResultadoEvento();
        if (getTurno() != null) {
            _hashCode += getTurno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TurnoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "turnoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDTURNO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDTURNO_INVALIDO"));
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
        elemField.setFieldName("ERRO_REATIVACAO_INDISPONIVEL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_REATIVACAO_INDISPONIVEL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TURNO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TURNO_JA_EXISTE"));
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
        elemField.setFieldName("quantidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("turno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "turno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
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
