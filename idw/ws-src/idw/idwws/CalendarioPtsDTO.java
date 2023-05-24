/**
 * CalendarioPtsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CalendarioPtsDTO  implements java.io.Serializable {
    private int ERRO_PT_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.DwCalpt[] pts;

    private int resultadoEvento;

    public CalendarioPtsDTO() {
    }

    public CalendarioPtsDTO(
           int ERRO_PT_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.DwCalpt[] pts,
           int resultadoEvento) {
           this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.pts = pts;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the ERRO_PT_DESCONHECIDO value for this CalendarioPtsDTO.
     * 
     * @return ERRO_PT_DESCONHECIDO
     */
    public int getERRO_PT_DESCONHECIDO() {
        return ERRO_PT_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PT_DESCONHECIDO value for this CalendarioPtsDTO.
     * 
     * @param ERRO_PT_DESCONHECIDO
     */
    public void setERRO_PT_DESCONHECIDO(int ERRO_PT_DESCONHECIDO) {
        this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this CalendarioPtsDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this CalendarioPtsDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the pts value for this CalendarioPtsDTO.
     * 
     * @return pts
     */
    public idw.idwws.DwCalpt[] getPts() {
        return pts;
    }


    /**
     * Sets the pts value for this CalendarioPtsDTO.
     * 
     * @param pts
     */
    public void setPts(idw.idwws.DwCalpt[] pts) {
        this.pts = pts;
    }

    public idw.idwws.DwCalpt getPts(int i) {
        return this.pts[i];
    }

    public void setPts(int i, idw.idwws.DwCalpt _value) {
        this.pts[i] = _value;
    }


    /**
     * Gets the resultadoEvento value for this CalendarioPtsDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this CalendarioPtsDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CalendarioPtsDTO)) return false;
        CalendarioPtsDTO other = (CalendarioPtsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_PT_DESCONHECIDO == other.getERRO_PT_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.pts==null && other.getPts()==null) || 
             (this.pts!=null &&
              java.util.Arrays.equals(this.pts, other.getPts()))) &&
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
        _hashCode += getERRO_PT_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getPts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPts(), i);
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
        new org.apache.axis.description.TypeDesc(CalendarioPtsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioPtsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PT_DESCONHECIDO"));
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
        elemField.setFieldName("pts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalpt"));
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
