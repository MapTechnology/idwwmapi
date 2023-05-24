/**
 * DwDetativ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwDetativ  extends idw.idwws.DwDetativTemplate  implements java.io.Serializable {
    private long idDetativ;

    private idw.idwws.DwProcativ dwProcativ;

    private java.lang.Integer ordem;

    private java.lang.Short tpDetativ;

    private java.lang.String texto;

    private java.lang.Byte[] foto;

    public DwDetativ() {
    }

    public DwDetativ(
           long idDetativ,
           idw.idwws.DwProcativ dwProcativ,
           java.lang.Integer ordem,
           java.lang.Short tpDetativ,
           java.lang.String texto,
           java.lang.Byte[] foto) {
        this.idDetativ = idDetativ;
        this.dwProcativ = dwProcativ;
        this.ordem = ordem;
        this.tpDetativ = tpDetativ;
        this.texto = texto;
        this.foto = foto;
    }


    /**
     * Gets the idDetativ value for this DwDetativ.
     * 
     * @return idDetativ
     */
    public long getIdDetativ() {
        return idDetativ;
    }


    /**
     * Sets the idDetativ value for this DwDetativ.
     * 
     * @param idDetativ
     */
    public void setIdDetativ(long idDetativ) {
        this.idDetativ = idDetativ;
    }


    /**
     * Gets the dwProcativ value for this DwDetativ.
     * 
     * @return dwProcativ
     */
    public idw.idwws.DwProcativ getDwProcativ() {
        return dwProcativ;
    }


    /**
     * Sets the dwProcativ value for this DwDetativ.
     * 
     * @param dwProcativ
     */
    public void setDwProcativ(idw.idwws.DwProcativ dwProcativ) {
        this.dwProcativ = dwProcativ;
    }


    /**
     * Gets the ordem value for this DwDetativ.
     * 
     * @return ordem
     */
    public java.lang.Integer getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this DwDetativ.
     * 
     * @param ordem
     */
    public void setOrdem(java.lang.Integer ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the tpDetativ value for this DwDetativ.
     * 
     * @return tpDetativ
     */
    public java.lang.Short getTpDetativ() {
        return tpDetativ;
    }


    /**
     * Sets the tpDetativ value for this DwDetativ.
     * 
     * @param tpDetativ
     */
    public void setTpDetativ(java.lang.Short tpDetativ) {
        this.tpDetativ = tpDetativ;
    }


    /**
     * Gets the texto value for this DwDetativ.
     * 
     * @return texto
     */
    public java.lang.String getTexto() {
        return texto;
    }


    /**
     * Sets the texto value for this DwDetativ.
     * 
     * @param texto
     */
    public void setTexto(java.lang.String texto) {
        this.texto = texto;
    }


    /**
     * Gets the foto value for this DwDetativ.
     * 
     * @return foto
     */
    public java.lang.Byte[] getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this DwDetativ.
     * 
     * @param foto
     */
    public void setFoto(java.lang.Byte[] foto) {
        this.foto = foto;
    }

    public java.lang.Byte getFoto(int i) {
        return this.foto[i];
    }

    public void setFoto(int i, java.lang.Byte _value) {
        this.foto[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwDetativ)) return false;
        DwDetativ other = (DwDetativ) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.idDetativ == other.getIdDetativ() &&
            ((this.dwProcativ==null && other.getDwProcativ()==null) || 
             (this.dwProcativ!=null &&
              this.dwProcativ.equals(other.getDwProcativ()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem()))) &&
            ((this.tpDetativ==null && other.getTpDetativ()==null) || 
             (this.tpDetativ!=null &&
              this.tpDetativ.equals(other.getTpDetativ()))) &&
            ((this.texto==null && other.getTexto()==null) || 
             (this.texto!=null &&
              this.texto.equals(other.getTexto()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              java.util.Arrays.equals(this.foto, other.getFoto())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += new Long(getIdDetativ()).hashCode();
        if (getDwProcativ() != null) {
            _hashCode += getDwProcativ().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        if (getTpDetativ() != null) {
            _hashCode += getTpDetativ().hashCode();
        }
        if (getTexto() != null) {
            _hashCode += getTexto().hashCode();
        }
        if (getFoto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFoto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFoto(), i);
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
        new org.apache.axis.description.TypeDesc(DwDetativ.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwDetativ"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDetativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idDetativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProcativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcativ"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpDetativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpDetativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("texto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "texto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
