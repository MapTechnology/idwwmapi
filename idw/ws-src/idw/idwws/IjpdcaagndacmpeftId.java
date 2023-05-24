/**
 * IjpdcaagndacmpeftId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjpdcaagndacmpeftId  implements java.io.Serializable {
    private java.lang.String cdefeito;

    private java.math.BigDecimal idparticipante;

    private java.lang.String nrprojeto;

    private java.math.BigDecimal tpefeito;

    public IjpdcaagndacmpeftId() {
    }

    public IjpdcaagndacmpeftId(
           java.lang.String cdefeito,
           java.math.BigDecimal idparticipante,
           java.lang.String nrprojeto,
           java.math.BigDecimal tpefeito) {
           this.cdefeito = cdefeito;
           this.idparticipante = idparticipante;
           this.nrprojeto = nrprojeto;
           this.tpefeito = tpefeito;
    }


    /**
     * Gets the cdefeito value for this IjpdcaagndacmpeftId.
     * 
     * @return cdefeito
     */
    public java.lang.String getCdefeito() {
        return cdefeito;
    }


    /**
     * Sets the cdefeito value for this IjpdcaagndacmpeftId.
     * 
     * @param cdefeito
     */
    public void setCdefeito(java.lang.String cdefeito) {
        this.cdefeito = cdefeito;
    }


    /**
     * Gets the idparticipante value for this IjpdcaagndacmpeftId.
     * 
     * @return idparticipante
     */
    public java.math.BigDecimal getIdparticipante() {
        return idparticipante;
    }


    /**
     * Sets the idparticipante value for this IjpdcaagndacmpeftId.
     * 
     * @param idparticipante
     */
    public void setIdparticipante(java.math.BigDecimal idparticipante) {
        this.idparticipante = idparticipante;
    }


    /**
     * Gets the nrprojeto value for this IjpdcaagndacmpeftId.
     * 
     * @return nrprojeto
     */
    public java.lang.String getNrprojeto() {
        return nrprojeto;
    }


    /**
     * Sets the nrprojeto value for this IjpdcaagndacmpeftId.
     * 
     * @param nrprojeto
     */
    public void setNrprojeto(java.lang.String nrprojeto) {
        this.nrprojeto = nrprojeto;
    }


    /**
     * Gets the tpefeito value for this IjpdcaagndacmpeftId.
     * 
     * @return tpefeito
     */
    public java.math.BigDecimal getTpefeito() {
        return tpefeito;
    }


    /**
     * Sets the tpefeito value for this IjpdcaagndacmpeftId.
     * 
     * @param tpefeito
     */
    public void setTpefeito(java.math.BigDecimal tpefeito) {
        this.tpefeito = tpefeito;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjpdcaagndacmpeftId)) return false;
        IjpdcaagndacmpeftId other = (IjpdcaagndacmpeftId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdefeito==null && other.getCdefeito()==null) || 
             (this.cdefeito!=null &&
              this.cdefeito.equals(other.getCdefeito()))) &&
            ((this.idparticipante==null && other.getIdparticipante()==null) || 
             (this.idparticipante!=null &&
              this.idparticipante.equals(other.getIdparticipante()))) &&
            ((this.nrprojeto==null && other.getNrprojeto()==null) || 
             (this.nrprojeto!=null &&
              this.nrprojeto.equals(other.getNrprojeto()))) &&
            ((this.tpefeito==null && other.getTpefeito()==null) || 
             (this.tpefeito!=null &&
              this.tpefeito.equals(other.getTpefeito())));
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
        if (getCdefeito() != null) {
            _hashCode += getCdefeito().hashCode();
        }
        if (getIdparticipante() != null) {
            _hashCode += getIdparticipante().hashCode();
        }
        if (getNrprojeto() != null) {
            _hashCode += getNrprojeto().hashCode();
        }
        if (getTpefeito() != null) {
            _hashCode += getTpefeito().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjpdcaagndacmpeftId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaagndacmpeftId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdefeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdefeito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpefeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpefeito"));
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
