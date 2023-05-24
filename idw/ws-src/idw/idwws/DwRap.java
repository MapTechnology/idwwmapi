/**
 * DwRap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwRap  extends idw.idwws.DwRapTemplate  implements java.io.Serializable {
    private java.lang.String cdRap;

    private java.lang.String depara;

    private java.lang.String dsRap;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwFolharap[] dwFolharaps;

    private idw.idwws.DwRap dwRap;

    private idw.idwws.DwRap[] dwRaps;

    private java.lang.Long idRap;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpIndispRappt[] ppIndispRappts;

    private java.math.BigDecimal qtAlocada;

    private java.math.BigDecimal qtTotal;

    private java.lang.Long revisao;

    private java.math.BigDecimal segTempoliberacao;

    private java.lang.Byte stAtivo;

    private java.math.BigDecimal tpRap;

    public DwRap() {
    }

    public DwRap(
           java.lang.Long id,
           java.lang.String cdRap,
           java.lang.String depara,
           java.lang.String dsRap,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwFolharap[] dwFolharaps,
           idw.idwws.DwRap dwRap,
           idw.idwws.DwRap[] dwRaps,
           java.lang.Long idRap,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpIndispRappt[] ppIndispRappts,
           java.math.BigDecimal qtAlocada,
           java.math.BigDecimal qtTotal,
           java.lang.Long revisao,
           java.math.BigDecimal segTempoliberacao,
           java.lang.Byte stAtivo,
           java.math.BigDecimal tpRap) {
        super(
            id);
        this.cdRap = cdRap;
        this.depara = depara;
        this.dsRap = dsRap;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwFolharaps = dwFolharaps;
        this.dwRap = dwRap;
        this.dwRaps = dwRaps;
        this.idRap = idRap;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppIndispRappts = ppIndispRappts;
        this.qtAlocada = qtAlocada;
        this.qtTotal = qtTotal;
        this.revisao = revisao;
        this.segTempoliberacao = segTempoliberacao;
        this.stAtivo = stAtivo;
        this.tpRap = tpRap;
    }


    /**
     * Gets the cdRap value for this DwRap.
     * 
     * @return cdRap
     */
    public java.lang.String getCdRap() {
        return cdRap;
    }


    /**
     * Sets the cdRap value for this DwRap.
     * 
     * @param cdRap
     */
    public void setCdRap(java.lang.String cdRap) {
        this.cdRap = cdRap;
    }


    /**
     * Gets the depara value for this DwRap.
     * 
     * @return depara
     */
    public java.lang.String getDepara() {
        return depara;
    }


    /**
     * Sets the depara value for this DwRap.
     * 
     * @param depara
     */
    public void setDepara(java.lang.String depara) {
        this.depara = depara;
    }


    /**
     * Gets the dsRap value for this DwRap.
     * 
     * @return dsRap
     */
    public java.lang.String getDsRap() {
        return dsRap;
    }


    /**
     * Sets the dsRap value for this DwRap.
     * 
     * @param dsRap
     */
    public void setDsRap(java.lang.String dsRap) {
        this.dsRap = dsRap;
    }


    /**
     * Gets the dtRevisao value for this DwRap.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwRap.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwRap.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwRap.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwFolharaps value for this DwRap.
     * 
     * @return dwFolharaps
     */
    public idw.idwws.DwFolharap[] getDwFolharaps() {
        return dwFolharaps;
    }


    /**
     * Sets the dwFolharaps value for this DwRap.
     * 
     * @param dwFolharaps
     */
    public void setDwFolharaps(idw.idwws.DwFolharap[] dwFolharaps) {
        this.dwFolharaps = dwFolharaps;
    }

    public idw.idwws.DwFolharap getDwFolharaps(int i) {
        return this.dwFolharaps[i];
    }

    public void setDwFolharaps(int i, idw.idwws.DwFolharap _value) {
        this.dwFolharaps[i] = _value;
    }


    /**
     * Gets the dwRap value for this DwRap.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this DwRap.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the dwRaps value for this DwRap.
     * 
     * @return dwRaps
     */
    public idw.idwws.DwRap[] getDwRaps() {
        return dwRaps;
    }


    /**
     * Sets the dwRaps value for this DwRap.
     * 
     * @param dwRaps
     */
    public void setDwRaps(idw.idwws.DwRap[] dwRaps) {
        this.dwRaps = dwRaps;
    }

    public idw.idwws.DwRap getDwRaps(int i) {
        return this.dwRaps[i];
    }

    public void setDwRaps(int i, idw.idwws.DwRap _value) {
        this.dwRaps[i] = _value;
    }


    /**
     * Gets the idRap value for this DwRap.
     * 
     * @return idRap
     */
    public java.lang.Long getIdRap() {
        return idRap;
    }


    /**
     * Sets the idRap value for this DwRap.
     * 
     * @param idRap
     */
    public void setIdRap(java.lang.Long idRap) {
        this.idRap = idRap;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwRap.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwRap.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwRap.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwRap.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppIndispRappts value for this DwRap.
     * 
     * @return ppIndispRappts
     */
    public idw.idwws.PpIndispRappt[] getPpIndispRappts() {
        return ppIndispRappts;
    }


    /**
     * Sets the ppIndispRappts value for this DwRap.
     * 
     * @param ppIndispRappts
     */
    public void setPpIndispRappts(idw.idwws.PpIndispRappt[] ppIndispRappts) {
        this.ppIndispRappts = ppIndispRappts;
    }

    public idw.idwws.PpIndispRappt getPpIndispRappts(int i) {
        return this.ppIndispRappts[i];
    }

    public void setPpIndispRappts(int i, idw.idwws.PpIndispRappt _value) {
        this.ppIndispRappts[i] = _value;
    }


    /**
     * Gets the qtAlocada value for this DwRap.
     * 
     * @return qtAlocada
     */
    public java.math.BigDecimal getQtAlocada() {
        return qtAlocada;
    }


    /**
     * Sets the qtAlocada value for this DwRap.
     * 
     * @param qtAlocada
     */
    public void setQtAlocada(java.math.BigDecimal qtAlocada) {
        this.qtAlocada = qtAlocada;
    }


    /**
     * Gets the qtTotal value for this DwRap.
     * 
     * @return qtTotal
     */
    public java.math.BigDecimal getQtTotal() {
        return qtTotal;
    }


    /**
     * Sets the qtTotal value for this DwRap.
     * 
     * @param qtTotal
     */
    public void setQtTotal(java.math.BigDecimal qtTotal) {
        this.qtTotal = qtTotal;
    }


    /**
     * Gets the revisao value for this DwRap.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwRap.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the segTempoliberacao value for this DwRap.
     * 
     * @return segTempoliberacao
     */
    public java.math.BigDecimal getSegTempoliberacao() {
        return segTempoliberacao;
    }


    /**
     * Sets the segTempoliberacao value for this DwRap.
     * 
     * @param segTempoliberacao
     */
    public void setSegTempoliberacao(java.math.BigDecimal segTempoliberacao) {
        this.segTempoliberacao = segTempoliberacao;
    }


    /**
     * Gets the stAtivo value for this DwRap.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwRap.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpRap value for this DwRap.
     * 
     * @return tpRap
     */
    public java.math.BigDecimal getTpRap() {
        return tpRap;
    }


    /**
     * Sets the tpRap value for this DwRap.
     * 
     * @param tpRap
     */
    public void setTpRap(java.math.BigDecimal tpRap) {
        this.tpRap = tpRap;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwRap)) return false;
        DwRap other = (DwRap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdRap==null && other.getCdRap()==null) || 
             (this.cdRap!=null &&
              this.cdRap.equals(other.getCdRap()))) &&
            ((this.depara==null && other.getDepara()==null) || 
             (this.depara!=null &&
              this.depara.equals(other.getDepara()))) &&
            ((this.dsRap==null && other.getDsRap()==null) || 
             (this.dsRap!=null &&
              this.dsRap.equals(other.getDsRap()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwFolharaps==null && other.getDwFolharaps()==null) || 
             (this.dwFolharaps!=null &&
              java.util.Arrays.equals(this.dwFolharaps, other.getDwFolharaps()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.dwRaps==null && other.getDwRaps()==null) || 
             (this.dwRaps!=null &&
              java.util.Arrays.equals(this.dwRaps, other.getDwRaps()))) &&
            ((this.idRap==null && other.getIdRap()==null) || 
             (this.idRap!=null &&
              this.idRap.equals(other.getIdRap()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppIndispRappts==null && other.getPpIndispRappts()==null) || 
             (this.ppIndispRappts!=null &&
              java.util.Arrays.equals(this.ppIndispRappts, other.getPpIndispRappts()))) &&
            ((this.qtAlocada==null && other.getQtAlocada()==null) || 
             (this.qtAlocada!=null &&
              this.qtAlocada.equals(other.getQtAlocada()))) &&
            ((this.qtTotal==null && other.getQtTotal()==null) || 
             (this.qtTotal!=null &&
              this.qtTotal.equals(other.getQtTotal()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.segTempoliberacao==null && other.getSegTempoliberacao()==null) || 
             (this.segTempoliberacao!=null &&
              this.segTempoliberacao.equals(other.getSegTempoliberacao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpRap==null && other.getTpRap()==null) || 
             (this.tpRap!=null &&
              this.tpRap.equals(other.getTpRap())));
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
        if (getCdRap() != null) {
            _hashCode += getCdRap().hashCode();
        }
        if (getDepara() != null) {
            _hashCode += getDepara().hashCode();
        }
        if (getDsRap() != null) {
            _hashCode += getDsRap().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwFolharaps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolharaps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolharaps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getDwRaps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRaps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRaps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdRap() != null) {
            _hashCode += getIdRap().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpIndispRappts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpIndispRappts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpIndispRappts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQtAlocada() != null) {
            _hashCode += getQtAlocada().hashCode();
        }
        if (getQtTotal() != null) {
            _hashCode += getQtTotal().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getSegTempoliberacao() != null) {
            _hashCode += getSegTempoliberacao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpRap() != null) {
            _hashCode += getTpRap().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwRap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsRap"));
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
        elemField.setFieldName("dwFolharaps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolharaps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolharap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRaps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRaps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("ppIndispRappts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppIndispRappts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppIndispRappt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAlocada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAlocada"));
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
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempoliberacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempoliberacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpRap"));
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
