/**
 * Ijreaparintbet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreaparintbet  implements java.io.Serializable {
    private idw.idwws.IjreaparintbetId id;

    private idw.idwws.Ijreapar ijreapar;

    private java.lang.String nrOrdProd;

    public Ijreaparintbet() {
    }

    public Ijreaparintbet(
           idw.idwws.IjreaparintbetId id,
           idw.idwws.Ijreapar ijreapar,
           java.lang.String nrOrdProd) {
           this.id = id;
           this.ijreapar = ijreapar;
           this.nrOrdProd = nrOrdProd;
    }


    /**
     * Gets the id value for this Ijreaparintbet.
     * 
     * @return id
     */
    public idw.idwws.IjreaparintbetId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreaparintbet.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreaparintbetId id) {
        this.id = id;
    }


    /**
     * Gets the ijreapar value for this Ijreaparintbet.
     * 
     * @return ijreapar
     */
    public idw.idwws.Ijreapar getIjreapar() {
        return ijreapar;
    }


    /**
     * Sets the ijreapar value for this Ijreaparintbet.
     * 
     * @param ijreapar
     */
    public void setIjreapar(idw.idwws.Ijreapar ijreapar) {
        this.ijreapar = ijreapar;
    }


    /**
     * Gets the nrOrdProd value for this Ijreaparintbet.
     * 
     * @return nrOrdProd
     */
    public java.lang.String getNrOrdProd() {
        return nrOrdProd;
    }


    /**
     * Sets the nrOrdProd value for this Ijreaparintbet.
     * 
     * @param nrOrdProd
     */
    public void setNrOrdProd(java.lang.String nrOrdProd) {
        this.nrOrdProd = nrOrdProd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreaparintbet)) return false;
        Ijreaparintbet other = (Ijreaparintbet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijreapar==null && other.getIjreapar()==null) || 
             (this.ijreapar!=null &&
              this.ijreapar.equals(other.getIjreapar()))) &&
            ((this.nrOrdProd==null && other.getNrOrdProd()==null) || 
             (this.nrOrdProd!=null &&
              this.nrOrdProd.equals(other.getNrOrdProd())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjreapar() != null) {
            _hashCode += getIjreapar().hashCode();
        }
        if (getNrOrdProd() != null) {
            _hashCode += getNrOrdProd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreaparintbet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintbet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintbetId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrOrdProd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrOrdProd"));
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
