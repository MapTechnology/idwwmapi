/**
 * DefeitoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DefeitoDTO  implements java.io.Serializable {
    private java.lang.String cb;

    private long idNserie;

    private long idPassagem;

    private long idPassdef;

    private long idPt;

    private long idTAcao;

    private long idTDefeito;

    private long idTppt;

    private idw.idwws.ResultadoDTO resultado;

    public DefeitoDTO() {
    }

    public DefeitoDTO(
           java.lang.String cb,
           long idNserie,
           long idPassagem,
           long idPassdef,
           long idPt,
           long idTAcao,
           long idTDefeito,
           long idTppt,
           idw.idwws.ResultadoDTO resultado) {
           this.cb = cb;
           this.idNserie = idNserie;
           this.idPassagem = idPassagem;
           this.idPassdef = idPassdef;
           this.idPt = idPt;
           this.idTAcao = idTAcao;
           this.idTDefeito = idTDefeito;
           this.idTppt = idTppt;
           this.resultado = resultado;
    }


    /**
     * Gets the cb value for this DefeitoDTO.
     * 
     * @return cb
     */
    public java.lang.String getCb() {
        return cb;
    }


    /**
     * Sets the cb value for this DefeitoDTO.
     * 
     * @param cb
     */
    public void setCb(java.lang.String cb) {
        this.cb = cb;
    }


    /**
     * Gets the idNserie value for this DefeitoDTO.
     * 
     * @return idNserie
     */
    public long getIdNserie() {
        return idNserie;
    }


    /**
     * Sets the idNserie value for this DefeitoDTO.
     * 
     * @param idNserie
     */
    public void setIdNserie(long idNserie) {
        this.idNserie = idNserie;
    }


    /**
     * Gets the idPassagem value for this DefeitoDTO.
     * 
     * @return idPassagem
     */
    public long getIdPassagem() {
        return idPassagem;
    }


    /**
     * Sets the idPassagem value for this DefeitoDTO.
     * 
     * @param idPassagem
     */
    public void setIdPassagem(long idPassagem) {
        this.idPassagem = idPassagem;
    }


    /**
     * Gets the idPassdef value for this DefeitoDTO.
     * 
     * @return idPassdef
     */
    public long getIdPassdef() {
        return idPassdef;
    }


    /**
     * Sets the idPassdef value for this DefeitoDTO.
     * 
     * @param idPassdef
     */
    public void setIdPassdef(long idPassdef) {
        this.idPassdef = idPassdef;
    }


    /**
     * Gets the idPt value for this DefeitoDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this DefeitoDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idTAcao value for this DefeitoDTO.
     * 
     * @return idTAcao
     */
    public long getIdTAcao() {
        return idTAcao;
    }


    /**
     * Sets the idTAcao value for this DefeitoDTO.
     * 
     * @param idTAcao
     */
    public void setIdTAcao(long idTAcao) {
        this.idTAcao = idTAcao;
    }


    /**
     * Gets the idTDefeito value for this DefeitoDTO.
     * 
     * @return idTDefeito
     */
    public long getIdTDefeito() {
        return idTDefeito;
    }


    /**
     * Sets the idTDefeito value for this DefeitoDTO.
     * 
     * @param idTDefeito
     */
    public void setIdTDefeito(long idTDefeito) {
        this.idTDefeito = idTDefeito;
    }


    /**
     * Gets the idTppt value for this DefeitoDTO.
     * 
     * @return idTppt
     */
    public long getIdTppt() {
        return idTppt;
    }


    /**
     * Sets the idTppt value for this DefeitoDTO.
     * 
     * @param idTppt
     */
    public void setIdTppt(long idTppt) {
        this.idTppt = idTppt;
    }


    /**
     * Gets the resultado value for this DefeitoDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this DefeitoDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DefeitoDTO)) return false;
        DefeitoDTO other = (DefeitoDTO) obj;
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
            this.idNserie == other.getIdNserie() &&
            this.idPassagem == other.getIdPassagem() &&
            this.idPassdef == other.getIdPassdef() &&
            this.idPt == other.getIdPt() &&
            this.idTAcao == other.getIdTAcao() &&
            this.idTDefeito == other.getIdTDefeito() &&
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
        _hashCode += new Long(getIdNserie()).hashCode();
        _hashCode += new Long(getIdPassagem()).hashCode();
        _hashCode += new Long(getIdPassdef()).hashCode();
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdTAcao()).hashCode();
        _hashCode += new Long(getIdTDefeito()).hashCode();
        _hashCode += new Long(getIdTppt()).hashCode();
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DefeitoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "defeitoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNserie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNserie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPassdef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPassdef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("idTDefeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTDefeito"));
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
