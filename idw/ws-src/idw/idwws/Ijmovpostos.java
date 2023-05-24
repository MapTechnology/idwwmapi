/**
 * Ijmovpostos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmovpostos  implements java.io.Serializable {
    private idw.idwws.IjmovpostosId id;

    private idw.idwws.Ijgrpestproc ijgrpestproc;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtboperacoes ijtboperacoes;

    private idw.idwws.Ijtbpostos ijtbpostos;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijmovpostos() {
    }

    public Ijmovpostos(
           idw.idwws.IjmovpostosId id,
           idw.idwws.Ijgrpestproc ijgrpestproc,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtboperacoes ijtboperacoes,
           idw.idwws.Ijtbpostos ijtbpostos,
           idw.idwws.Ijtbusu ijtbusu) {
           this.id = id;
           this.ijgrpestproc = ijgrpestproc;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.ijtboperacoes = ijtboperacoes;
           this.ijtbpostos = ijtbpostos;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the id value for this Ijmovpostos.
     * 
     * @return id
     */
    public idw.idwws.IjmovpostosId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmovpostos.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmovpostosId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpestproc value for this Ijmovpostos.
     * 
     * @return ijgrpestproc
     */
    public idw.idwws.Ijgrpestproc getIjgrpestproc() {
        return ijgrpestproc;
    }


    /**
     * Sets the ijgrpestproc value for this Ijmovpostos.
     * 
     * @param ijgrpestproc
     */
    public void setIjgrpestproc(idw.idwws.Ijgrpestproc ijgrpestproc) {
        this.ijgrpestproc = ijgrpestproc;
    }


    /**
     * Gets the ijop value for this Ijmovpostos.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijmovpostos.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijmovpostos.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijmovpostos.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtboperacoes value for this Ijmovpostos.
     * 
     * @return ijtboperacoes
     */
    public idw.idwws.Ijtboperacoes getIjtboperacoes() {
        return ijtboperacoes;
    }


    /**
     * Sets the ijtboperacoes value for this Ijmovpostos.
     * 
     * @param ijtboperacoes
     */
    public void setIjtboperacoes(idw.idwws.Ijtboperacoes ijtboperacoes) {
        this.ijtboperacoes = ijtboperacoes;
    }


    /**
     * Gets the ijtbpostos value for this Ijmovpostos.
     * 
     * @return ijtbpostos
     */
    public idw.idwws.Ijtbpostos getIjtbpostos() {
        return ijtbpostos;
    }


    /**
     * Sets the ijtbpostos value for this Ijmovpostos.
     * 
     * @param ijtbpostos
     */
    public void setIjtbpostos(idw.idwws.Ijtbpostos ijtbpostos) {
        this.ijtbpostos = ijtbpostos;
    }


    /**
     * Gets the ijtbusu value for this Ijmovpostos.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijmovpostos.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmovpostos)) return false;
        Ijmovpostos other = (Ijmovpostos) obj;
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
            ((this.ijgrpestproc==null && other.getIjgrpestproc()==null) || 
             (this.ijgrpestproc!=null &&
              this.ijgrpestproc.equals(other.getIjgrpestproc()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtboperacoes==null && other.getIjtboperacoes()==null) || 
             (this.ijtboperacoes!=null &&
              this.ijtboperacoes.equals(other.getIjtboperacoes()))) &&
            ((this.ijtbpostos==null && other.getIjtbpostos()==null) || 
             (this.ijtbpostos!=null &&
              this.ijtbpostos.equals(other.getIjtbpostos()))) &&
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
        if (getIjgrpestproc() != null) {
            _hashCode += getIjgrpestproc().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtboperacoes() != null) {
            _hashCode += getIjtboperacoes().hashCode();
        }
        if (getIjtbpostos() != null) {
            _hashCode += getIjtbpostos().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmovpostos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmovpostos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmovpostosId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpestproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpestproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpestproc"));
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
        elemField.setFieldName("ijtboperacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtboperacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpostos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpostos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpostos"));
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
