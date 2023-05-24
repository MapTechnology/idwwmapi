/**
 * FiltroDetalhePTDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroDetalhePTDTO  implements java.io.Serializable {
    private java.lang.Integer agrupador;

    private idw.idwws.OmProduto componente;

    private idw.idwws.DwEst destino;

    private java.util.Calendar dtFinal;

    private java.util.Calendar dtInicial;

    private idw.idwws.OmGt gt;

    private java.lang.String nrSerieFinal;

    private java.lang.String nrSerieInicial;

    private idw.idwws.OmUsr operador;

    private idw.idwws.DwPassagem passagem;

    private idw.idwws.OmProgrp plataforma;

    private idw.idwws.OmProduto produto;

    private idw.idwws.OmPt pt;

    private idw.idwws.OmUsr supervisor;

    private idw.idwws.OmTppt tppt;

    private idw.idwws.DwTurno turno;

    public FiltroDetalhePTDTO() {
    }

    public FiltroDetalhePTDTO(
           java.lang.Integer agrupador,
           idw.idwws.OmProduto componente,
           idw.idwws.DwEst destino,
           java.util.Calendar dtFinal,
           java.util.Calendar dtInicial,
           idw.idwws.OmGt gt,
           java.lang.String nrSerieFinal,
           java.lang.String nrSerieInicial,
           idw.idwws.OmUsr operador,
           idw.idwws.DwPassagem passagem,
           idw.idwws.OmProgrp plataforma,
           idw.idwws.OmProduto produto,
           idw.idwws.OmPt pt,
           idw.idwws.OmUsr supervisor,
           idw.idwws.OmTppt tppt,
           idw.idwws.DwTurno turno) {
           this.agrupador = agrupador;
           this.componente = componente;
           this.destino = destino;
           this.dtFinal = dtFinal;
           this.dtInicial = dtInicial;
           this.gt = gt;
           this.nrSerieFinal = nrSerieFinal;
           this.nrSerieInicial = nrSerieInicial;
           this.operador = operador;
           this.passagem = passagem;
           this.plataforma = plataforma;
           this.produto = produto;
           this.pt = pt;
           this.supervisor = supervisor;
           this.tppt = tppt;
           this.turno = turno;
    }


    /**
     * Gets the agrupador value for this FiltroDetalhePTDTO.
     * 
     * @return agrupador
     */
    public java.lang.Integer getAgrupador() {
        return agrupador;
    }


    /**
     * Sets the agrupador value for this FiltroDetalhePTDTO.
     * 
     * @param agrupador
     */
    public void setAgrupador(java.lang.Integer agrupador) {
        this.agrupador = agrupador;
    }


    /**
     * Gets the componente value for this FiltroDetalhePTDTO.
     * 
     * @return componente
     */
    public idw.idwws.OmProduto getComponente() {
        return componente;
    }


    /**
     * Sets the componente value for this FiltroDetalhePTDTO.
     * 
     * @param componente
     */
    public void setComponente(idw.idwws.OmProduto componente) {
        this.componente = componente;
    }


    /**
     * Gets the destino value for this FiltroDetalhePTDTO.
     * 
     * @return destino
     */
    public idw.idwws.DwEst getDestino() {
        return destino;
    }


    /**
     * Sets the destino value for this FiltroDetalhePTDTO.
     * 
     * @param destino
     */
    public void setDestino(idw.idwws.DwEst destino) {
        this.destino = destino;
    }


    /**
     * Gets the dtFinal value for this FiltroDetalhePTDTO.
     * 
     * @return dtFinal
     */
    public java.util.Calendar getDtFinal() {
        return dtFinal;
    }


    /**
     * Sets the dtFinal value for this FiltroDetalhePTDTO.
     * 
     * @param dtFinal
     */
    public void setDtFinal(java.util.Calendar dtFinal) {
        this.dtFinal = dtFinal;
    }


    /**
     * Gets the dtInicial value for this FiltroDetalhePTDTO.
     * 
     * @return dtInicial
     */
    public java.util.Calendar getDtInicial() {
        return dtInicial;
    }


    /**
     * Sets the dtInicial value for this FiltroDetalhePTDTO.
     * 
     * @param dtInicial
     */
    public void setDtInicial(java.util.Calendar dtInicial) {
        this.dtInicial = dtInicial;
    }


    /**
     * Gets the gt value for this FiltroDetalhePTDTO.
     * 
     * @return gt
     */
    public idw.idwws.OmGt getGt() {
        return gt;
    }


    /**
     * Sets the gt value for this FiltroDetalhePTDTO.
     * 
     * @param gt
     */
    public void setGt(idw.idwws.OmGt gt) {
        this.gt = gt;
    }


    /**
     * Gets the nrSerieFinal value for this FiltroDetalhePTDTO.
     * 
     * @return nrSerieFinal
     */
    public java.lang.String getNrSerieFinal() {
        return nrSerieFinal;
    }


    /**
     * Sets the nrSerieFinal value for this FiltroDetalhePTDTO.
     * 
     * @param nrSerieFinal
     */
    public void setNrSerieFinal(java.lang.String nrSerieFinal) {
        this.nrSerieFinal = nrSerieFinal;
    }


    /**
     * Gets the nrSerieInicial value for this FiltroDetalhePTDTO.
     * 
     * @return nrSerieInicial
     */
    public java.lang.String getNrSerieInicial() {
        return nrSerieInicial;
    }


    /**
     * Sets the nrSerieInicial value for this FiltroDetalhePTDTO.
     * 
     * @param nrSerieInicial
     */
    public void setNrSerieInicial(java.lang.String nrSerieInicial) {
        this.nrSerieInicial = nrSerieInicial;
    }


    /**
     * Gets the operador value for this FiltroDetalhePTDTO.
     * 
     * @return operador
     */
    public idw.idwws.OmUsr getOperador() {
        return operador;
    }


    /**
     * Sets the operador value for this FiltroDetalhePTDTO.
     * 
     * @param operador
     */
    public void setOperador(idw.idwws.OmUsr operador) {
        this.operador = operador;
    }


    /**
     * Gets the passagem value for this FiltroDetalhePTDTO.
     * 
     * @return passagem
     */
    public idw.idwws.DwPassagem getPassagem() {
        return passagem;
    }


    /**
     * Sets the passagem value for this FiltroDetalhePTDTO.
     * 
     * @param passagem
     */
    public void setPassagem(idw.idwws.DwPassagem passagem) {
        this.passagem = passagem;
    }


    /**
     * Gets the plataforma value for this FiltroDetalhePTDTO.
     * 
     * @return plataforma
     */
    public idw.idwws.OmProgrp getPlataforma() {
        return plataforma;
    }


    /**
     * Sets the plataforma value for this FiltroDetalhePTDTO.
     * 
     * @param plataforma
     */
    public void setPlataforma(idw.idwws.OmProgrp plataforma) {
        this.plataforma = plataforma;
    }


    /**
     * Gets the produto value for this FiltroDetalhePTDTO.
     * 
     * @return produto
     */
    public idw.idwws.OmProduto getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this FiltroDetalhePTDTO.
     * 
     * @param produto
     */
    public void setProduto(idw.idwws.OmProduto produto) {
        this.produto = produto;
    }


    /**
     * Gets the pt value for this FiltroDetalhePTDTO.
     * 
     * @return pt
     */
    public idw.idwws.OmPt getPt() {
        return pt;
    }


    /**
     * Sets the pt value for this FiltroDetalhePTDTO.
     * 
     * @param pt
     */
    public void setPt(idw.idwws.OmPt pt) {
        this.pt = pt;
    }


    /**
     * Gets the supervisor value for this FiltroDetalhePTDTO.
     * 
     * @return supervisor
     */
    public idw.idwws.OmUsr getSupervisor() {
        return supervisor;
    }


    /**
     * Sets the supervisor value for this FiltroDetalhePTDTO.
     * 
     * @param supervisor
     */
    public void setSupervisor(idw.idwws.OmUsr supervisor) {
        this.supervisor = supervisor;
    }


    /**
     * Gets the tppt value for this FiltroDetalhePTDTO.
     * 
     * @return tppt
     */
    public idw.idwws.OmTppt getTppt() {
        return tppt;
    }


    /**
     * Sets the tppt value for this FiltroDetalhePTDTO.
     * 
     * @param tppt
     */
    public void setTppt(idw.idwws.OmTppt tppt) {
        this.tppt = tppt;
    }


    /**
     * Gets the turno value for this FiltroDetalhePTDTO.
     * 
     * @return turno
     */
    public idw.idwws.DwTurno getTurno() {
        return turno;
    }


    /**
     * Sets the turno value for this FiltroDetalhePTDTO.
     * 
     * @param turno
     */
    public void setTurno(idw.idwws.DwTurno turno) {
        this.turno = turno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroDetalhePTDTO)) return false;
        FiltroDetalhePTDTO other = (FiltroDetalhePTDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agrupador==null && other.getAgrupador()==null) || 
             (this.agrupador!=null &&
              this.agrupador.equals(other.getAgrupador()))) &&
            ((this.componente==null && other.getComponente()==null) || 
             (this.componente!=null &&
              this.componente.equals(other.getComponente()))) &&
            ((this.destino==null && other.getDestino()==null) || 
             (this.destino!=null &&
              this.destino.equals(other.getDestino()))) &&
            ((this.dtFinal==null && other.getDtFinal()==null) || 
             (this.dtFinal!=null &&
              this.dtFinal.equals(other.getDtFinal()))) &&
            ((this.dtInicial==null && other.getDtInicial()==null) || 
             (this.dtInicial!=null &&
              this.dtInicial.equals(other.getDtInicial()))) &&
            ((this.gt==null && other.getGt()==null) || 
             (this.gt!=null &&
              this.gt.equals(other.getGt()))) &&
            ((this.nrSerieFinal==null && other.getNrSerieFinal()==null) || 
             (this.nrSerieFinal!=null &&
              this.nrSerieFinal.equals(other.getNrSerieFinal()))) &&
            ((this.nrSerieInicial==null && other.getNrSerieInicial()==null) || 
             (this.nrSerieInicial!=null &&
              this.nrSerieInicial.equals(other.getNrSerieInicial()))) &&
            ((this.operador==null && other.getOperador()==null) || 
             (this.operador!=null &&
              this.operador.equals(other.getOperador()))) &&
            ((this.passagem==null && other.getPassagem()==null) || 
             (this.passagem!=null &&
              this.passagem.equals(other.getPassagem()))) &&
            ((this.plataforma==null && other.getPlataforma()==null) || 
             (this.plataforma!=null &&
              this.plataforma.equals(other.getPlataforma()))) &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            ((this.pt==null && other.getPt()==null) || 
             (this.pt!=null &&
              this.pt.equals(other.getPt()))) &&
            ((this.supervisor==null && other.getSupervisor()==null) || 
             (this.supervisor!=null &&
              this.supervisor.equals(other.getSupervisor()))) &&
            ((this.tppt==null && other.getTppt()==null) || 
             (this.tppt!=null &&
              this.tppt.equals(other.getTppt()))) &&
            ((this.turno==null && other.getTurno()==null) || 
             (this.turno!=null &&
              this.turno.equals(other.getTurno())));
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
        if (getAgrupador() != null) {
            _hashCode += getAgrupador().hashCode();
        }
        if (getComponente() != null) {
            _hashCode += getComponente().hashCode();
        }
        if (getDestino() != null) {
            _hashCode += getDestino().hashCode();
        }
        if (getDtFinal() != null) {
            _hashCode += getDtFinal().hashCode();
        }
        if (getDtInicial() != null) {
            _hashCode += getDtInicial().hashCode();
        }
        if (getGt() != null) {
            _hashCode += getGt().hashCode();
        }
        if (getNrSerieFinal() != null) {
            _hashCode += getNrSerieFinal().hashCode();
        }
        if (getNrSerieInicial() != null) {
            _hashCode += getNrSerieInicial().hashCode();
        }
        if (getOperador() != null) {
            _hashCode += getOperador().hashCode();
        }
        if (getPassagem() != null) {
            _hashCode += getPassagem().hashCode();
        }
        if (getPlataforma() != null) {
            _hashCode += getPlataforma().hashCode();
        }
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        if (getPt() != null) {
            _hashCode += getPt().hashCode();
        }
        if (getSupervisor() != null) {
            _hashCode += getSupervisor().hashCode();
        }
        if (getTppt() != null) {
            _hashCode += getTppt().hashCode();
        }
        if (getTurno() != null) {
            _hashCode += getTurno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroDetalhePTDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroDetalhePTDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agrupador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agrupador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "componente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrSerieFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrSerieFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrSerieInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrSerieInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plataforma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plataforma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "turno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
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
