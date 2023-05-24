/**
 * CicloInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CicloInjetDTO  implements java.io.Serializable {
    private java.lang.Float ciclopadrao;

    private java.util.Calendar dthrfciclo;

    private java.util.Calendar dthriciclo;

    private java.lang.Float duracao;

    private java.lang.Float eficienciaCiclo;

    public CicloInjetDTO() {
    }

    public CicloInjetDTO(
           java.lang.Float ciclopadrao,
           java.util.Calendar dthrfciclo,
           java.util.Calendar dthriciclo,
           java.lang.Float duracao,
           java.lang.Float eficienciaCiclo) {
           this.ciclopadrao = ciclopadrao;
           this.dthrfciclo = dthrfciclo;
           this.dthriciclo = dthriciclo;
           this.duracao = duracao;
           this.eficienciaCiclo = eficienciaCiclo;
    }


    /**
     * Gets the ciclopadrao value for this CicloInjetDTO.
     * 
     * @return ciclopadrao
     */
    public java.lang.Float getCiclopadrao() {
        return ciclopadrao;
    }


    /**
     * Sets the ciclopadrao value for this CicloInjetDTO.
     * 
     * @param ciclopadrao
     */
    public void setCiclopadrao(java.lang.Float ciclopadrao) {
        this.ciclopadrao = ciclopadrao;
    }


    /**
     * Gets the dthrfciclo value for this CicloInjetDTO.
     * 
     * @return dthrfciclo
     */
    public java.util.Calendar getDthrfciclo() {
        return dthrfciclo;
    }


    /**
     * Sets the dthrfciclo value for this CicloInjetDTO.
     * 
     * @param dthrfciclo
     */
    public void setDthrfciclo(java.util.Calendar dthrfciclo) {
        this.dthrfciclo = dthrfciclo;
    }


    /**
     * Gets the dthriciclo value for this CicloInjetDTO.
     * 
     * @return dthriciclo
     */
    public java.util.Calendar getDthriciclo() {
        return dthriciclo;
    }


    /**
     * Sets the dthriciclo value for this CicloInjetDTO.
     * 
     * @param dthriciclo
     */
    public void setDthriciclo(java.util.Calendar dthriciclo) {
        this.dthriciclo = dthriciclo;
    }


    /**
     * Gets the duracao value for this CicloInjetDTO.
     * 
     * @return duracao
     */
    public java.lang.Float getDuracao() {
        return duracao;
    }


    /**
     * Sets the duracao value for this CicloInjetDTO.
     * 
     * @param duracao
     */
    public void setDuracao(java.lang.Float duracao) {
        this.duracao = duracao;
    }


    /**
     * Gets the eficienciaCiclo value for this CicloInjetDTO.
     * 
     * @return eficienciaCiclo
     */
    public java.lang.Float getEficienciaCiclo() {
        return eficienciaCiclo;
    }


    /**
     * Sets the eficienciaCiclo value for this CicloInjetDTO.
     * 
     * @param eficienciaCiclo
     */
    public void setEficienciaCiclo(java.lang.Float eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CicloInjetDTO)) return false;
        CicloInjetDTO other = (CicloInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ciclopadrao==null && other.getCiclopadrao()==null) || 
             (this.ciclopadrao!=null &&
              this.ciclopadrao.equals(other.getCiclopadrao()))) &&
            ((this.dthrfciclo==null && other.getDthrfciclo()==null) || 
             (this.dthrfciclo!=null &&
              this.dthrfciclo.equals(other.getDthrfciclo()))) &&
            ((this.dthriciclo==null && other.getDthriciclo()==null) || 
             (this.dthriciclo!=null &&
              this.dthriciclo.equals(other.getDthriciclo()))) &&
            ((this.duracao==null && other.getDuracao()==null) || 
             (this.duracao!=null &&
              this.duracao.equals(other.getDuracao()))) &&
            ((this.eficienciaCiclo==null && other.getEficienciaCiclo()==null) || 
             (this.eficienciaCiclo!=null &&
              this.eficienciaCiclo.equals(other.getEficienciaCiclo())));
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
        if (getCiclopadrao() != null) {
            _hashCode += getCiclopadrao().hashCode();
        }
        if (getDthrfciclo() != null) {
            _hashCode += getDthrfciclo().hashCode();
        }
        if (getDthriciclo() != null) {
            _hashCode += getDthriciclo().hashCode();
        }
        if (getDuracao() != null) {
            _hashCode += getDuracao().hashCode();
        }
        if (getEficienciaCiclo() != null) {
            _hashCode += getEficienciaCiclo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CicloInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cicloInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
