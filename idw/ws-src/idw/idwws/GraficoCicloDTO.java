/**
 * GraficoCicloDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoCicloDTO  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private java.lang.Double eficRealizacao;

    private java.lang.Double eficVel;

    private java.lang.Double indAcurAtivas;

    private java.lang.Double indParadas;

    private java.lang.Double indPerdas;

    private java.lang.Double indRefugos;

    private java.lang.Double produtividadeOEE;

    public GraficoCicloDTO() {
    }

    public GraficoCicloDTO(
           java.util.Calendar dtReferencia,
           java.lang.Double eficRealizacao,
           java.lang.Double eficVel,
           java.lang.Double indAcurAtivas,
           java.lang.Double indParadas,
           java.lang.Double indPerdas,
           java.lang.Double indRefugos,
           java.lang.Double produtividadeOEE) {
           this.dtReferencia = dtReferencia;
           this.eficRealizacao = eficRealizacao;
           this.eficVel = eficVel;
           this.indAcurAtivas = indAcurAtivas;
           this.indParadas = indParadas;
           this.indPerdas = indPerdas;
           this.indRefugos = indRefugos;
           this.produtividadeOEE = produtividadeOEE;
    }


    /**
     * Gets the dtReferencia value for this GraficoCicloDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this GraficoCicloDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the eficRealizacao value for this GraficoCicloDTO.
     * 
     * @return eficRealizacao
     */
    public java.lang.Double getEficRealizacao() {
        return eficRealizacao;
    }


    /**
     * Sets the eficRealizacao value for this GraficoCicloDTO.
     * 
     * @param eficRealizacao
     */
    public void setEficRealizacao(java.lang.Double eficRealizacao) {
        this.eficRealizacao = eficRealizacao;
    }


    /**
     * Gets the eficVel value for this GraficoCicloDTO.
     * 
     * @return eficVel
     */
    public java.lang.Double getEficVel() {
        return eficVel;
    }


    /**
     * Sets the eficVel value for this GraficoCicloDTO.
     * 
     * @param eficVel
     */
    public void setEficVel(java.lang.Double eficVel) {
        this.eficVel = eficVel;
    }


    /**
     * Gets the indAcurAtivas value for this GraficoCicloDTO.
     * 
     * @return indAcurAtivas
     */
    public java.lang.Double getIndAcurAtivas() {
        return indAcurAtivas;
    }


    /**
     * Sets the indAcurAtivas value for this GraficoCicloDTO.
     * 
     * @param indAcurAtivas
     */
    public void setIndAcurAtivas(java.lang.Double indAcurAtivas) {
        this.indAcurAtivas = indAcurAtivas;
    }


    /**
     * Gets the indParadas value for this GraficoCicloDTO.
     * 
     * @return indParadas
     */
    public java.lang.Double getIndParadas() {
        return indParadas;
    }


    /**
     * Sets the indParadas value for this GraficoCicloDTO.
     * 
     * @param indParadas
     */
    public void setIndParadas(java.lang.Double indParadas) {
        this.indParadas = indParadas;
    }


    /**
     * Gets the indPerdas value for this GraficoCicloDTO.
     * 
     * @return indPerdas
     */
    public java.lang.Double getIndPerdas() {
        return indPerdas;
    }


    /**
     * Sets the indPerdas value for this GraficoCicloDTO.
     * 
     * @param indPerdas
     */
    public void setIndPerdas(java.lang.Double indPerdas) {
        this.indPerdas = indPerdas;
    }


    /**
     * Gets the indRefugos value for this GraficoCicloDTO.
     * 
     * @return indRefugos
     */
    public java.lang.Double getIndRefugos() {
        return indRefugos;
    }


    /**
     * Sets the indRefugos value for this GraficoCicloDTO.
     * 
     * @param indRefugos
     */
    public void setIndRefugos(java.lang.Double indRefugos) {
        this.indRefugos = indRefugos;
    }


    /**
     * Gets the produtividadeOEE value for this GraficoCicloDTO.
     * 
     * @return produtividadeOEE
     */
    public java.lang.Double getProdutividadeOEE() {
        return produtividadeOEE;
    }


    /**
     * Sets the produtividadeOEE value for this GraficoCicloDTO.
     * 
     * @param produtividadeOEE
     */
    public void setProdutividadeOEE(java.lang.Double produtividadeOEE) {
        this.produtividadeOEE = produtividadeOEE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoCicloDTO)) return false;
        GraficoCicloDTO other = (GraficoCicloDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.eficRealizacao==null && other.getEficRealizacao()==null) || 
             (this.eficRealizacao!=null &&
              this.eficRealizacao.equals(other.getEficRealizacao()))) &&
            ((this.eficVel==null && other.getEficVel()==null) || 
             (this.eficVel!=null &&
              this.eficVel.equals(other.getEficVel()))) &&
            ((this.indAcurAtivas==null && other.getIndAcurAtivas()==null) || 
             (this.indAcurAtivas!=null &&
              this.indAcurAtivas.equals(other.getIndAcurAtivas()))) &&
            ((this.indParadas==null && other.getIndParadas()==null) || 
             (this.indParadas!=null &&
              this.indParadas.equals(other.getIndParadas()))) &&
            ((this.indPerdas==null && other.getIndPerdas()==null) || 
             (this.indPerdas!=null &&
              this.indPerdas.equals(other.getIndPerdas()))) &&
            ((this.indRefugos==null && other.getIndRefugos()==null) || 
             (this.indRefugos!=null &&
              this.indRefugos.equals(other.getIndRefugos()))) &&
            ((this.produtividadeOEE==null && other.getProdutividadeOEE()==null) || 
             (this.produtividadeOEE!=null &&
              this.produtividadeOEE.equals(other.getProdutividadeOEE())));
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
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getEficRealizacao() != null) {
            _hashCode += getEficRealizacao().hashCode();
        }
        if (getEficVel() != null) {
            _hashCode += getEficVel().hashCode();
        }
        if (getIndAcurAtivas() != null) {
            _hashCode += getIndAcurAtivas().hashCode();
        }
        if (getIndParadas() != null) {
            _hashCode += getIndParadas().hashCode();
        }
        if (getIndPerdas() != null) {
            _hashCode += getIndPerdas().hashCode();
        }
        if (getIndRefugos() != null) {
            _hashCode += getIndRefugos().hashCode();
        }
        if (getProdutividadeOEE() != null) {
            _hashCode += getProdutividadeOEE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GraficoCicloDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoCicloDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficRealizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficRealizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficVel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficVel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indAcurAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indAcurAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indPerdas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indPerdas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indRefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indRefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produtividadeOEE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtividadeOEE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
