/**
 * MaquinaPlanejamentoInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MaquinaPlanejamentoInjetDTO  implements java.io.Serializable {
    private java.lang.String cdEstrutura;

    private java.lang.String cdMolde;

    private java.lang.String cliente;

    private java.util.Calendar dtInicio;

    private java.lang.Float eficienciaCiclo;

    private java.lang.Float eficienciaRealizacao;

    private java.lang.Float indiceParada;

    private java.lang.Float indiceProducao;

    private java.lang.Float indiceRefugo;

    private java.lang.String nrop;

    private java.lang.Float qtcavativas;

    private java.lang.Float qtcavidades;

    public MaquinaPlanejamentoInjetDTO() {
    }

    public MaquinaPlanejamentoInjetDTO(
           java.lang.String cdEstrutura,
           java.lang.String cdMolde,
           java.lang.String cliente,
           java.util.Calendar dtInicio,
           java.lang.Float eficienciaCiclo,
           java.lang.Float eficienciaRealizacao,
           java.lang.Float indiceParada,
           java.lang.Float indiceProducao,
           java.lang.Float indiceRefugo,
           java.lang.String nrop,
           java.lang.Float qtcavativas,
           java.lang.Float qtcavidades) {
           this.cdEstrutura = cdEstrutura;
           this.cdMolde = cdMolde;
           this.cliente = cliente;
           this.dtInicio = dtInicio;
           this.eficienciaCiclo = eficienciaCiclo;
           this.eficienciaRealizacao = eficienciaRealizacao;
           this.indiceParada = indiceParada;
           this.indiceProducao = indiceProducao;
           this.indiceRefugo = indiceRefugo;
           this.nrop = nrop;
           this.qtcavativas = qtcavativas;
           this.qtcavidades = qtcavidades;
    }


    /**
     * Gets the cdEstrutura value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return cdEstrutura
     */
    public java.lang.String getCdEstrutura() {
        return cdEstrutura;
    }


    /**
     * Sets the cdEstrutura value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param cdEstrutura
     */
    public void setCdEstrutura(java.lang.String cdEstrutura) {
        this.cdEstrutura = cdEstrutura;
    }


    /**
     * Gets the cdMolde value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return cdMolde
     */
    public java.lang.String getCdMolde() {
        return cdMolde;
    }


    /**
     * Sets the cdMolde value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param cdMolde
     */
    public void setCdMolde(java.lang.String cdMolde) {
        this.cdMolde = cdMolde;
    }


    /**
     * Gets the cliente value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the dtInicio value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return dtInicio
     */
    public java.util.Calendar getDtInicio() {
        return dtInicio;
    }


    /**
     * Sets the dtInicio value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param dtInicio
     */
    public void setDtInicio(java.util.Calendar dtInicio) {
        this.dtInicio = dtInicio;
    }


    /**
     * Gets the eficienciaCiclo value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return eficienciaCiclo
     */
    public java.lang.Float getEficienciaCiclo() {
        return eficienciaCiclo;
    }


    /**
     * Sets the eficienciaCiclo value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param eficienciaCiclo
     */
    public void setEficienciaCiclo(java.lang.Float eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }


    /**
     * Gets the eficienciaRealizacao value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return eficienciaRealizacao
     */
    public java.lang.Float getEficienciaRealizacao() {
        return eficienciaRealizacao;
    }


    /**
     * Sets the eficienciaRealizacao value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param eficienciaRealizacao
     */
    public void setEficienciaRealizacao(java.lang.Float eficienciaRealizacao) {
        this.eficienciaRealizacao = eficienciaRealizacao;
    }


    /**
     * Gets the indiceParada value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return indiceParada
     */
    public java.lang.Float getIndiceParada() {
        return indiceParada;
    }


    /**
     * Sets the indiceParada value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param indiceParada
     */
    public void setIndiceParada(java.lang.Float indiceParada) {
        this.indiceParada = indiceParada;
    }


    /**
     * Gets the indiceProducao value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return indiceProducao
     */
    public java.lang.Float getIndiceProducao() {
        return indiceProducao;
    }


    /**
     * Sets the indiceProducao value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param indiceProducao
     */
    public void setIndiceProducao(java.lang.Float indiceProducao) {
        this.indiceProducao = indiceProducao;
    }


    /**
     * Gets the indiceRefugo value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return indiceRefugo
     */
    public java.lang.Float getIndiceRefugo() {
        return indiceRefugo;
    }


    /**
     * Sets the indiceRefugo value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param indiceRefugo
     */
    public void setIndiceRefugo(java.lang.Float indiceRefugo) {
        this.indiceRefugo = indiceRefugo;
    }


    /**
     * Gets the nrop value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the qtcavativas value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return qtcavativas
     */
    public java.lang.Float getQtcavativas() {
        return qtcavativas;
    }


    /**
     * Sets the qtcavativas value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param qtcavativas
     */
    public void setQtcavativas(java.lang.Float qtcavativas) {
        this.qtcavativas = qtcavativas;
    }


    /**
     * Gets the qtcavidades value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @return qtcavidades
     */
    public java.lang.Float getQtcavidades() {
        return qtcavidades;
    }


    /**
     * Sets the qtcavidades value for this MaquinaPlanejamentoInjetDTO.
     * 
     * @param qtcavidades
     */
    public void setQtcavidades(java.lang.Float qtcavidades) {
        this.qtcavidades = qtcavidades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MaquinaPlanejamentoInjetDTO)) return false;
        MaquinaPlanejamentoInjetDTO other = (MaquinaPlanejamentoInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdEstrutura==null && other.getCdEstrutura()==null) || 
             (this.cdEstrutura!=null &&
              this.cdEstrutura.equals(other.getCdEstrutura()))) &&
            ((this.cdMolde==null && other.getCdMolde()==null) || 
             (this.cdMolde!=null &&
              this.cdMolde.equals(other.getCdMolde()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.dtInicio==null && other.getDtInicio()==null) || 
             (this.dtInicio!=null &&
              this.dtInicio.equals(other.getDtInicio()))) &&
            ((this.eficienciaCiclo==null && other.getEficienciaCiclo()==null) || 
             (this.eficienciaCiclo!=null &&
              this.eficienciaCiclo.equals(other.getEficienciaCiclo()))) &&
            ((this.eficienciaRealizacao==null && other.getEficienciaRealizacao()==null) || 
             (this.eficienciaRealizacao!=null &&
              this.eficienciaRealizacao.equals(other.getEficienciaRealizacao()))) &&
            ((this.indiceParada==null && other.getIndiceParada()==null) || 
             (this.indiceParada!=null &&
              this.indiceParada.equals(other.getIndiceParada()))) &&
            ((this.indiceProducao==null && other.getIndiceProducao()==null) || 
             (this.indiceProducao!=null &&
              this.indiceProducao.equals(other.getIndiceProducao()))) &&
            ((this.indiceRefugo==null && other.getIndiceRefugo()==null) || 
             (this.indiceRefugo!=null &&
              this.indiceRefugo.equals(other.getIndiceRefugo()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.qtcavativas==null && other.getQtcavativas()==null) || 
             (this.qtcavativas!=null &&
              this.qtcavativas.equals(other.getQtcavativas()))) &&
            ((this.qtcavidades==null && other.getQtcavidades()==null) || 
             (this.qtcavidades!=null &&
              this.qtcavidades.equals(other.getQtcavidades())));
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
        if (getCdEstrutura() != null) {
            _hashCode += getCdEstrutura().hashCode();
        }
        if (getCdMolde() != null) {
            _hashCode += getCdMolde().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getDtInicio() != null) {
            _hashCode += getDtInicio().hashCode();
        }
        if (getEficienciaCiclo() != null) {
            _hashCode += getEficienciaCiclo().hashCode();
        }
        if (getEficienciaRealizacao() != null) {
            _hashCode += getEficienciaRealizacao().hashCode();
        }
        if (getIndiceParada() != null) {
            _hashCode += getIndiceParada().hashCode();
        }
        if (getIndiceProducao() != null) {
            _hashCode += getIndiceProducao().hashCode();
        }
        if (getIndiceRefugo() != null) {
            _hashCode += getIndiceRefugo().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getQtcavativas() != null) {
            _hashCode += getQtcavativas().hashCode();
        }
        if (getQtcavidades() != null) {
            _hashCode += getQtcavidades().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MaquinaPlanejamentoInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "maquinaPlanejamentoInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdEstrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdEstrutura"));
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
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaRealizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaRealizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceProducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceProducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavativas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
