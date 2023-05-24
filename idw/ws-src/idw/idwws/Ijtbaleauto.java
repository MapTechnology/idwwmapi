/**
 * Ijtbaleauto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbaleauto  implements java.io.Serializable {
    private java.lang.String dsalertaauto;

    private idw.idwws.IjtbaleautoId id;

    private idw.idwws.Ijaleinj[] ijaleinjs;

    private idw.idwws.Ijalertasauto[] ijalertasautos;

    private idw.idwws.Ijtbequipamentos ijtbequipamentos;

    public Ijtbaleauto() {
    }

    public Ijtbaleauto(
           java.lang.String dsalertaauto,
           idw.idwws.IjtbaleautoId id,
           idw.idwws.Ijaleinj[] ijaleinjs,
           idw.idwws.Ijalertasauto[] ijalertasautos,
           idw.idwws.Ijtbequipamentos ijtbequipamentos) {
           this.dsalertaauto = dsalertaauto;
           this.id = id;
           this.ijaleinjs = ijaleinjs;
           this.ijalertasautos = ijalertasautos;
           this.ijtbequipamentos = ijtbequipamentos;
    }


    /**
     * Gets the dsalertaauto value for this Ijtbaleauto.
     * 
     * @return dsalertaauto
     */
    public java.lang.String getDsalertaauto() {
        return dsalertaauto;
    }


    /**
     * Sets the dsalertaauto value for this Ijtbaleauto.
     * 
     * @param dsalertaauto
     */
    public void setDsalertaauto(java.lang.String dsalertaauto) {
        this.dsalertaauto = dsalertaauto;
    }


    /**
     * Gets the id value for this Ijtbaleauto.
     * 
     * @return id
     */
    public idw.idwws.IjtbaleautoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbaleauto.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbaleautoId id) {
        this.id = id;
    }


    /**
     * Gets the ijaleinjs value for this Ijtbaleauto.
     * 
     * @return ijaleinjs
     */
    public idw.idwws.Ijaleinj[] getIjaleinjs() {
        return ijaleinjs;
    }


    /**
     * Sets the ijaleinjs value for this Ijtbaleauto.
     * 
     * @param ijaleinjs
     */
    public void setIjaleinjs(idw.idwws.Ijaleinj[] ijaleinjs) {
        this.ijaleinjs = ijaleinjs;
    }

    public idw.idwws.Ijaleinj getIjaleinjs(int i) {
        return this.ijaleinjs[i];
    }

    public void setIjaleinjs(int i, idw.idwws.Ijaleinj _value) {
        this.ijaleinjs[i] = _value;
    }


    /**
     * Gets the ijalertasautos value for this Ijtbaleauto.
     * 
     * @return ijalertasautos
     */
    public idw.idwws.Ijalertasauto[] getIjalertasautos() {
        return ijalertasautos;
    }


    /**
     * Sets the ijalertasautos value for this Ijtbaleauto.
     * 
     * @param ijalertasautos
     */
    public void setIjalertasautos(idw.idwws.Ijalertasauto[] ijalertasautos) {
        this.ijalertasautos = ijalertasautos;
    }

    public idw.idwws.Ijalertasauto getIjalertasautos(int i) {
        return this.ijalertasautos[i];
    }

    public void setIjalertasautos(int i, idw.idwws.Ijalertasauto _value) {
        this.ijalertasautos[i] = _value;
    }


    /**
     * Gets the ijtbequipamentos value for this Ijtbaleauto.
     * 
     * @return ijtbequipamentos
     */
    public idw.idwws.Ijtbequipamentos getIjtbequipamentos() {
        return ijtbequipamentos;
    }


    /**
     * Sets the ijtbequipamentos value for this Ijtbaleauto.
     * 
     * @param ijtbequipamentos
     */
    public void setIjtbequipamentos(idw.idwws.Ijtbequipamentos ijtbequipamentos) {
        this.ijtbequipamentos = ijtbequipamentos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbaleauto)) return false;
        Ijtbaleauto other = (Ijtbaleauto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsalertaauto==null && other.getDsalertaauto()==null) || 
             (this.dsalertaauto!=null &&
              this.dsalertaauto.equals(other.getDsalertaauto()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijaleinjs==null && other.getIjaleinjs()==null) || 
             (this.ijaleinjs!=null &&
              java.util.Arrays.equals(this.ijaleinjs, other.getIjaleinjs()))) &&
            ((this.ijalertasautos==null && other.getIjalertasautos()==null) || 
             (this.ijalertasautos!=null &&
              java.util.Arrays.equals(this.ijalertasautos, other.getIjalertasautos()))) &&
            ((this.ijtbequipamentos==null && other.getIjtbequipamentos()==null) || 
             (this.ijtbequipamentos!=null &&
              this.ijtbequipamentos.equals(other.getIjtbequipamentos())));
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
        if (getDsalertaauto() != null) {
            _hashCode += getDsalertaauto().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjaleinjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjaleinjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjaleinjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjalertasautos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjalertasautos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjalertasautos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbequipamentos() != null) {
            _hashCode += getIjtbequipamentos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbaleauto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbaleauto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsalertaauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsalertaauto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbaleautoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaleinjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaleinjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaleinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijalertasautos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijalertasautos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertasauto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbequipamentos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbequipamentos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbequipamentos"));
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
