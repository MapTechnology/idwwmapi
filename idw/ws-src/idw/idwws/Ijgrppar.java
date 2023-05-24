/**
 * Ijgrppar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrppar  implements java.io.Serializable {
    private java.lang.String cdgrupopar;

    private java.lang.String dsgrupopar;

    private idw.idwws.Ijgrpdetpar[] ijgrpdetpars;

    private idw.idwws.Ijgrpinjpar[] ijgrpinjpars;

    private idw.idwws.Ijgrpparaux[] ijgrpparauxes;

    public Ijgrppar() {
    }

    public Ijgrppar(
           java.lang.String cdgrupopar,
           java.lang.String dsgrupopar,
           idw.idwws.Ijgrpdetpar[] ijgrpdetpars,
           idw.idwws.Ijgrpinjpar[] ijgrpinjpars,
           idw.idwws.Ijgrpparaux[] ijgrpparauxes) {
           this.cdgrupopar = cdgrupopar;
           this.dsgrupopar = dsgrupopar;
           this.ijgrpdetpars = ijgrpdetpars;
           this.ijgrpinjpars = ijgrpinjpars;
           this.ijgrpparauxes = ijgrpparauxes;
    }


    /**
     * Gets the cdgrupopar value for this Ijgrppar.
     * 
     * @return cdgrupopar
     */
    public java.lang.String getCdgrupopar() {
        return cdgrupopar;
    }


    /**
     * Sets the cdgrupopar value for this Ijgrppar.
     * 
     * @param cdgrupopar
     */
    public void setCdgrupopar(java.lang.String cdgrupopar) {
        this.cdgrupopar = cdgrupopar;
    }


    /**
     * Gets the dsgrupopar value for this Ijgrppar.
     * 
     * @return dsgrupopar
     */
    public java.lang.String getDsgrupopar() {
        return dsgrupopar;
    }


    /**
     * Sets the dsgrupopar value for this Ijgrppar.
     * 
     * @param dsgrupopar
     */
    public void setDsgrupopar(java.lang.String dsgrupopar) {
        this.dsgrupopar = dsgrupopar;
    }


    /**
     * Gets the ijgrpdetpars value for this Ijgrppar.
     * 
     * @return ijgrpdetpars
     */
    public idw.idwws.Ijgrpdetpar[] getIjgrpdetpars() {
        return ijgrpdetpars;
    }


    /**
     * Sets the ijgrpdetpars value for this Ijgrppar.
     * 
     * @param ijgrpdetpars
     */
    public void setIjgrpdetpars(idw.idwws.Ijgrpdetpar[] ijgrpdetpars) {
        this.ijgrpdetpars = ijgrpdetpars;
    }

    public idw.idwws.Ijgrpdetpar getIjgrpdetpars(int i) {
        return this.ijgrpdetpars[i];
    }

    public void setIjgrpdetpars(int i, idw.idwws.Ijgrpdetpar _value) {
        this.ijgrpdetpars[i] = _value;
    }


    /**
     * Gets the ijgrpinjpars value for this Ijgrppar.
     * 
     * @return ijgrpinjpars
     */
    public idw.idwws.Ijgrpinjpar[] getIjgrpinjpars() {
        return ijgrpinjpars;
    }


    /**
     * Sets the ijgrpinjpars value for this Ijgrppar.
     * 
     * @param ijgrpinjpars
     */
    public void setIjgrpinjpars(idw.idwws.Ijgrpinjpar[] ijgrpinjpars) {
        this.ijgrpinjpars = ijgrpinjpars;
    }

    public idw.idwws.Ijgrpinjpar getIjgrpinjpars(int i) {
        return this.ijgrpinjpars[i];
    }

    public void setIjgrpinjpars(int i, idw.idwws.Ijgrpinjpar _value) {
        this.ijgrpinjpars[i] = _value;
    }


    /**
     * Gets the ijgrpparauxes value for this Ijgrppar.
     * 
     * @return ijgrpparauxes
     */
    public idw.idwws.Ijgrpparaux[] getIjgrpparauxes() {
        return ijgrpparauxes;
    }


    /**
     * Sets the ijgrpparauxes value for this Ijgrppar.
     * 
     * @param ijgrpparauxes
     */
    public void setIjgrpparauxes(idw.idwws.Ijgrpparaux[] ijgrpparauxes) {
        this.ijgrpparauxes = ijgrpparauxes;
    }

    public idw.idwws.Ijgrpparaux getIjgrpparauxes(int i) {
        return this.ijgrpparauxes[i];
    }

    public void setIjgrpparauxes(int i, idw.idwws.Ijgrpparaux _value) {
        this.ijgrpparauxes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrppar)) return false;
        Ijgrppar other = (Ijgrppar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrupopar==null && other.getCdgrupopar()==null) || 
             (this.cdgrupopar!=null &&
              this.cdgrupopar.equals(other.getCdgrupopar()))) &&
            ((this.dsgrupopar==null && other.getDsgrupopar()==null) || 
             (this.dsgrupopar!=null &&
              this.dsgrupopar.equals(other.getDsgrupopar()))) &&
            ((this.ijgrpdetpars==null && other.getIjgrpdetpars()==null) || 
             (this.ijgrpdetpars!=null &&
              java.util.Arrays.equals(this.ijgrpdetpars, other.getIjgrpdetpars()))) &&
            ((this.ijgrpinjpars==null && other.getIjgrpinjpars()==null) || 
             (this.ijgrpinjpars!=null &&
              java.util.Arrays.equals(this.ijgrpinjpars, other.getIjgrpinjpars()))) &&
            ((this.ijgrpparauxes==null && other.getIjgrpparauxes()==null) || 
             (this.ijgrpparauxes!=null &&
              java.util.Arrays.equals(this.ijgrpparauxes, other.getIjgrpparauxes())));
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
        if (getCdgrupopar() != null) {
            _hashCode += getCdgrupopar().hashCode();
        }
        if (getDsgrupopar() != null) {
            _hashCode += getDsgrupopar().hashCode();
        }
        if (getIjgrpdetpars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetpars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetpars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpinjpars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpinjpars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpinjpars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpparauxes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpparauxes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpparauxes(), i);
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
        new org.apache.axis.description.TypeDesc(Ijgrppar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrppar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrupopar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrupopar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrupopar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrupopar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetpars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetpars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpinjpars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpinjpars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpinjpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpparauxes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpparauxes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaux"));
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
