/**
 * MsIhm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsIhm  extends idw.idwws.MsIhmTemplate  implements java.io.Serializable {
    private java.lang.String cdIhm;

    private java.util.Calendar dthrCadastro;

    private java.util.Calendar dthrHeartbeat;

    private java.math.BigDecimal idIhm;

    private java.lang.Boolean isEvtalerta;

    private java.lang.Boolean isEvtciclofechado;

    private java.lang.Boolean isEvtlogin;

    private java.lang.Boolean isEvtparada;

    private java.lang.Boolean isEvtpnd;

    private java.lang.Boolean isEvtrefugo;

    private java.lang.Boolean isEvttodos;

    private java.lang.Boolean isEvttrabalhando;

    private java.lang.Boolean isUpreg;

    private idw.idwws.MsMsihm[] msMsihms;

    private idw.idwws.MsUpihm[] msUpihms;

    private idw.idwws.MsUsr msUsr;

    private java.lang.String urlConexao;

    private java.lang.String urlConexaoalt;

    private java.lang.String urlIp;

    public MsIhm() {
    }

    public MsIhm(
           java.lang.String cdIhm,
           java.util.Calendar dthrCadastro,
           java.util.Calendar dthrHeartbeat,
           java.math.BigDecimal idIhm,
           java.lang.Boolean isEvtalerta,
           java.lang.Boolean isEvtciclofechado,
           java.lang.Boolean isEvtlogin,
           java.lang.Boolean isEvtparada,
           java.lang.Boolean isEvtpnd,
           java.lang.Boolean isEvtrefugo,
           java.lang.Boolean isEvttodos,
           java.lang.Boolean isEvttrabalhando,
           java.lang.Boolean isUpreg,
           idw.idwws.MsMsihm[] msMsihms,
           idw.idwws.MsUpihm[] msUpihms,
           idw.idwws.MsUsr msUsr,
           java.lang.String urlConexao,
           java.lang.String urlConexaoalt,
           java.lang.String urlIp) {
        this.cdIhm = cdIhm;
        this.dthrCadastro = dthrCadastro;
        this.dthrHeartbeat = dthrHeartbeat;
        this.idIhm = idIhm;
        this.isEvtalerta = isEvtalerta;
        this.isEvtciclofechado = isEvtciclofechado;
        this.isEvtlogin = isEvtlogin;
        this.isEvtparada = isEvtparada;
        this.isEvtpnd = isEvtpnd;
        this.isEvtrefugo = isEvtrefugo;
        this.isEvttodos = isEvttodos;
        this.isEvttrabalhando = isEvttrabalhando;
        this.isUpreg = isUpreg;
        this.msMsihms = msMsihms;
        this.msUpihms = msUpihms;
        this.msUsr = msUsr;
        this.urlConexao = urlConexao;
        this.urlConexaoalt = urlConexaoalt;
        this.urlIp = urlIp;
    }


    /**
     * Gets the cdIhm value for this MsIhm.
     * 
     * @return cdIhm
     */
    public java.lang.String getCdIhm() {
        return cdIhm;
    }


    /**
     * Sets the cdIhm value for this MsIhm.
     * 
     * @param cdIhm
     */
    public void setCdIhm(java.lang.String cdIhm) {
        this.cdIhm = cdIhm;
    }


    /**
     * Gets the dthrCadastro value for this MsIhm.
     * 
     * @return dthrCadastro
     */
    public java.util.Calendar getDthrCadastro() {
        return dthrCadastro;
    }


    /**
     * Sets the dthrCadastro value for this MsIhm.
     * 
     * @param dthrCadastro
     */
    public void setDthrCadastro(java.util.Calendar dthrCadastro) {
        this.dthrCadastro = dthrCadastro;
    }


    /**
     * Gets the dthrHeartbeat value for this MsIhm.
     * 
     * @return dthrHeartbeat
     */
    public java.util.Calendar getDthrHeartbeat() {
        return dthrHeartbeat;
    }


    /**
     * Sets the dthrHeartbeat value for this MsIhm.
     * 
     * @param dthrHeartbeat
     */
    public void setDthrHeartbeat(java.util.Calendar dthrHeartbeat) {
        this.dthrHeartbeat = dthrHeartbeat;
    }


    /**
     * Gets the idIhm value for this MsIhm.
     * 
     * @return idIhm
     */
    public java.math.BigDecimal getIdIhm() {
        return idIhm;
    }


    /**
     * Sets the idIhm value for this MsIhm.
     * 
     * @param idIhm
     */
    public void setIdIhm(java.math.BigDecimal idIhm) {
        this.idIhm = idIhm;
    }


    /**
     * Gets the isEvtalerta value for this MsIhm.
     * 
     * @return isEvtalerta
     */
    public java.lang.Boolean getIsEvtalerta() {
        return isEvtalerta;
    }


    /**
     * Sets the isEvtalerta value for this MsIhm.
     * 
     * @param isEvtalerta
     */
    public void setIsEvtalerta(java.lang.Boolean isEvtalerta) {
        this.isEvtalerta = isEvtalerta;
    }


    /**
     * Gets the isEvtciclofechado value for this MsIhm.
     * 
     * @return isEvtciclofechado
     */
    public java.lang.Boolean getIsEvtciclofechado() {
        return isEvtciclofechado;
    }


    /**
     * Sets the isEvtciclofechado value for this MsIhm.
     * 
     * @param isEvtciclofechado
     */
    public void setIsEvtciclofechado(java.lang.Boolean isEvtciclofechado) {
        this.isEvtciclofechado = isEvtciclofechado;
    }


    /**
     * Gets the isEvtlogin value for this MsIhm.
     * 
     * @return isEvtlogin
     */
    public java.lang.Boolean getIsEvtlogin() {
        return isEvtlogin;
    }


    /**
     * Sets the isEvtlogin value for this MsIhm.
     * 
     * @param isEvtlogin
     */
    public void setIsEvtlogin(java.lang.Boolean isEvtlogin) {
        this.isEvtlogin = isEvtlogin;
    }


    /**
     * Gets the isEvtparada value for this MsIhm.
     * 
     * @return isEvtparada
     */
    public java.lang.Boolean getIsEvtparada() {
        return isEvtparada;
    }


    /**
     * Sets the isEvtparada value for this MsIhm.
     * 
     * @param isEvtparada
     */
    public void setIsEvtparada(java.lang.Boolean isEvtparada) {
        this.isEvtparada = isEvtparada;
    }


    /**
     * Gets the isEvtpnd value for this MsIhm.
     * 
     * @return isEvtpnd
     */
    public java.lang.Boolean getIsEvtpnd() {
        return isEvtpnd;
    }


    /**
     * Sets the isEvtpnd value for this MsIhm.
     * 
     * @param isEvtpnd
     */
    public void setIsEvtpnd(java.lang.Boolean isEvtpnd) {
        this.isEvtpnd = isEvtpnd;
    }


    /**
     * Gets the isEvtrefugo value for this MsIhm.
     * 
     * @return isEvtrefugo
     */
    public java.lang.Boolean getIsEvtrefugo() {
        return isEvtrefugo;
    }


    /**
     * Sets the isEvtrefugo value for this MsIhm.
     * 
     * @param isEvtrefugo
     */
    public void setIsEvtrefugo(java.lang.Boolean isEvtrefugo) {
        this.isEvtrefugo = isEvtrefugo;
    }


    /**
     * Gets the isEvttodos value for this MsIhm.
     * 
     * @return isEvttodos
     */
    public java.lang.Boolean getIsEvttodos() {
        return isEvttodos;
    }


    /**
     * Sets the isEvttodos value for this MsIhm.
     * 
     * @param isEvttodos
     */
    public void setIsEvttodos(java.lang.Boolean isEvttodos) {
        this.isEvttodos = isEvttodos;
    }


    /**
     * Gets the isEvttrabalhando value for this MsIhm.
     * 
     * @return isEvttrabalhando
     */
    public java.lang.Boolean getIsEvttrabalhando() {
        return isEvttrabalhando;
    }


    /**
     * Sets the isEvttrabalhando value for this MsIhm.
     * 
     * @param isEvttrabalhando
     */
    public void setIsEvttrabalhando(java.lang.Boolean isEvttrabalhando) {
        this.isEvttrabalhando = isEvttrabalhando;
    }


    /**
     * Gets the isUpreg value for this MsIhm.
     * 
     * @return isUpreg
     */
    public java.lang.Boolean getIsUpreg() {
        return isUpreg;
    }


    /**
     * Sets the isUpreg value for this MsIhm.
     * 
     * @param isUpreg
     */
    public void setIsUpreg(java.lang.Boolean isUpreg) {
        this.isUpreg = isUpreg;
    }


    /**
     * Gets the msMsihms value for this MsIhm.
     * 
     * @return msMsihms
     */
    public idw.idwws.MsMsihm[] getMsMsihms() {
        return msMsihms;
    }


    /**
     * Sets the msMsihms value for this MsIhm.
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
     * Gets the msUpihms value for this MsIhm.
     * 
     * @return msUpihms
     */
    public idw.idwws.MsUpihm[] getMsUpihms() {
        return msUpihms;
    }


    /**
     * Sets the msUpihms value for this MsIhm.
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
     * Gets the msUsr value for this MsIhm.
     * 
     * @return msUsr
     */
    public idw.idwws.MsUsr getMsUsr() {
        return msUsr;
    }


    /**
     * Sets the msUsr value for this MsIhm.
     * 
     * @param msUsr
     */
    public void setMsUsr(idw.idwws.MsUsr msUsr) {
        this.msUsr = msUsr;
    }


    /**
     * Gets the urlConexao value for this MsIhm.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this MsIhm.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the urlConexaoalt value for this MsIhm.
     * 
     * @return urlConexaoalt
     */
    public java.lang.String getUrlConexaoalt() {
        return urlConexaoalt;
    }


    /**
     * Sets the urlConexaoalt value for this MsIhm.
     * 
     * @param urlConexaoalt
     */
    public void setUrlConexaoalt(java.lang.String urlConexaoalt) {
        this.urlConexaoalt = urlConexaoalt;
    }


    /**
     * Gets the urlIp value for this MsIhm.
     * 
     * @return urlIp
     */
    public java.lang.String getUrlIp() {
        return urlIp;
    }


    /**
     * Sets the urlIp value for this MsIhm.
     * 
     * @param urlIp
     */
    public void setUrlIp(java.lang.String urlIp) {
        this.urlIp = urlIp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsIhm)) return false;
        MsIhm other = (MsIhm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdIhm==null && other.getCdIhm()==null) || 
             (this.cdIhm!=null &&
              this.cdIhm.equals(other.getCdIhm()))) &&
            ((this.dthrCadastro==null && other.getDthrCadastro()==null) || 
             (this.dthrCadastro!=null &&
              this.dthrCadastro.equals(other.getDthrCadastro()))) &&
            ((this.dthrHeartbeat==null && other.getDthrHeartbeat()==null) || 
             (this.dthrHeartbeat!=null &&
              this.dthrHeartbeat.equals(other.getDthrHeartbeat()))) &&
            ((this.idIhm==null && other.getIdIhm()==null) || 
             (this.idIhm!=null &&
              this.idIhm.equals(other.getIdIhm()))) &&
            ((this.isEvtalerta==null && other.getIsEvtalerta()==null) || 
             (this.isEvtalerta!=null &&
              this.isEvtalerta.equals(other.getIsEvtalerta()))) &&
            ((this.isEvtciclofechado==null && other.getIsEvtciclofechado()==null) || 
             (this.isEvtciclofechado!=null &&
              this.isEvtciclofechado.equals(other.getIsEvtciclofechado()))) &&
            ((this.isEvtlogin==null && other.getIsEvtlogin()==null) || 
             (this.isEvtlogin!=null &&
              this.isEvtlogin.equals(other.getIsEvtlogin()))) &&
            ((this.isEvtparada==null && other.getIsEvtparada()==null) || 
             (this.isEvtparada!=null &&
              this.isEvtparada.equals(other.getIsEvtparada()))) &&
            ((this.isEvtpnd==null && other.getIsEvtpnd()==null) || 
             (this.isEvtpnd!=null &&
              this.isEvtpnd.equals(other.getIsEvtpnd()))) &&
            ((this.isEvtrefugo==null && other.getIsEvtrefugo()==null) || 
             (this.isEvtrefugo!=null &&
              this.isEvtrefugo.equals(other.getIsEvtrefugo()))) &&
            ((this.isEvttodos==null && other.getIsEvttodos()==null) || 
             (this.isEvttodos!=null &&
              this.isEvttodos.equals(other.getIsEvttodos()))) &&
            ((this.isEvttrabalhando==null && other.getIsEvttrabalhando()==null) || 
             (this.isEvttrabalhando!=null &&
              this.isEvttrabalhando.equals(other.getIsEvttrabalhando()))) &&
            ((this.isUpreg==null && other.getIsUpreg()==null) || 
             (this.isUpreg!=null &&
              this.isUpreg.equals(other.getIsUpreg()))) &&
            ((this.msMsihms==null && other.getMsMsihms()==null) || 
             (this.msMsihms!=null &&
              java.util.Arrays.equals(this.msMsihms, other.getMsMsihms()))) &&
            ((this.msUpihms==null && other.getMsUpihms()==null) || 
             (this.msUpihms!=null &&
              java.util.Arrays.equals(this.msUpihms, other.getMsUpihms()))) &&
            ((this.msUsr==null && other.getMsUsr()==null) || 
             (this.msUsr!=null &&
              this.msUsr.equals(other.getMsUsr()))) &&
            ((this.urlConexao==null && other.getUrlConexao()==null) || 
             (this.urlConexao!=null &&
              this.urlConexao.equals(other.getUrlConexao()))) &&
            ((this.urlConexaoalt==null && other.getUrlConexaoalt()==null) || 
             (this.urlConexaoalt!=null &&
              this.urlConexaoalt.equals(other.getUrlConexaoalt()))) &&
            ((this.urlIp==null && other.getUrlIp()==null) || 
             (this.urlIp!=null &&
              this.urlIp.equals(other.getUrlIp())));
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
        if (getCdIhm() != null) {
            _hashCode += getCdIhm().hashCode();
        }
        if (getDthrCadastro() != null) {
            _hashCode += getDthrCadastro().hashCode();
        }
        if (getDthrHeartbeat() != null) {
            _hashCode += getDthrHeartbeat().hashCode();
        }
        if (getIdIhm() != null) {
            _hashCode += getIdIhm().hashCode();
        }
        if (getIsEvtalerta() != null) {
            _hashCode += getIsEvtalerta().hashCode();
        }
        if (getIsEvtciclofechado() != null) {
            _hashCode += getIsEvtciclofechado().hashCode();
        }
        if (getIsEvtlogin() != null) {
            _hashCode += getIsEvtlogin().hashCode();
        }
        if (getIsEvtparada() != null) {
            _hashCode += getIsEvtparada().hashCode();
        }
        if (getIsEvtpnd() != null) {
            _hashCode += getIsEvtpnd().hashCode();
        }
        if (getIsEvtrefugo() != null) {
            _hashCode += getIsEvtrefugo().hashCode();
        }
        if (getIsEvttodos() != null) {
            _hashCode += getIsEvttodos().hashCode();
        }
        if (getIsEvttrabalhando() != null) {
            _hashCode += getIsEvttrabalhando().hashCode();
        }
        if (getIsUpreg() != null) {
            _hashCode += getIsUpreg().hashCode();
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
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        if (getUrlConexaoalt() != null) {
            _hashCode += getUrlConexaoalt().hashCode();
        }
        if (getUrlIp() != null) {
            _hashCode += getUrlIp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsIhm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msIhm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdIhm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdIhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("idIhm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtciclofechado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtciclofechado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtpnd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtpnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvtrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvtrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvttodos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvttodos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEvttrabalhando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEvttrabalhando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isUpreg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isUpreg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("urlConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlConexaoalt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlConexaoalt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlIp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlIp"));
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
