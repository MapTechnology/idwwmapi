/**
 * DetalheParadaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalheParadaDTO  implements java.io.Serializable {
    private java.lang.String acao;

    private idw.idwws.DwTArea area_resp;

    private java.lang.String causa;

    private java.lang.String duracao;

    private java.lang.String ferramenta;

    private java.util.Calendar fim;

    private java.util.Calendar inicio;

    private java.lang.String justificativa;

    private java.lang.String maquina;

    private java.lang.String parada;

    private double perdas_paradas;

    private java.lang.String tecnico1;

    private java.lang.String tecnico2;

    private java.lang.String tecnico_responsavel;

    public DetalheParadaDTO() {
    }

    public DetalheParadaDTO(
           java.lang.String acao,
           idw.idwws.DwTArea area_resp,
           java.lang.String causa,
           java.lang.String duracao,
           java.lang.String ferramenta,
           java.util.Calendar fim,
           java.util.Calendar inicio,
           java.lang.String justificativa,
           java.lang.String maquina,
           java.lang.String parada,
           double perdas_paradas,
           java.lang.String tecnico1,
           java.lang.String tecnico2,
           java.lang.String tecnico_responsavel) {
           this.acao = acao;
           this.area_resp = area_resp;
           this.causa = causa;
           this.duracao = duracao;
           this.ferramenta = ferramenta;
           this.fim = fim;
           this.inicio = inicio;
           this.justificativa = justificativa;
           this.maquina = maquina;
           this.parada = parada;
           this.perdas_paradas = perdas_paradas;
           this.tecnico1 = tecnico1;
           this.tecnico2 = tecnico2;
           this.tecnico_responsavel = tecnico_responsavel;
    }


    /**
     * Gets the acao value for this DetalheParadaDTO.
     * 
     * @return acao
     */
    public java.lang.String getAcao() {
        return acao;
    }


    /**
     * Sets the acao value for this DetalheParadaDTO.
     * 
     * @param acao
     */
    public void setAcao(java.lang.String acao) {
        this.acao = acao;
    }


    /**
     * Gets the area_resp value for this DetalheParadaDTO.
     * 
     * @return area_resp
     */
    public idw.idwws.DwTArea getArea_resp() {
        return area_resp;
    }


    /**
     * Sets the area_resp value for this DetalheParadaDTO.
     * 
     * @param area_resp
     */
    public void setArea_resp(idw.idwws.DwTArea area_resp) {
        this.area_resp = area_resp;
    }


    /**
     * Gets the causa value for this DetalheParadaDTO.
     * 
     * @return causa
     */
    public java.lang.String getCausa() {
        return causa;
    }


    /**
     * Sets the causa value for this DetalheParadaDTO.
     * 
     * @param causa
     */
    public void setCausa(java.lang.String causa) {
        this.causa = causa;
    }


    /**
     * Gets the duracao value for this DetalheParadaDTO.
     * 
     * @return duracao
     */
    public java.lang.String getDuracao() {
        return duracao;
    }


    /**
     * Sets the duracao value for this DetalheParadaDTO.
     * 
     * @param duracao
     */
    public void setDuracao(java.lang.String duracao) {
        this.duracao = duracao;
    }


    /**
     * Gets the ferramenta value for this DetalheParadaDTO.
     * 
     * @return ferramenta
     */
    public java.lang.String getFerramenta() {
        return ferramenta;
    }


    /**
     * Sets the ferramenta value for this DetalheParadaDTO.
     * 
     * @param ferramenta
     */
    public void setFerramenta(java.lang.String ferramenta) {
        this.ferramenta = ferramenta;
    }


    /**
     * Gets the fim value for this DetalheParadaDTO.
     * 
     * @return fim
     */
    public java.util.Calendar getFim() {
        return fim;
    }


    /**
     * Sets the fim value for this DetalheParadaDTO.
     * 
     * @param fim
     */
    public void setFim(java.util.Calendar fim) {
        this.fim = fim;
    }


    /**
     * Gets the inicio value for this DetalheParadaDTO.
     * 
     * @return inicio
     */
    public java.util.Calendar getInicio() {
        return inicio;
    }


    /**
     * Sets the inicio value for this DetalheParadaDTO.
     * 
     * @param inicio
     */
    public void setInicio(java.util.Calendar inicio) {
        this.inicio = inicio;
    }


    /**
     * Gets the justificativa value for this DetalheParadaDTO.
     * 
     * @return justificativa
     */
    public java.lang.String getJustificativa() {
        return justificativa;
    }


    /**
     * Sets the justificativa value for this DetalheParadaDTO.
     * 
     * @param justificativa
     */
    public void setJustificativa(java.lang.String justificativa) {
        this.justificativa = justificativa;
    }


    /**
     * Gets the maquina value for this DetalheParadaDTO.
     * 
     * @return maquina
     */
    public java.lang.String getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this DetalheParadaDTO.
     * 
     * @param maquina
     */
    public void setMaquina(java.lang.String maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the parada value for this DetalheParadaDTO.
     * 
     * @return parada
     */
    public java.lang.String getParada() {
        return parada;
    }


    /**
     * Sets the parada value for this DetalheParadaDTO.
     * 
     * @param parada
     */
    public void setParada(java.lang.String parada) {
        this.parada = parada;
    }


    /**
     * Gets the perdas_paradas value for this DetalheParadaDTO.
     * 
     * @return perdas_paradas
     */
    public double getPerdas_paradas() {
        return perdas_paradas;
    }


    /**
     * Sets the perdas_paradas value for this DetalheParadaDTO.
     * 
     * @param perdas_paradas
     */
    public void setPerdas_paradas(double perdas_paradas) {
        this.perdas_paradas = perdas_paradas;
    }


    /**
     * Gets the tecnico1 value for this DetalheParadaDTO.
     * 
     * @return tecnico1
     */
    public java.lang.String getTecnico1() {
        return tecnico1;
    }


    /**
     * Sets the tecnico1 value for this DetalheParadaDTO.
     * 
     * @param tecnico1
     */
    public void setTecnico1(java.lang.String tecnico1) {
        this.tecnico1 = tecnico1;
    }


    /**
     * Gets the tecnico2 value for this DetalheParadaDTO.
     * 
     * @return tecnico2
     */
    public java.lang.String getTecnico2() {
        return tecnico2;
    }


    /**
     * Sets the tecnico2 value for this DetalheParadaDTO.
     * 
     * @param tecnico2
     */
    public void setTecnico2(java.lang.String tecnico2) {
        this.tecnico2 = tecnico2;
    }


    /**
     * Gets the tecnico_responsavel value for this DetalheParadaDTO.
     * 
     * @return tecnico_responsavel
     */
    public java.lang.String getTecnico_responsavel() {
        return tecnico_responsavel;
    }


    /**
     * Sets the tecnico_responsavel value for this DetalheParadaDTO.
     * 
     * @param tecnico_responsavel
     */
    public void setTecnico_responsavel(java.lang.String tecnico_responsavel) {
        this.tecnico_responsavel = tecnico_responsavel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalheParadaDTO)) return false;
        DetalheParadaDTO other = (DetalheParadaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acao==null && other.getAcao()==null) || 
             (this.acao!=null &&
              this.acao.equals(other.getAcao()))) &&
            ((this.area_resp==null && other.getArea_resp()==null) || 
             (this.area_resp!=null &&
              this.area_resp.equals(other.getArea_resp()))) &&
            ((this.causa==null && other.getCausa()==null) || 
             (this.causa!=null &&
              this.causa.equals(other.getCausa()))) &&
            ((this.duracao==null && other.getDuracao()==null) || 
             (this.duracao!=null &&
              this.duracao.equals(other.getDuracao()))) &&
            ((this.ferramenta==null && other.getFerramenta()==null) || 
             (this.ferramenta!=null &&
              this.ferramenta.equals(other.getFerramenta()))) &&
            ((this.fim==null && other.getFim()==null) || 
             (this.fim!=null &&
              this.fim.equals(other.getFim()))) &&
            ((this.inicio==null && other.getInicio()==null) || 
             (this.inicio!=null &&
              this.inicio.equals(other.getInicio()))) &&
            ((this.justificativa==null && other.getJustificativa()==null) || 
             (this.justificativa!=null &&
              this.justificativa.equals(other.getJustificativa()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            ((this.parada==null && other.getParada()==null) || 
             (this.parada!=null &&
              this.parada.equals(other.getParada()))) &&
            this.perdas_paradas == other.getPerdas_paradas() &&
            ((this.tecnico1==null && other.getTecnico1()==null) || 
             (this.tecnico1!=null &&
              this.tecnico1.equals(other.getTecnico1()))) &&
            ((this.tecnico2==null && other.getTecnico2()==null) || 
             (this.tecnico2!=null &&
              this.tecnico2.equals(other.getTecnico2()))) &&
            ((this.tecnico_responsavel==null && other.getTecnico_responsavel()==null) || 
             (this.tecnico_responsavel!=null &&
              this.tecnico_responsavel.equals(other.getTecnico_responsavel())));
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
        if (getAcao() != null) {
            _hashCode += getAcao().hashCode();
        }
        if (getArea_resp() != null) {
            _hashCode += getArea_resp().hashCode();
        }
        if (getCausa() != null) {
            _hashCode += getCausa().hashCode();
        }
        if (getDuracao() != null) {
            _hashCode += getDuracao().hashCode();
        }
        if (getFerramenta() != null) {
            _hashCode += getFerramenta().hashCode();
        }
        if (getFim() != null) {
            _hashCode += getFim().hashCode();
        }
        if (getInicio() != null) {
            _hashCode += getInicio().hashCode();
        }
        if (getJustificativa() != null) {
            _hashCode += getJustificativa().hashCode();
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        if (getParada() != null) {
            _hashCode += getParada().hashCode();
        }
        _hashCode += new Double(getPerdas_paradas()).hashCode();
        if (getTecnico1() != null) {
            _hashCode += getTecnico1().hashCode();
        }
        if (getTecnico2() != null) {
            _hashCode += getTecnico2().hashCode();
        }
        if (getTecnico_responsavel() != null) {
            _hashCode += getTecnico_responsavel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalheParadaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheParadaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area_resp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "area_resp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTArea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("causa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "causa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ferramenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ferramenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justificativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "justificativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdas_paradas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdas_paradas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tecnico1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tecnico1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tecnico2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tecnico2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tecnico_responsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tecnico_responsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
