/**
 * MsDetector.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsDetector  extends idw.idwws.MsDetectorTemplate  implements java.io.Serializable {
    private java.lang.String cdDetector;

    private java.lang.String dsDetector;

    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private java.lang.Long idDetector;

    private java.lang.Boolean isEmail;

    private java.lang.Boolean isSms;

    private idw.idwws.MsDetectorusr[] msDetectorusrs;

    private idw.idwws.MsTrigger[] msTriggers;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.OmUsrgrp omUsrgrp;

    private java.math.BigDecimal revisao;

    private java.math.BigDecimal stAtivo;

    public MsDetector() {
    }

    public MsDetector(
           java.lang.String cdDetector,
           java.lang.String dsDetector,
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           java.lang.Long idDetector,
           java.lang.Boolean isEmail,
           java.lang.Boolean isSms,
           idw.idwws.MsDetectorusr[] msDetectorusrs,
           idw.idwws.MsTrigger[] msTriggers,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.OmUsrgrp omUsrgrp,
           java.math.BigDecimal revisao,
           java.math.BigDecimal stAtivo) {
        this.cdDetector = cdDetector;
        this.dsDetector = dsDetector;
        this.dthrRevisao = dthrRevisao;
        this.dthrStativo = dthrStativo;
        this.idDetector = idDetector;
        this.isEmail = isEmail;
        this.isSms = isSms;
        this.msDetectorusrs = msDetectorusrs;
        this.msTriggers = msTriggers;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.omUsrgrp = omUsrgrp;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdDetector value for this MsDetector.
     * 
     * @return cdDetector
     */
    public java.lang.String getCdDetector() {
        return cdDetector;
    }


    /**
     * Sets the cdDetector value for this MsDetector.
     * 
     * @param cdDetector
     */
    public void setCdDetector(java.lang.String cdDetector) {
        this.cdDetector = cdDetector;
    }


    /**
     * Gets the dsDetector value for this MsDetector.
     * 
     * @return dsDetector
     */
    public java.lang.String getDsDetector() {
        return dsDetector;
    }


    /**
     * Sets the dsDetector value for this MsDetector.
     * 
     * @param dsDetector
     */
    public void setDsDetector(java.lang.String dsDetector) {
        this.dsDetector = dsDetector;
    }


    /**
     * Gets the dthrRevisao value for this MsDetector.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this MsDetector.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this MsDetector.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this MsDetector.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the idDetector value for this MsDetector.
     * 
     * @return idDetector
     */
    public java.lang.Long getIdDetector() {
        return idDetector;
    }


    /**
     * Sets the idDetector value for this MsDetector.
     * 
     * @param idDetector
     */
    public void setIdDetector(java.lang.Long idDetector) {
        this.idDetector = idDetector;
    }


    /**
     * Gets the isEmail value for this MsDetector.
     * 
     * @return isEmail
     */
    public java.lang.Boolean getIsEmail() {
        return isEmail;
    }


    /**
     * Sets the isEmail value for this MsDetector.
     * 
     * @param isEmail
     */
    public void setIsEmail(java.lang.Boolean isEmail) {
        this.isEmail = isEmail;
    }


    /**
     * Gets the isSms value for this MsDetector.
     * 
     * @return isSms
     */
    public java.lang.Boolean getIsSms() {
        return isSms;
    }


    /**
     * Sets the isSms value for this MsDetector.
     * 
     * @param isSms
     */
    public void setIsSms(java.lang.Boolean isSms) {
        this.isSms = isSms;
    }


    /**
     * Gets the msDetectorusrs value for this MsDetector.
     * 
     * @return msDetectorusrs
     */
    public idw.idwws.MsDetectorusr[] getMsDetectorusrs() {
        return msDetectorusrs;
    }


    /**
     * Sets the msDetectorusrs value for this MsDetector.
     * 
     * @param msDetectorusrs
     */
    public void setMsDetectorusrs(idw.idwws.MsDetectorusr[] msDetectorusrs) {
        this.msDetectorusrs = msDetectorusrs;
    }

    public idw.idwws.MsDetectorusr getMsDetectorusrs(int i) {
        return this.msDetectorusrs[i];
    }

    public void setMsDetectorusrs(int i, idw.idwws.MsDetectorusr _value) {
        this.msDetectorusrs[i] = _value;
    }


    /**
     * Gets the msTriggers value for this MsDetector.
     * 
     * @return msTriggers
     */
    public idw.idwws.MsTrigger[] getMsTriggers() {
        return msTriggers;
    }


    /**
     * Sets the msTriggers value for this MsDetector.
     * 
     * @param msTriggers
     */
    public void setMsTriggers(idw.idwws.MsTrigger[] msTriggers) {
        this.msTriggers = msTriggers;
    }

    public idw.idwws.MsTrigger getMsTriggers(int i) {
        return this.msTriggers[i];
    }

    public void setMsTriggers(int i, idw.idwws.MsTrigger _value) {
        this.msTriggers[i] = _value;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this MsDetector.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this MsDetector.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this MsDetector.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this MsDetector.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the omUsrgrp value for this MsDetector.
     * 
     * @return omUsrgrp
     */
    public idw.idwws.OmUsrgrp getOmUsrgrp() {
        return omUsrgrp;
    }


    /**
     * Sets the omUsrgrp value for this MsDetector.
     * 
     * @param omUsrgrp
     */
    public void setOmUsrgrp(idw.idwws.OmUsrgrp omUsrgrp) {
        this.omUsrgrp = omUsrgrp;
    }


    /**
     * Gets the revisao value for this MsDetector.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this MsDetector.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this MsDetector.
     * 
     * @return stAtivo
     */
    public java.math.BigDecimal getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this MsDetector.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.math.BigDecimal stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsDetector)) return false;
        MsDetector other = (MsDetector) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdDetector==null && other.getCdDetector()==null) || 
             (this.cdDetector!=null &&
              this.cdDetector.equals(other.getCdDetector()))) &&
            ((this.dsDetector==null && other.getDsDetector()==null) || 
             (this.dsDetector!=null &&
              this.dsDetector.equals(other.getDsDetector()))) &&
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            ((this.idDetector==null && other.getIdDetector()==null) || 
             (this.idDetector!=null &&
              this.idDetector.equals(other.getIdDetector()))) &&
            ((this.isEmail==null && other.getIsEmail()==null) || 
             (this.isEmail!=null &&
              this.isEmail.equals(other.getIsEmail()))) &&
            ((this.isSms==null && other.getIsSms()==null) || 
             (this.isSms!=null &&
              this.isSms.equals(other.getIsSms()))) &&
            ((this.msDetectorusrs==null && other.getMsDetectorusrs()==null) || 
             (this.msDetectorusrs!=null &&
              java.util.Arrays.equals(this.msDetectorusrs, other.getMsDetectorusrs()))) &&
            ((this.msTriggers==null && other.getMsTriggers()==null) || 
             (this.msTriggers!=null &&
              java.util.Arrays.equals(this.msTriggers, other.getMsTriggers()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.omUsrgrp==null && other.getOmUsrgrp()==null) || 
             (this.omUsrgrp!=null &&
              this.omUsrgrp.equals(other.getOmUsrgrp()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo())));
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
        if (getCdDetector() != null) {
            _hashCode += getCdDetector().hashCode();
        }
        if (getDsDetector() != null) {
            _hashCode += getDsDetector().hashCode();
        }
        if (getDthrRevisao() != null) {
            _hashCode += getDthrRevisao().hashCode();
        }
        if (getDthrStativo() != null) {
            _hashCode += getDthrStativo().hashCode();
        }
        if (getIdDetector() != null) {
            _hashCode += getIdDetector().hashCode();
        }
        if (getIsEmail() != null) {
            _hashCode += getIsEmail().hashCode();
        }
        if (getIsSms() != null) {
            _hashCode += getIsSms().hashCode();
        }
        if (getMsDetectorusrs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsDetectorusrs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsDetectorusrs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsTriggers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsTriggers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsTriggers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getOmUsrgrp() != null) {
            _hashCode += getOmUsrgrp().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsDetector.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msDetector"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdDetector");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdDetector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsDetector");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsDetector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("idDetector");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idDetector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDetectorusrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDetectorusrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msDetectorusr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msTriggers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msTriggers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msTrigger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrgrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrgrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsrgrp"));
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
