/**
 * OmIndgt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmIndgt  implements java.io.Serializable {
    private long idIndgt;

    private java.math.BigDecimal numInf;

    private java.math.BigDecimal numMeta;

    private java.math.BigDecimal numSuperior;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmInd omInd;

    public OmIndgt() {
    }

    public OmIndgt(
           long idIndgt,
           java.math.BigDecimal numInf,
           java.math.BigDecimal numMeta,
           java.math.BigDecimal numSuperior,
           idw.idwws.OmGt omGt,
           idw.idwws.OmInd omInd) {
           this.idIndgt = idIndgt;
           this.numInf = numInf;
           this.numMeta = numMeta;
           this.numSuperior = numSuperior;
           this.omGt = omGt;
           this.omInd = omInd;
    }


    /**
     * Gets the idIndgt value for this OmIndgt.
     * 
     * @return idIndgt
     */
    public long getIdIndgt() {
        return idIndgt;
    }


    /**
     * Sets the idIndgt value for this OmIndgt.
     * 
     * @param idIndgt
     */
    public void setIdIndgt(long idIndgt) {
        this.idIndgt = idIndgt;
    }


    /**
     * Gets the numInf value for this OmIndgt.
     * 
     * @return numInf
     */
    public java.math.BigDecimal getNumInf() {
        return numInf;
    }


    /**
     * Sets the numInf value for this OmIndgt.
     * 
     * @param numInf
     */
    public void setNumInf(java.math.BigDecimal numInf) {
        this.numInf = numInf;
    }


    /**
     * Gets the numMeta value for this OmIndgt.
     * 
     * @return numMeta
     */
    public java.math.BigDecimal getNumMeta() {
        return numMeta;
    }


    /**
     * Sets the numMeta value for this OmIndgt.
     * 
     * @param numMeta
     */
    public void setNumMeta(java.math.BigDecimal numMeta) {
        this.numMeta = numMeta;
    }


    /**
     * Gets the numSuperior value for this OmIndgt.
     * 
     * @return numSuperior
     */
    public java.math.BigDecimal getNumSuperior() {
        return numSuperior;
    }


    /**
     * Sets the numSuperior value for this OmIndgt.
     * 
     * @param numSuperior
     */
    public void setNumSuperior(java.math.BigDecimal numSuperior) {
        this.numSuperior = numSuperior;
    }


    /**
     * Gets the omGt value for this OmIndgt.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this OmIndgt.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omInd value for this OmIndgt.
     * 
     * @return omInd
     */
    public idw.idwws.OmInd getOmInd() {
        return omInd;
    }


    /**
     * Sets the omInd value for this OmIndgt.
     * 
     * @param omInd
     */
    public void setOmInd(idw.idwws.OmInd omInd) {
        this.omInd = omInd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmIndgt)) return false;
        OmIndgt other = (OmIndgt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idIndgt == other.getIdIndgt() &&
            ((this.numInf==null && other.getNumInf()==null) || 
             (this.numInf!=null &&
              this.numInf.equals(other.getNumInf()))) &&
            ((this.numMeta==null && other.getNumMeta()==null) || 
             (this.numMeta!=null &&
              this.numMeta.equals(other.getNumMeta()))) &&
            ((this.numSuperior==null && other.getNumSuperior()==null) || 
             (this.numSuperior!=null &&
              this.numSuperior.equals(other.getNumSuperior()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omInd==null && other.getOmInd()==null) || 
             (this.omInd!=null &&
              this.omInd.equals(other.getOmInd())));
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
        _hashCode += new Long(getIdIndgt()).hashCode();
        if (getNumInf() != null) {
            _hashCode += getNumInf().hashCode();
        }
        if (getNumMeta() != null) {
            _hashCode += getNumMeta().hashCode();
        }
        if (getNumSuperior() != null) {
            _hashCode += getNumSuperior().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmInd() != null) {
            _hashCode += getOmInd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmIndgt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndgt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIndgt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIndgt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numInf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numInf"));
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
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
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
