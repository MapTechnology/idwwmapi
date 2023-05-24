/**
 * Ijtbrele.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbrele  implements java.io.Serializable {
    private java.lang.String dsrele;

    private java.math.BigDecimal idrele;

    private java.lang.String idreleaux;

    private idw.idwws.Ijcfgandmaqevt[] ijcfgandmaqevts;

    private idw.idwws.Ijcfgandon[] ijcfgandons;

    private java.math.BigDecimal stativo;

    public Ijtbrele() {
    }

    public Ijtbrele(
           java.lang.String dsrele,
           java.math.BigDecimal idrele,
           java.lang.String idreleaux,
           idw.idwws.Ijcfgandmaqevt[] ijcfgandmaqevts,
           idw.idwws.Ijcfgandon[] ijcfgandons,
           java.math.BigDecimal stativo) {
           this.dsrele = dsrele;
           this.idrele = idrele;
           this.idreleaux = idreleaux;
           this.ijcfgandmaqevts = ijcfgandmaqevts;
           this.ijcfgandons = ijcfgandons;
           this.stativo = stativo;
    }


    /**
     * Gets the dsrele value for this Ijtbrele.
     * 
     * @return dsrele
     */
    public java.lang.String getDsrele() {
        return dsrele;
    }


    /**
     * Sets the dsrele value for this Ijtbrele.
     * 
     * @param dsrele
     */
    public void setDsrele(java.lang.String dsrele) {
        this.dsrele = dsrele;
    }


    /**
     * Gets the idrele value for this Ijtbrele.
     * 
     * @return idrele
     */
    public java.math.BigDecimal getIdrele() {
        return idrele;
    }


    /**
     * Sets the idrele value for this Ijtbrele.
     * 
     * @param idrele
     */
    public void setIdrele(java.math.BigDecimal idrele) {
        this.idrele = idrele;
    }


    /**
     * Gets the idreleaux value for this Ijtbrele.
     * 
     * @return idreleaux
     */
    public java.lang.String getIdreleaux() {
        return idreleaux;
    }


    /**
     * Sets the idreleaux value for this Ijtbrele.
     * 
     * @param idreleaux
     */
    public void setIdreleaux(java.lang.String idreleaux) {
        this.idreleaux = idreleaux;
    }


    /**
     * Gets the ijcfgandmaqevts value for this Ijtbrele.
     * 
     * @return ijcfgandmaqevts
     */
    public idw.idwws.Ijcfgandmaqevt[] getIjcfgandmaqevts() {
        return ijcfgandmaqevts;
    }


    /**
     * Sets the ijcfgandmaqevts value for this Ijtbrele.
     * 
     * @param ijcfgandmaqevts
     */
    public void setIjcfgandmaqevts(idw.idwws.Ijcfgandmaqevt[] ijcfgandmaqevts) {
        this.ijcfgandmaqevts = ijcfgandmaqevts;
    }

    public idw.idwws.Ijcfgandmaqevt getIjcfgandmaqevts(int i) {
        return this.ijcfgandmaqevts[i];
    }

    public void setIjcfgandmaqevts(int i, idw.idwws.Ijcfgandmaqevt _value) {
        this.ijcfgandmaqevts[i] = _value;
    }


    /**
     * Gets the ijcfgandons value for this Ijtbrele.
     * 
     * @return ijcfgandons
     */
    public idw.idwws.Ijcfgandon[] getIjcfgandons() {
        return ijcfgandons;
    }


    /**
     * Sets the ijcfgandons value for this Ijtbrele.
     * 
     * @param ijcfgandons
     */
    public void setIjcfgandons(idw.idwws.Ijcfgandon[] ijcfgandons) {
        this.ijcfgandons = ijcfgandons;
    }

    public idw.idwws.Ijcfgandon getIjcfgandons(int i) {
        return this.ijcfgandons[i];
    }

    public void setIjcfgandons(int i, idw.idwws.Ijcfgandon _value) {
        this.ijcfgandons[i] = _value;
    }


    /**
     * Gets the stativo value for this Ijtbrele.
     * 
     * @return stativo
     */
    public java.math.BigDecimal getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbrele.
     * 
     * @param stativo
     */
    public void setStativo(java.math.BigDecimal stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbrele)) return false;
        Ijtbrele other = (Ijtbrele) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsrele==null && other.getDsrele()==null) || 
             (this.dsrele!=null &&
              this.dsrele.equals(other.getDsrele()))) &&
            ((this.idrele==null && other.getIdrele()==null) || 
             (this.idrele!=null &&
              this.idrele.equals(other.getIdrele()))) &&
            ((this.idreleaux==null && other.getIdreleaux()==null) || 
             (this.idreleaux!=null &&
              this.idreleaux.equals(other.getIdreleaux()))) &&
            ((this.ijcfgandmaqevts==null && other.getIjcfgandmaqevts()==null) || 
             (this.ijcfgandmaqevts!=null &&
              java.util.Arrays.equals(this.ijcfgandmaqevts, other.getIjcfgandmaqevts()))) &&
            ((this.ijcfgandons==null && other.getIjcfgandons()==null) || 
             (this.ijcfgandons!=null &&
              java.util.Arrays.equals(this.ijcfgandons, other.getIjcfgandons()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo())));
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
        if (getDsrele() != null) {
            _hashCode += getDsrele().hashCode();
        }
        if (getIdrele() != null) {
            _hashCode += getIdrele().hashCode();
        }
        if (getIdreleaux() != null) {
            _hashCode += getIdreleaux().hashCode();
        }
        if (getIjcfgandmaqevts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcfgandmaqevts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcfgandmaqevts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcfgandons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcfgandons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcfgandons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbrele.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbrele"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsrele");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsrele"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idrele");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idrele"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idreleaux");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idreleaux"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandmaqevts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandmaqevts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
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
