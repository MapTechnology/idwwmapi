/**
 * OmGarantia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmGarantia  implements java.io.Serializable {
    private java.lang.String cdGarantia;

    private java.lang.String docCliente;

    private java.lang.String dsGarantia;

    private java.util.Calendar dthrFimvalidade;

    private java.util.Calendar dthrIniciovalidade;

    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private double idGarantia;

    private idw.idwws.OmContato omContato;

    private idw.idwws.OmGarpro[] omGarpros;

    private java.lang.Double revisao;

    private org.apache.axis.types.UnsignedShort stAtivo;

    private java.math.BigDecimal vlContratomanu;

    private java.math.BigDecimal vlLicencas;

    public OmGarantia() {
    }

    public OmGarantia(
           java.lang.String cdGarantia,
           java.lang.String docCliente,
           java.lang.String dsGarantia,
           java.util.Calendar dthrFimvalidade,
           java.util.Calendar dthrIniciovalidade,
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           double idGarantia,
           idw.idwws.OmContato omContato,
           idw.idwws.OmGarpro[] omGarpros,
           java.lang.Double revisao,
           org.apache.axis.types.UnsignedShort stAtivo,
           java.math.BigDecimal vlContratomanu,
           java.math.BigDecimal vlLicencas) {
           this.cdGarantia = cdGarantia;
           this.docCliente = docCliente;
           this.dsGarantia = dsGarantia;
           this.dthrFimvalidade = dthrFimvalidade;
           this.dthrIniciovalidade = dthrIniciovalidade;
           this.dthrRevisao = dthrRevisao;
           this.dthrStativo = dthrStativo;
           this.idGarantia = idGarantia;
           this.omContato = omContato;
           this.omGarpros = omGarpros;
           this.revisao = revisao;
           this.stAtivo = stAtivo;
           this.vlContratomanu = vlContratomanu;
           this.vlLicencas = vlLicencas;
    }


    /**
     * Gets the cdGarantia value for this OmGarantia.
     * 
     * @return cdGarantia
     */
    public java.lang.String getCdGarantia() {
        return cdGarantia;
    }


    /**
     * Sets the cdGarantia value for this OmGarantia.
     * 
     * @param cdGarantia
     */
    public void setCdGarantia(java.lang.String cdGarantia) {
        this.cdGarantia = cdGarantia;
    }


    /**
     * Gets the docCliente value for this OmGarantia.
     * 
     * @return docCliente
     */
    public java.lang.String getDocCliente() {
        return docCliente;
    }


    /**
     * Sets the docCliente value for this OmGarantia.
     * 
     * @param docCliente
     */
    public void setDocCliente(java.lang.String docCliente) {
        this.docCliente = docCliente;
    }


    /**
     * Gets the dsGarantia value for this OmGarantia.
     * 
     * @return dsGarantia
     */
    public java.lang.String getDsGarantia() {
        return dsGarantia;
    }


    /**
     * Sets the dsGarantia value for this OmGarantia.
     * 
     * @param dsGarantia
     */
    public void setDsGarantia(java.lang.String dsGarantia) {
        this.dsGarantia = dsGarantia;
    }


    /**
     * Gets the dthrFimvalidade value for this OmGarantia.
     * 
     * @return dthrFimvalidade
     */
    public java.util.Calendar getDthrFimvalidade() {
        return dthrFimvalidade;
    }


    /**
     * Sets the dthrFimvalidade value for this OmGarantia.
     * 
     * @param dthrFimvalidade
     */
    public void setDthrFimvalidade(java.util.Calendar dthrFimvalidade) {
        this.dthrFimvalidade = dthrFimvalidade;
    }


    /**
     * Gets the dthrIniciovalidade value for this OmGarantia.
     * 
     * @return dthrIniciovalidade
     */
    public java.util.Calendar getDthrIniciovalidade() {
        return dthrIniciovalidade;
    }


    /**
     * Sets the dthrIniciovalidade value for this OmGarantia.
     * 
     * @param dthrIniciovalidade
     */
    public void setDthrIniciovalidade(java.util.Calendar dthrIniciovalidade) {
        this.dthrIniciovalidade = dthrIniciovalidade;
    }


    /**
     * Gets the dthrRevisao value for this OmGarantia.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this OmGarantia.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this OmGarantia.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this OmGarantia.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the idGarantia value for this OmGarantia.
     * 
     * @return idGarantia
     */
    public double getIdGarantia() {
        return idGarantia;
    }


    /**
     * Sets the idGarantia value for this OmGarantia.
     * 
     * @param idGarantia
     */
    public void setIdGarantia(double idGarantia) {
        this.idGarantia = idGarantia;
    }


    /**
     * Gets the omContato value for this OmGarantia.
     * 
     * @return omContato
     */
    public idw.idwws.OmContato getOmContato() {
        return omContato;
    }


    /**
     * Sets the omContato value for this OmGarantia.
     * 
     * @param omContato
     */
    public void setOmContato(idw.idwws.OmContato omContato) {
        this.omContato = omContato;
    }


    /**
     * Gets the omGarpros value for this OmGarantia.
     * 
     * @return omGarpros
     */
    public idw.idwws.OmGarpro[] getOmGarpros() {
        return omGarpros;
    }


    /**
     * Sets the omGarpros value for this OmGarantia.
     * 
     * @param omGarpros
     */
    public void setOmGarpros(idw.idwws.OmGarpro[] omGarpros) {
        this.omGarpros = omGarpros;
    }

    public idw.idwws.OmGarpro getOmGarpros(int i) {
        return this.omGarpros[i];
    }

    public void setOmGarpros(int i, idw.idwws.OmGarpro _value) {
        this.omGarpros[i] = _value;
    }


    /**
     * Gets the revisao value for this OmGarantia.
     * 
     * @return revisao
     */
    public java.lang.Double getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmGarantia.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Double revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmGarantia.
     * 
     * @return stAtivo
     */
    public org.apache.axis.types.UnsignedShort getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmGarantia.
     * 
     * @param stAtivo
     */
    public void setStAtivo(org.apache.axis.types.UnsignedShort stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the vlContratomanu value for this OmGarantia.
     * 
     * @return vlContratomanu
     */
    public java.math.BigDecimal getVlContratomanu() {
        return vlContratomanu;
    }


    /**
     * Sets the vlContratomanu value for this OmGarantia.
     * 
     * @param vlContratomanu
     */
    public void setVlContratomanu(java.math.BigDecimal vlContratomanu) {
        this.vlContratomanu = vlContratomanu;
    }


    /**
     * Gets the vlLicencas value for this OmGarantia.
     * 
     * @return vlLicencas
     */
    public java.math.BigDecimal getVlLicencas() {
        return vlLicencas;
    }


    /**
     * Sets the vlLicencas value for this OmGarantia.
     * 
     * @param vlLicencas
     */
    public void setVlLicencas(java.math.BigDecimal vlLicencas) {
        this.vlLicencas = vlLicencas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmGarantia)) return false;
        OmGarantia other = (OmGarantia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdGarantia==null && other.getCdGarantia()==null) || 
             (this.cdGarantia!=null &&
              this.cdGarantia.equals(other.getCdGarantia()))) &&
            ((this.docCliente==null && other.getDocCliente()==null) || 
             (this.docCliente!=null &&
              this.docCliente.equals(other.getDocCliente()))) &&
            ((this.dsGarantia==null && other.getDsGarantia()==null) || 
             (this.dsGarantia!=null &&
              this.dsGarantia.equals(other.getDsGarantia()))) &&
            ((this.dthrFimvalidade==null && other.getDthrFimvalidade()==null) || 
             (this.dthrFimvalidade!=null &&
              this.dthrFimvalidade.equals(other.getDthrFimvalidade()))) &&
            ((this.dthrIniciovalidade==null && other.getDthrIniciovalidade()==null) || 
             (this.dthrIniciovalidade!=null &&
              this.dthrIniciovalidade.equals(other.getDthrIniciovalidade()))) &&
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            this.idGarantia == other.getIdGarantia() &&
            ((this.omContato==null && other.getOmContato()==null) || 
             (this.omContato!=null &&
              this.omContato.equals(other.getOmContato()))) &&
            ((this.omGarpros==null && other.getOmGarpros()==null) || 
             (this.omGarpros!=null &&
              java.util.Arrays.equals(this.omGarpros, other.getOmGarpros()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.vlContratomanu==null && other.getVlContratomanu()==null) || 
             (this.vlContratomanu!=null &&
              this.vlContratomanu.equals(other.getVlContratomanu()))) &&
            ((this.vlLicencas==null && other.getVlLicencas()==null) || 
             (this.vlLicencas!=null &&
              this.vlLicencas.equals(other.getVlLicencas())));
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
        if (getCdGarantia() != null) {
            _hashCode += getCdGarantia().hashCode();
        }
        if (getDocCliente() != null) {
            _hashCode += getDocCliente().hashCode();
        }
        if (getDsGarantia() != null) {
            _hashCode += getDsGarantia().hashCode();
        }
        if (getDthrFimvalidade() != null) {
            _hashCode += getDthrFimvalidade().hashCode();
        }
        if (getDthrIniciovalidade() != null) {
            _hashCode += getDthrIniciovalidade().hashCode();
        }
        if (getDthrRevisao() != null) {
            _hashCode += getDthrRevisao().hashCode();
        }
        if (getDthrStativo() != null) {
            _hashCode += getDthrStativo().hashCode();
        }
        _hashCode += new Double(getIdGarantia()).hashCode();
        if (getOmContato() != null) {
            _hashCode += getOmContato().hashCode();
        }
        if (getOmGarpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGarpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGarpros(), i);
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
        if (getVlContratomanu() != null) {
            _hashCode += getVlContratomanu().hashCode();
        }
        if (getVlLicencas() != null) {
            _hashCode += getVlLicencas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmGarantia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGarantia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdGarantia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdGarantia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "docCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsGarantia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsGarantia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("idGarantia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idGarantia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omContato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omContato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omContato"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGarpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGarpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGarpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlContratomanu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlContratomanu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlLicencas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlLicencas"));
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
