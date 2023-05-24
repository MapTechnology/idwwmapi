/**
 * LeituraCODTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class LeituraCODTO  implements java.io.Serializable {
    private java.lang.String cbRap;

    private java.lang.String cdLidoProduto;

    private java.lang.String dthrLeitura;

    private long idUsuario;

    private int isConferenciaOuAlimentacao;

    private boolean leituraOk;

    private idw.idwws.PosicaoCODTO posicaoASerLida;

    private int qtAlimentada;

    private boolean realimentacao;

    public LeituraCODTO() {
    }

    public LeituraCODTO(
           java.lang.String cbRap,
           java.lang.String cdLidoProduto,
           java.lang.String dthrLeitura,
           long idUsuario,
           int isConferenciaOuAlimentacao,
           boolean leituraOk,
           idw.idwws.PosicaoCODTO posicaoASerLida,
           int qtAlimentada,
           boolean realimentacao) {
           this.cbRap = cbRap;
           this.cdLidoProduto = cdLidoProduto;
           this.dthrLeitura = dthrLeitura;
           this.idUsuario = idUsuario;
           this.isConferenciaOuAlimentacao = isConferenciaOuAlimentacao;
           this.leituraOk = leituraOk;
           this.posicaoASerLida = posicaoASerLida;
           this.qtAlimentada = qtAlimentada;
           this.realimentacao = realimentacao;
    }


    /**
     * Gets the cbRap value for this LeituraCODTO.
     * 
     * @return cbRap
     */
    public java.lang.String getCbRap() {
        return cbRap;
    }


    /**
     * Sets the cbRap value for this LeituraCODTO.
     * 
     * @param cbRap
     */
    public void setCbRap(java.lang.String cbRap) {
        this.cbRap = cbRap;
    }


    /**
     * Gets the cdLidoProduto value for this LeituraCODTO.
     * 
     * @return cdLidoProduto
     */
    public java.lang.String getCdLidoProduto() {
        return cdLidoProduto;
    }


    /**
     * Sets the cdLidoProduto value for this LeituraCODTO.
     * 
     * @param cdLidoProduto
     */
    public void setCdLidoProduto(java.lang.String cdLidoProduto) {
        this.cdLidoProduto = cdLidoProduto;
    }


    /**
     * Gets the dthrLeitura value for this LeituraCODTO.
     * 
     * @return dthrLeitura
     */
    public java.lang.String getDthrLeitura() {
        return dthrLeitura;
    }


    /**
     * Sets the dthrLeitura value for this LeituraCODTO.
     * 
     * @param dthrLeitura
     */
    public void setDthrLeitura(java.lang.String dthrLeitura) {
        this.dthrLeitura = dthrLeitura;
    }


    /**
     * Gets the idUsuario value for this LeituraCODTO.
     * 
     * @return idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }


    /**
     * Sets the idUsuario value for this LeituraCODTO.
     * 
     * @param idUsuario
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Gets the isConferenciaOuAlimentacao value for this LeituraCODTO.
     * 
     * @return isConferenciaOuAlimentacao
     */
    public int getIsConferenciaOuAlimentacao() {
        return isConferenciaOuAlimentacao;
    }


    /**
     * Sets the isConferenciaOuAlimentacao value for this LeituraCODTO.
     * 
     * @param isConferenciaOuAlimentacao
     */
    public void setIsConferenciaOuAlimentacao(int isConferenciaOuAlimentacao) {
        this.isConferenciaOuAlimentacao = isConferenciaOuAlimentacao;
    }


    /**
     * Gets the leituraOk value for this LeituraCODTO.
     * 
     * @return leituraOk
     */
    public boolean isLeituraOk() {
        return leituraOk;
    }


    /**
     * Sets the leituraOk value for this LeituraCODTO.
     * 
     * @param leituraOk
     */
    public void setLeituraOk(boolean leituraOk) {
        this.leituraOk = leituraOk;
    }


    /**
     * Gets the posicaoASerLida value for this LeituraCODTO.
     * 
     * @return posicaoASerLida
     */
    public idw.idwws.PosicaoCODTO getPosicaoASerLida() {
        return posicaoASerLida;
    }


    /**
     * Sets the posicaoASerLida value for this LeituraCODTO.
     * 
     * @param posicaoASerLida
     */
    public void setPosicaoASerLida(idw.idwws.PosicaoCODTO posicaoASerLida) {
        this.posicaoASerLida = posicaoASerLida;
    }


    /**
     * Gets the qtAlimentada value for this LeituraCODTO.
     * 
     * @return qtAlimentada
     */
    public int getQtAlimentada() {
        return qtAlimentada;
    }


    /**
     * Sets the qtAlimentada value for this LeituraCODTO.
     * 
     * @param qtAlimentada
     */
    public void setQtAlimentada(int qtAlimentada) {
        this.qtAlimentada = qtAlimentada;
    }


    /**
     * Gets the realimentacao value for this LeituraCODTO.
     * 
     * @return realimentacao
     */
    public boolean isRealimentacao() {
        return realimentacao;
    }


    /**
     * Sets the realimentacao value for this LeituraCODTO.
     * 
     * @param realimentacao
     */
    public void setRealimentacao(boolean realimentacao) {
        this.realimentacao = realimentacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LeituraCODTO)) return false;
        LeituraCODTO other = (LeituraCODTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cbRap==null && other.getCbRap()==null) || 
             (this.cbRap!=null &&
              this.cbRap.equals(other.getCbRap()))) &&
            ((this.cdLidoProduto==null && other.getCdLidoProduto()==null) || 
             (this.cdLidoProduto!=null &&
              this.cdLidoProduto.equals(other.getCdLidoProduto()))) &&
            ((this.dthrLeitura==null && other.getDthrLeitura()==null) || 
             (this.dthrLeitura!=null &&
              this.dthrLeitura.equals(other.getDthrLeitura()))) &&
            this.idUsuario == other.getIdUsuario() &&
            this.isConferenciaOuAlimentacao == other.getIsConferenciaOuAlimentacao() &&
            this.leituraOk == other.isLeituraOk() &&
            ((this.posicaoASerLida==null && other.getPosicaoASerLida()==null) || 
             (this.posicaoASerLida!=null &&
              this.posicaoASerLida.equals(other.getPosicaoASerLida()))) &&
            this.qtAlimentada == other.getQtAlimentada() &&
            this.realimentacao == other.isRealimentacao();
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
        if (getCbRap() != null) {
            _hashCode += getCbRap().hashCode();
        }
        if (getCdLidoProduto() != null) {
            _hashCode += getCdLidoProduto().hashCode();
        }
        if (getDthrLeitura() != null) {
            _hashCode += getDthrLeitura().hashCode();
        }
        _hashCode += new Long(getIdUsuario()).hashCode();
        _hashCode += getIsConferenciaOuAlimentacao();
        _hashCode += (isLeituraOk() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPosicaoASerLida() != null) {
            _hashCode += getPosicaoASerLida().hashCode();
        }
        _hashCode += getQtAlimentada();
        _hashCode += (isRealimentacao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LeituraCODTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "leituraCODTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cbRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdLidoProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdLidoProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrLeitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrLeitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConferenciaOuAlimentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConferenciaOuAlimentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leituraOk");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leituraOk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posicaoASerLida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posicaoASerLida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "posicaoCODTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAlimentada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAlimentada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realimentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "realimentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
