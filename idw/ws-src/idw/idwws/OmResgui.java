/**
 * OmResgui.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmResgui  extends idw.idwws.OmResguiTemplate  implements java.io.Serializable {
    private java.lang.String cdResgui;

    private java.lang.String dsResgui;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private long idResgui;

    private idw.idwws.OmCfg[] omCfgs;

    private idw.idwws.OmGrnts[] omGrntses;

    private idw.idwws.OmResgui omResgui;

    private idw.idwws.OmResgui[] omResguis;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmResgui() {
    }

    public OmResgui(
           java.lang.String cdResgui,
           java.lang.String dsResgui,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           long idResgui,
           idw.idwws.OmCfg[] omCfgs,
           idw.idwws.OmGrnts[] omGrntses,
           idw.idwws.OmResgui omResgui,
           idw.idwws.OmResgui[] omResguis,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        this.cdResgui = cdResgui;
        this.dsResgui = dsResgui;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.idResgui = idResgui;
        this.omCfgs = omCfgs;
        this.omGrntses = omGrntses;
        this.omResgui = omResgui;
        this.omResguis = omResguis;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdResgui value for this OmResgui.
     * 
     * @return cdResgui
     */
    public java.lang.String getCdResgui() {
        return cdResgui;
    }


    /**
     * Sets the cdResgui value for this OmResgui.
     * 
     * @param cdResgui
     */
    public void setCdResgui(java.lang.String cdResgui) {
        this.cdResgui = cdResgui;
    }


    /**
     * Gets the dsResgui value for this OmResgui.
     * 
     * @return dsResgui
     */
    public java.lang.String getDsResgui() {
        return dsResgui;
    }


    /**
     * Sets the dsResgui value for this OmResgui.
     * 
     * @param dsResgui
     */
    public void setDsResgui(java.lang.String dsResgui) {
        this.dsResgui = dsResgui;
    }


    /**
     * Gets the dtRevisao value for this OmResgui.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmResgui.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmResgui.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmResgui.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idResgui value for this OmResgui.
     * 
     * @return idResgui
     */
    public long getIdResgui() {
        return idResgui;
    }


    /**
     * Sets the idResgui value for this OmResgui.
     * 
     * @param idResgui
     */
    public void setIdResgui(long idResgui) {
        this.idResgui = idResgui;
    }


    /**
     * Gets the omCfgs value for this OmResgui.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this OmResgui.
     * 
     * @param omCfgs
     */
    public void setOmCfgs(idw.idwws.OmCfg[] omCfgs) {
        this.omCfgs = omCfgs;
    }

    public idw.idwws.OmCfg getOmCfgs(int i) {
        return this.omCfgs[i];
    }

    public void setOmCfgs(int i, idw.idwws.OmCfg _value) {
        this.omCfgs[i] = _value;
    }


    /**
     * Gets the omGrntses value for this OmResgui.
     * 
     * @return omGrntses
     */
    public idw.idwws.OmGrnts[] getOmGrntses() {
        return omGrntses;
    }


    /**
     * Sets the omGrntses value for this OmResgui.
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
     * Gets the omResgui value for this OmResgui.
     * 
     * @return omResgui
     */
    public idw.idwws.OmResgui getOmResgui() {
        return omResgui;
    }


    /**
     * Sets the omResgui value for this OmResgui.
     * 
     * @param omResgui
     */
    public void setOmResgui(idw.idwws.OmResgui omResgui) {
        this.omResgui = omResgui;
    }


    /**
     * Gets the omResguis value for this OmResgui.
     * 
     * @return omResguis
     */
    public idw.idwws.OmResgui[] getOmResguis() {
        return omResguis;
    }


    /**
     * Sets the omResguis value for this OmResgui.
     * 
     * @param omResguis
     */
    public void setOmResguis(idw.idwws.OmResgui[] omResguis) {
        this.omResguis = omResguis;
    }

    public idw.idwws.OmResgui getOmResguis(int i) {
        return this.omResguis[i];
    }

    public void setOmResguis(int i, idw.idwws.OmResgui _value) {
        this.omResguis[i] = _value;
    }


    /**
     * Gets the revisao value for this OmResgui.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmResgui.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmResgui.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmResgui.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmResgui)) return false;
        OmResgui other = (OmResgui) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdResgui==null && other.getCdResgui()==null) || 
             (this.cdResgui!=null &&
              this.cdResgui.equals(other.getCdResgui()))) &&
            ((this.dsResgui==null && other.getDsResgui()==null) || 
             (this.dsResgui!=null &&
              this.dsResgui.equals(other.getDsResgui()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idResgui == other.getIdResgui() &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.omGrntses==null && other.getOmGrntses()==null) || 
             (this.omGrntses!=null &&
              java.util.Arrays.equals(this.omGrntses, other.getOmGrntses()))) &&
            ((this.omResgui==null && other.getOmResgui()==null) || 
             (this.omResgui!=null &&
              this.omResgui.equals(other.getOmResgui()))) &&
            ((this.omResguis==null && other.getOmResguis()==null) || 
             (this.omResguis!=null &&
              java.util.Arrays.equals(this.omResguis, other.getOmResguis()))) &&
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
        if (getCdResgui() != null) {
            _hashCode += getCdResgui().hashCode();
        }
        if (getDsResgui() != null) {
            _hashCode += getDsResgui().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdResgui()).hashCode();
        if (getOmCfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        if (getOmResgui() != null) {
            _hashCode += getOmResgui().hashCode();
        }
        if (getOmResguis() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmResguis());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmResguis(), i);
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
        new org.apache.axis.description.TypeDesc(OmResgui.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omResgui"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdResgui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdResgui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsResgui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsResgui"));
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
        elemField.setFieldName("idResgui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idResgui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("omResgui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omResgui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omResgui"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omResguis");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omResguis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omResgui"));
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
