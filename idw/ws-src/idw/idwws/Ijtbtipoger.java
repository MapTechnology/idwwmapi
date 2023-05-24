/**
 * Ijtbtipoger.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtipoger  implements java.io.Serializable {
    private java.lang.String cdinterno;

    private java.lang.String cdtipoger;

    private java.lang.String dstipoger;

    private idw.idwws.Ijtbcont[] ijtbconts;

    private idw.idwws.Ijtbinf[] ijtbinfs;

    private java.lang.String indgrafico;

    private java.lang.String nomeicone;

    public Ijtbtipoger() {
    }

    public Ijtbtipoger(
           java.lang.String cdinterno,
           java.lang.String cdtipoger,
           java.lang.String dstipoger,
           idw.idwws.Ijtbcont[] ijtbconts,
           idw.idwws.Ijtbinf[] ijtbinfs,
           java.lang.String indgrafico,
           java.lang.String nomeicone) {
           this.cdinterno = cdinterno;
           this.cdtipoger = cdtipoger;
           this.dstipoger = dstipoger;
           this.ijtbconts = ijtbconts;
           this.ijtbinfs = ijtbinfs;
           this.indgrafico = indgrafico;
           this.nomeicone = nomeicone;
    }


    /**
     * Gets the cdinterno value for this Ijtbtipoger.
     * 
     * @return cdinterno
     */
    public java.lang.String getCdinterno() {
        return cdinterno;
    }


    /**
     * Sets the cdinterno value for this Ijtbtipoger.
     * 
     * @param cdinterno
     */
    public void setCdinterno(java.lang.String cdinterno) {
        this.cdinterno = cdinterno;
    }


    /**
     * Gets the cdtipoger value for this Ijtbtipoger.
     * 
     * @return cdtipoger
     */
    public java.lang.String getCdtipoger() {
        return cdtipoger;
    }


    /**
     * Sets the cdtipoger value for this Ijtbtipoger.
     * 
     * @param cdtipoger
     */
    public void setCdtipoger(java.lang.String cdtipoger) {
        this.cdtipoger = cdtipoger;
    }


    /**
     * Gets the dstipoger value for this Ijtbtipoger.
     * 
     * @return dstipoger
     */
    public java.lang.String getDstipoger() {
        return dstipoger;
    }


    /**
     * Sets the dstipoger value for this Ijtbtipoger.
     * 
     * @param dstipoger
     */
    public void setDstipoger(java.lang.String dstipoger) {
        this.dstipoger = dstipoger;
    }


    /**
     * Gets the ijtbconts value for this Ijtbtipoger.
     * 
     * @return ijtbconts
     */
    public idw.idwws.Ijtbcont[] getIjtbconts() {
        return ijtbconts;
    }


    /**
     * Sets the ijtbconts value for this Ijtbtipoger.
     * 
     * @param ijtbconts
     */
    public void setIjtbconts(idw.idwws.Ijtbcont[] ijtbconts) {
        this.ijtbconts = ijtbconts;
    }

    public idw.idwws.Ijtbcont getIjtbconts(int i) {
        return this.ijtbconts[i];
    }

    public void setIjtbconts(int i, idw.idwws.Ijtbcont _value) {
        this.ijtbconts[i] = _value;
    }


    /**
     * Gets the ijtbinfs value for this Ijtbtipoger.
     * 
     * @return ijtbinfs
     */
    public idw.idwws.Ijtbinf[] getIjtbinfs() {
        return ijtbinfs;
    }


    /**
     * Sets the ijtbinfs value for this Ijtbtipoger.
     * 
     * @param ijtbinfs
     */
    public void setIjtbinfs(idw.idwws.Ijtbinf[] ijtbinfs) {
        this.ijtbinfs = ijtbinfs;
    }

    public idw.idwws.Ijtbinf getIjtbinfs(int i) {
        return this.ijtbinfs[i];
    }

    public void setIjtbinfs(int i, idw.idwws.Ijtbinf _value) {
        this.ijtbinfs[i] = _value;
    }


    /**
     * Gets the indgrafico value for this Ijtbtipoger.
     * 
     * @return indgrafico
     */
    public java.lang.String getIndgrafico() {
        return indgrafico;
    }


    /**
     * Sets the indgrafico value for this Ijtbtipoger.
     * 
     * @param indgrafico
     */
    public void setIndgrafico(java.lang.String indgrafico) {
        this.indgrafico = indgrafico;
    }


    /**
     * Gets the nomeicone value for this Ijtbtipoger.
     * 
     * @return nomeicone
     */
    public java.lang.String getNomeicone() {
        return nomeicone;
    }


    /**
     * Sets the nomeicone value for this Ijtbtipoger.
     * 
     * @param nomeicone
     */
    public void setNomeicone(java.lang.String nomeicone) {
        this.nomeicone = nomeicone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtipoger)) return false;
        Ijtbtipoger other = (Ijtbtipoger) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinterno==null && other.getCdinterno()==null) || 
             (this.cdinterno!=null &&
              this.cdinterno.equals(other.getCdinterno()))) &&
            ((this.cdtipoger==null && other.getCdtipoger()==null) || 
             (this.cdtipoger!=null &&
              this.cdtipoger.equals(other.getCdtipoger()))) &&
            ((this.dstipoger==null && other.getDstipoger()==null) || 
             (this.dstipoger!=null &&
              this.dstipoger.equals(other.getDstipoger()))) &&
            ((this.ijtbconts==null && other.getIjtbconts()==null) || 
             (this.ijtbconts!=null &&
              java.util.Arrays.equals(this.ijtbconts, other.getIjtbconts()))) &&
            ((this.ijtbinfs==null && other.getIjtbinfs()==null) || 
             (this.ijtbinfs!=null &&
              java.util.Arrays.equals(this.ijtbinfs, other.getIjtbinfs()))) &&
            ((this.indgrafico==null && other.getIndgrafico()==null) || 
             (this.indgrafico!=null &&
              this.indgrafico.equals(other.getIndgrafico()))) &&
            ((this.nomeicone==null && other.getNomeicone()==null) || 
             (this.nomeicone!=null &&
              this.nomeicone.equals(other.getNomeicone())));
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
        if (getCdinterno() != null) {
            _hashCode += getCdinterno().hashCode();
        }
        if (getCdtipoger() != null) {
            _hashCode += getCdtipoger().hashCode();
        }
        if (getDstipoger() != null) {
            _hashCode += getDstipoger().hashCode();
        }
        if (getIjtbconts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbconts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbconts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinfs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbinfs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbinfs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndgrafico() != null) {
            _hashCode += getIndgrafico().hashCode();
        }
        if (getNomeicone() != null) {
            _hashCode += getNomeicone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtipoger.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipoger"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipoger");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipoger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstipoger");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstipoger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbconts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbconts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinfs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinfs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indgrafico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indgrafico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeicone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeicone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
