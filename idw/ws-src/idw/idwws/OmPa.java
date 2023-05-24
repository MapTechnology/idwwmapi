/**
 * OmPa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmPa  extends idw.idwws.OmPaTemplate  implements java.io.Serializable {
    private java.lang.String cdPa;

    private java.lang.String depara;

    private java.lang.String desvio;

    private java.lang.String dsPa;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idPa;

    private idw.idwws.OmMapapa[] omMapapas;

    private idw.idwws.OmPapro[] omPapros;

    private idw.idwws.OmPrgpos[] omPrgposes;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Integer ordem;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmPa() {
    }

    public OmPa(
           java.lang.Long id,
           java.lang.String cdPa,
           java.lang.String depara,
           java.lang.String desvio,
           java.lang.String dsPa,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idPa,
           idw.idwws.OmMapapa[] omMapapas,
           idw.idwws.OmPapro[] omPapros,
           idw.idwws.OmPrgpos[] omPrgposes,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Integer ordem,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdPa = cdPa;
        this.depara = depara;
        this.desvio = desvio;
        this.dsPa = dsPa;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idPa = idPa;
        this.omMapapas = omMapapas;
        this.omPapros = omPapros;
        this.omPrgposes = omPrgposes;
        this.omPt = omPt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ordem = ordem;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdPa value for this OmPa.
     * 
     * @return cdPa
     */
    public java.lang.String getCdPa() {
        return cdPa;
    }


    /**
     * Sets the cdPa value for this OmPa.
     * 
     * @param cdPa
     */
    public void setCdPa(java.lang.String cdPa) {
        this.cdPa = cdPa;
    }


    /**
     * Gets the depara value for this OmPa.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this OmPa.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the desvio value for this OmPa.
     * 
     * @return desvio
     */
    public java.lang.String getDesvio() {
        return desvio;
    }


    /**
     * Sets the desvio value for this OmPa.
     * 
     * @param desvio
     */
    public void setDesvio(java.lang.String desvio) {
        this.desvio = desvio;
    }


    /**
     * Gets the dsPa value for this OmPa.
     * 
     * @return dsPa
     */
    public java.lang.String getDsPa() {
        return dsPa;
    }


    /**
     * Sets the dsPa value for this OmPa.
     * 
     * @param dsPa
     */
    public void setDsPa(java.lang.String dsPa) {
        this.dsPa = dsPa;
    }


    /**
     * Gets the dtRevisao value for this OmPa.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmPa.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmPa.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmPa.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idPa value for this OmPa.
     * 
     * @return idPa
     */
    public long getIdPa() {
        return idPa;
    }


    /**
     * Sets the idPa value for this OmPa.
     * 
     * @param idPa
     */
    public void setIdPa(long idPa) {
        this.idPa = idPa;
    }


    /**
     * Gets the omMapapas value for this OmPa.
     * 
     * @return omMapapas
     */
    public idw.idwws.OmMapapa[] getOmMapapas() {
        return omMapapas;
    }


    /**
     * Sets the omMapapas value for this OmPa.
     * 
     * @param omMapapas
     */
    public void setOmMapapas(idw.idwws.OmMapapa[] omMapapas) {
        this.omMapapas = omMapapas;
    }

    public idw.idwws.OmMapapa getOmMapapas(int i) {
        return this.omMapapas[i];
    }

    public void setOmMapapas(int i, idw.idwws.OmMapapa _value) {
        this.omMapapas[i] = _value;
    }


    /**
     * Gets the omPapros value for this OmPa.
     * 
     * @return omPapros
     */
    public idw.idwws.OmPapro[] getOmPapros() {
        return omPapros;
    }


    /**
     * Sets the omPapros value for this OmPa.
     * 
     * @param omPapros
     */
    public void setOmPapros(idw.idwws.OmPapro[] omPapros) {
        this.omPapros = omPapros;
    }

    public idw.idwws.OmPapro getOmPapros(int i) {
        return this.omPapros[i];
    }

    public void setOmPapros(int i, idw.idwws.OmPapro _value) {
        this.omPapros[i] = _value;
    }


    /**
     * Gets the omPrgposes value for this OmPa.
     * 
     * @return omPrgposes
     */
    public idw.idwws.OmPrgpos[] getOmPrgposes() {
        return omPrgposes;
    }


    /**
     * Sets the omPrgposes value for this OmPa.
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
     * Gets the omPt value for this OmPa.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmPa.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmPa.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmPa.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmPa.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmPa.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ordem value for this OmPa.
     * 
     * @return ordem
     */
    public java.lang.Integer getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this OmPa.
     * 
     * @param ordem
     */
    public void setOrdem(java.lang.Integer ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the revisao value for this OmPa.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmPa.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmPa.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmPa.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmPa)) return false;
        OmPa other = (OmPa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdPa==null && other.getCdPa()==null) || 
             (this.cdPa!=null &&
              this.cdPa.equals(other.getCdPa()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.desvio==null && other.getDesvio()==null) || 
             (this.desvio!=null &&
              this.desvio.equals(other.getDesvio()))) &&
            ((this.dsPa==null && other.getDsPa()==null) || 
             (this.dsPa!=null &&
              this.dsPa.equals(other.getDsPa()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idPa == other.getIdPa() &&
            ((this.omMapapas==null && other.getOmMapapas()==null) || 
             (this.omMapapas!=null &&
              java.util.Arrays.equals(this.omMapapas, other.getOmMapapas()))) &&
            ((this.omPapros==null && other.getOmPapros()==null) || 
             (this.omPapros!=null &&
              java.util.Arrays.equals(this.omPapros, other.getOmPapros()))) &&
            ((this.omPrgposes==null && other.getOmPrgposes()==null) || 
             (this.omPrgposes!=null &&
              java.util.Arrays.equals(this.omPrgposes, other.getOmPrgposes()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem()))) &&
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
        if (getCdPa() != null) {
            _hashCode += getCdPa().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDesvio() != null) {
            _hashCode += getDesvio().hashCode();
        }
        if (getDsPa() != null) {
            _hashCode += getDsPa().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdPa()).hashCode();
        if (getOmMapapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmMapapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmMapapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPapros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPapros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPapros(), i);
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
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
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
        new org.apache.axis.description.TypeDesc(OmPa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desvio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "desvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPa"));
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
        elemField.setFieldName("idPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPapros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPapros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPapro"));
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
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
