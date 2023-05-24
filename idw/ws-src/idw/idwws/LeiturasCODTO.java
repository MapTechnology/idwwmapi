/**
 * LeiturasCODTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class LeiturasCODTO  implements java.io.Serializable {
    private java.lang.String cdMaquina;

    private long idAlim;

    private java.lang.String isExclusividade;

    private idw.idwws.LeituraCODTO[] leituras;

    private idw.idwws.MapaCODTO mapa;

    private long minDtHrLeitura;

    private byte status;

    private byte tpLeitura;

    private idw.idwws.UsuarioCODTO usuario;

    public LeiturasCODTO() {
    }

    public LeiturasCODTO(
           java.lang.String cdMaquina,
           long idAlim,
           java.lang.String isExclusividade,
           idw.idwws.LeituraCODTO[] leituras,
           idw.idwws.MapaCODTO mapa,
           long minDtHrLeitura,
           byte status,
           byte tpLeitura,
           idw.idwws.UsuarioCODTO usuario) {
           this.cdMaquina = cdMaquina;
           this.idAlim = idAlim;
           this.isExclusividade = isExclusividade;
           this.leituras = leituras;
           this.mapa = mapa;
           this.minDtHrLeitura = minDtHrLeitura;
           this.status = status;
           this.tpLeitura = tpLeitura;
           this.usuario = usuario;
    }


    /**
     * Gets the cdMaquina value for this LeiturasCODTO.
     * 
     * @return cdMaquina
     */
    public java.lang.String getCdMaquina() {
        return cdMaquina;
    }


    /**
     * Sets the cdMaquina value for this LeiturasCODTO.
     * 
     * @param cdMaquina
     */
    public void setCdMaquina(java.lang.String cdMaquina) {
        this.cdMaquina = cdMaquina;
    }


    /**
     * Gets the idAlim value for this LeiturasCODTO.
     * 
     * @return idAlim
     */
    public long getIdAlim() {
        return idAlim;
    }


    /**
     * Sets the idAlim value for this LeiturasCODTO.
     * 
     * @param idAlim
     */
    public void setIdAlim(long idAlim) {
        this.idAlim = idAlim;
    }


    /**
     * Gets the isExclusividade value for this LeiturasCODTO.
     * 
     * @return isExclusividade
     */
    public java.lang.String getIsExclusividade() {
        return isExclusividade;
    }


    /**
     * Sets the isExclusividade value for this LeiturasCODTO.
     * 
     * @param isExclusividade
     */
    public void setIsExclusividade(java.lang.String isExclusividade) {
        this.isExclusividade = isExclusividade;
    }


    /**
     * Gets the leituras value for this LeiturasCODTO.
     * 
     * @return leituras
     */
    public idw.idwws.LeituraCODTO[] getLeituras() {
        return leituras;
    }


    /**
     * Sets the leituras value for this LeiturasCODTO.
     * 
     * @param leituras
     */
    public void setLeituras(idw.idwws.LeituraCODTO[] leituras) {
        this.leituras = leituras;
    }

    public idw.idwws.LeituraCODTO getLeituras(int i) {
        return this.leituras[i];
    }

    public void setLeituras(int i, idw.idwws.LeituraCODTO _value) {
        this.leituras[i] = _value;
    }


    /**
     * Gets the mapa value for this LeiturasCODTO.
     * 
     * @return mapa
     */
    public idw.idwws.MapaCODTO getMapa() {
        return mapa;
    }


    /**
     * Sets the mapa value for this LeiturasCODTO.
     * 
     * @param mapa
     */
    public void setMapa(idw.idwws.MapaCODTO mapa) {
        this.mapa = mapa;
    }


    /**
     * Gets the minDtHrLeitura value for this LeiturasCODTO.
     * 
     * @return minDtHrLeitura
     */
    public long getMinDtHrLeitura() {
        return minDtHrLeitura;
    }


    /**
     * Sets the minDtHrLeitura value for this LeiturasCODTO.
     * 
     * @param minDtHrLeitura
     */
    public void setMinDtHrLeitura(long minDtHrLeitura) {
        this.minDtHrLeitura = minDtHrLeitura;
    }


    /**
     * Gets the status value for this LeiturasCODTO.
     * 
     * @return status
     */
    public byte getStatus() {
        return status;
    }


    /**
     * Sets the status value for this LeiturasCODTO.
     * 
     * @param status
     */
    public void setStatus(byte status) {
        this.status = status;
    }


    /**
     * Gets the tpLeitura value for this LeiturasCODTO.
     * 
     * @return tpLeitura
     */
    public byte getTpLeitura() {
        return tpLeitura;
    }


    /**
     * Sets the tpLeitura value for this LeiturasCODTO.
     * 
     * @param tpLeitura
     */
    public void setTpLeitura(byte tpLeitura) {
        this.tpLeitura = tpLeitura;
    }


    /**
     * Gets the usuario value for this LeiturasCODTO.
     * 
     * @return usuario
     */
    public idw.idwws.UsuarioCODTO getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this LeiturasCODTO.
     * 
     * @param usuario
     */
    public void setUsuario(idw.idwws.UsuarioCODTO usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LeiturasCODTO)) return false;
        LeiturasCODTO other = (LeiturasCODTO) obj;
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
            this.idAlim == other.getIdAlim() &&
            ((this.isExclusividade==null && other.getIsExclusividade()==null) || 
             (this.isExclusividade!=null &&
              this.isExclusividade.equals(other.getIsExclusividade()))) &&
            ((this.leituras==null && other.getLeituras()==null) || 
             (this.leituras!=null &&
              java.util.Arrays.equals(this.leituras, other.getLeituras()))) &&
            ((this.mapa==null && other.getMapa()==null) || 
             (this.mapa!=null &&
              this.mapa.equals(other.getMapa()))) &&
            this.minDtHrLeitura == other.getMinDtHrLeitura() &&
            this.status == other.getStatus() &&
            this.tpLeitura == other.getTpLeitura() &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
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
        _hashCode += new Long(getIdAlim()).hashCode();
        if (getIsExclusividade() != null) {
            _hashCode += getIsExclusividade().hashCode();
        }
        if (getLeituras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLeituras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLeituras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMapa() != null) {
            _hashCode += getMapa().hashCode();
        }
        _hashCode += new Long(getMinDtHrLeitura()).hashCode();
        _hashCode += getStatus();
        _hashCode += getTpLeitura();
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LeiturasCODTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "leiturasCODTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAlim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isExclusividade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isExclusividade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leituras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leituras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "leituraCODTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaCODTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minDtHrLeitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minDtHrLeitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpLeitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpLeitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "usuarioCODTO"));
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
