/**
 * CalendariosSemanaisDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CalendariosSemanaisDTO  implements java.io.Serializable {
    private idw.idwws.CalendarioSemanalDTO[] calendariosSemanais;

    private int ERRO_DESCONHECIDO;

    private int ERRO_DIASEMANA_INVALIDO;

    private int ERRO_DURACAO_INVALIDA;

    private int ERRO_FIMTURNO_INVALIDO;

    private int ERRO_INICIOTURNO_INVALIDO;

    private int ERRO_INTERVALOMULTIPLO_DURACAO;

    private int ERRO_INTERVALO_INVALIDO;

    private int ERRO_TOLERANCIA_INVALIDA;

    private int ERRO_TPREFERENCIA_INVALIDA;

    private int ERRO_TURNO_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    public CalendariosSemanaisDTO() {
    }

    public CalendariosSemanaisDTO(
           idw.idwws.CalendarioSemanalDTO[] calendariosSemanais,
           int ERRO_DESCONHECIDO,
           int ERRO_DIASEMANA_INVALIDO,
           int ERRO_DURACAO_INVALIDA,
           int ERRO_FIMTURNO_INVALIDO,
           int ERRO_INICIOTURNO_INVALIDO,
           int ERRO_INTERVALOMULTIPLO_DURACAO,
           int ERRO_INTERVALO_INVALIDO,
           int ERRO_TOLERANCIA_INVALIDA,
           int ERRO_TPREFERENCIA_INVALIDA,
           int ERRO_TURNO_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento) {
           this.calendariosSemanais = calendariosSemanais;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_DIASEMANA_INVALIDO = ERRO_DIASEMANA_INVALIDO;
           this.ERRO_DURACAO_INVALIDA = ERRO_DURACAO_INVALIDA;
           this.ERRO_FIMTURNO_INVALIDO = ERRO_FIMTURNO_INVALIDO;
           this.ERRO_INICIOTURNO_INVALIDO = ERRO_INICIOTURNO_INVALIDO;
           this.ERRO_INTERVALOMULTIPLO_DURACAO = ERRO_INTERVALOMULTIPLO_DURACAO;
           this.ERRO_INTERVALO_INVALIDO = ERRO_INTERVALO_INVALIDO;
           this.ERRO_TOLERANCIA_INVALIDA = ERRO_TOLERANCIA_INVALIDA;
           this.ERRO_TPREFERENCIA_INVALIDA = ERRO_TPREFERENCIA_INVALIDA;
           this.ERRO_TURNO_DESCONHECIDO = ERRO_TURNO_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the calendariosSemanais value for this CalendariosSemanaisDTO.
     * 
     * @return calendariosSemanais
     */
    public idw.idwws.CalendarioSemanalDTO[] getCalendariosSemanais() {
        return calendariosSemanais;
    }


    /**
     * Sets the calendariosSemanais value for this CalendariosSemanaisDTO.
     * 
     * @param calendariosSemanais
     */
    public void setCalendariosSemanais(idw.idwws.CalendarioSemanalDTO[] calendariosSemanais) {
        this.calendariosSemanais = calendariosSemanais;
    }

    public idw.idwws.CalendarioSemanalDTO getCalendariosSemanais(int i) {
        return this.calendariosSemanais[i];
    }

    public void setCalendariosSemanais(int i, idw.idwws.CalendarioSemanalDTO _value) {
        this.calendariosSemanais[i] = _value;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DIASEMANA_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_DIASEMANA_INVALIDO
     */
    public int getERRO_DIASEMANA_INVALIDO() {
        return ERRO_DIASEMANA_INVALIDO;
    }


    /**
     * Sets the ERRO_DIASEMANA_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_DIASEMANA_INVALIDO
     */
    public void setERRO_DIASEMANA_INVALIDO(int ERRO_DIASEMANA_INVALIDO) {
        this.ERRO_DIASEMANA_INVALIDO = ERRO_DIASEMANA_INVALIDO;
    }


    /**
     * Gets the ERRO_DURACAO_INVALIDA value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_DURACAO_INVALIDA
     */
    public int getERRO_DURACAO_INVALIDA() {
        return ERRO_DURACAO_INVALIDA;
    }


    /**
     * Sets the ERRO_DURACAO_INVALIDA value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_DURACAO_INVALIDA
     */
    public void setERRO_DURACAO_INVALIDA(int ERRO_DURACAO_INVALIDA) {
        this.ERRO_DURACAO_INVALIDA = ERRO_DURACAO_INVALIDA;
    }


    /**
     * Gets the ERRO_FIMTURNO_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_FIMTURNO_INVALIDO
     */
    public int getERRO_FIMTURNO_INVALIDO() {
        return ERRO_FIMTURNO_INVALIDO;
    }


    /**
     * Sets the ERRO_FIMTURNO_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_FIMTURNO_INVALIDO
     */
    public void setERRO_FIMTURNO_INVALIDO(int ERRO_FIMTURNO_INVALIDO) {
        this.ERRO_FIMTURNO_INVALIDO = ERRO_FIMTURNO_INVALIDO;
    }


    /**
     * Gets the ERRO_INICIOTURNO_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_INICIOTURNO_INVALIDO
     */
    public int getERRO_INICIOTURNO_INVALIDO() {
        return ERRO_INICIOTURNO_INVALIDO;
    }


    /**
     * Sets the ERRO_INICIOTURNO_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_INICIOTURNO_INVALIDO
     */
    public void setERRO_INICIOTURNO_INVALIDO(int ERRO_INICIOTURNO_INVALIDO) {
        this.ERRO_INICIOTURNO_INVALIDO = ERRO_INICIOTURNO_INVALIDO;
    }


    /**
     * Gets the ERRO_INTERVALOMULTIPLO_DURACAO value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_INTERVALOMULTIPLO_DURACAO
     */
    public int getERRO_INTERVALOMULTIPLO_DURACAO() {
        return ERRO_INTERVALOMULTIPLO_DURACAO;
    }


    /**
     * Sets the ERRO_INTERVALOMULTIPLO_DURACAO value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_INTERVALOMULTIPLO_DURACAO
     */
    public void setERRO_INTERVALOMULTIPLO_DURACAO(int ERRO_INTERVALOMULTIPLO_DURACAO) {
        this.ERRO_INTERVALOMULTIPLO_DURACAO = ERRO_INTERVALOMULTIPLO_DURACAO;
    }


    /**
     * Gets the ERRO_INTERVALO_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_INTERVALO_INVALIDO
     */
    public int getERRO_INTERVALO_INVALIDO() {
        return ERRO_INTERVALO_INVALIDO;
    }


    /**
     * Sets the ERRO_INTERVALO_INVALIDO value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_INTERVALO_INVALIDO
     */
    public void setERRO_INTERVALO_INVALIDO(int ERRO_INTERVALO_INVALIDO) {
        this.ERRO_INTERVALO_INVALIDO = ERRO_INTERVALO_INVALIDO;
    }


    /**
     * Gets the ERRO_TOLERANCIA_INVALIDA value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_TOLERANCIA_INVALIDA
     */
    public int getERRO_TOLERANCIA_INVALIDA() {
        return ERRO_TOLERANCIA_INVALIDA;
    }


    /**
     * Sets the ERRO_TOLERANCIA_INVALIDA value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_TOLERANCIA_INVALIDA
     */
    public void setERRO_TOLERANCIA_INVALIDA(int ERRO_TOLERANCIA_INVALIDA) {
        this.ERRO_TOLERANCIA_INVALIDA = ERRO_TOLERANCIA_INVALIDA;
    }


    /**
     * Gets the ERRO_TPREFERENCIA_INVALIDA value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_TPREFERENCIA_INVALIDA
     */
    public int getERRO_TPREFERENCIA_INVALIDA() {
        return ERRO_TPREFERENCIA_INVALIDA;
    }


    /**
     * Sets the ERRO_TPREFERENCIA_INVALIDA value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_TPREFERENCIA_INVALIDA
     */
    public void setERRO_TPREFERENCIA_INVALIDA(int ERRO_TPREFERENCIA_INVALIDA) {
        this.ERRO_TPREFERENCIA_INVALIDA = ERRO_TPREFERENCIA_INVALIDA;
    }


    /**
     * Gets the ERRO_TURNO_DESCONHECIDO value for this CalendariosSemanaisDTO.
     * 
     * @return ERRO_TURNO_DESCONHECIDO
     */
    public int getERRO_TURNO_DESCONHECIDO() {
        return ERRO_TURNO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TURNO_DESCONHECIDO value for this CalendariosSemanaisDTO.
     * 
     * @param ERRO_TURNO_DESCONHECIDO
     */
    public void setERRO_TURNO_DESCONHECIDO(int ERRO_TURNO_DESCONHECIDO) {
        this.ERRO_TURNO_DESCONHECIDO = ERRO_TURNO_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this CalendariosSemanaisDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this CalendariosSemanaisDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this CalendariosSemanaisDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this CalendariosSemanaisDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CalendariosSemanaisDTO)) return false;
        CalendariosSemanaisDTO other = (CalendariosSemanaisDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calendariosSemanais==null && other.getCalendariosSemanais()==null) || 
             (this.calendariosSemanais!=null &&
              java.util.Arrays.equals(this.calendariosSemanais, other.getCalendariosSemanais()))) &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_DIASEMANA_INVALIDO == other.getERRO_DIASEMANA_INVALIDO() &&
            this.ERRO_DURACAO_INVALIDA == other.getERRO_DURACAO_INVALIDA() &&
            this.ERRO_FIMTURNO_INVALIDO == other.getERRO_FIMTURNO_INVALIDO() &&
            this.ERRO_INICIOTURNO_INVALIDO == other.getERRO_INICIOTURNO_INVALIDO() &&
            this.ERRO_INTERVALOMULTIPLO_DURACAO == other.getERRO_INTERVALOMULTIPLO_DURACAO() &&
            this.ERRO_INTERVALO_INVALIDO == other.getERRO_INTERVALO_INVALIDO() &&
            this.ERRO_TOLERANCIA_INVALIDA == other.getERRO_TOLERANCIA_INVALIDA() &&
            this.ERRO_TPREFERENCIA_INVALIDA == other.getERRO_TPREFERENCIA_INVALIDA() &&
            this.ERRO_TURNO_DESCONHECIDO == other.getERRO_TURNO_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
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
        if (getCalendariosSemanais() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCalendariosSemanais());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCalendariosSemanais(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_DIASEMANA_INVALIDO();
        _hashCode += getERRO_DURACAO_INVALIDA();
        _hashCode += getERRO_FIMTURNO_INVALIDO();
        _hashCode += getERRO_INICIOTURNO_INVALIDO();
        _hashCode += getERRO_INTERVALOMULTIPLO_DURACAO();
        _hashCode += getERRO_INTERVALO_INVALIDO();
        _hashCode += getERRO_TOLERANCIA_INVALIDA();
        _hashCode += getERRO_TPREFERENCIA_INVALIDA();
        _hashCode += getERRO_TURNO_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CalendariosSemanaisDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendariosSemanaisDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendariosSemanais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendariosSemanais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioSemanalDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DIASEMANA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DIASEMANA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DURACAO_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DURACAO_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_FIMTURNO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_FIMTURNO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_INICIOTURNO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_INICIOTURNO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_INTERVALOMULTIPLO_DURACAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_INTERVALOMULTIPLO_DURACAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_INTERVALO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_INTERVALO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TOLERANCIA_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TOLERANCIA_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TPREFERENCIA_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TPREFERENCIA_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TURNO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TURNO_DESCONHECIDO"));
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
