/**
 * MsMsicup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsMsicup  extends idw.idwws.MsMsicupTemplate  implements java.io.Serializable {
    private java.math.BigDecimal idMsicup;

    private idw.idwws.MsEvt[] msEvts;

    private idw.idwws.MsIc msIc;

    private idw.idwws.MsMs msMs;

    private idw.idwws.MsUp msUp;

    private java.math.BigDecimal tpConexao;

    private java.lang.String urlAuxiliar;

    private java.lang.String urlConexao;

    public MsMsicup() {
    }

    public MsMsicup(
           java.math.BigDecimal idMsicup,
           idw.idwws.MsEvt[] msEvts,
           idw.idwws.MsIc msIc,
           idw.idwws.MsMs msMs,
           idw.idwws.MsUp msUp,
           java.math.BigDecimal tpConexao,
           java.lang.String urlAuxiliar,
           java.lang.String urlConexao) {
        this.idMsicup = idMsicup;
        this.msEvts = msEvts;
        this.msIc = msIc;
        this.msMs = msMs;
        this.msUp = msUp;
        this.tpConexao = tpConexao;
        this.urlAuxiliar = urlAuxiliar;
        this.urlConexao = urlConexao;
    }


    /**
     * Gets the idMsicup value for this MsMsicup.
     * 
     * @return idMsicup
     */
    public java.math.BigDecimal getIdMsicup() {
        return idMsicup;
    }


    /**
     * Sets the idMsicup value for this MsMsicup.
     * 
     * @param idMsicup
     */
    public void setIdMsicup(java.math.BigDecimal idMsicup) {
        this.idMsicup = idMsicup;
    }


    /**
     * Gets the msEvts value for this MsMsicup.
     * 
     * @return msEvts
     */
    public idw.idwws.MsEvt[] getMsEvts() {
        return msEvts;
    }


    /**
     * Sets the msEvts value for this MsMsicup.
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
     * Gets the msIc value for this MsMsicup.
     * 
     * @return msIc
     */
    public idw.idwws.MsIc getMsIc() {
        return msIc;
    }


    /**
     * Sets the msIc value for this MsMsicup.
     * 
     * @param msIc
     */
    public void setMsIc(idw.idwws.MsIc msIc) {
        this.msIc = msIc;
    }


    /**
     * Gets the msMs value for this MsMsicup.
     * 
     * @return msMs
     */
    public idw.idwws.MsMs getMsMs() {
        return msMs;
    }


    /**
     * Sets the msMs value for this MsMsicup.
     * 
     * @param msMs
     */
    public void setMsMs(idw.idwws.MsMs msMs) {
        this.msMs = msMs;
    }


    /**
     * Gets the msUp value for this MsMsicup.
     * 
     * @return msUp
     */
    public idw.idwws.MsUp getMsUp() {
        return msUp;
    }


    /**
     * Sets the msUp value for this MsMsicup.
     * 
     * @param msUp
     */
    public void setMsUp(idw.idwws.MsUp msUp) {
        this.msUp = msUp;
    }


    /**
     * Gets the tpConexao value for this MsMsicup.
     * 
     * @return tpConexao
     */
    public java.math.BigDecimal getTpConexao() {
        return tpConexao;
    }


    /**
     * Sets the tpConexao value for this MsMsicup.
     * 
     * @param tpConexao
     */
    public void setTpConexao(java.math.BigDecimal tpConexao) {
        this.tpConexao = tpConexao;
    }


    /**
     * Gets the urlAuxiliar value for this MsMsicup.
     * 
     * @return urlAuxiliar
     */
    public java.lang.String getUrlAuxiliar() {
        return urlAuxiliar;
    }


    /**
     * Sets the urlAuxiliar value for this MsMsicup.
     * 
     * @param urlAuxiliar
     */
    public void setUrlAuxiliar(java.lang.String urlAuxiliar) {
        this.urlAuxiliar = urlAuxiliar;
    }


    /**
     * Gets the urlConexao value for this MsMsicup.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this MsMsicup.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsMsicup)) return false;
        MsMsicup other = (MsMsicup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idMsicup==null && other.getIdMsicup()==null) || 
             (this.idMsicup!=null &&
              this.idMsicup.equals(other.getIdMsicup()))) &&
            ((this.msEvts==null && other.getMsEvts()==null) || 
             (this.msEvts!=null &&
              java.util.Arrays.equals(this.msEvts, other.getMsEvts()))) &&
            ((this.msIc==null && other.getMsIc()==null) || 
             (this.msIc!=null &&
              this.msIc.equals(other.getMsIc()))) &&
            ((this.msMs==null && other.getMsMs()==null) || 
             (this.msMs!=null &&
              this.msMs.equals(other.getMsMs()))) &&
            ((this.msUp==null && other.getMsUp()==null) || 
             (this.msUp!=null &&
              this.msUp.equals(other.getMsUp()))) &&
            ((this.tpConexao==null && other.getTpConexao()==null) || 
             (this.tpConexao!=null &&
              this.tpConexao.equals(other.getTpConexao()))) &&
            ((this.urlAuxiliar==null && other.getUrlAuxiliar()==null) || 
             (this.urlAuxiliar!=null &&
              this.urlAuxiliar.equals(other.getUrlAuxiliar()))) &&
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
        if (getIdMsicup() != null) {
            _hashCode += getIdMsicup().hashCode();
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
        if (getMsIc() != null) {
            _hashCode += getMsIc().hashCode();
        }
        if (getMsMs() != null) {
            _hashCode += getMsMs().hashCode();
        }
        if (getMsUp() != null) {
            _hashCode += getMsUp().hashCode();
        }
        if (getTpConexao() != null) {
            _hashCode += getTpConexao().hashCode();
        }
        if (getUrlAuxiliar() != null) {
            _hashCode += getUrlAuxiliar().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsMsicup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMsicup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMsicup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMsicup"));
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
        elemField.setFieldName("msIc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msIc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msIc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msMs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msMs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMs"));
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
        elemField.setFieldName("tpConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
