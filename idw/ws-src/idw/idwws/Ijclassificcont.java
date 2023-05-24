/**
 * Ijclassificcont.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijclassificcont  implements java.io.Serializable {
    private idw.idwws.IjclassificcontId id;

    private idw.idwws.Ijselitensmen[] ijselitensmens;

    private idw.idwws.Ijtbcont ijtbcont;

    private idw.idwws.Ijtbtipoinf ijtbtipoinf;

    public Ijclassificcont() {
    }

    public Ijclassificcont(
           idw.idwws.IjclassificcontId id,
           idw.idwws.Ijselitensmen[] ijselitensmens,
           idw.idwws.Ijtbcont ijtbcont,
           idw.idwws.Ijtbtipoinf ijtbtipoinf) {
           this.id = id;
           this.ijselitensmens = ijselitensmens;
           this.ijtbcont = ijtbcont;
           this.ijtbtipoinf = ijtbtipoinf;
    }


    /**
     * Gets the id value for this Ijclassificcont.
     * 
     * @return id
     */
    public idw.idwws.IjclassificcontId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijclassificcont.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjclassificcontId id) {
        this.id = id;
    }


    /**
     * Gets the ijselitensmens value for this Ijclassificcont.
     * 
     * @return ijselitensmens
     */
    public idw.idwws.Ijselitensmen[] getIjselitensmens() {
        return ijselitensmens;
    }


    /**
     * Sets the ijselitensmens value for this Ijclassificcont.
     * 
     * @param ijselitensmens
     */
    public void setIjselitensmens(idw.idwws.Ijselitensmen[] ijselitensmens) {
        this.ijselitensmens = ijselitensmens;
    }

    public idw.idwws.Ijselitensmen getIjselitensmens(int i) {
        return this.ijselitensmens[i];
    }

    public void setIjselitensmens(int i, idw.idwws.Ijselitensmen _value) {
        this.ijselitensmens[i] = _value;
    }


    /**
     * Gets the ijtbcont value for this Ijclassificcont.
     * 
     * @return ijtbcont
     */
    public idw.idwws.Ijtbcont getIjtbcont() {
        return ijtbcont;
    }


    /**
     * Sets the ijtbcont value for this Ijclassificcont.
     * 
     * @param ijtbcont
     */
    public void setIjtbcont(idw.idwws.Ijtbcont ijtbcont) {
        this.ijtbcont = ijtbcont;
    }


    /**
     * Gets the ijtbtipoinf value for this Ijclassificcont.
     * 
     * @return ijtbtipoinf
     */
    public idw.idwws.Ijtbtipoinf getIjtbtipoinf() {
        return ijtbtipoinf;
    }


    /**
     * Sets the ijtbtipoinf value for this Ijclassificcont.
     * 
     * @param ijtbtipoinf
     */
    public void setIjtbtipoinf(idw.idwws.Ijtbtipoinf ijtbtipoinf) {
        this.ijtbtipoinf = ijtbtipoinf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijclassificcont)) return false;
        Ijclassificcont other = (Ijclassificcont) obj;
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
            ((this.ijselitensmens==null && other.getIjselitensmens()==null) || 
             (this.ijselitensmens!=null &&
              java.util.Arrays.equals(this.ijselitensmens, other.getIjselitensmens()))) &&
            ((this.ijtbcont==null && other.getIjtbcont()==null) || 
             (this.ijtbcont!=null &&
              this.ijtbcont.equals(other.getIjtbcont()))) &&
            ((this.ijtbtipoinf==null && other.getIjtbtipoinf()==null) || 
             (this.ijtbtipoinf!=null &&
              this.ijtbtipoinf.equals(other.getIjtbtipoinf())));
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
        if (getIjselitensmens() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjselitensmens());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjselitensmens(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbcont() != null) {
            _hashCode += getIjtbcont().hashCode();
        }
        if (getIjtbtipoinf() != null) {
            _hashCode += getIjtbtipoinf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijclassificcont.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificcont"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificcontId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselitensmens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselitensmens"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensmen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtipoinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtipoinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipoinf"));
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
