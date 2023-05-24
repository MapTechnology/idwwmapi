/**
 * EvtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EvtDTO  implements java.io.Serializable {
    private java.lang.String dsTipoEvento;

    private java.util.Calendar dthrFEvento;

    private java.util.Calendar dthrIEvento;

    private java.math.BigDecimal idEvento;

    private java.math.BigDecimal idEventoAnterior;

    private java.math.BigDecimal idTipoEvento;

    public EvtDTO() {
    }

    public EvtDTO(
           java.lang.String dsTipoEvento,
           java.util.Calendar dthrFEvento,
           java.util.Calendar dthrIEvento,
           java.math.BigDecimal idEvento,
           java.math.BigDecimal idEventoAnterior,
           java.math.BigDecimal idTipoEvento) {
           this.dsTipoEvento = dsTipoEvento;
           this.dthrFEvento = dthrFEvento;
           this.dthrIEvento = dthrIEvento;
           this.idEvento = idEvento;
           this.idEventoAnterior = idEventoAnterior;
           this.idTipoEvento = idTipoEvento;
    }


    /**
     * Gets the dsTipoEvento value for this EvtDTO.
     * 
     * @return dsTipoEvento
     */
    public java.lang.String getDsTipoEvento() {
        return dsTipoEvento;
    }


    /**
     * Sets the dsTipoEvento value for this EvtDTO.
     * 
     * @param dsTipoEvento
     */
    public void setDsTipoEvento(java.lang.String dsTipoEvento) {
        this.dsTipoEvento = dsTipoEvento;
    }


    /**
     * Gets the dthrFEvento value for this EvtDTO.
     * 
     * @return dthrFEvento
     */
    public java.util.Calendar getDthrFEvento() {
        return dthrFEvento;
    }


    /**
     * Sets the dthrFEvento value for this EvtDTO.
     * 
     * @param dthrFEvento
     */
    public void setDthrFEvento(java.util.Calendar dthrFEvento) {
        this.dthrFEvento = dthrFEvento;
    }


    /**
     * Gets the dthrIEvento value for this EvtDTO.
     * 
     * @return dthrIEvento
     */
    public java.util.Calendar getDthrIEvento() {
        return dthrIEvento;
    }


    /**
     * Sets the dthrIEvento value for this EvtDTO.
     * 
     * @param dthrIEvento
     */
    public void setDthrIEvento(java.util.Calendar dthrIEvento) {
        this.dthrIEvento = dthrIEvento;
    }


    /**
     * Gets the idEvento value for this EvtDTO.
     * 
     * @return idEvento
     */
    public java.math.BigDecimal getIdEvento() {
        return idEvento;
    }


    /**
     * Sets the idEvento value for this EvtDTO.
     * 
     * @param idEvento
     */
    public void setIdEvento(java.math.BigDecimal idEvento) {
        this.idEvento = idEvento;
    }


    /**
     * Gets the idEventoAnterior value for this EvtDTO.
     * 
     * @return idEventoAnterior
     */
    public java.math.BigDecimal getIdEventoAnterior() {
        return idEventoAnterior;
    }


    /**
     * Sets the idEventoAnterior value for this EvtDTO.
     * 
     * @param idEventoAnterior
     */
    public void setIdEventoAnterior(java.math.BigDecimal idEventoAnterior) {
        this.idEventoAnterior = idEventoAnterior;
    }


    /**
     * Gets the idTipoEvento value for this EvtDTO.
     * 
     * @return idTipoEvento
     */
    public java.math.BigDecimal getIdTipoEvento() {
        return idTipoEvento;
    }


    /**
     * Sets the idTipoEvento value for this EvtDTO.
     * 
     * @param idTipoEvento
     */
    public void setIdTipoEvento(java.math.BigDecimal idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EvtDTO)) return false;
        EvtDTO other = (EvtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsTipoEvento==null && other.getDsTipoEvento()==null) || 
             (this.dsTipoEvento!=null &&
              this.dsTipoEvento.equals(other.getDsTipoEvento()))) &&
            ((this.dthrFEvento==null && other.getDthrFEvento()==null) || 
             (this.dthrFEvento!=null &&
              this.dthrFEvento.equals(other.getDthrFEvento()))) &&
            ((this.dthrIEvento==null && other.getDthrIEvento()==null) || 
             (this.dthrIEvento!=null &&
              this.dthrIEvento.equals(other.getDthrIEvento()))) &&
            ((this.idEvento==null && other.getIdEvento()==null) || 
             (this.idEvento!=null &&
              this.idEvento.equals(other.getIdEvento()))) &&
            ((this.idEventoAnterior==null && other.getIdEventoAnterior()==null) || 
             (this.idEventoAnterior!=null &&
              this.idEventoAnterior.equals(other.getIdEventoAnterior()))) &&
            ((this.idTipoEvento==null && other.getIdTipoEvento()==null) || 
             (this.idTipoEvento!=null &&
              this.idTipoEvento.equals(other.getIdTipoEvento())));
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
        if (getDsTipoEvento() != null) {
            _hashCode += getDsTipoEvento().hashCode();
        }
        if (getDthrFEvento() != null) {
            _hashCode += getDthrFEvento().hashCode();
        }
        if (getDthrIEvento() != null) {
            _hashCode += getDthrIEvento().hashCode();
        }
        if (getIdEvento() != null) {
            _hashCode += getIdEvento().hashCode();
        }
        if (getIdEventoAnterior() != null) {
            _hashCode += getIdEventoAnterior().hashCode();
        }
        if (getIdTipoEvento() != null) {
            _hashCode += getIdTipoEvento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EvtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "evtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTipoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTipoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEventoAnterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEventoAnterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTipoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTipoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
