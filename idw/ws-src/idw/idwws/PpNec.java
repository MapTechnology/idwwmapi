/**
 * PpNec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNec  extends idw.idwws.PpNecTemplate  implements java.io.Serializable {
    private java.lang.String cdNec;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.math.BigDecimal hrLeadtime;

    private java.lang.Long idNec;

    private java.lang.String nrDoc;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpCliente ppCliente;

    private idw.idwws.PpNeccron[] ppNeccrons;

    private idw.idwws.PpNecimpurllog ppNecimpurllog;

    private idw.idwws.PpPlanec[] ppPlanecs;

    private java.lang.Long revisao;

    private java.lang.Integer stAtivo;

    private java.lang.Integer tpNec;

    private java.lang.String urlOrigem;

    public PpNec() {
    }

    public PpNec(
           java.lang.String cdNec,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.math.BigDecimal hrLeadtime,
           java.lang.Long idNec,
           java.lang.String nrDoc,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCliente ppCliente,
           idw.idwws.PpNeccron[] ppNeccrons,
           idw.idwws.PpNecimpurllog ppNecimpurllog,
           idw.idwws.PpPlanec[] ppPlanecs,
           java.lang.Long revisao,
           java.lang.Integer stAtivo,
           java.lang.Integer tpNec,
           java.lang.String urlOrigem) {
        this.cdNec = cdNec;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.hrLeadtime = hrLeadtime;
        this.idNec = idNec;
        this.nrDoc = nrDoc;
        this.omProduto = omProduto;
        this.omPt = omPt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppCliente = ppCliente;
        this.ppNeccrons = ppNeccrons;
        this.ppNecimpurllog = ppNecimpurllog;
        this.ppPlanecs = ppPlanecs;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.tpNec = tpNec;
        this.urlOrigem = urlOrigem;
    }


    /**
     * Gets the cdNec value for this PpNec.
     * 
     * @return cdNec
     */
    public java.lang.String getCdNec() {
        return cdNec;
    }


    /**
     * Sets the cdNec value for this PpNec.
     * 
     * @param cdNec
     */
    public void setCdNec(java.lang.String cdNec) {
        this.cdNec = cdNec;
    }


    /**
     * Gets the dtRevisao value for this PpNec.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this PpNec.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this PpNec.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this PpNec.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the hrLeadtime value for this PpNec.
     * 
     * @return hrLeadtime
     */
    public java.math.BigDecimal getHrLeadtime() {
        return hrLeadtime;
    }


    /**
     * Sets the hrLeadtime value for this PpNec.
     * 
     * @param hrLeadtime
     */
    public void setHrLeadtime(java.math.BigDecimal hrLeadtime) {
        this.hrLeadtime = hrLeadtime;
    }


    /**
     * Gets the idNec value for this PpNec.
     * 
     * @return idNec
     */
    public java.lang.Long getIdNec() {
        return idNec;
    }


    /**
     * Sets the idNec value for this PpNec.
     * 
     * @param idNec
     */
    public void setIdNec(java.lang.Long idNec) {
        this.idNec = idNec;
    }


    /**
     * Gets the nrDoc value for this PpNec.
     * 
     * @return nrDoc
     */
    public java.lang.String getNrDoc() {
        return nrDoc;
    }


    /**
     * Sets the nrDoc value for this PpNec.
     * 
     * @param nrDoc
     */
    public void setNrDoc(java.lang.String nrDoc) {
        this.nrDoc = nrDoc;
    }


    /**
     * Gets the omProduto value for this PpNec.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this PpNec.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the omPt value for this PpNec.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this PpNec.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this PpNec.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this PpNec.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this PpNec.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this PpNec.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppCliente value for this PpNec.
     * 
     * @return ppCliente
     */
    public idw.idwws.PpCliente getPpCliente() {
        return ppCliente;
    }


    /**
     * Sets the ppCliente value for this PpNec.
     * 
     * @param ppCliente
     */
    public void setPpCliente(idw.idwws.PpCliente ppCliente) {
        this.ppCliente = ppCliente;
    }


    /**
     * Gets the ppNeccrons value for this PpNec.
     * 
     * @return ppNeccrons
     */
    public idw.idwws.PpNeccron[] getPpNeccrons() {
        return ppNeccrons;
    }


    /**
     * Sets the ppNeccrons value for this PpNec.
     * 
     * @param ppNeccrons
     */
    public void setPpNeccrons(idw.idwws.PpNeccron[] ppNeccrons) {
        this.ppNeccrons = ppNeccrons;
    }

    public idw.idwws.PpNeccron getPpNeccrons(int i) {
        return this.ppNeccrons[i];
    }

    public void setPpNeccrons(int i, idw.idwws.PpNeccron _value) {
        this.ppNeccrons[i] = _value;
    }


    /**
     * Gets the ppNecimpurllog value for this PpNec.
     * 
     * @return ppNecimpurllog
     */
    public idw.idwws.PpNecimpurllog getPpNecimpurllog() {
        return ppNecimpurllog;
    }


    /**
     * Sets the ppNecimpurllog value for this PpNec.
     * 
     * @param ppNecimpurllog
     */
    public void setPpNecimpurllog(idw.idwws.PpNecimpurllog ppNecimpurllog) {
        this.ppNecimpurllog = ppNecimpurllog;
    }


    /**
     * Gets the ppPlanecs value for this PpNec.
     * 
     * @return ppPlanecs
     */
    public idw.idwws.PpPlanec[] getPpPlanecs() {
        return ppPlanecs;
    }


    /**
     * Sets the ppPlanecs value for this PpNec.
     * 
     * @param ppPlanecs
     */
    public void setPpPlanecs(idw.idwws.PpPlanec[] ppPlanecs) {
        this.ppPlanecs = ppPlanecs;
    }

    public idw.idwws.PpPlanec getPpPlanecs(int i) {
        return this.ppPlanecs[i];
    }

    public void setPpPlanecs(int i, idw.idwws.PpPlanec _value) {
        this.ppPlanecs[i] = _value;
    }


    /**
     * Gets the revisao value for this PpNec.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this PpNec.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this PpNec.
     * 
     * @return stAtivo
     */
    public java.lang.Integer getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this PpNec.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Integer stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpNec value for this PpNec.
     * 
     * @return tpNec
     */
    public java.lang.Integer getTpNec() {
        return tpNec;
    }


    /**
     * Sets the tpNec value for this PpNec.
     * 
     * @param tpNec
     */
    public void setTpNec(java.lang.Integer tpNec) {
        this.tpNec = tpNec;
    }


    /**
     * Gets the urlOrigem value for this PpNec.
     * 
     * @return urlOrigem
     */
    public java.lang.String getUrlOrigem() {
        return urlOrigem;
    }


    /**
     * Sets the urlOrigem value for this PpNec.
     * 
     * @param urlOrigem
     */
    public void setUrlOrigem(java.lang.String urlOrigem) {
        this.urlOrigem = urlOrigem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNec)) return false;
        PpNec other = (PpNec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdNec==null && other.getCdNec()==null) || 
             (this.cdNec!=null &&
              this.cdNec.equals(other.getCdNec()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.hrLeadtime==null && other.getHrLeadtime()==null) || 
             (this.hrLeadtime!=null &&
              this.hrLeadtime.equals(other.getHrLeadtime()))) &&
            ((this.idNec==null && other.getIdNec()==null) || 
             (this.idNec!=null &&
              this.idNec.equals(other.getIdNec()))) &&
            ((this.nrDoc==null && other.getNrDoc()==null) || 
             (this.nrDoc!=null &&
              this.nrDoc.equals(other.getNrDoc()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppCliente==null && other.getPpCliente()==null) || 
             (this.ppCliente!=null &&
              this.ppCliente.equals(other.getPpCliente()))) &&
            ((this.ppNeccrons==null && other.getPpNeccrons()==null) || 
             (this.ppNeccrons!=null &&
              java.util.Arrays.equals(this.ppNeccrons, other.getPpNeccrons()))) &&
            ((this.ppNecimpurllog==null && other.getPpNecimpurllog()==null) || 
             (this.ppNecimpurllog!=null &&
              this.ppNecimpurllog.equals(other.getPpNecimpurllog()))) &&
            ((this.ppPlanecs==null && other.getPpPlanecs()==null) || 
             (this.ppPlanecs!=null &&
              java.util.Arrays.equals(this.ppPlanecs, other.getPpPlanecs()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpNec==null && other.getTpNec()==null) || 
             (this.tpNec!=null &&
              this.tpNec.equals(other.getTpNec()))) &&
            ((this.urlOrigem==null && other.getUrlOrigem()==null) || 
             (this.urlOrigem!=null &&
              this.urlOrigem.equals(other.getUrlOrigem())));
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
        if (getCdNec() != null) {
            _hashCode += getCdNec().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getHrLeadtime() != null) {
            _hashCode += getHrLeadtime().hashCode();
        }
        if (getIdNec() != null) {
            _hashCode += getIdNec().hashCode();
        }
        if (getNrDoc() != null) {
            _hashCode += getNrDoc().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpCliente() != null) {
            _hashCode += getPpCliente().hashCode();
        }
        if (getPpNeccrons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpNeccrons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpNeccrons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpNecimpurllog() != null) {
            _hashCode += getPpNecimpurllog().hashCode();
        }
        if (getPpPlanecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpPlanecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpPlanecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpNec() != null) {
            _hashCode += getTpNec().hashCode();
        }
        if (getUrlOrigem() != null) {
            _hashCode += getUrlOrigem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdNec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdNec"));
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
        elemField.setFieldName("hrLeadtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrLeadtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrDoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrDoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
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
        elemField.setFieldName("ppCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNeccrons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNeccrons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNeccron"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNecimpurllog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNecimpurllog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurllog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlanecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlanecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlanec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpNec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpNec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlOrigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlOrigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
