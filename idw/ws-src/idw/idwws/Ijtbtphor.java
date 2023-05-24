/**
 * Ijtbtphor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtphor  implements java.io.Serializable {
    private java.lang.String cdtphor;

    private java.lang.String dstphor;

    private idw.idwws.Ijhorexc[] ijhorexcs;

    private java.math.BigDecimal paradatrabextra;

    public Ijtbtphor() {
    }

    public Ijtbtphor(
           java.lang.String cdtphor,
           java.lang.String dstphor,
           idw.idwws.Ijhorexc[] ijhorexcs,
           java.math.BigDecimal paradatrabextra) {
           this.cdtphor = cdtphor;
           this.dstphor = dstphor;
           this.ijhorexcs = ijhorexcs;
           this.paradatrabextra = paradatrabextra;
    }


    /**
     * Gets the cdtphor value for this Ijtbtphor.
     * 
     * @return cdtphor
     */
    public java.lang.String getCdtphor() {
        return cdtphor;
    }


    /**
     * Sets the cdtphor value for this Ijtbtphor.
     * 
     * @param cdtphor
     */
    public void setCdtphor(java.lang.String cdtphor) {
        this.cdtphor = cdtphor;
    }


    /**
     * Gets the dstphor value for this Ijtbtphor.
     * 
     * @return dstphor
     */
    public java.lang.String getDstphor() {
        return dstphor;
    }


    /**
     * Sets the dstphor value for this Ijtbtphor.
     * 
     * @param dstphor
     */
    public void setDstphor(java.lang.String dstphor) {
        this.dstphor = dstphor;
    }


    /**
     * Gets the ijhorexcs value for this Ijtbtphor.
     * 
     * @return ijhorexcs
     */
    public idw.idwws.Ijhorexc[] getIjhorexcs() {
        return ijhorexcs;
    }


    /**
     * Sets the ijhorexcs value for this Ijtbtphor.
     * 
     * @param ijhorexcs
     */
    public void setIjhorexcs(idw.idwws.Ijhorexc[] ijhorexcs) {
        this.ijhorexcs = ijhorexcs;
    }

    public idw.idwws.Ijhorexc getIjhorexcs(int i) {
        return this.ijhorexcs[i];
    }

    public void setIjhorexcs(int i, idw.idwws.Ijhorexc _value) {
        this.ijhorexcs[i] = _value;
    }


    /**
     * Gets the paradatrabextra value for this Ijtbtphor.
     * 
     * @return paradatrabextra
     */
    public java.math.BigDecimal getParadatrabextra() {
        return paradatrabextra;
    }


    /**
     * Sets the paradatrabextra value for this Ijtbtphor.
     * 
     * @param paradatrabextra
     */
    public void setParadatrabextra(java.math.BigDecimal paradatrabextra) {
        this.paradatrabextra = paradatrabextra;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtphor)) return false;
        Ijtbtphor other = (Ijtbtphor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdtphor==null && other.getCdtphor()==null) || 
             (this.cdtphor!=null &&
              this.cdtphor.equals(other.getCdtphor()))) &&
            ((this.dstphor==null && other.getDstphor()==null) || 
             (this.dstphor!=null &&
              this.dstphor.equals(other.getDstphor()))) &&
            ((this.ijhorexcs==null && other.getIjhorexcs()==null) || 
             (this.ijhorexcs!=null &&
              java.util.Arrays.equals(this.ijhorexcs, other.getIjhorexcs()))) &&
            ((this.paradatrabextra==null && other.getParadatrabextra()==null) || 
             (this.paradatrabextra!=null &&
              this.paradatrabextra.equals(other.getParadatrabextra())));
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
        if (getCdtphor() != null) {
            _hashCode += getCdtphor().hashCode();
        }
        if (getDstphor() != null) {
            _hashCode += getDstphor().hashCode();
        }
        if (getIjhorexcs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjhorexcs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjhorexcs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParadatrabextra() != null) {
            _hashCode += getParadatrabextra().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtphor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtphor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtphor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtphor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstphor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstphor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijhorexcs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijhorexcs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhorexc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradatrabextra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradatrabextra"));
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
