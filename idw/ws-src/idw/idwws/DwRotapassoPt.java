/**
 * DwRotapassoPt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwRotapassoPt  extends idw.idwws.DwRotapassoPtTemplate  implements java.io.Serializable {
    private idw.idwws.DwRotapasso dwRotapasso;

    private java.math.BigDecimal idRotapassoPt;

    private idw.idwws.OmPt omPt;

    private java.math.BigDecimal ordem;

    public DwRotapassoPt() {
    }

    public DwRotapassoPt(
           idw.idwws.DwRotapasso dwRotapasso,
           java.math.BigDecimal idRotapassoPt,
           idw.idwws.OmPt omPt,
           java.math.BigDecimal ordem) {
        this.dwRotapasso = dwRotapasso;
        this.idRotapassoPt = idRotapassoPt;
        this.omPt = omPt;
        this.ordem = ordem;
    }


    /**
     * Gets the dwRotapasso value for this DwRotapassoPt.
     * 
     * @return dwRotapasso
     */
    public idw.idwws.DwRotapasso getDwRotapasso() {
        return dwRotapasso;
    }


    /**
     * Sets the dwRotapasso value for this DwRotapassoPt.
     * 
     * @param dwRotapasso
     */
    public void setDwRotapasso(idw.idwws.DwRotapasso dwRotapasso) {
        this.dwRotapasso = dwRotapasso;
    }


    /**
     * Gets the idRotapassoPt value for this DwRotapassoPt.
     * 
     * @return idRotapassoPt
     */
    public java.math.BigDecimal getIdRotapassoPt() {
        return idRotapassoPt;
    }


    /**
     * Sets the idRotapassoPt value for this DwRotapassoPt.
     * 
     * @param idRotapassoPt
     */
    public void setIdRotapassoPt(java.math.BigDecimal idRotapassoPt) {
        this.idRotapassoPt = idRotapassoPt;
    }


    /**
     * Gets the omPt value for this DwRotapassoPt.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwRotapassoPt.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ordem value for this DwRotapassoPt.
     * 
     * @return ordem
     */
    public java.math.BigDecimal getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this DwRotapassoPt.
     * 
     * @param ordem
     */
    public void setOrdem(java.math.BigDecimal ordem) {
        this.ordem = ordem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwRotapassoPt)) return false;
        DwRotapassoPt other = (DwRotapassoPt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwRotapasso==null && other.getDwRotapasso()==null) || 
             (this.dwRotapasso!=null &&
              this.dwRotapasso.equals(other.getDwRotapasso()))) &&
            ((this.idRotapassoPt==null && other.getIdRotapassoPt()==null) || 
             (this.idRotapassoPt!=null &&
              this.idRotapassoPt.equals(other.getIdRotapassoPt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem())));
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
        if (getDwRotapasso() != null) {
            _hashCode += getDwRotapasso().hashCode();
        }
        if (getIdRotapassoPt() != null) {
            _hashCode += getIdRotapassoPt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwRotapassoPt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapassoPt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapasso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapasso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRotapassoPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRotapassoPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
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
