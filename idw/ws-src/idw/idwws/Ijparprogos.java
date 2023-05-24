/**
 * Ijparprogos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijparprogos  implements java.io.Serializable {
    private java.util.Calendar dtprevfimmanut;

    private java.util.Calendar dtprevinimanut;

    private idw.idwws.IjparprogosId id;

    private idw.idwws.Ijmanut ijmanut;

    private idw.idwws.Ijparprog ijparprog;

    public Ijparprogos() {
    }

    public Ijparprogos(
           java.util.Calendar dtprevfimmanut,
           java.util.Calendar dtprevinimanut,
           idw.idwws.IjparprogosId id,
           idw.idwws.Ijmanut ijmanut,
           idw.idwws.Ijparprog ijparprog) {
           this.dtprevfimmanut = dtprevfimmanut;
           this.dtprevinimanut = dtprevinimanut;
           this.id = id;
           this.ijmanut = ijmanut;
           this.ijparprog = ijparprog;
    }


    /**
     * Gets the dtprevfimmanut value for this Ijparprogos.
     * 
     * @return dtprevfimmanut
     */
    public java.util.Calendar getDtprevfimmanut() {
        return dtprevfimmanut;
    }


    /**
     * Sets the dtprevfimmanut value for this Ijparprogos.
     * 
     * @param dtprevfimmanut
     */
    public void setDtprevfimmanut(java.util.Calendar dtprevfimmanut) {
        this.dtprevfimmanut = dtprevfimmanut;
    }


    /**
     * Gets the dtprevinimanut value for this Ijparprogos.
     * 
     * @return dtprevinimanut
     */
    public java.util.Calendar getDtprevinimanut() {
        return dtprevinimanut;
    }


    /**
     * Sets the dtprevinimanut value for this Ijparprogos.
     * 
     * @param dtprevinimanut
     */
    public void setDtprevinimanut(java.util.Calendar dtprevinimanut) {
        this.dtprevinimanut = dtprevinimanut;
    }


    /**
     * Gets the id value for this Ijparprogos.
     * 
     * @return id
     */
    public idw.idwws.IjparprogosId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijparprogos.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjparprogosId id) {
        this.id = id;
    }


    /**
     * Gets the ijmanut value for this Ijparprogos.
     * 
     * @return ijmanut
     */
    public idw.idwws.Ijmanut getIjmanut() {
        return ijmanut;
    }


    /**
     * Sets the ijmanut value for this Ijparprogos.
     * 
     * @param ijmanut
     */
    public void setIjmanut(idw.idwws.Ijmanut ijmanut) {
        this.ijmanut = ijmanut;
    }


    /**
     * Gets the ijparprog value for this Ijparprogos.
     * 
     * @return ijparprog
     */
    public idw.idwws.Ijparprog getIjparprog() {
        return ijparprog;
    }


    /**
     * Sets the ijparprog value for this Ijparprogos.
     * 
     * @param ijparprog
     */
    public void setIjparprog(idw.idwws.Ijparprog ijparprog) {
        this.ijparprog = ijparprog;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijparprogos)) return false;
        Ijparprogos other = (Ijparprogos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtprevfimmanut==null && other.getDtprevfimmanut()==null) || 
             (this.dtprevfimmanut!=null &&
              this.dtprevfimmanut.equals(other.getDtprevfimmanut()))) &&
            ((this.dtprevinimanut==null && other.getDtprevinimanut()==null) || 
             (this.dtprevinimanut!=null &&
              this.dtprevinimanut.equals(other.getDtprevinimanut()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijmanut==null && other.getIjmanut()==null) || 
             (this.ijmanut!=null &&
              this.ijmanut.equals(other.getIjmanut()))) &&
            ((this.ijparprog==null && other.getIjparprog()==null) || 
             (this.ijparprog!=null &&
              this.ijparprog.equals(other.getIjparprog())));
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
        if (getDtprevfimmanut() != null) {
            _hashCode += getDtprevfimmanut().hashCode();
        }
        if (getDtprevinimanut() != null) {
            _hashCode += getDtprevinimanut().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjmanut() != null) {
            _hashCode += getIjmanut().hashCode();
        }
        if (getIjparprog() != null) {
            _hashCode += getIjparprog().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijparprogos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparprogos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtprevfimmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtprevfimmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtprevinimanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtprevinimanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparprogosId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparprog"));
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
