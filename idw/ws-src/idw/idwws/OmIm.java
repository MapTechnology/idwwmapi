/**
 * OmIm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmIm  implements java.io.Serializable {
    private java.util.Calendar dthrIm;

    private long idIm;

    private java.lang.String msg;

    private idw.idwws.OmUsr omUsrByIdUsrsrc;

    private idw.idwws.OmUsr omUsrByIdUsrtrg;

    public OmIm() {
    }

    public OmIm(
           java.util.Calendar dthrIm,
           long idIm,
           java.lang.String msg,
           idw.idwws.OmUsr omUsrByIdUsrsrc,
           idw.idwws.OmUsr omUsrByIdUsrtrg) {
           this.dthrIm = dthrIm;
           this.idIm = idIm;
           this.msg = msg;
           this.omUsrByIdUsrsrc = omUsrByIdUsrsrc;
           this.omUsrByIdUsrtrg = omUsrByIdUsrtrg;
    }


    /**
     * Gets the dthrIm value for this OmIm.
     * 
     * @return dthrIm
     */
    public java.util.Calendar getDthrIm() {
        return dthrIm;
    }


    /**
     * Sets the dthrIm value for this OmIm.
     * 
     * @param dthrIm
     */
    public void setDthrIm(java.util.Calendar dthrIm) {
        this.dthrIm = dthrIm;
    }


    /**
     * Gets the idIm value for this OmIm.
     * 
     * @return idIm
     */
    public long getIdIm() {
        return idIm;
    }


    /**
     * Sets the idIm value for this OmIm.
     * 
     * @param idIm
     */
    public void setIdIm(long idIm) {
        this.idIm = idIm;
    }


    /**
     * Gets the msg value for this OmIm.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this OmIm.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }


    /**
     * Gets the omUsrByIdUsrsrc value for this OmIm.
     * 
     * @return omUsrByIdUsrsrc
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrsrc() {
        return omUsrByIdUsrsrc;
    }


    /**
     * Sets the omUsrByIdUsrsrc value for this OmIm.
     * 
     * @param omUsrByIdUsrsrc
     */
    public void setOmUsrByIdUsrsrc(idw.idwws.OmUsr omUsrByIdUsrsrc) {
        this.omUsrByIdUsrsrc = omUsrByIdUsrsrc;
    }


    /**
     * Gets the omUsrByIdUsrtrg value for this OmIm.
     * 
     * @return omUsrByIdUsrtrg
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrtrg() {
        return omUsrByIdUsrtrg;
    }


    /**
     * Sets the omUsrByIdUsrtrg value for this OmIm.
     * 
     * @param omUsrByIdUsrtrg
     */
    public void setOmUsrByIdUsrtrg(idw.idwws.OmUsr omUsrByIdUsrtrg) {
        this.omUsrByIdUsrtrg = omUsrByIdUsrtrg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmIm)) return false;
        OmIm other = (OmIm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrIm==null && other.getDthrIm()==null) || 
             (this.dthrIm!=null &&
              this.dthrIm.equals(other.getDthrIm()))) &&
            this.idIm == other.getIdIm() &&
            ((this.msg==null && other.getMsg()==null) || 
             (this.msg!=null &&
              this.msg.equals(other.getMsg()))) &&
            ((this.omUsrByIdUsrsrc==null && other.getOmUsrByIdUsrsrc()==null) || 
             (this.omUsrByIdUsrsrc!=null &&
              this.omUsrByIdUsrsrc.equals(other.getOmUsrByIdUsrsrc()))) &&
            ((this.omUsrByIdUsrtrg==null && other.getOmUsrByIdUsrtrg()==null) || 
             (this.omUsrByIdUsrtrg!=null &&
              this.omUsrByIdUsrtrg.equals(other.getOmUsrByIdUsrtrg())));
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
        if (getDthrIm() != null) {
            _hashCode += getDthrIm().hashCode();
        }
        _hashCode += new Long(getIdIm()).hashCode();
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        if (getOmUsrByIdUsrsrc() != null) {
            _hashCode += getOmUsrByIdUsrsrc().hashCode();
        }
        if (getOmUsrByIdUsrtrg() != null) {
            _hashCode += getOmUsrByIdUsrtrg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmIm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrsrc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrsrc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrtrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrtrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
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
