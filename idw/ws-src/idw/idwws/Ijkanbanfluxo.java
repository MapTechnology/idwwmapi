/**
 * Ijkanbanfluxo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijkanbanfluxo  implements java.io.Serializable {
    private java.lang.String cdlocalorigem;

    private idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocaldestino;

    private idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocalorigem;

    public Ijkanbanfluxo() {
    }

    public Ijkanbanfluxo(
           java.lang.String cdlocalorigem,
           idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocaldestino,
           idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocalorigem) {
           this.cdlocalorigem = cdlocalorigem;
           this.ijkanbanlocalByCdlocaldestino = ijkanbanlocalByCdlocaldestino;
           this.ijkanbanlocalByCdlocalorigem = ijkanbanlocalByCdlocalorigem;
    }


    /**
     * Gets the cdlocalorigem value for this Ijkanbanfluxo.
     * 
     * @return cdlocalorigem
     */
    public java.lang.String getCdlocalorigem() {
        return cdlocalorigem;
    }


    /**
     * Sets the cdlocalorigem value for this Ijkanbanfluxo.
     * 
     * @param cdlocalorigem
     */
    public void setCdlocalorigem(java.lang.String cdlocalorigem) {
        this.cdlocalorigem = cdlocalorigem;
    }


    /**
     * Gets the ijkanbanlocalByCdlocaldestino value for this Ijkanbanfluxo.
     * 
     * @return ijkanbanlocalByCdlocaldestino
     */
    public idw.idwws.Ijkanbanlocal getIjkanbanlocalByCdlocaldestino() {
        return ijkanbanlocalByCdlocaldestino;
    }


    /**
     * Sets the ijkanbanlocalByCdlocaldestino value for this Ijkanbanfluxo.
     * 
     * @param ijkanbanlocalByCdlocaldestino
     */
    public void setIjkanbanlocalByCdlocaldestino(idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocaldestino) {
        this.ijkanbanlocalByCdlocaldestino = ijkanbanlocalByCdlocaldestino;
    }


    /**
     * Gets the ijkanbanlocalByCdlocalorigem value for this Ijkanbanfluxo.
     * 
     * @return ijkanbanlocalByCdlocalorigem
     */
    public idw.idwws.Ijkanbanlocal getIjkanbanlocalByCdlocalorigem() {
        return ijkanbanlocalByCdlocalorigem;
    }


    /**
     * Sets the ijkanbanlocalByCdlocalorigem value for this Ijkanbanfluxo.
     * 
     * @param ijkanbanlocalByCdlocalorigem
     */
    public void setIjkanbanlocalByCdlocalorigem(idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocalorigem) {
        this.ijkanbanlocalByCdlocalorigem = ijkanbanlocalByCdlocalorigem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijkanbanfluxo)) return false;
        Ijkanbanfluxo other = (Ijkanbanfluxo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdlocalorigem==null && other.getCdlocalorigem()==null) || 
             (this.cdlocalorigem!=null &&
              this.cdlocalorigem.equals(other.getCdlocalorigem()))) &&
            ((this.ijkanbanlocalByCdlocaldestino==null && other.getIjkanbanlocalByCdlocaldestino()==null) || 
             (this.ijkanbanlocalByCdlocaldestino!=null &&
              this.ijkanbanlocalByCdlocaldestino.equals(other.getIjkanbanlocalByCdlocaldestino()))) &&
            ((this.ijkanbanlocalByCdlocalorigem==null && other.getIjkanbanlocalByCdlocalorigem()==null) || 
             (this.ijkanbanlocalByCdlocalorigem!=null &&
              this.ijkanbanlocalByCdlocalorigem.equals(other.getIjkanbanlocalByCdlocalorigem())));
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
        if (getCdlocalorigem() != null) {
            _hashCode += getCdlocalorigem().hashCode();
        }
        if (getIjkanbanlocalByCdlocaldestino() != null) {
            _hashCode += getIjkanbanlocalByCdlocaldestino().hashCode();
        }
        if (getIjkanbanlocalByCdlocalorigem() != null) {
            _hashCode += getIjkanbanlocalByCdlocalorigem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijkanbanfluxo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanfluxo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlocalorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlocalorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlocalByCdlocaldestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlocalByCdlocaldestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlocal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlocalByCdlocalorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlocalByCdlocalorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlocal"));
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
