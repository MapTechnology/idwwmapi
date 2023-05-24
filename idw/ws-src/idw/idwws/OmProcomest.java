/**
 * OmProcomest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmProcomest  extends idw.idwws.OmProcomestTemplate  implements java.io.Serializable {
    private java.lang.Integer conjunto;

    private java.lang.Long idProcomest;

    private idw.idwws.OmProduto omProdutoByIdProduto;

    private idw.idwws.OmProduto omProdutoByIdProdutomp;

    private java.math.BigDecimal qtUsada;

    private java.lang.Integer tpProcomest;

    public OmProcomest() {
    }

    public OmProcomest(
           java.lang.Integer conjunto,
           java.lang.Long idProcomest,
           idw.idwws.OmProduto omProdutoByIdProduto,
           idw.idwws.OmProduto omProdutoByIdProdutomp,
           java.math.BigDecimal qtUsada,
           java.lang.Integer tpProcomest) {
        this.conjunto = conjunto;
        this.idProcomest = idProcomest;
        this.omProdutoByIdProduto = omProdutoByIdProduto;
        this.omProdutoByIdProdutomp = omProdutoByIdProdutomp;
        this.qtUsada = qtUsada;
        this.tpProcomest = tpProcomest;
    }


    /**
     * Gets the conjunto value for this OmProcomest.
     * 
     * @return conjunto
     */
    public java.lang.Integer getConjunto() {
        return conjunto;
    }


    /**
     * Sets the conjunto value for this OmProcomest.
     * 
     * @param conjunto
     */
    public void setConjunto(java.lang.Integer conjunto) {
        this.conjunto = conjunto;
    }


    /**
     * Gets the idProcomest value for this OmProcomest.
     * 
     * @return idProcomest
     */
    public java.lang.Long getIdProcomest() {
        return idProcomest;
    }


    /**
     * Sets the idProcomest value for this OmProcomest.
     * 
     * @param idProcomest
     */
    public void setIdProcomest(java.lang.Long idProcomest) {
        this.idProcomest = idProcomest;
    }


    /**
     * Gets the omProdutoByIdProduto value for this OmProcomest.
     * 
     * @return omProdutoByIdProduto
     */
    public idw.idwws.OmProduto getOmProdutoByIdProduto() {
        return omProdutoByIdProduto;
    }


    /**
     * Sets the omProdutoByIdProduto value for this OmProcomest.
     * 
     * @param omProdutoByIdProduto
     */
    public void setOmProdutoByIdProduto(idw.idwws.OmProduto omProdutoByIdProduto) {
        this.omProdutoByIdProduto = omProdutoByIdProduto;
    }


    /**
     * Gets the omProdutoByIdProdutomp value for this OmProcomest.
     * 
     * @return omProdutoByIdProdutomp
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutomp() {
        return omProdutoByIdProdutomp;
    }


    /**
     * Sets the omProdutoByIdProdutomp value for this OmProcomest.
     * 
     * @param omProdutoByIdProdutomp
     */
    public void setOmProdutoByIdProdutomp(idw.idwws.OmProduto omProdutoByIdProdutomp) {
        this.omProdutoByIdProdutomp = omProdutoByIdProdutomp;
    }


    /**
     * Gets the qtUsada value for this OmProcomest.
     * 
     * @return qtUsada
     */
    public java.math.BigDecimal getQtUsada() {
        return qtUsada;
    }


    /**
     * Sets the qtUsada value for this OmProcomest.
     * 
     * @param qtUsada
     */
    public void setQtUsada(java.math.BigDecimal qtUsada) {
        this.qtUsada = qtUsada;
    }


    /**
     * Gets the tpProcomest value for this OmProcomest.
     * 
     * @return tpProcomest
     */
    public java.lang.Integer getTpProcomest() {
        return tpProcomest;
    }


    /**
     * Sets the tpProcomest value for this OmProcomest.
     * 
     * @param tpProcomest
     */
    public void setTpProcomest(java.lang.Integer tpProcomest) {
        this.tpProcomest = tpProcomest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmProcomest)) return false;
        OmProcomest other = (OmProcomest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.conjunto==null && other.getConjunto()==null) || 
             (this.conjunto!=null &&
              this.conjunto.equals(other.getConjunto()))) &&
            ((this.idProcomest==null && other.getIdProcomest()==null) || 
             (this.idProcomest!=null &&
              this.idProcomest.equals(other.getIdProcomest()))) &&
            ((this.omProdutoByIdProduto==null && other.getOmProdutoByIdProduto()==null) || 
             (this.omProdutoByIdProduto!=null &&
              this.omProdutoByIdProduto.equals(other.getOmProdutoByIdProduto()))) &&
            ((this.omProdutoByIdProdutomp==null && other.getOmProdutoByIdProdutomp()==null) || 
             (this.omProdutoByIdProdutomp!=null &&
              this.omProdutoByIdProdutomp.equals(other.getOmProdutoByIdProdutomp()))) &&
            ((this.qtUsada==null && other.getQtUsada()==null) || 
             (this.qtUsada!=null &&
              this.qtUsada.equals(other.getQtUsada()))) &&
            ((this.tpProcomest==null && other.getTpProcomest()==null) || 
             (this.tpProcomest!=null &&
              this.tpProcomest.equals(other.getTpProcomest())));
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
        if (getConjunto() != null) {
            _hashCode += getConjunto().hashCode();
        }
        if (getIdProcomest() != null) {
            _hashCode += getIdProcomest().hashCode();
        }
        if (getOmProdutoByIdProduto() != null) {
            _hashCode += getOmProdutoByIdProduto().hashCode();
        }
        if (getOmProdutoByIdProdutomp() != null) {
            _hashCode += getOmProdutoByIdProdutomp().hashCode();
        }
        if (getQtUsada() != null) {
            _hashCode += getQtUsada().hashCode();
        }
        if (getTpProcomest() != null) {
            _hashCode += getTpProcomest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmProcomest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProcomest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conjunto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conjunto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProcomest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProcomest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtUsada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtUsada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpProcomest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpProcomest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
