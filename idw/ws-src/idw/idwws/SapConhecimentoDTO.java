/**
 * SapConhecimentoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class SapConhecimentoDTO  implements java.io.Serializable {
    private int resultadoEvento;

    private idw.idwws.TtSapCon sapconhecimento;

    public SapConhecimentoDTO() {
    }

    public SapConhecimentoDTO(
           int resultadoEvento,
           idw.idwws.TtSapCon sapconhecimento) {
           this.resultadoEvento = resultadoEvento;
           this.sapconhecimento = sapconhecimento;
    }


    /**
     * Gets the resultadoEvento value for this SapConhecimentoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this SapConhecimentoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the sapconhecimento value for this SapConhecimentoDTO.
     * 
     * @return sapconhecimento
     */
    public idw.idwws.TtSapCon getSapconhecimento() {
        return sapconhecimento;
    }


    /**
     * Sets the sapconhecimento value for this SapConhecimentoDTO.
     * 
     * @param sapconhecimento
     */
    public void setSapconhecimento(idw.idwws.TtSapCon sapconhecimento) {
        this.sapconhecimento = sapconhecimento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SapConhecimentoDTO)) return false;
        SapConhecimentoDTO other = (SapConhecimentoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.sapconhecimento==null && other.getSapconhecimento()==null) || 
             (this.sapconhecimento!=null &&
              this.sapconhecimento.equals(other.getSapconhecimento())));
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
        _hashCode += getResultadoEvento();
        if (getSapconhecimento() != null) {
            _hashCode += getSapconhecimento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SapConhecimentoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "sapConhecimentoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sapconhecimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sapconhecimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ttSapCon"));
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
