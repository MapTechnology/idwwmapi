/**
 * MsUpihm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsUpihm  extends idw.idwws.MsUpihmTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrCadastro;

    private java.math.BigDecimal idUpihm;

    private idw.idwws.MsEvt[] msEvts;

    private idw.idwws.MsIhm msIhm;

    private idw.idwws.MsUp msUp;

    private java.lang.String urlConexao;

    public MsUpihm() {
    }

    public MsUpihm(
           java.util.Calendar dthrCadastro,
           java.math.BigDecimal idUpihm,
           idw.idwws.MsEvt[] msEvts,
           idw.idwws.MsIhm msIhm,
           idw.idwws.MsUp msUp,
           java.lang.String urlConexao) {
        this.dthrCadastro = dthrCadastro;
        this.idUpihm = idUpihm;
        this.msEvts = msEvts;
        this.msIhm = msIhm;
        this.msUp = msUp;
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the dthrCadastro value for this MsUpihm.
     * 
     * @return dthrCadastro
     */
    public java.util.Calendar getDthrCadastro() {
        return dthrCadastro;
    }


    /**
     * Sets the dthrCadastro value for this MsUpihm.
     * 
     * @param dthrCadastro
     */
    public void setDthrCadastro(java.util.Calendar dthrCadastro) {
        this.dthrCadastro = dthrCadastro;
    }


    /**
     * Gets the idUpihm value for this MsUpihm.
     * 
     * @return idUpihm
     */
    public java.math.BigDecimal getIdUpihm() {
        return idUpihm;
    }


    /**
     * Sets the idUpihm value for this MsUpihm.
     * 
     * @param idUpihm
     */
    public void setIdUpihm(java.math.BigDecimal idUpihm) {
        this.idUpihm = idUpihm;
    }


    /**
     * Gets the msEvts value for this MsUpihm.
     * 
     * @return msEvts
     */
    public idw.idwws.MsEvt[] getMsEvts() {
        return msEvts;
    }


    /**
     * Sets the msEvts value for this MsUpihm.
     * 
     * @param msEvts
     */
    public void setMsEvts(idw.idwws.MsEvt[] msEvts) {
        this.msEvts = msEvts;
    }

    public idw.idwws.MsEvt getMsEvts(int i) {
        return this.msEvts[i];
    }

    public void setMsEvts(int i, idw.idwws.MsEvt _value) {
        this.msEvts[i] = _value;
    }


    /**
     * Gets the msIhm value for this MsUpihm.
     * 
     * @return msIhm
     */
    public idw.idwws.MsIhm getMsIhm() {
        return msIhm;
    }


    /**
     * Sets the msIhm value for this MsUpihm.
     * 
     * @param msIhm
     */
    public void setMsIhm(idw.idwws.MsIhm msIhm) {
        this.msIhm = msIhm;
    }


    /**
     * Gets the msUp value for this MsUpihm.
     * 
     * @return msUp
     */
    public idw.idwws.MsUp getMsUp() {
        return msUp;
    }


    /**
     * Sets the msUp value for this MsUpihm.
     * 
     * @param msUp
     */
    public void setMsUp(idw.idwws.MsUp msUp) {
        this.msUp = msUp;
    }


    /**
     * Gets the urlConexao value for this MsUpihm.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this MsUpihm.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsUpihm)) return false;
        MsUpihm other = (MsUpihm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrCadastro==null && other.getDthrCadastro()==null) || 
             (this.dthrCadastro!=null &&
              this.dthrCadastro.equals(other.getDthrCadastro()))) &&
            ((this.idUpihm==null && other.getIdUpihm()==null) || 
             (this.idUpihm!=null &&
              this.idUpihm.equals(other.getIdUpihm()))) &&
            ((this.msEvts==null && other.getMsEvts()==null) || 
             (this.msEvts!=null &&
              java.util.Arrays.equals(this.msEvts, other.getMsEvts()))) &&
            ((this.msIhm==null && other.getMsIhm()==null) || 
             (this.msIhm!=null &&
              this.msIhm.equals(other.getMsIhm()))) &&
            ((this.msUp==null && other.getMsUp()==null) || 
             (this.msUp!=null &&
              this.msUp.equals(other.getMsUp()))) &&
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
        if (getDthrCadastro() != null) {
            _hashCode += getDthrCadastro().hashCode();
        }
        if (getIdUpihm() != null) {
            _hashCode += getIdUpihm().hashCode();
        }
        if (getMsEvts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsEvts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsEvts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMsIhm() != null) {
            _hashCode += getMsIhm().hashCode();
        }
        if (getMsUp() != null) {
            _hashCode += getMsUp().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsUpihm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUpihm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUpihm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUpihm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msEvts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msEvts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msIhm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msIhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msIhm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUp"));
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
