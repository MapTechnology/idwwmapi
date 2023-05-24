/**
 * Ijtbvarritmo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbvarritmo  implements java.io.Serializable {
    private java.lang.String cdvarritmo;

    private java.lang.String dsvarritmo;

    private idw.idwws.Exportacao001[] exportacao001S;

    private idw.idwws.Exportacao003[] exportacao003S;

    private idw.idwws.Ijocorvarritmoitem[] ijocorvarritmoitems;

    private java.math.BigDecimal percmax;

    private org.apache.axis.types.UnsignedShort stativo;

    public Ijtbvarritmo() {
    }

    public Ijtbvarritmo(
           java.lang.String cdvarritmo,
           java.lang.String dsvarritmo,
           idw.idwws.Exportacao001[] exportacao001S,
           idw.idwws.Exportacao003[] exportacao003S,
           idw.idwws.Ijocorvarritmoitem[] ijocorvarritmoitems,
           java.math.BigDecimal percmax,
           org.apache.axis.types.UnsignedShort stativo) {
           this.cdvarritmo = cdvarritmo;
           this.dsvarritmo = dsvarritmo;
           this.exportacao001S = exportacao001S;
           this.exportacao003S = exportacao003S;
           this.ijocorvarritmoitems = ijocorvarritmoitems;
           this.percmax = percmax;
           this.stativo = stativo;
    }


    /**
     * Gets the cdvarritmo value for this Ijtbvarritmo.
     * 
     * @return cdvarritmo
     */
    public java.lang.String getCdvarritmo() {
        return cdvarritmo;
    }


    /**
     * Sets the cdvarritmo value for this Ijtbvarritmo.
     * 
     * @param cdvarritmo
     */
    public void setCdvarritmo(java.lang.String cdvarritmo) {
        this.cdvarritmo = cdvarritmo;
    }


    /**
     * Gets the dsvarritmo value for this Ijtbvarritmo.
     * 
     * @return dsvarritmo
     */
    public java.lang.String getDsvarritmo() {
        return dsvarritmo;
    }


    /**
     * Sets the dsvarritmo value for this Ijtbvarritmo.
     * 
     * @param dsvarritmo
     */
    public void setDsvarritmo(java.lang.String dsvarritmo) {
        this.dsvarritmo = dsvarritmo;
    }


    /**
     * Gets the exportacao001S value for this Ijtbvarritmo.
     * 
     * @return exportacao001S
     */
    public idw.idwws.Exportacao001[] getExportacao001S() {
        return exportacao001S;
    }


    /**
     * Sets the exportacao001S value for this Ijtbvarritmo.
     * 
     * @param exportacao001S
     */
    public void setExportacao001S(idw.idwws.Exportacao001[] exportacao001S) {
        this.exportacao001S = exportacao001S;
    }

    public idw.idwws.Exportacao001 getExportacao001S(int i) {
        return this.exportacao001S[i];
    }

    public void setExportacao001S(int i, idw.idwws.Exportacao001 _value) {
        this.exportacao001S[i] = _value;
    }


    /**
     * Gets the exportacao003S value for this Ijtbvarritmo.
     * 
     * @return exportacao003S
     */
    public idw.idwws.Exportacao003[] getExportacao003S() {
        return exportacao003S;
    }


    /**
     * Sets the exportacao003S value for this Ijtbvarritmo.
     * 
     * @param exportacao003S
     */
    public void setExportacao003S(idw.idwws.Exportacao003[] exportacao003S) {
        this.exportacao003S = exportacao003S;
    }

    public idw.idwws.Exportacao003 getExportacao003S(int i) {
        return this.exportacao003S[i];
    }

    public void setExportacao003S(int i, idw.idwws.Exportacao003 _value) {
        this.exportacao003S[i] = _value;
    }


    /**
     * Gets the ijocorvarritmoitems value for this Ijtbvarritmo.
     * 
     * @return ijocorvarritmoitems
     */
    public idw.idwws.Ijocorvarritmoitem[] getIjocorvarritmoitems() {
        return ijocorvarritmoitems;
    }


    /**
     * Sets the ijocorvarritmoitems value for this Ijtbvarritmo.
     * 
     * @param ijocorvarritmoitems
     */
    public void setIjocorvarritmoitems(idw.idwws.Ijocorvarritmoitem[] ijocorvarritmoitems) {
        this.ijocorvarritmoitems = ijocorvarritmoitems;
    }

    public idw.idwws.Ijocorvarritmoitem getIjocorvarritmoitems(int i) {
        return this.ijocorvarritmoitems[i];
    }

    public void setIjocorvarritmoitems(int i, idw.idwws.Ijocorvarritmoitem _value) {
        this.ijocorvarritmoitems[i] = _value;
    }


    /**
     * Gets the percmax value for this Ijtbvarritmo.
     * 
     * @return percmax
     */
    public java.math.BigDecimal getPercmax() {
        return percmax;
    }


    /**
     * Sets the percmax value for this Ijtbvarritmo.
     * 
     * @param percmax
     */
    public void setPercmax(java.math.BigDecimal percmax) {
        this.percmax = percmax;
    }


    /**
     * Gets the stativo value for this Ijtbvarritmo.
     * 
     * @return stativo
     */
    public org.apache.axis.types.UnsignedShort getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbvarritmo.
     * 
     * @param stativo
     */
    public void setStativo(org.apache.axis.types.UnsignedShort stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbvarritmo)) return false;
        Ijtbvarritmo other = (Ijtbvarritmo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdvarritmo==null && other.getCdvarritmo()==null) || 
             (this.cdvarritmo!=null &&
              this.cdvarritmo.equals(other.getCdvarritmo()))) &&
            ((this.dsvarritmo==null && other.getDsvarritmo()==null) || 
             (this.dsvarritmo!=null &&
              this.dsvarritmo.equals(other.getDsvarritmo()))) &&
            ((this.exportacao001S==null && other.getExportacao001S()==null) || 
             (this.exportacao001S!=null &&
              java.util.Arrays.equals(this.exportacao001S, other.getExportacao001S()))) &&
            ((this.exportacao003S==null && other.getExportacao003S()==null) || 
             (this.exportacao003S!=null &&
              java.util.Arrays.equals(this.exportacao003S, other.getExportacao003S()))) &&
            ((this.ijocorvarritmoitems==null && other.getIjocorvarritmoitems()==null) || 
             (this.ijocorvarritmoitems!=null &&
              java.util.Arrays.equals(this.ijocorvarritmoitems, other.getIjocorvarritmoitems()))) &&
            ((this.percmax==null && other.getPercmax()==null) || 
             (this.percmax!=null &&
              this.percmax.equals(other.getPercmax()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo())));
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
        if (getCdvarritmo() != null) {
            _hashCode += getCdvarritmo().hashCode();
        }
        if (getDsvarritmo() != null) {
            _hashCode += getDsvarritmo().hashCode();
        }
        if (getExportacao001S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao001S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao001S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExportacao003S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao003S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao003S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjocorvarritmoitems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjocorvarritmoitems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjocorvarritmoitems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPercmax() != null) {
            _hashCode += getPercmax().hashCode();
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbvarritmo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbvarritmo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdvarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdvarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsvarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsvarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao001S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao001s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao001"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao003S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao003s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao003"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorvarritmoitems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorvarritmoitems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorvarritmoitem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percmax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percmax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
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
