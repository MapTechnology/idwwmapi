/**
 * OmIndpt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmIndpt  implements java.io.Serializable {
    private long idIndpt;

    private java.math.BigDecimal indInferior;

    private java.math.BigDecimal indMeta;

    private java.math.BigDecimal indSuperior;

    private idw.idwws.OmInd omInd;

    private idw.idwws.OmPt omPt;

    public OmIndpt() {
    }

    public OmIndpt(
           long idIndpt,
           java.math.BigDecimal indInferior,
           java.math.BigDecimal indMeta,
           java.math.BigDecimal indSuperior,
           idw.idwws.OmInd omInd,
           idw.idwws.OmPt omPt) {
           this.idIndpt = idIndpt;
           this.indInferior = indInferior;
           this.indMeta = indMeta;
           this.indSuperior = indSuperior;
           this.omInd = omInd;
           this.omPt = omPt;
    }


    /**
     * Gets the idIndpt value for this OmIndpt.
     * 
     * @return idIndpt
     */
    public long getIdIndpt() {
        return idIndpt;
    }


    /**
     * Sets the idIndpt value for this OmIndpt.
     * 
     * @param idIndpt
     */
    public void setIdIndpt(long idIndpt) {
        this.idIndpt = idIndpt;
    }


    /**
     * Gets the indInferior value for this OmIndpt.
     * 
     * @return indInferior
     */
    public java.math.BigDecimal getIndInferior() {
        return indInferior;
    }


    /**
     * Sets the indInferior value for this OmIndpt.
     * 
     * @param indInferior
     */
    public void setIndInferior(java.math.BigDecimal indInferior) {
        this.indInferior = indInferior;
    }


    /**
     * Gets the indMeta value for this OmIndpt.
     * 
     * @return indMeta
     */
    public java.math.BigDecimal getIndMeta() {
        return indMeta;
    }


    /**
     * Sets the indMeta value for this OmIndpt.
     * 
     * @param indMeta
     */
    public void setIndMeta(java.math.BigDecimal indMeta) {
        this.indMeta = indMeta;
    }


    /**
     * Gets the indSuperior value for this OmIndpt.
     * 
     * @return indSuperior
     */
    public java.math.BigDecimal getIndSuperior() {
        return indSuperior;
    }


    /**
     * Sets the indSuperior value for this OmIndpt.
     * 
     * @param indSuperior
     */
    public void setIndSuperior(java.math.BigDecimal indSuperior) {
        this.indSuperior = indSuperior;
    }


    /**
     * Gets the omInd value for this OmIndpt.
     * 
     * @return omInd
     */
    public idw.idwws.OmInd getOmInd() {
        return omInd;
    }


    /**
     * Sets the omInd value for this OmIndpt.
     * 
     * @param omInd
     */
    public void setOmInd(idw.idwws.OmInd omInd) {
        this.omInd = omInd;
    }


    /**
     * Gets the omPt value for this OmIndpt.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmIndpt.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmIndpt)) return false;
        OmIndpt other = (OmIndpt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idIndpt == other.getIdIndpt() &&
            ((this.indInferior==null && other.getIndInferior()==null) || 
             (this.indInferior!=null &&
              this.indInferior.equals(other.getIndInferior()))) &&
            ((this.indMeta==null && other.getIndMeta()==null) || 
             (this.indMeta!=null &&
              this.indMeta.equals(other.getIndMeta()))) &&
            ((this.indSuperior==null && other.getIndSuperior()==null) || 
             (this.indSuperior!=null &&
              this.indSuperior.equals(other.getIndSuperior()))) &&
            ((this.omInd==null && other.getOmInd()==null) || 
             (this.omInd!=null &&
              this.omInd.equals(other.getOmInd()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt())));
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
        _hashCode += new Long(getIdIndpt()).hashCode();
        if (getIndInferior() != null) {
            _hashCode += getIndInferior().hashCode();
        }
        if (getIndMeta() != null) {
            _hashCode += getIndMeta().hashCode();
        }
        if (getIndSuperior() != null) {
            _hashCode += getIndSuperior().hashCode();
        }
        if (getOmInd() != null) {
            _hashCode += getOmInd().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmIndpt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndpt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIndpt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIndpt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indInferior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indInferior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indSuperior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indSuperior"));
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
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
