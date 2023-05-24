/**
 * OmTpgt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmTpgt  extends idw.idwws.OmTpgtTemplate  implements java.io.Serializable {
    private java.lang.String cdTpgt;

    private java.lang.String dsTpgt;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idTpgt;

    private idw.idwws.OmCfg[] omCfgsForIdTpgtFabrica;

    private idw.idwws.OmCfg[] omCfgsForIdTpgtlogsuper;

    private idw.idwws.OmGt[] omGts;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmTpgt() {
    }

    public OmTpgt(
           java.lang.String cdTpgt,
           java.lang.String dsTpgt,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idTpgt,
           idw.idwws.OmCfg[] omCfgsForIdTpgtFabrica,
           idw.idwws.OmCfg[] omCfgsForIdTpgtlogsuper,
           idw.idwws.OmGt[] omGts,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        this.cdTpgt = cdTpgt;
        this.dsTpgt = dsTpgt;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idTpgt = idTpgt;
        this.omCfgsForIdTpgtFabrica = omCfgsForIdTpgtFabrica;
        this.omCfgsForIdTpgtlogsuper = omCfgsForIdTpgtlogsuper;
        this.omGts = omGts;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTpgt value for this OmTpgt.
     * 
     * @return cdTpgt
     */
    public java.lang.String getCdTpgt() {
        return cdTpgt;
    }


    /**
     * Sets the cdTpgt value for this OmTpgt.
     * 
     * @param cdTpgt
     */
    public void setCdTpgt(java.lang.String cdTpgt) {
        this.cdTpgt = cdTpgt;
    }


    /**
     * Gets the dsTpgt value for this OmTpgt.
     * 
     * @return dsTpgt
     */
    public java.lang.String getDsTpgt() {
        return dsTpgt;
    }


    /**
     * Sets the dsTpgt value for this OmTpgt.
     * 
     * @param dsTpgt
     */
    public void setDsTpgt(java.lang.String dsTpgt) {
        this.dsTpgt = dsTpgt;
    }


    /**
     * Gets the dtRevisao value for this OmTpgt.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmTpgt.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmTpgt.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmTpgt.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idTpgt value for this OmTpgt.
     * 
     * @return idTpgt
     */
    public long getIdTpgt() {
        return idTpgt;
    }


    /**
     * Sets the idTpgt value for this OmTpgt.
     * 
     * @param idTpgt
     */
    public void setIdTpgt(long idTpgt) {
        this.idTpgt = idTpgt;
    }


    /**
     * Gets the omCfgsForIdTpgtFabrica value for this OmTpgt.
     * 
     * @return omCfgsForIdTpgtFabrica
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpgtFabrica() {
        return omCfgsForIdTpgtFabrica;
    }


    /**
     * Sets the omCfgsForIdTpgtFabrica value for this OmTpgt.
     * 
     * @param omCfgsForIdTpgtFabrica
     */
    public void setOmCfgsForIdTpgtFabrica(idw.idwws.OmCfg[] omCfgsForIdTpgtFabrica) {
        this.omCfgsForIdTpgtFabrica = omCfgsForIdTpgtFabrica;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpgtFabrica(int i) {
        return this.omCfgsForIdTpgtFabrica[i];
    }

    public void setOmCfgsForIdTpgtFabrica(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpgtFabrica[i] = _value;
    }


    /**
     * Gets the omCfgsForIdTpgtlogsuper value for this OmTpgt.
     * 
     * @return omCfgsForIdTpgtlogsuper
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpgtlogsuper() {
        return omCfgsForIdTpgtlogsuper;
    }


    /**
     * Sets the omCfgsForIdTpgtlogsuper value for this OmTpgt.
     * 
     * @param omCfgsForIdTpgtlogsuper
     */
    public void setOmCfgsForIdTpgtlogsuper(idw.idwws.OmCfg[] omCfgsForIdTpgtlogsuper) {
        this.omCfgsForIdTpgtlogsuper = omCfgsForIdTpgtlogsuper;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpgtlogsuper(int i) {
        return this.omCfgsForIdTpgtlogsuper[i];
    }

    public void setOmCfgsForIdTpgtlogsuper(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpgtlogsuper[i] = _value;
    }


    /**
     * Gets the omGts value for this OmTpgt.
     * 
     * @return omGts
     */
    public idw.idwws.OmGt[] getOmGts() {
        return omGts;
    }


    /**
     * Sets the omGts value for this OmTpgt.
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
     * Gets the omUsrByIdUsrrevisao value for this OmTpgt.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmTpgt.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmTpgt.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmTpgt.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this OmTpgt.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmTpgt.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmTpgt.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmTpgt.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmTpgt)) return false;
        OmTpgt other = (OmTpgt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTpgt==null && other.getCdTpgt()==null) || 
             (this.cdTpgt!=null &&
              this.cdTpgt.equals(other.getCdTpgt()))) &&
            ((this.dsTpgt==null && other.getDsTpgt()==null) || 
             (this.dsTpgt!=null &&
              this.dsTpgt.equals(other.getDsTpgt()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idTpgt == other.getIdTpgt() &&
            ((this.omCfgsForIdTpgtFabrica==null && other.getOmCfgsForIdTpgtFabrica()==null) || 
             (this.omCfgsForIdTpgtFabrica!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpgtFabrica, other.getOmCfgsForIdTpgtFabrica()))) &&
            ((this.omCfgsForIdTpgtlogsuper==null && other.getOmCfgsForIdTpgtlogsuper()==null) || 
             (this.omCfgsForIdTpgtlogsuper!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpgtlogsuper, other.getOmCfgsForIdTpgtlogsuper()))) &&
            ((this.omGts==null && other.getOmGts()==null) || 
             (this.omGts!=null &&
              java.util.Arrays.equals(this.omGts, other.getOmGts()))) &&
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
        if (getCdTpgt() != null) {
            _hashCode += getCdTpgt().hashCode();
        }
        if (getDsTpgt() != null) {
            _hashCode += getDsTpgt().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdTpgt()).hashCode();
        if (getOmCfgsForIdTpgtFabrica() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpgtFabrica());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpgtFabrica(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdTpgtlogsuper() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpgtlogsuper());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpgtlogsuper(), i);
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
        new org.apache.axis.description.TypeDesc(OmTpgt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTpgt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTpgt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTpgt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTpgt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTpgt"));
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
        elemField.setFieldName("idTpgt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTpgt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpgtFabrica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpgtFabrica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpgtlogsuper");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpgtlogsuper"));
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
