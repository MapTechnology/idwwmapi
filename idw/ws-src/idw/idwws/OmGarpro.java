/**
 * OmGarpro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmGarpro  implements java.io.Serializable {
    private java.util.Calendar dthrFimvalidade;

    private java.util.Calendar dthrIniciovalidade;

    private double idGarpro;

    private java.lang.String ns;

    private idw.idwws.OmGarantia omGarantia;

    private idw.idwws.OmProduto omProduto;

    private java.math.BigDecimal qtLicencascontratomanu;

    private java.math.BigDecimal qtLicencasvendidas;

    private java.math.BigDecimal tpLicenca;

    public OmGarpro() {
    }

    public OmGarpro(
           java.util.Calendar dthrFimvalidade,
           java.util.Calendar dthrIniciovalidade,
           double idGarpro,
           java.lang.String ns,
           idw.idwws.OmGarantia omGarantia,
           idw.idwws.OmProduto omProduto,
           java.math.BigDecimal qtLicencascontratomanu,
           java.math.BigDecimal qtLicencasvendidas,
           java.math.BigDecimal tpLicenca) {
           this.dthrFimvalidade = dthrFimvalidade;
           this.dthrIniciovalidade = dthrIniciovalidade;
           this.idGarpro = idGarpro;
           this.ns = ns;
           this.omGarantia = omGarantia;
           this.omProduto = omProduto;
           this.qtLicencascontratomanu = qtLicencascontratomanu;
           this.qtLicencasvendidas = qtLicencasvendidas;
           this.tpLicenca = tpLicenca;
    }


    /**
     * Gets the dthrFimvalidade value for this OmGarpro.
     * 
     * @return dthrFimvalidade
     */
    public java.util.Calendar getDthrFimvalidade() {
        return dthrFimvalidade;
    }


    /**
     * Sets the dthrFimvalidade value for this OmGarpro.
     * 
     * @param dthrFimvalidade
     */
    public void setDthrFimvalidade(java.util.Calendar dthrFimvalidade) {
        this.dthrFimvalidade = dthrFimvalidade;
    }


    /**
     * Gets the dthrIniciovalidade value for this OmGarpro.
     * 
     * @return dthrIniciovalidade
     */
    public java.util.Calendar getDthrIniciovalidade() {
        return dthrIniciovalidade;
    }


    /**
     * Sets the dthrIniciovalidade value for this OmGarpro.
     * 
     * @param dthrIniciovalidade
     */
    public void setDthrIniciovalidade(java.util.Calendar dthrIniciovalidade) {
        this.dthrIniciovalidade = dthrIniciovalidade;
    }


    /**
     * Gets the idGarpro value for this OmGarpro.
     * 
     * @return idGarpro
     */
    public double getIdGarpro() {
        return idGarpro;
    }


    /**
     * Sets the idGarpro value for this OmGarpro.
     * 
     * @param idGarpro
     */
    public void setIdGarpro(double idGarpro) {
        this.idGarpro = idGarpro;
    }


    /**
     * Gets the ns value for this OmGarpro.
     * 
     * @return ns
     */
    public java.lang.String getNs() {
        return ns;
    }


    /**
     * Sets the ns value for this OmGarpro.
     * 
     * @param ns
     */
    public void setNs(java.lang.String ns) {
        this.ns = ns;
    }


    /**
     * Gets the omGarantia value for this OmGarpro.
     * 
     * @return omGarantia
     */
    public idw.idwws.OmGarantia getOmGarantia() {
        return omGarantia;
    }


    /**
     * Sets the omGarantia value for this OmGarpro.
     * 
     * @param omGarantia
     */
    public void setOmGarantia(idw.idwws.OmGarantia omGarantia) {
        this.omGarantia = omGarantia;
    }


    /**
     * Gets the omProduto value for this OmGarpro.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmGarpro.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the qtLicencascontratomanu value for this OmGarpro.
     * 
     * @return qtLicencascontratomanu
     */
    public java.math.BigDecimal getQtLicencascontratomanu() {
        return qtLicencascontratomanu;
    }


    /**
     * Sets the qtLicencascontratomanu value for this OmGarpro.
     * 
     * @param qtLicencascontratomanu
     */
    public void setQtLicencascontratomanu(java.math.BigDecimal qtLicencascontratomanu) {
        this.qtLicencascontratomanu = qtLicencascontratomanu;
    }


    /**
     * Gets the qtLicencasvendidas value for this OmGarpro.
     * 
     * @return qtLicencasvendidas
     */
    public java.math.BigDecimal getQtLicencasvendidas() {
        return qtLicencasvendidas;
    }


    /**
     * Sets the qtLicencasvendidas value for this OmGarpro.
     * 
     * @param qtLicencasvendidas
     */
    public void setQtLicencasvendidas(java.math.BigDecimal qtLicencasvendidas) {
        this.qtLicencasvendidas = qtLicencasvendidas;
    }


    /**
     * Gets the tpLicenca value for this OmGarpro.
     * 
     * @return tpLicenca
     */
    public java.math.BigDecimal getTpLicenca() {
        return tpLicenca;
    }


    /**
     * Sets the tpLicenca value for this OmGarpro.
     * 
     * @param tpLicenca
     */
    public void setTpLicenca(java.math.BigDecimal tpLicenca) {
        this.tpLicenca = tpLicenca;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmGarpro)) return false;
        OmGarpro other = (OmGarpro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrFimvalidade==null && other.getDthrFimvalidade()==null) || 
             (this.dthrFimvalidade!=null &&
              this.dthrFimvalidade.equals(other.getDthrFimvalidade()))) &&
            ((this.dthrIniciovalidade==null && other.getDthrIniciovalidade()==null) || 
             (this.dthrIniciovalidade!=null &&
              this.dthrIniciovalidade.equals(other.getDthrIniciovalidade()))) &&
            this.idGarpro == other.getIdGarpro() &&
            ((this.ns==null && other.getNs()==null) || 
             (this.ns!=null &&
              this.ns.equals(other.getNs()))) &&
            ((this.omGarantia==null && other.getOmGarantia()==null) || 
             (this.omGarantia!=null &&
              this.omGarantia.equals(other.getOmGarantia()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.qtLicencascontratomanu==null && other.getQtLicencascontratomanu()==null) || 
             (this.qtLicencascontratomanu!=null &&
              this.qtLicencascontratomanu.equals(other.getQtLicencascontratomanu()))) &&
            ((this.qtLicencasvendidas==null && other.getQtLicencasvendidas()==null) || 
             (this.qtLicencasvendidas!=null &&
              this.qtLicencasvendidas.equals(other.getQtLicencasvendidas()))) &&
            ((this.tpLicenca==null && other.getTpLicenca()==null) || 
             (this.tpLicenca!=null &&
              this.tpLicenca.equals(other.getTpLicenca())));
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
        if (getDthrFimvalidade() != null) {
            _hashCode += getDthrFimvalidade().hashCode();
        }
        if (getDthrIniciovalidade() != null) {
            _hashCode += getDthrIniciovalidade().hashCode();
        }
        _hashCode += new Double(getIdGarpro()).hashCode();
        if (getNs() != null) {
            _hashCode += getNs().hashCode();
        }
        if (getOmGarantia() != null) {
            _hashCode += getOmGarantia().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getQtLicencascontratomanu() != null) {
            _hashCode += getQtLicencascontratomanu().hashCode();
        }
        if (getQtLicencasvendidas() != null) {
            _hashCode += getQtLicencasvendidas().hashCode();
        }
        if (getTpLicenca() != null) {
            _hashCode += getTpLicenca().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmGarpro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGarpro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFimvalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFimvalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIniciovalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIniciovalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idGarpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGarpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ns");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGarantia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGarantia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGarantia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtLicencascontratomanu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtLicencascontratomanu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtLicencasvendidas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtLicencasvendidas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpLicenca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpLicenca"));
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
