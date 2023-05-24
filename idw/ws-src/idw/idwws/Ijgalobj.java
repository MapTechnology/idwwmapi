/**
 * Ijgalobj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgalobj  implements java.io.Serializable {
    private idw.idwws.IjgalobjId id;

    private idw.idwws.Ijtbgal ijtbgal;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbpostos ijtbpostos;

    public Ijgalobj() {
    }

    public Ijgalobj(
           idw.idwws.IjgalobjId id,
           idw.idwws.Ijtbgal ijtbgal,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbpostos ijtbpostos) {
           this.id = id;
           this.ijtbgal = ijtbgal;
           this.ijtbinj = ijtbinj;
           this.ijtbpostos = ijtbpostos;
    }


    /**
     * Gets the id value for this Ijgalobj.
     * 
     * @return id
     */
    public idw.idwws.IjgalobjId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgalobj.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgalobjId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbgal value for this Ijgalobj.
     * 
     * @return ijtbgal
     */
    public idw.idwws.Ijtbgal getIjtbgal() {
        return ijtbgal;
    }


    /**
     * Sets the ijtbgal value for this Ijgalobj.
     * 
     * @param ijtbgal
     */
    public void setIjtbgal(idw.idwws.Ijtbgal ijtbgal) {
        this.ijtbgal = ijtbgal;
    }


    /**
     * Gets the ijtbinj value for this Ijgalobj.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijgalobj.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbpostos value for this Ijgalobj.
     * 
     * @return ijtbpostos
     */
    public idw.idwws.Ijtbpostos getIjtbpostos() {
        return ijtbpostos;
    }


    /**
     * Sets the ijtbpostos value for this Ijgalobj.
     * 
     * @param ijtbpostos
     */
    public void setIjtbpostos(idw.idwws.Ijtbpostos ijtbpostos) {
        this.ijtbpostos = ijtbpostos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgalobj)) return false;
        Ijgalobj other = (Ijgalobj) obj;
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
            ((this.ijtbgal==null && other.getIjtbgal()==null) || 
             (this.ijtbgal!=null &&
              this.ijtbgal.equals(other.getIjtbgal()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbpostos==null && other.getIjtbpostos()==null) || 
             (this.ijtbpostos!=null &&
              this.ijtbpostos.equals(other.getIjtbpostos())));
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
        if (getIjtbgal() != null) {
            _hashCode += getIjtbgal().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbpostos() != null) {
            _hashCode += getIjtbpostos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgalobj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobjId"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpostos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpostos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpostos"));
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
