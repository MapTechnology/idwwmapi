/**
 * CalendarioWizardDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CalendarioWizardDTO  implements java.io.Serializable {
    private java.lang.Integer[] diasSemana;

    private double duracao;

    private int ERRO_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private java.math.BigDecimal hrFinalTurno;

    private java.math.BigDecimal hrInicioTurno;

    private double intervalo;

    private java.math.BigDecimal posTolerancia;

    private java.math.BigDecimal preTolerancia;

    private int resultadoEvento;

    private int tpReferencia;

    private idw.idwws.DwTurno turno;

    public CalendarioWizardDTO() {
    }

    public CalendarioWizardDTO(
           java.lang.Integer[] diasSemana,
           double duracao,
           int ERRO_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           java.math.BigDecimal hrFinalTurno,
           java.math.BigDecimal hrInicioTurno,
           double intervalo,
           java.math.BigDecimal posTolerancia,
           java.math.BigDecimal preTolerancia,
           int resultadoEvento,
           int tpReferencia,
           idw.idwws.DwTurno turno) {
           this.diasSemana = diasSemana;
           this.duracao = duracao;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.hrFinalTurno = hrFinalTurno;
           this.hrInicioTurno = hrInicioTurno;
           this.intervalo = intervalo;
           this.posTolerancia = posTolerancia;
           this.preTolerancia = preTolerancia;
           this.resultadoEvento = resultadoEvento;
           this.tpReferencia = tpReferencia;
           this.turno = turno;
    }


    /**
     * Gets the diasSemana value for this CalendarioWizardDTO.
     * 
     * @return diasSemana
     */
    public java.lang.Integer[] getDiasSemana() {
        return diasSemana;
    }


    /**
     * Sets the diasSemana value for this CalendarioWizardDTO.
     * 
     * @param diasSemana
     */
    public void setDiasSemana(java.lang.Integer[] diasSemana) {
        this.diasSemana = diasSemana;
    }

    public java.lang.Integer getDiasSemana(int i) {
        return this.diasSemana[i];
    }

    public void setDiasSemana(int i, java.lang.Integer _value) {
        this.diasSemana[i] = _value;
    }


    /**
     * Gets the duracao value for this CalendarioWizardDTO.
     * 
     * @return duracao
     */
    public double getDuracao() {
        return duracao;
    }


    /**
     * Sets the duracao value for this CalendarioWizardDTO.
     * 
     * @param duracao
     */
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this CalendarioWizardDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this CalendarioWizardDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this CalendarioWizardDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this CalendarioWizardDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the hrFinalTurno value for this CalendarioWizardDTO.
     * 
     * @return hrFinalTurno
     */
    public java.math.BigDecimal getHrFinalTurno() {
        return hrFinalTurno;
    }


    /**
     * Sets the hrFinalTurno value for this CalendarioWizardDTO.
     * 
     * @param hrFinalTurno
     */
    public void setHrFinalTurno(java.math.BigDecimal hrFinalTurno) {
        this.hrFinalTurno = hrFinalTurno;
    }


    /**
     * Gets the hrInicioTurno value for this CalendarioWizardDTO.
     * 
     * @return hrInicioTurno
     */
    public java.math.BigDecimal getHrInicioTurno() {
        return hrInicioTurno;
    }


    /**
     * Sets the hrInicioTurno value for this CalendarioWizardDTO.
     * 
     * @param hrInicioTurno
     */
    public void setHrInicioTurno(java.math.BigDecimal hrInicioTurno) {
        this.hrInicioTurno = hrInicioTurno;
    }


    /**
     * Gets the intervalo value for this CalendarioWizardDTO.
     * 
     * @return intervalo
     */
    public double getIntervalo() {
        return intervalo;
    }


    /**
     * Sets the intervalo value for this CalendarioWizardDTO.
     * 
     * @param intervalo
     */
    public void setIntervalo(double intervalo) {
        this.intervalo = intervalo;
    }


    /**
     * Gets the posTolerancia value for this CalendarioWizardDTO.
     * 
     * @return posTolerancia
     */
    public java.math.BigDecimal getPosTolerancia() {
        return posTolerancia;
    }


    /**
     * Sets the posTolerancia value for this CalendarioWizardDTO.
     * 
     * @param posTolerancia
     */
    public void setPosTolerancia(java.math.BigDecimal posTolerancia) {
        this.posTolerancia = posTolerancia;
    }


    /**
     * Gets the preTolerancia value for this CalendarioWizardDTO.
     * 
     * @return preTolerancia
     */
    public java.math.BigDecimal getPreTolerancia() {
        return preTolerancia;
    }


    /**
     * Sets the preTolerancia value for this CalendarioWizardDTO.
     * 
     * @param preTolerancia
     */
    public void setPreTolerancia(java.math.BigDecimal preTolerancia) {
        this.preTolerancia = preTolerancia;
    }


    /**
     * Gets the resultadoEvento value for this CalendarioWizardDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this CalendarioWizardDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the tpReferencia value for this CalendarioWizardDTO.
     * 
     * @return tpReferencia
     */
    public int getTpReferencia() {
        return tpReferencia;
    }


    /**
     * Sets the tpReferencia value for this CalendarioWizardDTO.
     * 
     * @param tpReferencia
     */
    public void setTpReferencia(int tpReferencia) {
        this.tpReferencia = tpReferencia;
    }


    /**
     * Gets the turno value for this CalendarioWizardDTO.
     * 
     * @return turno
     */
    public idw.idwws.DwTurno getTurno() {
        return turno;
    }


    /**
     * Sets the turno value for this CalendarioWizardDTO.
     * 
     * @param turno
     */
    public void setTurno(idw.idwws.DwTurno turno) {
        this.turno = turno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CalendarioWizardDTO)) return false;
        CalendarioWizardDTO other = (CalendarioWizardDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.diasSemana==null && other.getDiasSemana()==null) || 
             (this.diasSemana!=null &&
              java.util.Arrays.equals(this.diasSemana, other.getDiasSemana()))) &&
            this.duracao == other.getDuracao() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.hrFinalTurno==null && other.getHrFinalTurno()==null) || 
             (this.hrFinalTurno!=null &&
              this.hrFinalTurno.equals(other.getHrFinalTurno()))) &&
            ((this.hrInicioTurno==null && other.getHrInicioTurno()==null) || 
             (this.hrInicioTurno!=null &&
              this.hrInicioTurno.equals(other.getHrInicioTurno()))) &&
            this.intervalo == other.getIntervalo() &&
            ((this.posTolerancia==null && other.getPosTolerancia()==null) || 
             (this.posTolerancia!=null &&
              this.posTolerancia.equals(other.getPosTolerancia()))) &&
            ((this.preTolerancia==null && other.getPreTolerancia()==null) || 
             (this.preTolerancia!=null &&
              this.preTolerancia.equals(other.getPreTolerancia()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            this.tpReferencia == other.getTpReferencia() &&
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
        if (getDiasSemana() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDiasSemana());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDiasSemana(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getDuracao()).hashCode();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getHrFinalTurno() != null) {
            _hashCode += getHrFinalTurno().hashCode();
        }
        if (getHrInicioTurno() != null) {
            _hashCode += getHrInicioTurno().hashCode();
        }
        _hashCode += new Double(getIntervalo()).hashCode();
        if (getPosTolerancia() != null) {
            _hashCode += getPosTolerancia().hashCode();
        }
        if (getPreTolerancia() != null) {
            _hashCode += getPreTolerancia().hashCode();
        }
        _hashCode += getResultadoEvento();
        _hashCode += getTpReferencia();
        if (getTurno() != null) {
            _hashCode += getTurno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CalendarioWizardDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioWizardDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diasSemana");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diasSemana"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
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
        elemField.setFieldName("hrFinalTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrFinalTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrInicioTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrInicioTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intervalo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intervalo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posTolerancia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posTolerancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preTolerancia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preTolerancia"));
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
        elemField.setFieldName("tpReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpReferencia"));
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
