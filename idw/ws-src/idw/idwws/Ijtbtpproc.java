/**
 * Ijtbtpproc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtpproc  implements java.io.Serializable {
    private java.lang.String cdtpproc;

    private java.lang.String dstpproc;

    private idw.idwws.Ijtbinjtpproc[] ijtbinjtpprocs;

    public Ijtbtpproc() {
    }

    public Ijtbtpproc(
           java.lang.String cdtpproc,
           java.lang.String dstpproc,
           idw.idwws.Ijtbinjtpproc[] ijtbinjtpprocs) {
           this.cdtpproc = cdtpproc;
           this.dstpproc = dstpproc;
           this.ijtbinjtpprocs = ijtbinjtpprocs;
    }


    /**
     * Gets the cdtpproc value for this Ijtbtpproc.
     * 
     * @return cdtpproc
     */
    public java.lang.String getCdtpproc() {
        return cdtpproc;
    }


    /**
     * Sets the cdtpproc value for this Ijtbtpproc.
     * 
     * @param cdtpproc
     */
    public void setCdtpproc(java.lang.String cdtpproc) {
        this.cdtpproc = cdtpproc;
    }


    /**
     * Gets the dstpproc value for this Ijtbtpproc.
     * 
     * @return dstpproc
     */
    public java.lang.String getDstpproc() {
        return dstpproc;
    }


    /**
     * Sets the dstpproc value for this Ijtbtpproc.
     * 
     * @param dstpproc
     */
    public void setDstpproc(java.lang.String dstpproc) {
        this.dstpproc = dstpproc;
    }


    /**
     * Gets the ijtbinjtpprocs value for this Ijtbtpproc.
     * 
     * @return ijtbinjtpprocs
     */
    public idw.idwws.Ijtbinjtpproc[] getIjtbinjtpprocs() {
        return ijtbinjtpprocs;
    }


    /**
     * Sets the ijtbinjtpprocs value for this Ijtbtpproc.
     * 
     * @param ijtbinjtpprocs
     */
    public void setIjtbinjtpprocs(idw.idwws.Ijtbinjtpproc[] ijtbinjtpprocs) {
        this.ijtbinjtpprocs = ijtbinjtpprocs;
    }

    public idw.idwws.Ijtbinjtpproc getIjtbinjtpprocs(int i) {
        return this.ijtbinjtpprocs[i];
    }

    public void setIjtbinjtpprocs(int i, idw.idwws.Ijtbinjtpproc _value) {
        this.ijtbinjtpprocs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtpproc)) return false;
        Ijtbtpproc other = (Ijtbtpproc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdtpproc==null && other.getCdtpproc()==null) || 
             (this.cdtpproc!=null &&
              this.cdtpproc.equals(other.getCdtpproc()))) &&
            ((this.dstpproc==null && other.getDstpproc()==null) || 
             (this.dstpproc!=null &&
              this.dstpproc.equals(other.getDstpproc()))) &&
            ((this.ijtbinjtpprocs==null && other.getIjtbinjtpprocs()==null) || 
             (this.ijtbinjtpprocs!=null &&
              java.util.Arrays.equals(this.ijtbinjtpprocs, other.getIjtbinjtpprocs())));
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
        if (getCdtpproc() != null) {
            _hashCode += getCdtpproc().hashCode();
        }
        if (getDstpproc() != null) {
            _hashCode += getDstpproc().hashCode();
        }
        if (getIjtbinjtpprocs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbinjtpprocs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbinjtpprocs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtpproc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpproc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtpproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtpproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstpproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstpproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjtpprocs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjtpprocs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinjtpproc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
