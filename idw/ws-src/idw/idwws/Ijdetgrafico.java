/**
 * Ijdetgrafico.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdetgrafico  implements java.io.Serializable {
    private java.lang.String cdcor;

    private java.lang.String descricaolegenda;

    private idw.idwws.IjdetgraficoId id;

    private idw.idwws.Ijgrafico ijgrafico;

    private java.math.BigDecimal intfinal;

    private java.math.BigDecimal intinicial;

    private java.lang.String operadorfinal;

    private java.lang.String operadorinicial;

    public Ijdetgrafico() {
    }

    public Ijdetgrafico(
           java.lang.String cdcor,
           java.lang.String descricaolegenda,
           idw.idwws.IjdetgraficoId id,
           idw.idwws.Ijgrafico ijgrafico,
           java.math.BigDecimal intfinal,
           java.math.BigDecimal intinicial,
           java.lang.String operadorfinal,
           java.lang.String operadorinicial) {
           this.cdcor = cdcor;
           this.descricaolegenda = descricaolegenda;
           this.id = id;
           this.ijgrafico = ijgrafico;
           this.intfinal = intfinal;
           this.intinicial = intinicial;
           this.operadorfinal = operadorfinal;
           this.operadorinicial = operadorinicial;
    }


    /**
     * Gets the cdcor value for this Ijdetgrafico.
     * 
     * @return cdcor
     */
    public java.lang.String getCdcor() {
        return cdcor;
    }


    /**
     * Sets the cdcor value for this Ijdetgrafico.
     * 
     * @param cdcor
     */
    public void setCdcor(java.lang.String cdcor) {
        this.cdcor = cdcor;
    }


    /**
     * Gets the descricaolegenda value for this Ijdetgrafico.
     * 
     * @return descricaolegenda
     */
    public java.lang.String getDescricaolegenda() {
        return descricaolegenda;
    }


    /**
     * Sets the descricaolegenda value for this Ijdetgrafico.
     * 
     * @param descricaolegenda
     */
    public void setDescricaolegenda(java.lang.String descricaolegenda) {
        this.descricaolegenda = descricaolegenda;
    }


    /**
     * Gets the id value for this Ijdetgrafico.
     * 
     * @return id
     */
    public idw.idwws.IjdetgraficoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijdetgrafico.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjdetgraficoId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrafico value for this Ijdetgrafico.
     * 
     * @return ijgrafico
     */
    public idw.idwws.Ijgrafico getIjgrafico() {
        return ijgrafico;
    }


    /**
     * Sets the ijgrafico value for this Ijdetgrafico.
     * 
     * @param ijgrafico
     */
    public void setIjgrafico(idw.idwws.Ijgrafico ijgrafico) {
        this.ijgrafico = ijgrafico;
    }


    /**
     * Gets the intfinal value for this Ijdetgrafico.
     * 
     * @return intfinal
     */
    public java.math.BigDecimal getIntfinal() {
        return intfinal;
    }


    /**
     * Sets the intfinal value for this Ijdetgrafico.
     * 
     * @param intfinal
     */
    public void setIntfinal(java.math.BigDecimal intfinal) {
        this.intfinal = intfinal;
    }


    /**
     * Gets the intinicial value for this Ijdetgrafico.
     * 
     * @return intinicial
     */
    public java.math.BigDecimal getIntinicial() {
        return intinicial;
    }


    /**
     * Sets the intinicial value for this Ijdetgrafico.
     * 
     * @param intinicial
     */
    public void setIntinicial(java.math.BigDecimal intinicial) {
        this.intinicial = intinicial;
    }


    /**
     * Gets the operadorfinal value for this Ijdetgrafico.
     * 
     * @return operadorfinal
     */
    public java.lang.String getOperadorfinal() {
        return operadorfinal;
    }


    /**
     * Sets the operadorfinal value for this Ijdetgrafico.
     * 
     * @param operadorfinal
     */
    public void setOperadorfinal(java.lang.String operadorfinal) {
        this.operadorfinal = operadorfinal;
    }


    /**
     * Gets the operadorinicial value for this Ijdetgrafico.
     * 
     * @return operadorinicial
     */
    public java.lang.String getOperadorinicial() {
        return operadorinicial;
    }


    /**
     * Sets the operadorinicial value for this Ijdetgrafico.
     * 
     * @param operadorinicial
     */
    public void setOperadorinicial(java.lang.String operadorinicial) {
        this.operadorinicial = operadorinicial;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdetgrafico)) return false;
        Ijdetgrafico other = (Ijdetgrafico) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcor==null && other.getCdcor()==null) || 
             (this.cdcor!=null &&
              this.cdcor.equals(other.getCdcor()))) &&
            ((this.descricaolegenda==null && other.getDescricaolegenda()==null) || 
             (this.descricaolegenda!=null &&
              this.descricaolegenda.equals(other.getDescricaolegenda()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijgrafico==null && other.getIjgrafico()==null) || 
             (this.ijgrafico!=null &&
              this.ijgrafico.equals(other.getIjgrafico()))) &&
            ((this.intfinal==null && other.getIntfinal()==null) || 
             (this.intfinal!=null &&
              this.intfinal.equals(other.getIntfinal()))) &&
            ((this.intinicial==null && other.getIntinicial()==null) || 
             (this.intinicial!=null &&
              this.intinicial.equals(other.getIntinicial()))) &&
            ((this.operadorfinal==null && other.getOperadorfinal()==null) || 
             (this.operadorfinal!=null &&
              this.operadorfinal.equals(other.getOperadorfinal()))) &&
            ((this.operadorinicial==null && other.getOperadorinicial()==null) || 
             (this.operadorinicial!=null &&
              this.operadorinicial.equals(other.getOperadorinicial())));
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
        if (getCdcor() != null) {
            _hashCode += getCdcor().hashCode();
        }
        if (getDescricaolegenda() != null) {
            _hashCode += getDescricaolegenda().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjgrafico() != null) {
            _hashCode += getIjgrafico().hashCode();
        }
        if (getIntfinal() != null) {
            _hashCode += getIntfinal().hashCode();
        }
        if (getIntinicial() != null) {
            _hashCode += getIntinicial().hashCode();
        }
        if (getOperadorfinal() != null) {
            _hashCode += getOperadorfinal().hashCode();
        }
        if (getOperadorinicial() != null) {
            _hashCode += getOperadorinicial().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijdetgrafico.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdetgrafico"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricaolegenda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricaolegenda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdetgraficoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrafico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrafico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrafico"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intfinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intfinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intinicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intinicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadorfinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadorfinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadorinicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadorinicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
