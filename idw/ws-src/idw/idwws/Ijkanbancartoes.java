/**
 * Ijkanbancartoes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijkanbancartoes  implements java.io.Serializable {
    private java.util.Calendar dthrleitura;

    private java.util.Calendar dthrlibproducao;

    private idw.idwws.IjkanbancartoesId id;

    private idw.idwws.Ijkanbanidcartao ijkanbanidcartao;

    private idw.idwws.Ijkanbanlote ijkanbanlote;

    private org.apache.axis.types.UnsignedShort stlibproducao;

    public Ijkanbancartoes() {
    }

    public Ijkanbancartoes(
           java.util.Calendar dthrleitura,
           java.util.Calendar dthrlibproducao,
           idw.idwws.IjkanbancartoesId id,
           idw.idwws.Ijkanbanidcartao ijkanbanidcartao,
           idw.idwws.Ijkanbanlote ijkanbanlote,
           org.apache.axis.types.UnsignedShort stlibproducao) {
           this.dthrleitura = dthrleitura;
           this.dthrlibproducao = dthrlibproducao;
           this.id = id;
           this.ijkanbanidcartao = ijkanbanidcartao;
           this.ijkanbanlote = ijkanbanlote;
           this.stlibproducao = stlibproducao;
    }


    /**
     * Gets the dthrleitura value for this Ijkanbancartoes.
     * 
     * @return dthrleitura
     */
    public java.util.Calendar getDthrleitura() {
        return dthrleitura;
    }


    /**
     * Sets the dthrleitura value for this Ijkanbancartoes.
     * 
     * @param dthrleitura
     */
    public void setDthrleitura(java.util.Calendar dthrleitura) {
        this.dthrleitura = dthrleitura;
    }


    /**
     * Gets the dthrlibproducao value for this Ijkanbancartoes.
     * 
     * @return dthrlibproducao
     */
    public java.util.Calendar getDthrlibproducao() {
        return dthrlibproducao;
    }


    /**
     * Sets the dthrlibproducao value for this Ijkanbancartoes.
     * 
     * @param dthrlibproducao
     */
    public void setDthrlibproducao(java.util.Calendar dthrlibproducao) {
        this.dthrlibproducao = dthrlibproducao;
    }


    /**
     * Gets the id value for this Ijkanbancartoes.
     * 
     * @return id
     */
    public idw.idwws.IjkanbancartoesId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijkanbancartoes.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjkanbancartoesId id) {
        this.id = id;
    }


    /**
     * Gets the ijkanbanidcartao value for this Ijkanbancartoes.
     * 
     * @return ijkanbanidcartao
     */
    public idw.idwws.Ijkanbanidcartao getIjkanbanidcartao() {
        return ijkanbanidcartao;
    }


    /**
     * Sets the ijkanbanidcartao value for this Ijkanbancartoes.
     * 
     * @param ijkanbanidcartao
     */
    public void setIjkanbanidcartao(idw.idwws.Ijkanbanidcartao ijkanbanidcartao) {
        this.ijkanbanidcartao = ijkanbanidcartao;
    }


    /**
     * Gets the ijkanbanlote value for this Ijkanbancartoes.
     * 
     * @return ijkanbanlote
     */
    public idw.idwws.Ijkanbanlote getIjkanbanlote() {
        return ijkanbanlote;
    }


    /**
     * Sets the ijkanbanlote value for this Ijkanbancartoes.
     * 
     * @param ijkanbanlote
     */
    public void setIjkanbanlote(idw.idwws.Ijkanbanlote ijkanbanlote) {
        this.ijkanbanlote = ijkanbanlote;
    }


    /**
     * Gets the stlibproducao value for this Ijkanbancartoes.
     * 
     * @return stlibproducao
     */
    public org.apache.axis.types.UnsignedShort getStlibproducao() {
        return stlibproducao;
    }


    /**
     * Sets the stlibproducao value for this Ijkanbancartoes.
     * 
     * @param stlibproducao
     */
    public void setStlibproducao(org.apache.axis.types.UnsignedShort stlibproducao) {
        this.stlibproducao = stlibproducao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijkanbancartoes)) return false;
        Ijkanbancartoes other = (Ijkanbancartoes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrleitura==null && other.getDthrleitura()==null) || 
             (this.dthrleitura!=null &&
              this.dthrleitura.equals(other.getDthrleitura()))) &&
            ((this.dthrlibproducao==null && other.getDthrlibproducao()==null) || 
             (this.dthrlibproducao!=null &&
              this.dthrlibproducao.equals(other.getDthrlibproducao()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijkanbanidcartao==null && other.getIjkanbanidcartao()==null) || 
             (this.ijkanbanidcartao!=null &&
              this.ijkanbanidcartao.equals(other.getIjkanbanidcartao()))) &&
            ((this.ijkanbanlote==null && other.getIjkanbanlote()==null) || 
             (this.ijkanbanlote!=null &&
              this.ijkanbanlote.equals(other.getIjkanbanlote()))) &&
            ((this.stlibproducao==null && other.getStlibproducao()==null) || 
             (this.stlibproducao!=null &&
              this.stlibproducao.equals(other.getStlibproducao())));
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
        if (getDthrleitura() != null) {
            _hashCode += getDthrleitura().hashCode();
        }
        if (getDthrlibproducao() != null) {
            _hashCode += getDthrlibproducao().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjkanbanidcartao() != null) {
            _hashCode += getIjkanbanidcartao().hashCode();
        }
        if (getIjkanbanlote() != null) {
            _hashCode += getIjkanbanlote().hashCode();
        }
        if (getStlibproducao() != null) {
            _hashCode += getStlibproducao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijkanbancartoes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbancartoes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrleitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrleitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrlibproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrlibproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbancartoesId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanidcartao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanidcartao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanidcartao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stlibproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stlibproducao"));
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
