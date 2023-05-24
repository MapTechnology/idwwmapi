/**
 * MsTpevt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsTpevt  extends idw.idwws.MsTpevtTemplate  implements java.io.Serializable {
    private java.math.BigDecimal deparaPdba;

    private java.lang.String dsTpevt;

    private java.lang.Long idTpevt;

    private idw.idwws.MsEvt[] msEvts;

    public MsTpevt() {
    }

    public MsTpevt(
           java.math.BigDecimal deparaPdba,
           java.lang.String dsTpevt,
           java.lang.Long idTpevt,
           idw.idwws.MsEvt[] msEvts) {
        this.deparaPdba = deparaPdba;
        this.dsTpevt = dsTpevt;
        this.idTpevt = idTpevt;
        this.msEvts = msEvts;
    }


    /**
     * Gets the deparaPdba value for this MsTpevt.
     * 
     * @return deparaPdba
     */
    public java.math.BigDecimal getDeparaPdba() {
        return deparaPdba;
    }


    /**
     * Sets the deparaPdba value for this MsTpevt.
     * 
     * @param deparaPdba
     */
    public void setDeparaPdba(java.math.BigDecimal deparaPdba) {
        this.deparaPdba = deparaPdba;
    }


    /**
     * Gets the dsTpevt value for this MsTpevt.
     * 
     * @return dsTpevt
     */
    public java.lang.String getDsTpevt() {
        return dsTpevt;
    }


    /**
     * Sets the dsTpevt value for this MsTpevt.
     * 
     * @param dsTpevt
     */
    public void setDsTpevt(java.lang.String dsTpevt) {
        this.dsTpevt = dsTpevt;
    }


    /**
     * Gets the idTpevt value for this MsTpevt.
     * 
     * @return idTpevt
     */
    public java.lang.Long getIdTpevt() {
        return idTpevt;
    }


    /**
     * Sets the idTpevt value for this MsTpevt.
     * 
     * @param idTpevt
     */
    public void setIdTpevt(java.lang.Long idTpevt) {
        this.idTpevt = idTpevt;
    }


    /**
     * Gets the msEvts value for this MsTpevt.
     * 
     * @return msEvts
     */
    public idw.idwws.MsEvt[] getMsEvts() {
        return msEvts;
    }


    /**
     * Sets the msEvts value for this MsTpevt.
     * 
     * @param msEvts
     */
    public void setMsEvts(idw.idwws.MsEvt[] msEvts) {
        this.msEvts = msEvts;
    }

    public idw.idwws.MsEvt getMsEvts(int i) {
        return this.msEvts[i];
    }

    public void setMsEvts(int i, idw.idwws.MsEvt _value) {
        this.msEvts[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsTpevt)) return false;
        MsTpevt other = (MsTpevt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.deparaPdba==null && other.getDeparaPdba()==null) || 
             (this.deparaPdba!=null &&
              this.deparaPdba.equals(other.getDeparaPdba()))) &&
            ((this.dsTpevt==null && other.getDsTpevt()==null) || 
             (this.dsTpevt!=null &&
              this.dsTpevt.equals(other.getDsTpevt()))) &&
            ((this.idTpevt==null && other.getIdTpevt()==null) || 
             (this.idTpevt!=null &&
              this.idTpevt.equals(other.getIdTpevt()))) &&
            ((this.msEvts==null && other.getMsEvts()==null) || 
             (this.msEvts!=null &&
              java.util.Arrays.equals(this.msEvts, other.getMsEvts())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDeparaPdba() != null) {
            _hashCode += getDeparaPdba().hashCode();
        }
        if (getDsTpevt() != null) {
            _hashCode += getDsTpevt().hashCode();
        }
        if (getIdTpevt() != null) {
            _hashCode += getIdTpevt().hashCode();
        }
        if (getMsEvts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsEvts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsEvts(), i);
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
        new org.apache.axis.description.TypeDesc(MsTpevt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msTpevt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deparaPdba");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deparaPdba"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTpevt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTpevt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTpevt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTpevt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msEvts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msEvts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msEvt"));
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
