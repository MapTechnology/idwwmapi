/**
 * Ijtbtpeventoandon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtpeventoandon  implements java.io.Serializable {
    private java.lang.String dstpevento;

    private idw.idwws.Ijcfgandmaqevt[] ijcfgandmaqevts;

    private idw.idwws.Ijcfgandon[] ijcfgandons;

    private java.math.BigDecimal stativo;

    private java.math.BigDecimal tpeventoandon;

    public Ijtbtpeventoandon() {
    }

    public Ijtbtpeventoandon(
           java.lang.String dstpevento,
           idw.idwws.Ijcfgandmaqevt[] ijcfgandmaqevts,
           idw.idwws.Ijcfgandon[] ijcfgandons,
           java.math.BigDecimal stativo,
           java.math.BigDecimal tpeventoandon) {
           this.dstpevento = dstpevento;
           this.ijcfgandmaqevts = ijcfgandmaqevts;
           this.ijcfgandons = ijcfgandons;
           this.stativo = stativo;
           this.tpeventoandon = tpeventoandon;
    }


    /**
     * Gets the dstpevento value for this Ijtbtpeventoandon.
     * 
     * @return dstpevento
     */
    public java.lang.String getDstpevento() {
        return dstpevento;
    }


    /**
     * Sets the dstpevento value for this Ijtbtpeventoandon.
     * 
     * @param dstpevento
     */
    public void setDstpevento(java.lang.String dstpevento) {
        this.dstpevento = dstpevento;
    }


    /**
     * Gets the ijcfgandmaqevts value for this Ijtbtpeventoandon.
     * 
     * @return ijcfgandmaqevts
     */
    public idw.idwws.Ijcfgandmaqevt[] getIjcfgandmaqevts() {
        return ijcfgandmaqevts;
    }


    /**
     * Sets the ijcfgandmaqevts value for this Ijtbtpeventoandon.
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
     * Gets the ijcfgandons value for this Ijtbtpeventoandon.
     * 
     * @return ijcfgandons
     */
    public idw.idwws.Ijcfgandon[] getIjcfgandons() {
        return ijcfgandons;
    }


    /**
     * Sets the ijcfgandons value for this Ijtbtpeventoandon.
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
     * Gets the stativo value for this Ijtbtpeventoandon.
     * 
     * @return stativo
     */
    public java.math.BigDecimal getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbtpeventoandon.
     * 
     * @param stativo
     */
    public void setStativo(java.math.BigDecimal stativo) {
        this.stativo = stativo;
    }


    /**
     * Gets the tpeventoandon value for this Ijtbtpeventoandon.
     * 
     * @return tpeventoandon
     */
    public java.math.BigDecimal getTpeventoandon() {
        return tpeventoandon;
    }


    /**
     * Sets the tpeventoandon value for this Ijtbtpeventoandon.
     * 
     * @param tpeventoandon
     */
    public void setTpeventoandon(java.math.BigDecimal tpeventoandon) {
        this.tpeventoandon = tpeventoandon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtpeventoandon)) return false;
        Ijtbtpeventoandon other = (Ijtbtpeventoandon) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dstpevento==null && other.getDstpevento()==null) || 
             (this.dstpevento!=null &&
              this.dstpevento.equals(other.getDstpevento()))) &&
            ((this.ijcfgandmaqevts==null && other.getIjcfgandmaqevts()==null) || 
             (this.ijcfgandmaqevts!=null &&
              java.util.Arrays.equals(this.ijcfgandmaqevts, other.getIjcfgandmaqevts()))) &&
            ((this.ijcfgandons==null && other.getIjcfgandons()==null) || 
             (this.ijcfgandons!=null &&
              java.util.Arrays.equals(this.ijcfgandons, other.getIjcfgandons()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo()))) &&
            ((this.tpeventoandon==null && other.getTpeventoandon()==null) || 
             (this.tpeventoandon!=null &&
              this.tpeventoandon.equals(other.getTpeventoandon())));
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
        if (getDstpevento() != null) {
            _hashCode += getDstpevento().hashCode();
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
        if (getTpeventoandon() != null) {
            _hashCode += getTpeventoandon().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtpeventoandon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpeventoandon"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstpevento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstpevento"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpeventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpeventoandon"));
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
