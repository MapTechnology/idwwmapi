/**
 * FiltroRelatorioIndiceParadasDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroRelatorioIndiceParadasDTO  implements java.io.Serializable {
    private java.lang.String cdop;

    private idw.idwws.DwRap dwRap;

    private idw.idwws.DwTParada dwTParada;

    private idw.idwws.DwRap gpDwRap;

    private java.lang.String horarios;

    private idw.idwws.OmGt omgt;

    private idw.idwws.OmPt ompt;

    private java.util.Calendar periodoFinal;

    private java.util.Calendar periodoInicial;

    private java.lang.String tipo;

    private idw.idwws.TurnoDTO turnoDTO;

    public FiltroRelatorioIndiceParadasDTO() {
    }

    public FiltroRelatorioIndiceParadasDTO(
           java.lang.String cdop,
           idw.idwws.DwRap dwRap,
           idw.idwws.DwTParada dwTParada,
           idw.idwws.DwRap gpDwRap,
           java.lang.String horarios,
           idw.idwws.OmGt omgt,
           idw.idwws.OmPt ompt,
           java.util.Calendar periodoFinal,
           java.util.Calendar periodoInicial,
           java.lang.String tipo,
           idw.idwws.TurnoDTO turnoDTO) {
           this.cdop = cdop;
           this.dwRap = dwRap;
           this.dwTParada = dwTParada;
           this.gpDwRap = gpDwRap;
           this.horarios = horarios;
           this.omgt = omgt;
           this.ompt = ompt;
           this.periodoFinal = periodoFinal;
           this.periodoInicial = periodoInicial;
           this.tipo = tipo;
           this.turnoDTO = turnoDTO;
    }


    /**
     * Gets the cdop value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return cdop
     */
    public java.lang.String getCdop() {
        return cdop;
    }


    /**
     * Sets the cdop value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param cdop
     */
    public void setCdop(java.lang.String cdop) {
        this.cdop = cdop;
    }


    /**
     * Gets the dwRap value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the dwTParada value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return dwTParada
     */
    public idw.idwws.DwTParada getDwTParada() {
        return dwTParada;
    }


    /**
     * Sets the dwTParada value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param dwTParada
     */
    public void setDwTParada(idw.idwws.DwTParada dwTParada) {
        this.dwTParada = dwTParada;
    }


    /**
     * Gets the gpDwRap value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return gpDwRap
     */
    public idw.idwws.DwRap getGpDwRap() {
        return gpDwRap;
    }


    /**
     * Sets the gpDwRap value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param gpDwRap
     */
    public void setGpDwRap(idw.idwws.DwRap gpDwRap) {
        this.gpDwRap = gpDwRap;
    }


    /**
     * Gets the horarios value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return horarios
     */
    public java.lang.String getHorarios() {
        return horarios;
    }


    /**
     * Sets the horarios value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param horarios
     */
    public void setHorarios(java.lang.String horarios) {
        this.horarios = horarios;
    }


    /**
     * Gets the omgt value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return omgt
     */
    public idw.idwws.OmGt getOmgt() {
        return omgt;
    }


    /**
     * Sets the omgt value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param omgt
     */
    public void setOmgt(idw.idwws.OmGt omgt) {
        this.omgt = omgt;
    }


    /**
     * Gets the ompt value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return ompt
     */
    public idw.idwws.OmPt getOmpt() {
        return ompt;
    }


    /**
     * Sets the ompt value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param ompt
     */
    public void setOmpt(idw.idwws.OmPt ompt) {
        this.ompt = ompt;
    }


    /**
     * Gets the periodoFinal value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return periodoFinal
     */
    public java.util.Calendar getPeriodoFinal() {
        return periodoFinal;
    }


    /**
     * Sets the periodoFinal value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param periodoFinal
     */
    public void setPeriodoFinal(java.util.Calendar periodoFinal) {
        this.periodoFinal = periodoFinal;
    }


    /**
     * Gets the periodoInicial value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return periodoInicial
     */
    public java.util.Calendar getPeriodoInicial() {
        return periodoInicial;
    }


    /**
     * Sets the periodoInicial value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param periodoInicial
     */
    public void setPeriodoInicial(java.util.Calendar periodoInicial) {
        this.periodoInicial = periodoInicial;
    }


    /**
     * Gets the tipo value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the turnoDTO value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @return turnoDTO
     */
    public idw.idwws.TurnoDTO getTurnoDTO() {
        return turnoDTO;
    }


    /**
     * Sets the turnoDTO value for this FiltroRelatorioIndiceParadasDTO.
     * 
     * @param turnoDTO
     */
    public void setTurnoDTO(idw.idwws.TurnoDTO turnoDTO) {
        this.turnoDTO = turnoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroRelatorioIndiceParadasDTO)) return false;
        FiltroRelatorioIndiceParadasDTO other = (FiltroRelatorioIndiceParadasDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdop==null && other.getCdop()==null) || 
             (this.cdop!=null &&
              this.cdop.equals(other.getCdop()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.dwTParada==null && other.getDwTParada()==null) || 
             (this.dwTParada!=null &&
              this.dwTParada.equals(other.getDwTParada()))) &&
            ((this.gpDwRap==null && other.getGpDwRap()==null) || 
             (this.gpDwRap!=null &&
              this.gpDwRap.equals(other.getGpDwRap()))) &&
            ((this.horarios==null && other.getHorarios()==null) || 
             (this.horarios!=null &&
              this.horarios.equals(other.getHorarios()))) &&
            ((this.omgt==null && other.getOmgt()==null) || 
             (this.omgt!=null &&
              this.omgt.equals(other.getOmgt()))) &&
            ((this.ompt==null && other.getOmpt()==null) || 
             (this.ompt!=null &&
              this.ompt.equals(other.getOmpt()))) &&
            ((this.periodoFinal==null && other.getPeriodoFinal()==null) || 
             (this.periodoFinal!=null &&
              this.periodoFinal.equals(other.getPeriodoFinal()))) &&
            ((this.periodoInicial==null && other.getPeriodoInicial()==null) || 
             (this.periodoInicial!=null &&
              this.periodoInicial.equals(other.getPeriodoInicial()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.turnoDTO==null && other.getTurnoDTO()==null) || 
             (this.turnoDTO!=null &&
              this.turnoDTO.equals(other.getTurnoDTO())));
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
        if (getCdop() != null) {
            _hashCode += getCdop().hashCode();
        }
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getDwTParada() != null) {
            _hashCode += getDwTParada().hashCode();
        }
        if (getGpDwRap() != null) {
            _hashCode += getGpDwRap().hashCode();
        }
        if (getHorarios() != null) {
            _hashCode += getHorarios().hashCode();
        }
        if (getOmgt() != null) {
            _hashCode += getOmgt().hashCode();
        }
        if (getOmpt() != null) {
            _hashCode += getOmpt().hashCode();
        }
        if (getPeriodoFinal() != null) {
            _hashCode += getPeriodoFinal().hashCode();
        }
        if (getPeriodoInicial() != null) {
            _hashCode += getPeriodoInicial().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getTurnoDTO() != null) {
            _hashCode += getTurnoDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroRelatorioIndiceParadasDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroRelatorioIndiceParadasDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gpDwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gpDwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horarios");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horarios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omgt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omgt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ompt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ompt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodoFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodoFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodoInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodoInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turnoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "turnoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "turnoDTO"));
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
