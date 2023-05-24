/**
 * DwConsolpaoco.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpaoco  extends idw.idwws.DwConsolpaocoTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFparada;

    private java.util.Calendar dthrFparadaAb;

    private java.util.Calendar dthrIparada;

    private idw.idwws.DwConsolpa dwConsolpa;

    private idw.idwws.DwConsolpalog dwConsolpalog;

    private long idConsolpaoco;

    private java.math.BigDecimal isContinuaproximoperiodo;

    private java.math.BigDecimal msDthrfparada;

    private java.math.BigDecimal msDthrfparadaAb;

    private java.math.BigDecimal msDthriparada;

    public DwConsolpaoco() {
    }

    public DwConsolpaoco(
           java.util.Calendar dthrFparada,
           java.util.Calendar dthrFparadaAb,
           java.util.Calendar dthrIparada,
           idw.idwws.DwConsolpa dwConsolpa,
           idw.idwws.DwConsolpalog dwConsolpalog,
           long idConsolpaoco,
           java.math.BigDecimal isContinuaproximoperiodo,
           java.math.BigDecimal msDthrfparada,
           java.math.BigDecimal msDthrfparadaAb,
           java.math.BigDecimal msDthriparada) {
        this.dthrFparada = dthrFparada;
        this.dthrFparadaAb = dthrFparadaAb;
        this.dthrIparada = dthrIparada;
        this.dwConsolpa = dwConsolpa;
        this.dwConsolpalog = dwConsolpalog;
        this.idConsolpaoco = idConsolpaoco;
        this.isContinuaproximoperiodo = isContinuaproximoperiodo;
        this.msDthrfparada = msDthrfparada;
        this.msDthrfparadaAb = msDthrfparadaAb;
        this.msDthriparada = msDthriparada;
    }


    /**
     * Gets the dthrFparada value for this DwConsolpaoco.
     * 
     * @return dthrFparada
     */
    public java.util.Calendar getDthrFparada() {
        return dthrFparada;
    }


    /**
     * Sets the dthrFparada value for this DwConsolpaoco.
     * 
     * @param dthrFparada
     */
    public void setDthrFparada(java.util.Calendar dthrFparada) {
        this.dthrFparada = dthrFparada;
    }


    /**
     * Gets the dthrFparadaAb value for this DwConsolpaoco.
     * 
     * @return dthrFparadaAb
     */
    public java.util.Calendar getDthrFparadaAb() {
        return dthrFparadaAb;
    }


    /**
     * Sets the dthrFparadaAb value for this DwConsolpaoco.
     * 
     * @param dthrFparadaAb
     */
    public void setDthrFparadaAb(java.util.Calendar dthrFparadaAb) {
        this.dthrFparadaAb = dthrFparadaAb;
    }


    /**
     * Gets the dthrIparada value for this DwConsolpaoco.
     * 
     * @return dthrIparada
     */
    public java.util.Calendar getDthrIparada() {
        return dthrIparada;
    }


    /**
     * Sets the dthrIparada value for this DwConsolpaoco.
     * 
     * @param dthrIparada
     */
    public void setDthrIparada(java.util.Calendar dthrIparada) {
        this.dthrIparada = dthrIparada;
    }


    /**
     * Gets the dwConsolpa value for this DwConsolpaoco.
     * 
     * @return dwConsolpa
     */
    public idw.idwws.DwConsolpa getDwConsolpa() {
        return dwConsolpa;
    }


    /**
     * Sets the dwConsolpa value for this DwConsolpaoco.
     * 
     * @param dwConsolpa
     */
    public void setDwConsolpa(idw.idwws.DwConsolpa dwConsolpa) {
        this.dwConsolpa = dwConsolpa;
    }


    /**
     * Gets the dwConsolpalog value for this DwConsolpaoco.
     * 
     * @return dwConsolpalog
     */
    public idw.idwws.DwConsolpalog getDwConsolpalog() {
        return dwConsolpalog;
    }


    /**
     * Sets the dwConsolpalog value for this DwConsolpaoco.
     * 
     * @param dwConsolpalog
     */
    public void setDwConsolpalog(idw.idwws.DwConsolpalog dwConsolpalog) {
        this.dwConsolpalog = dwConsolpalog;
    }


    /**
     * Gets the idConsolpaoco value for this DwConsolpaoco.
     * 
     * @return idConsolpaoco
     */
    public long getIdConsolpaoco() {
        return idConsolpaoco;
    }


    /**
     * Sets the idConsolpaoco value for this DwConsolpaoco.
     * 
     * @param idConsolpaoco
     */
    public void setIdConsolpaoco(long idConsolpaoco) {
        this.idConsolpaoco = idConsolpaoco;
    }


    /**
     * Gets the isContinuaproximoperiodo value for this DwConsolpaoco.
     * 
     * @return isContinuaproximoperiodo
     */
    public java.math.BigDecimal getIsContinuaproximoperiodo() {
        return isContinuaproximoperiodo;
    }


    /**
     * Sets the isContinuaproximoperiodo value for this DwConsolpaoco.
     * 
     * @param isContinuaproximoperiodo
     */
    public void setIsContinuaproximoperiodo(java.math.BigDecimal isContinuaproximoperiodo) {
        this.isContinuaproximoperiodo = isContinuaproximoperiodo;
    }


    /**
     * Gets the msDthrfparada value for this DwConsolpaoco.
     * 
     * @return msDthrfparada
     */
    public java.math.BigDecimal getMsDthrfparada() {
        return msDthrfparada;
    }


    /**
     * Sets the msDthrfparada value for this DwConsolpaoco.
     * 
     * @param msDthrfparada
     */
    public void setMsDthrfparada(java.math.BigDecimal msDthrfparada) {
        this.msDthrfparada = msDthrfparada;
    }


    /**
     * Gets the msDthrfparadaAb value for this DwConsolpaoco.
     * 
     * @return msDthrfparadaAb
     */
    public java.math.BigDecimal getMsDthrfparadaAb() {
        return msDthrfparadaAb;
    }


    /**
     * Sets the msDthrfparadaAb value for this DwConsolpaoco.
     * 
     * @param msDthrfparadaAb
     */
    public void setMsDthrfparadaAb(java.math.BigDecimal msDthrfparadaAb) {
        this.msDthrfparadaAb = msDthrfparadaAb;
    }


    /**
     * Gets the msDthriparada value for this DwConsolpaoco.
     * 
     * @return msDthriparada
     */
    public java.math.BigDecimal getMsDthriparada() {
        return msDthriparada;
    }


    /**
     * Sets the msDthriparada value for this DwConsolpaoco.
     * 
     * @param msDthriparada
     */
    public void setMsDthriparada(java.math.BigDecimal msDthriparada) {
        this.msDthriparada = msDthriparada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpaoco)) return false;
        DwConsolpaoco other = (DwConsolpaoco) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFparada==null && other.getDthrFparada()==null) || 
             (this.dthrFparada!=null &&
              this.dthrFparada.equals(other.getDthrFparada()))) &&
            ((this.dthrFparadaAb==null && other.getDthrFparadaAb()==null) || 
             (this.dthrFparadaAb!=null &&
              this.dthrFparadaAb.equals(other.getDthrFparadaAb()))) &&
            ((this.dthrIparada==null && other.getDthrIparada()==null) || 
             (this.dthrIparada!=null &&
              this.dthrIparada.equals(other.getDthrIparada()))) &&
            ((this.dwConsolpa==null && other.getDwConsolpa()==null) || 
             (this.dwConsolpa!=null &&
              this.dwConsolpa.equals(other.getDwConsolpa()))) &&
            ((this.dwConsolpalog==null && other.getDwConsolpalog()==null) || 
             (this.dwConsolpalog!=null &&
              this.dwConsolpalog.equals(other.getDwConsolpalog()))) &&
            this.idConsolpaoco == other.getIdConsolpaoco() &&
            ((this.isContinuaproximoperiodo==null && other.getIsContinuaproximoperiodo()==null) || 
             (this.isContinuaproximoperiodo!=null &&
              this.isContinuaproximoperiodo.equals(other.getIsContinuaproximoperiodo()))) &&
            ((this.msDthrfparada==null && other.getMsDthrfparada()==null) || 
             (this.msDthrfparada!=null &&
              this.msDthrfparada.equals(other.getMsDthrfparada()))) &&
            ((this.msDthrfparadaAb==null && other.getMsDthrfparadaAb()==null) || 
             (this.msDthrfparadaAb!=null &&
              this.msDthrfparadaAb.equals(other.getMsDthrfparadaAb()))) &&
            ((this.msDthriparada==null && other.getMsDthriparada()==null) || 
             (this.msDthriparada!=null &&
              this.msDthriparada.equals(other.getMsDthriparada())));
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
        if (getDthrFparada() != null) {
            _hashCode += getDthrFparada().hashCode();
        }
        if (getDthrFparadaAb() != null) {
            _hashCode += getDthrFparadaAb().hashCode();
        }
        if (getDthrIparada() != null) {
            _hashCode += getDthrIparada().hashCode();
        }
        if (getDwConsolpa() != null) {
            _hashCode += getDwConsolpa().hashCode();
        }
        if (getDwConsolpalog() != null) {
            _hashCode += getDwConsolpalog().hashCode();
        }
        _hashCode += new Long(getIdConsolpaoco()).hashCode();
        if (getIsContinuaproximoperiodo() != null) {
            _hashCode += getIsContinuaproximoperiodo().hashCode();
        }
        if (getMsDthrfparada() != null) {
            _hashCode += getMsDthrfparada().hashCode();
        }
        if (getMsDthrfparadaAb() != null) {
            _hashCode += getMsDthrfparadaAb().hashCode();
        }
        if (getMsDthriparada() != null) {
            _hashCode += getMsDthriparada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpaoco.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpaoco"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFparadaAb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFparadaAb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpalog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpalog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpaoco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpaoco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isContinuaproximoperiodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isContinuaproximoperiodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfparadaAb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfparadaAb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthriparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthriparada"));
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
