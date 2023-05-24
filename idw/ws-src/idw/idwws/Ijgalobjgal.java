/**
 * Ijgalobjgal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgalobjgal  implements java.io.Serializable {
    private double coordx;

    private double coordy;

    private idw.idwws.IjgalobjgalId id;

    private idw.idwws.Ijtbgal ijtbgalByCdgalpao;

    private idw.idwws.Ijtbgal ijtbgalByCdgalpaoobj;

    public Ijgalobjgal() {
    }

    public Ijgalobjgal(
           double coordx,
           double coordy,
           idw.idwws.IjgalobjgalId id,
           idw.idwws.Ijtbgal ijtbgalByCdgalpao,
           idw.idwws.Ijtbgal ijtbgalByCdgalpaoobj) {
           this.coordx = coordx;
           this.coordy = coordy;
           this.id = id;
           this.ijtbgalByCdgalpao = ijtbgalByCdgalpao;
           this.ijtbgalByCdgalpaoobj = ijtbgalByCdgalpaoobj;
    }


    /**
     * Gets the coordx value for this Ijgalobjgal.
     * 
     * @return coordx
     */
    public double getCoordx() {
        return coordx;
    }


    /**
     * Sets the coordx value for this Ijgalobjgal.
     * 
     * @param coordx
     */
    public void setCoordx(double coordx) {
        this.coordx = coordx;
    }


    /**
     * Gets the coordy value for this Ijgalobjgal.
     * 
     * @return coordy
     */
    public double getCoordy() {
        return coordy;
    }


    /**
     * Sets the coordy value for this Ijgalobjgal.
     * 
     * @param coordy
     */
    public void setCoordy(double coordy) {
        this.coordy = coordy;
    }


    /**
     * Gets the id value for this Ijgalobjgal.
     * 
     * @return id
     */
    public idw.idwws.IjgalobjgalId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgalobjgal.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgalobjgalId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbgalByCdgalpao value for this Ijgalobjgal.
     * 
     * @return ijtbgalByCdgalpao
     */
    public idw.idwws.Ijtbgal getIjtbgalByCdgalpao() {
        return ijtbgalByCdgalpao;
    }


    /**
     * Sets the ijtbgalByCdgalpao value for this Ijgalobjgal.
     * 
     * @param ijtbgalByCdgalpao
     */
    public void setIjtbgalByCdgalpao(idw.idwws.Ijtbgal ijtbgalByCdgalpao) {
        this.ijtbgalByCdgalpao = ijtbgalByCdgalpao;
    }


    /**
     * Gets the ijtbgalByCdgalpaoobj value for this Ijgalobjgal.
     * 
     * @return ijtbgalByCdgalpaoobj
     */
    public idw.idwws.Ijtbgal getIjtbgalByCdgalpaoobj() {
        return ijtbgalByCdgalpaoobj;
    }


    /**
     * Sets the ijtbgalByCdgalpaoobj value for this Ijgalobjgal.
     * 
     * @param ijtbgalByCdgalpaoobj
     */
    public void setIjtbgalByCdgalpaoobj(idw.idwws.Ijtbgal ijtbgalByCdgalpaoobj) {
        this.ijtbgalByCdgalpaoobj = ijtbgalByCdgalpaoobj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgalobjgal)) return false;
        Ijgalobjgal other = (Ijgalobjgal) obj;
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
            ((this.ijtbgalByCdgalpao==null && other.getIjtbgalByCdgalpao()==null) || 
             (this.ijtbgalByCdgalpao!=null &&
              this.ijtbgalByCdgalpao.equals(other.getIjtbgalByCdgalpao()))) &&
            ((this.ijtbgalByCdgalpaoobj==null && other.getIjtbgalByCdgalpaoobj()==null) || 
             (this.ijtbgalByCdgalpaoobj!=null &&
              this.ijtbgalByCdgalpaoobj.equals(other.getIjtbgalByCdgalpaoobj())));
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
        if (getIjtbgalByCdgalpao() != null) {
            _hashCode += getIjtbgalByCdgalpao().hashCode();
        }
        if (getIjtbgalByCdgalpaoobj() != null) {
            _hashCode += getIjtbgalByCdgalpaoobj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgalobjgal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjgal"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjgalId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbgalByCdgalpao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbgalByCdgalpao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbgalByCdgalpaoobj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbgalByCdgalpaoobj"));
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
