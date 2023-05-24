/**
 * DwTAcao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTAcao  extends idw.idwws.DwTAcaoTemplate  implements java.io.Serializable {
    private java.lang.String cdTacao;

    private java.lang.String dsTacao;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolpalog[] dwConsolpalogs;

    private idw.idwws.DwConsolrelog[] dwConsolrelogs;

    private idw.idwws.DwExpcvs[] dwExpcvses;

    private idw.idwws.DwPasscau[] dwPasscaus;

    private long idTacao;

    private idw.idwws.OmTppt omTppt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwTAcao() {
    }

    public DwTAcao(
           java.lang.Long id,
           java.lang.String cdTacao,
           java.lang.String dsTacao,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolpalog[] dwConsolpalogs,
           idw.idwws.DwConsolrelog[] dwConsolrelogs,
           idw.idwws.DwExpcvs[] dwExpcvses,
           idw.idwws.DwPasscau[] dwPasscaus,
           long idTacao,
           idw.idwws.OmTppt omTppt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdTacao = cdTacao;
        this.dsTacao = dsTacao;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolpalogs = dwConsolpalogs;
        this.dwConsolrelogs = dwConsolrelogs;
        this.dwExpcvses = dwExpcvses;
        this.dwPasscaus = dwPasscaus;
        this.idTacao = idTacao;
        this.omTppt = omTppt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTacao value for this DwTAcao.
     * 
     * @return cdTacao
     */
    public java.lang.String getCdTacao() {
        return cdTacao;
    }


    /**
     * Sets the cdTacao value for this DwTAcao.
     * 
     * @param cdTacao
     */
    public void setCdTacao(java.lang.String cdTacao) {
        this.cdTacao = cdTacao;
    }


    /**
     * Gets the dsTacao value for this DwTAcao.
     * 
     * @return dsTacao
     */
    public java.lang.String getDsTacao() {
        return dsTacao;
    }


    /**
     * Sets the dsTacao value for this DwTAcao.
     * 
     * @param dsTacao
     */
    public void setDsTacao(java.lang.String dsTacao) {
        this.dsTacao = dsTacao;
    }


    /**
     * Gets the dtRevisao value for this DwTAcao.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwTAcao.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwTAcao.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwTAcao.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolpalogs value for this DwTAcao.
     * 
     * @return dwConsolpalogs
     */
    public idw.idwws.DwConsolpalog[] getDwConsolpalogs() {
        return dwConsolpalogs;
    }


    /**
     * Sets the dwConsolpalogs value for this DwTAcao.
     * 
     * @param dwConsolpalogs
     */
    public void setDwConsolpalogs(idw.idwws.DwConsolpalog[] dwConsolpalogs) {
        this.dwConsolpalogs = dwConsolpalogs;
    }

    public idw.idwws.DwConsolpalog getDwConsolpalogs(int i) {
        return this.dwConsolpalogs[i];
    }

    public void setDwConsolpalogs(int i, idw.idwws.DwConsolpalog _value) {
        this.dwConsolpalogs[i] = _value;
    }


    /**
     * Gets the dwConsolrelogs value for this DwTAcao.
     * 
     * @return dwConsolrelogs
     */
    public idw.idwws.DwConsolrelog[] getDwConsolrelogs() {
        return dwConsolrelogs;
    }


    /**
     * Sets the dwConsolrelogs value for this DwTAcao.
     * 
     * @param dwConsolrelogs
     */
    public void setDwConsolrelogs(idw.idwws.DwConsolrelog[] dwConsolrelogs) {
        this.dwConsolrelogs = dwConsolrelogs;
    }

    public idw.idwws.DwConsolrelog getDwConsolrelogs(int i) {
        return this.dwConsolrelogs[i];
    }

    public void setDwConsolrelogs(int i, idw.idwws.DwConsolrelog _value) {
        this.dwConsolrelogs[i] = _value;
    }


    /**
     * Gets the dwExpcvses value for this DwTAcao.
     * 
     * @return dwExpcvses
     */
    public idw.idwws.DwExpcvs[] getDwExpcvses() {
        return dwExpcvses;
    }


    /**
     * Sets the dwExpcvses value for this DwTAcao.
     * 
     * @param dwExpcvses
     */
    public void setDwExpcvses(idw.idwws.DwExpcvs[] dwExpcvses) {
        this.dwExpcvses = dwExpcvses;
    }

    public idw.idwws.DwExpcvs getDwExpcvses(int i) {
        return this.dwExpcvses[i];
    }

    public void setDwExpcvses(int i, idw.idwws.DwExpcvs _value) {
        this.dwExpcvses[i] = _value;
    }


    /**
     * Gets the dwPasscaus value for this DwTAcao.
     * 
     * @return dwPasscaus
     */
    public idw.idwws.DwPasscau[] getDwPasscaus() {
        return dwPasscaus;
    }


    /**
     * Sets the dwPasscaus value for this DwTAcao.
     * 
     * @param dwPasscaus
     */
    public void setDwPasscaus(idw.idwws.DwPasscau[] dwPasscaus) {
        this.dwPasscaus = dwPasscaus;
    }

    public idw.idwws.DwPasscau getDwPasscaus(int i) {
        return this.dwPasscaus[i];
    }

    public void setDwPasscaus(int i, idw.idwws.DwPasscau _value) {
        this.dwPasscaus[i] = _value;
    }


    /**
     * Gets the idTacao value for this DwTAcao.
     * 
     * @return idTacao
     */
    public long getIdTacao() {
        return idTacao;
    }


    /**
     * Sets the idTacao value for this DwTAcao.
     * 
     * @param idTacao
     */
    public void setIdTacao(long idTacao) {
        this.idTacao = idTacao;
    }


    /**
     * Gets the omTppt value for this DwTAcao.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this DwTAcao.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwTAcao.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwTAcao.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwTAcao.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwTAcao.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwTAcao.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwTAcao.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwTAcao.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwTAcao.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTAcao)) return false;
        DwTAcao other = (DwTAcao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTacao==null && other.getCdTacao()==null) || 
             (this.cdTacao!=null &&
              this.cdTacao.equals(other.getCdTacao()))) &&
            ((this.dsTacao==null && other.getDsTacao()==null) || 
             (this.dsTacao!=null &&
              this.dsTacao.equals(other.getDsTacao()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwConsolpalogs==null && other.getDwConsolpalogs()==null) || 
             (this.dwConsolpalogs!=null &&
              java.util.Arrays.equals(this.dwConsolpalogs, other.getDwConsolpalogs()))) &&
            ((this.dwConsolrelogs==null && other.getDwConsolrelogs()==null) || 
             (this.dwConsolrelogs!=null &&
              java.util.Arrays.equals(this.dwConsolrelogs, other.getDwConsolrelogs()))) &&
            ((this.dwExpcvses==null && other.getDwExpcvses()==null) || 
             (this.dwExpcvses!=null &&
              java.util.Arrays.equals(this.dwExpcvses, other.getDwExpcvses()))) &&
            ((this.dwPasscaus==null && other.getDwPasscaus()==null) || 
             (this.dwPasscaus!=null &&
              java.util.Arrays.equals(this.dwPasscaus, other.getDwPasscaus()))) &&
            this.idTacao == other.getIdTacao() &&
            ((this.omTppt==null && other.getOmTppt()==null) || 
             (this.omTppt!=null &&
              this.omTppt.equals(other.getOmTppt()))) &&
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
        if (getCdTacao() != null) {
            _hashCode += getCdTacao().hashCode();
        }
        if (getDsTacao() != null) {
            _hashCode += getDsTacao().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwConsolpalogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpalogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpalogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolrelogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolrelogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolrelogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwExpcvses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwExpcvses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwExpcvses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPasscaus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPasscaus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPasscaus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdTacao()).hashCode();
        if (getOmTppt() != null) {
            _hashCode += getOmTppt().hashCode();
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
        new org.apache.axis.description.TypeDesc(DwTAcao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTacao"));
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
        elemField.setFieldName("dwConsolpalogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpalogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolrelogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolrelogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolrelog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwExpcvses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwExpcvses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwExpcvs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasscaus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasscaus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasscau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
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
