/**
 * Ijreaparintrasa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreaparintrasa  implements java.io.Serializable {
    private idw.idwws.IjreaparintrasaId id;

    private idw.idwws.Ijreapar ijreapar;

    private idw.idwws.Ijtblocalparada ijtblocalparada;

    private org.apache.axis.types.UnsignedShort semconexao;

    public Ijreaparintrasa() {
    }

    public Ijreaparintrasa(
           idw.idwws.IjreaparintrasaId id,
           idw.idwws.Ijreapar ijreapar,
           idw.idwws.Ijtblocalparada ijtblocalparada,
           org.apache.axis.types.UnsignedShort semconexao) {
           this.id = id;
           this.ijreapar = ijreapar;
           this.ijtblocalparada = ijtblocalparada;
           this.semconexao = semconexao;
    }


    /**
     * Gets the id value for this Ijreaparintrasa.
     * 
     * @return id
     */
    public idw.idwws.IjreaparintrasaId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreaparintrasa.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreaparintrasaId id) {
        this.id = id;
    }


    /**
     * Gets the ijreapar value for this Ijreaparintrasa.
     * 
     * @return ijreapar
     */
    public idw.idwws.Ijreapar getIjreapar() {
        return ijreapar;
    }


    /**
     * Sets the ijreapar value for this Ijreaparintrasa.
     * 
     * @param ijreapar
     */
    public void setIjreapar(idw.idwws.Ijreapar ijreapar) {
        this.ijreapar = ijreapar;
    }


    /**
     * Gets the ijtblocalparada value for this Ijreaparintrasa.
     * 
     * @return ijtblocalparada
     */
    public idw.idwws.Ijtblocalparada getIjtblocalparada() {
        return ijtblocalparada;
    }


    /**
     * Sets the ijtblocalparada value for this Ijreaparintrasa.
     * 
     * @param ijtblocalparada
     */
    public void setIjtblocalparada(idw.idwws.Ijtblocalparada ijtblocalparada) {
        this.ijtblocalparada = ijtblocalparada;
    }


    /**
     * Gets the semconexao value for this Ijreaparintrasa.
     * 
     * @return semconexao
     */
    public org.apache.axis.types.UnsignedShort getSemconexao() {
        return semconexao;
    }


    /**
     * Sets the semconexao value for this Ijreaparintrasa.
     * 
     * @param semconexao
     */
    public void setSemconexao(org.apache.axis.types.UnsignedShort semconexao) {
        this.semconexao = semconexao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreaparintrasa)) return false;
        Ijreaparintrasa other = (Ijreaparintrasa) obj;
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
            ((this.ijreapar==null && other.getIjreapar()==null) || 
             (this.ijreapar!=null &&
              this.ijreapar.equals(other.getIjreapar()))) &&
            ((this.ijtblocalparada==null && other.getIjtblocalparada()==null) || 
             (this.ijtblocalparada!=null &&
              this.ijtblocalparada.equals(other.getIjtblocalparada()))) &&
            ((this.semconexao==null && other.getSemconexao()==null) || 
             (this.semconexao!=null &&
              this.semconexao.equals(other.getSemconexao())));
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
        if (getIjreapar() != null) {
            _hashCode += getIjreapar().hashCode();
        }
        if (getIjtblocalparada() != null) {
            _hashCode += getIjtblocalparada().hashCode();
        }
        if (getSemconexao() != null) {
            _hashCode += getSemconexao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreaparintrasa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintrasa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintrasaId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtblocalparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtblocalparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtblocalparada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("semconexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "semconexao"));
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
