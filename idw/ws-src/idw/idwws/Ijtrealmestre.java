/**
 * Ijtrealmestre.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtrealmestre  implements java.io.Serializable {
    private java.lang.String cdmestre;

    private java.lang.String cdturno;

    private java.util.Calendar dthrfturno;

    private java.util.Calendar dthriturno;

    private java.util.Calendar dthrsistema;

    private java.util.Calendar dtrefturno;

    private idw.idwws.Ijtbmestres ijtbmestres;

    public Ijtrealmestre() {
    }

    public Ijtrealmestre(
           java.lang.String cdmestre,
           java.lang.String cdturno,
           java.util.Calendar dthrfturno,
           java.util.Calendar dthriturno,
           java.util.Calendar dthrsistema,
           java.util.Calendar dtrefturno,
           idw.idwws.Ijtbmestres ijtbmestres) {
           this.cdmestre = cdmestre;
           this.cdturno = cdturno;
           this.dthrfturno = dthrfturno;
           this.dthriturno = dthriturno;
           this.dthrsistema = dthrsistema;
           this.dtrefturno = dtrefturno;
           this.ijtbmestres = ijtbmestres;
    }


    /**
     * Gets the cdmestre value for this Ijtrealmestre.
     * 
     * @return cdmestre
     */
    public java.lang.String getCdmestre() {
        return cdmestre;
    }


    /**
     * Sets the cdmestre value for this Ijtrealmestre.
     * 
     * @param cdmestre
     */
    public void setCdmestre(java.lang.String cdmestre) {
        this.cdmestre = cdmestre;
    }


    /**
     * Gets the cdturno value for this Ijtrealmestre.
     * 
     * @return cdturno
     */
    public java.lang.String getCdturno() {
        return cdturno;
    }


    /**
     * Sets the cdturno value for this Ijtrealmestre.
     * 
     * @param cdturno
     */
    public void setCdturno(java.lang.String cdturno) {
        this.cdturno = cdturno;
    }


    /**
     * Gets the dthrfturno value for this Ijtrealmestre.
     * 
     * @return dthrfturno
     */
    public java.util.Calendar getDthrfturno() {
        return dthrfturno;
    }


    /**
     * Sets the dthrfturno value for this Ijtrealmestre.
     * 
     * @param dthrfturno
     */
    public void setDthrfturno(java.util.Calendar dthrfturno) {
        this.dthrfturno = dthrfturno;
    }


    /**
     * Gets the dthriturno value for this Ijtrealmestre.
     * 
     * @return dthriturno
     */
    public java.util.Calendar getDthriturno() {
        return dthriturno;
    }


    /**
     * Sets the dthriturno value for this Ijtrealmestre.
     * 
     * @param dthriturno
     */
    public void setDthriturno(java.util.Calendar dthriturno) {
        this.dthriturno = dthriturno;
    }


    /**
     * Gets the dthrsistema value for this Ijtrealmestre.
     * 
     * @return dthrsistema
     */
    public java.util.Calendar getDthrsistema() {
        return dthrsistema;
    }


    /**
     * Sets the dthrsistema value for this Ijtrealmestre.
     * 
     * @param dthrsistema
     */
    public void setDthrsistema(java.util.Calendar dthrsistema) {
        this.dthrsistema = dthrsistema;
    }


    /**
     * Gets the dtrefturno value for this Ijtrealmestre.
     * 
     * @return dtrefturno
     */
    public java.util.Calendar getDtrefturno() {
        return dtrefturno;
    }


    /**
     * Sets the dtrefturno value for this Ijtrealmestre.
     * 
     * @param dtrefturno
     */
    public void setDtrefturno(java.util.Calendar dtrefturno) {
        this.dtrefturno = dtrefturno;
    }


    /**
     * Gets the ijtbmestres value for this Ijtrealmestre.
     * 
     * @return ijtbmestres
     */
    public idw.idwws.Ijtbmestres getIjtbmestres() {
        return ijtbmestres;
    }


    /**
     * Sets the ijtbmestres value for this Ijtrealmestre.
     * 
     * @param ijtbmestres
     */
    public void setIjtbmestres(idw.idwws.Ijtbmestres ijtbmestres) {
        this.ijtbmestres = ijtbmestres;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtrealmestre)) return false;
        Ijtrealmestre other = (Ijtrealmestre) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmestre==null && other.getCdmestre()==null) || 
             (this.cdmestre!=null &&
              this.cdmestre.equals(other.getCdmestre()))) &&
            ((this.cdturno==null && other.getCdturno()==null) || 
             (this.cdturno!=null &&
              this.cdturno.equals(other.getCdturno()))) &&
            ((this.dthrfturno==null && other.getDthrfturno()==null) || 
             (this.dthrfturno!=null &&
              this.dthrfturno.equals(other.getDthrfturno()))) &&
            ((this.dthriturno==null && other.getDthriturno()==null) || 
             (this.dthriturno!=null &&
              this.dthriturno.equals(other.getDthriturno()))) &&
            ((this.dthrsistema==null && other.getDthrsistema()==null) || 
             (this.dthrsistema!=null &&
              this.dthrsistema.equals(other.getDthrsistema()))) &&
            ((this.dtrefturno==null && other.getDtrefturno()==null) || 
             (this.dtrefturno!=null &&
              this.dtrefturno.equals(other.getDtrefturno()))) &&
            ((this.ijtbmestres==null && other.getIjtbmestres()==null) || 
             (this.ijtbmestres!=null &&
              this.ijtbmestres.equals(other.getIjtbmestres())));
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
        if (getCdmestre() != null) {
            _hashCode += getCdmestre().hashCode();
        }
        if (getCdturno() != null) {
            _hashCode += getCdturno().hashCode();
        }
        if (getDthrfturno() != null) {
            _hashCode += getDthrfturno().hashCode();
        }
        if (getDthriturno() != null) {
            _hashCode += getDthriturno().hashCode();
        }
        if (getDthrsistema() != null) {
            _hashCode += getDthrsistema().hashCode();
        }
        if (getDtrefturno() != null) {
            _hashCode += getDtrefturno().hashCode();
        }
        if (getIjtbmestres() != null) {
            _hashCode += getIjtbmestres().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtrealmestre.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtrealmestre"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmestre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmestre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrsistema");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrsistema"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtrefturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtrefturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmestres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmestres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmestres"));
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
