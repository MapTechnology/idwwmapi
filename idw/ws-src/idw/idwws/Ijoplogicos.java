/**
 * Ijoplogicos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijoplogicos  implements java.io.Serializable {
    private java.lang.String dsintinicial;

    private java.lang.String dsoplogico;

    private idw.idwws.IjoplogicosId id;

    private idw.idwws.Ijlinguas ijlinguas;

    private java.lang.String oplogico;

    public Ijoplogicos() {
    }

    public Ijoplogicos(
           java.lang.String dsintinicial,
           java.lang.String dsoplogico,
           idw.idwws.IjoplogicosId id,
           idw.idwws.Ijlinguas ijlinguas,
           java.lang.String oplogico) {
           this.dsintinicial = dsintinicial;
           this.dsoplogico = dsoplogico;
           this.id = id;
           this.ijlinguas = ijlinguas;
           this.oplogico = oplogico;
    }


    /**
     * Gets the dsintinicial value for this Ijoplogicos.
     * 
     * @return dsintinicial
     */
    public java.lang.String getDsintinicial() {
        return dsintinicial;
    }


    /**
     * Sets the dsintinicial value for this Ijoplogicos.
     * 
     * @param dsintinicial
     */
    public void setDsintinicial(java.lang.String dsintinicial) {
        this.dsintinicial = dsintinicial;
    }


    /**
     * Gets the dsoplogico value for this Ijoplogicos.
     * 
     * @return dsoplogico
     */
    public java.lang.String getDsoplogico() {
        return dsoplogico;
    }


    /**
     * Sets the dsoplogico value for this Ijoplogicos.
     * 
     * @param dsoplogico
     */
    public void setDsoplogico(java.lang.String dsoplogico) {
        this.dsoplogico = dsoplogico;
    }


    /**
     * Gets the id value for this Ijoplogicos.
     * 
     * @return id
     */
    public idw.idwws.IjoplogicosId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijoplogicos.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjoplogicosId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijoplogicos.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijoplogicos.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the oplogico value for this Ijoplogicos.
     * 
     * @return oplogico
     */
    public java.lang.String getOplogico() {
        return oplogico;
    }


    /**
     * Sets the oplogico value for this Ijoplogicos.
     * 
     * @param oplogico
     */
    public void setOplogico(java.lang.String oplogico) {
        this.oplogico = oplogico;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijoplogicos)) return false;
        Ijoplogicos other = (Ijoplogicos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsintinicial==null && other.getDsintinicial()==null) || 
             (this.dsintinicial!=null &&
              this.dsintinicial.equals(other.getDsintinicial()))) &&
            ((this.dsoplogico==null && other.getDsoplogico()==null) || 
             (this.dsoplogico!=null &&
              this.dsoplogico.equals(other.getDsoplogico()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.oplogico==null && other.getOplogico()==null) || 
             (this.oplogico!=null &&
              this.oplogico.equals(other.getOplogico())));
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
        if (getDsintinicial() != null) {
            _hashCode += getDsintinicial().hashCode();
        }
        if (getDsoplogico() != null) {
            _hashCode += getDsoplogico().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getOplogico() != null) {
            _hashCode += getOplogico().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijoplogicos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplogicos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsintinicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsintinicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsoplogico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsoplogico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplogicosId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oplogico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oplogico"));
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
