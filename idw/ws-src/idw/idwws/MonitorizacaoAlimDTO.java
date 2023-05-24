/**
 * MonitorizacaoAlimDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MonitorizacaoAlimDTO  implements java.io.Serializable {
    private double cicloPadrao;

    private idw.idwws.OmPapro ompapro;

    private long previsaoTermino;

    private long qtCicloRestante;

    private long qtProdutoRestante;

    public MonitorizacaoAlimDTO() {
    }

    public MonitorizacaoAlimDTO(
           double cicloPadrao,
           idw.idwws.OmPapro ompapro,
           long previsaoTermino,
           long qtCicloRestante,
           long qtProdutoRestante) {
           this.cicloPadrao = cicloPadrao;
           this.ompapro = ompapro;
           this.previsaoTermino = previsaoTermino;
           this.qtCicloRestante = qtCicloRestante;
           this.qtProdutoRestante = qtProdutoRestante;
    }


    /**
     * Gets the cicloPadrao value for this MonitorizacaoAlimDTO.
     * 
     * @return cicloPadrao
     */
    public double getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this MonitorizacaoAlimDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(double cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the ompapro value for this MonitorizacaoAlimDTO.
     * 
     * @return ompapro
     */
    public idw.idwws.OmPapro getOmpapro() {
        return ompapro;
    }


    /**
     * Sets the ompapro value for this MonitorizacaoAlimDTO.
     * 
     * @param ompapro
     */
    public void setOmpapro(idw.idwws.OmPapro ompapro) {
        this.ompapro = ompapro;
    }


    /**
     * Gets the previsaoTermino value for this MonitorizacaoAlimDTO.
     * 
     * @return previsaoTermino
     */
    public long getPrevisaoTermino() {
        return previsaoTermino;
    }


    /**
     * Sets the previsaoTermino value for this MonitorizacaoAlimDTO.
     * 
     * @param previsaoTermino
     */
    public void setPrevisaoTermino(long previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }


    /**
     * Gets the qtCicloRestante value for this MonitorizacaoAlimDTO.
     * 
     * @return qtCicloRestante
     */
    public long getQtCicloRestante() {
        return qtCicloRestante;
    }


    /**
     * Sets the qtCicloRestante value for this MonitorizacaoAlimDTO.
     * 
     * @param qtCicloRestante
     */
    public void setQtCicloRestante(long qtCicloRestante) {
        this.qtCicloRestante = qtCicloRestante;
    }


    /**
     * Gets the qtProdutoRestante value for this MonitorizacaoAlimDTO.
     * 
     * @return qtProdutoRestante
     */
    public long getQtProdutoRestante() {
        return qtProdutoRestante;
    }


    /**
     * Sets the qtProdutoRestante value for this MonitorizacaoAlimDTO.
     * 
     * @param qtProdutoRestante
     */
    public void setQtProdutoRestante(long qtProdutoRestante) {
        this.qtProdutoRestante = qtProdutoRestante;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MonitorizacaoAlimDTO)) return false;
        MonitorizacaoAlimDTO other = (MonitorizacaoAlimDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cicloPadrao == other.getCicloPadrao() &&
            ((this.ompapro==null && other.getOmpapro()==null) || 
             (this.ompapro!=null &&
              this.ompapro.equals(other.getOmpapro()))) &&
            this.previsaoTermino == other.getPrevisaoTermino() &&
            this.qtCicloRestante == other.getQtCicloRestante() &&
            this.qtProdutoRestante == other.getQtProdutoRestante();
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
        _hashCode += new Double(getCicloPadrao()).hashCode();
        if (getOmpapro() != null) {
            _hashCode += getOmpapro().hashCode();
        }
        _hashCode += new Long(getPrevisaoTermino()).hashCode();
        _hashCode += new Long(getQtCicloRestante()).hashCode();
        _hashCode += new Long(getQtProdutoRestante()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MonitorizacaoAlimDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "monitorizacaoAlimDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ompapro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ompapro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPapro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previsaoTermino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previsaoTermino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCicloRestante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCicloRestante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtProdutoRestante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtProdutoRestante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
