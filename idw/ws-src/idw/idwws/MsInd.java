/**
 * MsInd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsInd  extends idw.idwws.MsIndTemplate  implements java.io.Serializable {
    private java.lang.String dsCalculo;

    private java.lang.String dsInd;

    private java.lang.String dsUnidade;

    private java.math.BigDecimal idInd;

    private idw.idwws.MsTrigger[] msTriggers;

    public MsInd() {
    }

    public MsInd(
           java.lang.String dsCalculo,
           java.lang.String dsInd,
           java.lang.String dsUnidade,
           java.math.BigDecimal idInd,
           idw.idwws.MsTrigger[] msTriggers) {
        this.dsCalculo = dsCalculo;
        this.dsInd = dsInd;
        this.dsUnidade = dsUnidade;
        this.idInd = idInd;
        this.msTriggers = msTriggers;
    }


    /**
     * Gets the dsCalculo value for this MsInd.
     * 
     * @return dsCalculo
     */
    public java.lang.String getDsCalculo() {
        return dsCalculo;
    }


    /**
     * Sets the dsCalculo value for this MsInd.
     * 
     * @param dsCalculo
     */
    public void setDsCalculo(java.lang.String dsCalculo) {
        this.dsCalculo = dsCalculo;
    }


    /**
     * Gets the dsInd value for this MsInd.
     * 
     * @return dsInd
     */
    public java.lang.String getDsInd() {
        return dsInd;
    }


    /**
     * Sets the dsInd value for this MsInd.
     * 
     * @param dsInd
     */
    public void setDsInd(java.lang.String dsInd) {
        this.dsInd = dsInd;
    }


    /**
     * Gets the dsUnidade value for this MsInd.
     * 
     * @return dsUnidade
     */
    public java.lang.String getDsUnidade() {
        return dsUnidade;
    }


    /**
     * Sets the dsUnidade value for this MsInd.
     * 
     * @param dsUnidade
     */
    public void setDsUnidade(java.lang.String dsUnidade) {
        this.dsUnidade = dsUnidade;
    }


    /**
     * Gets the idInd value for this MsInd.
     * 
     * @return idInd
     */
    public java.math.BigDecimal getIdInd() {
        return idInd;
    }


    /**
     * Sets the idInd value for this MsInd.
     * 
     * @param idInd
     */
    public void setIdInd(java.math.BigDecimal idInd) {
        this.idInd = idInd;
    }


    /**
     * Gets the msTriggers value for this MsInd.
     * 
     * @return msTriggers
     */
    public idw.idwws.MsTrigger[] getMsTriggers() {
        return msTriggers;
    }


    /**
     * Sets the msTriggers value for this MsInd.
     * 
     * @param msTriggers
     */
    public void setMsTriggers(idw.idwws.MsTrigger[] msTriggers) {
        this.msTriggers = msTriggers;
    }

    public idw.idwws.MsTrigger getMsTriggers(int i) {
        return this.msTriggers[i];
    }

    public void setMsTriggers(int i, idw.idwws.MsTrigger _value) {
        this.msTriggers[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsInd)) return false;
        MsInd other = (MsInd) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsCalculo==null && other.getDsCalculo()==null) || 
             (this.dsCalculo!=null &&
              this.dsCalculo.equals(other.getDsCalculo()))) &&
            ((this.dsInd==null && other.getDsInd()==null) || 
             (this.dsInd!=null &&
              this.dsInd.equals(other.getDsInd()))) &&
            ((this.dsUnidade==null && other.getDsUnidade()==null) || 
             (this.dsUnidade!=null &&
              this.dsUnidade.equals(other.getDsUnidade()))) &&
            ((this.idInd==null && other.getIdInd()==null) || 
             (this.idInd!=null &&
              this.idInd.equals(other.getIdInd()))) &&
            ((this.msTriggers==null && other.getMsTriggers()==null) || 
             (this.msTriggers!=null &&
              java.util.Arrays.equals(this.msTriggers, other.getMsTriggers())));
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
        if (getDsCalculo() != null) {
            _hashCode += getDsCalculo().hashCode();
        }
        if (getDsInd() != null) {
            _hashCode += getDsInd().hashCode();
        }
        if (getDsUnidade() != null) {
            _hashCode += getDsUnidade().hashCode();
        }
        if (getIdInd() != null) {
            _hashCode += getIdInd().hashCode();
        }
        if (getMsTriggers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMsTriggers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMsTriggers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsInd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msInd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCalculo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCalculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsUnidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsUnidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msTriggers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msTriggers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msTrigger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
