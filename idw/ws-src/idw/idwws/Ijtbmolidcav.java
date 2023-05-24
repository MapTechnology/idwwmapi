/**
 * Ijtbmolidcav.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmolidcav  implements java.io.Serializable {
    private double idcavidade;

    private idw.idwws.Ijmolproidcav[] ijmolproidcavs;

    private idw.idwws.Ijtbmol ijtbmol;

    private java.lang.String nmcavidade;

    private org.apache.axis.types.UnsignedShort stcavidade;

    public Ijtbmolidcav() {
    }

    public Ijtbmolidcav(
           double idcavidade,
           idw.idwws.Ijmolproidcav[] ijmolproidcavs,
           idw.idwws.Ijtbmol ijtbmol,
           java.lang.String nmcavidade,
           org.apache.axis.types.UnsignedShort stcavidade) {
           this.idcavidade = idcavidade;
           this.ijmolproidcavs = ijmolproidcavs;
           this.ijtbmol = ijtbmol;
           this.nmcavidade = nmcavidade;
           this.stcavidade = stcavidade;
    }


    /**
     * Gets the idcavidade value for this Ijtbmolidcav.
     * 
     * @return idcavidade
     */
    public double getIdcavidade() {
        return idcavidade;
    }


    /**
     * Sets the idcavidade value for this Ijtbmolidcav.
     * 
     * @param idcavidade
     */
    public void setIdcavidade(double idcavidade) {
        this.idcavidade = idcavidade;
    }


    /**
     * Gets the ijmolproidcavs value for this Ijtbmolidcav.
     * 
     * @return ijmolproidcavs
     */
    public idw.idwws.Ijmolproidcav[] getIjmolproidcavs() {
        return ijmolproidcavs;
    }


    /**
     * Sets the ijmolproidcavs value for this Ijtbmolidcav.
     * 
     * @param ijmolproidcavs
     */
    public void setIjmolproidcavs(idw.idwws.Ijmolproidcav[] ijmolproidcavs) {
        this.ijmolproidcavs = ijmolproidcavs;
    }

    public idw.idwws.Ijmolproidcav getIjmolproidcavs(int i) {
        return this.ijmolproidcavs[i];
    }

    public void setIjmolproidcavs(int i, idw.idwws.Ijmolproidcav _value) {
        this.ijmolproidcavs[i] = _value;
    }


    /**
     * Gets the ijtbmol value for this Ijtbmolidcav.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijtbmolidcav.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the nmcavidade value for this Ijtbmolidcav.
     * 
     * @return nmcavidade
     */
    public java.lang.String getNmcavidade() {
        return nmcavidade;
    }


    /**
     * Sets the nmcavidade value for this Ijtbmolidcav.
     * 
     * @param nmcavidade
     */
    public void setNmcavidade(java.lang.String nmcavidade) {
        this.nmcavidade = nmcavidade;
    }


    /**
     * Gets the stcavidade value for this Ijtbmolidcav.
     * 
     * @return stcavidade
     */
    public org.apache.axis.types.UnsignedShort getStcavidade() {
        return stcavidade;
    }


    /**
     * Sets the stcavidade value for this Ijtbmolidcav.
     * 
     * @param stcavidade
     */
    public void setStcavidade(org.apache.axis.types.UnsignedShort stcavidade) {
        this.stcavidade = stcavidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmolidcav)) return false;
        Ijtbmolidcav other = (Ijtbmolidcav) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idcavidade == other.getIdcavidade() &&
            ((this.ijmolproidcavs==null && other.getIjmolproidcavs()==null) || 
             (this.ijmolproidcavs!=null &&
              java.util.Arrays.equals(this.ijmolproidcavs, other.getIjmolproidcavs()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol()))) &&
            ((this.nmcavidade==null && other.getNmcavidade()==null) || 
             (this.nmcavidade!=null &&
              this.nmcavidade.equals(other.getNmcavidade()))) &&
            ((this.stcavidade==null && other.getStcavidade()==null) || 
             (this.stcavidade!=null &&
              this.stcavidade.equals(other.getStcavidade())));
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
        _hashCode += new Double(getIdcavidade()).hashCode();
        if (getIjmolproidcavs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproidcavs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproidcavs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmol() != null) {
            _hashCode += getIjtbmol().hashCode();
        }
        if (getNmcavidade() != null) {
            _hashCode += getNmcavidade().hashCode();
        }
        if (getStcavidade() != null) {
            _hashCode += getStcavidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbmolidcav.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmolidcav"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcavidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idcavidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproidcavs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproidcavs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproidcav"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmcavidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmcavidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stcavidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stcavidade"));
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
