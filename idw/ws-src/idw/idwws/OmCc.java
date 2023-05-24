/**
 * OmCc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmCc  extends idw.idwws.OmCcTemplate  implements java.io.Serializable {
    private java.lang.String cdCc;

    private java.lang.String dsCc;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idCc;

    private idw.idwws.OmCfg[] omCfgs;

    private idw.idwws.OmGt[] omGts;

    private idw.idwws.OmProduto[] omProdutos;

    private idw.idwws.OmPt[] omPts;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.OmUsr[] omUsrs;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmCc() {
    }

    public OmCc(
           java.lang.Long id,
           java.lang.String cdCc,
           java.lang.String dsCc,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idCc,
           idw.idwws.OmCfg[] omCfgs,
           idw.idwws.OmGt[] omGts,
           idw.idwws.OmProduto[] omProdutos,
           idw.idwws.OmPt[] omPts,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.OmUsr[] omUsrs,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdCc = cdCc;
        this.dsCc = dsCc;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idCc = idCc;
        this.omCfgs = omCfgs;
        this.omGts = omGts;
        this.omProdutos = omProdutos;
        this.omPts = omPts;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.omUsrs = omUsrs;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdCc value for this OmCc.
     * 
     * @return cdCc
     */
    public java.lang.String getCdCc() {
        return cdCc;
    }


    /**
     * Sets the cdCc value for this OmCc.
     * 
     * @param cdCc
     */
    public void setCdCc(java.lang.String cdCc) {
        this.cdCc = cdCc;
    }


    /**
     * Gets the dsCc value for this OmCc.
     * 
     * @return dsCc
     */
    public java.lang.String getDsCc() {
        return dsCc;
    }


    /**
     * Sets the dsCc value for this OmCc.
     * 
     * @param dsCc
     */
    public void setDsCc(java.lang.String dsCc) {
        this.dsCc = dsCc;
    }


    /**
     * Gets the dtRevisao value for this OmCc.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmCc.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmCc.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmCc.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idCc value for this OmCc.
     * 
     * @return idCc
     */
    public long getIdCc() {
        return idCc;
    }


    /**
     * Sets the idCc value for this OmCc.
     * 
     * @param idCc
     */
    public void setIdCc(long idCc) {
        this.idCc = idCc;
    }


    /**
     * Gets the omCfgs value for this OmCc.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this OmCc.
     * 
     * @param omCfgs
     */
    public void setOmCfgs(idw.idwws.OmCfg[] omCfgs) {
        this.omCfgs = omCfgs;
    }

    public idw.idwws.OmCfg getOmCfgs(int i) {
        return this.omCfgs[i];
    }

    public void setOmCfgs(int i, idw.idwws.OmCfg _value) {
        this.omCfgs[i] = _value;
    }


    /**
     * Gets the omGts value for this OmCc.
     * 
     * @return omGts
     */
    public idw.idwws.OmGt[] getOmGts() {
        return omGts;
    }


    /**
     * Sets the omGts value for this OmCc.
     * 
     * @param omGts
     */
    public void setOmGts(idw.idwws.OmGt[] omGts) {
        this.omGts = omGts;
    }

    public idw.idwws.OmGt getOmGts(int i) {
        return this.omGts[i];
    }

    public void setOmGts(int i, idw.idwws.OmGt _value) {
        this.omGts[i] = _value;
    }


    /**
     * Gets the omProdutos value for this OmCc.
     * 
     * @return omProdutos
     */
    public idw.idwws.OmProduto[] getOmProdutos() {
        return omProdutos;
    }


    /**
     * Sets the omProdutos value for this OmCc.
     * 
     * @param omProdutos
     */
    public void setOmProdutos(idw.idwws.OmProduto[] omProdutos) {
        this.omProdutos = omProdutos;
    }

    public idw.idwws.OmProduto getOmProdutos(int i) {
        return this.omProdutos[i];
    }

    public void setOmProdutos(int i, idw.idwws.OmProduto _value) {
        this.omProdutos[i] = _value;
    }


    /**
     * Gets the omPts value for this OmCc.
     * 
     * @return omPts
     */
    public idw.idwws.OmPt[] getOmPts() {
        return omPts;
    }


    /**
     * Sets the omPts value for this OmCc.
     * 
     * @param omPts
     */
    public void setOmPts(idw.idwws.OmPt[] omPts) {
        this.omPts = omPts;
    }

    public idw.idwws.OmPt getOmPts(int i) {
        return this.omPts[i];
    }

    public void setOmPts(int i, idw.idwws.OmPt _value) {
        this.omPts[i] = _value;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmCc.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmCc.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmCc.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmCc.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the omUsrs value for this OmCc.
     * 
     * @return omUsrs
     */
    public idw.idwws.OmUsr[] getOmUsrs() {
        return omUsrs;
    }


    /**
     * Sets the omUsrs value for this OmCc.
     * 
     * @param omUsrs
     */
    public void setOmUsrs(idw.idwws.OmUsr[] omUsrs) {
        this.omUsrs = omUsrs;
    }

    public idw.idwws.OmUsr getOmUsrs(int i) {
        return this.omUsrs[i];
    }

    public void setOmUsrs(int i, idw.idwws.OmUsr _value) {
        this.omUsrs[i] = _value;
    }


    /**
     * Gets the revisao value for this OmCc.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmCc.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmCc.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmCc.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmCc)) return false;
        OmCc other = (OmCc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdCc==null && other.getCdCc()==null) || 
             (this.cdCc!=null &&
              this.cdCc.equals(other.getCdCc()))) &&
            ((this.dsCc==null && other.getDsCc()==null) || 
             (this.dsCc!=null &&
              this.dsCc.equals(other.getDsCc()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idCc == other.getIdCc() &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.omGts==null && other.getOmGts()==null) || 
             (this.omGts!=null &&
              java.util.Arrays.equals(this.omGts, other.getOmGts()))) &&
            ((this.omProdutos==null && other.getOmProdutos()==null) || 
             (this.omProdutos!=null &&
              java.util.Arrays.equals(this.omProdutos, other.getOmProdutos()))) &&
            ((this.omPts==null && other.getOmPts()==null) || 
             (this.omPts!=null &&
              java.util.Arrays.equals(this.omPts, other.getOmPts()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.omUsrs==null && other.getOmUsrs()==null) || 
             (this.omUsrs!=null &&
              java.util.Arrays.equals(this.omUsrs, other.getOmUsrs()))) &&
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
        if (getCdCc() != null) {
            _hashCode += getCdCc().hashCode();
        }
        if (getDsCc() != null) {
            _hashCode += getDsCc().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdCc()).hashCode();
        if (getOmCfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmGts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPts(), i);
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
        if (getOmUsrs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmUsrs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmUsrs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(OmCc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdCc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdCc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
        elemField.setFieldName("omUsrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
