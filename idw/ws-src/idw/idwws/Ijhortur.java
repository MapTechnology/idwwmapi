/**
 * Ijhortur.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijhortur  implements java.io.Serializable {
    private java.util.Calendar hrfturno;

    private java.util.Calendar hriturno;

    private idw.idwws.IjhorturId id;

    private idw.idwws.Ijhorage ijhorage;

    private idw.idwws.Ijtbdse ijtbdse;

    private idw.idwws.Ijtbtur ijtbtur;

    public Ijhortur() {
    }

    public Ijhortur(
           java.util.Calendar hrfturno,
           java.util.Calendar hriturno,
           idw.idwws.IjhorturId id,
           idw.idwws.Ijhorage ijhorage,
           idw.idwws.Ijtbdse ijtbdse,
           idw.idwws.Ijtbtur ijtbtur) {
           this.hrfturno = hrfturno;
           this.hriturno = hriturno;
           this.id = id;
           this.ijhorage = ijhorage;
           this.ijtbdse = ijtbdse;
           this.ijtbtur = ijtbtur;
    }


    /**
     * Gets the hrfturno value for this Ijhortur.
     * 
     * @return hrfturno
     */
    public java.util.Calendar getHrfturno() {
        return hrfturno;
    }


    /**
     * Sets the hrfturno value for this Ijhortur.
     * 
     * @param hrfturno
     */
    public void setHrfturno(java.util.Calendar hrfturno) {
        this.hrfturno = hrfturno;
    }


    /**
     * Gets the hriturno value for this Ijhortur.
     * 
     * @return hriturno
     */
    public java.util.Calendar getHriturno() {
        return hriturno;
    }


    /**
     * Sets the hriturno value for this Ijhortur.
     * 
     * @param hriturno
     */
    public void setHriturno(java.util.Calendar hriturno) {
        this.hriturno = hriturno;
    }


    /**
     * Gets the id value for this Ijhortur.
     * 
     * @return id
     */
    public idw.idwws.IjhorturId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijhortur.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjhorturId id) {
        this.id = id;
    }


    /**
     * Gets the ijhorage value for this Ijhortur.
     * 
     * @return ijhorage
     */
    public idw.idwws.Ijhorage getIjhorage() {
        return ijhorage;
    }


    /**
     * Sets the ijhorage value for this Ijhortur.
     * 
     * @param ijhorage
     */
    public void setIjhorage(idw.idwws.Ijhorage ijhorage) {
        this.ijhorage = ijhorage;
    }


    /**
     * Gets the ijtbdse value for this Ijhortur.
     * 
     * @return ijtbdse
     */
    public idw.idwws.Ijtbdse getIjtbdse() {
        return ijtbdse;
    }


    /**
     * Sets the ijtbdse value for this Ijhortur.
     * 
     * @param ijtbdse
     */
    public void setIjtbdse(idw.idwws.Ijtbdse ijtbdse) {
        this.ijtbdse = ijtbdse;
    }


    /**
     * Gets the ijtbtur value for this Ijhortur.
     * 
     * @return ijtbtur
     */
    public idw.idwws.Ijtbtur getIjtbtur() {
        return ijtbtur;
    }


    /**
     * Sets the ijtbtur value for this Ijhortur.
     * 
     * @param ijtbtur
     */
    public void setIjtbtur(idw.idwws.Ijtbtur ijtbtur) {
        this.ijtbtur = ijtbtur;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijhortur)) return false;
        Ijhortur other = (Ijhortur) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hrfturno==null && other.getHrfturno()==null) || 
             (this.hrfturno!=null &&
              this.hrfturno.equals(other.getHrfturno()))) &&
            ((this.hriturno==null && other.getHriturno()==null) || 
             (this.hriturno!=null &&
              this.hriturno.equals(other.getHriturno()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijhorage==null && other.getIjhorage()==null) || 
             (this.ijhorage!=null &&
              this.ijhorage.equals(other.getIjhorage()))) &&
            ((this.ijtbdse==null && other.getIjtbdse()==null) || 
             (this.ijtbdse!=null &&
              this.ijtbdse.equals(other.getIjtbdse()))) &&
            ((this.ijtbtur==null && other.getIjtbtur()==null) || 
             (this.ijtbtur!=null &&
              this.ijtbtur.equals(other.getIjtbtur())));
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
        if (getHrfturno() != null) {
            _hashCode += getHrfturno().hashCode();
        }
        if (getHriturno() != null) {
            _hashCode += getHriturno().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjhorage() != null) {
            _hashCode += getIjhorage().hashCode();
        }
        if (getIjtbdse() != null) {
            _hashCode += getIjtbdse().hashCode();
        }
        if (getIjtbtur() != null) {
            _hashCode += getIjtbtur().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijhortur.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhortur"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrfturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrfturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hriturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hriturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhorturId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijhorage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijhorage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhorage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbdse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbdse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbdse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtur"));
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
