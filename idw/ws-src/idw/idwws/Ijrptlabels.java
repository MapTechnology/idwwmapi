/**
 * Ijrptlabels.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijrptlabels  implements java.io.Serializable {
    private java.lang.String dslabel;

    private idw.idwws.IjrptlabelsId id;

    private idw.idwws.Ijrptreports ijrptreports;

    public Ijrptlabels() {
    }

    public Ijrptlabels(
           java.lang.String dslabel,
           idw.idwws.IjrptlabelsId id,
           idw.idwws.Ijrptreports ijrptreports) {
           this.dslabel = dslabel;
           this.id = id;
           this.ijrptreports = ijrptreports;
    }


    /**
     * Gets the dslabel value for this Ijrptlabels.
     * 
     * @return dslabel
     */
    public java.lang.String getDslabel() {
        return dslabel;
    }


    /**
     * Sets the dslabel value for this Ijrptlabels.
     * 
     * @param dslabel
     */
    public void setDslabel(java.lang.String dslabel) {
        this.dslabel = dslabel;
    }


    /**
     * Gets the id value for this Ijrptlabels.
     * 
     * @return id
     */
    public idw.idwws.IjrptlabelsId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijrptlabels.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjrptlabelsId id) {
        this.id = id;
    }


    /**
     * Gets the ijrptreports value for this Ijrptlabels.
     * 
     * @return ijrptreports
     */
    public idw.idwws.Ijrptreports getIjrptreports() {
        return ijrptreports;
    }


    /**
     * Sets the ijrptreports value for this Ijrptlabels.
     * 
     * @param ijrptreports
     */
    public void setIjrptreports(idw.idwws.Ijrptreports ijrptreports) {
        this.ijrptreports = ijrptreports;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijrptlabels)) return false;
        Ijrptlabels other = (Ijrptlabels) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dslabel==null && other.getDslabel()==null) || 
             (this.dslabel!=null &&
              this.dslabel.equals(other.getDslabel()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijrptreports==null && other.getIjrptreports()==null) || 
             (this.ijrptreports!=null &&
              this.ijrptreports.equals(other.getIjrptreports())));
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
        if (getDslabel() != null) {
            _hashCode += getDslabel().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjrptreports() != null) {
            _hashCode += getIjrptreports().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijrptlabels.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrptlabels"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dslabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dslabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrptlabelsId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrptreports");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrptreports"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrptreports"));
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
