/**
 * MontagemDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MontagemDTO  implements java.io.Serializable {
    private java.lang.String cb;

    private java.lang.String dsProdutoEsperado;

    private long idProdutoAcoplado;

    private long idProdutoAgrupador;

    private long idProdutoEsperado;

    private int ordem;

    public MontagemDTO() {
    }

    public MontagemDTO(
           java.lang.String cb,
           java.lang.String dsProdutoEsperado,
           long idProdutoAcoplado,
           long idProdutoAgrupador,
           long idProdutoEsperado,
           int ordem) {
           this.cb = cb;
           this.dsProdutoEsperado = dsProdutoEsperado;
           this.idProdutoAcoplado = idProdutoAcoplado;
           this.idProdutoAgrupador = idProdutoAgrupador;
           this.idProdutoEsperado = idProdutoEsperado;
           this.ordem = ordem;
    }


    /**
     * Gets the cb value for this MontagemDTO.
     * 
     * @return cb
     */
    public java.lang.String getCb() {
        return cb;
    }


    /**
     * Sets the cb value for this MontagemDTO.
     * 
     * @param cb
     */
    public void setCb(java.lang.String cb) {
        this.cb = cb;
    }


    /**
     * Gets the dsProdutoEsperado value for this MontagemDTO.
     * 
     * @return dsProdutoEsperado
     */
    public java.lang.String getDsProdutoEsperado() {
        return dsProdutoEsperado;
    }


    /**
     * Sets the dsProdutoEsperado value for this MontagemDTO.
     * 
     * @param dsProdutoEsperado
     */
    public void setDsProdutoEsperado(java.lang.String dsProdutoEsperado) {
        this.dsProdutoEsperado = dsProdutoEsperado;
    }


    /**
     * Gets the idProdutoAcoplado value for this MontagemDTO.
     * 
     * @return idProdutoAcoplado
     */
    public long getIdProdutoAcoplado() {
        return idProdutoAcoplado;
    }


    /**
     * Sets the idProdutoAcoplado value for this MontagemDTO.
     * 
     * @param idProdutoAcoplado
     */
    public void setIdProdutoAcoplado(long idProdutoAcoplado) {
        this.idProdutoAcoplado = idProdutoAcoplado;
    }


    /**
     * Gets the idProdutoAgrupador value for this MontagemDTO.
     * 
     * @return idProdutoAgrupador
     */
    public long getIdProdutoAgrupador() {
        return idProdutoAgrupador;
    }


    /**
     * Sets the idProdutoAgrupador value for this MontagemDTO.
     * 
     * @param idProdutoAgrupador
     */
    public void setIdProdutoAgrupador(long idProdutoAgrupador) {
        this.idProdutoAgrupador = idProdutoAgrupador;
    }


    /**
     * Gets the idProdutoEsperado value for this MontagemDTO.
     * 
     * @return idProdutoEsperado
     */
    public long getIdProdutoEsperado() {
        return idProdutoEsperado;
    }


    /**
     * Sets the idProdutoEsperado value for this MontagemDTO.
     * 
     * @param idProdutoEsperado
     */
    public void setIdProdutoEsperado(long idProdutoEsperado) {
        this.idProdutoEsperado = idProdutoEsperado;
    }


    /**
     * Gets the ordem value for this MontagemDTO.
     * 
     * @return ordem
     */
    public int getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this MontagemDTO.
     * 
     * @param ordem
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MontagemDTO)) return false;
        MontagemDTO other = (MontagemDTO) obj;
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
            ((this.dsProdutoEsperado==null && other.getDsProdutoEsperado()==null) || 
             (this.dsProdutoEsperado!=null &&
              this.dsProdutoEsperado.equals(other.getDsProdutoEsperado()))) &&
            this.idProdutoAcoplado == other.getIdProdutoAcoplado() &&
            this.idProdutoAgrupador == other.getIdProdutoAgrupador() &&
            this.idProdutoEsperado == other.getIdProdutoEsperado() &&
            this.ordem == other.getOrdem();
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
        if (getDsProdutoEsperado() != null) {
            _hashCode += getDsProdutoEsperado().hashCode();
        }
        _hashCode += new Long(getIdProdutoAcoplado()).hashCode();
        _hashCode += new Long(getIdProdutoAgrupador()).hashCode();
        _hashCode += new Long(getIdProdutoEsperado()).hashCode();
        _hashCode += getOrdem();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MontagemDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "montagemDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsProdutoEsperado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsProdutoEsperado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProdutoAcoplado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProdutoAcoplado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProdutoAgrupador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProdutoAgrupador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProdutoEsperado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProdutoEsperado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
