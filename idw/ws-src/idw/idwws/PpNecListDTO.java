/**
 * PpNecListDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecListDTO  implements java.io.Serializable {
    private java.lang.String aba;

    private java.lang.Integer anoReferencia;

    private java.lang.String dsErro;

    private java.util.Calendar dthrFimportacao;

    private java.util.Calendar dthrIimportacao;

    private java.util.Calendar dthrInicioGeral;

    private java.lang.Integer mesReferencia;

    private idw.idwws.OmUsr omusr;

    private idw.idwws.PpNecDTO[] ppNecDTO;

    private idw.idwws.PpNecimp ppnecimp;

    private idw.idwws.PpNecimplog ppnecimplog;

    private idw.idwws.PpNecimpurl ppnecimpurl;

    private idw.idwws.ResultadoDTO resultadoDTO;

    private idw.idwws.ProdutoDTO[] resultadoIntegProdutos;

    private java.lang.Byte stImp;

    private java.lang.String urlArquivo;

    public PpNecListDTO() {
    }

    public PpNecListDTO(
           java.lang.String aba,
           java.lang.Integer anoReferencia,
           java.lang.String dsErro,
           java.util.Calendar dthrFimportacao,
           java.util.Calendar dthrIimportacao,
           java.util.Calendar dthrInicioGeral,
           java.lang.Integer mesReferencia,
           idw.idwws.OmUsr omusr,
           idw.idwws.PpNecDTO[] ppNecDTO,
           idw.idwws.PpNecimp ppnecimp,
           idw.idwws.PpNecimplog ppnecimplog,
           idw.idwws.PpNecimpurl ppnecimpurl,
           idw.idwws.ResultadoDTO resultadoDTO,
           idw.idwws.ProdutoDTO[] resultadoIntegProdutos,
           java.lang.Byte stImp,
           java.lang.String urlArquivo) {
           this.aba = aba;
           this.anoReferencia = anoReferencia;
           this.dsErro = dsErro;
           this.dthrFimportacao = dthrFimportacao;
           this.dthrIimportacao = dthrIimportacao;
           this.dthrInicioGeral = dthrInicioGeral;
           this.mesReferencia = mesReferencia;
           this.omusr = omusr;
           this.ppNecDTO = ppNecDTO;
           this.ppnecimp = ppnecimp;
           this.ppnecimplog = ppnecimplog;
           this.ppnecimpurl = ppnecimpurl;
           this.resultadoDTO = resultadoDTO;
           this.resultadoIntegProdutos = resultadoIntegProdutos;
           this.stImp = stImp;
           this.urlArquivo = urlArquivo;
    }


    /**
     * Gets the aba value for this PpNecListDTO.
     * 
     * @return aba
     */
    public java.lang.String getAba() {
        return aba;
    }


    /**
     * Sets the aba value for this PpNecListDTO.
     * 
     * @param aba
     */
    public void setAba(java.lang.String aba) {
        this.aba = aba;
    }


    /**
     * Gets the anoReferencia value for this PpNecListDTO.
     * 
     * @return anoReferencia
     */
    public java.lang.Integer getAnoReferencia() {
        return anoReferencia;
    }


    /**
     * Sets the anoReferencia value for this PpNecListDTO.
     * 
     * @param anoReferencia
     */
    public void setAnoReferencia(java.lang.Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }


    /**
     * Gets the dsErro value for this PpNecListDTO.
     * 
     * @return dsErro
     */
    public java.lang.String getDsErro() {
        return dsErro;
    }


    /**
     * Sets the dsErro value for this PpNecListDTO.
     * 
     * @param dsErro
     */
    public void setDsErro(java.lang.String dsErro) {
        this.dsErro = dsErro;
    }


    /**
     * Gets the dthrFimportacao value for this PpNecListDTO.
     * 
     * @return dthrFimportacao
     */
    public java.util.Calendar getDthrFimportacao() {
        return dthrFimportacao;
    }


    /**
     * Sets the dthrFimportacao value for this PpNecListDTO.
     * 
     * @param dthrFimportacao
     */
    public void setDthrFimportacao(java.util.Calendar dthrFimportacao) {
        this.dthrFimportacao = dthrFimportacao;
    }


    /**
     * Gets the dthrIimportacao value for this PpNecListDTO.
     * 
     * @return dthrIimportacao
     */
    public java.util.Calendar getDthrIimportacao() {
        return dthrIimportacao;
    }


    /**
     * Sets the dthrIimportacao value for this PpNecListDTO.
     * 
     * @param dthrIimportacao
     */
    public void setDthrIimportacao(java.util.Calendar dthrIimportacao) {
        this.dthrIimportacao = dthrIimportacao;
    }


    /**
     * Gets the dthrInicioGeral value for this PpNecListDTO.
     * 
     * @return dthrInicioGeral
     */
    public java.util.Calendar getDthrInicioGeral() {
        return dthrInicioGeral;
    }


    /**
     * Sets the dthrInicioGeral value for this PpNecListDTO.
     * 
     * @param dthrInicioGeral
     */
    public void setDthrInicioGeral(java.util.Calendar dthrInicioGeral) {
        this.dthrInicioGeral = dthrInicioGeral;
    }


    /**
     * Gets the mesReferencia value for this PpNecListDTO.
     * 
     * @return mesReferencia
     */
    public java.lang.Integer getMesReferencia() {
        return mesReferencia;
    }


    /**
     * Sets the mesReferencia value for this PpNecListDTO.
     * 
     * @param mesReferencia
     */
    public void setMesReferencia(java.lang.Integer mesReferencia) {
        this.mesReferencia = mesReferencia;
    }


    /**
     * Gets the omusr value for this PpNecListDTO.
     * 
     * @return omusr
     */
    public idw.idwws.OmUsr getOmusr() {
        return omusr;
    }


    /**
     * Sets the omusr value for this PpNecListDTO.
     * 
     * @param omusr
     */
    public void setOmusr(idw.idwws.OmUsr omusr) {
        this.omusr = omusr;
    }


    /**
     * Gets the ppNecDTO value for this PpNecListDTO.
     * 
     * @return ppNecDTO
     */
    public idw.idwws.PpNecDTO[] getPpNecDTO() {
        return ppNecDTO;
    }


    /**
     * Sets the ppNecDTO value for this PpNecListDTO.
     * 
     * @param ppNecDTO
     */
    public void setPpNecDTO(idw.idwws.PpNecDTO[] ppNecDTO) {
        this.ppNecDTO = ppNecDTO;
    }

    public idw.idwws.PpNecDTO getPpNecDTO(int i) {
        return this.ppNecDTO[i];
    }

    public void setPpNecDTO(int i, idw.idwws.PpNecDTO _value) {
        this.ppNecDTO[i] = _value;
    }


    /**
     * Gets the ppnecimp value for this PpNecListDTO.
     * 
     * @return ppnecimp
     */
    public idw.idwws.PpNecimp getPpnecimp() {
        return ppnecimp;
    }


    /**
     * Sets the ppnecimp value for this PpNecListDTO.
     * 
     * @param ppnecimp
     */
    public void setPpnecimp(idw.idwws.PpNecimp ppnecimp) {
        this.ppnecimp = ppnecimp;
    }


    /**
     * Gets the ppnecimplog value for this PpNecListDTO.
     * 
     * @return ppnecimplog
     */
    public idw.idwws.PpNecimplog getPpnecimplog() {
        return ppnecimplog;
    }


    /**
     * Sets the ppnecimplog value for this PpNecListDTO.
     * 
     * @param ppnecimplog
     */
    public void setPpnecimplog(idw.idwws.PpNecimplog ppnecimplog) {
        this.ppnecimplog = ppnecimplog;
    }


    /**
     * Gets the ppnecimpurl value for this PpNecListDTO.
     * 
     * @return ppnecimpurl
     */
    public idw.idwws.PpNecimpurl getPpnecimpurl() {
        return ppnecimpurl;
    }


    /**
     * Sets the ppnecimpurl value for this PpNecListDTO.
     * 
     * @param ppnecimpurl
     */
    public void setPpnecimpurl(idw.idwws.PpNecimpurl ppnecimpurl) {
        this.ppnecimpurl = ppnecimpurl;
    }


    /**
     * Gets the resultadoDTO value for this PpNecListDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this PpNecListDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the resultadoIntegProdutos value for this PpNecListDTO.
     * 
     * @return resultadoIntegProdutos
     */
    public idw.idwws.ProdutoDTO[] getResultadoIntegProdutos() {
        return resultadoIntegProdutos;
    }


    /**
     * Sets the resultadoIntegProdutos value for this PpNecListDTO.
     * 
     * @param resultadoIntegProdutos
     */
    public void setResultadoIntegProdutos(idw.idwws.ProdutoDTO[] resultadoIntegProdutos) {
        this.resultadoIntegProdutos = resultadoIntegProdutos;
    }

    public idw.idwws.ProdutoDTO getResultadoIntegProdutos(int i) {
        return this.resultadoIntegProdutos[i];
    }

    public void setResultadoIntegProdutos(int i, idw.idwws.ProdutoDTO _value) {
        this.resultadoIntegProdutos[i] = _value;
    }


    /**
     * Gets the stImp value for this PpNecListDTO.
     * 
     * @return stImp
     */
    public java.lang.Byte getStImp() {
        return stImp;
    }


    /**
     * Sets the stImp value for this PpNecListDTO.
     * 
     * @param stImp
     */
    public void setStImp(java.lang.Byte stImp) {
        this.stImp = stImp;
    }


    /**
     * Gets the urlArquivo value for this PpNecListDTO.
     * 
     * @return urlArquivo
     */
    public java.lang.String getUrlArquivo() {
        return urlArquivo;
    }


    /**
     * Sets the urlArquivo value for this PpNecListDTO.
     * 
     * @param urlArquivo
     */
    public void setUrlArquivo(java.lang.String urlArquivo) {
        this.urlArquivo = urlArquivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecListDTO)) return false;
        PpNecListDTO other = (PpNecListDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aba==null && other.getAba()==null) || 
             (this.aba!=null &&
              this.aba.equals(other.getAba()))) &&
            ((this.anoReferencia==null && other.getAnoReferencia()==null) || 
             (this.anoReferencia!=null &&
              this.anoReferencia.equals(other.getAnoReferencia()))) &&
            ((this.dsErro==null && other.getDsErro()==null) || 
             (this.dsErro!=null &&
              this.dsErro.equals(other.getDsErro()))) &&
            ((this.dthrFimportacao==null && other.getDthrFimportacao()==null) || 
             (this.dthrFimportacao!=null &&
              this.dthrFimportacao.equals(other.getDthrFimportacao()))) &&
            ((this.dthrIimportacao==null && other.getDthrIimportacao()==null) || 
             (this.dthrIimportacao!=null &&
              this.dthrIimportacao.equals(other.getDthrIimportacao()))) &&
            ((this.dthrInicioGeral==null && other.getDthrInicioGeral()==null) || 
             (this.dthrInicioGeral!=null &&
              this.dthrInicioGeral.equals(other.getDthrInicioGeral()))) &&
            ((this.mesReferencia==null && other.getMesReferencia()==null) || 
             (this.mesReferencia!=null &&
              this.mesReferencia.equals(other.getMesReferencia()))) &&
            ((this.omusr==null && other.getOmusr()==null) || 
             (this.omusr!=null &&
              this.omusr.equals(other.getOmusr()))) &&
            ((this.ppNecDTO==null && other.getPpNecDTO()==null) || 
             (this.ppNecDTO!=null &&
              java.util.Arrays.equals(this.ppNecDTO, other.getPpNecDTO()))) &&
            ((this.ppnecimp==null && other.getPpnecimp()==null) || 
             (this.ppnecimp!=null &&
              this.ppnecimp.equals(other.getPpnecimp()))) &&
            ((this.ppnecimplog==null && other.getPpnecimplog()==null) || 
             (this.ppnecimplog!=null &&
              this.ppnecimplog.equals(other.getPpnecimplog()))) &&
            ((this.ppnecimpurl==null && other.getPpnecimpurl()==null) || 
             (this.ppnecimpurl!=null &&
              this.ppnecimpurl.equals(other.getPpnecimpurl()))) &&
            ((this.resultadoDTO==null && other.getResultadoDTO()==null) || 
             (this.resultadoDTO!=null &&
              this.resultadoDTO.equals(other.getResultadoDTO()))) &&
            ((this.resultadoIntegProdutos==null && other.getResultadoIntegProdutos()==null) || 
             (this.resultadoIntegProdutos!=null &&
              java.util.Arrays.equals(this.resultadoIntegProdutos, other.getResultadoIntegProdutos()))) &&
            ((this.stImp==null && other.getStImp()==null) || 
             (this.stImp!=null &&
              this.stImp.equals(other.getStImp()))) &&
            ((this.urlArquivo==null && other.getUrlArquivo()==null) || 
             (this.urlArquivo!=null &&
              this.urlArquivo.equals(other.getUrlArquivo())));
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
        if (getAba() != null) {
            _hashCode += getAba().hashCode();
        }
        if (getAnoReferencia() != null) {
            _hashCode += getAnoReferencia().hashCode();
        }
        if (getDsErro() != null) {
            _hashCode += getDsErro().hashCode();
        }
        if (getDthrFimportacao() != null) {
            _hashCode += getDthrFimportacao().hashCode();
        }
        if (getDthrIimportacao() != null) {
            _hashCode += getDthrIimportacao().hashCode();
        }
        if (getDthrInicioGeral() != null) {
            _hashCode += getDthrInicioGeral().hashCode();
        }
        if (getMesReferencia() != null) {
            _hashCode += getMesReferencia().hashCode();
        }
        if (getOmusr() != null) {
            _hashCode += getOmusr().hashCode();
        }
        if (getPpNecDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpnecimp() != null) {
            _hashCode += getPpnecimp().hashCode();
        }
        if (getPpnecimplog() != null) {
            _hashCode += getPpnecimplog().hashCode();
        }
        if (getPpnecimpurl() != null) {
            _hashCode += getPpnecimpurl().hashCode();
        }
        if (getResultadoDTO() != null) {
            _hashCode += getResultadoDTO().hashCode();
        }
        if (getResultadoIntegProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResultadoIntegProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResultadoIntegProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStImp() != null) {
            _hashCode += getStImp().hashCode();
        }
        if (getUrlArquivo() != null) {
            _hashCode += getUrlArquivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNecListDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecListDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aba");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aba"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFimportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFimportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIimportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIimportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicioGeral");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicioGeral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omusr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omusr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppnecimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppnecimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppnecimplog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppnecimplog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimplog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppnecimpurl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppnecimpurl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoIntegProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoIntegProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stImp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stImp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlArquivo"));
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
