/**
 * TtSapEstmppa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TtSapEstmppa  extends idw.idwws.TtSapEstmppaTemplate  implements java.io.Serializable {
    private java.lang.String centro;

    private java.lang.String deposito;

    private java.lang.String dsErro;

    private java.util.Calendar dthrReferencia;

    private java.lang.String globalcode;

    private java.lang.Long idSapestmppa;

    private java.lang.Boolean isImportado;

    private java.math.BigDecimal qtEstoque;

    public TtSapEstmppa() {
    }

    public TtSapEstmppa(
           java.lang.String centro,
           java.lang.String deposito,
           java.lang.String dsErro,
           java.util.Calendar dthrReferencia,
           java.lang.String globalcode,
           java.lang.Long idSapestmppa,
           java.lang.Boolean isImportado,
           java.math.BigDecimal qtEstoque) {
        this.centro = centro;
        this.deposito = deposito;
        this.dsErro = dsErro;
        this.dthrReferencia = dthrReferencia;
        this.globalcode = globalcode;
        this.idSapestmppa = idSapestmppa;
        this.isImportado = isImportado;
        this.qtEstoque = qtEstoque;
    }


    /**
     * Gets the centro value for this TtSapEstmppa.
     * 
     * @return centro
     */
    public java.lang.String getCentro() {
        return centro;
    }


    /**
     * Sets the centro value for this TtSapEstmppa.
     * 
     * @param centro
     */
    public void setCentro(java.lang.String centro) {
        this.centro = centro;
    }


    /**
     * Gets the deposito value for this TtSapEstmppa.
     * 
     * @return deposito
     */
    public java.lang.String getDeposito() {
        return deposito;
    }


    /**
     * Sets the deposito value for this TtSapEstmppa.
     * 
     * @param deposito
     */
    public void setDeposito(java.lang.String deposito) {
        this.deposito = deposito;
    }


    /**
     * Gets the dsErro value for this TtSapEstmppa.
     * 
     * @return dsErro
     */
    public java.lang.String getDsErro() {
        return dsErro;
    }


    /**
     * Sets the dsErro value for this TtSapEstmppa.
     * 
     * @param dsErro
     */
    public void setDsErro(java.lang.String dsErro) {
        this.dsErro = dsErro;
    }


    /**
     * Gets the dthrReferencia value for this TtSapEstmppa.
     * 
     * @return dthrReferencia
     */
    public java.util.Calendar getDthrReferencia() {
        return dthrReferencia;
    }


    /**
     * Sets the dthrReferencia value for this TtSapEstmppa.
     * 
     * @param dthrReferencia
     */
    public void setDthrReferencia(java.util.Calendar dthrReferencia) {
        this.dthrReferencia = dthrReferencia;
    }


    /**
     * Gets the globalcode value for this TtSapEstmppa.
     * 
     * @return globalcode
     */
    public java.lang.String getGlobalcode() {
        return globalcode;
    }


    /**
     * Sets the globalcode value for this TtSapEstmppa.
     * 
     * @param globalcode
     */
    public void setGlobalcode(java.lang.String globalcode) {
        this.globalcode = globalcode;
    }


    /**
     * Gets the idSapestmppa value for this TtSapEstmppa.
     * 
     * @return idSapestmppa
     */
    public java.lang.Long getIdSapestmppa() {
        return idSapestmppa;
    }


    /**
     * Sets the idSapestmppa value for this TtSapEstmppa.
     * 
     * @param idSapestmppa
     */
    public void setIdSapestmppa(java.lang.Long idSapestmppa) {
        this.idSapestmppa = idSapestmppa;
    }


    /**
     * Gets the isImportado value for this TtSapEstmppa.
     * 
     * @return isImportado
     */
    public java.lang.Boolean getIsImportado() {
        return isImportado;
    }


    /**
     * Sets the isImportado value for this TtSapEstmppa.
     * 
     * @param isImportado
     */
    public void setIsImportado(java.lang.Boolean isImportado) {
        this.isImportado = isImportado;
    }


    /**
     * Gets the qtEstoque value for this TtSapEstmppa.
     * 
     * @return qtEstoque
     */
    public java.math.BigDecimal getQtEstoque() {
        return qtEstoque;
    }


    /**
     * Sets the qtEstoque value for this TtSapEstmppa.
     * 
     * @param qtEstoque
     */
    public void setQtEstoque(java.math.BigDecimal qtEstoque) {
        this.qtEstoque = qtEstoque;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TtSapEstmppa)) return false;
        TtSapEstmppa other = (TtSapEstmppa) obj;
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
            ((this.deposito==null && other.getDeposito()==null) || 
             (this.deposito!=null &&
              this.deposito.equals(other.getDeposito()))) &&
            ((this.dsErro==null && other.getDsErro()==null) || 
             (this.dsErro!=null &&
              this.dsErro.equals(other.getDsErro()))) &&
            ((this.dthrReferencia==null && other.getDthrReferencia()==null) || 
             (this.dthrReferencia!=null &&
              this.dthrReferencia.equals(other.getDthrReferencia()))) &&
            ((this.globalcode==null && other.getGlobalcode()==null) || 
             (this.globalcode!=null &&
              this.globalcode.equals(other.getGlobalcode()))) &&
            ((this.idSapestmppa==null && other.getIdSapestmppa()==null) || 
             (this.idSapestmppa!=null &&
              this.idSapestmppa.equals(other.getIdSapestmppa()))) &&
            ((this.isImportado==null && other.getIsImportado()==null) || 
             (this.isImportado!=null &&
              this.isImportado.equals(other.getIsImportado()))) &&
            ((this.qtEstoque==null && other.getQtEstoque()==null) || 
             (this.qtEstoque!=null &&
              this.qtEstoque.equals(other.getQtEstoque())));
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
        if (getDeposito() != null) {
            _hashCode += getDeposito().hashCode();
        }
        if (getDsErro() != null) {
            _hashCode += getDsErro().hashCode();
        }
        if (getDthrReferencia() != null) {
            _hashCode += getDthrReferencia().hashCode();
        }
        if (getGlobalcode() != null) {
            _hashCode += getGlobalcode().hashCode();
        }
        if (getIdSapestmppa() != null) {
            _hashCode += getIdSapestmppa().hashCode();
        }
        if (getIsImportado() != null) {
            _hashCode += getIsImportado().hashCode();
        }
        if (getQtEstoque() != null) {
            _hashCode += getQtEstoque().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TtSapEstmppa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ttSapEstmppa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("centro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "centro"));
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
        elemField.setFieldName("idSapestmppa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSapestmppa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("qtEstoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtEstoque"));
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
