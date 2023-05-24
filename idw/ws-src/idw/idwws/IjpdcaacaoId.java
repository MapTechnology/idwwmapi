/**
 * IjpdcaacaoId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjpdcaacaoId  implements java.io.Serializable {
    private java.math.BigDecimal idagendamento;

    private java.lang.String nrprojeto;

    public IjpdcaacaoId() {
    }

    public IjpdcaacaoId(
           java.math.BigDecimal idagendamento,
           java.lang.String nrprojeto) {
           this.idagendamento = idagendamento;
           this.nrprojeto = nrprojeto;
    }


    /**
     * Gets the idagendamento value for this IjpdcaacaoId.
     * 
     * @return idagendamento
     */
    public java.math.BigDecimal getIdagendamento() {
        return idagendamento;
    }


    /**
     * Sets the idagendamento value for this IjpdcaacaoId.
     * 
     * @param idagendamento
     */
    public void setIdagendamento(java.math.BigDecimal idagendamento) {
        this.idagendamento = idagendamento;
    }


    /**
     * Gets the nrprojeto value for this IjpdcaacaoId.
     * 
     * @return nrprojeto
     */
    public java.lang.String getNrprojeto() {
        return nrprojeto;
    }


    /**
     * Sets the nrprojeto value for this IjpdcaacaoId.
     * 
     * @param nrprojeto
     */
    public void setNrprojeto(java.lang.String nrprojeto) {
        this.nrprojeto = nrprojeto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjpdcaacaoId)) return false;
        IjpdcaacaoId other = (IjpdcaacaoId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idagendamento==null && other.getIdagendamento()==null) || 
             (this.idagendamento!=null &&
              this.idagendamento.equals(other.getIdagendamento()))) &&
            ((this.nrprojeto==null && other.getNrprojeto()==null) || 
             (this.nrprojeto!=null &&
              this.nrprojeto.equals(other.getNrprojeto())));
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
        if (getIdagendamento() != null) {
            _hashCode += getIdagendamento().hashCode();
        }
        if (getNrprojeto() != null) {
            _hashCode += getNrprojeto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjpdcaacaoId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaacaoId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idagendamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idagendamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrprojeto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrprojeto"));
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
