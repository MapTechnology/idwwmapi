/**
 * DwEstmov.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwEstmov  extends idw.idwws.DwEstMovTemplate  implements java.io.Serializable {
    private java.lang.Integer ano;

    private java.util.Calendar dthrCadastro;

    private java.util.Calendar dthrMov;

    private idw.idwws.DwEstlocalpro dwEstlocalpro;

    private idw.idwws.DwEstpro dwEstpro;

    private idw.idwws.DwTurno dwTurno;

    private java.lang.Long idEstmov;

    private java.lang.Boolean isEfetivado;

    private java.lang.String lancamento;

    private java.lang.Integer mes;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsr;

    private java.math.BigDecimal qtAjuste;

    private java.math.BigDecimal qtAjusteAnt;

    private java.math.BigDecimal qtEntradaAnt;

    private java.math.BigDecimal qtReservadaAnt;

    private java.math.BigDecimal qtSaidaAnt;

    private java.math.BigDecimal qtTotal;

    private java.math.BigDecimal qtTotalAnt;

    private java.lang.Integer tpMov;

    private java.lang.Integer tpOrigem;

    public DwEstmov() {
    }

    public DwEstmov(
           java.lang.Integer ano,
           java.util.Calendar dthrCadastro,
           java.util.Calendar dthrMov,
           idw.idwws.DwEstlocalpro dwEstlocalpro,
           idw.idwws.DwEstpro dwEstpro,
           idw.idwws.DwTurno dwTurno,
           java.lang.Long idEstmov,
           java.lang.Boolean isEfetivado,
           java.lang.String lancamento,
           java.lang.Integer mes,
           idw.idwws.OmGt omGt,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsr,
           java.math.BigDecimal qtAjuste,
           java.math.BigDecimal qtAjusteAnt,
           java.math.BigDecimal qtEntradaAnt,
           java.math.BigDecimal qtReservadaAnt,
           java.math.BigDecimal qtSaidaAnt,
           java.math.BigDecimal qtTotal,
           java.math.BigDecimal qtTotalAnt,
           java.lang.Integer tpMov,
           java.lang.Integer tpOrigem) {
        this.ano = ano;
        this.dthrCadastro = dthrCadastro;
        this.dthrMov = dthrMov;
        this.dwEstlocalpro = dwEstlocalpro;
        this.dwEstpro = dwEstpro;
        this.dwTurno = dwTurno;
        this.idEstmov = idEstmov;
        this.isEfetivado = isEfetivado;
        this.lancamento = lancamento;
        this.mes = mes;
        this.omGt = omGt;
        this.omPt = omPt;
        this.omUsr = omUsr;
        this.qtAjuste = qtAjuste;
        this.qtAjusteAnt = qtAjusteAnt;
        this.qtEntradaAnt = qtEntradaAnt;
        this.qtReservadaAnt = qtReservadaAnt;
        this.qtSaidaAnt = qtSaidaAnt;
        this.qtTotal = qtTotal;
        this.qtTotalAnt = qtTotalAnt;
        this.tpMov = tpMov;
        this.tpOrigem = tpOrigem;
    }


    /**
     * Gets the ano value for this DwEstmov.
     * 
     * @return ano
     */
    public java.lang.Integer getAno() {
        return ano;
    }


    /**
     * Sets the ano value for this DwEstmov.
     * 
     * @param ano
     */
    public void setAno(java.lang.Integer ano) {
        this.ano = ano;
    }


    /**
     * Gets the dthrCadastro value for this DwEstmov.
     * 
     * @return dthrCadastro
     */
    public java.util.Calendar getDthrCadastro() {
        return dthrCadastro;
    }


    /**
     * Sets the dthrCadastro value for this DwEstmov.
     * 
     * @param dthrCadastro
     */
    public void setDthrCadastro(java.util.Calendar dthrCadastro) {
        this.dthrCadastro = dthrCadastro;
    }


    /**
     * Gets the dthrMov value for this DwEstmov.
     * 
     * @return dthrMov
     */
    public java.util.Calendar getDthrMov() {
        return dthrMov;
    }


    /**
     * Sets the dthrMov value for this DwEstmov.
     * 
     * @param dthrMov
     */
    public void setDthrMov(java.util.Calendar dthrMov) {
        this.dthrMov = dthrMov;
    }


    /**
     * Gets the dwEstlocalpro value for this DwEstmov.
     * 
     * @return dwEstlocalpro
     */
    public idw.idwws.DwEstlocalpro getDwEstlocalpro() {
        return dwEstlocalpro;
    }


    /**
     * Sets the dwEstlocalpro value for this DwEstmov.
     * 
     * @param dwEstlocalpro
     */
    public void setDwEstlocalpro(idw.idwws.DwEstlocalpro dwEstlocalpro) {
        this.dwEstlocalpro = dwEstlocalpro;
    }


    /**
     * Gets the dwEstpro value for this DwEstmov.
     * 
     * @return dwEstpro
     */
    public idw.idwws.DwEstpro getDwEstpro() {
        return dwEstpro;
    }


    /**
     * Sets the dwEstpro value for this DwEstmov.
     * 
     * @param dwEstpro
     */
    public void setDwEstpro(idw.idwws.DwEstpro dwEstpro) {
        this.dwEstpro = dwEstpro;
    }


    /**
     * Gets the dwTurno value for this DwEstmov.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this DwEstmov.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the idEstmov value for this DwEstmov.
     * 
     * @return idEstmov
     */
    public java.lang.Long getIdEstmov() {
        return idEstmov;
    }


    /**
     * Sets the idEstmov value for this DwEstmov.
     * 
     * @param idEstmov
     */
    public void setIdEstmov(java.lang.Long idEstmov) {
        this.idEstmov = idEstmov;
    }


    /**
     * Gets the isEfetivado value for this DwEstmov.
     * 
     * @return isEfetivado
     */
    public java.lang.Boolean getIsEfetivado() {
        return isEfetivado;
    }


    /**
     * Sets the isEfetivado value for this DwEstmov.
     * 
     * @param isEfetivado
     */
    public void setIsEfetivado(java.lang.Boolean isEfetivado) {
        this.isEfetivado = isEfetivado;
    }


    /**
     * Gets the lancamento value for this DwEstmov.
     * 
     * @return lancamento
     */
    public java.lang.String getLancamento() {
        return lancamento;
    }


    /**
     * Sets the lancamento value for this DwEstmov.
     * 
     * @param lancamento
     */
    public void setLancamento(java.lang.String lancamento) {
        this.lancamento = lancamento;
    }


    /**
     * Gets the mes value for this DwEstmov.
     * 
     * @return mes
     */
    public java.lang.Integer getMes() {
        return mes;
    }


    /**
     * Sets the mes value for this DwEstmov.
     * 
     * @param mes
     */
    public void setMes(java.lang.Integer mes) {
        this.mes = mes;
    }


    /**
     * Gets the omGt value for this DwEstmov.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this DwEstmov.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omPt value for this DwEstmov.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwEstmov.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsr value for this DwEstmov.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this DwEstmov.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the qtAjuste value for this DwEstmov.
     * 
     * @return qtAjuste
     */
    public java.math.BigDecimal getQtAjuste() {
        return qtAjuste;
    }


    /**
     * Sets the qtAjuste value for this DwEstmov.
     * 
     * @param qtAjuste
     */
    public void setQtAjuste(java.math.BigDecimal qtAjuste) {
        this.qtAjuste = qtAjuste;
    }


    /**
     * Gets the qtAjusteAnt value for this DwEstmov.
     * 
     * @return qtAjusteAnt
     */
    public java.math.BigDecimal getQtAjusteAnt() {
        return qtAjusteAnt;
    }


    /**
     * Sets the qtAjusteAnt value for this DwEstmov.
     * 
     * @param qtAjusteAnt
     */
    public void setQtAjusteAnt(java.math.BigDecimal qtAjusteAnt) {
        this.qtAjusteAnt = qtAjusteAnt;
    }


    /**
     * Gets the qtEntradaAnt value for this DwEstmov.
     * 
     * @return qtEntradaAnt
     */
    public java.math.BigDecimal getQtEntradaAnt() {
        return qtEntradaAnt;
    }


    /**
     * Sets the qtEntradaAnt value for this DwEstmov.
     * 
     * @param qtEntradaAnt
     */
    public void setQtEntradaAnt(java.math.BigDecimal qtEntradaAnt) {
        this.qtEntradaAnt = qtEntradaAnt;
    }


    /**
     * Gets the qtReservadaAnt value for this DwEstmov.
     * 
     * @return qtReservadaAnt
     */
    public java.math.BigDecimal getQtReservadaAnt() {
        return qtReservadaAnt;
    }


    /**
     * Sets the qtReservadaAnt value for this DwEstmov.
     * 
     * @param qtReservadaAnt
     */
    public void setQtReservadaAnt(java.math.BigDecimal qtReservadaAnt) {
        this.qtReservadaAnt = qtReservadaAnt;
    }


    /**
     * Gets the qtSaidaAnt value for this DwEstmov.
     * 
     * @return qtSaidaAnt
     */
    public java.math.BigDecimal getQtSaidaAnt() {
        return qtSaidaAnt;
    }


    /**
     * Sets the qtSaidaAnt value for this DwEstmov.
     * 
     * @param qtSaidaAnt
     */
    public void setQtSaidaAnt(java.math.BigDecimal qtSaidaAnt) {
        this.qtSaidaAnt = qtSaidaAnt;
    }


    /**
     * Gets the qtTotal value for this DwEstmov.
     * 
     * @return qtTotal
     */
    public java.math.BigDecimal getQtTotal() {
        return qtTotal;
    }


    /**
     * Sets the qtTotal value for this DwEstmov.
     * 
     * @param qtTotal
     */
    public void setQtTotal(java.math.BigDecimal qtTotal) {
        this.qtTotal = qtTotal;
    }


    /**
     * Gets the qtTotalAnt value for this DwEstmov.
     * 
     * @return qtTotalAnt
     */
    public java.math.BigDecimal getQtTotalAnt() {
        return qtTotalAnt;
    }


    /**
     * Sets the qtTotalAnt value for this DwEstmov.
     * 
     * @param qtTotalAnt
     */
    public void setQtTotalAnt(java.math.BigDecimal qtTotalAnt) {
        this.qtTotalAnt = qtTotalAnt;
    }


    /**
     * Gets the tpMov value for this DwEstmov.
     * 
     * @return tpMov
     */
    public java.lang.Integer getTpMov() {
        return tpMov;
    }


    /**
     * Sets the tpMov value for this DwEstmov.
     * 
     * @param tpMov
     */
    public void setTpMov(java.lang.Integer tpMov) {
        this.tpMov = tpMov;
    }


    /**
     * Gets the tpOrigem value for this DwEstmov.
     * 
     * @return tpOrigem
     */
    public java.lang.Integer getTpOrigem() {
        return tpOrigem;
    }


    /**
     * Sets the tpOrigem value for this DwEstmov.
     * 
     * @param tpOrigem
     */
    public void setTpOrigem(java.lang.Integer tpOrigem) {
        this.tpOrigem = tpOrigem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwEstmov)) return false;
        DwEstmov other = (DwEstmov) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ano==null && other.getAno()==null) || 
             (this.ano!=null &&
              this.ano.equals(other.getAno()))) &&
            ((this.dthrCadastro==null && other.getDthrCadastro()==null) || 
             (this.dthrCadastro!=null &&
              this.dthrCadastro.equals(other.getDthrCadastro()))) &&
            ((this.dthrMov==null && other.getDthrMov()==null) || 
             (this.dthrMov!=null &&
              this.dthrMov.equals(other.getDthrMov()))) &&
            ((this.dwEstlocalpro==null && other.getDwEstlocalpro()==null) || 
             (this.dwEstlocalpro!=null &&
              this.dwEstlocalpro.equals(other.getDwEstlocalpro()))) &&
            ((this.dwEstpro==null && other.getDwEstpro()==null) || 
             (this.dwEstpro!=null &&
              this.dwEstpro.equals(other.getDwEstpro()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.idEstmov==null && other.getIdEstmov()==null) || 
             (this.idEstmov!=null &&
              this.idEstmov.equals(other.getIdEstmov()))) &&
            ((this.isEfetivado==null && other.getIsEfetivado()==null) || 
             (this.isEfetivado!=null &&
              this.isEfetivado.equals(other.getIsEfetivado()))) &&
            ((this.lancamento==null && other.getLancamento()==null) || 
             (this.lancamento!=null &&
              this.lancamento.equals(other.getLancamento()))) &&
            ((this.mes==null && other.getMes()==null) || 
             (this.mes!=null &&
              this.mes.equals(other.getMes()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.qtAjuste==null && other.getQtAjuste()==null) || 
             (this.qtAjuste!=null &&
              this.qtAjuste.equals(other.getQtAjuste()))) &&
            ((this.qtAjusteAnt==null && other.getQtAjusteAnt()==null) || 
             (this.qtAjusteAnt!=null &&
              this.qtAjusteAnt.equals(other.getQtAjusteAnt()))) &&
            ((this.qtEntradaAnt==null && other.getQtEntradaAnt()==null) || 
             (this.qtEntradaAnt!=null &&
              this.qtEntradaAnt.equals(other.getQtEntradaAnt()))) &&
            ((this.qtReservadaAnt==null && other.getQtReservadaAnt()==null) || 
             (this.qtReservadaAnt!=null &&
              this.qtReservadaAnt.equals(other.getQtReservadaAnt()))) &&
            ((this.qtSaidaAnt==null && other.getQtSaidaAnt()==null) || 
             (this.qtSaidaAnt!=null &&
              this.qtSaidaAnt.equals(other.getQtSaidaAnt()))) &&
            ((this.qtTotal==null && other.getQtTotal()==null) || 
             (this.qtTotal!=null &&
              this.qtTotal.equals(other.getQtTotal()))) &&
            ((this.qtTotalAnt==null && other.getQtTotalAnt()==null) || 
             (this.qtTotalAnt!=null &&
              this.qtTotalAnt.equals(other.getQtTotalAnt()))) &&
            ((this.tpMov==null && other.getTpMov()==null) || 
             (this.tpMov!=null &&
              this.tpMov.equals(other.getTpMov()))) &&
            ((this.tpOrigem==null && other.getTpOrigem()==null) || 
             (this.tpOrigem!=null &&
              this.tpOrigem.equals(other.getTpOrigem())));
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
        if (getAno() != null) {
            _hashCode += getAno().hashCode();
        }
        if (getDthrCadastro() != null) {
            _hashCode += getDthrCadastro().hashCode();
        }
        if (getDthrMov() != null) {
            _hashCode += getDthrMov().hashCode();
        }
        if (getDwEstlocalpro() != null) {
            _hashCode += getDwEstlocalpro().hashCode();
        }
        if (getDwEstpro() != null) {
            _hashCode += getDwEstpro().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getIdEstmov() != null) {
            _hashCode += getIdEstmov().hashCode();
        }
        if (getIsEfetivado() != null) {
            _hashCode += getIsEfetivado().hashCode();
        }
        if (getLancamento() != null) {
            _hashCode += getLancamento().hashCode();
        }
        if (getMes() != null) {
            _hashCode += getMes().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getQtAjuste() != null) {
            _hashCode += getQtAjuste().hashCode();
        }
        if (getQtAjusteAnt() != null) {
            _hashCode += getQtAjusteAnt().hashCode();
        }
        if (getQtEntradaAnt() != null) {
            _hashCode += getQtEntradaAnt().hashCode();
        }
        if (getQtReservadaAnt() != null) {
            _hashCode += getQtReservadaAnt().hashCode();
        }
        if (getQtSaidaAnt() != null) {
            _hashCode += getQtSaidaAnt().hashCode();
        }
        if (getQtTotal() != null) {
            _hashCode += getQtTotal().hashCode();
        }
        if (getQtTotalAnt() != null) {
            _hashCode += getQtTotalAnt().hashCode();
        }
        if (getTpMov() != null) {
            _hashCode += getTpMov().hashCode();
        }
        if (getTpOrigem() != null) {
            _hashCode += getTpOrigem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwEstmov.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstmov"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrMov");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrMov"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstlocalpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstlocalpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstlocalpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstpro"));
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
        elemField.setFieldName("idEstmov");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEstmov"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEfetivado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEfetivado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lancamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lancamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mes"));
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
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAjuste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAjuste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAjusteAnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAjusteAnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtEntradaAnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtEntradaAnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtReservadaAnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtReservadaAnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtSaidaAnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtSaidaAnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtTotalAnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtTotalAnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpMov");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpMov"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpOrigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpOrigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
