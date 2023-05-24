/**
 * Ijproplano.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijproplano  implements java.io.Serializable {
    private idw.idwws.IjproplanoId id;

    private idw.idwws.Ijplano ijplano;

    private idw.idwws.Ijtbpro ijtbpro;

    private double qtplanejada;

    private double qtproduzida;

    public Ijproplano() {
    }

    public Ijproplano(
           idw.idwws.IjproplanoId id,
           idw.idwws.Ijplano ijplano,
           idw.idwws.Ijtbpro ijtbpro,
           double qtplanejada,
           double qtproduzida) {
           this.id = id;
           this.ijplano = ijplano;
           this.ijtbpro = ijtbpro;
           this.qtplanejada = qtplanejada;
           this.qtproduzida = qtproduzida;
    }


    /**
     * Gets the id value for this Ijproplano.
     * 
     * @return id
     */
    public idw.idwws.IjproplanoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijproplano.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjproplanoId id) {
        this.id = id;
    }


    /**
     * Gets the ijplano value for this Ijproplano.
     * 
     * @return ijplano
     */
    public idw.idwws.Ijplano getIjplano() {
        return ijplano;
    }


    /**
     * Sets the ijplano value for this Ijproplano.
     * 
     * @param ijplano
     */
    public void setIjplano(idw.idwws.Ijplano ijplano) {
        this.ijplano = ijplano;
    }


    /**
     * Gets the ijtbpro value for this Ijproplano.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijproplano.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the qtplanejada value for this Ijproplano.
     * 
     * @return qtplanejada
     */
    public double getQtplanejada() {
        return qtplanejada;
    }


    /**
     * Sets the qtplanejada value for this Ijproplano.
     * 
     * @param qtplanejada
     */
    public void setQtplanejada(double qtplanejada) {
        this.qtplanejada = qtplanejada;
    }


    /**
     * Gets the qtproduzida value for this Ijproplano.
     * 
     * @return qtproduzida
     */
    public double getQtproduzida() {
        return qtproduzida;
    }


    /**
     * Sets the qtproduzida value for this Ijproplano.
     * 
     * @param qtproduzida
     */
    public void setQtproduzida(double qtproduzida) {
        this.qtproduzida = qtproduzida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijproplano)) return false;
        Ijproplano other = (Ijproplano) obj;
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
            ((this.ijplano==null && other.getIjplano()==null) || 
             (this.ijplano!=null &&
              this.ijplano.equals(other.getIjplano()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.qtplanejada == other.getQtplanejada() &&
            this.qtproduzida == other.getQtproduzida();
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
        if (getIjplano() != null) {
            _hashCode += getIjplano().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getQtplanejada()).hashCode();
        _hashCode += new Double(getQtproduzida()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijproplano.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproplano"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproplanoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijplano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijplano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijplano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtplanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtplanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtproduzida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtproduzida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
