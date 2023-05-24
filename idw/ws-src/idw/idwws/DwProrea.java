/**
 * DwProrea.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwProrea  extends idw.idwws.DwProreaTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsolid dwConsolid;

    private idw.idwws.DwProcedimento dwProcedimento;

    private idw.idwws.DwProreaativ[] dwProreaativs;

    private java.lang.Long idProrea;

    private java.lang.Byte stProrea;

    public DwProrea() {
    }

    public DwProrea(
           idw.idwws.DwConsolid dwConsolid,
           idw.idwws.DwProcedimento dwProcedimento,
           idw.idwws.DwProreaativ[] dwProreaativs,
           java.lang.Long idProrea,
           java.lang.Byte stProrea) {
        this.dwConsolid = dwConsolid;
        this.dwProcedimento = dwProcedimento;
        this.dwProreaativs = dwProreaativs;
        this.idProrea = idProrea;
        this.stProrea = stProrea;
    }


    /**
     * Gets the dwConsolid value for this DwProrea.
     * 
     * @return dwConsolid
     */
    public idw.idwws.DwConsolid getDwConsolid() {
        return dwConsolid;
    }


    /**
     * Sets the dwConsolid value for this DwProrea.
     * 
     * @param dwConsolid
     */
    public void setDwConsolid(idw.idwws.DwConsolid dwConsolid) {
        this.dwConsolid = dwConsolid;
    }


    /**
     * Gets the dwProcedimento value for this DwProrea.
     * 
     * @return dwProcedimento
     */
    public idw.idwws.DwProcedimento getDwProcedimento() {
        return dwProcedimento;
    }


    /**
     * Sets the dwProcedimento value for this DwProrea.
     * 
     * @param dwProcedimento
     */
    public void setDwProcedimento(idw.idwws.DwProcedimento dwProcedimento) {
        this.dwProcedimento = dwProcedimento;
    }


    /**
     * Gets the dwProreaativs value for this DwProrea.
     * 
     * @return dwProreaativs
     */
    public idw.idwws.DwProreaativ[] getDwProreaativs() {
        return dwProreaativs;
    }


    /**
     * Sets the dwProreaativs value for this DwProrea.
     * 
     * @param dwProreaativs
     */
    public void setDwProreaativs(idw.idwws.DwProreaativ[] dwProreaativs) {
        this.dwProreaativs = dwProreaativs;
    }

    public idw.idwws.DwProreaativ getDwProreaativs(int i) {
        return this.dwProreaativs[i];
    }

    public void setDwProreaativs(int i, idw.idwws.DwProreaativ _value) {
        this.dwProreaativs[i] = _value;
    }


    /**
     * Gets the idProrea value for this DwProrea.
     * 
     * @return idProrea
     */
    public java.lang.Long getIdProrea() {
        return idProrea;
    }


    /**
     * Sets the idProrea value for this DwProrea.
     * 
     * @param idProrea
     */
    public void setIdProrea(java.lang.Long idProrea) {
        this.idProrea = idProrea;
    }


    /**
     * Gets the stProrea value for this DwProrea.
     * 
     * @return stProrea
     */
    public java.lang.Byte getStProrea() {
        return stProrea;
    }


    /**
     * Sets the stProrea value for this DwProrea.
     * 
     * @param stProrea
     */
    public void setStProrea(java.lang.Byte stProrea) {
        this.stProrea = stProrea;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwProrea)) return false;
        DwProrea other = (DwProrea) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwConsolid==null && other.getDwConsolid()==null) || 
             (this.dwConsolid!=null &&
              this.dwConsolid.equals(other.getDwConsolid()))) &&
            ((this.dwProcedimento==null && other.getDwProcedimento()==null) || 
             (this.dwProcedimento!=null &&
              this.dwProcedimento.equals(other.getDwProcedimento()))) &&
            ((this.dwProreaativs==null && other.getDwProreaativs()==null) || 
             (this.dwProreaativs!=null &&
              java.util.Arrays.equals(this.dwProreaativs, other.getDwProreaativs()))) &&
            ((this.idProrea==null && other.getIdProrea()==null) || 
             (this.idProrea!=null &&
              this.idProrea.equals(other.getIdProrea()))) &&
            ((this.stProrea==null && other.getStProrea()==null) || 
             (this.stProrea!=null &&
              this.stProrea.equals(other.getStProrea())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDwConsolid() != null) {
            _hashCode += getDwConsolid().hashCode();
        }
        if (getDwProcedimento() != null) {
            _hashCode += getDwProcedimento().hashCode();
        }
        if (getDwProreaativs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProreaativs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProreaativs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdProrea() != null) {
            _hashCode += getIdProrea().hashCode();
        }
        if (getStProrea() != null) {
            _hashCode += getStProrea().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwProrea.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProrea"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcedimento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProreaativs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProreaativs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProreaativ"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProrea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProrea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stProrea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stProrea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
