/**
 * OmPropaihomo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmPropaihomo  implements java.io.Serializable {
    private java.lang.Long idPropaihomo;

    private idw.idwws.OmProduto omProdutoByIdProduto;

    private idw.idwws.OmProduto omProdutoByIdProdutopai;

    public OmPropaihomo() {
    }

    public OmPropaihomo(
           java.lang.Long idPropaihomo,
           idw.idwws.OmProduto omProdutoByIdProduto,
           idw.idwws.OmProduto omProdutoByIdProdutopai) {
           this.idPropaihomo = idPropaihomo;
           this.omProdutoByIdProduto = omProdutoByIdProduto;
           this.omProdutoByIdProdutopai = omProdutoByIdProdutopai;
    }


    /**
     * Gets the idPropaihomo value for this OmPropaihomo.
     * 
     * @return idPropaihomo
     */
    public java.lang.Long getIdPropaihomo() {
        return idPropaihomo;
    }


    /**
     * Sets the idPropaihomo value for this OmPropaihomo.
     * 
     * @param idPropaihomo
     */
    public void setIdPropaihomo(java.lang.Long idPropaihomo) {
        this.idPropaihomo = idPropaihomo;
    }


    /**
     * Gets the omProdutoByIdProduto value for this OmPropaihomo.
     * 
     * @return omProdutoByIdProduto
     */
    public idw.idwws.OmProduto getOmProdutoByIdProduto() {
        return omProdutoByIdProduto;
    }


    /**
     * Sets the omProdutoByIdProduto value for this OmPropaihomo.
     * 
     * @param omProdutoByIdProduto
     */
    public void setOmProdutoByIdProduto(idw.idwws.OmProduto omProdutoByIdProduto) {
        this.omProdutoByIdProduto = omProdutoByIdProduto;
    }


    /**
     * Gets the omProdutoByIdProdutopai value for this OmPropaihomo.
     * 
     * @return omProdutoByIdProdutopai
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutopai() {
        return omProdutoByIdProdutopai;
    }


    /**
     * Sets the omProdutoByIdProdutopai value for this OmPropaihomo.
     * 
     * @param omProdutoByIdProdutopai
     */
    public void setOmProdutoByIdProdutopai(idw.idwws.OmProduto omProdutoByIdProdutopai) {
        this.omProdutoByIdProdutopai = omProdutoByIdProdutopai;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmPropaihomo)) return false;
        OmPropaihomo other = (OmPropaihomo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idPropaihomo==null && other.getIdPropaihomo()==null) || 
             (this.idPropaihomo!=null &&
              this.idPropaihomo.equals(other.getIdPropaihomo()))) &&
            ((this.omProdutoByIdProduto==null && other.getOmProdutoByIdProduto()==null) || 
             (this.omProdutoByIdProduto!=null &&
              this.omProdutoByIdProduto.equals(other.getOmProdutoByIdProduto()))) &&
            ((this.omProdutoByIdProdutopai==null && other.getOmProdutoByIdProdutopai()==null) || 
             (this.omProdutoByIdProdutopai!=null &&
              this.omProdutoByIdProdutopai.equals(other.getOmProdutoByIdProdutopai())));
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
        if (getIdPropaihomo() != null) {
            _hashCode += getIdPropaihomo().hashCode();
        }
        if (getOmProdutoByIdProduto() != null) {
            _hashCode += getOmProdutoByIdProduto().hashCode();
        }
        if (getOmProdutoByIdProdutopai() != null) {
            _hashCode += getOmProdutoByIdProdutopai().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmPropaihomo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPropaihomo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPropaihomo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPropaihomo"));
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
        elemField.setFieldName("omProdutoByIdProdutopai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutopai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
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
