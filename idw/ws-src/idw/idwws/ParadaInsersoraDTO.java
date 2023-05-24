/**
 * ParadaInsersoraDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ParadaInsersoraDTO  implements java.io.Serializable {
    private java.lang.String codigoParada;

    private java.lang.String descricaoParada;

    private java.lang.String subCodigoParada;

    public ParadaInsersoraDTO() {
    }

    public ParadaInsersoraDTO(
           java.lang.String codigoParada,
           java.lang.String descricaoParada,
           java.lang.String subCodigoParada) {
           this.codigoParada = codigoParada;
           this.descricaoParada = descricaoParada;
           this.subCodigoParada = subCodigoParada;
    }


    /**
     * Gets the codigoParada value for this ParadaInsersoraDTO.
     * 
     * @return codigoParada
     */
    public java.lang.String getCodigoParada() {
        return codigoParada;
    }


    /**
     * Sets the codigoParada value for this ParadaInsersoraDTO.
     * 
     * @param codigoParada
     */
    public void setCodigoParada(java.lang.String codigoParada) {
        this.codigoParada = codigoParada;
    }


    /**
     * Gets the descricaoParada value for this ParadaInsersoraDTO.
     * 
     * @return descricaoParada
     */
    public java.lang.String getDescricaoParada() {
        return descricaoParada;
    }


    /**
     * Sets the descricaoParada value for this ParadaInsersoraDTO.
     * 
     * @param descricaoParada
     */
    public void setDescricaoParada(java.lang.String descricaoParada) {
        this.descricaoParada = descricaoParada;
    }


    /**
     * Gets the subCodigoParada value for this ParadaInsersoraDTO.
     * 
     * @return subCodigoParada
     */
    public java.lang.String getSubCodigoParada() {
        return subCodigoParada;
    }


    /**
     * Sets the subCodigoParada value for this ParadaInsersoraDTO.
     * 
     * @param subCodigoParada
     */
    public void setSubCodigoParada(java.lang.String subCodigoParada) {
        this.subCodigoParada = subCodigoParada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParadaInsersoraDTO)) return false;
        ParadaInsersoraDTO other = (ParadaInsersoraDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoParada==null && other.getCodigoParada()==null) || 
             (this.codigoParada!=null &&
              this.codigoParada.equals(other.getCodigoParada()))) &&
            ((this.descricaoParada==null && other.getDescricaoParada()==null) || 
             (this.descricaoParada!=null &&
              this.descricaoParada.equals(other.getDescricaoParada()))) &&
            ((this.subCodigoParada==null && other.getSubCodigoParada()==null) || 
             (this.subCodigoParada!=null &&
              this.subCodigoParada.equals(other.getSubCodigoParada())));
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
        if (getCodigoParada() != null) {
            _hashCode += getCodigoParada().hashCode();
        }
        if (getDescricaoParada() != null) {
            _hashCode += getDescricaoParada().hashCode();
        }
        if (getSubCodigoParada() != null) {
            _hashCode += getSubCodigoParada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParadaInsersoraDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paradaInsersoraDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricaoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricaoParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subCodigoParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subCodigoParada"));
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
