/**
 * AndonDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class AndonDTO  implements java.io.Serializable {
    private idw.idwws.Timer agendador;

    private java.util.Calendar dtHrInicio;

    private double ideventoandon;

    private int idrele;

    private java.lang.String idreleaux;

    private java.lang.String idup;

    private java.lang.Double indicador;

    private java.lang.Double indicadorHora;

    private java.lang.Double indicadorTurno;

    private int prioridade;

    private int stativo;

    private int stintermitente;

    private boolean timerIniciado;

    private int tmpsinalalto;

    private int tmpsinalbaixo;

    private int tpeventoandon;

    public AndonDTO() {
    }

    public AndonDTO(
           idw.idwws.Timer agendador,
           java.util.Calendar dtHrInicio,
           double ideventoandon,
           int idrele,
           java.lang.String idreleaux,
           java.lang.String idup,
           java.lang.Double indicador,
           java.lang.Double indicadorHora,
           java.lang.Double indicadorTurno,
           int prioridade,
           int stativo,
           int stintermitente,
           boolean timerIniciado,
           int tmpsinalalto,
           int tmpsinalbaixo,
           int tpeventoandon) {
           this.agendador = agendador;
           this.dtHrInicio = dtHrInicio;
           this.ideventoandon = ideventoandon;
           this.idrele = idrele;
           this.idreleaux = idreleaux;
           this.idup = idup;
           this.indicador = indicador;
           this.indicadorHora = indicadorHora;
           this.indicadorTurno = indicadorTurno;
           this.prioridade = prioridade;
           this.stativo = stativo;
           this.stintermitente = stintermitente;
           this.timerIniciado = timerIniciado;
           this.tmpsinalalto = tmpsinalalto;
           this.tmpsinalbaixo = tmpsinalbaixo;
           this.tpeventoandon = tpeventoandon;
    }


    /**
     * Gets the agendador value for this AndonDTO.
     * 
     * @return agendador
     */
    public idw.idwws.Timer getAgendador() {
        return agendador;
    }


    /**
     * Sets the agendador value for this AndonDTO.
     * 
     * @param agendador
     */
    public void setAgendador(idw.idwws.Timer agendador) {
        this.agendador = agendador;
    }


    /**
     * Gets the dtHrInicio value for this AndonDTO.
     * 
     * @return dtHrInicio
     */
    public java.util.Calendar getDtHrInicio() {
        return dtHrInicio;
    }


    /**
     * Sets the dtHrInicio value for this AndonDTO.
     * 
     * @param dtHrInicio
     */
    public void setDtHrInicio(java.util.Calendar dtHrInicio) {
        this.dtHrInicio = dtHrInicio;
    }


    /**
     * Gets the ideventoandon value for this AndonDTO.
     * 
     * @return ideventoandon
     */
    public double getIdeventoandon() {
        return ideventoandon;
    }


    /**
     * Sets the ideventoandon value for this AndonDTO.
     * 
     * @param ideventoandon
     */
    public void setIdeventoandon(double ideventoandon) {
        this.ideventoandon = ideventoandon;
    }


    /**
     * Gets the idrele value for this AndonDTO.
     * 
     * @return idrele
     */
    public int getIdrele() {
        return idrele;
    }


    /**
     * Sets the idrele value for this AndonDTO.
     * 
     * @param idrele
     */
    public void setIdrele(int idrele) {
        this.idrele = idrele;
    }


    /**
     * Gets the idreleaux value for this AndonDTO.
     * 
     * @return idreleaux
     */
    public java.lang.String getIdreleaux() {
        return idreleaux;
    }


    /**
     * Sets the idreleaux value for this AndonDTO.
     * 
     * @param idreleaux
     */
    public void setIdreleaux(java.lang.String idreleaux) {
        this.idreleaux = idreleaux;
    }


    /**
     * Gets the idup value for this AndonDTO.
     * 
     * @return idup
     */
    public java.lang.String getIdup() {
        return idup;
    }


    /**
     * Sets the idup value for this AndonDTO.
     * 
     * @param idup
     */
    public void setIdup(java.lang.String idup) {
        this.idup = idup;
    }


    /**
     * Gets the indicador value for this AndonDTO.
     * 
     * @return indicador
     */
    public java.lang.Double getIndicador() {
        return indicador;
    }


    /**
     * Sets the indicador value for this AndonDTO.
     * 
     * @param indicador
     */
    public void setIndicador(java.lang.Double indicador) {
        this.indicador = indicador;
    }


    /**
     * Gets the indicadorHora value for this AndonDTO.
     * 
     * @return indicadorHora
     */
    public java.lang.Double getIndicadorHora() {
        return indicadorHora;
    }


    /**
     * Sets the indicadorHora value for this AndonDTO.
     * 
     * @param indicadorHora
     */
    public void setIndicadorHora(java.lang.Double indicadorHora) {
        this.indicadorHora = indicadorHora;
    }


    /**
     * Gets the indicadorTurno value for this AndonDTO.
     * 
     * @return indicadorTurno
     */
    public java.lang.Double getIndicadorTurno() {
        return indicadorTurno;
    }


    /**
     * Sets the indicadorTurno value for this AndonDTO.
     * 
     * @param indicadorTurno
     */
    public void setIndicadorTurno(java.lang.Double indicadorTurno) {
        this.indicadorTurno = indicadorTurno;
    }


    /**
     * Gets the prioridade value for this AndonDTO.
     * 
     * @return prioridade
     */
    public int getPrioridade() {
        return prioridade;
    }


    /**
     * Sets the prioridade value for this AndonDTO.
     * 
     * @param prioridade
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }


    /**
     * Gets the stativo value for this AndonDTO.
     * 
     * @return stativo
     */
    public int getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this AndonDTO.
     * 
     * @param stativo
     */
    public void setStativo(int stativo) {
        this.stativo = stativo;
    }


    /**
     * Gets the stintermitente value for this AndonDTO.
     * 
     * @return stintermitente
     */
    public int getStintermitente() {
        return stintermitente;
    }


    /**
     * Sets the stintermitente value for this AndonDTO.
     * 
     * @param stintermitente
     */
    public void setStintermitente(int stintermitente) {
        this.stintermitente = stintermitente;
    }


    /**
     * Gets the timerIniciado value for this AndonDTO.
     * 
     * @return timerIniciado
     */
    public boolean isTimerIniciado() {
        return timerIniciado;
    }


    /**
     * Sets the timerIniciado value for this AndonDTO.
     * 
     * @param timerIniciado
     */
    public void setTimerIniciado(boolean timerIniciado) {
        this.timerIniciado = timerIniciado;
    }


    /**
     * Gets the tmpsinalalto value for this AndonDTO.
     * 
     * @return tmpsinalalto
     */
    public int getTmpsinalalto() {
        return tmpsinalalto;
    }


    /**
     * Sets the tmpsinalalto value for this AndonDTO.
     * 
     * @param tmpsinalalto
     */
    public void setTmpsinalalto(int tmpsinalalto) {
        this.tmpsinalalto = tmpsinalalto;
    }


    /**
     * Gets the tmpsinalbaixo value for this AndonDTO.
     * 
     * @return tmpsinalbaixo
     */
    public int getTmpsinalbaixo() {
        return tmpsinalbaixo;
    }


    /**
     * Sets the tmpsinalbaixo value for this AndonDTO.
     * 
     * @param tmpsinalbaixo
     */
    public void setTmpsinalbaixo(int tmpsinalbaixo) {
        this.tmpsinalbaixo = tmpsinalbaixo;
    }


    /**
     * Gets the tpeventoandon value for this AndonDTO.
     * 
     * @return tpeventoandon
     */
    public int getTpeventoandon() {
        return tpeventoandon;
    }


    /**
     * Sets the tpeventoandon value for this AndonDTO.
     * 
     * @param tpeventoandon
     */
    public void setTpeventoandon(int tpeventoandon) {
        this.tpeventoandon = tpeventoandon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AndonDTO)) return false;
        AndonDTO other = (AndonDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agendador==null && other.getAgendador()==null) || 
             (this.agendador!=null &&
              this.agendador.equals(other.getAgendador()))) &&
            ((this.dtHrInicio==null && other.getDtHrInicio()==null) || 
             (this.dtHrInicio!=null &&
              this.dtHrInicio.equals(other.getDtHrInicio()))) &&
            this.ideventoandon == other.getIdeventoandon() &&
            this.idrele == other.getIdrele() &&
            ((this.idreleaux==null && other.getIdreleaux()==null) || 
             (this.idreleaux!=null &&
              this.idreleaux.equals(other.getIdreleaux()))) &&
            ((this.idup==null && other.getIdup()==null) || 
             (this.idup!=null &&
              this.idup.equals(other.getIdup()))) &&
            ((this.indicador==null && other.getIndicador()==null) || 
             (this.indicador!=null &&
              this.indicador.equals(other.getIndicador()))) &&
            ((this.indicadorHora==null && other.getIndicadorHora()==null) || 
             (this.indicadorHora!=null &&
              this.indicadorHora.equals(other.getIndicadorHora()))) &&
            ((this.indicadorTurno==null && other.getIndicadorTurno()==null) || 
             (this.indicadorTurno!=null &&
              this.indicadorTurno.equals(other.getIndicadorTurno()))) &&
            this.prioridade == other.getPrioridade() &&
            this.stativo == other.getStativo() &&
            this.stintermitente == other.getStintermitente() &&
            this.timerIniciado == other.isTimerIniciado() &&
            this.tmpsinalalto == other.getTmpsinalalto() &&
            this.tmpsinalbaixo == other.getTmpsinalbaixo() &&
            this.tpeventoandon == other.getTpeventoandon();
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
        if (getAgendador() != null) {
            _hashCode += getAgendador().hashCode();
        }
        if (getDtHrInicio() != null) {
            _hashCode += getDtHrInicio().hashCode();
        }
        _hashCode += new Double(getIdeventoandon()).hashCode();
        _hashCode += getIdrele();
        if (getIdreleaux() != null) {
            _hashCode += getIdreleaux().hashCode();
        }
        if (getIdup() != null) {
            _hashCode += getIdup().hashCode();
        }
        if (getIndicador() != null) {
            _hashCode += getIndicador().hashCode();
        }
        if (getIndicadorHora() != null) {
            _hashCode += getIndicadorHora().hashCode();
        }
        if (getIndicadorTurno() != null) {
            _hashCode += getIndicadorTurno().hashCode();
        }
        _hashCode += getPrioridade();
        _hashCode += getStativo();
        _hashCode += getStintermitente();
        _hashCode += (isTimerIniciado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getTmpsinalalto();
        _hashCode += getTmpsinalbaixo();
        _hashCode += getTpeventoandon();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AndonDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "andonDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agendador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agendador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "timer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ideventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ideventoandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idrele");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idrele"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idreleaux");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idreleaux"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadorHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadorHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadorTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicadorTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prioridade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stintermitente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stintermitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timerIniciado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timerIniciado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpsinalalto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpsinalalto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpsinalbaixo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpsinalbaixo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpeventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpeventoandon"));
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
