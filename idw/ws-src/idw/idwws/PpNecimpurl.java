/**
 * PpNecimpurl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecimpurl  extends idw.idwws.PpNecimpurlTemplate  implements java.io.Serializable {
    private java.lang.String aba;

    private java.lang.Long idNecimpurl;

    private java.lang.String mascara;

    private idw.idwws.PpNecimp ppNecimp;

    private idw.idwws.PpNecimpurllog[] ppNecimpurllogs;

    private java.lang.String urlFonte;

    public PpNecimpurl() {
    }

    public PpNecimpurl(
           java.lang.String aba,
           java.lang.Long idNecimpurl,
           java.lang.String mascara,
           idw.idwws.PpNecimp ppNecimp,
           idw.idwws.PpNecimpurllog[] ppNecimpurllogs,
           java.lang.String urlFonte) {
        this.aba = aba;
        this.idNecimpurl = idNecimpurl;
        this.mascara = mascara;
        this.ppNecimp = ppNecimp;
        this.ppNecimpurllogs = ppNecimpurllogs;
        this.urlFonte = urlFonte;
    }


    /**
     * Gets the aba value for this PpNecimpurl.
     * 
     * @return aba
     */
    public java.lang.String getAba() {
        return aba;
    }


    /**
     * Sets the aba value for this PpNecimpurl.
     * 
     * @param aba
     */
    public void setAba(java.lang.String aba) {
        this.aba = aba;
    }


    /**
     * Gets the idNecimpurl value for this PpNecimpurl.
     * 
     * @return idNecimpurl
     */
    public java.lang.Long getIdNecimpurl() {
        return idNecimpurl;
    }


    /**
     * Sets the idNecimpurl value for this PpNecimpurl.
     * 
     * @param idNecimpurl
     */
    public void setIdNecimpurl(java.lang.Long idNecimpurl) {
        this.idNecimpurl = idNecimpurl;
    }


    /**
     * Gets the mascara value for this PpNecimpurl.
     * 
     * @return mascara
     */
    public java.lang.String getMascara() {
        return mascara;
    }


    /**
     * Sets the mascara value for this PpNecimpurl.
     * 
     * @param mascara
     */
    public void setMascara(java.lang.String mascara) {
        this.mascara = mascara;
    }


    /**
     * Gets the ppNecimp value for this PpNecimpurl.
     * 
     * @return ppNecimp
     */
    public idw.idwws.PpNecimp getPpNecimp() {
        return ppNecimp;
    }


    /**
     * Sets the ppNecimp value for this PpNecimpurl.
     * 
     * @param ppNecimp
     */
    public void setPpNecimp(idw.idwws.PpNecimp ppNecimp) {
        this.ppNecimp = ppNecimp;
    }


    /**
     * Gets the ppNecimpurllogs value for this PpNecimpurl.
     * 
     * @return ppNecimpurllogs
     */
    public idw.idwws.PpNecimpurllog[] getPpNecimpurllogs() {
        return ppNecimpurllogs;
    }


    /**
     * Sets the ppNecimpurllogs value for this PpNecimpurl.
     * 
     * @param ppNecimpurllogs
     */
    public void setPpNecimpurllogs(idw.idwws.PpNecimpurllog[] ppNecimpurllogs) {
        this.ppNecimpurllogs = ppNecimpurllogs;
    }

    public idw.idwws.PpNecimpurllog getPpNecimpurllogs(int i) {
        return this.ppNecimpurllogs[i];
    }

    public void setPpNecimpurllogs(int i, idw.idwws.PpNecimpurllog _value) {
        this.ppNecimpurllogs[i] = _value;
    }


    /**
     * Gets the urlFonte value for this PpNecimpurl.
     * 
     * @return urlFonte
     */
    public java.lang.String getUrlFonte() {
        return urlFonte;
    }


    /**
     * Sets the urlFonte value for this PpNecimpurl.
     * 
     * @param urlFonte
     */
    public void setUrlFonte(java.lang.String urlFonte) {
        this.urlFonte = urlFonte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecimpurl)) return false;
        PpNecimpurl other = (PpNecimpurl) obj;
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
            ((this.idNecimpurl==null && other.getIdNecimpurl()==null) || 
             (this.idNecimpurl!=null &&
              this.idNecimpurl.equals(other.getIdNecimpurl()))) &&
            ((this.mascara==null && other.getMascara()==null) || 
             (this.mascara!=null &&
              this.mascara.equals(other.getMascara()))) &&
            ((this.ppNecimp==null && other.getPpNecimp()==null) || 
             (this.ppNecimp!=null &&
              this.ppNecimp.equals(other.getPpNecimp()))) &&
            ((this.ppNecimpurllogs==null && other.getPpNecimpurllogs()==null) || 
             (this.ppNecimpurllogs!=null &&
              java.util.Arrays.equals(this.ppNecimpurllogs, other.getPpNecimpurllogs()))) &&
            ((this.urlFonte==null && other.getUrlFonte()==null) || 
             (this.urlFonte!=null &&
              this.urlFonte.equals(other.getUrlFonte())));
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
        if (getIdNecimpurl() != null) {
            _hashCode += getIdNecimpurl().hashCode();
        }
        if (getMascara() != null) {
            _hashCode += getMascara().hashCode();
        }
        if (getPpNecimp() != null) {
            _hashCode += getPpNecimp().hashCode();
        }
        if (getPpNecimpurllogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNecimpurllogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNecimpurllogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUrlFonte() != null) {
            _hashCode += getUrlFonte().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNecimpurl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aba");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aba"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNecimpurl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNecimpurl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mascara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mascara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimpurllogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimpurllogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurllog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlFonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlFonte"));
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
