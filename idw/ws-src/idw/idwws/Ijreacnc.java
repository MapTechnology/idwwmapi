/**
 * Ijreacnc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreacnc  implements java.io.Serializable {
    private idw.idwws.IjreacncId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbitemcnc ijtbitemcnc;

    private java.lang.Double vldefinido;

    private java.lang.Double vllido;

    public Ijreacnc() {
    }

    public Ijreacnc(
           idw.idwws.IjreacncId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbitemcnc ijtbitemcnc,
           java.lang.Double vldefinido,
           java.lang.Double vllido) {
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijtbinj = ijtbinj;
           this.ijtbitemcnc = ijtbitemcnc;
           this.vldefinido = vldefinido;
           this.vllido = vllido;
    }


    /**
     * Gets the id value for this Ijreacnc.
     * 
     * @return id
     */
    public idw.idwws.IjreacncId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreacnc.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreacncId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijreacnc.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijreacnc.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijtbinj value for this Ijreacnc.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijreacnc.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbitemcnc value for this Ijreacnc.
     * 
     * @return ijtbitemcnc
     */
    public idw.idwws.Ijtbitemcnc getIjtbitemcnc() {
        return ijtbitemcnc;
    }


    /**
     * Sets the ijtbitemcnc value for this Ijreacnc.
     * 
     * @param ijtbitemcnc
     */
    public void setIjtbitemcnc(idw.idwws.Ijtbitemcnc ijtbitemcnc) {
        this.ijtbitemcnc = ijtbitemcnc;
    }


    /**
     * Gets the vldefinido value for this Ijreacnc.
     * 
     * @return vldefinido
     */
    public java.lang.Double getVldefinido() {
        return vldefinido;
    }


    /**
     * Sets the vldefinido value for this Ijreacnc.
     * 
     * @param vldefinido
     */
    public void setVldefinido(java.lang.Double vldefinido) {
        this.vldefinido = vldefinido;
    }


    /**
     * Gets the vllido value for this Ijreacnc.
     * 
     * @return vllido
     */
    public java.lang.Double getVllido() {
        return vllido;
    }


    /**
     * Sets the vllido value for this Ijreacnc.
     * 
     * @param vllido
     */
    public void setVllido(java.lang.Double vllido) {
        this.vllido = vllido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreacnc)) return false;
        Ijreacnc other = (Ijreacnc) obj;
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
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbitemcnc==null && other.getIjtbitemcnc()==null) || 
             (this.ijtbitemcnc!=null &&
              this.ijtbitemcnc.equals(other.getIjtbitemcnc()))) &&
            ((this.vldefinido==null && other.getVldefinido()==null) || 
             (this.vldefinido!=null &&
              this.vldefinido.equals(other.getVldefinido()))) &&
            ((this.vllido==null && other.getVllido()==null) || 
             (this.vllido!=null &&
              this.vllido.equals(other.getVllido())));
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
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbitemcnc() != null) {
            _hashCode += getIjtbitemcnc().hashCode();
        }
        if (getVldefinido() != null) {
            _hashCode += getVldefinido().hashCode();
        }
        if (getVllido() != null) {
            _hashCode += getVllido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreacnc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacnc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacncId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
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
        elemField.setFieldName("ijtbitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbitemcnc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vldefinido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vldefinido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vllido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vllido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
