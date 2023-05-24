/**
 * FiltroGraficoDetalhePtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroGraficoDetalhePtDTO  implements java.io.Serializable {
    private java.lang.Integer anoFinal;

    private java.lang.Integer anoInicial;

    private boolean comParadas;

    private java.util.Calendar dtReferencia;

    private java.util.Calendar dtReferenciaFinal;

    private java.util.Calendar dtReferenciaInicial;

    private java.util.Calendar dthrFhora;

    private java.util.Calendar dthrFturno;

    private java.util.Calendar dthrIhora;

    private java.util.Calendar dthrIturno;

    private idw.idwws.DwTParada dwTParada;

    private idw.idwws.DwTurno dwTurno;

    private idw.idwws.DwFolha dwfolha;

    private java.lang.Long idCp;

    private long idrt;

    private java.lang.Integer mesFinal;

    private java.lang.Integer mesInicial;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.PpCp ppCp;

    private java.lang.Byte tpId;

    public FiltroGraficoDetalhePtDTO() {
    }

    public FiltroGraficoDetalhePtDTO(
           java.lang.Integer anoFinal,
           java.lang.Integer anoInicial,
           boolean comParadas,
           java.util.Calendar dtReferencia,
           java.util.Calendar dtReferenciaFinal,
           java.util.Calendar dtReferenciaInicial,
           java.util.Calendar dthrFhora,
           java.util.Calendar dthrFturno,
           java.util.Calendar dthrIhora,
           java.util.Calendar dthrIturno,
           idw.idwws.DwTParada dwTParada,
           idw.idwws.DwTurno dwTurno,
           idw.idwws.DwFolha dwfolha,
           java.lang.Long idCp,
           long idrt,
           java.lang.Integer mesFinal,
           java.lang.Integer mesInicial,
           idw.idwws.OmGt omGt,
           idw.idwws.OmPt omPt,
           idw.idwws.PpCp ppCp,
           java.lang.Byte tpId) {
           this.anoFinal = anoFinal;
           this.anoInicial = anoInicial;
           this.comParadas = comParadas;
           this.dtReferencia = dtReferencia;
           this.dtReferenciaFinal = dtReferenciaFinal;
           this.dtReferenciaInicial = dtReferenciaInicial;
           this.dthrFhora = dthrFhora;
           this.dthrFturno = dthrFturno;
           this.dthrIhora = dthrIhora;
           this.dthrIturno = dthrIturno;
           this.dwTParada = dwTParada;
           this.dwTurno = dwTurno;
           this.dwfolha = dwfolha;
           this.idCp = idCp;
           this.idrt = idrt;
           this.mesFinal = mesFinal;
           this.mesInicial = mesInicial;
           this.omGt = omGt;
           this.omPt = omPt;
           this.ppCp = ppCp;
           this.tpId = tpId;
    }


    /**
     * Gets the anoFinal value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return anoFinal
     */
    public java.lang.Integer getAnoFinal() {
        return anoFinal;
    }


    /**
     * Sets the anoFinal value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param anoFinal
     */
    public void setAnoFinal(java.lang.Integer anoFinal) {
        this.anoFinal = anoFinal;
    }


    /**
     * Gets the anoInicial value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return anoInicial
     */
    public java.lang.Integer getAnoInicial() {
        return anoInicial;
    }


    /**
     * Sets the anoInicial value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param anoInicial
     */
    public void setAnoInicial(java.lang.Integer anoInicial) {
        this.anoInicial = anoInicial;
    }


    /**
     * Gets the comParadas value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return comParadas
     */
    public boolean isComParadas() {
        return comParadas;
    }


    /**
     * Sets the comParadas value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param comParadas
     */
    public void setComParadas(boolean comParadas) {
        this.comParadas = comParadas;
    }


    /**
     * Gets the dtReferencia value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dtReferenciaFinal value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dtReferenciaFinal
     */
    public java.util.Calendar getDtReferenciaFinal() {
        return dtReferenciaFinal;
    }


    /**
     * Sets the dtReferenciaFinal value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dtReferenciaFinal
     */
    public void setDtReferenciaFinal(java.util.Calendar dtReferenciaFinal) {
        this.dtReferenciaFinal = dtReferenciaFinal;
    }


    /**
     * Gets the dtReferenciaInicial value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dtReferenciaInicial
     */
    public java.util.Calendar getDtReferenciaInicial() {
        return dtReferenciaInicial;
    }


    /**
     * Sets the dtReferenciaInicial value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dtReferenciaInicial
     */
    public void setDtReferenciaInicial(java.util.Calendar dtReferenciaInicial) {
        this.dtReferenciaInicial = dtReferenciaInicial;
    }


    /**
     * Gets the dthrFhora value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dthrFhora
     */
    public java.util.Calendar getDthrFhora() {
        return dthrFhora;
    }


    /**
     * Sets the dthrFhora value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dthrFhora
     */
    public void setDthrFhora(java.util.Calendar dthrFhora) {
        this.dthrFhora = dthrFhora;
    }


    /**
     * Gets the dthrFturno value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dthrFturno
     */
    public java.util.Calendar getDthrFturno() {
        return dthrFturno;
    }


    /**
     * Sets the dthrFturno value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dthrFturno
     */
    public void setDthrFturno(java.util.Calendar dthrFturno) {
        this.dthrFturno = dthrFturno;
    }


    /**
     * Gets the dthrIhora value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dthrIhora
     */
    public java.util.Calendar getDthrIhora() {
        return dthrIhora;
    }


    /**
     * Sets the dthrIhora value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dthrIhora
     */
    public void setDthrIhora(java.util.Calendar dthrIhora) {
        this.dthrIhora = dthrIhora;
    }


    /**
     * Gets the dthrIturno value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dthrIturno
     */
    public java.util.Calendar getDthrIturno() {
        return dthrIturno;
    }


    /**
     * Sets the dthrIturno value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dthrIturno
     */
    public void setDthrIturno(java.util.Calendar dthrIturno) {
        this.dthrIturno = dthrIturno;
    }


    /**
     * Gets the dwTParada value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dwTParada
     */
    public idw.idwws.DwTParada getDwTParada() {
        return dwTParada;
    }


    /**
     * Sets the dwTParada value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dwTParada
     */
    public void setDwTParada(idw.idwws.DwTParada dwTParada) {
        this.dwTParada = dwTParada;
    }


    /**
     * Gets the dwTurno value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the dwfolha value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return dwfolha
     */
    public idw.idwws.DwFolha getDwfolha() {
        return dwfolha;
    }


    /**
     * Sets the dwfolha value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param dwfolha
     */
    public void setDwfolha(idw.idwws.DwFolha dwfolha) {
        this.dwfolha = dwfolha;
    }


    /**
     * Gets the idCp value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return idCp
     */
    public java.lang.Long getIdCp() {
        return idCp;
    }


    /**
     * Sets the idCp value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param idCp
     */
    public void setIdCp(java.lang.Long idCp) {
        this.idCp = idCp;
    }


    /**
     * Gets the idrt value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return idrt
     */
    public long getIdrt() {
        return idrt;
    }


    /**
     * Sets the idrt value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param idrt
     */
    public void setIdrt(long idrt) {
        this.idrt = idrt;
    }


    /**
     * Gets the mesFinal value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return mesFinal
     */
    public java.lang.Integer getMesFinal() {
        return mesFinal;
    }


    /**
     * Sets the mesFinal value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param mesFinal
     */
    public void setMesFinal(java.lang.Integer mesFinal) {
        this.mesFinal = mesFinal;
    }


    /**
     * Gets the mesInicial value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return mesInicial
     */
    public java.lang.Integer getMesInicial() {
        return mesInicial;
    }


    /**
     * Sets the mesInicial value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param mesInicial
     */
    public void setMesInicial(java.lang.Integer mesInicial) {
        this.mesInicial = mesInicial;
    }


    /**
     * Gets the omGt value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omPt value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ppCp value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the tpId value for this FiltroGraficoDetalhePtDTO.
     * 
     * @return tpId
     */
    public java.lang.Byte getTpId() {
        return tpId;
    }


    /**
     * Sets the tpId value for this FiltroGraficoDetalhePtDTO.
     * 
     * @param tpId
     */
    public void setTpId(java.lang.Byte tpId) {
        this.tpId = tpId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroGraficoDetalhePtDTO)) return false;
        FiltroGraficoDetalhePtDTO other = (FiltroGraficoDetalhePtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anoFinal==null && other.getAnoFinal()==null) || 
             (this.anoFinal!=null &&
              this.anoFinal.equals(other.getAnoFinal()))) &&
            ((this.anoInicial==null && other.getAnoInicial()==null) || 
             (this.anoInicial!=null &&
              this.anoInicial.equals(other.getAnoInicial()))) &&
            this.comParadas == other.isComParadas() &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dtReferenciaFinal==null && other.getDtReferenciaFinal()==null) || 
             (this.dtReferenciaFinal!=null &&
              this.dtReferenciaFinal.equals(other.getDtReferenciaFinal()))) &&
            ((this.dtReferenciaInicial==null && other.getDtReferenciaInicial()==null) || 
             (this.dtReferenciaInicial!=null &&
              this.dtReferenciaInicial.equals(other.getDtReferenciaInicial()))) &&
            ((this.dthrFhora==null && other.getDthrFhora()==null) || 
             (this.dthrFhora!=null &&
              this.dthrFhora.equals(other.getDthrFhora()))) &&
            ((this.dthrFturno==null && other.getDthrFturno()==null) || 
             (this.dthrFturno!=null &&
              this.dthrFturno.equals(other.getDthrFturno()))) &&
            ((this.dthrIhora==null && other.getDthrIhora()==null) || 
             (this.dthrIhora!=null &&
              this.dthrIhora.equals(other.getDthrIhora()))) &&
            ((this.dthrIturno==null && other.getDthrIturno()==null) || 
             (this.dthrIturno!=null &&
              this.dthrIturno.equals(other.getDthrIturno()))) &&
            ((this.dwTParada==null && other.getDwTParada()==null) || 
             (this.dwTParada!=null &&
              this.dwTParada.equals(other.getDwTParada()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.dwfolha==null && other.getDwfolha()==null) || 
             (this.dwfolha!=null &&
              this.dwfolha.equals(other.getDwfolha()))) &&
            ((this.idCp==null && other.getIdCp()==null) || 
             (this.idCp!=null &&
              this.idCp.equals(other.getIdCp()))) &&
            this.idrt == other.getIdrt() &&
            ((this.mesFinal==null && other.getMesFinal()==null) || 
             (this.mesFinal!=null &&
              this.mesFinal.equals(other.getMesFinal()))) &&
            ((this.mesInicial==null && other.getMesInicial()==null) || 
             (this.mesInicial!=null &&
              this.mesInicial.equals(other.getMesInicial()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.tpId==null && other.getTpId()==null) || 
             (this.tpId!=null &&
              this.tpId.equals(other.getTpId())));
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
        if (getAnoFinal() != null) {
            _hashCode += getAnoFinal().hashCode();
        }
        if (getAnoInicial() != null) {
            _hashCode += getAnoInicial().hashCode();
        }
        _hashCode += (isComParadas() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDtReferenciaFinal() != null) {
            _hashCode += getDtReferenciaFinal().hashCode();
        }
        if (getDtReferenciaInicial() != null) {
            _hashCode += getDtReferenciaInicial().hashCode();
        }
        if (getDthrFhora() != null) {
            _hashCode += getDthrFhora().hashCode();
        }
        if (getDthrFturno() != null) {
            _hashCode += getDthrFturno().hashCode();
        }
        if (getDthrIhora() != null) {
            _hashCode += getDthrIhora().hashCode();
        }
        if (getDthrIturno() != null) {
            _hashCode += getDthrIturno().hashCode();
        }
        if (getDwTParada() != null) {
            _hashCode += getDwTParada().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getDwfolha() != null) {
            _hashCode += getDwfolha().hashCode();
        }
        if (getIdCp() != null) {
            _hashCode += getIdCp().hashCode();
        }
        _hashCode += new Long(getIdrt()).hashCode();
        if (getMesFinal() != null) {
            _hashCode += getMesFinal().hashCode();
        }
        if (getMesInicial() != null) {
            _hashCode += getMesInicial().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getTpId() != null) {
            _hashCode += getTpId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroGraficoDetalhePtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroGraficoDetalhePtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferenciaFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferenciaFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferenciaInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferenciaInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFhora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFhora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIhora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIhora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwfolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwfolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idrt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idrt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
