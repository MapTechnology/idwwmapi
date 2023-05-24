/**
 * IndicadorMinMetaMaxDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IndicadorMinMetaMaxDTO  extends idw.idwws.IndicadorValorDTO  implements java.io.Serializable {
    private java.math.BigDecimal indInferior;

    private java.math.BigDecimal indMeta;

    private java.math.BigDecimal indSuperior;

    public IndicadorMinMetaMaxDTO() {
    }

    public IndicadorMinMetaMaxDTO(
           idw.idwws.OmInd omInd,
           double valor,
           java.math.BigDecimal indInferior,
           java.math.BigDecimal indMeta,
           java.math.BigDecimal indSuperior) {
        super(
            omInd,
            valor);
        this.indInferior = indInferior;
        this.indMeta = indMeta;
        this.indSuperior = indSuperior;
    }


    /**
     * Gets the indInferior value for this IndicadorMinMetaMaxDTO.
     * 
     * @return indInferior
     */
    public java.math.BigDecimal getIndInferior() {
        return indInferior;
    }


    /**
     * Sets the indInferior value for this IndicadorMinMetaMaxDTO.
     * 
     * @param indInferior
     */
    public void setIndInferior(java.math.BigDecimal indInferior) {
        this.indInferior = indInferior;
    }


    /**
     * Gets the indMeta value for this IndicadorMinMetaMaxDTO.
     * 
     * @return indMeta
     */
    public java.math.BigDecimal getIndMeta() {
        return indMeta;
    }


    /**
     * Sets the indMeta value for this IndicadorMinMetaMaxDTO.
     * 
     * @param indMeta
     */
    public void setIndMeta(java.math.BigDecimal indMeta) {
        this.indMeta = indMeta;
    }


    /**
     * Gets the indSuperior value for this IndicadorMinMetaMaxDTO.
     * 
     * @return indSuperior
     */
    public java.math.BigDecimal getIndSuperior() {
        return indSuperior;
    }


    /**
     * Sets the indSuperior value for this IndicadorMinMetaMaxDTO.
     * 
     * @param indSuperior
     */
    public void setIndSuperior(java.math.BigDecimal indSuperior) {
        this.indSuperior = indSuperior;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndicadorMinMetaMaxDTO)) return false;
        IndicadorMinMetaMaxDTO other = (IndicadorMinMetaMaxDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.indInferior==null && other.getIndInferior()==null) || 
             (this.indInferior!=null &&
              this.indInferior.equals(other.getIndInferior()))) &&
            ((this.indMeta==null && other.getIndMeta()==null) || 
             (this.indMeta!=null &&
              this.indMeta.equals(other.getIndMeta()))) &&
            ((this.indSuperior==null && other.getIndSuperior()==null) || 
             (this.indSuperior!=null &&
              this.indSuperior.equals(other.getIndSuperior())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getIndInferior() != null) {
            _hashCode += getIndInferior().hashCode();
        }
        if (getIndMeta() != null) {
            _hashCode += getIndMeta().hashCode();
        }
        if (getIndSuperior() != null) {
            _hashCode += getIndSuperior().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndicadorMinMetaMaxDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "indicadorMinMetaMaxDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indInferior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indInferior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indSuperior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indSuperior"));
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
