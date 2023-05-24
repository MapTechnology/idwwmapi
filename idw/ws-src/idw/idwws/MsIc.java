/**
 * MsIc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsIc  extends idw.idwws.MsIcTemplate  implements java.io.Serializable {
    private java.lang.String cdIc;

    private java.lang.String dsIc;

    private java.util.Calendar dthrHeartbeat;

    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private java.lang.String firmware;

    private java.math.BigDecimal idIc;

    private idw.idwws.MsMsicup[] msMsicups;

    private idw.idwws.MsUsr msUsr;

    private java.math.BigDecimal revisao;

    private java.math.BigDecimal stAtivo;

    private java.math.BigDecimal tpIc;

    private java.lang.String urlConexao;

    public MsIc() {
    }

    public MsIc(
           java.lang.String cdIc,
           java.lang.String dsIc,
           java.util.Calendar dthrHeartbeat,
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           java.lang.String firmware,
           java.math.BigDecimal idIc,
           idw.idwws.MsMsicup[] msMsicups,
           idw.idwws.MsUsr msUsr,
           java.math.BigDecimal revisao,
           java.math.BigDecimal stAtivo,
           java.math.BigDecimal tpIc,
           java.lang.String urlConexao) {
        this.cdIc = cdIc;
        this.dsIc = dsIc;
        this.dthrHeartbeat = dthrHeartbeat;
        this.dthrRevisao = dthrRevisao;
        this.dthrStativo = dthrStativo;
        this.firmware = firmware;
        this.idIc = idIc;
        this.msMsicups = msMsicups;
        this.msUsr = msUsr;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.tpIc = tpIc;
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the cdIc value for this MsIc.
     * 
     * @return cdIc
     */
    public java.lang.String getCdIc() {
        return cdIc;
    }


    /**
     * Sets the cdIc value for this MsIc.
     * 
     * @param cdIc
     */
    public void setCdIc(java.lang.String cdIc) {
        this.cdIc = cdIc;
    }


    /**
     * Gets the dsIc value for this MsIc.
     * 
     * @return dsIc
     */
    public java.lang.String getDsIc() {
        return dsIc;
    }


    /**
     * Sets the dsIc value for this MsIc.
     * 
     * @param dsIc
     */
    public void setDsIc(java.lang.String dsIc) {
        this.dsIc = dsIc;
    }


    /**
     * Gets the dthrHeartbeat value for this MsIc.
     * 
     * @return dthrHeartbeat
     */
    public java.util.Calendar getDthrHeartbeat() {
        return dthrHeartbeat;
    }


    /**
     * Sets the dthrHeartbeat value for this MsIc.
     * 
     * @param dthrHeartbeat
     */
    public void setDthrHeartbeat(java.util.Calendar dthrHeartbeat) {
        this.dthrHeartbeat = dthrHeartbeat;
    }


    /**
     * Gets the dthrRevisao value for this MsIc.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this MsIc.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this MsIc.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this MsIc.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the firmware value for this MsIc.
     * 
     * @return firmware
     */
    public java.lang.String getFirmware() {
        return firmware;
    }


    /**
     * Sets the firmware value for this MsIc.
     * 
     * @param firmware
     */
    public void setFirmware(java.lang.String firmware) {
        this.firmware = firmware;
    }


    /**
     * Gets the idIc value for this MsIc.
     * 
     * @return idIc
     */
    public java.math.BigDecimal getIdIc() {
        return idIc;
    }


    /**
     * Sets the idIc value for this MsIc.
     * 
     * @param idIc
     */
    public void setIdIc(java.math.BigDecimal idIc) {
        this.idIc = idIc;
    }


    /**
     * Gets the msMsicups value for this MsIc.
     * 
     * @return msMsicups
     */
    public idw.idwws.MsMsicup[] getMsMsicups() {
        return msMsicups;
    }


    /**
     * Sets the msMsicups value for this MsIc.
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
     * Gets the msUsr value for this MsIc.
     * 
     * @return msUsr
     */
    public idw.idwws.MsUsr getMsUsr() {
        return msUsr;
    }


    /**
     * Sets the msUsr value for this MsIc.
     * 
     * @param msUsr
     */
    public void setMsUsr(idw.idwws.MsUsr msUsr) {
        this.msUsr = msUsr;
    }


    /**
     * Gets the revisao value for this MsIc.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this MsIc.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this MsIc.
     * 
     * @return stAtivo
     */
    public java.math.BigDecimal getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this MsIc.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.math.BigDecimal stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpIc value for this MsIc.
     * 
     * @return tpIc
     */
    public java.math.BigDecimal getTpIc() {
        return tpIc;
    }


    /**
     * Sets the tpIc value for this MsIc.
     * 
     * @param tpIc
     */
    public void setTpIc(java.math.BigDecimal tpIc) {
        this.tpIc = tpIc;
    }


    /**
     * Gets the urlConexao value for this MsIc.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this MsIc.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsIc)) return false;
        MsIc other = (MsIc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdIc==null && other.getCdIc()==null) || 
             (this.cdIc!=null &&
              this.cdIc.equals(other.getCdIc()))) &&
            ((this.dsIc==null && other.getDsIc()==null) || 
             (this.dsIc!=null &&
              this.dsIc.equals(other.getDsIc()))) &&
            ((this.dthrHeartbeat==null && other.getDthrHeartbeat()==null) || 
             (this.dthrHeartbeat!=null &&
              this.dthrHeartbeat.equals(other.getDthrHeartbeat()))) &&
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            ((this.firmware==null && other.getFirmware()==null) || 
             (this.firmware!=null &&
              this.firmware.equals(other.getFirmware()))) &&
            ((this.idIc==null && other.getIdIc()==null) || 
             (this.idIc!=null &&
              this.idIc.equals(other.getIdIc()))) &&
            ((this.msMsicups==null && other.getMsMsicups()==null) || 
             (this.msMsicups!=null &&
              java.util.Arrays.equals(this.msMsicups, other.getMsMsicups()))) &&
            ((this.msUsr==null && other.getMsUsr()==null) || 
             (this.msUsr!=null &&
              this.msUsr.equals(other.getMsUsr()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpIc==null && other.getTpIc()==null) || 
             (this.tpIc!=null &&
              this.tpIc.equals(other.getTpIc()))) &&
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
        if (getCdIc() != null) {
            _hashCode += getCdIc().hashCode();
        }
        if (getDsIc() != null) {
            _hashCode += getDsIc().hashCode();
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
        if (getFirmware() != null) {
            _hashCode += getFirmware().hashCode();
        }
        if (getIdIc() != null) {
            _hashCode += getIdIc().hashCode();
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
        if (getMsUsr() != null) {
            _hashCode += getMsUsr().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpIc() != null) {
            _hashCode += getTpIc().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsIc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msIc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdIc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdIc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsIc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsIc"));
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
        elemField.setFieldName("firmware");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firmware"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpIc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpIc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
