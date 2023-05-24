/**
 * PlanoListDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PlanoListDTO  implements java.io.Serializable {
    private idw.idwws.OmCfg configuracao;

    private java.util.Calendar dthrAtualConsulta;

    private idw.idwws.PlanoDTO[] planos;

    private idw.idwws.ResultadoDTO resultado;

    public PlanoListDTO() {
    }

    public PlanoListDTO(
           idw.idwws.OmCfg configuracao,
           java.util.Calendar dthrAtualConsulta,
           idw.idwws.PlanoDTO[] planos,
           idw.idwws.ResultadoDTO resultado) {
           this.configuracao = configuracao;
           this.dthrAtualConsulta = dthrAtualConsulta;
           this.planos = planos;
           this.resultado = resultado;
    }


    /**
     * Gets the configuracao value for this PlanoListDTO.
     * 
     * @return configuracao
     */
    public idw.idwws.OmCfg getConfiguracao() {
        return configuracao;
    }


    /**
     * Sets the configuracao value for this PlanoListDTO.
     * 
     * @param configuracao
     */
    public void setConfiguracao(idw.idwws.OmCfg configuracao) {
        this.configuracao = configuracao;
    }


    /**
     * Gets the dthrAtualConsulta value for this PlanoListDTO.
     * 
     * @return dthrAtualConsulta
     */
    public java.util.Calendar getDthrAtualConsulta() {
        return dthrAtualConsulta;
    }


    /**
     * Sets the dthrAtualConsulta value for this PlanoListDTO.
     * 
     * @param dthrAtualConsulta
     */
    public void setDthrAtualConsulta(java.util.Calendar dthrAtualConsulta) {
        this.dthrAtualConsulta = dthrAtualConsulta;
    }


    /**
     * Gets the planos value for this PlanoListDTO.
     * 
     * @return planos
     */
    public idw.idwws.PlanoDTO[] getPlanos() {
        return planos;
    }


    /**
     * Sets the planos value for this PlanoListDTO.
     * 
     * @param planos
     */
    public void setPlanos(idw.idwws.PlanoDTO[] planos) {
        this.planos = planos;
    }

    public idw.idwws.PlanoDTO getPlanos(int i) {
        return this.planos[i];
    }

    public void setPlanos(int i, idw.idwws.PlanoDTO _value) {
        this.planos[i] = _value;
    }


    /**
     * Gets the resultado value for this PlanoListDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this PlanoListDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PlanoListDTO)) return false;
        PlanoListDTO other = (PlanoListDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.configuracao==null && other.getConfiguracao()==null) || 
             (this.configuracao!=null &&
              this.configuracao.equals(other.getConfiguracao()))) &&
            ((this.dthrAtualConsulta==null && other.getDthrAtualConsulta()==null) || 
             (this.dthrAtualConsulta!=null &&
              this.dthrAtualConsulta.equals(other.getDthrAtualConsulta()))) &&
            ((this.planos==null && other.getPlanos()==null) || 
             (this.planos!=null &&
              java.util.Arrays.equals(this.planos, other.getPlanos()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado())));
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
        if (getConfiguracao() != null) {
            _hashCode += getConfiguracao().hashCode();
        }
        if (getDthrAtualConsulta() != null) {
            _hashCode += getDthrAtualConsulta().hashCode();
        }
        if (getPlanos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPlanos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPlanos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PlanoListDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "planoListDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configuracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "configuracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrAtualConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrAtualConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "planoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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