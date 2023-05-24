/**
 * Ijselitensarq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijselitensarq  implements java.io.Serializable {
    private idw.idwws.IjselitensarqId id;

    private idw.idwws.Ijclassificinf ijclassificinf;

    private idw.idwws.Ijparamitensarq[] ijparamitensarqs;

    private idw.idwws.Ijselecao ijselecao;

    public Ijselitensarq() {
    }

    public Ijselitensarq(
           idw.idwws.IjselitensarqId id,
           idw.idwws.Ijclassificinf ijclassificinf,
           idw.idwws.Ijparamitensarq[] ijparamitensarqs,
           idw.idwws.Ijselecao ijselecao) {
           this.id = id;
           this.ijclassificinf = ijclassificinf;
           this.ijparamitensarqs = ijparamitensarqs;
           this.ijselecao = ijselecao;
    }


    /**
     * Gets the id value for this Ijselitensarq.
     * 
     * @return id
     */
    public idw.idwws.IjselitensarqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijselitensarq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjselitensarqId id) {
        this.id = id;
    }


    /**
     * Gets the ijclassificinf value for this Ijselitensarq.
     * 
     * @return ijclassificinf
     */
    public idw.idwws.Ijclassificinf getIjclassificinf() {
        return ijclassificinf;
    }


    /**
     * Sets the ijclassificinf value for this Ijselitensarq.
     * 
     * @param ijclassificinf
     */
    public void setIjclassificinf(idw.idwws.Ijclassificinf ijclassificinf) {
        this.ijclassificinf = ijclassificinf;
    }


    /**
     * Gets the ijparamitensarqs value for this Ijselitensarq.
     * 
     * @return ijparamitensarqs
     */
    public idw.idwws.Ijparamitensarq[] getIjparamitensarqs() {
        return ijparamitensarqs;
    }


    /**
     * Sets the ijparamitensarqs value for this Ijselitensarq.
     * 
     * @param ijparamitensarqs
     */
    public void setIjparamitensarqs(idw.idwws.Ijparamitensarq[] ijparamitensarqs) {
        this.ijparamitensarqs = ijparamitensarqs;
    }

    public idw.idwws.Ijparamitensarq getIjparamitensarqs(int i) {
        return this.ijparamitensarqs[i];
    }

    public void setIjparamitensarqs(int i, idw.idwws.Ijparamitensarq _value) {
        this.ijparamitensarqs[i] = _value;
    }


    /**
     * Gets the ijselecao value for this Ijselitensarq.
     * 
     * @return ijselecao
     */
    public idw.idwws.Ijselecao getIjselecao() {
        return ijselecao;
    }


    /**
     * Sets the ijselecao value for this Ijselitensarq.
     * 
     * @param ijselecao
     */
    public void setIjselecao(idw.idwws.Ijselecao ijselecao) {
        this.ijselecao = ijselecao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijselitensarq)) return false;
        Ijselitensarq other = (Ijselitensarq) obj;
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
            ((this.ijclassificinf==null && other.getIjclassificinf()==null) || 
             (this.ijclassificinf!=null &&
              this.ijclassificinf.equals(other.getIjclassificinf()))) &&
            ((this.ijparamitensarqs==null && other.getIjparamitensarqs()==null) || 
             (this.ijparamitensarqs!=null &&
              java.util.Arrays.equals(this.ijparamitensarqs, other.getIjparamitensarqs()))) &&
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
        if (getIjclassificinf() != null) {
            _hashCode += getIjclassificinf().hashCode();
        }
        if (getIjparamitensarqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjparamitensarqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjparamitensarqs(), i);
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
        new org.apache.axis.description.TypeDesc(Ijselitensarq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensarq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensarqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijclassificinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijclassificinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificinf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparamitensarqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparamitensarqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparamitensarq"));
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
