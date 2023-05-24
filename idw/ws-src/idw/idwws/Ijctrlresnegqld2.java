/**
 * Ijctrlresnegqld2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlresnegqld2  implements java.io.Serializable {
    private idw.idwws.Ijctrlresnegqld2Id id;

    private idw.idwws.Ijgrpparaminsp ijgrpparaminsp;

    private idw.idwws.Ijmolpro ijmolpro;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private org.apache.axis.types.UnsignedShort resultadoinspecao;

    public Ijctrlresnegqld2() {
    }

    public Ijctrlresnegqld2(
           idw.idwws.Ijctrlresnegqld2Id id,
           idw.idwws.Ijgrpparaminsp ijgrpparaminsp,
           idw.idwws.Ijmolpro ijmolpro,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           org.apache.axis.types.UnsignedShort resultadoinspecao) {
           this.id = id;
           this.ijgrpparaminsp = ijgrpparaminsp;
           this.ijmolpro = ijmolpro;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.resultadoinspecao = resultadoinspecao;
    }


    /**
     * Gets the id value for this Ijctrlresnegqld2.
     * 
     * @return id
     */
    public idw.idwws.Ijctrlresnegqld2Id getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijctrlresnegqld2.
     * 
     * @param id
     */
    public void setId(idw.idwws.Ijctrlresnegqld2Id id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpparaminsp value for this Ijctrlresnegqld2.
     * 
     * @return ijgrpparaminsp
     */
    public idw.idwws.Ijgrpparaminsp getIjgrpparaminsp() {
        return ijgrpparaminsp;
    }


    /**
     * Sets the ijgrpparaminsp value for this Ijctrlresnegqld2.
     * 
     * @param ijgrpparaminsp
     */
    public void setIjgrpparaminsp(idw.idwws.Ijgrpparaminsp ijgrpparaminsp) {
        this.ijgrpparaminsp = ijgrpparaminsp;
    }


    /**
     * Gets the ijmolpro value for this Ijctrlresnegqld2.
     * 
     * @return ijmolpro
     */
    public idw.idwws.Ijmolpro getIjmolpro() {
        return ijmolpro;
    }


    /**
     * Sets the ijmolpro value for this Ijctrlresnegqld2.
     * 
     * @param ijmolpro
     */
    public void setIjmolpro(idw.idwws.Ijmolpro ijmolpro) {
        this.ijmolpro = ijmolpro;
    }


    /**
     * Gets the ijop value for this Ijctrlresnegqld2.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijctrlresnegqld2.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijctrlresnegqld2.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijctrlresnegqld2.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the resultadoinspecao value for this Ijctrlresnegqld2.
     * 
     * @return resultadoinspecao
     */
    public org.apache.axis.types.UnsignedShort getResultadoinspecao() {
        return resultadoinspecao;
    }


    /**
     * Sets the resultadoinspecao value for this Ijctrlresnegqld2.
     * 
     * @param resultadoinspecao
     */
    public void setResultadoinspecao(org.apache.axis.types.UnsignedShort resultadoinspecao) {
        this.resultadoinspecao = resultadoinspecao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlresnegqld2)) return false;
        Ijctrlresnegqld2 other = (Ijctrlresnegqld2) obj;
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
            ((this.ijgrpparaminsp==null && other.getIjgrpparaminsp()==null) || 
             (this.ijgrpparaminsp!=null &&
              this.ijgrpparaminsp.equals(other.getIjgrpparaminsp()))) &&
            ((this.ijmolpro==null && other.getIjmolpro()==null) || 
             (this.ijmolpro!=null &&
              this.ijmolpro.equals(other.getIjmolpro()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.resultadoinspecao==null && other.getResultadoinspecao()==null) || 
             (this.resultadoinspecao!=null &&
              this.resultadoinspecao.equals(other.getResultadoinspecao())));
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
        if (getIjgrpparaminsp() != null) {
            _hashCode += getIjgrpparaminsp().hashCode();
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
        if (getResultadoinspecao() != null) {
            _hashCode += getResultadoinspecao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlresnegqld2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlresnegqld2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlresnegqld2Id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpparaminsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpparaminsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminsp"));
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
        elemField.setFieldName("resultadoinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoinspecao"));
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
