/**
 * RelatoriosDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class RelatoriosDTO  implements java.io.Serializable {
    private java.lang.String maquina;

    private int ordem;

    private idw.idwws.PpCp ppcp;

    private idw.idwws.OmProduto produto;

    private java.math.BigDecimal qtdApont;

    private idw.idwws.RelatorioDTO[] rel;

    private idw.idwws.ResultadoDTO resul;

    public RelatoriosDTO() {
    }

    public RelatoriosDTO(
           java.lang.String maquina,
           int ordem,
           idw.idwws.PpCp ppcp,
           idw.idwws.OmProduto produto,
           java.math.BigDecimal qtdApont,
           idw.idwws.RelatorioDTO[] rel,
           idw.idwws.ResultadoDTO resul) {
           this.maquina = maquina;
           this.ordem = ordem;
           this.ppcp = ppcp;
           this.produto = produto;
           this.qtdApont = qtdApont;
           this.rel = rel;
           this.resul = resul;
    }


    /**
     * Gets the maquina value for this RelatoriosDTO.
     * 
     * @return maquina
     */
    public java.lang.String getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this RelatoriosDTO.
     * 
     * @param maquina
     */
    public void setMaquina(java.lang.String maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the ordem value for this RelatoriosDTO.
     * 
     * @return ordem
     */
    public int getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this RelatoriosDTO.
     * 
     * @param ordem
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the ppcp value for this RelatoriosDTO.
     * 
     * @return ppcp
     */
    public idw.idwws.PpCp getPpcp() {
        return ppcp;
    }


    /**
     * Sets the ppcp value for this RelatoriosDTO.
     * 
     * @param ppcp
     */
    public void setPpcp(idw.idwws.PpCp ppcp) {
        this.ppcp = ppcp;
    }


    /**
     * Gets the produto value for this RelatoriosDTO.
     * 
     * @return produto
     */
    public idw.idwws.OmProduto getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this RelatoriosDTO.
     * 
     * @param produto
     */
    public void setProduto(idw.idwws.OmProduto produto) {
        this.produto = produto;
    }


    /**
     * Gets the qtdApont value for this RelatoriosDTO.
     * 
     * @return qtdApont
     */
    public java.math.BigDecimal getQtdApont() {
        return qtdApont;
    }


    /**
     * Sets the qtdApont value for this RelatoriosDTO.
     * 
     * @param qtdApont
     */
    public void setQtdApont(java.math.BigDecimal qtdApont) {
        this.qtdApont = qtdApont;
    }


    /**
     * Gets the rel value for this RelatoriosDTO.
     * 
     * @return rel
     */
    public idw.idwws.RelatorioDTO[] getRel() {
        return rel;
    }


    /**
     * Sets the rel value for this RelatoriosDTO.
     * 
     * @param rel
     */
    public void setRel(idw.idwws.RelatorioDTO[] rel) {
        this.rel = rel;
    }

    public idw.idwws.RelatorioDTO getRel(int i) {
        return this.rel[i];
    }

    public void setRel(int i, idw.idwws.RelatorioDTO _value) {
        this.rel[i] = _value;
    }


    /**
     * Gets the resul value for this RelatoriosDTO.
     * 
     * @return resul
     */
    public idw.idwws.ResultadoDTO getResul() {
        return resul;
    }


    /**
     * Sets the resul value for this RelatoriosDTO.
     * 
     * @param resul
     */
    public void setResul(idw.idwws.ResultadoDTO resul) {
        this.resul = resul;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatoriosDTO)) return false;
        RelatoriosDTO other = (RelatoriosDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            this.ordem == other.getOrdem() &&
            ((this.ppcp==null && other.getPpcp()==null) || 
             (this.ppcp!=null &&
              this.ppcp.equals(other.getPpcp()))) &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            ((this.qtdApont==null && other.getQtdApont()==null) || 
             (this.qtdApont!=null &&
              this.qtdApont.equals(other.getQtdApont()))) &&
            ((this.rel==null && other.getRel()==null) || 
             (this.rel!=null &&
              java.util.Arrays.equals(this.rel, other.getRel()))) &&
            ((this.resul==null && other.getResul()==null) || 
             (this.resul!=null &&
              this.resul.equals(other.getResul())));
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
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        _hashCode += getOrdem();
        if (getPpcp() != null) {
            _hashCode += getPpcp().hashCode();
        }
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        if (getQtdApont() != null) {
            _hashCode += getQtdApont().hashCode();
        }
        if (getRel() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRel());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRel(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResul() != null) {
            _hashCode += getResul().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RelatoriosDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "relatoriosDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppcp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppcp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdApont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdApont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "relatorioDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resul");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resul"));
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
