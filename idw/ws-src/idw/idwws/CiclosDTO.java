/**
 * CiclosDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CiclosDTO  implements java.io.Serializable {
    private idw.idwws.CapabilidadeProcessoDTO capabilidadeProcessoDTO;

    private java.math.BigDecimal cavAtivas;

    private java.math.BigDecimal cicloPadrao;

    private idw.idwws.CicloDTO[] listaCicloDTO;

    private java.math.BigDecimal metaHora;

    public CiclosDTO() {
    }

    public CiclosDTO(
           idw.idwws.CapabilidadeProcessoDTO capabilidadeProcessoDTO,
           java.math.BigDecimal cavAtivas,
           java.math.BigDecimal cicloPadrao,
           idw.idwws.CicloDTO[] listaCicloDTO,
           java.math.BigDecimal metaHora) {
           this.capabilidadeProcessoDTO = capabilidadeProcessoDTO;
           this.cavAtivas = cavAtivas;
           this.cicloPadrao = cicloPadrao;
           this.listaCicloDTO = listaCicloDTO;
           this.metaHora = metaHora;
    }


    /**
     * Gets the capabilidadeProcessoDTO value for this CiclosDTO.
     * 
     * @return capabilidadeProcessoDTO
     */
    public idw.idwws.CapabilidadeProcessoDTO getCapabilidadeProcessoDTO() {
        return capabilidadeProcessoDTO;
    }


    /**
     * Sets the capabilidadeProcessoDTO value for this CiclosDTO.
     * 
     * @param capabilidadeProcessoDTO
     */
    public void setCapabilidadeProcessoDTO(idw.idwws.CapabilidadeProcessoDTO capabilidadeProcessoDTO) {
        this.capabilidadeProcessoDTO = capabilidadeProcessoDTO;
    }


    /**
     * Gets the cavAtivas value for this CiclosDTO.
     * 
     * @return cavAtivas
     */
    public java.math.BigDecimal getCavAtivas() {
        return cavAtivas;
    }


    /**
     * Sets the cavAtivas value for this CiclosDTO.
     * 
     * @param cavAtivas
     */
    public void setCavAtivas(java.math.BigDecimal cavAtivas) {
        this.cavAtivas = cavAtivas;
    }


    /**
     * Gets the cicloPadrao value for this CiclosDTO.
     * 
     * @return cicloPadrao
     */
    public java.math.BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this CiclosDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.math.BigDecimal cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the listaCicloDTO value for this CiclosDTO.
     * 
     * @return listaCicloDTO
     */
    public idw.idwws.CicloDTO[] getListaCicloDTO() {
        return listaCicloDTO;
    }


    /**
     * Sets the listaCicloDTO value for this CiclosDTO.
     * 
     * @param listaCicloDTO
     */
    public void setListaCicloDTO(idw.idwws.CicloDTO[] listaCicloDTO) {
        this.listaCicloDTO = listaCicloDTO;
    }

    public idw.idwws.CicloDTO getListaCicloDTO(int i) {
        return this.listaCicloDTO[i];
    }

    public void setListaCicloDTO(int i, idw.idwws.CicloDTO _value) {
        this.listaCicloDTO[i] = _value;
    }


    /**
     * Gets the metaHora value for this CiclosDTO.
     * 
     * @return metaHora
     */
    public java.math.BigDecimal getMetaHora() {
        return metaHora;
    }


    /**
     * Sets the metaHora value for this CiclosDTO.
     * 
     * @param metaHora
     */
    public void setMetaHora(java.math.BigDecimal metaHora) {
        this.metaHora = metaHora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CiclosDTO)) return false;
        CiclosDTO other = (CiclosDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.capabilidadeProcessoDTO==null && other.getCapabilidadeProcessoDTO()==null) || 
             (this.capabilidadeProcessoDTO!=null &&
              this.capabilidadeProcessoDTO.equals(other.getCapabilidadeProcessoDTO()))) &&
            ((this.cavAtivas==null && other.getCavAtivas()==null) || 
             (this.cavAtivas!=null &&
              this.cavAtivas.equals(other.getCavAtivas()))) &&
            ((this.cicloPadrao==null && other.getCicloPadrao()==null) || 
             (this.cicloPadrao!=null &&
              this.cicloPadrao.equals(other.getCicloPadrao()))) &&
            ((this.listaCicloDTO==null && other.getListaCicloDTO()==null) || 
             (this.listaCicloDTO!=null &&
              java.util.Arrays.equals(this.listaCicloDTO, other.getListaCicloDTO()))) &&
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
        if (getCapabilidadeProcessoDTO() != null) {
            _hashCode += getCapabilidadeProcessoDTO().hashCode();
        }
        if (getCavAtivas() != null) {
            _hashCode += getCavAtivas().hashCode();
        }
        if (getCicloPadrao() != null) {
            _hashCode += getCicloPadrao().hashCode();
        }
        if (getListaCicloDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaCicloDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaCicloDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMetaHora() != null) {
            _hashCode += getMetaHora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CiclosDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ciclosDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("capabilidadeProcessoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "capabilidadeProcessoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "capabilidadeProcessoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("listaCicloDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaCicloDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cicloDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
