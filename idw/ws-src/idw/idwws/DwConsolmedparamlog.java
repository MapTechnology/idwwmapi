/**
 * DwConsolmedparamlog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolmedparamlog  extends idw.idwws.DwConsolmedparamlogTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrMedicao;

    private idw.idwws.DwConsolmedparamoco[] dwConsolmedparamocos;

    private idw.idwws.DwFtParam dwFtParam;

    private java.math.BigDecimal idConsolmedparamlog;

    private int msDthrmedicao;

    private java.math.BigDecimal vlrLido;

    public DwConsolmedparamlog() {
    }

    public DwConsolmedparamlog(
           java.util.Calendar dthrMedicao,
           idw.idwws.DwConsolmedparamoco[] dwConsolmedparamocos,
           idw.idwws.DwFtParam dwFtParam,
           java.math.BigDecimal idConsolmedparamlog,
           int msDthrmedicao,
           java.math.BigDecimal vlrLido) {
        this.dthrMedicao = dthrMedicao;
        this.dwConsolmedparamocos = dwConsolmedparamocos;
        this.dwFtParam = dwFtParam;
        this.idConsolmedparamlog = idConsolmedparamlog;
        this.msDthrmedicao = msDthrmedicao;
        this.vlrLido = vlrLido;
    }


    /**
     * Gets the dthrMedicao value for this DwConsolmedparamlog.
     * 
     * @return dthrMedicao
     */
    public java.util.Calendar getDthrMedicao() {
        return dthrMedicao;
    }


    /**
     * Sets the dthrMedicao value for this DwConsolmedparamlog.
     * 
     * @param dthrMedicao
     */
    public void setDthrMedicao(java.util.Calendar dthrMedicao) {
        this.dthrMedicao = dthrMedicao;
    }


    /**
     * Gets the dwConsolmedparamocos value for this DwConsolmedparamlog.
     * 
     * @return dwConsolmedparamocos
     */
    public idw.idwws.DwConsolmedparamoco[] getDwConsolmedparamocos() {
        return dwConsolmedparamocos;
    }


    /**
     * Sets the dwConsolmedparamocos value for this DwConsolmedparamlog.
     * 
     * @param dwConsolmedparamocos
     */
    public void setDwConsolmedparamocos(idw.idwws.DwConsolmedparamoco[] dwConsolmedparamocos) {
        this.dwConsolmedparamocos = dwConsolmedparamocos;
    }

    public idw.idwws.DwConsolmedparamoco getDwConsolmedparamocos(int i) {
        return this.dwConsolmedparamocos[i];
    }

    public void setDwConsolmedparamocos(int i, idw.idwws.DwConsolmedparamoco _value) {
        this.dwConsolmedparamocos[i] = _value;
    }


    /**
     * Gets the dwFtParam value for this DwConsolmedparamlog.
     * 
     * @return dwFtParam
     */
    public idw.idwws.DwFtParam getDwFtParam() {
        return dwFtParam;
    }


    /**
     * Sets the dwFtParam value for this DwConsolmedparamlog.
     * 
     * @param dwFtParam
     */
    public void setDwFtParam(idw.idwws.DwFtParam dwFtParam) {
        this.dwFtParam = dwFtParam;
    }


    /**
     * Gets the idConsolmedparamlog value for this DwConsolmedparamlog.
     * 
     * @return idConsolmedparamlog
     */
    public java.math.BigDecimal getIdConsolmedparamlog() {
        return idConsolmedparamlog;
    }


    /**
     * Sets the idConsolmedparamlog value for this DwConsolmedparamlog.
     * 
     * @param idConsolmedparamlog
     */
    public void setIdConsolmedparamlog(java.math.BigDecimal idConsolmedparamlog) {
        this.idConsolmedparamlog = idConsolmedparamlog;
    }


    /**
     * Gets the msDthrmedicao value for this DwConsolmedparamlog.
     * 
     * @return msDthrmedicao
     */
    public int getMsDthrmedicao() {
        return msDthrmedicao;
    }


    /**
     * Sets the msDthrmedicao value for this DwConsolmedparamlog.
     * 
     * @param msDthrmedicao
     */
    public void setMsDthrmedicao(int msDthrmedicao) {
        this.msDthrmedicao = msDthrmedicao;
    }


    /**
     * Gets the vlrLido value for this DwConsolmedparamlog.
     * 
     * @return vlrLido
     */
    public java.math.BigDecimal getVlrLido() {
        return vlrLido;
    }


    /**
     * Sets the vlrLido value for this DwConsolmedparamlog.
     * 
     * @param vlrLido
     */
    public void setVlrLido(java.math.BigDecimal vlrLido) {
        this.vlrLido = vlrLido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolmedparamlog)) return false;
        DwConsolmedparamlog other = (DwConsolmedparamlog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrMedicao==null && other.getDthrMedicao()==null) || 
             (this.dthrMedicao!=null &&
              this.dthrMedicao.equals(other.getDthrMedicao()))) &&
            ((this.dwConsolmedparamocos==null && other.getDwConsolmedparamocos()==null) || 
             (this.dwConsolmedparamocos!=null &&
              java.util.Arrays.equals(this.dwConsolmedparamocos, other.getDwConsolmedparamocos()))) &&
            ((this.dwFtParam==null && other.getDwFtParam()==null) || 
             (this.dwFtParam!=null &&
              this.dwFtParam.equals(other.getDwFtParam()))) &&
            ((this.idConsolmedparamlog==null && other.getIdConsolmedparamlog()==null) || 
             (this.idConsolmedparamlog!=null &&
              this.idConsolmedparamlog.equals(other.getIdConsolmedparamlog()))) &&
            this.msDthrmedicao == other.getMsDthrmedicao() &&
            ((this.vlrLido==null && other.getVlrLido()==null) || 
             (this.vlrLido!=null &&
              this.vlrLido.equals(other.getVlrLido())));
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
        if (getDthrMedicao() != null) {
            _hashCode += getDthrMedicao().hashCode();
        }
        if (getDwConsolmedparamocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmedparamocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmedparamocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFtParam() != null) {
            _hashCode += getDwFtParam().hashCode();
        }
        if (getIdConsolmedparamlog() != null) {
            _hashCode += getIdConsolmedparamlog().hashCode();
        }
        _hashCode += getMsDthrmedicao();
        if (getVlrLido() != null) {
            _hashCode += getVlrLido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolmedparamlog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparamlog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrMedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrMedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmedparamocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmedparamocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparamoco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolmedparamlog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolmedparamlog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrmedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrmedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlrLido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlrLido"));
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
