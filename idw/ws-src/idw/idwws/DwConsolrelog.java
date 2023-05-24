/**
 * DwConsolrelog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolrelog  implements java.io.Serializable {
    private java.util.Calendar dthrCancelado;

    private java.util.Calendar dthrRefugo;

    private idw.idwws.DwConsolreoco[] dwConsolreocos;

    private idw.idwws.DwTAcao dwTAcao;

    private idw.idwws.DwTCausa dwTCausa;

    private idw.idwws.DwTRefugo dwTRefugo;

    private long idConsolrelog;

    private java.math.BigDecimal isCancelado;

    private java.math.BigDecimal msDthrrefugo;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmPt omPt;

    private java.lang.Double pcsAutoProducaorefugada;

    private java.lang.Double pcsManuProducaorefugada;

    public DwConsolrelog() {
    }

    public DwConsolrelog(
           java.util.Calendar dthrCancelado,
           java.util.Calendar dthrRefugo,
           idw.idwws.DwConsolreoco[] dwConsolreocos,
           idw.idwws.DwTAcao dwTAcao,
           idw.idwws.DwTCausa dwTCausa,
           idw.idwws.DwTRefugo dwTRefugo,
           long idConsolrelog,
           java.math.BigDecimal isCancelado,
           java.math.BigDecimal msDthrrefugo,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           java.lang.Double pcsAutoProducaorefugada,
           java.lang.Double pcsManuProducaorefugada) {
           this.dthrCancelado = dthrCancelado;
           this.dthrRefugo = dthrRefugo;
           this.dwConsolreocos = dwConsolreocos;
           this.dwTAcao = dwTAcao;
           this.dwTCausa = dwTCausa;
           this.dwTRefugo = dwTRefugo;
           this.idConsolrelog = idConsolrelog;
           this.isCancelado = isCancelado;
           this.msDthrrefugo = msDthrrefugo;
           this.omProduto = omProduto;
           this.omPt = omPt;
           this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
           this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }


    /**
     * Gets the dthrCancelado value for this DwConsolrelog.
     * 
     * @return dthrCancelado
     */
    public java.util.Calendar getDthrCancelado() {
        return dthrCancelado;
    }


    /**
     * Sets the dthrCancelado value for this DwConsolrelog.
     * 
     * @param dthrCancelado
     */
    public void setDthrCancelado(java.util.Calendar dthrCancelado) {
        this.dthrCancelado = dthrCancelado;
    }


    /**
     * Gets the dthrRefugo value for this DwConsolrelog.
     * 
     * @return dthrRefugo
     */
    public java.util.Calendar getDthrRefugo() {
        return dthrRefugo;
    }


    /**
     * Sets the dthrRefugo value for this DwConsolrelog.
     * 
     * @param dthrRefugo
     */
    public void setDthrRefugo(java.util.Calendar dthrRefugo) {
        this.dthrRefugo = dthrRefugo;
    }


    /**
     * Gets the dwConsolreocos value for this DwConsolrelog.
     * 
     * @return dwConsolreocos
     */
    public idw.idwws.DwConsolreoco[] getDwConsolreocos() {
        return dwConsolreocos;
    }


    /**
     * Sets the dwConsolreocos value for this DwConsolrelog.
     * 
     * @param dwConsolreocos
     */
    public void setDwConsolreocos(idw.idwws.DwConsolreoco[] dwConsolreocos) {
        this.dwConsolreocos = dwConsolreocos;
    }

    public idw.idwws.DwConsolreoco getDwConsolreocos(int i) {
        return this.dwConsolreocos[i];
    }

    public void setDwConsolreocos(int i, idw.idwws.DwConsolreoco _value) {
        this.dwConsolreocos[i] = _value;
    }


    /**
     * Gets the dwTAcao value for this DwConsolrelog.
     * 
     * @return dwTAcao
     */
    public idw.idwws.DwTAcao getDwTAcao() {
        return dwTAcao;
    }


    /**
     * Sets the dwTAcao value for this DwConsolrelog.
     * 
     * @param dwTAcao
     */
    public void setDwTAcao(idw.idwws.DwTAcao dwTAcao) {
        this.dwTAcao = dwTAcao;
    }


    /**
     * Gets the dwTCausa value for this DwConsolrelog.
     * 
     * @return dwTCausa
     */
    public idw.idwws.DwTCausa getDwTCausa() {
        return dwTCausa;
    }


    /**
     * Sets the dwTCausa value for this DwConsolrelog.
     * 
     * @param dwTCausa
     */
    public void setDwTCausa(idw.idwws.DwTCausa dwTCausa) {
        this.dwTCausa = dwTCausa;
    }


    /**
     * Gets the dwTRefugo value for this DwConsolrelog.
     * 
     * @return dwTRefugo
     */
    public idw.idwws.DwTRefugo getDwTRefugo() {
        return dwTRefugo;
    }


    /**
     * Sets the dwTRefugo value for this DwConsolrelog.
     * 
     * @param dwTRefugo
     */
    public void setDwTRefugo(idw.idwws.DwTRefugo dwTRefugo) {
        this.dwTRefugo = dwTRefugo;
    }


    /**
     * Gets the idConsolrelog value for this DwConsolrelog.
     * 
     * @return idConsolrelog
     */
    public long getIdConsolrelog() {
        return idConsolrelog;
    }


    /**
     * Sets the idConsolrelog value for this DwConsolrelog.
     * 
     * @param idConsolrelog
     */
    public void setIdConsolrelog(long idConsolrelog) {
        this.idConsolrelog = idConsolrelog;
    }


    /**
     * Gets the isCancelado value for this DwConsolrelog.
     * 
     * @return isCancelado
     */
    public java.math.BigDecimal getIsCancelado() {
        return isCancelado;
    }


    /**
     * Sets the isCancelado value for this DwConsolrelog.
     * 
     * @param isCancelado
     */
    public void setIsCancelado(java.math.BigDecimal isCancelado) {
        this.isCancelado = isCancelado;
    }


    /**
     * Gets the msDthrrefugo value for this DwConsolrelog.
     * 
     * @return msDthrrefugo
     */
    public java.math.BigDecimal getMsDthrrefugo() {
        return msDthrrefugo;
    }


    /**
     * Sets the msDthrrefugo value for this DwConsolrelog.
     * 
     * @param msDthrrefugo
     */
    public void setMsDthrrefugo(java.math.BigDecimal msDthrrefugo) {
        this.msDthrrefugo = msDthrrefugo;
    }


    /**
     * Gets the omProduto value for this DwConsolrelog.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwConsolrelog.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omPt value for this DwConsolrelog.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwConsolrelog.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the pcsAutoProducaorefugada value for this DwConsolrelog.
     * 
     * @return pcsAutoProducaorefugada
     */
    public java.lang.Double getPcsAutoProducaorefugada() {
        return pcsAutoProducaorefugada;
    }


    /**
     * Sets the pcsAutoProducaorefugada value for this DwConsolrelog.
     * 
     * @param pcsAutoProducaorefugada
     */
    public void setPcsAutoProducaorefugada(java.lang.Double pcsAutoProducaorefugada) {
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
    }


    /**
     * Gets the pcsManuProducaorefugada value for this DwConsolrelog.
     * 
     * @return pcsManuProducaorefugada
     */
    public java.lang.Double getPcsManuProducaorefugada() {
        return pcsManuProducaorefugada;
    }


    /**
     * Sets the pcsManuProducaorefugada value for this DwConsolrelog.
     * 
     * @param pcsManuProducaorefugada
     */
    public void setPcsManuProducaorefugada(java.lang.Double pcsManuProducaorefugada) {
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolrelog)) return false;
        DwConsolrelog other = (DwConsolrelog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrCancelado==null && other.getDthrCancelado()==null) || 
             (this.dthrCancelado!=null &&
              this.dthrCancelado.equals(other.getDthrCancelado()))) &&
            ((this.dthrRefugo==null && other.getDthrRefugo()==null) || 
             (this.dthrRefugo!=null &&
              this.dthrRefugo.equals(other.getDthrRefugo()))) &&
            ((this.dwConsolreocos==null && other.getDwConsolreocos()==null) || 
             (this.dwConsolreocos!=null &&
              java.util.Arrays.equals(this.dwConsolreocos, other.getDwConsolreocos()))) &&
            ((this.dwTAcao==null && other.getDwTAcao()==null) || 
             (this.dwTAcao!=null &&
              this.dwTAcao.equals(other.getDwTAcao()))) &&
            ((this.dwTCausa==null && other.getDwTCausa()==null) || 
             (this.dwTCausa!=null &&
              this.dwTCausa.equals(other.getDwTCausa()))) &&
            ((this.dwTRefugo==null && other.getDwTRefugo()==null) || 
             (this.dwTRefugo!=null &&
              this.dwTRefugo.equals(other.getDwTRefugo()))) &&
            this.idConsolrelog == other.getIdConsolrelog() &&
            ((this.isCancelado==null && other.getIsCancelado()==null) || 
             (this.isCancelado!=null &&
              this.isCancelado.equals(other.getIsCancelado()))) &&
            ((this.msDthrrefugo==null && other.getMsDthrrefugo()==null) || 
             (this.msDthrrefugo!=null &&
              this.msDthrrefugo.equals(other.getMsDthrrefugo()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.pcsAutoProducaorefugada==null && other.getPcsAutoProducaorefugada()==null) || 
             (this.pcsAutoProducaorefugada!=null &&
              this.pcsAutoProducaorefugada.equals(other.getPcsAutoProducaorefugada()))) &&
            ((this.pcsManuProducaorefugada==null && other.getPcsManuProducaorefugada()==null) || 
             (this.pcsManuProducaorefugada!=null &&
              this.pcsManuProducaorefugada.equals(other.getPcsManuProducaorefugada())));
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
        if (getDthrCancelado() != null) {
            _hashCode += getDthrCancelado().hashCode();
        }
        if (getDthrRefugo() != null) {
            _hashCode += getDthrRefugo().hashCode();
        }
        if (getDwConsolreocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolreocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolreocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAcao() != null) {
            _hashCode += getDwTAcao().hashCode();
        }
        if (getDwTCausa() != null) {
            _hashCode += getDwTCausa().hashCode();
        }
        if (getDwTRefugo() != null) {
            _hashCode += getDwTRefugo().hashCode();
        }
        _hashCode += new Long(getIdConsolrelog()).hashCode();
        if (getIsCancelado() != null) {
            _hashCode += getIsCancelado().hashCode();
        }
        if (getMsDthrrefugo() != null) {
            _hashCode += getMsDthrrefugo().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPcsAutoProducaorefugada() != null) {
            _hashCode += getPcsAutoProducaorefugada().hashCode();
        }
        if (getPcsManuProducaorefugada() != null) {
            _hashCode += getPcsManuProducaorefugada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolrelog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolrelog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCancelado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCancelado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolreocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolreocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolreoco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTCausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTCausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTCausa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolrelog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolrelog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCancelado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCancelado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaorefugada"));
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
