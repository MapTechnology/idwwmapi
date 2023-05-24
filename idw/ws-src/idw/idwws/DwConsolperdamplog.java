/**
 * DwConsolperdamplog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolperdamplog  extends idw.idwws.DwConsolperdamplogTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrPerdamp;

    private idw.idwws.DwConsolpempoco[] dwConsolpempocos;

    private idw.idwws.DwRap dwRap;

    private idw.idwws.DwTPerdamp dwTPerdamp;

    private long idConsolpemplog;

    private int msDthrperdamp;

    private idw.idwws.OmProduto omProduto;

    private java.math.BigDecimal qtAutoPerdamp;

    private java.math.BigDecimal qtManuPerdamp;

    public DwConsolperdamplog() {
    }

    public DwConsolperdamplog(
           java.util.Calendar dthrPerdamp,
           idw.idwws.DwConsolpempoco[] dwConsolpempocos,
           idw.idwws.DwRap dwRap,
           idw.idwws.DwTPerdamp dwTPerdamp,
           long idConsolpemplog,
           int msDthrperdamp,
           idw.idwws.OmProduto omProduto,
           java.math.BigDecimal qtAutoPerdamp,
           java.math.BigDecimal qtManuPerdamp) {
        this.dthrPerdamp = dthrPerdamp;
        this.dwConsolpempocos = dwConsolpempocos;
        this.dwRap = dwRap;
        this.dwTPerdamp = dwTPerdamp;
        this.idConsolpemplog = idConsolpemplog;
        this.msDthrperdamp = msDthrperdamp;
        this.omProduto = omProduto;
        this.qtAutoPerdamp = qtAutoPerdamp;
        this.qtManuPerdamp = qtManuPerdamp;
    }


    /**
     * Gets the dthrPerdamp value for this DwConsolperdamplog.
     * 
     * @return dthrPerdamp
     */
    public java.util.Calendar getDthrPerdamp() {
        return dthrPerdamp;
    }


    /**
     * Sets the dthrPerdamp value for this DwConsolperdamplog.
     * 
     * @param dthrPerdamp
     */
    public void setDthrPerdamp(java.util.Calendar dthrPerdamp) {
        this.dthrPerdamp = dthrPerdamp;
    }


    /**
     * Gets the dwConsolpempocos value for this DwConsolperdamplog.
     * 
     * @return dwConsolpempocos
     */
    public idw.idwws.DwConsolpempoco[] getDwConsolpempocos() {
        return dwConsolpempocos;
    }


    /**
     * Sets the dwConsolpempocos value for this DwConsolperdamplog.
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
     * Gets the dwRap value for this DwConsolperdamplog.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this DwConsolperdamplog.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the dwTPerdamp value for this DwConsolperdamplog.
     * 
     * @return dwTPerdamp
     */
    public idw.idwws.DwTPerdamp getDwTPerdamp() {
        return dwTPerdamp;
    }


    /**
     * Sets the dwTPerdamp value for this DwConsolperdamplog.
     * 
     * @param dwTPerdamp
     */
    public void setDwTPerdamp(idw.idwws.DwTPerdamp dwTPerdamp) {
        this.dwTPerdamp = dwTPerdamp;
    }


    /**
     * Gets the idConsolpemplog value for this DwConsolperdamplog.
     * 
     * @return idConsolpemplog
     */
    public long getIdConsolpemplog() {
        return idConsolpemplog;
    }


    /**
     * Sets the idConsolpemplog value for this DwConsolperdamplog.
     * 
     * @param idConsolpemplog
     */
    public void setIdConsolpemplog(long idConsolpemplog) {
        this.idConsolpemplog = idConsolpemplog;
    }


    /**
     * Gets the msDthrperdamp value for this DwConsolperdamplog.
     * 
     * @return msDthrperdamp
     */
    public int getMsDthrperdamp() {
        return msDthrperdamp;
    }


    /**
     * Sets the msDthrperdamp value for this DwConsolperdamplog.
     * 
     * @param msDthrperdamp
     */
    public void setMsDthrperdamp(int msDthrperdamp) {
        this.msDthrperdamp = msDthrperdamp;
    }


    /**
     * Gets the omProduto value for this DwConsolperdamplog.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwConsolperdamplog.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the qtAutoPerdamp value for this DwConsolperdamplog.
     * 
     * @return qtAutoPerdamp
     */
    public java.math.BigDecimal getQtAutoPerdamp() {
        return qtAutoPerdamp;
    }


    /**
     * Sets the qtAutoPerdamp value for this DwConsolperdamplog.
     * 
     * @param qtAutoPerdamp
     */
    public void setQtAutoPerdamp(java.math.BigDecimal qtAutoPerdamp) {
        this.qtAutoPerdamp = qtAutoPerdamp;
    }


    /**
     * Gets the qtManuPerdamp value for this DwConsolperdamplog.
     * 
     * @return qtManuPerdamp
     */
    public java.math.BigDecimal getQtManuPerdamp() {
        return qtManuPerdamp;
    }


    /**
     * Sets the qtManuPerdamp value for this DwConsolperdamplog.
     * 
     * @param qtManuPerdamp
     */
    public void setQtManuPerdamp(java.math.BigDecimal qtManuPerdamp) {
        this.qtManuPerdamp = qtManuPerdamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolperdamplog)) return false;
        DwConsolperdamplog other = (DwConsolperdamplog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrPerdamp==null && other.getDthrPerdamp()==null) || 
             (this.dthrPerdamp!=null &&
              this.dthrPerdamp.equals(other.getDthrPerdamp()))) &&
            ((this.dwConsolpempocos==null && other.getDwConsolpempocos()==null) || 
             (this.dwConsolpempocos!=null &&
              java.util.Arrays.equals(this.dwConsolpempocos, other.getDwConsolpempocos()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.dwTPerdamp==null && other.getDwTPerdamp()==null) || 
             (this.dwTPerdamp!=null &&
              this.dwTPerdamp.equals(other.getDwTPerdamp()))) &&
            this.idConsolpemplog == other.getIdConsolpemplog() &&
            this.msDthrperdamp == other.getMsDthrperdamp() &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
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
        if (getDthrPerdamp() != null) {
            _hashCode += getDthrPerdamp().hashCode();
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
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getDwTPerdamp() != null) {
            _hashCode += getDwTPerdamp().hashCode();
        }
        _hashCode += new Long(getIdConsolpemplog()).hashCode();
        _hashCode += getMsDthrperdamp();
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(DwConsolperdamplog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolperdamplog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrPerdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrPerdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("dwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTPerdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTPerdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTPerdamp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpemplog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpemplog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrperdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrperdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
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
