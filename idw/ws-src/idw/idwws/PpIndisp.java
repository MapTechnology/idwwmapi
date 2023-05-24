/**
 * PpIndisp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpIndisp  extends idw.idwws.PpIndispTemplate  implements java.io.Serializable {
    private java.lang.String cdIndisp;

    private java.lang.String dsIndisp;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.lang.Long idIndisp;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpIndispRappt[] ppIndispRappts;

    private java.lang.Long revisao;

    private java.lang.Integer stAtivo;

    private java.lang.Integer stIndisp;

    public PpIndisp() {
    }

    public PpIndisp(
           java.lang.String cdIndisp,
           java.lang.String dsIndisp,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.lang.Long idIndisp,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpIndispRappt[] ppIndispRappts,
           java.lang.Long revisao,
           java.lang.Integer stAtivo,
           java.lang.Integer stIndisp) {
        this.cdIndisp = cdIndisp;
        this.dsIndisp = dsIndisp;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idIndisp = idIndisp;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppIndispRappts = ppIndispRappts;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.stIndisp = stIndisp;
    }


    /**
     * Gets the cdIndisp value for this PpIndisp.
     * 
     * @return cdIndisp
     */
    public java.lang.String getCdIndisp() {
        return cdIndisp;
    }


    /**
     * Sets the cdIndisp value for this PpIndisp.
     * 
     * @param cdIndisp
     */
    public void setCdIndisp(java.lang.String cdIndisp) {
        this.cdIndisp = cdIndisp;
    }


    /**
     * Gets the dsIndisp value for this PpIndisp.
     * 
     * @return dsIndisp
     */
    public java.lang.String getDsIndisp() {
        return dsIndisp;
    }


    /**
     * Sets the dsIndisp value for this PpIndisp.
     * 
     * @param dsIndisp
     */
    public void setDsIndisp(java.lang.String dsIndisp) {
        this.dsIndisp = dsIndisp;
    }


    /**
     * Gets the dtRevisao value for this PpIndisp.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this PpIndisp.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this PpIndisp.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this PpIndisp.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idIndisp value for this PpIndisp.
     * 
     * @return idIndisp
     */
    public java.lang.Long getIdIndisp() {
        return idIndisp;
    }


    /**
     * Sets the idIndisp value for this PpIndisp.
     * 
     * @param idIndisp
     */
    public void setIdIndisp(java.lang.Long idIndisp) {
        this.idIndisp = idIndisp;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this PpIndisp.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this PpIndisp.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this PpIndisp.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this PpIndisp.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppIndispRappts value for this PpIndisp.
     * 
     * @return ppIndispRappts
     */
    public idw.idwws.PpIndispRappt[] getPpIndispRappts() {
        return ppIndispRappts;
    }


    /**
     * Sets the ppIndispRappts value for this PpIndisp.
     * 
     * @param ppIndispRappts
     */
    public void setPpIndispRappts(idw.idwws.PpIndispRappt[] ppIndispRappts) {
        this.ppIndispRappts = ppIndispRappts;
    }

    public idw.idwws.PpIndispRappt getPpIndispRappts(int i) {
        return this.ppIndispRappts[i];
    }

    public void setPpIndispRappts(int i, idw.idwws.PpIndispRappt _value) {
        this.ppIndispRappts[i] = _value;
    }


    /**
     * Gets the revisao value for this PpIndisp.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this PpIndisp.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this PpIndisp.
     * 
     * @return stAtivo
     */
    public java.lang.Integer getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this PpIndisp.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Integer stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the stIndisp value for this PpIndisp.
     * 
     * @return stIndisp
     */
    public java.lang.Integer getStIndisp() {
        return stIndisp;
    }


    /**
     * Sets the stIndisp value for this PpIndisp.
     * 
     * @param stIndisp
     */
    public void setStIndisp(java.lang.Integer stIndisp) {
        this.stIndisp = stIndisp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpIndisp)) return false;
        PpIndisp other = (PpIndisp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdIndisp==null && other.getCdIndisp()==null) || 
             (this.cdIndisp!=null &&
              this.cdIndisp.equals(other.getCdIndisp()))) &&
            ((this.dsIndisp==null && other.getDsIndisp()==null) || 
             (this.dsIndisp!=null &&
              this.dsIndisp.equals(other.getDsIndisp()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.idIndisp==null && other.getIdIndisp()==null) || 
             (this.idIndisp!=null &&
              this.idIndisp.equals(other.getIdIndisp()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppIndispRappts==null && other.getPpIndispRappts()==null) || 
             (this.ppIndispRappts!=null &&
              java.util.Arrays.equals(this.ppIndispRappts, other.getPpIndispRappts()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.stIndisp==null && other.getStIndisp()==null) || 
             (this.stIndisp!=null &&
              this.stIndisp.equals(other.getStIndisp())));
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
        if (getCdIndisp() != null) {
            _hashCode += getCdIndisp().hashCode();
        }
        if (getDsIndisp() != null) {
            _hashCode += getDsIndisp().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getIdIndisp() != null) {
            _hashCode += getIdIndisp().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpIndispRappts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpIndispRappts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpIndispRappts(), i);
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
        if (getStIndisp() != null) {
            _hashCode += getStIndisp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpIndisp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppIndisp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdIndisp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdIndisp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsIndisp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsIndisp"));
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
        elemField.setFieldName("idIndisp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIndisp"));
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
        elemField.setFieldName("ppIndispRappts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppIndispRappts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppIndispRappt"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stIndisp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stIndisp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
