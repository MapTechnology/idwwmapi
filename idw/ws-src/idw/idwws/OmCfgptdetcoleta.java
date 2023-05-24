/**
 * OmCfgptdetcoleta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmCfgptdetcoleta  extends idw.idwws.OmCfgptdetcoletaTemplate  implements java.io.Serializable {
    private long idCfgptdetcoleta;

    private idw.idwws.OmCfg omCfg;

    private idw.idwws.OmPt omPt;

    public OmCfgptdetcoleta() {
    }

    public OmCfgptdetcoleta(
           long idCfgptdetcoleta,
           idw.idwws.OmCfg omCfg,
           idw.idwws.OmPt omPt) {
        this.idCfgptdetcoleta = idCfgptdetcoleta;
        this.omCfg = omCfg;
        this.omPt = omPt;
    }


    /**
     * Gets the idCfgptdetcoleta value for this OmCfgptdetcoleta.
     * 
     * @return idCfgptdetcoleta
     */
    public long getIdCfgptdetcoleta() {
        return idCfgptdetcoleta;
    }


    /**
     * Sets the idCfgptdetcoleta value for this OmCfgptdetcoleta.
     * 
     * @param idCfgptdetcoleta
     */
    public void setIdCfgptdetcoleta(long idCfgptdetcoleta) {
        this.idCfgptdetcoleta = idCfgptdetcoleta;
    }


    /**
     * Gets the omCfg value for this OmCfgptdetcoleta.
     * 
     * @return omCfg
     */
    public idw.idwws.OmCfg getOmCfg() {
        return omCfg;
    }


    /**
     * Sets the omCfg value for this OmCfgptdetcoleta.
     * 
     * @param omCfg
     */
    public void setOmCfg(idw.idwws.OmCfg omCfg) {
        this.omCfg = omCfg;
    }


    /**
     * Gets the omPt value for this OmCfgptdetcoleta.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmCfgptdetcoleta.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmCfgptdetcoleta)) return false;
        OmCfgptdetcoleta other = (OmCfgptdetcoleta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.idCfgptdetcoleta == other.getIdCfgptdetcoleta() &&
            ((this.omCfg==null && other.getOmCfg()==null) || 
             (this.omCfg!=null &&
              this.omCfg.equals(other.getOmCfg()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt())));
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
        _hashCode += new Long(getIdCfgptdetcoleta()).hashCode();
        if (getOmCfg() != null) {
            _hashCode += getOmCfg().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmCfgptdetcoleta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgptdetcoleta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCfgptdetcoleta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCfgptdetcoleta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
