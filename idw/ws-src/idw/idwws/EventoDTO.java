/**
 * EventoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EventoDTO  implements java.io.Serializable {
    private java.lang.String codigo;

    private java.lang.String data;

    private boolean descartar;

    private java.lang.String descricaoEvento;

    private idw.idwws.ErroInsersoraDTO erroDTO;

    private java.lang.String estagioEvento;

    private boolean eventoMaquina;

    private boolean eventoValido;

    private idw.idwws.FeederDTO[] feeders;

    private boolean fimCicloAnterior;

    private boolean fimParada;

    private boolean inicioParada;

    private java.lang.String linha;

    private java.lang.String maquina;

    private idw.idwws.NozzleDTO[] nozzles;

    private idw.idwws.OmPt ompt;

    private java.lang.String origem;

    private idw.idwws.ParadaInsersoraDTO paradaDTO;

    private java.lang.String produto;

    private java.lang.String programa;

    private int sequencial;

    private int tipoEvento;

    public EventoDTO() {
    }

    public EventoDTO(
           java.lang.String codigo,
           java.lang.String data,
           boolean descartar,
           java.lang.String descricaoEvento,
           idw.idwws.ErroInsersoraDTO erroDTO,
           java.lang.String estagioEvento,
           boolean eventoMaquina,
           boolean eventoValido,
           idw.idwws.FeederDTO[] feeders,
           boolean fimCicloAnterior,
           boolean fimParada,
           boolean inicioParada,
           java.lang.String linha,
           java.lang.String maquina,
           idw.idwws.NozzleDTO[] nozzles,
           idw.idwws.OmPt ompt,
           java.lang.String origem,
           idw.idwws.ParadaInsersoraDTO paradaDTO,
           java.lang.String produto,
           java.lang.String programa,
           int sequencial,
           int tipoEvento) {
           this.codigo = codigo;
           this.data = data;
           this.descartar = descartar;
           this.descricaoEvento = descricaoEvento;
           this.erroDTO = erroDTO;
           this.estagioEvento = estagioEvento;
           this.eventoMaquina = eventoMaquina;
           this.eventoValido = eventoValido;
           this.feeders = feeders;
           this.fimCicloAnterior = fimCicloAnterior;
           this.fimParada = fimParada;
           this.inicioParada = inicioParada;
           this.linha = linha;
           this.maquina = maquina;
           this.nozzles = nozzles;
           this.ompt = ompt;
           this.origem = origem;
           this.paradaDTO = paradaDTO;
           this.produto = produto;
           this.programa = programa;
           this.sequencial = sequencial;
           this.tipoEvento = tipoEvento;
    }


    /**
     * Gets the codigo value for this EventoDTO.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this EventoDTO.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the data value for this EventoDTO.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this EventoDTO.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }


    /**
     * Gets the descartar value for this EventoDTO.
     * 
     * @return descartar
     */
    public boolean isDescartar() {
        return descartar;
    }


    /**
     * Sets the descartar value for this EventoDTO.
     * 
     * @param descartar
     */
    public void setDescartar(boolean descartar) {
        this.descartar = descartar;
    }


    /**
     * Gets the descricaoEvento value for this EventoDTO.
     * 
     * @return descricaoEvento
     */
    public java.lang.String getDescricaoEvento() {
        return descricaoEvento;
    }


    /**
     * Sets the descricaoEvento value for this EventoDTO.
     * 
     * @param descricaoEvento
     */
    public void setDescricaoEvento(java.lang.String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }


    /**
     * Gets the erroDTO value for this EventoDTO.
     * 
     * @return erroDTO
     */
    public idw.idwws.ErroInsersoraDTO getErroDTO() {
        return erroDTO;
    }


    /**
     * Sets the erroDTO value for this EventoDTO.
     * 
     * @param erroDTO
     */
    public void setErroDTO(idw.idwws.ErroInsersoraDTO erroDTO) {
        this.erroDTO = erroDTO;
    }


    /**
     * Gets the estagioEvento value for this EventoDTO.
     * 
     * @return estagioEvento
     */
    public java.lang.String getEstagioEvento() {
        return estagioEvento;
    }


    /**
     * Sets the estagioEvento value for this EventoDTO.
     * 
     * @param estagioEvento
     */
    public void setEstagioEvento(java.lang.String estagioEvento) {
        this.estagioEvento = estagioEvento;
    }


    /**
     * Gets the eventoMaquina value for this EventoDTO.
     * 
     * @return eventoMaquina
     */
    public boolean isEventoMaquina() {
        return eventoMaquina;
    }


    /**
     * Sets the eventoMaquina value for this EventoDTO.
     * 
     * @param eventoMaquina
     */
    public void setEventoMaquina(boolean eventoMaquina) {
        this.eventoMaquina = eventoMaquina;
    }


    /**
     * Gets the eventoValido value for this EventoDTO.
     * 
     * @return eventoValido
     */
    public boolean isEventoValido() {
        return eventoValido;
    }


    /**
     * Sets the eventoValido value for this EventoDTO.
     * 
     * @param eventoValido
     */
    public void setEventoValido(boolean eventoValido) {
        this.eventoValido = eventoValido;
    }


    /**
     * Gets the feeders value for this EventoDTO.
     * 
     * @return feeders
     */
    public idw.idwws.FeederDTO[] getFeeders() {
        return feeders;
    }


    /**
     * Sets the feeders value for this EventoDTO.
     * 
     * @param feeders
     */
    public void setFeeders(idw.idwws.FeederDTO[] feeders) {
        this.feeders = feeders;
    }

    public idw.idwws.FeederDTO getFeeders(int i) {
        return this.feeders[i];
    }

    public void setFeeders(int i, idw.idwws.FeederDTO _value) {
        this.feeders[i] = _value;
    }


    /**
     * Gets the fimCicloAnterior value for this EventoDTO.
     * 
     * @return fimCicloAnterior
     */
    public boolean isFimCicloAnterior() {
        return fimCicloAnterior;
    }


    /**
     * Sets the fimCicloAnterior value for this EventoDTO.
     * 
     * @param fimCicloAnterior
     */
    public void setFimCicloAnterior(boolean fimCicloAnterior) {
        this.fimCicloAnterior = fimCicloAnterior;
    }


    /**
     * Gets the fimParada value for this EventoDTO.
     * 
     * @return fimParada
     */
    public boolean isFimParada() {
        return fimParada;
    }


    /**
     * Sets the fimParada value for this EventoDTO.
     * 
     * @param fimParada
     */
    public void setFimParada(boolean fimParada) {
        this.fimParada = fimParada;
    }


    /**
     * Gets the inicioParada value for this EventoDTO.
     * 
     * @return inicioParada
     */
    public boolean isInicioParada() {
        return inicioParada;
    }


    /**
     * Sets the inicioParada value for this EventoDTO.
     * 
     * @param inicioParada
     */
    public void setInicioParada(boolean inicioParada) {
        this.inicioParada = inicioParada;
    }


    /**
     * Gets the linha value for this EventoDTO.
     * 
     * @return linha
     */
    public java.lang.String getLinha() {
        return linha;
    }


    /**
     * Sets the linha value for this EventoDTO.
     * 
     * @param linha
     */
    public void setLinha(java.lang.String linha) {
        this.linha = linha;
    }


    /**
     * Gets the maquina value for this EventoDTO.
     * 
     * @return maquina
     */
    public java.lang.String getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this EventoDTO.
     * 
     * @param maquina
     */
    public void setMaquina(java.lang.String maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the nozzles value for this EventoDTO.
     * 
     * @return nozzles
     */
    public idw.idwws.NozzleDTO[] getNozzles() {
        return nozzles;
    }


    /**
     * Sets the nozzles value for this EventoDTO.
     * 
     * @param nozzles
     */
    public void setNozzles(idw.idwws.NozzleDTO[] nozzles) {
        this.nozzles = nozzles;
    }

    public idw.idwws.NozzleDTO getNozzles(int i) {
        return this.nozzles[i];
    }

    public void setNozzles(int i, idw.idwws.NozzleDTO _value) {
        this.nozzles[i] = _value;
    }


    /**
     * Gets the ompt value for this EventoDTO.
     * 
     * @return ompt
     */
    public idw.idwws.OmPt getOmpt() {
        return ompt;
    }


    /**
     * Sets the ompt value for this EventoDTO.
     * 
     * @param ompt
     */
    public void setOmpt(idw.idwws.OmPt ompt) {
        this.ompt = ompt;
    }


    /**
     * Gets the origem value for this EventoDTO.
     * 
     * @return origem
     */
    public java.lang.String getOrigem() {
        return origem;
    }


    /**
     * Sets the origem value for this EventoDTO.
     * 
     * @param origem
     */
    public void setOrigem(java.lang.String origem) {
        this.origem = origem;
    }


    /**
     * Gets the paradaDTO value for this EventoDTO.
     * 
     * @return paradaDTO
     */
    public idw.idwws.ParadaInsersoraDTO getParadaDTO() {
        return paradaDTO;
    }


    /**
     * Sets the paradaDTO value for this EventoDTO.
     * 
     * @param paradaDTO
     */
    public void setParadaDTO(idw.idwws.ParadaInsersoraDTO paradaDTO) {
        this.paradaDTO = paradaDTO;
    }


    /**
     * Gets the produto value for this EventoDTO.
     * 
     * @return produto
     */
    public java.lang.String getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this EventoDTO.
     * 
     * @param produto
     */
    public void setProduto(java.lang.String produto) {
        this.produto = produto;
    }


    /**
     * Gets the programa value for this EventoDTO.
     * 
     * @return programa
     */
    public java.lang.String getPrograma() {
        return programa;
    }


    /**
     * Sets the programa value for this EventoDTO.
     * 
     * @param programa
     */
    public void setPrograma(java.lang.String programa) {
        this.programa = programa;
    }


    /**
     * Gets the sequencial value for this EventoDTO.
     * 
     * @return sequencial
     */
    public int getSequencial() {
        return sequencial;
    }


    /**
     * Sets the sequencial value for this EventoDTO.
     * 
     * @param sequencial
     */
    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }


    /**
     * Gets the tipoEvento value for this EventoDTO.
     * 
     * @return tipoEvento
     */
    public int getTipoEvento() {
        return tipoEvento;
    }


    /**
     * Sets the tipoEvento value for this EventoDTO.
     * 
     * @param tipoEvento
     */
    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventoDTO)) return false;
        EventoDTO other = (EventoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            this.descartar == other.isDescartar() &&
            ((this.descricaoEvento==null && other.getDescricaoEvento()==null) || 
             (this.descricaoEvento!=null &&
              this.descricaoEvento.equals(other.getDescricaoEvento()))) &&
            ((this.erroDTO==null && other.getErroDTO()==null) || 
             (this.erroDTO!=null &&
              this.erroDTO.equals(other.getErroDTO()))) &&
            ((this.estagioEvento==null && other.getEstagioEvento()==null) || 
             (this.estagioEvento!=null &&
              this.estagioEvento.equals(other.getEstagioEvento()))) &&
            this.eventoMaquina == other.isEventoMaquina() &&
            this.eventoValido == other.isEventoValido() &&
            ((this.feeders==null && other.getFeeders()==null) || 
             (this.feeders!=null &&
              java.util.Arrays.equals(this.feeders, other.getFeeders()))) &&
            this.fimCicloAnterior == other.isFimCicloAnterior() &&
            this.fimParada == other.isFimParada() &&
            this.inicioParada == other.isInicioParada() &&
            ((this.linha==null && other.getLinha()==null) || 
             (this.linha!=null &&
              this.linha.equals(other.getLinha()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            ((this.nozzles==null && other.getNozzles()==null) || 
             (this.nozzles!=null &&
              java.util.Arrays.equals(this.nozzles, other.getNozzles()))) &&
            ((this.ompt==null && other.getOmpt()==null) || 
             (this.ompt!=null &&
              this.ompt.equals(other.getOmpt()))) &&
            ((this.origem==null && other.getOrigem()==null) || 
             (this.origem!=null &&
              this.origem.equals(other.getOrigem()))) &&
            ((this.paradaDTO==null && other.getParadaDTO()==null) || 
             (this.paradaDTO!=null &&
              this.paradaDTO.equals(other.getParadaDTO()))) &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            ((this.programa==null && other.getPrograma()==null) || 
             (this.programa!=null &&
              this.programa.equals(other.getPrograma()))) &&
            this.sequencial == other.getSequencial() &&
            this.tipoEvento == other.getTipoEvento();
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        _hashCode += (isDescartar() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDescricaoEvento() != null) {
            _hashCode += getDescricaoEvento().hashCode();
        }
        if (getErroDTO() != null) {
            _hashCode += getErroDTO().hashCode();
        }
        if (getEstagioEvento() != null) {
            _hashCode += getEstagioEvento().hashCode();
        }
        _hashCode += (isEventoMaquina() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isEventoValido() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFeeders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFeeders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFeeders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isFimCicloAnterior() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isFimParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isInicioParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLinha() != null) {
            _hashCode += getLinha().hashCode();
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        if (getNozzles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNozzles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNozzles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmpt() != null) {
            _hashCode += getOmpt().hashCode();
        }
        if (getOrigem() != null) {
            _hashCode += getOrigem().hashCode();
        }
        if (getParadaDTO() != null) {
            _hashCode += getParadaDTO().hashCode();
        }
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        if (getPrograma() != null) {
            _hashCode += getPrograma().hashCode();
        }
        _hashCode += getSequencial();
        _hashCode += getTipoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eventoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descartar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descartar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricaoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricaoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("erroDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "erroDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "erroInsersoraDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estagioEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estagioEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventoMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventoMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventoValido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventoValido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeders");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "feederDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimCicloAnterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimCicloAnterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nozzles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nozzles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "nozzleDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ompt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ompt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "paradaInsersoraDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "programa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequencial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
