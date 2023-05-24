/**
 * FiltroMaquinaInjetDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroMaquinaInjetDTO  implements java.io.Serializable {
    private java.lang.String cdMaquina;

    private java.lang.String cdMaquinaGrupo;

    private java.lang.String cdMolde;

    private java.lang.String cdMoldeGrupo;

    private java.lang.String cdProduto;

    private java.lang.String cdTurno;

    private java.util.Calendar data;

    private java.util.Calendar dtFinal;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbpro ijtbpro;

    private java.lang.Boolean isObterGruposDaMaquina;

    private java.lang.Boolean isObterRelacaoProdutos;

    private java.lang.Boolean isObterTemposDeSetupDasOPs;

    private java.lang.Boolean isProcessarCompleto;

    private java.lang.Boolean isProcessarDetalheMaquina;

    private java.lang.Boolean isProcessarTempoReal;

    private java.lang.String nrop;

    private boolean obterParadasPorArea;

    private boolean obterParadasPorMotivo;

    public FiltroMaquinaInjetDTO() {
    }

    public FiltroMaquinaInjetDTO(
           java.lang.String cdMaquina,
           java.lang.String cdMaquinaGrupo,
           java.lang.String cdMolde,
           java.lang.String cdMoldeGrupo,
           java.lang.String cdProduto,
           java.lang.String cdTurno,
           java.util.Calendar data,
           java.util.Calendar dtFinal,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbpro ijtbpro,
           java.lang.Boolean isObterGruposDaMaquina,
           java.lang.Boolean isObterRelacaoProdutos,
           java.lang.Boolean isObterTemposDeSetupDasOPs,
           java.lang.Boolean isProcessarCompleto,
           java.lang.Boolean isProcessarDetalheMaquina,
           java.lang.Boolean isProcessarTempoReal,
           java.lang.String nrop,
           boolean obterParadasPorArea,
           boolean obterParadasPorMotivo) {
           this.cdMaquina = cdMaquina;
           this.cdMaquinaGrupo = cdMaquinaGrupo;
           this.cdMolde = cdMolde;
           this.cdMoldeGrupo = cdMoldeGrupo;
           this.cdProduto = cdProduto;
           this.cdTurno = cdTurno;
           this.data = data;
           this.dtFinal = dtFinal;
           this.ijtbinj = ijtbinj;
           this.ijtbpro = ijtbpro;
           this.isObterGruposDaMaquina = isObterGruposDaMaquina;
           this.isObterRelacaoProdutos = isObterRelacaoProdutos;
           this.isObterTemposDeSetupDasOPs = isObterTemposDeSetupDasOPs;
           this.isProcessarCompleto = isProcessarCompleto;
           this.isProcessarDetalheMaquina = isProcessarDetalheMaquina;
           this.isProcessarTempoReal = isProcessarTempoReal;
           this.nrop = nrop;
           this.obterParadasPorArea = obterParadasPorArea;
           this.obterParadasPorMotivo = obterParadasPorMotivo;
    }


    /**
     * Gets the cdMaquina value for this FiltroMaquinaInjetDTO.
     * 
     * @return cdMaquina
     */
    public java.lang.String getCdMaquina() {
        return cdMaquina;
    }


    /**
     * Sets the cdMaquina value for this FiltroMaquinaInjetDTO.
     * 
     * @param cdMaquina
     */
    public void setCdMaquina(java.lang.String cdMaquina) {
        this.cdMaquina = cdMaquina;
    }


    /**
     * Gets the cdMaquinaGrupo value for this FiltroMaquinaInjetDTO.
     * 
     * @return cdMaquinaGrupo
     */
    public java.lang.String getCdMaquinaGrupo() {
        return cdMaquinaGrupo;
    }


    /**
     * Sets the cdMaquinaGrupo value for this FiltroMaquinaInjetDTO.
     * 
     * @param cdMaquinaGrupo
     */
    public void setCdMaquinaGrupo(java.lang.String cdMaquinaGrupo) {
        this.cdMaquinaGrupo = cdMaquinaGrupo;
    }


    /**
     * Gets the cdMolde value for this FiltroMaquinaInjetDTO.
     * 
     * @return cdMolde
     */
    public java.lang.String getCdMolde() {
        return cdMolde;
    }


    /**
     * Sets the cdMolde value for this FiltroMaquinaInjetDTO.
     * 
     * @param cdMolde
     */
    public void setCdMolde(java.lang.String cdMolde) {
        this.cdMolde = cdMolde;
    }


    /**
     * Gets the cdMoldeGrupo value for this FiltroMaquinaInjetDTO.
     * 
     * @return cdMoldeGrupo
     */
    public java.lang.String getCdMoldeGrupo() {
        return cdMoldeGrupo;
    }


    /**
     * Sets the cdMoldeGrupo value for this FiltroMaquinaInjetDTO.
     * 
     * @param cdMoldeGrupo
     */
    public void setCdMoldeGrupo(java.lang.String cdMoldeGrupo) {
        this.cdMoldeGrupo = cdMoldeGrupo;
    }


    /**
     * Gets the cdProduto value for this FiltroMaquinaInjetDTO.
     * 
     * @return cdProduto
     */
    public java.lang.String getCdProduto() {
        return cdProduto;
    }


    /**
     * Sets the cdProduto value for this FiltroMaquinaInjetDTO.
     * 
     * @param cdProduto
     */
    public void setCdProduto(java.lang.String cdProduto) {
        this.cdProduto = cdProduto;
    }


    /**
     * Gets the cdTurno value for this FiltroMaquinaInjetDTO.
     * 
     * @return cdTurno
     */
    public java.lang.String getCdTurno() {
        return cdTurno;
    }


    /**
     * Sets the cdTurno value for this FiltroMaquinaInjetDTO.
     * 
     * @param cdTurno
     */
    public void setCdTurno(java.lang.String cdTurno) {
        this.cdTurno = cdTurno;
    }


    /**
     * Gets the data value for this FiltroMaquinaInjetDTO.
     * 
     * @return data
     */
    public java.util.Calendar getData() {
        return data;
    }


    /**
     * Sets the data value for this FiltroMaquinaInjetDTO.
     * 
     * @param data
     */
    public void setData(java.util.Calendar data) {
        this.data = data;
    }


    /**
     * Gets the dtFinal value for this FiltroMaquinaInjetDTO.
     * 
     * @return dtFinal
     */
    public java.util.Calendar getDtFinal() {
        return dtFinal;
    }


    /**
     * Sets the dtFinal value for this FiltroMaquinaInjetDTO.
     * 
     * @param dtFinal
     */
    public void setDtFinal(java.util.Calendar dtFinal) {
        this.dtFinal = dtFinal;
    }


    /**
     * Gets the ijtbinj value for this FiltroMaquinaInjetDTO.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this FiltroMaquinaInjetDTO.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbpro value for this FiltroMaquinaInjetDTO.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this FiltroMaquinaInjetDTO.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the isObterGruposDaMaquina value for this FiltroMaquinaInjetDTO.
     * 
     * @return isObterGruposDaMaquina
     */
    public java.lang.Boolean getIsObterGruposDaMaquina() {
        return isObterGruposDaMaquina;
    }


    /**
     * Sets the isObterGruposDaMaquina value for this FiltroMaquinaInjetDTO.
     * 
     * @param isObterGruposDaMaquina
     */
    public void setIsObterGruposDaMaquina(java.lang.Boolean isObterGruposDaMaquina) {
        this.isObterGruposDaMaquina = isObterGruposDaMaquina;
    }


    /**
     * Gets the isObterRelacaoProdutos value for this FiltroMaquinaInjetDTO.
     * 
     * @return isObterRelacaoProdutos
     */
    public java.lang.Boolean getIsObterRelacaoProdutos() {
        return isObterRelacaoProdutos;
    }


    /**
     * Sets the isObterRelacaoProdutos value for this FiltroMaquinaInjetDTO.
     * 
     * @param isObterRelacaoProdutos
     */
    public void setIsObterRelacaoProdutos(java.lang.Boolean isObterRelacaoProdutos) {
        this.isObterRelacaoProdutos = isObterRelacaoProdutos;
    }


    /**
     * Gets the isObterTemposDeSetupDasOPs value for this FiltroMaquinaInjetDTO.
     * 
     * @return isObterTemposDeSetupDasOPs
     */
    public java.lang.Boolean getIsObterTemposDeSetupDasOPs() {
        return isObterTemposDeSetupDasOPs;
    }


    /**
     * Sets the isObterTemposDeSetupDasOPs value for this FiltroMaquinaInjetDTO.
     * 
     * @param isObterTemposDeSetupDasOPs
     */
    public void setIsObterTemposDeSetupDasOPs(java.lang.Boolean isObterTemposDeSetupDasOPs) {
        this.isObterTemposDeSetupDasOPs = isObterTemposDeSetupDasOPs;
    }


    /**
     * Gets the isProcessarCompleto value for this FiltroMaquinaInjetDTO.
     * 
     * @return isProcessarCompleto
     */
    public java.lang.Boolean getIsProcessarCompleto() {
        return isProcessarCompleto;
    }


    /**
     * Sets the isProcessarCompleto value for this FiltroMaquinaInjetDTO.
     * 
     * @param isProcessarCompleto
     */
    public void setIsProcessarCompleto(java.lang.Boolean isProcessarCompleto) {
        this.isProcessarCompleto = isProcessarCompleto;
    }


    /**
     * Gets the isProcessarDetalheMaquina value for this FiltroMaquinaInjetDTO.
     * 
     * @return isProcessarDetalheMaquina
     */
    public java.lang.Boolean getIsProcessarDetalheMaquina() {
        return isProcessarDetalheMaquina;
    }


    /**
     * Sets the isProcessarDetalheMaquina value for this FiltroMaquinaInjetDTO.
     * 
     * @param isProcessarDetalheMaquina
     */
    public void setIsProcessarDetalheMaquina(java.lang.Boolean isProcessarDetalheMaquina) {
        this.isProcessarDetalheMaquina = isProcessarDetalheMaquina;
    }


    /**
     * Gets the isProcessarTempoReal value for this FiltroMaquinaInjetDTO.
     * 
     * @return isProcessarTempoReal
     */
    public java.lang.Boolean getIsProcessarTempoReal() {
        return isProcessarTempoReal;
    }


    /**
     * Sets the isProcessarTempoReal value for this FiltroMaquinaInjetDTO.
     * 
     * @param isProcessarTempoReal
     */
    public void setIsProcessarTempoReal(java.lang.Boolean isProcessarTempoReal) {
        this.isProcessarTempoReal = isProcessarTempoReal;
    }


    /**
     * Gets the nrop value for this FiltroMaquinaInjetDTO.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this FiltroMaquinaInjetDTO.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the obterParadasPorArea value for this FiltroMaquinaInjetDTO.
     * 
     * @return obterParadasPorArea
     */
    public boolean isObterParadasPorArea() {
        return obterParadasPorArea;
    }


    /**
     * Sets the obterParadasPorArea value for this FiltroMaquinaInjetDTO.
     * 
     * @param obterParadasPorArea
     */
    public void setObterParadasPorArea(boolean obterParadasPorArea) {
        this.obterParadasPorArea = obterParadasPorArea;
    }


    /**
     * Gets the obterParadasPorMotivo value for this FiltroMaquinaInjetDTO.
     * 
     * @return obterParadasPorMotivo
     */
    public boolean isObterParadasPorMotivo() {
        return obterParadasPorMotivo;
    }


    /**
     * Sets the obterParadasPorMotivo value for this FiltroMaquinaInjetDTO.
     * 
     * @param obterParadasPorMotivo
     */
    public void setObterParadasPorMotivo(boolean obterParadasPorMotivo) {
        this.obterParadasPorMotivo = obterParadasPorMotivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroMaquinaInjetDTO)) return false;
        FiltroMaquinaInjetDTO other = (FiltroMaquinaInjetDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdMaquina==null && other.getCdMaquina()==null) || 
             (this.cdMaquina!=null &&
              this.cdMaquina.equals(other.getCdMaquina()))) &&
            ((this.cdMaquinaGrupo==null && other.getCdMaquinaGrupo()==null) || 
             (this.cdMaquinaGrupo!=null &&
              this.cdMaquinaGrupo.equals(other.getCdMaquinaGrupo()))) &&
            ((this.cdMolde==null && other.getCdMolde()==null) || 
             (this.cdMolde!=null &&
              this.cdMolde.equals(other.getCdMolde()))) &&
            ((this.cdMoldeGrupo==null && other.getCdMoldeGrupo()==null) || 
             (this.cdMoldeGrupo!=null &&
              this.cdMoldeGrupo.equals(other.getCdMoldeGrupo()))) &&
            ((this.cdProduto==null && other.getCdProduto()==null) || 
             (this.cdProduto!=null &&
              this.cdProduto.equals(other.getCdProduto()))) &&
            ((this.cdTurno==null && other.getCdTurno()==null) || 
             (this.cdTurno!=null &&
              this.cdTurno.equals(other.getCdTurno()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.dtFinal==null && other.getDtFinal()==null) || 
             (this.dtFinal!=null &&
              this.dtFinal.equals(other.getDtFinal()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.isObterGruposDaMaquina==null && other.getIsObterGruposDaMaquina()==null) || 
             (this.isObterGruposDaMaquina!=null &&
              this.isObterGruposDaMaquina.equals(other.getIsObterGruposDaMaquina()))) &&
            ((this.isObterRelacaoProdutos==null && other.getIsObterRelacaoProdutos()==null) || 
             (this.isObterRelacaoProdutos!=null &&
              this.isObterRelacaoProdutos.equals(other.getIsObterRelacaoProdutos()))) &&
            ((this.isObterTemposDeSetupDasOPs==null && other.getIsObterTemposDeSetupDasOPs()==null) || 
             (this.isObterTemposDeSetupDasOPs!=null &&
              this.isObterTemposDeSetupDasOPs.equals(other.getIsObterTemposDeSetupDasOPs()))) &&
            ((this.isProcessarCompleto==null && other.getIsProcessarCompleto()==null) || 
             (this.isProcessarCompleto!=null &&
              this.isProcessarCompleto.equals(other.getIsProcessarCompleto()))) &&
            ((this.isProcessarDetalheMaquina==null && other.getIsProcessarDetalheMaquina()==null) || 
             (this.isProcessarDetalheMaquina!=null &&
              this.isProcessarDetalheMaquina.equals(other.getIsProcessarDetalheMaquina()))) &&
            ((this.isProcessarTempoReal==null && other.getIsProcessarTempoReal()==null) || 
             (this.isProcessarTempoReal!=null &&
              this.isProcessarTempoReal.equals(other.getIsProcessarTempoReal()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            this.obterParadasPorArea == other.isObterParadasPorArea() &&
            this.obterParadasPorMotivo == other.isObterParadasPorMotivo();
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
        if (getCdMaquina() != null) {
            _hashCode += getCdMaquina().hashCode();
        }
        if (getCdMaquinaGrupo() != null) {
            _hashCode += getCdMaquinaGrupo().hashCode();
        }
        if (getCdMolde() != null) {
            _hashCode += getCdMolde().hashCode();
        }
        if (getCdMoldeGrupo() != null) {
            _hashCode += getCdMoldeGrupo().hashCode();
        }
        if (getCdProduto() != null) {
            _hashCode += getCdProduto().hashCode();
        }
        if (getCdTurno() != null) {
            _hashCode += getCdTurno().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getDtFinal() != null) {
            _hashCode += getDtFinal().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getIsObterGruposDaMaquina() != null) {
            _hashCode += getIsObterGruposDaMaquina().hashCode();
        }
        if (getIsObterRelacaoProdutos() != null) {
            _hashCode += getIsObterRelacaoProdutos().hashCode();
        }
        if (getIsObterTemposDeSetupDasOPs() != null) {
            _hashCode += getIsObterTemposDeSetupDasOPs().hashCode();
        }
        if (getIsProcessarCompleto() != null) {
            _hashCode += getIsProcessarCompleto().hashCode();
        }
        if (getIsProcessarDetalheMaquina() != null) {
            _hashCode += getIsProcessarDetalheMaquina().hashCode();
        }
        if (getIsProcessarTempoReal() != null) {
            _hashCode += getIsProcessarTempoReal().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        _hashCode += (isObterParadasPorArea() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isObterParadasPorMotivo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroMaquinaInjetDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroMaquinaInjetDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdMaquinaGrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMaquinaGrupo"));
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
        elemField.setFieldName("cdMoldeGrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdMoldeGrupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isObterGruposDaMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isObterGruposDaMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isObterRelacaoProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isObterRelacaoProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isObterTemposDeSetupDasOPs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isObterTemposDeSetupDasOPs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isProcessarCompleto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isProcessarCompleto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isProcessarDetalheMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isProcessarDetalheMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isProcessarTempoReal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isProcessarTempoReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obterParadasPorArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obterParadasPorArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obterParadasPorMotivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obterParadasPorMotivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
