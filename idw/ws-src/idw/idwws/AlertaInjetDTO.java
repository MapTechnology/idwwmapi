/**
 * AlertaInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class AlertaInjetDTO  implements java.io.Serializable {
    private java.lang.String cdAlerta;

    private java.lang.String dsAlerta;

    private java.util.Calendar dthrfAlerta;

    private java.util.Calendar dthriAlerta;

    private java.lang.Float duracao;

    public AlertaInjetDTO() {
    }

    public AlertaInjetDTO(
           java.lang.String cdAlerta,
           java.lang.String dsAlerta,
           java.util.Calendar dthrfAlerta,
           java.util.Calendar dthriAlerta,
           java.lang.Float duracao) {
           this.cdAlerta = cdAlerta;
           this.dsAlerta = dsAlerta;
           this.dthrfAlerta = dthrfAlerta;
           this.dthriAlerta = dthriAlerta;
           this.duracao = duracao;
    }


    /**
     * Gets the cdAlerta value for this AlertaInjetDTO.
     * 
     * @return cdAlerta
     */
    public java.lang.String getCdAlerta() {
        return cdAlerta;
    }


    /**
     * Sets the cdAlerta value for this AlertaInjetDTO.
     * 
     * @param cdAlerta
     */
    public void setCdAlerta(java.lang.String cdAlerta) {
        this.cdAlerta = cdAlerta;
    }


    /**
     * Gets the dsAlerta value for this AlertaInjetDTO.
     * 
     * @return dsAlerta
     */
    public java.lang.String getDsAlerta() {
        return dsAlerta;
    }


    /**
     * Sets the dsAlerta value for this AlertaInjetDTO.
     * 
     * @param dsAlerta
     */
    public void setDsAlerta(java.lang.String dsAlerta) {
        this.dsAlerta = dsAlerta;
    }


    /**
     * Gets the dthrfAlerta value for this AlertaInjetDTO.
     * 
     * @return dthrfAlerta
     */
    public java.util.Calendar getDthrfAlerta() {
        return dthrfAlerta;
    }


    /**
     * Sets the dthrfAlerta value for this AlertaInjetDTO.
     * 
     * @param dthrfAlerta
     */
    public void setDthrfAlerta(java.util.Calendar dthrfAlerta) {
        this.dthrfAlerta = dthrfAlerta;
    }


    /**
     * Gets the dthriAlerta value for this AlertaInjetDTO.
     * 
     * @return dthriAlerta
     */
    public java.util.Calendar getDthriAlerta() {
        return dthriAlerta;
    }


    /**
     * Sets the dthriAlerta value for this AlertaInjetDTO.
     * 
     * @param dthriAlerta
     */
    public void setDthriAlerta(java.util.Calendar dthriAlerta) {
        this.dthriAlerta = dthriAlerta;
    }


    /**
     * Gets the duracao value for this AlertaInjetDTO.
     * 
     * @return duracao
     */
    public java.lang.Float getDuracao() {
        return duracao;
    }


    /**
     * Sets the duracao value for this AlertaInjetDTO.
     * 
     * @param duracao
     */
    public void setDuracao(java.lang.Float duracao) {
        this.duracao = duracao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlertaInjetDTO)) return false;
        AlertaInjetDTO other = (AlertaInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdAlerta==null && other.getCdAlerta()==null) || 
             (this.cdAlerta!=null &&
              this.cdAlerta.equals(other.getCdAlerta()))) &&
            ((this.dsAlerta==null && other.getDsAlerta()==null) || 
             (this.dsAlerta!=null &&
              this.dsAlerta.equals(other.getDsAlerta()))) &&
            ((this.dthrfAlerta==null && other.getDthrfAlerta()==null) || 
             (this.dthrfAlerta!=null &&
              this.dthrfAlerta.equals(other.getDthrfAlerta()))) &&
            ((this.dthriAlerta==null && other.getDthriAlerta()==null) || 
             (this.dthriAlerta!=null &&
              this.dthriAlerta.equals(other.getDthriAlerta()))) &&
            ((this.duracao==null && other.getDuracao()==null) || 
             (this.duracao!=null &&
              this.duracao.equals(other.getDuracao())));
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
        if (getCdAlerta() != null) {
            _hashCode += getCdAlerta().hashCode();
        }
        if (getDsAlerta() != null) {
            _hashCode += getDsAlerta().hashCode();
        }
        if (getDthrfAlerta() != null) {
            _hashCode += getDthrfAlerta().hashCode();
        }
        if (getDthriAlerta() != null) {
            _hashCode += getDthriAlerta().hashCode();
        }
        if (getDuracao() != null) {
            _hashCode += getDuracao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlertaInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "alertaInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
