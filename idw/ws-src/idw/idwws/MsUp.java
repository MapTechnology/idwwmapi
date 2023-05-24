/**
 * MsUp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsUp  extends idw.idwws.MsUpTemplate  implements java.io.Serializable {
    private java.lang.String cdBc;

    private java.lang.String cdUp;

    private java.lang.String dsUp;

    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private java.math.BigDecimal idUp;

    private java.lang.String iduppdba;

    private org.apache.axis.types.UnsignedShort isLicenciada;

    private idw.idwws.MsEvt msEvtByIdEvtiniciociclo;

    private idw.idwws.MsEvt msEvtByIdEvtinicioparada;

    private idw.idwws.MsMsicup[] msMsicups;

    private idw.idwws.MsUpihm[] msUpihms;

    private idw.idwws.MsUsr msUsr;

    private java.lang.String nrop;

    private java.math.BigDecimal revisao;

    private java.lang.Integer sequencial;

    private java.math.BigDecimal stAtivo;

    private java.lang.Integer tpUp;

    public MsUp() {
    }

    public MsUp(
           java.lang.String cdBc,
           java.lang.String cdUp,
           java.lang.String dsUp,
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           java.math.BigDecimal idUp,
           java.lang.String iduppdba,
           org.apache.axis.types.UnsignedShort isLicenciada,
           idw.idwws.MsEvt msEvtByIdEvtiniciociclo,
           idw.idwws.MsEvt msEvtByIdEvtinicioparada,
           idw.idwws.MsMsicup[] msMsicups,
           idw.idwws.MsUpihm[] msUpihms,
           idw.idwws.MsUsr msUsr,
           java.lang.String nrop,
           java.math.BigDecimal revisao,
           java.lang.Integer sequencial,
           java.math.BigDecimal stAtivo,
           java.lang.Integer tpUp) {
        this.cdBc = cdBc;
        this.cdUp = cdUp;
        this.dsUp = dsUp;
        this.dthrRevisao = dthrRevisao;
        this.dthrStativo = dthrStativo;
        this.idUp = idUp;
        this.iduppdba = iduppdba;
        this.isLicenciada = isLicenciada;
        this.msEvtByIdEvtiniciociclo = msEvtByIdEvtiniciociclo;
        this.msEvtByIdEvtinicioparada = msEvtByIdEvtinicioparada;
        this.msMsicups = msMsicups;
        this.msUpihms = msUpihms;
        this.msUsr = msUsr;
        this.nrop = nrop;
        this.revisao = revisao;
        this.sequencial = sequencial;
        this.stAtivo = stAtivo;
        this.tpUp = tpUp;
    }


    /**
     * Gets the cdBc value for this MsUp.
     * 
     * @return cdBc
     */
    public java.lang.String getCdBc() {
        return cdBc;
    }


    /**
     * Sets the cdBc value for this MsUp.
     * 
     * @param cdBc
     */
    public void setCdBc(java.lang.String cdBc) {
        this.cdBc = cdBc;
    }


    /**
     * Gets the cdUp value for this MsUp.
     * 
     * @return cdUp
     */
    public java.lang.String getCdUp() {
        return cdUp;
    }


    /**
     * Sets the cdUp value for this MsUp.
     * 
     * @param cdUp
     */
    public void setCdUp(java.lang.String cdUp) {
        this.cdUp = cdUp;
    }


    /**
     * Gets the dsUp value for this MsUp.
     * 
     * @return dsUp
     */
    public java.lang.String getDsUp() {
        return dsUp;
    }


    /**
     * Sets the dsUp value for this MsUp.
     * 
     * @param dsUp
     */
    public void setDsUp(java.lang.String dsUp) {
        this.dsUp = dsUp;
    }


    /**
     * Gets the dthrRevisao value for this MsUp.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this MsUp.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this MsUp.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this MsUp.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the idUp value for this MsUp.
     * 
     * @return idUp
     */
    public java.math.BigDecimal getIdUp() {
        return idUp;
    }


    /**
     * Sets the idUp value for this MsUp.
     * 
     * @param idUp
     */
    public void setIdUp(java.math.BigDecimal idUp) {
        this.idUp = idUp;
    }


    /**
     * Gets the iduppdba value for this MsUp.
     * 
     * @return iduppdba
     */
    public java.lang.String getIduppdba() {
        return iduppdba;
    }


    /**
     * Sets the iduppdba value for this MsUp.
     * 
     * @param iduppdba
     */
    public void setIduppdba(java.lang.String iduppdba) {
        this.iduppdba = iduppdba;
    }


    /**
     * Gets the isLicenciada value for this MsUp.
     * 
     * @return isLicenciada
     */
    public org.apache.axis.types.UnsignedShort getIsLicenciada() {
        return isLicenciada;
    }


    /**
     * Sets the isLicenciada value for this MsUp.
     * 
     * @param isLicenciada
     */
    public void setIsLicenciada(org.apache.axis.types.UnsignedShort isLicenciada) {
        this.isLicenciada = isLicenciada;
    }


    /**
     * Gets the msEvtByIdEvtiniciociclo value for this MsUp.
     * 
     * @return msEvtByIdEvtiniciociclo
     */
    public idw.idwws.MsEvt getMsEvtByIdEvtiniciociclo() {
        return msEvtByIdEvtiniciociclo;
    }


    /**
     * Sets the msEvtByIdEvtiniciociclo value for this MsUp.
     * 
     * @param msEvtByIdEvtiniciociclo
     */
    public void setMsEvtByIdEvtiniciociclo(idw.idwws.MsEvt msEvtByIdEvtiniciociclo) {
        this.msEvtByIdEvtiniciociclo = msEvtByIdEvtiniciociclo;
    }


    /**
     * Gets the msEvtByIdEvtinicioparada value for this MsUp.
     * 
     * @return msEvtByIdEvtinicioparada
     */
    public idw.idwws.MsEvt getMsEvtByIdEvtinicioparada() {
        return msEvtByIdEvtinicioparada;
    }


    /**
     * Sets the msEvtByIdEvtinicioparada value for this MsUp.
     * 
     * @param msEvtByIdEvtinicioparada
     */
    public void setMsEvtByIdEvtinicioparada(idw.idwws.MsEvt msEvtByIdEvtinicioparada) {
        this.msEvtByIdEvtinicioparada = msEvtByIdEvtinicioparada;
    }


    /**
     * Gets the msMsicups value for this MsUp.
     * 
     * @return msMsicups
     */
    public idw.idwws.MsMsicup[] getMsMsicups() {
        return msMsicups;
    }


    /**
     * Sets the msMsicups value for this MsUp.
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
     * Gets the msUpihms value for this MsUp.
     * 
     * @return msUpihms
     */
    public idw.idwws.MsUpihm[] getMsUpihms() {
        return msUpihms;
    }


    /**
     * Sets the msUpihms value for this MsUp.
     * 
     * @param msUpihms
     */
    public void setMsUpihms(idw.idwws.MsUpihm[] msUpihms) {
        this.msUpihms = msUpihms;
    }

    public idw.idwws.MsUpihm getMsUpihms(int i) {
        return this.msUpihms[i];
    }

    public void setMsUpihms(int i, idw.idwws.MsUpihm _value) {
        this.msUpihms[i] = _value;
    }


    /**
     * Gets the msUsr value for this MsUp.
     * 
     * @return msUsr
     */
    public idw.idwws.MsUsr getMsUsr() {
        return msUsr;
    }


    /**
     * Sets the msUsr value for this MsUp.
     * 
     * @param msUsr
     */
    public void setMsUsr(idw.idwws.MsUsr msUsr) {
        this.msUsr = msUsr;
    }


    /**
     * Gets the nrop value for this MsUp.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this MsUp.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the revisao value for this MsUp.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this MsUp.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the sequencial value for this MsUp.
     * 
     * @return sequencial
     */
    public java.lang.Integer getSequencial() {
        return sequencial;
    }


    /**
     * Sets the sequencial value for this MsUp.
     * 
     * @param sequencial
     */
    public void setSequencial(java.lang.Integer sequencial) {
        this.sequencial = sequencial;
    }


    /**
     * Gets the stAtivo value for this MsUp.
     * 
     * @return stAtivo
     */
    public java.math.BigDecimal getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this MsUp.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.math.BigDecimal stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpUp value for this MsUp.
     * 
     * @return tpUp
     */
    public java.lang.Integer getTpUp() {
        return tpUp;
    }


    /**
     * Sets the tpUp value for this MsUp.
     * 
     * @param tpUp
     */
    public void setTpUp(java.lang.Integer tpUp) {
        this.tpUp = tpUp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsUp)) return false;
        MsUp other = (MsUp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdBc==null && other.getCdBc()==null) || 
             (this.cdBc!=null &&
              this.cdBc.equals(other.getCdBc()))) &&
            ((this.cdUp==null && other.getCdUp()==null) || 
             (this.cdUp!=null &&
              this.cdUp.equals(other.getCdUp()))) &&
            ((this.dsUp==null && other.getDsUp()==null) || 
             (this.dsUp!=null &&
              this.dsUp.equals(other.getDsUp()))) &&
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            ((this.idUp==null && other.getIdUp()==null) || 
             (this.idUp!=null &&
              this.idUp.equals(other.getIdUp()))) &&
            ((this.iduppdba==null && other.getIduppdba()==null) || 
             (this.iduppdba!=null &&
              this.iduppdba.equals(other.getIduppdba()))) &&
            ((this.isLicenciada==null && other.getIsLicenciada()==null) || 
             (this.isLicenciada!=null &&
              this.isLicenciada.equals(other.getIsLicenciada()))) &&
            ((this.msEvtByIdEvtiniciociclo==null && other.getMsEvtByIdEvtiniciociclo()==null) || 
             (this.msEvtByIdEvtiniciociclo!=null &&
              this.msEvtByIdEvtiniciociclo.equals(other.getMsEvtByIdEvtiniciociclo()))) &&
            ((this.msEvtByIdEvtinicioparada==null && other.getMsEvtByIdEvtinicioparada()==null) || 
             (this.msEvtByIdEvtinicioparada!=null &&
              this.msEvtByIdEvtinicioparada.equals(other.getMsEvtByIdEvtinicioparada()))) &&
            ((this.msMsicups==null && other.getMsMsicups()==null) || 
             (this.msMsicups!=null &&
              java.util.Arrays.equals(this.msMsicups, other.getMsMsicups()))) &&
            ((this.msUpihms==null && other.getMsUpihms()==null) || 
             (this.msUpihms!=null &&
              java.util.Arrays.equals(this.msUpihms, other.getMsUpihms()))) &&
            ((this.msUsr==null && other.getMsUsr()==null) || 
             (this.msUsr!=null &&
              this.msUsr.equals(other.getMsUsr()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.sequencial==null && other.getSequencial()==null) || 
             (this.sequencial!=null &&
              this.sequencial.equals(other.getSequencial()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpUp==null && other.getTpUp()==null) || 
             (this.tpUp!=null &&
              this.tpUp.equals(other.getTpUp())));
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
        if (getCdBc() != null) {
            _hashCode += getCdBc().hashCode();
        }
        if (getCdUp() != null) {
            _hashCode += getCdUp().hashCode();
        }
        if (getDsUp() != null) {
            _hashCode += getDsUp().hashCode();
        }
        if (getDthrRevisao() != null) {
            _hashCode += getDthrRevisao().hashCode();
        }
        if (getDthrStativo() != null) {
            _hashCode += getDthrStativo().hashCode();
        }
        if (getIdUp() != null) {
            _hashCode += getIdUp().hashCode();
        }
        if (getIduppdba() != null) {
            _hashCode += getIduppdba().hashCode();
        }
        if (getIsLicenciada() != null) {
            _hashCode += getIsLicenciada().hashCode();
        }
        if (getMsEvtByIdEvtiniciociclo() != null) {
            _hashCode += getMsEvtByIdEvtiniciociclo().hashCode();
        }
        if (getMsEvtByIdEvtinicioparada() != null) {
            _hashCode += getMsEvtByIdEvtinicioparada().hashCode();
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
        if (getMsUpihms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsUpihms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsUpihms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsUsr() != null) {
            _hashCode += getMsUsr().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSequencial() != null) {
            _hashCode += getSequencial().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpUp() != null) {
            _hashCode += getTpUp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsUp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdBc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdBc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsUp"));
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
        elemField.setFieldName("idUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iduppdba");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iduppdba"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLicenciada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isLicenciada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msEvtByIdEvtiniciociclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msEvtByIdEvtiniciociclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msEvtByIdEvtinicioparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msEvtByIdEvtinicioparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
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
        elemField.setFieldName("msUpihms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUpihms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUpihm"));
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
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("sequencial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("tpUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
