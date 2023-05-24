/**
 * GtRtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GtRtDTO  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private idw.idwws.DwTurno dwTurno;

    private idw.idwws.GtDTO gtDTO;

    private idw.idwws.ObjsRtDTO objsRtDTO;

    private int resultadoEvento;

    public GtRtDTO() {
    }

    public GtRtDTO(
           java.util.Calendar dtReferencia,
           idw.idwws.DwTurno dwTurno,
           idw.idwws.GtDTO gtDTO,
           idw.idwws.ObjsRtDTO objsRtDTO,
           int resultadoEvento) {
           this.dtReferencia = dtReferencia;
           this.dwTurno = dwTurno;
           this.gtDTO = gtDTO;
           this.objsRtDTO = objsRtDTO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the dtReferencia value for this GtRtDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this GtRtDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dwTurno value for this GtRtDTO.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this GtRtDTO.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the gtDTO value for this GtRtDTO.
     * 
     * @return gtDTO
     */
    public idw.idwws.GtDTO getGtDTO() {
        return gtDTO;
    }


    /**
     * Sets the gtDTO value for this GtRtDTO.
     * 
     * @param gtDTO
     */
    public void setGtDTO(idw.idwws.GtDTO gtDTO) {
        this.gtDTO = gtDTO;
    }


    /**
     * Gets the objsRtDTO value for this GtRtDTO.
     * 
     * @return objsRtDTO
     */
    public idw.idwws.ObjsRtDTO getObjsRtDTO() {
        return objsRtDTO;
    }


    /**
     * Sets the objsRtDTO value for this GtRtDTO.
     * 
     * @param objsRtDTO
     */
    public void setObjsRtDTO(idw.idwws.ObjsRtDTO objsRtDTO) {
        this.objsRtDTO = objsRtDTO;
    }


    /**
     * Gets the resultadoEvento value for this GtRtDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this GtRtDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GtRtDTO)) return false;
        GtRtDTO other = (GtRtDTO) obj;
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
            ((this.gtDTO==null && other.getGtDTO()==null) || 
             (this.gtDTO!=null &&
              this.gtDTO.equals(other.getGtDTO()))) &&
            ((this.objsRtDTO==null && other.getObjsRtDTO()==null) || 
             (this.objsRtDTO!=null &&
              this.objsRtDTO.equals(other.getObjsRtDTO()))) &&
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
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getGtDTO() != null) {
            _hashCode += getGtDTO().hashCode();
        }
        if (getObjsRtDTO() != null) {
            _hashCode += getObjsRtDTO().hashCode();
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GtRtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "gtRtDTO"));
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
        elemField.setFieldName("gtDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gtDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "gtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objsRtDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objsRtDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objsRtDTO"));
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
