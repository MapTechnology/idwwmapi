/**
 * PrSubColetor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrSubColetor  implements java.io.Serializable {
    private java.math.BigDecimal idregsubcoletor;

    private java.math.BigDecimal idsubcoletor;

    private idw.idwws.PrColetor prColetor;

    private idw.idwws.PrUp[] prUps;

    public PrSubColetor() {
    }

    public PrSubColetor(
           java.math.BigDecimal idregsubcoletor,
           java.math.BigDecimal idsubcoletor,
           idw.idwws.PrColetor prColetor,
           idw.idwws.PrUp[] prUps) {
           this.idregsubcoletor = idregsubcoletor;
           this.idsubcoletor = idsubcoletor;
           this.prColetor = prColetor;
           this.prUps = prUps;
    }


    /**
     * Gets the idregsubcoletor value for this PrSubColetor.
     * 
     * @return idregsubcoletor
     */
    public java.math.BigDecimal getIdregsubcoletor() {
        return idregsubcoletor;
    }


    /**
     * Sets the idregsubcoletor value for this PrSubColetor.
     * 
     * @param idregsubcoletor
     */
    public void setIdregsubcoletor(java.math.BigDecimal idregsubcoletor) {
        this.idregsubcoletor = idregsubcoletor;
    }


    /**
     * Gets the idsubcoletor value for this PrSubColetor.
     * 
     * @return idsubcoletor
     */
    public java.math.BigDecimal getIdsubcoletor() {
        return idsubcoletor;
    }


    /**
     * Sets the idsubcoletor value for this PrSubColetor.
     * 
     * @param idsubcoletor
     */
    public void setIdsubcoletor(java.math.BigDecimal idsubcoletor) {
        this.idsubcoletor = idsubcoletor;
    }


    /**
     * Gets the prColetor value for this PrSubColetor.
     * 
     * @return prColetor
     */
    public idw.idwws.PrColetor getPrColetor() {
        return prColetor;
    }


    /**
     * Sets the prColetor value for this PrSubColetor.
     * 
     * @param prColetor
     */
    public void setPrColetor(idw.idwws.PrColetor prColetor) {
        this.prColetor = prColetor;
    }


    /**
     * Gets the prUps value for this PrSubColetor.
     * 
     * @return prUps
     */
    public idw.idwws.PrUp[] getPrUps() {
        return prUps;
    }


    /**
     * Sets the prUps value for this PrSubColetor.
     * 
     * @param prUps
     */
    public void setPrUps(idw.idwws.PrUp[] prUps) {
        this.prUps = prUps;
    }

    public idw.idwws.PrUp getPrUps(int i) {
        return this.prUps[i];
    }

    public void setPrUps(int i, idw.idwws.PrUp _value) {
        this.prUps[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrSubColetor)) return false;
        PrSubColetor other = (PrSubColetor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idregsubcoletor==null && other.getIdregsubcoletor()==null) || 
             (this.idregsubcoletor!=null &&
              this.idregsubcoletor.equals(other.getIdregsubcoletor()))) &&
            ((this.idsubcoletor==null && other.getIdsubcoletor()==null) || 
             (this.idsubcoletor!=null &&
              this.idsubcoletor.equals(other.getIdsubcoletor()))) &&
            ((this.prColetor==null && other.getPrColetor()==null) || 
             (this.prColetor!=null &&
              this.prColetor.equals(other.getPrColetor()))) &&
            ((this.prUps==null && other.getPrUps()==null) || 
             (this.prUps!=null &&
              java.util.Arrays.equals(this.prUps, other.getPrUps())));
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
        if (getIdregsubcoletor() != null) {
            _hashCode += getIdregsubcoletor().hashCode();
        }
        if (getIdsubcoletor() != null) {
            _hashCode += getIdsubcoletor().hashCode();
        }
        if (getPrColetor() != null) {
            _hashCode += getPrColetor().hashCode();
        }
        if (getPrUps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrSubColetor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prSubColetor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregsubcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregsubcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idsubcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idsubcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prColetor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prColetor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prColetor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
