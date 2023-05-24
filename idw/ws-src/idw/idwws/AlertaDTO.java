/**
 * AlertaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class AlertaDTO  implements java.io.Serializable {
    private java.util.Calendar dthrFalerta;

    private java.util.Calendar dthrIalerta;

    private idw.idwws.DwTAlerta dwTAlerta;

    private idw.idwws.OmPt maquina;

    private java.lang.Byte msDthrfalerta;

    private java.lang.Byte msDthrialerta;

    private idw.idwws.PpCp ordemproducao;

    public AlertaDTO() {
    }

    public AlertaDTO(
           java.util.Calendar dthrFalerta,
           java.util.Calendar dthrIalerta,
           idw.idwws.DwTAlerta dwTAlerta,
           idw.idwws.OmPt maquina,
           java.lang.Byte msDthrfalerta,
           java.lang.Byte msDthrialerta,
           idw.idwws.PpCp ordemproducao) {
           this.dthrFalerta = dthrFalerta;
           this.dthrIalerta = dthrIalerta;
           this.dwTAlerta = dwTAlerta;
           this.maquina = maquina;
           this.msDthrfalerta = msDthrfalerta;
           this.msDthrialerta = msDthrialerta;
           this.ordemproducao = ordemproducao;
    }


    /**
     * Gets the dthrFalerta value for this AlertaDTO.
     * 
     * @return dthrFalerta
     */
    public java.util.Calendar getDthrFalerta() {
        return dthrFalerta;
    }


    /**
     * Sets the dthrFalerta value for this AlertaDTO.
     * 
     * @param dthrFalerta
     */
    public void setDthrFalerta(java.util.Calendar dthrFalerta) {
        this.dthrFalerta = dthrFalerta;
    }


    /**
     * Gets the dthrIalerta value for this AlertaDTO.
     * 
     * @return dthrIalerta
     */
    public java.util.Calendar getDthrIalerta() {
        return dthrIalerta;
    }


    /**
     * Sets the dthrIalerta value for this AlertaDTO.
     * 
     * @param dthrIalerta
     */
    public void setDthrIalerta(java.util.Calendar dthrIalerta) {
        this.dthrIalerta = dthrIalerta;
    }


    /**
     * Gets the dwTAlerta value for this AlertaDTO.
     * 
     * @return dwTAlerta
     */
    public idw.idwws.DwTAlerta getDwTAlerta() {
        return dwTAlerta;
    }


    /**
     * Sets the dwTAlerta value for this AlertaDTO.
     * 
     * @param dwTAlerta
     */
    public void setDwTAlerta(idw.idwws.DwTAlerta dwTAlerta) {
        this.dwTAlerta = dwTAlerta;
    }


    /**
     * Gets the maquina value for this AlertaDTO.
     * 
     * @return maquina
     */
    public idw.idwws.OmPt getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this AlertaDTO.
     * 
     * @param maquina
     */
    public void setMaquina(idw.idwws.OmPt maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the msDthrfalerta value for this AlertaDTO.
     * 
     * @return msDthrfalerta
     */
    public java.lang.Byte getMsDthrfalerta() {
        return msDthrfalerta;
    }


    /**
     * Sets the msDthrfalerta value for this AlertaDTO.
     * 
     * @param msDthrfalerta
     */
    public void setMsDthrfalerta(java.lang.Byte msDthrfalerta) {
        this.msDthrfalerta = msDthrfalerta;
    }


    /**
     * Gets the msDthrialerta value for this AlertaDTO.
     * 
     * @return msDthrialerta
     */
    public java.lang.Byte getMsDthrialerta() {
        return msDthrialerta;
    }


    /**
     * Sets the msDthrialerta value for this AlertaDTO.
     * 
     * @param msDthrialerta
     */
    public void setMsDthrialerta(java.lang.Byte msDthrialerta) {
        this.msDthrialerta = msDthrialerta;
    }


    /**
     * Gets the ordemproducao value for this AlertaDTO.
     * 
     * @return ordemproducao
     */
    public idw.idwws.PpCp getOrdemproducao() {
        return ordemproducao;
    }


    /**
     * Sets the ordemproducao value for this AlertaDTO.
     * 
     * @param ordemproducao
     */
    public void setOrdemproducao(idw.idwws.PpCp ordemproducao) {
        this.ordemproducao = ordemproducao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlertaDTO)) return false;
        AlertaDTO other = (AlertaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrFalerta==null && other.getDthrFalerta()==null) || 
             (this.dthrFalerta!=null &&
              this.dthrFalerta.equals(other.getDthrFalerta()))) &&
            ((this.dthrIalerta==null && other.getDthrIalerta()==null) || 
             (this.dthrIalerta!=null &&
              this.dthrIalerta.equals(other.getDthrIalerta()))) &&
            ((this.dwTAlerta==null && other.getDwTAlerta()==null) || 
             (this.dwTAlerta!=null &&
              this.dwTAlerta.equals(other.getDwTAlerta()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            ((this.msDthrfalerta==null && other.getMsDthrfalerta()==null) || 
             (this.msDthrfalerta!=null &&
              this.msDthrfalerta.equals(other.getMsDthrfalerta()))) &&
            ((this.msDthrialerta==null && other.getMsDthrialerta()==null) || 
             (this.msDthrialerta!=null &&
              this.msDthrialerta.equals(other.getMsDthrialerta()))) &&
            ((this.ordemproducao==null && other.getOrdemproducao()==null) || 
             (this.ordemproducao!=null &&
              this.ordemproducao.equals(other.getOrdemproducao())));
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
        if (getDthrFalerta() != null) {
            _hashCode += getDthrFalerta().hashCode();
        }
        if (getDthrIalerta() != null) {
            _hashCode += getDthrIalerta().hashCode();
        }
        if (getDwTAlerta() != null) {
            _hashCode += getDwTAlerta().hashCode();
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        if (getMsDthrfalerta() != null) {
            _hashCode += getMsDthrfalerta().hashCode();
        }
        if (getMsDthrialerta() != null) {
            _hashCode += getMsDthrialerta().hashCode();
        }
        if (getOrdemproducao() != null) {
            _hashCode += getOrdemproducao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlertaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "alertaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAlerta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrialerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrialerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
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
