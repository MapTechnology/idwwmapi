/**
 * Ijrefman.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijrefman  implements java.io.Serializable {
    private idw.idwws.IjrefmanId id;

    private idw.idwws.Ijmolpro ijmolpro;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbref ijtbref;

    private idw.idwws.Ijtbtur ijtbtur;

    private idw.idwws.Ijtbusu ijtbusuByCdusuarioexclusao;

    private idw.idwws.Ijtbusu ijtbusuByCdusuarioinclusao;

    public Ijrefman() {
    }

    public Ijrefman(
           idw.idwws.IjrefmanId id,
           idw.idwws.Ijmolpro ijmolpro,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbref ijtbref,
           idw.idwws.Ijtbtur ijtbtur,
           idw.idwws.Ijtbusu ijtbusuByCdusuarioexclusao,
           idw.idwws.Ijtbusu ijtbusuByCdusuarioinclusao) {
           this.id = id;
           this.ijmolpro = ijmolpro;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.ijtbref = ijtbref;
           this.ijtbtur = ijtbtur;
           this.ijtbusuByCdusuarioexclusao = ijtbusuByCdusuarioexclusao;
           this.ijtbusuByCdusuarioinclusao = ijtbusuByCdusuarioinclusao;
    }


    /**
     * Gets the id value for this Ijrefman.
     * 
     * @return id
     */
    public idw.idwws.IjrefmanId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijrefman.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjrefmanId id) {
        this.id = id;
    }


    /**
     * Gets the ijmolpro value for this Ijrefman.
     * 
     * @return ijmolpro
     */
    public idw.idwws.Ijmolpro getIjmolpro() {
        return ijmolpro;
    }


    /**
     * Sets the ijmolpro value for this Ijrefman.
     * 
     * @param ijmolpro
     */
    public void setIjmolpro(idw.idwws.Ijmolpro ijmolpro) {
        this.ijmolpro = ijmolpro;
    }


    /**
     * Gets the ijop value for this Ijrefman.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijrefman.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijrefman.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijrefman.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbref value for this Ijrefman.
     * 
     * @return ijtbref
     */
    public idw.idwws.Ijtbref getIjtbref() {
        return ijtbref;
    }


    /**
     * Sets the ijtbref value for this Ijrefman.
     * 
     * @param ijtbref
     */
    public void setIjtbref(idw.idwws.Ijtbref ijtbref) {
        this.ijtbref = ijtbref;
    }


    /**
     * Gets the ijtbtur value for this Ijrefman.
     * 
     * @return ijtbtur
     */
    public idw.idwws.Ijtbtur getIjtbtur() {
        return ijtbtur;
    }


    /**
     * Sets the ijtbtur value for this Ijrefman.
     * 
     * @param ijtbtur
     */
    public void setIjtbtur(idw.idwws.Ijtbtur ijtbtur) {
        this.ijtbtur = ijtbtur;
    }


    /**
     * Gets the ijtbusuByCdusuarioexclusao value for this Ijrefman.
     * 
     * @return ijtbusuByCdusuarioexclusao
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuarioexclusao() {
        return ijtbusuByCdusuarioexclusao;
    }


    /**
     * Sets the ijtbusuByCdusuarioexclusao value for this Ijrefman.
     * 
     * @param ijtbusuByCdusuarioexclusao
     */
    public void setIjtbusuByCdusuarioexclusao(idw.idwws.Ijtbusu ijtbusuByCdusuarioexclusao) {
        this.ijtbusuByCdusuarioexclusao = ijtbusuByCdusuarioexclusao;
    }


    /**
     * Gets the ijtbusuByCdusuarioinclusao value for this Ijrefman.
     * 
     * @return ijtbusuByCdusuarioinclusao
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuarioinclusao() {
        return ijtbusuByCdusuarioinclusao;
    }


    /**
     * Sets the ijtbusuByCdusuarioinclusao value for this Ijrefman.
     * 
     * @param ijtbusuByCdusuarioinclusao
     */
    public void setIjtbusuByCdusuarioinclusao(idw.idwws.Ijtbusu ijtbusuByCdusuarioinclusao) {
        this.ijtbusuByCdusuarioinclusao = ijtbusuByCdusuarioinclusao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijrefman)) return false;
        Ijrefman other = (Ijrefman) obj;
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
            ((this.ijmolpro==null && other.getIjmolpro()==null) || 
             (this.ijmolpro!=null &&
              this.ijmolpro.equals(other.getIjmolpro()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbref==null && other.getIjtbref()==null) || 
             (this.ijtbref!=null &&
              this.ijtbref.equals(other.getIjtbref()))) &&
            ((this.ijtbtur==null && other.getIjtbtur()==null) || 
             (this.ijtbtur!=null &&
              this.ijtbtur.equals(other.getIjtbtur()))) &&
            ((this.ijtbusuByCdusuarioexclusao==null && other.getIjtbusuByCdusuarioexclusao()==null) || 
             (this.ijtbusuByCdusuarioexclusao!=null &&
              this.ijtbusuByCdusuarioexclusao.equals(other.getIjtbusuByCdusuarioexclusao()))) &&
            ((this.ijtbusuByCdusuarioinclusao==null && other.getIjtbusuByCdusuarioinclusao()==null) || 
             (this.ijtbusuByCdusuarioinclusao!=null &&
              this.ijtbusuByCdusuarioinclusao.equals(other.getIjtbusuByCdusuarioinclusao())));
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
        if (getIjmolpro() != null) {
            _hashCode += getIjmolpro().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbref() != null) {
            _hashCode += getIjtbref().hashCode();
        }
        if (getIjtbtur() != null) {
            _hashCode += getIjtbtur().hashCode();
        }
        if (getIjtbusuByCdusuarioexclusao() != null) {
            _hashCode += getIjtbusuByCdusuarioexclusao().hashCode();
        }
        if (getIjtbusuByCdusuarioinclusao() != null) {
            _hashCode += getIjtbusuByCdusuarioinclusao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijrefman.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefman"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefmanId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbref");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbref"));
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
        elemField.setFieldName("ijtbusuByCdusuarioexclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusuarioexclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusuarioinclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusuarioinclusao"));
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
