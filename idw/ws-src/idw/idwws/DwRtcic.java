/**
 * DwRtcic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwRtcic  extends idw.idwws.DwRtCicTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFciclo;

    private java.util.Calendar dthrIciclo;

    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwRt dwRt;

    private long idRtcic;

    private java.lang.Boolean isRegulagem;

    private java.lang.Byte msDthrfciclo;

    private java.lang.Byte msDthriciclo;

    private idw.idwws.PpCp ppCp;

    private java.math.BigDecimal segDuracao;

    public DwRtcic() {
    }

    public DwRtcic(
           java.util.Calendar dthrFciclo,
           java.util.Calendar dthrIciclo,
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwRt dwRt,
           long idRtcic,
           java.lang.Boolean isRegulagem,
           java.lang.Byte msDthrfciclo,
           java.lang.Byte msDthriciclo,
           idw.idwws.PpCp ppCp,
           java.math.BigDecimal segDuracao) {
        this.dthrFciclo = dthrFciclo;
        this.dthrIciclo = dthrIciclo;
        this.dwFolha = dwFolha;
        this.dwRt = dwRt;
        this.idRtcic = idRtcic;
        this.isRegulagem = isRegulagem;
        this.msDthrfciclo = msDthrfciclo;
        this.msDthriciclo = msDthriciclo;
        this.ppCp = ppCp;
        this.segDuracao = segDuracao;
    }


    /**
     * Gets the dthrFciclo value for this DwRtcic.
     * 
     * @return dthrFciclo
     */
    public java.util.Calendar getDthrFciclo() {
        return dthrFciclo;
    }


    /**
     * Sets the dthrFciclo value for this DwRtcic.
     * 
     * @param dthrFciclo
     */
    public void setDthrFciclo(java.util.Calendar dthrFciclo) {
        this.dthrFciclo = dthrFciclo;
    }


    /**
     * Gets the dthrIciclo value for this DwRtcic.
     * 
     * @return dthrIciclo
     */
    public java.util.Calendar getDthrIciclo() {
        return dthrIciclo;
    }


    /**
     * Sets the dthrIciclo value for this DwRtcic.
     * 
     * @param dthrIciclo
     */
    public void setDthrIciclo(java.util.Calendar dthrIciclo) {
        this.dthrIciclo = dthrIciclo;
    }


    /**
     * Gets the dwFolha value for this DwRtcic.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwRtcic.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwRt value for this DwRtcic.
     * 
     * @return dwRt
     */
    public idw.idwws.DwRt getDwRt() {
        return dwRt;
    }


    /**
     * Sets the dwRt value for this DwRtcic.
     * 
     * @param dwRt
     */
    public void setDwRt(idw.idwws.DwRt dwRt) {
        this.dwRt = dwRt;
    }


    /**
     * Gets the idRtcic value for this DwRtcic.
     * 
     * @return idRtcic
     */
    public long getIdRtcic() {
        return idRtcic;
    }


    /**
     * Sets the idRtcic value for this DwRtcic.
     * 
     * @param idRtcic
     */
    public void setIdRtcic(long idRtcic) {
        this.idRtcic = idRtcic;
    }


    /**
     * Gets the isRegulagem value for this DwRtcic.
     * 
     * @return isRegulagem
     */
    public java.lang.Boolean getIsRegulagem() {
        return isRegulagem;
    }


    /**
     * Sets the isRegulagem value for this DwRtcic.
     * 
     * @param isRegulagem
     */
    public void setIsRegulagem(java.lang.Boolean isRegulagem) {
        this.isRegulagem = isRegulagem;
    }


    /**
     * Gets the msDthrfciclo value for this DwRtcic.
     * 
     * @return msDthrfciclo
     */
    public java.lang.Byte getMsDthrfciclo() {
        return msDthrfciclo;
    }


    /**
     * Sets the msDthrfciclo value for this DwRtcic.
     * 
     * @param msDthrfciclo
     */
    public void setMsDthrfciclo(java.lang.Byte msDthrfciclo) {
        this.msDthrfciclo = msDthrfciclo;
    }


    /**
     * Gets the msDthriciclo value for this DwRtcic.
     * 
     * @return msDthriciclo
     */
    public java.lang.Byte getMsDthriciclo() {
        return msDthriciclo;
    }


    /**
     * Sets the msDthriciclo value for this DwRtcic.
     * 
     * @param msDthriciclo
     */
    public void setMsDthriciclo(java.lang.Byte msDthriciclo) {
        this.msDthriciclo = msDthriciclo;
    }


    /**
     * Gets the ppCp value for this DwRtcic.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this DwRtcic.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the segDuracao value for this DwRtcic.
     * 
     * @return segDuracao
     */
    public java.math.BigDecimal getSegDuracao() {
        return segDuracao;
    }


    /**
     * Sets the segDuracao value for this DwRtcic.
     * 
     * @param segDuracao
     */
    public void setSegDuracao(java.math.BigDecimal segDuracao) {
        this.segDuracao = segDuracao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwRtcic)) return false;
        DwRtcic other = (DwRtcic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFciclo==null && other.getDthrFciclo()==null) || 
             (this.dthrFciclo!=null &&
              this.dthrFciclo.equals(other.getDthrFciclo()))) &&
            ((this.dthrIciclo==null && other.getDthrIciclo()==null) || 
             (this.dthrIciclo!=null &&
              this.dthrIciclo.equals(other.getDthrIciclo()))) &&
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.dwRt==null && other.getDwRt()==null) || 
             (this.dwRt!=null &&
              this.dwRt.equals(other.getDwRt()))) &&
            this.idRtcic == other.getIdRtcic() &&
            ((this.isRegulagem==null && other.getIsRegulagem()==null) || 
             (this.isRegulagem!=null &&
              this.isRegulagem.equals(other.getIsRegulagem()))) &&
            ((this.msDthrfciclo==null && other.getMsDthrfciclo()==null) || 
             (this.msDthrfciclo!=null &&
              this.msDthrfciclo.equals(other.getMsDthrfciclo()))) &&
            ((this.msDthriciclo==null && other.getMsDthriciclo()==null) || 
             (this.msDthriciclo!=null &&
              this.msDthriciclo.equals(other.getMsDthriciclo()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.segDuracao==null && other.getSegDuracao()==null) || 
             (this.segDuracao!=null &&
              this.segDuracao.equals(other.getSegDuracao())));
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
        if (getDthrFciclo() != null) {
            _hashCode += getDthrFciclo().hashCode();
        }
        if (getDthrIciclo() != null) {
            _hashCode += getDthrIciclo().hashCode();
        }
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getDwRt() != null) {
            _hashCode += getDwRt().hashCode();
        }
        _hashCode += new Long(getIdRtcic()).hashCode();
        if (getIsRegulagem() != null) {
            _hashCode += getIsRegulagem().hashCode();
        }
        if (getMsDthrfciclo() != null) {
            _hashCode += getMsDthrfciclo().hashCode();
        }
        if (getMsDthriciclo() != null) {
            _hashCode += getMsDthriciclo().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getSegDuracao() != null) {
            _hashCode += getSegDuracao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwRtcic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRtcic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRtcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRtcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthriciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthriciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segDuracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segDuracao"));
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
