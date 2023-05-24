/**
 * OmInd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmInd  extends idw.idwws.OmIndTemplate  implements java.io.Serializable {
    private java.lang.String cdInd;

    private java.lang.String dsCurta;

    private java.lang.String dsInd;

    private long idInd;

    private idw.idwws.OmCfgind[] omCfginds;

    private idw.idwws.OmIndgt[] omIndgts;

    private idw.idwws.OmIndpt[] omIndpts;

    private idw.idwws.OmIndtppt[] omIndtppts;

    public OmInd() {
    }

    public OmInd(
           boolean eficienciaCiclo,
           boolean eficienciaRealizacao,
           boolean indiceParada,
           boolean indiceRefugo,
           boolean oee,
           boolean produtividade,
           boolean qualidade,
           boolean ritmo,
           boolean ritmoPerc,
           java.lang.String cdInd,
           java.lang.String dsCurta,
           java.lang.String dsInd,
           long idInd,
           idw.idwws.OmCfgind[] omCfginds,
           idw.idwws.OmIndgt[] omIndgts,
           idw.idwws.OmIndpt[] omIndpts,
           idw.idwws.OmIndtppt[] omIndtppts) {
        super(
            eficienciaCiclo,
            eficienciaRealizacao,
            indiceParada,
            indiceRefugo,
            oee,
            produtividade,
            qualidade,
            ritmo,
            ritmoPerc);
        this.cdInd = cdInd;
        this.dsCurta = dsCurta;
        this.dsInd = dsInd;
        this.idInd = idInd;
        this.omCfginds = omCfginds;
        this.omIndgts = omIndgts;
        this.omIndpts = omIndpts;
        this.omIndtppts = omIndtppts;
    }


    /**
     * Gets the cdInd value for this OmInd.
     * 
     * @return cdInd
     */
    public java.lang.String getCdInd() {
        return cdInd;
    }


    /**
     * Sets the cdInd value for this OmInd.
     * 
     * @param cdInd
     */
    public void setCdInd(java.lang.String cdInd) {
        this.cdInd = cdInd;
    }


    /**
     * Gets the dsCurta value for this OmInd.
     * 
     * @return dsCurta
     */
    public java.lang.String getDsCurta() {
        return dsCurta;
    }


    /**
     * Sets the dsCurta value for this OmInd.
     * 
     * @param dsCurta
     */
    public void setDsCurta(java.lang.String dsCurta) {
        this.dsCurta = dsCurta;
    }


    /**
     * Gets the dsInd value for this OmInd.
     * 
     * @return dsInd
     */
    public java.lang.String getDsInd() {
        return dsInd;
    }


    /**
     * Sets the dsInd value for this OmInd.
     * 
     * @param dsInd
     */
    public void setDsInd(java.lang.String dsInd) {
        this.dsInd = dsInd;
    }


    /**
     * Gets the idInd value for this OmInd.
     * 
     * @return idInd
     */
    public long getIdInd() {
        return idInd;
    }


    /**
     * Sets the idInd value for this OmInd.
     * 
     * @param idInd
     */
    public void setIdInd(long idInd) {
        this.idInd = idInd;
    }


    /**
     * Gets the omCfginds value for this OmInd.
     * 
     * @return omCfginds
     */
    public idw.idwws.OmCfgind[] getOmCfginds() {
        return omCfginds;
    }


    /**
     * Sets the omCfginds value for this OmInd.
     * 
     * @param omCfginds
     */
    public void setOmCfginds(idw.idwws.OmCfgind[] omCfginds) {
        this.omCfginds = omCfginds;
    }

    public idw.idwws.OmCfgind getOmCfginds(int i) {
        return this.omCfginds[i];
    }

    public void setOmCfginds(int i, idw.idwws.OmCfgind _value) {
        this.omCfginds[i] = _value;
    }


    /**
     * Gets the omIndgts value for this OmInd.
     * 
     * @return omIndgts
     */
    public idw.idwws.OmIndgt[] getOmIndgts() {
        return omIndgts;
    }


    /**
     * Sets the omIndgts value for this OmInd.
     * 
     * @param omIndgts
     */
    public void setOmIndgts(idw.idwws.OmIndgt[] omIndgts) {
        this.omIndgts = omIndgts;
    }

    public idw.idwws.OmIndgt getOmIndgts(int i) {
        return this.omIndgts[i];
    }

    public void setOmIndgts(int i, idw.idwws.OmIndgt _value) {
        this.omIndgts[i] = _value;
    }


    /**
     * Gets the omIndpts value for this OmInd.
     * 
     * @return omIndpts
     */
    public idw.idwws.OmIndpt[] getOmIndpts() {
        return omIndpts;
    }


    /**
     * Sets the omIndpts value for this OmInd.
     * 
     * @param omIndpts
     */
    public void setOmIndpts(idw.idwws.OmIndpt[] omIndpts) {
        this.omIndpts = omIndpts;
    }

    public idw.idwws.OmIndpt getOmIndpts(int i) {
        return this.omIndpts[i];
    }

    public void setOmIndpts(int i, idw.idwws.OmIndpt _value) {
        this.omIndpts[i] = _value;
    }


    /**
     * Gets the omIndtppts value for this OmInd.
     * 
     * @return omIndtppts
     */
    public idw.idwws.OmIndtppt[] getOmIndtppts() {
        return omIndtppts;
    }


    /**
     * Sets the omIndtppts value for this OmInd.
     * 
     * @param omIndtppts
     */
    public void setOmIndtppts(idw.idwws.OmIndtppt[] omIndtppts) {
        this.omIndtppts = omIndtppts;
    }

    public idw.idwws.OmIndtppt getOmIndtppts(int i) {
        return this.omIndtppts[i];
    }

    public void setOmIndtppts(int i, idw.idwws.OmIndtppt _value) {
        this.omIndtppts[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmInd)) return false;
        OmInd other = (OmInd) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdInd==null && other.getCdInd()==null) || 
             (this.cdInd!=null &&
              this.cdInd.equals(other.getCdInd()))) &&
            ((this.dsCurta==null && other.getDsCurta()==null) || 
             (this.dsCurta!=null &&
              this.dsCurta.equals(other.getDsCurta()))) &&
            ((this.dsInd==null && other.getDsInd()==null) || 
             (this.dsInd!=null &&
              this.dsInd.equals(other.getDsInd()))) &&
            this.idInd == other.getIdInd() &&
            ((this.omCfginds==null && other.getOmCfginds()==null) || 
             (this.omCfginds!=null &&
              java.util.Arrays.equals(this.omCfginds, other.getOmCfginds()))) &&
            ((this.omIndgts==null && other.getOmIndgts()==null) || 
             (this.omIndgts!=null &&
              java.util.Arrays.equals(this.omIndgts, other.getOmIndgts()))) &&
            ((this.omIndpts==null && other.getOmIndpts()==null) || 
             (this.omIndpts!=null &&
              java.util.Arrays.equals(this.omIndpts, other.getOmIndpts()))) &&
            ((this.omIndtppts==null && other.getOmIndtppts()==null) || 
             (this.omIndtppts!=null &&
              java.util.Arrays.equals(this.omIndtppts, other.getOmIndtppts())));
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
        if (getCdInd() != null) {
            _hashCode += getCdInd().hashCode();
        }
        if (getDsCurta() != null) {
            _hashCode += getDsCurta().hashCode();
        }
        if (getDsInd() != null) {
            _hashCode += getDsInd().hashCode();
        }
        _hashCode += new Long(getIdInd()).hashCode();
        if (getOmCfginds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfginds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfginds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmIndgts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmIndgts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmIndgts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmIndpts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmIndpts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmIndpts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmIndtppts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmIndtppts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmIndtppts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmInd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omInd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCurta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCurta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfginds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfginds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgind"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omIndgts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omIndgts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndgt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omIndpts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omIndpts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omIndtppts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omIndtppts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndtppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
