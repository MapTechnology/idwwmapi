/**
 * PpCm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCm  extends idw.idwws.PpCmTemplate  implements java.io.Serializable {
    private java.lang.String cdCm;

    private java.lang.String dsCm;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.util.Calendar dthrSai;

    private java.util.Calendar dthrVigor;

    private java.lang.Long idCm;

    private java.lang.Integer isConsumirmp;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpCmcom[] ppCmcoms;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public PpCm() {
    }

    public PpCm(
           java.lang.String cdCm,
           java.lang.String dsCm,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.util.Calendar dthrSai,
           java.util.Calendar dthrVigor,
           java.lang.Long idCm,
           java.lang.Integer isConsumirmp,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCmcom[] ppCmcoms,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        this.cdCm = cdCm;
        this.dsCm = dsCm;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dthrSai = dthrSai;
        this.dthrVigor = dthrVigor;
        this.idCm = idCm;
        this.isConsumirmp = isConsumirmp;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppCmcoms = ppCmcoms;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdCm value for this PpCm.
     * 
     * @return cdCm
     */
    public java.lang.String getCdCm() {
        return cdCm;
    }


    /**
     * Sets the cdCm value for this PpCm.
     * 
     * @param cdCm
     */
    public void setCdCm(java.lang.String cdCm) {
        this.cdCm = cdCm;
    }


    /**
     * Gets the dsCm value for this PpCm.
     * 
     * @return dsCm
     */
    public java.lang.String getDsCm() {
        return dsCm;
    }


    /**
     * Sets the dsCm value for this PpCm.
     * 
     * @param dsCm
     */
    public void setDsCm(java.lang.String dsCm) {
        this.dsCm = dsCm;
    }


    /**
     * Gets the dtRevisao value for this PpCm.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this PpCm.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this PpCm.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this PpCm.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dthrSai value for this PpCm.
     * 
     * @return dthrSai
     */
    public java.util.Calendar getDthrSai() {
        return dthrSai;
    }


    /**
     * Sets the dthrSai value for this PpCm.
     * 
     * @param dthrSai
     */
    public void setDthrSai(java.util.Calendar dthrSai) {
        this.dthrSai = dthrSai;
    }


    /**
     * Gets the dthrVigor value for this PpCm.
     * 
     * @return dthrVigor
     */
    public java.util.Calendar getDthrVigor() {
        return dthrVigor;
    }


    /**
     * Sets the dthrVigor value for this PpCm.
     * 
     * @param dthrVigor
     */
    public void setDthrVigor(java.util.Calendar dthrVigor) {
        this.dthrVigor = dthrVigor;
    }


    /**
     * Gets the idCm value for this PpCm.
     * 
     * @return idCm
     */
    public java.lang.Long getIdCm() {
        return idCm;
    }


    /**
     * Sets the idCm value for this PpCm.
     * 
     * @param idCm
     */
    public void setIdCm(java.lang.Long idCm) {
        this.idCm = idCm;
    }


    /**
     * Gets the isConsumirmp value for this PpCm.
     * 
     * @return isConsumirmp
     */
    public java.lang.Integer getIsConsumirmp() {
        return isConsumirmp;
    }


    /**
     * Sets the isConsumirmp value for this PpCm.
     * 
     * @param isConsumirmp
     */
    public void setIsConsumirmp(java.lang.Integer isConsumirmp) {
        this.isConsumirmp = isConsumirmp;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this PpCm.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this PpCm.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this PpCm.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this PpCm.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppCmcoms value for this PpCm.
     * 
     * @return ppCmcoms
     */
    public idw.idwws.PpCmcom[] getPpCmcoms() {
        return ppCmcoms;
    }


    /**
     * Sets the ppCmcoms value for this PpCm.
     * 
     * @param ppCmcoms
     */
    public void setPpCmcoms(idw.idwws.PpCmcom[] ppCmcoms) {
        this.ppCmcoms = ppCmcoms;
    }

    public idw.idwws.PpCmcom getPpCmcoms(int i) {
        return this.ppCmcoms[i];
    }

    public void setPpCmcoms(int i, idw.idwws.PpCmcom _value) {
        this.ppCmcoms[i] = _value;
    }


    /**
     * Gets the revisao value for this PpCm.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this PpCm.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this PpCm.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this PpCm.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCm)) return false;
        PpCm other = (PpCm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdCm==null && other.getCdCm()==null) || 
             (this.cdCm!=null &&
              this.cdCm.equals(other.getCdCm()))) &&
            ((this.dsCm==null && other.getDsCm()==null) || 
             (this.dsCm!=null &&
              this.dsCm.equals(other.getDsCm()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dthrSai==null && other.getDthrSai()==null) || 
             (this.dthrSai!=null &&
              this.dthrSai.equals(other.getDthrSai()))) &&
            ((this.dthrVigor==null && other.getDthrVigor()==null) || 
             (this.dthrVigor!=null &&
              this.dthrVigor.equals(other.getDthrVigor()))) &&
            ((this.idCm==null && other.getIdCm()==null) || 
             (this.idCm!=null &&
              this.idCm.equals(other.getIdCm()))) &&
            ((this.isConsumirmp==null && other.getIsConsumirmp()==null) || 
             (this.isConsumirmp!=null &&
              this.isConsumirmp.equals(other.getIsConsumirmp()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppCmcoms==null && other.getPpCmcoms()==null) || 
             (this.ppCmcoms!=null &&
              java.util.Arrays.equals(this.ppCmcoms, other.getPpCmcoms()))) &&
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
        if (getCdCm() != null) {
            _hashCode += getCdCm().hashCode();
        }
        if (getDsCm() != null) {
            _hashCode += getDsCm().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDthrSai() != null) {
            _hashCode += getDthrSai().hashCode();
        }
        if (getDthrVigor() != null) {
            _hashCode += getDthrVigor().hashCode();
        }
        if (getIdCm() != null) {
            _hashCode += getIdCm().hashCode();
        }
        if (getIsConsumirmp() != null) {
            _hashCode += getIsConsumirmp().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpCmcoms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCmcoms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCmcoms(), i);
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
        new org.apache.axis.description.TypeDesc(PpCm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdCm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdCm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCm"));
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
        elemField.setFieldName("dthrSai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrSai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrVigor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrVigor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsumirmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsumirmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("ppCmcoms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCmcoms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCmcom"));
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
