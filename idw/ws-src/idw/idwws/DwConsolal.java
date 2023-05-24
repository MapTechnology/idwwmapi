/**
 * DwConsolal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolal  implements java.io.Serializable {
    private idw.idwws.DwConsol dwConsol;

    private idw.idwws.DwConsolalmo[] dwConsolalmos;

    private idw.idwws.DwConsolaloco[] dwConsolalocos;

    private idw.idwws.DwTAlerta dwTAlerta;

    private java.lang.Long idConsolal;

    private java.math.BigDecimal segAutoTempoalerta;

    private java.math.BigDecimal segManuTempoalerta;

    public DwConsolal() {
    }

    public DwConsolal(
           idw.idwws.DwConsol dwConsol,
           idw.idwws.DwConsolalmo[] dwConsolalmos,
           idw.idwws.DwConsolaloco[] dwConsolalocos,
           idw.idwws.DwTAlerta dwTAlerta,
           java.lang.Long idConsolal,
           java.math.BigDecimal segAutoTempoalerta,
           java.math.BigDecimal segManuTempoalerta) {
           this.dwConsol = dwConsol;
           this.dwConsolalmos = dwConsolalmos;
           this.dwConsolalocos = dwConsolalocos;
           this.dwTAlerta = dwTAlerta;
           this.idConsolal = idConsolal;
           this.segAutoTempoalerta = segAutoTempoalerta;
           this.segManuTempoalerta = segManuTempoalerta;
    }


    /**
     * Gets the dwConsol value for this DwConsolal.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsolal.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the dwConsolalmos value for this DwConsolal.
     * 
     * @return dwConsolalmos
     */
    public idw.idwws.DwConsolalmo[] getDwConsolalmos() {
        return dwConsolalmos;
    }


    /**
     * Sets the dwConsolalmos value for this DwConsolal.
     * 
     * @param dwConsolalmos
     */
    public void setDwConsolalmos(idw.idwws.DwConsolalmo[] dwConsolalmos) {
        this.dwConsolalmos = dwConsolalmos;
    }

    public idw.idwws.DwConsolalmo getDwConsolalmos(int i) {
        return this.dwConsolalmos[i];
    }

    public void setDwConsolalmos(int i, idw.idwws.DwConsolalmo _value) {
        this.dwConsolalmos[i] = _value;
    }


    /**
     * Gets the dwConsolalocos value for this DwConsolal.
     * 
     * @return dwConsolalocos
     */
    public idw.idwws.DwConsolaloco[] getDwConsolalocos() {
        return dwConsolalocos;
    }


    /**
     * Sets the dwConsolalocos value for this DwConsolal.
     * 
     * @param dwConsolalocos
     */
    public void setDwConsolalocos(idw.idwws.DwConsolaloco[] dwConsolalocos) {
        this.dwConsolalocos = dwConsolalocos;
    }

    public idw.idwws.DwConsolaloco getDwConsolalocos(int i) {
        return this.dwConsolalocos[i];
    }

    public void setDwConsolalocos(int i, idw.idwws.DwConsolaloco _value) {
        this.dwConsolalocos[i] = _value;
    }


    /**
     * Gets the dwTAlerta value for this DwConsolal.
     * 
     * @return dwTAlerta
     */
    public idw.idwws.DwTAlerta getDwTAlerta() {
        return dwTAlerta;
    }


    /**
     * Sets the dwTAlerta value for this DwConsolal.
     * 
     * @param dwTAlerta
     */
    public void setDwTAlerta(idw.idwws.DwTAlerta dwTAlerta) {
        this.dwTAlerta = dwTAlerta;
    }


    /**
     * Gets the idConsolal value for this DwConsolal.
     * 
     * @return idConsolal
     */
    public java.lang.Long getIdConsolal() {
        return idConsolal;
    }


    /**
     * Sets the idConsolal value for this DwConsolal.
     * 
     * @param idConsolal
     */
    public void setIdConsolal(java.lang.Long idConsolal) {
        this.idConsolal = idConsolal;
    }


    /**
     * Gets the segAutoTempoalerta value for this DwConsolal.
     * 
     * @return segAutoTempoalerta
     */
    public java.math.BigDecimal getSegAutoTempoalerta() {
        return segAutoTempoalerta;
    }


    /**
     * Sets the segAutoTempoalerta value for this DwConsolal.
     * 
     * @param segAutoTempoalerta
     */
    public void setSegAutoTempoalerta(java.math.BigDecimal segAutoTempoalerta) {
        this.segAutoTempoalerta = segAutoTempoalerta;
    }


    /**
     * Gets the segManuTempoalerta value for this DwConsolal.
     * 
     * @return segManuTempoalerta
     */
    public java.math.BigDecimal getSegManuTempoalerta() {
        return segManuTempoalerta;
    }


    /**
     * Sets the segManuTempoalerta value for this DwConsolal.
     * 
     * @param segManuTempoalerta
     */
    public void setSegManuTempoalerta(java.math.BigDecimal segManuTempoalerta) {
        this.segManuTempoalerta = segManuTempoalerta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolal)) return false;
        DwConsolal other = (DwConsolal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsol==null && other.getDwConsol()==null) || 
             (this.dwConsol!=null &&
              this.dwConsol.equals(other.getDwConsol()))) &&
            ((this.dwConsolalmos==null && other.getDwConsolalmos()==null) || 
             (this.dwConsolalmos!=null &&
              java.util.Arrays.equals(this.dwConsolalmos, other.getDwConsolalmos()))) &&
            ((this.dwConsolalocos==null && other.getDwConsolalocos()==null) || 
             (this.dwConsolalocos!=null &&
              java.util.Arrays.equals(this.dwConsolalocos, other.getDwConsolalocos()))) &&
            ((this.dwTAlerta==null && other.getDwTAlerta()==null) || 
             (this.dwTAlerta!=null &&
              this.dwTAlerta.equals(other.getDwTAlerta()))) &&
            ((this.idConsolal==null && other.getIdConsolal()==null) || 
             (this.idConsolal!=null &&
              this.idConsolal.equals(other.getIdConsolal()))) &&
            ((this.segAutoTempoalerta==null && other.getSegAutoTempoalerta()==null) || 
             (this.segAutoTempoalerta!=null &&
              this.segAutoTempoalerta.equals(other.getSegAutoTempoalerta()))) &&
            ((this.segManuTempoalerta==null && other.getSegManuTempoalerta()==null) || 
             (this.segManuTempoalerta!=null &&
              this.segManuTempoalerta.equals(other.getSegManuTempoalerta())));
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
        if (getDwConsol() != null) {
            _hashCode += getDwConsol().hashCode();
        }
        if (getDwConsolalmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolalmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolalmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolalocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolalocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolalocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAlerta() != null) {
            _hashCode += getDwTAlerta().hashCode();
        }
        if (getIdConsolal() != null) {
            _hashCode += getIdConsolal().hashCode();
        }
        if (getSegAutoTempoalerta() != null) {
            _hashCode += getSegAutoTempoalerta().hashCode();
        }
        if (getSegManuTempoalerta() != null) {
            _hashCode += getSegManuTempoalerta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolal"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolalmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolalmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolalmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolalocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolalocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolaloco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAlerta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoalerta"));
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
