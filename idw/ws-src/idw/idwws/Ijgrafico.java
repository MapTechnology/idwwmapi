/**
 * Ijgrafico.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrafico  implements java.io.Serializable {
    private idw.idwws.IjgraficoId id;

    private idw.idwws.Ijdetgrafico[] ijdetgraficos;

    private idw.idwws.Ijlinguas ijlinguas;

    private java.lang.String titulo;

    public Ijgrafico() {
    }

    public Ijgrafico(
           idw.idwws.IjgraficoId id,
           idw.idwws.Ijdetgrafico[] ijdetgraficos,
           idw.idwws.Ijlinguas ijlinguas,
           java.lang.String titulo) {
           this.id = id;
           this.ijdetgraficos = ijdetgraficos;
           this.ijlinguas = ijlinguas;
           this.titulo = titulo;
    }


    /**
     * Gets the id value for this Ijgrafico.
     * 
     * @return id
     */
    public idw.idwws.IjgraficoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrafico.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgraficoId id) {
        this.id = id;
    }


    /**
     * Gets the ijdetgraficos value for this Ijgrafico.
     * 
     * @return ijdetgraficos
     */
    public idw.idwws.Ijdetgrafico[] getIjdetgraficos() {
        return ijdetgraficos;
    }


    /**
     * Sets the ijdetgraficos value for this Ijgrafico.
     * 
     * @param ijdetgraficos
     */
    public void setIjdetgraficos(idw.idwws.Ijdetgrafico[] ijdetgraficos) {
        this.ijdetgraficos = ijdetgraficos;
    }

    public idw.idwws.Ijdetgrafico getIjdetgraficos(int i) {
        return this.ijdetgraficos[i];
    }

    public void setIjdetgraficos(int i, idw.idwws.Ijdetgrafico _value) {
        this.ijdetgraficos[i] = _value;
    }


    /**
     * Gets the ijlinguas value for this Ijgrafico.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijgrafico.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the titulo value for this Ijgrafico.
     * 
     * @return titulo
     */
    public java.lang.String getTitulo() {
        return titulo;
    }


    /**
     * Sets the titulo value for this Ijgrafico.
     * 
     * @param titulo
     */
    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrafico)) return false;
        Ijgrafico other = (Ijgrafico) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijdetgraficos==null && other.getIjdetgraficos()==null) || 
             (this.ijdetgraficos!=null &&
              java.util.Arrays.equals(this.ijdetgraficos, other.getIjdetgraficos()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.titulo==null && other.getTitulo()==null) || 
             (this.titulo!=null &&
              this.titulo.equals(other.getTitulo())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjdetgraficos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdetgraficos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdetgraficos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getTitulo() != null) {
            _hashCode += getTitulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrafico.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrafico"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgraficoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdetgraficos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdetgraficos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdetgrafico"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "titulo"));
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
