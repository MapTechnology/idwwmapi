/**
 * PrUpProdutoValidacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrUpProdutoValidacao  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private java.lang.String dsproduto;

    private java.lang.String idproduto;

    private org.apache.axis.types.UnsignedShort idreduzidaproduto;

    private idw.idwws.PrUp prUp;

    private double qtplan;

    public PrUpProdutoValidacao() {
    }

    public PrUpProdutoValidacao(
           java.lang.String cdproduto,
           java.lang.String dsproduto,
           java.lang.String idproduto,
           org.apache.axis.types.UnsignedShort idreduzidaproduto,
           idw.idwws.PrUp prUp,
           double qtplan) {
           this.cdproduto = cdproduto;
           this.dsproduto = dsproduto;
           this.idproduto = idproduto;
           this.idreduzidaproduto = idreduzidaproduto;
           this.prUp = prUp;
           this.qtplan = qtplan;
    }


    /**
     * Gets the cdproduto value for this PrUpProdutoValidacao.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this PrUpProdutoValidacao.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dsproduto value for this PrUpProdutoValidacao.
     * 
     * @return dsproduto
     */
    public java.lang.String getDsproduto() {
        return dsproduto;
    }


    /**
     * Sets the dsproduto value for this PrUpProdutoValidacao.
     * 
     * @param dsproduto
     */
    public void setDsproduto(java.lang.String dsproduto) {
        this.dsproduto = dsproduto;
    }


    /**
     * Gets the idproduto value for this PrUpProdutoValidacao.
     * 
     * @return idproduto
     */
    public java.lang.String getIdproduto() {
        return idproduto;
    }


    /**
     * Sets the idproduto value for this PrUpProdutoValidacao.
     * 
     * @param idproduto
     */
    public void setIdproduto(java.lang.String idproduto) {
        this.idproduto = idproduto;
    }


    /**
     * Gets the idreduzidaproduto value for this PrUpProdutoValidacao.
     * 
     * @return idreduzidaproduto
     */
    public org.apache.axis.types.UnsignedShort getIdreduzidaproduto() {
        return idreduzidaproduto;
    }


    /**
     * Sets the idreduzidaproduto value for this PrUpProdutoValidacao.
     * 
     * @param idreduzidaproduto
     */
    public void setIdreduzidaproduto(org.apache.axis.types.UnsignedShort idreduzidaproduto) {
        this.idreduzidaproduto = idreduzidaproduto;
    }


    /**
     * Gets the prUp value for this PrUpProdutoValidacao.
     * 
     * @return prUp
     */
    public idw.idwws.PrUp getPrUp() {
        return prUp;
    }


    /**
     * Sets the prUp value for this PrUpProdutoValidacao.
     * 
     * @param prUp
     */
    public void setPrUp(idw.idwws.PrUp prUp) {
        this.prUp = prUp;
    }


    /**
     * Gets the qtplan value for this PrUpProdutoValidacao.
     * 
     * @return qtplan
     */
    public double getQtplan() {
        return qtplan;
    }


    /**
     * Sets the qtplan value for this PrUpProdutoValidacao.
     * 
     * @param qtplan
     */
    public void setQtplan(double qtplan) {
        this.qtplan = qtplan;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrUpProdutoValidacao)) return false;
        PrUpProdutoValidacao other = (PrUpProdutoValidacao) obj;
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
            ((this.idproduto==null && other.getIdproduto()==null) || 
             (this.idproduto!=null &&
              this.idproduto.equals(other.getIdproduto()))) &&
            ((this.idreduzidaproduto==null && other.getIdreduzidaproduto()==null) || 
             (this.idreduzidaproduto!=null &&
              this.idreduzidaproduto.equals(other.getIdreduzidaproduto()))) &&
            ((this.prUp==null && other.getPrUp()==null) || 
             (this.prUp!=null &&
              this.prUp.equals(other.getPrUp()))) &&
            this.qtplan == other.getQtplan();
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
        if (getIdproduto() != null) {
            _hashCode += getIdproduto().hashCode();
        }
        if (getIdreduzidaproduto() != null) {
            _hashCode += getIdreduzidaproduto().hashCode();
        }
        if (getPrUp() != null) {
            _hashCode += getPrUp().hashCode();
        }
        _hashCode += new Double(getQtplan()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrUpProdutoValidacao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpProdutoValidacao"));
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
        elemField.setFieldName("idproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idreduzidaproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idreduzidaproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtplan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtplan"));
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
