/**
 * TtTmgCon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TtTmgCon  extends idw.idwws.TtTmgConTemplate  implements java.io.Serializable {
    private java.lang.String centro;

    private java.lang.String conhecimento;

    private java.lang.String dsErro;

    private java.util.Calendar dtPrevistaEntrada;

    private java.util.Calendar dthrReferencia;

    private java.lang.String globalcode;

    private java.math.BigDecimal idTmgcon;

    private java.lang.Boolean isImportado;

    private java.lang.Boolean isTransito;

    private java.math.BigDecimal qtMaterial;

    public TtTmgCon() {
    }

    public TtTmgCon(
           java.lang.String centro,
           java.lang.String conhecimento,
           java.lang.String dsErro,
           java.util.Calendar dtPrevistaEntrada,
           java.util.Calendar dthrReferencia,
           java.lang.String globalcode,
           java.math.BigDecimal idTmgcon,
           java.lang.Boolean isImportado,
           java.lang.Boolean isTransito,
           java.math.BigDecimal qtMaterial) {
        this.centro = centro;
        this.conhecimento = conhecimento;
        this.dsErro = dsErro;
        this.dtPrevistaEntrada = dtPrevistaEntrada;
        this.dthrReferencia = dthrReferencia;
        this.globalcode = globalcode;
        this.idTmgcon = idTmgcon;
        this.isImportado = isImportado;
        this.isTransito = isTransito;
        this.qtMaterial = qtMaterial;
    }


    /**
     * Gets the centro value for this TtTmgCon.
     * 
     * @return centro
     */
    public java.lang.String getCentro() {
        return centro;
    }


    /**
     * Sets the centro value for this TtTmgCon.
     * 
     * @param centro
     */
    public void setCentro(java.lang.String centro) {
        this.centro = centro;
    }


    /**
     * Gets the conhecimento value for this TtTmgCon.
     * 
     * @return conhecimento
     */
    public java.lang.String getConhecimento() {
        return conhecimento;
    }


    /**
     * Sets the conhecimento value for this TtTmgCon.
     * 
     * @param conhecimento
     */
    public void setConhecimento(java.lang.String conhecimento) {
        this.conhecimento = conhecimento;
    }


    /**
     * Gets the dsErro value for this TtTmgCon.
     * 
     * @return dsErro
     */
    public java.lang.String getDsErro() {
        return dsErro;
    }


    /**
     * Sets the dsErro value for this TtTmgCon.
     * 
     * @param dsErro
     */
    public void setDsErro(java.lang.String dsErro) {
        this.dsErro = dsErro;
    }


    /**
     * Gets the dtPrevistaEntrada value for this TtTmgCon.
     * 
     * @return dtPrevistaEntrada
     */
    public java.util.Calendar getDtPrevistaEntrada() {
        return dtPrevistaEntrada;
    }


    /**
     * Sets the dtPrevistaEntrada value for this TtTmgCon.
     * 
     * @param dtPrevistaEntrada
     */
    public void setDtPrevistaEntrada(java.util.Calendar dtPrevistaEntrada) {
        this.dtPrevistaEntrada = dtPrevistaEntrada;
    }


    /**
     * Gets the dthrReferencia value for this TtTmgCon.
     * 
     * @return dthrReferencia
     */
    public java.util.Calendar getDthrReferencia() {
        return dthrReferencia;
    }


    /**
     * Sets the dthrReferencia value for this TtTmgCon.
     * 
     * @param dthrReferencia
     */
    public void setDthrReferencia(java.util.Calendar dthrReferencia) {
        this.dthrReferencia = dthrReferencia;
    }


    /**
     * Gets the globalcode value for this TtTmgCon.
     * 
     * @return globalcode
     */
    public java.lang.String getGlobalcode() {
        return globalcode;
    }


    /**
     * Sets the globalcode value for this TtTmgCon.
     * 
     * @param globalcode
     */
    public void setGlobalcode(java.lang.String globalcode) {
        this.globalcode = globalcode;
    }


    /**
     * Gets the idTmgcon value for this TtTmgCon.
     * 
     * @return idTmgcon
     */
    public java.math.BigDecimal getIdTmgcon() {
        return idTmgcon;
    }


    /**
     * Sets the idTmgcon value for this TtTmgCon.
     * 
     * @param idTmgcon
     */
    public void setIdTmgcon(java.math.BigDecimal idTmgcon) {
        this.idTmgcon = idTmgcon;
    }


    /**
     * Gets the isImportado value for this TtTmgCon.
     * 
     * @return isImportado
     */
    public java.lang.Boolean getIsImportado() {
        return isImportado;
    }


    /**
     * Sets the isImportado value for this TtTmgCon.
     * 
     * @param isImportado
     */
    public void setIsImportado(java.lang.Boolean isImportado) {
        this.isImportado = isImportado;
    }


    /**
     * Gets the isTransito value for this TtTmgCon.
     * 
     * @return isTransito
     */
    public java.lang.Boolean getIsTransito() {
        return isTransito;
    }


    /**
     * Sets the isTransito value for this TtTmgCon.
     * 
     * @param isTransito
     */
    public void setIsTransito(java.lang.Boolean isTransito) {
        this.isTransito = isTransito;
    }


    /**
     * Gets the qtMaterial value for this TtTmgCon.
     * 
     * @return qtMaterial
     */
    public java.math.BigDecimal getQtMaterial() {
        return qtMaterial;
    }


    /**
     * Sets the qtMaterial value for this TtTmgCon.
     * 
     * @param qtMaterial
     */
    public void setQtMaterial(java.math.BigDecimal qtMaterial) {
        this.qtMaterial = qtMaterial;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TtTmgCon)) return false;
        TtTmgCon other = (TtTmgCon) obj;
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
            ((this.dsErro==null && other.getDsErro()==null) || 
             (this.dsErro!=null &&
              this.dsErro.equals(other.getDsErro()))) &&
            ((this.dtPrevistaEntrada==null && other.getDtPrevistaEntrada()==null) || 
             (this.dtPrevistaEntrada!=null &&
              this.dtPrevistaEntrada.equals(other.getDtPrevistaEntrada()))) &&
            ((this.dthrReferencia==null && other.getDthrReferencia()==null) || 
             (this.dthrReferencia!=null &&
              this.dthrReferencia.equals(other.getDthrReferencia()))) &&
            ((this.globalcode==null && other.getGlobalcode()==null) || 
             (this.globalcode!=null &&
              this.globalcode.equals(other.getGlobalcode()))) &&
            ((this.idTmgcon==null && other.getIdTmgcon()==null) || 
             (this.idTmgcon!=null &&
              this.idTmgcon.equals(other.getIdTmgcon()))) &&
            ((this.isImportado==null && other.getIsImportado()==null) || 
             (this.isImportado!=null &&
              this.isImportado.equals(other.getIsImportado()))) &&
            ((this.isTransito==null && other.getIsTransito()==null) || 
             (this.isTransito!=null &&
              this.isTransito.equals(other.getIsTransito()))) &&
            ((this.qtMaterial==null && other.getQtMaterial()==null) || 
             (this.qtMaterial!=null &&
              this.qtMaterial.equals(other.getQtMaterial())));
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
        if (getDsErro() != null) {
            _hashCode += getDsErro().hashCode();
        }
        if (getDtPrevistaEntrada() != null) {
            _hashCode += getDtPrevistaEntrada().hashCode();
        }
        if (getDthrReferencia() != null) {
            _hashCode += getDthrReferencia().hashCode();
        }
        if (getGlobalcode() != null) {
            _hashCode += getGlobalcode().hashCode();
        }
        if (getIdTmgcon() != null) {
            _hashCode += getIdTmgcon().hashCode();
        }
        if (getIsImportado() != null) {
            _hashCode += getIsImportado().hashCode();
        }
        if (getIsTransito() != null) {
            _hashCode += getIsTransito().hashCode();
        }
        if (getQtMaterial() != null) {
            _hashCode += getQtMaterial().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TtTmgCon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ttTmgCon"));
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
        elemField.setFieldName("dsErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtPrevistaEntrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtPrevistaEntrada"));
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
        elemField.setFieldName("globalcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "globalcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTmgcon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTmgcon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isImportado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isImportado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTransito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isTransito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMaterial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMaterial"));
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
