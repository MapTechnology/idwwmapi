/**
 * DwTAlerta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTAlerta  extends idw.idwws.DwTAlertaTemplate  implements java.io.Serializable {
    private java.lang.String cdTalerta;

    private java.lang.String dsTalerta;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolallog[] dwConsolallogs;

    private idw.idwws.DwConsolal[] dwConsolals;

    private long idTalerta;

    private java.lang.Boolean isAutomatico;

    private idw.idwws.OmTppt omTppt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwTAlerta() {
    }

    public DwTAlerta(
           java.lang.Long id,
           java.lang.String cdTalerta,
           java.lang.String dsTalerta,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolallog[] dwConsolallogs,
           idw.idwws.DwConsolal[] dwConsolals,
           long idTalerta,
           java.lang.Boolean isAutomatico,
           idw.idwws.OmTppt omTppt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdTalerta = cdTalerta;
        this.dsTalerta = dsTalerta;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolallogs = dwConsolallogs;
        this.dwConsolals = dwConsolals;
        this.idTalerta = idTalerta;
        this.isAutomatico = isAutomatico;
        this.omTppt = omTppt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTalerta value for this DwTAlerta.
     * 
     * @return cdTalerta
     */
    public java.lang.String getCdTalerta() {
        return cdTalerta;
    }


    /**
     * Sets the cdTalerta value for this DwTAlerta.
     * 
     * @param cdTalerta
     */
    public void setCdTalerta(java.lang.String cdTalerta) {
        this.cdTalerta = cdTalerta;
    }


    /**
     * Gets the dsTalerta value for this DwTAlerta.
     * 
     * @return dsTalerta
     */
    public java.lang.String getDsTalerta() {
        return dsTalerta;
    }


    /**
     * Sets the dsTalerta value for this DwTAlerta.
     * 
     * @param dsTalerta
     */
    public void setDsTalerta(java.lang.String dsTalerta) {
        this.dsTalerta = dsTalerta;
    }


    /**
     * Gets the dtRevisao value for this DwTAlerta.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwTAlerta.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwTAlerta.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwTAlerta.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolallogs value for this DwTAlerta.
     * 
     * @return dwConsolallogs
     */
    public idw.idwws.DwConsolallog[] getDwConsolallogs() {
        return dwConsolallogs;
    }


    /**
     * Sets the dwConsolallogs value for this DwTAlerta.
     * 
     * @param dwConsolallogs
     */
    public void setDwConsolallogs(idw.idwws.DwConsolallog[] dwConsolallogs) {
        this.dwConsolallogs = dwConsolallogs;
    }

    public idw.idwws.DwConsolallog getDwConsolallogs(int i) {
        return this.dwConsolallogs[i];
    }

    public void setDwConsolallogs(int i, idw.idwws.DwConsolallog _value) {
        this.dwConsolallogs[i] = _value;
    }


    /**
     * Gets the dwConsolals value for this DwTAlerta.
     * 
     * @return dwConsolals
     */
    public idw.idwws.DwConsolal[] getDwConsolals() {
        return dwConsolals;
    }


    /**
     * Sets the dwConsolals value for this DwTAlerta.
     * 
     * @param dwConsolals
     */
    public void setDwConsolals(idw.idwws.DwConsolal[] dwConsolals) {
        this.dwConsolals = dwConsolals;
    }

    public idw.idwws.DwConsolal getDwConsolals(int i) {
        return this.dwConsolals[i];
    }

    public void setDwConsolals(int i, idw.idwws.DwConsolal _value) {
        this.dwConsolals[i] = _value;
    }


    /**
     * Gets the idTalerta value for this DwTAlerta.
     * 
     * @return idTalerta
     */
    public long getIdTalerta() {
        return idTalerta;
    }


    /**
     * Sets the idTalerta value for this DwTAlerta.
     * 
     * @param idTalerta
     */
    public void setIdTalerta(long idTalerta) {
        this.idTalerta = idTalerta;
    }


    /**
     * Gets the isAutomatico value for this DwTAlerta.
     * 
     * @return isAutomatico
     */
    public java.lang.Boolean getIsAutomatico() {
        return isAutomatico;
    }


    /**
     * Sets the isAutomatico value for this DwTAlerta.
     * 
     * @param isAutomatico
     */
    public void setIsAutomatico(java.lang.Boolean isAutomatico) {
        this.isAutomatico = isAutomatico;
    }


    /**
     * Gets the omTppt value for this DwTAlerta.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this DwTAlerta.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwTAlerta.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwTAlerta.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwTAlerta.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwTAlerta.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwTAlerta.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwTAlerta.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwTAlerta.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwTAlerta.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTAlerta)) return false;
        DwTAlerta other = (DwTAlerta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTalerta==null && other.getCdTalerta()==null) || 
             (this.cdTalerta!=null &&
              this.cdTalerta.equals(other.getCdTalerta()))) &&
            ((this.dsTalerta==null && other.getDsTalerta()==null) || 
             (this.dsTalerta!=null &&
              this.dsTalerta.equals(other.getDsTalerta()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwConsolallogs==null && other.getDwConsolallogs()==null) || 
             (this.dwConsolallogs!=null &&
              java.util.Arrays.equals(this.dwConsolallogs, other.getDwConsolallogs()))) &&
            ((this.dwConsolals==null && other.getDwConsolals()==null) || 
             (this.dwConsolals!=null &&
              java.util.Arrays.equals(this.dwConsolals, other.getDwConsolals()))) &&
            this.idTalerta == other.getIdTalerta() &&
            ((this.isAutomatico==null && other.getIsAutomatico()==null) || 
             (this.isAutomatico!=null &&
              this.isAutomatico.equals(other.getIsAutomatico()))) &&
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
        if (getCdTalerta() != null) {
            _hashCode += getCdTalerta().hashCode();
        }
        if (getDsTalerta() != null) {
            _hashCode += getDsTalerta().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwConsolallogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolallogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolallogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolals() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolals());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolals(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdTalerta()).hashCode();
        if (getIsAutomatico() != null) {
            _hashCode += getIsAutomatico().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(DwTAlerta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAlerta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTalerta"));
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
        elemField.setFieldName("dwConsolallogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolallogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolallog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolals");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolals"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAutomatico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAutomatico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
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
