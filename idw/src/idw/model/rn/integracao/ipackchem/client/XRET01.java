/**
 * XRET01.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public class XRET01  implements java.io.Serializable {
    private java.lang.String XMENSAGEM;

    private java.lang.String XSTATUS;

    public XRET01() {
    }

    public XRET01(
           java.lang.String XMENSAGEM,
           java.lang.String XSTATUS) {
           this.XMENSAGEM = XMENSAGEM;
           this.XSTATUS = XSTATUS;
    }


    /**
     * Gets the XMENSAGEM value for this XRET01.
     * 
     * @return XMENSAGEM
     */
    public java.lang.String getXMENSAGEM() {
        return XMENSAGEM;
    }


    /**
     * Sets the XMENSAGEM value for this XRET01.
     * 
     * @param XMENSAGEM
     */
    public void setXMENSAGEM(java.lang.String XMENSAGEM) {
        this.XMENSAGEM = XMENSAGEM;
    }


    /**
     * Gets the XSTATUS value for this XRET01.
     * 
     * @return XSTATUS
     */
    public java.lang.String getXSTATUS() {
        return XSTATUS;
    }


    /**
     * Sets the XSTATUS value for this XRET01.
     * 
     * @param XSTATUS
     */
    public void setXSTATUS(java.lang.String XSTATUS) {
        this.XSTATUS = XSTATUS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof XRET01)) return false;
        XRET01 other = (XRET01) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XMENSAGEM==null && other.getXMENSAGEM()==null) || 
             (this.XMENSAGEM!=null &&
              this.XMENSAGEM.equals(other.getXMENSAGEM()))) &&
            ((this.XSTATUS==null && other.getXSTATUS()==null) || 
             (this.XSTATUS!=null &&
              this.XSTATUS.equals(other.getXSTATUS())));
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
        if (getXMENSAGEM() != null) {
            _hashCode += getXMENSAGEM().hashCode();
        }
        if (getXSTATUS() != null) {
            _hashCode += getXSTATUS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(XRET01.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XRET01"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XMENSAGEM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XMENSAGEM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XSTATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XSTATUS"));
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
