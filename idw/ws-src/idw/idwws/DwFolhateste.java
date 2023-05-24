/**
 * DwFolhateste.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhateste  extends idw.idwws.DwFolhatesteTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwTestesub[] dwTestesubs;

    private java.lang.Integer frequenciaHz;

    private long idFolhateste;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmProduto omProduto;

    private java.math.BigDecimal tensaoMax;

    private java.math.BigDecimal tensaoMin;

    private java.math.BigDecimal tensaoNom;

    public DwFolhateste() {
    }

    public DwFolhateste(
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwTestesub[] dwTestesubs,
           java.lang.Integer frequenciaHz,
           long idFolhateste,
           idw.idwws.OmGt omGt,
           idw.idwws.OmProduto omProduto,
           java.math.BigDecimal tensaoMax,
           java.math.BigDecimal tensaoMin,
           java.math.BigDecimal tensaoNom) {
        this.dwFolha = dwFolha;
        this.dwTestesubs = dwTestesubs;
        this.frequenciaHz = frequenciaHz;
        this.idFolhateste = idFolhateste;
        this.omGt = omGt;
        this.omProduto = omProduto;
        this.tensaoMax = tensaoMax;
        this.tensaoMin = tensaoMin;
        this.tensaoNom = tensaoNom;
    }


    /**
     * Gets the dwFolha value for this DwFolhateste.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwFolhateste.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwTestesubs value for this DwFolhateste.
     * 
     * @return dwTestesubs
     */
    public idw.idwws.DwTestesub[] getDwTestesubs() {
        return dwTestesubs;
    }


    /**
     * Sets the dwTestesubs value for this DwFolhateste.
     * 
     * @param dwTestesubs
     */
    public void setDwTestesubs(idw.idwws.DwTestesub[] dwTestesubs) {
        this.dwTestesubs = dwTestesubs;
    }

    public idw.idwws.DwTestesub getDwTestesubs(int i) {
        return this.dwTestesubs[i];
    }

    public void setDwTestesubs(int i, idw.idwws.DwTestesub _value) {
        this.dwTestesubs[i] = _value;
    }


    /**
     * Gets the frequenciaHz value for this DwFolhateste.
     * 
     * @return frequenciaHz
     */
    public java.lang.Integer getFrequenciaHz() {
        return frequenciaHz;
    }


    /**
     * Sets the frequenciaHz value for this DwFolhateste.
     * 
     * @param frequenciaHz
     */
    public void setFrequenciaHz(java.lang.Integer frequenciaHz) {
        this.frequenciaHz = frequenciaHz;
    }


    /**
     * Gets the idFolhateste value for this DwFolhateste.
     * 
     * @return idFolhateste
     */
    public long getIdFolhateste() {
        return idFolhateste;
    }


    /**
     * Sets the idFolhateste value for this DwFolhateste.
     * 
     * @param idFolhateste
     */
    public void setIdFolhateste(long idFolhateste) {
        this.idFolhateste = idFolhateste;
    }


    /**
     * Gets the omGt value for this DwFolhateste.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this DwFolhateste.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omProduto value for this DwFolhateste.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwFolhateste.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the tensaoMax value for this DwFolhateste.
     * 
     * @return tensaoMax
     */
    public java.math.BigDecimal getTensaoMax() {
        return tensaoMax;
    }


    /**
     * Sets the tensaoMax value for this DwFolhateste.
     * 
     * @param tensaoMax
     */
    public void setTensaoMax(java.math.BigDecimal tensaoMax) {
        this.tensaoMax = tensaoMax;
    }


    /**
     * Gets the tensaoMin value for this DwFolhateste.
     * 
     * @return tensaoMin
     */
    public java.math.BigDecimal getTensaoMin() {
        return tensaoMin;
    }


    /**
     * Sets the tensaoMin value for this DwFolhateste.
     * 
     * @param tensaoMin
     */
    public void setTensaoMin(java.math.BigDecimal tensaoMin) {
        this.tensaoMin = tensaoMin;
    }


    /**
     * Gets the tensaoNom value for this DwFolhateste.
     * 
     * @return tensaoNom
     */
    public java.math.BigDecimal getTensaoNom() {
        return tensaoNom;
    }


    /**
     * Sets the tensaoNom value for this DwFolhateste.
     * 
     * @param tensaoNom
     */
    public void setTensaoNom(java.math.BigDecimal tensaoNom) {
        this.tensaoNom = tensaoNom;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhateste)) return false;
        DwFolhateste other = (DwFolhateste) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.dwTestesubs==null && other.getDwTestesubs()==null) || 
             (this.dwTestesubs!=null &&
              java.util.Arrays.equals(this.dwTestesubs, other.getDwTestesubs()))) &&
            ((this.frequenciaHz==null && other.getFrequenciaHz()==null) || 
             (this.frequenciaHz!=null &&
              this.frequenciaHz.equals(other.getFrequenciaHz()))) &&
            this.idFolhateste == other.getIdFolhateste() &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.tensaoMax==null && other.getTensaoMax()==null) || 
             (this.tensaoMax!=null &&
              this.tensaoMax.equals(other.getTensaoMax()))) &&
            ((this.tensaoMin==null && other.getTensaoMin()==null) || 
             (this.tensaoMin!=null &&
              this.tensaoMin.equals(other.getTensaoMin()))) &&
            ((this.tensaoNom==null && other.getTensaoNom()==null) || 
             (this.tensaoNom!=null &&
              this.tensaoNom.equals(other.getTensaoNom())));
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
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getDwTestesubs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTestesubs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTestesubs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFrequenciaHz() != null) {
            _hashCode += getFrequenciaHz().hashCode();
        }
        _hashCode += new Long(getIdFolhateste()).hashCode();
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getTensaoMax() != null) {
            _hashCode += getTensaoMax().hashCode();
        }
        if (getTensaoMin() != null) {
            _hashCode += getTensaoMin().hashCode();
        }
        if (getTensaoNom() != null) {
            _hashCode += getTensaoNom().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhateste.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhateste"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTestesubs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTestesubs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequenciaHz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequenciaHz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhateste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhateste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("tensaoMax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaoMax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tensaoMin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaoMin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tensaoNom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tensaoNom"));
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
