/**
 * Ijaledbqldanot.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijaledbqldanot  implements java.io.Serializable {
    private java.lang.String anotacao;

    private java.util.Calendar dthranotacao;

    private double idregistro;

    private idw.idwws.Ijaledbqld ijaledbqld;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijaledbqldanot() {
    }

    public Ijaledbqldanot(
           java.lang.String anotacao,
           java.util.Calendar dthranotacao,
           double idregistro,
           idw.idwws.Ijaledbqld ijaledbqld,
           idw.idwws.Ijtbusu ijtbusu) {
           this.anotacao = anotacao;
           this.dthranotacao = dthranotacao;
           this.idregistro = idregistro;
           this.ijaledbqld = ijaledbqld;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the anotacao value for this Ijaledbqldanot.
     * 
     * @return anotacao
     */
    public java.lang.String getAnotacao() {
        return anotacao;
    }


    /**
     * Sets the anotacao value for this Ijaledbqldanot.
     * 
     * @param anotacao
     */
    public void setAnotacao(java.lang.String anotacao) {
        this.anotacao = anotacao;
    }


    /**
     * Gets the dthranotacao value for this Ijaledbqldanot.
     * 
     * @return dthranotacao
     */
    public java.util.Calendar getDthranotacao() {
        return dthranotacao;
    }


    /**
     * Sets the dthranotacao value for this Ijaledbqldanot.
     * 
     * @param dthranotacao
     */
    public void setDthranotacao(java.util.Calendar dthranotacao) {
        this.dthranotacao = dthranotacao;
    }


    /**
     * Gets the idregistro value for this Ijaledbqldanot.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijaledbqldanot.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijaledbqld value for this Ijaledbqldanot.
     * 
     * @return ijaledbqld
     */
    public idw.idwws.Ijaledbqld getIjaledbqld() {
        return ijaledbqld;
    }


    /**
     * Sets the ijaledbqld value for this Ijaledbqldanot.
     * 
     * @param ijaledbqld
     */
    public void setIjaledbqld(idw.idwws.Ijaledbqld ijaledbqld) {
        this.ijaledbqld = ijaledbqld;
    }


    /**
     * Gets the ijtbusu value for this Ijaledbqldanot.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijaledbqldanot.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijaledbqldanot)) return false;
        Ijaledbqldanot other = (Ijaledbqldanot) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anotacao==null && other.getAnotacao()==null) || 
             (this.anotacao!=null &&
              this.anotacao.equals(other.getAnotacao()))) &&
            ((this.dthranotacao==null && other.getDthranotacao()==null) || 
             (this.dthranotacao!=null &&
              this.dthranotacao.equals(other.getDthranotacao()))) &&
            this.idregistro == other.getIdregistro() &&
            ((this.ijaledbqld==null && other.getIjaledbqld()==null) || 
             (this.ijaledbqld!=null &&
              this.ijaledbqld.equals(other.getIjaledbqld()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu())));
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
        if (getAnotacao() != null) {
            _hashCode += getAnotacao().hashCode();
        }
        if (getDthranotacao() != null) {
            _hashCode += getDthranotacao().hashCode();
        }
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjaledbqld() != null) {
            _hashCode += getIjaledbqld().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijaledbqldanot.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqldanot"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anotacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anotacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthranotacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthranotacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqld"));
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
