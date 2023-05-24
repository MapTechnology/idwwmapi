/**
 * RefugoTempoInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class RefugoTempoInjetDTO  implements java.io.Serializable {
    private java.math.BigDecimal producaoRefugada;

    private java.math.BigDecimal producaoRefugadaCusto;

    private java.math.BigDecimal producaoRefugadaKg;

    private java.math.BigDecimal qtCiclosRefugados;

    private java.math.BigDecimal tempoRefugo;

    public RefugoTempoInjetDTO() {
    }

    public RefugoTempoInjetDTO(
           java.math.BigDecimal producaoRefugada,
           java.math.BigDecimal producaoRefugadaCusto,
           java.math.BigDecimal producaoRefugadaKg,
           java.math.BigDecimal qtCiclosRefugados,
           java.math.BigDecimal tempoRefugo) {
           this.producaoRefugada = producaoRefugada;
           this.producaoRefugadaCusto = producaoRefugadaCusto;
           this.producaoRefugadaKg = producaoRefugadaKg;
           this.qtCiclosRefugados = qtCiclosRefugados;
           this.tempoRefugo = tempoRefugo;
    }


    /**
     * Gets the producaoRefugada value for this RefugoTempoInjetDTO.
     * 
     * @return producaoRefugada
     */
    public java.math.BigDecimal getProducaoRefugada() {
        return producaoRefugada;
    }


    /**
     * Sets the producaoRefugada value for this RefugoTempoInjetDTO.
     * 
     * @param producaoRefugada
     */
    public void setProducaoRefugada(java.math.BigDecimal producaoRefugada) {
        this.producaoRefugada = producaoRefugada;
    }


    /**
     * Gets the producaoRefugadaCusto value for this RefugoTempoInjetDTO.
     * 
     * @return producaoRefugadaCusto
     */
    public java.math.BigDecimal getProducaoRefugadaCusto() {
        return producaoRefugadaCusto;
    }


    /**
     * Sets the producaoRefugadaCusto value for this RefugoTempoInjetDTO.
     * 
     * @param producaoRefugadaCusto
     */
    public void setProducaoRefugadaCusto(java.math.BigDecimal producaoRefugadaCusto) {
        this.producaoRefugadaCusto = producaoRefugadaCusto;
    }


    /**
     * Gets the producaoRefugadaKg value for this RefugoTempoInjetDTO.
     * 
     * @return producaoRefugadaKg
     */
    public java.math.BigDecimal getProducaoRefugadaKg() {
        return producaoRefugadaKg;
    }


    /**
     * Sets the producaoRefugadaKg value for this RefugoTempoInjetDTO.
     * 
     * @param producaoRefugadaKg
     */
    public void setProducaoRefugadaKg(java.math.BigDecimal producaoRefugadaKg) {
        this.producaoRefugadaKg = producaoRefugadaKg;
    }


    /**
     * Gets the qtCiclosRefugados value for this RefugoTempoInjetDTO.
     * 
     * @return qtCiclosRefugados
     */
    public java.math.BigDecimal getQtCiclosRefugados() {
        return qtCiclosRefugados;
    }


    /**
     * Sets the qtCiclosRefugados value for this RefugoTempoInjetDTO.
     * 
     * @param qtCiclosRefugados
     */
    public void setQtCiclosRefugados(java.math.BigDecimal qtCiclosRefugados) {
        this.qtCiclosRefugados = qtCiclosRefugados;
    }


    /**
     * Gets the tempoRefugo value for this RefugoTempoInjetDTO.
     * 
     * @return tempoRefugo
     */
    public java.math.BigDecimal getTempoRefugo() {
        return tempoRefugo;
    }


    /**
     * Sets the tempoRefugo value for this RefugoTempoInjetDTO.
     * 
     * @param tempoRefugo
     */
    public void setTempoRefugo(java.math.BigDecimal tempoRefugo) {
        this.tempoRefugo = tempoRefugo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RefugoTempoInjetDTO)) return false;
        RefugoTempoInjetDTO other = (RefugoTempoInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.producaoRefugada==null && other.getProducaoRefugada()==null) || 
             (this.producaoRefugada!=null &&
              this.producaoRefugada.equals(other.getProducaoRefugada()))) &&
            ((this.producaoRefugadaCusto==null && other.getProducaoRefugadaCusto()==null) || 
             (this.producaoRefugadaCusto!=null &&
              this.producaoRefugadaCusto.equals(other.getProducaoRefugadaCusto()))) &&
            ((this.producaoRefugadaKg==null && other.getProducaoRefugadaKg()==null) || 
             (this.producaoRefugadaKg!=null &&
              this.producaoRefugadaKg.equals(other.getProducaoRefugadaKg()))) &&
            ((this.qtCiclosRefugados==null && other.getQtCiclosRefugados()==null) || 
             (this.qtCiclosRefugados!=null &&
              this.qtCiclosRefugados.equals(other.getQtCiclosRefugados()))) &&
            ((this.tempoRefugo==null && other.getTempoRefugo()==null) || 
             (this.tempoRefugo!=null &&
              this.tempoRefugo.equals(other.getTempoRefugo())));
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
        if (getProducaoRefugada() != null) {
            _hashCode += getProducaoRefugada().hashCode();
        }
        if (getProducaoRefugadaCusto() != null) {
            _hashCode += getProducaoRefugadaCusto().hashCode();
        }
        if (getProducaoRefugadaKg() != null) {
            _hashCode += getProducaoRefugadaKg().hashCode();
        }
        if (getQtCiclosRefugados() != null) {
            _hashCode += getQtCiclosRefugados().hashCode();
        }
        if (getTempoRefugo() != null) {
            _hashCode += getTempoRefugo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RefugoTempoInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "refugoTempoInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoRefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoRefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoRefugadaCusto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoRefugadaCusto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoRefugadaKg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoRefugadaKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCiclosRefugados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCiclosRefugados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
