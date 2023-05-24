/**
 * OmAlgocor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmAlgocor  extends idw.idwws.OmAlgocorTemplate  implements java.io.Serializable {
    private java.lang.String dsAlgocor;

    private long idAlgocor;

    private idw.idwws.OmCfg[] omCfgs;

    private idw.idwws.OmTppt[] omTppts;

    public OmAlgocor() {
    }

    public OmAlgocor(
           java.lang.String dsAlgocor,
           long idAlgocor,
           idw.idwws.OmCfg[] omCfgs,
           idw.idwws.OmTppt[] omTppts) {
        this.dsAlgocor = dsAlgocor;
        this.idAlgocor = idAlgocor;
        this.omCfgs = omCfgs;
        this.omTppts = omTppts;
    }


    /**
     * Gets the dsAlgocor value for this OmAlgocor.
     * 
     * @return dsAlgocor
     */
    public java.lang.String getDsAlgocor() {
        return dsAlgocor;
    }


    /**
     * Sets the dsAlgocor value for this OmAlgocor.
     * 
     * @param dsAlgocor
     */
    public void setDsAlgocor(java.lang.String dsAlgocor) {
        this.dsAlgocor = dsAlgocor;
    }


    /**
     * Gets the idAlgocor value for this OmAlgocor.
     * 
     * @return idAlgocor
     */
    public long getIdAlgocor() {
        return idAlgocor;
    }


    /**
     * Sets the idAlgocor value for this OmAlgocor.
     * 
     * @param idAlgocor
     */
    public void setIdAlgocor(long idAlgocor) {
        this.idAlgocor = idAlgocor;
    }


    /**
     * Gets the omCfgs value for this OmAlgocor.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this OmAlgocor.
     * 
     * @param omCfgs
     */
    public void setOmCfgs(idw.idwws.OmCfg[] omCfgs) {
        this.omCfgs = omCfgs;
    }

    public idw.idwws.OmCfg getOmCfgs(int i) {
        return this.omCfgs[i];
    }

    public void setOmCfgs(int i, idw.idwws.OmCfg _value) {
        this.omCfgs[i] = _value;
    }


    /**
     * Gets the omTppts value for this OmAlgocor.
     * 
     * @return omTppts
     */
    public idw.idwws.OmTppt[] getOmTppts() {
        return omTppts;
    }


    /**
     * Sets the omTppts value for this OmAlgocor.
     * 
     * @param omTppts
     */
    public void setOmTppts(idw.idwws.OmTppt[] omTppts) {
        this.omTppts = omTppts;
    }

    public idw.idwws.OmTppt getOmTppts(int i) {
        return this.omTppts[i];
    }

    public void setOmTppts(int i, idw.idwws.OmTppt _value) {
        this.omTppts[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmAlgocor)) return false;
        OmAlgocor other = (OmAlgocor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsAlgocor==null && other.getDsAlgocor()==null) || 
             (this.dsAlgocor!=null &&
              this.dsAlgocor.equals(other.getDsAlgocor()))) &&
            this.idAlgocor == other.getIdAlgocor() &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.omTppts==null && other.getOmTppts()==null) || 
             (this.omTppts!=null &&
              java.util.Arrays.equals(this.omTppts, other.getOmTppts())));
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
        if (getDsAlgocor() != null) {
            _hashCode += getDsAlgocor().hashCode();
        }
        _hashCode += new Long(getIdAlgocor()).hashCode();
        if (getOmCfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmTppts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmTppts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmTppts(), i);
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
        new org.apache.axis.description.TypeDesc(OmAlgocor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlgocor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsAlgocor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsAlgocor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAlgocor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAlgocor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTppts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTppts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
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
