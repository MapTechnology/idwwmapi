/**
 * XPAR01.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public class XPAR01  implements java.io.Serializable {
    private java.util.Date XDATA_PREVISTA;

    private java.lang.String XNOME_MAQUINA;

    private java.lang.String XNUMERO_OP;

    public XPAR01() {
    }

    public XPAR01(
           java.util.Date XDATA_PREVISTA,
           java.lang.String XNOME_MAQUINA,
           java.lang.String XNUMERO_OP) {
           this.XDATA_PREVISTA = XDATA_PREVISTA;
           this.XNOME_MAQUINA = XNOME_MAQUINA;
           this.XNUMERO_OP = XNUMERO_OP;
    }


    /**
     * Gets the XDATA_PREVISTA value for this XPAR01.
     * 
     * @return XDATA_PREVISTA
     */
    public java.util.Date getXDATA_PREVISTA() {
        return XDATA_PREVISTA;
    }


    /**
     * Sets the XDATA_PREVISTA value for this XPAR01.
     * 
     * @param XDATA_PREVISTA
     */
    public void setXDATA_PREVISTA(java.util.Date XDATA_PREVISTA) {
        this.XDATA_PREVISTA = XDATA_PREVISTA;
    }


    /**
     * Gets the XNOME_MAQUINA value for this XPAR01.
     * 
     * @return XNOME_MAQUINA
     */
    public java.lang.String getXNOME_MAQUINA() {
        return XNOME_MAQUINA;
    }


    /**
     * Sets the XNOME_MAQUINA value for this XPAR01.
     * 
     * @param XNOME_MAQUINA
     */
    public void setXNOME_MAQUINA(java.lang.String XNOME_MAQUINA) {
        this.XNOME_MAQUINA = XNOME_MAQUINA;
    }


    /**
     * Gets the XNUMERO_OP value for this XPAR01.
     * 
     * @return XNUMERO_OP
     */
    public java.lang.String getXNUMERO_OP() {
        return XNUMERO_OP;
    }


    /**
     * Sets the XNUMERO_OP value for this XPAR01.
     * 
     * @param XNUMERO_OP
     */
    public void setXNUMERO_OP(java.lang.String XNUMERO_OP) {
        this.XNUMERO_OP = XNUMERO_OP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof XPAR01)) return false;
        XPAR01 other = (XPAR01) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XDATA_PREVISTA==null && other.getXDATA_PREVISTA()==null) || 
             (this.XDATA_PREVISTA!=null &&
              this.XDATA_PREVISTA.equals(other.getXDATA_PREVISTA()))) &&
            ((this.XNOME_MAQUINA==null && other.getXNOME_MAQUINA()==null) || 
             (this.XNOME_MAQUINA!=null &&
              this.XNOME_MAQUINA.equals(other.getXNOME_MAQUINA()))) &&
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
        if (getXDATA_PREVISTA() != null) {
            _hashCode += getXDATA_PREVISTA().hashCode();
        }
        if (getXNOME_MAQUINA() != null) {
            _hashCode += getXNOME_MAQUINA().hashCode();
        }
        if (getXNUMERO_OP() != null) {
            _hashCode += getXNUMERO_OP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(XPAR01.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR01"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XDATA_PREVISTA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XDATA_PREVISTA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XNOME_MAQUINA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XNOME_MAQUINA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
