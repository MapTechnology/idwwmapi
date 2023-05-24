/**
 * TtSapCon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TtSapCon  extends idw.idwws.TtSapConTemplate  implements java.io.Serializable {
    private java.lang.String centro;

    private java.lang.String conhecimento;

    private java.lang.String deposito;

    private java.lang.String dsErro;

    private java.util.Calendar dtConhecimento;

    private java.util.Calendar dthrReferencia;

    private java.math.BigDecimal idSapcon;

    private java.math.BigDecimal isImportado;

    public TtSapCon() {
    }

    public TtSapCon(
           java.lang.String centro,
           java.lang.String conhecimento,
           java.lang.String deposito,
           java.lang.String dsErro,
           java.util.Calendar dtConhecimento,
           java.util.Calendar dthrReferencia,
           java.math.BigDecimal idSapcon,
           java.math.BigDecimal isImportado) {
        this.centro = centro;
        this.conhecimento = conhecimento;
        this.deposito = deposito;
        this.dsErro = dsErro;
        this.dtConhecimento = dtConhecimento;
        this.dthrReferencia = dthrReferencia;
        this.idSapcon = idSapcon;
        this.isImportado = isImportado;
    }


    /**
     * Gets the centro value for this TtSapCon.
     * 
     * @return centro
     */
    public java.lang.String getCentro() {
        return centro;
    }


    /**
     * Sets the centro value for this TtSapCon.
     * 
     * @param centro
     */
    public void setCentro(java.lang.String centro) {
        this.centro = centro;
    }


    /**
     * Gets the conhecimento value for this TtSapCon.
     * 
     * @return conhecimento
     */
    public java.lang.String getConhecimento() {
        return conhecimento;
    }


    /**
     * Sets the conhecimento value for this TtSapCon.
     * 
     * @param conhecimento
     */
    public void setConhecimento(java.lang.String conhecimento) {
        this.conhecimento = conhecimento;
    }


    /**
     * Gets the deposito value for this TtSapCon.
     * 
     * @return deposito
     */
    public java.lang.String getDeposito() {
        return deposito;
    }


    /**
     * Sets the deposito value for this TtSapCon.
     * 
     * @param deposito
     */
    public void setDeposito(java.lang.String deposito) {
        this.deposito = deposito;
    }


    /**
     * Gets the dsErro value for this TtSapCon.
     * 
     * @return dsErro
     */
    public java.lang.String getDsErro() {
        return dsErro;
    }


    /**
     * Sets the dsErro value for this TtSapCon.
     * 
     * @param dsErro
     */
    public void setDsErro(java.lang.String dsErro) {
        this.dsErro = dsErro;
    }


    /**
     * Gets the dtConhecimento value for this TtSapCon.
     * 
     * @return dtConhecimento
     */
    public java.util.Calendar getDtConhecimento() {
        return dtConhecimento;
    }


    /**
     * Sets the dtConhecimento value for this TtSapCon.
     * 
     * @param dtConhecimento
     */
    public void setDtConhecimento(java.util.Calendar dtConhecimento) {
        this.dtConhecimento = dtConhecimento;
    }


    /**
     * Gets the dthrReferencia value for this TtSapCon.
     * 
     * @return dthrReferencia
     */
    public java.util.Calendar getDthrReferencia() {
        return dthrReferencia;
    }


    /**
     * Sets the dthrReferencia value for this TtSapCon.
     * 
     * @param dthrReferencia
     */
    public void setDthrReferencia(java.util.Calendar dthrReferencia) {
        this.dthrReferencia = dthrReferencia;
    }


    /**
     * Gets the idSapcon value for this TtSapCon.
     * 
     * @return idSapcon
     */
    public java.math.BigDecimal getIdSapcon() {
        return idSapcon;
    }


    /**
     * Sets the idSapcon value for this TtSapCon.
     * 
     * @param idSapcon
     */
    public void setIdSapcon(java.math.BigDecimal idSapcon) {
        this.idSapcon = idSapcon;
    }


    /**
     * Gets the isImportado value for this TtSapCon.
     * 
     * @return isImportado
     */
    public java.math.BigDecimal getIsImportado() {
        return isImportado;
    }


    /**
     * Sets the isImportado value for this TtSapCon.
     * 
     * @param isImportado
     */
    public void setIsImportado(java.math.BigDecimal isImportado) {
        this.isImportado = isImportado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TtSapCon)) return false;
        TtSapCon other = (TtSapCon) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.centro==null && other.getCentro()==null) || 
             (this.centro!=null &&
              this.centro.equals(other.getCentro()))) &&
            ((this.conhecimento==null && other.getConhecimento()==null) || 
             (this.conhecimento!=null &&
              this.conhecimento.equals(other.getConhecimento()))) &&
            ((this.deposito==null && other.getDeposito()==null) || 
             (this.deposito!=null &&
              this.deposito.equals(other.getDeposito()))) &&
            ((this.dsErro==null && other.getDsErro()==null) || 
             (this.dsErro!=null &&
              this.dsErro.equals(other.getDsErro()))) &&
            ((this.dtConhecimento==null && other.getDtConhecimento()==null) || 
             (this.dtConhecimento!=null &&
              this.dtConhecimento.equals(other.getDtConhecimento()))) &&
            ((this.dthrReferencia==null && other.getDthrReferencia()==null) || 
             (this.dthrReferencia!=null &&
              this.dthrReferencia.equals(other.getDthrReferencia()))) &&
            ((this.idSapcon==null && other.getIdSapcon()==null) || 
             (this.idSapcon!=null &&
              this.idSapcon.equals(other.getIdSapcon()))) &&
            ((this.isImportado==null && other.getIsImportado()==null) || 
             (this.isImportado!=null &&
              this.isImportado.equals(other.getIsImportado())));
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
        if (getCentro() != null) {
            _hashCode += getCentro().hashCode();
        }
        if (getConhecimento() != null) {
            _hashCode += getConhecimento().hashCode();
        }
        if (getDeposito() != null) {
            _hashCode += getDeposito().hashCode();
        }
        if (getDsErro() != null) {
            _hashCode += getDsErro().hashCode();
        }
        if (getDtConhecimento() != null) {
            _hashCode += getDtConhecimento().hashCode();
        }
        if (getDthrReferencia() != null) {
            _hashCode += getDthrReferencia().hashCode();
        }
        if (getIdSapcon() != null) {
            _hashCode += getIdSapcon().hashCode();
        }
        if (getIsImportado() != null) {
            _hashCode += getIsImportado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TtSapCon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ttSapCon"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("centro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "centro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conhecimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conhecimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deposito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deposito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtConhecimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtConhecimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idSapcon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSapcon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isImportado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isImportado"));
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
