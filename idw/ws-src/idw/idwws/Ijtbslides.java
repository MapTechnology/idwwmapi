/**
 * Ijtbslides.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbslides  implements java.io.Serializable {
    private java.lang.String cdslide;

    private java.lang.String dsslide;

    private idw.idwws.Ijtbapresxslides[] ijtbapresxslideses;

    private idw.idwws.Ijtbslidesxmaq[] ijtbslidesxmaqs;

    private java.math.BigDecimal tpslide;

    public Ijtbslides() {
    }

    public Ijtbslides(
           java.lang.String cdslide,
           java.lang.String dsslide,
           idw.idwws.Ijtbapresxslides[] ijtbapresxslideses,
           idw.idwws.Ijtbslidesxmaq[] ijtbslidesxmaqs,
           java.math.BigDecimal tpslide) {
           this.cdslide = cdslide;
           this.dsslide = dsslide;
           this.ijtbapresxslideses = ijtbapresxslideses;
           this.ijtbslidesxmaqs = ijtbslidesxmaqs;
           this.tpslide = tpslide;
    }


    /**
     * Gets the cdslide value for this Ijtbslides.
     * 
     * @return cdslide
     */
    public java.lang.String getCdslide() {
        return cdslide;
    }


    /**
     * Sets the cdslide value for this Ijtbslides.
     * 
     * @param cdslide
     */
    public void setCdslide(java.lang.String cdslide) {
        this.cdslide = cdslide;
    }


    /**
     * Gets the dsslide value for this Ijtbslides.
     * 
     * @return dsslide
     */
    public java.lang.String getDsslide() {
        return dsslide;
    }


    /**
     * Sets the dsslide value for this Ijtbslides.
     * 
     * @param dsslide
     */
    public void setDsslide(java.lang.String dsslide) {
        this.dsslide = dsslide;
    }


    /**
     * Gets the ijtbapresxslideses value for this Ijtbslides.
     * 
     * @return ijtbapresxslideses
     */
    public idw.idwws.Ijtbapresxslides[] getIjtbapresxslideses() {
        return ijtbapresxslideses;
    }


    /**
     * Sets the ijtbapresxslideses value for this Ijtbslides.
     * 
     * @param ijtbapresxslideses
     */
    public void setIjtbapresxslideses(idw.idwws.Ijtbapresxslides[] ijtbapresxslideses) {
        this.ijtbapresxslideses = ijtbapresxslideses;
    }

    public idw.idwws.Ijtbapresxslides getIjtbapresxslideses(int i) {
        return this.ijtbapresxslideses[i];
    }

    public void setIjtbapresxslideses(int i, idw.idwws.Ijtbapresxslides _value) {
        this.ijtbapresxslideses[i] = _value;
    }


    /**
     * Gets the ijtbslidesxmaqs value for this Ijtbslides.
     * 
     * @return ijtbslidesxmaqs
     */
    public idw.idwws.Ijtbslidesxmaq[] getIjtbslidesxmaqs() {
        return ijtbslidesxmaqs;
    }


    /**
     * Sets the ijtbslidesxmaqs value for this Ijtbslides.
     * 
     * @param ijtbslidesxmaqs
     */
    public void setIjtbslidesxmaqs(idw.idwws.Ijtbslidesxmaq[] ijtbslidesxmaqs) {
        this.ijtbslidesxmaqs = ijtbslidesxmaqs;
    }

    public idw.idwws.Ijtbslidesxmaq getIjtbslidesxmaqs(int i) {
        return this.ijtbslidesxmaqs[i];
    }

    public void setIjtbslidesxmaqs(int i, idw.idwws.Ijtbslidesxmaq _value) {
        this.ijtbslidesxmaqs[i] = _value;
    }


    /**
     * Gets the tpslide value for this Ijtbslides.
     * 
     * @return tpslide
     */
    public java.math.BigDecimal getTpslide() {
        return tpslide;
    }


    /**
     * Sets the tpslide value for this Ijtbslides.
     * 
     * @param tpslide
     */
    public void setTpslide(java.math.BigDecimal tpslide) {
        this.tpslide = tpslide;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbslides)) return false;
        Ijtbslides other = (Ijtbslides) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdslide==null && other.getCdslide()==null) || 
             (this.cdslide!=null &&
              this.cdslide.equals(other.getCdslide()))) &&
            ((this.dsslide==null && other.getDsslide()==null) || 
             (this.dsslide!=null &&
              this.dsslide.equals(other.getDsslide()))) &&
            ((this.ijtbapresxslideses==null && other.getIjtbapresxslideses()==null) || 
             (this.ijtbapresxslideses!=null &&
              java.util.Arrays.equals(this.ijtbapresxslideses, other.getIjtbapresxslideses()))) &&
            ((this.ijtbslidesxmaqs==null && other.getIjtbslidesxmaqs()==null) || 
             (this.ijtbslidesxmaqs!=null &&
              java.util.Arrays.equals(this.ijtbslidesxmaqs, other.getIjtbslidesxmaqs()))) &&
            ((this.tpslide==null && other.getTpslide()==null) || 
             (this.tpslide!=null &&
              this.tpslide.equals(other.getTpslide())));
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
        if (getCdslide() != null) {
            _hashCode += getCdslide().hashCode();
        }
        if (getDsslide() != null) {
            _hashCode += getDsslide().hashCode();
        }
        if (getIjtbapresxslideses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbapresxslideses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbapresxslideses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbslidesxmaqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbslidesxmaqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbslidesxmaqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTpslide() != null) {
            _hashCode += getTpslide().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbslides.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbslides"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdslide");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdslide"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsslide");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsslide"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbapresxslideses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbapresxslideses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbapresxslides"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbslidesxmaqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbslidesxmaqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbslidesxmaq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpslide");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpslide"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
