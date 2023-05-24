/**
 * PpNecimpurllog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecimpurllog  extends idw.idwws.PpNecimpurllogTemplate  implements java.io.Serializable {
    private java.lang.String aba;

    private java.lang.String dsErro;

    private java.util.Calendar dthrFimportacao;

    private java.util.Calendar dthrIimportacao;

    private java.lang.Long idNecimpurllog;

    private idw.idwws.PpNecimplog ppNecimplog;

    private idw.idwws.PpNecimpurl ppNecimpurl;

    private idw.idwws.PpNec[] ppNecs;

    private java.lang.Integer stImp;

    private java.lang.String urlArquivo;

    public PpNecimpurllog() {
    }

    public PpNecimpurllog(
           java.lang.String aba,
           java.lang.String dsErro,
           java.util.Calendar dthrFimportacao,
           java.util.Calendar dthrIimportacao,
           java.lang.Long idNecimpurllog,
           idw.idwws.PpNecimplog ppNecimplog,
           idw.idwws.PpNecimpurl ppNecimpurl,
           idw.idwws.PpNec[] ppNecs,
           java.lang.Integer stImp,
           java.lang.String urlArquivo) {
        this.aba = aba;
        this.dsErro = dsErro;
        this.dthrFimportacao = dthrFimportacao;
        this.dthrIimportacao = dthrIimportacao;
        this.idNecimpurllog = idNecimpurllog;
        this.ppNecimplog = ppNecimplog;
        this.ppNecimpurl = ppNecimpurl;
        this.ppNecs = ppNecs;
        this.stImp = stImp;
        this.urlArquivo = urlArquivo;
    }


    /**
     * Gets the aba value for this PpNecimpurllog.
     * 
     * @return aba
     */
    public java.lang.String getAba() {
        return aba;
    }


    /**
     * Sets the aba value for this PpNecimpurllog.
     * 
     * @param aba
     */
    public void setAba(java.lang.String aba) {
        this.aba = aba;
    }


    /**
     * Gets the dsErro value for this PpNecimpurllog.
     * 
     * @return dsErro
     */
    public java.lang.String getDsErro() {
        return dsErro;
    }


    /**
     * Sets the dsErro value for this PpNecimpurllog.
     * 
     * @param dsErro
     */
    public void setDsErro(java.lang.String dsErro) {
        this.dsErro = dsErro;
    }


    /**
     * Gets the dthrFimportacao value for this PpNecimpurllog.
     * 
     * @return dthrFimportacao
     */
    public java.util.Calendar getDthrFimportacao() {
        return dthrFimportacao;
    }


    /**
     * Sets the dthrFimportacao value for this PpNecimpurllog.
     * 
     * @param dthrFimportacao
     */
    public void setDthrFimportacao(java.util.Calendar dthrFimportacao) {
        this.dthrFimportacao = dthrFimportacao;
    }


    /**
     * Gets the dthrIimportacao value for this PpNecimpurllog.
     * 
     * @return dthrIimportacao
     */
    public java.util.Calendar getDthrIimportacao() {
        return dthrIimportacao;
    }


    /**
     * Sets the dthrIimportacao value for this PpNecimpurllog.
     * 
     * @param dthrIimportacao
     */
    public void setDthrIimportacao(java.util.Calendar dthrIimportacao) {
        this.dthrIimportacao = dthrIimportacao;
    }


    /**
     * Gets the idNecimpurllog value for this PpNecimpurllog.
     * 
     * @return idNecimpurllog
     */
    public java.lang.Long getIdNecimpurllog() {
        return idNecimpurllog;
    }


    /**
     * Sets the idNecimpurllog value for this PpNecimpurllog.
     * 
     * @param idNecimpurllog
     */
    public void setIdNecimpurllog(java.lang.Long idNecimpurllog) {
        this.idNecimpurllog = idNecimpurllog;
    }


    /**
     * Gets the ppNecimplog value for this PpNecimpurllog.
     * 
     * @return ppNecimplog
     */
    public idw.idwws.PpNecimplog getPpNecimplog() {
        return ppNecimplog;
    }


    /**
     * Sets the ppNecimplog value for this PpNecimpurllog.
     * 
     * @param ppNecimplog
     */
    public void setPpNecimplog(idw.idwws.PpNecimplog ppNecimplog) {
        this.ppNecimplog = ppNecimplog;
    }


    /**
     * Gets the ppNecimpurl value for this PpNecimpurllog.
     * 
     * @return ppNecimpurl
     */
    public idw.idwws.PpNecimpurl getPpNecimpurl() {
        return ppNecimpurl;
    }


    /**
     * Sets the ppNecimpurl value for this PpNecimpurllog.
     * 
     * @param ppNecimpurl
     */
    public void setPpNecimpurl(idw.idwws.PpNecimpurl ppNecimpurl) {
        this.ppNecimpurl = ppNecimpurl;
    }


    /**
     * Gets the ppNecs value for this PpNecimpurllog.
     * 
     * @return ppNecs
     */
    public idw.idwws.PpNec[] getPpNecs() {
        return ppNecs;
    }


    /**
     * Sets the ppNecs value for this PpNecimpurllog.
     * 
     * @param ppNecs
     */
    public void setPpNecs(idw.idwws.PpNec[] ppNecs) {
        this.ppNecs = ppNecs;
    }

    public idw.idwws.PpNec getPpNecs(int i) {
        return this.ppNecs[i];
    }

    public void setPpNecs(int i, idw.idwws.PpNec _value) {
        this.ppNecs[i] = _value;
    }


    /**
     * Gets the stImp value for this PpNecimpurllog.
     * 
     * @return stImp
     */
    public java.lang.Integer getStImp() {
        return stImp;
    }


    /**
     * Sets the stImp value for this PpNecimpurllog.
     * 
     * @param stImp
     */
    public void setStImp(java.lang.Integer stImp) {
        this.stImp = stImp;
    }


    /**
     * Gets the urlArquivo value for this PpNecimpurllog.
     * 
     * @return urlArquivo
     */
    public java.lang.String getUrlArquivo() {
        return urlArquivo;
    }


    /**
     * Sets the urlArquivo value for this PpNecimpurllog.
     * 
     * @param urlArquivo
     */
    public void setUrlArquivo(java.lang.String urlArquivo) {
        this.urlArquivo = urlArquivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecimpurllog)) return false;
        PpNecimpurllog other = (PpNecimpurllog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.aba==null && other.getAba()==null) || 
             (this.aba!=null &&
              this.aba.equals(other.getAba()))) &&
            ((this.dsErro==null && other.getDsErro()==null) || 
             (this.dsErro!=null &&
              this.dsErro.equals(other.getDsErro()))) &&
            ((this.dthrFimportacao==null && other.getDthrFimportacao()==null) || 
             (this.dthrFimportacao!=null &&
              this.dthrFimportacao.equals(other.getDthrFimportacao()))) &&
            ((this.dthrIimportacao==null && other.getDthrIimportacao()==null) || 
             (this.dthrIimportacao!=null &&
              this.dthrIimportacao.equals(other.getDthrIimportacao()))) &&
            ((this.idNecimpurllog==null && other.getIdNecimpurllog()==null) || 
             (this.idNecimpurllog!=null &&
              this.idNecimpurllog.equals(other.getIdNecimpurllog()))) &&
            ((this.ppNecimplog==null && other.getPpNecimplog()==null) || 
             (this.ppNecimplog!=null &&
              this.ppNecimplog.equals(other.getPpNecimplog()))) &&
            ((this.ppNecimpurl==null && other.getPpNecimpurl()==null) || 
             (this.ppNecimpurl!=null &&
              this.ppNecimpurl.equals(other.getPpNecimpurl()))) &&
            ((this.ppNecs==null && other.getPpNecs()==null) || 
             (this.ppNecs!=null &&
              java.util.Arrays.equals(this.ppNecs, other.getPpNecs()))) &&
            ((this.stImp==null && other.getStImp()==null) || 
             (this.stImp!=null &&
              this.stImp.equals(other.getStImp()))) &&
            ((this.urlArquivo==null && other.getUrlArquivo()==null) || 
             (this.urlArquivo!=null &&
              this.urlArquivo.equals(other.getUrlArquivo())));
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
        if (getAba() != null) {
            _hashCode += getAba().hashCode();
        }
        if (getDsErro() != null) {
            _hashCode += getDsErro().hashCode();
        }
        if (getDthrFimportacao() != null) {
            _hashCode += getDthrFimportacao().hashCode();
        }
        if (getDthrIimportacao() != null) {
            _hashCode += getDthrIimportacao().hashCode();
        }
        if (getIdNecimpurllog() != null) {
            _hashCode += getIdNecimpurllog().hashCode();
        }
        if (getPpNecimplog() != null) {
            _hashCode += getPpNecimplog().hashCode();
        }
        if (getPpNecimpurl() != null) {
            _hashCode += getPpNecimpurl().hashCode();
        }
        if (getPpNecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStImp() != null) {
            _hashCode += getStImp().hashCode();
        }
        if (getUrlArquivo() != null) {
            _hashCode += getUrlArquivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNecimpurllog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurllog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aba");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aba"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFimportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFimportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIimportacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIimportacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNecimpurllog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNecimpurllog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimplog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimplog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimplog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimpurl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimpurl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stImp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stImp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlArquivo"));
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
