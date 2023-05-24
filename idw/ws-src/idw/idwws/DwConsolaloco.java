/**
 * DwConsolaloco.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolaloco  implements java.io.Serializable {
    private java.util.Calendar dthrFalerta;

    private java.util.Calendar dthrIalerta;

    private idw.idwws.DwConsolal dwConsolal;

    private idw.idwws.DwConsolallog dwConsolallog;

    private java.lang.Long idConsolaloco;

    private java.lang.Boolean isContinuaproximoperiodo;

    private java.lang.Byte msDthrfalerta;

    private java.lang.Byte msDthrialerta;

    public DwConsolaloco() {
    }

    public DwConsolaloco(
           java.util.Calendar dthrFalerta,
           java.util.Calendar dthrIalerta,
           idw.idwws.DwConsolal dwConsolal,
           idw.idwws.DwConsolallog dwConsolallog,
           java.lang.Long idConsolaloco,
           java.lang.Boolean isContinuaproximoperiodo,
           java.lang.Byte msDthrfalerta,
           java.lang.Byte msDthrialerta) {
           this.dthrFalerta = dthrFalerta;
           this.dthrIalerta = dthrIalerta;
           this.dwConsolal = dwConsolal;
           this.dwConsolallog = dwConsolallog;
           this.idConsolaloco = idConsolaloco;
           this.isContinuaproximoperiodo = isContinuaproximoperiodo;
           this.msDthrfalerta = msDthrfalerta;
           this.msDthrialerta = msDthrialerta;
    }


    /**
     * Gets the dthrFalerta value for this DwConsolaloco.
     * 
     * @return dthrFalerta
     */
    public java.util.Calendar getDthrFalerta() {
        return dthrFalerta;
    }


    /**
     * Sets the dthrFalerta value for this DwConsolaloco.
     * 
     * @param dthrFalerta
     */
    public void setDthrFalerta(java.util.Calendar dthrFalerta) {
        this.dthrFalerta = dthrFalerta;
    }


    /**
     * Gets the dthrIalerta value for this DwConsolaloco.
     * 
     * @return dthrIalerta
     */
    public java.util.Calendar getDthrIalerta() {
        return dthrIalerta;
    }


    /**
     * Sets the dthrIalerta value for this DwConsolaloco.
     * 
     * @param dthrIalerta
     */
    public void setDthrIalerta(java.util.Calendar dthrIalerta) {
        this.dthrIalerta = dthrIalerta;
    }


    /**
     * Gets the dwConsolal value for this DwConsolaloco.
     * 
     * @return dwConsolal
     */
    public idw.idwws.DwConsolal getDwConsolal() {
        return dwConsolal;
    }


    /**
     * Sets the dwConsolal value for this DwConsolaloco.
     * 
     * @param dwConsolal
     */
    public void setDwConsolal(idw.idwws.DwConsolal dwConsolal) {
        this.dwConsolal = dwConsolal;
    }


    /**
     * Gets the dwConsolallog value for this DwConsolaloco.
     * 
     * @return dwConsolallog
     */
    public idw.idwws.DwConsolallog getDwConsolallog() {
        return dwConsolallog;
    }


    /**
     * Sets the dwConsolallog value for this DwConsolaloco.
     * 
     * @param dwConsolallog
     */
    public void setDwConsolallog(idw.idwws.DwConsolallog dwConsolallog) {
        this.dwConsolallog = dwConsolallog;
    }


    /**
     * Gets the idConsolaloco value for this DwConsolaloco.
     * 
     * @return idConsolaloco
     */
    public java.lang.Long getIdConsolaloco() {
        return idConsolaloco;
    }


    /**
     * Sets the idConsolaloco value for this DwConsolaloco.
     * 
     * @param idConsolaloco
     */
    public void setIdConsolaloco(java.lang.Long idConsolaloco) {
        this.idConsolaloco = idConsolaloco;
    }


    /**
     * Gets the isContinuaproximoperiodo value for this DwConsolaloco.
     * 
     * @return isContinuaproximoperiodo
     */
    public java.lang.Boolean getIsContinuaproximoperiodo() {
        return isContinuaproximoperiodo;
    }


    /**
     * Sets the isContinuaproximoperiodo value for this DwConsolaloco.
     * 
     * @param isContinuaproximoperiodo
     */
    public void setIsContinuaproximoperiodo(java.lang.Boolean isContinuaproximoperiodo) {
        this.isContinuaproximoperiodo = isContinuaproximoperiodo;
    }


    /**
     * Gets the msDthrfalerta value for this DwConsolaloco.
     * 
     * @return msDthrfalerta
     */
    public java.lang.Byte getMsDthrfalerta() {
        return msDthrfalerta;
    }


    /**
     * Sets the msDthrfalerta value for this DwConsolaloco.
     * 
     * @param msDthrfalerta
     */
    public void setMsDthrfalerta(java.lang.Byte msDthrfalerta) {
        this.msDthrfalerta = msDthrfalerta;
    }


    /**
     * Gets the msDthrialerta value for this DwConsolaloco.
     * 
     * @return msDthrialerta
     */
    public java.lang.Byte getMsDthrialerta() {
        return msDthrialerta;
    }


    /**
     * Sets the msDthrialerta value for this DwConsolaloco.
     * 
     * @param msDthrialerta
     */
    public void setMsDthrialerta(java.lang.Byte msDthrialerta) {
        this.msDthrialerta = msDthrialerta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolaloco)) return false;
        DwConsolaloco other = (DwConsolaloco) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrFalerta==null && other.getDthrFalerta()==null) || 
             (this.dthrFalerta!=null &&
              this.dthrFalerta.equals(other.getDthrFalerta()))) &&
            ((this.dthrIalerta==null && other.getDthrIalerta()==null) || 
             (this.dthrIalerta!=null &&
              this.dthrIalerta.equals(other.getDthrIalerta()))) &&
            ((this.dwConsolal==null && other.getDwConsolal()==null) || 
             (this.dwConsolal!=null &&
              this.dwConsolal.equals(other.getDwConsolal()))) &&
            ((this.dwConsolallog==null && other.getDwConsolallog()==null) || 
             (this.dwConsolallog!=null &&
              this.dwConsolallog.equals(other.getDwConsolallog()))) &&
            ((this.idConsolaloco==null && other.getIdConsolaloco()==null) || 
             (this.idConsolaloco!=null &&
              this.idConsolaloco.equals(other.getIdConsolaloco()))) &&
            ((this.isContinuaproximoperiodo==null && other.getIsContinuaproximoperiodo()==null) || 
             (this.isContinuaproximoperiodo!=null &&
              this.isContinuaproximoperiodo.equals(other.getIsContinuaproximoperiodo()))) &&
            ((this.msDthrfalerta==null && other.getMsDthrfalerta()==null) || 
             (this.msDthrfalerta!=null &&
              this.msDthrfalerta.equals(other.getMsDthrfalerta()))) &&
            ((this.msDthrialerta==null && other.getMsDthrialerta()==null) || 
             (this.msDthrialerta!=null &&
              this.msDthrialerta.equals(other.getMsDthrialerta())));
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
        if (getDthrFalerta() != null) {
            _hashCode += getDthrFalerta().hashCode();
        }
        if (getDthrIalerta() != null) {
            _hashCode += getDthrIalerta().hashCode();
        }
        if (getDwConsolal() != null) {
            _hashCode += getDwConsolal().hashCode();
        }
        if (getDwConsolallog() != null) {
            _hashCode += getDwConsolallog().hashCode();
        }
        if (getIdConsolaloco() != null) {
            _hashCode += getIdConsolaloco().hashCode();
        }
        if (getIsContinuaproximoperiodo() != null) {
            _hashCode += getIsContinuaproximoperiodo().hashCode();
        }
        if (getMsDthrfalerta() != null) {
            _hashCode += getMsDthrfalerta().hashCode();
        }
        if (getMsDthrialerta() != null) {
            _hashCode += getMsDthrialerta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolaloco.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolaloco"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolallog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolallog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolallog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolaloco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolaloco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("msDthrfalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrialerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrialerta"));
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
