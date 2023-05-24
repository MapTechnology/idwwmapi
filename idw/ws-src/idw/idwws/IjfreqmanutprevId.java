/**
 * IjfreqmanutprevId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjfreqmanutprevId  implements java.io.Serializable {
    private java.lang.String cdchklst;

    private java.lang.String idrecurso;

    private java.lang.String tprecurso;

    public IjfreqmanutprevId() {
    }

    public IjfreqmanutprevId(
           java.lang.String cdchklst,
           java.lang.String idrecurso,
           java.lang.String tprecurso) {
           this.cdchklst = cdchklst;
           this.idrecurso = idrecurso;
           this.tprecurso = tprecurso;
    }


    /**
     * Gets the cdchklst value for this IjfreqmanutprevId.
     * 
     * @return cdchklst
     */
    public java.lang.String getCdchklst() {
        return cdchklst;
    }


    /**
     * Sets the cdchklst value for this IjfreqmanutprevId.
     * 
     * @param cdchklst
     */
    public void setCdchklst(java.lang.String cdchklst) {
        this.cdchklst = cdchklst;
    }


    /**
     * Gets the idrecurso value for this IjfreqmanutprevId.
     * 
     * @return idrecurso
     */
    public java.lang.String getIdrecurso() {
        return idrecurso;
    }


    /**
     * Sets the idrecurso value for this IjfreqmanutprevId.
     * 
     * @param idrecurso
     */
    public void setIdrecurso(java.lang.String idrecurso) {
        this.idrecurso = idrecurso;
    }


    /**
     * Gets the tprecurso value for this IjfreqmanutprevId.
     * 
     * @return tprecurso
     */
    public java.lang.String getTprecurso() {
        return tprecurso;
    }


    /**
     * Sets the tprecurso value for this IjfreqmanutprevId.
     * 
     * @param tprecurso
     */
    public void setTprecurso(java.lang.String tprecurso) {
        this.tprecurso = tprecurso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjfreqmanutprevId)) return false;
        IjfreqmanutprevId other = (IjfreqmanutprevId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdchklst==null && other.getCdchklst()==null) || 
             (this.cdchklst!=null &&
              this.cdchklst.equals(other.getCdchklst()))) &&
            ((this.idrecurso==null && other.getIdrecurso()==null) || 
             (this.idrecurso!=null &&
              this.idrecurso.equals(other.getIdrecurso()))) &&
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
        if (getCdchklst() != null) {
            _hashCode += getCdchklst().hashCode();
        }
        if (getIdrecurso() != null) {
            _hashCode += getIdrecurso().hashCode();
        }
        if (getTprecurso() != null) {
            _hashCode += getTprecurso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjfreqmanutprevId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprevId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdchklst"));
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
