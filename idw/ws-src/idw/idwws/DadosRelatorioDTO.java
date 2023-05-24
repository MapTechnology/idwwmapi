/**
 * DadosRelatorioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DadosRelatorioDTO  implements java.io.Serializable {
    private java.util.Calendar dateFimApont;

    private java.util.Calendar dateFimPlan;

    private java.util.Calendar dateInicioApont;

    private java.util.Calendar dateInicioPlan;

    private idw.idwws.RelatoriosDTO[] listaRelatorios;

    private idw.idwws.PpNec ppnec;

    private idw.idwws.ResultadoDTO result;

    public DadosRelatorioDTO() {
    }

    public DadosRelatorioDTO(
           java.util.Calendar dateFimApont,
           java.util.Calendar dateFimPlan,
           java.util.Calendar dateInicioApont,
           java.util.Calendar dateInicioPlan,
           idw.idwws.RelatoriosDTO[] listaRelatorios,
           idw.idwws.PpNec ppnec,
           idw.idwws.ResultadoDTO result) {
           this.dateFimApont = dateFimApont;
           this.dateFimPlan = dateFimPlan;
           this.dateInicioApont = dateInicioApont;
           this.dateInicioPlan = dateInicioPlan;
           this.listaRelatorios = listaRelatorios;
           this.ppnec = ppnec;
           this.result = result;
    }


    /**
     * Gets the dateFimApont value for this DadosRelatorioDTO.
     * 
     * @return dateFimApont
     */
    public java.util.Calendar getDateFimApont() {
        return dateFimApont;
    }


    /**
     * Sets the dateFimApont value for this DadosRelatorioDTO.
     * 
     * @param dateFimApont
     */
    public void setDateFimApont(java.util.Calendar dateFimApont) {
        this.dateFimApont = dateFimApont;
    }


    /**
     * Gets the dateFimPlan value for this DadosRelatorioDTO.
     * 
     * @return dateFimPlan
     */
    public java.util.Calendar getDateFimPlan() {
        return dateFimPlan;
    }


    /**
     * Sets the dateFimPlan value for this DadosRelatorioDTO.
     * 
     * @param dateFimPlan
     */
    public void setDateFimPlan(java.util.Calendar dateFimPlan) {
        this.dateFimPlan = dateFimPlan;
    }


    /**
     * Gets the dateInicioApont value for this DadosRelatorioDTO.
     * 
     * @return dateInicioApont
     */
    public java.util.Calendar getDateInicioApont() {
        return dateInicioApont;
    }


    /**
     * Sets the dateInicioApont value for this DadosRelatorioDTO.
     * 
     * @param dateInicioApont
     */
    public void setDateInicioApont(java.util.Calendar dateInicioApont) {
        this.dateInicioApont = dateInicioApont;
    }


    /**
     * Gets the dateInicioPlan value for this DadosRelatorioDTO.
     * 
     * @return dateInicioPlan
     */
    public java.util.Calendar getDateInicioPlan() {
        return dateInicioPlan;
    }


    /**
     * Sets the dateInicioPlan value for this DadosRelatorioDTO.
     * 
     * @param dateInicioPlan
     */
    public void setDateInicioPlan(java.util.Calendar dateInicioPlan) {
        this.dateInicioPlan = dateInicioPlan;
    }


    /**
     * Gets the listaRelatorios value for this DadosRelatorioDTO.
     * 
     * @return listaRelatorios
     */
    public idw.idwws.RelatoriosDTO[] getListaRelatorios() {
        return listaRelatorios;
    }


    /**
     * Sets the listaRelatorios value for this DadosRelatorioDTO.
     * 
     * @param listaRelatorios
     */
    public void setListaRelatorios(idw.idwws.RelatoriosDTO[] listaRelatorios) {
        this.listaRelatorios = listaRelatorios;
    }

    public idw.idwws.RelatoriosDTO getListaRelatorios(int i) {
        return this.listaRelatorios[i];
    }

    public void setListaRelatorios(int i, idw.idwws.RelatoriosDTO _value) {
        this.listaRelatorios[i] = _value;
    }


    /**
     * Gets the ppnec value for this DadosRelatorioDTO.
     * 
     * @return ppnec
     */
    public idw.idwws.PpNec getPpnec() {
        return ppnec;
    }


    /**
     * Sets the ppnec value for this DadosRelatorioDTO.
     * 
     * @param ppnec
     */
    public void setPpnec(idw.idwws.PpNec ppnec) {
        this.ppnec = ppnec;
    }


    /**
     * Gets the result value for this DadosRelatorioDTO.
     * 
     * @return result
     */
    public idw.idwws.ResultadoDTO getResult() {
        return result;
    }


    /**
     * Sets the result value for this DadosRelatorioDTO.
     * 
     * @param result
     */
    public void setResult(idw.idwws.ResultadoDTO result) {
        this.result = result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosRelatorioDTO)) return false;
        DadosRelatorioDTO other = (DadosRelatorioDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateFimApont==null && other.getDateFimApont()==null) || 
             (this.dateFimApont!=null &&
              this.dateFimApont.equals(other.getDateFimApont()))) &&
            ((this.dateFimPlan==null && other.getDateFimPlan()==null) || 
             (this.dateFimPlan!=null &&
              this.dateFimPlan.equals(other.getDateFimPlan()))) &&
            ((this.dateInicioApont==null && other.getDateInicioApont()==null) || 
             (this.dateInicioApont!=null &&
              this.dateInicioApont.equals(other.getDateInicioApont()))) &&
            ((this.dateInicioPlan==null && other.getDateInicioPlan()==null) || 
             (this.dateInicioPlan!=null &&
              this.dateInicioPlan.equals(other.getDateInicioPlan()))) &&
            ((this.listaRelatorios==null && other.getListaRelatorios()==null) || 
             (this.listaRelatorios!=null &&
              java.util.Arrays.equals(this.listaRelatorios, other.getListaRelatorios()))) &&
            ((this.ppnec==null && other.getPpnec()==null) || 
             (this.ppnec!=null &&
              this.ppnec.equals(other.getPpnec()))) &&
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult())));
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
        if (getDateFimApont() != null) {
            _hashCode += getDateFimApont().hashCode();
        }
        if (getDateFimPlan() != null) {
            _hashCode += getDateFimPlan().hashCode();
        }
        if (getDateInicioApont() != null) {
            _hashCode += getDateInicioApont().hashCode();
        }
        if (getDateInicioPlan() != null) {
            _hashCode += getDateInicioPlan().hashCode();
        }
        if (getListaRelatorios() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaRelatorios());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaRelatorios(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpnec() != null) {
            _hashCode += getPpnec().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosRelatorioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dadosRelatorioDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateFimApont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateFimApont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateFimPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateFimPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateInicioApont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateInicioApont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateInicioPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateInicioPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaRelatorios");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaRelatorios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "relatoriosDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppnec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppnec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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
