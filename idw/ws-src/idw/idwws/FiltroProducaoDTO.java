/**
 * FiltroProducaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroProducaoDTO  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private idw.idwws.DwTurno dwTurno;

    private idw.idwws.InicioFimDTO inicioFimHora;

    private idw.idwws.InicioFimDTO inicioFimTurno;

    private idw.idwws.FiltroProducaoPtCpDTO[] listaFiltroProducaoPtCp;

    private idw.idwws.OmGt omGt;

    private byte tpId;

    public FiltroProducaoDTO() {
    }

    public FiltroProducaoDTO(
           java.util.Calendar dtReferencia,
           idw.idwws.DwTurno dwTurno,
           idw.idwws.InicioFimDTO inicioFimHora,
           idw.idwws.InicioFimDTO inicioFimTurno,
           idw.idwws.FiltroProducaoPtCpDTO[] listaFiltroProducaoPtCp,
           idw.idwws.OmGt omGt,
           byte tpId) {
           this.dtReferencia = dtReferencia;
           this.dwTurno = dwTurno;
           this.inicioFimHora = inicioFimHora;
           this.inicioFimTurno = inicioFimTurno;
           this.listaFiltroProducaoPtCp = listaFiltroProducaoPtCp;
           this.omGt = omGt;
           this.tpId = tpId;
    }


    /**
     * Gets the dtReferencia value for this FiltroProducaoDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this FiltroProducaoDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dwTurno value for this FiltroProducaoDTO.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this FiltroProducaoDTO.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the inicioFimHora value for this FiltroProducaoDTO.
     * 
     * @return inicioFimHora
     */
    public idw.idwws.InicioFimDTO getInicioFimHora() {
        return inicioFimHora;
    }


    /**
     * Sets the inicioFimHora value for this FiltroProducaoDTO.
     * 
     * @param inicioFimHora
     */
    public void setInicioFimHora(idw.idwws.InicioFimDTO inicioFimHora) {
        this.inicioFimHora = inicioFimHora;
    }


    /**
     * Gets the inicioFimTurno value for this FiltroProducaoDTO.
     * 
     * @return inicioFimTurno
     */
    public idw.idwws.InicioFimDTO getInicioFimTurno() {
        return inicioFimTurno;
    }


    /**
     * Sets the inicioFimTurno value for this FiltroProducaoDTO.
     * 
     * @param inicioFimTurno
     */
    public void setInicioFimTurno(idw.idwws.InicioFimDTO inicioFimTurno) {
        this.inicioFimTurno = inicioFimTurno;
    }


    /**
     * Gets the listaFiltroProducaoPtCp value for this FiltroProducaoDTO.
     * 
     * @return listaFiltroProducaoPtCp
     */
    public idw.idwws.FiltroProducaoPtCpDTO[] getListaFiltroProducaoPtCp() {
        return listaFiltroProducaoPtCp;
    }


    /**
     * Sets the listaFiltroProducaoPtCp value for this FiltroProducaoDTO.
     * 
     * @param listaFiltroProducaoPtCp
     */
    public void setListaFiltroProducaoPtCp(idw.idwws.FiltroProducaoPtCpDTO[] listaFiltroProducaoPtCp) {
        this.listaFiltroProducaoPtCp = listaFiltroProducaoPtCp;
    }

    public idw.idwws.FiltroProducaoPtCpDTO getListaFiltroProducaoPtCp(int i) {
        return this.listaFiltroProducaoPtCp[i];
    }

    public void setListaFiltroProducaoPtCp(int i, idw.idwws.FiltroProducaoPtCpDTO _value) {
        this.listaFiltroProducaoPtCp[i] = _value;
    }


    /**
     * Gets the omGt value for this FiltroProducaoDTO.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this FiltroProducaoDTO.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the tpId value for this FiltroProducaoDTO.
     * 
     * @return tpId
     */
    public byte getTpId() {
        return tpId;
    }


    /**
     * Sets the tpId value for this FiltroProducaoDTO.
     * 
     * @param tpId
     */
    public void setTpId(byte tpId) {
        this.tpId = tpId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroProducaoDTO)) return false;
        FiltroProducaoDTO other = (FiltroProducaoDTO) obj;
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
            ((this.inicioFimHora==null && other.getInicioFimHora()==null) || 
             (this.inicioFimHora!=null &&
              this.inicioFimHora.equals(other.getInicioFimHora()))) &&
            ((this.inicioFimTurno==null && other.getInicioFimTurno()==null) || 
             (this.inicioFimTurno!=null &&
              this.inicioFimTurno.equals(other.getInicioFimTurno()))) &&
            ((this.listaFiltroProducaoPtCp==null && other.getListaFiltroProducaoPtCp()==null) || 
             (this.listaFiltroProducaoPtCp!=null &&
              java.util.Arrays.equals(this.listaFiltroProducaoPtCp, other.getListaFiltroProducaoPtCp()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            this.tpId == other.getTpId();
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
        if (getInicioFimHora() != null) {
            _hashCode += getInicioFimHora().hashCode();
        }
        if (getInicioFimTurno() != null) {
            _hashCode += getInicioFimTurno().hashCode();
        }
        if (getListaFiltroProducaoPtCp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaFiltroProducaoPtCp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaFiltroProducaoPtCp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        _hashCode += getTpId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroProducaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroProducaoDTO"));
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
        elemField.setFieldName("inicioFimHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioFimHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "inicioFimDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioFimTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioFimTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "inicioFimDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaFiltroProducaoPtCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaFiltroProducaoPtCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroProducaoPtCpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
