/**
 * Ijtbinjstatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbinjstatus  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private idw.idwws.Ijtbinj ijtbinj;

    private org.apache.axis.types.UnsignedShort stdelayconsol;

    private org.apache.axis.types.UnsignedShort stmanut;

    private org.apache.axis.types.UnsignedShort stperdasinc;

    private org.apache.axis.types.UnsignedShort stprobqld;

    public Ijtbinjstatus() {
    }

    public Ijtbinjstatus(
           java.lang.String cdinjetora,
           idw.idwws.Ijtbinj ijtbinj,
           org.apache.axis.types.UnsignedShort stdelayconsol,
           org.apache.axis.types.UnsignedShort stmanut,
           org.apache.axis.types.UnsignedShort stperdasinc,
           org.apache.axis.types.UnsignedShort stprobqld) {
           this.cdinjetora = cdinjetora;
           this.ijtbinj = ijtbinj;
           this.stdelayconsol = stdelayconsol;
           this.stmanut = stmanut;
           this.stperdasinc = stperdasinc;
           this.stprobqld = stprobqld;
    }


    /**
     * Gets the cdinjetora value for this Ijtbinjstatus.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijtbinjstatus.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the ijtbinj value for this Ijtbinjstatus.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtbinjstatus.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the stdelayconsol value for this Ijtbinjstatus.
     * 
     * @return stdelayconsol
     */
    public org.apache.axis.types.UnsignedShort getStdelayconsol() {
        return stdelayconsol;
    }


    /**
     * Sets the stdelayconsol value for this Ijtbinjstatus.
     * 
     * @param stdelayconsol
     */
    public void setStdelayconsol(org.apache.axis.types.UnsignedShort stdelayconsol) {
        this.stdelayconsol = stdelayconsol;
    }


    /**
     * Gets the stmanut value for this Ijtbinjstatus.
     * 
     * @return stmanut
     */
    public org.apache.axis.types.UnsignedShort getStmanut() {
        return stmanut;
    }


    /**
     * Sets the stmanut value for this Ijtbinjstatus.
     * 
     * @param stmanut
     */
    public void setStmanut(org.apache.axis.types.UnsignedShort stmanut) {
        this.stmanut = stmanut;
    }


    /**
     * Gets the stperdasinc value for this Ijtbinjstatus.
     * 
     * @return stperdasinc
     */
    public org.apache.axis.types.UnsignedShort getStperdasinc() {
        return stperdasinc;
    }


    /**
     * Sets the stperdasinc value for this Ijtbinjstatus.
     * 
     * @param stperdasinc
     */
    public void setStperdasinc(org.apache.axis.types.UnsignedShort stperdasinc) {
        this.stperdasinc = stperdasinc;
    }


    /**
     * Gets the stprobqld value for this Ijtbinjstatus.
     * 
     * @return stprobqld
     */
    public org.apache.axis.types.UnsignedShort getStprobqld() {
        return stprobqld;
    }


    /**
     * Sets the stprobqld value for this Ijtbinjstatus.
     * 
     * @param stprobqld
     */
    public void setStprobqld(org.apache.axis.types.UnsignedShort stprobqld) {
        this.stprobqld = stprobqld;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbinjstatus)) return false;
        Ijtbinjstatus other = (Ijtbinjstatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.stdelayconsol==null && other.getStdelayconsol()==null) || 
             (this.stdelayconsol!=null &&
              this.stdelayconsol.equals(other.getStdelayconsol()))) &&
            ((this.stmanut==null && other.getStmanut()==null) || 
             (this.stmanut!=null &&
              this.stmanut.equals(other.getStmanut()))) &&
            ((this.stperdasinc==null && other.getStperdasinc()==null) || 
             (this.stperdasinc!=null &&
              this.stperdasinc.equals(other.getStperdasinc()))) &&
            ((this.stprobqld==null && other.getStprobqld()==null) || 
             (this.stprobqld!=null &&
              this.stprobqld.equals(other.getStprobqld())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getStdelayconsol() != null) {
            _hashCode += getStdelayconsol().hashCode();
        }
        if (getStmanut() != null) {
            _hashCode += getStmanut().hashCode();
        }
        if (getStperdasinc() != null) {
            _hashCode += getStperdasinc().hashCode();
        }
        if (getStprobqld() != null) {
            _hashCode += getStprobqld().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbinjstatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinjstatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("stdelayconsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stdelayconsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stperdasinc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stperdasinc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stprobqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stprobqld"));
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
