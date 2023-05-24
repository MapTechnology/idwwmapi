/**
 * OmObjDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmObjDTO  extends idw.idwws.OmObj  implements java.io.Serializable {
    private java.lang.Double ec;

    private java.lang.Double er;

    private boolean foraMeta;

    private java.lang.String identificacao;

    private java.lang.Double ip;

    private boolean offline;

    private boolean parada;

    private java.lang.Integer segCicloPadrao;

    private java.lang.Integer segTempoRotatividadeEstoque;

    public OmObjDTO() {
    }

    public OmObjDTO(
           byte TIPO_OBJ_CIRCULO,
           byte TIPO_OBJ_ESTOQUE,
           byte TIPO_OBJ_FOLHA,
           byte TIPO_OBJ_GT,
           byte TIPO_OBJ_IMAGEM,
           byte TIPO_OBJ_PT,
           byte TIPO_OBJ_RETANGULO,
           byte TIPO_OBJ_RETA_SETA_1,
           byte TIPO_OBJ_RETA_SETA_1_2,
           byte TIPO_OBJ_RETA_SETA_2,
           byte TIPO_OBJ_TEXTO,
           java.lang.String corFrente,
           java.lang.String corFundo,
           idw.idwws.DwEst dwEstByIdEst,
           idw.idwws.DwFolha dwFolhaByIdFolha,
           idw.idwws.DwRota dwRotaByIdRota,
           idw.idwws.DwRotapasso dwRotapasso,
           java.lang.Long idObj,
           java.lang.Byte monitoracao,
           idw.idwws.OmGt omGtByIdGt,
           idw.idwws.OmGt omGtByIdGtfilho,
           idw.idwws.OmImg omImg,
           idw.idwws.OmObj omObjByIdObjdestino,
           idw.idwws.OmObj omObjByIdObjorigem,
           idw.idwws.OmPt omPt,
           idw.idwws.OmTexto omTexto,
           idw.idwws.OmWebcam omWebcam,
           java.lang.Byte tpObj,
           java.math.BigDecimal x,
           java.math.BigDecimal x2,
           java.math.BigDecimal y,
           java.math.BigDecimal y2,
           java.lang.Double ec,
           java.lang.Double er,
           boolean foraMeta,
           java.lang.String identificacao,
           java.lang.Double ip,
           boolean offline,
           boolean parada,
           java.lang.Integer segCicloPadrao,
           java.lang.Integer segTempoRotatividadeEstoque) {
        super(
            TIPO_OBJ_CIRCULO,
            TIPO_OBJ_ESTOQUE,
            TIPO_OBJ_FOLHA,
            TIPO_OBJ_GT,
            TIPO_OBJ_IMAGEM,
            TIPO_OBJ_PT,
            TIPO_OBJ_RETANGULO,
            TIPO_OBJ_RETA_SETA_1,
            TIPO_OBJ_RETA_SETA_1_2,
            TIPO_OBJ_RETA_SETA_2,
            TIPO_OBJ_TEXTO,
            corFrente,
            corFundo,
            dwEstByIdEst,
            dwFolhaByIdFolha,
            dwRotaByIdRota,
            dwRotapasso,
            idObj,
            monitoracao,
            omGtByIdGt,
            omGtByIdGtfilho,
            omImg,
            omObjByIdObjdestino,
            omObjByIdObjorigem,
            omPt,
            omTexto,
            omWebcam,
            tpObj,
            x,
            x2,
            y,
            y2);
        this.ec = ec;
        this.er = er;
        this.foraMeta = foraMeta;
        this.identificacao = identificacao;
        this.ip = ip;
        this.offline = offline;
        this.parada = parada;
        this.segCicloPadrao = segCicloPadrao;
        this.segTempoRotatividadeEstoque = segTempoRotatividadeEstoque;
    }


    /**
     * Gets the ec value for this OmObjDTO.
     * 
     * @return ec
     */
    public java.lang.Double getEc() {
        return ec;
    }


    /**
     * Sets the ec value for this OmObjDTO.
     * 
     * @param ec
     */
    public void setEc(java.lang.Double ec) {
        this.ec = ec;
    }


    /**
     * Gets the er value for this OmObjDTO.
     * 
     * @return er
     */
    public java.lang.Double getEr() {
        return er;
    }


    /**
     * Sets the er value for this OmObjDTO.
     * 
     * @param er
     */
    public void setEr(java.lang.Double er) {
        this.er = er;
    }


    /**
     * Gets the foraMeta value for this OmObjDTO.
     * 
     * @return foraMeta
     */
    public boolean isForaMeta() {
        return foraMeta;
    }


    /**
     * Sets the foraMeta value for this OmObjDTO.
     * 
     * @param foraMeta
     */
    public void setForaMeta(boolean foraMeta) {
        this.foraMeta = foraMeta;
    }


    /**
     * Gets the identificacao value for this OmObjDTO.
     * 
     * @return identificacao
     */
    public java.lang.String getIdentificacao() {
        return identificacao;
    }


    /**
     * Sets the identificacao value for this OmObjDTO.
     * 
     * @param identificacao
     */
    public void setIdentificacao(java.lang.String identificacao) {
        this.identificacao = identificacao;
    }


    /**
     * Gets the ip value for this OmObjDTO.
     * 
     * @return ip
     */
    public java.lang.Double getIp() {
        return ip;
    }


    /**
     * Sets the ip value for this OmObjDTO.
     * 
     * @param ip
     */
    public void setIp(java.lang.Double ip) {
        this.ip = ip;
    }


    /**
     * Gets the offline value for this OmObjDTO.
     * 
     * @return offline
     */
    public boolean isOffline() {
        return offline;
    }


    /**
     * Sets the offline value for this OmObjDTO.
     * 
     * @param offline
     */
    public void setOffline(boolean offline) {
        this.offline = offline;
    }


    /**
     * Gets the parada value for this OmObjDTO.
     * 
     * @return parada
     */
    public boolean isParada() {
        return parada;
    }


    /**
     * Sets the parada value for this OmObjDTO.
     * 
     * @param parada
     */
    public void setParada(boolean parada) {
        this.parada = parada;
    }


    /**
     * Gets the segCicloPadrao value for this OmObjDTO.
     * 
     * @return segCicloPadrao
     */
    public java.lang.Integer getSegCicloPadrao() {
        return segCicloPadrao;
    }


    /**
     * Sets the segCicloPadrao value for this OmObjDTO.
     * 
     * @param segCicloPadrao
     */
    public void setSegCicloPadrao(java.lang.Integer segCicloPadrao) {
        this.segCicloPadrao = segCicloPadrao;
    }


    /**
     * Gets the segTempoRotatividadeEstoque value for this OmObjDTO.
     * 
     * @return segTempoRotatividadeEstoque
     */
    public java.lang.Integer getSegTempoRotatividadeEstoque() {
        return segTempoRotatividadeEstoque;
    }


    /**
     * Sets the segTempoRotatividadeEstoque value for this OmObjDTO.
     * 
     * @param segTempoRotatividadeEstoque
     */
    public void setSegTempoRotatividadeEstoque(java.lang.Integer segTempoRotatividadeEstoque) {
        this.segTempoRotatividadeEstoque = segTempoRotatividadeEstoque;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmObjDTO)) return false;
        OmObjDTO other = (OmObjDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ec==null && other.getEc()==null) || 
             (this.ec!=null &&
              this.ec.equals(other.getEc()))) &&
            ((this.er==null && other.getEr()==null) || 
             (this.er!=null &&
              this.er.equals(other.getEr()))) &&
            this.foraMeta == other.isForaMeta() &&
            ((this.identificacao==null && other.getIdentificacao()==null) || 
             (this.identificacao!=null &&
              this.identificacao.equals(other.getIdentificacao()))) &&
            ((this.ip==null && other.getIp()==null) || 
             (this.ip!=null &&
              this.ip.equals(other.getIp()))) &&
            this.offline == other.isOffline() &&
            this.parada == other.isParada() &&
            ((this.segCicloPadrao==null && other.getSegCicloPadrao()==null) || 
             (this.segCicloPadrao!=null &&
              this.segCicloPadrao.equals(other.getSegCicloPadrao()))) &&
            ((this.segTempoRotatividadeEstoque==null && other.getSegTempoRotatividadeEstoque()==null) || 
             (this.segTempoRotatividadeEstoque!=null &&
              this.segTempoRotatividadeEstoque.equals(other.getSegTempoRotatividadeEstoque())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getEc() != null) {
            _hashCode += getEc().hashCode();
        }
        if (getEr() != null) {
            _hashCode += getEr().hashCode();
        }
        _hashCode += (isForaMeta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIdentificacao() != null) {
            _hashCode += getIdentificacao().hashCode();
        }
        if (getIp() != null) {
            _hashCode += getIp().hashCode();
        }
        _hashCode += (isOffline() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSegCicloPadrao() != null) {
            _hashCode += getSegCicloPadrao().hashCode();
        }
        if (getSegTempoRotatividadeEstoque() != null) {
            _hashCode += getSegTempoRotatividadeEstoque().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmObjDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObjDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("er");
        elemField.setXmlName(new javax.xml.namespace.QName("", "er"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foraMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foraMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "identificacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempoRotatividadeEstoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempoRotatividadeEstoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
