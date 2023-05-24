/**
 * IjoplotesdetId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjoplotesdetId  implements java.io.Serializable {
    private java.util.Calendar dthrbaixaest;

    private java.util.Calendar dthrrecbaixaest;

    private java.lang.String nrloteop;

    private double qtdunidades;

    public IjoplotesdetId() {
    }

    public IjoplotesdetId(
           java.util.Calendar dthrbaixaest,
           java.util.Calendar dthrrecbaixaest,
           java.lang.String nrloteop,
           double qtdunidades) {
           this.dthrbaixaest = dthrbaixaest;
           this.dthrrecbaixaest = dthrrecbaixaest;
           this.nrloteop = nrloteop;
           this.qtdunidades = qtdunidades;
    }


    /**
     * Gets the dthrbaixaest value for this IjoplotesdetId.
     * 
     * @return dthrbaixaest
     */
    public java.util.Calendar getDthrbaixaest() {
        return dthrbaixaest;
    }


    /**
     * Sets the dthrbaixaest value for this IjoplotesdetId.
     * 
     * @param dthrbaixaest
     */
    public void setDthrbaixaest(java.util.Calendar dthrbaixaest) {
        this.dthrbaixaest = dthrbaixaest;
    }


    /**
     * Gets the dthrrecbaixaest value for this IjoplotesdetId.
     * 
     * @return dthrrecbaixaest
     */
    public java.util.Calendar getDthrrecbaixaest() {
        return dthrrecbaixaest;
    }


    /**
     * Sets the dthrrecbaixaest value for this IjoplotesdetId.
     * 
     * @param dthrrecbaixaest
     */
    public void setDthrrecbaixaest(java.util.Calendar dthrrecbaixaest) {
        this.dthrrecbaixaest = dthrrecbaixaest;
    }


    /**
     * Gets the nrloteop value for this IjoplotesdetId.
     * 
     * @return nrloteop
     */
    public java.lang.String getNrloteop() {
        return nrloteop;
    }


    /**
     * Sets the nrloteop value for this IjoplotesdetId.
     * 
     * @param nrloteop
     */
    public void setNrloteop(java.lang.String nrloteop) {
        this.nrloteop = nrloteop;
    }


    /**
     * Gets the qtdunidades value for this IjoplotesdetId.
     * 
     * @return qtdunidades
     */
    public double getQtdunidades() {
        return qtdunidades;
    }


    /**
     * Sets the qtdunidades value for this IjoplotesdetId.
     * 
     * @param qtdunidades
     */
    public void setQtdunidades(double qtdunidades) {
        this.qtdunidades = qtdunidades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjoplotesdetId)) return false;
        IjoplotesdetId other = (IjoplotesdetId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrbaixaest==null && other.getDthrbaixaest()==null) || 
             (this.dthrbaixaest!=null &&
              this.dthrbaixaest.equals(other.getDthrbaixaest()))) &&
            ((this.dthrrecbaixaest==null && other.getDthrrecbaixaest()==null) || 
             (this.dthrrecbaixaest!=null &&
              this.dthrrecbaixaest.equals(other.getDthrrecbaixaest()))) &&
            ((this.nrloteop==null && other.getNrloteop()==null) || 
             (this.nrloteop!=null &&
              this.nrloteop.equals(other.getNrloteop()))) &&
            this.qtdunidades == other.getQtdunidades();
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
        if (getDthrbaixaest() != null) {
            _hashCode += getDthrbaixaest().hashCode();
        }
        if (getDthrrecbaixaest() != null) {
            _hashCode += getDthrrecbaixaest().hashCode();
        }
        if (getNrloteop() != null) {
            _hashCode += getNrloteop().hashCode();
        }
        _hashCode += new Double(getQtdunidades()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjoplotesdetId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotesdetId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrbaixaest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrbaixaest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrrecbaixaest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrrecbaixaest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrloteop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrloteop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdunidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdunidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
