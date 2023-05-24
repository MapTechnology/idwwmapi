/**
 * DwConsolatlog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolatlog  implements java.io.Serializable {
    private java.util.Calendar dthrAnterior;

    private java.util.Calendar dthrNova;

    private long idConsolatlog;

    private java.lang.Integer msDthranterior;

    private java.lang.Integer msDthrnova;

    private idw.idwws.OmPt omPt;

    private java.lang.String urlConexao;

    public DwConsolatlog() {
    }

    public DwConsolatlog(
           java.util.Calendar dthrAnterior,
           java.util.Calendar dthrNova,
           long idConsolatlog,
           java.lang.Integer msDthranterior,
           java.lang.Integer msDthrnova,
           idw.idwws.OmPt omPt,
           java.lang.String urlConexao) {
           this.dthrAnterior = dthrAnterior;
           this.dthrNova = dthrNova;
           this.idConsolatlog = idConsolatlog;
           this.msDthranterior = msDthranterior;
           this.msDthrnova = msDthrnova;
           this.omPt = omPt;
           this.urlConexao = urlConexao;
    }


    /**
     * Gets the dthrAnterior value for this DwConsolatlog.
     * 
     * @return dthrAnterior
     */
    public java.util.Calendar getDthrAnterior() {
        return dthrAnterior;
    }


    /**
     * Sets the dthrAnterior value for this DwConsolatlog.
     * 
     * @param dthrAnterior
     */
    public void setDthrAnterior(java.util.Calendar dthrAnterior) {
        this.dthrAnterior = dthrAnterior;
    }


    /**
     * Gets the dthrNova value for this DwConsolatlog.
     * 
     * @return dthrNova
     */
    public java.util.Calendar getDthrNova() {
        return dthrNova;
    }


    /**
     * Sets the dthrNova value for this DwConsolatlog.
     * 
     * @param dthrNova
     */
    public void setDthrNova(java.util.Calendar dthrNova) {
        this.dthrNova = dthrNova;
    }


    /**
     * Gets the idConsolatlog value for this DwConsolatlog.
     * 
     * @return idConsolatlog
     */
    public long getIdConsolatlog() {
        return idConsolatlog;
    }


    /**
     * Sets the idConsolatlog value for this DwConsolatlog.
     * 
     * @param idConsolatlog
     */
    public void setIdConsolatlog(long idConsolatlog) {
        this.idConsolatlog = idConsolatlog;
    }


    /**
     * Gets the msDthranterior value for this DwConsolatlog.
     * 
     * @return msDthranterior
     */
    public java.lang.Integer getMsDthranterior() {
        return msDthranterior;
    }


    /**
     * Sets the msDthranterior value for this DwConsolatlog.
     * 
     * @param msDthranterior
     */
    public void setMsDthranterior(java.lang.Integer msDthranterior) {
        this.msDthranterior = msDthranterior;
    }


    /**
     * Gets the msDthrnova value for this DwConsolatlog.
     * 
     * @return msDthrnova
     */
    public java.lang.Integer getMsDthrnova() {
        return msDthrnova;
    }


    /**
     * Sets the msDthrnova value for this DwConsolatlog.
     * 
     * @param msDthrnova
     */
    public void setMsDthrnova(java.lang.Integer msDthrnova) {
        this.msDthrnova = msDthrnova;
    }


    /**
     * Gets the omPt value for this DwConsolatlog.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwConsolatlog.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the urlConexao value for this DwConsolatlog.
     * 
     * @return urlConexao
     */
    public java.lang.String getUrlConexao() {
        return urlConexao;
    }


    /**
     * Sets the urlConexao value for this DwConsolatlog.
     * 
     * @param urlConexao
     */
    public void setUrlConexao(java.lang.String urlConexao) {
        this.urlConexao = urlConexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolatlog)) return false;
        DwConsolatlog other = (DwConsolatlog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrAnterior==null && other.getDthrAnterior()==null) || 
             (this.dthrAnterior!=null &&
              this.dthrAnterior.equals(other.getDthrAnterior()))) &&
            ((this.dthrNova==null && other.getDthrNova()==null) || 
             (this.dthrNova!=null &&
              this.dthrNova.equals(other.getDthrNova()))) &&
            this.idConsolatlog == other.getIdConsolatlog() &&
            ((this.msDthranterior==null && other.getMsDthranterior()==null) || 
             (this.msDthranterior!=null &&
              this.msDthranterior.equals(other.getMsDthranterior()))) &&
            ((this.msDthrnova==null && other.getMsDthrnova()==null) || 
             (this.msDthrnova!=null &&
              this.msDthrnova.equals(other.getMsDthrnova()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
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
        int _hashCode = 1;
        if (getDthrAnterior() != null) {
            _hashCode += getDthrAnterior().hashCode();
        }
        if (getDthrNova() != null) {
            _hashCode += getDthrNova().hashCode();
        }
        _hashCode += new Long(getIdConsolatlog()).hashCode();
        if (getMsDthranterior() != null) {
            _hashCode += getMsDthranterior().hashCode();
        }
        if (getMsDthrnova() != null) {
            _hashCode += getMsDthrnova().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getUrlConexao() != null) {
            _hashCode += getUrlConexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolatlog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolatlog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrAnterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrAnterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrNova");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrNova"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolatlog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolatlog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthranterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthranterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrnova");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrnova"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
