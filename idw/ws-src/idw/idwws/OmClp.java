/**
 * OmClp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmClp  implements java.io.Serializable {
    private java.lang.String cdClp;

    private java.lang.String dsClp;

    private java.lang.String dsCurta;

    private java.util.Calendar dtCadastro;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idClp;

    private idw.idwws.OmPt[] omPts;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmClp() {
    }

    public OmClp(
           java.lang.String cdClp,
           java.lang.String dsClp,
           java.lang.String dsCurta,
           java.util.Calendar dtCadastro,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idClp,
           idw.idwws.OmPt[] omPts,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
           this.cdClp = cdClp;
           this.dsClp = dsClp;
           this.dsCurta = dsCurta;
           this.dtCadastro = dtCadastro;
           this.dtRevisao = dtRevisao;
           this.dtStativo = dtStativo;
           this.idClp = idClp;
           this.omPts = omPts;
           this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
           this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
           this.revisao = revisao;
           this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdClp value for this OmClp.
     * 
     * @return cdClp
     */
    public java.lang.String getCdClp() {
        return cdClp;
    }


    /**
     * Sets the cdClp value for this OmClp.
     * 
     * @param cdClp
     */
    public void setCdClp(java.lang.String cdClp) {
        this.cdClp = cdClp;
    }


    /**
     * Gets the dsClp value for this OmClp.
     * 
     * @return dsClp
     */
    public java.lang.String getDsClp() {
        return dsClp;
    }


    /**
     * Sets the dsClp value for this OmClp.
     * 
     * @param dsClp
     */
    public void setDsClp(java.lang.String dsClp) {
        this.dsClp = dsClp;
    }


    /**
     * Gets the dsCurta value for this OmClp.
     * 
     * @return dsCurta
     */
    public java.lang.String getDsCurta() {
        return dsCurta;
    }


    /**
     * Sets the dsCurta value for this OmClp.
     * 
     * @param dsCurta
     */
    public void setDsCurta(java.lang.String dsCurta) {
        this.dsCurta = dsCurta;
    }


    /**
     * Gets the dtCadastro value for this OmClp.
     * 
     * @return dtCadastro
     */
    public java.util.Calendar getDtCadastro() {
        return dtCadastro;
    }


    /**
     * Sets the dtCadastro value for this OmClp.
     * 
     * @param dtCadastro
     */
    public void setDtCadastro(java.util.Calendar dtCadastro) {
        this.dtCadastro = dtCadastro;
    }


    /**
     * Gets the dtRevisao value for this OmClp.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmClp.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmClp.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmClp.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idClp value for this OmClp.
     * 
     * @return idClp
     */
    public long getIdClp() {
        return idClp;
    }


    /**
     * Sets the idClp value for this OmClp.
     * 
     * @param idClp
     */
    public void setIdClp(long idClp) {
        this.idClp = idClp;
    }


    /**
     * Gets the omPts value for this OmClp.
     * 
     * @return omPts
     */
    public idw.idwws.OmPt[] getOmPts() {
        return omPts;
    }


    /**
     * Sets the omPts value for this OmClp.
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
     * Gets the omUsrByIdUsrrevisao value for this OmClp.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmClp.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmClp.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmClp.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this OmClp.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmClp.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmClp.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmClp.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmClp)) return false;
        OmClp other = (OmClp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdClp==null && other.getCdClp()==null) || 
             (this.cdClp!=null &&
              this.cdClp.equals(other.getCdClp()))) &&
            ((this.dsClp==null && other.getDsClp()==null) || 
             (this.dsClp!=null &&
              this.dsClp.equals(other.getDsClp()))) &&
            ((this.dsCurta==null && other.getDsCurta()==null) || 
             (this.dsCurta!=null &&
              this.dsCurta.equals(other.getDsCurta()))) &&
            ((this.dtCadastro==null && other.getDtCadastro()==null) || 
             (this.dtCadastro!=null &&
              this.dtCadastro.equals(other.getDtCadastro()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idClp == other.getIdClp() &&
            ((this.omPts==null && other.getOmPts()==null) || 
             (this.omPts!=null &&
              java.util.Arrays.equals(this.omPts, other.getOmPts()))) &&
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
        int _hashCode = 1;
        if (getCdClp() != null) {
            _hashCode += getCdClp().hashCode();
        }
        if (getDsClp() != null) {
            _hashCode += getDsClp().hashCode();
        }
        if (getDsCurta() != null) {
            _hashCode += getDsCurta().hashCode();
        }
        if (getDtCadastro() != null) {
            _hashCode += getDtCadastro().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdClp()).hashCode();
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
        new org.apache.axis.description.TypeDesc(OmClp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omClp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdClp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdClp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsClp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsClp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCurta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCurta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("idClp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idClp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
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
