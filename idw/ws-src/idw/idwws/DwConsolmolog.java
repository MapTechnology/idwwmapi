/**
 * DwConsolmolog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolmolog  extends idw.idwws.DwConsolmologTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFlogin;

    private java.util.Calendar dthrIlogin;

    private idw.idwws.DwConsolmooco[] dwConsolmoocos;

    private java.lang.Long idConsolmolog;

    private java.lang.Integer msDthrflogin;

    private java.lang.Integer msDthrilogin;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsr;

    public DwConsolmolog() {
    }

    public DwConsolmolog(
           java.util.Calendar dthrFlogin,
           java.util.Calendar dthrIlogin,
           idw.idwws.DwConsolmooco[] dwConsolmoocos,
           java.lang.Long idConsolmolog,
           java.lang.Integer msDthrflogin,
           java.lang.Integer msDthrilogin,
           idw.idwws.OmGt omGt,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsr) {
        this.dthrFlogin = dthrFlogin;
        this.dthrIlogin = dthrIlogin;
        this.dwConsolmoocos = dwConsolmoocos;
        this.idConsolmolog = idConsolmolog;
        this.msDthrflogin = msDthrflogin;
        this.msDthrilogin = msDthrilogin;
        this.omGt = omGt;
        this.omPt = omPt;
        this.omUsr = omUsr;
    }


    /**
     * Gets the dthrFlogin value for this DwConsolmolog.
     * 
     * @return dthrFlogin
     */
    public java.util.Calendar getDthrFlogin() {
        return dthrFlogin;
    }


    /**
     * Sets the dthrFlogin value for this DwConsolmolog.
     * 
     * @param dthrFlogin
     */
    public void setDthrFlogin(java.util.Calendar dthrFlogin) {
        this.dthrFlogin = dthrFlogin;
    }


    /**
     * Gets the dthrIlogin value for this DwConsolmolog.
     * 
     * @return dthrIlogin
     */
    public java.util.Calendar getDthrIlogin() {
        return dthrIlogin;
    }


    /**
     * Sets the dthrIlogin value for this DwConsolmolog.
     * 
     * @param dthrIlogin
     */
    public void setDthrIlogin(java.util.Calendar dthrIlogin) {
        this.dthrIlogin = dthrIlogin;
    }


    /**
     * Gets the dwConsolmoocos value for this DwConsolmolog.
     * 
     * @return dwConsolmoocos
     */
    public idw.idwws.DwConsolmooco[] getDwConsolmoocos() {
        return dwConsolmoocos;
    }


    /**
     * Sets the dwConsolmoocos value for this DwConsolmolog.
     * 
     * @param dwConsolmoocos
     */
    public void setDwConsolmoocos(idw.idwws.DwConsolmooco[] dwConsolmoocos) {
        this.dwConsolmoocos = dwConsolmoocos;
    }

    public idw.idwws.DwConsolmooco getDwConsolmoocos(int i) {
        return this.dwConsolmoocos[i];
    }

    public void setDwConsolmoocos(int i, idw.idwws.DwConsolmooco _value) {
        this.dwConsolmoocos[i] = _value;
    }


    /**
     * Gets the idConsolmolog value for this DwConsolmolog.
     * 
     * @return idConsolmolog
     */
    public java.lang.Long getIdConsolmolog() {
        return idConsolmolog;
    }


    /**
     * Sets the idConsolmolog value for this DwConsolmolog.
     * 
     * @param idConsolmolog
     */
    public void setIdConsolmolog(java.lang.Long idConsolmolog) {
        this.idConsolmolog = idConsolmolog;
    }


    /**
     * Gets the msDthrflogin value for this DwConsolmolog.
     * 
     * @return msDthrflogin
     */
    public java.lang.Integer getMsDthrflogin() {
        return msDthrflogin;
    }


    /**
     * Sets the msDthrflogin value for this DwConsolmolog.
     * 
     * @param msDthrflogin
     */
    public void setMsDthrflogin(java.lang.Integer msDthrflogin) {
        this.msDthrflogin = msDthrflogin;
    }


    /**
     * Gets the msDthrilogin value for this DwConsolmolog.
     * 
     * @return msDthrilogin
     */
    public java.lang.Integer getMsDthrilogin() {
        return msDthrilogin;
    }


    /**
     * Sets the msDthrilogin value for this DwConsolmolog.
     * 
     * @param msDthrilogin
     */
    public void setMsDthrilogin(java.lang.Integer msDthrilogin) {
        this.msDthrilogin = msDthrilogin;
    }


    /**
     * Gets the omGt value for this DwConsolmolog.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this DwConsolmolog.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omPt value for this DwConsolmolog.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwConsolmolog.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsr value for this DwConsolmolog.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this DwConsolmolog.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolmolog)) return false;
        DwConsolmolog other = (DwConsolmolog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFlogin==null && other.getDthrFlogin()==null) || 
             (this.dthrFlogin!=null &&
              this.dthrFlogin.equals(other.getDthrFlogin()))) &&
            ((this.dthrIlogin==null && other.getDthrIlogin()==null) || 
             (this.dthrIlogin!=null &&
              this.dthrIlogin.equals(other.getDthrIlogin()))) &&
            ((this.dwConsolmoocos==null && other.getDwConsolmoocos()==null) || 
             (this.dwConsolmoocos!=null &&
              java.util.Arrays.equals(this.dwConsolmoocos, other.getDwConsolmoocos()))) &&
            ((this.idConsolmolog==null && other.getIdConsolmolog()==null) || 
             (this.idConsolmolog!=null &&
              this.idConsolmolog.equals(other.getIdConsolmolog()))) &&
            ((this.msDthrflogin==null && other.getMsDthrflogin()==null) || 
             (this.msDthrflogin!=null &&
              this.msDthrflogin.equals(other.getMsDthrflogin()))) &&
            ((this.msDthrilogin==null && other.getMsDthrilogin()==null) || 
             (this.msDthrilogin!=null &&
              this.msDthrilogin.equals(other.getMsDthrilogin()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr())));
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
        if (getDthrFlogin() != null) {
            _hashCode += getDthrFlogin().hashCode();
        }
        if (getDthrIlogin() != null) {
            _hashCode += getDthrIlogin().hashCode();
        }
        if (getDwConsolmoocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmoocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmoocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdConsolmolog() != null) {
            _hashCode += getIdConsolmolog().hashCode();
        }
        if (getMsDthrflogin() != null) {
            _hashCode += getMsDthrflogin().hashCode();
        }
        if (getMsDthrilogin() != null) {
            _hashCode += getMsDthrilogin().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolmolog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmolog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmoocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmoocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmooco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolmolog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolmolog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrflogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrflogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrilogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrilogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
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
