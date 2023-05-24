/**
 * Ijpostogrpestproc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijpostogrpestproc  implements java.io.Serializable {
    private idw.idwws.IjpostogrpestprocId id;

    private idw.idwws.Ijgrpestproc ijgrpestproc;

    private idw.idwws.Ijtbpostos ijtbpostos;

    public Ijpostogrpestproc() {
    }

    public Ijpostogrpestproc(
           idw.idwws.IjpostogrpestprocId id,
           idw.idwws.Ijgrpestproc ijgrpestproc,
           idw.idwws.Ijtbpostos ijtbpostos) {
           this.id = id;
           this.ijgrpestproc = ijgrpestproc;
           this.ijtbpostos = ijtbpostos;
    }


    /**
     * Gets the id value for this Ijpostogrpestproc.
     * 
     * @return id
     */
    public idw.idwws.IjpostogrpestprocId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijpostogrpestproc.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjpostogrpestprocId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpestproc value for this Ijpostogrpestproc.
     * 
     * @return ijgrpestproc
     */
    public idw.idwws.Ijgrpestproc getIjgrpestproc() {
        return ijgrpestproc;
    }


    /**
     * Sets the ijgrpestproc value for this Ijpostogrpestproc.
     * 
     * @param ijgrpestproc
     */
    public void setIjgrpestproc(idw.idwws.Ijgrpestproc ijgrpestproc) {
        this.ijgrpestproc = ijgrpestproc;
    }


    /**
     * Gets the ijtbpostos value for this Ijpostogrpestproc.
     * 
     * @return ijtbpostos
     */
    public idw.idwws.Ijtbpostos getIjtbpostos() {
        return ijtbpostos;
    }


    /**
     * Sets the ijtbpostos value for this Ijpostogrpestproc.
     * 
     * @param ijtbpostos
     */
    public void setIjtbpostos(idw.idwws.Ijtbpostos ijtbpostos) {
        this.ijtbpostos = ijtbpostos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijpostogrpestproc)) return false;
        Ijpostogrpestproc other = (Ijpostogrpestproc) obj;
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
            ((this.ijgrpestproc==null && other.getIjgrpestproc()==null) || 
             (this.ijgrpestproc!=null &&
              this.ijgrpestproc.equals(other.getIjgrpestproc()))) &&
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
        if (getIjgrpestproc() != null) {
            _hashCode += getIjgrpestproc().hashCode();
        }
        if (getIjtbpostos() != null) {
            _hashCode += getIjtbpostos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijpostogrpestproc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpostogrpestproc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpostogrpestprocId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpestproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpestproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpestproc"));
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
