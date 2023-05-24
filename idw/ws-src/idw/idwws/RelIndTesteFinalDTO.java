/**
 * RelIndTesteFinalDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class RelIndTesteFinalDTO  implements java.io.Serializable {
    private java.util.Calendar fimMelhorIndice;

    private java.util.Calendar fimPiorIndice;

    private java.util.Calendar inicioMelhorIndice;

    private java.util.Calendar inicioPiorIndice;

    private java.lang.Double melhorIndice;

    private idw.idwws.SerieParettoDTO[] parettos;

    private java.lang.Double piorIndice;

    private java.lang.String[] plataformasSelecionadas;

    private idw.idwws.SerieTaxaFalhaDTO[] taxas;

    public RelIndTesteFinalDTO() {
    }

    public RelIndTesteFinalDTO(
           java.util.Calendar fimMelhorIndice,
           java.util.Calendar fimPiorIndice,
           java.util.Calendar inicioMelhorIndice,
           java.util.Calendar inicioPiorIndice,
           java.lang.Double melhorIndice,
           idw.idwws.SerieParettoDTO[] parettos,
           java.lang.Double piorIndice,
           java.lang.String[] plataformasSelecionadas,
           idw.idwws.SerieTaxaFalhaDTO[] taxas) {
           this.fimMelhorIndice = fimMelhorIndice;
           this.fimPiorIndice = fimPiorIndice;
           this.inicioMelhorIndice = inicioMelhorIndice;
           this.inicioPiorIndice = inicioPiorIndice;
           this.melhorIndice = melhorIndice;
           this.parettos = parettos;
           this.piorIndice = piorIndice;
           this.plataformasSelecionadas = plataformasSelecionadas;
           this.taxas = taxas;
    }


    /**
     * Gets the fimMelhorIndice value for this RelIndTesteFinalDTO.
     * 
     * @return fimMelhorIndice
     */
    public java.util.Calendar getFimMelhorIndice() {
        return fimMelhorIndice;
    }


    /**
     * Sets the fimMelhorIndice value for this RelIndTesteFinalDTO.
     * 
     * @param fimMelhorIndice
     */
    public void setFimMelhorIndice(java.util.Calendar fimMelhorIndice) {
        this.fimMelhorIndice = fimMelhorIndice;
    }


    /**
     * Gets the fimPiorIndice value for this RelIndTesteFinalDTO.
     * 
     * @return fimPiorIndice
     */
    public java.util.Calendar getFimPiorIndice() {
        return fimPiorIndice;
    }


    /**
     * Sets the fimPiorIndice value for this RelIndTesteFinalDTO.
     * 
     * @param fimPiorIndice
     */
    public void setFimPiorIndice(java.util.Calendar fimPiorIndice) {
        this.fimPiorIndice = fimPiorIndice;
    }


    /**
     * Gets the inicioMelhorIndice value for this RelIndTesteFinalDTO.
     * 
     * @return inicioMelhorIndice
     */
    public java.util.Calendar getInicioMelhorIndice() {
        return inicioMelhorIndice;
    }


    /**
     * Sets the inicioMelhorIndice value for this RelIndTesteFinalDTO.
     * 
     * @param inicioMelhorIndice
     */
    public void setInicioMelhorIndice(java.util.Calendar inicioMelhorIndice) {
        this.inicioMelhorIndice = inicioMelhorIndice;
    }


    /**
     * Gets the inicioPiorIndice value for this RelIndTesteFinalDTO.
     * 
     * @return inicioPiorIndice
     */
    public java.util.Calendar getInicioPiorIndice() {
        return inicioPiorIndice;
    }


    /**
     * Sets the inicioPiorIndice value for this RelIndTesteFinalDTO.
     * 
     * @param inicioPiorIndice
     */
    public void setInicioPiorIndice(java.util.Calendar inicioPiorIndice) {
        this.inicioPiorIndice = inicioPiorIndice;
    }


    /**
     * Gets the melhorIndice value for this RelIndTesteFinalDTO.
     * 
     * @return melhorIndice
     */
    public java.lang.Double getMelhorIndice() {
        return melhorIndice;
    }


    /**
     * Sets the melhorIndice value for this RelIndTesteFinalDTO.
     * 
     * @param melhorIndice
     */
    public void setMelhorIndice(java.lang.Double melhorIndice) {
        this.melhorIndice = melhorIndice;
    }


    /**
     * Gets the parettos value for this RelIndTesteFinalDTO.
     * 
     * @return parettos
     */
    public idw.idwws.SerieParettoDTO[] getParettos() {
        return parettos;
    }


    /**
     * Sets the parettos value for this RelIndTesteFinalDTO.
     * 
     * @param parettos
     */
    public void setParettos(idw.idwws.SerieParettoDTO[] parettos) {
        this.parettos = parettos;
    }

    public idw.idwws.SerieParettoDTO getParettos(int i) {
        return this.parettos[i];
    }

    public void setParettos(int i, idw.idwws.SerieParettoDTO _value) {
        this.parettos[i] = _value;
    }


    /**
     * Gets the piorIndice value for this RelIndTesteFinalDTO.
     * 
     * @return piorIndice
     */
    public java.lang.Double getPiorIndice() {
        return piorIndice;
    }


    /**
     * Sets the piorIndice value for this RelIndTesteFinalDTO.
     * 
     * @param piorIndice
     */
    public void setPiorIndice(java.lang.Double piorIndice) {
        this.piorIndice = piorIndice;
    }


    /**
     * Gets the plataformasSelecionadas value for this RelIndTesteFinalDTO.
     * 
     * @return plataformasSelecionadas
     */
    public java.lang.String[] getPlataformasSelecionadas() {
        return plataformasSelecionadas;
    }


    /**
     * Sets the plataformasSelecionadas value for this RelIndTesteFinalDTO.
     * 
     * @param plataformasSelecionadas
     */
    public void setPlataformasSelecionadas(java.lang.String[] plataformasSelecionadas) {
        this.plataformasSelecionadas = plataformasSelecionadas;
    }

    public java.lang.String getPlataformasSelecionadas(int i) {
        return this.plataformasSelecionadas[i];
    }

    public void setPlataformasSelecionadas(int i, java.lang.String _value) {
        this.plataformasSelecionadas[i] = _value;
    }


    /**
     * Gets the taxas value for this RelIndTesteFinalDTO.
     * 
     * @return taxas
     */
    public idw.idwws.SerieTaxaFalhaDTO[] getTaxas() {
        return taxas;
    }


    /**
     * Sets the taxas value for this RelIndTesteFinalDTO.
     * 
     * @param taxas
     */
    public void setTaxas(idw.idwws.SerieTaxaFalhaDTO[] taxas) {
        this.taxas = taxas;
    }

    public idw.idwws.SerieTaxaFalhaDTO getTaxas(int i) {
        return this.taxas[i];
    }

    public void setTaxas(int i, idw.idwws.SerieTaxaFalhaDTO _value) {
        this.taxas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelIndTesteFinalDTO)) return false;
        RelIndTesteFinalDTO other = (RelIndTesteFinalDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fimMelhorIndice==null && other.getFimMelhorIndice()==null) || 
             (this.fimMelhorIndice!=null &&
              this.fimMelhorIndice.equals(other.getFimMelhorIndice()))) &&
            ((this.fimPiorIndice==null && other.getFimPiorIndice()==null) || 
             (this.fimPiorIndice!=null &&
              this.fimPiorIndice.equals(other.getFimPiorIndice()))) &&
            ((this.inicioMelhorIndice==null && other.getInicioMelhorIndice()==null) || 
             (this.inicioMelhorIndice!=null &&
              this.inicioMelhorIndice.equals(other.getInicioMelhorIndice()))) &&
            ((this.inicioPiorIndice==null && other.getInicioPiorIndice()==null) || 
             (this.inicioPiorIndice!=null &&
              this.inicioPiorIndice.equals(other.getInicioPiorIndice()))) &&
            ((this.melhorIndice==null && other.getMelhorIndice()==null) || 
             (this.melhorIndice!=null &&
              this.melhorIndice.equals(other.getMelhorIndice()))) &&
            ((this.parettos==null && other.getParettos()==null) || 
             (this.parettos!=null &&
              java.util.Arrays.equals(this.parettos, other.getParettos()))) &&
            ((this.piorIndice==null && other.getPiorIndice()==null) || 
             (this.piorIndice!=null &&
              this.piorIndice.equals(other.getPiorIndice()))) &&
            ((this.plataformasSelecionadas==null && other.getPlataformasSelecionadas()==null) || 
             (this.plataformasSelecionadas!=null &&
              java.util.Arrays.equals(this.plataformasSelecionadas, other.getPlataformasSelecionadas()))) &&
            ((this.taxas==null && other.getTaxas()==null) || 
             (this.taxas!=null &&
              java.util.Arrays.equals(this.taxas, other.getTaxas())));
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
        if (getFimMelhorIndice() != null) {
            _hashCode += getFimMelhorIndice().hashCode();
        }
        if (getFimPiorIndice() != null) {
            _hashCode += getFimPiorIndice().hashCode();
        }
        if (getInicioMelhorIndice() != null) {
            _hashCode += getInicioMelhorIndice().hashCode();
        }
        if (getInicioPiorIndice() != null) {
            _hashCode += getInicioPiorIndice().hashCode();
        }
        if (getMelhorIndice() != null) {
            _hashCode += getMelhorIndice().hashCode();
        }
        if (getParettos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParettos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParettos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPiorIndice() != null) {
            _hashCode += getPiorIndice().hashCode();
        }
        if (getPlataformasSelecionadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPlataformasSelecionadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPlataformasSelecionadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTaxas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTaxas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTaxas(), i);
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
        new org.apache.axis.description.TypeDesc(RelIndTesteFinalDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "relIndTesteFinalDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimMelhorIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimMelhorIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimPiorIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimPiorIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioMelhorIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioMelhorIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioPiorIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioPiorIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("melhorIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "melhorIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parettos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parettos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "serieParettoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("piorIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "piorIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plataformasSelecionadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plataformasSelecionadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "serieTaxaFalhaDTO"));
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
