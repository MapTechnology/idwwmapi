/**
 * Ijtbparaux.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbparaux  implements java.io.Serializable {
    private java.lang.String cdparada;

    private idw.idwws.Ijtbpar ijtbpar;

    private java.lang.String subcodigo;

    public Ijtbparaux() {
    }

    public Ijtbparaux(
           java.lang.String cdparada,
           idw.idwws.Ijtbpar ijtbpar,
           java.lang.String subcodigo) {
           this.cdparada = cdparada;
           this.ijtbpar = ijtbpar;
           this.subcodigo = subcodigo;
    }


    /**
     * Gets the cdparada value for this Ijtbparaux.
     * 
     * @return cdparada
     */
    public java.lang.String getCdparada() {
        return cdparada;
    }


    /**
     * Sets the cdparada value for this Ijtbparaux.
     * 
     * @param cdparada
     */
    public void setCdparada(java.lang.String cdparada) {
        this.cdparada = cdparada;
    }


    /**
     * Gets the ijtbpar value for this Ijtbparaux.
     * 
     * @return ijtbpar
     */
    public idw.idwws.Ijtbpar getIjtbpar() {
        return ijtbpar;
    }


    /**
     * Sets the ijtbpar value for this Ijtbparaux.
     * 
     * @param ijtbpar
     */
    public void setIjtbpar(idw.idwws.Ijtbpar ijtbpar) {
        this.ijtbpar = ijtbpar;
    }


    /**
     * Gets the subcodigo value for this Ijtbparaux.
     * 
     * @return subcodigo
     */
    public java.lang.String getSubcodigo() {
        return subcodigo;
    }


    /**
     * Sets the subcodigo value for this Ijtbparaux.
     * 
     * @param subcodigo
     */
    public void setSubcodigo(java.lang.String subcodigo) {
        this.subcodigo = subcodigo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbparaux)) return false;
        Ijtbparaux other = (Ijtbparaux) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdparada==null && other.getCdparada()==null) || 
             (this.cdparada!=null &&
              this.cdparada.equals(other.getCdparada()))) &&
            ((this.ijtbpar==null && other.getIjtbpar()==null) || 
             (this.ijtbpar!=null &&
              this.ijtbpar.equals(other.getIjtbpar()))) &&
            ((this.subcodigo==null && other.getSubcodigo()==null) || 
             (this.subcodigo!=null &&
              this.subcodigo.equals(other.getSubcodigo())));
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
        if (getCdparada() != null) {
            _hashCode += getCdparada().hashCode();
        }
        if (getIjtbpar() != null) {
            _hashCode += getIjtbpar().hashCode();
        }
        if (getSubcodigo() != null) {
            _hashCode += getSubcodigo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbparaux.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbparaux"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subcodigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subcodigo"));
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
