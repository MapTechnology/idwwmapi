/**
 * Ijtbmodulos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmodulos  implements java.io.Serializable {
    private java.lang.String cdmodulo;

    private idw.idwws.Ijcaptionlinguas[] ijcaptionlinguases;

    private idw.idwws.Ijtbidgraf[] ijtbidgrafs;

    private idw.idwws.Ijtbidrpt[] ijtbidrpts;

    private idw.idwws.Ijtbopcmenu[] ijtbopcmenus;

    private java.lang.String nmmodulo;

    public Ijtbmodulos() {
    }

    public Ijtbmodulos(
           java.lang.String cdmodulo,
           idw.idwws.Ijcaptionlinguas[] ijcaptionlinguases,
           idw.idwws.Ijtbidgraf[] ijtbidgrafs,
           idw.idwws.Ijtbidrpt[] ijtbidrpts,
           idw.idwws.Ijtbopcmenu[] ijtbopcmenus,
           java.lang.String nmmodulo) {
           this.cdmodulo = cdmodulo;
           this.ijcaptionlinguases = ijcaptionlinguases;
           this.ijtbidgrafs = ijtbidgrafs;
           this.ijtbidrpts = ijtbidrpts;
           this.ijtbopcmenus = ijtbopcmenus;
           this.nmmodulo = nmmodulo;
    }


    /**
     * Gets the cdmodulo value for this Ijtbmodulos.
     * 
     * @return cdmodulo
     */
    public java.lang.String getCdmodulo() {
        return cdmodulo;
    }


    /**
     * Sets the cdmodulo value for this Ijtbmodulos.
     * 
     * @param cdmodulo
     */
    public void setCdmodulo(java.lang.String cdmodulo) {
        this.cdmodulo = cdmodulo;
    }


    /**
     * Gets the ijcaptionlinguases value for this Ijtbmodulos.
     * 
     * @return ijcaptionlinguases
     */
    public idw.idwws.Ijcaptionlinguas[] getIjcaptionlinguases() {
        return ijcaptionlinguases;
    }


    /**
     * Sets the ijcaptionlinguases value for this Ijtbmodulos.
     * 
     * @param ijcaptionlinguases
     */
    public void setIjcaptionlinguases(idw.idwws.Ijcaptionlinguas[] ijcaptionlinguases) {
        this.ijcaptionlinguases = ijcaptionlinguases;
    }

    public idw.idwws.Ijcaptionlinguas getIjcaptionlinguases(int i) {
        return this.ijcaptionlinguases[i];
    }

    public void setIjcaptionlinguases(int i, idw.idwws.Ijcaptionlinguas _value) {
        this.ijcaptionlinguases[i] = _value;
    }


    /**
     * Gets the ijtbidgrafs value for this Ijtbmodulos.
     * 
     * @return ijtbidgrafs
     */
    public idw.idwws.Ijtbidgraf[] getIjtbidgrafs() {
        return ijtbidgrafs;
    }


    /**
     * Sets the ijtbidgrafs value for this Ijtbmodulos.
     * 
     * @param ijtbidgrafs
     */
    public void setIjtbidgrafs(idw.idwws.Ijtbidgraf[] ijtbidgrafs) {
        this.ijtbidgrafs = ijtbidgrafs;
    }

    public idw.idwws.Ijtbidgraf getIjtbidgrafs(int i) {
        return this.ijtbidgrafs[i];
    }

    public void setIjtbidgrafs(int i, idw.idwws.Ijtbidgraf _value) {
        this.ijtbidgrafs[i] = _value;
    }


    /**
     * Gets the ijtbidrpts value for this Ijtbmodulos.
     * 
     * @return ijtbidrpts
     */
    public idw.idwws.Ijtbidrpt[] getIjtbidrpts() {
        return ijtbidrpts;
    }


    /**
     * Sets the ijtbidrpts value for this Ijtbmodulos.
     * 
     * @param ijtbidrpts
     */
    public void setIjtbidrpts(idw.idwws.Ijtbidrpt[] ijtbidrpts) {
        this.ijtbidrpts = ijtbidrpts;
    }

    public idw.idwws.Ijtbidrpt getIjtbidrpts(int i) {
        return this.ijtbidrpts[i];
    }

    public void setIjtbidrpts(int i, idw.idwws.Ijtbidrpt _value) {
        this.ijtbidrpts[i] = _value;
    }


    /**
     * Gets the ijtbopcmenus value for this Ijtbmodulos.
     * 
     * @return ijtbopcmenus
     */
    public idw.idwws.Ijtbopcmenu[] getIjtbopcmenus() {
        return ijtbopcmenus;
    }


    /**
     * Sets the ijtbopcmenus value for this Ijtbmodulos.
     * 
     * @param ijtbopcmenus
     */
    public void setIjtbopcmenus(idw.idwws.Ijtbopcmenu[] ijtbopcmenus) {
        this.ijtbopcmenus = ijtbopcmenus;
    }

    public idw.idwws.Ijtbopcmenu getIjtbopcmenus(int i) {
        return this.ijtbopcmenus[i];
    }

    public void setIjtbopcmenus(int i, idw.idwws.Ijtbopcmenu _value) {
        this.ijtbopcmenus[i] = _value;
    }


    /**
     * Gets the nmmodulo value for this Ijtbmodulos.
     * 
     * @return nmmodulo
     */
    public java.lang.String getNmmodulo() {
        return nmmodulo;
    }


    /**
     * Sets the nmmodulo value for this Ijtbmodulos.
     * 
     * @param nmmodulo
     */
    public void setNmmodulo(java.lang.String nmmodulo) {
        this.nmmodulo = nmmodulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmodulos)) return false;
        Ijtbmodulos other = (Ijtbmodulos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmodulo==null && other.getCdmodulo()==null) || 
             (this.cdmodulo!=null &&
              this.cdmodulo.equals(other.getCdmodulo()))) &&
            ((this.ijcaptionlinguases==null && other.getIjcaptionlinguases()==null) || 
             (this.ijcaptionlinguases!=null &&
              java.util.Arrays.equals(this.ijcaptionlinguases, other.getIjcaptionlinguases()))) &&
            ((this.ijtbidgrafs==null && other.getIjtbidgrafs()==null) || 
             (this.ijtbidgrafs!=null &&
              java.util.Arrays.equals(this.ijtbidgrafs, other.getIjtbidgrafs()))) &&
            ((this.ijtbidrpts==null && other.getIjtbidrpts()==null) || 
             (this.ijtbidrpts!=null &&
              java.util.Arrays.equals(this.ijtbidrpts, other.getIjtbidrpts()))) &&
            ((this.ijtbopcmenus==null && other.getIjtbopcmenus()==null) || 
             (this.ijtbopcmenus!=null &&
              java.util.Arrays.equals(this.ijtbopcmenus, other.getIjtbopcmenus()))) &&
            ((this.nmmodulo==null && other.getNmmodulo()==null) || 
             (this.nmmodulo!=null &&
              this.nmmodulo.equals(other.getNmmodulo())));
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
        if (getCdmodulo() != null) {
            _hashCode += getCdmodulo().hashCode();
        }
        if (getIjcaptionlinguases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcaptionlinguases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcaptionlinguases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbidgrafs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbidgrafs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbidgrafs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbidrpts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbidrpts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbidrpts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbopcmenus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbopcmenus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbopcmenus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNmmodulo() != null) {
            _hashCode += getNmmodulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbmodulos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodulos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmodulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmodulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcaptionlinguases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcaptionlinguases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcaptionlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbidgrafs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbidgrafs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidgraf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbidrpts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbidrpts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbidrpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbopcmenus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbopcmenus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbopcmenu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmmodulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmmodulo"));
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
