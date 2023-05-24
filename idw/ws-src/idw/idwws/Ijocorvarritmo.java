/**
 * Ijocorvarritmo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijocorvarritmo  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdmolde;

    private java.lang.String cdturno;

    private java.util.Calendar dthrfim;

    private java.util.Calendar dthrinicio;

    private java.util.Calendar dthrivalcic;

    private java.util.Calendar dthrivalestru;

    private idw.idwws.Exportacao030[] exportacao030S;

    private double idregvarritmo;

    private idw.idwws.Ijocorvarritmoitem[] ijocorvarritmoitems;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbpro ijtbpro;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String nropexibicao;

    private double percvarritmo;

    private double qtdhrprod;

    private double qtdinj;

    private double qtdprod;

    private double qtdref;

    private org.apache.axis.types.UnsignedShort tpevtprod;

    public Ijocorvarritmo() {
    }

    public Ijocorvarritmo(
           java.lang.String cdestrutura,
           java.lang.String cdmolde,
           java.lang.String cdturno,
           java.util.Calendar dthrfim,
           java.util.Calendar dthrinicio,
           java.util.Calendar dthrivalcic,
           java.util.Calendar dthrivalestru,
           idw.idwws.Exportacao030[] exportacao030S,
           double idregvarritmo,
           idw.idwws.Ijocorvarritmoitem[] ijocorvarritmoitems,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbpro ijtbpro,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String nropexibicao,
           double percvarritmo,
           double qtdhrprod,
           double qtdinj,
           double qtdprod,
           double qtdref,
           org.apache.axis.types.UnsignedShort tpevtprod) {
           this.cdestrutura = cdestrutura;
           this.cdmolde = cdmolde;
           this.cdturno = cdturno;
           this.dthrfim = dthrfim;
           this.dthrinicio = dthrinicio;
           this.dthrivalcic = dthrivalcic;
           this.dthrivalestru = dthrivalestru;
           this.exportacao030S = exportacao030S;
           this.idregvarritmo = idregvarritmo;
           this.ijocorvarritmoitems = ijocorvarritmoitems;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.ijtbpro = ijtbpro;
           this.ijtbusu = ijtbusu;
           this.nropexibicao = nropexibicao;
           this.percvarritmo = percvarritmo;
           this.qtdhrprod = qtdhrprod;
           this.qtdinj = qtdinj;
           this.qtdprod = qtdprod;
           this.qtdref = qtdref;
           this.tpevtprod = tpevtprod;
    }


    /**
     * Gets the cdestrutura value for this Ijocorvarritmo.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this Ijocorvarritmo.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdmolde value for this Ijocorvarritmo.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this Ijocorvarritmo.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdturno value for this Ijocorvarritmo.
     * 
     * @return cdturno
     */
    public java.lang.String getCdturno() {
        return cdturno;
    }


    /**
     * Sets the cdturno value for this Ijocorvarritmo.
     * 
     * @param cdturno
     */
    public void setCdturno(java.lang.String cdturno) {
        this.cdturno = cdturno;
    }


    /**
     * Gets the dthrfim value for this Ijocorvarritmo.
     * 
     * @return dthrfim
     */
    public java.util.Calendar getDthrfim() {
        return dthrfim;
    }


    /**
     * Sets the dthrfim value for this Ijocorvarritmo.
     * 
     * @param dthrfim
     */
    public void setDthrfim(java.util.Calendar dthrfim) {
        this.dthrfim = dthrfim;
    }


    /**
     * Gets the dthrinicio value for this Ijocorvarritmo.
     * 
     * @return dthrinicio
     */
    public java.util.Calendar getDthrinicio() {
        return dthrinicio;
    }


    /**
     * Sets the dthrinicio value for this Ijocorvarritmo.
     * 
     * @param dthrinicio
     */
    public void setDthrinicio(java.util.Calendar dthrinicio) {
        this.dthrinicio = dthrinicio;
    }


    /**
     * Gets the dthrivalcic value for this Ijocorvarritmo.
     * 
     * @return dthrivalcic
     */
    public java.util.Calendar getDthrivalcic() {
        return dthrivalcic;
    }


    /**
     * Sets the dthrivalcic value for this Ijocorvarritmo.
     * 
     * @param dthrivalcic
     */
    public void setDthrivalcic(java.util.Calendar dthrivalcic) {
        this.dthrivalcic = dthrivalcic;
    }


    /**
     * Gets the dthrivalestru value for this Ijocorvarritmo.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijocorvarritmo.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the exportacao030S value for this Ijocorvarritmo.
     * 
     * @return exportacao030S
     */
    public idw.idwws.Exportacao030[] getExportacao030S() {
        return exportacao030S;
    }


    /**
     * Sets the exportacao030S value for this Ijocorvarritmo.
     * 
     * @param exportacao030S
     */
    public void setExportacao030S(idw.idwws.Exportacao030[] exportacao030S) {
        this.exportacao030S = exportacao030S;
    }

    public idw.idwws.Exportacao030 getExportacao030S(int i) {
        return this.exportacao030S[i];
    }

    public void setExportacao030S(int i, idw.idwws.Exportacao030 _value) {
        this.exportacao030S[i] = _value;
    }


    /**
     * Gets the idregvarritmo value for this Ijocorvarritmo.
     * 
     * @return idregvarritmo
     */
    public double getIdregvarritmo() {
        return idregvarritmo;
    }


    /**
     * Sets the idregvarritmo value for this Ijocorvarritmo.
     * 
     * @param idregvarritmo
     */
    public void setIdregvarritmo(double idregvarritmo) {
        this.idregvarritmo = idregvarritmo;
    }


    /**
     * Gets the ijocorvarritmoitems value for this Ijocorvarritmo.
     * 
     * @return ijocorvarritmoitems
     */
    public idw.idwws.Ijocorvarritmoitem[] getIjocorvarritmoitems() {
        return ijocorvarritmoitems;
    }


    /**
     * Sets the ijocorvarritmoitems value for this Ijocorvarritmo.
     * 
     * @param ijocorvarritmoitems
     */
    public void setIjocorvarritmoitems(idw.idwws.Ijocorvarritmoitem[] ijocorvarritmoitems) {
        this.ijocorvarritmoitems = ijocorvarritmoitems;
    }

    public idw.idwws.Ijocorvarritmoitem getIjocorvarritmoitems(int i) {
        return this.ijocorvarritmoitems[i];
    }

    public void setIjocorvarritmoitems(int i, idw.idwws.Ijocorvarritmoitem _value) {
        this.ijocorvarritmoitems[i] = _value;
    }


    /**
     * Gets the ijop value for this Ijocorvarritmo.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijocorvarritmo.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijocorvarritmo.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijocorvarritmo.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbpro value for this Ijocorvarritmo.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijocorvarritmo.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the ijtbusu value for this Ijocorvarritmo.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijocorvarritmo.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the nropexibicao value for this Ijocorvarritmo.
     * 
     * @return nropexibicao
     */
    public java.lang.String getNropexibicao() {
        return nropexibicao;
    }


    /**
     * Sets the nropexibicao value for this Ijocorvarritmo.
     * 
     * @param nropexibicao
     */
    public void setNropexibicao(java.lang.String nropexibicao) {
        this.nropexibicao = nropexibicao;
    }


    /**
     * Gets the percvarritmo value for this Ijocorvarritmo.
     * 
     * @return percvarritmo
     */
    public double getPercvarritmo() {
        return percvarritmo;
    }


    /**
     * Sets the percvarritmo value for this Ijocorvarritmo.
     * 
     * @param percvarritmo
     */
    public void setPercvarritmo(double percvarritmo) {
        this.percvarritmo = percvarritmo;
    }


    /**
     * Gets the qtdhrprod value for this Ijocorvarritmo.
     * 
     * @return qtdhrprod
     */
    public double getQtdhrprod() {
        return qtdhrprod;
    }


    /**
     * Sets the qtdhrprod value for this Ijocorvarritmo.
     * 
     * @param qtdhrprod
     */
    public void setQtdhrprod(double qtdhrprod) {
        this.qtdhrprod = qtdhrprod;
    }


    /**
     * Gets the qtdinj value for this Ijocorvarritmo.
     * 
     * @return qtdinj
     */
    public double getQtdinj() {
        return qtdinj;
    }


    /**
     * Sets the qtdinj value for this Ijocorvarritmo.
     * 
     * @param qtdinj
     */
    public void setQtdinj(double qtdinj) {
        this.qtdinj = qtdinj;
    }


    /**
     * Gets the qtdprod value for this Ijocorvarritmo.
     * 
     * @return qtdprod
     */
    public double getQtdprod() {
        return qtdprod;
    }


    /**
     * Sets the qtdprod value for this Ijocorvarritmo.
     * 
     * @param qtdprod
     */
    public void setQtdprod(double qtdprod) {
        this.qtdprod = qtdprod;
    }


    /**
     * Gets the qtdref value for this Ijocorvarritmo.
     * 
     * @return qtdref
     */
    public double getQtdref() {
        return qtdref;
    }


    /**
     * Sets the qtdref value for this Ijocorvarritmo.
     * 
     * @param qtdref
     */
    public void setQtdref(double qtdref) {
        this.qtdref = qtdref;
    }


    /**
     * Gets the tpevtprod value for this Ijocorvarritmo.
     * 
     * @return tpevtprod
     */
    public org.apache.axis.types.UnsignedShort getTpevtprod() {
        return tpevtprod;
    }


    /**
     * Sets the tpevtprod value for this Ijocorvarritmo.
     * 
     * @param tpevtprod
     */
    public void setTpevtprod(org.apache.axis.types.UnsignedShort tpevtprod) {
        this.tpevtprod = tpevtprod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijocorvarritmo)) return false;
        Ijocorvarritmo other = (Ijocorvarritmo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdturno==null && other.getCdturno()==null) || 
             (this.cdturno!=null &&
              this.cdturno.equals(other.getCdturno()))) &&
            ((this.dthrfim==null && other.getDthrfim()==null) || 
             (this.dthrfim!=null &&
              this.dthrfim.equals(other.getDthrfim()))) &&
            ((this.dthrinicio==null && other.getDthrinicio()==null) || 
             (this.dthrinicio!=null &&
              this.dthrinicio.equals(other.getDthrinicio()))) &&
            ((this.dthrivalcic==null && other.getDthrivalcic()==null) || 
             (this.dthrivalcic!=null &&
              this.dthrivalcic.equals(other.getDthrivalcic()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.exportacao030S==null && other.getExportacao030S()==null) || 
             (this.exportacao030S!=null &&
              java.util.Arrays.equals(this.exportacao030S, other.getExportacao030S()))) &&
            this.idregvarritmo == other.getIdregvarritmo() &&
            ((this.ijocorvarritmoitems==null && other.getIjocorvarritmoitems()==null) || 
             (this.ijocorvarritmoitems!=null &&
              java.util.Arrays.equals(this.ijocorvarritmoitems, other.getIjocorvarritmoitems()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.nropexibicao==null && other.getNropexibicao()==null) || 
             (this.nropexibicao!=null &&
              this.nropexibicao.equals(other.getNropexibicao()))) &&
            this.percvarritmo == other.getPercvarritmo() &&
            this.qtdhrprod == other.getQtdhrprod() &&
            this.qtdinj == other.getQtdinj() &&
            this.qtdprod == other.getQtdprod() &&
            this.qtdref == other.getQtdref() &&
            ((this.tpevtprod==null && other.getTpevtprod()==null) || 
             (this.tpevtprod!=null &&
              this.tpevtprod.equals(other.getTpevtprod())));
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
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdturno() != null) {
            _hashCode += getCdturno().hashCode();
        }
        if (getDthrfim() != null) {
            _hashCode += getDthrfim().hashCode();
        }
        if (getDthrinicio() != null) {
            _hashCode += getDthrinicio().hashCode();
        }
        if (getDthrivalcic() != null) {
            _hashCode += getDthrivalcic().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getExportacao030S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao030S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao030S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getIdregvarritmo()).hashCode();
        if (getIjocorvarritmoitems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjocorvarritmoitems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjocorvarritmoitems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getNropexibicao() != null) {
            _hashCode += getNropexibicao().hashCode();
        }
        _hashCode += new Double(getPercvarritmo()).hashCode();
        _hashCode += new Double(getQtdhrprod()).hashCode();
        _hashCode += new Double(getQtdinj()).hashCode();
        _hashCode += new Double(getQtdprod()).hashCode();
        _hashCode += new Double(getQtdref()).hashCode();
        if (getTpevtprod() != null) {
            _hashCode += getTpevtprod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijocorvarritmo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorvarritmo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao030S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao030s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao030"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregvarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregvarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorvarritmoitems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorvarritmoitems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorvarritmoitem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
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
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropexibicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropexibicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percvarritmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percvarritmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdhrprod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdhrprod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdprod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdprod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdref");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpevtprod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpevtprod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
