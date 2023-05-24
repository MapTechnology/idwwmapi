/**
 * DwCal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwCal  extends idw.idwws.DwCalTemplate  implements java.io.Serializable {
    private java.lang.String cdCal;

    private java.lang.String dsCal;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.util.Calendar dthrFvalidade;

    private java.util.Calendar dthrIvalidade;

    private idw.idwws.DwCalavu[] dwCalavus;

    private idw.idwws.DwCalpt[] dwCalpts;

    private idw.idwws.DwCalsem[] dwCalsems;

    private idw.idwws.DwConsolid[] dwConsolids;

    private long idCal;

    private idw.idwws.OmCfg[] omCfgs;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwCal() {
    }

    public DwCal(
           java.lang.Long id,
           java.lang.String cdCal,
           java.lang.String dsCal,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.util.Calendar dthrFvalidade,
           java.util.Calendar dthrIvalidade,
           idw.idwws.DwCalavu[] dwCalavus,
           idw.idwws.DwCalpt[] dwCalpts,
           idw.idwws.DwCalsem[] dwCalsems,
           idw.idwws.DwConsolid[] dwConsolids,
           long idCal,
           idw.idwws.OmCfg[] omCfgs,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdCal = cdCal;
        this.dsCal = dsCal;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dthrFvalidade = dthrFvalidade;
        this.dthrIvalidade = dthrIvalidade;
        this.dwCalavus = dwCalavus;
        this.dwCalpts = dwCalpts;
        this.dwCalsems = dwCalsems;
        this.dwConsolids = dwConsolids;
        this.idCal = idCal;
        this.omCfgs = omCfgs;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdCal value for this DwCal.
     * 
     * @return cdCal
     */
    public java.lang.String getCdCal() {
        return cdCal;
    }


    /**
     * Sets the cdCal value for this DwCal.
     * 
     * @param cdCal
     */
    public void setCdCal(java.lang.String cdCal) {
        this.cdCal = cdCal;
    }


    /**
     * Gets the dsCal value for this DwCal.
     * 
     * @return dsCal
     */
    public java.lang.String getDsCal() {
        return dsCal;
    }


    /**
     * Sets the dsCal value for this DwCal.
     * 
     * @param dsCal
     */
    public void setDsCal(java.lang.String dsCal) {
        this.dsCal = dsCal;
    }


    /**
     * Gets the dtRevisao value for this DwCal.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwCal.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwCal.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwCal.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dthrFvalidade value for this DwCal.
     * 
     * @return dthrFvalidade
     */
    public java.util.Calendar getDthrFvalidade() {
        return dthrFvalidade;
    }


    /**
     * Sets the dthrFvalidade value for this DwCal.
     * 
     * @param dthrFvalidade
     */
    public void setDthrFvalidade(java.util.Calendar dthrFvalidade) {
        this.dthrFvalidade = dthrFvalidade;
    }


    /**
     * Gets the dthrIvalidade value for this DwCal.
     * 
     * @return dthrIvalidade
     */
    public java.util.Calendar getDthrIvalidade() {
        return dthrIvalidade;
    }


    /**
     * Sets the dthrIvalidade value for this DwCal.
     * 
     * @param dthrIvalidade
     */
    public void setDthrIvalidade(java.util.Calendar dthrIvalidade) {
        this.dthrIvalidade = dthrIvalidade;
    }


    /**
     * Gets the dwCalavus value for this DwCal.
     * 
     * @return dwCalavus
     */
    public idw.idwws.DwCalavu[] getDwCalavus() {
        return dwCalavus;
    }


    /**
     * Sets the dwCalavus value for this DwCal.
     * 
     * @param dwCalavus
     */
    public void setDwCalavus(idw.idwws.DwCalavu[] dwCalavus) {
        this.dwCalavus = dwCalavus;
    }

    public idw.idwws.DwCalavu getDwCalavus(int i) {
        return this.dwCalavus[i];
    }

    public void setDwCalavus(int i, idw.idwws.DwCalavu _value) {
        this.dwCalavus[i] = _value;
    }


    /**
     * Gets the dwCalpts value for this DwCal.
     * 
     * @return dwCalpts
     */
    public idw.idwws.DwCalpt[] getDwCalpts() {
        return dwCalpts;
    }


    /**
     * Sets the dwCalpts value for this DwCal.
     * 
     * @param dwCalpts
     */
    public void setDwCalpts(idw.idwws.DwCalpt[] dwCalpts) {
        this.dwCalpts = dwCalpts;
    }

    public idw.idwws.DwCalpt getDwCalpts(int i) {
        return this.dwCalpts[i];
    }

    public void setDwCalpts(int i, idw.idwws.DwCalpt _value) {
        this.dwCalpts[i] = _value;
    }


    /**
     * Gets the dwCalsems value for this DwCal.
     * 
     * @return dwCalsems
     */
    public idw.idwws.DwCalsem[] getDwCalsems() {
        return dwCalsems;
    }


    /**
     * Sets the dwCalsems value for this DwCal.
     * 
     * @param dwCalsems
     */
    public void setDwCalsems(idw.idwws.DwCalsem[] dwCalsems) {
        this.dwCalsems = dwCalsems;
    }

    public idw.idwws.DwCalsem getDwCalsems(int i) {
        return this.dwCalsems[i];
    }

    public void setDwCalsems(int i, idw.idwws.DwCalsem _value) {
        this.dwCalsems[i] = _value;
    }


    /**
     * Gets the dwConsolids value for this DwCal.
     * 
     * @return dwConsolids
     */
    public idw.idwws.DwConsolid[] getDwConsolids() {
        return dwConsolids;
    }


    /**
     * Sets the dwConsolids value for this DwCal.
     * 
     * @param dwConsolids
     */
    public void setDwConsolids(idw.idwws.DwConsolid[] dwConsolids) {
        this.dwConsolids = dwConsolids;
    }

    public idw.idwws.DwConsolid getDwConsolids(int i) {
        return this.dwConsolids[i];
    }

    public void setDwConsolids(int i, idw.idwws.DwConsolid _value) {
        this.dwConsolids[i] = _value;
    }


    /**
     * Gets the idCal value for this DwCal.
     * 
     * @return idCal
     */
    public long getIdCal() {
        return idCal;
    }


    /**
     * Sets the idCal value for this DwCal.
     * 
     * @param idCal
     */
    public void setIdCal(long idCal) {
        this.idCal = idCal;
    }


    /**
     * Gets the omCfgs value for this DwCal.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this DwCal.
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
     * Gets the omUsrByIdUsrrevisao value for this DwCal.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwCal.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwCal.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwCal.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwCal.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwCal.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwCal.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwCal.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwCal)) return false;
        DwCal other = (DwCal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdCal==null && other.getCdCal()==null) || 
             (this.cdCal!=null &&
              this.cdCal.equals(other.getCdCal()))) &&
            ((this.dsCal==null && other.getDsCal()==null) || 
             (this.dsCal!=null &&
              this.dsCal.equals(other.getDsCal()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dthrFvalidade==null && other.getDthrFvalidade()==null) || 
             (this.dthrFvalidade!=null &&
              this.dthrFvalidade.equals(other.getDthrFvalidade()))) &&
            ((this.dthrIvalidade==null && other.getDthrIvalidade()==null) || 
             (this.dthrIvalidade!=null &&
              this.dthrIvalidade.equals(other.getDthrIvalidade()))) &&
            ((this.dwCalavus==null && other.getDwCalavus()==null) || 
             (this.dwCalavus!=null &&
              java.util.Arrays.equals(this.dwCalavus, other.getDwCalavus()))) &&
            ((this.dwCalpts==null && other.getDwCalpts()==null) || 
             (this.dwCalpts!=null &&
              java.util.Arrays.equals(this.dwCalpts, other.getDwCalpts()))) &&
            ((this.dwCalsems==null && other.getDwCalsems()==null) || 
             (this.dwCalsems!=null &&
              java.util.Arrays.equals(this.dwCalsems, other.getDwCalsems()))) &&
            ((this.dwConsolids==null && other.getDwConsolids()==null) || 
             (this.dwConsolids!=null &&
              java.util.Arrays.equals(this.dwConsolids, other.getDwConsolids()))) &&
            this.idCal == other.getIdCal() &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
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
        if (getCdCal() != null) {
            _hashCode += getCdCal().hashCode();
        }
        if (getDsCal() != null) {
            _hashCode += getDsCal().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDthrFvalidade() != null) {
            _hashCode += getDthrFvalidade().hashCode();
        }
        if (getDthrIvalidade() != null) {
            _hashCode += getDthrIvalidade().hashCode();
        }
        if (getDwCalavus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalavus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalavus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwCalpts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalpts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalpts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwCalsems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalsems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalsems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdCal()).hashCode();
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
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
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
        new org.apache.axis.description.TypeDesc(DwCal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCal"));
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
        elemField.setFieldName("dthrFvalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFvalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIvalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIvalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalavus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalavus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalavu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalpts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalpts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalsems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalsems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalsem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCal"));
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
