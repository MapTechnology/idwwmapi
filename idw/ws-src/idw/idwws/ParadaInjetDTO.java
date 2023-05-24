/**
 * ParadaInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ParadaInjetDTO  implements java.io.Serializable {
    private java.lang.String cdParada;

    private java.lang.String dsAreaResponsavel;

    private java.lang.String dsParada;

    private java.util.Calendar dthrfParada;

    private java.util.Calendar dthriParada;

    private boolean paradaPesa;

    private java.lang.Float tempoParadaSegundos;

    private java.lang.Float tempoTotal;

    public ParadaInjetDTO() {
    }

    public ParadaInjetDTO(
           java.lang.String cdParada,
           java.lang.String dsAreaResponsavel,
           java.lang.String dsParada,
           java.util.Calendar dthrfParada,
           java.util.Calendar dthriParada,
           boolean paradaPesa,
           java.lang.Float tempoParadaSegundos,
           java.lang.Float tempoTotal) {
           this.cdParada = cdParada;
           this.dsAreaResponsavel = dsAreaResponsavel;
           this.dsParada = dsParada;
           this.dthrfParada = dthrfParada;
           this.dthriParada = dthriParada;
           this.paradaPesa = paradaPesa;
           this.tempoParadaSegundos = tempoParadaSegundos;
           this.tempoTotal = tempoTotal;
    }


    /**
     * Gets the cdParada value for this ParadaInjetDTO.
     * 
     * @return cdParada
     */
    public java.lang.String getCdParada() {
        return cdParada;
    }


    /**
     * Sets the cdParada value for this ParadaInjetDTO.
     * 
     * @param cdParada
     */
    public void setCdParada(java.lang.String cdParada) {
        this.cdParada = cdParada;
    }


    /**
     * Gets the dsAreaResponsavel value for this ParadaInjetDTO.
     * 
     * @return dsAreaResponsavel
     */
    public java.lang.String getDsAreaResponsavel() {
        return dsAreaResponsavel;
    }


    /**
     * Sets the dsAreaResponsavel value for this ParadaInjetDTO.
     * 
     * @param dsAreaResponsavel
     */
    public void setDsAreaResponsavel(java.lang.String dsAreaResponsavel) {
        this.dsAreaResponsavel = dsAreaResponsavel;
    }


    /**
     * Gets the dsParada value for this ParadaInjetDTO.
     * 
     * @return dsParada
     */
    public java.lang.String getDsParada() {
        return dsParada;
    }


    /**
     * Sets the dsParada value for this ParadaInjetDTO.
     * 
     * @param dsParada
     */
    public void setDsParada(java.lang.String dsParada) {
        this.dsParada = dsParada;
    }


    /**
     * Gets the dthrfParada value for this ParadaInjetDTO.
     * 
     * @return dthrfParada
     */
    public java.util.Calendar getDthrfParada() {
        return dthrfParada;
    }


    /**
     * Sets the dthrfParada value for this ParadaInjetDTO.
     * 
     * @param dthrfParada
     */
    public void setDthrfParada(java.util.Calendar dthrfParada) {
        this.dthrfParada = dthrfParada;
    }


    /**
     * Gets the dthriParada value for this ParadaInjetDTO.
     * 
     * @return dthriParada
     */
    public java.util.Calendar getDthriParada() {
        return dthriParada;
    }


    /**
     * Sets the dthriParada value for this ParadaInjetDTO.
     * 
     * @param dthriParada
     */
    public void setDthriParada(java.util.Calendar dthriParada) {
        this.dthriParada = dthriParada;
    }


    /**
     * Gets the paradaPesa value for this ParadaInjetDTO.
     * 
     * @return paradaPesa
     */
    public boolean isParadaPesa() {
        return paradaPesa;
    }


    /**
     * Sets the paradaPesa value for this ParadaInjetDTO.
     * 
     * @param paradaPesa
     */
    public void setParadaPesa(boolean paradaPesa) {
        this.paradaPesa = paradaPesa;
    }


    /**
     * Gets the tempoParadaSegundos value for this ParadaInjetDTO.
     * 
     * @return tempoParadaSegundos
     */
    public java.lang.Float getTempoParadaSegundos() {
        return tempoParadaSegundos;
    }


    /**
     * Sets the tempoParadaSegundos value for this ParadaInjetDTO.
     * 
     * @param tempoParadaSegundos
     */
    public void setTempoParadaSegundos(java.lang.Float tempoParadaSegundos) {
        this.tempoParadaSegundos = tempoParadaSegundos;
    }


    /**
     * Gets the tempoTotal value for this ParadaInjetDTO.
     * 
     * @return tempoTotal
     */
    public java.lang.Float getTempoTotal() {
        return tempoTotal;
    }


    /**
     * Sets the tempoTotal value for this ParadaInjetDTO.
     * 
     * @param tempoTotal
     */
    public void setTempoTotal(java.lang.Float tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParadaInjetDTO)) return false;
        ParadaInjetDTO other = (ParadaInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdParada==null && other.getCdParada()==null) || 
             (this.cdParada!=null &&
              this.cdParada.equals(other.getCdParada()))) &&
            ((this.dsAreaResponsavel==null && other.getDsAreaResponsavel()==null) || 
             (this.dsAreaResponsavel!=null &&
              this.dsAreaResponsavel.equals(other.getDsAreaResponsavel()))) &&
            ((this.dsParada==null && other.getDsParada()==null) || 
             (this.dsParada!=null &&
              this.dsParada.equals(other.getDsParada()))) &&
            ((this.dthrfParada==null && other.getDthrfParada()==null) || 
             (this.dthrfParada!=null &&
              this.dthrfParada.equals(other.getDthrfParada()))) &&
            ((this.dthriParada==null && other.getDthriParada()==null) || 
             (this.dthriParada!=null &&
              this.dthriParada.equals(other.getDthriParada()))) &&
            this.paradaPesa == other.isParadaPesa() &&
            ((this.tempoParadaSegundos==null && other.getTempoParadaSegundos()==null) || 
             (this.tempoParadaSegundos!=null &&
              this.tempoParadaSegundos.equals(other.getTempoParadaSegundos()))) &&
            ((this.tempoTotal==null && other.getTempoTotal()==null) || 
             (this.tempoTotal!=null &&
              this.tempoTotal.equals(other.getTempoTotal())));
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
        if (getCdParada() != null) {
            _hashCode += getCdParada().hashCode();
        }
        if (getDsAreaResponsavel() != null) {
            _hashCode += getDsAreaResponsavel().hashCode();
        }
        if (getDsParada() != null) {
            _hashCode += getDsParada().hashCode();
        }
        if (getDthrfParada() != null) {
            _hashCode += getDthrfParada().hashCode();
        }
        if (getDthriParada() != null) {
            _hashCode += getDthriParada().hashCode();
        }
        _hashCode += (isParadaPesa() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getTempoParadaSegundos() != null) {
            _hashCode += getTempoParadaSegundos().hashCode();
        }
        if (getTempoTotal() != null) {
            _hashCode += getTempoTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParadaInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paradaInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsAreaResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsAreaResponsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaPesa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaPesa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoParadaSegundos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoParadaSegundos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoTotal"));
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
