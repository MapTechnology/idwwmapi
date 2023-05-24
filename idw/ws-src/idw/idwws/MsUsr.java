/**
 * MsUsr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsUsr  extends idw.idwws.MsUsrTemplate  implements java.io.Serializable {
    private java.lang.String cdUsr;

    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private java.math.BigDecimal idUsr;

    private java.lang.String login;

    private idw.idwws.MsCfg[] msCfgs;

    private idw.idwws.MsDetectorusr[] msDetectorusrs;

    private idw.idwws.MsIc[] msIcs;

    private idw.idwws.MsIhm[] msIhms;

    private idw.idwws.MsMs[] msMses;

    private idw.idwws.MsUp[] msUps;

    private java.lang.String nmUsr;

    private java.math.BigDecimal revisao;

    private java.lang.String senha;

    private java.math.BigDecimal stAtivo;

    public MsUsr() {
    }

    public MsUsr(
           java.lang.String cdUsr,
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           java.math.BigDecimal idUsr,
           java.lang.String login,
           idw.idwws.MsCfg[] msCfgs,
           idw.idwws.MsDetectorusr[] msDetectorusrs,
           idw.idwws.MsIc[] msIcs,
           idw.idwws.MsIhm[] msIhms,
           idw.idwws.MsMs[] msMses,
           idw.idwws.MsUp[] msUps,
           java.lang.String nmUsr,
           java.math.BigDecimal revisao,
           java.lang.String senha,
           java.math.BigDecimal stAtivo) {
        this.cdUsr = cdUsr;
        this.dthrRevisao = dthrRevisao;
        this.dthrStativo = dthrStativo;
        this.idUsr = idUsr;
        this.login = login;
        this.msCfgs = msCfgs;
        this.msDetectorusrs = msDetectorusrs;
        this.msIcs = msIcs;
        this.msIhms = msIhms;
        this.msMses = msMses;
        this.msUps = msUps;
        this.nmUsr = nmUsr;
        this.revisao = revisao;
        this.senha = senha;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdUsr value for this MsUsr.
     * 
     * @return cdUsr
     */
    public java.lang.String getCdUsr() {
        return cdUsr;
    }


    /**
     * Sets the cdUsr value for this MsUsr.
     * 
     * @param cdUsr
     */
    public void setCdUsr(java.lang.String cdUsr) {
        this.cdUsr = cdUsr;
    }


    /**
     * Gets the dthrRevisao value for this MsUsr.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this MsUsr.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this MsUsr.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this MsUsr.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the idUsr value for this MsUsr.
     * 
     * @return idUsr
     */
    public java.math.BigDecimal getIdUsr() {
        return idUsr;
    }


    /**
     * Sets the idUsr value for this MsUsr.
     * 
     * @param idUsr
     */
    public void setIdUsr(java.math.BigDecimal idUsr) {
        this.idUsr = idUsr;
    }


    /**
     * Gets the login value for this MsUsr.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this MsUsr.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the msCfgs value for this MsUsr.
     * 
     * @return msCfgs
     */
    public idw.idwws.MsCfg[] getMsCfgs() {
        return msCfgs;
    }


    /**
     * Sets the msCfgs value for this MsUsr.
     * 
     * @param msCfgs
     */
    public void setMsCfgs(idw.idwws.MsCfg[] msCfgs) {
        this.msCfgs = msCfgs;
    }

    public idw.idwws.MsCfg getMsCfgs(int i) {
        return this.msCfgs[i];
    }

    public void setMsCfgs(int i, idw.idwws.MsCfg _value) {
        this.msCfgs[i] = _value;
    }


    /**
     * Gets the msDetectorusrs value for this MsUsr.
     * 
     * @return msDetectorusrs
     */
    public idw.idwws.MsDetectorusr[] getMsDetectorusrs() {
        return msDetectorusrs;
    }


    /**
     * Sets the msDetectorusrs value for this MsUsr.
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
     * Gets the msIcs value for this MsUsr.
     * 
     * @return msIcs
     */
    public idw.idwws.MsIc[] getMsIcs() {
        return msIcs;
    }


    /**
     * Sets the msIcs value for this MsUsr.
     * 
     * @param msIcs
     */
    public void setMsIcs(idw.idwws.MsIc[] msIcs) {
        this.msIcs = msIcs;
    }

    public idw.idwws.MsIc getMsIcs(int i) {
        return this.msIcs[i];
    }

    public void setMsIcs(int i, idw.idwws.MsIc _value) {
        this.msIcs[i] = _value;
    }


    /**
     * Gets the msIhms value for this MsUsr.
     * 
     * @return msIhms
     */
    public idw.idwws.MsIhm[] getMsIhms() {
        return msIhms;
    }


    /**
     * Sets the msIhms value for this MsUsr.
     * 
     * @param msIhms
     */
    public void setMsIhms(idw.idwws.MsIhm[] msIhms) {
        this.msIhms = msIhms;
    }

    public idw.idwws.MsIhm getMsIhms(int i) {
        return this.msIhms[i];
    }

    public void setMsIhms(int i, idw.idwws.MsIhm _value) {
        this.msIhms[i] = _value;
    }


    /**
     * Gets the msMses value for this MsUsr.
     * 
     * @return msMses
     */
    public idw.idwws.MsMs[] getMsMses() {
        return msMses;
    }


    /**
     * Sets the msMses value for this MsUsr.
     * 
     * @param msMses
     */
    public void setMsMses(idw.idwws.MsMs[] msMses) {
        this.msMses = msMses;
    }

    public idw.idwws.MsMs getMsMses(int i) {
        return this.msMses[i];
    }

    public void setMsMses(int i, idw.idwws.MsMs _value) {
        this.msMses[i] = _value;
    }


    /**
     * Gets the msUps value for this MsUsr.
     * 
     * @return msUps
     */
    public idw.idwws.MsUp[] getMsUps() {
        return msUps;
    }


    /**
     * Sets the msUps value for this MsUsr.
     * 
     * @param msUps
     */
    public void setMsUps(idw.idwws.MsUp[] msUps) {
        this.msUps = msUps;
    }

    public idw.idwws.MsUp getMsUps(int i) {
        return this.msUps[i];
    }

    public void setMsUps(int i, idw.idwws.MsUp _value) {
        this.msUps[i] = _value;
    }


    /**
     * Gets the nmUsr value for this MsUsr.
     * 
     * @return nmUsr
     */
    public java.lang.String getNmUsr() {
        return nmUsr;
    }


    /**
     * Sets the nmUsr value for this MsUsr.
     * 
     * @param nmUsr
     */
    public void setNmUsr(java.lang.String nmUsr) {
        this.nmUsr = nmUsr;
    }


    /**
     * Gets the revisao value for this MsUsr.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this MsUsr.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the senha value for this MsUsr.
     * 
     * @return senha
     */
    public java.lang.String getSenha() {
        return senha;
    }


    /**
     * Sets the senha value for this MsUsr.
     * 
     * @param senha
     */
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }


    /**
     * Gets the stAtivo value for this MsUsr.
     * 
     * @return stAtivo
     */
    public java.math.BigDecimal getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this MsUsr.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.math.BigDecimal stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsUsr)) return false;
        MsUsr other = (MsUsr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdUsr==null && other.getCdUsr()==null) || 
             (this.cdUsr!=null &&
              this.cdUsr.equals(other.getCdUsr()))) &&
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            ((this.idUsr==null && other.getIdUsr()==null) || 
             (this.idUsr!=null &&
              this.idUsr.equals(other.getIdUsr()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.msCfgs==null && other.getMsCfgs()==null) || 
             (this.msCfgs!=null &&
              java.util.Arrays.equals(this.msCfgs, other.getMsCfgs()))) &&
            ((this.msDetectorusrs==null && other.getMsDetectorusrs()==null) || 
             (this.msDetectorusrs!=null &&
              java.util.Arrays.equals(this.msDetectorusrs, other.getMsDetectorusrs()))) &&
            ((this.msIcs==null && other.getMsIcs()==null) || 
             (this.msIcs!=null &&
              java.util.Arrays.equals(this.msIcs, other.getMsIcs()))) &&
            ((this.msIhms==null && other.getMsIhms()==null) || 
             (this.msIhms!=null &&
              java.util.Arrays.equals(this.msIhms, other.getMsIhms()))) &&
            ((this.msMses==null && other.getMsMses()==null) || 
             (this.msMses!=null &&
              java.util.Arrays.equals(this.msMses, other.getMsMses()))) &&
            ((this.msUps==null && other.getMsUps()==null) || 
             (this.msUps!=null &&
              java.util.Arrays.equals(this.msUps, other.getMsUps()))) &&
            ((this.nmUsr==null && other.getNmUsr()==null) || 
             (this.nmUsr!=null &&
              this.nmUsr.equals(other.getNmUsr()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.senha==null && other.getSenha()==null) || 
             (this.senha!=null &&
              this.senha.equals(other.getSenha()))) &&
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
        if (getCdUsr() != null) {
            _hashCode += getCdUsr().hashCode();
        }
        if (getDthrRevisao() != null) {
            _hashCode += getDthrRevisao().hashCode();
        }
        if (getDthrStativo() != null) {
            _hashCode += getDthrStativo().hashCode();
        }
        if (getIdUsr() != null) {
            _hashCode += getIdUsr().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getMsCfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsCfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsCfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getMsIcs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsIcs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsIcs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsIhms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsIhms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsIhms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsMses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsMses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsMses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsUps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsUps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsUps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNmUsr() != null) {
            _hashCode += getNmUsr().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSenha() != null) {
            _hashCode += getSenha().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsUsr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUsr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdUsr"));
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
        elemField.setFieldName("idUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msCfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msCfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("msIcs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msIcs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msIc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msIhms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msIhms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msIhm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msMses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msMses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmUsr"));
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
        elemField.setFieldName("senha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
