/**
 * GtRtMonitorizacaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GtRtMonitorizacaoDTO  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private java.util.Calendar dthrRefresh;

    private int filtroLabel;

    private int filtroLabel2;

    private idw.idwws.GtDTO gtDTO;

    private idw.idwws.ObjsRtMonitorizacaoDTO objsRtMonitorizacaoDTO;

    private int resultadoEvento;

    private int tempoMiliAtualizacaoGt;

    private idw.idwws.TurnoAtualDTO turnoReferencia;

    public GtRtMonitorizacaoDTO() {
    }

    public GtRtMonitorizacaoDTO(
           java.util.Calendar dtReferencia,
           java.util.Calendar dthrRefresh,
           int filtroLabel,
           int filtroLabel2,
           idw.idwws.GtDTO gtDTO,
           idw.idwws.ObjsRtMonitorizacaoDTO objsRtMonitorizacaoDTO,
           int resultadoEvento,
           int tempoMiliAtualizacaoGt,
           idw.idwws.TurnoAtualDTO turnoReferencia) {
           this.dtReferencia = dtReferencia;
           this.dthrRefresh = dthrRefresh;
           this.filtroLabel = filtroLabel;
           this.filtroLabel2 = filtroLabel2;
           this.gtDTO = gtDTO;
           this.objsRtMonitorizacaoDTO = objsRtMonitorizacaoDTO;
           this.resultadoEvento = resultadoEvento;
           this.tempoMiliAtualizacaoGt = tempoMiliAtualizacaoGt;
           this.turnoReferencia = turnoReferencia;
    }


    /**
     * Gets the dtReferencia value for this GtRtMonitorizacaoDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this GtRtMonitorizacaoDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dthrRefresh value for this GtRtMonitorizacaoDTO.
     * 
     * @return dthrRefresh
     */
    public java.util.Calendar getDthrRefresh() {
        return dthrRefresh;
    }


    /**
     * Sets the dthrRefresh value for this GtRtMonitorizacaoDTO.
     * 
     * @param dthrRefresh
     */
    public void setDthrRefresh(java.util.Calendar dthrRefresh) {
        this.dthrRefresh = dthrRefresh;
    }


    /**
     * Gets the filtroLabel value for this GtRtMonitorizacaoDTO.
     * 
     * @return filtroLabel
     */
    public int getFiltroLabel() {
        return filtroLabel;
    }


    /**
     * Sets the filtroLabel value for this GtRtMonitorizacaoDTO.
     * 
     * @param filtroLabel
     */
    public void setFiltroLabel(int filtroLabel) {
        this.filtroLabel = filtroLabel;
    }


    /**
     * Gets the filtroLabel2 value for this GtRtMonitorizacaoDTO.
     * 
     * @return filtroLabel2
     */
    public int getFiltroLabel2() {
        return filtroLabel2;
    }


    /**
     * Sets the filtroLabel2 value for this GtRtMonitorizacaoDTO.
     * 
     * @param filtroLabel2
     */
    public void setFiltroLabel2(int filtroLabel2) {
        this.filtroLabel2 = filtroLabel2;
    }


    /**
     * Gets the gtDTO value for this GtRtMonitorizacaoDTO.
     * 
     * @return gtDTO
     */
    public idw.idwws.GtDTO getGtDTO() {
        return gtDTO;
    }


    /**
     * Sets the gtDTO value for this GtRtMonitorizacaoDTO.
     * 
     * @param gtDTO
     */
    public void setGtDTO(idw.idwws.GtDTO gtDTO) {
        this.gtDTO = gtDTO;
    }


    /**
     * Gets the objsRtMonitorizacaoDTO value for this GtRtMonitorizacaoDTO.
     * 
     * @return objsRtMonitorizacaoDTO
     */
    public idw.idwws.ObjsRtMonitorizacaoDTO getObjsRtMonitorizacaoDTO() {
        return objsRtMonitorizacaoDTO;
    }


    /**
     * Sets the objsRtMonitorizacaoDTO value for this GtRtMonitorizacaoDTO.
     * 
     * @param objsRtMonitorizacaoDTO
     */
    public void setObjsRtMonitorizacaoDTO(idw.idwws.ObjsRtMonitorizacaoDTO objsRtMonitorizacaoDTO) {
        this.objsRtMonitorizacaoDTO = objsRtMonitorizacaoDTO;
    }


    /**
     * Gets the resultadoEvento value for this GtRtMonitorizacaoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this GtRtMonitorizacaoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the tempoMiliAtualizacaoGt value for this GtRtMonitorizacaoDTO.
     * 
     * @return tempoMiliAtualizacaoGt
     */
    public int getTempoMiliAtualizacaoGt() {
        return tempoMiliAtualizacaoGt;
    }


    /**
     * Sets the tempoMiliAtualizacaoGt value for this GtRtMonitorizacaoDTO.
     * 
     * @param tempoMiliAtualizacaoGt
     */
    public void setTempoMiliAtualizacaoGt(int tempoMiliAtualizacaoGt) {
        this.tempoMiliAtualizacaoGt = tempoMiliAtualizacaoGt;
    }


    /**
     * Gets the turnoReferencia value for this GtRtMonitorizacaoDTO.
     * 
     * @return turnoReferencia
     */
    public idw.idwws.TurnoAtualDTO getTurnoReferencia() {
        return turnoReferencia;
    }


    /**
     * Sets the turnoReferencia value for this GtRtMonitorizacaoDTO.
     * 
     * @param turnoReferencia
     */
    public void setTurnoReferencia(idw.idwws.TurnoAtualDTO turnoReferencia) {
        this.turnoReferencia = turnoReferencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GtRtMonitorizacaoDTO)) return false;
        GtRtMonitorizacaoDTO other = (GtRtMonitorizacaoDTO) obj;
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
            ((this.dthrRefresh==null && other.getDthrRefresh()==null) || 
             (this.dthrRefresh!=null &&
              this.dthrRefresh.equals(other.getDthrRefresh()))) &&
            this.filtroLabel == other.getFiltroLabel() &&
            this.filtroLabel2 == other.getFiltroLabel2() &&
            ((this.gtDTO==null && other.getGtDTO()==null) || 
             (this.gtDTO!=null &&
              this.gtDTO.equals(other.getGtDTO()))) &&
            ((this.objsRtMonitorizacaoDTO==null && other.getObjsRtMonitorizacaoDTO()==null) || 
             (this.objsRtMonitorizacaoDTO!=null &&
              this.objsRtMonitorizacaoDTO.equals(other.getObjsRtMonitorizacaoDTO()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            this.tempoMiliAtualizacaoGt == other.getTempoMiliAtualizacaoGt() &&
            ((this.turnoReferencia==null && other.getTurnoReferencia()==null) || 
             (this.turnoReferencia!=null &&
              this.turnoReferencia.equals(other.getTurnoReferencia())));
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
        if (getDthrRefresh() != null) {
            _hashCode += getDthrRefresh().hashCode();
        }
        _hashCode += getFiltroLabel();
        _hashCode += getFiltroLabel2();
        if (getGtDTO() != null) {
            _hashCode += getGtDTO().hashCode();
        }
        if (getObjsRtMonitorizacaoDTO() != null) {
            _hashCode += getObjsRtMonitorizacaoDTO().hashCode();
        }
        _hashCode += getResultadoEvento();
        _hashCode += getTempoMiliAtualizacaoGt();
        if (getTurnoReferencia() != null) {
            _hashCode += getTurnoReferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GtRtMonitorizacaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "gtRtMonitorizacaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrRefresh");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrRefresh"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filtroLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filtroLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filtroLabel2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filtroLabel2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("objsRtMonitorizacaoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objsRtMonitorizacaoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objsRtMonitorizacaoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoMiliAtualizacaoGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoMiliAtualizacaoGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turnoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "turnoReferencia"));
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
