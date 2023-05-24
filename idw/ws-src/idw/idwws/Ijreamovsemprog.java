/**
 * Ijreamovsemprog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreamovsemprog  implements java.io.Serializable {
    private java.util.Calendar dthrfsemprog;

    private idw.idwws.IjreamovsemprogId id;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbmotsemprog ijtbmotsemprog;

    private idw.idwws.Ijtbusu ijtbusuByCdtecfsemprog;

    private idw.idwws.Ijtbusu ijtbusuByCdtecisemprog;

    public Ijreamovsemprog() {
    }

    public Ijreamovsemprog(
           java.util.Calendar dthrfsemprog,
           idw.idwws.IjreamovsemprogId id,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbmotsemprog ijtbmotsemprog,
           idw.idwws.Ijtbusu ijtbusuByCdtecfsemprog,
           idw.idwws.Ijtbusu ijtbusuByCdtecisemprog) {
           this.dthrfsemprog = dthrfsemprog;
           this.id = id;
           this.ijtbinj = ijtbinj;
           this.ijtbmotsemprog = ijtbmotsemprog;
           this.ijtbusuByCdtecfsemprog = ijtbusuByCdtecfsemprog;
           this.ijtbusuByCdtecisemprog = ijtbusuByCdtecisemprog;
    }


    /**
     * Gets the dthrfsemprog value for this Ijreamovsemprog.
     * 
     * @return dthrfsemprog
     */
    public java.util.Calendar getDthrfsemprog() {
        return dthrfsemprog;
    }


    /**
     * Sets the dthrfsemprog value for this Ijreamovsemprog.
     * 
     * @param dthrfsemprog
     */
    public void setDthrfsemprog(java.util.Calendar dthrfsemprog) {
        this.dthrfsemprog = dthrfsemprog;
    }


    /**
     * Gets the id value for this Ijreamovsemprog.
     * 
     * @return id
     */
    public idw.idwws.IjreamovsemprogId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreamovsemprog.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreamovsemprogId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinj value for this Ijreamovsemprog.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijreamovsemprog.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbmotsemprog value for this Ijreamovsemprog.
     * 
     * @return ijtbmotsemprog
     */
    public idw.idwws.Ijtbmotsemprog getIjtbmotsemprog() {
        return ijtbmotsemprog;
    }


    /**
     * Sets the ijtbmotsemprog value for this Ijreamovsemprog.
     * 
     * @param ijtbmotsemprog
     */
    public void setIjtbmotsemprog(idw.idwws.Ijtbmotsemprog ijtbmotsemprog) {
        this.ijtbmotsemprog = ijtbmotsemprog;
    }


    /**
     * Gets the ijtbusuByCdtecfsemprog value for this Ijreamovsemprog.
     * 
     * @return ijtbusuByCdtecfsemprog
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdtecfsemprog() {
        return ijtbusuByCdtecfsemprog;
    }


    /**
     * Sets the ijtbusuByCdtecfsemprog value for this Ijreamovsemprog.
     * 
     * @param ijtbusuByCdtecfsemprog
     */
    public void setIjtbusuByCdtecfsemprog(idw.idwws.Ijtbusu ijtbusuByCdtecfsemprog) {
        this.ijtbusuByCdtecfsemprog = ijtbusuByCdtecfsemprog;
    }


    /**
     * Gets the ijtbusuByCdtecisemprog value for this Ijreamovsemprog.
     * 
     * @return ijtbusuByCdtecisemprog
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdtecisemprog() {
        return ijtbusuByCdtecisemprog;
    }


    /**
     * Sets the ijtbusuByCdtecisemprog value for this Ijreamovsemprog.
     * 
     * @param ijtbusuByCdtecisemprog
     */
    public void setIjtbusuByCdtecisemprog(idw.idwws.Ijtbusu ijtbusuByCdtecisemprog) {
        this.ijtbusuByCdtecisemprog = ijtbusuByCdtecisemprog;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreamovsemprog)) return false;
        Ijreamovsemprog other = (Ijreamovsemprog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfsemprog==null && other.getDthrfsemprog()==null) || 
             (this.dthrfsemprog!=null &&
              this.dthrfsemprog.equals(other.getDthrfsemprog()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbmotsemprog==null && other.getIjtbmotsemprog()==null) || 
             (this.ijtbmotsemprog!=null &&
              this.ijtbmotsemprog.equals(other.getIjtbmotsemprog()))) &&
            ((this.ijtbusuByCdtecfsemprog==null && other.getIjtbusuByCdtecfsemprog()==null) || 
             (this.ijtbusuByCdtecfsemprog!=null &&
              this.ijtbusuByCdtecfsemprog.equals(other.getIjtbusuByCdtecfsemprog()))) &&
            ((this.ijtbusuByCdtecisemprog==null && other.getIjtbusuByCdtecisemprog()==null) || 
             (this.ijtbusuByCdtecisemprog!=null &&
              this.ijtbusuByCdtecisemprog.equals(other.getIjtbusuByCdtecisemprog())));
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
        if (getDthrfsemprog() != null) {
            _hashCode += getDthrfsemprog().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbmotsemprog() != null) {
            _hashCode += getIjtbmotsemprog().hashCode();
        }
        if (getIjtbusuByCdtecfsemprog() != null) {
            _hashCode += getIjtbusuByCdtecfsemprog().hashCode();
        }
        if (getIjtbusuByCdtecisemprog() != null) {
            _hashCode += getIjtbusuByCdtecisemprog().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreamovsemprog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreamovsemprog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfsemprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfsemprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreamovsemprogId"));
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
        elemField.setFieldName("ijtbmotsemprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmotsemprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmotsemprog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdtecfsemprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdtecfsemprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdtecisemprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdtecisemprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
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
