/**
 * ComponenteDeParaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ComponenteDeParaDTO  implements java.io.Serializable {
    private java.lang.String componente;

    private int EVENTO_BEM_SUCEDIDO;

    private java.lang.String fornecedor;

    private int resultadoEvento;

    public ComponenteDeParaDTO() {
    }

    public ComponenteDeParaDTO(
           java.lang.String componente,
           int EVENTO_BEM_SUCEDIDO,
           java.lang.String fornecedor,
           int resultadoEvento) {
           this.componente = componente;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.fornecedor = fornecedor;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the componente value for this ComponenteDeParaDTO.
     * 
     * @return componente
     */
    public java.lang.String getComponente() {
        return componente;
    }


    /**
     * Sets the componente value for this ComponenteDeParaDTO.
     * 
     * @param componente
     */
    public void setComponente(java.lang.String componente) {
        this.componente = componente;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this ComponenteDeParaDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this ComponenteDeParaDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the fornecedor value for this ComponenteDeParaDTO.
     * 
     * @return fornecedor
     */
    public java.lang.String getFornecedor() {
        return fornecedor;
    }


    /**
     * Sets the fornecedor value for this ComponenteDeParaDTO.
     * 
     * @param fornecedor
     */
    public void setFornecedor(java.lang.String fornecedor) {
        this.fornecedor = fornecedor;
    }


    /**
     * Gets the resultadoEvento value for this ComponenteDeParaDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this ComponenteDeParaDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComponenteDeParaDTO)) return false;
        ComponenteDeParaDTO other = (ComponenteDeParaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.componente==null && other.getComponente()==null) || 
             (this.componente!=null &&
              this.componente.equals(other.getComponente()))) &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.fornecedor==null && other.getFornecedor()==null) || 
             (this.fornecedor!=null &&
              this.fornecedor.equals(other.getFornecedor()))) &&
            this.resultadoEvento == other.getResultadoEvento();
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
        if (getComponente() != null) {
            _hashCode += getComponente().hashCode();
        }
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getFornecedor() != null) {
            _hashCode += getFornecedor().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComponenteDeParaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "componenteDeParaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "componente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fornecedor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fornecedor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
