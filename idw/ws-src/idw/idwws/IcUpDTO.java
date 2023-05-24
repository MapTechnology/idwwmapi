/**
 * IcUpDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IcUpDTO  implements java.io.Serializable {
    private java.lang.String atributo;

    private idw.idwws.IcDTO ic;

    private java.lang.Integer idIcUp;

    private boolean isUpSendoTratada;

    private java.util.Calendar lastCicloDthr;

    private java.lang.Integer tpConexao;

    private idw.idwws.UpDTO upDTO;

    private java.lang.String urlAuxiliar;

    private java.lang.String urlConexao;

    private boolean isParada;

    public IcUpDTO() {
    }

    public IcUpDTO(
           java.lang.String atributo,
           idw.idwws.IcDTO ic,
           java.lang.Integer idIcUp,
           boolean isUpSendoTratada,
           java.util.Calendar lastCicloDthr,
           java.lang.Integer tpConexao,
           idw.idwws.UpDTO upDTO,
           java.lang.String urlAuxiliar,
           java.lang.String urlConexao,
           boolean isParada) {
           this.atributo = atributo;
           this.ic = ic;
           this.idIcUp = idIcUp;
           this.isUpSendoTratada = isUpSendoTratada;
           this.lastCicloDthr = lastCicloDthr;
           this.tpConexao = tpConexao;
           this.upDTO = upDTO;
           this.urlAuxiliar = urlAuxiliar;
           this.urlConexao = urlConexao;
           this.isParada = isParada;
    }


    /**
     * Gets the atributo value for this IcUpDTO.
     * 
     * @return atributo
     */
    public java.lang.String getAtributo() {
        return atributo;
    }


    /**
     * Sets the atributo value for this IcUpDTO.
     * 
     * @param atributo
     */
    public void setAtributo(java.lang.String atributo) {
        this.atributo = atributo;
    }


    /**
     * Gets the ic value for this IcUpDTO.
     * 
     * @return ic
     */
    public idw.idwws.IcDTO getIc() {
        return ic;
    }


    /**
     * Sets the ic value for this IcUpDTO.
     * 
     * @param ic
     */
    public void setIc(idw.idwws.IcDTO ic) {
        this.ic = ic;
    }


    /**
     * Gets the idIcUp value for this IcUpDTO.
     * 
     * @return idIcUp
     */
    public java.lang.Integer getIdIcUp() {
        return idIcUp;
    }


    /**
     * Sets the idIcUp value for this IcUpDTO.
     * 
     * @param idIcUp
     */
    public void setIdIcUp(java.lang.Integer idIcUp) {
        this.idIcUp = idIcUp;
    }


    /**
     * Gets the isUpSendoTratada value for this IcUpDTO.
     * 
     * @return isUpSendoTratada
     */
    public boolean isIsUpSendoTratada() {
        return isUpSendoTratada;
    }


    /**
     * Sets the isUpSendoTratada value for this IcUpDTO.
     * 
     * @param isUpSendoTratada
     */
    public void setIsUpSendoTratada(boolean isUpSendoTratada) {
        this.isUpSendoTratada = isUpSendoTratada;
    }


    /**
     * Gets the lastCicloDthr value for this IcUpDTO.
     * 
     * @return lastCicloDthr
     */
    public java.util.Calendar getLastCicloDthr() {
        return lastCicloDthr;
    }


    /**
     * Sets the lastCicloDthr value for this IcUpDTO.
     * 
     * @param lastCicloDthr
     */
    public void setLastCicloDthr(java.util.Calendar lastCicloDthr) {
        this.lastCicloDthr = lastCicloDthr;
    }


    /**
     * Gets the tpConexao value for this IcUpDTO.
     * 
     * @return tpConexao
     */
    public java.lang.Integer getTpConexao() {
        return tpConexao;
    }


    /**
     * Sets the tpConexao value for this IcUpDTO.
     * 
     * @param tpConexao
     */
    public void setTpConexao(java.lang.Integer tpConexao) {
        this.tpConexao = tpConexao;
    }


    /**
     * Gets the upDTO value for this IcUpDTO.
     * 
     * @return upDTO
     */
    public idw.idwws.UpDTO getUpDTO() {
        return upDTO;
    }


    /**
     * Sets the upDTO value for this IcUpDTO.
     * 
     * @param upDTO
     */
    public void setUpDTO(idw.idwws.UpDTO upDTO) {
        this.upDTO = upDTO;
    }


    /**
     * Gets the urlAuxiliar value for this IcUpDTO.
     * 
     * @return urlAuxiliar
     */
    public java.lang.String getUrlAuxiliar() {
        return urlAuxiliar;
    }


    /**
     * Sets the urlAuxiliar value for this IcUpDTO.
     * 
     * @param urlAuxiliar
     */
    public void setUrlAuxiliar(java.lang.String urlAuxiliar) {
        this.urlAuxiliar = urlAuxiliar;
    }


    /**
     * Gets the urlConexao value for this IcUpDTO.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this IcUpDTO.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the isParada value for this IcUpDTO.
     * 
     * @return isParada
     */
    public boolean isIsParada() {
        return isParada;
    }


    /**
     * Sets the isParada value for this IcUpDTO.
     * 
     * @param isParada
     */
    public void setIsParada(boolean isParada) {
        this.isParada = isParada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IcUpDTO)) return false;
        IcUpDTO other = (IcUpDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.atributo==null && other.getAtributo()==null) || 
             (this.atributo!=null &&
              this.atributo.equals(other.getAtributo()))) &&
            ((this.ic==null && other.getIc()==null) || 
             (this.ic!=null &&
              this.ic.equals(other.getIc()))) &&
            ((this.idIcUp==null && other.getIdIcUp()==null) || 
             (this.idIcUp!=null &&
              this.idIcUp.equals(other.getIdIcUp()))) &&
            this.isUpSendoTratada == other.isIsUpSendoTratada() &&
            ((this.lastCicloDthr==null && other.getLastCicloDthr()==null) || 
             (this.lastCicloDthr!=null &&
              this.lastCicloDthr.equals(other.getLastCicloDthr()))) &&
            ((this.tpConexao==null && other.getTpConexao()==null) || 
             (this.tpConexao!=null &&
              this.tpConexao.equals(other.getTpConexao()))) &&
            ((this.upDTO==null && other.getUpDTO()==null) || 
             (this.upDTO!=null &&
              this.upDTO.equals(other.getUpDTO()))) &&
            ((this.urlAuxiliar==null && other.getUrlAuxiliar()==null) || 
             (this.urlAuxiliar!=null &&
              this.urlAuxiliar.equals(other.getUrlAuxiliar()))) &&
            ((this.urlConexao==null && other.getUrlConexao()==null) || 
             (this.urlConexao!=null &&
              this.urlConexao.equals(other.getUrlConexao()))) &&
            this.isParada == other.isIsParada();
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
        if (getAtributo() != null) {
            _hashCode += getAtributo().hashCode();
        }
        if (getIc() != null) {
            _hashCode += getIc().hashCode();
        }
        if (getIdIcUp() != null) {
            _hashCode += getIdIcUp().hashCode();
        }
        _hashCode += (isIsUpSendoTratada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLastCicloDthr() != null) {
            _hashCode += getLastCicloDthr().hashCode();
        }
        if (getTpConexao() != null) {
            _hashCode += getTpConexao().hashCode();
        }
        if (getUpDTO() != null) {
            _hashCode += getUpDTO().hashCode();
        }
        if (getUrlAuxiliar() != null) {
            _hashCode += getUrlAuxiliar().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        _hashCode += (isIsParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IcUpDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "icUpDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("atributo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "atributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "icDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIcUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIcUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isUpSendoTratada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isUpSendoTratada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastCicloDthr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastCicloDthr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "upDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlAuxiliar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlAuxiliar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
