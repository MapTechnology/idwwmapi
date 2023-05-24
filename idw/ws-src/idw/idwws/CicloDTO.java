/**
 * CicloDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CicloDTO  implements java.io.Serializable {
    private java.lang.Integer cavAtivas;

    private java.math.BigDecimal cicloPadrao;

    private idw.idwws.DwRtcic dwRtcic;

    private java.math.BigDecimal eficienciaCiclo;

    private java.math.BigDecimal metaHora;

    public CicloDTO() {
    }

    public CicloDTO(
           java.lang.Integer cavAtivas,
           java.math.BigDecimal cicloPadrao,
           idw.idwws.DwRtcic dwRtcic,
           java.math.BigDecimal eficienciaCiclo,
           java.math.BigDecimal metaHora) {
           this.cavAtivas = cavAtivas;
           this.cicloPadrao = cicloPadrao;
           this.dwRtcic = dwRtcic;
           this.eficienciaCiclo = eficienciaCiclo;
           this.metaHora = metaHora;
    }


    /**
     * Gets the cavAtivas value for this CicloDTO.
     * 
     * @return cavAtivas
     */
    public java.lang.Integer getCavAtivas() {
        return cavAtivas;
    }


    /**
     * Sets the cavAtivas value for this CicloDTO.
     * 
     * @param cavAtivas
     */
    public void setCavAtivas(java.lang.Integer cavAtivas) {
        this.cavAtivas = cavAtivas;
    }


    /**
     * Gets the cicloPadrao value for this CicloDTO.
     * 
     * @return cicloPadrao
     */
    public java.math.BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this CicloDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.math.BigDecimal cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the dwRtcic value for this CicloDTO.
     * 
     * @return dwRtcic
     */
    public idw.idwws.DwRtcic getDwRtcic() {
        return dwRtcic;
    }


    /**
     * Sets the dwRtcic value for this CicloDTO.
     * 
     * @param dwRtcic
     */
    public void setDwRtcic(idw.idwws.DwRtcic dwRtcic) {
        this.dwRtcic = dwRtcic;
    }


    /**
     * Gets the eficienciaCiclo value for this CicloDTO.
     * 
     * @return eficienciaCiclo
     */
    public java.math.BigDecimal getEficienciaCiclo() {
        return eficienciaCiclo;
    }


    /**
     * Sets the eficienciaCiclo value for this CicloDTO.
     * 
     * @param eficienciaCiclo
     */
    public void setEficienciaCiclo(java.math.BigDecimal eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }


    /**
     * Gets the metaHora value for this CicloDTO.
     * 
     * @return metaHora
     */
    public java.math.BigDecimal getMetaHora() {
        return metaHora;
    }


    /**
     * Sets the metaHora value for this CicloDTO.
     * 
     * @param metaHora
     */
    public void setMetaHora(java.math.BigDecimal metaHora) {
        this.metaHora = metaHora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CicloDTO)) return false;
        CicloDTO other = (CicloDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cavAtivas==null && other.getCavAtivas()==null) || 
             (this.cavAtivas!=null &&
              this.cavAtivas.equals(other.getCavAtivas()))) &&
            ((this.cicloPadrao==null && other.getCicloPadrao()==null) || 
             (this.cicloPadrao!=null &&
              this.cicloPadrao.equals(other.getCicloPadrao()))) &&
            ((this.dwRtcic==null && other.getDwRtcic()==null) || 
             (this.dwRtcic!=null &&
              this.dwRtcic.equals(other.getDwRtcic()))) &&
            ((this.eficienciaCiclo==null && other.getEficienciaCiclo()==null) || 
             (this.eficienciaCiclo!=null &&
              this.eficienciaCiclo.equals(other.getEficienciaCiclo()))) &&
            ((this.metaHora==null && other.getMetaHora()==null) || 
             (this.metaHora!=null &&
              this.metaHora.equals(other.getMetaHora())));
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
        if (getCavAtivas() != null) {
            _hashCode += getCavAtivas().hashCode();
        }
        if (getCicloPadrao() != null) {
            _hashCode += getCicloPadrao().hashCode();
        }
        if (getDwRtcic() != null) {
            _hashCode += getDwRtcic().hashCode();
        }
        if (getEficienciaCiclo() != null) {
            _hashCode += getEficienciaCiclo().hashCode();
        }
        if (getMetaHora() != null) {
            _hashCode += getMetaHora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CicloDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cicloDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRtcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRtcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRtcic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaHora"));
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
