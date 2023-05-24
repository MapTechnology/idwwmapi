/**
 * LoginDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class LoginDTO  implements java.io.Serializable {
    private java.lang.String cdUsr;

    private java.util.Calendar dtHrILogin;

    private long idGt;

    private long idPt;

    private long idUsr;

    private idw.idwws.ResultadoDTO resultado;

    private java.math.BigDecimal segAutologout;

    private java.math.BigDecimal segFeedbacklogin;

    public LoginDTO() {
    }

    public LoginDTO(
           java.lang.String cdUsr,
           java.util.Calendar dtHrILogin,
           long idGt,
           long idPt,
           long idUsr,
           idw.idwws.ResultadoDTO resultado,
           java.math.BigDecimal segAutologout,
           java.math.BigDecimal segFeedbacklogin) {
           this.cdUsr = cdUsr;
           this.dtHrILogin = dtHrILogin;
           this.idGt = idGt;
           this.idPt = idPt;
           this.idUsr = idUsr;
           this.resultado = resultado;
           this.segAutologout = segAutologout;
           this.segFeedbacklogin = segFeedbacklogin;
    }


    /**
     * Gets the cdUsr value for this LoginDTO.
     * 
     * @return cdUsr
     */
    public java.lang.String getCdUsr() {
        return cdUsr;
    }


    /**
     * Sets the cdUsr value for this LoginDTO.
     * 
     * @param cdUsr
     */
    public void setCdUsr(java.lang.String cdUsr) {
        this.cdUsr = cdUsr;
    }


    /**
     * Gets the dtHrILogin value for this LoginDTO.
     * 
     * @return dtHrILogin
     */
    public java.util.Calendar getDtHrILogin() {
        return dtHrILogin;
    }


    /**
     * Sets the dtHrILogin value for this LoginDTO.
     * 
     * @param dtHrILogin
     */
    public void setDtHrILogin(java.util.Calendar dtHrILogin) {
        this.dtHrILogin = dtHrILogin;
    }


    /**
     * Gets the idGt value for this LoginDTO.
     * 
     * @return idGt
     */
    public long getIdGt() {
        return idGt;
    }


    /**
     * Sets the idGt value for this LoginDTO.
     * 
     * @param idGt
     */
    public void setIdGt(long idGt) {
        this.idGt = idGt;
    }


    /**
     * Gets the idPt value for this LoginDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this LoginDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idUsr value for this LoginDTO.
     * 
     * @return idUsr
     */
    public long getIdUsr() {
        return idUsr;
    }


    /**
     * Sets the idUsr value for this LoginDTO.
     * 
     * @param idUsr
     */
    public void setIdUsr(long idUsr) {
        this.idUsr = idUsr;
    }


    /**
     * Gets the resultado value for this LoginDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this LoginDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the segAutologout value for this LoginDTO.
     * 
     * @return segAutologout
     */
    public java.math.BigDecimal getSegAutologout() {
        return segAutologout;
    }


    /**
     * Sets the segAutologout value for this LoginDTO.
     * 
     * @param segAutologout
     */
    public void setSegAutologout(java.math.BigDecimal segAutologout) {
        this.segAutologout = segAutologout;
    }


    /**
     * Gets the segFeedbacklogin value for this LoginDTO.
     * 
     * @return segFeedbacklogin
     */
    public java.math.BigDecimal getSegFeedbacklogin() {
        return segFeedbacklogin;
    }


    /**
     * Sets the segFeedbacklogin value for this LoginDTO.
     * 
     * @param segFeedbacklogin
     */
    public void setSegFeedbacklogin(java.math.BigDecimal segFeedbacklogin) {
        this.segFeedbacklogin = segFeedbacklogin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginDTO)) return false;
        LoginDTO other = (LoginDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdUsr==null && other.getCdUsr()==null) || 
             (this.cdUsr!=null &&
              this.cdUsr.equals(other.getCdUsr()))) &&
            ((this.dtHrILogin==null && other.getDtHrILogin()==null) || 
             (this.dtHrILogin!=null &&
              this.dtHrILogin.equals(other.getDtHrILogin()))) &&
            this.idGt == other.getIdGt() &&
            this.idPt == other.getIdPt() &&
            this.idUsr == other.getIdUsr() &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.segAutologout==null && other.getSegAutologout()==null) || 
             (this.segAutologout!=null &&
              this.segAutologout.equals(other.getSegAutologout()))) &&
            ((this.segFeedbacklogin==null && other.getSegFeedbacklogin()==null) || 
             (this.segFeedbacklogin!=null &&
              this.segFeedbacklogin.equals(other.getSegFeedbacklogin())));
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
        if (getCdUsr() != null) {
            _hashCode += getCdUsr().hashCode();
        }
        if (getDtHrILogin() != null) {
            _hashCode += getDtHrILogin().hashCode();
        }
        _hashCode += new Long(getIdGt()).hashCode();
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdUsr()).hashCode();
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getSegAutologout() != null) {
            _hashCode += getSegAutologout().hashCode();
        }
        if (getSegFeedbacklogin() != null) {
            _hashCode += getSegFeedbacklogin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "loginDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrILogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrILogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutologout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutologout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segFeedbacklogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segFeedbacklogin"));
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
