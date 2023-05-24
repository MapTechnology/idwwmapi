/**
 * DwFtEtapa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFtEtapa  extends idw.idwws.DwFtEtapaTemplate  implements java.io.Serializable {
    private java.lang.String cdEtapa;

    private java.lang.String dsEtapa;

    private java.lang.String dsMensagemnok;

    private java.lang.String dsMensagemok;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwFtSub[] dwFtSubs;

    private long idFtEtapa;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwFtEtapa() {
    }

    public DwFtEtapa(
           java.lang.String cdEtapa,
           java.lang.String dsEtapa,
           java.lang.String dsMensagemnok,
           java.lang.String dsMensagemok,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwFtSub[] dwFtSubs,
           long idFtEtapa,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        this.cdEtapa = cdEtapa;
        this.dsEtapa = dsEtapa;
        this.dsMensagemnok = dsMensagemnok;
        this.dsMensagemok = dsMensagemok;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwFtSubs = dwFtSubs;
        this.idFtEtapa = idFtEtapa;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdEtapa value for this DwFtEtapa.
     * 
     * @return cdEtapa
     */
    public java.lang.String getCdEtapa() {
        return cdEtapa;
    }


    /**
     * Sets the cdEtapa value for this DwFtEtapa.
     * 
     * @param cdEtapa
     */
    public void setCdEtapa(java.lang.String cdEtapa) {
        this.cdEtapa = cdEtapa;
    }


    /**
     * Gets the dsEtapa value for this DwFtEtapa.
     * 
     * @return dsEtapa
     */
    public java.lang.String getDsEtapa() {
        return dsEtapa;
    }


    /**
     * Sets the dsEtapa value for this DwFtEtapa.
     * 
     * @param dsEtapa
     */
    public void setDsEtapa(java.lang.String dsEtapa) {
        this.dsEtapa = dsEtapa;
    }


    /**
     * Gets the dsMensagemnok value for this DwFtEtapa.
     * 
     * @return dsMensagemnok
     */
    public java.lang.String getDsMensagemnok() {
        return dsMensagemnok;
    }


    /**
     * Sets the dsMensagemnok value for this DwFtEtapa.
     * 
     * @param dsMensagemnok
     */
    public void setDsMensagemnok(java.lang.String dsMensagemnok) {
        this.dsMensagemnok = dsMensagemnok;
    }


    /**
     * Gets the dsMensagemok value for this DwFtEtapa.
     * 
     * @return dsMensagemok
     */
    public java.lang.String getDsMensagemok() {
        return dsMensagemok;
    }


    /**
     * Sets the dsMensagemok value for this DwFtEtapa.
     * 
     * @param dsMensagemok
     */
    public void setDsMensagemok(java.lang.String dsMensagemok) {
        this.dsMensagemok = dsMensagemok;
    }


    /**
     * Gets the dtRevisao value for this DwFtEtapa.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwFtEtapa.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwFtEtapa.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwFtEtapa.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwFtSubs value for this DwFtEtapa.
     * 
     * @return dwFtSubs
     */
    public idw.idwws.DwFtSub[] getDwFtSubs() {
        return dwFtSubs;
    }


    /**
     * Sets the dwFtSubs value for this DwFtEtapa.
     * 
     * @param dwFtSubs
     */
    public void setDwFtSubs(idw.idwws.DwFtSub[] dwFtSubs) {
        this.dwFtSubs = dwFtSubs;
    }

    public idw.idwws.DwFtSub getDwFtSubs(int i) {
        return this.dwFtSubs[i];
    }

    public void setDwFtSubs(int i, idw.idwws.DwFtSub _value) {
        this.dwFtSubs[i] = _value;
    }


    /**
     * Gets the idFtEtapa value for this DwFtEtapa.
     * 
     * @return idFtEtapa
     */
    public long getIdFtEtapa() {
        return idFtEtapa;
    }


    /**
     * Sets the idFtEtapa value for this DwFtEtapa.
     * 
     * @param idFtEtapa
     */
    public void setIdFtEtapa(long idFtEtapa) {
        this.idFtEtapa = idFtEtapa;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwFtEtapa.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwFtEtapa.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwFtEtapa.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwFtEtapa.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwFtEtapa.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwFtEtapa.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwFtEtapa.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwFtEtapa.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFtEtapa)) return false;
        DwFtEtapa other = (DwFtEtapa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdEtapa==null && other.getCdEtapa()==null) || 
             (this.cdEtapa!=null &&
              this.cdEtapa.equals(other.getCdEtapa()))) &&
            ((this.dsEtapa==null && other.getDsEtapa()==null) || 
             (this.dsEtapa!=null &&
              this.dsEtapa.equals(other.getDsEtapa()))) &&
            ((this.dsMensagemnok==null && other.getDsMensagemnok()==null) || 
             (this.dsMensagemnok!=null &&
              this.dsMensagemnok.equals(other.getDsMensagemnok()))) &&
            ((this.dsMensagemok==null && other.getDsMensagemok()==null) || 
             (this.dsMensagemok!=null &&
              this.dsMensagemok.equals(other.getDsMensagemok()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwFtSubs==null && other.getDwFtSubs()==null) || 
             (this.dwFtSubs!=null &&
              java.util.Arrays.equals(this.dwFtSubs, other.getDwFtSubs()))) &&
            this.idFtEtapa == other.getIdFtEtapa() &&
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
        if (getCdEtapa() != null) {
            _hashCode += getCdEtapa().hashCode();
        }
        if (getDsEtapa() != null) {
            _hashCode += getDsEtapa().hashCode();
        }
        if (getDsMensagemnok() != null) {
            _hashCode += getDsMensagemnok().hashCode();
        }
        if (getDsMensagemok() != null) {
            _hashCode += getDsMensagemok().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwFtSubs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFtSubs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFtSubs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdFtEtapa()).hashCode();
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
        new org.apache.axis.description.TypeDesc(DwFtEtapa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMensagemnok");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMensagemnok"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMensagemok");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMensagemok"));
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
        elemField.setFieldName("dwFtSubs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSubs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFtEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFtEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
