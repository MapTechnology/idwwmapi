/**
 * Ijamostragemctrl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamostragemctrl  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private java.lang.String dsproduto;

    private java.util.Calendar dthrivalespecific;

    private double idamostctrl;

    private java.lang.String iddriver;

    private java.lang.String idespecific;

    private idw.idwws.Ijamostragemdetctrl[] ijamostragemdetctrls;

    private idw.idwws.Ijinspecao ijinspecao;

    private java.lang.Double liperctolerancia;

    private java.lang.Double lsperctolerancia;

    private org.apache.axis.types.UnsignedShort pormedia;

    private java.math.BigDecimal tamamostra;

    private java.math.BigDecimal tpentradavlr;

    private org.apache.axis.types.UnsignedShort tpespecific;

    private java.lang.Double vlbase;

    private org.apache.axis.types.UnsignedShort vlporvariacao;

    public Ijamostragemctrl() {
    }

    public Ijamostragemctrl(
           java.lang.String cdproduto,
           java.lang.String dsproduto,
           java.util.Calendar dthrivalespecific,
           double idamostctrl,
           java.lang.String iddriver,
           java.lang.String idespecific,
           idw.idwws.Ijamostragemdetctrl[] ijamostragemdetctrls,
           idw.idwws.Ijinspecao ijinspecao,
           java.lang.Double liperctolerancia,
           java.lang.Double lsperctolerancia,
           org.apache.axis.types.UnsignedShort pormedia,
           java.math.BigDecimal tamamostra,
           java.math.BigDecimal tpentradavlr,
           org.apache.axis.types.UnsignedShort tpespecific,
           java.lang.Double vlbase,
           org.apache.axis.types.UnsignedShort vlporvariacao) {
           this.cdproduto = cdproduto;
           this.dsproduto = dsproduto;
           this.dthrivalespecific = dthrivalespecific;
           this.idamostctrl = idamostctrl;
           this.iddriver = iddriver;
           this.idespecific = idespecific;
           this.ijamostragemdetctrls = ijamostragemdetctrls;
           this.ijinspecao = ijinspecao;
           this.liperctolerancia = liperctolerancia;
           this.lsperctolerancia = lsperctolerancia;
           this.pormedia = pormedia;
           this.tamamostra = tamamostra;
           this.tpentradavlr = tpentradavlr;
           this.tpespecific = tpespecific;
           this.vlbase = vlbase;
           this.vlporvariacao = vlporvariacao;
    }


    /**
     * Gets the cdproduto value for this Ijamostragemctrl.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this Ijamostragemctrl.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dsproduto value for this Ijamostragemctrl.
     * 
     * @return dsproduto
     */
    public java.lang.String getDsproduto() {
        return dsproduto;
    }


    /**
     * Sets the dsproduto value for this Ijamostragemctrl.
     * 
     * @param dsproduto
     */
    public void setDsproduto(java.lang.String dsproduto) {
        this.dsproduto = dsproduto;
    }


    /**
     * Gets the dthrivalespecific value for this Ijamostragemctrl.
     * 
     * @return dthrivalespecific
     */
    public java.util.Calendar getDthrivalespecific() {
        return dthrivalespecific;
    }


    /**
     * Sets the dthrivalespecific value for this Ijamostragemctrl.
     * 
     * @param dthrivalespecific
     */
    public void setDthrivalespecific(java.util.Calendar dthrivalespecific) {
        this.dthrivalespecific = dthrivalespecific;
    }


    /**
     * Gets the idamostctrl value for this Ijamostragemctrl.
     * 
     * @return idamostctrl
     */
    public double getIdamostctrl() {
        return idamostctrl;
    }


    /**
     * Sets the idamostctrl value for this Ijamostragemctrl.
     * 
     * @param idamostctrl
     */
    public void setIdamostctrl(double idamostctrl) {
        this.idamostctrl = idamostctrl;
    }


    /**
     * Gets the iddriver value for this Ijamostragemctrl.
     * 
     * @return iddriver
     */
    public java.lang.String getIddriver() {
        return iddriver;
    }


    /**
     * Sets the iddriver value for this Ijamostragemctrl.
     * 
     * @param iddriver
     */
    public void setIddriver(java.lang.String iddriver) {
        this.iddriver = iddriver;
    }


    /**
     * Gets the idespecific value for this Ijamostragemctrl.
     * 
     * @return idespecific
     */
    public java.lang.String getIdespecific() {
        return idespecific;
    }


    /**
     * Sets the idespecific value for this Ijamostragemctrl.
     * 
     * @param idespecific
     */
    public void setIdespecific(java.lang.String idespecific) {
        this.idespecific = idespecific;
    }


    /**
     * Gets the ijamostragemdetctrls value for this Ijamostragemctrl.
     * 
     * @return ijamostragemdetctrls
     */
    public idw.idwws.Ijamostragemdetctrl[] getIjamostragemdetctrls() {
        return ijamostragemdetctrls;
    }


    /**
     * Sets the ijamostragemdetctrls value for this Ijamostragemctrl.
     * 
     * @param ijamostragemdetctrls
     */
    public void setIjamostragemdetctrls(idw.idwws.Ijamostragemdetctrl[] ijamostragemdetctrls) {
        this.ijamostragemdetctrls = ijamostragemdetctrls;
    }

    public idw.idwws.Ijamostragemdetctrl getIjamostragemdetctrls(int i) {
        return this.ijamostragemdetctrls[i];
    }

    public void setIjamostragemdetctrls(int i, idw.idwws.Ijamostragemdetctrl _value) {
        this.ijamostragemdetctrls[i] = _value;
    }


    /**
     * Gets the ijinspecao value for this Ijamostragemctrl.
     * 
     * @return ijinspecao
     */
    public idw.idwws.Ijinspecao getIjinspecao() {
        return ijinspecao;
    }


    /**
     * Sets the ijinspecao value for this Ijamostragemctrl.
     * 
     * @param ijinspecao
     */
    public void setIjinspecao(idw.idwws.Ijinspecao ijinspecao) {
        this.ijinspecao = ijinspecao;
    }


    /**
     * Gets the liperctolerancia value for this Ijamostragemctrl.
     * 
     * @return liperctolerancia
     */
    public java.lang.Double getLiperctolerancia() {
        return liperctolerancia;
    }


    /**
     * Sets the liperctolerancia value for this Ijamostragemctrl.
     * 
     * @param liperctolerancia
     */
    public void setLiperctolerancia(java.lang.Double liperctolerancia) {
        this.liperctolerancia = liperctolerancia;
    }


    /**
     * Gets the lsperctolerancia value for this Ijamostragemctrl.
     * 
     * @return lsperctolerancia
     */
    public java.lang.Double getLsperctolerancia() {
        return lsperctolerancia;
    }


    /**
     * Sets the lsperctolerancia value for this Ijamostragemctrl.
     * 
     * @param lsperctolerancia
     */
    public void setLsperctolerancia(java.lang.Double lsperctolerancia) {
        this.lsperctolerancia = lsperctolerancia;
    }


    /**
     * Gets the pormedia value for this Ijamostragemctrl.
     * 
     * @return pormedia
     */
    public org.apache.axis.types.UnsignedShort getPormedia() {
        return pormedia;
    }


    /**
     * Sets the pormedia value for this Ijamostragemctrl.
     * 
     * @param pormedia
     */
    public void setPormedia(org.apache.axis.types.UnsignedShort pormedia) {
        this.pormedia = pormedia;
    }


    /**
     * Gets the tamamostra value for this Ijamostragemctrl.
     * 
     * @return tamamostra
     */
    public java.math.BigDecimal getTamamostra() {
        return tamamostra;
    }


    /**
     * Sets the tamamostra value for this Ijamostragemctrl.
     * 
     * @param tamamostra
     */
    public void setTamamostra(java.math.BigDecimal tamamostra) {
        this.tamamostra = tamamostra;
    }


    /**
     * Gets the tpentradavlr value for this Ijamostragemctrl.
     * 
     * @return tpentradavlr
     */
    public java.math.BigDecimal getTpentradavlr() {
        return tpentradavlr;
    }


    /**
     * Sets the tpentradavlr value for this Ijamostragemctrl.
     * 
     * @param tpentradavlr
     */
    public void setTpentradavlr(java.math.BigDecimal tpentradavlr) {
        this.tpentradavlr = tpentradavlr;
    }


    /**
     * Gets the tpespecific value for this Ijamostragemctrl.
     * 
     * @return tpespecific
     */
    public org.apache.axis.types.UnsignedShort getTpespecific() {
        return tpespecific;
    }


    /**
     * Sets the tpespecific value for this Ijamostragemctrl.
     * 
     * @param tpespecific
     */
    public void setTpespecific(org.apache.axis.types.UnsignedShort tpespecific) {
        this.tpespecific = tpespecific;
    }


    /**
     * Gets the vlbase value for this Ijamostragemctrl.
     * 
     * @return vlbase
     */
    public java.lang.Double getVlbase() {
        return vlbase;
    }


    /**
     * Sets the vlbase value for this Ijamostragemctrl.
     * 
     * @param vlbase
     */
    public void setVlbase(java.lang.Double vlbase) {
        this.vlbase = vlbase;
    }


    /**
     * Gets the vlporvariacao value for this Ijamostragemctrl.
     * 
     * @return vlporvariacao
     */
    public org.apache.axis.types.UnsignedShort getVlporvariacao() {
        return vlporvariacao;
    }


    /**
     * Sets the vlporvariacao value for this Ijamostragemctrl.
     * 
     * @param vlporvariacao
     */
    public void setVlporvariacao(org.apache.axis.types.UnsignedShort vlporvariacao) {
        this.vlporvariacao = vlporvariacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamostragemctrl)) return false;
        Ijamostragemctrl other = (Ijamostragemctrl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.dsproduto==null && other.getDsproduto()==null) || 
             (this.dsproduto!=null &&
              this.dsproduto.equals(other.getDsproduto()))) &&
            ((this.dthrivalespecific==null && other.getDthrivalespecific()==null) || 
             (this.dthrivalespecific!=null &&
              this.dthrivalespecific.equals(other.getDthrivalespecific()))) &&
            this.idamostctrl == other.getIdamostctrl() &&
            ((this.iddriver==null && other.getIddriver()==null) || 
             (this.iddriver!=null &&
              this.iddriver.equals(other.getIddriver()))) &&
            ((this.idespecific==null && other.getIdespecific()==null) || 
             (this.idespecific!=null &&
              this.idespecific.equals(other.getIdespecific()))) &&
            ((this.ijamostragemdetctrls==null && other.getIjamostragemdetctrls()==null) || 
             (this.ijamostragemdetctrls!=null &&
              java.util.Arrays.equals(this.ijamostragemdetctrls, other.getIjamostragemdetctrls()))) &&
            ((this.ijinspecao==null && other.getIjinspecao()==null) || 
             (this.ijinspecao!=null &&
              this.ijinspecao.equals(other.getIjinspecao()))) &&
            ((this.liperctolerancia==null && other.getLiperctolerancia()==null) || 
             (this.liperctolerancia!=null &&
              this.liperctolerancia.equals(other.getLiperctolerancia()))) &&
            ((this.lsperctolerancia==null && other.getLsperctolerancia()==null) || 
             (this.lsperctolerancia!=null &&
              this.lsperctolerancia.equals(other.getLsperctolerancia()))) &&
            ((this.pormedia==null && other.getPormedia()==null) || 
             (this.pormedia!=null &&
              this.pormedia.equals(other.getPormedia()))) &&
            ((this.tamamostra==null && other.getTamamostra()==null) || 
             (this.tamamostra!=null &&
              this.tamamostra.equals(other.getTamamostra()))) &&
            ((this.tpentradavlr==null && other.getTpentradavlr()==null) || 
             (this.tpentradavlr!=null &&
              this.tpentradavlr.equals(other.getTpentradavlr()))) &&
            ((this.tpespecific==null && other.getTpespecific()==null) || 
             (this.tpespecific!=null &&
              this.tpespecific.equals(other.getTpespecific()))) &&
            ((this.vlbase==null && other.getVlbase()==null) || 
             (this.vlbase!=null &&
              this.vlbase.equals(other.getVlbase()))) &&
            ((this.vlporvariacao==null && other.getVlporvariacao()==null) || 
             (this.vlporvariacao!=null &&
              this.vlporvariacao.equals(other.getVlporvariacao())));
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
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getDsproduto() != null) {
            _hashCode += getDsproduto().hashCode();
        }
        if (getDthrivalespecific() != null) {
            _hashCode += getDthrivalespecific().hashCode();
        }
        _hashCode += new Double(getIdamostctrl()).hashCode();
        if (getIddriver() != null) {
            _hashCode += getIddriver().hashCode();
        }
        if (getIdespecific() != null) {
            _hashCode += getIdespecific().hashCode();
        }
        if (getIjamostragemdetctrls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamostragemdetctrls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamostragemdetctrls(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjinspecao() != null) {
            _hashCode += getIjinspecao().hashCode();
        }
        if (getLiperctolerancia() != null) {
            _hashCode += getLiperctolerancia().hashCode();
        }
        if (getLsperctolerancia() != null) {
            _hashCode += getLsperctolerancia().hashCode();
        }
        if (getPormedia() != null) {
            _hashCode += getPormedia().hashCode();
        }
        if (getTamamostra() != null) {
            _hashCode += getTamamostra().hashCode();
        }
        if (getTpentradavlr() != null) {
            _hashCode += getTpentradavlr().hashCode();
        }
        if (getTpespecific() != null) {
            _hashCode += getTpespecific().hashCode();
        }
        if (getVlbase() != null) {
            _hashCode += getVlbase().hashCode();
        }
        if (getVlporvariacao() != null) {
            _hashCode += getVlporvariacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamostragemctrl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemctrl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idamostctrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idamostctrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iddriver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iddriver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragemdetctrls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragemdetctrls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdetctrl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liperctolerancia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liperctolerancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lsperctolerancia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lsperctolerancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pormedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pormedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamamostra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamamostra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpentradavlr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpentradavlr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlbase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlbase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlporvariacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlporvariacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
