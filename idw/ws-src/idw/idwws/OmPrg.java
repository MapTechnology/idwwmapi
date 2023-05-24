/**
 * OmPrg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmPrg  extends idw.idwws.OmPrgTemplate  implements java.io.Serializable {
    private java.lang.String cdPrg;

    private java.lang.String dsPrg;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwFolhaiac[] dwFolhaiacs;

    private long idPrg;

    private java.lang.Integer isConformeestruturaproduto;

    private idw.idwws.OmMapa[] omMapas;

    private idw.idwws.OmPrgpos[] omPrgposes;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmPt omPt;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmPrg() {
    }

    public OmPrg(
           java.lang.String cdPrg,
           java.lang.String dsPrg,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwFolhaiac[] dwFolhaiacs,
           long idPrg,
           java.lang.Integer isConformeestruturaproduto,
           idw.idwws.OmMapa[] omMapas,
           idw.idwws.OmPrgpos[] omPrgposes,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        this.cdPrg = cdPrg;
        this.dsPrg = dsPrg;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwFolhaiacs = dwFolhaiacs;
        this.idPrg = idPrg;
        this.isConformeestruturaproduto = isConformeestruturaproduto;
        this.omMapas = omMapas;
        this.omPrgposes = omPrgposes;
        this.omProduto = omProduto;
        this.omPt = omPt;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdPrg value for this OmPrg.
     * 
     * @return cdPrg
     */
    public java.lang.String getCdPrg() {
        return cdPrg;
    }


    /**
     * Sets the cdPrg value for this OmPrg.
     * 
     * @param cdPrg
     */
    public void setCdPrg(java.lang.String cdPrg) {
        this.cdPrg = cdPrg;
    }


    /**
     * Gets the dsPrg value for this OmPrg.
     * 
     * @return dsPrg
     */
    public java.lang.String getDsPrg() {
        return dsPrg;
    }


    /**
     * Sets the dsPrg value for this OmPrg.
     * 
     * @param dsPrg
     */
    public void setDsPrg(java.lang.String dsPrg) {
        this.dsPrg = dsPrg;
    }


    /**
     * Gets the dtRevisao value for this OmPrg.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmPrg.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmPrg.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmPrg.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwFolhaiacs value for this OmPrg.
     * 
     * @return dwFolhaiacs
     */
    public idw.idwws.DwFolhaiac[] getDwFolhaiacs() {
        return dwFolhaiacs;
    }


    /**
     * Sets the dwFolhaiacs value for this OmPrg.
     * 
     * @param dwFolhaiacs
     */
    public void setDwFolhaiacs(idw.idwws.DwFolhaiac[] dwFolhaiacs) {
        this.dwFolhaiacs = dwFolhaiacs;
    }

    public idw.idwws.DwFolhaiac getDwFolhaiacs(int i) {
        return this.dwFolhaiacs[i];
    }

    public void setDwFolhaiacs(int i, idw.idwws.DwFolhaiac _value) {
        this.dwFolhaiacs[i] = _value;
    }


    /**
     * Gets the idPrg value for this OmPrg.
     * 
     * @return idPrg
     */
    public long getIdPrg() {
        return idPrg;
    }


    /**
     * Sets the idPrg value for this OmPrg.
     * 
     * @param idPrg
     */
    public void setIdPrg(long idPrg) {
        this.idPrg = idPrg;
    }


    /**
     * Gets the isConformeestruturaproduto value for this OmPrg.
     * 
     * @return isConformeestruturaproduto
     */
    public java.lang.Integer getIsConformeestruturaproduto() {
        return isConformeestruturaproduto;
    }


    /**
     * Sets the isConformeestruturaproduto value for this OmPrg.
     * 
     * @param isConformeestruturaproduto
     */
    public void setIsConformeestruturaproduto(java.lang.Integer isConformeestruturaproduto) {
        this.isConformeestruturaproduto = isConformeestruturaproduto;
    }


    /**
     * Gets the omMapas value for this OmPrg.
     * 
     * @return omMapas
     */
    public idw.idwws.OmMapa[] getOmMapas() {
        return omMapas;
    }


    /**
     * Sets the omMapas value for this OmPrg.
     * 
     * @param omMapas
     */
    public void setOmMapas(idw.idwws.OmMapa[] omMapas) {
        this.omMapas = omMapas;
    }

    public idw.idwws.OmMapa getOmMapas(int i) {
        return this.omMapas[i];
    }

    public void setOmMapas(int i, idw.idwws.OmMapa _value) {
        this.omMapas[i] = _value;
    }


    /**
     * Gets the omPrgposes value for this OmPrg.
     * 
     * @return omPrgposes
     */
    public idw.idwws.OmPrgpos[] getOmPrgposes() {
        return omPrgposes;
    }


    /**
     * Sets the omPrgposes value for this OmPrg.
     * 
     * @param omPrgposes
     */
    public void setOmPrgposes(idw.idwws.OmPrgpos[] omPrgposes) {
        this.omPrgposes = omPrgposes;
    }

    public idw.idwws.OmPrgpos getOmPrgposes(int i) {
        return this.omPrgposes[i];
    }

    public void setOmPrgposes(int i, idw.idwws.OmPrgpos _value) {
        this.omPrgposes[i] = _value;
    }


    /**
     * Gets the omProduto value for this OmPrg.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmPrg.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omPt value for this OmPrg.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmPrg.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the revisao value for this OmPrg.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmPrg.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmPrg.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmPrg.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmPrg)) return false;
        OmPrg other = (OmPrg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdPrg==null && other.getCdPrg()==null) || 
             (this.cdPrg!=null &&
              this.cdPrg.equals(other.getCdPrg()))) &&
            ((this.dsPrg==null && other.getDsPrg()==null) || 
             (this.dsPrg!=null &&
              this.dsPrg.equals(other.getDsPrg()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwFolhaiacs==null && other.getDwFolhaiacs()==null) || 
             (this.dwFolhaiacs!=null &&
              java.util.Arrays.equals(this.dwFolhaiacs, other.getDwFolhaiacs()))) &&
            this.idPrg == other.getIdPrg() &&
            ((this.isConformeestruturaproduto==null && other.getIsConformeestruturaproduto()==null) || 
             (this.isConformeestruturaproduto!=null &&
              this.isConformeestruturaproduto.equals(other.getIsConformeestruturaproduto()))) &&
            ((this.omMapas==null && other.getOmMapas()==null) || 
             (this.omMapas!=null &&
              java.util.Arrays.equals(this.omMapas, other.getOmMapas()))) &&
            ((this.omPrgposes==null && other.getOmPrgposes()==null) || 
             (this.omPrgposes!=null &&
              java.util.Arrays.equals(this.omPrgposes, other.getOmPrgposes()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
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
        if (getCdPrg() != null) {
            _hashCode += getCdPrg().hashCode();
        }
        if (getDsPrg() != null) {
            _hashCode += getDsPrg().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwFolhaiacs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhaiacs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhaiacs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdPrg()).hashCode();
        if (getIsConformeestruturaproduto() != null) {
            _hashCode += getIsConformeestruturaproduto().hashCode();
        }
        if (getOmMapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmMapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmMapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPrgposes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPrgposes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPrgposes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
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
        new org.apache.axis.description.TypeDesc(OmPrg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdPrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdPrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPrg"));
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
        elemField.setFieldName("dwFolhaiacs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhaiacs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhaiac"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConformeestruturaproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConformeestruturaproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPrgposes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPrgposes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrgpos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
