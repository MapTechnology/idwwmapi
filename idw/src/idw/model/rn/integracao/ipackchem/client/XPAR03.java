/**
 * XPAR03.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public class XPAR03  implements java.io.Serializable {
    private java.util.Date XDATA_LIBERACAO;

    private java.lang.String XNUMERO_OP;

    public XPAR03() {
    }

    public XPAR03(
           java.util.Date XDATA_LIBERACAO,
           java.lang.String XNUMERO_OP) {
           this.XDATA_LIBERACAO = XDATA_LIBERACAO;
           this.XNUMERO_OP = XNUMERO_OP;
    }


    /**
     * Gets the XDATA_LIBERACAO value for this XPAR03.
     * 
     * @return XDATA_LIBERACAO
     */
    public java.util.Date getXDATA_LIBERACAO() {
        return XDATA_LIBERACAO;
    }


    /**
     * Sets the XDATA_LIBERACAO value for this XPAR03.
     * 
     * @param XDATA_LIBERACAO
     */
    public void setXDATA_LIBERACAO(java.util.Date XDATA_LIBERACAO) {
        this.XDATA_LIBERACAO = XDATA_LIBERACAO;
    }


    /**
     * Gets the XNUMERO_OP value for this XPAR03.
     * 
     * @return XNUMERO_OP
     */
    public java.lang.String getXNUMERO_OP() {
        return XNUMERO_OP;
    }


    /**
     * Sets the XNUMERO_OP value for this XPAR03.
     * 
     * @param XNUMERO_OP
     */
    public void setXNUMERO_OP(java.lang.String XNUMERO_OP) {
        this.XNUMERO_OP = XNUMERO_OP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof XPAR03)) return false;
        XPAR03 other = (XPAR03) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XDATA_LIBERACAO==null && other.getXDATA_LIBERACAO()==null) || 
             (this.XDATA_LIBERACAO!=null &&
              this.XDATA_LIBERACAO.equals(other.getXDATA_LIBERACAO()))) &&
            ((this.XNUMERO_OP==null && other.getXNUMERO_OP()==null) || 
             (this.XNUMERO_OP!=null &&
              this.XNUMERO_OP.equals(other.getXNUMERO_OP())));
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
        if (getXDATA_LIBERACAO() != null) {
            _hashCode += getXDATA_LIBERACAO().hashCode();
        }
        if (getXNUMERO_OP() != null) {
            _hashCode += getXNUMERO_OP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(XPAR03.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR03"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XDATA_LIBERACAO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XDATA_LIBERACAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XNUMERO_OP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XNUMERO_OP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
