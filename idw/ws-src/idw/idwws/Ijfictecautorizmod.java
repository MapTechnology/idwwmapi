/**
 * Ijfictecautorizmod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfictecautorizmod  implements java.io.Serializable {
    private double ciclopadrao;

    private java.util.Calendar dthrsolicmodific;

    private java.util.Calendar dthrstsolic;

    private idw.idwws.Ijfictec ijfictec;

    private idw.idwws.Ijfictecautorizusu[] ijfictecautorizusus;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String nrsolicmodificcic;

    private org.apache.axis.types.UnsignedShort stsolicmodific;

    private double varmax;

    private double varmin;

    public Ijfictecautorizmod() {
    }

    public Ijfictecautorizmod(
           double ciclopadrao,
           java.util.Calendar dthrsolicmodific,
           java.util.Calendar dthrstsolic,
           idw.idwws.Ijfictec ijfictec,
           idw.idwws.Ijfictecautorizusu[] ijfictecautorizusus,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String nrsolicmodificcic,
           org.apache.axis.types.UnsignedShort stsolicmodific,
           double varmax,
           double varmin) {
           this.ciclopadrao = ciclopadrao;
           this.dthrsolicmodific = dthrsolicmodific;
           this.dthrstsolic = dthrstsolic;
           this.ijfictec = ijfictec;
           this.ijfictecautorizusus = ijfictecautorizusus;
           this.ijtbusu = ijtbusu;
           this.nrsolicmodificcic = nrsolicmodificcic;
           this.stsolicmodific = stsolicmodific;
           this.varmax = varmax;
           this.varmin = varmin;
    }


    /**
     * Gets the ciclopadrao value for this Ijfictecautorizmod.
     * 
     * @return ciclopadrao
     */
    public double getCiclopadrao() {
        return ciclopadrao;
    }


    /**
     * Sets the ciclopadrao value for this Ijfictecautorizmod.
     * 
     * @param ciclopadrao
     */
    public void setCiclopadrao(double ciclopadrao) {
        this.ciclopadrao = ciclopadrao;
    }


    /**
     * Gets the dthrsolicmodific value for this Ijfictecautorizmod.
     * 
     * @return dthrsolicmodific
     */
    public java.util.Calendar getDthrsolicmodific() {
        return dthrsolicmodific;
    }


    /**
     * Sets the dthrsolicmodific value for this Ijfictecautorizmod.
     * 
     * @param dthrsolicmodific
     */
    public void setDthrsolicmodific(java.util.Calendar dthrsolicmodific) {
        this.dthrsolicmodific = dthrsolicmodific;
    }


    /**
     * Gets the dthrstsolic value for this Ijfictecautorizmod.
     * 
     * @return dthrstsolic
     */
    public java.util.Calendar getDthrstsolic() {
        return dthrstsolic;
    }


    /**
     * Sets the dthrstsolic value for this Ijfictecautorizmod.
     * 
     * @param dthrstsolic
     */
    public void setDthrstsolic(java.util.Calendar dthrstsolic) {
        this.dthrstsolic = dthrstsolic;
    }


    /**
     * Gets the ijfictec value for this Ijfictecautorizmod.
     * 
     * @return ijfictec
     */
    public idw.idwws.Ijfictec getIjfictec() {
        return ijfictec;
    }


    /**
     * Sets the ijfictec value for this Ijfictecautorizmod.
     * 
     * @param ijfictec
     */
    public void setIjfictec(idw.idwws.Ijfictec ijfictec) {
        this.ijfictec = ijfictec;
    }


    /**
     * Gets the ijfictecautorizusus value for this Ijfictecautorizmod.
     * 
     * @return ijfictecautorizusus
     */
    public idw.idwws.Ijfictecautorizusu[] getIjfictecautorizusus() {
        return ijfictecautorizusus;
    }


    /**
     * Sets the ijfictecautorizusus value for this Ijfictecautorizmod.
     * 
     * @param ijfictecautorizusus
     */
    public void setIjfictecautorizusus(idw.idwws.Ijfictecautorizusu[] ijfictecautorizusus) {
        this.ijfictecautorizusus = ijfictecautorizusus;
    }

    public idw.idwws.Ijfictecautorizusu getIjfictecautorizusus(int i) {
        return this.ijfictecautorizusus[i];
    }

    public void setIjfictecautorizusus(int i, idw.idwws.Ijfictecautorizusu _value) {
        this.ijfictecautorizusus[i] = _value;
    }


    /**
     * Gets the ijtbusu value for this Ijfictecautorizmod.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijfictecautorizmod.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the nrsolicmodificcic value for this Ijfictecautorizmod.
     * 
     * @return nrsolicmodificcic
     */
    public java.lang.String getNrsolicmodificcic() {
        return nrsolicmodificcic;
    }


    /**
     * Sets the nrsolicmodificcic value for this Ijfictecautorizmod.
     * 
     * @param nrsolicmodificcic
     */
    public void setNrsolicmodificcic(java.lang.String nrsolicmodificcic) {
        this.nrsolicmodificcic = nrsolicmodificcic;
    }


    /**
     * Gets the stsolicmodific value for this Ijfictecautorizmod.
     * 
     * @return stsolicmodific
     */
    public org.apache.axis.types.UnsignedShort getStsolicmodific() {
        return stsolicmodific;
    }


    /**
     * Sets the stsolicmodific value for this Ijfictecautorizmod.
     * 
     * @param stsolicmodific
     */
    public void setStsolicmodific(org.apache.axis.types.UnsignedShort stsolicmodific) {
        this.stsolicmodific = stsolicmodific;
    }


    /**
     * Gets the varmax value for this Ijfictecautorizmod.
     * 
     * @return varmax
     */
    public double getVarmax() {
        return varmax;
    }


    /**
     * Sets the varmax value for this Ijfictecautorizmod.
     * 
     * @param varmax
     */
    public void setVarmax(double varmax) {
        this.varmax = varmax;
    }


    /**
     * Gets the varmin value for this Ijfictecautorizmod.
     * 
     * @return varmin
     */
    public double getVarmin() {
        return varmin;
    }


    /**
     * Sets the varmin value for this Ijfictecautorizmod.
     * 
     * @param varmin
     */
    public void setVarmin(double varmin) {
        this.varmin = varmin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfictecautorizmod)) return false;
        Ijfictecautorizmod other = (Ijfictecautorizmod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ciclopadrao == other.getCiclopadrao() &&
            ((this.dthrsolicmodific==null && other.getDthrsolicmodific()==null) || 
             (this.dthrsolicmodific!=null &&
              this.dthrsolicmodific.equals(other.getDthrsolicmodific()))) &&
            ((this.dthrstsolic==null && other.getDthrstsolic()==null) || 
             (this.dthrstsolic!=null &&
              this.dthrstsolic.equals(other.getDthrstsolic()))) &&
            ((this.ijfictec==null && other.getIjfictec()==null) || 
             (this.ijfictec!=null &&
              this.ijfictec.equals(other.getIjfictec()))) &&
            ((this.ijfictecautorizusus==null && other.getIjfictecautorizusus()==null) || 
             (this.ijfictecautorizusus!=null &&
              java.util.Arrays.equals(this.ijfictecautorizusus, other.getIjfictecautorizusus()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.nrsolicmodificcic==null && other.getNrsolicmodificcic()==null) || 
             (this.nrsolicmodificcic!=null &&
              this.nrsolicmodificcic.equals(other.getNrsolicmodificcic()))) &&
            ((this.stsolicmodific==null && other.getStsolicmodific()==null) || 
             (this.stsolicmodific!=null &&
              this.stsolicmodific.equals(other.getStsolicmodific()))) &&
            this.varmax == other.getVarmax() &&
            this.varmin == other.getVarmin();
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
        _hashCode += new Double(getCiclopadrao()).hashCode();
        if (getDthrsolicmodific() != null) {
            _hashCode += getDthrsolicmodific().hashCode();
        }
        if (getDthrstsolic() != null) {
            _hashCode += getDthrstsolic().hashCode();
        }
        if (getIjfictec() != null) {
            _hashCode += getIjfictec().hashCode();
        }
        if (getIjfictecautorizusus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfictecautorizusus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfictecautorizusus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getNrsolicmodificcic() != null) {
            _hashCode += getNrsolicmodificcic().hashCode();
        }
        if (getStsolicmodific() != null) {
            _hashCode += getStsolicmodific().hashCode();
        }
        _hashCode += new Double(getVarmax()).hashCode();
        _hashCode += new Double(getVarmin()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfictecautorizmod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecautorizmod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrsolicmodific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrsolicmodific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrstsolic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrstsolic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictecautorizusus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictecautorizusus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecautorizusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrsolicmodificcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrsolicmodificcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stsolicmodific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stsolicmodific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varmax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "varmax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "varmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
