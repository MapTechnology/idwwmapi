/**
 * DwTPerdamp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTPerdamp  extends idw.idwws.DwTPerdampTemplate  implements java.io.Serializable {
    private java.lang.String dsPerdamp;

    private idw.idwws.DwConsolpemp[] dwConsolpemps;

    private idw.idwws.DwConsolperdamplog[] dwConsolperdamplogs;

    private long idTperdamp;

    public DwTPerdamp() {
    }

    public DwTPerdamp(
           java.lang.String dsPerdamp,
           idw.idwws.DwConsolpemp[] dwConsolpemps,
           idw.idwws.DwConsolperdamplog[] dwConsolperdamplogs,
           long idTperdamp) {
        this.dsPerdamp = dsPerdamp;
        this.dwConsolpemps = dwConsolpemps;
        this.dwConsolperdamplogs = dwConsolperdamplogs;
        this.idTperdamp = idTperdamp;
    }


    /**
     * Gets the dsPerdamp value for this DwTPerdamp.
     * 
     * @return dsPerdamp
     */
    public java.lang.String getDsPerdamp() {
        return dsPerdamp;
    }


    /**
     * Sets the dsPerdamp value for this DwTPerdamp.
     * 
     * @param dsPerdamp
     */
    public void setDsPerdamp(java.lang.String dsPerdamp) {
        this.dsPerdamp = dsPerdamp;
    }


    /**
     * Gets the dwConsolpemps value for this DwTPerdamp.
     * 
     * @return dwConsolpemps
     */
    public idw.idwws.DwConsolpemp[] getDwConsolpemps() {
        return dwConsolpemps;
    }


    /**
     * Sets the dwConsolpemps value for this DwTPerdamp.
     * 
     * @param dwConsolpemps
     */
    public void setDwConsolpemps(idw.idwws.DwConsolpemp[] dwConsolpemps) {
        this.dwConsolpemps = dwConsolpemps;
    }

    public idw.idwws.DwConsolpemp getDwConsolpemps(int i) {
        return this.dwConsolpemps[i];
    }

    public void setDwConsolpemps(int i, idw.idwws.DwConsolpemp _value) {
        this.dwConsolpemps[i] = _value;
    }


    /**
     * Gets the dwConsolperdamplogs value for this DwTPerdamp.
     * 
     * @return dwConsolperdamplogs
     */
    public idw.idwws.DwConsolperdamplog[] getDwConsolperdamplogs() {
        return dwConsolperdamplogs;
    }


    /**
     * Sets the dwConsolperdamplogs value for this DwTPerdamp.
     * 
     * @param dwConsolperdamplogs
     */
    public void setDwConsolperdamplogs(idw.idwws.DwConsolperdamplog[] dwConsolperdamplogs) {
        this.dwConsolperdamplogs = dwConsolperdamplogs;
    }

    public idw.idwws.DwConsolperdamplog getDwConsolperdamplogs(int i) {
        return this.dwConsolperdamplogs[i];
    }

    public void setDwConsolperdamplogs(int i, idw.idwws.DwConsolperdamplog _value) {
        this.dwConsolperdamplogs[i] = _value;
    }


    /**
     * Gets the idTperdamp value for this DwTPerdamp.
     * 
     * @return idTperdamp
     */
    public long getIdTperdamp() {
        return idTperdamp;
    }


    /**
     * Sets the idTperdamp value for this DwTPerdamp.
     * 
     * @param idTperdamp
     */
    public void setIdTperdamp(long idTperdamp) {
        this.idTperdamp = idTperdamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTPerdamp)) return false;
        DwTPerdamp other = (DwTPerdamp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsPerdamp==null && other.getDsPerdamp()==null) || 
             (this.dsPerdamp!=null &&
              this.dsPerdamp.equals(other.getDsPerdamp()))) &&
            ((this.dwConsolpemps==null && other.getDwConsolpemps()==null) || 
             (this.dwConsolpemps!=null &&
              java.util.Arrays.equals(this.dwConsolpemps, other.getDwConsolpemps()))) &&
            ((this.dwConsolperdamplogs==null && other.getDwConsolperdamplogs()==null) || 
             (this.dwConsolperdamplogs!=null &&
              java.util.Arrays.equals(this.dwConsolperdamplogs, other.getDwConsolperdamplogs()))) &&
            this.idTperdamp == other.getIdTperdamp();
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
        if (getDsPerdamp() != null) {
            _hashCode += getDsPerdamp().hashCode();
        }
        if (getDwConsolpemps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpemps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpemps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolperdamplogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolperdamplogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolperdamplogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdTperdamp()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTPerdamp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTPerdamp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPerdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPerdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpemps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpemps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpemp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolperdamplogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolperdamplogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolperdamplog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTperdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTperdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
