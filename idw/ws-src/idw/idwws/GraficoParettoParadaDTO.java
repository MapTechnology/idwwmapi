/**
 * GraficoParettoParadaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoParettoParadaDTO  implements java.io.Serializable {
    private java.lang.String cdParada;

    private java.lang.String corBarra;

    private java.lang.String dsParada;

    private java.lang.Long idTParada;

    private java.lang.Double indiceParada;

    private java.lang.String tempoFormatado;

    public GraficoParettoParadaDTO() {
    }

    public GraficoParettoParadaDTO(
           java.lang.String cdParada,
           java.lang.String corBarra,
           java.lang.String dsParada,
           java.lang.Long idTParada,
           java.lang.Double indiceParada,
           java.lang.String tempoFormatado) {
           this.cdParada = cdParada;
           this.corBarra = corBarra;
           this.dsParada = dsParada;
           this.idTParada = idTParada;
           this.indiceParada = indiceParada;
           this.tempoFormatado = tempoFormatado;
    }


    /**
     * Gets the cdParada value for this GraficoParettoParadaDTO.
     * 
     * @return cdParada
     */
    public java.lang.String getCdParada() {
        return cdParada;
    }


    /**
     * Sets the cdParada value for this GraficoParettoParadaDTO.
     * 
     * @param cdParada
     */
    public void setCdParada(java.lang.String cdParada) {
        this.cdParada = cdParada;
    }


    /**
     * Gets the corBarra value for this GraficoParettoParadaDTO.
     * 
     * @return corBarra
     */
    public java.lang.String getCorBarra() {
        return corBarra;
    }


    /**
     * Sets the corBarra value for this GraficoParettoParadaDTO.
     * 
     * @param corBarra
     */
    public void setCorBarra(java.lang.String corBarra) {
        this.corBarra = corBarra;
    }


    /**
     * Gets the dsParada value for this GraficoParettoParadaDTO.
     * 
     * @return dsParada
     */
    public java.lang.String getDsParada() {
        return dsParada;
    }


    /**
     * Sets the dsParada value for this GraficoParettoParadaDTO.
     * 
     * @param dsParada
     */
    public void setDsParada(java.lang.String dsParada) {
        this.dsParada = dsParada;
    }


    /**
     * Gets the idTParada value for this GraficoParettoParadaDTO.
     * 
     * @return idTParada
     */
    public java.lang.Long getIdTParada() {
        return idTParada;
    }


    /**
     * Sets the idTParada value for this GraficoParettoParadaDTO.
     * 
     * @param idTParada
     */
    public void setIdTParada(java.lang.Long idTParada) {
        this.idTParada = idTParada;
    }


    /**
     * Gets the indiceParada value for this GraficoParettoParadaDTO.
     * 
     * @return indiceParada
     */
    public java.lang.Double getIndiceParada() {
        return indiceParada;
    }


    /**
     * Sets the indiceParada value for this GraficoParettoParadaDTO.
     * 
     * @param indiceParada
     */
    public void setIndiceParada(java.lang.Double indiceParada) {
        this.indiceParada = indiceParada;
    }


    /**
     * Gets the tempoFormatado value for this GraficoParettoParadaDTO.
     * 
     * @return tempoFormatado
     */
    public java.lang.String getTempoFormatado() {
        return tempoFormatado;
    }


    /**
     * Sets the tempoFormatado value for this GraficoParettoParadaDTO.
     * 
     * @param tempoFormatado
     */
    public void setTempoFormatado(java.lang.String tempoFormatado) {
        this.tempoFormatado = tempoFormatado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoParettoParadaDTO)) return false;
        GraficoParettoParadaDTO other = (GraficoParettoParadaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdParada==null && other.getCdParada()==null) || 
             (this.cdParada!=null &&
              this.cdParada.equals(other.getCdParada()))) &&
            ((this.corBarra==null && other.getCorBarra()==null) || 
             (this.corBarra!=null &&
              this.corBarra.equals(other.getCorBarra()))) &&
            ((this.dsParada==null && other.getDsParada()==null) || 
             (this.dsParada!=null &&
              this.dsParada.equals(other.getDsParada()))) &&
            ((this.idTParada==null && other.getIdTParada()==null) || 
             (this.idTParada!=null &&
              this.idTParada.equals(other.getIdTParada()))) &&
            ((this.indiceParada==null && other.getIndiceParada()==null) || 
             (this.indiceParada!=null &&
              this.indiceParada.equals(other.getIndiceParada()))) &&
            ((this.tempoFormatado==null && other.getTempoFormatado()==null) || 
             (this.tempoFormatado!=null &&
              this.tempoFormatado.equals(other.getTempoFormatado())));
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
        if (getCdParada() != null) {
            _hashCode += getCdParada().hashCode();
        }
        if (getCorBarra() != null) {
            _hashCode += getCorBarra().hashCode();
        }
        if (getDsParada() != null) {
            _hashCode += getDsParada().hashCode();
        }
        if (getIdTParada() != null) {
            _hashCode += getIdTParada().hashCode();
        }
        if (getIndiceParada() != null) {
            _hashCode += getIndiceParada().hashCode();
        }
        if (getTempoFormatado() != null) {
            _hashCode += getTempoFormatado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GraficoParettoParadaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoParettoParadaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corBarra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corBarra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoFormatado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoFormatado"));
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
