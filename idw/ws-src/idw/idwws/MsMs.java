/**
 * MsMs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsMs  extends idw.idwws.MsMsTemplate  implements java.io.Serializable {
    private java.lang.String cdMs;

    private java.lang.String dsMs;

    private java.util.Calendar dthrHeartbeat;

    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private java.math.BigDecimal idMs;

    private java.lang.Boolean isImportouTm;

    private idw.idwws.MsMsicup[] msMsicups;

    private idw.idwws.MsMsihm[] msMsihms;

    private idw.idwws.MsUsr msUsr;

    private java.math.BigDecimal revisao;

    private java.math.BigDecimal segHeartbeat;

    private java.math.BigDecimal stAtivo;

    private java.lang.Integer tpCalculoandon;

    private java.lang.String urlConexao;

    public MsMs() {
    }

    public MsMs(
           java.lang.String cdMs,
           java.lang.String dsMs,
           java.util.Calendar dthrHeartbeat,
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           java.math.BigDecimal idMs,
           java.lang.Boolean isImportouTm,
           idw.idwws.MsMsicup[] msMsicups,
           idw.idwws.MsMsihm[] msMsihms,
           idw.idwws.MsUsr msUsr,
           java.math.BigDecimal revisao,
           java.math.BigDecimal segHeartbeat,
           java.math.BigDecimal stAtivo,
           java.lang.Integer tpCalculoandon,
           java.lang.String urlConexao) {
        this.cdMs = cdMs;
        this.dsMs = dsMs;
        this.dthrHeartbeat = dthrHeartbeat;
        this.dthrRevisao = dthrRevisao;
        this.dthrStativo = dthrStativo;
        this.idMs = idMs;
        this.isImportouTm = isImportouTm;
        this.msMsicups = msMsicups;
        this.msMsihms = msMsihms;
        this.msUsr = msUsr;
        this.revisao = revisao;
        this.segHeartbeat = segHeartbeat;
        this.stAtivo = stAtivo;
        this.tpCalculoandon = tpCalculoandon;
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the cdMs value for this MsMs.
     * 
     * @return cdMs
     */
    public java.lang.String getCdMs() {
        return cdMs;
    }


    /**
     * Sets the cdMs value for this MsMs.
     * 
     * @param cdMs
     */
    public void setCdMs(java.lang.String cdMs) {
        this.cdMs = cdMs;
    }


    /**
     * Gets the dsMs value for this MsMs.
     * 
     * @return dsMs
     */
    public java.lang.String getDsMs() {
        return dsMs;
    }


    /**
     * Sets the dsMs value for this MsMs.
     * 
     * @param dsMs
     */
    public void setDsMs(java.lang.String dsMs) {
        this.dsMs = dsMs;
    }


    /**
     * Gets the dthrHeartbeat value for this MsMs.
     * 
     * @return dthrHeartbeat
     */
    public java.util.Calendar getDthrHeartbeat() {
        return dthrHeartbeat;
    }


    /**
     * Sets the dthrHeartbeat value for this MsMs.
     * 
     * @param dthrHeartbeat
     */
    public void setDthrHeartbeat(java.util.Calendar dthrHeartbeat) {
        this.dthrHeartbeat = dthrHeartbeat;
    }


    /**
     * Gets the dthrRevisao value for this MsMs.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this MsMs.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this MsMs.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this MsMs.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the idMs value for this MsMs.
     * 
     * @return idMs
     */
    public java.math.BigDecimal getIdMs() {
        return idMs;
    }


    /**
     * Sets the idMs value for this MsMs.
     * 
     * @param idMs
     */
    public void setIdMs(java.math.BigDecimal idMs) {
        this.idMs = idMs;
    }


    /**
     * Gets the isImportouTm value for this MsMs.
     * 
     * @return isImportouTm
     */
    public java.lang.Boolean getIsImportouTm() {
        return isImportouTm;
    }


    /**
     * Sets the isImportouTm value for this MsMs.
     * 
     * @param isImportouTm
     */
    public void setIsImportouTm(java.lang.Boolean isImportouTm) {
        this.isImportouTm = isImportouTm;
    }


    /**
     * Gets the msMsicups value for this MsMs.
     * 
     * @return msMsicups
     */
    public idw.idwws.MsMsicup[] getMsMsicups() {
        return msMsicups;
    }


    /**
     * Sets the msMsicups value for this MsMs.
     * 
     * @param msMsicups
     */
    public void setMsMsicups(idw.idwws.MsMsicup[] msMsicups) {
        this.msMsicups = msMsicups;
    }

    public idw.idwws.MsMsicup getMsMsicups(int i) {
        return this.msMsicups[i];
    }

    public void setMsMsicups(int i, idw.idwws.MsMsicup _value) {
        this.msMsicups[i] = _value;
    }


    /**
     * Gets the msMsihms value for this MsMs.
     * 
     * @return msMsihms
     */
    public idw.idwws.MsMsihm[] getMsMsihms() {
        return msMsihms;
    }


    /**
     * Sets the msMsihms value for this MsMs.
     * 
     * @param msMsihms
     */
    public void setMsMsihms(idw.idwws.MsMsihm[] msMsihms) {
        this.msMsihms = msMsihms;
    }

    public idw.idwws.MsMsihm getMsMsihms(int i) {
        return this.msMsihms[i];
    }

    public void setMsMsihms(int i, idw.idwws.MsMsihm _value) {
        this.msMsihms[i] = _value;
    }


    /**
     * Gets the msUsr value for this MsMs.
     * 
     * @return msUsr
     */
    public idw.idwws.MsUsr getMsUsr() {
        return msUsr;
    }


    /**
     * Sets the msUsr value for this MsMs.
     * 
     * @param msUsr
     */
    public void setMsUsr(idw.idwws.MsUsr msUsr) {
        this.msUsr = msUsr;
    }


    /**
     * Gets the revisao value for this MsMs.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this MsMs.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the segHeartbeat value for this MsMs.
     * 
     * @return segHeartbeat
     */
    public java.math.BigDecimal getSegHeartbeat() {
        return segHeartbeat;
    }


    /**
     * Sets the segHeartbeat value for this MsMs.
     * 
     * @param segHeartbeat
     */
    public void setSegHeartbeat(java.math.BigDecimal segHeartbeat) {
        this.segHeartbeat = segHeartbeat;
    }


    /**
     * Gets the stAtivo value for this MsMs.
     * 
     * @return stAtivo
     */
    public java.math.BigDecimal getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this MsMs.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.math.BigDecimal stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpCalculoandon value for this MsMs.
     * 
     * @return tpCalculoandon
     */
    public java.lang.Integer getTpCalculoandon() {
        return tpCalculoandon;
    }


    /**
     * Sets the tpCalculoandon value for this MsMs.
     * 
     * @param tpCalculoandon
     */
    public void setTpCalculoandon(java.lang.Integer tpCalculoandon) {
        this.tpCalculoandon = tpCalculoandon;
    }


    /**
     * Gets the urlConexao value for this MsMs.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this MsMs.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsMs)) return false;
        MsMs other = (MsMs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdMs==null && other.getCdMs()==null) || 
             (this.cdMs!=null &&
              this.cdMs.equals(other.getCdMs()))) &&
            ((this.dsMs==null && other.getDsMs()==null) || 
             (this.dsMs!=null &&
              this.dsMs.equals(other.getDsMs()))) &&
            ((this.dthrHeartbeat==null && other.getDthrHeartbeat()==null) || 
             (this.dthrHeartbeat!=null &&
              this.dthrHeartbeat.equals(other.getDthrHeartbeat()))) &&
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            ((this.idMs==null && other.getIdMs()==null) || 
             (this.idMs!=null &&
              this.idMs.equals(other.getIdMs()))) &&
            ((this.isImportouTm==null && other.getIsImportouTm()==null) || 
             (this.isImportouTm!=null &&
              this.isImportouTm.equals(other.getIsImportouTm()))) &&
            ((this.msMsicups==null && other.getMsMsicups()==null) || 
             (this.msMsicups!=null &&
              java.util.Arrays.equals(this.msMsicups, other.getMsMsicups()))) &&
            ((this.msMsihms==null && other.getMsMsihms()==null) || 
             (this.msMsihms!=null &&
              java.util.Arrays.equals(this.msMsihms, other.getMsMsihms()))) &&
            ((this.msUsr==null && other.getMsUsr()==null) || 
             (this.msUsr!=null &&
              this.msUsr.equals(other.getMsUsr()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.segHeartbeat==null && other.getSegHeartbeat()==null) || 
             (this.segHeartbeat!=null &&
              this.segHeartbeat.equals(other.getSegHeartbeat()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpCalculoandon==null && other.getTpCalculoandon()==null) || 
             (this.tpCalculoandon!=null &&
              this.tpCalculoandon.equals(other.getTpCalculoandon()))) &&
            ((this.urlConexao==null && other.getUrlConexao()==null) || 
             (this.urlConexao!=null &&
              this.urlConexao.equals(other.getUrlConexao())));
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
        if (getCdMs() != null) {
            _hashCode += getCdMs().hashCode();
        }
        if (getDsMs() != null) {
            _hashCode += getDsMs().hashCode();
        }
        if (getDthrHeartbeat() != null) {
            _hashCode += getDthrHeartbeat().hashCode();
        }
        if (getDthrRevisao() != null) {
            _hashCode += getDthrRevisao().hashCode();
        }
        if (getDthrStativo() != null) {
            _hashCode += getDthrStativo().hashCode();
        }
        if (getIdMs() != null) {
            _hashCode += getIdMs().hashCode();
        }
        if (getIsImportouTm() != null) {
            _hashCode += getIsImportouTm().hashCode();
        }
        if (getMsMsicups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsMsicups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsMsicups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsMsihms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsMsihms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsMsihms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsUsr() != null) {
            _hashCode += getMsUsr().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSegHeartbeat() != null) {
            _hashCode += getSegHeartbeat().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpCalculoandon() != null) {
            _hashCode += getTpCalculoandon().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsMs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrHeartbeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrHeartbeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isImportouTm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isImportouTm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msMsicups");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msMsicups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMsicup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msMsihms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msMsihms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMsihm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segHeartbeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segHeartbeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpCalculoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpCalculoandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlConexao"));
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
