/**
 * IjpdcaagndacmpId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjpdcaagndacmpId  implements java.io.Serializable {
    private java.util.Calendar dtagendamento;

    private java.math.BigDecimal idparticipante;

    private java.lang.String nrprojeto;

    public IjpdcaagndacmpId() {
    }

    public IjpdcaagndacmpId(
           java.util.Calendar dtagendamento,
           java.math.BigDecimal idparticipante,
           java.lang.String nrprojeto) {
           this.dtagendamento = dtagendamento;
           this.idparticipante = idparticipante;
           this.nrprojeto = nrprojeto;
    }


    /**
     * Gets the dtagendamento value for this IjpdcaagndacmpId.
     * 
     * @return dtagendamento
     */
    public java.util.Calendar getDtagendamento() {
        return dtagendamento;
    }


    /**
     * Sets the dtagendamento value for this IjpdcaagndacmpId.
     * 
     * @param dtagendamento
     */
    public void setDtagendamento(java.util.Calendar dtagendamento) {
        this.dtagendamento = dtagendamento;
    }


    /**
     * Gets the idparticipante value for this IjpdcaagndacmpId.
     * 
     * @return idparticipante
     */
    public java.math.BigDecimal getIdparticipante() {
        return idparticipante;
    }


    /**
     * Sets the idparticipante value for this IjpdcaagndacmpId.
     * 
     * @param idparticipante
     */
    public void setIdparticipante(java.math.BigDecimal idparticipante) {
        this.idparticipante = idparticipante;
    }


    /**
     * Gets the nrprojeto value for this IjpdcaagndacmpId.
     * 
     * @return nrprojeto
     */
    public java.lang.String getNrprojeto() {
        return nrprojeto;
    }


    /**
     * Sets the nrprojeto value for this IjpdcaagndacmpId.
     * 
     * @param nrprojeto
     */
    public void setNrprojeto(java.lang.String nrprojeto) {
        this.nrprojeto = nrprojeto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjpdcaagndacmpId)) return false;
        IjpdcaagndacmpId other = (IjpdcaagndacmpId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtagendamento==null && other.getDtagendamento()==null) || 
             (this.dtagendamento!=null &&
              this.dtagendamento.equals(other.getDtagendamento()))) &&
            ((this.idparticipante==null && other.getIdparticipante()==null) || 
             (this.idparticipante!=null &&
              this.idparticipante.equals(other.getIdparticipante()))) &&
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
        if (getDtagendamento() != null) {
            _hashCode += getDtagendamento().hashCode();
        }
        if (getIdparticipante() != null) {
            _hashCode += getIdparticipante().hashCode();
        }
        if (getNrprojeto() != null) {
            _hashCode += getNrprojeto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjpdcaagndacmpId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaagndacmpId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtagendamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtagendamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idparticipante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idparticipante"));
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
