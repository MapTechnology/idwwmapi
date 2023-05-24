/**
 * CalendarioSemanalDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CalendarioSemanalDTO  implements java.io.Serializable {
    private idw.idwws.CalendarioAvulsoDTO calendarioAvulso;

    private idw.idwws.DwCalsem calendarioSemanal;

    private int ERRO_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    private boolean virtual;

    public CalendarioSemanalDTO() {
    }

    public CalendarioSemanalDTO(
           idw.idwws.CalendarioAvulsoDTO calendarioAvulso,
           idw.idwws.DwCalsem calendarioSemanal,
           int ERRO_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento,
           boolean virtual) {
           this.calendarioAvulso = calendarioAvulso;
           this.calendarioSemanal = calendarioSemanal;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
           this.virtual = virtual;
    }


    /**
     * Gets the calendarioAvulso value for this CalendarioSemanalDTO.
     * 
     * @return calendarioAvulso
     */
    public idw.idwws.CalendarioAvulsoDTO getCalendarioAvulso() {
        return calendarioAvulso;
    }


    /**
     * Sets the calendarioAvulso value for this CalendarioSemanalDTO.
     * 
     * @param calendarioAvulso
     */
    public void setCalendarioAvulso(idw.idwws.CalendarioAvulsoDTO calendarioAvulso) {
        this.calendarioAvulso = calendarioAvulso;
    }


    /**
     * Gets the calendarioSemanal value for this CalendarioSemanalDTO.
     * 
     * @return calendarioSemanal
     */
    public idw.idwws.DwCalsem getCalendarioSemanal() {
        return calendarioSemanal;
    }


    /**
     * Sets the calendarioSemanal value for this CalendarioSemanalDTO.
     * 
     * @param calendarioSemanal
     */
    public void setCalendarioSemanal(idw.idwws.DwCalsem calendarioSemanal) {
        this.calendarioSemanal = calendarioSemanal;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this CalendarioSemanalDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this CalendarioSemanalDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this CalendarioSemanalDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this CalendarioSemanalDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this CalendarioSemanalDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this CalendarioSemanalDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the virtual value for this CalendarioSemanalDTO.
     * 
     * @return virtual
     */
    public boolean isVirtual() {
        return virtual;
    }


    /**
     * Sets the virtual value for this CalendarioSemanalDTO.
     * 
     * @param virtual
     */
    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CalendarioSemanalDTO)) return false;
        CalendarioSemanalDTO other = (CalendarioSemanalDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calendarioAvulso==null && other.getCalendarioAvulso()==null) || 
             (this.calendarioAvulso!=null &&
              this.calendarioAvulso.equals(other.getCalendarioAvulso()))) &&
            ((this.calendarioSemanal==null && other.getCalendarioSemanal()==null) || 
             (this.calendarioSemanal!=null &&
              this.calendarioSemanal.equals(other.getCalendarioSemanal()))) &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            this.resultadoEvento == other.getResultadoEvento() &&
            this.virtual == other.isVirtual();
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
        if (getCalendarioAvulso() != null) {
            _hashCode += getCalendarioAvulso().hashCode();
        }
        if (getCalendarioSemanal() != null) {
            _hashCode += getCalendarioSemanal().hashCode();
        }
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += getResultadoEvento();
        _hashCode += (isVirtual() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CalendarioSemanalDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioSemanalDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendarioAvulso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendarioAvulso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioAvulsoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendarioSemanal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendarioSemanal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalsem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("virtual");
        elemField.setXmlName(new javax.xml.namespace.QName("", "virtual"));
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
