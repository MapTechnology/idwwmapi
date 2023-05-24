/**
 * Ijcfgandonagrup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcfgandonagrup  implements java.io.Serializable {
    private double idregistro;

    private idw.idwws.Ijcfgandmaqevt ijcfgandmaqevtByIdeventoandon;

    private idw.idwws.Ijcfgandmaqevt ijcfgandmaqevtByIdeventoandon2;

    public Ijcfgandonagrup() {
    }

    public Ijcfgandonagrup(
           double idregistro,
           idw.idwws.Ijcfgandmaqevt ijcfgandmaqevtByIdeventoandon,
           idw.idwws.Ijcfgandmaqevt ijcfgandmaqevtByIdeventoandon2) {
           this.idregistro = idregistro;
           this.ijcfgandmaqevtByIdeventoandon = ijcfgandmaqevtByIdeventoandon;
           this.ijcfgandmaqevtByIdeventoandon2 = ijcfgandmaqevtByIdeventoandon2;
    }


    /**
     * Gets the idregistro value for this Ijcfgandonagrup.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijcfgandonagrup.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijcfgandmaqevtByIdeventoandon value for this Ijcfgandonagrup.
     * 
     * @return ijcfgandmaqevtByIdeventoandon
     */
    public idw.idwws.Ijcfgandmaqevt getIjcfgandmaqevtByIdeventoandon() {
        return ijcfgandmaqevtByIdeventoandon;
    }


    /**
     * Sets the ijcfgandmaqevtByIdeventoandon value for this Ijcfgandonagrup.
     * 
     * @param ijcfgandmaqevtByIdeventoandon
     */
    public void setIjcfgandmaqevtByIdeventoandon(idw.idwws.Ijcfgandmaqevt ijcfgandmaqevtByIdeventoandon) {
        this.ijcfgandmaqevtByIdeventoandon = ijcfgandmaqevtByIdeventoandon;
    }


    /**
     * Gets the ijcfgandmaqevtByIdeventoandon2 value for this Ijcfgandonagrup.
     * 
     * @return ijcfgandmaqevtByIdeventoandon2
     */
    public idw.idwws.Ijcfgandmaqevt getIjcfgandmaqevtByIdeventoandon2() {
        return ijcfgandmaqevtByIdeventoandon2;
    }


    /**
     * Sets the ijcfgandmaqevtByIdeventoandon2 value for this Ijcfgandonagrup.
     * 
     * @param ijcfgandmaqevtByIdeventoandon2
     */
    public void setIjcfgandmaqevtByIdeventoandon2(idw.idwws.Ijcfgandmaqevt ijcfgandmaqevtByIdeventoandon2) {
        this.ijcfgandmaqevtByIdeventoandon2 = ijcfgandmaqevtByIdeventoandon2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcfgandonagrup)) return false;
        Ijcfgandonagrup other = (Ijcfgandonagrup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregistro == other.getIdregistro() &&
            ((this.ijcfgandmaqevtByIdeventoandon==null && other.getIjcfgandmaqevtByIdeventoandon()==null) || 
             (this.ijcfgandmaqevtByIdeventoandon!=null &&
              this.ijcfgandmaqevtByIdeventoandon.equals(other.getIjcfgandmaqevtByIdeventoandon()))) &&
            ((this.ijcfgandmaqevtByIdeventoandon2==null && other.getIjcfgandmaqevtByIdeventoandon2()==null) || 
             (this.ijcfgandmaqevtByIdeventoandon2!=null &&
              this.ijcfgandmaqevtByIdeventoandon2.equals(other.getIjcfgandmaqevtByIdeventoandon2())));
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
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjcfgandmaqevtByIdeventoandon() != null) {
            _hashCode += getIjcfgandmaqevtByIdeventoandon().hashCode();
        }
        if (getIjcfgandmaqevtByIdeventoandon2() != null) {
            _hashCode += getIjcfgandmaqevtByIdeventoandon2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcfgandonagrup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandonagrup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandmaqevtByIdeventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandmaqevtByIdeventoandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandmaqevtByIdeventoandon2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandmaqevtByIdeventoandon2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevt"));
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
