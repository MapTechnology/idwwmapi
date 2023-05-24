/**
 * DwOperacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwOperacao  implements java.io.Serializable {
    private idw.idwws.DwTOperacao dwTOperacao;

    private long idOperacao;

    private idw.idwws.OmProduto omProdutoByIdProdutoAcabado;

    private idw.idwws.OmProduto omProdutoByIdProdutoSemiacabado;

    private idw.idwws.OmPt omPt;

    private java.math.BigDecimal segCiclopadrao;

    public DwOperacao() {
    }

    public DwOperacao(
           idw.idwws.DwTOperacao dwTOperacao,
           long idOperacao,
           idw.idwws.OmProduto omProdutoByIdProdutoAcabado,
           idw.idwws.OmProduto omProdutoByIdProdutoSemiacabado,
           idw.idwws.OmPt omPt,
           java.math.BigDecimal segCiclopadrao) {
           this.dwTOperacao = dwTOperacao;
           this.idOperacao = idOperacao;
           this.omProdutoByIdProdutoAcabado = omProdutoByIdProdutoAcabado;
           this.omProdutoByIdProdutoSemiacabado = omProdutoByIdProdutoSemiacabado;
           this.omPt = omPt;
           this.segCiclopadrao = segCiclopadrao;
    }


    /**
     * Gets the dwTOperacao value for this DwOperacao.
     * 
     * @return dwTOperacao
     */
    public idw.idwws.DwTOperacao getDwTOperacao() {
        return dwTOperacao;
    }


    /**
     * Sets the dwTOperacao value for this DwOperacao.
     * 
     * @param dwTOperacao
     */
    public void setDwTOperacao(idw.idwws.DwTOperacao dwTOperacao) {
        this.dwTOperacao = dwTOperacao;
    }


    /**
     * Gets the idOperacao value for this DwOperacao.
     * 
     * @return idOperacao
     */
    public long getIdOperacao() {
        return idOperacao;
    }


    /**
     * Sets the idOperacao value for this DwOperacao.
     * 
     * @param idOperacao
     */
    public void setIdOperacao(long idOperacao) {
        this.idOperacao = idOperacao;
    }


    /**
     * Gets the omProdutoByIdProdutoAcabado value for this DwOperacao.
     * 
     * @return omProdutoByIdProdutoAcabado
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutoAcabado() {
        return omProdutoByIdProdutoAcabado;
    }


    /**
     * Sets the omProdutoByIdProdutoAcabado value for this DwOperacao.
     * 
     * @param omProdutoByIdProdutoAcabado
     */
    public void setOmProdutoByIdProdutoAcabado(idw.idwws.OmProduto omProdutoByIdProdutoAcabado) {
        this.omProdutoByIdProdutoAcabado = omProdutoByIdProdutoAcabado;
    }


    /**
     * Gets the omProdutoByIdProdutoSemiacabado value for this DwOperacao.
     * 
     * @return omProdutoByIdProdutoSemiacabado
     */
    public idw.idwws.OmProduto getOmProdutoByIdProdutoSemiacabado() {
        return omProdutoByIdProdutoSemiacabado;
    }


    /**
     * Sets the omProdutoByIdProdutoSemiacabado value for this DwOperacao.
     * 
     * @param omProdutoByIdProdutoSemiacabado
     */
    public void setOmProdutoByIdProdutoSemiacabado(idw.idwws.OmProduto omProdutoByIdProdutoSemiacabado) {
        this.omProdutoByIdProdutoSemiacabado = omProdutoByIdProdutoSemiacabado;
    }


    /**
     * Gets the omPt value for this DwOperacao.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwOperacao.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the segCiclopadrao value for this DwOperacao.
     * 
     * @return segCiclopadrao
     */
    public java.math.BigDecimal getSegCiclopadrao() {
        return segCiclopadrao;
    }


    /**
     * Sets the segCiclopadrao value for this DwOperacao.
     * 
     * @param segCiclopadrao
     */
    public void setSegCiclopadrao(java.math.BigDecimal segCiclopadrao) {
        this.segCiclopadrao = segCiclopadrao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwOperacao)) return false;
        DwOperacao other = (DwOperacao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwTOperacao==null && other.getDwTOperacao()==null) || 
             (this.dwTOperacao!=null &&
              this.dwTOperacao.equals(other.getDwTOperacao()))) &&
            this.idOperacao == other.getIdOperacao() &&
            ((this.omProdutoByIdProdutoAcabado==null && other.getOmProdutoByIdProdutoAcabado()==null) || 
             (this.omProdutoByIdProdutoAcabado!=null &&
              this.omProdutoByIdProdutoAcabado.equals(other.getOmProdutoByIdProdutoAcabado()))) &&
            ((this.omProdutoByIdProdutoSemiacabado==null && other.getOmProdutoByIdProdutoSemiacabado()==null) || 
             (this.omProdutoByIdProdutoSemiacabado!=null &&
              this.omProdutoByIdProdutoSemiacabado.equals(other.getOmProdutoByIdProdutoSemiacabado()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.segCiclopadrao==null && other.getSegCiclopadrao()==null) || 
             (this.segCiclopadrao!=null &&
              this.segCiclopadrao.equals(other.getSegCiclopadrao())));
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
        if (getDwTOperacao() != null) {
            _hashCode += getDwTOperacao().hashCode();
        }
        _hashCode += new Long(getIdOperacao()).hashCode();
        if (getOmProdutoByIdProdutoAcabado() != null) {
            _hashCode += getOmProdutoByIdProdutoAcabado().hashCode();
        }
        if (getOmProdutoByIdProdutoSemiacabado() != null) {
            _hashCode += getOmProdutoByIdProdutoSemiacabado().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getSegCiclopadrao() != null) {
            _hashCode += getSegCiclopadrao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwOperacao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwOperacao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTOperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTOperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTOperacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idOperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutoAcabado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutoAcabado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProdutoByIdProdutoSemiacabado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProdutoByIdProdutoSemiacabado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCiclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCiclopadrao"));
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
