/**
 * OmMapa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmMapa  extends idw.idwws.OmMapaTemplate  implements java.io.Serializable {
    private java.lang.String cdMapa;

    private java.lang.String dsMapa;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idMapa;

    private idw.idwws.OmAlim[] omAlims;

    private idw.idwws.OmMapapa[] omMapapas;

    private idw.idwws.OmPrg omPrg;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmMapa() {
    }

    public OmMapa(
           java.lang.String cdMapa,
           java.lang.String dsMapa,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idMapa,
           idw.idwws.OmAlim[] omAlims,
           idw.idwws.OmMapapa[] omMapapas,
           idw.idwws.OmPrg omPrg,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        this.cdMapa = cdMapa;
        this.dsMapa = dsMapa;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idMapa = idMapa;
        this.omAlims = omAlims;
        this.omMapapas = omMapapas;
        this.omPrg = omPrg;
        this.omProduto = omProduto;
        this.omPt = omPt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdMapa value for this OmMapa.
     * 
     * @return cdMapa
     */
    public java.lang.String getCdMapa() {
        return cdMapa;
    }


    /**
     * Sets the cdMapa value for this OmMapa.
     * 
     * @param cdMapa
     */
    public void setCdMapa(java.lang.String cdMapa) {
        this.cdMapa = cdMapa;
    }


    /**
     * Gets the dsMapa value for this OmMapa.
     * 
     * @return dsMapa
     */
    public java.lang.String getDsMapa() {
        return dsMapa;
    }


    /**
     * Sets the dsMapa value for this OmMapa.
     * 
     * @param dsMapa
     */
    public void setDsMapa(java.lang.String dsMapa) {
        this.dsMapa = dsMapa;
    }


    /**
     * Gets the dtRevisao value for this OmMapa.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmMapa.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmMapa.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmMapa.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idMapa value for this OmMapa.
     * 
     * @return idMapa
     */
    public long getIdMapa() {
        return idMapa;
    }


    /**
     * Sets the idMapa value for this OmMapa.
     * 
     * @param idMapa
     */
    public void setIdMapa(long idMapa) {
        this.idMapa = idMapa;
    }


    /**
     * Gets the omAlims value for this OmMapa.
     * 
     * @return omAlims
     */
    public idw.idwws.OmAlim[] getOmAlims() {
        return omAlims;
    }


    /**
     * Sets the omAlims value for this OmMapa.
     * 
     * @param omAlims
     */
    public void setOmAlims(idw.idwws.OmAlim[] omAlims) {
        this.omAlims = omAlims;
    }

    public idw.idwws.OmAlim getOmAlims(int i) {
        return this.omAlims[i];
    }

    public void setOmAlims(int i, idw.idwws.OmAlim _value) {
        this.omAlims[i] = _value;
    }


    /**
     * Gets the omMapapas value for this OmMapa.
     * 
     * @return omMapapas
     */
    public idw.idwws.OmMapapa[] getOmMapapas() {
        return omMapapas;
    }


    /**
     * Sets the omMapapas value for this OmMapa.
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
     * Gets the omPrg value for this OmMapa.
     * 
     * @return omPrg
     */
    public idw.idwws.OmPrg getOmPrg() {
        return omPrg;
    }


    /**
     * Sets the omPrg value for this OmMapa.
     * 
     * @param omPrg
     */
    public void setOmPrg(idw.idwws.OmPrg omPrg) {
        this.omPrg = omPrg;
    }


    /**
     * Gets the omProduto value for this OmMapa.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmMapa.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omPt value for this OmMapa.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmMapa.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmMapa.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmMapa.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmMapa.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmMapa.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this OmMapa.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmMapa.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmMapa.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmMapa.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmMapa)) return false;
        OmMapa other = (OmMapa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdMapa==null && other.getCdMapa()==null) || 
             (this.cdMapa!=null &&
              this.cdMapa.equals(other.getCdMapa()))) &&
            ((this.dsMapa==null && other.getDsMapa()==null) || 
             (this.dsMapa!=null &&
              this.dsMapa.equals(other.getDsMapa()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idMapa == other.getIdMapa() &&
            ((this.omAlims==null && other.getOmAlims()==null) || 
             (this.omAlims!=null &&
              java.util.Arrays.equals(this.omAlims, other.getOmAlims()))) &&
            ((this.omMapapas==null && other.getOmMapapas()==null) || 
             (this.omMapapas!=null &&
              java.util.Arrays.equals(this.omMapapas, other.getOmMapapas()))) &&
            ((this.omPrg==null && other.getOmPrg()==null) || 
             (this.omPrg!=null &&
              this.omPrg.equals(other.getOmPrg()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
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
        if (getCdMapa() != null) {
            _hashCode += getCdMapa().hashCode();
        }
        if (getDsMapa() != null) {
            _hashCode += getDsMapa().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdMapa()).hashCode();
        if (getOmAlims() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmAlims());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmAlims(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        if (getOmPrg() != null) {
            _hashCode += getOmPrg().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
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
        new org.apache.axis.description.TypeDesc(OmMapa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMapa"));
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
        elemField.setFieldName("idMapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlims");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlims"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlim"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("omPrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
