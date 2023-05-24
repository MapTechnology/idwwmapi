/**
 * AcoplamentoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class AcoplamentoDTO  implements java.io.Serializable {
    private java.lang.String cb;

    private java.lang.String cdProduto;

    private long idFolha;

    private long idProduto;

    private long idProdutoAcoplado;

    private long idPt;

    private long idTppt;

    private idw.idwws.ResultadoDTO resultado;

    public AcoplamentoDTO() {
    }

    public AcoplamentoDTO(
           java.lang.String cb,
           java.lang.String cdProduto,
           long idFolha,
           long idProduto,
           long idProdutoAcoplado,
           long idPt,
           long idTppt,
           idw.idwws.ResultadoDTO resultado) {
           this.cb = cb;
           this.cdProduto = cdProduto;
           this.idFolha = idFolha;
           this.idProduto = idProduto;
           this.idProdutoAcoplado = idProdutoAcoplado;
           this.idPt = idPt;
           this.idTppt = idTppt;
           this.resultado = resultado;
    }


    /**
     * Gets the cb value for this AcoplamentoDTO.
     * 
     * @return cb
     */
    public java.lang.String getCb() {
        return cb;
    }


    /**
     * Sets the cb value for this AcoplamentoDTO.
     * 
     * @param cb
     */
    public void setCb(java.lang.String cb) {
        this.cb = cb;
    }


    /**
     * Gets the cdProduto value for this AcoplamentoDTO.
     * 
     * @return cdProduto
     */
    public java.lang.String getCdProduto() {
        return cdProduto;
    }


    /**
     * Sets the cdProduto value for this AcoplamentoDTO.
     * 
     * @param cdProduto
     */
    public void setCdProduto(java.lang.String cdProduto) {
        this.cdProduto = cdProduto;
    }


    /**
     * Gets the idFolha value for this AcoplamentoDTO.
     * 
     * @return idFolha
     */
    public long getIdFolha() {
        return idFolha;
    }


    /**
     * Sets the idFolha value for this AcoplamentoDTO.
     * 
     * @param idFolha
     */
    public void setIdFolha(long idFolha) {
        this.idFolha = idFolha;
    }


    /**
     * Gets the idProduto value for this AcoplamentoDTO.
     * 
     * @return idProduto
     */
    public long getIdProduto() {
        return idProduto;
    }


    /**
     * Sets the idProduto value for this AcoplamentoDTO.
     * 
     * @param idProduto
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }


    /**
     * Gets the idProdutoAcoplado value for this AcoplamentoDTO.
     * 
     * @return idProdutoAcoplado
     */
    public long getIdProdutoAcoplado() {
        return idProdutoAcoplado;
    }


    /**
     * Sets the idProdutoAcoplado value for this AcoplamentoDTO.
     * 
     * @param idProdutoAcoplado
     */
    public void setIdProdutoAcoplado(long idProdutoAcoplado) {
        this.idProdutoAcoplado = idProdutoAcoplado;
    }


    /**
     * Gets the idPt value for this AcoplamentoDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this AcoplamentoDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idTppt value for this AcoplamentoDTO.
     * 
     * @return idTppt
     */
    public long getIdTppt() {
        return idTppt;
    }


    /**
     * Sets the idTppt value for this AcoplamentoDTO.
     * 
     * @param idTppt
     */
    public void setIdTppt(long idTppt) {
        this.idTppt = idTppt;
    }


    /**
     * Gets the resultado value for this AcoplamentoDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this AcoplamentoDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcoplamentoDTO)) return false;
        AcoplamentoDTO other = (AcoplamentoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cb==null && other.getCb()==null) || 
             (this.cb!=null &&
              this.cb.equals(other.getCb()))) &&
            ((this.cdProduto==null && other.getCdProduto()==null) || 
             (this.cdProduto!=null &&
              this.cdProduto.equals(other.getCdProduto()))) &&
            this.idFolha == other.getIdFolha() &&
            this.idProduto == other.getIdProduto() &&
            this.idProdutoAcoplado == other.getIdProdutoAcoplado() &&
            this.idPt == other.getIdPt() &&
            this.idTppt == other.getIdTppt() &&
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
        if (getCb() != null) {
            _hashCode += getCb().hashCode();
        }
        if (getCdProduto() != null) {
            _hashCode += getCdProduto().hashCode();
        }
        _hashCode += new Long(getIdFolha()).hashCode();
        _hashCode += new Long(getIdProduto()).hashCode();
        _hashCode += new Long(getIdProdutoAcoplado()).hashCode();
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdTppt()).hashCode();
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcoplamentoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "acoplamentoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProdutoAcoplado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProdutoAcoplado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
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
