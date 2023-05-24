/**
 * DwPassagem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPassagem  extends idw.idwws.DwPassagemTemplate  implements java.io.Serializable {
    private java.util.Calendar dthr;

    private java.util.Calendar dthrInicio;

    private idw.idwws.DwConsolid dwConsolid;

    private idw.idwws.DwEst dwEst;

    private idw.idwws.DwNserie dwNserie;

    private idw.idwws.DwNserie[] dwNseries;

    private idw.idwws.DwPasscau dwPasscau;

    private idw.idwws.DwPasscau[] dwPasscaus;

    private idw.idwws.DwPassdef[] dwPassdefs;

    private idw.idwws.DwPassmon[] dwPassmons;

    private idw.idwws.DwPasstf[] dwPasstfs;

    private long idPassagem;

    private java.lang.Boolean isTfFinalizado;

    private java.lang.Integer msDthr;

    private java.lang.Integer msDthrinicio;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsrByIdUsroperador;

    private idw.idwws.OmUsr omUsrByIdUsrsupervisor;

    private java.math.BigDecimal segCiclo;

    private java.lang.Byte stNserie;

    public DwPassagem() {
    }

    public DwPassagem(
           java.util.Calendar dthr,
           java.util.Calendar dthrInicio,
           idw.idwws.DwConsolid dwConsolid,
           idw.idwws.DwEst dwEst,
           idw.idwws.DwNserie dwNserie,
           idw.idwws.DwNserie[] dwNseries,
           idw.idwws.DwPasscau dwPasscau,
           idw.idwws.DwPasscau[] dwPasscaus,
           idw.idwws.DwPassdef[] dwPassdefs,
           idw.idwws.DwPassmon[] dwPassmons,
           idw.idwws.DwPasstf[] dwPasstfs,
           long idPassagem,
           java.lang.Boolean isTfFinalizado,
           java.lang.Integer msDthr,
           java.lang.Integer msDthrinicio,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsroperador,
           idw.idwws.OmUsr omUsrByIdUsrsupervisor,
           java.math.BigDecimal segCiclo,
           java.lang.Byte stNserie) {
        this.dthr = dthr;
        this.dthrInicio = dthrInicio;
        this.dwConsolid = dwConsolid;
        this.dwEst = dwEst;
        this.dwNserie = dwNserie;
        this.dwNseries = dwNseries;
        this.dwPasscau = dwPasscau;
        this.dwPasscaus = dwPasscaus;
        this.dwPassdefs = dwPassdefs;
        this.dwPassmons = dwPassmons;
        this.dwPasstfs = dwPasstfs;
        this.idPassagem = idPassagem;
        this.isTfFinalizado = isTfFinalizado;
        this.msDthr = msDthr;
        this.msDthrinicio = msDthrinicio;
        this.omPt = omPt;
        this.omUsrByIdUsroperador = omUsrByIdUsroperador;
        this.omUsrByIdUsrsupervisor = omUsrByIdUsrsupervisor;
        this.segCiclo = segCiclo;
        this.stNserie = stNserie;
    }


    /**
     * Gets the dthr value for this DwPassagem.
     * 
     * @return dthr
     */
    public java.util.Calendar getDthr() {
        return dthr;
    }


    /**
     * Sets the dthr value for this DwPassagem.
     * 
     * @param dthr
     */
    public void setDthr(java.util.Calendar dthr) {
        this.dthr = dthr;
    }


    /**
     * Gets the dthrInicio value for this DwPassagem.
     * 
     * @return dthrInicio
     */
    public java.util.Calendar getDthrInicio() {
        return dthrInicio;
    }


    /**
     * Sets the dthrInicio value for this DwPassagem.
     * 
     * @param dthrInicio
     */
    public void setDthrInicio(java.util.Calendar dthrInicio) {
        this.dthrInicio = dthrInicio;
    }


    /**
     * Gets the dwConsolid value for this DwPassagem.
     * 
     * @return dwConsolid
     */
    public idw.idwws.DwConsolid getDwConsolid() {
        return dwConsolid;
    }


    /**
     * Sets the dwConsolid value for this DwPassagem.
     * 
     * @param dwConsolid
     */
    public void setDwConsolid(idw.idwws.DwConsolid dwConsolid) {
        this.dwConsolid = dwConsolid;
    }


    /**
     * Gets the dwEst value for this DwPassagem.
     * 
     * @return dwEst
     */
    public idw.idwws.DwEst getDwEst() {
        return dwEst;
    }


    /**
     * Sets the dwEst value for this DwPassagem.
     * 
     * @param dwEst
     */
    public void setDwEst(idw.idwws.DwEst dwEst) {
        this.dwEst = dwEst;
    }


    /**
     * Gets the dwNserie value for this DwPassagem.
     * 
     * @return dwNserie
     */
    public idw.idwws.DwNserie getDwNserie() {
        return dwNserie;
    }


    /**
     * Sets the dwNserie value for this DwPassagem.
     * 
     * @param dwNserie
     */
    public void setDwNserie(idw.idwws.DwNserie dwNserie) {
        this.dwNserie = dwNserie;
    }


    /**
     * Gets the dwNseries value for this DwPassagem.
     * 
     * @return dwNseries
     */
    public idw.idwws.DwNserie[] getDwNseries() {
        return dwNseries;
    }


    /**
     * Sets the dwNseries value for this DwPassagem.
     * 
     * @param dwNseries
     */
    public void setDwNseries(idw.idwws.DwNserie[] dwNseries) {
        this.dwNseries = dwNseries;
    }

    public idw.idwws.DwNserie getDwNseries(int i) {
        return this.dwNseries[i];
    }

    public void setDwNseries(int i, idw.idwws.DwNserie _value) {
        this.dwNseries[i] = _value;
    }


    /**
     * Gets the dwPasscau value for this DwPassagem.
     * 
     * @return dwPasscau
     */
    public idw.idwws.DwPasscau getDwPasscau() {
        return dwPasscau;
    }


    /**
     * Sets the dwPasscau value for this DwPassagem.
     * 
     * @param dwPasscau
     */
    public void setDwPasscau(idw.idwws.DwPasscau dwPasscau) {
        this.dwPasscau = dwPasscau;
    }


    /**
     * Gets the dwPasscaus value for this DwPassagem.
     * 
     * @return dwPasscaus
     */
    public idw.idwws.DwPasscau[] getDwPasscaus() {
        return dwPasscaus;
    }


    /**
     * Sets the dwPasscaus value for this DwPassagem.
     * 
     * @param dwPasscaus
     */
    public void setDwPasscaus(idw.idwws.DwPasscau[] dwPasscaus) {
        this.dwPasscaus = dwPasscaus;
    }

    public idw.idwws.DwPasscau getDwPasscaus(int i) {
        return this.dwPasscaus[i];
    }

    public void setDwPasscaus(int i, idw.idwws.DwPasscau _value) {
        this.dwPasscaus[i] = _value;
    }


    /**
     * Gets the dwPassdefs value for this DwPassagem.
     * 
     * @return dwPassdefs
     */
    public idw.idwws.DwPassdef[] getDwPassdefs() {
        return dwPassdefs;
    }


    /**
     * Sets the dwPassdefs value for this DwPassagem.
     * 
     * @param dwPassdefs
     */
    public void setDwPassdefs(idw.idwws.DwPassdef[] dwPassdefs) {
        this.dwPassdefs = dwPassdefs;
    }

    public idw.idwws.DwPassdef getDwPassdefs(int i) {
        return this.dwPassdefs[i];
    }

    public void setDwPassdefs(int i, idw.idwws.DwPassdef _value) {
        this.dwPassdefs[i] = _value;
    }


    /**
     * Gets the dwPassmons value for this DwPassagem.
     * 
     * @return dwPassmons
     */
    public idw.idwws.DwPassmon[] getDwPassmons() {
        return dwPassmons;
    }


    /**
     * Sets the dwPassmons value for this DwPassagem.
     * 
     * @param dwPassmons
     */
    public void setDwPassmons(idw.idwws.DwPassmon[] dwPassmons) {
        this.dwPassmons = dwPassmons;
    }

    public idw.idwws.DwPassmon getDwPassmons(int i) {
        return this.dwPassmons[i];
    }

    public void setDwPassmons(int i, idw.idwws.DwPassmon _value) {
        this.dwPassmons[i] = _value;
    }


    /**
     * Gets the dwPasstfs value for this DwPassagem.
     * 
     * @return dwPasstfs
     */
    public idw.idwws.DwPasstf[] getDwPasstfs() {
        return dwPasstfs;
    }


    /**
     * Sets the dwPasstfs value for this DwPassagem.
     * 
     * @param dwPasstfs
     */
    public void setDwPasstfs(idw.idwws.DwPasstf[] dwPasstfs) {
        this.dwPasstfs = dwPasstfs;
    }

    public idw.idwws.DwPasstf getDwPasstfs(int i) {
        return this.dwPasstfs[i];
    }

    public void setDwPasstfs(int i, idw.idwws.DwPasstf _value) {
        this.dwPasstfs[i] = _value;
    }


    /**
     * Gets the idPassagem value for this DwPassagem.
     * 
     * @return idPassagem
     */
    public long getIdPassagem() {
        return idPassagem;
    }


    /**
     * Sets the idPassagem value for this DwPassagem.
     * 
     * @param idPassagem
     */
    public void setIdPassagem(long idPassagem) {
        this.idPassagem = idPassagem;
    }


    /**
     * Gets the isTfFinalizado value for this DwPassagem.
     * 
     * @return isTfFinalizado
     */
    public java.lang.Boolean getIsTfFinalizado() {
        return isTfFinalizado;
    }


    /**
     * Sets the isTfFinalizado value for this DwPassagem.
     * 
     * @param isTfFinalizado
     */
    public void setIsTfFinalizado(java.lang.Boolean isTfFinalizado) {
        this.isTfFinalizado = isTfFinalizado;
    }


    /**
     * Gets the msDthr value for this DwPassagem.
     * 
     * @return msDthr
     */
    public java.lang.Integer getMsDthr() {
        return msDthr;
    }


    /**
     * Sets the msDthr value for this DwPassagem.
     * 
     * @param msDthr
     */
    public void setMsDthr(java.lang.Integer msDthr) {
        this.msDthr = msDthr;
    }


    /**
     * Gets the msDthrinicio value for this DwPassagem.
     * 
     * @return msDthrinicio
     */
    public java.lang.Integer getMsDthrinicio() {
        return msDthrinicio;
    }


    /**
     * Sets the msDthrinicio value for this DwPassagem.
     * 
     * @param msDthrinicio
     */
    public void setMsDthrinicio(java.lang.Integer msDthrinicio) {
        this.msDthrinicio = msDthrinicio;
    }


    /**
     * Gets the omPt value for this DwPassagem.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwPassagem.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsrByIdUsroperador value for this DwPassagem.
     * 
     * @return omUsrByIdUsroperador
     */
    public idw.idwws.OmUsr getOmUsrByIdUsroperador() {
        return omUsrByIdUsroperador;
    }


    /**
     * Sets the omUsrByIdUsroperador value for this DwPassagem.
     * 
     * @param omUsrByIdUsroperador
     */
    public void setOmUsrByIdUsroperador(idw.idwws.OmUsr omUsrByIdUsroperador) {
        this.omUsrByIdUsroperador = omUsrByIdUsroperador;
    }


    /**
     * Gets the omUsrByIdUsrsupervisor value for this DwPassagem.
     * 
     * @return omUsrByIdUsrsupervisor
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrsupervisor() {
        return omUsrByIdUsrsupervisor;
    }


    /**
     * Sets the omUsrByIdUsrsupervisor value for this DwPassagem.
     * 
     * @param omUsrByIdUsrsupervisor
     */
    public void setOmUsrByIdUsrsupervisor(idw.idwws.OmUsr omUsrByIdUsrsupervisor) {
        this.omUsrByIdUsrsupervisor = omUsrByIdUsrsupervisor;
    }


    /**
     * Gets the segCiclo value for this DwPassagem.
     * 
     * @return segCiclo
     */
    public java.math.BigDecimal getSegCiclo() {
        return segCiclo;
    }


    /**
     * Sets the segCiclo value for this DwPassagem.
     * 
     * @param segCiclo
     */
    public void setSegCiclo(java.math.BigDecimal segCiclo) {
        this.segCiclo = segCiclo;
    }


    /**
     * Gets the stNserie value for this DwPassagem.
     * 
     * @return stNserie
     */
    public java.lang.Byte getStNserie() {
        return stNserie;
    }


    /**
     * Sets the stNserie value for this DwPassagem.
     * 
     * @param stNserie
     */
    public void setStNserie(java.lang.Byte stNserie) {
        this.stNserie = stNserie;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPassagem)) return false;
        DwPassagem other = (DwPassagem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthr==null && other.getDthr()==null) || 
             (this.dthr!=null &&
              this.dthr.equals(other.getDthr()))) &&
            ((this.dthrInicio==null && other.getDthrInicio()==null) || 
             (this.dthrInicio!=null &&
              this.dthrInicio.equals(other.getDthrInicio()))) &&
            ((this.dwConsolid==null && other.getDwConsolid()==null) || 
             (this.dwConsolid!=null &&
              this.dwConsolid.equals(other.getDwConsolid()))) &&
            ((this.dwEst==null && other.getDwEst()==null) || 
             (this.dwEst!=null &&
              this.dwEst.equals(other.getDwEst()))) &&
            ((this.dwNserie==null && other.getDwNserie()==null) || 
             (this.dwNserie!=null &&
              this.dwNserie.equals(other.getDwNserie()))) &&
            ((this.dwNseries==null && other.getDwNseries()==null) || 
             (this.dwNseries!=null &&
              java.util.Arrays.equals(this.dwNseries, other.getDwNseries()))) &&
            ((this.dwPasscau==null && other.getDwPasscau()==null) || 
             (this.dwPasscau!=null &&
              this.dwPasscau.equals(other.getDwPasscau()))) &&
            ((this.dwPasscaus==null && other.getDwPasscaus()==null) || 
             (this.dwPasscaus!=null &&
              java.util.Arrays.equals(this.dwPasscaus, other.getDwPasscaus()))) &&
            ((this.dwPassdefs==null && other.getDwPassdefs()==null) || 
             (this.dwPassdefs!=null &&
              java.util.Arrays.equals(this.dwPassdefs, other.getDwPassdefs()))) &&
            ((this.dwPassmons==null && other.getDwPassmons()==null) || 
             (this.dwPassmons!=null &&
              java.util.Arrays.equals(this.dwPassmons, other.getDwPassmons()))) &&
            ((this.dwPasstfs==null && other.getDwPasstfs()==null) || 
             (this.dwPasstfs!=null &&
              java.util.Arrays.equals(this.dwPasstfs, other.getDwPasstfs()))) &&
            this.idPassagem == other.getIdPassagem() &&
            ((this.isTfFinalizado==null && other.getIsTfFinalizado()==null) || 
             (this.isTfFinalizado!=null &&
              this.isTfFinalizado.equals(other.getIsTfFinalizado()))) &&
            ((this.msDthr==null && other.getMsDthr()==null) || 
             (this.msDthr!=null &&
              this.msDthr.equals(other.getMsDthr()))) &&
            ((this.msDthrinicio==null && other.getMsDthrinicio()==null) || 
             (this.msDthrinicio!=null &&
              this.msDthrinicio.equals(other.getMsDthrinicio()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsrByIdUsroperador==null && other.getOmUsrByIdUsroperador()==null) || 
             (this.omUsrByIdUsroperador!=null &&
              this.omUsrByIdUsroperador.equals(other.getOmUsrByIdUsroperador()))) &&
            ((this.omUsrByIdUsrsupervisor==null && other.getOmUsrByIdUsrsupervisor()==null) || 
             (this.omUsrByIdUsrsupervisor!=null &&
              this.omUsrByIdUsrsupervisor.equals(other.getOmUsrByIdUsrsupervisor()))) &&
            ((this.segCiclo==null && other.getSegCiclo()==null) || 
             (this.segCiclo!=null &&
              this.segCiclo.equals(other.getSegCiclo()))) &&
            ((this.stNserie==null && other.getStNserie()==null) || 
             (this.stNserie!=null &&
              this.stNserie.equals(other.getStNserie())));
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
        if (getDthr() != null) {
            _hashCode += getDthr().hashCode();
        }
        if (getDthrInicio() != null) {
            _hashCode += getDthrInicio().hashCode();
        }
        if (getDwConsolid() != null) {
            _hashCode += getDwConsolid().hashCode();
        }
        if (getDwEst() != null) {
            _hashCode += getDwEst().hashCode();
        }
        if (getDwNserie() != null) {
            _hashCode += getDwNserie().hashCode();
        }
        if (getDwNseries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwNseries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwNseries(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPasscau() != null) {
            _hashCode += getDwPasscau().hashCode();
        }
        if (getDwPasscaus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPasscaus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPasscaus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPassdefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassdefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassdefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPassmons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassmons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassmons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPasstfs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPasstfs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPasstfs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdPassagem()).hashCode();
        if (getIsTfFinalizado() != null) {
            _hashCode += getIsTfFinalizado().hashCode();
        }
        if (getMsDthr() != null) {
            _hashCode += getMsDthr().hashCode();
        }
        if (getMsDthrinicio() != null) {
            _hashCode += getMsDthrinicio().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsrByIdUsroperador() != null) {
            _hashCode += getOmUsrByIdUsroperador().hashCode();
        }
        if (getOmUsrByIdUsrsupervisor() != null) {
            _hashCode += getOmUsrByIdUsrsupervisor().hashCode();
        }
        if (getSegCiclo() != null) {
            _hashCode += getSegCiclo().hashCode();
        }
        if (getStNserie() != null) {
            _hashCode += getStNserie().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPassagem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwNserie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwNserie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwNserie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwNseries");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwNseries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwNserie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasscau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasscau"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasscau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasscaus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasscaus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasscau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassdefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassdefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassdef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassmons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassmons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassmon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasstfs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasstfs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTfFinalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isTfFinalizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrinicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrinicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("omUsrByIdUsroperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsroperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrsupervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrsupervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stNserie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stNserie"));
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
