/**
 * Ijopprodutos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijopprodutos  implements java.io.Serializable {
    private idw.idwws.IjopprodutosId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijopnipponinsumo[] ijopnipponinsumos;

    private idw.idwws.Ijtbpro ijtbpro;

    private java.lang.Double qtpecasestoque;

    private double qtpecasproduzir;

    public Ijopprodutos() {
    }

    public Ijopprodutos(
           idw.idwws.IjopprodutosId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijopnipponinsumo[] ijopnipponinsumos,
           idw.idwws.Ijtbpro ijtbpro,
           java.lang.Double qtpecasestoque,
           double qtpecasproduzir) {
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijop = ijop;
           this.ijopnipponinsumos = ijopnipponinsumos;
           this.ijtbpro = ijtbpro;
           this.qtpecasestoque = qtpecasestoque;
           this.qtpecasproduzir = qtpecasproduzir;
    }


    /**
     * Gets the id value for this Ijopprodutos.
     * 
     * @return id
     */
    public idw.idwws.IjopprodutosId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijopprodutos.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjopprodutosId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijopprodutos.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijopprodutos.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijop value for this Ijopprodutos.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijopprodutos.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijopnipponinsumos value for this Ijopprodutos.
     * 
     * @return ijopnipponinsumos
     */
    public idw.idwws.Ijopnipponinsumo[] getIjopnipponinsumos() {
        return ijopnipponinsumos;
    }


    /**
     * Sets the ijopnipponinsumos value for this Ijopprodutos.
     * 
     * @param ijopnipponinsumos
     */
    public void setIjopnipponinsumos(idw.idwws.Ijopnipponinsumo[] ijopnipponinsumos) {
        this.ijopnipponinsumos = ijopnipponinsumos;
    }

    public idw.idwws.Ijopnipponinsumo getIjopnipponinsumos(int i) {
        return this.ijopnipponinsumos[i];
    }

    public void setIjopnipponinsumos(int i, idw.idwws.Ijopnipponinsumo _value) {
        this.ijopnipponinsumos[i] = _value;
    }


    /**
     * Gets the ijtbpro value for this Ijopprodutos.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijopprodutos.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the qtpecasestoque value for this Ijopprodutos.
     * 
     * @return qtpecasestoque
     */
    public java.lang.Double getQtpecasestoque() {
        return qtpecasestoque;
    }


    /**
     * Sets the qtpecasestoque value for this Ijopprodutos.
     * 
     * @param qtpecasestoque
     */
    public void setQtpecasestoque(java.lang.Double qtpecasestoque) {
        this.qtpecasestoque = qtpecasestoque;
    }


    /**
     * Gets the qtpecasproduzir value for this Ijopprodutos.
     * 
     * @return qtpecasproduzir
     */
    public double getQtpecasproduzir() {
        return qtpecasproduzir;
    }


    /**
     * Sets the qtpecasproduzir value for this Ijopprodutos.
     * 
     * @param qtpecasproduzir
     */
    public void setQtpecasproduzir(double qtpecasproduzir) {
        this.qtpecasproduzir = qtpecasproduzir;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijopprodutos)) return false;
        Ijopprodutos other = (Ijopprodutos) obj;
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
            ((this.ijopnipponinsumos==null && other.getIjopnipponinsumos()==null) || 
             (this.ijopnipponinsumos!=null &&
              java.util.Arrays.equals(this.ijopnipponinsumos, other.getIjopnipponinsumos()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.qtpecasestoque==null && other.getQtpecasestoque()==null) || 
             (this.qtpecasestoque!=null &&
              this.qtpecasestoque.equals(other.getQtpecasestoque()))) &&
            this.qtpecasproduzir == other.getQtpecasproduzir();
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
        if (getIjopnipponinsumos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopnipponinsumos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopnipponinsumos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getQtpecasestoque() != null) {
            _hashCode += getQtpecasestoque().hashCode();
        }
        _hashCode += new Double(getQtpecasproduzir()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijopprodutos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopprodutos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopprodutosId"));
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
        elemField.setFieldName("ijopnipponinsumos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopnipponinsumos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopnipponinsumo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtpecasestoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtpecasestoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtpecasproduzir");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtpecasproduzir"));
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
