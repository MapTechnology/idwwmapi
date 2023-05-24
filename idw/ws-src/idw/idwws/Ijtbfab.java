/**
 * Ijtbfab.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbfab  implements java.io.Serializable {
    private java.lang.String cdfabricante;

    private java.lang.String dsfabricante;

    private idw.idwws.Ijtbinj[] ijtbinjs;

    private idw.idwws.Ijtbmol[] ijtbmols;

    private idw.idwws.Ijtbmprima[] ijtbmprimas;

    public Ijtbfab() {
    }

    public Ijtbfab(
           java.lang.String cdfabricante,
           java.lang.String dsfabricante,
           idw.idwws.Ijtbinj[] ijtbinjs,
           idw.idwws.Ijtbmol[] ijtbmols,
           idw.idwws.Ijtbmprima[] ijtbmprimas) {
           this.cdfabricante = cdfabricante;
           this.dsfabricante = dsfabricante;
           this.ijtbinjs = ijtbinjs;
           this.ijtbmols = ijtbmols;
           this.ijtbmprimas = ijtbmprimas;
    }


    /**
     * Gets the cdfabricante value for this Ijtbfab.
     * 
     * @return cdfabricante
     */
    public java.lang.String getCdfabricante() {
        return cdfabricante;
    }


    /**
     * Sets the cdfabricante value for this Ijtbfab.
     * 
     * @param cdfabricante
     */
    public void setCdfabricante(java.lang.String cdfabricante) {
        this.cdfabricante = cdfabricante;
    }


    /**
     * Gets the dsfabricante value for this Ijtbfab.
     * 
     * @return dsfabricante
     */
    public java.lang.String getDsfabricante() {
        return dsfabricante;
    }


    /**
     * Sets the dsfabricante value for this Ijtbfab.
     * 
     * @param dsfabricante
     */
    public void setDsfabricante(java.lang.String dsfabricante) {
        this.dsfabricante = dsfabricante;
    }


    /**
     * Gets the ijtbinjs value for this Ijtbfab.
     * 
     * @return ijtbinjs
     */
    public idw.idwws.Ijtbinj[] getIjtbinjs() {
        return ijtbinjs;
    }


    /**
     * Sets the ijtbinjs value for this Ijtbfab.
     * 
     * @param ijtbinjs
     */
    public void setIjtbinjs(idw.idwws.Ijtbinj[] ijtbinjs) {
        this.ijtbinjs = ijtbinjs;
    }

    public idw.idwws.Ijtbinj getIjtbinjs(int i) {
        return this.ijtbinjs[i];
    }

    public void setIjtbinjs(int i, idw.idwws.Ijtbinj _value) {
        this.ijtbinjs[i] = _value;
    }


    /**
     * Gets the ijtbmols value for this Ijtbfab.
     * 
     * @return ijtbmols
     */
    public idw.idwws.Ijtbmol[] getIjtbmols() {
        return ijtbmols;
    }


    /**
     * Sets the ijtbmols value for this Ijtbfab.
     * 
     * @param ijtbmols
     */
    public void setIjtbmols(idw.idwws.Ijtbmol[] ijtbmols) {
        this.ijtbmols = ijtbmols;
    }

    public idw.idwws.Ijtbmol getIjtbmols(int i) {
        return this.ijtbmols[i];
    }

    public void setIjtbmols(int i, idw.idwws.Ijtbmol _value) {
        this.ijtbmols[i] = _value;
    }


    /**
     * Gets the ijtbmprimas value for this Ijtbfab.
     * 
     * @return ijtbmprimas
     */
    public idw.idwws.Ijtbmprima[] getIjtbmprimas() {
        return ijtbmprimas;
    }


    /**
     * Sets the ijtbmprimas value for this Ijtbfab.
     * 
     * @param ijtbmprimas
     */
    public void setIjtbmprimas(idw.idwws.Ijtbmprima[] ijtbmprimas) {
        this.ijtbmprimas = ijtbmprimas;
    }

    public idw.idwws.Ijtbmprima getIjtbmprimas(int i) {
        return this.ijtbmprimas[i];
    }

    public void setIjtbmprimas(int i, idw.idwws.Ijtbmprima _value) {
        this.ijtbmprimas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbfab)) return false;
        Ijtbfab other = (Ijtbfab) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdfabricante==null && other.getCdfabricante()==null) || 
             (this.cdfabricante!=null &&
              this.cdfabricante.equals(other.getCdfabricante()))) &&
            ((this.dsfabricante==null && other.getDsfabricante()==null) || 
             (this.dsfabricante!=null &&
              this.dsfabricante.equals(other.getDsfabricante()))) &&
            ((this.ijtbinjs==null && other.getIjtbinjs()==null) || 
             (this.ijtbinjs!=null &&
              java.util.Arrays.equals(this.ijtbinjs, other.getIjtbinjs()))) &&
            ((this.ijtbmols==null && other.getIjtbmols()==null) || 
             (this.ijtbmols!=null &&
              java.util.Arrays.equals(this.ijtbmols, other.getIjtbmols()))) &&
            ((this.ijtbmprimas==null && other.getIjtbmprimas()==null) || 
             (this.ijtbmprimas!=null &&
              java.util.Arrays.equals(this.ijtbmprimas, other.getIjtbmprimas())));
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
        if (getCdfabricante() != null) {
            _hashCode += getCdfabricante().hashCode();
        }
        if (getDsfabricante() != null) {
            _hashCode += getDsfabricante().hashCode();
        }
        if (getIjtbinjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbinjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbinjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmols(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmprimas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmprimas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmprimas(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbfab.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbfab"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdfabricante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdfabricante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsfabricante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsfabricante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmprimas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprimas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
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
