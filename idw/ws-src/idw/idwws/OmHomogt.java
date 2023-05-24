/**
 * OmHomogt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmHomogt  extends idw.idwws.OmHomogtTemplate  implements java.io.Serializable {
    private java.util.Calendar dtHomogt;

    private long idHomogt;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmUsr omUsrByIdUsr;

    private idw.idwws.OmUsr omUsrByIdUsrhomologado;

    private java.lang.Byte tpHomogt;

    public OmHomogt() {
    }

    public OmHomogt(
           java.util.Calendar dtHomogt,
           long idHomogt,
           idw.idwws.OmGt omGt,
           idw.idwws.OmUsr omUsrByIdUsr,
           idw.idwws.OmUsr omUsrByIdUsrhomologado,
           java.lang.Byte tpHomogt) {
        this.dtHomogt = dtHomogt;
        this.idHomogt = idHomogt;
        this.omGt = omGt;
        this.omUsrByIdUsr = omUsrByIdUsr;
        this.omUsrByIdUsrhomologado = omUsrByIdUsrhomologado;
        this.tpHomogt = tpHomogt;
    }


    /**
     * Gets the dtHomogt value for this OmHomogt.
     * 
     * @return dtHomogt
     */
    public java.util.Calendar getDtHomogt() {
        return dtHomogt;
    }


    /**
     * Sets the dtHomogt value for this OmHomogt.
     * 
     * @param dtHomogt
     */
    public void setDtHomogt(java.util.Calendar dtHomogt) {
        this.dtHomogt = dtHomogt;
    }


    /**
     * Gets the idHomogt value for this OmHomogt.
     * 
     * @return idHomogt
     */
    public long getIdHomogt() {
        return idHomogt;
    }


    /**
     * Sets the idHomogt value for this OmHomogt.
     * 
     * @param idHomogt
     */
    public void setIdHomogt(long idHomogt) {
        this.idHomogt = idHomogt;
    }


    /**
     * Gets the omGt value for this OmHomogt.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this OmHomogt.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omUsrByIdUsr value for this OmHomogt.
     * 
     * @return omUsrByIdUsr
     */
    public idw.idwws.OmUsr getOmUsrByIdUsr() {
        return omUsrByIdUsr;
    }


    /**
     * Sets the omUsrByIdUsr value for this OmHomogt.
     * 
     * @param omUsrByIdUsr
     */
    public void setOmUsrByIdUsr(idw.idwws.OmUsr omUsrByIdUsr) {
        this.omUsrByIdUsr = omUsrByIdUsr;
    }


    /**
     * Gets the omUsrByIdUsrhomologado value for this OmHomogt.
     * 
     * @return omUsrByIdUsrhomologado
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrhomologado() {
        return omUsrByIdUsrhomologado;
    }


    /**
     * Sets the omUsrByIdUsrhomologado value for this OmHomogt.
     * 
     * @param omUsrByIdUsrhomologado
     */
    public void setOmUsrByIdUsrhomologado(idw.idwws.OmUsr omUsrByIdUsrhomologado) {
        this.omUsrByIdUsrhomologado = omUsrByIdUsrhomologado;
    }


    /**
     * Gets the tpHomogt value for this OmHomogt.
     * 
     * @return tpHomogt
     */
    public java.lang.Byte getTpHomogt() {
        return tpHomogt;
    }


    /**
     * Sets the tpHomogt value for this OmHomogt.
     * 
     * @param tpHomogt
     */
    public void setTpHomogt(java.lang.Byte tpHomogt) {
        this.tpHomogt = tpHomogt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmHomogt)) return false;
        OmHomogt other = (OmHomogt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dtHomogt==null && other.getDtHomogt()==null) || 
             (this.dtHomogt!=null &&
              this.dtHomogt.equals(other.getDtHomogt()))) &&
            this.idHomogt == other.getIdHomogt() &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omUsrByIdUsr==null && other.getOmUsrByIdUsr()==null) || 
             (this.omUsrByIdUsr!=null &&
              this.omUsrByIdUsr.equals(other.getOmUsrByIdUsr()))) &&
            ((this.omUsrByIdUsrhomologado==null && other.getOmUsrByIdUsrhomologado()==null) || 
             (this.omUsrByIdUsrhomologado!=null &&
              this.omUsrByIdUsrhomologado.equals(other.getOmUsrByIdUsrhomologado()))) &&
            ((this.tpHomogt==null && other.getTpHomogt()==null) || 
             (this.tpHomogt!=null &&
              this.tpHomogt.equals(other.getTpHomogt())));
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
        if (getDtHomogt() != null) {
            _hashCode += getDtHomogt().hashCode();
        }
        _hashCode += new Long(getIdHomogt()).hashCode();
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmUsrByIdUsr() != null) {
            _hashCode += getOmUsrByIdUsr().hashCode();
        }
        if (getOmUsrByIdUsrhomologado() != null) {
            _hashCode += getOmUsrByIdUsrhomologado().hashCode();
        }
        if (getTpHomogt() != null) {
            _hashCode += getTpHomogt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmHomogt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omHomogt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHomogt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHomogt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idHomogt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idHomogt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
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
        elemField.setFieldName("tpHomogt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpHomogt"));
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
