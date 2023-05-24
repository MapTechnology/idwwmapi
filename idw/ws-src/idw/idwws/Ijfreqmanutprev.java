/**
 * Ijfreqmanutprev.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfreqmanutprev  implements java.io.Serializable {
    private java.math.BigDecimal ativo;

    private java.util.Calendar dthrultalemanprev;

    private idw.idwws.IjfreqmanutprevId id;

    private idw.idwws.Ijmanut ijmanut;

    private java.math.BigDecimal podegeraralerta;

    private double qtdcicexec;

    private double qtdhstrab;

    private java.math.BigDecimal tpfreqmanut;

    private double vlrfreq;

    public Ijfreqmanutprev() {
    }

    public Ijfreqmanutprev(
           java.math.BigDecimal ativo,
           java.util.Calendar dthrultalemanprev,
           idw.idwws.IjfreqmanutprevId id,
           idw.idwws.Ijmanut ijmanut,
           java.math.BigDecimal podegeraralerta,
           double qtdcicexec,
           double qtdhstrab,
           java.math.BigDecimal tpfreqmanut,
           double vlrfreq) {
           this.ativo = ativo;
           this.dthrultalemanprev = dthrultalemanprev;
           this.id = id;
           this.ijmanut = ijmanut;
           this.podegeraralerta = podegeraralerta;
           this.qtdcicexec = qtdcicexec;
           this.qtdhstrab = qtdhstrab;
           this.tpfreqmanut = tpfreqmanut;
           this.vlrfreq = vlrfreq;
    }


    /**
     * Gets the ativo value for this Ijfreqmanutprev.
     * 
     * @return ativo
     */
    public java.math.BigDecimal getAtivo() {
        return ativo;
    }


    /**
     * Sets the ativo value for this Ijfreqmanutprev.
     * 
     * @param ativo
     */
    public void setAtivo(java.math.BigDecimal ativo) {
        this.ativo = ativo;
    }


    /**
     * Gets the dthrultalemanprev value for this Ijfreqmanutprev.
     * 
     * @return dthrultalemanprev
     */
    public java.util.Calendar getDthrultalemanprev() {
        return dthrultalemanprev;
    }


    /**
     * Sets the dthrultalemanprev value for this Ijfreqmanutprev.
     * 
     * @param dthrultalemanprev
     */
    public void setDthrultalemanprev(java.util.Calendar dthrultalemanprev) {
        this.dthrultalemanprev = dthrultalemanprev;
    }


    /**
     * Gets the id value for this Ijfreqmanutprev.
     * 
     * @return id
     */
    public idw.idwws.IjfreqmanutprevId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijfreqmanutprev.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjfreqmanutprevId id) {
        this.id = id;
    }


    /**
     * Gets the ijmanut value for this Ijfreqmanutprev.
     * 
     * @return ijmanut
     */
    public idw.idwws.Ijmanut getIjmanut() {
        return ijmanut;
    }


    /**
     * Sets the ijmanut value for this Ijfreqmanutprev.
     * 
     * @param ijmanut
     */
    public void setIjmanut(idw.idwws.Ijmanut ijmanut) {
        this.ijmanut = ijmanut;
    }


    /**
     * Gets the podegeraralerta value for this Ijfreqmanutprev.
     * 
     * @return podegeraralerta
     */
    public java.math.BigDecimal getPodegeraralerta() {
        return podegeraralerta;
    }


    /**
     * Sets the podegeraralerta value for this Ijfreqmanutprev.
     * 
     * @param podegeraralerta
     */
    public void setPodegeraralerta(java.math.BigDecimal podegeraralerta) {
        this.podegeraralerta = podegeraralerta;
    }


    /**
     * Gets the qtdcicexec value for this Ijfreqmanutprev.
     * 
     * @return qtdcicexec
     */
    public double getQtdcicexec() {
        return qtdcicexec;
    }


    /**
     * Sets the qtdcicexec value for this Ijfreqmanutprev.
     * 
     * @param qtdcicexec
     */
    public void setQtdcicexec(double qtdcicexec) {
        this.qtdcicexec = qtdcicexec;
    }


    /**
     * Gets the qtdhstrab value for this Ijfreqmanutprev.
     * 
     * @return qtdhstrab
     */
    public double getQtdhstrab() {
        return qtdhstrab;
    }


    /**
     * Sets the qtdhstrab value for this Ijfreqmanutprev.
     * 
     * @param qtdhstrab
     */
    public void setQtdhstrab(double qtdhstrab) {
        this.qtdhstrab = qtdhstrab;
    }


    /**
     * Gets the tpfreqmanut value for this Ijfreqmanutprev.
     * 
     * @return tpfreqmanut
     */
    public java.math.BigDecimal getTpfreqmanut() {
        return tpfreqmanut;
    }


    /**
     * Sets the tpfreqmanut value for this Ijfreqmanutprev.
     * 
     * @param tpfreqmanut
     */
    public void setTpfreqmanut(java.math.BigDecimal tpfreqmanut) {
        this.tpfreqmanut = tpfreqmanut;
    }


    /**
     * Gets the vlrfreq value for this Ijfreqmanutprev.
     * 
     * @return vlrfreq
     */
    public double getVlrfreq() {
        return vlrfreq;
    }


    /**
     * Sets the vlrfreq value for this Ijfreqmanutprev.
     * 
     * @param vlrfreq
     */
    public void setVlrfreq(double vlrfreq) {
        this.vlrfreq = vlrfreq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfreqmanutprev)) return false;
        Ijfreqmanutprev other = (Ijfreqmanutprev) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ativo==null && other.getAtivo()==null) || 
             (this.ativo!=null &&
              this.ativo.equals(other.getAtivo()))) &&
            ((this.dthrultalemanprev==null && other.getDthrultalemanprev()==null) || 
             (this.dthrultalemanprev!=null &&
              this.dthrultalemanprev.equals(other.getDthrultalemanprev()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijmanut==null && other.getIjmanut()==null) || 
             (this.ijmanut!=null &&
              this.ijmanut.equals(other.getIjmanut()))) &&
            ((this.podegeraralerta==null && other.getPodegeraralerta()==null) || 
             (this.podegeraralerta!=null &&
              this.podegeraralerta.equals(other.getPodegeraralerta()))) &&
            this.qtdcicexec == other.getQtdcicexec() &&
            this.qtdhstrab == other.getQtdhstrab() &&
            ((this.tpfreqmanut==null && other.getTpfreqmanut()==null) || 
             (this.tpfreqmanut!=null &&
              this.tpfreqmanut.equals(other.getTpfreqmanut()))) &&
            this.vlrfreq == other.getVlrfreq();
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
        if (getAtivo() != null) {
            _hashCode += getAtivo().hashCode();
        }
        if (getDthrultalemanprev() != null) {
            _hashCode += getDthrultalemanprev().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjmanut() != null) {
            _hashCode += getIjmanut().hashCode();
        }
        if (getPodegeraralerta() != null) {
            _hashCode += getPodegeraralerta().hashCode();
        }
        _hashCode += new Double(getQtdcicexec()).hashCode();
        _hashCode += new Double(getQtdhstrab()).hashCode();
        if (getTpfreqmanut() != null) {
            _hashCode += getTpfreqmanut().hashCode();
        }
        _hashCode += new Double(getVlrfreq()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfreqmanutprev.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprev"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrultalemanprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrultalemanprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprevId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("podegeraralerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "podegeraralerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdcicexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdcicexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdhstrab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdhstrab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpfreqmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpfreqmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlrfreq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlrfreq"));
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
