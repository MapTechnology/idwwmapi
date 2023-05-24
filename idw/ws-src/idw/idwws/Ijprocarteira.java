/**
 * Ijprocarteira.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijprocarteira  implements java.io.Serializable {
    private idw.idwws.IjprocarteiraId id;

    private idw.idwws.Ijcarteira ijcarteira;

    private idw.idwws.Ijtbpro ijtbpro;

    private double qtatendida;

    private double qtpedida;

    public Ijprocarteira() {
    }

    public Ijprocarteira(
           idw.idwws.IjprocarteiraId id,
           idw.idwws.Ijcarteira ijcarteira,
           idw.idwws.Ijtbpro ijtbpro,
           double qtatendida,
           double qtpedida) {
           this.id = id;
           this.ijcarteira = ijcarteira;
           this.ijtbpro = ijtbpro;
           this.qtatendida = qtatendida;
           this.qtpedida = qtpedida;
    }


    /**
     * Gets the id value for this Ijprocarteira.
     * 
     * @return id
     */
    public idw.idwws.IjprocarteiraId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijprocarteira.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjprocarteiraId id) {
        this.id = id;
    }


    /**
     * Gets the ijcarteira value for this Ijprocarteira.
     * 
     * @return ijcarteira
     */
    public idw.idwws.Ijcarteira getIjcarteira() {
        return ijcarteira;
    }


    /**
     * Sets the ijcarteira value for this Ijprocarteira.
     * 
     * @param ijcarteira
     */
    public void setIjcarteira(idw.idwws.Ijcarteira ijcarteira) {
        this.ijcarteira = ijcarteira;
    }


    /**
     * Gets the ijtbpro value for this Ijprocarteira.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijprocarteira.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the qtatendida value for this Ijprocarteira.
     * 
     * @return qtatendida
     */
    public double getQtatendida() {
        return qtatendida;
    }


    /**
     * Sets the qtatendida value for this Ijprocarteira.
     * 
     * @param qtatendida
     */
    public void setQtatendida(double qtatendida) {
        this.qtatendida = qtatendida;
    }


    /**
     * Gets the qtpedida value for this Ijprocarteira.
     * 
     * @return qtpedida
     */
    public double getQtpedida() {
        return qtpedida;
    }


    /**
     * Sets the qtpedida value for this Ijprocarteira.
     * 
     * @param qtpedida
     */
    public void setQtpedida(double qtpedida) {
        this.qtpedida = qtpedida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijprocarteira)) return false;
        Ijprocarteira other = (Ijprocarteira) obj;
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
            ((this.ijcarteira==null && other.getIjcarteira()==null) || 
             (this.ijcarteira!=null &&
              this.ijcarteira.equals(other.getIjcarteira()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.qtatendida == other.getQtatendida() &&
            this.qtpedida == other.getQtpedida();
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
        if (getIjcarteira() != null) {
            _hashCode += getIjcarteira().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getQtatendida()).hashCode();
        _hashCode += new Double(getQtpedida()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijprocarteira.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprocarteira"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprocarteiraId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcarteira");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcarteira"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcarteira"));
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
        elemField.setFieldName("qtatendida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtatendida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtpedida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtpedida"));
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
