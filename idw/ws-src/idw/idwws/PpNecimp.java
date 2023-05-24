/**
 * PpNecimp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecimp  extends idw.idwws.PpNecimpTemplate  implements java.io.Serializable {
    private java.lang.String cdNecimp;

    private java.lang.String dsNecimp;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.lang.Long idNecimp;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpNecimplog[] ppNecimplogs;

    private idw.idwws.PpNecimpurl[] ppNecimpurls;

    private java.lang.Integer revisao;

    private java.lang.Byte stAtivo;

    private java.math.BigDecimal tpNecimp;

    public PpNecimp() {
    }

    public PpNecimp(
           java.lang.String cdNecimp,
           java.lang.String dsNecimp,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.lang.Long idNecimp,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpNecimplog[] ppNecimplogs,
           idw.idwws.PpNecimpurl[] ppNecimpurls,
           java.lang.Integer revisao,
           java.lang.Byte stAtivo,
           java.math.BigDecimal tpNecimp) {
        this.cdNecimp = cdNecimp;
        this.dsNecimp = dsNecimp;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idNecimp = idNecimp;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppNecimplogs = ppNecimplogs;
        this.ppNecimpurls = ppNecimpurls;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.tpNecimp = tpNecimp;
    }


    /**
     * Gets the cdNecimp value for this PpNecimp.
     * 
     * @return cdNecimp
     */
    public java.lang.String getCdNecimp() {
        return cdNecimp;
    }


    /**
     * Sets the cdNecimp value for this PpNecimp.
     * 
     * @param cdNecimp
     */
    public void setCdNecimp(java.lang.String cdNecimp) {
        this.cdNecimp = cdNecimp;
    }


    /**
     * Gets the dsNecimp value for this PpNecimp.
     * 
     * @return dsNecimp
     */
    public java.lang.String getDsNecimp() {
        return dsNecimp;
    }


    /**
     * Sets the dsNecimp value for this PpNecimp.
     * 
     * @param dsNecimp
     */
    public void setDsNecimp(java.lang.String dsNecimp) {
        this.dsNecimp = dsNecimp;
    }


    /**
     * Gets the dtRevisao value for this PpNecimp.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this PpNecimp.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this PpNecimp.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this PpNecimp.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idNecimp value for this PpNecimp.
     * 
     * @return idNecimp
     */
    public java.lang.Long getIdNecimp() {
        return idNecimp;
    }


    /**
     * Sets the idNecimp value for this PpNecimp.
     * 
     * @param idNecimp
     */
    public void setIdNecimp(java.lang.Long idNecimp) {
        this.idNecimp = idNecimp;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this PpNecimp.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this PpNecimp.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this PpNecimp.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this PpNecimp.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppNecimplogs value for this PpNecimp.
     * 
     * @return ppNecimplogs
     */
    public idw.idwws.PpNecimplog[] getPpNecimplogs() {
        return ppNecimplogs;
    }


    /**
     * Sets the ppNecimplogs value for this PpNecimp.
     * 
     * @param ppNecimplogs
     */
    public void setPpNecimplogs(idw.idwws.PpNecimplog[] ppNecimplogs) {
        this.ppNecimplogs = ppNecimplogs;
    }

    public idw.idwws.PpNecimplog getPpNecimplogs(int i) {
        return this.ppNecimplogs[i];
    }

    public void setPpNecimplogs(int i, idw.idwws.PpNecimplog _value) {
        this.ppNecimplogs[i] = _value;
    }


    /**
     * Gets the ppNecimpurls value for this PpNecimp.
     * 
     * @return ppNecimpurls
     */
    public idw.idwws.PpNecimpurl[] getPpNecimpurls() {
        return ppNecimpurls;
    }


    /**
     * Sets the ppNecimpurls value for this PpNecimp.
     * 
     * @param ppNecimpurls
     */
    public void setPpNecimpurls(idw.idwws.PpNecimpurl[] ppNecimpurls) {
        this.ppNecimpurls = ppNecimpurls;
    }

    public idw.idwws.PpNecimpurl getPpNecimpurls(int i) {
        return this.ppNecimpurls[i];
    }

    public void setPpNecimpurls(int i, idw.idwws.PpNecimpurl _value) {
        this.ppNecimpurls[i] = _value;
    }


    /**
     * Gets the revisao value for this PpNecimp.
     * 
     * @return revisao
     */
    public java.lang.Integer getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this PpNecimp.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Integer revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this PpNecimp.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this PpNecimp.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpNecimp value for this PpNecimp.
     * 
     * @return tpNecimp
     */
    public java.math.BigDecimal getTpNecimp() {
        return tpNecimp;
    }


    /**
     * Sets the tpNecimp value for this PpNecimp.
     * 
     * @param tpNecimp
     */
    public void setTpNecimp(java.math.BigDecimal tpNecimp) {
        this.tpNecimp = tpNecimp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecimp)) return false;
        PpNecimp other = (PpNecimp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdNecimp==null && other.getCdNecimp()==null) || 
             (this.cdNecimp!=null &&
              this.cdNecimp.equals(other.getCdNecimp()))) &&
            ((this.dsNecimp==null && other.getDsNecimp()==null) || 
             (this.dsNecimp!=null &&
              this.dsNecimp.equals(other.getDsNecimp()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.idNecimp==null && other.getIdNecimp()==null) || 
             (this.idNecimp!=null &&
              this.idNecimp.equals(other.getIdNecimp()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppNecimplogs==null && other.getPpNecimplogs()==null) || 
             (this.ppNecimplogs!=null &&
              java.util.Arrays.equals(this.ppNecimplogs, other.getPpNecimplogs()))) &&
            ((this.ppNecimpurls==null && other.getPpNecimpurls()==null) || 
             (this.ppNecimpurls!=null &&
              java.util.Arrays.equals(this.ppNecimpurls, other.getPpNecimpurls()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpNecimp==null && other.getTpNecimp()==null) || 
             (this.tpNecimp!=null &&
              this.tpNecimp.equals(other.getTpNecimp())));
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
        if (getCdNecimp() != null) {
            _hashCode += getCdNecimp().hashCode();
        }
        if (getDsNecimp() != null) {
            _hashCode += getDsNecimp().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getIdNecimp() != null) {
            _hashCode += getIdNecimp().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpNecimplogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecimplogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecimplogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpNecimpurls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecimpurls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecimpurls(), i);
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
        if (getTpNecimp() != null) {
            _hashCode += getTpNecimp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNecimp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdNecimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdNecimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsNecimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsNecimp"));
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
        elemField.setFieldName("idNecimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNecimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("ppNecimplogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimplogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimplog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimpurls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimpurls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpNecimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpNecimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
