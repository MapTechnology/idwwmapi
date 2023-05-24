/**
 * Ijmanutchklstdet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanutchklstdet  implements java.io.Serializable {
    private idw.idwws.IjmanutchklstdetId id;

    private idw.idwws.Ijmanutchklst ijmanutchklst;

    private idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefa;

    private idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefapai;

    private java.math.BigDecimal nivel;

    private org.apache.axis.types.UnsignedShort stobrigatoria;

    public Ijmanutchklstdet() {
    }

    public Ijmanutchklstdet(
           idw.idwws.IjmanutchklstdetId id,
           idw.idwws.Ijmanutchklst ijmanutchklst,
           idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefa,
           idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefapai,
           java.math.BigDecimal nivel,
           org.apache.axis.types.UnsignedShort stobrigatoria) {
           this.id = id;
           this.ijmanutchklst = ijmanutchklst;
           this.ijmanuttarefaByIdtarefa = ijmanuttarefaByIdtarefa;
           this.ijmanuttarefaByIdtarefapai = ijmanuttarefaByIdtarefapai;
           this.nivel = nivel;
           this.stobrigatoria = stobrigatoria;
    }


    /**
     * Gets the id value for this Ijmanutchklstdet.
     * 
     * @return id
     */
    public idw.idwws.IjmanutchklstdetId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmanutchklstdet.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmanutchklstdetId id) {
        this.id = id;
    }


    /**
     * Gets the ijmanutchklst value for this Ijmanutchklstdet.
     * 
     * @return ijmanutchklst
     */
    public idw.idwws.Ijmanutchklst getIjmanutchklst() {
        return ijmanutchklst;
    }


    /**
     * Sets the ijmanutchklst value for this Ijmanutchklstdet.
     * 
     * @param ijmanutchklst
     */
    public void setIjmanutchklst(idw.idwws.Ijmanutchklst ijmanutchklst) {
        this.ijmanutchklst = ijmanutchklst;
    }


    /**
     * Gets the ijmanuttarefaByIdtarefa value for this Ijmanutchklstdet.
     * 
     * @return ijmanuttarefaByIdtarefa
     */
    public idw.idwws.Ijmanuttarefa getIjmanuttarefaByIdtarefa() {
        return ijmanuttarefaByIdtarefa;
    }


    /**
     * Sets the ijmanuttarefaByIdtarefa value for this Ijmanutchklstdet.
     * 
     * @param ijmanuttarefaByIdtarefa
     */
    public void setIjmanuttarefaByIdtarefa(idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefa) {
        this.ijmanuttarefaByIdtarefa = ijmanuttarefaByIdtarefa;
    }


    /**
     * Gets the ijmanuttarefaByIdtarefapai value for this Ijmanutchklstdet.
     * 
     * @return ijmanuttarefaByIdtarefapai
     */
    public idw.idwws.Ijmanuttarefa getIjmanuttarefaByIdtarefapai() {
        return ijmanuttarefaByIdtarefapai;
    }


    /**
     * Sets the ijmanuttarefaByIdtarefapai value for this Ijmanutchklstdet.
     * 
     * @param ijmanuttarefaByIdtarefapai
     */
    public void setIjmanuttarefaByIdtarefapai(idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefapai) {
        this.ijmanuttarefaByIdtarefapai = ijmanuttarefaByIdtarefapai;
    }


    /**
     * Gets the nivel value for this Ijmanutchklstdet.
     * 
     * @return nivel
     */
    public java.math.BigDecimal getNivel() {
        return nivel;
    }


    /**
     * Sets the nivel value for this Ijmanutchklstdet.
     * 
     * @param nivel
     */
    public void setNivel(java.math.BigDecimal nivel) {
        this.nivel = nivel;
    }


    /**
     * Gets the stobrigatoria value for this Ijmanutchklstdet.
     * 
     * @return stobrigatoria
     */
    public org.apache.axis.types.UnsignedShort getStobrigatoria() {
        return stobrigatoria;
    }


    /**
     * Sets the stobrigatoria value for this Ijmanutchklstdet.
     * 
     * @param stobrigatoria
     */
    public void setStobrigatoria(org.apache.axis.types.UnsignedShort stobrigatoria) {
        this.stobrigatoria = stobrigatoria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanutchklstdet)) return false;
        Ijmanutchklstdet other = (Ijmanutchklstdet) obj;
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
            ((this.ijmanutchklst==null && other.getIjmanutchklst()==null) || 
             (this.ijmanutchklst!=null &&
              this.ijmanutchklst.equals(other.getIjmanutchklst()))) &&
            ((this.ijmanuttarefaByIdtarefa==null && other.getIjmanuttarefaByIdtarefa()==null) || 
             (this.ijmanuttarefaByIdtarefa!=null &&
              this.ijmanuttarefaByIdtarefa.equals(other.getIjmanuttarefaByIdtarefa()))) &&
            ((this.ijmanuttarefaByIdtarefapai==null && other.getIjmanuttarefaByIdtarefapai()==null) || 
             (this.ijmanuttarefaByIdtarefapai!=null &&
              this.ijmanuttarefaByIdtarefapai.equals(other.getIjmanuttarefaByIdtarefapai()))) &&
            ((this.nivel==null && other.getNivel()==null) || 
             (this.nivel!=null &&
              this.nivel.equals(other.getNivel()))) &&
            ((this.stobrigatoria==null && other.getStobrigatoria()==null) || 
             (this.stobrigatoria!=null &&
              this.stobrigatoria.equals(other.getStobrigatoria())));
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
        if (getIjmanutchklst() != null) {
            _hashCode += getIjmanutchklst().hashCode();
        }
        if (getIjmanuttarefaByIdtarefa() != null) {
            _hashCode += getIjmanuttarefaByIdtarefa().hashCode();
        }
        if (getIjmanuttarefaByIdtarefapai() != null) {
            _hashCode += getIjmanuttarefaByIdtarefapai().hashCode();
        }
        if (getNivel() != null) {
            _hashCode += getNivel().hashCode();
        }
        if (getStobrigatoria() != null) {
            _hashCode += getStobrigatoria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanutchklstdet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklstdet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklstdetId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutchklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanuttarefaByIdtarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanuttarefaByIdtarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanuttarefa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanuttarefaByIdtarefapai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanuttarefaByIdtarefapai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanuttarefa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stobrigatoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stobrigatoria"));
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
