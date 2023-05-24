/**
 * TrocaOPInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TrocaOPInjetDTO  implements java.io.Serializable {
    private java.lang.String cdMaquina;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.lang.String nropEntrando;

    private java.lang.String nropSaindo;

    private java.math.BigDecimal tempoPlanejadoSetup;

    private java.math.BigDecimal tempoRealSetup;

    public TrocaOPInjetDTO() {
    }

    public TrocaOPInjetDTO(
           java.lang.String cdMaquina,
           idw.idwws.Ijtbinj ijtbinj,
           java.lang.String nropEntrando,
           java.lang.String nropSaindo,
           java.math.BigDecimal tempoPlanejadoSetup,
           java.math.BigDecimal tempoRealSetup) {
           this.cdMaquina = cdMaquina;
           this.ijtbinj = ijtbinj;
           this.nropEntrando = nropEntrando;
           this.nropSaindo = nropSaindo;
           this.tempoPlanejadoSetup = tempoPlanejadoSetup;
           this.tempoRealSetup = tempoRealSetup;
    }


    /**
     * Gets the cdMaquina value for this TrocaOPInjetDTO.
     * 
     * @return cdMaquina
     */
    public java.lang.String getCdMaquina() {
        return cdMaquina;
    }


    /**
     * Sets the cdMaquina value for this TrocaOPInjetDTO.
     * 
     * @param cdMaquina
     */
    public void setCdMaquina(java.lang.String cdMaquina) {
        this.cdMaquina = cdMaquina;
    }


    /**
     * Gets the ijtbinj value for this TrocaOPInjetDTO.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this TrocaOPInjetDTO.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the nropEntrando value for this TrocaOPInjetDTO.
     * 
     * @return nropEntrando
     */
    public java.lang.String getNropEntrando() {
        return nropEntrando;
    }


    /**
     * Sets the nropEntrando value for this TrocaOPInjetDTO.
     * 
     * @param nropEntrando
     */
    public void setNropEntrando(java.lang.String nropEntrando) {
        this.nropEntrando = nropEntrando;
    }


    /**
     * Gets the nropSaindo value for this TrocaOPInjetDTO.
     * 
     * @return nropSaindo
     */
    public java.lang.String getNropSaindo() {
        return nropSaindo;
    }


    /**
     * Sets the nropSaindo value for this TrocaOPInjetDTO.
     * 
     * @param nropSaindo
     */
    public void setNropSaindo(java.lang.String nropSaindo) {
        this.nropSaindo = nropSaindo;
    }


    /**
     * Gets the tempoPlanejadoSetup value for this TrocaOPInjetDTO.
     * 
     * @return tempoPlanejadoSetup
     */
    public java.math.BigDecimal getTempoPlanejadoSetup() {
        return tempoPlanejadoSetup;
    }


    /**
     * Sets the tempoPlanejadoSetup value for this TrocaOPInjetDTO.
     * 
     * @param tempoPlanejadoSetup
     */
    public void setTempoPlanejadoSetup(java.math.BigDecimal tempoPlanejadoSetup) {
        this.tempoPlanejadoSetup = tempoPlanejadoSetup;
    }


    /**
     * Gets the tempoRealSetup value for this TrocaOPInjetDTO.
     * 
     * @return tempoRealSetup
     */
    public java.math.BigDecimal getTempoRealSetup() {
        return tempoRealSetup;
    }


    /**
     * Sets the tempoRealSetup value for this TrocaOPInjetDTO.
     * 
     * @param tempoRealSetup
     */
    public void setTempoRealSetup(java.math.BigDecimal tempoRealSetup) {
        this.tempoRealSetup = tempoRealSetup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TrocaOPInjetDTO)) return false;
        TrocaOPInjetDTO other = (TrocaOPInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdMaquina==null && other.getCdMaquina()==null) || 
             (this.cdMaquina!=null &&
              this.cdMaquina.equals(other.getCdMaquina()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.nropEntrando==null && other.getNropEntrando()==null) || 
             (this.nropEntrando!=null &&
              this.nropEntrando.equals(other.getNropEntrando()))) &&
            ((this.nropSaindo==null && other.getNropSaindo()==null) || 
             (this.nropSaindo!=null &&
              this.nropSaindo.equals(other.getNropSaindo()))) &&
            ((this.tempoPlanejadoSetup==null && other.getTempoPlanejadoSetup()==null) || 
             (this.tempoPlanejadoSetup!=null &&
              this.tempoPlanejadoSetup.equals(other.getTempoPlanejadoSetup()))) &&
            ((this.tempoRealSetup==null && other.getTempoRealSetup()==null) || 
             (this.tempoRealSetup!=null &&
              this.tempoRealSetup.equals(other.getTempoRealSetup())));
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
        if (getCdMaquina() != null) {
            _hashCode += getCdMaquina().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getNropEntrando() != null) {
            _hashCode += getNropEntrando().hashCode();
        }
        if (getNropSaindo() != null) {
            _hashCode += getNropSaindo().hashCode();
        }
        if (getTempoPlanejadoSetup() != null) {
            _hashCode += getTempoPlanejadoSetup().hashCode();
        }
        if (getTempoRealSetup() != null) {
            _hashCode += getTempoRealSetup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TrocaOPInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "trocaOPInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropEntrando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropEntrando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropSaindo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropSaindo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoPlanejadoSetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoPlanejadoSetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoRealSetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoRealSetup"));
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
