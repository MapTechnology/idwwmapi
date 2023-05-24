/**
 * Ijcelxestagios.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcelxestagios  implements java.io.Serializable {
    private idw.idwws.IjcelxestagiosId id;

    private idw.idwws.Ijcelxmaq[] ijcelxmaqs;

    private idw.idwws.Ijtbcelula ijtbcelula;

    private double tampulmaomax;

    private double tampulmaomin;

    private double tampulmaopadrao;

    public Ijcelxestagios() {
    }

    public Ijcelxestagios(
           idw.idwws.IjcelxestagiosId id,
           idw.idwws.Ijcelxmaq[] ijcelxmaqs,
           idw.idwws.Ijtbcelula ijtbcelula,
           double tampulmaomax,
           double tampulmaomin,
           double tampulmaopadrao) {
           this.id = id;
           this.ijcelxmaqs = ijcelxmaqs;
           this.ijtbcelula = ijtbcelula;
           this.tampulmaomax = tampulmaomax;
           this.tampulmaomin = tampulmaomin;
           this.tampulmaopadrao = tampulmaopadrao;
    }


    /**
     * Gets the id value for this Ijcelxestagios.
     * 
     * @return id
     */
    public idw.idwws.IjcelxestagiosId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcelxestagios.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcelxestagiosId id) {
        this.id = id;
    }


    /**
     * Gets the ijcelxmaqs value for this Ijcelxestagios.
     * 
     * @return ijcelxmaqs
     */
    public idw.idwws.Ijcelxmaq[] getIjcelxmaqs() {
        return ijcelxmaqs;
    }


    /**
     * Sets the ijcelxmaqs value for this Ijcelxestagios.
     * 
     * @param ijcelxmaqs
     */
    public void setIjcelxmaqs(idw.idwws.Ijcelxmaq[] ijcelxmaqs) {
        this.ijcelxmaqs = ijcelxmaqs;
    }

    public idw.idwws.Ijcelxmaq getIjcelxmaqs(int i) {
        return this.ijcelxmaqs[i];
    }

    public void setIjcelxmaqs(int i, idw.idwws.Ijcelxmaq _value) {
        this.ijcelxmaqs[i] = _value;
    }


    /**
     * Gets the ijtbcelula value for this Ijcelxestagios.
     * 
     * @return ijtbcelula
     */
    public idw.idwws.Ijtbcelula getIjtbcelula() {
        return ijtbcelula;
    }


    /**
     * Sets the ijtbcelula value for this Ijcelxestagios.
     * 
     * @param ijtbcelula
     */
    public void setIjtbcelula(idw.idwws.Ijtbcelula ijtbcelula) {
        this.ijtbcelula = ijtbcelula;
    }


    /**
     * Gets the tampulmaomax value for this Ijcelxestagios.
     * 
     * @return tampulmaomax
     */
    public double getTampulmaomax() {
        return tampulmaomax;
    }


    /**
     * Sets the tampulmaomax value for this Ijcelxestagios.
     * 
     * @param tampulmaomax
     */
    public void setTampulmaomax(double tampulmaomax) {
        this.tampulmaomax = tampulmaomax;
    }


    /**
     * Gets the tampulmaomin value for this Ijcelxestagios.
     * 
     * @return tampulmaomin
     */
    public double getTampulmaomin() {
        return tampulmaomin;
    }


    /**
     * Sets the tampulmaomin value for this Ijcelxestagios.
     * 
     * @param tampulmaomin
     */
    public void setTampulmaomin(double tampulmaomin) {
        this.tampulmaomin = tampulmaomin;
    }


    /**
     * Gets the tampulmaopadrao value for this Ijcelxestagios.
     * 
     * @return tampulmaopadrao
     */
    public double getTampulmaopadrao() {
        return tampulmaopadrao;
    }


    /**
     * Sets the tampulmaopadrao value for this Ijcelxestagios.
     * 
     * @param tampulmaopadrao
     */
    public void setTampulmaopadrao(double tampulmaopadrao) {
        this.tampulmaopadrao = tampulmaopadrao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcelxestagios)) return false;
        Ijcelxestagios other = (Ijcelxestagios) obj;
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
            ((this.ijcelxmaqs==null && other.getIjcelxmaqs()==null) || 
             (this.ijcelxmaqs!=null &&
              java.util.Arrays.equals(this.ijcelxmaqs, other.getIjcelxmaqs()))) &&
            ((this.ijtbcelula==null && other.getIjtbcelula()==null) || 
             (this.ijtbcelula!=null &&
              this.ijtbcelula.equals(other.getIjtbcelula()))) &&
            this.tampulmaomax == other.getTampulmaomax() &&
            this.tampulmaomin == other.getTampulmaomin() &&
            this.tampulmaopadrao == other.getTampulmaopadrao();
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
        if (getIjcelxmaqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcelxmaqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcelxmaqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbcelula() != null) {
            _hashCode += getIjtbcelula().hashCode();
        }
        _hashCode += new Double(getTampulmaomax()).hashCode();
        _hashCode += new Double(getTampulmaomin()).hashCode();
        _hashCode += new Double(getTampulmaopadrao()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcelxestagios.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxestagios"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxestagiosId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcelxmaqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcelxmaqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcelxmaq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcelula"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tampulmaomax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tampulmaomax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tampulmaomin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tampulmaomin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tampulmaopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tampulmaopadrao"));
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
