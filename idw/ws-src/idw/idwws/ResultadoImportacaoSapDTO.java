/**
 * ResultadoImportacaoSapDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ResultadoImportacaoSapDTO  implements java.io.Serializable {
    private int resultadoEvento;

    private idw.idwws.SapConhecimentoDTO[] sapconhecimentosdto;

    private idw.idwws.SapEstoqueDTO[] sapestoquesdto;

    private idw.idwws.TmgConhecimentoDTO[] tmgconhecimentosdto;

    public ResultadoImportacaoSapDTO() {
    }

    public ResultadoImportacaoSapDTO(
           int resultadoEvento,
           idw.idwws.SapConhecimentoDTO[] sapconhecimentosdto,
           idw.idwws.SapEstoqueDTO[] sapestoquesdto,
           idw.idwws.TmgConhecimentoDTO[] tmgconhecimentosdto) {
           this.resultadoEvento = resultadoEvento;
           this.sapconhecimentosdto = sapconhecimentosdto;
           this.sapestoquesdto = sapestoquesdto;
           this.tmgconhecimentosdto = tmgconhecimentosdto;
    }


    /**
     * Gets the resultadoEvento value for this ResultadoImportacaoSapDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this ResultadoImportacaoSapDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the sapconhecimentosdto value for this ResultadoImportacaoSapDTO.
     * 
     * @return sapconhecimentosdto
     */
    public idw.idwws.SapConhecimentoDTO[] getSapconhecimentosdto() {
        return sapconhecimentosdto;
    }


    /**
     * Sets the sapconhecimentosdto value for this ResultadoImportacaoSapDTO.
     * 
     * @param sapconhecimentosdto
     */
    public void setSapconhecimentosdto(idw.idwws.SapConhecimentoDTO[] sapconhecimentosdto) {
        this.sapconhecimentosdto = sapconhecimentosdto;
    }


    /**
     * Gets the sapestoquesdto value for this ResultadoImportacaoSapDTO.
     * 
     * @return sapestoquesdto
     */
    public idw.idwws.SapEstoqueDTO[] getSapestoquesdto() {
        return sapestoquesdto;
    }


    /**
     * Sets the sapestoquesdto value for this ResultadoImportacaoSapDTO.
     * 
     * @param sapestoquesdto
     */
    public void setSapestoquesdto(idw.idwws.SapEstoqueDTO[] sapestoquesdto) {
        this.sapestoquesdto = sapestoquesdto;
    }


    /**
     * Gets the tmgconhecimentosdto value for this ResultadoImportacaoSapDTO.
     * 
     * @return tmgconhecimentosdto
     */
    public idw.idwws.TmgConhecimentoDTO[] getTmgconhecimentosdto() {
        return tmgconhecimentosdto;
    }


    /**
     * Sets the tmgconhecimentosdto value for this ResultadoImportacaoSapDTO.
     * 
     * @param tmgconhecimentosdto
     */
    public void setTmgconhecimentosdto(idw.idwws.TmgConhecimentoDTO[] tmgconhecimentosdto) {
        this.tmgconhecimentosdto = tmgconhecimentosdto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoImportacaoSapDTO)) return false;
        ResultadoImportacaoSapDTO other = (ResultadoImportacaoSapDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.sapconhecimentosdto==null && other.getSapconhecimentosdto()==null) || 
             (this.sapconhecimentosdto!=null &&
              java.util.Arrays.equals(this.sapconhecimentosdto, other.getSapconhecimentosdto()))) &&
            ((this.sapestoquesdto==null && other.getSapestoquesdto()==null) || 
             (this.sapestoquesdto!=null &&
              java.util.Arrays.equals(this.sapestoquesdto, other.getSapestoquesdto()))) &&
            ((this.tmgconhecimentosdto==null && other.getTmgconhecimentosdto()==null) || 
             (this.tmgconhecimentosdto!=null &&
              java.util.Arrays.equals(this.tmgconhecimentosdto, other.getTmgconhecimentosdto())));
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
        if (getSapconhecimentosdto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSapconhecimentosdto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSapconhecimentosdto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSapestoquesdto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSapestoquesdto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSapestoquesdto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTmgconhecimentosdto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTmgconhecimentosdto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTmgconhecimentosdto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoImportacaoSapDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoImportacaoSapDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sapconhecimentosdto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sapconhecimentosdto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "sapConhecimentoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "sapconhecimentos"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sapestoquesdto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sapestoquesdto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "sapEstoqueDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "sapestoques"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmgconhecimentosdto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmgconhecimentosdto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "tmgConhecimentoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "tmgconhecimentos"));
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
