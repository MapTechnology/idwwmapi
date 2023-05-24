/**
 * OmProaltglo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmProaltglo  implements java.io.Serializable {
    private long idProalt;

    private idw.idwws.OmProduto omProdutoByIdProdutoFilho;

    private idw.idwws.OmProduto omProdutoByIdProdutoMae;

    private idw.idwws.OmProduto omProdutoBySemiacabado;

    private java.lang.Integer prioridade;

    private java.math.BigDecimal qt;

    public OmProaltglo() {
    }

    public OmProaltglo(
           long idProalt,
           idw.idwws.OmProduto omProdutoByIdProdutoFilho,
           idw.idwws.OmProduto omProdutoByIdProdutoMae,
           idw.idwws.OmProduto omProdutoBySemiacabado,
           java.lang.Integer prioridade,
           java.math.BigDecimal qt) {
           this.idProalt = idProalt;
           this.omProdutoByIdProdutoFilho = omProdutoByIdProdutoFilho;
           this.omProdutoByIdProdutoMae = omProdutoByIdProdutoMae;
           this.omProdutoBySemiacabado = omProdutoBySemiacabado;
           this.prioridade = prioridade;
           this.qt = qt;
    }


    /**
     * Gets the idProalt value for this OmProaltglo.
     * 
     * @return idProalt
     */
    public long getIdProalt() {
        return idProalt;
    }


    /**
     * Sets the idProalt value for this OmProaltglo.
     * 
     * @param idProalt
     */
    public void setIdProalt(long idProalt) {
        this.idProalt = idProalt;
    }


    /**
     * Gets the omProdutoByIdProdutoFilho value for this OmProaltglo.
     * 
     * @return omProdutoByIdProdutoFilho
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutoFilho() {
        return omProdutoByIdProdutoFilho;
    }


    /**
     * Sets the omProdutoByIdProdutoFilho value for this OmProaltglo.
     * 
     * @param omProdutoByIdProdutoFilho
     */
    public void setOmProdutoByIdProdutoFilho(idw.idwws.OmProduto omProdutoByIdProdutoFilho) {
        this.omProdutoByIdProdutoFilho = omProdutoByIdProdutoFilho;
    }


    /**
     * Gets the omProdutoByIdProdutoMae value for this OmProaltglo.
     * 
     * @return omProdutoByIdProdutoMae
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutoMae() {
        return omProdutoByIdProdutoMae;
    }


    /**
     * Sets the omProdutoByIdProdutoMae value for this OmProaltglo.
     * 
     * @param omProdutoByIdProdutoMae
     */
    public void setOmProdutoByIdProdutoMae(idw.idwws.OmProduto omProdutoByIdProdutoMae) {
        this.omProdutoByIdProdutoMae = omProdutoByIdProdutoMae;
    }


    /**
     * Gets the omProdutoBySemiacabado value for this OmProaltglo.
     * 
     * @return omProdutoBySemiacabado
     */
    public idw.idwws.OmProduto getOmProdutoBySemiacabado() {
        return omProdutoBySemiacabado;
    }


    /**
     * Sets the omProdutoBySemiacabado value for this OmProaltglo.
     * 
     * @param omProdutoBySemiacabado
     */
    public void setOmProdutoBySemiacabado(idw.idwws.OmProduto omProdutoBySemiacabado) {
        this.omProdutoBySemiacabado = omProdutoBySemiacabado;
    }


    /**
     * Gets the prioridade value for this OmProaltglo.
     * 
     * @return prioridade
     */
    public java.lang.Integer getPrioridade() {
        return prioridade;
    }


    /**
     * Sets the prioridade value for this OmProaltglo.
     * 
     * @param prioridade
     */
    public void setPrioridade(java.lang.Integer prioridade) {
        this.prioridade = prioridade;
    }


    /**
     * Gets the qt value for this OmProaltglo.
     * 
     * @return qt
     */
    public java.math.BigDecimal getQt() {
        return qt;
    }


    /**
     * Sets the qt value for this OmProaltglo.
     * 
     * @param qt
     */
    public void setQt(java.math.BigDecimal qt) {
        this.qt = qt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmProaltglo)) return false;
        OmProaltglo other = (OmProaltglo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idProalt == other.getIdProalt() &&
            ((this.omProdutoByIdProdutoFilho==null && other.getOmProdutoByIdProdutoFilho()==null) || 
             (this.omProdutoByIdProdutoFilho!=null &&
              this.omProdutoByIdProdutoFilho.equals(other.getOmProdutoByIdProdutoFilho()))) &&
            ((this.omProdutoByIdProdutoMae==null && other.getOmProdutoByIdProdutoMae()==null) || 
             (this.omProdutoByIdProdutoMae!=null &&
              this.omProdutoByIdProdutoMae.equals(other.getOmProdutoByIdProdutoMae()))) &&
            ((this.omProdutoBySemiacabado==null && other.getOmProdutoBySemiacabado()==null) || 
             (this.omProdutoBySemiacabado!=null &&
              this.omProdutoBySemiacabado.equals(other.getOmProdutoBySemiacabado()))) &&
            ((this.prioridade==null && other.getPrioridade()==null) || 
             (this.prioridade!=null &&
              this.prioridade.equals(other.getPrioridade()))) &&
            ((this.qt==null && other.getQt()==null) || 
             (this.qt!=null &&
              this.qt.equals(other.getQt())));
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
        _hashCode += new Long(getIdProalt()).hashCode();
        if (getOmProdutoByIdProdutoFilho() != null) {
            _hashCode += getOmProdutoByIdProdutoFilho().hashCode();
        }
        if (getOmProdutoByIdProdutoMae() != null) {
            _hashCode += getOmProdutoByIdProdutoMae().hashCode();
        }
        if (getOmProdutoBySemiacabado() != null) {
            _hashCode += getOmProdutoBySemiacabado().hashCode();
        }
        if (getPrioridade() != null) {
            _hashCode += getPrioridade().hashCode();
        }
        if (getQt() != null) {
            _hashCode += getQt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmProaltglo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProaltglo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProalt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProalt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutoFilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutoFilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutoMae");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutoMae"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoBySemiacabado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoBySemiacabado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prioridade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
