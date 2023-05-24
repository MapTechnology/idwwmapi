/**
 * Ijtbfamiliamaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbfamiliamaq  implements java.io.Serializable {
    private java.lang.String cdfamilia;

    private java.lang.String empresa;

    private idw.idwws.Ijfamiliaxmaq[] ijfamiliaxmaqs;

    private idw.idwws.Ijfilakanbanintbet[] ijfilakanbanintbets;

    private java.lang.String nmfamilia;

    public Ijtbfamiliamaq() {
    }

    public Ijtbfamiliamaq(
           java.lang.String cdfamilia,
           java.lang.String empresa,
           idw.idwws.Ijfamiliaxmaq[] ijfamiliaxmaqs,
           idw.idwws.Ijfilakanbanintbet[] ijfilakanbanintbets,
           java.lang.String nmfamilia) {
           this.cdfamilia = cdfamilia;
           this.empresa = empresa;
           this.ijfamiliaxmaqs = ijfamiliaxmaqs;
           this.ijfilakanbanintbets = ijfilakanbanintbets;
           this.nmfamilia = nmfamilia;
    }


    /**
     * Gets the cdfamilia value for this Ijtbfamiliamaq.
     * 
     * @return cdfamilia
     */
    public java.lang.String getCdfamilia() {
        return cdfamilia;
    }


    /**
     * Sets the cdfamilia value for this Ijtbfamiliamaq.
     * 
     * @param cdfamilia
     */
    public void setCdfamilia(java.lang.String cdfamilia) {
        this.cdfamilia = cdfamilia;
    }


    /**
     * Gets the empresa value for this Ijtbfamiliamaq.
     * 
     * @return empresa
     */
    public java.lang.String getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this Ijtbfamiliamaq.
     * 
     * @param empresa
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the ijfamiliaxmaqs value for this Ijtbfamiliamaq.
     * 
     * @return ijfamiliaxmaqs
     */
    public idw.idwws.Ijfamiliaxmaq[] getIjfamiliaxmaqs() {
        return ijfamiliaxmaqs;
    }


    /**
     * Sets the ijfamiliaxmaqs value for this Ijtbfamiliamaq.
     * 
     * @param ijfamiliaxmaqs
     */
    public void setIjfamiliaxmaqs(idw.idwws.Ijfamiliaxmaq[] ijfamiliaxmaqs) {
        this.ijfamiliaxmaqs = ijfamiliaxmaqs;
    }

    public idw.idwws.Ijfamiliaxmaq getIjfamiliaxmaqs(int i) {
        return this.ijfamiliaxmaqs[i];
    }

    public void setIjfamiliaxmaqs(int i, idw.idwws.Ijfamiliaxmaq _value) {
        this.ijfamiliaxmaqs[i] = _value;
    }


    /**
     * Gets the ijfilakanbanintbets value for this Ijtbfamiliamaq.
     * 
     * @return ijfilakanbanintbets
     */
    public idw.idwws.Ijfilakanbanintbet[] getIjfilakanbanintbets() {
        return ijfilakanbanintbets;
    }


    /**
     * Sets the ijfilakanbanintbets value for this Ijtbfamiliamaq.
     * 
     * @param ijfilakanbanintbets
     */
    public void setIjfilakanbanintbets(idw.idwws.Ijfilakanbanintbet[] ijfilakanbanintbets) {
        this.ijfilakanbanintbets = ijfilakanbanintbets;
    }

    public idw.idwws.Ijfilakanbanintbet getIjfilakanbanintbets(int i) {
        return this.ijfilakanbanintbets[i];
    }

    public void setIjfilakanbanintbets(int i, idw.idwws.Ijfilakanbanintbet _value) {
        this.ijfilakanbanintbets[i] = _value;
    }


    /**
     * Gets the nmfamilia value for this Ijtbfamiliamaq.
     * 
     * @return nmfamilia
     */
    public java.lang.String getNmfamilia() {
        return nmfamilia;
    }


    /**
     * Sets the nmfamilia value for this Ijtbfamiliamaq.
     * 
     * @param nmfamilia
     */
    public void setNmfamilia(java.lang.String nmfamilia) {
        this.nmfamilia = nmfamilia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbfamiliamaq)) return false;
        Ijtbfamiliamaq other = (Ijtbfamiliamaq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdfamilia==null && other.getCdfamilia()==null) || 
             (this.cdfamilia!=null &&
              this.cdfamilia.equals(other.getCdfamilia()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.ijfamiliaxmaqs==null && other.getIjfamiliaxmaqs()==null) || 
             (this.ijfamiliaxmaqs!=null &&
              java.util.Arrays.equals(this.ijfamiliaxmaqs, other.getIjfamiliaxmaqs()))) &&
            ((this.ijfilakanbanintbets==null && other.getIjfilakanbanintbets()==null) || 
             (this.ijfilakanbanintbets!=null &&
              java.util.Arrays.equals(this.ijfilakanbanintbets, other.getIjfilakanbanintbets()))) &&
            ((this.nmfamilia==null && other.getNmfamilia()==null) || 
             (this.nmfamilia!=null &&
              this.nmfamilia.equals(other.getNmfamilia())));
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
        if (getCdfamilia() != null) {
            _hashCode += getCdfamilia().hashCode();
        }
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getIjfamiliaxmaqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfamiliaxmaqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfamiliaxmaqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjfilakanbanintbets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfilakanbanintbets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfilakanbanintbets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNmfamilia() != null) {
            _hashCode += getNmfamilia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbfamiliamaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbfamiliamaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdfamilia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdfamilia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfamiliaxmaqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfamiliaxmaqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfamiliaxmaq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfilakanbanintbets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfilakanbanintbets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfilakanbanintbet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmfamilia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmfamilia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
