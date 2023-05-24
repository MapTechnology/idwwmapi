/**
 * DatasDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DatasDTO  implements java.io.Serializable {
    private java.util.Calendar dtFAtendimento;

    private java.util.Calendar dtIAtendimento;

    private double producaoAjustada;

    private int qtAtivas;

    private double ultimoTempoNecessario;

    public DatasDTO() {
    }

    public DatasDTO(
           java.util.Calendar dtFAtendimento,
           java.util.Calendar dtIAtendimento,
           double producaoAjustada,
           int qtAtivas,
           double ultimoTempoNecessario) {
           this.dtFAtendimento = dtFAtendimento;
           this.dtIAtendimento = dtIAtendimento;
           this.producaoAjustada = producaoAjustada;
           this.qtAtivas = qtAtivas;
           this.ultimoTempoNecessario = ultimoTempoNecessario;
    }


    /**
     * Gets the dtFAtendimento value for this DatasDTO.
     * 
     * @return dtFAtendimento
     */
    public java.util.Calendar getDtFAtendimento() {
        return dtFAtendimento;
    }


    /**
     * Sets the dtFAtendimento value for this DatasDTO.
     * 
     * @param dtFAtendimento
     */
    public void setDtFAtendimento(java.util.Calendar dtFAtendimento) {
        this.dtFAtendimento = dtFAtendimento;
    }


    /**
     * Gets the dtIAtendimento value for this DatasDTO.
     * 
     * @return dtIAtendimento
     */
    public java.util.Calendar getDtIAtendimento() {
        return dtIAtendimento;
    }


    /**
     * Sets the dtIAtendimento value for this DatasDTO.
     * 
     * @param dtIAtendimento
     */
    public void setDtIAtendimento(java.util.Calendar dtIAtendimento) {
        this.dtIAtendimento = dtIAtendimento;
    }


    /**
     * Gets the producaoAjustada value for this DatasDTO.
     * 
     * @return producaoAjustada
     */
    public double getProducaoAjustada() {
        return producaoAjustada;
    }


    /**
     * Sets the producaoAjustada value for this DatasDTO.
     * 
     * @param producaoAjustada
     */
    public void setProducaoAjustada(double producaoAjustada) {
        this.producaoAjustada = producaoAjustada;
    }


    /**
     * Gets the qtAtivas value for this DatasDTO.
     * 
     * @return qtAtivas
     */
    public int getQtAtivas() {
        return qtAtivas;
    }


    /**
     * Sets the qtAtivas value for this DatasDTO.
     * 
     * @param qtAtivas
     */
    public void setQtAtivas(int qtAtivas) {
        this.qtAtivas = qtAtivas;
    }


    /**
     * Gets the ultimoTempoNecessario value for this DatasDTO.
     * 
     * @return ultimoTempoNecessario
     */
    public double getUltimoTempoNecessario() {
        return ultimoTempoNecessario;
    }


    /**
     * Sets the ultimoTempoNecessario value for this DatasDTO.
     * 
     * @param ultimoTempoNecessario
     */
    public void setUltimoTempoNecessario(double ultimoTempoNecessario) {
        this.ultimoTempoNecessario = ultimoTempoNecessario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatasDTO)) return false;
        DatasDTO other = (DatasDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtFAtendimento==null && other.getDtFAtendimento()==null) || 
             (this.dtFAtendimento!=null &&
              this.dtFAtendimento.equals(other.getDtFAtendimento()))) &&
            ((this.dtIAtendimento==null && other.getDtIAtendimento()==null) || 
             (this.dtIAtendimento!=null &&
              this.dtIAtendimento.equals(other.getDtIAtendimento()))) &&
            this.producaoAjustada == other.getProducaoAjustada() &&
            this.qtAtivas == other.getQtAtivas() &&
            this.ultimoTempoNecessario == other.getUltimoTempoNecessario();
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
        if (getDtFAtendimento() != null) {
            _hashCode += getDtFAtendimento().hashCode();
        }
        if (getDtIAtendimento() != null) {
            _hashCode += getDtIAtendimento().hashCode();
        }
        _hashCode += new Double(getProducaoAjustada()).hashCode();
        _hashCode += getQtAtivas();
        _hashCode += new Double(getUltimoTempoNecessario()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatasDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "datasDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtFAtendimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtFAtendimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtIAtendimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtIAtendimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoAjustada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoAjustada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoTempoNecessario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimoTempoNecessario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
