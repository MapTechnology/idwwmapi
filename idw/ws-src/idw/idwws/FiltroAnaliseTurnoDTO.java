/**
 * FiltroAnaliseTurnoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroAnaliseTurnoDTO  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private idw.idwws.DwTurno dwTurno;

    private idw.idwws.OmGt omGt;

    public FiltroAnaliseTurnoDTO() {
    }

    public FiltroAnaliseTurnoDTO(
           java.util.Calendar dtReferencia,
           idw.idwws.DwTurno dwTurno,
           idw.idwws.OmGt omGt) {
           this.dtReferencia = dtReferencia;
           this.dwTurno = dwTurno;
           this.omGt = omGt;
    }


    /**
     * Gets the dtReferencia value for this FiltroAnaliseTurnoDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this FiltroAnaliseTurnoDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dwTurno value for this FiltroAnaliseTurnoDTO.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this FiltroAnaliseTurnoDTO.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the omGt value for this FiltroAnaliseTurnoDTO.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this FiltroAnaliseTurnoDTO.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroAnaliseTurnoDTO)) return false;
        FiltroAnaliseTurnoDTO other = (FiltroAnaliseTurnoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt())));
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
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroAnaliseTurnoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroAnaliseTurnoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
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
