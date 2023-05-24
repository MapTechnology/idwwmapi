/**
 * AcaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class AcaoDTO  implements java.io.Serializable {
    private java.lang.String cb;

    private idw.idwws.ComponenteDTO componente;

    private idw.idwws.DefeitoDTO defeito;

    private long idPt;

    private long idTAcao;

    private long idTppt;

    private idw.idwws.ResultadoDTO resultado;

    public AcaoDTO() {
    }

    public AcaoDTO(
           java.lang.String cb,
           idw.idwws.ComponenteDTO componente,
           idw.idwws.DefeitoDTO defeito,
           long idPt,
           long idTAcao,
           long idTppt,
           idw.idwws.ResultadoDTO resultado) {
           this.cb = cb;
           this.componente = componente;
           this.defeito = defeito;
           this.idPt = idPt;
           this.idTAcao = idTAcao;
           this.idTppt = idTppt;
           this.resultado = resultado;
    }


    /**
     * Gets the cb value for this AcaoDTO.
     * 
     * @return cb
     */
    public java.lang.String getCb() {
        return cb;
    }


    /**
     * Sets the cb value for this AcaoDTO.
     * 
     * @param cb
     */
    public void setCb(java.lang.String cb) {
        this.cb = cb;
    }


    /**
     * Gets the componente value for this AcaoDTO.
     * 
     * @return componente
     */
    public idw.idwws.ComponenteDTO getComponente() {
        return componente;
    }


    /**
     * Sets the componente value for this AcaoDTO.
     * 
     * @param componente
     */
    public void setComponente(idw.idwws.ComponenteDTO componente) {
        this.componente = componente;
    }


    /**
     * Gets the defeito value for this AcaoDTO.
     * 
     * @return defeito
     */
    public idw.idwws.DefeitoDTO getDefeito() {
        return defeito;
    }


    /**
     * Sets the defeito value for this AcaoDTO.
     * 
     * @param defeito
     */
    public void setDefeito(idw.idwws.DefeitoDTO defeito) {
        this.defeito = defeito;
    }


    /**
     * Gets the idPt value for this AcaoDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this AcaoDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idTAcao value for this AcaoDTO.
     * 
     * @return idTAcao
     */
    public long getIdTAcao() {
        return idTAcao;
    }


    /**
     * Sets the idTAcao value for this AcaoDTO.
     * 
     * @param idTAcao
     */
    public void setIdTAcao(long idTAcao) {
        this.idTAcao = idTAcao;
    }


    /**
     * Gets the idTppt value for this AcaoDTO.
     * 
     * @return idTppt
     */
    public long getIdTppt() {
        return idTppt;
    }


    /**
     * Sets the idTppt value for this AcaoDTO.
     * 
     * @param idTppt
     */
    public void setIdTppt(long idTppt) {
        this.idTppt = idTppt;
    }


    /**
     * Gets the resultado value for this AcaoDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this AcaoDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcaoDTO)) return false;
        AcaoDTO other = (AcaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cb==null && other.getCb()==null) || 
             (this.cb!=null &&
              this.cb.equals(other.getCb()))) &&
            ((this.componente==null && other.getComponente()==null) || 
             (this.componente!=null &&
              this.componente.equals(other.getComponente()))) &&
            ((this.defeito==null && other.getDefeito()==null) || 
             (this.defeito!=null &&
              this.defeito.equals(other.getDefeito()))) &&
            this.idPt == other.getIdPt() &&
            this.idTAcao == other.getIdTAcao() &&
            this.idTppt == other.getIdTppt() &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado())));
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
        if (getCb() != null) {
            _hashCode += getCb().hashCode();
        }
        if (getComponente() != null) {
            _hashCode += getComponente().hashCode();
        }
        if (getDefeito() != null) {
            _hashCode += getDefeito().hashCode();
        }
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdTAcao()).hashCode();
        _hashCode += new Long(getIdTppt()).hashCode();
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "acaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "componente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "componenteDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defeito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "defeitoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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
