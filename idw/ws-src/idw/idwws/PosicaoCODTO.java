/**
 * PosicaoCODTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PosicaoCODTO  implements java.io.Serializable {
    private boolean autorizado;

    private java.lang.String cdFeeder;

    private java.lang.String cdProduto;

    private java.lang.String cdRap;

    private java.lang.String desvio;

    private long idFeeder;

    private long idMapapa;

    private long idProduto;

    private boolean lido;

    private int ordem;

    public PosicaoCODTO() {
    }

    public PosicaoCODTO(
           boolean autorizado,
           java.lang.String cdFeeder,
           java.lang.String cdProduto,
           java.lang.String cdRap,
           java.lang.String desvio,
           long idFeeder,
           long idMapapa,
           long idProduto,
           boolean lido,
           int ordem) {
           this.autorizado = autorizado;
           this.cdFeeder = cdFeeder;
           this.cdProduto = cdProduto;
           this.cdRap = cdRap;
           this.desvio = desvio;
           this.idFeeder = idFeeder;
           this.idMapapa = idMapapa;
           this.idProduto = idProduto;
           this.lido = lido;
           this.ordem = ordem;
    }


    /**
     * Gets the autorizado value for this PosicaoCODTO.
     * 
     * @return autorizado
     */
    public boolean isAutorizado() {
        return autorizado;
    }


    /**
     * Sets the autorizado value for this PosicaoCODTO.
     * 
     * @param autorizado
     */
    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }


    /**
     * Gets the cdFeeder value for this PosicaoCODTO.
     * 
     * @return cdFeeder
     */
    public java.lang.String getCdFeeder() {
        return cdFeeder;
    }


    /**
     * Sets the cdFeeder value for this PosicaoCODTO.
     * 
     * @param cdFeeder
     */
    public void setCdFeeder(java.lang.String cdFeeder) {
        this.cdFeeder = cdFeeder;
    }


    /**
     * Gets the cdProduto value for this PosicaoCODTO.
     * 
     * @return cdProduto
     */
    public java.lang.String getCdProduto() {
        return cdProduto;
    }


    /**
     * Sets the cdProduto value for this PosicaoCODTO.
     * 
     * @param cdProduto
     */
    public void setCdProduto(java.lang.String cdProduto) {
        this.cdProduto = cdProduto;
    }


    /**
     * Gets the cdRap value for this PosicaoCODTO.
     * 
     * @return cdRap
     */
    public java.lang.String getCdRap() {
        return cdRap;
    }


    /**
     * Sets the cdRap value for this PosicaoCODTO.
     * 
     * @param cdRap
     */
    public void setCdRap(java.lang.String cdRap) {
        this.cdRap = cdRap;
    }


    /**
     * Gets the desvio value for this PosicaoCODTO.
     * 
     * @return desvio
     */
    public java.lang.String getDesvio() {
        return desvio;
    }


    /**
     * Sets the desvio value for this PosicaoCODTO.
     * 
     * @param desvio
     */
    public void setDesvio(java.lang.String desvio) {
        this.desvio = desvio;
    }


    /**
     * Gets the idFeeder value for this PosicaoCODTO.
     * 
     * @return idFeeder
     */
    public long getIdFeeder() {
        return idFeeder;
    }


    /**
     * Sets the idFeeder value for this PosicaoCODTO.
     * 
     * @param idFeeder
     */
    public void setIdFeeder(long idFeeder) {
        this.idFeeder = idFeeder;
    }


    /**
     * Gets the idMapapa value for this PosicaoCODTO.
     * 
     * @return idMapapa
     */
    public long getIdMapapa() {
        return idMapapa;
    }


    /**
     * Sets the idMapapa value for this PosicaoCODTO.
     * 
     * @param idMapapa
     */
    public void setIdMapapa(long idMapapa) {
        this.idMapapa = idMapapa;
    }


    /**
     * Gets the idProduto value for this PosicaoCODTO.
     * 
     * @return idProduto
     */
    public long getIdProduto() {
        return idProduto;
    }


    /**
     * Sets the idProduto value for this PosicaoCODTO.
     * 
     * @param idProduto
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }


    /**
     * Gets the lido value for this PosicaoCODTO.
     * 
     * @return lido
     */
    public boolean isLido() {
        return lido;
    }


    /**
     * Sets the lido value for this PosicaoCODTO.
     * 
     * @param lido
     */
    public void setLido(boolean lido) {
        this.lido = lido;
    }


    /**
     * Gets the ordem value for this PosicaoCODTO.
     * 
     * @return ordem
     */
    public int getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this PosicaoCODTO.
     * 
     * @param ordem
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PosicaoCODTO)) return false;
        PosicaoCODTO other = (PosicaoCODTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.autorizado == other.isAutorizado() &&
            ((this.cdFeeder==null && other.getCdFeeder()==null) || 
             (this.cdFeeder!=null &&
              this.cdFeeder.equals(other.getCdFeeder()))) &&
            ((this.cdProduto==null && other.getCdProduto()==null) || 
             (this.cdProduto!=null &&
              this.cdProduto.equals(other.getCdProduto()))) &&
            ((this.cdRap==null && other.getCdRap()==null) || 
             (this.cdRap!=null &&
              this.cdRap.equals(other.getCdRap()))) &&
            ((this.desvio==null && other.getDesvio()==null) || 
             (this.desvio!=null &&
              this.desvio.equals(other.getDesvio()))) &&
            this.idFeeder == other.getIdFeeder() &&
            this.idMapapa == other.getIdMapapa() &&
            this.idProduto == other.getIdProduto() &&
            this.lido == other.isLido() &&
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
        _hashCode += (isAutorizado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCdFeeder() != null) {
            _hashCode += getCdFeeder().hashCode();
        }
        if (getCdProduto() != null) {
            _hashCode += getCdProduto().hashCode();
        }
        if (getCdRap() != null) {
            _hashCode += getCdRap().hashCode();
        }
        if (getDesvio() != null) {
            _hashCode += getDesvio().hashCode();
        }
        _hashCode += new Long(getIdFeeder()).hashCode();
        _hashCode += new Long(getIdMapapa()).hashCode();
        _hashCode += new Long(getIdProduto()).hashCode();
        _hashCode += (isLido() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getOrdem();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PosicaoCODTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "posicaoCODTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autorizado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autorizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdFeeder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdFeeder"));
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
        elemField.setFieldName("cdRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desvio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "desvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFeeder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFeeder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMapapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMapapa"));
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
        elemField.setFieldName("lido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
