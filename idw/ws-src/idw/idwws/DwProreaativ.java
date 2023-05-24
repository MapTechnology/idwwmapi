/**
 * DwProreaativ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwProreaativ  extends idw.idwws.DwProreaativTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFim;

    private java.util.Calendar dthrInicio;

    private idw.idwws.DwProcativ dwProcativ;

    private idw.idwws.DwProrea dwProrea;

    private idw.idwws.DwProreaativobs[] dwProreaativobses;

    private java.lang.Long idProreaativ;

    private idw.idwws.OmUsr omUsr;

    private java.lang.Byte stProreaativ;

    public DwProreaativ() {
    }

    public DwProreaativ(
           java.util.Calendar dthrFim,
           java.util.Calendar dthrInicio,
           idw.idwws.DwProcativ dwProcativ,
           idw.idwws.DwProrea dwProrea,
           idw.idwws.DwProreaativobs[] dwProreaativobses,
           java.lang.Long idProreaativ,
           idw.idwws.OmUsr omUsr,
           java.lang.Byte stProreaativ) {
        this.dthrFim = dthrFim;
        this.dthrInicio = dthrInicio;
        this.dwProcativ = dwProcativ;
        this.dwProrea = dwProrea;
        this.dwProreaativobses = dwProreaativobses;
        this.idProreaativ = idProreaativ;
        this.omUsr = omUsr;
        this.stProreaativ = stProreaativ;
    }


    /**
     * Gets the dthrFim value for this DwProreaativ.
     * 
     * @return dthrFim
     */
    public java.util.Calendar getDthrFim() {
        return dthrFim;
    }


    /**
     * Sets the dthrFim value for this DwProreaativ.
     * 
     * @param dthrFim
     */
    public void setDthrFim(java.util.Calendar dthrFim) {
        this.dthrFim = dthrFim;
    }


    /**
     * Gets the dthrInicio value for this DwProreaativ.
     * 
     * @return dthrInicio
     */
    public java.util.Calendar getDthrInicio() {
        return dthrInicio;
    }


    /**
     * Sets the dthrInicio value for this DwProreaativ.
     * 
     * @param dthrInicio
     */
    public void setDthrInicio(java.util.Calendar dthrInicio) {
        this.dthrInicio = dthrInicio;
    }


    /**
     * Gets the dwProcativ value for this DwProreaativ.
     * 
     * @return dwProcativ
     */
    public idw.idwws.DwProcativ getDwProcativ() {
        return dwProcativ;
    }


    /**
     * Sets the dwProcativ value for this DwProreaativ.
     * 
     * @param dwProcativ
     */
    public void setDwProcativ(idw.idwws.DwProcativ dwProcativ) {
        this.dwProcativ = dwProcativ;
    }


    /**
     * Gets the dwProrea value for this DwProreaativ.
     * 
     * @return dwProrea
     */
    public idw.idwws.DwProrea getDwProrea() {
        return dwProrea;
    }


    /**
     * Sets the dwProrea value for this DwProreaativ.
     * 
     * @param dwProrea
     */
    public void setDwProrea(idw.idwws.DwProrea dwProrea) {
        this.dwProrea = dwProrea;
    }


    /**
     * Gets the dwProreaativobses value for this DwProreaativ.
     * 
     * @return dwProreaativobses
     */
    public idw.idwws.DwProreaativobs[] getDwProreaativobses() {
        return dwProreaativobses;
    }


    /**
     * Sets the dwProreaativobses value for this DwProreaativ.
     * 
     * @param dwProreaativobses
     */
    public void setDwProreaativobses(idw.idwws.DwProreaativobs[] dwProreaativobses) {
        this.dwProreaativobses = dwProreaativobses;
    }

    public idw.idwws.DwProreaativobs getDwProreaativobses(int i) {
        return this.dwProreaativobses[i];
    }

    public void setDwProreaativobses(int i, idw.idwws.DwProreaativobs _value) {
        this.dwProreaativobses[i] = _value;
    }


    /**
     * Gets the idProreaativ value for this DwProreaativ.
     * 
     * @return idProreaativ
     */
    public java.lang.Long getIdProreaativ() {
        return idProreaativ;
    }


    /**
     * Sets the idProreaativ value for this DwProreaativ.
     * 
     * @param idProreaativ
     */
    public void setIdProreaativ(java.lang.Long idProreaativ) {
        this.idProreaativ = idProreaativ;
    }


    /**
     * Gets the omUsr value for this DwProreaativ.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this DwProreaativ.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the stProreaativ value for this DwProreaativ.
     * 
     * @return stProreaativ
     */
    public java.lang.Byte getStProreaativ() {
        return stProreaativ;
    }


    /**
     * Sets the stProreaativ value for this DwProreaativ.
     * 
     * @param stProreaativ
     */
    public void setStProreaativ(java.lang.Byte stProreaativ) {
        this.stProreaativ = stProreaativ;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwProreaativ)) return false;
        DwProreaativ other = (DwProreaativ) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFim==null && other.getDthrFim()==null) || 
             (this.dthrFim!=null &&
              this.dthrFim.equals(other.getDthrFim()))) &&
            ((this.dthrInicio==null && other.getDthrInicio()==null) || 
             (this.dthrInicio!=null &&
              this.dthrInicio.equals(other.getDthrInicio()))) &&
            ((this.dwProcativ==null && other.getDwProcativ()==null) || 
             (this.dwProcativ!=null &&
              this.dwProcativ.equals(other.getDwProcativ()))) &&
            ((this.dwProrea==null && other.getDwProrea()==null) || 
             (this.dwProrea!=null &&
              this.dwProrea.equals(other.getDwProrea()))) &&
            ((this.dwProreaativobses==null && other.getDwProreaativobses()==null) || 
             (this.dwProreaativobses!=null &&
              java.util.Arrays.equals(this.dwProreaativobses, other.getDwProreaativobses()))) &&
            ((this.idProreaativ==null && other.getIdProreaativ()==null) || 
             (this.idProreaativ!=null &&
              this.idProreaativ.equals(other.getIdProreaativ()))) &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.stProreaativ==null && other.getStProreaativ()==null) || 
             (this.stProreaativ!=null &&
              this.stProreaativ.equals(other.getStProreaativ())));
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
        if (getDthrFim() != null) {
            _hashCode += getDthrFim().hashCode();
        }
        if (getDthrInicio() != null) {
            _hashCode += getDthrInicio().hashCode();
        }
        if (getDwProcativ() != null) {
            _hashCode += getDwProcativ().hashCode();
        }
        if (getDwProrea() != null) {
            _hashCode += getDwProrea().hashCode();
        }
        if (getDwProreaativobses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProreaativobses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProreaativobses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdProreaativ() != null) {
            _hashCode += getIdProreaativ().hashCode();
        }
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getStProreaativ() != null) {
            _hashCode += getStProreaativ().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwProreaativ.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProreaativ"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProcativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcativ"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProrea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProrea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProrea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProreaativobses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProreaativobses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProreaativobs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProreaativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProreaativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stProreaativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stProreaativ"));
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
