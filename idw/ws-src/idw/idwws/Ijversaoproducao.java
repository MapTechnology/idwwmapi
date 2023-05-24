/**
 * Ijversaoproducao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijversaoproducao  implements java.io.Serializable {
    private java.lang.String ativa;

    private idw.idwws.IjversaoproducaoId id;

    private idw.idwws.Ijopversaopro[] ijopversaopros;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbpro ijtbpro;

    public Ijversaoproducao() {
    }

    public Ijversaoproducao(
           java.lang.String ativa,
           idw.idwws.IjversaoproducaoId id,
           idw.idwws.Ijopversaopro[] ijopversaopros,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbpro ijtbpro) {
           this.ativa = ativa;
           this.id = id;
           this.ijopversaopros = ijopversaopros;
           this.ijtbinj = ijtbinj;
           this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the ativa value for this Ijversaoproducao.
     * 
     * @return ativa
     */
    public java.lang.String getAtiva() {
        return ativa;
    }


    /**
     * Sets the ativa value for this Ijversaoproducao.
     * 
     * @param ativa
     */
    public void setAtiva(java.lang.String ativa) {
        this.ativa = ativa;
    }


    /**
     * Gets the id value for this Ijversaoproducao.
     * 
     * @return id
     */
    public idw.idwws.IjversaoproducaoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijversaoproducao.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjversaoproducaoId id) {
        this.id = id;
    }


    /**
     * Gets the ijopversaopros value for this Ijversaoproducao.
     * 
     * @return ijopversaopros
     */
    public idw.idwws.Ijopversaopro[] getIjopversaopros() {
        return ijopversaopros;
    }


    /**
     * Sets the ijopversaopros value for this Ijversaoproducao.
     * 
     * @param ijopversaopros
     */
    public void setIjopversaopros(idw.idwws.Ijopversaopro[] ijopversaopros) {
        this.ijopversaopros = ijopversaopros;
    }

    public idw.idwws.Ijopversaopro getIjopversaopros(int i) {
        return this.ijopversaopros[i];
    }

    public void setIjopversaopros(int i, idw.idwws.Ijopversaopro _value) {
        this.ijopversaopros[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijversaoproducao.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijversaoproducao.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbpro value for this Ijversaoproducao.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijversaoproducao.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijversaoproducao)) return false;
        Ijversaoproducao other = (Ijversaoproducao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ativa==null && other.getAtiva()==null) || 
             (this.ativa!=null &&
              this.ativa.equals(other.getAtiva()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijopversaopros==null && other.getIjopversaopros()==null) || 
             (this.ijopversaopros!=null &&
              java.util.Arrays.equals(this.ijopversaopros, other.getIjopversaopros()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro())));
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
        if (getAtiva() != null) {
            _hashCode += getAtiva().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjopversaopros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopversaopros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopversaopros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijversaoproducao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijversaoproducao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijversaoproducaoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopversaopros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopversaopros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopversaopro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
