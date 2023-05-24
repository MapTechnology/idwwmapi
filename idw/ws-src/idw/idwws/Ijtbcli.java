/**
 * Ijtbcli.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbcli  implements java.io.Serializable {
    private java.lang.String cdcliente;

    private java.lang.String dscliente;

    private idw.idwws.Ijcarteira[] ijcarteiras;

    private idw.idwws.Ijtbclierp[] ijtbclierps;

    private idw.idwws.Ijtbclixplantas[] ijtbclixplantases;

    private idw.idwws.Ijtblicfgenviarcgq[] ijtblicfgenviarcgqs;

    private idw.idwws.Ijtbmol[] ijtbmols;

    public Ijtbcli() {
    }

    public Ijtbcli(
           java.lang.String cdcliente,
           java.lang.String dscliente,
           idw.idwws.Ijcarteira[] ijcarteiras,
           idw.idwws.Ijtbclierp[] ijtbclierps,
           idw.idwws.Ijtbclixplantas[] ijtbclixplantases,
           idw.idwws.Ijtblicfgenviarcgq[] ijtblicfgenviarcgqs,
           idw.idwws.Ijtbmol[] ijtbmols) {
           this.cdcliente = cdcliente;
           this.dscliente = dscliente;
           this.ijcarteiras = ijcarteiras;
           this.ijtbclierps = ijtbclierps;
           this.ijtbclixplantases = ijtbclixplantases;
           this.ijtblicfgenviarcgqs = ijtblicfgenviarcgqs;
           this.ijtbmols = ijtbmols;
    }


    /**
     * Gets the cdcliente value for this Ijtbcli.
     * 
     * @return cdcliente
     */
    public java.lang.String getCdcliente() {
        return cdcliente;
    }


    /**
     * Sets the cdcliente value for this Ijtbcli.
     * 
     * @param cdcliente
     */
    public void setCdcliente(java.lang.String cdcliente) {
        this.cdcliente = cdcliente;
    }


    /**
     * Gets the dscliente value for this Ijtbcli.
     * 
     * @return dscliente
     */
    public java.lang.String getDscliente() {
        return dscliente;
    }


    /**
     * Sets the dscliente value for this Ijtbcli.
     * 
     * @param dscliente
     */
    public void setDscliente(java.lang.String dscliente) {
        this.dscliente = dscliente;
    }


    /**
     * Gets the ijcarteiras value for this Ijtbcli.
     * 
     * @return ijcarteiras
     */
    public idw.idwws.Ijcarteira[] getIjcarteiras() {
        return ijcarteiras;
    }


    /**
     * Sets the ijcarteiras value for this Ijtbcli.
     * 
     * @param ijcarteiras
     */
    public void setIjcarteiras(idw.idwws.Ijcarteira[] ijcarteiras) {
        this.ijcarteiras = ijcarteiras;
    }

    public idw.idwws.Ijcarteira getIjcarteiras(int i) {
        return this.ijcarteiras[i];
    }

    public void setIjcarteiras(int i, idw.idwws.Ijcarteira _value) {
        this.ijcarteiras[i] = _value;
    }


    /**
     * Gets the ijtbclierps value for this Ijtbcli.
     * 
     * @return ijtbclierps
     */
    public idw.idwws.Ijtbclierp[] getIjtbclierps() {
        return ijtbclierps;
    }


    /**
     * Sets the ijtbclierps value for this Ijtbcli.
     * 
     * @param ijtbclierps
     */
    public void setIjtbclierps(idw.idwws.Ijtbclierp[] ijtbclierps) {
        this.ijtbclierps = ijtbclierps;
    }

    public idw.idwws.Ijtbclierp getIjtbclierps(int i) {
        return this.ijtbclierps[i];
    }

    public void setIjtbclierps(int i, idw.idwws.Ijtbclierp _value) {
        this.ijtbclierps[i] = _value;
    }


    /**
     * Gets the ijtbclixplantases value for this Ijtbcli.
     * 
     * @return ijtbclixplantases
     */
    public idw.idwws.Ijtbclixplantas[] getIjtbclixplantases() {
        return ijtbclixplantases;
    }


    /**
     * Sets the ijtbclixplantases value for this Ijtbcli.
     * 
     * @param ijtbclixplantases
     */
    public void setIjtbclixplantases(idw.idwws.Ijtbclixplantas[] ijtbclixplantases) {
        this.ijtbclixplantases = ijtbclixplantases;
    }

    public idw.idwws.Ijtbclixplantas getIjtbclixplantases(int i) {
        return this.ijtbclixplantases[i];
    }

    public void setIjtbclixplantases(int i, idw.idwws.Ijtbclixplantas _value) {
        this.ijtbclixplantases[i] = _value;
    }


    /**
     * Gets the ijtblicfgenviarcgqs value for this Ijtbcli.
     * 
     * @return ijtblicfgenviarcgqs
     */
    public idw.idwws.Ijtblicfgenviarcgq[] getIjtblicfgenviarcgqs() {
        return ijtblicfgenviarcgqs;
    }


    /**
     * Sets the ijtblicfgenviarcgqs value for this Ijtbcli.
     * 
     * @param ijtblicfgenviarcgqs
     */
    public void setIjtblicfgenviarcgqs(idw.idwws.Ijtblicfgenviarcgq[] ijtblicfgenviarcgqs) {
        this.ijtblicfgenviarcgqs = ijtblicfgenviarcgqs;
    }

    public idw.idwws.Ijtblicfgenviarcgq getIjtblicfgenviarcgqs(int i) {
        return this.ijtblicfgenviarcgqs[i];
    }

    public void setIjtblicfgenviarcgqs(int i, idw.idwws.Ijtblicfgenviarcgq _value) {
        this.ijtblicfgenviarcgqs[i] = _value;
    }


    /**
     * Gets the ijtbmols value for this Ijtbcli.
     * 
     * @return ijtbmols
     */
    public idw.idwws.Ijtbmol[] getIjtbmols() {
        return ijtbmols;
    }


    /**
     * Sets the ijtbmols value for this Ijtbcli.
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbcli)) return false;
        Ijtbcli other = (Ijtbcli) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcliente==null && other.getCdcliente()==null) || 
             (this.cdcliente!=null &&
              this.cdcliente.equals(other.getCdcliente()))) &&
            ((this.dscliente==null && other.getDscliente()==null) || 
             (this.dscliente!=null &&
              this.dscliente.equals(other.getDscliente()))) &&
            ((this.ijcarteiras==null && other.getIjcarteiras()==null) || 
             (this.ijcarteiras!=null &&
              java.util.Arrays.equals(this.ijcarteiras, other.getIjcarteiras()))) &&
            ((this.ijtbclierps==null && other.getIjtbclierps()==null) || 
             (this.ijtbclierps!=null &&
              java.util.Arrays.equals(this.ijtbclierps, other.getIjtbclierps()))) &&
            ((this.ijtbclixplantases==null && other.getIjtbclixplantases()==null) || 
             (this.ijtbclixplantases!=null &&
              java.util.Arrays.equals(this.ijtbclixplantases, other.getIjtbclixplantases()))) &&
            ((this.ijtblicfgenviarcgqs==null && other.getIjtblicfgenviarcgqs()==null) || 
             (this.ijtblicfgenviarcgqs!=null &&
              java.util.Arrays.equals(this.ijtblicfgenviarcgqs, other.getIjtblicfgenviarcgqs()))) &&
            ((this.ijtbmols==null && other.getIjtbmols()==null) || 
             (this.ijtbmols!=null &&
              java.util.Arrays.equals(this.ijtbmols, other.getIjtbmols())));
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
        if (getCdcliente() != null) {
            _hashCode += getCdcliente().hashCode();
        }
        if (getDscliente() != null) {
            _hashCode += getDscliente().hashCode();
        }
        if (getIjcarteiras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcarteiras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcarteiras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbclierps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbclierps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbclierps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbclixplantases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbclixplantases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbclixplantases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtblicfgenviarcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtblicfgenviarcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtblicfgenviarcgqs(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbcli.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcli"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcarteiras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcarteiras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcarteira"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbclierps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbclierps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclierp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbclixplantases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbclixplantases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixplantas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtblicfgenviarcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtblicfgenviarcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtblicfgenviarcgq"));
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
