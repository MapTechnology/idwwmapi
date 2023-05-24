/**
 * Ijtbmotsemprog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmotsemprog  implements java.io.Serializable {
    private java.lang.String cdmotsemprog;

    private java.lang.String dsmotsemprog;

    private idw.idwws.Ijreamovsemprog[] ijreamovsemprogs;

    private org.apache.axis.types.UnsignedShort stativo;

    public Ijtbmotsemprog() {
    }

    public Ijtbmotsemprog(
           java.lang.String cdmotsemprog,
           java.lang.String dsmotsemprog,
           idw.idwws.Ijreamovsemprog[] ijreamovsemprogs,
           org.apache.axis.types.UnsignedShort stativo) {
           this.cdmotsemprog = cdmotsemprog;
           this.dsmotsemprog = dsmotsemprog;
           this.ijreamovsemprogs = ijreamovsemprogs;
           this.stativo = stativo;
    }


    /**
     * Gets the cdmotsemprog value for this Ijtbmotsemprog.
     * 
     * @return cdmotsemprog
     */
    public java.lang.String getCdmotsemprog() {
        return cdmotsemprog;
    }


    /**
     * Sets the cdmotsemprog value for this Ijtbmotsemprog.
     * 
     * @param cdmotsemprog
     */
    public void setCdmotsemprog(java.lang.String cdmotsemprog) {
        this.cdmotsemprog = cdmotsemprog;
    }


    /**
     * Gets the dsmotsemprog value for this Ijtbmotsemprog.
     * 
     * @return dsmotsemprog
     */
    public java.lang.String getDsmotsemprog() {
        return dsmotsemprog;
    }


    /**
     * Sets the dsmotsemprog value for this Ijtbmotsemprog.
     * 
     * @param dsmotsemprog
     */
    public void setDsmotsemprog(java.lang.String dsmotsemprog) {
        this.dsmotsemprog = dsmotsemprog;
    }


    /**
     * Gets the ijreamovsemprogs value for this Ijtbmotsemprog.
     * 
     * @return ijreamovsemprogs
     */
    public idw.idwws.Ijreamovsemprog[] getIjreamovsemprogs() {
        return ijreamovsemprogs;
    }


    /**
     * Sets the ijreamovsemprogs value for this Ijtbmotsemprog.
     * 
     * @param ijreamovsemprogs
     */
    public void setIjreamovsemprogs(idw.idwws.Ijreamovsemprog[] ijreamovsemprogs) {
        this.ijreamovsemprogs = ijreamovsemprogs;
    }

    public idw.idwws.Ijreamovsemprog getIjreamovsemprogs(int i) {
        return this.ijreamovsemprogs[i];
    }

    public void setIjreamovsemprogs(int i, idw.idwws.Ijreamovsemprog _value) {
        this.ijreamovsemprogs[i] = _value;
    }


    /**
     * Gets the stativo value for this Ijtbmotsemprog.
     * 
     * @return stativo
     */
    public org.apache.axis.types.UnsignedShort getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbmotsemprog.
     * 
     * @param stativo
     */
    public void setStativo(org.apache.axis.types.UnsignedShort stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmotsemprog)) return false;
        Ijtbmotsemprog other = (Ijtbmotsemprog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmotsemprog==null && other.getCdmotsemprog()==null) || 
             (this.cdmotsemprog!=null &&
              this.cdmotsemprog.equals(other.getCdmotsemprog()))) &&
            ((this.dsmotsemprog==null && other.getDsmotsemprog()==null) || 
             (this.dsmotsemprog!=null &&
              this.dsmotsemprog.equals(other.getDsmotsemprog()))) &&
            ((this.ijreamovsemprogs==null && other.getIjreamovsemprogs()==null) || 
             (this.ijreamovsemprogs!=null &&
              java.util.Arrays.equals(this.ijreamovsemprogs, other.getIjreamovsemprogs()))) &&
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
        if (getCdmotsemprog() != null) {
            _hashCode += getCdmotsemprog().hashCode();
        }
        if (getDsmotsemprog() != null) {
            _hashCode += getDsmotsemprog().hashCode();
        }
        if (getIjreamovsemprogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreamovsemprogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreamovsemprogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbmotsemprog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmotsemprog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmotsemprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmotsemprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmotsemprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmotsemprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreamovsemprogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreamovsemprogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreamovsemprog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
