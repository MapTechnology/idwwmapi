/**
 * OmImg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmImg  extends idw.idwws.OmImgTemplate  implements java.io.Serializable {
    private java.lang.String cdImg;

    private java.lang.String dsImg;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idImg;

    private idw.idwws.OmGt[] omGts;

    private idw.idwws.OmObj[] omObjs;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    private java.lang.String urlImg;

    public OmImg() {
    }

    public OmImg(
           java.lang.String cdImg,
           java.lang.String dsImg,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idImg,
           idw.idwws.OmGt[] omGts,
           idw.idwws.OmObj[] omObjs,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo,
           java.lang.String urlImg) {
        this.cdImg = cdImg;
        this.dsImg = dsImg;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idImg = idImg;
        this.omGts = omGts;
        this.omObjs = omObjs;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.urlImg = urlImg;
    }


    /**
     * Gets the cdImg value for this OmImg.
     * 
     * @return cdImg
     */
    public java.lang.String getCdImg() {
        return cdImg;
    }


    /**
     * Sets the cdImg value for this OmImg.
     * 
     * @param cdImg
     */
    public void setCdImg(java.lang.String cdImg) {
        this.cdImg = cdImg;
    }


    /**
     * Gets the dsImg value for this OmImg.
     * 
     * @return dsImg
     */
    public java.lang.String getDsImg() {
        return dsImg;
    }


    /**
     * Sets the dsImg value for this OmImg.
     * 
     * @param dsImg
     */
    public void setDsImg(java.lang.String dsImg) {
        this.dsImg = dsImg;
    }


    /**
     * Gets the dtRevisao value for this OmImg.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmImg.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmImg.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmImg.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idImg value for this OmImg.
     * 
     * @return idImg
     */
    public long getIdImg() {
        return idImg;
    }


    /**
     * Sets the idImg value for this OmImg.
     * 
     * @param idImg
     */
    public void setIdImg(long idImg) {
        this.idImg = idImg;
    }


    /**
     * Gets the omGts value for this OmImg.
     * 
     * @return omGts
     */
    public idw.idwws.OmGt[] getOmGts() {
        return omGts;
    }


    /**
     * Sets the omGts value for this OmImg.
     * 
     * @param omGts
     */
    public void setOmGts(idw.idwws.OmGt[] omGts) {
        this.omGts = omGts;
    }

    public idw.idwws.OmGt getOmGts(int i) {
        return this.omGts[i];
    }

    public void setOmGts(int i, idw.idwws.OmGt _value) {
        this.omGts[i] = _value;
    }


    /**
     * Gets the omObjs value for this OmImg.
     * 
     * @return omObjs
     */
    public idw.idwws.OmObj[] getOmObjs() {
        return omObjs;
    }


    /**
     * Sets the omObjs value for this OmImg.
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
     * Gets the omUsrByIdUsrrevisao value for this OmImg.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmImg.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmImg.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmImg.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this OmImg.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmImg.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmImg.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmImg.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the urlImg value for this OmImg.
     * 
     * @return urlImg
     */
    public java.lang.String getUrlImg() {
        return urlImg;
    }


    /**
     * Sets the urlImg value for this OmImg.
     * 
     * @param urlImg
     */
    public void setUrlImg(java.lang.String urlImg) {
        this.urlImg = urlImg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmImg)) return false;
        OmImg other = (OmImg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdImg==null && other.getCdImg()==null) || 
             (this.cdImg!=null &&
              this.cdImg.equals(other.getCdImg()))) &&
            ((this.dsImg==null && other.getDsImg()==null) || 
             (this.dsImg!=null &&
              this.dsImg.equals(other.getDsImg()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idImg == other.getIdImg() &&
            ((this.omGts==null && other.getOmGts()==null) || 
             (this.omGts!=null &&
              java.util.Arrays.equals(this.omGts, other.getOmGts()))) &&
            ((this.omObjs==null && other.getOmObjs()==null) || 
             (this.omObjs!=null &&
              java.util.Arrays.equals(this.omObjs, other.getOmObjs()))) &&
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
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.urlImg==null && other.getUrlImg()==null) || 
             (this.urlImg!=null &&
              this.urlImg.equals(other.getUrlImg())));
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
        if (getCdImg() != null) {
            _hashCode += getCdImg().hashCode();
        }
        if (getDsImg() != null) {
            _hashCode += getDsImg().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdImg()).hashCode();
        if (getOmGts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        if (getUrlImg() != null) {
            _hashCode += getUrlImg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmImg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omImg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdImg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsImg"));
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
        elemField.setFieldName("idImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idImg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlImg"));
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
