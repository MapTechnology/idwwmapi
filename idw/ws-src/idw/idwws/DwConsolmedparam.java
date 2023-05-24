/**
 * DwConsolmedparam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolmedparam  extends idw.idwws.DwConsolmedparamTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsol dwConsol;

    private idw.idwws.DwConsolmedparamoco[] dwConsolmedparamocos;

    private idw.idwws.DwFtParam dwFtParam;

    private java.math.BigDecimal idConsolmedparam;

    private java.math.BigDecimal qtMedicoesLidas;

    private java.math.BigDecimal qtValoresAcum;

    public DwConsolmedparam() {
    }

    public DwConsolmedparam(
           idw.idwws.DwConsol dwConsol,
           idw.idwws.DwConsolmedparamoco[] dwConsolmedparamocos,
           idw.idwws.DwFtParam dwFtParam,
           java.math.BigDecimal idConsolmedparam,
           java.math.BigDecimal qtMedicoesLidas,
           java.math.BigDecimal qtValoresAcum) {
        this.dwConsol = dwConsol;
        this.dwConsolmedparamocos = dwConsolmedparamocos;
        this.dwFtParam = dwFtParam;
        this.idConsolmedparam = idConsolmedparam;
        this.qtMedicoesLidas = qtMedicoesLidas;
        this.qtValoresAcum = qtValoresAcum;
    }


    /**
     * Gets the dwConsol value for this DwConsolmedparam.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsolmedparam.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the dwConsolmedparamocos value for this DwConsolmedparam.
     * 
     * @return dwConsolmedparamocos
     */
    public idw.idwws.DwConsolmedparamoco[] getDwConsolmedparamocos() {
        return dwConsolmedparamocos;
    }


    /**
     * Sets the dwConsolmedparamocos value for this DwConsolmedparam.
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
     * Gets the dwFtParam value for this DwConsolmedparam.
     * 
     * @return dwFtParam
     */
    public idw.idwws.DwFtParam getDwFtParam() {
        return dwFtParam;
    }


    /**
     * Sets the dwFtParam value for this DwConsolmedparam.
     * 
     * @param dwFtParam
     */
    public void setDwFtParam(idw.idwws.DwFtParam dwFtParam) {
        this.dwFtParam = dwFtParam;
    }


    /**
     * Gets the idConsolmedparam value for this DwConsolmedparam.
     * 
     * @return idConsolmedparam
     */
    public java.math.BigDecimal getIdConsolmedparam() {
        return idConsolmedparam;
    }


    /**
     * Sets the idConsolmedparam value for this DwConsolmedparam.
     * 
     * @param idConsolmedparam
     */
    public void setIdConsolmedparam(java.math.BigDecimal idConsolmedparam) {
        this.idConsolmedparam = idConsolmedparam;
    }


    /**
     * Gets the qtMedicoesLidas value for this DwConsolmedparam.
     * 
     * @return qtMedicoesLidas
     */
    public java.math.BigDecimal getQtMedicoesLidas() {
        return qtMedicoesLidas;
    }


    /**
     * Sets the qtMedicoesLidas value for this DwConsolmedparam.
     * 
     * @param qtMedicoesLidas
     */
    public void setQtMedicoesLidas(java.math.BigDecimal qtMedicoesLidas) {
        this.qtMedicoesLidas = qtMedicoesLidas;
    }


    /**
     * Gets the qtValoresAcum value for this DwConsolmedparam.
     * 
     * @return qtValoresAcum
     */
    public java.math.BigDecimal getQtValoresAcum() {
        return qtValoresAcum;
    }


    /**
     * Sets the qtValoresAcum value for this DwConsolmedparam.
     * 
     * @param qtValoresAcum
     */
    public void setQtValoresAcum(java.math.BigDecimal qtValoresAcum) {
        this.qtValoresAcum = qtValoresAcum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolmedparam)) return false;
        DwConsolmedparam other = (DwConsolmedparam) obj;
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
            ((this.dwConsolmedparamocos==null && other.getDwConsolmedparamocos()==null) || 
             (this.dwConsolmedparamocos!=null &&
              java.util.Arrays.equals(this.dwConsolmedparamocos, other.getDwConsolmedparamocos()))) &&
            ((this.dwFtParam==null && other.getDwFtParam()==null) || 
             (this.dwFtParam!=null &&
              this.dwFtParam.equals(other.getDwFtParam()))) &&
            ((this.idConsolmedparam==null && other.getIdConsolmedparam()==null) || 
             (this.idConsolmedparam!=null &&
              this.idConsolmedparam.equals(other.getIdConsolmedparam()))) &&
            ((this.qtMedicoesLidas==null && other.getQtMedicoesLidas()==null) || 
             (this.qtMedicoesLidas!=null &&
              this.qtMedicoesLidas.equals(other.getQtMedicoesLidas()))) &&
            ((this.qtValoresAcum==null && other.getQtValoresAcum()==null) || 
             (this.qtValoresAcum!=null &&
              this.qtValoresAcum.equals(other.getQtValoresAcum())));
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
        if (getIdConsolmedparam() != null) {
            _hashCode += getIdConsolmedparam().hashCode();
        }
        if (getQtMedicoesLidas() != null) {
            _hashCode += getQtMedicoesLidas().hashCode();
        }
        if (getQtValoresAcum() != null) {
            _hashCode += getQtValoresAcum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolmedparam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
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
        elemField.setFieldName("idConsolmedparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolmedparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMedicoesLidas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMedicoesLidas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtValoresAcum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtValoresAcum"));
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
