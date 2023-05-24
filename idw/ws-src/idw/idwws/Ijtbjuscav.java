/**
 * Ijtbjuscav.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbjuscav  implements java.io.Serializable {
    private java.lang.String cdjuscav;

    private java.lang.String dsjuscav;

    private idw.idwws.Ijmolproautorizmod[] ijmolproautorizmods;

    private idw.idwws.Ijpdcapadrao[] ijpdcapadraos;

    private idw.idwws.Ijreajuscav[] ijreajuscavs;

    private org.apache.axis.types.UnsignedShort status;

    public Ijtbjuscav() {
    }

    public Ijtbjuscav(
           java.lang.String cdjuscav,
           java.lang.String dsjuscav,
           idw.idwws.Ijmolproautorizmod[] ijmolproautorizmods,
           idw.idwws.Ijpdcapadrao[] ijpdcapadraos,
           idw.idwws.Ijreajuscav[] ijreajuscavs,
           org.apache.axis.types.UnsignedShort status) {
           this.cdjuscav = cdjuscav;
           this.dsjuscav = dsjuscav;
           this.ijmolproautorizmods = ijmolproautorizmods;
           this.ijpdcapadraos = ijpdcapadraos;
           this.ijreajuscavs = ijreajuscavs;
           this.status = status;
    }


    /**
     * Gets the cdjuscav value for this Ijtbjuscav.
     * 
     * @return cdjuscav
     */
    public java.lang.String getCdjuscav() {
        return cdjuscav;
    }


    /**
     * Sets the cdjuscav value for this Ijtbjuscav.
     * 
     * @param cdjuscav
     */
    public void setCdjuscav(java.lang.String cdjuscav) {
        this.cdjuscav = cdjuscav;
    }


    /**
     * Gets the dsjuscav value for this Ijtbjuscav.
     * 
     * @return dsjuscav
     */
    public java.lang.String getDsjuscav() {
        return dsjuscav;
    }


    /**
     * Sets the dsjuscav value for this Ijtbjuscav.
     * 
     * @param dsjuscav
     */
    public void setDsjuscav(java.lang.String dsjuscav) {
        this.dsjuscav = dsjuscav;
    }


    /**
     * Gets the ijmolproautorizmods value for this Ijtbjuscav.
     * 
     * @return ijmolproautorizmods
     */
    public idw.idwws.Ijmolproautorizmod[] getIjmolproautorizmods() {
        return ijmolproautorizmods;
    }


    /**
     * Sets the ijmolproautorizmods value for this Ijtbjuscav.
     * 
     * @param ijmolproautorizmods
     */
    public void setIjmolproautorizmods(idw.idwws.Ijmolproautorizmod[] ijmolproautorizmods) {
        this.ijmolproautorizmods = ijmolproautorizmods;
    }

    public idw.idwws.Ijmolproautorizmod getIjmolproautorizmods(int i) {
        return this.ijmolproautorizmods[i];
    }

    public void setIjmolproautorizmods(int i, idw.idwws.Ijmolproautorizmod _value) {
        this.ijmolproautorizmods[i] = _value;
    }


    /**
     * Gets the ijpdcapadraos value for this Ijtbjuscav.
     * 
     * @return ijpdcapadraos
     */
    public idw.idwws.Ijpdcapadrao[] getIjpdcapadraos() {
        return ijpdcapadraos;
    }


    /**
     * Sets the ijpdcapadraos value for this Ijtbjuscav.
     * 
     * @param ijpdcapadraos
     */
    public void setIjpdcapadraos(idw.idwws.Ijpdcapadrao[] ijpdcapadraos) {
        this.ijpdcapadraos = ijpdcapadraos;
    }

    public idw.idwws.Ijpdcapadrao getIjpdcapadraos(int i) {
        return this.ijpdcapadraos[i];
    }

    public void setIjpdcapadraos(int i, idw.idwws.Ijpdcapadrao _value) {
        this.ijpdcapadraos[i] = _value;
    }


    /**
     * Gets the ijreajuscavs value for this Ijtbjuscav.
     * 
     * @return ijreajuscavs
     */
    public idw.idwws.Ijreajuscav[] getIjreajuscavs() {
        return ijreajuscavs;
    }


    /**
     * Sets the ijreajuscavs value for this Ijtbjuscav.
     * 
     * @param ijreajuscavs
     */
    public void setIjreajuscavs(idw.idwws.Ijreajuscav[] ijreajuscavs) {
        this.ijreajuscavs = ijreajuscavs;
    }

    public idw.idwws.Ijreajuscav getIjreajuscavs(int i) {
        return this.ijreajuscavs[i];
    }

    public void setIjreajuscavs(int i, idw.idwws.Ijreajuscav _value) {
        this.ijreajuscavs[i] = _value;
    }


    /**
     * Gets the status value for this Ijtbjuscav.
     * 
     * @return status
     */
    public org.apache.axis.types.UnsignedShort getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Ijtbjuscav.
     * 
     * @param status
     */
    public void setStatus(org.apache.axis.types.UnsignedShort status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbjuscav)) return false;
        Ijtbjuscav other = (Ijtbjuscav) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdjuscav==null && other.getCdjuscav()==null) || 
             (this.cdjuscav!=null &&
              this.cdjuscav.equals(other.getCdjuscav()))) &&
            ((this.dsjuscav==null && other.getDsjuscav()==null) || 
             (this.dsjuscav!=null &&
              this.dsjuscav.equals(other.getDsjuscav()))) &&
            ((this.ijmolproautorizmods==null && other.getIjmolproautorizmods()==null) || 
             (this.ijmolproautorizmods!=null &&
              java.util.Arrays.equals(this.ijmolproautorizmods, other.getIjmolproautorizmods()))) &&
            ((this.ijpdcapadraos==null && other.getIjpdcapadraos()==null) || 
             (this.ijpdcapadraos!=null &&
              java.util.Arrays.equals(this.ijpdcapadraos, other.getIjpdcapadraos()))) &&
            ((this.ijreajuscavs==null && other.getIjreajuscavs()==null) || 
             (this.ijreajuscavs!=null &&
              java.util.Arrays.equals(this.ijreajuscavs, other.getIjreajuscavs()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getCdjuscav() != null) {
            _hashCode += getCdjuscav().hashCode();
        }
        if (getDsjuscav() != null) {
            _hashCode += getDsjuscav().hashCode();
        }
        if (getIjmolproautorizmods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproautorizmods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproautorizmods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcapadraos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcapadraos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcapadraos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreajuscavs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreajuscavs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreajuscavs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbjuscav.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbjuscav"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdjuscav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdjuscav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsjuscav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsjuscav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproautorizmods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproautorizmods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizmod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcapadraos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcapadraos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcapadrao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreajuscavs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreajuscavs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreajuscav"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
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
