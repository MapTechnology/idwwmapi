/**
 * EficienciaCicloInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EficienciaCicloInjetDTO  implements java.io.Serializable {
    private java.lang.String cdEstrutura;

    private java.lang.String cdInjetora;

    private java.lang.String cdMolde;

    private java.math.BigDecimal cicloPadrao;

    private java.util.Calendar dthrvalcic;

    private java.math.BigDecimal qtinjnormal;

    private java.math.BigDecimal tmpcicnormal;

    public EficienciaCicloInjetDTO() {
    }

    public EficienciaCicloInjetDTO(
           java.lang.String cdEstrutura,
           java.lang.String cdInjetora,
           java.lang.String cdMolde,
           java.math.BigDecimal cicloPadrao,
           java.util.Calendar dthrvalcic,
           java.math.BigDecimal qtinjnormal,
           java.math.BigDecimal tmpcicnormal) {
           this.cdEstrutura = cdEstrutura;
           this.cdInjetora = cdInjetora;
           this.cdMolde = cdMolde;
           this.cicloPadrao = cicloPadrao;
           this.dthrvalcic = dthrvalcic;
           this.qtinjnormal = qtinjnormal;
           this.tmpcicnormal = tmpcicnormal;
    }


    /**
     * Gets the cdEstrutura value for this EficienciaCicloInjetDTO.
     * 
     * @return cdEstrutura
     */
    public java.lang.String getCdEstrutura() {
        return cdEstrutura;
    }


    /**
     * Sets the cdEstrutura value for this EficienciaCicloInjetDTO.
     * 
     * @param cdEstrutura
     */
    public void setCdEstrutura(java.lang.String cdEstrutura) {
        this.cdEstrutura = cdEstrutura;
    }


    /**
     * Gets the cdInjetora value for this EficienciaCicloInjetDTO.
     * 
     * @return cdInjetora
     */
    public java.lang.String getCdInjetora() {
        return cdInjetora;
    }


    /**
     * Sets the cdInjetora value for this EficienciaCicloInjetDTO.
     * 
     * @param cdInjetora
     */
    public void setCdInjetora(java.lang.String cdInjetora) {
        this.cdInjetora = cdInjetora;
    }


    /**
     * Gets the cdMolde value for this EficienciaCicloInjetDTO.
     * 
     * @return cdMolde
     */
    public java.lang.String getCdMolde() {
        return cdMolde;
    }


    /**
     * Sets the cdMolde value for this EficienciaCicloInjetDTO.
     * 
     * @param cdMolde
     */
    public void setCdMolde(java.lang.String cdMolde) {
        this.cdMolde = cdMolde;
    }


    /**
     * Gets the cicloPadrao value for this EficienciaCicloInjetDTO.
     * 
     * @return cicloPadrao
     */
    public java.math.BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }


    /**
     * Sets the cicloPadrao value for this EficienciaCicloInjetDTO.
     * 
     * @param cicloPadrao
     */
    public void setCicloPadrao(java.math.BigDecimal cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }


    /**
     * Gets the dthrvalcic value for this EficienciaCicloInjetDTO.
     * 
     * @return dthrvalcic
     */
    public java.util.Calendar getDthrvalcic() {
        return dthrvalcic;
    }


    /**
     * Sets the dthrvalcic value for this EficienciaCicloInjetDTO.
     * 
     * @param dthrvalcic
     */
    public void setDthrvalcic(java.util.Calendar dthrvalcic) {
        this.dthrvalcic = dthrvalcic;
    }


    /**
     * Gets the qtinjnormal value for this EficienciaCicloInjetDTO.
     * 
     * @return qtinjnormal
     */
    public java.math.BigDecimal getQtinjnormal() {
        return qtinjnormal;
    }


    /**
     * Sets the qtinjnormal value for this EficienciaCicloInjetDTO.
     * 
     * @param qtinjnormal
     */
    public void setQtinjnormal(java.math.BigDecimal qtinjnormal) {
        this.qtinjnormal = qtinjnormal;
    }


    /**
     * Gets the tmpcicnormal value for this EficienciaCicloInjetDTO.
     * 
     * @return tmpcicnormal
     */
    public java.math.BigDecimal getTmpcicnormal() {
        return tmpcicnormal;
    }


    /**
     * Sets the tmpcicnormal value for this EficienciaCicloInjetDTO.
     * 
     * @param tmpcicnormal
     */
    public void setTmpcicnormal(java.math.BigDecimal tmpcicnormal) {
        this.tmpcicnormal = tmpcicnormal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EficienciaCicloInjetDTO)) return false;
        EficienciaCicloInjetDTO other = (EficienciaCicloInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdEstrutura==null && other.getCdEstrutura()==null) || 
             (this.cdEstrutura!=null &&
              this.cdEstrutura.equals(other.getCdEstrutura()))) &&
            ((this.cdInjetora==null && other.getCdInjetora()==null) || 
             (this.cdInjetora!=null &&
              this.cdInjetora.equals(other.getCdInjetora()))) &&
            ((this.cdMolde==null && other.getCdMolde()==null) || 
             (this.cdMolde!=null &&
              this.cdMolde.equals(other.getCdMolde()))) &&
            ((this.cicloPadrao==null && other.getCicloPadrao()==null) || 
             (this.cicloPadrao!=null &&
              this.cicloPadrao.equals(other.getCicloPadrao()))) &&
            ((this.dthrvalcic==null && other.getDthrvalcic()==null) || 
             (this.dthrvalcic!=null &&
              this.dthrvalcic.equals(other.getDthrvalcic()))) &&
            ((this.qtinjnormal==null && other.getQtinjnormal()==null) || 
             (this.qtinjnormal!=null &&
              this.qtinjnormal.equals(other.getQtinjnormal()))) &&
            ((this.tmpcicnormal==null && other.getTmpcicnormal()==null) || 
             (this.tmpcicnormal!=null &&
              this.tmpcicnormal.equals(other.getTmpcicnormal())));
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
        if (getCdEstrutura() != null) {
            _hashCode += getCdEstrutura().hashCode();
        }
        if (getCdInjetora() != null) {
            _hashCode += getCdInjetora().hashCode();
        }
        if (getCdMolde() != null) {
            _hashCode += getCdMolde().hashCode();
        }
        if (getCicloPadrao() != null) {
            _hashCode += getCicloPadrao().hashCode();
        }
        if (getDthrvalcic() != null) {
            _hashCode += getDthrvalcic().hashCode();
        }
        if (getQtinjnormal() != null) {
            _hashCode += getQtinjnormal().hashCode();
        }
        if (getTmpcicnormal() != null) {
            _hashCode += getTmpcicnormal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EficienciaCicloInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eficienciaCicloInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdEstrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdEstrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdInjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdInjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrvalcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrvalcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtinjnormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtinjnormal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpcicnormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpcicnormal"));
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
