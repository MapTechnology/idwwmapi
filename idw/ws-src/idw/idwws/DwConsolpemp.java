/**
 * DwConsolpemp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpemp  extends idw.idwws.DwConsolpempTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsol dwConsol;

    private idw.idwws.DwConsolpempoco[] dwConsolpempocos;

    private idw.idwws.DwTPerdamp dwTPerdamp;

    private long idConsolpemp;

    private java.math.BigDecimal qtAutoPerdamp;

    private java.math.BigDecimal qtManuPerdamp;

    public DwConsolpemp() {
    }

    public DwConsolpemp(
           idw.idwws.DwConsol dwConsol,
           idw.idwws.DwConsolpempoco[] dwConsolpempocos,
           idw.idwws.DwTPerdamp dwTPerdamp,
           long idConsolpemp,
           java.math.BigDecimal qtAutoPerdamp,
           java.math.BigDecimal qtManuPerdamp) {
        this.dwConsol = dwConsol;
        this.dwConsolpempocos = dwConsolpempocos;
        this.dwTPerdamp = dwTPerdamp;
        this.idConsolpemp = idConsolpemp;
        this.qtAutoPerdamp = qtAutoPerdamp;
        this.qtManuPerdamp = qtManuPerdamp;
    }


    /**
     * Gets the dwConsol value for this DwConsolpemp.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsolpemp.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the dwConsolpempocos value for this DwConsolpemp.
     * 
     * @return dwConsolpempocos
     */
    public idw.idwws.DwConsolpempoco[] getDwConsolpempocos() {
        return dwConsolpempocos;
    }


    /**
     * Sets the dwConsolpempocos value for this DwConsolpemp.
     * 
     * @param dwConsolpempocos
     */
    public void setDwConsolpempocos(idw.idwws.DwConsolpempoco[] dwConsolpempocos) {
        this.dwConsolpempocos = dwConsolpempocos;
    }

    public idw.idwws.DwConsolpempoco getDwConsolpempocos(int i) {
        return this.dwConsolpempocos[i];
    }

    public void setDwConsolpempocos(int i, idw.idwws.DwConsolpempoco _value) {
        this.dwConsolpempocos[i] = _value;
    }


    /**
     * Gets the dwTPerdamp value for this DwConsolpemp.
     * 
     * @return dwTPerdamp
     */
    public idw.idwws.DwTPerdamp getDwTPerdamp() {
        return dwTPerdamp;
    }


    /**
     * Sets the dwTPerdamp value for this DwConsolpemp.
     * 
     * @param dwTPerdamp
     */
    public void setDwTPerdamp(idw.idwws.DwTPerdamp dwTPerdamp) {
        this.dwTPerdamp = dwTPerdamp;
    }


    /**
     * Gets the idConsolpemp value for this DwConsolpemp.
     * 
     * @return idConsolpemp
     */
    public long getIdConsolpemp() {
        return idConsolpemp;
    }


    /**
     * Sets the idConsolpemp value for this DwConsolpemp.
     * 
     * @param idConsolpemp
     */
    public void setIdConsolpemp(long idConsolpemp) {
        this.idConsolpemp = idConsolpemp;
    }


    /**
     * Gets the qtAutoPerdamp value for this DwConsolpemp.
     * 
     * @return qtAutoPerdamp
     */
    public java.math.BigDecimal getQtAutoPerdamp() {
        return qtAutoPerdamp;
    }


    /**
     * Sets the qtAutoPerdamp value for this DwConsolpemp.
     * 
     * @param qtAutoPerdamp
     */
    public void setQtAutoPerdamp(java.math.BigDecimal qtAutoPerdamp) {
        this.qtAutoPerdamp = qtAutoPerdamp;
    }


    /**
     * Gets the qtManuPerdamp value for this DwConsolpemp.
     * 
     * @return qtManuPerdamp
     */
    public java.math.BigDecimal getQtManuPerdamp() {
        return qtManuPerdamp;
    }


    /**
     * Sets the qtManuPerdamp value for this DwConsolpemp.
     * 
     * @param qtManuPerdamp
     */
    public void setQtManuPerdamp(java.math.BigDecimal qtManuPerdamp) {
        this.qtManuPerdamp = qtManuPerdamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpemp)) return false;
        DwConsolpemp other = (DwConsolpemp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwConsol==null && other.getDwConsol()==null) || 
             (this.dwConsol!=null &&
              this.dwConsol.equals(other.getDwConsol()))) &&
            ((this.dwConsolpempocos==null && other.getDwConsolpempocos()==null) || 
             (this.dwConsolpempocos!=null &&
              java.util.Arrays.equals(this.dwConsolpempocos, other.getDwConsolpempocos()))) &&
            ((this.dwTPerdamp==null && other.getDwTPerdamp()==null) || 
             (this.dwTPerdamp!=null &&
              this.dwTPerdamp.equals(other.getDwTPerdamp()))) &&
            this.idConsolpemp == other.getIdConsolpemp() &&
            ((this.qtAutoPerdamp==null && other.getQtAutoPerdamp()==null) || 
             (this.qtAutoPerdamp!=null &&
              this.qtAutoPerdamp.equals(other.getQtAutoPerdamp()))) &&
            ((this.qtManuPerdamp==null && other.getQtManuPerdamp()==null) || 
             (this.qtManuPerdamp!=null &&
              this.qtManuPerdamp.equals(other.getQtManuPerdamp())));
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
        if (getDwConsol() != null) {
            _hashCode += getDwConsol().hashCode();
        }
        if (getDwConsolpempocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpempocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpempocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTPerdamp() != null) {
            _hashCode += getDwTPerdamp().hashCode();
        }
        _hashCode += new Long(getIdConsolpemp()).hashCode();
        if (getQtAutoPerdamp() != null) {
            _hashCode += getQtAutoPerdamp().hashCode();
        }
        if (getQtManuPerdamp() != null) {
            _hashCode += getQtManuPerdamp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpemp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpemp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpempocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpempocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpempoco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTPerdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTPerdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTPerdamp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpemp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoPerdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoPerdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuPerdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuPerdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
