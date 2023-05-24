/**
 * OmCfgscrpimp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmCfgscrpimp  extends idw.idwws.OmCfgscrpimpTemplate  implements java.io.Serializable {
    private java.lang.String cdScrp;

    private java.lang.String dsScrp;

    private long idCfgscrpimp;

    private idw.idwws.OmCfg omCfg;

    private java.lang.Long revisao;

    private java.lang.String scriptimpressao;

    private java.lang.Byte stativo;

    public OmCfgscrpimp() {
    }

    public OmCfgscrpimp(
           java.lang.String cdScrp,
           java.lang.String dsScrp,
           long idCfgscrpimp,
           idw.idwws.OmCfg omCfg,
           java.lang.Long revisao,
           java.lang.String scriptimpressao,
           java.lang.Byte stativo) {
        this.cdScrp = cdScrp;
        this.dsScrp = dsScrp;
        this.idCfgscrpimp = idCfgscrpimp;
        this.omCfg = omCfg;
        this.revisao = revisao;
        this.scriptimpressao = scriptimpressao;
        this.stativo = stativo;
    }


    /**
     * Gets the cdScrp value for this OmCfgscrpimp.
     * 
     * @return cdScrp
     */
    public java.lang.String getCdScrp() {
        return cdScrp;
    }


    /**
     * Sets the cdScrp value for this OmCfgscrpimp.
     * 
     * @param cdScrp
     */
    public void setCdScrp(java.lang.String cdScrp) {
        this.cdScrp = cdScrp;
    }


    /**
     * Gets the dsScrp value for this OmCfgscrpimp.
     * 
     * @return dsScrp
     */
    public java.lang.String getDsScrp() {
        return dsScrp;
    }


    /**
     * Sets the dsScrp value for this OmCfgscrpimp.
     * 
     * @param dsScrp
     */
    public void setDsScrp(java.lang.String dsScrp) {
        this.dsScrp = dsScrp;
    }


    /**
     * Gets the idCfgscrpimp value for this OmCfgscrpimp.
     * 
     * @return idCfgscrpimp
     */
    public long getIdCfgscrpimp() {
        return idCfgscrpimp;
    }


    /**
     * Sets the idCfgscrpimp value for this OmCfgscrpimp.
     * 
     * @param idCfgscrpimp
     */
    public void setIdCfgscrpimp(long idCfgscrpimp) {
        this.idCfgscrpimp = idCfgscrpimp;
    }


    /**
     * Gets the omCfg value for this OmCfgscrpimp.
     * 
     * @return omCfg
     */
    public idw.idwws.OmCfg getOmCfg() {
        return omCfg;
    }


    /**
     * Sets the omCfg value for this OmCfgscrpimp.
     * 
     * @param omCfg
     */
    public void setOmCfg(idw.idwws.OmCfg omCfg) {
        this.omCfg = omCfg;
    }


    /**
     * Gets the revisao value for this OmCfgscrpimp.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmCfgscrpimp.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the scriptimpressao value for this OmCfgscrpimp.
     * 
     * @return scriptimpressao
     */
    public java.lang.String getScriptimpressao() {
        return scriptimpressao;
    }


    /**
     * Sets the scriptimpressao value for this OmCfgscrpimp.
     * 
     * @param scriptimpressao
     */
    public void setScriptimpressao(java.lang.String scriptimpressao) {
        this.scriptimpressao = scriptimpressao;
    }


    /**
     * Gets the stativo value for this OmCfgscrpimp.
     * 
     * @return stativo
     */
    public java.lang.Byte getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this OmCfgscrpimp.
     * 
     * @param stativo
     */
    public void setStativo(java.lang.Byte stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmCfgscrpimp)) return false;
        OmCfgscrpimp other = (OmCfgscrpimp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdScrp==null && other.getCdScrp()==null) || 
             (this.cdScrp!=null &&
              this.cdScrp.equals(other.getCdScrp()))) &&
            ((this.dsScrp==null && other.getDsScrp()==null) || 
             (this.dsScrp!=null &&
              this.dsScrp.equals(other.getDsScrp()))) &&
            this.idCfgscrpimp == other.getIdCfgscrpimp() &&
            ((this.omCfg==null && other.getOmCfg()==null) || 
             (this.omCfg!=null &&
              this.omCfg.equals(other.getOmCfg()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.scriptimpressao==null && other.getScriptimpressao()==null) || 
             (this.scriptimpressao!=null &&
              this.scriptimpressao.equals(other.getScriptimpressao()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo())));
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
        if (getCdScrp() != null) {
            _hashCode += getCdScrp().hashCode();
        }
        if (getDsScrp() != null) {
            _hashCode += getDsScrp().hashCode();
        }
        _hashCode += new Long(getIdCfgscrpimp()).hashCode();
        if (getOmCfg() != null) {
            _hashCode += getOmCfg().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getScriptimpressao() != null) {
            _hashCode += getScriptimpressao().hashCode();
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmCfgscrpimp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgscrpimp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdScrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdScrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsScrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsScrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCfgscrpimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCfgscrpimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
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
        elemField.setFieldName("scriptimpressao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scriptimpressao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
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
