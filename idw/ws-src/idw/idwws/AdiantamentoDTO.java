/**
 * AdiantamentoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class AdiantamentoDTO  implements java.io.Serializable {
    private java.util.Calendar data;

    private idw.idwws.AlocacaoProdutoMaquinaDTO[] maquina;

    private idw.idwws.PpCpproduto[] produtos;

    public AdiantamentoDTO() {
    }

    public AdiantamentoDTO(
           java.util.Calendar data,
           idw.idwws.AlocacaoProdutoMaquinaDTO[] maquina,
           idw.idwws.PpCpproduto[] produtos) {
           this.data = data;
           this.maquina = maquina;
           this.produtos = produtos;
    }


    /**
     * Gets the data value for this AdiantamentoDTO.
     * 
     * @return data
     */
    public java.util.Calendar getData() {
        return data;
    }


    /**
     * Sets the data value for this AdiantamentoDTO.
     * 
     * @param data
     */
    public void setData(java.util.Calendar data) {
        this.data = data;
    }


    /**
     * Gets the maquina value for this AdiantamentoDTO.
     * 
     * @return maquina
     */
    public idw.idwws.AlocacaoProdutoMaquinaDTO[] getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this AdiantamentoDTO.
     * 
     * @param maquina
     */
    public void setMaquina(idw.idwws.AlocacaoProdutoMaquinaDTO[] maquina) {
        this.maquina = maquina;
    }

    public idw.idwws.AlocacaoProdutoMaquinaDTO getMaquina(int i) {
        return this.maquina[i];
    }

    public void setMaquina(int i, idw.idwws.AlocacaoProdutoMaquinaDTO _value) {
        this.maquina[i] = _value;
    }


    /**
     * Gets the produtos value for this AdiantamentoDTO.
     * 
     * @return produtos
     */
    public idw.idwws.PpCpproduto[] getProdutos() {
        return produtos;
    }


    /**
     * Sets the produtos value for this AdiantamentoDTO.
     * 
     * @param produtos
     */
    public void setProdutos(idw.idwws.PpCpproduto[] produtos) {
        this.produtos = produtos;
    }

    public idw.idwws.PpCpproduto getProdutos(int i) {
        return this.produtos[i];
    }

    public void setProdutos(int i, idw.idwws.PpCpproduto _value) {
        this.produtos[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdiantamentoDTO)) return false;
        AdiantamentoDTO other = (AdiantamentoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              java.util.Arrays.equals(this.maquina, other.getMaquina()))) &&
            ((this.produtos==null && other.getProdutos()==null) || 
             (this.produtos!=null &&
              java.util.Arrays.equals(this.produtos, other.getProdutos())));
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
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getMaquina() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMaquina());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMaquina(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdiantamentoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "adiantamentoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "alocacaoProdutoMaquinaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produtos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produtos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpproduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
