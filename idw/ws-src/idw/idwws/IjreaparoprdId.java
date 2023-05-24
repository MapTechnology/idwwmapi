/**
 * IjreaparoprdId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjreaparoprdId  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cdoperador;

    private java.util.Calendar dthriparada;

    private java.util.Calendar dthrloginpar;

    public IjreaparoprdId() {
    }

    public IjreaparoprdId(
           java.lang.String cdinjetora,
           java.lang.String cdoperador,
           java.util.Calendar dthriparada,
           java.util.Calendar dthrloginpar) {
           this.cdinjetora = cdinjetora;
           this.cdoperador = cdoperador;
           this.dthriparada = dthriparada;
           this.dthrloginpar = dthrloginpar;
    }


    /**
     * Gets the cdinjetora value for this IjreaparoprdId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjreaparoprdId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdoperador value for this IjreaparoprdId.
     * 
     * @return cdoperador
     */
    public java.lang.String getCdoperador() {
        return cdoperador;
    }


    /**
     * Sets the cdoperador value for this IjreaparoprdId.
     * 
     * @param cdoperador
     */
    public void setCdoperador(java.lang.String cdoperador) {
        this.cdoperador = cdoperador;
    }


    /**
     * Gets the dthriparada value for this IjreaparoprdId.
     * 
     * @return dthriparada
     */
    public java.util.Calendar getDthriparada() {
        return dthriparada;
    }


    /**
     * Sets the dthriparada value for this IjreaparoprdId.
     * 
     * @param dthriparada
     */
    public void setDthriparada(java.util.Calendar dthriparada) {
        this.dthriparada = dthriparada;
    }


    /**
     * Gets the dthrloginpar value for this IjreaparoprdId.
     * 
     * @return dthrloginpar
     */
    public java.util.Calendar getDthrloginpar() {
        return dthrloginpar;
    }


    /**
     * Sets the dthrloginpar value for this IjreaparoprdId.
     * 
     * @param dthrloginpar
     */
    public void setDthrloginpar(java.util.Calendar dthrloginpar) {
        this.dthrloginpar = dthrloginpar;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjreaparoprdId)) return false;
        IjreaparoprdId other = (IjreaparoprdId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdoperador==null && other.getCdoperador()==null) || 
             (this.cdoperador!=null &&
              this.cdoperador.equals(other.getCdoperador()))) &&
            ((this.dthriparada==null && other.getDthriparada()==null) || 
             (this.dthriparada!=null &&
              this.dthriparada.equals(other.getDthriparada()))) &&
            ((this.dthrloginpar==null && other.getDthrloginpar()==null) || 
             (this.dthrloginpar!=null &&
              this.dthrloginpar.equals(other.getDthrloginpar())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdoperador() != null) {
            _hashCode += getCdoperador().hashCode();
        }
        if (getDthriparada() != null) {
            _hashCode += getDthriparada().hashCode();
        }
        if (getDthrloginpar() != null) {
            _hashCode += getDthrloginpar().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjreaparoprdId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparoprdId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrloginpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrloginpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
