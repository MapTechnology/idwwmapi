/**
 * OmUsrgrp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmUsrgrp  extends idw.idwws.OmUsrgrpTemplate  implements java.io.Serializable {
    private java.lang.String cdUsrgrp;

    private java.lang.String dsUsrGrp;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idUsrgrp;

    private idw.idwws.OmGrnts[] omGrntses;

    private idw.idwws.OmUsr[] omUsrs;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmUsrgrp() {
    }

    public OmUsrgrp(
           java.lang.Long id,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.String cdUsrgrp,
           java.lang.String dsUsrGrp,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idUsrgrp,
           idw.idwws.OmGrnts[] omGrntses,
           idw.idwws.OmUsr[] omUsrs,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id,
            omUsrByIdUsrrevisao,
            omUsrByIdUsrstativo);
        this.cdUsrgrp = cdUsrgrp;
        this.dsUsrGrp = dsUsrGrp;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idUsrgrp = idUsrgrp;
        this.omGrntses = omGrntses;
        this.omUsrs = omUsrs;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdUsrgrp value for this OmUsrgrp.
     * 
     * @return cdUsrgrp
     */
    public java.lang.String getCdUsrgrp() {
        return cdUsrgrp;
    }


    /**
     * Sets the cdUsrgrp value for this OmUsrgrp.
     * 
     * @param cdUsrgrp
     */
    public void setCdUsrgrp(java.lang.String cdUsrgrp) {
        this.cdUsrgrp = cdUsrgrp;
    }


    /**
     * Gets the dsUsrGrp value for this OmUsrgrp.
     * 
     * @return dsUsrGrp
     */
    public java.lang.String getDsUsrGrp() {
        return dsUsrGrp;
    }


    /**
     * Sets the dsUsrGrp value for this OmUsrgrp.
     * 
     * @param dsUsrGrp
     */
    public void setDsUsrGrp(java.lang.String dsUsrGrp) {
        this.dsUsrGrp = dsUsrGrp;
    }


    /**
     * Gets the dtRevisao value for this OmUsrgrp.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmUsrgrp.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmUsrgrp.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmUsrgrp.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idUsrgrp value for this OmUsrgrp.
     * 
     * @return idUsrgrp
     */
    public long getIdUsrgrp() {
        return idUsrgrp;
    }


    /**
     * Sets the idUsrgrp value for this OmUsrgrp.
     * 
     * @param idUsrgrp
     */
    public void setIdUsrgrp(long idUsrgrp) {
        this.idUsrgrp = idUsrgrp;
    }


    /**
     * Gets the omGrntses value for this OmUsrgrp.
     * 
     * @return omGrntses
     */
    public idw.idwws.OmGrnts[] getOmGrntses() {
        return omGrntses;
    }


    /**
     * Sets the omGrntses value for this OmUsrgrp.
     * 
     * @param omGrntses
     */
    public void setOmGrntses(idw.idwws.OmGrnts[] omGrntses) {
        this.omGrntses = omGrntses;
    }

    public idw.idwws.OmGrnts getOmGrntses(int i) {
        return this.omGrntses[i];
    }

    public void setOmGrntses(int i, idw.idwws.OmGrnts _value) {
        this.omGrntses[i] = _value;
    }


    /**
     * Gets the omUsrs value for this OmUsrgrp.
     * 
     * @return omUsrs
     */
    public idw.idwws.OmUsr[] getOmUsrs() {
        return omUsrs;
    }


    /**
     * Sets the omUsrs value for this OmUsrgrp.
     * 
     * @param omUsrs
     */
    public void setOmUsrs(idw.idwws.OmUsr[] omUsrs) {
        this.omUsrs = omUsrs;
    }

    public idw.idwws.OmUsr getOmUsrs(int i) {
        return this.omUsrs[i];
    }

    public void setOmUsrs(int i, idw.idwws.OmUsr _value) {
        this.omUsrs[i] = _value;
    }


    /**
     * Gets the revisao value for this OmUsrgrp.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmUsrgrp.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmUsrgrp.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmUsrgrp.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmUsrgrp)) return false;
        OmUsrgrp other = (OmUsrgrp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdUsrgrp==null && other.getCdUsrgrp()==null) || 
             (this.cdUsrgrp!=null &&
              this.cdUsrgrp.equals(other.getCdUsrgrp()))) &&
            ((this.dsUsrGrp==null && other.getDsUsrGrp()==null) || 
             (this.dsUsrGrp!=null &&
              this.dsUsrGrp.equals(other.getDsUsrGrp()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idUsrgrp == other.getIdUsrgrp() &&
            ((this.omGrntses==null && other.getOmGrntses()==null) || 
             (this.omGrntses!=null &&
              java.util.Arrays.equals(this.omGrntses, other.getOmGrntses()))) &&
            ((this.omUsrs==null && other.getOmUsrs()==null) || 
             (this.omUsrs!=null &&
              java.util.Arrays.equals(this.omUsrs, other.getOmUsrs()))) &&
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
        if (getCdUsrgrp() != null) {
            _hashCode += getCdUsrgrp().hashCode();
        }
        if (getDsUsrGrp() != null) {
            _hashCode += getDsUsrGrp().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdUsrgrp()).hashCode();
        if (getOmGrntses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGrntses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGrntses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUsrs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmUsrs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmUsrs(), i);
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
        new org.apache.axis.description.TypeDesc(OmUsrgrp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsrgrp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdUsrgrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdUsrgrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsUsrGrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsUsrGrp"));
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
        elemField.setFieldName("idUsrgrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsrgrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGrntses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGrntses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGrnts"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
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
