/**
 * DwPasstfsepmView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPasstfsepmView  implements java.io.Serializable {
    private java.util.Calendar dthrMedicao;

    private idw.idwws.DwPasstfse dwPasstfse;

    private java.math.BigDecimal fluxoe;

    private java.math.BigDecimal fluxos;

    private long idPasstfsepm;

    private java.math.BigDecimal msDthrmedicao;

    private java.math.BigDecimal tensao;

    private java.math.BigDecimal vlcorrente;

    public DwPasstfsepmView() {
    }

    public DwPasstfsepmView(
           java.util.Calendar dthrMedicao,
           idw.idwws.DwPasstfse dwPasstfse,
           java.math.BigDecimal fluxoe,
           java.math.BigDecimal fluxos,
           long idPasstfsepm,
           java.math.BigDecimal msDthrmedicao,
           java.math.BigDecimal tensao,
           java.math.BigDecimal vlcorrente) {
           this.dthrMedicao = dthrMedicao;
           this.dwPasstfse = dwPasstfse;
           this.fluxoe = fluxoe;
           this.fluxos = fluxos;
           this.idPasstfsepm = idPasstfsepm;
           this.msDthrmedicao = msDthrmedicao;
           this.tensao = tensao;
           this.vlcorrente = vlcorrente;
    }


    /**
     * Gets the dthrMedicao value for this DwPasstfsepmView.
     * 
     * @return dthrMedicao
     */
    public java.util.Calendar getDthrMedicao() {
        return dthrMedicao;
    }


    /**
     * Sets the dthrMedicao value for this DwPasstfsepmView.
     * 
     * @param dthrMedicao
     */
    public void setDthrMedicao(java.util.Calendar dthrMedicao) {
        this.dthrMedicao = dthrMedicao;
    }


    /**
     * Gets the dwPasstfse value for this DwPasstfsepmView.
     * 
     * @return dwPasstfse
     */
    public idw.idwws.DwPasstfse getDwPasstfse() {
        return dwPasstfse;
    }


    /**
     * Sets the dwPasstfse value for this DwPasstfsepmView.
     * 
     * @param dwPasstfse
     */
    public void setDwPasstfse(idw.idwws.DwPasstfse dwPasstfse) {
        this.dwPasstfse = dwPasstfse;
    }


    /**
     * Gets the fluxoe value for this DwPasstfsepmView.
     * 
     * @return fluxoe
     */
    public java.math.BigDecimal getFluxoe() {
        return fluxoe;
    }


    /**
     * Sets the fluxoe value for this DwPasstfsepmView.
     * 
     * @param fluxoe
     */
    public void setFluxoe(java.math.BigDecimal fluxoe) {
        this.fluxoe = fluxoe;
    }


    /**
     * Gets the fluxos value for this DwPasstfsepmView.
     * 
     * @return fluxos
     */
    public java.math.BigDecimal getFluxos() {
        return fluxos;
    }


    /**
     * Sets the fluxos value for this DwPasstfsepmView.
     * 
     * @param fluxos
     */
    public void setFluxos(java.math.BigDecimal fluxos) {
        this.fluxos = fluxos;
    }


    /**
     * Gets the idPasstfsepm value for this DwPasstfsepmView.
     * 
     * @return idPasstfsepm
     */
    public long getIdPasstfsepm() {
        return idPasstfsepm;
    }


    /**
     * Sets the idPasstfsepm value for this DwPasstfsepmView.
     * 
     * @param idPasstfsepm
     */
    public void setIdPasstfsepm(long idPasstfsepm) {
        this.idPasstfsepm = idPasstfsepm;
    }


    /**
     * Gets the msDthrmedicao value for this DwPasstfsepmView.
     * 
     * @return msDthrmedicao
     */
    public java.math.BigDecimal getMsDthrmedicao() {
        return msDthrmedicao;
    }


    /**
     * Sets the msDthrmedicao value for this DwPasstfsepmView.
     * 
     * @param msDthrmedicao
     */
    public void setMsDthrmedicao(java.math.BigDecimal msDthrmedicao) {
        this.msDthrmedicao = msDthrmedicao;
    }


    /**
     * Gets the tensao value for this DwPasstfsepmView.
     * 
     * @return tensao
     */
    public java.math.BigDecimal getTensao() {
        return tensao;
    }


    /**
     * Sets the tensao value for this DwPasstfsepmView.
     * 
     * @param tensao
     */
    public void setTensao(java.math.BigDecimal tensao) {
        this.tensao = tensao;
    }


    /**
     * Gets the vlcorrente value for this DwPasstfsepmView.
     * 
     * @return vlcorrente
     */
    public java.math.BigDecimal getVlcorrente() {
        return vlcorrente;
    }


    /**
     * Sets the vlcorrente value for this DwPasstfsepmView.
     * 
     * @param vlcorrente
     */
    public void setVlcorrente(java.math.BigDecimal vlcorrente) {
        this.vlcorrente = vlcorrente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPasstfsepmView)) return false;
        DwPasstfsepmView other = (DwPasstfsepmView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrMedicao==null && other.getDthrMedicao()==null) || 
             (this.dthrMedicao!=null &&
              this.dthrMedicao.equals(other.getDthrMedicao()))) &&
            ((this.dwPasstfse==null && other.getDwPasstfse()==null) || 
             (this.dwPasstfse!=null &&
              this.dwPasstfse.equals(other.getDwPasstfse()))) &&
            ((this.fluxoe==null && other.getFluxoe()==null) || 
             (this.fluxoe!=null &&
              this.fluxoe.equals(other.getFluxoe()))) &&
            ((this.fluxos==null && other.getFluxos()==null) || 
             (this.fluxos!=null &&
              this.fluxos.equals(other.getFluxos()))) &&
            this.idPasstfsepm == other.getIdPasstfsepm() &&
            ((this.msDthrmedicao==null && other.getMsDthrmedicao()==null) || 
             (this.msDthrmedicao!=null &&
              this.msDthrmedicao.equals(other.getMsDthrmedicao()))) &&
            ((this.tensao==null && other.getTensao()==null) || 
             (this.tensao!=null &&
              this.tensao.equals(other.getTensao()))) &&
            ((this.vlcorrente==null && other.getVlcorrente()==null) || 
             (this.vlcorrente!=null &&
              this.vlcorrente.equals(other.getVlcorrente())));
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
        if (getDthrMedicao() != null) {
            _hashCode += getDthrMedicao().hashCode();
        }
        if (getDwPasstfse() != null) {
            _hashCode += getDwPasstfse().hashCode();
        }
        if (getFluxoe() != null) {
            _hashCode += getFluxoe().hashCode();
        }
        if (getFluxos() != null) {
            _hashCode += getFluxos().hashCode();
        }
        _hashCode += new Long(getIdPasstfsepm()).hashCode();
        if (getMsDthrmedicao() != null) {
            _hashCode += getMsDthrmedicao().hashCode();
        }
        if (getTensao() != null) {
            _hashCode += getTensao().hashCode();
        }
        if (getVlcorrente() != null) {
            _hashCode += getVlcorrente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPasstfsepmView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfsepmView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrMedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrMedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("fluxoe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fluxoe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fluxos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fluxos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("tensao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlcorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlcorrente"));
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
