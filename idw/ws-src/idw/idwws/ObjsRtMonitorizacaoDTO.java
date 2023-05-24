/**
 * ObjsRtMonitorizacaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ObjsRtMonitorizacaoDTO  implements java.io.Serializable {
    private idw.idwws.ObjRtMonitorizacaoDTO[] objsRtMonitorizacao;

    private int resultadoEvento;

    public ObjsRtMonitorizacaoDTO() {
    }

    public ObjsRtMonitorizacaoDTO(
           idw.idwws.ObjRtMonitorizacaoDTO[] objsRtMonitorizacao,
           int resultadoEvento) {
           this.objsRtMonitorizacao = objsRtMonitorizacao;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the objsRtMonitorizacao value for this ObjsRtMonitorizacaoDTO.
     * 
     * @return objsRtMonitorizacao
     */
    public idw.idwws.ObjRtMonitorizacaoDTO[] getObjsRtMonitorizacao() {
        return objsRtMonitorizacao;
    }


    /**
     * Sets the objsRtMonitorizacao value for this ObjsRtMonitorizacaoDTO.
     * 
     * @param objsRtMonitorizacao
     */
    public void setObjsRtMonitorizacao(idw.idwws.ObjRtMonitorizacaoDTO[] objsRtMonitorizacao) {
        this.objsRtMonitorizacao = objsRtMonitorizacao;
    }

    public idw.idwws.ObjRtMonitorizacaoDTO getObjsRtMonitorizacao(int i) {
        return this.objsRtMonitorizacao[i];
    }

    public void setObjsRtMonitorizacao(int i, idw.idwws.ObjRtMonitorizacaoDTO _value) {
        this.objsRtMonitorizacao[i] = _value;
    }


    /**
     * Gets the resultadoEvento value for this ObjsRtMonitorizacaoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this ObjsRtMonitorizacaoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjsRtMonitorizacaoDTO)) return false;
        ObjsRtMonitorizacaoDTO other = (ObjsRtMonitorizacaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objsRtMonitorizacao==null && other.getObjsRtMonitorizacao()==null) || 
             (this.objsRtMonitorizacao!=null &&
              java.util.Arrays.equals(this.objsRtMonitorizacao, other.getObjsRtMonitorizacao()))) &&
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
        if (getObjsRtMonitorizacao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjsRtMonitorizacao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjsRtMonitorizacao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObjsRtMonitorizacaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objsRtMonitorizacaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objsRtMonitorizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objsRtMonitorizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objRtMonitorizacaoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
