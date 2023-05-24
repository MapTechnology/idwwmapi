/**
 * Ijselitensmen.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijselitensmen  implements java.io.Serializable {
    private idw.idwws.IjselitensmenId id;

    private idw.idwws.Ijclassificcont ijclassificcont;

    private idw.idwws.Ijfiltroitensmen[] ijfiltroitensmens;

    private idw.idwws.Ijselecao ijselecao;

    public Ijselitensmen() {
    }

    public Ijselitensmen(
           idw.idwws.IjselitensmenId id,
           idw.idwws.Ijclassificcont ijclassificcont,
           idw.idwws.Ijfiltroitensmen[] ijfiltroitensmens,
           idw.idwws.Ijselecao ijselecao) {
           this.id = id;
           this.ijclassificcont = ijclassificcont;
           this.ijfiltroitensmens = ijfiltroitensmens;
           this.ijselecao = ijselecao;
    }


    /**
     * Gets the id value for this Ijselitensmen.
     * 
     * @return id
     */
    public idw.idwws.IjselitensmenId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijselitensmen.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjselitensmenId id) {
        this.id = id;
    }


    /**
     * Gets the ijclassificcont value for this Ijselitensmen.
     * 
     * @return ijclassificcont
     */
    public idw.idwws.Ijclassificcont getIjclassificcont() {
        return ijclassificcont;
    }


    /**
     * Sets the ijclassificcont value for this Ijselitensmen.
     * 
     * @param ijclassificcont
     */
    public void setIjclassificcont(idw.idwws.Ijclassificcont ijclassificcont) {
        this.ijclassificcont = ijclassificcont;
    }


    /**
     * Gets the ijfiltroitensmens value for this Ijselitensmen.
     * 
     * @return ijfiltroitensmens
     */
    public idw.idwws.Ijfiltroitensmen[] getIjfiltroitensmens() {
        return ijfiltroitensmens;
    }


    /**
     * Sets the ijfiltroitensmens value for this Ijselitensmen.
     * 
     * @param ijfiltroitensmens
     */
    public void setIjfiltroitensmens(idw.idwws.Ijfiltroitensmen[] ijfiltroitensmens) {
        this.ijfiltroitensmens = ijfiltroitensmens;
    }

    public idw.idwws.Ijfiltroitensmen getIjfiltroitensmens(int i) {
        return this.ijfiltroitensmens[i];
    }

    public void setIjfiltroitensmens(int i, idw.idwws.Ijfiltroitensmen _value) {
        this.ijfiltroitensmens[i] = _value;
    }


    /**
     * Gets the ijselecao value for this Ijselitensmen.
     * 
     * @return ijselecao
     */
    public idw.idwws.Ijselecao getIjselecao() {
        return ijselecao;
    }


    /**
     * Sets the ijselecao value for this Ijselitensmen.
     * 
     * @param ijselecao
     */
    public void setIjselecao(idw.idwws.Ijselecao ijselecao) {
        this.ijselecao = ijselecao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijselitensmen)) return false;
        Ijselitensmen other = (Ijselitensmen) obj;
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
            ((this.ijclassificcont==null && other.getIjclassificcont()==null) || 
             (this.ijclassificcont!=null &&
              this.ijclassificcont.equals(other.getIjclassificcont()))) &&
            ((this.ijfiltroitensmens==null && other.getIjfiltroitensmens()==null) || 
             (this.ijfiltroitensmens!=null &&
              java.util.Arrays.equals(this.ijfiltroitensmens, other.getIjfiltroitensmens()))) &&
            ((this.ijselecao==null && other.getIjselecao()==null) || 
             (this.ijselecao!=null &&
              this.ijselecao.equals(other.getIjselecao())));
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
        if (getIjclassificcont() != null) {
            _hashCode += getIjclassificcont().hashCode();
        }
        if (getIjfiltroitensmens() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfiltroitensmens());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfiltroitensmens(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjselecao() != null) {
            _hashCode += getIjselecao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijselitensmen.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensmen"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensmenId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijclassificcont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijclassificcont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificcont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfiltroitensmens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfiltroitensmens"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltroitensmen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselecao"));
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
