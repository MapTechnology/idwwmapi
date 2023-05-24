/**
 * Ijtbmodisp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmodisp  implements java.io.Serializable {
    private java.util.Calendar dthroperacao;

    private idw.idwws.IjtbmodispId id;

    private idw.idwws.Ijtbtur ijtbtur;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String motivoalteracao;

    private java.math.BigDecimal qtdmo;

    public Ijtbmodisp() {
    }

    public Ijtbmodisp(
           java.util.Calendar dthroperacao,
           idw.idwws.IjtbmodispId id,
           idw.idwws.Ijtbtur ijtbtur,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String motivoalteracao,
           java.math.BigDecimal qtdmo) {
           this.dthroperacao = dthroperacao;
           this.id = id;
           this.ijtbtur = ijtbtur;
           this.ijtbusu = ijtbusu;
           this.motivoalteracao = motivoalteracao;
           this.qtdmo = qtdmo;
    }


    /**
     * Gets the dthroperacao value for this Ijtbmodisp.
     * 
     * @return dthroperacao
     */
    public java.util.Calendar getDthroperacao() {
        return dthroperacao;
    }


    /**
     * Sets the dthroperacao value for this Ijtbmodisp.
     * 
     * @param dthroperacao
     */
    public void setDthroperacao(java.util.Calendar dthroperacao) {
        this.dthroperacao = dthroperacao;
    }


    /**
     * Gets the id value for this Ijtbmodisp.
     * 
     * @return id
     */
    public idw.idwws.IjtbmodispId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbmodisp.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbmodispId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbtur value for this Ijtbmodisp.
     * 
     * @return ijtbtur
     */
    public idw.idwws.Ijtbtur getIjtbtur() {
        return ijtbtur;
    }


    /**
     * Sets the ijtbtur value for this Ijtbmodisp.
     * 
     * @param ijtbtur
     */
    public void setIjtbtur(idw.idwws.Ijtbtur ijtbtur) {
        this.ijtbtur = ijtbtur;
    }


    /**
     * Gets the ijtbusu value for this Ijtbmodisp.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijtbmodisp.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the motivoalteracao value for this Ijtbmodisp.
     * 
     * @return motivoalteracao
     */
    public java.lang.String getMotivoalteracao() {
        return motivoalteracao;
    }


    /**
     * Sets the motivoalteracao value for this Ijtbmodisp.
     * 
     * @param motivoalteracao
     */
    public void setMotivoalteracao(java.lang.String motivoalteracao) {
        this.motivoalteracao = motivoalteracao;
    }


    /**
     * Gets the qtdmo value for this Ijtbmodisp.
     * 
     * @return qtdmo
     */
    public java.math.BigDecimal getQtdmo() {
        return qtdmo;
    }


    /**
     * Sets the qtdmo value for this Ijtbmodisp.
     * 
     * @param qtdmo
     */
    public void setQtdmo(java.math.BigDecimal qtdmo) {
        this.qtdmo = qtdmo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmodisp)) return false;
        Ijtbmodisp other = (Ijtbmodisp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthroperacao==null && other.getDthroperacao()==null) || 
             (this.dthroperacao!=null &&
              this.dthroperacao.equals(other.getDthroperacao()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbtur==null && other.getIjtbtur()==null) || 
             (this.ijtbtur!=null &&
              this.ijtbtur.equals(other.getIjtbtur()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.motivoalteracao==null && other.getMotivoalteracao()==null) || 
             (this.motivoalteracao!=null &&
              this.motivoalteracao.equals(other.getMotivoalteracao()))) &&
            ((this.qtdmo==null && other.getQtdmo()==null) || 
             (this.qtdmo!=null &&
              this.qtdmo.equals(other.getQtdmo())));
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
        if (getDthroperacao() != null) {
            _hashCode += getDthroperacao().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbtur() != null) {
            _hashCode += getIjtbtur().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getMotivoalteracao() != null) {
            _hashCode += getMotivoalteracao().hashCode();
        }
        if (getQtdmo() != null) {
            _hashCode += getQtdmo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbmodisp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodisp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthroperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthroperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodispId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtur"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivoalteracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "motivoalteracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
