/**
 * MapaPaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MapaPaDTO  implements java.io.Serializable {
    private int ERRO_DESCONHECIDO;

    private int ERRO_PA_DESCONHECIDO;

    private int ERRO_PRODUTO_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.OmMapapa mapaPa;

    private int resultadoEvento;

    public MapaPaDTO() {
    }

    public MapaPaDTO(
           int ERRO_DESCONHECIDO,
           int ERRO_PA_DESCONHECIDO,
           int ERRO_PRODUTO_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.OmMapapa mapaPa,
           int resultadoEvento) {
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_PA_DESCONHECIDO = ERRO_PA_DESCONHECIDO;
           this.ERRO_PRODUTO_DESCONHECIDO = ERRO_PRODUTO_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.mapaPa = mapaPa;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this MapaPaDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this MapaPaDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PA_DESCONHECIDO value for this MapaPaDTO.
     * 
     * @return ERRO_PA_DESCONHECIDO
     */
    public int getERRO_PA_DESCONHECIDO() {
        return ERRO_PA_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PA_DESCONHECIDO value for this MapaPaDTO.
     * 
     * @param ERRO_PA_DESCONHECIDO
     */
    public void setERRO_PA_DESCONHECIDO(int ERRO_PA_DESCONHECIDO) {
        this.ERRO_PA_DESCONHECIDO = ERRO_PA_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PRODUTO_DESCONHECIDO value for this MapaPaDTO.
     * 
     * @return ERRO_PRODUTO_DESCONHECIDO
     */
    public int getERRO_PRODUTO_DESCONHECIDO() {
        return ERRO_PRODUTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PRODUTO_DESCONHECIDO value for this MapaPaDTO.
     * 
     * @param ERRO_PRODUTO_DESCONHECIDO
     */
    public void setERRO_PRODUTO_DESCONHECIDO(int ERRO_PRODUTO_DESCONHECIDO) {
        this.ERRO_PRODUTO_DESCONHECIDO = ERRO_PRODUTO_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this MapaPaDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this MapaPaDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the mapaPa value for this MapaPaDTO.
     * 
     * @return mapaPa
     */
    public idw.idwws.OmMapapa getMapaPa() {
        return mapaPa;
    }


    /**
     * Sets the mapaPa value for this MapaPaDTO.
     * 
     * @param mapaPa
     */
    public void setMapaPa(idw.idwws.OmMapapa mapaPa) {
        this.mapaPa = mapaPa;
    }


    /**
     * Gets the resultadoEvento value for this MapaPaDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this MapaPaDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MapaPaDTO)) return false;
        MapaPaDTO other = (MapaPaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_PA_DESCONHECIDO == other.getERRO_PA_DESCONHECIDO() &&
            this.ERRO_PRODUTO_DESCONHECIDO == other.getERRO_PRODUTO_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.mapaPa==null && other.getMapaPa()==null) || 
             (this.mapaPa!=null &&
              this.mapaPa.equals(other.getMapaPa()))) &&
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
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_PA_DESCONHECIDO();
        _hashCode += getERRO_PRODUTO_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getMapaPa() != null) {
            _hashCode += getMapaPa().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MapaPaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaPaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PA_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PA_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PRODUTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PRODUTO_DESCONHECIDO"));
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
        elemField.setFieldName("mapaPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapapa"));
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
