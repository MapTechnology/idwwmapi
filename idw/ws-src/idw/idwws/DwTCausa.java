/**
 * DwTCausa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTCausa  extends idw.idwws.DwTCausaTemplate  implements java.io.Serializable {
    private java.lang.String cdTcausa;

    private java.lang.String dsTcausa;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolpalog[] dwConsolpalogs;

    private idw.idwws.DwConsolrelog[] dwConsolrelogs;

    private long idTcausa;

    private idw.idwws.OmTppt omTppt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwTCausa() {
    }

    public DwTCausa(
           java.lang.Long id,
           java.lang.String cdTcausa,
           java.lang.String dsTcausa,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolpalog[] dwConsolpalogs,
           idw.idwws.DwConsolrelog[] dwConsolrelogs,
           long idTcausa,
           idw.idwws.OmTppt omTppt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdTcausa = cdTcausa;
        this.dsTcausa = dsTcausa;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolpalogs = dwConsolpalogs;
        this.dwConsolrelogs = dwConsolrelogs;
        this.idTcausa = idTcausa;
        this.omTppt = omTppt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTcausa value for this DwTCausa.
     * 
     * @return cdTcausa
     */
    public java.lang.String getCdTcausa() {
        return cdTcausa;
    }


    /**
     * Sets the cdTcausa value for this DwTCausa.
     * 
     * @param cdTcausa
     */
    public void setCdTcausa(java.lang.String cdTcausa) {
        this.cdTcausa = cdTcausa;
    }


    /**
     * Gets the dsTcausa value for this DwTCausa.
     * 
     * @return dsTcausa
     */
    public java.lang.String getDsTcausa() {
        return dsTcausa;
    }


    /**
     * Sets the dsTcausa value for this DwTCausa.
     * 
     * @param dsTcausa
     */
    public void setDsTcausa(java.lang.String dsTcausa) {
        this.dsTcausa = dsTcausa;
    }


    /**
     * Gets the dtRevisao value for this DwTCausa.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwTCausa.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwTCausa.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwTCausa.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolpalogs value for this DwTCausa.
     * 
     * @return dwConsolpalogs
     */
    public idw.idwws.DwConsolpalog[] getDwConsolpalogs() {
        return dwConsolpalogs;
    }


    /**
     * Sets the dwConsolpalogs value for this DwTCausa.
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
     * Gets the dwConsolrelogs value for this DwTCausa.
     * 
     * @return dwConsolrelogs
     */
    public idw.idwws.DwConsolrelog[] getDwConsolrelogs() {
        return dwConsolrelogs;
    }


    /**
     * Sets the dwConsolrelogs value for this DwTCausa.
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
     * Gets the idTcausa value for this DwTCausa.
     * 
     * @return idTcausa
     */
    public long getIdTcausa() {
        return idTcausa;
    }


    /**
     * Sets the idTcausa value for this DwTCausa.
     * 
     * @param idTcausa
     */
    public void setIdTcausa(long idTcausa) {
        this.idTcausa = idTcausa;
    }


    /**
     * Gets the omTppt value for this DwTCausa.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this DwTCausa.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwTCausa.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwTCausa.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwTCausa.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwTCausa.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwTCausa.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwTCausa.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwTCausa.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwTCausa.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTCausa)) return false;
        DwTCausa other = (DwTCausa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTcausa==null && other.getCdTcausa()==null) || 
             (this.cdTcausa!=null &&
              this.cdTcausa.equals(other.getCdTcausa()))) &&
            ((this.dsTcausa==null && other.getDsTcausa()==null) || 
             (this.dsTcausa!=null &&
              this.dsTcausa.equals(other.getDsTcausa()))) &&
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
            this.idTcausa == other.getIdTcausa() &&
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
        if (getCdTcausa() != null) {
            _hashCode += getCdTcausa().hashCode();
        }
        if (getDsTcausa() != null) {
            _hashCode += getDsTcausa().hashCode();
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
        _hashCode += new Long(getIdTcausa()).hashCode();
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
        new org.apache.axis.description.TypeDesc(DwTCausa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTCausa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTcausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTcausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTcausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTcausa"));
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
        elemField.setFieldName("idTcausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTcausa"));
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
