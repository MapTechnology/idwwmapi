/**
 * GraficoTempoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoTempoDTO  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private java.lang.Double tempoacurisoladas;

    private java.lang.Double tempocicloimprodutivos;

    private java.lang.Double temponaodisponivel;

    private java.lang.Double tempoparadas;

    private java.lang.Double tempoprodutivas;

    private java.lang.Double temporefugos;

    private java.lang.Double temporitmo;

    private java.lang.Double tempototal;

    public GraficoTempoDTO() {
    }

    public GraficoTempoDTO(
           java.util.Calendar dtReferencia,
           java.lang.Double tempoacurisoladas,
           java.lang.Double tempocicloimprodutivos,
           java.lang.Double temponaodisponivel,
           java.lang.Double tempoparadas,
           java.lang.Double tempoprodutivas,
           java.lang.Double temporefugos,
           java.lang.Double temporitmo,
           java.lang.Double tempototal) {
           this.dtReferencia = dtReferencia;
           this.tempoacurisoladas = tempoacurisoladas;
           this.tempocicloimprodutivos = tempocicloimprodutivos;
           this.temponaodisponivel = temponaodisponivel;
           this.tempoparadas = tempoparadas;
           this.tempoprodutivas = tempoprodutivas;
           this.temporefugos = temporefugos;
           this.temporitmo = temporitmo;
           this.tempototal = tempototal;
    }


    /**
     * Gets the dtReferencia value for this GraficoTempoDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this GraficoTempoDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the tempoacurisoladas value for this GraficoTempoDTO.
     * 
     * @return tempoacurisoladas
     */
    public java.lang.Double getTempoacurisoladas() {
        return tempoacurisoladas;
    }


    /**
     * Sets the tempoacurisoladas value for this GraficoTempoDTO.
     * 
     * @param tempoacurisoladas
     */
    public void setTempoacurisoladas(java.lang.Double tempoacurisoladas) {
        this.tempoacurisoladas = tempoacurisoladas;
    }


    /**
     * Gets the tempocicloimprodutivos value for this GraficoTempoDTO.
     * 
     * @return tempocicloimprodutivos
     */
    public java.lang.Double getTempocicloimprodutivos() {
        return tempocicloimprodutivos;
    }


    /**
     * Sets the tempocicloimprodutivos value for this GraficoTempoDTO.
     * 
     * @param tempocicloimprodutivos
     */
    public void setTempocicloimprodutivos(java.lang.Double tempocicloimprodutivos) {
        this.tempocicloimprodutivos = tempocicloimprodutivos;
    }


    /**
     * Gets the temponaodisponivel value for this GraficoTempoDTO.
     * 
     * @return temponaodisponivel
     */
    public java.lang.Double getTemponaodisponivel() {
        return temponaodisponivel;
    }


    /**
     * Sets the temponaodisponivel value for this GraficoTempoDTO.
     * 
     * @param temponaodisponivel
     */
    public void setTemponaodisponivel(java.lang.Double temponaodisponivel) {
        this.temponaodisponivel = temponaodisponivel;
    }


    /**
     * Gets the tempoparadas value for this GraficoTempoDTO.
     * 
     * @return tempoparadas
     */
    public java.lang.Double getTempoparadas() {
        return tempoparadas;
    }


    /**
     * Sets the tempoparadas value for this GraficoTempoDTO.
     * 
     * @param tempoparadas
     */
    public void setTempoparadas(java.lang.Double tempoparadas) {
        this.tempoparadas = tempoparadas;
    }


    /**
     * Gets the tempoprodutivas value for this GraficoTempoDTO.
     * 
     * @return tempoprodutivas
     */
    public java.lang.Double getTempoprodutivas() {
        return tempoprodutivas;
    }


    /**
     * Sets the tempoprodutivas value for this GraficoTempoDTO.
     * 
     * @param tempoprodutivas
     */
    public void setTempoprodutivas(java.lang.Double tempoprodutivas) {
        this.tempoprodutivas = tempoprodutivas;
    }


    /**
     * Gets the temporefugos value for this GraficoTempoDTO.
     * 
     * @return temporefugos
     */
    public java.lang.Double getTemporefugos() {
        return temporefugos;
    }


    /**
     * Sets the temporefugos value for this GraficoTempoDTO.
     * 
     * @param temporefugos
     */
    public void setTemporefugos(java.lang.Double temporefugos) {
        this.temporefugos = temporefugos;
    }


    /**
     * Gets the temporitmo value for this GraficoTempoDTO.
     * 
     * @return temporitmo
     */
    public java.lang.Double getTemporitmo() {
        return temporitmo;
    }


    /**
     * Sets the temporitmo value for this GraficoTempoDTO.
     * 
     * @param temporitmo
     */
    public void setTemporitmo(java.lang.Double temporitmo) {
        this.temporitmo = temporitmo;
    }


    /**
     * Gets the tempototal value for this GraficoTempoDTO.
     * 
     * @return tempototal
     */
    public java.lang.Double getTempototal() {
        return tempototal;
    }


    /**
     * Sets the tempototal value for this GraficoTempoDTO.
     * 
     * @param tempototal
     */
    public void setTempototal(java.lang.Double tempototal) {
        this.tempototal = tempototal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoTempoDTO)) return false;
        GraficoTempoDTO other = (GraficoTempoDTO) obj;
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
            ((this.tempoacurisoladas==null && other.getTempoacurisoladas()==null) || 
             (this.tempoacurisoladas!=null &&
              this.tempoacurisoladas.equals(other.getTempoacurisoladas()))) &&
            ((this.tempocicloimprodutivos==null && other.getTempocicloimprodutivos()==null) || 
             (this.tempocicloimprodutivos!=null &&
              this.tempocicloimprodutivos.equals(other.getTempocicloimprodutivos()))) &&
            ((this.temponaodisponivel==null && other.getTemponaodisponivel()==null) || 
             (this.temponaodisponivel!=null &&
              this.temponaodisponivel.equals(other.getTemponaodisponivel()))) &&
            ((this.tempoparadas==null && other.getTempoparadas()==null) || 
             (this.tempoparadas!=null &&
              this.tempoparadas.equals(other.getTempoparadas()))) &&
            ((this.tempoprodutivas==null && other.getTempoprodutivas()==null) || 
             (this.tempoprodutivas!=null &&
              this.tempoprodutivas.equals(other.getTempoprodutivas()))) &&
            ((this.temporefugos==null && other.getTemporefugos()==null) || 
             (this.temporefugos!=null &&
              this.temporefugos.equals(other.getTemporefugos()))) &&
            ((this.temporitmo==null && other.getTemporitmo()==null) || 
             (this.temporitmo!=null &&
              this.temporitmo.equals(other.getTemporitmo()))) &&
            ((this.tempototal==null && other.getTempototal()==null) || 
             (this.tempototal!=null &&
              this.tempototal.equals(other.getTempototal())));
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
        if (getTempoacurisoladas() != null) {
            _hashCode += getTempoacurisoladas().hashCode();
        }
        if (getTempocicloimprodutivos() != null) {
            _hashCode += getTempocicloimprodutivos().hashCode();
        }
        if (getTemponaodisponivel() != null) {
            _hashCode += getTemponaodisponivel().hashCode();
        }
        if (getTempoparadas() != null) {
            _hashCode += getTempoparadas().hashCode();
        }
        if (getTempoprodutivas() != null) {
            _hashCode += getTempoprodutivas().hashCode();
        }
        if (getTemporefugos() != null) {
            _hashCode += getTemporefugos().hashCode();
        }
        if (getTemporitmo() != null) {
            _hashCode += getTemporitmo().hashCode();
        }
        if (getTempototal() != null) {
            _hashCode += getTempototal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GraficoTempoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoTempoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoacurisoladas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoacurisoladas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempocicloimprodutivos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempocicloimprodutivos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temponaodisponivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temponaodisponivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoparadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoparadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoprodutivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoprodutivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temporefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temporefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temporitmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temporitmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempototal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempototal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
