/**
 * Ijopintrasa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijopintrasa  implements java.io.Serializable {
    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbpar ijtbpar;

    private java.lang.String nrop;

    private java.math.BigDecimal percmin;

    private java.math.BigDecimal tmpfechaevt;

    private org.apache.axis.types.UnsignedShort tpop;

    public Ijopintrasa() {
    }

    public Ijopintrasa(
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbpar ijtbpar,
           java.lang.String nrop,
           java.math.BigDecimal percmin,
           java.math.BigDecimal tmpfechaevt,
           org.apache.axis.types.UnsignedShort tpop) {
           this.ijop = ijop;
           this.ijtbpar = ijtbpar;
           this.nrop = nrop;
           this.percmin = percmin;
           this.tmpfechaevt = tmpfechaevt;
           this.tpop = tpop;
    }


    /**
     * Gets the ijop value for this Ijopintrasa.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijopintrasa.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbpar value for this Ijopintrasa.
     * 
     * @return ijtbpar
     */
    public idw.idwws.Ijtbpar getIjtbpar() {
        return ijtbpar;
    }


    /**
     * Sets the ijtbpar value for this Ijopintrasa.
     * 
     * @param ijtbpar
     */
    public void setIjtbpar(idw.idwws.Ijtbpar ijtbpar) {
        this.ijtbpar = ijtbpar;
    }


    /**
     * Gets the nrop value for this Ijopintrasa.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Ijopintrasa.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the percmin value for this Ijopintrasa.
     * 
     * @return percmin
     */
    public java.math.BigDecimal getPercmin() {
        return percmin;
    }


    /**
     * Sets the percmin value for this Ijopintrasa.
     * 
     * @param percmin
     */
    public void setPercmin(java.math.BigDecimal percmin) {
        this.percmin = percmin;
    }


    /**
     * Gets the tmpfechaevt value for this Ijopintrasa.
     * 
     * @return tmpfechaevt
     */
    public java.math.BigDecimal getTmpfechaevt() {
        return tmpfechaevt;
    }


    /**
     * Sets the tmpfechaevt value for this Ijopintrasa.
     * 
     * @param tmpfechaevt
     */
    public void setTmpfechaevt(java.math.BigDecimal tmpfechaevt) {
        this.tmpfechaevt = tmpfechaevt;
    }


    /**
     * Gets the tpop value for this Ijopintrasa.
     * 
     * @return tpop
     */
    public org.apache.axis.types.UnsignedShort getTpop() {
        return tpop;
    }


    /**
     * Sets the tpop value for this Ijopintrasa.
     * 
     * @param tpop
     */
    public void setTpop(org.apache.axis.types.UnsignedShort tpop) {
        this.tpop = tpop;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijopintrasa)) return false;
        Ijopintrasa other = (Ijopintrasa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbpar==null && other.getIjtbpar()==null) || 
             (this.ijtbpar!=null &&
              this.ijtbpar.equals(other.getIjtbpar()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.percmin==null && other.getPercmin()==null) || 
             (this.percmin!=null &&
              this.percmin.equals(other.getPercmin()))) &&
            ((this.tmpfechaevt==null && other.getTmpfechaevt()==null) || 
             (this.tmpfechaevt!=null &&
              this.tmpfechaevt.equals(other.getTmpfechaevt()))) &&
            ((this.tpop==null && other.getTpop()==null) || 
             (this.tpop!=null &&
              this.tpop.equals(other.getTpop())));
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
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbpar() != null) {
            _hashCode += getIjtbpar().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getPercmin() != null) {
            _hashCode += getPercmin().hashCode();
        }
        if (getTmpfechaevt() != null) {
            _hashCode += getTmpfechaevt().hashCode();
        }
        if (getTpop() != null) {
            _hashCode += getTpop().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijopintrasa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopintrasa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpfechaevt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpfechaevt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
