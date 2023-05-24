/**
 * ProdutosDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ProdutosDTO  implements java.io.Serializable {
    private idw.idwws.ProdutoDTO[] produtos;

    private idw.idwws.ResultadoDTO resultado;

    public ProdutosDTO() {
    }

    public ProdutosDTO(
           idw.idwws.ProdutoDTO[] produtos,
           idw.idwws.ResultadoDTO resultado) {
           this.produtos = produtos;
           this.resultado = resultado;
    }


    /**
     * Gets the produtos value for this ProdutosDTO.
     * 
     * @return produtos
     */
    public idw.idwws.ProdutoDTO[] getProdutos() {
        return produtos;
    }


    /**
     * Sets the produtos value for this ProdutosDTO.
     * 
     * @param produtos
     */
    public void setProdutos(idw.idwws.ProdutoDTO[] produtos) {
        this.produtos = produtos;
    }

    public idw.idwws.ProdutoDTO getProdutos(int i) {
        return this.produtos[i];
    }

    public void setProdutos(int i, idw.idwws.ProdutoDTO _value) {
        this.produtos[i] = _value;
    }


    /**
     * Gets the resultado value for this ProdutosDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this ProdutosDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProdutosDTO)) return false;
        ProdutosDTO other = (ProdutosDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.produtos==null && other.getProdutos()==null) || 
             (this.produtos!=null &&
              java.util.Arrays.equals(this.produtos, other.getProdutos()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado())));
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
        if (getProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProdutosDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtosDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produtos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "produtoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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
