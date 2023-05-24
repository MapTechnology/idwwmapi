/**
 * Ijgrpinjpar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpinjpar  implements java.io.Serializable {
    private idw.idwws.IjgrpinjparId id;

    private idw.idwws.Ijgrppar ijgrppar;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijgrpinjpar() {
    }

    public Ijgrpinjpar(
           idw.idwws.IjgrpinjparId id,
           idw.idwws.Ijgrppar ijgrppar,
           idw.idwws.Ijtbinj ijtbinj) {
           this.id = id;
           this.ijgrppar = ijgrppar;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the id value for this Ijgrpinjpar.
     * 
     * @return id
     */
    public idw.idwws.IjgrpinjparId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpinjpar.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpinjparId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrppar value for this Ijgrpinjpar.
     * 
     * @return ijgrppar
     */
    public idw.idwws.Ijgrppar getIjgrppar() {
        return ijgrppar;
    }


    /**
     * Sets the ijgrppar value for this Ijgrpinjpar.
     * 
     * @param ijgrppar
     */
    public void setIjgrppar(idw.idwws.Ijgrppar ijgrppar) {
        this.ijgrppar = ijgrppar;
    }


    /**
     * Gets the ijtbinj value for this Ijgrpinjpar.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijgrpinjpar.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpinjpar)) return false;
        Ijgrpinjpar other = (Ijgrpinjpar) obj;
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
            ((this.ijgrppar==null && other.getIjgrppar()==null) || 
             (this.ijgrppar!=null &&
              this.ijgrppar.equals(other.getIjgrppar()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjgrppar() != null) {
            _hashCode += getIjgrppar().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpinjpar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpinjpar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpinjparId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrppar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrppar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrppar"));
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
