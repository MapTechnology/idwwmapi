/**
 * Ijareres.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijareres  implements java.io.Serializable {
    private java.lang.String cdarea;

    private java.lang.String dsarea;

    private idw.idwws.Ijmanut[] ijmanuts;

    private idw.idwws.Ijpdcaacao[] ijpdcaacaos;

    private idw.idwws.Ijpdcapadrao[] ijpdcapadraos;

    private idw.idwws.Ijtbpar[] ijtbpars;

    private idw.idwws.Ijtbref[] ijtbrefs;

    private org.apache.axis.types.UnsignedShort tipoarearesp;

    public Ijareres() {
    }

    public Ijareres(
           java.lang.String cdarea,
           java.lang.String dsarea,
           idw.idwws.Ijmanut[] ijmanuts,
           idw.idwws.Ijpdcaacao[] ijpdcaacaos,
           idw.idwws.Ijpdcapadrao[] ijpdcapadraos,
           idw.idwws.Ijtbpar[] ijtbpars,
           idw.idwws.Ijtbref[] ijtbrefs,
           org.apache.axis.types.UnsignedShort tipoarearesp) {
           this.cdarea = cdarea;
           this.dsarea = dsarea;
           this.ijmanuts = ijmanuts;
           this.ijpdcaacaos = ijpdcaacaos;
           this.ijpdcapadraos = ijpdcapadraos;
           this.ijtbpars = ijtbpars;
           this.ijtbrefs = ijtbrefs;
           this.tipoarearesp = tipoarearesp;
    }


    /**
     * Gets the cdarea value for this Ijareres.
     * 
     * @return cdarea
     */
    public java.lang.String getCdarea() {
        return cdarea;
    }


    /**
     * Sets the cdarea value for this Ijareres.
     * 
     * @param cdarea
     */
    public void setCdarea(java.lang.String cdarea) {
        this.cdarea = cdarea;
    }


    /**
     * Gets the dsarea value for this Ijareres.
     * 
     * @return dsarea
     */
    public java.lang.String getDsarea() {
        return dsarea;
    }


    /**
     * Sets the dsarea value for this Ijareres.
     * 
     * @param dsarea
     */
    public void setDsarea(java.lang.String dsarea) {
        this.dsarea = dsarea;
    }


    /**
     * Gets the ijmanuts value for this Ijareres.
     * 
     * @return ijmanuts
     */
    public idw.idwws.Ijmanut[] getIjmanuts() {
        return ijmanuts;
    }


    /**
     * Sets the ijmanuts value for this Ijareres.
     * 
     * @param ijmanuts
     */
    public void setIjmanuts(idw.idwws.Ijmanut[] ijmanuts) {
        this.ijmanuts = ijmanuts;
    }

    public idw.idwws.Ijmanut getIjmanuts(int i) {
        return this.ijmanuts[i];
    }

    public void setIjmanuts(int i, idw.idwws.Ijmanut _value) {
        this.ijmanuts[i] = _value;
    }


    /**
     * Gets the ijpdcaacaos value for this Ijareres.
     * 
     * @return ijpdcaacaos
     */
    public idw.idwws.Ijpdcaacao[] getIjpdcaacaos() {
        return ijpdcaacaos;
    }


    /**
     * Sets the ijpdcaacaos value for this Ijareres.
     * 
     * @param ijpdcaacaos
     */
    public void setIjpdcaacaos(idw.idwws.Ijpdcaacao[] ijpdcaacaos) {
        this.ijpdcaacaos = ijpdcaacaos;
    }

    public idw.idwws.Ijpdcaacao getIjpdcaacaos(int i) {
        return this.ijpdcaacaos[i];
    }

    public void setIjpdcaacaos(int i, idw.idwws.Ijpdcaacao _value) {
        this.ijpdcaacaos[i] = _value;
    }


    /**
     * Gets the ijpdcapadraos value for this Ijareres.
     * 
     * @return ijpdcapadraos
     */
    public idw.idwws.Ijpdcapadrao[] getIjpdcapadraos() {
        return ijpdcapadraos;
    }


    /**
     * Sets the ijpdcapadraos value for this Ijareres.
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
     * Gets the ijtbpars value for this Ijareres.
     * 
     * @return ijtbpars
     */
    public idw.idwws.Ijtbpar[] getIjtbpars() {
        return ijtbpars;
    }


    /**
     * Sets the ijtbpars value for this Ijareres.
     * 
     * @param ijtbpars
     */
    public void setIjtbpars(idw.idwws.Ijtbpar[] ijtbpars) {
        this.ijtbpars = ijtbpars;
    }

    public idw.idwws.Ijtbpar getIjtbpars(int i) {
        return this.ijtbpars[i];
    }

    public void setIjtbpars(int i, idw.idwws.Ijtbpar _value) {
        this.ijtbpars[i] = _value;
    }


    /**
     * Gets the ijtbrefs value for this Ijareres.
     * 
     * @return ijtbrefs
     */
    public idw.idwws.Ijtbref[] getIjtbrefs() {
        return ijtbrefs;
    }


    /**
     * Sets the ijtbrefs value for this Ijareres.
     * 
     * @param ijtbrefs
     */
    public void setIjtbrefs(idw.idwws.Ijtbref[] ijtbrefs) {
        this.ijtbrefs = ijtbrefs;
    }

    public idw.idwws.Ijtbref getIjtbrefs(int i) {
        return this.ijtbrefs[i];
    }

    public void setIjtbrefs(int i, idw.idwws.Ijtbref _value) {
        this.ijtbrefs[i] = _value;
    }


    /**
     * Gets the tipoarearesp value for this Ijareres.
     * 
     * @return tipoarearesp
     */
    public org.apache.axis.types.UnsignedShort getTipoarearesp() {
        return tipoarearesp;
    }


    /**
     * Sets the tipoarearesp value for this Ijareres.
     * 
     * @param tipoarearesp
     */
    public void setTipoarearesp(org.apache.axis.types.UnsignedShort tipoarearesp) {
        this.tipoarearesp = tipoarearesp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijareres)) return false;
        Ijareres other = (Ijareres) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdarea==null && other.getCdarea()==null) || 
             (this.cdarea!=null &&
              this.cdarea.equals(other.getCdarea()))) &&
            ((this.dsarea==null && other.getDsarea()==null) || 
             (this.dsarea!=null &&
              this.dsarea.equals(other.getDsarea()))) &&
            ((this.ijmanuts==null && other.getIjmanuts()==null) || 
             (this.ijmanuts!=null &&
              java.util.Arrays.equals(this.ijmanuts, other.getIjmanuts()))) &&
            ((this.ijpdcaacaos==null && other.getIjpdcaacaos()==null) || 
             (this.ijpdcaacaos!=null &&
              java.util.Arrays.equals(this.ijpdcaacaos, other.getIjpdcaacaos()))) &&
            ((this.ijpdcapadraos==null && other.getIjpdcapadraos()==null) || 
             (this.ijpdcapadraos!=null &&
              java.util.Arrays.equals(this.ijpdcapadraos, other.getIjpdcapadraos()))) &&
            ((this.ijtbpars==null && other.getIjtbpars()==null) || 
             (this.ijtbpars!=null &&
              java.util.Arrays.equals(this.ijtbpars, other.getIjtbpars()))) &&
            ((this.ijtbrefs==null && other.getIjtbrefs()==null) || 
             (this.ijtbrefs!=null &&
              java.util.Arrays.equals(this.ijtbrefs, other.getIjtbrefs()))) &&
            ((this.tipoarearesp==null && other.getTipoarearesp()==null) || 
             (this.tipoarearesp!=null &&
              this.tipoarearesp.equals(other.getTipoarearesp())));
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
        if (getCdarea() != null) {
            _hashCode += getCdarea().hashCode();
        }
        if (getDsarea() != null) {
            _hashCode += getDsarea().hashCode();
        }
        if (getIjmanuts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanuts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanuts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcaacaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcaacaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcaacaos(), i);
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
        if (getIjtbpars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbpars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbpars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbrefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbrefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbrefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTipoarearesp() != null) {
            _hashCode += getTipoarearesp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijareres.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijareres"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdarea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdarea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsarea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsarea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanuts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanuts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaacaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaacaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaacao"));
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
        elemField.setFieldName("ijtbpars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbrefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbrefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoarearesp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoarearesp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
