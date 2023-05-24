/**
 * Ijtbclixplantas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbclixplantas  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedShort excluido;

    private idw.idwws.IjtbclixplantasId id;

    private idw.idwws.Ijctrlcgqxplantas[] ijctrlcgqxplantases;

    private idw.idwws.Ijtbcli ijtbcli;

    private idw.idwws.Ijtbclixcttcgq[] ijtbclixcttcgqs;

    private org.apache.axis.types.UnsignedShort stativo;

    public Ijtbclixplantas() {
    }

    public Ijtbclixplantas(
           org.apache.axis.types.UnsignedShort excluido,
           idw.idwws.IjtbclixplantasId id,
           idw.idwws.Ijctrlcgqxplantas[] ijctrlcgqxplantases,
           idw.idwws.Ijtbcli ijtbcli,
           idw.idwws.Ijtbclixcttcgq[] ijtbclixcttcgqs,
           org.apache.axis.types.UnsignedShort stativo) {
           this.excluido = excluido;
           this.id = id;
           this.ijctrlcgqxplantases = ijctrlcgqxplantases;
           this.ijtbcli = ijtbcli;
           this.ijtbclixcttcgqs = ijtbclixcttcgqs;
           this.stativo = stativo;
    }


    /**
     * Gets the excluido value for this Ijtbclixplantas.
     * 
     * @return excluido
     */
    public org.apache.axis.types.UnsignedShort getExcluido() {
        return excluido;
    }


    /**
     * Sets the excluido value for this Ijtbclixplantas.
     * 
     * @param excluido
     */
    public void setExcluido(org.apache.axis.types.UnsignedShort excluido) {
        this.excluido = excluido;
    }


    /**
     * Gets the id value for this Ijtbclixplantas.
     * 
     * @return id
     */
    public idw.idwws.IjtbclixplantasId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbclixplantas.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbclixplantasId id) {
        this.id = id;
    }


    /**
     * Gets the ijctrlcgqxplantases value for this Ijtbclixplantas.
     * 
     * @return ijctrlcgqxplantases
     */
    public idw.idwws.Ijctrlcgqxplantas[] getIjctrlcgqxplantases() {
        return ijctrlcgqxplantases;
    }


    /**
     * Sets the ijctrlcgqxplantases value for this Ijtbclixplantas.
     * 
     * @param ijctrlcgqxplantases
     */
    public void setIjctrlcgqxplantases(idw.idwws.Ijctrlcgqxplantas[] ijctrlcgqxplantases) {
        this.ijctrlcgqxplantases = ijctrlcgqxplantases;
    }

    public idw.idwws.Ijctrlcgqxplantas getIjctrlcgqxplantases(int i) {
        return this.ijctrlcgqxplantases[i];
    }

    public void setIjctrlcgqxplantases(int i, idw.idwws.Ijctrlcgqxplantas _value) {
        this.ijctrlcgqxplantases[i] = _value;
    }


    /**
     * Gets the ijtbcli value for this Ijtbclixplantas.
     * 
     * @return ijtbcli
     */
    public idw.idwws.Ijtbcli getIjtbcli() {
        return ijtbcli;
    }


    /**
     * Sets the ijtbcli value for this Ijtbclixplantas.
     * 
     * @param ijtbcli
     */
    public void setIjtbcli(idw.idwws.Ijtbcli ijtbcli) {
        this.ijtbcli = ijtbcli;
    }


    /**
     * Gets the ijtbclixcttcgqs value for this Ijtbclixplantas.
     * 
     * @return ijtbclixcttcgqs
     */
    public idw.idwws.Ijtbclixcttcgq[] getIjtbclixcttcgqs() {
        return ijtbclixcttcgqs;
    }


    /**
     * Sets the ijtbclixcttcgqs value for this Ijtbclixplantas.
     * 
     * @param ijtbclixcttcgqs
     */
    public void setIjtbclixcttcgqs(idw.idwws.Ijtbclixcttcgq[] ijtbclixcttcgqs) {
        this.ijtbclixcttcgqs = ijtbclixcttcgqs;
    }

    public idw.idwws.Ijtbclixcttcgq getIjtbclixcttcgqs(int i) {
        return this.ijtbclixcttcgqs[i];
    }

    public void setIjtbclixcttcgqs(int i, idw.idwws.Ijtbclixcttcgq _value) {
        this.ijtbclixcttcgqs[i] = _value;
    }


    /**
     * Gets the stativo value for this Ijtbclixplantas.
     * 
     * @return stativo
     */
    public org.apache.axis.types.UnsignedShort getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbclixplantas.
     * 
     * @param stativo
     */
    public void setStativo(org.apache.axis.types.UnsignedShort stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbclixplantas)) return false;
        Ijtbclixplantas other = (Ijtbclixplantas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.excluido==null && other.getExcluido()==null) || 
             (this.excluido!=null &&
              this.excluido.equals(other.getExcluido()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijctrlcgqxplantases==null && other.getIjctrlcgqxplantases()==null) || 
             (this.ijctrlcgqxplantases!=null &&
              java.util.Arrays.equals(this.ijctrlcgqxplantases, other.getIjctrlcgqxplantases()))) &&
            ((this.ijtbcli==null && other.getIjtbcli()==null) || 
             (this.ijtbcli!=null &&
              this.ijtbcli.equals(other.getIjtbcli()))) &&
            ((this.ijtbclixcttcgqs==null && other.getIjtbclixcttcgqs()==null) || 
             (this.ijtbclixcttcgqs!=null &&
              java.util.Arrays.equals(this.ijtbclixcttcgqs, other.getIjtbclixcttcgqs()))) &&
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
        if (getExcluido() != null) {
            _hashCode += getExcluido().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjctrlcgqxplantases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqxplantases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqxplantases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbcli() != null) {
            _hashCode += getIjtbcli().hashCode();
        }
        if (getIjtbclixcttcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbclixcttcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbclixcttcgqs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbclixplantas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixplantas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excluido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "excluido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixplantasId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqxplantases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqxplantases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxplantas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcli");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcli"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbclixcttcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbclixcttcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixcttcgq"));
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
