/**
 * Ijkanbanmov.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijkanbanmov  implements java.io.Serializable {
    private idw.idwws.IjkanbanmovId id;

    private idw.idwws.Ijkanbanidcartao ijkanbanidcartao;

    private idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocaldestino;

    private idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocalorigem;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijkanbanmov() {
    }

    public Ijkanbanmov(
           idw.idwws.IjkanbanmovId id,
           idw.idwws.Ijkanbanidcartao ijkanbanidcartao,
           idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocaldestino,
           idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocalorigem,
           idw.idwws.Ijtbusu ijtbusu) {
           this.id = id;
           this.ijkanbanidcartao = ijkanbanidcartao;
           this.ijkanbanlocalByCdlocaldestino = ijkanbanlocalByCdlocaldestino;
           this.ijkanbanlocalByCdlocalorigem = ijkanbanlocalByCdlocalorigem;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the id value for this Ijkanbanmov.
     * 
     * @return id
     */
    public idw.idwws.IjkanbanmovId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijkanbanmov.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjkanbanmovId id) {
        this.id = id;
    }


    /**
     * Gets the ijkanbanidcartao value for this Ijkanbanmov.
     * 
     * @return ijkanbanidcartao
     */
    public idw.idwws.Ijkanbanidcartao getIjkanbanidcartao() {
        return ijkanbanidcartao;
    }


    /**
     * Sets the ijkanbanidcartao value for this Ijkanbanmov.
     * 
     * @param ijkanbanidcartao
     */
    public void setIjkanbanidcartao(idw.idwws.Ijkanbanidcartao ijkanbanidcartao) {
        this.ijkanbanidcartao = ijkanbanidcartao;
    }


    /**
     * Gets the ijkanbanlocalByCdlocaldestino value for this Ijkanbanmov.
     * 
     * @return ijkanbanlocalByCdlocaldestino
     */
    public idw.idwws.Ijkanbanlocal getIjkanbanlocalByCdlocaldestino() {
        return ijkanbanlocalByCdlocaldestino;
    }


    /**
     * Sets the ijkanbanlocalByCdlocaldestino value for this Ijkanbanmov.
     * 
     * @param ijkanbanlocalByCdlocaldestino
     */
    public void setIjkanbanlocalByCdlocaldestino(idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocaldestino) {
        this.ijkanbanlocalByCdlocaldestino = ijkanbanlocalByCdlocaldestino;
    }


    /**
     * Gets the ijkanbanlocalByCdlocalorigem value for this Ijkanbanmov.
     * 
     * @return ijkanbanlocalByCdlocalorigem
     */
    public idw.idwws.Ijkanbanlocal getIjkanbanlocalByCdlocalorigem() {
        return ijkanbanlocalByCdlocalorigem;
    }


    /**
     * Sets the ijkanbanlocalByCdlocalorigem value for this Ijkanbanmov.
     * 
     * @param ijkanbanlocalByCdlocalorigem
     */
    public void setIjkanbanlocalByCdlocalorigem(idw.idwws.Ijkanbanlocal ijkanbanlocalByCdlocalorigem) {
        this.ijkanbanlocalByCdlocalorigem = ijkanbanlocalByCdlocalorigem;
    }


    /**
     * Gets the ijtbusu value for this Ijkanbanmov.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijkanbanmov.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijkanbanmov)) return false;
        Ijkanbanmov other = (Ijkanbanmov) obj;
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
            ((this.ijkanbanidcartao==null && other.getIjkanbanidcartao()==null) || 
             (this.ijkanbanidcartao!=null &&
              this.ijkanbanidcartao.equals(other.getIjkanbanidcartao()))) &&
            ((this.ijkanbanlocalByCdlocaldestino==null && other.getIjkanbanlocalByCdlocaldestino()==null) || 
             (this.ijkanbanlocalByCdlocaldestino!=null &&
              this.ijkanbanlocalByCdlocaldestino.equals(other.getIjkanbanlocalByCdlocaldestino()))) &&
            ((this.ijkanbanlocalByCdlocalorigem==null && other.getIjkanbanlocalByCdlocalorigem()==null) || 
             (this.ijkanbanlocalByCdlocalorigem!=null &&
              this.ijkanbanlocalByCdlocalorigem.equals(other.getIjkanbanlocalByCdlocalorigem()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjkanbanidcartao() != null) {
            _hashCode += getIjkanbanidcartao().hashCode();
        }
        if (getIjkanbanlocalByCdlocaldestino() != null) {
            _hashCode += getIjkanbanlocalByCdlocaldestino().hashCode();
        }
        if (getIjkanbanlocalByCdlocalorigem() != null) {
            _hashCode += getIjkanbanlocalByCdlocalorigem().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijkanbanmov.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanmov"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanmovId"));
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
        elemField.setFieldName("ijkanbanlocalByCdlocaldestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlocalByCdlocaldestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlocal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlocalByCdlocalorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlocalByCdlocalorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlocal"));
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
