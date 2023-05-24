/**
 * DwFolharap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolharap  extends idw.idwws.DwFolharapTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwFolharapcom[] dwFolharapcoms;

    private idw.idwws.DwRap dwRap;

    private java.lang.Long idFolharap;

    private java.math.BigDecimal qtUsada;

    private java.math.BigDecimal segTempopreparacao;

    public DwFolharap() {
    }

    public DwFolharap(
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwFolharapcom[] dwFolharapcoms,
           idw.idwws.DwRap dwRap,
           java.lang.Long idFolharap,
           java.math.BigDecimal qtUsada,
           java.math.BigDecimal segTempopreparacao) {
        this.dwFolha = dwFolha;
        this.dwFolharapcoms = dwFolharapcoms;
        this.dwRap = dwRap;
        this.idFolharap = idFolharap;
        this.qtUsada = qtUsada;
        this.segTempopreparacao = segTempopreparacao;
    }


    /**
     * Gets the dwFolha value for this DwFolharap.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwFolharap.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwFolharapcoms value for this DwFolharap.
     * 
     * @return dwFolharapcoms
     */
    public idw.idwws.DwFolharapcom[] getDwFolharapcoms() {
        return dwFolharapcoms;
    }


    /**
     * Sets the dwFolharapcoms value for this DwFolharap.
     * 
     * @param dwFolharapcoms
     */
    public void setDwFolharapcoms(idw.idwws.DwFolharapcom[] dwFolharapcoms) {
        this.dwFolharapcoms = dwFolharapcoms;
    }

    public idw.idwws.DwFolharapcom getDwFolharapcoms(int i) {
        return this.dwFolharapcoms[i];
    }

    public void setDwFolharapcoms(int i, idw.idwws.DwFolharapcom _value) {
        this.dwFolharapcoms[i] = _value;
    }


    /**
     * Gets the dwRap value for this DwFolharap.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this DwFolharap.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the idFolharap value for this DwFolharap.
     * 
     * @return idFolharap
     */
    public java.lang.Long getIdFolharap() {
        return idFolharap;
    }


    /**
     * Sets the idFolharap value for this DwFolharap.
     * 
     * @param idFolharap
     */
    public void setIdFolharap(java.lang.Long idFolharap) {
        this.idFolharap = idFolharap;
    }


    /**
     * Gets the qtUsada value for this DwFolharap.
     * 
     * @return qtUsada
     */
    public java.math.BigDecimal getQtUsada() {
        return qtUsada;
    }


    /**
     * Sets the qtUsada value for this DwFolharap.
     * 
     * @param qtUsada
     */
    public void setQtUsada(java.math.BigDecimal qtUsada) {
        this.qtUsada = qtUsada;
    }


    /**
     * Gets the segTempopreparacao value for this DwFolharap.
     * 
     * @return segTempopreparacao
     */
    public java.math.BigDecimal getSegTempopreparacao() {
        return segTempopreparacao;
    }


    /**
     * Sets the segTempopreparacao value for this DwFolharap.
     * 
     * @param segTempopreparacao
     */
    public void setSegTempopreparacao(java.math.BigDecimal segTempopreparacao) {
        this.segTempopreparacao = segTempopreparacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolharap)) return false;
        DwFolharap other = (DwFolharap) obj;
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
            ((this.dwFolharapcoms==null && other.getDwFolharapcoms()==null) || 
             (this.dwFolharapcoms!=null &&
              java.util.Arrays.equals(this.dwFolharapcoms, other.getDwFolharapcoms()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.idFolharap==null && other.getIdFolharap()==null) || 
             (this.idFolharap!=null &&
              this.idFolharap.equals(other.getIdFolharap()))) &&
            ((this.qtUsada==null && other.getQtUsada()==null) || 
             (this.qtUsada!=null &&
              this.qtUsada.equals(other.getQtUsada()))) &&
            ((this.segTempopreparacao==null && other.getSegTempopreparacao()==null) || 
             (this.segTempopreparacao!=null &&
              this.segTempopreparacao.equals(other.getSegTempopreparacao())));
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
        if (getDwFolharapcoms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolharapcoms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolharapcoms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getIdFolharap() != null) {
            _hashCode += getIdFolharap().hashCode();
        }
        if (getQtUsada() != null) {
            _hashCode += getQtUsada().hashCode();
        }
        if (getSegTempopreparacao() != null) {
            _hashCode += getSegTempopreparacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolharap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolharap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolharapcoms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolharapcoms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolharapcom"));
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
        elemField.setFieldName("idFolharap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolharap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtUsada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtUsada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempopreparacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempopreparacao"));
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
