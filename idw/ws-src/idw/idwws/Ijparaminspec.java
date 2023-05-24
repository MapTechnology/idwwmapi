/**
 * Ijparaminspec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijparaminspec  implements java.io.Serializable {
    private java.lang.String dsespecific;

    private java.lang.String idauxdrivercelcar;

    private java.lang.String idespecific;

    private idw.idwws.Ijdrvcntexecprtdef[] ijdrvcntexecprtdefs;

    private idw.idwws.Ijespecinspromedia[] ijespecinspromedias;

    private idw.idwws.Ijgrcarcrtctrlxesp[] ijgrcarcrtctrlxesps;

    private idw.idwws.Ijgrpparaminspxord[] ijgrpparaminspxords;

    private java.math.BigDecimal tpespecific;

    private java.lang.String unidmedida;

    public Ijparaminspec() {
    }

    public Ijparaminspec(
           java.lang.String dsespecific,
           java.lang.String idauxdrivercelcar,
           java.lang.String idespecific,
           idw.idwws.Ijdrvcntexecprtdef[] ijdrvcntexecprtdefs,
           idw.idwws.Ijespecinspromedia[] ijespecinspromedias,
           idw.idwws.Ijgrcarcrtctrlxesp[] ijgrcarcrtctrlxesps,
           idw.idwws.Ijgrpparaminspxord[] ijgrpparaminspxords,
           java.math.BigDecimal tpespecific,
           java.lang.String unidmedida) {
           this.dsespecific = dsespecific;
           this.idauxdrivercelcar = idauxdrivercelcar;
           this.idespecific = idespecific;
           this.ijdrvcntexecprtdefs = ijdrvcntexecprtdefs;
           this.ijespecinspromedias = ijespecinspromedias;
           this.ijgrcarcrtctrlxesps = ijgrcarcrtctrlxesps;
           this.ijgrpparaminspxords = ijgrpparaminspxords;
           this.tpespecific = tpespecific;
           this.unidmedida = unidmedida;
    }


    /**
     * Gets the dsespecific value for this Ijparaminspec.
     * 
     * @return dsespecific
     */
    public java.lang.String getDsespecific() {
        return dsespecific;
    }


    /**
     * Sets the dsespecific value for this Ijparaminspec.
     * 
     * @param dsespecific
     */
    public void setDsespecific(java.lang.String dsespecific) {
        this.dsespecific = dsespecific;
    }


    /**
     * Gets the idauxdrivercelcar value for this Ijparaminspec.
     * 
     * @return idauxdrivercelcar
     */
    public java.lang.String getIdauxdrivercelcar() {
        return idauxdrivercelcar;
    }


    /**
     * Sets the idauxdrivercelcar value for this Ijparaminspec.
     * 
     * @param idauxdrivercelcar
     */
    public void setIdauxdrivercelcar(java.lang.String idauxdrivercelcar) {
        this.idauxdrivercelcar = idauxdrivercelcar;
    }


    /**
     * Gets the idespecific value for this Ijparaminspec.
     * 
     * @return idespecific
     */
    public java.lang.String getIdespecific() {
        return idespecific;
    }


    /**
     * Sets the idespecific value for this Ijparaminspec.
     * 
     * @param idespecific
     */
    public void setIdespecific(java.lang.String idespecific) {
        this.idespecific = idespecific;
    }


    /**
     * Gets the ijdrvcntexecprtdefs value for this Ijparaminspec.
     * 
     * @return ijdrvcntexecprtdefs
     */
    public idw.idwws.Ijdrvcntexecprtdef[] getIjdrvcntexecprtdefs() {
        return ijdrvcntexecprtdefs;
    }


    /**
     * Sets the ijdrvcntexecprtdefs value for this Ijparaminspec.
     * 
     * @param ijdrvcntexecprtdefs
     */
    public void setIjdrvcntexecprtdefs(idw.idwws.Ijdrvcntexecprtdef[] ijdrvcntexecprtdefs) {
        this.ijdrvcntexecprtdefs = ijdrvcntexecprtdefs;
    }

    public idw.idwws.Ijdrvcntexecprtdef getIjdrvcntexecprtdefs(int i) {
        return this.ijdrvcntexecprtdefs[i];
    }

    public void setIjdrvcntexecprtdefs(int i, idw.idwws.Ijdrvcntexecprtdef _value) {
        this.ijdrvcntexecprtdefs[i] = _value;
    }


    /**
     * Gets the ijespecinspromedias value for this Ijparaminspec.
     * 
     * @return ijespecinspromedias
     */
    public idw.idwws.Ijespecinspromedia[] getIjespecinspromedias() {
        return ijespecinspromedias;
    }


    /**
     * Sets the ijespecinspromedias value for this Ijparaminspec.
     * 
     * @param ijespecinspromedias
     */
    public void setIjespecinspromedias(idw.idwws.Ijespecinspromedia[] ijespecinspromedias) {
        this.ijespecinspromedias = ijespecinspromedias;
    }

    public idw.idwws.Ijespecinspromedia getIjespecinspromedias(int i) {
        return this.ijespecinspromedias[i];
    }

    public void setIjespecinspromedias(int i, idw.idwws.Ijespecinspromedia _value) {
        this.ijespecinspromedias[i] = _value;
    }


    /**
     * Gets the ijgrcarcrtctrlxesps value for this Ijparaminspec.
     * 
     * @return ijgrcarcrtctrlxesps
     */
    public idw.idwws.Ijgrcarcrtctrlxesp[] getIjgrcarcrtctrlxesps() {
        return ijgrcarcrtctrlxesps;
    }


    /**
     * Sets the ijgrcarcrtctrlxesps value for this Ijparaminspec.
     * 
     * @param ijgrcarcrtctrlxesps
     */
    public void setIjgrcarcrtctrlxesps(idw.idwws.Ijgrcarcrtctrlxesp[] ijgrcarcrtctrlxesps) {
        this.ijgrcarcrtctrlxesps = ijgrcarcrtctrlxesps;
    }

    public idw.idwws.Ijgrcarcrtctrlxesp getIjgrcarcrtctrlxesps(int i) {
        return this.ijgrcarcrtctrlxesps[i];
    }

    public void setIjgrcarcrtctrlxesps(int i, idw.idwws.Ijgrcarcrtctrlxesp _value) {
        this.ijgrcarcrtctrlxesps[i] = _value;
    }


    /**
     * Gets the ijgrpparaminspxords value for this Ijparaminspec.
     * 
     * @return ijgrpparaminspxords
     */
    public idw.idwws.Ijgrpparaminspxord[] getIjgrpparaminspxords() {
        return ijgrpparaminspxords;
    }


    /**
     * Sets the ijgrpparaminspxords value for this Ijparaminspec.
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
     * Gets the tpespecific value for this Ijparaminspec.
     * 
     * @return tpespecific
     */
    public java.math.BigDecimal getTpespecific() {
        return tpespecific;
    }


    /**
     * Sets the tpespecific value for this Ijparaminspec.
     * 
     * @param tpespecific
     */
    public void setTpespecific(java.math.BigDecimal tpespecific) {
        this.tpespecific = tpespecific;
    }


    /**
     * Gets the unidmedida value for this Ijparaminspec.
     * 
     * @return unidmedida
     */
    public java.lang.String getUnidmedida() {
        return unidmedida;
    }


    /**
     * Sets the unidmedida value for this Ijparaminspec.
     * 
     * @param unidmedida
     */
    public void setUnidmedida(java.lang.String unidmedida) {
        this.unidmedida = unidmedida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijparaminspec)) return false;
        Ijparaminspec other = (Ijparaminspec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsespecific==null && other.getDsespecific()==null) || 
             (this.dsespecific!=null &&
              this.dsespecific.equals(other.getDsespecific()))) &&
            ((this.idauxdrivercelcar==null && other.getIdauxdrivercelcar()==null) || 
             (this.idauxdrivercelcar!=null &&
              this.idauxdrivercelcar.equals(other.getIdauxdrivercelcar()))) &&
            ((this.idespecific==null && other.getIdespecific()==null) || 
             (this.idespecific!=null &&
              this.idespecific.equals(other.getIdespecific()))) &&
            ((this.ijdrvcntexecprtdefs==null && other.getIjdrvcntexecprtdefs()==null) || 
             (this.ijdrvcntexecprtdefs!=null &&
              java.util.Arrays.equals(this.ijdrvcntexecprtdefs, other.getIjdrvcntexecprtdefs()))) &&
            ((this.ijespecinspromedias==null && other.getIjespecinspromedias()==null) || 
             (this.ijespecinspromedias!=null &&
              java.util.Arrays.equals(this.ijespecinspromedias, other.getIjespecinspromedias()))) &&
            ((this.ijgrcarcrtctrlxesps==null && other.getIjgrcarcrtctrlxesps()==null) || 
             (this.ijgrcarcrtctrlxesps!=null &&
              java.util.Arrays.equals(this.ijgrcarcrtctrlxesps, other.getIjgrcarcrtctrlxesps()))) &&
            ((this.ijgrpparaminspxords==null && other.getIjgrpparaminspxords()==null) || 
             (this.ijgrpparaminspxords!=null &&
              java.util.Arrays.equals(this.ijgrpparaminspxords, other.getIjgrpparaminspxords()))) &&
            ((this.tpespecific==null && other.getTpespecific()==null) || 
             (this.tpespecific!=null &&
              this.tpespecific.equals(other.getTpespecific()))) &&
            ((this.unidmedida==null && other.getUnidmedida()==null) || 
             (this.unidmedida!=null &&
              this.unidmedida.equals(other.getUnidmedida())));
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
        if (getDsespecific() != null) {
            _hashCode += getDsespecific().hashCode();
        }
        if (getIdauxdrivercelcar() != null) {
            _hashCode += getIdauxdrivercelcar().hashCode();
        }
        if (getIdespecific() != null) {
            _hashCode += getIdespecific().hashCode();
        }
        if (getIjdrvcntexecprtdefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdrvcntexecprtdefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdrvcntexecprtdefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjespecinspromedias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjespecinspromedias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjespecinspromedias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrcarcrtctrlxesps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrcarcrtctrlxesps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrcarcrtctrlxesps(), i);
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
        if (getTpespecific() != null) {
            _hashCode += getTpespecific().hashCode();
        }
        if (getUnidmedida() != null) {
            _hashCode += getUnidmedida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijparaminspec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminspec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idauxdrivercelcar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idauxdrivercelcar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdrvcntexecprtdefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdrvcntexecprtdefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrvcntexecprtdef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijespecinspromedias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijespecinspromedias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinspromedia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrcarcrtctrlxesps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrcarcrtctrlxesps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrcarcrtctrlxesp"));
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
        elemField.setFieldName("tpespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidmedida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidmedida"));
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
