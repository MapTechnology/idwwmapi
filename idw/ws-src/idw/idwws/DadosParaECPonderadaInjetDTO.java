/**
 * DadosParaECPonderadaInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DadosParaECPonderadaInjetDTO  implements java.io.Serializable {
    private java.lang.String cdEstrutra;

    private java.lang.String cdMaquina;

    private java.lang.String cdMolde;

    private java.math.BigDecimal cicloPadrao;

    private java.lang.Integer qtCicloPadrao;

    private java.math.BigDecimal qtInjNormal;

    private java.math.BigDecimal tempoAtivo;

    private java.math.BigDecimal tmpCicNormal;

    public DadosParaECPonderadaInjetDTO() {
    }

    public DadosParaECPonderadaInjetDTO(
           java.lang.String cdEstrutra,
           java.lang.String cdMaquina,
           java.lang.String cdMolde,
           java.math.BigDecimal cicloPadrao,
           java.lang.Integer qtCicloPadrao,
           java.math.BigDecimal qtInjNormal,
           java.math.BigDecimal tempoAtivo,
           java.math.BigDecimal tmpCicNormal) {
           this.cdEstrutra = cdEstrutra;
           this.cdMaquina = cdMaquina;
           this.cdMolde = cdMolde;
           this.cicloPadrao = cicloPadrao;
           this.qtCicloPadrao = qtCicloPadrao;
           this.qtInjNormal = qtInjNormal;
           this.tempoAtivo = tempoAtivo;
           this.tmpCicNormal = tmpCicNormal;
    }


    /**
     * Gets the cdEstrutra value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return cdEstrutra
     */
    public java.lang.String getCdEstrutra() {
        return cdEstrutra;
    }


    /**
     * Sets the cdEstrutra value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param cdEstrutra
     */
    public void setCdEstrutra(java.lang.String cdEstrutra) {
        this.cdEstrutra = cdEstrutra;
    }


    /**
     * Gets the cdMaquina value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return cdMaquina
     */
    public java.lang.String getCdMaquina() {
        return cdMaquina;
    }


    /**
     * Sets the cdMaquina value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param cdMaquina
     */
    public void setCdMaquina(java.lang.String cdMaquina) {
        this.cdMaquina = cdMaquina;
    }


    /**
     * Gets the cdMolde value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return cdMolde
     */
    public java.lang.String getCdMolde() {
        return cdMolde;
    }


    /**
     * Sets the cdMolde value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param cdMolde
     */
    public void setCdMolde(java.lang.String cdMolde) {
        this.cdMolde = cdMolde;
    }


    /**
     * Gets the cicloPadrao value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return cicloPadrao
     */
    public java.math.BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.math.BigDecimal cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the qtCicloPadrao value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return qtCicloPadrao
     */
    public java.lang.Integer getQtCicloPadrao() {
        return qtCicloPadrao;
    }


    /**
     * Sets the qtCicloPadrao value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param qtCicloPadrao
     */
    public void setQtCicloPadrao(java.lang.Integer qtCicloPadrao) {
        this.qtCicloPadrao = qtCicloPadrao;
    }


    /**
     * Gets the qtInjNormal value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return qtInjNormal
     */
    public java.math.BigDecimal getQtInjNormal() {
        return qtInjNormal;
    }


    /**
     * Sets the qtInjNormal value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param qtInjNormal
     */
    public void setQtInjNormal(java.math.BigDecimal qtInjNormal) {
        this.qtInjNormal = qtInjNormal;
    }


    /**
     * Gets the tempoAtivo value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return tempoAtivo
     */
    public java.math.BigDecimal getTempoAtivo() {
        return tempoAtivo;
    }


    /**
     * Sets the tempoAtivo value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param tempoAtivo
     */
    public void setTempoAtivo(java.math.BigDecimal tempoAtivo) {
        this.tempoAtivo = tempoAtivo;
    }


    /**
     * Gets the tmpCicNormal value for this DadosParaECPonderadaInjetDTO.
     * 
     * @return tmpCicNormal
     */
    public java.math.BigDecimal getTmpCicNormal() {
        return tmpCicNormal;
    }


    /**
     * Sets the tmpCicNormal value for this DadosParaECPonderadaInjetDTO.
     * 
     * @param tmpCicNormal
     */
    public void setTmpCicNormal(java.math.BigDecimal tmpCicNormal) {
        this.tmpCicNormal = tmpCicNormal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosParaECPonderadaInjetDTO)) return false;
        DadosParaECPonderadaInjetDTO other = (DadosParaECPonderadaInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdEstrutra==null && other.getCdEstrutra()==null) || 
             (this.cdEstrutra!=null &&
              this.cdEstrutra.equals(other.getCdEstrutra()))) &&
            ((this.cdMaquina==null && other.getCdMaquina()==null) || 
             (this.cdMaquina!=null &&
              this.cdMaquina.equals(other.getCdMaquina()))) &&
            ((this.cdMolde==null && other.getCdMolde()==null) || 
             (this.cdMolde!=null &&
              this.cdMolde.equals(other.getCdMolde()))) &&
            ((this.cicloPadrao==null && other.getCicloPadrao()==null) || 
             (this.cicloPadrao!=null &&
              this.cicloPadrao.equals(other.getCicloPadrao()))) &&
            ((this.qtCicloPadrao==null && other.getQtCicloPadrao()==null) || 
             (this.qtCicloPadrao!=null &&
              this.qtCicloPadrao.equals(other.getQtCicloPadrao()))) &&
            ((this.qtInjNormal==null && other.getQtInjNormal()==null) || 
             (this.qtInjNormal!=null &&
              this.qtInjNormal.equals(other.getQtInjNormal()))) &&
            ((this.tempoAtivo==null && other.getTempoAtivo()==null) || 
             (this.tempoAtivo!=null &&
              this.tempoAtivo.equals(other.getTempoAtivo()))) &&
            ((this.tmpCicNormal==null && other.getTmpCicNormal()==null) || 
             (this.tmpCicNormal!=null &&
              this.tmpCicNormal.equals(other.getTmpCicNormal())));
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
        if (getCdEstrutra() != null) {
            _hashCode += getCdEstrutra().hashCode();
        }
        if (getCdMaquina() != null) {
            _hashCode += getCdMaquina().hashCode();
        }
        if (getCdMolde() != null) {
            _hashCode += getCdMolde().hashCode();
        }
        if (getCicloPadrao() != null) {
            _hashCode += getCicloPadrao().hashCode();
        }
        if (getQtCicloPadrao() != null) {
            _hashCode += getQtCicloPadrao().hashCode();
        }
        if (getQtInjNormal() != null) {
            _hashCode += getQtInjNormal().hashCode();
        }
        if (getTempoAtivo() != null) {
            _hashCode += getTempoAtivo().hashCode();
        }
        if (getTmpCicNormal() != null) {
            _hashCode += getTmpCicNormal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosParaECPonderadaInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dadosParaECPonderadaInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdEstrutra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdEstrutra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtInjNormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtInjNormal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpCicNormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpCicNormal"));
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
