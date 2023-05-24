/**
 * Ijtbinjqldctrl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbinjqldctrl  implements java.io.Serializable {
    private java.math.BigDecimal alepqldpendenviobc;

    private java.util.Calendar dthrfimaleprobqld;

    private java.util.Calendar dthrinialeprobqld;

    private double idregistro;

    private idw.idwws.Ijtbinj ijtbinj;

    private org.apache.axis.types.UnsignedShort stultinspqldbm;

    public Ijtbinjqldctrl() {
    }

    public Ijtbinjqldctrl(
           java.math.BigDecimal alepqldpendenviobc,
           java.util.Calendar dthrfimaleprobqld,
           java.util.Calendar dthrinialeprobqld,
           double idregistro,
           idw.idwws.Ijtbinj ijtbinj,
           org.apache.axis.types.UnsignedShort stultinspqldbm) {
           this.alepqldpendenviobc = alepqldpendenviobc;
           this.dthrfimaleprobqld = dthrfimaleprobqld;
           this.dthrinialeprobqld = dthrinialeprobqld;
           this.idregistro = idregistro;
           this.ijtbinj = ijtbinj;
           this.stultinspqldbm = stultinspqldbm;
    }


    /**
     * Gets the alepqldpendenviobc value for this Ijtbinjqldctrl.
     * 
     * @return alepqldpendenviobc
     */
    public java.math.BigDecimal getAlepqldpendenviobc() {
        return alepqldpendenviobc;
    }


    /**
     * Sets the alepqldpendenviobc value for this Ijtbinjqldctrl.
     * 
     * @param alepqldpendenviobc
     */
    public void setAlepqldpendenviobc(java.math.BigDecimal alepqldpendenviobc) {
        this.alepqldpendenviobc = alepqldpendenviobc;
    }


    /**
     * Gets the dthrfimaleprobqld value for this Ijtbinjqldctrl.
     * 
     * @return dthrfimaleprobqld
     */
    public java.util.Calendar getDthrfimaleprobqld() {
        return dthrfimaleprobqld;
    }


    /**
     * Sets the dthrfimaleprobqld value for this Ijtbinjqldctrl.
     * 
     * @param dthrfimaleprobqld
     */
    public void setDthrfimaleprobqld(java.util.Calendar dthrfimaleprobqld) {
        this.dthrfimaleprobqld = dthrfimaleprobqld;
    }


    /**
     * Gets the dthrinialeprobqld value for this Ijtbinjqldctrl.
     * 
     * @return dthrinialeprobqld
     */
    public java.util.Calendar getDthrinialeprobqld() {
        return dthrinialeprobqld;
    }


    /**
     * Sets the dthrinialeprobqld value for this Ijtbinjqldctrl.
     * 
     * @param dthrinialeprobqld
     */
    public void setDthrinialeprobqld(java.util.Calendar dthrinialeprobqld) {
        this.dthrinialeprobqld = dthrinialeprobqld;
    }


    /**
     * Gets the idregistro value for this Ijtbinjqldctrl.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijtbinjqldctrl.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijtbinj value for this Ijtbinjqldctrl.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtbinjqldctrl.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the stultinspqldbm value for this Ijtbinjqldctrl.
     * 
     * @return stultinspqldbm
     */
    public org.apache.axis.types.UnsignedShort getStultinspqldbm() {
        return stultinspqldbm;
    }


    /**
     * Sets the stultinspqldbm value for this Ijtbinjqldctrl.
     * 
     * @param stultinspqldbm
     */
    public void setStultinspqldbm(org.apache.axis.types.UnsignedShort stultinspqldbm) {
        this.stultinspqldbm = stultinspqldbm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbinjqldctrl)) return false;
        Ijtbinjqldctrl other = (Ijtbinjqldctrl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.alepqldpendenviobc==null && other.getAlepqldpendenviobc()==null) || 
             (this.alepqldpendenviobc!=null &&
              this.alepqldpendenviobc.equals(other.getAlepqldpendenviobc()))) &&
            ((this.dthrfimaleprobqld==null && other.getDthrfimaleprobqld()==null) || 
             (this.dthrfimaleprobqld!=null &&
              this.dthrfimaleprobqld.equals(other.getDthrfimaleprobqld()))) &&
            ((this.dthrinialeprobqld==null && other.getDthrinialeprobqld()==null) || 
             (this.dthrinialeprobqld!=null &&
              this.dthrinialeprobqld.equals(other.getDthrinialeprobqld()))) &&
            this.idregistro == other.getIdregistro() &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.stultinspqldbm==null && other.getStultinspqldbm()==null) || 
             (this.stultinspqldbm!=null &&
              this.stultinspqldbm.equals(other.getStultinspqldbm())));
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
        if (getAlepqldpendenviobc() != null) {
            _hashCode += getAlepqldpendenviobc().hashCode();
        }
        if (getDthrfimaleprobqld() != null) {
            _hashCode += getDthrfimaleprobqld().hashCode();
        }
        if (getDthrinialeprobqld() != null) {
            _hashCode += getDthrinialeprobqld().hashCode();
        }
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getStultinspqldbm() != null) {
            _hashCode += getStultinspqldbm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbinjqldctrl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinjqldctrl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alepqldpendenviobc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "alepqldpendenviobc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfimaleprobqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfimaleprobqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinialeprobqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinialeprobqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("stultinspqldbm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stultinspqldbm"));
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
