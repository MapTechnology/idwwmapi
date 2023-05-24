/**
 * NaoConformidadeDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class NaoConformidadeDTO  implements java.io.Serializable {
    private java.lang.String dsNaoConformidade;

    private java.lang.String dsPt;

    private java.util.Calendar dthrNC;

    private long idPassagem;

    private long idPassdef;

    private int tppt;

    public NaoConformidadeDTO() {
    }

    public NaoConformidadeDTO(
           java.lang.String dsNaoConformidade,
           java.lang.String dsPt,
           java.util.Calendar dthrNC,
           long idPassagem,
           long idPassdef,
           int tppt) {
           this.dsNaoConformidade = dsNaoConformidade;
           this.dsPt = dsPt;
           this.dthrNC = dthrNC;
           this.idPassagem = idPassagem;
           this.idPassdef = idPassdef;
           this.tppt = tppt;
    }


    /**
     * Gets the dsNaoConformidade value for this NaoConformidadeDTO.
     * 
     * @return dsNaoConformidade
     */
    public java.lang.String getDsNaoConformidade() {
        return dsNaoConformidade;
    }


    /**
     * Sets the dsNaoConformidade value for this NaoConformidadeDTO.
     * 
     * @param dsNaoConformidade
     */
    public void setDsNaoConformidade(java.lang.String dsNaoConformidade) {
        this.dsNaoConformidade = dsNaoConformidade;
    }


    /**
     * Gets the dsPt value for this NaoConformidadeDTO.
     * 
     * @return dsPt
     */
    public java.lang.String getDsPt() {
        return dsPt;
    }


    /**
     * Sets the dsPt value for this NaoConformidadeDTO.
     * 
     * @param dsPt
     */
    public void setDsPt(java.lang.String dsPt) {
        this.dsPt = dsPt;
    }


    /**
     * Gets the dthrNC value for this NaoConformidadeDTO.
     * 
     * @return dthrNC
     */
    public java.util.Calendar getDthrNC() {
        return dthrNC;
    }


    /**
     * Sets the dthrNC value for this NaoConformidadeDTO.
     * 
     * @param dthrNC
     */
    public void setDthrNC(java.util.Calendar dthrNC) {
        this.dthrNC = dthrNC;
    }


    /**
     * Gets the idPassagem value for this NaoConformidadeDTO.
     * 
     * @return idPassagem
     */
    public long getIdPassagem() {
        return idPassagem;
    }


    /**
     * Sets the idPassagem value for this NaoConformidadeDTO.
     * 
     * @param idPassagem
     */
    public void setIdPassagem(long idPassagem) {
        this.idPassagem = idPassagem;
    }


    /**
     * Gets the idPassdef value for this NaoConformidadeDTO.
     * 
     * @return idPassdef
     */
    public long getIdPassdef() {
        return idPassdef;
    }


    /**
     * Sets the idPassdef value for this NaoConformidadeDTO.
     * 
     * @param idPassdef
     */
    public void setIdPassdef(long idPassdef) {
        this.idPassdef = idPassdef;
    }


    /**
     * Gets the tppt value for this NaoConformidadeDTO.
     * 
     * @return tppt
     */
    public int getTppt() {
        return tppt;
    }


    /**
     * Sets the tppt value for this NaoConformidadeDTO.
     * 
     * @param tppt
     */
    public void setTppt(int tppt) {
        this.tppt = tppt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NaoConformidadeDTO)) return false;
        NaoConformidadeDTO other = (NaoConformidadeDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsNaoConformidade==null && other.getDsNaoConformidade()==null) || 
             (this.dsNaoConformidade!=null &&
              this.dsNaoConformidade.equals(other.getDsNaoConformidade()))) &&
            ((this.dsPt==null && other.getDsPt()==null) || 
             (this.dsPt!=null &&
              this.dsPt.equals(other.getDsPt()))) &&
            ((this.dthrNC==null && other.getDthrNC()==null) || 
             (this.dthrNC!=null &&
              this.dthrNC.equals(other.getDthrNC()))) &&
            this.idPassagem == other.getIdPassagem() &&
            this.idPassdef == other.getIdPassdef() &&
            this.tppt == other.getTppt();
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
        if (getDsNaoConformidade() != null) {
            _hashCode += getDsNaoConformidade().hashCode();
        }
        if (getDsPt() != null) {
            _hashCode += getDsPt().hashCode();
        }
        if (getDthrNC() != null) {
            _hashCode += getDthrNC().hashCode();
        }
        _hashCode += new Long(getIdPassagem()).hashCode();
        _hashCode += new Long(getIdPassdef()).hashCode();
        _hashCode += getTppt();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NaoConformidadeDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "naoConformidadeDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsNaoConformidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsNaoConformidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrNC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrNC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPassdef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPassdef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
