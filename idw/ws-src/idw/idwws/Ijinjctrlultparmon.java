/**
 * Ijinjctrlultparmon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijinjctrlultparmon  implements java.io.Serializable {
    private java.util.Calendar dthrfparrefmonit;

    private java.util.Calendar dthriparrefmonit;

    private double idregistro;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijinjctrlultparmon() {
    }

    public Ijinjctrlultparmon(
           java.util.Calendar dthrfparrefmonit,
           java.util.Calendar dthriparrefmonit,
           double idregistro,
           idw.idwws.Ijtbinj ijtbinj) {
           this.dthrfparrefmonit = dthrfparrefmonit;
           this.dthriparrefmonit = dthriparrefmonit;
           this.idregistro = idregistro;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the dthrfparrefmonit value for this Ijinjctrlultparmon.
     * 
     * @return dthrfparrefmonit
     */
    public java.util.Calendar getDthrfparrefmonit() {
        return dthrfparrefmonit;
    }


    /**
     * Sets the dthrfparrefmonit value for this Ijinjctrlultparmon.
     * 
     * @param dthrfparrefmonit
     */
    public void setDthrfparrefmonit(java.util.Calendar dthrfparrefmonit) {
        this.dthrfparrefmonit = dthrfparrefmonit;
    }


    /**
     * Gets the dthriparrefmonit value for this Ijinjctrlultparmon.
     * 
     * @return dthriparrefmonit
     */
    public java.util.Calendar getDthriparrefmonit() {
        return dthriparrefmonit;
    }


    /**
     * Sets the dthriparrefmonit value for this Ijinjctrlultparmon.
     * 
     * @param dthriparrefmonit
     */
    public void setDthriparrefmonit(java.util.Calendar dthriparrefmonit) {
        this.dthriparrefmonit = dthriparrefmonit;
    }


    /**
     * Gets the idregistro value for this Ijinjctrlultparmon.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijinjctrlultparmon.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijtbinj value for this Ijinjctrlultparmon.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijinjctrlultparmon.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijinjctrlultparmon)) return false;
        Ijinjctrlultparmon other = (Ijinjctrlultparmon) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfparrefmonit==null && other.getDthrfparrefmonit()==null) || 
             (this.dthrfparrefmonit!=null &&
              this.dthrfparrefmonit.equals(other.getDthrfparrefmonit()))) &&
            ((this.dthriparrefmonit==null && other.getDthriparrefmonit()==null) || 
             (this.dthriparrefmonit!=null &&
              this.dthriparrefmonit.equals(other.getDthriparrefmonit()))) &&
            this.idregistro == other.getIdregistro() &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj())));
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
        if (getDthrfparrefmonit() != null) {
            _hashCode += getDthrfparrefmonit().hashCode();
        }
        if (getDthriparrefmonit() != null) {
            _hashCode += getDthriparrefmonit().hashCode();
        }
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijinjctrlultparmon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinjctrlultparmon"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfparrefmonit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfparrefmonit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriparrefmonit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriparrefmonit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
