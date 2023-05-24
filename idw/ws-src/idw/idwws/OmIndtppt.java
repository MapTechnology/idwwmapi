/**
 * OmIndtppt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmIndtppt  implements java.io.Serializable {
    private long idIndtppt;

    private java.math.BigDecimal numInferior;

    private java.math.BigDecimal numMeta;

    private java.math.BigDecimal numSuperior;

    private idw.idwws.OmInd omInd;

    private idw.idwws.OmTppt omTppt;

    public OmIndtppt() {
    }

    public OmIndtppt(
           long idIndtppt,
           java.math.BigDecimal numInferior,
           java.math.BigDecimal numMeta,
           java.math.BigDecimal numSuperior,
           idw.idwws.OmInd omInd,
           idw.idwws.OmTppt omTppt) {
           this.idIndtppt = idIndtppt;
           this.numInferior = numInferior;
           this.numMeta = numMeta;
           this.numSuperior = numSuperior;
           this.omInd = omInd;
           this.omTppt = omTppt;
    }


    /**
     * Gets the idIndtppt value for this OmIndtppt.
     * 
     * @return idIndtppt
     */
    public long getIdIndtppt() {
        return idIndtppt;
    }


    /**
     * Sets the idIndtppt value for this OmIndtppt.
     * 
     * @param idIndtppt
     */
    public void setIdIndtppt(long idIndtppt) {
        this.idIndtppt = idIndtppt;
    }


    /**
     * Gets the numInferior value for this OmIndtppt.
     * 
     * @return numInferior
     */
    public java.math.BigDecimal getNumInferior() {
        return numInferior;
    }


    /**
     * Sets the numInferior value for this OmIndtppt.
     * 
     * @param numInferior
     */
    public void setNumInferior(java.math.BigDecimal numInferior) {
        this.numInferior = numInferior;
    }


    /**
     * Gets the numMeta value for this OmIndtppt.
     * 
     * @return numMeta
     */
    public java.math.BigDecimal getNumMeta() {
        return numMeta;
    }


    /**
     * Sets the numMeta value for this OmIndtppt.
     * 
     * @param numMeta
     */
    public void setNumMeta(java.math.BigDecimal numMeta) {
        this.numMeta = numMeta;
    }


    /**
     * Gets the numSuperior value for this OmIndtppt.
     * 
     * @return numSuperior
     */
    public java.math.BigDecimal getNumSuperior() {
        return numSuperior;
    }


    /**
     * Sets the numSuperior value for this OmIndtppt.
     * 
     * @param numSuperior
     */
    public void setNumSuperior(java.math.BigDecimal numSuperior) {
        this.numSuperior = numSuperior;
    }


    /**
     * Gets the omInd value for this OmIndtppt.
     * 
     * @return omInd
     */
    public idw.idwws.OmInd getOmInd() {
        return omInd;
    }


    /**
     * Sets the omInd value for this OmIndtppt.
     * 
     * @param omInd
     */
    public void setOmInd(idw.idwws.OmInd omInd) {
        this.omInd = omInd;
    }


    /**
     * Gets the omTppt value for this OmIndtppt.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this OmIndtppt.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmIndtppt)) return false;
        OmIndtppt other = (OmIndtppt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idIndtppt == other.getIdIndtppt() &&
            ((this.numInferior==null && other.getNumInferior()==null) || 
             (this.numInferior!=null &&
              this.numInferior.equals(other.getNumInferior()))) &&
            ((this.numMeta==null && other.getNumMeta()==null) || 
             (this.numMeta!=null &&
              this.numMeta.equals(other.getNumMeta()))) &&
            ((this.numSuperior==null && other.getNumSuperior()==null) || 
             (this.numSuperior!=null &&
              this.numSuperior.equals(other.getNumSuperior()))) &&
            ((this.omInd==null && other.getOmInd()==null) || 
             (this.omInd!=null &&
              this.omInd.equals(other.getOmInd()))) &&
            ((this.omTppt==null && other.getOmTppt()==null) || 
             (this.omTppt!=null &&
              this.omTppt.equals(other.getOmTppt())));
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
        _hashCode += new Long(getIdIndtppt()).hashCode();
        if (getNumInferior() != null) {
            _hashCode += getNumInferior().hashCode();
        }
        if (getNumMeta() != null) {
            _hashCode += getNumMeta().hashCode();
        }
        if (getNumSuperior() != null) {
            _hashCode += getNumSuperior().hashCode();
        }
        if (getOmInd() != null) {
            _hashCode += getOmInd().hashCode();
        }
        if (getOmTppt() != null) {
            _hashCode += getOmTppt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmIndtppt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndtppt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIndtppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIndtppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numInferior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numInferior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numSuperior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numSuperior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omInd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
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
