/**
 * GraficoDetalhePtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoDetalhePtDTO  implements java.io.Serializable {
    private java.lang.Double cavAtivas;

    private java.lang.Double cicloPadrao;

    private boolean comParadas;

    private idw.idwws.DwConsolidDTO dwConsolid;

    private idw.idwws.DwConsolidDTOs dwConsolidDTOs;

    private java.lang.Double limiteinferior;

    private java.lang.Double limitesuperior;

    private java.lang.Double meta;

    private java.lang.Double metaHora;

    private int tpgrafico;

    public GraficoDetalhePtDTO() {
    }

    public GraficoDetalhePtDTO(
           java.lang.Double cavAtivas,
           java.lang.Double cicloPadrao,
           boolean comParadas,
           idw.idwws.DwConsolidDTO dwConsolid,
           idw.idwws.DwConsolidDTOs dwConsolidDTOs,
           java.lang.Double limiteinferior,
           java.lang.Double limitesuperior,
           java.lang.Double meta,
           java.lang.Double metaHora,
           int tpgrafico) {
           this.cavAtivas = cavAtivas;
           this.cicloPadrao = cicloPadrao;
           this.comParadas = comParadas;
           this.dwConsolid = dwConsolid;
           this.dwConsolidDTOs = dwConsolidDTOs;
           this.limiteinferior = limiteinferior;
           this.limitesuperior = limitesuperior;
           this.meta = meta;
           this.metaHora = metaHora;
           this.tpgrafico = tpgrafico;
    }


    /**
     * Gets the cavAtivas value for this GraficoDetalhePtDTO.
     * 
     * @return cavAtivas
     */
    public java.lang.Double getCavAtivas() {
        return cavAtivas;
    }


    /**
     * Sets the cavAtivas value for this GraficoDetalhePtDTO.
     * 
     * @param cavAtivas
     */
    public void setCavAtivas(java.lang.Double cavAtivas) {
        this.cavAtivas = cavAtivas;
    }


    /**
     * Gets the cicloPadrao value for this GraficoDetalhePtDTO.
     * 
     * @return cicloPadrao
     */
    public java.lang.Double getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this GraficoDetalhePtDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.lang.Double cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the comParadas value for this GraficoDetalhePtDTO.
     * 
     * @return comParadas
     */
    public boolean isComParadas() {
        return comParadas;
    }


    /**
     * Sets the comParadas value for this GraficoDetalhePtDTO.
     * 
     * @param comParadas
     */
    public void setComParadas(boolean comParadas) {
        this.comParadas = comParadas;
    }


    /**
     * Gets the dwConsolid value for this GraficoDetalhePtDTO.
     * 
     * @return dwConsolid
     */
    public idw.idwws.DwConsolidDTO getDwConsolid() {
        return dwConsolid;
    }


    /**
     * Sets the dwConsolid value for this GraficoDetalhePtDTO.
     * 
     * @param dwConsolid
     */
    public void setDwConsolid(idw.idwws.DwConsolidDTO dwConsolid) {
        this.dwConsolid = dwConsolid;
    }


    /**
     * Gets the dwConsolidDTOs value for this GraficoDetalhePtDTO.
     * 
     * @return dwConsolidDTOs
     */
    public idw.idwws.DwConsolidDTOs getDwConsolidDTOs() {
        return dwConsolidDTOs;
    }


    /**
     * Sets the dwConsolidDTOs value for this GraficoDetalhePtDTO.
     * 
     * @param dwConsolidDTOs
     */
    public void setDwConsolidDTOs(idw.idwws.DwConsolidDTOs dwConsolidDTOs) {
        this.dwConsolidDTOs = dwConsolidDTOs;
    }


    /**
     * Gets the limiteinferior value for this GraficoDetalhePtDTO.
     * 
     * @return limiteinferior
     */
    public java.lang.Double getLimiteinferior() {
        return limiteinferior;
    }


    /**
     * Sets the limiteinferior value for this GraficoDetalhePtDTO.
     * 
     * @param limiteinferior
     */
    public void setLimiteinferior(java.lang.Double limiteinferior) {
        this.limiteinferior = limiteinferior;
    }


    /**
     * Gets the limitesuperior value for this GraficoDetalhePtDTO.
     * 
     * @return limitesuperior
     */
    public java.lang.Double getLimitesuperior() {
        return limitesuperior;
    }


    /**
     * Sets the limitesuperior value for this GraficoDetalhePtDTO.
     * 
     * @param limitesuperior
     */
    public void setLimitesuperior(java.lang.Double limitesuperior) {
        this.limitesuperior = limitesuperior;
    }


    /**
     * Gets the meta value for this GraficoDetalhePtDTO.
     * 
     * @return meta
     */
    public java.lang.Double getMeta() {
        return meta;
    }


    /**
     * Sets the meta value for this GraficoDetalhePtDTO.
     * 
     * @param meta
     */
    public void setMeta(java.lang.Double meta) {
        this.meta = meta;
    }


    /**
     * Gets the metaHora value for this GraficoDetalhePtDTO.
     * 
     * @return metaHora
     */
    public java.lang.Double getMetaHora() {
        return metaHora;
    }


    /**
     * Sets the metaHora value for this GraficoDetalhePtDTO.
     * 
     * @param metaHora
     */
    public void setMetaHora(java.lang.Double metaHora) {
        this.metaHora = metaHora;
    }


    /**
     * Gets the tpgrafico value for this GraficoDetalhePtDTO.
     * 
     * @return tpgrafico
     */
    public int getTpgrafico() {
        return tpgrafico;
    }


    /**
     * Sets the tpgrafico value for this GraficoDetalhePtDTO.
     * 
     * @param tpgrafico
     */
    public void setTpgrafico(int tpgrafico) {
        this.tpgrafico = tpgrafico;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoDetalhePtDTO)) return false;
        GraficoDetalhePtDTO other = (GraficoDetalhePtDTO) obj;
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
            this.comParadas == other.isComParadas() &&
            ((this.dwConsolid==null && other.getDwConsolid()==null) || 
             (this.dwConsolid!=null &&
              this.dwConsolid.equals(other.getDwConsolid()))) &&
            ((this.dwConsolidDTOs==null && other.getDwConsolidDTOs()==null) || 
             (this.dwConsolidDTOs!=null &&
              this.dwConsolidDTOs.equals(other.getDwConsolidDTOs()))) &&
            ((this.limiteinferior==null && other.getLimiteinferior()==null) || 
             (this.limiteinferior!=null &&
              this.limiteinferior.equals(other.getLimiteinferior()))) &&
            ((this.limitesuperior==null && other.getLimitesuperior()==null) || 
             (this.limitesuperior!=null &&
              this.limitesuperior.equals(other.getLimitesuperior()))) &&
            ((this.meta==null && other.getMeta()==null) || 
             (this.meta!=null &&
              this.meta.equals(other.getMeta()))) &&
            ((this.metaHora==null && other.getMetaHora()==null) || 
             (this.metaHora!=null &&
              this.metaHora.equals(other.getMetaHora()))) &&
            this.tpgrafico == other.getTpgrafico();
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
        _hashCode += (isComParadas() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDwConsolid() != null) {
            _hashCode += getDwConsolid().hashCode();
        }
        if (getDwConsolidDTOs() != null) {
            _hashCode += getDwConsolidDTOs().hashCode();
        }
        if (getLimiteinferior() != null) {
            _hashCode += getLimiteinferior().hashCode();
        }
        if (getLimitesuperior() != null) {
            _hashCode += getLimitesuperior().hashCode();
        }
        if (getMeta() != null) {
            _hashCode += getMeta().hashCode();
        }
        if (getMetaHora() != null) {
            _hashCode += getMetaHora().hashCode();
        }
        _hashCode += getTpgrafico();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GraficoDetalhePtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoDetalhePtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolidDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolidDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolidDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolidDTOs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limiteinferior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limiteinferior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitesuperior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limitesuperior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("meta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "meta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpgrafico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpgrafico"));
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
