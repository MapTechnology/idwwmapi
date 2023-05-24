/**
 * Ijgrcarcrtctrl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrcarcrtctrl  implements java.io.Serializable {
    private java.lang.String cdgrproctrctrl;

    private java.lang.String dsgrproctrctrl;

    private java.lang.String idgrproctrctrl;

    private idw.idwws.Ijgrcarcrtctrlxesp[] ijgrcarcrtctrlxesps;

    private idw.idwws.Ijproxgrcarcrtctrl[] ijproxgrcarcrtctrls;

    public Ijgrcarcrtctrl() {
    }

    public Ijgrcarcrtctrl(
           java.lang.String cdgrproctrctrl,
           java.lang.String dsgrproctrctrl,
           java.lang.String idgrproctrctrl,
           idw.idwws.Ijgrcarcrtctrlxesp[] ijgrcarcrtctrlxesps,
           idw.idwws.Ijproxgrcarcrtctrl[] ijproxgrcarcrtctrls) {
           this.cdgrproctrctrl = cdgrproctrctrl;
           this.dsgrproctrctrl = dsgrproctrctrl;
           this.idgrproctrctrl = idgrproctrctrl;
           this.ijgrcarcrtctrlxesps = ijgrcarcrtctrlxesps;
           this.ijproxgrcarcrtctrls = ijproxgrcarcrtctrls;
    }


    /**
     * Gets the cdgrproctrctrl value for this Ijgrcarcrtctrl.
     * 
     * @return cdgrproctrctrl
     */
    public java.lang.String getCdgrproctrctrl() {
        return cdgrproctrctrl;
    }


    /**
     * Sets the cdgrproctrctrl value for this Ijgrcarcrtctrl.
     * 
     * @param cdgrproctrctrl
     */
    public void setCdgrproctrctrl(java.lang.String cdgrproctrctrl) {
        this.cdgrproctrctrl = cdgrproctrctrl;
    }


    /**
     * Gets the dsgrproctrctrl value for this Ijgrcarcrtctrl.
     * 
     * @return dsgrproctrctrl
     */
    public java.lang.String getDsgrproctrctrl() {
        return dsgrproctrctrl;
    }


    /**
     * Sets the dsgrproctrctrl value for this Ijgrcarcrtctrl.
     * 
     * @param dsgrproctrctrl
     */
    public void setDsgrproctrctrl(java.lang.String dsgrproctrctrl) {
        this.dsgrproctrctrl = dsgrproctrctrl;
    }


    /**
     * Gets the idgrproctrctrl value for this Ijgrcarcrtctrl.
     * 
     * @return idgrproctrctrl
     */
    public java.lang.String getIdgrproctrctrl() {
        return idgrproctrctrl;
    }


    /**
     * Sets the idgrproctrctrl value for this Ijgrcarcrtctrl.
     * 
     * @param idgrproctrctrl
     */
    public void setIdgrproctrctrl(java.lang.String idgrproctrctrl) {
        this.idgrproctrctrl = idgrproctrctrl;
    }


    /**
     * Gets the ijgrcarcrtctrlxesps value for this Ijgrcarcrtctrl.
     * 
     * @return ijgrcarcrtctrlxesps
     */
    public idw.idwws.Ijgrcarcrtctrlxesp[] getIjgrcarcrtctrlxesps() {
        return ijgrcarcrtctrlxesps;
    }


    /**
     * Sets the ijgrcarcrtctrlxesps value for this Ijgrcarcrtctrl.
     * 
     * @param ijgrcarcrtctrlxesps
     */
    public void setIjgrcarcrtctrlxesps(idw.idwws.Ijgrcarcrtctrlxesp[] ijgrcarcrtctrlxesps) {
        this.ijgrcarcrtctrlxesps = ijgrcarcrtctrlxesps;
    }

    public idw.idwws.Ijgrcarcrtctrlxesp getIjgrcarcrtctrlxesps(int i) {
        return this.ijgrcarcrtctrlxesps[i];
    }

    public void setIjgrcarcrtctrlxesps(int i, idw.idwws.Ijgrcarcrtctrlxesp _value) {
        this.ijgrcarcrtctrlxesps[i] = _value;
    }


    /**
     * Gets the ijproxgrcarcrtctrls value for this Ijgrcarcrtctrl.
     * 
     * @return ijproxgrcarcrtctrls
     */
    public idw.idwws.Ijproxgrcarcrtctrl[] getIjproxgrcarcrtctrls() {
        return ijproxgrcarcrtctrls;
    }


    /**
     * Sets the ijproxgrcarcrtctrls value for this Ijgrcarcrtctrl.
     * 
     * @param ijproxgrcarcrtctrls
     */
    public void setIjproxgrcarcrtctrls(idw.idwws.Ijproxgrcarcrtctrl[] ijproxgrcarcrtctrls) {
        this.ijproxgrcarcrtctrls = ijproxgrcarcrtctrls;
    }

    public idw.idwws.Ijproxgrcarcrtctrl getIjproxgrcarcrtctrls(int i) {
        return this.ijproxgrcarcrtctrls[i];
    }

    public void setIjproxgrcarcrtctrls(int i, idw.idwws.Ijproxgrcarcrtctrl _value) {
        this.ijproxgrcarcrtctrls[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrcarcrtctrl)) return false;
        Ijgrcarcrtctrl other = (Ijgrcarcrtctrl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrproctrctrl==null && other.getCdgrproctrctrl()==null) || 
             (this.cdgrproctrctrl!=null &&
              this.cdgrproctrctrl.equals(other.getCdgrproctrctrl()))) &&
            ((this.dsgrproctrctrl==null && other.getDsgrproctrctrl()==null) || 
             (this.dsgrproctrctrl!=null &&
              this.dsgrproctrctrl.equals(other.getDsgrproctrctrl()))) &&
            ((this.idgrproctrctrl==null && other.getIdgrproctrctrl()==null) || 
             (this.idgrproctrctrl!=null &&
              this.idgrproctrctrl.equals(other.getIdgrproctrctrl()))) &&
            ((this.ijgrcarcrtctrlxesps==null && other.getIjgrcarcrtctrlxesps()==null) || 
             (this.ijgrcarcrtctrlxesps!=null &&
              java.util.Arrays.equals(this.ijgrcarcrtctrlxesps, other.getIjgrcarcrtctrlxesps()))) &&
            ((this.ijproxgrcarcrtctrls==null && other.getIjproxgrcarcrtctrls()==null) || 
             (this.ijproxgrcarcrtctrls!=null &&
              java.util.Arrays.equals(this.ijproxgrcarcrtctrls, other.getIjproxgrcarcrtctrls())));
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
        if (getCdgrproctrctrl() != null) {
            _hashCode += getCdgrproctrctrl().hashCode();
        }
        if (getDsgrproctrctrl() != null) {
            _hashCode += getDsgrproctrctrl().hashCode();
        }
        if (getIdgrproctrctrl() != null) {
            _hashCode += getIdgrproctrctrl().hashCode();
        }
        if (getIjgrcarcrtctrlxesps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrcarcrtctrlxesps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrcarcrtctrlxesps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjproxgrcarcrtctrls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjproxgrcarcrtctrls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjproxgrcarcrtctrls(), i);
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
        new org.apache.axis.description.TypeDesc(Ijgrcarcrtctrl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrcarcrtctrl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrproctrctrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrproctrctrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrproctrctrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrproctrctrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idgrproctrctrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idgrproctrctrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrcarcrtctrlxesps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrcarcrtctrlxesps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrcarcrtctrlxesp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijproxgrcarcrtctrls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijproxgrcarcrtctrls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproxgrcarcrtctrl"));
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
