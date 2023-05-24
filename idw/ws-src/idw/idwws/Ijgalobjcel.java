/**
 * Ijgalobjcel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgalobjcel  implements java.io.Serializable {
    private double coordx;

    private double coordy;

    private idw.idwws.IjgalobjcelId id;

    private idw.idwws.Ijtbcelula ijtbcelula;

    private idw.idwws.Ijtbgal ijtbgal;

    public Ijgalobjcel() {
    }

    public Ijgalobjcel(
           double coordx,
           double coordy,
           idw.idwws.IjgalobjcelId id,
           idw.idwws.Ijtbcelula ijtbcelula,
           idw.idwws.Ijtbgal ijtbgal) {
           this.coordx = coordx;
           this.coordy = coordy;
           this.id = id;
           this.ijtbcelula = ijtbcelula;
           this.ijtbgal = ijtbgal;
    }


    /**
     * Gets the coordx value for this Ijgalobjcel.
     * 
     * @return coordx
     */
    public double getCoordx() {
        return coordx;
    }


    /**
     * Sets the coordx value for this Ijgalobjcel.
     * 
     * @param coordx
     */
    public void setCoordx(double coordx) {
        this.coordx = coordx;
    }


    /**
     * Gets the coordy value for this Ijgalobjcel.
     * 
     * @return coordy
     */
    public double getCoordy() {
        return coordy;
    }


    /**
     * Sets the coordy value for this Ijgalobjcel.
     * 
     * @param coordy
     */
    public void setCoordy(double coordy) {
        this.coordy = coordy;
    }


    /**
     * Gets the id value for this Ijgalobjcel.
     * 
     * @return id
     */
    public idw.idwws.IjgalobjcelId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgalobjcel.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgalobjcelId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbcelula value for this Ijgalobjcel.
     * 
     * @return ijtbcelula
     */
    public idw.idwws.Ijtbcelula getIjtbcelula() {
        return ijtbcelula;
    }


    /**
     * Sets the ijtbcelula value for this Ijgalobjcel.
     * 
     * @param ijtbcelula
     */
    public void setIjtbcelula(idw.idwws.Ijtbcelula ijtbcelula) {
        this.ijtbcelula = ijtbcelula;
    }


    /**
     * Gets the ijtbgal value for this Ijgalobjcel.
     * 
     * @return ijtbgal
     */
    public idw.idwws.Ijtbgal getIjtbgal() {
        return ijtbgal;
    }


    /**
     * Sets the ijtbgal value for this Ijgalobjcel.
     * 
     * @param ijtbgal
     */
    public void setIjtbgal(idw.idwws.Ijtbgal ijtbgal) {
        this.ijtbgal = ijtbgal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgalobjcel)) return false;
        Ijgalobjcel other = (Ijgalobjcel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.coordx == other.getCoordx() &&
            this.coordy == other.getCoordy() &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbcelula==null && other.getIjtbcelula()==null) || 
             (this.ijtbcelula!=null &&
              this.ijtbcelula.equals(other.getIjtbcelula()))) &&
            ((this.ijtbgal==null && other.getIjtbgal()==null) || 
             (this.ijtbgal!=null &&
              this.ijtbgal.equals(other.getIjtbgal())));
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
        _hashCode += new Double(getCoordx()).hashCode();
        _hashCode += new Double(getCoordy()).hashCode();
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbcelula() != null) {
            _hashCode += getIjtbcelula().hashCode();
        }
        if (getIjtbgal() != null) {
            _hashCode += getIjtbgal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgalobjcel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjcel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjcelId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcelula"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbgal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbgal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgal"));
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
