/**
 * Ijgrpparaminsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpparaminsp  implements java.io.Serializable {
    private java.lang.String cdgrpparam;

    private java.lang.String dsgrpparam;

    private idw.idwws.Ijaledbqld[] ijaledbqlds;

    private idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S;

    private idw.idwws.Ijgrpparaminspxord[] ijgrpparaminspxords;

    private idw.idwws.Ijinspecao[] ijinspecaos;

    private idw.idwws.Ijprodxgrpparam[] ijprodxgrpparams;

    private java.math.BigDecimal tpgrpparaminsp;

    public Ijgrpparaminsp() {
    }

    public Ijgrpparaminsp(
           java.lang.String cdgrpparam,
           java.lang.String dsgrpparam,
           idw.idwws.Ijaledbqld[] ijaledbqlds,
           idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S,
           idw.idwws.Ijgrpparaminspxord[] ijgrpparaminspxords,
           idw.idwws.Ijinspecao[] ijinspecaos,
           idw.idwws.Ijprodxgrpparam[] ijprodxgrpparams,
           java.math.BigDecimal tpgrpparaminsp) {
           this.cdgrpparam = cdgrpparam;
           this.dsgrpparam = dsgrpparam;
           this.ijaledbqlds = ijaledbqlds;
           this.ijctrlresnegqld2S = ijctrlresnegqld2S;
           this.ijgrpparaminspxords = ijgrpparaminspxords;
           this.ijinspecaos = ijinspecaos;
           this.ijprodxgrpparams = ijprodxgrpparams;
           this.tpgrpparaminsp = tpgrpparaminsp;
    }


    /**
     * Gets the cdgrpparam value for this Ijgrpparaminsp.
     * 
     * @return cdgrpparam
     */
    public java.lang.String getCdgrpparam() {
        return cdgrpparam;
    }


    /**
     * Sets the cdgrpparam value for this Ijgrpparaminsp.
     * 
     * @param cdgrpparam
     */
    public void setCdgrpparam(java.lang.String cdgrpparam) {
        this.cdgrpparam = cdgrpparam;
    }


    /**
     * Gets the dsgrpparam value for this Ijgrpparaminsp.
     * 
     * @return dsgrpparam
     */
    public java.lang.String getDsgrpparam() {
        return dsgrpparam;
    }


    /**
     * Sets the dsgrpparam value for this Ijgrpparaminsp.
     * 
     * @param dsgrpparam
     */
    public void setDsgrpparam(java.lang.String dsgrpparam) {
        this.dsgrpparam = dsgrpparam;
    }


    /**
     * Gets the ijaledbqlds value for this Ijgrpparaminsp.
     * 
     * @return ijaledbqlds
     */
    public idw.idwws.Ijaledbqld[] getIjaledbqlds() {
        return ijaledbqlds;
    }


    /**
     * Sets the ijaledbqlds value for this Ijgrpparaminsp.
     * 
     * @param ijaledbqlds
     */
    public void setIjaledbqlds(idw.idwws.Ijaledbqld[] ijaledbqlds) {
        this.ijaledbqlds = ijaledbqlds;
    }

    public idw.idwws.Ijaledbqld getIjaledbqlds(int i) {
        return this.ijaledbqlds[i];
    }

    public void setIjaledbqlds(int i, idw.idwws.Ijaledbqld _value) {
        this.ijaledbqlds[i] = _value;
    }


    /**
     * Gets the ijctrlresnegqld2S value for this Ijgrpparaminsp.
     * 
     * @return ijctrlresnegqld2S
     */
    public idw.idwws.Ijctrlresnegqld2[] getIjctrlresnegqld2S() {
        return ijctrlresnegqld2S;
    }


    /**
     * Sets the ijctrlresnegqld2S value for this Ijgrpparaminsp.
     * 
     * @param ijctrlresnegqld2S
     */
    public void setIjctrlresnegqld2S(idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S) {
        this.ijctrlresnegqld2S = ijctrlresnegqld2S;
    }

    public idw.idwws.Ijctrlresnegqld2 getIjctrlresnegqld2S(int i) {
        return this.ijctrlresnegqld2S[i];
    }

    public void setIjctrlresnegqld2S(int i, idw.idwws.Ijctrlresnegqld2 _value) {
        this.ijctrlresnegqld2S[i] = _value;
    }


    /**
     * Gets the ijgrpparaminspxords value for this Ijgrpparaminsp.
     * 
     * @return ijgrpparaminspxords
     */
    public idw.idwws.Ijgrpparaminspxord[] getIjgrpparaminspxords() {
        return ijgrpparaminspxords;
    }


    /**
     * Sets the ijgrpparaminspxords value for this Ijgrpparaminsp.
     * 
     * @param ijgrpparaminspxords
     */
    public void setIjgrpparaminspxords(idw.idwws.Ijgrpparaminspxord[] ijgrpparaminspxords) {
        this.ijgrpparaminspxords = ijgrpparaminspxords;
    }

    public idw.idwws.Ijgrpparaminspxord getIjgrpparaminspxords(int i) {
        return this.ijgrpparaminspxords[i];
    }

    public void setIjgrpparaminspxords(int i, idw.idwws.Ijgrpparaminspxord _value) {
        this.ijgrpparaminspxords[i] = _value;
    }


    /**
     * Gets the ijinspecaos value for this Ijgrpparaminsp.
     * 
     * @return ijinspecaos
     */
    public idw.idwws.Ijinspecao[] getIjinspecaos() {
        return ijinspecaos;
    }


    /**
     * Sets the ijinspecaos value for this Ijgrpparaminsp.
     * 
     * @param ijinspecaos
     */
    public void setIjinspecaos(idw.idwws.Ijinspecao[] ijinspecaos) {
        this.ijinspecaos = ijinspecaos;
    }

    public idw.idwws.Ijinspecao getIjinspecaos(int i) {
        return this.ijinspecaos[i];
    }

    public void setIjinspecaos(int i, idw.idwws.Ijinspecao _value) {
        this.ijinspecaos[i] = _value;
    }


    /**
     * Gets the ijprodxgrpparams value for this Ijgrpparaminsp.
     * 
     * @return ijprodxgrpparams
     */
    public idw.idwws.Ijprodxgrpparam[] getIjprodxgrpparams() {
        return ijprodxgrpparams;
    }


    /**
     * Sets the ijprodxgrpparams value for this Ijgrpparaminsp.
     * 
     * @param ijprodxgrpparams
     */
    public void setIjprodxgrpparams(idw.idwws.Ijprodxgrpparam[] ijprodxgrpparams) {
        this.ijprodxgrpparams = ijprodxgrpparams;
    }

    public idw.idwws.Ijprodxgrpparam getIjprodxgrpparams(int i) {
        return this.ijprodxgrpparams[i];
    }

    public void setIjprodxgrpparams(int i, idw.idwws.Ijprodxgrpparam _value) {
        this.ijprodxgrpparams[i] = _value;
    }


    /**
     * Gets the tpgrpparaminsp value for this Ijgrpparaminsp.
     * 
     * @return tpgrpparaminsp
     */
    public java.math.BigDecimal getTpgrpparaminsp() {
        return tpgrpparaminsp;
    }


    /**
     * Sets the tpgrpparaminsp value for this Ijgrpparaminsp.
     * 
     * @param tpgrpparaminsp
     */
    public void setTpgrpparaminsp(java.math.BigDecimal tpgrpparaminsp) {
        this.tpgrpparaminsp = tpgrpparaminsp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpparaminsp)) return false;
        Ijgrpparaminsp other = (Ijgrpparaminsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrpparam==null && other.getCdgrpparam()==null) || 
             (this.cdgrpparam!=null &&
              this.cdgrpparam.equals(other.getCdgrpparam()))) &&
            ((this.dsgrpparam==null && other.getDsgrpparam()==null) || 
             (this.dsgrpparam!=null &&
              this.dsgrpparam.equals(other.getDsgrpparam()))) &&
            ((this.ijaledbqlds==null && other.getIjaledbqlds()==null) || 
             (this.ijaledbqlds!=null &&
              java.util.Arrays.equals(this.ijaledbqlds, other.getIjaledbqlds()))) &&
            ((this.ijctrlresnegqld2S==null && other.getIjctrlresnegqld2S()==null) || 
             (this.ijctrlresnegqld2S!=null &&
              java.util.Arrays.equals(this.ijctrlresnegqld2S, other.getIjctrlresnegqld2S()))) &&
            ((this.ijgrpparaminspxords==null && other.getIjgrpparaminspxords()==null) || 
             (this.ijgrpparaminspxords!=null &&
              java.util.Arrays.equals(this.ijgrpparaminspxords, other.getIjgrpparaminspxords()))) &&
            ((this.ijinspecaos==null && other.getIjinspecaos()==null) || 
             (this.ijinspecaos!=null &&
              java.util.Arrays.equals(this.ijinspecaos, other.getIjinspecaos()))) &&
            ((this.ijprodxgrpparams==null && other.getIjprodxgrpparams()==null) || 
             (this.ijprodxgrpparams!=null &&
              java.util.Arrays.equals(this.ijprodxgrpparams, other.getIjprodxgrpparams()))) &&
            ((this.tpgrpparaminsp==null && other.getTpgrpparaminsp()==null) || 
             (this.tpgrpparaminsp!=null &&
              this.tpgrpparaminsp.equals(other.getTpgrpparaminsp())));
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
        if (getCdgrpparam() != null) {
            _hashCode += getCdgrpparam().hashCode();
        }
        if (getDsgrpparam() != null) {
            _hashCode += getDsgrpparam().hashCode();
        }
        if (getIjaledbqlds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjaledbqlds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjaledbqlds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlresnegqld2S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlresnegqld2S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlresnegqld2S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpparaminspxords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpparaminspxords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpparaminspxords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjinspecaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjinspecaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjinspecaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjprodxgrpparams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprodxgrpparams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprodxgrpparams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTpgrpparaminsp() != null) {
            _hashCode += getTpgrpparaminsp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpparaminsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrpparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrpparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrpparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrpparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqlds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqlds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqld"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlresnegqld2S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlresnegqld2s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlresnegqld2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpparaminspxords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpparaminspxords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminspxord"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprodxgrpparams");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprodxgrpparams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxgrpparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpgrpparaminsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpgrpparaminsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
