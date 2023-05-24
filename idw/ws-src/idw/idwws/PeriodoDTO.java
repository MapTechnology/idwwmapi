/**
 * PeriodoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PeriodoDTO  implements java.io.Serializable {
    private java.util.Calendar dtHrFim;

    private java.util.Calendar dtHrInicio;

    private java.lang.Long duracao;

    private idw.idwws.TurnoAtualDTO turnoAtualDTO;

    public PeriodoDTO() {
    }

    public PeriodoDTO(
           java.util.Calendar dtHrFim,
           java.util.Calendar dtHrInicio,
           java.lang.Long duracao,
           idw.idwws.TurnoAtualDTO turnoAtualDTO) {
           this.dtHrFim = dtHrFim;
           this.dtHrInicio = dtHrInicio;
           this.duracao = duracao;
           this.turnoAtualDTO = turnoAtualDTO;
    }


    /**
     * Gets the dtHrFim value for this PeriodoDTO.
     * 
     * @return dtHrFim
     */
    public java.util.Calendar getDtHrFim() {
        return dtHrFim;
    }


    /**
     * Sets the dtHrFim value for this PeriodoDTO.
     * 
     * @param dtHrFim
     */
    public void setDtHrFim(java.util.Calendar dtHrFim) {
        this.dtHrFim = dtHrFim;
    }


    /**
     * Gets the dtHrInicio value for this PeriodoDTO.
     * 
     * @return dtHrInicio
     */
    public java.util.Calendar getDtHrInicio() {
        return dtHrInicio;
    }


    /**
     * Sets the dtHrInicio value for this PeriodoDTO.
     * 
     * @param dtHrInicio
     */
    public void setDtHrInicio(java.util.Calendar dtHrInicio) {
        this.dtHrInicio = dtHrInicio;
    }


    /**
     * Gets the duracao value for this PeriodoDTO.
     * 
     * @return duracao
     */
    public java.lang.Long getDuracao() {
        return duracao;
    }


    /**
     * Sets the duracao value for this PeriodoDTO.
     * 
     * @param duracao
     */
    public void setDuracao(java.lang.Long duracao) {
        this.duracao = duracao;
    }


    /**
     * Gets the turnoAtualDTO value for this PeriodoDTO.
     * 
     * @return turnoAtualDTO
     */
    public idw.idwws.TurnoAtualDTO getTurnoAtualDTO() {
        return turnoAtualDTO;
    }


    /**
     * Sets the turnoAtualDTO value for this PeriodoDTO.
     * 
     * @param turnoAtualDTO
     */
    public void setTurnoAtualDTO(idw.idwws.TurnoAtualDTO turnoAtualDTO) {
        this.turnoAtualDTO = turnoAtualDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeriodoDTO)) return false;
        PeriodoDTO other = (PeriodoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtHrFim==null && other.getDtHrFim()==null) || 
             (this.dtHrFim!=null &&
              this.dtHrFim.equals(other.getDtHrFim()))) &&
            ((this.dtHrInicio==null && other.getDtHrInicio()==null) || 
             (this.dtHrInicio!=null &&
              this.dtHrInicio.equals(other.getDtHrInicio()))) &&
            ((this.duracao==null && other.getDuracao()==null) || 
             (this.duracao!=null &&
              this.duracao.equals(other.getDuracao()))) &&
            ((this.turnoAtualDTO==null && other.getTurnoAtualDTO()==null) || 
             (this.turnoAtualDTO!=null &&
              this.turnoAtualDTO.equals(other.getTurnoAtualDTO())));
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
        if (getDtHrFim() != null) {
            _hashCode += getDtHrFim().hashCode();
        }
        if (getDtHrInicio() != null) {
            _hashCode += getDtHrInicio().hashCode();
        }
        if (getDuracao() != null) {
            _hashCode += getDuracao().hashCode();
        }
        if (getTurnoAtualDTO() != null) {
            _hashCode += getTurnoAtualDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PeriodoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "periodoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrFim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turnoAtualDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "turnoAtualDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "turnoAtualDTO"));
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
