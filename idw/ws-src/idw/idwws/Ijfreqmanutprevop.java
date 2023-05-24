/**
 * Ijfreqmanutprevop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfreqmanutprevop  implements java.io.Serializable {
    private java.util.Calendar dthrcopia;

    private idw.idwws.IjfreqmanutprevopId id;

    private idw.idwws.Ijop ijop;

    private java.math.BigDecimal tpfreqmanut;

    private double vlrfreq;

    public Ijfreqmanutprevop() {
    }

    public Ijfreqmanutprevop(
           java.util.Calendar dthrcopia,
           idw.idwws.IjfreqmanutprevopId id,
           idw.idwws.Ijop ijop,
           java.math.BigDecimal tpfreqmanut,
           double vlrfreq) {
           this.dthrcopia = dthrcopia;
           this.id = id;
           this.ijop = ijop;
           this.tpfreqmanut = tpfreqmanut;
           this.vlrfreq = vlrfreq;
    }


    /**
     * Gets the dthrcopia value for this Ijfreqmanutprevop.
     * 
     * @return dthrcopia
     */
    public java.util.Calendar getDthrcopia() {
        return dthrcopia;
    }


    /**
     * Sets the dthrcopia value for this Ijfreqmanutprevop.
     * 
     * @param dthrcopia
     */
    public void setDthrcopia(java.util.Calendar dthrcopia) {
        this.dthrcopia = dthrcopia;
    }


    /**
     * Gets the id value for this Ijfreqmanutprevop.
     * 
     * @return id
     */
    public idw.idwws.IjfreqmanutprevopId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijfreqmanutprevop.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjfreqmanutprevopId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijfreqmanutprevop.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijfreqmanutprevop.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the tpfreqmanut value for this Ijfreqmanutprevop.
     * 
     * @return tpfreqmanut
     */
    public java.math.BigDecimal getTpfreqmanut() {
        return tpfreqmanut;
    }


    /**
     * Sets the tpfreqmanut value for this Ijfreqmanutprevop.
     * 
     * @param tpfreqmanut
     */
    public void setTpfreqmanut(java.math.BigDecimal tpfreqmanut) {
        this.tpfreqmanut = tpfreqmanut;
    }


    /**
     * Gets the vlrfreq value for this Ijfreqmanutprevop.
     * 
     * @return vlrfreq
     */
    public double getVlrfreq() {
        return vlrfreq;
    }


    /**
     * Sets the vlrfreq value for this Ijfreqmanutprevop.
     * 
     * @param vlrfreq
     */
    public void setVlrfreq(double vlrfreq) {
        this.vlrfreq = vlrfreq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfreqmanutprevop)) return false;
        Ijfreqmanutprevop other = (Ijfreqmanutprevop) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrcopia==null && other.getDthrcopia()==null) || 
             (this.dthrcopia!=null &&
              this.dthrcopia.equals(other.getDthrcopia()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.tpfreqmanut==null && other.getTpfreqmanut()==null) || 
             (this.tpfreqmanut!=null &&
              this.tpfreqmanut.equals(other.getTpfreqmanut()))) &&
            this.vlrfreq == other.getVlrfreq();
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
        if (getDthrcopia() != null) {
            _hashCode += getDthrcopia().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getTpfreqmanut() != null) {
            _hashCode += getTpfreqmanut().hashCode();
        }
        _hashCode += new Double(getVlrfreq()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfreqmanutprevop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprevop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrcopia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrcopia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprevopId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpfreqmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpfreqmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlrfreq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlrfreq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
