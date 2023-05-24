/**
 * XPAR02LST.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public class XPAR02LST  implements java.io.Serializable {
    private java.lang.String XPRODUTO_PESADO;

    private float XQUANTIDADE_PESADA;

    public XPAR02LST() {
    }

    public XPAR02LST(
           java.lang.String XPRODUTO_PESADO,
           float XQUANTIDADE_PESADA) {
           this.XPRODUTO_PESADO = XPRODUTO_PESADO;
           this.XQUANTIDADE_PESADA = XQUANTIDADE_PESADA;
    }


    /**
     * Gets the XPRODUTO_PESADO value for this XPAR02LST.
     * 
     * @return XPRODUTO_PESADO
     */
    public java.lang.String getXPRODUTO_PESADO() {
        return XPRODUTO_PESADO;
    }


    /**
     * Sets the XPRODUTO_PESADO value for this XPAR02LST.
     * 
     * @param XPRODUTO_PESADO
     */
    public void setXPRODUTO_PESADO(java.lang.String XPRODUTO_PESADO) {
        this.XPRODUTO_PESADO = XPRODUTO_PESADO;
    }


    /**
     * Gets the XQUANTIDADE_PESADA value for this XPAR02LST.
     * 
     * @return XQUANTIDADE_PESADA
     */
    public float getXQUANTIDADE_PESADA() {
        return XQUANTIDADE_PESADA;
    }


    /**
     * Sets the XQUANTIDADE_PESADA value for this XPAR02LST.
     * 
     * @param XQUANTIDADE_PESADA
     */
    public void setXQUANTIDADE_PESADA(float XQUANTIDADE_PESADA) {
        this.XQUANTIDADE_PESADA = XQUANTIDADE_PESADA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof XPAR02LST)) return false;
        XPAR02LST other = (XPAR02LST) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XPRODUTO_PESADO==null && other.getXPRODUTO_PESADO()==null) || 
             (this.XPRODUTO_PESADO!=null &&
              this.XPRODUTO_PESADO.equals(other.getXPRODUTO_PESADO()))) &&
            this.XQUANTIDADE_PESADA == other.getXQUANTIDADE_PESADA();
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
        if (getXPRODUTO_PESADO() != null) {
            _hashCode += getXPRODUTO_PESADO().hashCode();
        }
        _hashCode += new Float(getXQUANTIDADE_PESADA()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(XPAR02LST.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02LST"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XPRODUTO_PESADO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPRODUTO_PESADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XQUANTIDADE_PESADA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XQUANTIDADE_PESADA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
