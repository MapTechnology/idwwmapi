/**
 * ResultadoTesteDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ResultadoTesteDTO  implements java.io.Serializable {
    private idw.idwws.ResultadoEtapaDTO[] etapas;

    private long idReceita;

    private boolean receitaFinalizada;

    public ResultadoTesteDTO() {
    }

    public ResultadoTesteDTO(
           idw.idwws.ResultadoEtapaDTO[] etapas,
           long idReceita,
           boolean receitaFinalizada) {
           this.etapas = etapas;
           this.idReceita = idReceita;
           this.receitaFinalizada = receitaFinalizada;
    }


    /**
     * Gets the etapas value for this ResultadoTesteDTO.
     * 
     * @return etapas
     */
    public idw.idwws.ResultadoEtapaDTO[] getEtapas() {
        return etapas;
    }


    /**
     * Sets the etapas value for this ResultadoTesteDTO.
     * 
     * @param etapas
     */
    public void setEtapas(idw.idwws.ResultadoEtapaDTO[] etapas) {
        this.etapas = etapas;
    }

    public idw.idwws.ResultadoEtapaDTO getEtapas(int i) {
        return this.etapas[i];
    }

    public void setEtapas(int i, idw.idwws.ResultadoEtapaDTO _value) {
        this.etapas[i] = _value;
    }


    /**
     * Gets the idReceita value for this ResultadoTesteDTO.
     * 
     * @return idReceita
     */
    public long getIdReceita() {
        return idReceita;
    }


    /**
     * Sets the idReceita value for this ResultadoTesteDTO.
     * 
     * @param idReceita
     */
    public void setIdReceita(long idReceita) {
        this.idReceita = idReceita;
    }


    /**
     * Gets the receitaFinalizada value for this ResultadoTesteDTO.
     * 
     * @return receitaFinalizada
     */
    public boolean isReceitaFinalizada() {
        return receitaFinalizada;
    }


    /**
     * Sets the receitaFinalizada value for this ResultadoTesteDTO.
     * 
     * @param receitaFinalizada
     */
    public void setReceitaFinalizada(boolean receitaFinalizada) {
        this.receitaFinalizada = receitaFinalizada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoTesteDTO)) return false;
        ResultadoTesteDTO other = (ResultadoTesteDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.etapas==null && other.getEtapas()==null) || 
             (this.etapas!=null &&
              java.util.Arrays.equals(this.etapas, other.getEtapas()))) &&
            this.idReceita == other.getIdReceita() &&
            this.receitaFinalizada == other.isReceitaFinalizada();
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
        if (getEtapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEtapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEtapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdReceita()).hashCode();
        _hashCode += (isReceitaFinalizada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoTesteDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoTesteDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "etapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoEtapaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idReceita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idReceita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receitaFinalizada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receitaFinalizada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
