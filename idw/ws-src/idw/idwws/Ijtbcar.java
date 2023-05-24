/**
 * Ijtbcar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbcar  implements java.io.Serializable {
    private java.lang.String cdcargo;

    private java.lang.String dscargo;

    private idw.idwws.Ijmdoalocdet[] ijmdoalocdets;

    private idw.idwws.Ijtbusu[] ijtbusus;

    private java.lang.Double vlhora;

    public Ijtbcar() {
    }

    public Ijtbcar(
           java.lang.String cdcargo,
           java.lang.String dscargo,
           idw.idwws.Ijmdoalocdet[] ijmdoalocdets,
           idw.idwws.Ijtbusu[] ijtbusus,
           java.lang.Double vlhora) {
           this.cdcargo = cdcargo;
           this.dscargo = dscargo;
           this.ijmdoalocdets = ijmdoalocdets;
           this.ijtbusus = ijtbusus;
           this.vlhora = vlhora;
    }


    /**
     * Gets the cdcargo value for this Ijtbcar.
     * 
     * @return cdcargo
     */
    public java.lang.String getCdcargo() {
        return cdcargo;
    }


    /**
     * Sets the cdcargo value for this Ijtbcar.
     * 
     * @param cdcargo
     */
    public void setCdcargo(java.lang.String cdcargo) {
        this.cdcargo = cdcargo;
    }


    /**
     * Gets the dscargo value for this Ijtbcar.
     * 
     * @return dscargo
     */
    public java.lang.String getDscargo() {
        return dscargo;
    }


    /**
     * Sets the dscargo value for this Ijtbcar.
     * 
     * @param dscargo
     */
    public void setDscargo(java.lang.String dscargo) {
        this.dscargo = dscargo;
    }


    /**
     * Gets the ijmdoalocdets value for this Ijtbcar.
     * 
     * @return ijmdoalocdets
     */
    public idw.idwws.Ijmdoalocdet[] getIjmdoalocdets() {
        return ijmdoalocdets;
    }


    /**
     * Sets the ijmdoalocdets value for this Ijtbcar.
     * 
     * @param ijmdoalocdets
     */
    public void setIjmdoalocdets(idw.idwws.Ijmdoalocdet[] ijmdoalocdets) {
        this.ijmdoalocdets = ijmdoalocdets;
    }

    public idw.idwws.Ijmdoalocdet getIjmdoalocdets(int i) {
        return this.ijmdoalocdets[i];
    }

    public void setIjmdoalocdets(int i, idw.idwws.Ijmdoalocdet _value) {
        this.ijmdoalocdets[i] = _value;
    }


    /**
     * Gets the ijtbusus value for this Ijtbcar.
     * 
     * @return ijtbusus
     */
    public idw.idwws.Ijtbusu[] getIjtbusus() {
        return ijtbusus;
    }


    /**
     * Sets the ijtbusus value for this Ijtbcar.
     * 
     * @param ijtbusus
     */
    public void setIjtbusus(idw.idwws.Ijtbusu[] ijtbusus) {
        this.ijtbusus = ijtbusus;
    }

    public idw.idwws.Ijtbusu getIjtbusus(int i) {
        return this.ijtbusus[i];
    }

    public void setIjtbusus(int i, idw.idwws.Ijtbusu _value) {
        this.ijtbusus[i] = _value;
    }


    /**
     * Gets the vlhora value for this Ijtbcar.
     * 
     * @return vlhora
     */
    public java.lang.Double getVlhora() {
        return vlhora;
    }


    /**
     * Sets the vlhora value for this Ijtbcar.
     * 
     * @param vlhora
     */
    public void setVlhora(java.lang.Double vlhora) {
        this.vlhora = vlhora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbcar)) return false;
        Ijtbcar other = (Ijtbcar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcargo==null && other.getCdcargo()==null) || 
             (this.cdcargo!=null &&
              this.cdcargo.equals(other.getCdcargo()))) &&
            ((this.dscargo==null && other.getDscargo()==null) || 
             (this.dscargo!=null &&
              this.dscargo.equals(other.getDscargo()))) &&
            ((this.ijmdoalocdets==null && other.getIjmdoalocdets()==null) || 
             (this.ijmdoalocdets!=null &&
              java.util.Arrays.equals(this.ijmdoalocdets, other.getIjmdoalocdets()))) &&
            ((this.ijtbusus==null && other.getIjtbusus()==null) || 
             (this.ijtbusus!=null &&
              java.util.Arrays.equals(this.ijtbusus, other.getIjtbusus()))) &&
            ((this.vlhora==null && other.getVlhora()==null) || 
             (this.vlhora!=null &&
              this.vlhora.equals(other.getVlhora())));
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
        if (getCdcargo() != null) {
            _hashCode += getCdcargo().hashCode();
        }
        if (getDscargo() != null) {
            _hashCode += getDscargo().hashCode();
        }
        if (getIjmdoalocdets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmdoalocdets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmdoalocdets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbusus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbusus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVlhora() != null) {
            _hashCode += getVlhora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbcar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcargo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscargo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmdoalocdets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmdoalocdets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlhora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlhora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
