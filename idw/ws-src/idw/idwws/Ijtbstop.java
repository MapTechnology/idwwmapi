/**
 * Ijtbstop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbstop  implements java.io.Serializable {
    private java.lang.String dsstop;

    private idw.idwws.Ijop[] ijops;

    private java.lang.String stop;

    public Ijtbstop() {
    }

    public Ijtbstop(
           java.lang.String dsstop,
           idw.idwws.Ijop[] ijops,
           java.lang.String stop) {
           this.dsstop = dsstop;
           this.ijops = ijops;
           this.stop = stop;
    }


    /**
     * Gets the dsstop value for this Ijtbstop.
     * 
     * @return dsstop
     */
    public java.lang.String getDsstop() {
        return dsstop;
    }


    /**
     * Sets the dsstop value for this Ijtbstop.
     * 
     * @param dsstop
     */
    public void setDsstop(java.lang.String dsstop) {
        this.dsstop = dsstop;
    }


    /**
     * Gets the ijops value for this Ijtbstop.
     * 
     * @return ijops
     */
    public idw.idwws.Ijop[] getIjops() {
        return ijops;
    }


    /**
     * Sets the ijops value for this Ijtbstop.
     * 
     * @param ijops
     */
    public void setIjops(idw.idwws.Ijop[] ijops) {
        this.ijops = ijops;
    }

    public idw.idwws.Ijop getIjops(int i) {
        return this.ijops[i];
    }

    public void setIjops(int i, idw.idwws.Ijop _value) {
        this.ijops[i] = _value;
    }


    /**
     * Gets the stop value for this Ijtbstop.
     * 
     * @return stop
     */
    public java.lang.String getStop() {
        return stop;
    }


    /**
     * Sets the stop value for this Ijtbstop.
     * 
     * @param stop
     */
    public void setStop(java.lang.String stop) {
        this.stop = stop;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbstop)) return false;
        Ijtbstop other = (Ijtbstop) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsstop==null && other.getDsstop()==null) || 
             (this.dsstop!=null &&
              this.dsstop.equals(other.getDsstop()))) &&
            ((this.ijops==null && other.getIjops()==null) || 
             (this.ijops!=null &&
              java.util.Arrays.equals(this.ijops, other.getIjops()))) &&
            ((this.stop==null && other.getStop()==null) || 
             (this.stop!=null &&
              this.stop.equals(other.getStop())));
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
        if (getDsstop() != null) {
            _hashCode += getDsstop().hashCode();
        }
        if (getIjops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStop() != null) {
            _hashCode += getStop().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbstop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbstop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsstop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsstop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
