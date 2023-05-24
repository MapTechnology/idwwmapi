/**
 * IjfreqmanutprevopId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjfreqmanutprevopId  implements java.io.Serializable {
    private java.lang.String idchklst;

    private java.lang.String idrecurso;

    private java.lang.String nrop;

    private java.lang.String tprecurso;

    public IjfreqmanutprevopId() {
    }

    public IjfreqmanutprevopId(
           java.lang.String idchklst,
           java.lang.String idrecurso,
           java.lang.String nrop,
           java.lang.String tprecurso) {
           this.idchklst = idchklst;
           this.idrecurso = idrecurso;
           this.nrop = nrop;
           this.tprecurso = tprecurso;
    }


    /**
     * Gets the idchklst value for this IjfreqmanutprevopId.
     * 
     * @return idchklst
     */
    public java.lang.String getIdchklst() {
        return idchklst;
    }


    /**
     * Sets the idchklst value for this IjfreqmanutprevopId.
     * 
     * @param idchklst
     */
    public void setIdchklst(java.lang.String idchklst) {
        this.idchklst = idchklst;
    }


    /**
     * Gets the idrecurso value for this IjfreqmanutprevopId.
     * 
     * @return idrecurso
     */
    public java.lang.String getIdrecurso() {
        return idrecurso;
    }


    /**
     * Sets the idrecurso value for this IjfreqmanutprevopId.
     * 
     * @param idrecurso
     */
    public void setIdrecurso(java.lang.String idrecurso) {
        this.idrecurso = idrecurso;
    }


    /**
     * Gets the nrop value for this IjfreqmanutprevopId.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this IjfreqmanutprevopId.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the tprecurso value for this IjfreqmanutprevopId.
     * 
     * @return tprecurso
     */
    public java.lang.String getTprecurso() {
        return tprecurso;
    }


    /**
     * Sets the tprecurso value for this IjfreqmanutprevopId.
     * 
     * @param tprecurso
     */
    public void setTprecurso(java.lang.String tprecurso) {
        this.tprecurso = tprecurso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjfreqmanutprevopId)) return false;
        IjfreqmanutprevopId other = (IjfreqmanutprevopId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idchklst==null && other.getIdchklst()==null) || 
             (this.idchklst!=null &&
              this.idchklst.equals(other.getIdchklst()))) &&
            ((this.idrecurso==null && other.getIdrecurso()==null) || 
             (this.idrecurso!=null &&
              this.idrecurso.equals(other.getIdrecurso()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.tprecurso==null && other.getTprecurso()==null) || 
             (this.tprecurso!=null &&
              this.tprecurso.equals(other.getTprecurso())));
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
        if (getIdchklst() != null) {
            _hashCode += getIdchklst().hashCode();
        }
        if (getIdrecurso() != null) {
            _hashCode += getIdrecurso().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getTprecurso() != null) {
            _hashCode += getTprecurso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjfreqmanutprevopId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprevopId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idchklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idrecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idrecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tprecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tprecurso"));
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
