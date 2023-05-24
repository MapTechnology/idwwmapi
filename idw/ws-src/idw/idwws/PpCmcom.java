/**
 * PpCmcom.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCmcom  extends idw.idwws.PpCmcomTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrSai;

    private java.util.Calendar dthrVigor;

    private java.lang.Long idCmcom;

    private java.lang.Integer isConsumirmp;

    private java.lang.String obs;

    private idw.idwws.OmProduto omProdutoByFinal;

    private idw.idwws.OmProduto omProdutoByIdProdutoentra;

    private idw.idwws.OmProduto omProdutoByIdProdutosai;

    private java.lang.String posicao;

    private idw.idwws.PpCm ppCm;

    private java.math.BigDecimal qtEntra;

    private java.math.BigDecimal qtSai;

    public PpCmcom() {
    }

    public PpCmcom(
           java.util.Calendar dthrSai,
           java.util.Calendar dthrVigor,
           java.lang.Long idCmcom,
           java.lang.Integer isConsumirmp,
           java.lang.String obs,
           idw.idwws.OmProduto omProdutoByFinal,
           idw.idwws.OmProduto omProdutoByIdProdutoentra,
           idw.idwws.OmProduto omProdutoByIdProdutosai,
           java.lang.String posicao,
           idw.idwws.PpCm ppCm,
           java.math.BigDecimal qtEntra,
           java.math.BigDecimal qtSai) {
        this.dthrSai = dthrSai;
        this.dthrVigor = dthrVigor;
        this.idCmcom = idCmcom;
        this.isConsumirmp = isConsumirmp;
        this.obs = obs;
        this.omProdutoByFinal = omProdutoByFinal;
        this.omProdutoByIdProdutoentra = omProdutoByIdProdutoentra;
        this.omProdutoByIdProdutosai = omProdutoByIdProdutosai;
        this.posicao = posicao;
        this.ppCm = ppCm;
        this.qtEntra = qtEntra;
        this.qtSai = qtSai;
    }


    /**
     * Gets the dthrSai value for this PpCmcom.
     * 
     * @return dthrSai
     */
    public java.util.Calendar getDthrSai() {
        return dthrSai;
    }


    /**
     * Sets the dthrSai value for this PpCmcom.
     * 
     * @param dthrSai
     */
    public void setDthrSai(java.util.Calendar dthrSai) {
        this.dthrSai = dthrSai;
    }


    /**
     * Gets the dthrVigor value for this PpCmcom.
     * 
     * @return dthrVigor
     */
    public java.util.Calendar getDthrVigor() {
        return dthrVigor;
    }


    /**
     * Sets the dthrVigor value for this PpCmcom.
     * 
     * @param dthrVigor
     */
    public void setDthrVigor(java.util.Calendar dthrVigor) {
        this.dthrVigor = dthrVigor;
    }


    /**
     * Gets the idCmcom value for this PpCmcom.
     * 
     * @return idCmcom
     */
    public java.lang.Long getIdCmcom() {
        return idCmcom;
    }


    /**
     * Sets the idCmcom value for this PpCmcom.
     * 
     * @param idCmcom
     */
    public void setIdCmcom(java.lang.Long idCmcom) {
        this.idCmcom = idCmcom;
    }


    /**
     * Gets the isConsumirmp value for this PpCmcom.
     * 
     * @return isConsumirmp
     */
    public java.lang.Integer getIsConsumirmp() {
        return isConsumirmp;
    }


    /**
     * Sets the isConsumirmp value for this PpCmcom.
     * 
     * @param isConsumirmp
     */
    public void setIsConsumirmp(java.lang.Integer isConsumirmp) {
        this.isConsumirmp = isConsumirmp;
    }


    /**
     * Gets the obs value for this PpCmcom.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this PpCmcom.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the omProdutoByFinal value for this PpCmcom.
     * 
     * @return omProdutoByFinal
     */
    public idw.idwws.OmProduto getOmProdutoByFinal() {
        return omProdutoByFinal;
    }


    /**
     * Sets the omProdutoByFinal value for this PpCmcom.
     * 
     * @param omProdutoByFinal
     */
    public void setOmProdutoByFinal(idw.idwws.OmProduto omProdutoByFinal) {
        this.omProdutoByFinal = omProdutoByFinal;
    }


    /**
     * Gets the omProdutoByIdProdutoentra value for this PpCmcom.
     * 
     * @return omProdutoByIdProdutoentra
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutoentra() {
        return omProdutoByIdProdutoentra;
    }


    /**
     * Sets the omProdutoByIdProdutoentra value for this PpCmcom.
     * 
     * @param omProdutoByIdProdutoentra
     */
    public void setOmProdutoByIdProdutoentra(idw.idwws.OmProduto omProdutoByIdProdutoentra) {
        this.omProdutoByIdProdutoentra = omProdutoByIdProdutoentra;
    }


    /**
     * Gets the omProdutoByIdProdutosai value for this PpCmcom.
     * 
     * @return omProdutoByIdProdutosai
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutosai() {
        return omProdutoByIdProdutosai;
    }


    /**
     * Sets the omProdutoByIdProdutosai value for this PpCmcom.
     * 
     * @param omProdutoByIdProdutosai
     */
    public void setOmProdutoByIdProdutosai(idw.idwws.OmProduto omProdutoByIdProdutosai) {
        this.omProdutoByIdProdutosai = omProdutoByIdProdutosai;
    }


    /**
     * Gets the posicao value for this PpCmcom.
     * 
     * @return posicao
     */
    public java.lang.String getPosicao() {
        return posicao;
    }


    /**
     * Sets the posicao value for this PpCmcom.
     * 
     * @param posicao
     */
    public void setPosicao(java.lang.String posicao) {
        this.posicao = posicao;
    }


    /**
     * Gets the ppCm value for this PpCmcom.
     * 
     * @return ppCm
     */
    public idw.idwws.PpCm getPpCm() {
        return ppCm;
    }


    /**
     * Sets the ppCm value for this PpCmcom.
     * 
     * @param ppCm
     */
    public void setPpCm(idw.idwws.PpCm ppCm) {
        this.ppCm = ppCm;
    }


    /**
     * Gets the qtEntra value for this PpCmcom.
     * 
     * @return qtEntra
     */
    public java.math.BigDecimal getQtEntra() {
        return qtEntra;
    }


    /**
     * Sets the qtEntra value for this PpCmcom.
     * 
     * @param qtEntra
     */
    public void setQtEntra(java.math.BigDecimal qtEntra) {
        this.qtEntra = qtEntra;
    }


    /**
     * Gets the qtSai value for this PpCmcom.
     * 
     * @return qtSai
     */
    public java.math.BigDecimal getQtSai() {
        return qtSai;
    }


    /**
     * Sets the qtSai value for this PpCmcom.
     * 
     * @param qtSai
     */
    public void setQtSai(java.math.BigDecimal qtSai) {
        this.qtSai = qtSai;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCmcom)) return false;
        PpCmcom other = (PpCmcom) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrSai==null && other.getDthrSai()==null) || 
             (this.dthrSai!=null &&
              this.dthrSai.equals(other.getDthrSai()))) &&
            ((this.dthrVigor==null && other.getDthrVigor()==null) || 
             (this.dthrVigor!=null &&
              this.dthrVigor.equals(other.getDthrVigor()))) &&
            ((this.idCmcom==null && other.getIdCmcom()==null) || 
             (this.idCmcom!=null &&
              this.idCmcom.equals(other.getIdCmcom()))) &&
            ((this.isConsumirmp==null && other.getIsConsumirmp()==null) || 
             (this.isConsumirmp!=null &&
              this.isConsumirmp.equals(other.getIsConsumirmp()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.omProdutoByFinal==null && other.getOmProdutoByFinal()==null) || 
             (this.omProdutoByFinal!=null &&
              this.omProdutoByFinal.equals(other.getOmProdutoByFinal()))) &&
            ((this.omProdutoByIdProdutoentra==null && other.getOmProdutoByIdProdutoentra()==null) || 
             (this.omProdutoByIdProdutoentra!=null &&
              this.omProdutoByIdProdutoentra.equals(other.getOmProdutoByIdProdutoentra()))) &&
            ((this.omProdutoByIdProdutosai==null && other.getOmProdutoByIdProdutosai()==null) || 
             (this.omProdutoByIdProdutosai!=null &&
              this.omProdutoByIdProdutosai.equals(other.getOmProdutoByIdProdutosai()))) &&
            ((this.posicao==null && other.getPosicao()==null) || 
             (this.posicao!=null &&
              this.posicao.equals(other.getPosicao()))) &&
            ((this.ppCm==null && other.getPpCm()==null) || 
             (this.ppCm!=null &&
              this.ppCm.equals(other.getPpCm()))) &&
            ((this.qtEntra==null && other.getQtEntra()==null) || 
             (this.qtEntra!=null &&
              this.qtEntra.equals(other.getQtEntra()))) &&
            ((this.qtSai==null && other.getQtSai()==null) || 
             (this.qtSai!=null &&
              this.qtSai.equals(other.getQtSai())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDthrSai() != null) {
            _hashCode += getDthrSai().hashCode();
        }
        if (getDthrVigor() != null) {
            _hashCode += getDthrVigor().hashCode();
        }
        if (getIdCmcom() != null) {
            _hashCode += getIdCmcom().hashCode();
        }
        if (getIsConsumirmp() != null) {
            _hashCode += getIsConsumirmp().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getOmProdutoByFinal() != null) {
            _hashCode += getOmProdutoByFinal().hashCode();
        }
        if (getOmProdutoByIdProdutoentra() != null) {
            _hashCode += getOmProdutoByIdProdutoentra().hashCode();
        }
        if (getOmProdutoByIdProdutosai() != null) {
            _hashCode += getOmProdutoByIdProdutosai().hashCode();
        }
        if (getPosicao() != null) {
            _hashCode += getPosicao().hashCode();
        }
        if (getPpCm() != null) {
            _hashCode += getPpCm().hashCode();
        }
        if (getQtEntra() != null) {
            _hashCode += getQtEntra().hashCode();
        }
        if (getQtSai() != null) {
            _hashCode += getQtSai().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCmcom.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCmcom"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrSai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrSai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrVigor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrVigor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCmcom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCmcom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsumirmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsumirmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutoentra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutoentra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutosai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutosai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtEntra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtEntra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtSai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtSai"));
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
