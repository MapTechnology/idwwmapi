/**
 * IjamostragemdetobsId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjamostragemdetobsId  implements java.io.Serializable {
    private java.math.BigDecimal amostra;

    private java.util.Calendar dthralteracao;

    private java.lang.String idamostragem;

    public IjamostragemdetobsId() {
    }

    public IjamostragemdetobsId(
           java.math.BigDecimal amostra,
           java.util.Calendar dthralteracao,
           java.lang.String idamostragem) {
           this.amostra = amostra;
           this.dthralteracao = dthralteracao;
           this.idamostragem = idamostragem;
    }


    /**
     * Gets the amostra value for this IjamostragemdetobsId.
     * 
     * @return amostra
     */
    public java.math.BigDecimal getAmostra() {
        return amostra;
    }


    /**
     * Sets the amostra value for this IjamostragemdetobsId.
     * 
     * @param amostra
     */
    public void setAmostra(java.math.BigDecimal amostra) {
        this.amostra = amostra;
    }


    /**
     * Gets the dthralteracao value for this IjamostragemdetobsId.
     * 
     * @return dthralteracao
     */
    public java.util.Calendar getDthralteracao() {
        return dthralteracao;
    }


    /**
     * Sets the dthralteracao value for this IjamostragemdetobsId.
     * 
     * @param dthralteracao
     */
    public void setDthralteracao(java.util.Calendar dthralteracao) {
        this.dthralteracao = dthralteracao;
    }


    /**
     * Gets the idamostragem value for this IjamostragemdetobsId.
     * 
     * @return idamostragem
     */
    public java.lang.String getIdamostragem() {
        return idamostragem;
    }


    /**
     * Sets the idamostragem value for this IjamostragemdetobsId.
     * 
     * @param idamostragem
     */
    public void setIdamostragem(java.lang.String idamostragem) {
        this.idamostragem = idamostragem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjamostragemdetobsId)) return false;
        IjamostragemdetobsId other = (IjamostragemdetobsId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amostra==null && other.getAmostra()==null) || 
             (this.amostra!=null &&
              this.amostra.equals(other.getAmostra()))) &&
            ((this.dthralteracao==null && other.getDthralteracao()==null) || 
             (this.dthralteracao!=null &&
              this.dthralteracao.equals(other.getDthralteracao()))) &&
            ((this.idamostragem==null && other.getIdamostragem()==null) || 
             (this.idamostragem!=null &&
              this.idamostragem.equals(other.getIdamostragem())));
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
        if (getAmostra() != null) {
            _hashCode += getAmostra().hashCode();
        }
        if (getDthralteracao() != null) {
            _hashCode += getDthralteracao().hashCode();
        }
        if (getIdamostragem() != null) {
            _hashCode += getIdamostragem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjamostragemdetobsId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdetobsId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amostra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amostra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("idamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idamostragem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
