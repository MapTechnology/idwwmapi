/**
 * DwRota.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwRota  extends idw.idwws.DwRotaTemplate  implements java.io.Serializable {
    private java.math.BigDecimal altura;

    private java.lang.String cdRota;

    private java.lang.String dsRota;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwRotapasso[] dwRotapassos;

    private java.math.BigDecimal gridx;

    private java.math.BigDecimal gridy;

    private long idRota;

    private java.lang.Boolean isModelo;

    private java.lang.Boolean isPassaadiante;

    private java.math.BigDecimal largura;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmObj[] omObjsForIdRota;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwRota() {
    }

    public DwRota(
           java.lang.Long id,
           java.math.BigDecimal altura,
           java.lang.String cdRota,
           java.lang.String dsRota,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwRotapasso[] dwRotapassos,
           java.math.BigDecimal gridx,
           java.math.BigDecimal gridy,
           long idRota,
           java.lang.Boolean isModelo,
           java.lang.Boolean isPassaadiante,
           java.math.BigDecimal largura,
           idw.idwws.OmGt omGt,
           idw.idwws.OmObj[] omObjsForIdRota,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.altura = altura;
        this.cdRota = cdRota;
        this.dsRota = dsRota;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwRotapassos = dwRotapassos;
        this.gridx = gridx;
        this.gridy = gridy;
        this.idRota = idRota;
        this.isModelo = isModelo;
        this.isPassaadiante = isPassaadiante;
        this.largura = largura;
        this.omGt = omGt;
        this.omObjsForIdRota = omObjsForIdRota;
        this.omProduto = omProduto;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the altura value for this DwRota.
     * 
     * @return altura
     */
    public java.math.BigDecimal getAltura() {
        return altura;
    }


    /**
     * Sets the altura value for this DwRota.
     * 
     * @param altura
     */
    public void setAltura(java.math.BigDecimal altura) {
        this.altura = altura;
    }


    /**
     * Gets the cdRota value for this DwRota.
     * 
     * @return cdRota
     */
    public java.lang.String getCdRota() {
        return cdRota;
    }


    /**
     * Sets the cdRota value for this DwRota.
     * 
     * @param cdRota
     */
    public void setCdRota(java.lang.String cdRota) {
        this.cdRota = cdRota;
    }


    /**
     * Gets the dsRota value for this DwRota.
     * 
     * @return dsRota
     */
    public java.lang.String getDsRota() {
        return dsRota;
    }


    /**
     * Sets the dsRota value for this DwRota.
     * 
     * @param dsRota
     */
    public void setDsRota(java.lang.String dsRota) {
        this.dsRota = dsRota;
    }


    /**
     * Gets the dtRevisao value for this DwRota.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwRota.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwRota.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwRota.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwRotapassos value for this DwRota.
     * 
     * @return dwRotapassos
     */
    public idw.idwws.DwRotapasso[] getDwRotapassos() {
        return dwRotapassos;
    }


    /**
     * Sets the dwRotapassos value for this DwRota.
     * 
     * @param dwRotapassos
     */
    public void setDwRotapassos(idw.idwws.DwRotapasso[] dwRotapassos) {
        this.dwRotapassos = dwRotapassos;
    }

    public idw.idwws.DwRotapasso getDwRotapassos(int i) {
        return this.dwRotapassos[i];
    }

    public void setDwRotapassos(int i, idw.idwws.DwRotapasso _value) {
        this.dwRotapassos[i] = _value;
    }


    /**
     * Gets the gridx value for this DwRota.
     * 
     * @return gridx
     */
    public java.math.BigDecimal getGridx() {
        return gridx;
    }


    /**
     * Sets the gridx value for this DwRota.
     * 
     * @param gridx
     */
    public void setGridx(java.math.BigDecimal gridx) {
        this.gridx = gridx;
    }


    /**
     * Gets the gridy value for this DwRota.
     * 
     * @return gridy
     */
    public java.math.BigDecimal getGridy() {
        return gridy;
    }


    /**
     * Sets the gridy value for this DwRota.
     * 
     * @param gridy
     */
    public void setGridy(java.math.BigDecimal gridy) {
        this.gridy = gridy;
    }


    /**
     * Gets the idRota value for this DwRota.
     * 
     * @return idRota
     */
    public long getIdRota() {
        return idRota;
    }


    /**
     * Sets the idRota value for this DwRota.
     * 
     * @param idRota
     */
    public void setIdRota(long idRota) {
        this.idRota = idRota;
    }


    /**
     * Gets the isModelo value for this DwRota.
     * 
     * @return isModelo
     */
    public java.lang.Boolean getIsModelo() {
        return isModelo;
    }


    /**
     * Sets the isModelo value for this DwRota.
     * 
     * @param isModelo
     */
    public void setIsModelo(java.lang.Boolean isModelo) {
        this.isModelo = isModelo;
    }


    /**
     * Gets the isPassaadiante value for this DwRota.
     * 
     * @return isPassaadiante
     */
    public java.lang.Boolean getIsPassaadiante() {
        return isPassaadiante;
    }


    /**
     * Sets the isPassaadiante value for this DwRota.
     * 
     * @param isPassaadiante
     */
    public void setIsPassaadiante(java.lang.Boolean isPassaadiante) {
        this.isPassaadiante = isPassaadiante;
    }


    /**
     * Gets the largura value for this DwRota.
     * 
     * @return largura
     */
    public java.math.BigDecimal getLargura() {
        return largura;
    }


    /**
     * Sets the largura value for this DwRota.
     * 
     * @param largura
     */
    public void setLargura(java.math.BigDecimal largura) {
        this.largura = largura;
    }


    /**
     * Gets the omGt value for this DwRota.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this DwRota.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omObjsForIdRota value for this DwRota.
     * 
     * @return omObjsForIdRota
     */
    public idw.idwws.OmObj[] getOmObjsForIdRota() {
        return omObjsForIdRota;
    }


    /**
     * Sets the omObjsForIdRota value for this DwRota.
     * 
     * @param omObjsForIdRota
     */
    public void setOmObjsForIdRota(idw.idwws.OmObj[] omObjsForIdRota) {
        this.omObjsForIdRota = omObjsForIdRota;
    }

    public idw.idwws.OmObj getOmObjsForIdRota(int i) {
        return this.omObjsForIdRota[i];
    }

    public void setOmObjsForIdRota(int i, idw.idwws.OmObj _value) {
        this.omObjsForIdRota[i] = _value;
    }


    /**
     * Gets the omProduto value for this DwRota.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwRota.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwRota.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwRota.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwRota.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwRota.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwRota.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwRota.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwRota.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwRota.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwRota)) return false;
        DwRota other = (DwRota) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.altura==null && other.getAltura()==null) || 
             (this.altura!=null &&
              this.altura.equals(other.getAltura()))) &&
            ((this.cdRota==null && other.getCdRota()==null) || 
             (this.cdRota!=null &&
              this.cdRota.equals(other.getCdRota()))) &&
            ((this.dsRota==null && other.getDsRota()==null) || 
             (this.dsRota!=null &&
              this.dsRota.equals(other.getDsRota()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwRotapassos==null && other.getDwRotapassos()==null) || 
             (this.dwRotapassos!=null &&
              java.util.Arrays.equals(this.dwRotapassos, other.getDwRotapassos()))) &&
            ((this.gridx==null && other.getGridx()==null) || 
             (this.gridx!=null &&
              this.gridx.equals(other.getGridx()))) &&
            ((this.gridy==null && other.getGridy()==null) || 
             (this.gridy!=null &&
              this.gridy.equals(other.getGridy()))) &&
            this.idRota == other.getIdRota() &&
            ((this.isModelo==null && other.getIsModelo()==null) || 
             (this.isModelo!=null &&
              this.isModelo.equals(other.getIsModelo()))) &&
            ((this.isPassaadiante==null && other.getIsPassaadiante()==null) || 
             (this.isPassaadiante!=null &&
              this.isPassaadiante.equals(other.getIsPassaadiante()))) &&
            ((this.largura==null && other.getLargura()==null) || 
             (this.largura!=null &&
              this.largura.equals(other.getLargura()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omObjsForIdRota==null && other.getOmObjsForIdRota()==null) || 
             (this.omObjsForIdRota!=null &&
              java.util.Arrays.equals(this.omObjsForIdRota, other.getOmObjsForIdRota()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo())));
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
        if (getAltura() != null) {
            _hashCode += getAltura().hashCode();
        }
        if (getCdRota() != null) {
            _hashCode += getCdRota().hashCode();
        }
        if (getDsRota() != null) {
            _hashCode += getDsRota().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwRotapassos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRotapassos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRotapassos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGridx() != null) {
            _hashCode += getGridx().hashCode();
        }
        if (getGridy() != null) {
            _hashCode += getGridy().hashCode();
        }
        _hashCode += new Long(getIdRota()).hashCode();
        if (getIsModelo() != null) {
            _hashCode += getIsModelo().hashCode();
        }
        if (getIsPassaadiante() != null) {
            _hashCode += getIsPassaadiante().hashCode();
        }
        if (getLargura() != null) {
            _hashCode += getLargura().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmObjsForIdRota() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmObjsForIdRota());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmObjsForIdRota(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwRota.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("altura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "altura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gridx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gridx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gridy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gridy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isModelo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isModelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPassaadiante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPassaadiante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("largura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "largura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("omObjsForIdRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjsForIdRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
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
