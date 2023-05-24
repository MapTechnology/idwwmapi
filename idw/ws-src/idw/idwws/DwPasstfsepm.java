/**
 * DwPasstfsepm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPasstfsepm  extends idw.idwws.DwPasstfsepmTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrMedicao;

    private idw.idwws.DwFtParam dwFtParam;

    private idw.idwws.DwPasstfse dwPasstfse;

    private long idPasstfsepm;

    private java.math.BigDecimal msDthrmedicao;

    private java.lang.Integer stFase;

    private java.math.BigDecimal stMedido;

    private java.math.BigDecimal vlMedido;

    public DwPasstfsepm() {
    }

    public DwPasstfsepm(
           java.util.Calendar dthrMedicao,
           idw.idwws.DwFtParam dwFtParam,
           idw.idwws.DwPasstfse dwPasstfse,
           long idPasstfsepm,
           java.math.BigDecimal msDthrmedicao,
           java.lang.Integer stFase,
           java.math.BigDecimal stMedido,
           java.math.BigDecimal vlMedido) {
        this.dthrMedicao = dthrMedicao;
        this.dwFtParam = dwFtParam;
        this.dwPasstfse = dwPasstfse;
        this.idPasstfsepm = idPasstfsepm;
        this.msDthrmedicao = msDthrmedicao;
        this.stFase = stFase;
        this.stMedido = stMedido;
        this.vlMedido = vlMedido;
    }


    /**
     * Gets the dthrMedicao value for this DwPasstfsepm.
     * 
     * @return dthrMedicao
     */
    public java.util.Calendar getDthrMedicao() {
        return dthrMedicao;
    }


    /**
     * Sets the dthrMedicao value for this DwPasstfsepm.
     * 
     * @param dthrMedicao
     */
    public void setDthrMedicao(java.util.Calendar dthrMedicao) {
        this.dthrMedicao = dthrMedicao;
    }


    /**
     * Gets the dwFtParam value for this DwPasstfsepm.
     * 
     * @return dwFtParam
     */
    public idw.idwws.DwFtParam getDwFtParam() {
        return dwFtParam;
    }


    /**
     * Sets the dwFtParam value for this DwPasstfsepm.
     * 
     * @param dwFtParam
     */
    public void setDwFtParam(idw.idwws.DwFtParam dwFtParam) {
        this.dwFtParam = dwFtParam;
    }


    /**
     * Gets the dwPasstfse value for this DwPasstfsepm.
     * 
     * @return dwPasstfse
     */
    public idw.idwws.DwPasstfse getDwPasstfse() {
        return dwPasstfse;
    }


    /**
     * Sets the dwPasstfse value for this DwPasstfsepm.
     * 
     * @param dwPasstfse
     */
    public void setDwPasstfse(idw.idwws.DwPasstfse dwPasstfse) {
        this.dwPasstfse = dwPasstfse;
    }


    /**
     * Gets the idPasstfsepm value for this DwPasstfsepm.
     * 
     * @return idPasstfsepm
     */
    public long getIdPasstfsepm() {
        return idPasstfsepm;
    }


    /**
     * Sets the idPasstfsepm value for this DwPasstfsepm.
     * 
     * @param idPasstfsepm
     */
    public void setIdPasstfsepm(long idPasstfsepm) {
        this.idPasstfsepm = idPasstfsepm;
    }


    /**
     * Gets the msDthrmedicao value for this DwPasstfsepm.
     * 
     * @return msDthrmedicao
     */
    public java.math.BigDecimal getMsDthrmedicao() {
        return msDthrmedicao;
    }


    /**
     * Sets the msDthrmedicao value for this DwPasstfsepm.
     * 
     * @param msDthrmedicao
     */
    public void setMsDthrmedicao(java.math.BigDecimal msDthrmedicao) {
        this.msDthrmedicao = msDthrmedicao;
    }


    /**
     * Gets the stFase value for this DwPasstfsepm.
     * 
     * @return stFase
     */
    public java.lang.Integer getStFase() {
        return stFase;
    }


    /**
     * Sets the stFase value for this DwPasstfsepm.
     * 
     * @param stFase
     */
    public void setStFase(java.lang.Integer stFase) {
        this.stFase = stFase;
    }


    /**
     * Gets the stMedido value for this DwPasstfsepm.
     * 
     * @return stMedido
     */
    public java.math.BigDecimal getStMedido() {
        return stMedido;
    }


    /**
     * Sets the stMedido value for this DwPasstfsepm.
     * 
     * @param stMedido
     */
    public void setStMedido(java.math.BigDecimal stMedido) {
        this.stMedido = stMedido;
    }


    /**
     * Gets the vlMedido value for this DwPasstfsepm.
     * 
     * @return vlMedido
     */
    public java.math.BigDecimal getVlMedido() {
        return vlMedido;
    }


    /**
     * Sets the vlMedido value for this DwPasstfsepm.
     * 
     * @param vlMedido
     */
    public void setVlMedido(java.math.BigDecimal vlMedido) {
        this.vlMedido = vlMedido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPasstfsepm)) return false;
        DwPasstfsepm other = (DwPasstfsepm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrMedicao==null && other.getDthrMedicao()==null) || 
             (this.dthrMedicao!=null &&
              this.dthrMedicao.equals(other.getDthrMedicao()))) &&
            ((this.dwFtParam==null && other.getDwFtParam()==null) || 
             (this.dwFtParam!=null &&
              this.dwFtParam.equals(other.getDwFtParam()))) &&
            ((this.dwPasstfse==null && other.getDwPasstfse()==null) || 
             (this.dwPasstfse!=null &&
              this.dwPasstfse.equals(other.getDwPasstfse()))) &&
            this.idPasstfsepm == other.getIdPasstfsepm() &&
            ((this.msDthrmedicao==null && other.getMsDthrmedicao()==null) || 
             (this.msDthrmedicao!=null &&
              this.msDthrmedicao.equals(other.getMsDthrmedicao()))) &&
            ((this.stFase==null && other.getStFase()==null) || 
             (this.stFase!=null &&
              this.stFase.equals(other.getStFase()))) &&
            ((this.stMedido==null && other.getStMedido()==null) || 
             (this.stMedido!=null &&
              this.stMedido.equals(other.getStMedido()))) &&
            ((this.vlMedido==null && other.getVlMedido()==null) || 
             (this.vlMedido!=null &&
              this.vlMedido.equals(other.getVlMedido())));
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
        if (getDthrMedicao() != null) {
            _hashCode += getDthrMedicao().hashCode();
        }
        if (getDwFtParam() != null) {
            _hashCode += getDwFtParam().hashCode();
        }
        if (getDwPasstfse() != null) {
            _hashCode += getDwPasstfse().hashCode();
        }
        _hashCode += new Long(getIdPasstfsepm()).hashCode();
        if (getMsDthrmedicao() != null) {
            _hashCode += getMsDthrmedicao().hashCode();
        }
        if (getStFase() != null) {
            _hashCode += getStFase().hashCode();
        }
        if (getStMedido() != null) {
            _hashCode += getStMedido().hashCode();
        }
        if (getVlMedido() != null) {
            _hashCode += getVlMedido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPasstfsepm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfsepm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrMedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrMedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasstfse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasstfse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPasstfsepm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPasstfsepm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrmedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrmedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stFase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stFase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stMedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stMedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlMedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlMedido"));
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
