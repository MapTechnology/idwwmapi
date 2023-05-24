/**
 * OmCfgurl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmCfgurl  extends idw.idwws.OmCfgurlTemplate  implements java.io.Serializable {
    private java.lang.String dsUrl;

    private java.lang.Long idCfgurl;

    private idw.idwws.OmCfg omCfg;

    private java.lang.String urlConexao;

    public OmCfgurl() {
    }

    public OmCfgurl(
           java.lang.String dsUrl,
           java.lang.Long idCfgurl,
           idw.idwws.OmCfg omCfg,
           java.lang.String urlConexao) {
        this.dsUrl = dsUrl;
        this.idCfgurl = idCfgurl;
        this.omCfg = omCfg;
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the dsUrl value for this OmCfgurl.
     * 
     * @return dsUrl
     */
    public java.lang.String getDsUrl() {
        return dsUrl;
    }


    /**
     * Sets the dsUrl value for this OmCfgurl.
     * 
     * @param dsUrl
     */
    public void setDsUrl(java.lang.String dsUrl) {
        this.dsUrl = dsUrl;
    }


    /**
     * Gets the idCfgurl value for this OmCfgurl.
     * 
     * @return idCfgurl
     */
    public java.lang.Long getIdCfgurl() {
        return idCfgurl;
    }


    /**
     * Sets the idCfgurl value for this OmCfgurl.
     * 
     * @param idCfgurl
     */
    public void setIdCfgurl(java.lang.Long idCfgurl) {
        this.idCfgurl = idCfgurl;
    }


    /**
     * Gets the omCfg value for this OmCfgurl.
     * 
     * @return omCfg
     */
    public idw.idwws.OmCfg getOmCfg() {
        return omCfg;
    }


    /**
     * Sets the omCfg value for this OmCfgurl.
     * 
     * @param omCfg
     */
    public void setOmCfg(idw.idwws.OmCfg omCfg) {
        this.omCfg = omCfg;
    }


    /**
     * Gets the urlConexao value for this OmCfgurl.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this OmCfgurl.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmCfgurl)) return false;
        OmCfgurl other = (OmCfgurl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsUrl==null && other.getDsUrl()==null) || 
             (this.dsUrl!=null &&
              this.dsUrl.equals(other.getDsUrl()))) &&
            ((this.idCfgurl==null && other.getIdCfgurl()==null) || 
             (this.idCfgurl!=null &&
              this.idCfgurl.equals(other.getIdCfgurl()))) &&
            ((this.omCfg==null && other.getOmCfg()==null) || 
             (this.omCfg!=null &&
              this.omCfg.equals(other.getOmCfg()))) &&
            ((this.urlConexao==null && other.getUrlConexao()==null) || 
             (this.urlConexao!=null &&
              this.urlConexao.equals(other.getUrlConexao())));
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
        if (getDsUrl() != null) {
            _hashCode += getDsUrl().hashCode();
        }
        if (getIdCfgurl() != null) {
            _hashCode += getIdCfgurl().hashCode();
        }
        if (getOmCfg() != null) {
            _hashCode += getOmCfg().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmCfgurl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgurl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCfgurl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCfgurl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
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
