/**
 * Ijmatrizsetup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmatrizsetup  implements java.io.Serializable {
    private idw.idwws.IjmatrizsetupId id;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbmol ijtbmolByCdmoldeentra;

    private idw.idwws.Ijtbmol ijtbmolByCdmoldesai;

    private java.lang.Double temposetup;

    public Ijmatrizsetup() {
    }

    public Ijmatrizsetup(
           idw.idwws.IjmatrizsetupId id,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbmol ijtbmolByCdmoldeentra,
           idw.idwws.Ijtbmol ijtbmolByCdmoldesai,
           java.lang.Double temposetup) {
           this.id = id;
           this.ijtbinj = ijtbinj;
           this.ijtbmolByCdmoldeentra = ijtbmolByCdmoldeentra;
           this.ijtbmolByCdmoldesai = ijtbmolByCdmoldesai;
           this.temposetup = temposetup;
    }


    /**
     * Gets the id value for this Ijmatrizsetup.
     * 
     * @return id
     */
    public idw.idwws.IjmatrizsetupId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmatrizsetup.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmatrizsetupId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinj value for this Ijmatrizsetup.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijmatrizsetup.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbmolByCdmoldeentra value for this Ijmatrizsetup.
     * 
     * @return ijtbmolByCdmoldeentra
     */
    public idw.idwws.Ijtbmol getIjtbmolByCdmoldeentra() {
        return ijtbmolByCdmoldeentra;
    }


    /**
     * Sets the ijtbmolByCdmoldeentra value for this Ijmatrizsetup.
     * 
     * @param ijtbmolByCdmoldeentra
     */
    public void setIjtbmolByCdmoldeentra(idw.idwws.Ijtbmol ijtbmolByCdmoldeentra) {
        this.ijtbmolByCdmoldeentra = ijtbmolByCdmoldeentra;
    }


    /**
     * Gets the ijtbmolByCdmoldesai value for this Ijmatrizsetup.
     * 
     * @return ijtbmolByCdmoldesai
     */
    public idw.idwws.Ijtbmol getIjtbmolByCdmoldesai() {
        return ijtbmolByCdmoldesai;
    }


    /**
     * Sets the ijtbmolByCdmoldesai value for this Ijmatrizsetup.
     * 
     * @param ijtbmolByCdmoldesai
     */
    public void setIjtbmolByCdmoldesai(idw.idwws.Ijtbmol ijtbmolByCdmoldesai) {
        this.ijtbmolByCdmoldesai = ijtbmolByCdmoldesai;
    }


    /**
     * Gets the temposetup value for this Ijmatrizsetup.
     * 
     * @return temposetup
     */
    public java.lang.Double getTemposetup() {
        return temposetup;
    }


    /**
     * Sets the temposetup value for this Ijmatrizsetup.
     * 
     * @param temposetup
     */
    public void setTemposetup(java.lang.Double temposetup) {
        this.temposetup = temposetup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmatrizsetup)) return false;
        Ijmatrizsetup other = (Ijmatrizsetup) obj;
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
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbmolByCdmoldeentra==null && other.getIjtbmolByCdmoldeentra()==null) || 
             (this.ijtbmolByCdmoldeentra!=null &&
              this.ijtbmolByCdmoldeentra.equals(other.getIjtbmolByCdmoldeentra()))) &&
            ((this.ijtbmolByCdmoldesai==null && other.getIjtbmolByCdmoldesai()==null) || 
             (this.ijtbmolByCdmoldesai!=null &&
              this.ijtbmolByCdmoldesai.equals(other.getIjtbmolByCdmoldesai()))) &&
            ((this.temposetup==null && other.getTemposetup()==null) || 
             (this.temposetup!=null &&
              this.temposetup.equals(other.getTemposetup())));
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
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbmolByCdmoldeentra() != null) {
            _hashCode += getIjtbmolByCdmoldeentra().hashCode();
        }
        if (getIjtbmolByCdmoldesai() != null) {
            _hashCode += getIjtbmolByCdmoldesai().hashCode();
        }
        if (getTemposetup() != null) {
            _hashCode += getTemposetup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmatrizsetup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmatrizsetup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmatrizsetupId"));
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
        elemField.setFieldName("ijtbmolByCdmoldeentra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmolByCdmoldeentra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmolByCdmoldesai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmolByCdmoldesai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temposetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temposetup"));
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
