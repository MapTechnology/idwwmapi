/**
 * Ijmolproautorizmod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmolproautorizmod  implements java.io.Serializable {
    private java.util.Calendar dthrsolicmodific;

    private java.util.Calendar dthrstsolic;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijmolproautorizpro[] ijmolproautorizpros;

    private idw.idwws.Ijmolproautorizusu[] ijmolproautorizusus;

    private idw.idwws.Ijtbjuscav ijtbjuscav;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String nrsolicmodificest;

    private org.apache.axis.types.UnsignedShort stsolicmodific;

    public Ijmolproautorizmod() {
    }

    public Ijmolproautorizmod(
           java.util.Calendar dthrsolicmodific,
           java.util.Calendar dthrstsolic,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijmolproautorizpro[] ijmolproautorizpros,
           idw.idwws.Ijmolproautorizusu[] ijmolproautorizusus,
           idw.idwws.Ijtbjuscav ijtbjuscav,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String nrsolicmodificest,
           org.apache.axis.types.UnsignedShort stsolicmodific) {
           this.dthrsolicmodific = dthrsolicmodific;
           this.dthrstsolic = dthrstsolic;
           this.ijestmol = ijestmol;
           this.ijmolproautorizpros = ijmolproautorizpros;
           this.ijmolproautorizusus = ijmolproautorizusus;
           this.ijtbjuscav = ijtbjuscav;
           this.ijtbusu = ijtbusu;
           this.nrsolicmodificest = nrsolicmodificest;
           this.stsolicmodific = stsolicmodific;
    }


    /**
     * Gets the dthrsolicmodific value for this Ijmolproautorizmod.
     * 
     * @return dthrsolicmodific
     */
    public java.util.Calendar getDthrsolicmodific() {
        return dthrsolicmodific;
    }


    /**
     * Sets the dthrsolicmodific value for this Ijmolproautorizmod.
     * 
     * @param dthrsolicmodific
     */
    public void setDthrsolicmodific(java.util.Calendar dthrsolicmodific) {
        this.dthrsolicmodific = dthrsolicmodific;
    }


    /**
     * Gets the dthrstsolic value for this Ijmolproautorizmod.
     * 
     * @return dthrstsolic
     */
    public java.util.Calendar getDthrstsolic() {
        return dthrstsolic;
    }


    /**
     * Sets the dthrstsolic value for this Ijmolproautorizmod.
     * 
     * @param dthrstsolic
     */
    public void setDthrstsolic(java.util.Calendar dthrstsolic) {
        this.dthrstsolic = dthrstsolic;
    }


    /**
     * Gets the ijestmol value for this Ijmolproautorizmod.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijmolproautorizmod.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijmolproautorizpros value for this Ijmolproautorizmod.
     * 
     * @return ijmolproautorizpros
     */
    public idw.idwws.Ijmolproautorizpro[] getIjmolproautorizpros() {
        return ijmolproautorizpros;
    }


    /**
     * Sets the ijmolproautorizpros value for this Ijmolproautorizmod.
     * 
     * @param ijmolproautorizpros
     */
    public void setIjmolproautorizpros(idw.idwws.Ijmolproautorizpro[] ijmolproautorizpros) {
        this.ijmolproautorizpros = ijmolproautorizpros;
    }

    public idw.idwws.Ijmolproautorizpro getIjmolproautorizpros(int i) {
        return this.ijmolproautorizpros[i];
    }

    public void setIjmolproautorizpros(int i, idw.idwws.Ijmolproautorizpro _value) {
        this.ijmolproautorizpros[i] = _value;
    }


    /**
     * Gets the ijmolproautorizusus value for this Ijmolproautorizmod.
     * 
     * @return ijmolproautorizusus
     */
    public idw.idwws.Ijmolproautorizusu[] getIjmolproautorizusus() {
        return ijmolproautorizusus;
    }


    /**
     * Sets the ijmolproautorizusus value for this Ijmolproautorizmod.
     * 
     * @param ijmolproautorizusus
     */
    public void setIjmolproautorizusus(idw.idwws.Ijmolproautorizusu[] ijmolproautorizusus) {
        this.ijmolproautorizusus = ijmolproautorizusus;
    }

    public idw.idwws.Ijmolproautorizusu getIjmolproautorizusus(int i) {
        return this.ijmolproautorizusus[i];
    }

    public void setIjmolproautorizusus(int i, idw.idwws.Ijmolproautorizusu _value) {
        this.ijmolproautorizusus[i] = _value;
    }


    /**
     * Gets the ijtbjuscav value for this Ijmolproautorizmod.
     * 
     * @return ijtbjuscav
     */
    public idw.idwws.Ijtbjuscav getIjtbjuscav() {
        return ijtbjuscav;
    }


    /**
     * Sets the ijtbjuscav value for this Ijmolproautorizmod.
     * 
     * @param ijtbjuscav
     */
    public void setIjtbjuscav(idw.idwws.Ijtbjuscav ijtbjuscav) {
        this.ijtbjuscav = ijtbjuscav;
    }


    /**
     * Gets the ijtbusu value for this Ijmolproautorizmod.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijmolproautorizmod.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the nrsolicmodificest value for this Ijmolproautorizmod.
     * 
     * @return nrsolicmodificest
     */
    public java.lang.String getNrsolicmodificest() {
        return nrsolicmodificest;
    }


    /**
     * Sets the nrsolicmodificest value for this Ijmolproautorizmod.
     * 
     * @param nrsolicmodificest
     */
    public void setNrsolicmodificest(java.lang.String nrsolicmodificest) {
        this.nrsolicmodificest = nrsolicmodificest;
    }


    /**
     * Gets the stsolicmodific value for this Ijmolproautorizmod.
     * 
     * @return stsolicmodific
     */
    public org.apache.axis.types.UnsignedShort getStsolicmodific() {
        return stsolicmodific;
    }


    /**
     * Sets the stsolicmodific value for this Ijmolproautorizmod.
     * 
     * @param stsolicmodific
     */
    public void setStsolicmodific(org.apache.axis.types.UnsignedShort stsolicmodific) {
        this.stsolicmodific = stsolicmodific;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmolproautorizmod)) return false;
        Ijmolproautorizmod other = (Ijmolproautorizmod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrsolicmodific==null && other.getDthrsolicmodific()==null) || 
             (this.dthrsolicmodific!=null &&
              this.dthrsolicmodific.equals(other.getDthrsolicmodific()))) &&
            ((this.dthrstsolic==null && other.getDthrstsolic()==null) || 
             (this.dthrstsolic!=null &&
              this.dthrstsolic.equals(other.getDthrstsolic()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijmolproautorizpros==null && other.getIjmolproautorizpros()==null) || 
             (this.ijmolproautorizpros!=null &&
              java.util.Arrays.equals(this.ijmolproautorizpros, other.getIjmolproautorizpros()))) &&
            ((this.ijmolproautorizusus==null && other.getIjmolproautorizusus()==null) || 
             (this.ijmolproautorizusus!=null &&
              java.util.Arrays.equals(this.ijmolproautorizusus, other.getIjmolproautorizusus()))) &&
            ((this.ijtbjuscav==null && other.getIjtbjuscav()==null) || 
             (this.ijtbjuscav!=null &&
              this.ijtbjuscav.equals(other.getIjtbjuscav()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.nrsolicmodificest==null && other.getNrsolicmodificest()==null) || 
             (this.nrsolicmodificest!=null &&
              this.nrsolicmodificest.equals(other.getNrsolicmodificest()))) &&
            ((this.stsolicmodific==null && other.getStsolicmodific()==null) || 
             (this.stsolicmodific!=null &&
              this.stsolicmodific.equals(other.getStsolicmodific())));
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
        if (getDthrsolicmodific() != null) {
            _hashCode += getDthrsolicmodific().hashCode();
        }
        if (getDthrstsolic() != null) {
            _hashCode += getDthrstsolic().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjmolproautorizpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproautorizpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproautorizpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmolproautorizusus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproautorizusus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproautorizusus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbjuscav() != null) {
            _hashCode += getIjtbjuscav().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getNrsolicmodificest() != null) {
            _hashCode += getNrsolicmodificest().hashCode();
        }
        if (getStsolicmodific() != null) {
            _hashCode += getStsolicmodific().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmolproautorizmod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizmod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproautorizpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproautorizpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproautorizusus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproautorizusus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbjuscav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbjuscav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbjuscav"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrsolicmodificest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrsolicmodificest"));
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
