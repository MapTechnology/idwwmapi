/**
 * RelatorioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class RelatorioDTO  implements java.io.Serializable {
    private java.util.Calendar data;

    private java.math.BigDecimal[] horasPlanej;

    private java.math.BigDecimal[] horasReal;

    private idw.idwws.TurnoDTO[] qtdTurnoReal;

    private idw.idwws.TurnoDTO[] qtdTurnos;

    public RelatorioDTO() {
    }

    public RelatorioDTO(
           java.util.Calendar data,
           java.math.BigDecimal[] horasPlanej,
           java.math.BigDecimal[] horasReal,
           idw.idwws.TurnoDTO[] qtdTurnoReal,
           idw.idwws.TurnoDTO[] qtdTurnos) {
           this.data = data;
           this.horasPlanej = horasPlanej;
           this.horasReal = horasReal;
           this.qtdTurnoReal = qtdTurnoReal;
           this.qtdTurnos = qtdTurnos;
    }


    /**
     * Gets the data value for this RelatorioDTO.
     * 
     * @return data
     */
    public java.util.Calendar getData() {
        return data;
    }


    /**
     * Sets the data value for this RelatorioDTO.
     * 
     * @param data
     */
    public void setData(java.util.Calendar data) {
        this.data = data;
    }


    /**
     * Gets the horasPlanej value for this RelatorioDTO.
     * 
     * @return horasPlanej
     */
    public java.math.BigDecimal[] getHorasPlanej() {
        return horasPlanej;
    }


    /**
     * Sets the horasPlanej value for this RelatorioDTO.
     * 
     * @param horasPlanej
     */
    public void setHorasPlanej(java.math.BigDecimal[] horasPlanej) {
        this.horasPlanej = horasPlanej;
    }

    public java.math.BigDecimal getHorasPlanej(int i) {
        return this.horasPlanej[i];
    }

    public void setHorasPlanej(int i, java.math.BigDecimal _value) {
        this.horasPlanej[i] = _value;
    }


    /**
     * Gets the horasReal value for this RelatorioDTO.
     * 
     * @return horasReal
     */
    public java.math.BigDecimal[] getHorasReal() {
        return horasReal;
    }


    /**
     * Sets the horasReal value for this RelatorioDTO.
     * 
     * @param horasReal
     */
    public void setHorasReal(java.math.BigDecimal[] horasReal) {
        this.horasReal = horasReal;
    }

    public java.math.BigDecimal getHorasReal(int i) {
        return this.horasReal[i];
    }

    public void setHorasReal(int i, java.math.BigDecimal _value) {
        this.horasReal[i] = _value;
    }


    /**
     * Gets the qtdTurnoReal value for this RelatorioDTO.
     * 
     * @return qtdTurnoReal
     */
    public idw.idwws.TurnoDTO[] getQtdTurnoReal() {
        return qtdTurnoReal;
    }


    /**
     * Sets the qtdTurnoReal value for this RelatorioDTO.
     * 
     * @param qtdTurnoReal
     */
    public void setQtdTurnoReal(idw.idwws.TurnoDTO[] qtdTurnoReal) {
        this.qtdTurnoReal = qtdTurnoReal;
    }


    /**
     * Gets the qtdTurnos value for this RelatorioDTO.
     * 
     * @return qtdTurnos
     */
    public idw.idwws.TurnoDTO[] getQtdTurnos() {
        return qtdTurnos;
    }


    /**
     * Sets the qtdTurnos value for this RelatorioDTO.
     * 
     * @param qtdTurnos
     */
    public void setQtdTurnos(idw.idwws.TurnoDTO[] qtdTurnos) {
        this.qtdTurnos = qtdTurnos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatorioDTO)) return false;
        RelatorioDTO other = (RelatorioDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.horasPlanej==null && other.getHorasPlanej()==null) || 
             (this.horasPlanej!=null &&
              java.util.Arrays.equals(this.horasPlanej, other.getHorasPlanej()))) &&
            ((this.horasReal==null && other.getHorasReal()==null) || 
             (this.horasReal!=null &&
              java.util.Arrays.equals(this.horasReal, other.getHorasReal()))) &&
            ((this.qtdTurnoReal==null && other.getQtdTurnoReal()==null) || 
             (this.qtdTurnoReal!=null &&
              java.util.Arrays.equals(this.qtdTurnoReal, other.getQtdTurnoReal()))) &&
            ((this.qtdTurnos==null && other.getQtdTurnos()==null) || 
             (this.qtdTurnos!=null &&
              java.util.Arrays.equals(this.qtdTurnos, other.getQtdTurnos())));
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
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getHorasPlanej() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHorasPlanej());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHorasPlanej(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHorasReal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHorasReal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHorasReal(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQtdTurnoReal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQtdTurnoReal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQtdTurnoReal(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQtdTurnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQtdTurnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQtdTurnos(), i);
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
        new org.apache.axis.description.TypeDesc(RelatorioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "relatorioDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horasPlanej");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horasPlanej"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horasReal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horasReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdTurnoReal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdTurnoReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "turnoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "turnos"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdTurnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdTurnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "turnoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "turnos"));
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
