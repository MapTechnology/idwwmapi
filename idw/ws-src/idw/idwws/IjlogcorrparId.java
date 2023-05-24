/**
 * IjlogcorrparId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjlogcorrparId  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cdusuario;

    private java.util.Calendar dthralteracao;

    private java.util.Calendar dthriparada;

    public IjlogcorrparId() {
    }

    public IjlogcorrparId(
           java.lang.String cdinjetora,
           java.lang.String cdusuario,
           java.util.Calendar dthralteracao,
           java.util.Calendar dthriparada) {
           this.cdinjetora = cdinjetora;
           this.cdusuario = cdusuario;
           this.dthralteracao = dthralteracao;
           this.dthriparada = dthriparada;
    }


    /**
     * Gets the cdinjetora value for this IjlogcorrparId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjlogcorrparId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdusuario value for this IjlogcorrparId.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this IjlogcorrparId.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the dthralteracao value for this IjlogcorrparId.
     * 
     * @return dthralteracao
     */
    public java.util.Calendar getDthralteracao() {
        return dthralteracao;
    }


    /**
     * Sets the dthralteracao value for this IjlogcorrparId.
     * 
     * @param dthralteracao
     */
    public void setDthralteracao(java.util.Calendar dthralteracao) {
        this.dthralteracao = dthralteracao;
    }


    /**
     * Gets the dthriparada value for this IjlogcorrparId.
     * 
     * @return dthriparada
     */
    public java.util.Calendar getDthriparada() {
        return dthriparada;
    }


    /**
     * Sets the dthriparada value for this IjlogcorrparId.
     * 
     * @param dthriparada
     */
    public void setDthriparada(java.util.Calendar dthriparada) {
        this.dthriparada = dthriparada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjlogcorrparId)) return false;
        IjlogcorrparId other = (IjlogcorrparId) obj;
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
            ((this.dthralteracao==null && other.getDthralteracao()==null) || 
             (this.dthralteracao!=null &&
              this.dthralteracao.equals(other.getDthralteracao()))) &&
            ((this.dthriparada==null && other.getDthriparada()==null) || 
             (this.dthriparada!=null &&
              this.dthriparada.equals(other.getDthriparada())));
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
        if (getDthralteracao() != null) {
            _hashCode += getDthralteracao().hashCode();
        }
        if (getDthriparada() != null) {
            _hashCode += getDthriparada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjlogcorrparId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogcorrparId"));
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
        elemField.setFieldName("dthralteracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthralteracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriparada"));
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
