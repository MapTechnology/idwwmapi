/**
 * Ijtblocalparada.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtblocalparada  implements java.io.Serializable {
    private java.lang.String cdlocalparada;

    private java.lang.String dslocalparada;

    private idw.idwws.Exportacao001[] exportacao001S;

    private idw.idwws.Exportacao003[] exportacao003S;

    private idw.idwws.Ijreaparintrasa[] ijreaparintrasas;

    private org.apache.axis.types.UnsignedShort stativo;

    public Ijtblocalparada() {
    }

    public Ijtblocalparada(
           java.lang.String cdlocalparada,
           java.lang.String dslocalparada,
           idw.idwws.Exportacao001[] exportacao001S,
           idw.idwws.Exportacao003[] exportacao003S,
           idw.idwws.Ijreaparintrasa[] ijreaparintrasas,
           org.apache.axis.types.UnsignedShort stativo) {
           this.cdlocalparada = cdlocalparada;
           this.dslocalparada = dslocalparada;
           this.exportacao001S = exportacao001S;
           this.exportacao003S = exportacao003S;
           this.ijreaparintrasas = ijreaparintrasas;
           this.stativo = stativo;
    }


    /**
     * Gets the cdlocalparada value for this Ijtblocalparada.
     * 
     * @return cdlocalparada
     */
    public java.lang.String getCdlocalparada() {
        return cdlocalparada;
    }


    /**
     * Sets the cdlocalparada value for this Ijtblocalparada.
     * 
     * @param cdlocalparada
     */
    public void setCdlocalparada(java.lang.String cdlocalparada) {
        this.cdlocalparada = cdlocalparada;
    }


    /**
     * Gets the dslocalparada value for this Ijtblocalparada.
     * 
     * @return dslocalparada
     */
    public java.lang.String getDslocalparada() {
        return dslocalparada;
    }


    /**
     * Sets the dslocalparada value for this Ijtblocalparada.
     * 
     * @param dslocalparada
     */
    public void setDslocalparada(java.lang.String dslocalparada) {
        this.dslocalparada = dslocalparada;
    }


    /**
     * Gets the exportacao001S value for this Ijtblocalparada.
     * 
     * @return exportacao001S
     */
    public idw.idwws.Exportacao001[] getExportacao001S() {
        return exportacao001S;
    }


    /**
     * Sets the exportacao001S value for this Ijtblocalparada.
     * 
     * @param exportacao001S
     */
    public void setExportacao001S(idw.idwws.Exportacao001[] exportacao001S) {
        this.exportacao001S = exportacao001S;
    }

    public idw.idwws.Exportacao001 getExportacao001S(int i) {
        return this.exportacao001S[i];
    }

    public void setExportacao001S(int i, idw.idwws.Exportacao001 _value) {
        this.exportacao001S[i] = _value;
    }


    /**
     * Gets the exportacao003S value for this Ijtblocalparada.
     * 
     * @return exportacao003S
     */
    public idw.idwws.Exportacao003[] getExportacao003S() {
        return exportacao003S;
    }


    /**
     * Sets the exportacao003S value for this Ijtblocalparada.
     * 
     * @param exportacao003S
     */
    public void setExportacao003S(idw.idwws.Exportacao003[] exportacao003S) {
        this.exportacao003S = exportacao003S;
    }

    public idw.idwws.Exportacao003 getExportacao003S(int i) {
        return this.exportacao003S[i];
    }

    public void setExportacao003S(int i, idw.idwws.Exportacao003 _value) {
        this.exportacao003S[i] = _value;
    }


    /**
     * Gets the ijreaparintrasas value for this Ijtblocalparada.
     * 
     * @return ijreaparintrasas
     */
    public idw.idwws.Ijreaparintrasa[] getIjreaparintrasas() {
        return ijreaparintrasas;
    }


    /**
     * Sets the ijreaparintrasas value for this Ijtblocalparada.
     * 
     * @param ijreaparintrasas
     */
    public void setIjreaparintrasas(idw.idwws.Ijreaparintrasa[] ijreaparintrasas) {
        this.ijreaparintrasas = ijreaparintrasas;
    }

    public idw.idwws.Ijreaparintrasa getIjreaparintrasas(int i) {
        return this.ijreaparintrasas[i];
    }

    public void setIjreaparintrasas(int i, idw.idwws.Ijreaparintrasa _value) {
        this.ijreaparintrasas[i] = _value;
    }


    /**
     * Gets the stativo value for this Ijtblocalparada.
     * 
     * @return stativo
     */
    public org.apache.axis.types.UnsignedShort getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtblocalparada.
     * 
     * @param stativo
     */
    public void setStativo(org.apache.axis.types.UnsignedShort stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtblocalparada)) return false;
        Ijtblocalparada other = (Ijtblocalparada) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdlocalparada==null && other.getCdlocalparada()==null) || 
             (this.cdlocalparada!=null &&
              this.cdlocalparada.equals(other.getCdlocalparada()))) &&
            ((this.dslocalparada==null && other.getDslocalparada()==null) || 
             (this.dslocalparada!=null &&
              this.dslocalparada.equals(other.getDslocalparada()))) &&
            ((this.exportacao001S==null && other.getExportacao001S()==null) || 
             (this.exportacao001S!=null &&
              java.util.Arrays.equals(this.exportacao001S, other.getExportacao001S()))) &&
            ((this.exportacao003S==null && other.getExportacao003S()==null) || 
             (this.exportacao003S!=null &&
              java.util.Arrays.equals(this.exportacao003S, other.getExportacao003S()))) &&
            ((this.ijreaparintrasas==null && other.getIjreaparintrasas()==null) || 
             (this.ijreaparintrasas!=null &&
              java.util.Arrays.equals(this.ijreaparintrasas, other.getIjreaparintrasas()))) &&
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
        if (getCdlocalparada() != null) {
            _hashCode += getCdlocalparada().hashCode();
        }
        if (getDslocalparada() != null) {
            _hashCode += getDslocalparada().hashCode();
        }
        if (getExportacao001S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao001S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao001S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExportacao003S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao003S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao003S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreaparintrasas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreaparintrasas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreaparintrasas(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtblocalparada.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtblocalparada"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlocalparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlocalparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dslocalparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dslocalparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao001S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao001s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao001"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao003S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao003s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao003"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreaparintrasas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreaparintrasas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintrasa"));
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
