/**
 * DwConsolmooco.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolmooco  implements java.io.Serializable {
    private java.util.Calendar dthrFlogin;

    private java.util.Calendar dthrIlogin;

    private idw.idwws.DwConsolmo dwConsolmo;

    private idw.idwws.DwConsolmolog dwConsolmolog;

    private long idConsolmooco;

    private java.lang.Boolean isContinuaproximoperiodo;

    private java.lang.Byte msDthrflogin;

    private java.lang.Byte msDthrilogin;

    public DwConsolmooco() {
    }

    public DwConsolmooco(
           java.util.Calendar dthrFlogin,
           java.util.Calendar dthrIlogin,
           idw.idwws.DwConsolmo dwConsolmo,
           idw.idwws.DwConsolmolog dwConsolmolog,
           long idConsolmooco,
           java.lang.Boolean isContinuaproximoperiodo,
           java.lang.Byte msDthrflogin,
           java.lang.Byte msDthrilogin) {
           this.dthrFlogin = dthrFlogin;
           this.dthrIlogin = dthrIlogin;
           this.dwConsolmo = dwConsolmo;
           this.dwConsolmolog = dwConsolmolog;
           this.idConsolmooco = idConsolmooco;
           this.isContinuaproximoperiodo = isContinuaproximoperiodo;
           this.msDthrflogin = msDthrflogin;
           this.msDthrilogin = msDthrilogin;
    }


    /**
     * Gets the dthrFlogin value for this DwConsolmooco.
     * 
     * @return dthrFlogin
     */
    public java.util.Calendar getDthrFlogin() {
        return dthrFlogin;
    }


    /**
     * Sets the dthrFlogin value for this DwConsolmooco.
     * 
     * @param dthrFlogin
     */
    public void setDthrFlogin(java.util.Calendar dthrFlogin) {
        this.dthrFlogin = dthrFlogin;
    }


    /**
     * Gets the dthrIlogin value for this DwConsolmooco.
     * 
     * @return dthrIlogin
     */
    public java.util.Calendar getDthrIlogin() {
        return dthrIlogin;
    }


    /**
     * Sets the dthrIlogin value for this DwConsolmooco.
     * 
     * @param dthrIlogin
     */
    public void setDthrIlogin(java.util.Calendar dthrIlogin) {
        this.dthrIlogin = dthrIlogin;
    }


    /**
     * Gets the dwConsolmo value for this DwConsolmooco.
     * 
     * @return dwConsolmo
     */
    public idw.idwws.DwConsolmo getDwConsolmo() {
        return dwConsolmo;
    }


    /**
     * Sets the dwConsolmo value for this DwConsolmooco.
     * 
     * @param dwConsolmo
     */
    public void setDwConsolmo(idw.idwws.DwConsolmo dwConsolmo) {
        this.dwConsolmo = dwConsolmo;
    }


    /**
     * Gets the dwConsolmolog value for this DwConsolmooco.
     * 
     * @return dwConsolmolog
     */
    public idw.idwws.DwConsolmolog getDwConsolmolog() {
        return dwConsolmolog;
    }


    /**
     * Sets the dwConsolmolog value for this DwConsolmooco.
     * 
     * @param dwConsolmolog
     */
    public void setDwConsolmolog(idw.idwws.DwConsolmolog dwConsolmolog) {
        this.dwConsolmolog = dwConsolmolog;
    }


    /**
     * Gets the idConsolmooco value for this DwConsolmooco.
     * 
     * @return idConsolmooco
     */
    public long getIdConsolmooco() {
        return idConsolmooco;
    }


    /**
     * Sets the idConsolmooco value for this DwConsolmooco.
     * 
     * @param idConsolmooco
     */
    public void setIdConsolmooco(long idConsolmooco) {
        this.idConsolmooco = idConsolmooco;
    }


    /**
     * Gets the isContinuaproximoperiodo value for this DwConsolmooco.
     * 
     * @return isContinuaproximoperiodo
     */
    public java.lang.Boolean getIsContinuaproximoperiodo() {
        return isContinuaproximoperiodo;
    }


    /**
     * Sets the isContinuaproximoperiodo value for this DwConsolmooco.
     * 
     * @param isContinuaproximoperiodo
     */
    public void setIsContinuaproximoperiodo(java.lang.Boolean isContinuaproximoperiodo) {
        this.isContinuaproximoperiodo = isContinuaproximoperiodo;
    }


    /**
     * Gets the msDthrflogin value for this DwConsolmooco.
     * 
     * @return msDthrflogin
     */
    public java.lang.Byte getMsDthrflogin() {
        return msDthrflogin;
    }


    /**
     * Sets the msDthrflogin value for this DwConsolmooco.
     * 
     * @param msDthrflogin
     */
    public void setMsDthrflogin(java.lang.Byte msDthrflogin) {
        this.msDthrflogin = msDthrflogin;
    }


    /**
     * Gets the msDthrilogin value for this DwConsolmooco.
     * 
     * @return msDthrilogin
     */
    public java.lang.Byte getMsDthrilogin() {
        return msDthrilogin;
    }


    /**
     * Sets the msDthrilogin value for this DwConsolmooco.
     * 
     * @param msDthrilogin
     */
    public void setMsDthrilogin(java.lang.Byte msDthrilogin) {
        this.msDthrilogin = msDthrilogin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolmooco)) return false;
        DwConsolmooco other = (DwConsolmooco) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrFlogin==null && other.getDthrFlogin()==null) || 
             (this.dthrFlogin!=null &&
              this.dthrFlogin.equals(other.getDthrFlogin()))) &&
            ((this.dthrIlogin==null && other.getDthrIlogin()==null) || 
             (this.dthrIlogin!=null &&
              this.dthrIlogin.equals(other.getDthrIlogin()))) &&
            ((this.dwConsolmo==null && other.getDwConsolmo()==null) || 
             (this.dwConsolmo!=null &&
              this.dwConsolmo.equals(other.getDwConsolmo()))) &&
            ((this.dwConsolmolog==null && other.getDwConsolmolog()==null) || 
             (this.dwConsolmolog!=null &&
              this.dwConsolmolog.equals(other.getDwConsolmolog()))) &&
            this.idConsolmooco == other.getIdConsolmooco() &&
            ((this.isContinuaproximoperiodo==null && other.getIsContinuaproximoperiodo()==null) || 
             (this.isContinuaproximoperiodo!=null &&
              this.isContinuaproximoperiodo.equals(other.getIsContinuaproximoperiodo()))) &&
            ((this.msDthrflogin==null && other.getMsDthrflogin()==null) || 
             (this.msDthrflogin!=null &&
              this.msDthrflogin.equals(other.getMsDthrflogin()))) &&
            ((this.msDthrilogin==null && other.getMsDthrilogin()==null) || 
             (this.msDthrilogin!=null &&
              this.msDthrilogin.equals(other.getMsDthrilogin())));
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
        if (getDthrFlogin() != null) {
            _hashCode += getDthrFlogin().hashCode();
        }
        if (getDthrIlogin() != null) {
            _hashCode += getDthrIlogin().hashCode();
        }
        if (getDwConsolmo() != null) {
            _hashCode += getDwConsolmo().hashCode();
        }
        if (getDwConsolmolog() != null) {
            _hashCode += getDwConsolmolog().hashCode();
        }
        _hashCode += new Long(getIdConsolmooco()).hashCode();
        if (getIsContinuaproximoperiodo() != null) {
            _hashCode += getIsContinuaproximoperiodo().hashCode();
        }
        if (getMsDthrflogin() != null) {
            _hashCode += getMsDthrflogin().hashCode();
        }
        if (getMsDthrilogin() != null) {
            _hashCode += getMsDthrilogin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolmooco.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmooco"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmolog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmolog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmolog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolmooco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolmooco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isContinuaproximoperiodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isContinuaproximoperiodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrflogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrflogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrilogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrilogin"));
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
