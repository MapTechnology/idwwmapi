/**
 * Ijprotempolimdbqld.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijprotempolimdbqld  implements java.io.Serializable {
    private double idregistro;

    private idw.idwws.Ijtbpro ijtbpro;

    private java.math.BigDecimal tempolimaptdbqld;

    public Ijprotempolimdbqld() {
    }

    public Ijprotempolimdbqld(
           double idregistro,
           idw.idwws.Ijtbpro ijtbpro,
           java.math.BigDecimal tempolimaptdbqld) {
           this.idregistro = idregistro;
           this.ijtbpro = ijtbpro;
           this.tempolimaptdbqld = tempolimaptdbqld;
    }


    /**
     * Gets the idregistro value for this Ijprotempolimdbqld.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijprotempolimdbqld.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijtbpro value for this Ijprotempolimdbqld.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijprotempolimdbqld.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the tempolimaptdbqld value for this Ijprotempolimdbqld.
     * 
     * @return tempolimaptdbqld
     */
    public java.math.BigDecimal getTempolimaptdbqld() {
        return tempolimaptdbqld;
    }


    /**
     * Sets the tempolimaptdbqld value for this Ijprotempolimdbqld.
     * 
     * @param tempolimaptdbqld
     */
    public void setTempolimaptdbqld(java.math.BigDecimal tempolimaptdbqld) {
        this.tempolimaptdbqld = tempolimaptdbqld;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijprotempolimdbqld)) return false;
        Ijprotempolimdbqld other = (Ijprotempolimdbqld) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregistro == other.getIdregistro() &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.tempolimaptdbqld==null && other.getTempolimaptdbqld()==null) || 
             (this.tempolimaptdbqld!=null &&
              this.tempolimaptdbqld.equals(other.getTempolimaptdbqld())));
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
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getTempolimaptdbqld() != null) {
            _hashCode += getTempolimaptdbqld().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijprotempolimdbqld.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprotempolimdbqld"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempolimaptdbqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempolimaptdbqld"));
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
