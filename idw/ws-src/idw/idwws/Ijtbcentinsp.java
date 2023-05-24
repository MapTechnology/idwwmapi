/**
 * Ijtbcentinsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbcentinsp  implements java.io.Serializable {
    private java.lang.String cdcentinsp;

    private java.lang.String dscentinsp;

    private java.lang.String idhost;

    private idw.idwws.Ijcomequipcent[] ijcomequipcents;

    private idw.idwws.Ijdrivercentprtdef[] ijdrivercentprtdefs;

    private idw.idwws.Ijdrivercent[] ijdrivercents;

    private idw.idwws.Ijdrvcntexecprtdef[] ijdrvcntexecprtdefs;

    private idw.idwws.Ijinspecao[] ijinspecaos;

    private org.apache.axis.types.UnsignedShort stsincronismo;

    private java.math.BigDecimal tpcentral;

    public Ijtbcentinsp() {
    }

    public Ijtbcentinsp(
           java.lang.String cdcentinsp,
           java.lang.String dscentinsp,
           java.lang.String idhost,
           idw.idwws.Ijcomequipcent[] ijcomequipcents,
           idw.idwws.Ijdrivercentprtdef[] ijdrivercentprtdefs,
           idw.idwws.Ijdrivercent[] ijdrivercents,
           idw.idwws.Ijdrvcntexecprtdef[] ijdrvcntexecprtdefs,
           idw.idwws.Ijinspecao[] ijinspecaos,
           org.apache.axis.types.UnsignedShort stsincronismo,
           java.math.BigDecimal tpcentral) {
           this.cdcentinsp = cdcentinsp;
           this.dscentinsp = dscentinsp;
           this.idhost = idhost;
           this.ijcomequipcents = ijcomequipcents;
           this.ijdrivercentprtdefs = ijdrivercentprtdefs;
           this.ijdrivercents = ijdrivercents;
           this.ijdrvcntexecprtdefs = ijdrvcntexecprtdefs;
           this.ijinspecaos = ijinspecaos;
           this.stsincronismo = stsincronismo;
           this.tpcentral = tpcentral;
    }


    /**
     * Gets the cdcentinsp value for this Ijtbcentinsp.
     * 
     * @return cdcentinsp
     */
    public java.lang.String getCdcentinsp() {
        return cdcentinsp;
    }


    /**
     * Sets the cdcentinsp value for this Ijtbcentinsp.
     * 
     * @param cdcentinsp
     */
    public void setCdcentinsp(java.lang.String cdcentinsp) {
        this.cdcentinsp = cdcentinsp;
    }


    /**
     * Gets the dscentinsp value for this Ijtbcentinsp.
     * 
     * @return dscentinsp
     */
    public java.lang.String getDscentinsp() {
        return dscentinsp;
    }


    /**
     * Sets the dscentinsp value for this Ijtbcentinsp.
     * 
     * @param dscentinsp
     */
    public void setDscentinsp(java.lang.String dscentinsp) {
        this.dscentinsp = dscentinsp;
    }


    /**
     * Gets the idhost value for this Ijtbcentinsp.
     * 
     * @return idhost
     */
    public java.lang.String getIdhost() {
        return idhost;
    }


    /**
     * Sets the idhost value for this Ijtbcentinsp.
     * 
     * @param idhost
     */
    public void setIdhost(java.lang.String idhost) {
        this.idhost = idhost;
    }


    /**
     * Gets the ijcomequipcents value for this Ijtbcentinsp.
     * 
     * @return ijcomequipcents
     */
    public idw.idwws.Ijcomequipcent[] getIjcomequipcents() {
        return ijcomequipcents;
    }


    /**
     * Sets the ijcomequipcents value for this Ijtbcentinsp.
     * 
     * @param ijcomequipcents
     */
    public void setIjcomequipcents(idw.idwws.Ijcomequipcent[] ijcomequipcents) {
        this.ijcomequipcents = ijcomequipcents;
    }

    public idw.idwws.Ijcomequipcent getIjcomequipcents(int i) {
        return this.ijcomequipcents[i];
    }

    public void setIjcomequipcents(int i, idw.idwws.Ijcomequipcent _value) {
        this.ijcomequipcents[i] = _value;
    }


    /**
     * Gets the ijdrivercentprtdefs value for this Ijtbcentinsp.
     * 
     * @return ijdrivercentprtdefs
     */
    public idw.idwws.Ijdrivercentprtdef[] getIjdrivercentprtdefs() {
        return ijdrivercentprtdefs;
    }


    /**
     * Sets the ijdrivercentprtdefs value for this Ijtbcentinsp.
     * 
     * @param ijdrivercentprtdefs
     */
    public void setIjdrivercentprtdefs(idw.idwws.Ijdrivercentprtdef[] ijdrivercentprtdefs) {
        this.ijdrivercentprtdefs = ijdrivercentprtdefs;
    }

    public idw.idwws.Ijdrivercentprtdef getIjdrivercentprtdefs(int i) {
        return this.ijdrivercentprtdefs[i];
    }

    public void setIjdrivercentprtdefs(int i, idw.idwws.Ijdrivercentprtdef _value) {
        this.ijdrivercentprtdefs[i] = _value;
    }


    /**
     * Gets the ijdrivercents value for this Ijtbcentinsp.
     * 
     * @return ijdrivercents
     */
    public idw.idwws.Ijdrivercent[] getIjdrivercents() {
        return ijdrivercents;
    }


    /**
     * Sets the ijdrivercents value for this Ijtbcentinsp.
     * 
     * @param ijdrivercents
     */
    public void setIjdrivercents(idw.idwws.Ijdrivercent[] ijdrivercents) {
        this.ijdrivercents = ijdrivercents;
    }

    public idw.idwws.Ijdrivercent getIjdrivercents(int i) {
        return this.ijdrivercents[i];
    }

    public void setIjdrivercents(int i, idw.idwws.Ijdrivercent _value) {
        this.ijdrivercents[i] = _value;
    }


    /**
     * Gets the ijdrvcntexecprtdefs value for this Ijtbcentinsp.
     * 
     * @return ijdrvcntexecprtdefs
     */
    public idw.idwws.Ijdrvcntexecprtdef[] getIjdrvcntexecprtdefs() {
        return ijdrvcntexecprtdefs;
    }


    /**
     * Sets the ijdrvcntexecprtdefs value for this Ijtbcentinsp.
     * 
     * @param ijdrvcntexecprtdefs
     */
    public void setIjdrvcntexecprtdefs(idw.idwws.Ijdrvcntexecprtdef[] ijdrvcntexecprtdefs) {
        this.ijdrvcntexecprtdefs = ijdrvcntexecprtdefs;
    }

    public idw.idwws.Ijdrvcntexecprtdef getIjdrvcntexecprtdefs(int i) {
        return this.ijdrvcntexecprtdefs[i];
    }

    public void setIjdrvcntexecprtdefs(int i, idw.idwws.Ijdrvcntexecprtdef _value) {
        this.ijdrvcntexecprtdefs[i] = _value;
    }


    /**
     * Gets the ijinspecaos value for this Ijtbcentinsp.
     * 
     * @return ijinspecaos
     */
    public idw.idwws.Ijinspecao[] getIjinspecaos() {
        return ijinspecaos;
    }


    /**
     * Sets the ijinspecaos value for this Ijtbcentinsp.
     * 
     * @param ijinspecaos
     */
    public void setIjinspecaos(idw.idwws.Ijinspecao[] ijinspecaos) {
        this.ijinspecaos = ijinspecaos;
    }

    public idw.idwws.Ijinspecao getIjinspecaos(int i) {
        return this.ijinspecaos[i];
    }

    public void setIjinspecaos(int i, idw.idwws.Ijinspecao _value) {
        this.ijinspecaos[i] = _value;
    }


    /**
     * Gets the stsincronismo value for this Ijtbcentinsp.
     * 
     * @return stsincronismo
     */
    public org.apache.axis.types.UnsignedShort getStsincronismo() {
        return stsincronismo;
    }


    /**
     * Sets the stsincronismo value for this Ijtbcentinsp.
     * 
     * @param stsincronismo
     */
    public void setStsincronismo(org.apache.axis.types.UnsignedShort stsincronismo) {
        this.stsincronismo = stsincronismo;
    }


    /**
     * Gets the tpcentral value for this Ijtbcentinsp.
     * 
     * @return tpcentral
     */
    public java.math.BigDecimal getTpcentral() {
        return tpcentral;
    }


    /**
     * Sets the tpcentral value for this Ijtbcentinsp.
     * 
     * @param tpcentral
     */
    public void setTpcentral(java.math.BigDecimal tpcentral) {
        this.tpcentral = tpcentral;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbcentinsp)) return false;
        Ijtbcentinsp other = (Ijtbcentinsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcentinsp==null && other.getCdcentinsp()==null) || 
             (this.cdcentinsp!=null &&
              this.cdcentinsp.equals(other.getCdcentinsp()))) &&
            ((this.dscentinsp==null && other.getDscentinsp()==null) || 
             (this.dscentinsp!=null &&
              this.dscentinsp.equals(other.getDscentinsp()))) &&
            ((this.idhost==null && other.getIdhost()==null) || 
             (this.idhost!=null &&
              this.idhost.equals(other.getIdhost()))) &&
            ((this.ijcomequipcents==null && other.getIjcomequipcents()==null) || 
             (this.ijcomequipcents!=null &&
              java.util.Arrays.equals(this.ijcomequipcents, other.getIjcomequipcents()))) &&
            ((this.ijdrivercentprtdefs==null && other.getIjdrivercentprtdefs()==null) || 
             (this.ijdrivercentprtdefs!=null &&
              java.util.Arrays.equals(this.ijdrivercentprtdefs, other.getIjdrivercentprtdefs()))) &&
            ((this.ijdrivercents==null && other.getIjdrivercents()==null) || 
             (this.ijdrivercents!=null &&
              java.util.Arrays.equals(this.ijdrivercents, other.getIjdrivercents()))) &&
            ((this.ijdrvcntexecprtdefs==null && other.getIjdrvcntexecprtdefs()==null) || 
             (this.ijdrvcntexecprtdefs!=null &&
              java.util.Arrays.equals(this.ijdrvcntexecprtdefs, other.getIjdrvcntexecprtdefs()))) &&
            ((this.ijinspecaos==null && other.getIjinspecaos()==null) || 
             (this.ijinspecaos!=null &&
              java.util.Arrays.equals(this.ijinspecaos, other.getIjinspecaos()))) &&
            ((this.stsincronismo==null && other.getStsincronismo()==null) || 
             (this.stsincronismo!=null &&
              this.stsincronismo.equals(other.getStsincronismo()))) &&
            ((this.tpcentral==null && other.getTpcentral()==null) || 
             (this.tpcentral!=null &&
              this.tpcentral.equals(other.getTpcentral())));
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
        if (getCdcentinsp() != null) {
            _hashCode += getCdcentinsp().hashCode();
        }
        if (getDscentinsp() != null) {
            _hashCode += getDscentinsp().hashCode();
        }
        if (getIdhost() != null) {
            _hashCode += getIdhost().hashCode();
        }
        if (getIjcomequipcents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcomequipcents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcomequipcents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjdrivercentprtdefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdrivercentprtdefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdrivercentprtdefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjdrivercents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdrivercents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdrivercents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjdrvcntexecprtdefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdrvcntexecprtdefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdrvcntexecprtdefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjinspecaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjinspecaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjinspecaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStsincronismo() != null) {
            _hashCode += getStsincronismo().hashCode();
        }
        if (getTpcentral() != null) {
            _hashCode += getTpcentral().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbcentinsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcentinsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcentinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcentinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscentinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscentinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idhost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idhost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcomequipcents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcomequipcents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomequipcent"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdrivercentprtdefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdrivercentprtdefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercentprtdef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdrivercents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdrivercents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercent"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdrvcntexecprtdefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdrvcntexecprtdefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrvcntexecprtdef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stsincronismo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stsincronismo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpcentral");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpcentral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
