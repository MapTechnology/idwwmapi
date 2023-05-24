/**
 * PaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PaDTO  implements java.io.Serializable {
    private int ERRO_CDPA_INVALIDO;

    private int ERRO_DEPARA_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_DESVIO_INVALIDO;

    private int ERRO_DSPA_INVALIDO;

    private int ERRO_ORDEM_INVALIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.OmPa pa;

    private int resultadoEvento;

    public PaDTO() {
    }

    public PaDTO(
           int ERRO_CDPA_INVALIDO,
           int ERRO_DEPARA_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_DESVIO_INVALIDO,
           int ERRO_DSPA_INVALIDO,
           int ERRO_ORDEM_INVALIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.OmPa pa,
           int resultadoEvento) {
           this.ERRO_CDPA_INVALIDO = ERRO_CDPA_INVALIDO;
           this.ERRO_DEPARA_INVALIDO = ERRO_DEPARA_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_DESVIO_INVALIDO = ERRO_DESVIO_INVALIDO;
           this.ERRO_DSPA_INVALIDO = ERRO_DSPA_INVALIDO;
           this.ERRO_ORDEM_INVALIDO = ERRO_ORDEM_INVALIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.pa = pa;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_CDPA_INVALIDO value for this PaDTO.
     * 
     * @return ERRO_CDPA_INVALIDO
     */
    public int getERRO_CDPA_INVALIDO() {
        return ERRO_CDPA_INVALIDO;
    }


    /**
     * Sets the ERRO_CDPA_INVALIDO value for this PaDTO.
     * 
     * @param ERRO_CDPA_INVALIDO
     */
    public void setERRO_CDPA_INVALIDO(int ERRO_CDPA_INVALIDO) {
        this.ERRO_CDPA_INVALIDO = ERRO_CDPA_INVALIDO;
    }


    /**
     * Gets the ERRO_DEPARA_INVALIDO value for this PaDTO.
     * 
     * @return ERRO_DEPARA_INVALIDO
     */
    public int getERRO_DEPARA_INVALIDO() {
        return ERRO_DEPARA_INVALIDO;
    }


    /**
     * Sets the ERRO_DEPARA_INVALIDO value for this PaDTO.
     * 
     * @param ERRO_DEPARA_INVALIDO
     */
    public void setERRO_DEPARA_INVALIDO(int ERRO_DEPARA_INVALIDO) {
        this.ERRO_DEPARA_INVALIDO = ERRO_DEPARA_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this PaDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this PaDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DESVIO_INVALIDO value for this PaDTO.
     * 
     * @return ERRO_DESVIO_INVALIDO
     */
    public int getERRO_DESVIO_INVALIDO() {
        return ERRO_DESVIO_INVALIDO;
    }


    /**
     * Sets the ERRO_DESVIO_INVALIDO value for this PaDTO.
     * 
     * @param ERRO_DESVIO_INVALIDO
     */
    public void setERRO_DESVIO_INVALIDO(int ERRO_DESVIO_INVALIDO) {
        this.ERRO_DESVIO_INVALIDO = ERRO_DESVIO_INVALIDO;
    }


    /**
     * Gets the ERRO_DSPA_INVALIDO value for this PaDTO.
     * 
     * @return ERRO_DSPA_INVALIDO
     */
    public int getERRO_DSPA_INVALIDO() {
        return ERRO_DSPA_INVALIDO;
    }


    /**
     * Sets the ERRO_DSPA_INVALIDO value for this PaDTO.
     * 
     * @param ERRO_DSPA_INVALIDO
     */
    public void setERRO_DSPA_INVALIDO(int ERRO_DSPA_INVALIDO) {
        this.ERRO_DSPA_INVALIDO = ERRO_DSPA_INVALIDO;
    }


    /**
     * Gets the ERRO_ORDEM_INVALIDO value for this PaDTO.
     * 
     * @return ERRO_ORDEM_INVALIDO
     */
    public int getERRO_ORDEM_INVALIDO() {
        return ERRO_ORDEM_INVALIDO;
    }


    /**
     * Sets the ERRO_ORDEM_INVALIDO value for this PaDTO.
     * 
     * @param ERRO_ORDEM_INVALIDO
     */
    public void setERRO_ORDEM_INVALIDO(int ERRO_ORDEM_INVALIDO) {
        this.ERRO_ORDEM_INVALIDO = ERRO_ORDEM_INVALIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this PaDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this PaDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the pa value for this PaDTO.
     * 
     * @return pa
     */
    public idw.idwws.OmPa getPa() {
        return pa;
    }


    /**
     * Sets the pa value for this PaDTO.
     * 
     * @param pa
     */
    public void setPa(idw.idwws.OmPa pa) {
        this.pa = pa;
    }


    /**
     * Gets the resultadoEvento value for this PaDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this PaDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaDTO)) return false;
        PaDTO other = (PaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_CDPA_INVALIDO == other.getERRO_CDPA_INVALIDO() &&
            this.ERRO_DEPARA_INVALIDO == other.getERRO_DEPARA_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_DESVIO_INVALIDO == other.getERRO_DESVIO_INVALIDO() &&
            this.ERRO_DSPA_INVALIDO == other.getERRO_DSPA_INVALIDO() &&
            this.ERRO_ORDEM_INVALIDO == other.getERRO_ORDEM_INVALIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.pa==null && other.getPa()==null) || 
             (this.pa!=null &&
              this.pa.equals(other.getPa()))) &&
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
        _hashCode += getERRO_CDPA_INVALIDO();
        _hashCode += getERRO_DEPARA_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_DESVIO_INVALIDO();
        _hashCode += getERRO_DSPA_INVALIDO();
        _hashCode += getERRO_ORDEM_INVALIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getPa() != null) {
            _hashCode += getPa().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDPA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDPA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DEPARA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DEPARA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESVIO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESVIO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DSPA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DSPA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_ORDEM_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_ORDEM_INVALIDO"));
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
        elemField.setFieldName("pa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
