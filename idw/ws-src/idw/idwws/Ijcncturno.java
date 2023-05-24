/**
 * Ijcncturno.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcncturno  implements java.io.Serializable {
    private idw.idwws.IjcncturnoId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbitemcnc ijtbitemcnc;

    private idw.idwws.Ijtbtur ijtbtur;

    private java.lang.Double qtdleituras;

    private java.lang.Double vlacumulado;

    public Ijcncturno() {
    }

    public Ijcncturno(
           idw.idwws.IjcncturnoId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbitemcnc ijtbitemcnc,
           idw.idwws.Ijtbtur ijtbtur,
           java.lang.Double qtdleituras,
           java.lang.Double vlacumulado) {
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.ijtbitemcnc = ijtbitemcnc;
           this.ijtbtur = ijtbtur;
           this.qtdleituras = qtdleituras;
           this.vlacumulado = vlacumulado;
    }


    /**
     * Gets the id value for this Ijcncturno.
     * 
     * @return id
     */
    public idw.idwws.IjcncturnoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcncturno.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcncturnoId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijcncturno.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijcncturno.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijop value for this Ijcncturno.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijcncturno.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijcncturno.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijcncturno.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbitemcnc value for this Ijcncturno.
     * 
     * @return ijtbitemcnc
     */
    public idw.idwws.Ijtbitemcnc getIjtbitemcnc() {
        return ijtbitemcnc;
    }


    /**
     * Sets the ijtbitemcnc value for this Ijcncturno.
     * 
     * @param ijtbitemcnc
     */
    public void setIjtbitemcnc(idw.idwws.Ijtbitemcnc ijtbitemcnc) {
        this.ijtbitemcnc = ijtbitemcnc;
    }


    /**
     * Gets the ijtbtur value for this Ijcncturno.
     * 
     * @return ijtbtur
     */
    public idw.idwws.Ijtbtur getIjtbtur() {
        return ijtbtur;
    }


    /**
     * Sets the ijtbtur value for this Ijcncturno.
     * 
     * @param ijtbtur
     */
    public void setIjtbtur(idw.idwws.Ijtbtur ijtbtur) {
        this.ijtbtur = ijtbtur;
    }


    /**
     * Gets the qtdleituras value for this Ijcncturno.
     * 
     * @return qtdleituras
     */
    public java.lang.Double getQtdleituras() {
        return qtdleituras;
    }


    /**
     * Sets the qtdleituras value for this Ijcncturno.
     * 
     * @param qtdleituras
     */
    public void setQtdleituras(java.lang.Double qtdleituras) {
        this.qtdleituras = qtdleituras;
    }


    /**
     * Gets the vlacumulado value for this Ijcncturno.
     * 
     * @return vlacumulado
     */
    public java.lang.Double getVlacumulado() {
        return vlacumulado;
    }


    /**
     * Sets the vlacumulado value for this Ijcncturno.
     * 
     * @param vlacumulado
     */
    public void setVlacumulado(java.lang.Double vlacumulado) {
        this.vlacumulado = vlacumulado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcncturno)) return false;
        Ijcncturno other = (Ijcncturno) obj;
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
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbitemcnc==null && other.getIjtbitemcnc()==null) || 
             (this.ijtbitemcnc!=null &&
              this.ijtbitemcnc.equals(other.getIjtbitemcnc()))) &&
            ((this.ijtbtur==null && other.getIjtbtur()==null) || 
             (this.ijtbtur!=null &&
              this.ijtbtur.equals(other.getIjtbtur()))) &&
            ((this.qtdleituras==null && other.getQtdleituras()==null) || 
             (this.qtdleituras!=null &&
              this.qtdleituras.equals(other.getQtdleituras()))) &&
            ((this.vlacumulado==null && other.getVlacumulado()==null) || 
             (this.vlacumulado!=null &&
              this.vlacumulado.equals(other.getVlacumulado())));
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
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbitemcnc() != null) {
            _hashCode += getIjtbitemcnc().hashCode();
        }
        if (getIjtbtur() != null) {
            _hashCode += getIjtbtur().hashCode();
        }
        if (getQtdleituras() != null) {
            _hashCode += getQtdleituras().hashCode();
        }
        if (getVlacumulado() != null) {
            _hashCode += getVlacumulado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcncturno.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncturno"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncturnoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
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
        elemField.setFieldName("ijtbitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbitemcnc"));
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
        elemField.setFieldName("qtdleituras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdleituras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlacumulado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlacumulado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
