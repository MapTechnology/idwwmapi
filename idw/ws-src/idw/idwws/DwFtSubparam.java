/**
 * DwFtSubparam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFtSubparam  extends idw.idwws.DwFtSubparamTemplate  implements java.io.Serializable {
    private idw.idwws.DwFtParam dwFtParam;

    private idw.idwws.DwFtSub dwFtSub;

    private idw.idwws.DwTestesubetapa[] dwTestesubetapas;

    private long idSubparam;

    public DwFtSubparam() {
    }

    public DwFtSubparam(
           idw.idwws.DwFtParam dwFtParam,
           idw.idwws.DwFtSub dwFtSub,
           idw.idwws.DwTestesubetapa[] dwTestesubetapas,
           long idSubparam) {
        this.dwFtParam = dwFtParam;
        this.dwFtSub = dwFtSub;
        this.dwTestesubetapas = dwTestesubetapas;
        this.idSubparam = idSubparam;
    }


    /**
     * Gets the dwFtParam value for this DwFtSubparam.
     * 
     * @return dwFtParam
     */
    public idw.idwws.DwFtParam getDwFtParam() {
        return dwFtParam;
    }


    /**
     * Sets the dwFtParam value for this DwFtSubparam.
     * 
     * @param dwFtParam
     */
    public void setDwFtParam(idw.idwws.DwFtParam dwFtParam) {
        this.dwFtParam = dwFtParam;
    }


    /**
     * Gets the dwFtSub value for this DwFtSubparam.
     * 
     * @return dwFtSub
     */
    public idw.idwws.DwFtSub getDwFtSub() {
        return dwFtSub;
    }


    /**
     * Sets the dwFtSub value for this DwFtSubparam.
     * 
     * @param dwFtSub
     */
    public void setDwFtSub(idw.idwws.DwFtSub dwFtSub) {
        this.dwFtSub = dwFtSub;
    }


    /**
     * Gets the dwTestesubetapas value for this DwFtSubparam.
     * 
     * @return dwTestesubetapas
     */
    public idw.idwws.DwTestesubetapa[] getDwTestesubetapas() {
        return dwTestesubetapas;
    }


    /**
     * Sets the dwTestesubetapas value for this DwFtSubparam.
     * 
     * @param dwTestesubetapas
     */
    public void setDwTestesubetapas(idw.idwws.DwTestesubetapa[] dwTestesubetapas) {
        this.dwTestesubetapas = dwTestesubetapas;
    }

    public idw.idwws.DwTestesubetapa getDwTestesubetapas(int i) {
        return this.dwTestesubetapas[i];
    }

    public void setDwTestesubetapas(int i, idw.idwws.DwTestesubetapa _value) {
        this.dwTestesubetapas[i] = _value;
    }


    /**
     * Gets the idSubparam value for this DwFtSubparam.
     * 
     * @return idSubparam
     */
    public long getIdSubparam() {
        return idSubparam;
    }


    /**
     * Sets the idSubparam value for this DwFtSubparam.
     * 
     * @param idSubparam
     */
    public void setIdSubparam(long idSubparam) {
        this.idSubparam = idSubparam;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFtSubparam)) return false;
        DwFtSubparam other = (DwFtSubparam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFtParam==null && other.getDwFtParam()==null) || 
             (this.dwFtParam!=null &&
              this.dwFtParam.equals(other.getDwFtParam()))) &&
            ((this.dwFtSub==null && other.getDwFtSub()==null) || 
             (this.dwFtSub!=null &&
              this.dwFtSub.equals(other.getDwFtSub()))) &&
            ((this.dwTestesubetapas==null && other.getDwTestesubetapas()==null) || 
             (this.dwTestesubetapas!=null &&
              java.util.Arrays.equals(this.dwTestesubetapas, other.getDwTestesubetapas()))) &&
            this.idSubparam == other.getIdSubparam();
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
        if (getDwFtParam() != null) {
            _hashCode += getDwFtParam().hashCode();
        }
        if (getDwFtSub() != null) {
            _hashCode += getDwFtSub().hashCode();
        }
        if (getDwTestesubetapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTestesubetapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTestesubetapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdSubparam()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFtSubparam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSubparam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtSub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTestesubetapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTestesubetapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesubetapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idSubparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSubparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
