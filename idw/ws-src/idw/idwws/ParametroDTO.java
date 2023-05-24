/**
 * ParametroDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ParametroDTO  implements java.io.Serializable {
    private int ERRO_DESCONHECIDO;

    private int ERRO_PARAMETRO_DESCONHECIDO;

    private int ERRO_PARAMETRO_SENDO_USADO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.DwFtParam parametro;

    private int resultadoEvento;

    public ParametroDTO() {
    }

    public ParametroDTO(
           int ERRO_DESCONHECIDO,
           int ERRO_PARAMETRO_DESCONHECIDO,
           int ERRO_PARAMETRO_SENDO_USADO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.DwFtParam parametro,
           int resultadoEvento) {
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_PARAMETRO_DESCONHECIDO = ERRO_PARAMETRO_DESCONHECIDO;
           this.ERRO_PARAMETRO_SENDO_USADO = ERRO_PARAMETRO_SENDO_USADO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.parametro = parametro;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this ParametroDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this ParametroDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PARAMETRO_DESCONHECIDO value for this ParametroDTO.
     * 
     * @return ERRO_PARAMETRO_DESCONHECIDO
     */
    public int getERRO_PARAMETRO_DESCONHECIDO() {
        return ERRO_PARAMETRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PARAMETRO_DESCONHECIDO value for this ParametroDTO.
     * 
     * @param ERRO_PARAMETRO_DESCONHECIDO
     */
    public void setERRO_PARAMETRO_DESCONHECIDO(int ERRO_PARAMETRO_DESCONHECIDO) {
        this.ERRO_PARAMETRO_DESCONHECIDO = ERRO_PARAMETRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PARAMETRO_SENDO_USADO value for this ParametroDTO.
     * 
     * @return ERRO_PARAMETRO_SENDO_USADO
     */
    public int getERRO_PARAMETRO_SENDO_USADO() {
        return ERRO_PARAMETRO_SENDO_USADO;
    }


    /**
     * Sets the ERRO_PARAMETRO_SENDO_USADO value for this ParametroDTO.
     * 
     * @param ERRO_PARAMETRO_SENDO_USADO
     */
    public void setERRO_PARAMETRO_SENDO_USADO(int ERRO_PARAMETRO_SENDO_USADO) {
        this.ERRO_PARAMETRO_SENDO_USADO = ERRO_PARAMETRO_SENDO_USADO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this ParametroDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this ParametroDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the parametro value for this ParametroDTO.
     * 
     * @return parametro
     */
    public idw.idwws.DwFtParam getParametro() {
        return parametro;
    }


    /**
     * Sets the parametro value for this ParametroDTO.
     * 
     * @param parametro
     */
    public void setParametro(idw.idwws.DwFtParam parametro) {
        this.parametro = parametro;
    }


    /**
     * Gets the resultadoEvento value for this ParametroDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this ParametroDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParametroDTO)) return false;
        ParametroDTO other = (ParametroDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_PARAMETRO_DESCONHECIDO == other.getERRO_PARAMETRO_DESCONHECIDO() &&
            this.ERRO_PARAMETRO_SENDO_USADO == other.getERRO_PARAMETRO_SENDO_USADO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.parametro==null && other.getParametro()==null) || 
             (this.parametro!=null &&
              this.parametro.equals(other.getParametro()))) &&
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
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_PARAMETRO_DESCONHECIDO();
        _hashCode += getERRO_PARAMETRO_SENDO_USADO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getParametro() != null) {
            _hashCode += getParametro().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParametroDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "parametroDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PARAMETRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PARAMETRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PARAMETRO_SENDO_USADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PARAMETRO_SENDO_USADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parametro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
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
