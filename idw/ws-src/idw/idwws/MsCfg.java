/**
 * MsCfg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsCfg  implements java.io.Serializable {
    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private java.math.BigDecimal idCfg;

    private idw.idwws.MsUsr msUsr;

    private java.math.BigDecimal revisao;

    private java.math.BigDecimal stAtivo;

    private java.math.BigDecimal tpCalculoandon;

    public MsCfg() {
    }

    public MsCfg(
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           java.math.BigDecimal idCfg,
           idw.idwws.MsUsr msUsr,
           java.math.BigDecimal revisao,
           java.math.BigDecimal stAtivo,
           java.math.BigDecimal tpCalculoandon) {
           this.dthrRevisao = dthrRevisao;
           this.dthrStativo = dthrStativo;
           this.idCfg = idCfg;
           this.msUsr = msUsr;
           this.revisao = revisao;
           this.stAtivo = stAtivo;
           this.tpCalculoandon = tpCalculoandon;
    }


    /**
     * Gets the dthrRevisao value for this MsCfg.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this MsCfg.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this MsCfg.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this MsCfg.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the idCfg value for this MsCfg.
     * 
     * @return idCfg
     */
    public java.math.BigDecimal getIdCfg() {
        return idCfg;
    }


    /**
     * Sets the idCfg value for this MsCfg.
     * 
     * @param idCfg
     */
    public void setIdCfg(java.math.BigDecimal idCfg) {
        this.idCfg = idCfg;
    }


    /**
     * Gets the msUsr value for this MsCfg.
     * 
     * @return msUsr
     */
    public idw.idwws.MsUsr getMsUsr() {
        return msUsr;
    }


    /**
     * Sets the msUsr value for this MsCfg.
     * 
     * @param msUsr
     */
    public void setMsUsr(idw.idwws.MsUsr msUsr) {
        this.msUsr = msUsr;
    }


    /**
     * Gets the revisao value for this MsCfg.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this MsCfg.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this MsCfg.
     * 
     * @return stAtivo
     */
    public java.math.BigDecimal getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this MsCfg.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.math.BigDecimal stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpCalculoandon value for this MsCfg.
     * 
     * @return tpCalculoandon
     */
    public java.math.BigDecimal getTpCalculoandon() {
        return tpCalculoandon;
    }


    /**
     * Sets the tpCalculoandon value for this MsCfg.
     * 
     * @param tpCalculoandon
     */
    public void setTpCalculoandon(java.math.BigDecimal tpCalculoandon) {
        this.tpCalculoandon = tpCalculoandon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsCfg)) return false;
        MsCfg other = (MsCfg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            ((this.idCfg==null && other.getIdCfg()==null) || 
             (this.idCfg!=null &&
              this.idCfg.equals(other.getIdCfg()))) &&
            ((this.msUsr==null && other.getMsUsr()==null) || 
             (this.msUsr!=null &&
              this.msUsr.equals(other.getMsUsr()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpCalculoandon==null && other.getTpCalculoandon()==null) || 
             (this.tpCalculoandon!=null &&
              this.tpCalculoandon.equals(other.getTpCalculoandon())));
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
        if (getDthrRevisao() != null) {
            _hashCode += getDthrRevisao().hashCode();
        }
        if (getDthrStativo() != null) {
            _hashCode += getDthrStativo().hashCode();
        }
        if (getIdCfg() != null) {
            _hashCode += getIdCfg().hashCode();
        }
        if (getMsUsr() != null) {
            _hashCode += getMsUsr().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpCalculoandon() != null) {
            _hashCode += getTpCalculoandon().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsCfg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msCfg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpCalculoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpCalculoandon"));
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
