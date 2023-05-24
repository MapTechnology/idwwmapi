/**
 * Ijficcnc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijficcnc  implements java.io.Serializable {
    private idw.idwws.IjficcncId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbitemcnc ijtbitemcnc;

    private java.lang.Double vlidealdefinido;

    private java.lang.Double vlmaxdefinido;

    private java.lang.Double vlmindefinido;

    public Ijficcnc() {
    }

    public Ijficcnc(
           idw.idwws.IjficcncId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbitemcnc ijtbitemcnc,
           java.lang.Double vlidealdefinido,
           java.lang.Double vlmaxdefinido,
           java.lang.Double vlmindefinido) {
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijtbinj = ijtbinj;
           this.ijtbitemcnc = ijtbitemcnc;
           this.vlidealdefinido = vlidealdefinido;
           this.vlmaxdefinido = vlmaxdefinido;
           this.vlmindefinido = vlmindefinido;
    }


    /**
     * Gets the id value for this Ijficcnc.
     * 
     * @return id
     */
    public idw.idwws.IjficcncId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijficcnc.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjficcncId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijficcnc.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijficcnc.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijtbinj value for this Ijficcnc.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijficcnc.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbitemcnc value for this Ijficcnc.
     * 
     * @return ijtbitemcnc
     */
    public idw.idwws.Ijtbitemcnc getIjtbitemcnc() {
        return ijtbitemcnc;
    }


    /**
     * Sets the ijtbitemcnc value for this Ijficcnc.
     * 
     * @param ijtbitemcnc
     */
    public void setIjtbitemcnc(idw.idwws.Ijtbitemcnc ijtbitemcnc) {
        this.ijtbitemcnc = ijtbitemcnc;
    }


    /**
     * Gets the vlidealdefinido value for this Ijficcnc.
     * 
     * @return vlidealdefinido
     */
    public java.lang.Double getVlidealdefinido() {
        return vlidealdefinido;
    }


    /**
     * Sets the vlidealdefinido value for this Ijficcnc.
     * 
     * @param vlidealdefinido
     */
    public void setVlidealdefinido(java.lang.Double vlidealdefinido) {
        this.vlidealdefinido = vlidealdefinido;
    }


    /**
     * Gets the vlmaxdefinido value for this Ijficcnc.
     * 
     * @return vlmaxdefinido
     */
    public java.lang.Double getVlmaxdefinido() {
        return vlmaxdefinido;
    }


    /**
     * Sets the vlmaxdefinido value for this Ijficcnc.
     * 
     * @param vlmaxdefinido
     */
    public void setVlmaxdefinido(java.lang.Double vlmaxdefinido) {
        this.vlmaxdefinido = vlmaxdefinido;
    }


    /**
     * Gets the vlmindefinido value for this Ijficcnc.
     * 
     * @return vlmindefinido
     */
    public java.lang.Double getVlmindefinido() {
        return vlmindefinido;
    }


    /**
     * Sets the vlmindefinido value for this Ijficcnc.
     * 
     * @param vlmindefinido
     */
    public void setVlmindefinido(java.lang.Double vlmindefinido) {
        this.vlmindefinido = vlmindefinido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijficcnc)) return false;
        Ijficcnc other = (Ijficcnc) obj;
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
            ((this.vlidealdefinido==null && other.getVlidealdefinido()==null) || 
             (this.vlidealdefinido!=null &&
              this.vlidealdefinido.equals(other.getVlidealdefinido()))) &&
            ((this.vlmaxdefinido==null && other.getVlmaxdefinido()==null) || 
             (this.vlmaxdefinido!=null &&
              this.vlmaxdefinido.equals(other.getVlmaxdefinido()))) &&
            ((this.vlmindefinido==null && other.getVlmindefinido()==null) || 
             (this.vlmindefinido!=null &&
              this.vlmindefinido.equals(other.getVlmindefinido())));
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
        if (getVlidealdefinido() != null) {
            _hashCode += getVlidealdefinido().hashCode();
        }
        if (getVlmaxdefinido() != null) {
            _hashCode += getVlmaxdefinido().hashCode();
        }
        if (getVlmindefinido() != null) {
            _hashCode += getVlmindefinido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijficcnc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficcnc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficcncId"));
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
        elemField.setFieldName("vlidealdefinido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlidealdefinido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlmaxdefinido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlmaxdefinido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlmindefinido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlmindefinido"));
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
