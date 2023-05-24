/**
 * OmHomopt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmHomopt  extends idw.idwws.OmHomoptTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrHomopt;

    private long idHomo;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsrByIdUsr;

    private idw.idwws.OmUsr omUsrByIdUsrhomologado;

    private java.lang.Byte tpHomopt;

    public OmHomopt() {
    }

    public OmHomopt(
           java.util.Calendar dthrHomopt,
           long idHomo,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsr,
           idw.idwws.OmUsr omUsrByIdUsrhomologado,
           java.lang.Byte tpHomopt) {
        this.dthrHomopt = dthrHomopt;
        this.idHomo = idHomo;
        this.omPt = omPt;
        this.omUsrByIdUsr = omUsrByIdUsr;
        this.omUsrByIdUsrhomologado = omUsrByIdUsrhomologado;
        this.tpHomopt = tpHomopt;
    }


    /**
     * Gets the dthrHomopt value for this OmHomopt.
     * 
     * @return dthrHomopt
     */
    public java.util.Calendar getDthrHomopt() {
        return dthrHomopt;
    }


    /**
     * Sets the dthrHomopt value for this OmHomopt.
     * 
     * @param dthrHomopt
     */
    public void setDthrHomopt(java.util.Calendar dthrHomopt) {
        this.dthrHomopt = dthrHomopt;
    }


    /**
     * Gets the idHomo value for this OmHomopt.
     * 
     * @return idHomo
     */
    public long getIdHomo() {
        return idHomo;
    }


    /**
     * Sets the idHomo value for this OmHomopt.
     * 
     * @param idHomo
     */
    public void setIdHomo(long idHomo) {
        this.idHomo = idHomo;
    }


    /**
     * Gets the omPt value for this OmHomopt.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmHomopt.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsrByIdUsr value for this OmHomopt.
     * 
     * @return omUsrByIdUsr
     */
    public idw.idwws.OmUsr getOmUsrByIdUsr() {
        return omUsrByIdUsr;
    }


    /**
     * Sets the omUsrByIdUsr value for this OmHomopt.
     * 
     * @param omUsrByIdUsr
     */
    public void setOmUsrByIdUsr(idw.idwws.OmUsr omUsrByIdUsr) {
        this.omUsrByIdUsr = omUsrByIdUsr;
    }


    /**
     * Gets the omUsrByIdUsrhomologado value for this OmHomopt.
     * 
     * @return omUsrByIdUsrhomologado
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrhomologado() {
        return omUsrByIdUsrhomologado;
    }


    /**
     * Sets the omUsrByIdUsrhomologado value for this OmHomopt.
     * 
     * @param omUsrByIdUsrhomologado
     */
    public void setOmUsrByIdUsrhomologado(idw.idwws.OmUsr omUsrByIdUsrhomologado) {
        this.omUsrByIdUsrhomologado = omUsrByIdUsrhomologado;
    }


    /**
     * Gets the tpHomopt value for this OmHomopt.
     * 
     * @return tpHomopt
     */
    public java.lang.Byte getTpHomopt() {
        return tpHomopt;
    }


    /**
     * Sets the tpHomopt value for this OmHomopt.
     * 
     * @param tpHomopt
     */
    public void setTpHomopt(java.lang.Byte tpHomopt) {
        this.tpHomopt = tpHomopt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmHomopt)) return false;
        OmHomopt other = (OmHomopt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrHomopt==null && other.getDthrHomopt()==null) || 
             (this.dthrHomopt!=null &&
              this.dthrHomopt.equals(other.getDthrHomopt()))) &&
            this.idHomo == other.getIdHomo() &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsrByIdUsr==null && other.getOmUsrByIdUsr()==null) || 
             (this.omUsrByIdUsr!=null &&
              this.omUsrByIdUsr.equals(other.getOmUsrByIdUsr()))) &&
            ((this.omUsrByIdUsrhomologado==null && other.getOmUsrByIdUsrhomologado()==null) || 
             (this.omUsrByIdUsrhomologado!=null &&
              this.omUsrByIdUsrhomologado.equals(other.getOmUsrByIdUsrhomologado()))) &&
            ((this.tpHomopt==null && other.getTpHomopt()==null) || 
             (this.tpHomopt!=null &&
              this.tpHomopt.equals(other.getTpHomopt())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDthrHomopt() != null) {
            _hashCode += getDthrHomopt().hashCode();
        }
        _hashCode += new Long(getIdHomo()).hashCode();
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsrByIdUsr() != null) {
            _hashCode += getOmUsrByIdUsr().hashCode();
        }
        if (getOmUsrByIdUsrhomologado() != null) {
            _hashCode += getOmUsrByIdUsrhomologado().hashCode();
        }
        if (getTpHomopt() != null) {
            _hashCode += getTpHomopt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmHomopt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomopt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrHomopt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrHomopt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idHomo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idHomo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrhomologado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrhomologado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpHomopt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpHomopt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
