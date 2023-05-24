/**
 * DwTRefugo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTRefugo  extends idw.idwws.DwTRefugoTemplate  implements java.io.Serializable {
    private java.lang.String cdTrefugo;

    private java.lang.String dsTrefugo;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolrelog[] dwConsolrelogs;

    private idw.idwws.DwConsolre[] dwConsolres;

    private idw.idwws.DwTArea dwTArea;

    private long idTrefugo;

    private java.lang.Boolean isRequerAcao;

    private java.lang.Boolean isRequerCausa;

    private idw.idwws.OmTppt omTppt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwTRefugo() {
    }

    public DwTRefugo(
           java.lang.Long id,
           java.lang.String cdTrefugo,
           java.lang.String dsTrefugo,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolrelog[] dwConsolrelogs,
           idw.idwws.DwConsolre[] dwConsolres,
           idw.idwws.DwTArea dwTArea,
           long idTrefugo,
           java.lang.Boolean isRequerAcao,
           java.lang.Boolean isRequerCausa,
           idw.idwws.OmTppt omTppt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdTrefugo = cdTrefugo;
        this.dsTrefugo = dsTrefugo;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolrelogs = dwConsolrelogs;
        this.dwConsolres = dwConsolres;
        this.dwTArea = dwTArea;
        this.idTrefugo = idTrefugo;
        this.isRequerAcao = isRequerAcao;
        this.isRequerCausa = isRequerCausa;
        this.omTppt = omTppt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTrefugo value for this DwTRefugo.
     * 
     * @return cdTrefugo
     */
    public java.lang.String getCdTrefugo() {
        return cdTrefugo;
    }


    /**
     * Sets the cdTrefugo value for this DwTRefugo.
     * 
     * @param cdTrefugo
     */
    public void setCdTrefugo(java.lang.String cdTrefugo) {
        this.cdTrefugo = cdTrefugo;
    }


    /**
     * Gets the dsTrefugo value for this DwTRefugo.
     * 
     * @return dsTrefugo
     */
    public java.lang.String getDsTrefugo() {
        return dsTrefugo;
    }


    /**
     * Sets the dsTrefugo value for this DwTRefugo.
     * 
     * @param dsTrefugo
     */
    public void setDsTrefugo(java.lang.String dsTrefugo) {
        this.dsTrefugo = dsTrefugo;
    }


    /**
     * Gets the dtRevisao value for this DwTRefugo.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwTRefugo.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwTRefugo.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwTRefugo.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolrelogs value for this DwTRefugo.
     * 
     * @return dwConsolrelogs
     */
    public idw.idwws.DwConsolrelog[] getDwConsolrelogs() {
        return dwConsolrelogs;
    }


    /**
     * Sets the dwConsolrelogs value for this DwTRefugo.
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
     * Gets the dwConsolres value for this DwTRefugo.
     * 
     * @return dwConsolres
     */
    public idw.idwws.DwConsolre[] getDwConsolres() {
        return dwConsolres;
    }


    /**
     * Sets the dwConsolres value for this DwTRefugo.
     * 
     * @param dwConsolres
     */
    public void setDwConsolres(idw.idwws.DwConsolre[] dwConsolres) {
        this.dwConsolres = dwConsolres;
    }

    public idw.idwws.DwConsolre getDwConsolres(int i) {
        return this.dwConsolres[i];
    }

    public void setDwConsolres(int i, idw.idwws.DwConsolre _value) {
        this.dwConsolres[i] = _value;
    }


    /**
     * Gets the dwTArea value for this DwTRefugo.
     * 
     * @return dwTArea
     */
    public idw.idwws.DwTArea getDwTArea() {
        return dwTArea;
    }


    /**
     * Sets the dwTArea value for this DwTRefugo.
     * 
     * @param dwTArea
     */
    public void setDwTArea(idw.idwws.DwTArea dwTArea) {
        this.dwTArea = dwTArea;
    }


    /**
     * Gets the idTrefugo value for this DwTRefugo.
     * 
     * @return idTrefugo
     */
    public long getIdTrefugo() {
        return idTrefugo;
    }


    /**
     * Sets the idTrefugo value for this DwTRefugo.
     * 
     * @param idTrefugo
     */
    public void setIdTrefugo(long idTrefugo) {
        this.idTrefugo = idTrefugo;
    }


    /**
     * Gets the isRequerAcao value for this DwTRefugo.
     * 
     * @return isRequerAcao
     */
    public java.lang.Boolean getIsRequerAcao() {
        return isRequerAcao;
    }


    /**
     * Sets the isRequerAcao value for this DwTRefugo.
     * 
     * @param isRequerAcao
     */
    public void setIsRequerAcao(java.lang.Boolean isRequerAcao) {
        this.isRequerAcao = isRequerAcao;
    }


    /**
     * Gets the isRequerCausa value for this DwTRefugo.
     * 
     * @return isRequerCausa
     */
    public java.lang.Boolean getIsRequerCausa() {
        return isRequerCausa;
    }


    /**
     * Sets the isRequerCausa value for this DwTRefugo.
     * 
     * @param isRequerCausa
     */
    public void setIsRequerCausa(java.lang.Boolean isRequerCausa) {
        this.isRequerCausa = isRequerCausa;
    }


    /**
     * Gets the omTppt value for this DwTRefugo.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this DwTRefugo.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwTRefugo.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwTRefugo.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwTRefugo.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwTRefugo.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwTRefugo.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwTRefugo.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwTRefugo.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwTRefugo.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTRefugo)) return false;
        DwTRefugo other = (DwTRefugo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTrefugo==null && other.getCdTrefugo()==null) || 
             (this.cdTrefugo!=null &&
              this.cdTrefugo.equals(other.getCdTrefugo()))) &&
            ((this.dsTrefugo==null && other.getDsTrefugo()==null) || 
             (this.dsTrefugo!=null &&
              this.dsTrefugo.equals(other.getDsTrefugo()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwConsolrelogs==null && other.getDwConsolrelogs()==null) || 
             (this.dwConsolrelogs!=null &&
              java.util.Arrays.equals(this.dwConsolrelogs, other.getDwConsolrelogs()))) &&
            ((this.dwConsolres==null && other.getDwConsolres()==null) || 
             (this.dwConsolres!=null &&
              java.util.Arrays.equals(this.dwConsolres, other.getDwConsolres()))) &&
            ((this.dwTArea==null && other.getDwTArea()==null) || 
             (this.dwTArea!=null &&
              this.dwTArea.equals(other.getDwTArea()))) &&
            this.idTrefugo == other.getIdTrefugo() &&
            ((this.isRequerAcao==null && other.getIsRequerAcao()==null) || 
             (this.isRequerAcao!=null &&
              this.isRequerAcao.equals(other.getIsRequerAcao()))) &&
            ((this.isRequerCausa==null && other.getIsRequerCausa()==null) || 
             (this.isRequerCausa!=null &&
              this.isRequerCausa.equals(other.getIsRequerCausa()))) &&
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
        if (getCdTrefugo() != null) {
            _hashCode += getCdTrefugo().hashCode();
        }
        if (getDsTrefugo() != null) {
            _hashCode += getDsTrefugo().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
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
        if (getDwConsolres() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolres());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolres(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTArea() != null) {
            _hashCode += getDwTArea().hashCode();
        }
        _hashCode += new Long(getIdTrefugo()).hashCode();
        if (getIsRequerAcao() != null) {
            _hashCode += getIsRequerAcao().hashCode();
        }
        if (getIsRequerCausa() != null) {
            _hashCode += getIsRequerCausa().hashCode();
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
        new org.apache.axis.description.TypeDesc(DwTRefugo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTrefugo"));
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
        elemField.setFieldName("dwConsolrelogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolrelogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolrelog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolre"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTArea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRequerAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRequerAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRequerCausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRequerCausa"));
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
