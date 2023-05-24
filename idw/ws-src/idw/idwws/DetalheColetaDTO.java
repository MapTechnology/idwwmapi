/**
 * DetalheColetaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalheColetaDTO  implements java.io.Serializable {
    private java.math.BigDecimal corrente;

    private java.lang.String dsFluxoEntrada;

    private java.lang.String dsFluxoSaida;

    private java.util.Calendar dthrColeta;

    private int fluxoEntrada;

    private int fluxoSaida;

    private int msDthrColeta;

    private java.math.BigDecimal tensao;

    public DetalheColetaDTO() {
    }

    public DetalheColetaDTO(
           java.math.BigDecimal corrente,
           java.lang.String dsFluxoEntrada,
           java.lang.String dsFluxoSaida,
           java.util.Calendar dthrColeta,
           int fluxoEntrada,
           int fluxoSaida,
           int msDthrColeta,
           java.math.BigDecimal tensao) {
           this.corrente = corrente;
           this.dsFluxoEntrada = dsFluxoEntrada;
           this.dsFluxoSaida = dsFluxoSaida;
           this.dthrColeta = dthrColeta;
           this.fluxoEntrada = fluxoEntrada;
           this.fluxoSaida = fluxoSaida;
           this.msDthrColeta = msDthrColeta;
           this.tensao = tensao;
    }


    /**
     * Gets the corrente value for this DetalheColetaDTO.
     * 
     * @return corrente
     */
    public java.math.BigDecimal getCorrente() {
        return corrente;
    }


    /**
     * Sets the corrente value for this DetalheColetaDTO.
     * 
     * @param corrente
     */
    public void setCorrente(java.math.BigDecimal corrente) {
        this.corrente = corrente;
    }


    /**
     * Gets the dsFluxoEntrada value for this DetalheColetaDTO.
     * 
     * @return dsFluxoEntrada
     */
    public java.lang.String getDsFluxoEntrada() {
        return dsFluxoEntrada;
    }


    /**
     * Sets the dsFluxoEntrada value for this DetalheColetaDTO.
     * 
     * @param dsFluxoEntrada
     */
    public void setDsFluxoEntrada(java.lang.String dsFluxoEntrada) {
        this.dsFluxoEntrada = dsFluxoEntrada;
    }


    /**
     * Gets the dsFluxoSaida value for this DetalheColetaDTO.
     * 
     * @return dsFluxoSaida
     */
    public java.lang.String getDsFluxoSaida() {
        return dsFluxoSaida;
    }


    /**
     * Sets the dsFluxoSaida value for this DetalheColetaDTO.
     * 
     * @param dsFluxoSaida
     */
    public void setDsFluxoSaida(java.lang.String dsFluxoSaida) {
        this.dsFluxoSaida = dsFluxoSaida;
    }


    /**
     * Gets the dthrColeta value for this DetalheColetaDTO.
     * 
     * @return dthrColeta
     */
    public java.util.Calendar getDthrColeta() {
        return dthrColeta;
    }


    /**
     * Sets the dthrColeta value for this DetalheColetaDTO.
     * 
     * @param dthrColeta
     */
    public void setDthrColeta(java.util.Calendar dthrColeta) {
        this.dthrColeta = dthrColeta;
    }


    /**
     * Gets the fluxoEntrada value for this DetalheColetaDTO.
     * 
     * @return fluxoEntrada
     */
    public int getFluxoEntrada() {
        return fluxoEntrada;
    }


    /**
     * Sets the fluxoEntrada value for this DetalheColetaDTO.
     * 
     * @param fluxoEntrada
     */
    public void setFluxoEntrada(int fluxoEntrada) {
        this.fluxoEntrada = fluxoEntrada;
    }


    /**
     * Gets the fluxoSaida value for this DetalheColetaDTO.
     * 
     * @return fluxoSaida
     */
    public int getFluxoSaida() {
        return fluxoSaida;
    }


    /**
     * Sets the fluxoSaida value for this DetalheColetaDTO.
     * 
     * @param fluxoSaida
     */
    public void setFluxoSaida(int fluxoSaida) {
        this.fluxoSaida = fluxoSaida;
    }


    /**
     * Gets the msDthrColeta value for this DetalheColetaDTO.
     * 
     * @return msDthrColeta
     */
    public int getMsDthrColeta() {
        return msDthrColeta;
    }


    /**
     * Sets the msDthrColeta value for this DetalheColetaDTO.
     * 
     * @param msDthrColeta
     */
    public void setMsDthrColeta(int msDthrColeta) {
        this.msDthrColeta = msDthrColeta;
    }


    /**
     * Gets the tensao value for this DetalheColetaDTO.
     * 
     * @return tensao
     */
    public java.math.BigDecimal getTensao() {
        return tensao;
    }


    /**
     * Sets the tensao value for this DetalheColetaDTO.
     * 
     * @param tensao
     */
    public void setTensao(java.math.BigDecimal tensao) {
        this.tensao = tensao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalheColetaDTO)) return false;
        DetalheColetaDTO other = (DetalheColetaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.corrente==null && other.getCorrente()==null) || 
             (this.corrente!=null &&
              this.corrente.equals(other.getCorrente()))) &&
            ((this.dsFluxoEntrada==null && other.getDsFluxoEntrada()==null) || 
             (this.dsFluxoEntrada!=null &&
              this.dsFluxoEntrada.equals(other.getDsFluxoEntrada()))) &&
            ((this.dsFluxoSaida==null && other.getDsFluxoSaida()==null) || 
             (this.dsFluxoSaida!=null &&
              this.dsFluxoSaida.equals(other.getDsFluxoSaida()))) &&
            ((this.dthrColeta==null && other.getDthrColeta()==null) || 
             (this.dthrColeta!=null &&
              this.dthrColeta.equals(other.getDthrColeta()))) &&
            this.fluxoEntrada == other.getFluxoEntrada() &&
            this.fluxoSaida == other.getFluxoSaida() &&
            this.msDthrColeta == other.getMsDthrColeta() &&
            ((this.tensao==null && other.getTensao()==null) || 
             (this.tensao!=null &&
              this.tensao.equals(other.getTensao())));
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
        if (getCorrente() != null) {
            _hashCode += getCorrente().hashCode();
        }
        if (getDsFluxoEntrada() != null) {
            _hashCode += getDsFluxoEntrada().hashCode();
        }
        if (getDsFluxoSaida() != null) {
            _hashCode += getDsFluxoSaida().hashCode();
        }
        if (getDthrColeta() != null) {
            _hashCode += getDthrColeta().hashCode();
        }
        _hashCode += getFluxoEntrada();
        _hashCode += getFluxoSaida();
        _hashCode += getMsDthrColeta();
        if (getTensao() != null) {
            _hashCode += getTensao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalheColetaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheColetaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsFluxoEntrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsFluxoEntrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsFluxoSaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsFluxoSaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrColeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrColeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fluxoEntrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fluxoEntrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fluxoSaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fluxoSaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrColeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrColeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tensao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
