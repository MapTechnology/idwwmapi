/**
 * MapaCODTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MapaCODTO  implements java.io.Serializable {
    private java.lang.String cdMapa;

    private long idMapa;

    private java.lang.Boolean isAlimentacaoCorrenteExclusiva;

    private java.lang.Boolean isControlarNivelAlimentacao;

    private java.lang.String mascaraQtd;

    public MapaCODTO() {
    }

    public MapaCODTO(
           java.lang.String cdMapa,
           long idMapa,
           java.lang.Boolean isAlimentacaoCorrenteExclusiva,
           java.lang.Boolean isControlarNivelAlimentacao,
           java.lang.String mascaraQtd) {
           this.cdMapa = cdMapa;
           this.idMapa = idMapa;
           this.isAlimentacaoCorrenteExclusiva = isAlimentacaoCorrenteExclusiva;
           this.isControlarNivelAlimentacao = isControlarNivelAlimentacao;
           this.mascaraQtd = mascaraQtd;
    }


    /**
     * Gets the cdMapa value for this MapaCODTO.
     * 
     * @return cdMapa
     */
    public java.lang.String getCdMapa() {
        return cdMapa;
    }


    /**
     * Sets the cdMapa value for this MapaCODTO.
     * 
     * @param cdMapa
     */
    public void setCdMapa(java.lang.String cdMapa) {
        this.cdMapa = cdMapa;
    }


    /**
     * Gets the idMapa value for this MapaCODTO.
     * 
     * @return idMapa
     */
    public long getIdMapa() {
        return idMapa;
    }


    /**
     * Sets the idMapa value for this MapaCODTO.
     * 
     * @param idMapa
     */
    public void setIdMapa(long idMapa) {
        this.idMapa = idMapa;
    }


    /**
     * Gets the isAlimentacaoCorrenteExclusiva value for this MapaCODTO.
     * 
     * @return isAlimentacaoCorrenteExclusiva
     */
    public java.lang.Boolean getIsAlimentacaoCorrenteExclusiva() {
        return isAlimentacaoCorrenteExclusiva;
    }


    /**
     * Sets the isAlimentacaoCorrenteExclusiva value for this MapaCODTO.
     * 
     * @param isAlimentacaoCorrenteExclusiva
     */
    public void setIsAlimentacaoCorrenteExclusiva(java.lang.Boolean isAlimentacaoCorrenteExclusiva) {
        this.isAlimentacaoCorrenteExclusiva = isAlimentacaoCorrenteExclusiva;
    }


    /**
     * Gets the isControlarNivelAlimentacao value for this MapaCODTO.
     * 
     * @return isControlarNivelAlimentacao
     */
    public java.lang.Boolean getIsControlarNivelAlimentacao() {
        return isControlarNivelAlimentacao;
    }


    /**
     * Sets the isControlarNivelAlimentacao value for this MapaCODTO.
     * 
     * @param isControlarNivelAlimentacao
     */
    public void setIsControlarNivelAlimentacao(java.lang.Boolean isControlarNivelAlimentacao) {
        this.isControlarNivelAlimentacao = isControlarNivelAlimentacao;
    }


    /**
     * Gets the mascaraQtd value for this MapaCODTO.
     * 
     * @return mascaraQtd
     */
    public java.lang.String getMascaraQtd() {
        return mascaraQtd;
    }


    /**
     * Sets the mascaraQtd value for this MapaCODTO.
     * 
     * @param mascaraQtd
     */
    public void setMascaraQtd(java.lang.String mascaraQtd) {
        this.mascaraQtd = mascaraQtd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MapaCODTO)) return false;
        MapaCODTO other = (MapaCODTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdMapa==null && other.getCdMapa()==null) || 
             (this.cdMapa!=null &&
              this.cdMapa.equals(other.getCdMapa()))) &&
            this.idMapa == other.getIdMapa() &&
            ((this.isAlimentacaoCorrenteExclusiva==null && other.getIsAlimentacaoCorrenteExclusiva()==null) || 
             (this.isAlimentacaoCorrenteExclusiva!=null &&
              this.isAlimentacaoCorrenteExclusiva.equals(other.getIsAlimentacaoCorrenteExclusiva()))) &&
            ((this.isControlarNivelAlimentacao==null && other.getIsControlarNivelAlimentacao()==null) || 
             (this.isControlarNivelAlimentacao!=null &&
              this.isControlarNivelAlimentacao.equals(other.getIsControlarNivelAlimentacao()))) &&
            ((this.mascaraQtd==null && other.getMascaraQtd()==null) || 
             (this.mascaraQtd!=null &&
              this.mascaraQtd.equals(other.getMascaraQtd())));
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
        if (getCdMapa() != null) {
            _hashCode += getCdMapa().hashCode();
        }
        _hashCode += new Long(getIdMapa()).hashCode();
        if (getIsAlimentacaoCorrenteExclusiva() != null) {
            _hashCode += getIsAlimentacaoCorrenteExclusiva().hashCode();
        }
        if (getIsControlarNivelAlimentacao() != null) {
            _hashCode += getIsControlarNivelAlimentacao().hashCode();
        }
        if (getMascaraQtd() != null) {
            _hashCode += getMascaraQtd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MapaCODTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaCODTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlimentacaoCorrenteExclusiva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAlimentacaoCorrenteExclusiva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isControlarNivelAlimentacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isControlarNivelAlimentacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascaraQtd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascaraQtd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
