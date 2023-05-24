/**
 * MsMonitor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsMonitor  extends idw.idwws.MsMonitorTemplate  implements java.io.Serializable {
    private java.lang.String dsItemMonitorado;

    private java.util.Calendar dthrFim;

    private java.util.Calendar dthrInicio;

    private java.lang.Long idMonitor;

    private java.math.BigDecimal memConsumida;

    private java.math.BigDecimal memfFreeEmbyte;

    private java.math.BigDecimal memiFreeEmbyte;

    private java.math.BigDecimal miliDuracao;

    private idw.idwws.MsEvt msEvt;

    public MsMonitor() {
    }

    public MsMonitor(
           java.lang.String dsItemMonitorado,
           java.util.Calendar dthrFim,
           java.util.Calendar dthrInicio,
           java.lang.Long idMonitor,
           java.math.BigDecimal memConsumida,
           java.math.BigDecimal memfFreeEmbyte,
           java.math.BigDecimal memiFreeEmbyte,
           java.math.BigDecimal miliDuracao,
           idw.idwws.MsEvt msEvt) {
        this.dsItemMonitorado = dsItemMonitorado;
        this.dthrFim = dthrFim;
        this.dthrInicio = dthrInicio;
        this.idMonitor = idMonitor;
        this.memConsumida = memConsumida;
        this.memfFreeEmbyte = memfFreeEmbyte;
        this.memiFreeEmbyte = memiFreeEmbyte;
        this.miliDuracao = miliDuracao;
        this.msEvt = msEvt;
    }


    /**
     * Gets the dsItemMonitorado value for this MsMonitor.
     * 
     * @return dsItemMonitorado
     */
    public java.lang.String getDsItemMonitorado() {
        return dsItemMonitorado;
    }


    /**
     * Sets the dsItemMonitorado value for this MsMonitor.
     * 
     * @param dsItemMonitorado
     */
    public void setDsItemMonitorado(java.lang.String dsItemMonitorado) {
        this.dsItemMonitorado = dsItemMonitorado;
    }


    /**
     * Gets the dthrFim value for this MsMonitor.
     * 
     * @return dthrFim
     */
    public java.util.Calendar getDthrFim() {
        return dthrFim;
    }


    /**
     * Sets the dthrFim value for this MsMonitor.
     * 
     * @param dthrFim
     */
    public void setDthrFim(java.util.Calendar dthrFim) {
        this.dthrFim = dthrFim;
    }


    /**
     * Gets the dthrInicio value for this MsMonitor.
     * 
     * @return dthrInicio
     */
    public java.util.Calendar getDthrInicio() {
        return dthrInicio;
    }


    /**
     * Sets the dthrInicio value for this MsMonitor.
     * 
     * @param dthrInicio
     */
    public void setDthrInicio(java.util.Calendar dthrInicio) {
        this.dthrInicio = dthrInicio;
    }


    /**
     * Gets the idMonitor value for this MsMonitor.
     * 
     * @return idMonitor
     */
    public java.lang.Long getIdMonitor() {
        return idMonitor;
    }


    /**
     * Sets the idMonitor value for this MsMonitor.
     * 
     * @param idMonitor
     */
    public void setIdMonitor(java.lang.Long idMonitor) {
        this.idMonitor = idMonitor;
    }


    /**
     * Gets the memConsumida value for this MsMonitor.
     * 
     * @return memConsumida
     */
    public java.math.BigDecimal getMemConsumida() {
        return memConsumida;
    }


    /**
     * Sets the memConsumida value for this MsMonitor.
     * 
     * @param memConsumida
     */
    public void setMemConsumida(java.math.BigDecimal memConsumida) {
        this.memConsumida = memConsumida;
    }


    /**
     * Gets the memfFreeEmbyte value for this MsMonitor.
     * 
     * @return memfFreeEmbyte
     */
    public java.math.BigDecimal getMemfFreeEmbyte() {
        return memfFreeEmbyte;
    }


    /**
     * Sets the memfFreeEmbyte value for this MsMonitor.
     * 
     * @param memfFreeEmbyte
     */
    public void setMemfFreeEmbyte(java.math.BigDecimal memfFreeEmbyte) {
        this.memfFreeEmbyte = memfFreeEmbyte;
    }


    /**
     * Gets the memiFreeEmbyte value for this MsMonitor.
     * 
     * @return memiFreeEmbyte
     */
    public java.math.BigDecimal getMemiFreeEmbyte() {
        return memiFreeEmbyte;
    }


    /**
     * Sets the memiFreeEmbyte value for this MsMonitor.
     * 
     * @param memiFreeEmbyte
     */
    public void setMemiFreeEmbyte(java.math.BigDecimal memiFreeEmbyte) {
        this.memiFreeEmbyte = memiFreeEmbyte;
    }


    /**
     * Gets the miliDuracao value for this MsMonitor.
     * 
     * @return miliDuracao
     */
    public java.math.BigDecimal getMiliDuracao() {
        return miliDuracao;
    }


    /**
     * Sets the miliDuracao value for this MsMonitor.
     * 
     * @param miliDuracao
     */
    public void setMiliDuracao(java.math.BigDecimal miliDuracao) {
        this.miliDuracao = miliDuracao;
    }


    /**
     * Gets the msEvt value for this MsMonitor.
     * 
     * @return msEvt
     */
    public idw.idwws.MsEvt getMsEvt() {
        return msEvt;
    }


    /**
     * Sets the msEvt value for this MsMonitor.
     * 
     * @param msEvt
     */
    public void setMsEvt(idw.idwws.MsEvt msEvt) {
        this.msEvt = msEvt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsMonitor)) return false;
        MsMonitor other = (MsMonitor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsItemMonitorado==null && other.getDsItemMonitorado()==null) || 
             (this.dsItemMonitorado!=null &&
              this.dsItemMonitorado.equals(other.getDsItemMonitorado()))) &&
            ((this.dthrFim==null && other.getDthrFim()==null) || 
             (this.dthrFim!=null &&
              this.dthrFim.equals(other.getDthrFim()))) &&
            ((this.dthrInicio==null && other.getDthrInicio()==null) || 
             (this.dthrInicio!=null &&
              this.dthrInicio.equals(other.getDthrInicio()))) &&
            ((this.idMonitor==null && other.getIdMonitor()==null) || 
             (this.idMonitor!=null &&
              this.idMonitor.equals(other.getIdMonitor()))) &&
            ((this.memConsumida==null && other.getMemConsumida()==null) || 
             (this.memConsumida!=null &&
              this.memConsumida.equals(other.getMemConsumida()))) &&
            ((this.memfFreeEmbyte==null && other.getMemfFreeEmbyte()==null) || 
             (this.memfFreeEmbyte!=null &&
              this.memfFreeEmbyte.equals(other.getMemfFreeEmbyte()))) &&
            ((this.memiFreeEmbyte==null && other.getMemiFreeEmbyte()==null) || 
             (this.memiFreeEmbyte!=null &&
              this.memiFreeEmbyte.equals(other.getMemiFreeEmbyte()))) &&
            ((this.miliDuracao==null && other.getMiliDuracao()==null) || 
             (this.miliDuracao!=null &&
              this.miliDuracao.equals(other.getMiliDuracao()))) &&
            ((this.msEvt==null && other.getMsEvt()==null) || 
             (this.msEvt!=null &&
              this.msEvt.equals(other.getMsEvt())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDsItemMonitorado() != null) {
            _hashCode += getDsItemMonitorado().hashCode();
        }
        if (getDthrFim() != null) {
            _hashCode += getDthrFim().hashCode();
        }
        if (getDthrInicio() != null) {
            _hashCode += getDthrInicio().hashCode();
        }
        if (getIdMonitor() != null) {
            _hashCode += getIdMonitor().hashCode();
        }
        if (getMemConsumida() != null) {
            _hashCode += getMemConsumida().hashCode();
        }
        if (getMemfFreeEmbyte() != null) {
            _hashCode += getMemfFreeEmbyte().hashCode();
        }
        if (getMemiFreeEmbyte() != null) {
            _hashCode += getMemiFreeEmbyte().hashCode();
        }
        if (getMiliDuracao() != null) {
            _hashCode += getMiliDuracao().hashCode();
        }
        if (getMsEvt() != null) {
            _hashCode += getMsEvt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsMonitor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMonitor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsItemMonitorado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsItemMonitorado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMonitor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMonitor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memConsumida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memConsumida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memfFreeEmbyte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memfFreeEmbyte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memiFreeEmbyte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memiFreeEmbyte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miliDuracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miliDuracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
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
