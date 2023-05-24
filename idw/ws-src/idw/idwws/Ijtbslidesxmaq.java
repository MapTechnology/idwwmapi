/**
 * Ijtbslidesxmaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbslidesxmaq  implements java.io.Serializable {
    private idw.idwws.IjtbslidesxmaqId id;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbslides ijtbslides;

    public Ijtbslidesxmaq() {
    }

    public Ijtbslidesxmaq(
           idw.idwws.IjtbslidesxmaqId id,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbslides ijtbslides) {
           this.id = id;
           this.ijtbinj = ijtbinj;
           this.ijtbslides = ijtbslides;
    }


    /**
     * Gets the id value for this Ijtbslidesxmaq.
     * 
     * @return id
     */
    public idw.idwws.IjtbslidesxmaqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbslidesxmaq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbslidesxmaqId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinj value for this Ijtbslidesxmaq.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtbslidesxmaq.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbslides value for this Ijtbslidesxmaq.
     * 
     * @return ijtbslides
     */
    public idw.idwws.Ijtbslides getIjtbslides() {
        return ijtbslides;
    }


    /**
     * Sets the ijtbslides value for this Ijtbslidesxmaq.
     * 
     * @param ijtbslides
     */
    public void setIjtbslides(idw.idwws.Ijtbslides ijtbslides) {
        this.ijtbslides = ijtbslides;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbslidesxmaq)) return false;
        Ijtbslidesxmaq other = (Ijtbslidesxmaq) obj;
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
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbslides==null && other.getIjtbslides()==null) || 
             (this.ijtbslides!=null &&
              this.ijtbslides.equals(other.getIjtbslides())));
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
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbslides() != null) {
            _hashCode += getIjtbslides().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbslidesxmaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbslidesxmaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbslidesxmaqId"));
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
        elemField.setFieldName("ijtbslides");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbslides"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbslides"));
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
