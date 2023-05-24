/**
 * IjlogipesemconexaoId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjlogipesemconexaoId  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cdusuario;

    private java.util.Calendar dthrocorrencia;

    private java.util.Calendar dthrultimaleitura;

    public IjlogipesemconexaoId() {
    }

    public IjlogipesemconexaoId(
           java.lang.String cdinjetora,
           java.lang.String cdusuario,
           java.util.Calendar dthrocorrencia,
           java.util.Calendar dthrultimaleitura) {
           this.cdinjetora = cdinjetora;
           this.cdusuario = cdusuario;
           this.dthrocorrencia = dthrocorrencia;
           this.dthrultimaleitura = dthrultimaleitura;
    }


    /**
     * Gets the cdinjetora value for this IjlogipesemconexaoId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjlogipesemconexaoId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdusuario value for this IjlogipesemconexaoId.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this IjlogipesemconexaoId.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the dthrocorrencia value for this IjlogipesemconexaoId.
     * 
     * @return dthrocorrencia
     */
    public java.util.Calendar getDthrocorrencia() {
        return dthrocorrencia;
    }


    /**
     * Sets the dthrocorrencia value for this IjlogipesemconexaoId.
     * 
     * @param dthrocorrencia
     */
    public void setDthrocorrencia(java.util.Calendar dthrocorrencia) {
        this.dthrocorrencia = dthrocorrencia;
    }


    /**
     * Gets the dthrultimaleitura value for this IjlogipesemconexaoId.
     * 
     * @return dthrultimaleitura
     */
    public java.util.Calendar getDthrultimaleitura() {
        return dthrultimaleitura;
    }


    /**
     * Sets the dthrultimaleitura value for this IjlogipesemconexaoId.
     * 
     * @param dthrultimaleitura
     */
    public void setDthrultimaleitura(java.util.Calendar dthrultimaleitura) {
        this.dthrultimaleitura = dthrultimaleitura;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjlogipesemconexaoId)) return false;
        IjlogipesemconexaoId other = (IjlogipesemconexaoId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.dthrocorrencia==null && other.getDthrocorrencia()==null) || 
             (this.dthrocorrencia!=null &&
              this.dthrocorrencia.equals(other.getDthrocorrencia()))) &&
            ((this.dthrultimaleitura==null && other.getDthrultimaleitura()==null) || 
             (this.dthrultimaleitura!=null &&
              this.dthrultimaleitura.equals(other.getDthrultimaleitura())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getDthrocorrencia() != null) {
            _hashCode += getDthrocorrencia().hashCode();
        }
        if (getDthrultimaleitura() != null) {
            _hashCode += getDthrultimaleitura().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjlogipesemconexaoId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogipesemconexaoId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrocorrencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrocorrencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrultimaleitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrultimaleitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
