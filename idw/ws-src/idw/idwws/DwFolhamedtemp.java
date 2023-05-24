/**
 * DwFolhamedtemp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhamedtemp  extends idw.idwws.DwFolhamedtempTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwFolhamedtemhor[] dwFolhamedtemhors;

    private java.math.BigDecimal idFolhamedtemp;

    private java.math.BigDecimal qtArmazenamento;

    private java.math.BigDecimal segIntervaloLeitura;

    private java.math.BigDecimal tpArmazenamento;

    public DwFolhamedtemp() {
    }

    public DwFolhamedtemp(
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwFolhamedtemhor[] dwFolhamedtemhors,
           java.math.BigDecimal idFolhamedtemp,
           java.math.BigDecimal qtArmazenamento,
           java.math.BigDecimal segIntervaloLeitura,
           java.math.BigDecimal tpArmazenamento) {
        this.dwFolha = dwFolha;
        this.dwFolhamedtemhors = dwFolhamedtemhors;
        this.idFolhamedtemp = idFolhamedtemp;
        this.qtArmazenamento = qtArmazenamento;
        this.segIntervaloLeitura = segIntervaloLeitura;
        this.tpArmazenamento = tpArmazenamento;
    }


    /**
     * Gets the dwFolha value for this DwFolhamedtemp.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwFolhamedtemp.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwFolhamedtemhors value for this DwFolhamedtemp.
     * 
     * @return dwFolhamedtemhors
     */
    public idw.idwws.DwFolhamedtemhor[] getDwFolhamedtemhors() {
        return dwFolhamedtemhors;
    }


    /**
     * Sets the dwFolhamedtemhors value for this DwFolhamedtemp.
     * 
     * @param dwFolhamedtemhors
     */
    public void setDwFolhamedtemhors(idw.idwws.DwFolhamedtemhor[] dwFolhamedtemhors) {
        this.dwFolhamedtemhors = dwFolhamedtemhors;
    }

    public idw.idwws.DwFolhamedtemhor getDwFolhamedtemhors(int i) {
        return this.dwFolhamedtemhors[i];
    }

    public void setDwFolhamedtemhors(int i, idw.idwws.DwFolhamedtemhor _value) {
        this.dwFolhamedtemhors[i] = _value;
    }


    /**
     * Gets the idFolhamedtemp value for this DwFolhamedtemp.
     * 
     * @return idFolhamedtemp
     */
    public java.math.BigDecimal getIdFolhamedtemp() {
        return idFolhamedtemp;
    }


    /**
     * Sets the idFolhamedtemp value for this DwFolhamedtemp.
     * 
     * @param idFolhamedtemp
     */
    public void setIdFolhamedtemp(java.math.BigDecimal idFolhamedtemp) {
        this.idFolhamedtemp = idFolhamedtemp;
    }


    /**
     * Gets the qtArmazenamento value for this DwFolhamedtemp.
     * 
     * @return qtArmazenamento
     */
    public java.math.BigDecimal getQtArmazenamento() {
        return qtArmazenamento;
    }


    /**
     * Sets the qtArmazenamento value for this DwFolhamedtemp.
     * 
     * @param qtArmazenamento
     */
    public void setQtArmazenamento(java.math.BigDecimal qtArmazenamento) {
        this.qtArmazenamento = qtArmazenamento;
    }


    /**
     * Gets the segIntervaloLeitura value for this DwFolhamedtemp.
     * 
     * @return segIntervaloLeitura
     */
    public java.math.BigDecimal getSegIntervaloLeitura() {
        return segIntervaloLeitura;
    }


    /**
     * Sets the segIntervaloLeitura value for this DwFolhamedtemp.
     * 
     * @param segIntervaloLeitura
     */
    public void setSegIntervaloLeitura(java.math.BigDecimal segIntervaloLeitura) {
        this.segIntervaloLeitura = segIntervaloLeitura;
    }


    /**
     * Gets the tpArmazenamento value for this DwFolhamedtemp.
     * 
     * @return tpArmazenamento
     */
    public java.math.BigDecimal getTpArmazenamento() {
        return tpArmazenamento;
    }


    /**
     * Sets the tpArmazenamento value for this DwFolhamedtemp.
     * 
     * @param tpArmazenamento
     */
    public void setTpArmazenamento(java.math.BigDecimal tpArmazenamento) {
        this.tpArmazenamento = tpArmazenamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhamedtemp)) return false;
        DwFolhamedtemp other = (DwFolhamedtemp) obj;
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
            ((this.dwFolhamedtemhors==null && other.getDwFolhamedtemhors()==null) || 
             (this.dwFolhamedtemhors!=null &&
              java.util.Arrays.equals(this.dwFolhamedtemhors, other.getDwFolhamedtemhors()))) &&
            ((this.idFolhamedtemp==null && other.getIdFolhamedtemp()==null) || 
             (this.idFolhamedtemp!=null &&
              this.idFolhamedtemp.equals(other.getIdFolhamedtemp()))) &&
            ((this.qtArmazenamento==null && other.getQtArmazenamento()==null) || 
             (this.qtArmazenamento!=null &&
              this.qtArmazenamento.equals(other.getQtArmazenamento()))) &&
            ((this.segIntervaloLeitura==null && other.getSegIntervaloLeitura()==null) || 
             (this.segIntervaloLeitura!=null &&
              this.segIntervaloLeitura.equals(other.getSegIntervaloLeitura()))) &&
            ((this.tpArmazenamento==null && other.getTpArmazenamento()==null) || 
             (this.tpArmazenamento!=null &&
              this.tpArmazenamento.equals(other.getTpArmazenamento())));
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
        if (getDwFolhamedtemhors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhamedtemhors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhamedtemhors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdFolhamedtemp() != null) {
            _hashCode += getIdFolhamedtemp().hashCode();
        }
        if (getQtArmazenamento() != null) {
            _hashCode += getQtArmazenamento().hashCode();
        }
        if (getSegIntervaloLeitura() != null) {
            _hashCode += getSegIntervaloLeitura().hashCode();
        }
        if (getTpArmazenamento() != null) {
            _hashCode += getTpArmazenamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhamedtemp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamedtemhors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamedtemhors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemhor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhamedtemp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhamedtemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtArmazenamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtArmazenamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segIntervaloLeitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segIntervaloLeitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpArmazenamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpArmazenamento"));
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
