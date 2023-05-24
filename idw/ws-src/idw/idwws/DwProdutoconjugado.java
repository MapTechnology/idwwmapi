/**
 * DwProdutoconjugado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwProdutoconjugado  implements java.io.Serializable {
    private long idProdutoconjugado;

    private idw.idwws.OmProduto omProdutoByIdProdutofilho;

    private idw.idwws.OmProduto omProdutoByIdProdutopai;

    public DwProdutoconjugado() {
    }

    public DwProdutoconjugado(
           long idProdutoconjugado,
           idw.idwws.OmProduto omProdutoByIdProdutofilho,
           idw.idwws.OmProduto omProdutoByIdProdutopai) {
           this.idProdutoconjugado = idProdutoconjugado;
           this.omProdutoByIdProdutofilho = omProdutoByIdProdutofilho;
           this.omProdutoByIdProdutopai = omProdutoByIdProdutopai;
    }


    /**
     * Gets the idProdutoconjugado value for this DwProdutoconjugado.
     * 
     * @return idProdutoconjugado
     */
    public long getIdProdutoconjugado() {
        return idProdutoconjugado;
    }


    /**
     * Sets the idProdutoconjugado value for this DwProdutoconjugado.
     * 
     * @param idProdutoconjugado
     */
    public void setIdProdutoconjugado(long idProdutoconjugado) {
        this.idProdutoconjugado = idProdutoconjugado;
    }


    /**
     * Gets the omProdutoByIdProdutofilho value for this DwProdutoconjugado.
     * 
     * @return omProdutoByIdProdutofilho
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutofilho() {
        return omProdutoByIdProdutofilho;
    }


    /**
     * Sets the omProdutoByIdProdutofilho value for this DwProdutoconjugado.
     * 
     * @param omProdutoByIdProdutofilho
     */
    public void setOmProdutoByIdProdutofilho(idw.idwws.OmProduto omProdutoByIdProdutofilho) {
        this.omProdutoByIdProdutofilho = omProdutoByIdProdutofilho;
    }


    /**
     * Gets the omProdutoByIdProdutopai value for this DwProdutoconjugado.
     * 
     * @return omProdutoByIdProdutopai
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutopai() {
        return omProdutoByIdProdutopai;
    }


    /**
     * Sets the omProdutoByIdProdutopai value for this DwProdutoconjugado.
     * 
     * @param omProdutoByIdProdutopai
     */
    public void setOmProdutoByIdProdutopai(idw.idwws.OmProduto omProdutoByIdProdutopai) {
        this.omProdutoByIdProdutopai = omProdutoByIdProdutopai;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwProdutoconjugado)) return false;
        DwProdutoconjugado other = (DwProdutoconjugado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idProdutoconjugado == other.getIdProdutoconjugado() &&
            ((this.omProdutoByIdProdutofilho==null && other.getOmProdutoByIdProdutofilho()==null) || 
             (this.omProdutoByIdProdutofilho!=null &&
              this.omProdutoByIdProdutofilho.equals(other.getOmProdutoByIdProdutofilho()))) &&
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
        _hashCode += new Long(getIdProdutoconjugado()).hashCode();
        if (getOmProdutoByIdProdutofilho() != null) {
            _hashCode += getOmProdutoByIdProdutofilho().hashCode();
        }
        if (getOmProdutoByIdProdutopai() != null) {
            _hashCode += getOmProdutoByIdProdutopai().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwProdutoconjugado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProdutoconjugado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProdutoconjugado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProdutoconjugado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutofilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutofilho"));
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
