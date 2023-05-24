/**
 * ResultadoSubetapaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ResultadoSubetapaDTO  implements java.io.Serializable {
    private java.util.Calendar dthrFSubetapaPosFalha;

    private java.util.Calendar dthrFSubetapaPreFalha;

    private java.util.Calendar dthrISubetapaPosFalha;

    private java.util.Calendar dthrISubetapaPreFalha;

    private long idSubetapa;

    private idw.idwws.ResultadoMedicaoDTO[] medicoes;

    private int ordemSubetapa;

    private boolean passou;

    public ResultadoSubetapaDTO() {
    }

    public ResultadoSubetapaDTO(
           java.util.Calendar dthrFSubetapaPosFalha,
           java.util.Calendar dthrFSubetapaPreFalha,
           java.util.Calendar dthrISubetapaPosFalha,
           java.util.Calendar dthrISubetapaPreFalha,
           long idSubetapa,
           idw.idwws.ResultadoMedicaoDTO[] medicoes,
           int ordemSubetapa,
           boolean passou) {
           this.dthrFSubetapaPosFalha = dthrFSubetapaPosFalha;
           this.dthrFSubetapaPreFalha = dthrFSubetapaPreFalha;
           this.dthrISubetapaPosFalha = dthrISubetapaPosFalha;
           this.dthrISubetapaPreFalha = dthrISubetapaPreFalha;
           this.idSubetapa = idSubetapa;
           this.medicoes = medicoes;
           this.ordemSubetapa = ordemSubetapa;
           this.passou = passou;
    }


    /**
     * Gets the dthrFSubetapaPosFalha value for this ResultadoSubetapaDTO.
     * 
     * @return dthrFSubetapaPosFalha
     */
    public java.util.Calendar getDthrFSubetapaPosFalha() {
        return dthrFSubetapaPosFalha;
    }


    /**
     * Sets the dthrFSubetapaPosFalha value for this ResultadoSubetapaDTO.
     * 
     * @param dthrFSubetapaPosFalha
     */
    public void setDthrFSubetapaPosFalha(java.util.Calendar dthrFSubetapaPosFalha) {
        this.dthrFSubetapaPosFalha = dthrFSubetapaPosFalha;
    }


    /**
     * Gets the dthrFSubetapaPreFalha value for this ResultadoSubetapaDTO.
     * 
     * @return dthrFSubetapaPreFalha
     */
    public java.util.Calendar getDthrFSubetapaPreFalha() {
        return dthrFSubetapaPreFalha;
    }


    /**
     * Sets the dthrFSubetapaPreFalha value for this ResultadoSubetapaDTO.
     * 
     * @param dthrFSubetapaPreFalha
     */
    public void setDthrFSubetapaPreFalha(java.util.Calendar dthrFSubetapaPreFalha) {
        this.dthrFSubetapaPreFalha = dthrFSubetapaPreFalha;
    }


    /**
     * Gets the dthrISubetapaPosFalha value for this ResultadoSubetapaDTO.
     * 
     * @return dthrISubetapaPosFalha
     */
    public java.util.Calendar getDthrISubetapaPosFalha() {
        return dthrISubetapaPosFalha;
    }


    /**
     * Sets the dthrISubetapaPosFalha value for this ResultadoSubetapaDTO.
     * 
     * @param dthrISubetapaPosFalha
     */
    public void setDthrISubetapaPosFalha(java.util.Calendar dthrISubetapaPosFalha) {
        this.dthrISubetapaPosFalha = dthrISubetapaPosFalha;
    }


    /**
     * Gets the dthrISubetapaPreFalha value for this ResultadoSubetapaDTO.
     * 
     * @return dthrISubetapaPreFalha
     */
    public java.util.Calendar getDthrISubetapaPreFalha() {
        return dthrISubetapaPreFalha;
    }


    /**
     * Sets the dthrISubetapaPreFalha value for this ResultadoSubetapaDTO.
     * 
     * @param dthrISubetapaPreFalha
     */
    public void setDthrISubetapaPreFalha(java.util.Calendar dthrISubetapaPreFalha) {
        this.dthrISubetapaPreFalha = dthrISubetapaPreFalha;
    }


    /**
     * Gets the idSubetapa value for this ResultadoSubetapaDTO.
     * 
     * @return idSubetapa
     */
    public long getIdSubetapa() {
        return idSubetapa;
    }


    /**
     * Sets the idSubetapa value for this ResultadoSubetapaDTO.
     * 
     * @param idSubetapa
     */
    public void setIdSubetapa(long idSubetapa) {
        this.idSubetapa = idSubetapa;
    }


    /**
     * Gets the medicoes value for this ResultadoSubetapaDTO.
     * 
     * @return medicoes
     */
    public idw.idwws.ResultadoMedicaoDTO[] getMedicoes() {
        return medicoes;
    }


    /**
     * Sets the medicoes value for this ResultadoSubetapaDTO.
     * 
     * @param medicoes
     */
    public void setMedicoes(idw.idwws.ResultadoMedicaoDTO[] medicoes) {
        this.medicoes = medicoes;
    }

    public idw.idwws.ResultadoMedicaoDTO getMedicoes(int i) {
        return this.medicoes[i];
    }

    public void setMedicoes(int i, idw.idwws.ResultadoMedicaoDTO _value) {
        this.medicoes[i] = _value;
    }


    /**
     * Gets the ordemSubetapa value for this ResultadoSubetapaDTO.
     * 
     * @return ordemSubetapa
     */
    public int getOrdemSubetapa() {
        return ordemSubetapa;
    }


    /**
     * Sets the ordemSubetapa value for this ResultadoSubetapaDTO.
     * 
     * @param ordemSubetapa
     */
    public void setOrdemSubetapa(int ordemSubetapa) {
        this.ordemSubetapa = ordemSubetapa;
    }


    /**
     * Gets the passou value for this ResultadoSubetapaDTO.
     * 
     * @return passou
     */
    public boolean isPassou() {
        return passou;
    }


    /**
     * Sets the passou value for this ResultadoSubetapaDTO.
     * 
     * @param passou
     */
    public void setPassou(boolean passou) {
        this.passou = passou;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoSubetapaDTO)) return false;
        ResultadoSubetapaDTO other = (ResultadoSubetapaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrFSubetapaPosFalha==null && other.getDthrFSubetapaPosFalha()==null) || 
             (this.dthrFSubetapaPosFalha!=null &&
              this.dthrFSubetapaPosFalha.equals(other.getDthrFSubetapaPosFalha()))) &&
            ((this.dthrFSubetapaPreFalha==null && other.getDthrFSubetapaPreFalha()==null) || 
             (this.dthrFSubetapaPreFalha!=null &&
              this.dthrFSubetapaPreFalha.equals(other.getDthrFSubetapaPreFalha()))) &&
            ((this.dthrISubetapaPosFalha==null && other.getDthrISubetapaPosFalha()==null) || 
             (this.dthrISubetapaPosFalha!=null &&
              this.dthrISubetapaPosFalha.equals(other.getDthrISubetapaPosFalha()))) &&
            ((this.dthrISubetapaPreFalha==null && other.getDthrISubetapaPreFalha()==null) || 
             (this.dthrISubetapaPreFalha!=null &&
              this.dthrISubetapaPreFalha.equals(other.getDthrISubetapaPreFalha()))) &&
            this.idSubetapa == other.getIdSubetapa() &&
            ((this.medicoes==null && other.getMedicoes()==null) || 
             (this.medicoes!=null &&
              java.util.Arrays.equals(this.medicoes, other.getMedicoes()))) &&
            this.ordemSubetapa == other.getOrdemSubetapa() &&
            this.passou == other.isPassou();
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
        if (getDthrFSubetapaPosFalha() != null) {
            _hashCode += getDthrFSubetapaPosFalha().hashCode();
        }
        if (getDthrFSubetapaPreFalha() != null) {
            _hashCode += getDthrFSubetapaPreFalha().hashCode();
        }
        if (getDthrISubetapaPosFalha() != null) {
            _hashCode += getDthrISubetapaPosFalha().hashCode();
        }
        if (getDthrISubetapaPreFalha() != null) {
            _hashCode += getDthrISubetapaPreFalha().hashCode();
        }
        _hashCode += new Long(getIdSubetapa()).hashCode();
        if (getMedicoes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMedicoes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMedicoes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getOrdemSubetapa();
        _hashCode += (isPassou() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoSubetapaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoSubetapaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFSubetapaPosFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFSubetapaPosFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFSubetapaPreFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFSubetapaPreFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrISubetapaPosFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrISubetapaPosFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrISubetapaPreFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrISubetapaPreFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idSubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medicoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medicoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoMedicaoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemSubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemSubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passou");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passou"));
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
