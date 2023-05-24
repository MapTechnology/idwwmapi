/**
 * Ijtbmolusaidcav.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmolusaidcav  implements java.io.Serializable {
    private java.lang.String cdmolde;

    private idw.idwws.Ijtbmol ijtbmol;

    private java.lang.String usaidcav;

    public Ijtbmolusaidcav() {
    }

    public Ijtbmolusaidcav(
           java.lang.String cdmolde,
           idw.idwws.Ijtbmol ijtbmol,
           java.lang.String usaidcav) {
           this.cdmolde = cdmolde;
           this.ijtbmol = ijtbmol;
           this.usaidcav = usaidcav;
    }


    /**
     * Gets the cdmolde value for this Ijtbmolusaidcav.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this Ijtbmolusaidcav.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the ijtbmol value for this Ijtbmolusaidcav.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijtbmolusaidcav.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the usaidcav value for this Ijtbmolusaidcav.
     * 
     * @return usaidcav
     */
    public java.lang.String getUsaidcav() {
        return usaidcav;
    }


    /**
     * Sets the usaidcav value for this Ijtbmolusaidcav.
     * 
     * @param usaidcav
     */
    public void setUsaidcav(java.lang.String usaidcav) {
        this.usaidcav = usaidcav;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmolusaidcav)) return false;
        Ijtbmolusaidcav other = (Ijtbmolusaidcav) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol()))) &&
            ((this.usaidcav==null && other.getUsaidcav()==null) || 
             (this.usaidcav!=null &&
              this.usaidcav.equals(other.getUsaidcav())));
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
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getIjtbmol() != null) {
            _hashCode += getIjtbmol().hashCode();
        }
        if (getUsaidcav() != null) {
            _hashCode += getUsaidcav().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbmolusaidcav.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmolusaidcav"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usaidcav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usaidcav"));
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
