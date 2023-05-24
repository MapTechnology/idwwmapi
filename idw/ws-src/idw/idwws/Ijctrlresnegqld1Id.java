/**
 * Ijctrlresnegqld1Id.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlresnegqld1Id  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdinjetora;

    private java.lang.String cdmolde;

    private java.lang.String cdproduto;

    private java.util.Calendar dthrivalestru;

    private java.lang.String nrop;

    private double sequencia;

    public Ijctrlresnegqld1Id() {
    }

    public Ijctrlresnegqld1Id(
           java.lang.String cdestrutura,
           java.lang.String cdinjetora,
           java.lang.String cdmolde,
           java.lang.String cdproduto,
           java.util.Calendar dthrivalestru,
           java.lang.String nrop,
           double sequencia) {
           this.cdestrutura = cdestrutura;
           this.cdinjetora = cdinjetora;
           this.cdmolde = cdmolde;
           this.cdproduto = cdproduto;
           this.dthrivalestru = dthrivalestru;
           this.nrop = nrop;
           this.sequencia = sequencia;
    }


    /**
     * Gets the cdestrutura value for this Ijctrlresnegqld1Id.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this Ijctrlresnegqld1Id.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdinjetora value for this Ijctrlresnegqld1Id.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijctrlresnegqld1Id.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdmolde value for this Ijctrlresnegqld1Id.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this Ijctrlresnegqld1Id.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdproduto value for this Ijctrlresnegqld1Id.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this Ijctrlresnegqld1Id.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dthrivalestru value for this Ijctrlresnegqld1Id.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijctrlresnegqld1Id.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the nrop value for this Ijctrlresnegqld1Id.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Ijctrlresnegqld1Id.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the sequencia value for this Ijctrlresnegqld1Id.
     * 
     * @return sequencia
     */
    public double getSequencia() {
        return sequencia;
    }


    /**
     * Sets the sequencia value for this Ijctrlresnegqld1Id.
     * 
     * @param sequencia
     */
    public void setSequencia(double sequencia) {
        this.sequencia = sequencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlresnegqld1Id)) return false;
        Ijctrlresnegqld1Id other = (Ijctrlresnegqld1Id) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            this.sequencia == other.getSequencia();
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
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        _hashCode += new Double(getSequencia()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlresnegqld1Id.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlresnegqld1Id"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
