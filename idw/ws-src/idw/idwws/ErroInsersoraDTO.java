/**
 * ErroInsersoraDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ErroInsersoraDTO  implements java.io.Serializable {
    private java.lang.String cabeca;

    private java.lang.String componente;

    private java.lang.String depara;

    private java.lang.String estagio;

    private java.lang.String feeder;

    private java.lang.String feederLado;

    private java.lang.String nozzle;

    private java.lang.String nozzlePosition;

    private java.lang.String qtErro;

    private java.lang.String tipoErro;

    public ErroInsersoraDTO() {
    }

    public ErroInsersoraDTO(
           java.lang.String cabeca,
           java.lang.String componente,
           java.lang.String depara,
           java.lang.String estagio,
           java.lang.String feeder,
           java.lang.String feederLado,
           java.lang.String nozzle,
           java.lang.String nozzlePosition,
           java.lang.String qtErro,
           java.lang.String tipoErro) {
           this.cabeca = cabeca;
           this.componente = componente;
           this.depara = depara;
           this.estagio = estagio;
           this.feeder = feeder;
           this.feederLado = feederLado;
           this.nozzle = nozzle;
           this.nozzlePosition = nozzlePosition;
           this.qtErro = qtErro;
           this.tipoErro = tipoErro;
    }


    /**
     * Gets the cabeca value for this ErroInsersoraDTO.
     * 
     * @return cabeca
     */
    public java.lang.String getCabeca() {
        return cabeca;
    }


    /**
     * Sets the cabeca value for this ErroInsersoraDTO.
     * 
     * @param cabeca
     */
    public void setCabeca(java.lang.String cabeca) {
        this.cabeca = cabeca;
    }


    /**
     * Gets the componente value for this ErroInsersoraDTO.
     * 
     * @return componente
     */
    public java.lang.String getComponente() {
        return componente;
    }


    /**
     * Sets the componente value for this ErroInsersoraDTO.
     * 
     * @param componente
     */
    public void setComponente(java.lang.String componente) {
        this.componente = componente;
    }


    /**
     * Gets the depara value for this ErroInsersoraDTO.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this ErroInsersoraDTO.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the estagio value for this ErroInsersoraDTO.
     * 
     * @return estagio
     */
    public java.lang.String getEstagio() {
        return estagio;
    }


    /**
     * Sets the estagio value for this ErroInsersoraDTO.
     * 
     * @param estagio
     */
    public void setEstagio(java.lang.String estagio) {
        this.estagio = estagio;
    }


    /**
     * Gets the feeder value for this ErroInsersoraDTO.
     * 
     * @return feeder
     */
    public java.lang.String getFeeder() {
        return feeder;
    }


    /**
     * Sets the feeder value for this ErroInsersoraDTO.
     * 
     * @param feeder
     */
    public void setFeeder(java.lang.String feeder) {
        this.feeder = feeder;
    }


    /**
     * Gets the feederLado value for this ErroInsersoraDTO.
     * 
     * @return feederLado
     */
    public java.lang.String getFeederLado() {
        return feederLado;
    }


    /**
     * Sets the feederLado value for this ErroInsersoraDTO.
     * 
     * @param feederLado
     */
    public void setFeederLado(java.lang.String feederLado) {
        this.feederLado = feederLado;
    }


    /**
     * Gets the nozzle value for this ErroInsersoraDTO.
     * 
     * @return nozzle
     */
    public java.lang.String getNozzle() {
        return nozzle;
    }


    /**
     * Sets the nozzle value for this ErroInsersoraDTO.
     * 
     * @param nozzle
     */
    public void setNozzle(java.lang.String nozzle) {
        this.nozzle = nozzle;
    }


    /**
     * Gets the nozzlePosition value for this ErroInsersoraDTO.
     * 
     * @return nozzlePosition
     */
    public java.lang.String getNozzlePosition() {
        return nozzlePosition;
    }


    /**
     * Sets the nozzlePosition value for this ErroInsersoraDTO.
     * 
     * @param nozzlePosition
     */
    public void setNozzlePosition(java.lang.String nozzlePosition) {
        this.nozzlePosition = nozzlePosition;
    }


    /**
     * Gets the qtErro value for this ErroInsersoraDTO.
     * 
     * @return qtErro
     */
    public java.lang.String getQtErro() {
        return qtErro;
    }


    /**
     * Sets the qtErro value for this ErroInsersoraDTO.
     * 
     * @param qtErro
     */
    public void setQtErro(java.lang.String qtErro) {
        this.qtErro = qtErro;
    }


    /**
     * Gets the tipoErro value for this ErroInsersoraDTO.
     * 
     * @return tipoErro
     */
    public java.lang.String getTipoErro() {
        return tipoErro;
    }


    /**
     * Sets the tipoErro value for this ErroInsersoraDTO.
     * 
     * @param tipoErro
     */
    public void setTipoErro(java.lang.String tipoErro) {
        this.tipoErro = tipoErro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ErroInsersoraDTO)) return false;
        ErroInsersoraDTO other = (ErroInsersoraDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cabeca==null && other.getCabeca()==null) || 
             (this.cabeca!=null &&
              this.cabeca.equals(other.getCabeca()))) &&
            ((this.componente==null && other.getComponente()==null) || 
             (this.componente!=null &&
              this.componente.equals(other.getComponente()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.estagio==null && other.getEstagio()==null) || 
             (this.estagio!=null &&
              this.estagio.equals(other.getEstagio()))) &&
            ((this.feeder==null && other.getFeeder()==null) || 
             (this.feeder!=null &&
              this.feeder.equals(other.getFeeder()))) &&
            ((this.feederLado==null && other.getFeederLado()==null) || 
             (this.feederLado!=null &&
              this.feederLado.equals(other.getFeederLado()))) &&
            ((this.nozzle==null && other.getNozzle()==null) || 
             (this.nozzle!=null &&
              this.nozzle.equals(other.getNozzle()))) &&
            ((this.nozzlePosition==null && other.getNozzlePosition()==null) || 
             (this.nozzlePosition!=null &&
              this.nozzlePosition.equals(other.getNozzlePosition()))) &&
            ((this.qtErro==null && other.getQtErro()==null) || 
             (this.qtErro!=null &&
              this.qtErro.equals(other.getQtErro()))) &&
            ((this.tipoErro==null && other.getTipoErro()==null) || 
             (this.tipoErro!=null &&
              this.tipoErro.equals(other.getTipoErro())));
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
        if (getCabeca() != null) {
            _hashCode += getCabeca().hashCode();
        }
        if (getComponente() != null) {
            _hashCode += getComponente().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getEstagio() != null) {
            _hashCode += getEstagio().hashCode();
        }
        if (getFeeder() != null) {
            _hashCode += getFeeder().hashCode();
        }
        if (getFeederLado() != null) {
            _hashCode += getFeederLado().hashCode();
        }
        if (getNozzle() != null) {
            _hashCode += getNozzle().hashCode();
        }
        if (getNozzlePosition() != null) {
            _hashCode += getNozzlePosition().hashCode();
        }
        if (getQtErro() != null) {
            _hashCode += getQtErro().hashCode();
        }
        if (getTipoErro() != null) {
            _hashCode += getTipoErro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ErroInsersoraDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "erroInsersoraDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cabeca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cabeca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "componente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estagio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estagio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feederLado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feederLado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nozzle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nozzle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nozzlePosition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nozzlePosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
