/**
 * Ijhorexc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijhorexc  implements java.io.Serializable {
    private java.math.BigDecimal conscalefi;

    private java.util.Calendar dthrfexchor;

    private idw.idwws.IjhorexcId id;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbtphor ijtbtphor;

    public Ijhorexc() {
    }

    public Ijhorexc(
           java.math.BigDecimal conscalefi,
           java.util.Calendar dthrfexchor,
           idw.idwws.IjhorexcId id,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbtphor ijtbtphor) {
           this.conscalefi = conscalefi;
           this.dthrfexchor = dthrfexchor;
           this.id = id;
           this.ijtbinj = ijtbinj;
           this.ijtbtphor = ijtbtphor;
    }


    /**
     * Gets the conscalefi value for this Ijhorexc.
     * 
     * @return conscalefi
     */
    public java.math.BigDecimal getConscalefi() {
        return conscalefi;
    }


    /**
     * Sets the conscalefi value for this Ijhorexc.
     * 
     * @param conscalefi
     */
    public void setConscalefi(java.math.BigDecimal conscalefi) {
        this.conscalefi = conscalefi;
    }


    /**
     * Gets the dthrfexchor value for this Ijhorexc.
     * 
     * @return dthrfexchor
     */
    public java.util.Calendar getDthrfexchor() {
        return dthrfexchor;
    }


    /**
     * Sets the dthrfexchor value for this Ijhorexc.
     * 
     * @param dthrfexchor
     */
    public void setDthrfexchor(java.util.Calendar dthrfexchor) {
        this.dthrfexchor = dthrfexchor;
    }


    /**
     * Gets the id value for this Ijhorexc.
     * 
     * @return id
     */
    public idw.idwws.IjhorexcId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijhorexc.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjhorexcId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinj value for this Ijhorexc.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijhorexc.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbtphor value for this Ijhorexc.
     * 
     * @return ijtbtphor
     */
    public idw.idwws.Ijtbtphor getIjtbtphor() {
        return ijtbtphor;
    }


    /**
     * Sets the ijtbtphor value for this Ijhorexc.
     * 
     * @param ijtbtphor
     */
    public void setIjtbtphor(idw.idwws.Ijtbtphor ijtbtphor) {
        this.ijtbtphor = ijtbtphor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijhorexc)) return false;
        Ijhorexc other = (Ijhorexc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.conscalefi==null && other.getConscalefi()==null) || 
             (this.conscalefi!=null &&
              this.conscalefi.equals(other.getConscalefi()))) &&
            ((this.dthrfexchor==null && other.getDthrfexchor()==null) || 
             (this.dthrfexchor!=null &&
              this.dthrfexchor.equals(other.getDthrfexchor()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbtphor==null && other.getIjtbtphor()==null) || 
             (this.ijtbtphor!=null &&
              this.ijtbtphor.equals(other.getIjtbtphor())));
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
        if (getConscalefi() != null) {
            _hashCode += getConscalefi().hashCode();
        }
        if (getDthrfexchor() != null) {
            _hashCode += getDthrfexchor().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbtphor() != null) {
            _hashCode += getIjtbtphor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijhorexc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhorexc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conscalefi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conscalefi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfexchor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfexchor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhorexcId"));
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
        elemField.setFieldName("ijtbtphor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtphor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtphor"));
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
