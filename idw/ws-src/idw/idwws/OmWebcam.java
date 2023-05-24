/**
 * OmWebcam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmWebcam  extends idw.idwws.OmWebcamTemplate  implements java.io.Serializable {
    private java.lang.String cdWebcam;

    private java.lang.String dsCurta;

    private java.lang.String dsWebcam;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idWebcam;

    private idw.idwws.OmObj[] omObjs;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    private java.lang.String url;

    public OmWebcam() {
    }

    public OmWebcam(
           java.lang.String cdWebcam,
           java.lang.String dsCurta,
           java.lang.String dsWebcam,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idWebcam,
           idw.idwws.OmObj[] omObjs,
           java.lang.Long revisao,
           java.lang.Byte stAtivo,
           java.lang.String url) {
        this.cdWebcam = cdWebcam;
        this.dsCurta = dsCurta;
        this.dsWebcam = dsWebcam;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idWebcam = idWebcam;
        this.omObjs = omObjs;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.url = url;
    }


    /**
     * Gets the cdWebcam value for this OmWebcam.
     * 
     * @return cdWebcam
     */
    public java.lang.String getCdWebcam() {
        return cdWebcam;
    }


    /**
     * Sets the cdWebcam value for this OmWebcam.
     * 
     * @param cdWebcam
     */
    public void setCdWebcam(java.lang.String cdWebcam) {
        this.cdWebcam = cdWebcam;
    }


    /**
     * Gets the dsCurta value for this OmWebcam.
     * 
     * @return dsCurta
     */
    public java.lang.String getDsCurta() {
        return dsCurta;
    }


    /**
     * Sets the dsCurta value for this OmWebcam.
     * 
     * @param dsCurta
     */
    public void setDsCurta(java.lang.String dsCurta) {
        this.dsCurta = dsCurta;
    }


    /**
     * Gets the dsWebcam value for this OmWebcam.
     * 
     * @return dsWebcam
     */
    public java.lang.String getDsWebcam() {
        return dsWebcam;
    }


    /**
     * Sets the dsWebcam value for this OmWebcam.
     * 
     * @param dsWebcam
     */
    public void setDsWebcam(java.lang.String dsWebcam) {
        this.dsWebcam = dsWebcam;
    }


    /**
     * Gets the dtRevisao value for this OmWebcam.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmWebcam.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmWebcam.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmWebcam.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idWebcam value for this OmWebcam.
     * 
     * @return idWebcam
     */
    public long getIdWebcam() {
        return idWebcam;
    }


    /**
     * Sets the idWebcam value for this OmWebcam.
     * 
     * @param idWebcam
     */
    public void setIdWebcam(long idWebcam) {
        this.idWebcam = idWebcam;
    }


    /**
     * Gets the omObjs value for this OmWebcam.
     * 
     * @return omObjs
     */
    public idw.idwws.OmObj[] getOmObjs() {
        return omObjs;
    }


    /**
     * Sets the omObjs value for this OmWebcam.
     * 
     * @param omObjs
     */
    public void setOmObjs(idw.idwws.OmObj[] omObjs) {
        this.omObjs = omObjs;
    }

    public idw.idwws.OmObj getOmObjs(int i) {
        return this.omObjs[i];
    }

    public void setOmObjs(int i, idw.idwws.OmObj _value) {
        this.omObjs[i] = _value;
    }


    /**
     * Gets the revisao value for this OmWebcam.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmWebcam.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmWebcam.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmWebcam.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the url value for this OmWebcam.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this OmWebcam.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmWebcam)) return false;
        OmWebcam other = (OmWebcam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdWebcam==null && other.getCdWebcam()==null) || 
             (this.cdWebcam!=null &&
              this.cdWebcam.equals(other.getCdWebcam()))) &&
            ((this.dsCurta==null && other.getDsCurta()==null) || 
             (this.dsCurta!=null &&
              this.dsCurta.equals(other.getDsCurta()))) &&
            ((this.dsWebcam==null && other.getDsWebcam()==null) || 
             (this.dsWebcam!=null &&
              this.dsWebcam.equals(other.getDsWebcam()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idWebcam == other.getIdWebcam() &&
            ((this.omObjs==null && other.getOmObjs()==null) || 
             (this.omObjs!=null &&
              java.util.Arrays.equals(this.omObjs, other.getOmObjs()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getCdWebcam() != null) {
            _hashCode += getCdWebcam().hashCode();
        }
        if (getDsCurta() != null) {
            _hashCode += getDsCurta().hashCode();
        }
        if (getDsWebcam() != null) {
            _hashCode += getDsWebcam().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdWebcam()).hashCode();
        if (getOmObjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjs(), i);
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
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmWebcam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omWebcam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdWebcam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdWebcam"));
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
        elemField.setFieldName("dsWebcam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsWebcam"));
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
        elemField.setFieldName("idWebcam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idWebcam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
