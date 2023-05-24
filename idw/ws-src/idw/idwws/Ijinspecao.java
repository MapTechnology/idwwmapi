/**
 * Ijinspecao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijinspecao  implements java.io.Serializable {
    private java.lang.String cdturnoalerta;

    private java.util.Calendar dthralerta;

    private java.util.Calendar dthrcancelalerta;

    private java.util.Calendar dthrinspecao;

    private java.util.Calendar dtrefturnoalerta;

    private java.lang.String idinspecao;

    private idw.idwws.Ijaledbqldinsp[] ijaledbqldinsps;

    private idw.idwws.Ijamostragemctrl[] ijamostragemctrls;

    private idw.idwws.Ijamostragem[] ijamostragems;

    private idw.idwws.Ijgrpparaminsp ijgrpparaminsp;

    private idw.idwws.Ijinspecaoctrl[] ijinspecaoctrls;

    private idw.idwws.Ijmolpro ijmolpro;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbcentinsp ijtbcentinsp;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbusu ijtbusuByCdoperador;

    private idw.idwws.Ijtbusu ijtbusuByCdsupervisor;

    private idw.idwws.Ijtbusu ijtbusuByCdusucancelalerta;

    private java.lang.String nretiquetainsp;

    private org.apache.axis.types.UnsignedShort resultadoinspecao;

    public Ijinspecao() {
    }

    public Ijinspecao(
           java.lang.String cdturnoalerta,
           java.util.Calendar dthralerta,
           java.util.Calendar dthrcancelalerta,
           java.util.Calendar dthrinspecao,
           java.util.Calendar dtrefturnoalerta,
           java.lang.String idinspecao,
           idw.idwws.Ijaledbqldinsp[] ijaledbqldinsps,
           idw.idwws.Ijamostragemctrl[] ijamostragemctrls,
           idw.idwws.Ijamostragem[] ijamostragems,
           idw.idwws.Ijgrpparaminsp ijgrpparaminsp,
           idw.idwws.Ijinspecaoctrl[] ijinspecaoctrls,
           idw.idwws.Ijmolpro ijmolpro,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbcentinsp ijtbcentinsp,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbusu ijtbusuByCdoperador,
           idw.idwws.Ijtbusu ijtbusuByCdsupervisor,
           idw.idwws.Ijtbusu ijtbusuByCdusucancelalerta,
           java.lang.String nretiquetainsp,
           org.apache.axis.types.UnsignedShort resultadoinspecao) {
           this.cdturnoalerta = cdturnoalerta;
           this.dthralerta = dthralerta;
           this.dthrcancelalerta = dthrcancelalerta;
           this.dthrinspecao = dthrinspecao;
           this.dtrefturnoalerta = dtrefturnoalerta;
           this.idinspecao = idinspecao;
           this.ijaledbqldinsps = ijaledbqldinsps;
           this.ijamostragemctrls = ijamostragemctrls;
           this.ijamostragems = ijamostragems;
           this.ijgrpparaminsp = ijgrpparaminsp;
           this.ijinspecaoctrls = ijinspecaoctrls;
           this.ijmolpro = ijmolpro;
           this.ijop = ijop;
           this.ijtbcentinsp = ijtbcentinsp;
           this.ijtbinj = ijtbinj;
           this.ijtbusuByCdoperador = ijtbusuByCdoperador;
           this.ijtbusuByCdsupervisor = ijtbusuByCdsupervisor;
           this.ijtbusuByCdusucancelalerta = ijtbusuByCdusucancelalerta;
           this.nretiquetainsp = nretiquetainsp;
           this.resultadoinspecao = resultadoinspecao;
    }


    /**
     * Gets the cdturnoalerta value for this Ijinspecao.
     * 
     * @return cdturnoalerta
     */
    public java.lang.String getCdturnoalerta() {
        return cdturnoalerta;
    }


    /**
     * Sets the cdturnoalerta value for this Ijinspecao.
     * 
     * @param cdturnoalerta
     */
    public void setCdturnoalerta(java.lang.String cdturnoalerta) {
        this.cdturnoalerta = cdturnoalerta;
    }


    /**
     * Gets the dthralerta value for this Ijinspecao.
     * 
     * @return dthralerta
     */
    public java.util.Calendar getDthralerta() {
        return dthralerta;
    }


    /**
     * Sets the dthralerta value for this Ijinspecao.
     * 
     * @param dthralerta
     */
    public void setDthralerta(java.util.Calendar dthralerta) {
        this.dthralerta = dthralerta;
    }


    /**
     * Gets the dthrcancelalerta value for this Ijinspecao.
     * 
     * @return dthrcancelalerta
     */
    public java.util.Calendar getDthrcancelalerta() {
        return dthrcancelalerta;
    }


    /**
     * Sets the dthrcancelalerta value for this Ijinspecao.
     * 
     * @param dthrcancelalerta
     */
    public void setDthrcancelalerta(java.util.Calendar dthrcancelalerta) {
        this.dthrcancelalerta = dthrcancelalerta;
    }


    /**
     * Gets the dthrinspecao value for this Ijinspecao.
     * 
     * @return dthrinspecao
     */
    public java.util.Calendar getDthrinspecao() {
        return dthrinspecao;
    }


    /**
     * Sets the dthrinspecao value for this Ijinspecao.
     * 
     * @param dthrinspecao
     */
    public void setDthrinspecao(java.util.Calendar dthrinspecao) {
        this.dthrinspecao = dthrinspecao;
    }


    /**
     * Gets the dtrefturnoalerta value for this Ijinspecao.
     * 
     * @return dtrefturnoalerta
     */
    public java.util.Calendar getDtrefturnoalerta() {
        return dtrefturnoalerta;
    }


    /**
     * Sets the dtrefturnoalerta value for this Ijinspecao.
     * 
     * @param dtrefturnoalerta
     */
    public void setDtrefturnoalerta(java.util.Calendar dtrefturnoalerta) {
        this.dtrefturnoalerta = dtrefturnoalerta;
    }


    /**
     * Gets the idinspecao value for this Ijinspecao.
     * 
     * @return idinspecao
     */
    public java.lang.String getIdinspecao() {
        return idinspecao;
    }


    /**
     * Sets the idinspecao value for this Ijinspecao.
     * 
     * @param idinspecao
     */
    public void setIdinspecao(java.lang.String idinspecao) {
        this.idinspecao = idinspecao;
    }


    /**
     * Gets the ijaledbqldinsps value for this Ijinspecao.
     * 
     * @return ijaledbqldinsps
     */
    public idw.idwws.Ijaledbqldinsp[] getIjaledbqldinsps() {
        return ijaledbqldinsps;
    }


    /**
     * Sets the ijaledbqldinsps value for this Ijinspecao.
     * 
     * @param ijaledbqldinsps
     */
    public void setIjaledbqldinsps(idw.idwws.Ijaledbqldinsp[] ijaledbqldinsps) {
        this.ijaledbqldinsps = ijaledbqldinsps;
    }

    public idw.idwws.Ijaledbqldinsp getIjaledbqldinsps(int i) {
        return this.ijaledbqldinsps[i];
    }

    public void setIjaledbqldinsps(int i, idw.idwws.Ijaledbqldinsp _value) {
        this.ijaledbqldinsps[i] = _value;
    }


    /**
     * Gets the ijamostragemctrls value for this Ijinspecao.
     * 
     * @return ijamostragemctrls
     */
    public idw.idwws.Ijamostragemctrl[] getIjamostragemctrls() {
        return ijamostragemctrls;
    }


    /**
     * Sets the ijamostragemctrls value for this Ijinspecao.
     * 
     * @param ijamostragemctrls
     */
    public void setIjamostragemctrls(idw.idwws.Ijamostragemctrl[] ijamostragemctrls) {
        this.ijamostragemctrls = ijamostragemctrls;
    }

    public idw.idwws.Ijamostragemctrl getIjamostragemctrls(int i) {
        return this.ijamostragemctrls[i];
    }

    public void setIjamostragemctrls(int i, idw.idwws.Ijamostragemctrl _value) {
        this.ijamostragemctrls[i] = _value;
    }


    /**
     * Gets the ijamostragems value for this Ijinspecao.
     * 
     * @return ijamostragems
     */
    public idw.idwws.Ijamostragem[] getIjamostragems() {
        return ijamostragems;
    }


    /**
     * Sets the ijamostragems value for this Ijinspecao.
     * 
     * @param ijamostragems
     */
    public void setIjamostragems(idw.idwws.Ijamostragem[] ijamostragems) {
        this.ijamostragems = ijamostragems;
    }

    public idw.idwws.Ijamostragem getIjamostragems(int i) {
        return this.ijamostragems[i];
    }

    public void setIjamostragems(int i, idw.idwws.Ijamostragem _value) {
        this.ijamostragems[i] = _value;
    }


    /**
     * Gets the ijgrpparaminsp value for this Ijinspecao.
     * 
     * @return ijgrpparaminsp
     */
    public idw.idwws.Ijgrpparaminsp getIjgrpparaminsp() {
        return ijgrpparaminsp;
    }


    /**
     * Sets the ijgrpparaminsp value for this Ijinspecao.
     * 
     * @param ijgrpparaminsp
     */
    public void setIjgrpparaminsp(idw.idwws.Ijgrpparaminsp ijgrpparaminsp) {
        this.ijgrpparaminsp = ijgrpparaminsp;
    }


    /**
     * Gets the ijinspecaoctrls value for this Ijinspecao.
     * 
     * @return ijinspecaoctrls
     */
    public idw.idwws.Ijinspecaoctrl[] getIjinspecaoctrls() {
        return ijinspecaoctrls;
    }


    /**
     * Sets the ijinspecaoctrls value for this Ijinspecao.
     * 
     * @param ijinspecaoctrls
     */
    public void setIjinspecaoctrls(idw.idwws.Ijinspecaoctrl[] ijinspecaoctrls) {
        this.ijinspecaoctrls = ijinspecaoctrls;
    }

    public idw.idwws.Ijinspecaoctrl getIjinspecaoctrls(int i) {
        return this.ijinspecaoctrls[i];
    }

    public void setIjinspecaoctrls(int i, idw.idwws.Ijinspecaoctrl _value) {
        this.ijinspecaoctrls[i] = _value;
    }


    /**
     * Gets the ijmolpro value for this Ijinspecao.
     * 
     * @return ijmolpro
     */
    public idw.idwws.Ijmolpro getIjmolpro() {
        return ijmolpro;
    }


    /**
     * Sets the ijmolpro value for this Ijinspecao.
     * 
     * @param ijmolpro
     */
    public void setIjmolpro(idw.idwws.Ijmolpro ijmolpro) {
        this.ijmolpro = ijmolpro;
    }


    /**
     * Gets the ijop value for this Ijinspecao.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijinspecao.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbcentinsp value for this Ijinspecao.
     * 
     * @return ijtbcentinsp
     */
    public idw.idwws.Ijtbcentinsp getIjtbcentinsp() {
        return ijtbcentinsp;
    }


    /**
     * Sets the ijtbcentinsp value for this Ijinspecao.
     * 
     * @param ijtbcentinsp
     */
    public void setIjtbcentinsp(idw.idwws.Ijtbcentinsp ijtbcentinsp) {
        this.ijtbcentinsp = ijtbcentinsp;
    }


    /**
     * Gets the ijtbinj value for this Ijinspecao.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijinspecao.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbusuByCdoperador value for this Ijinspecao.
     * 
     * @return ijtbusuByCdoperador
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdoperador() {
        return ijtbusuByCdoperador;
    }


    /**
     * Sets the ijtbusuByCdoperador value for this Ijinspecao.
     * 
     * @param ijtbusuByCdoperador
     */
    public void setIjtbusuByCdoperador(idw.idwws.Ijtbusu ijtbusuByCdoperador) {
        this.ijtbusuByCdoperador = ijtbusuByCdoperador;
    }


    /**
     * Gets the ijtbusuByCdsupervisor value for this Ijinspecao.
     * 
     * @return ijtbusuByCdsupervisor
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdsupervisor() {
        return ijtbusuByCdsupervisor;
    }


    /**
     * Sets the ijtbusuByCdsupervisor value for this Ijinspecao.
     * 
     * @param ijtbusuByCdsupervisor
     */
    public void setIjtbusuByCdsupervisor(idw.idwws.Ijtbusu ijtbusuByCdsupervisor) {
        this.ijtbusuByCdsupervisor = ijtbusuByCdsupervisor;
    }


    /**
     * Gets the ijtbusuByCdusucancelalerta value for this Ijinspecao.
     * 
     * @return ijtbusuByCdusucancelalerta
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusucancelalerta() {
        return ijtbusuByCdusucancelalerta;
    }


    /**
     * Sets the ijtbusuByCdusucancelalerta value for this Ijinspecao.
     * 
     * @param ijtbusuByCdusucancelalerta
     */
    public void setIjtbusuByCdusucancelalerta(idw.idwws.Ijtbusu ijtbusuByCdusucancelalerta) {
        this.ijtbusuByCdusucancelalerta = ijtbusuByCdusucancelalerta;
    }


    /**
     * Gets the nretiquetainsp value for this Ijinspecao.
     * 
     * @return nretiquetainsp
     */
    public java.lang.String getNretiquetainsp() {
        return nretiquetainsp;
    }


    /**
     * Sets the nretiquetainsp value for this Ijinspecao.
     * 
     * @param nretiquetainsp
     */
    public void setNretiquetainsp(java.lang.String nretiquetainsp) {
        this.nretiquetainsp = nretiquetainsp;
    }


    /**
     * Gets the resultadoinspecao value for this Ijinspecao.
     * 
     * @return resultadoinspecao
     */
    public org.apache.axis.types.UnsignedShort getResultadoinspecao() {
        return resultadoinspecao;
    }


    /**
     * Sets the resultadoinspecao value for this Ijinspecao.
     * 
     * @param resultadoinspecao
     */
    public void setResultadoinspecao(org.apache.axis.types.UnsignedShort resultadoinspecao) {
        this.resultadoinspecao = resultadoinspecao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijinspecao)) return false;
        Ijinspecao other = (Ijinspecao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdturnoalerta==null && other.getCdturnoalerta()==null) || 
             (this.cdturnoalerta!=null &&
              this.cdturnoalerta.equals(other.getCdturnoalerta()))) &&
            ((this.dthralerta==null && other.getDthralerta()==null) || 
             (this.dthralerta!=null &&
              this.dthralerta.equals(other.getDthralerta()))) &&
            ((this.dthrcancelalerta==null && other.getDthrcancelalerta()==null) || 
             (this.dthrcancelalerta!=null &&
              this.dthrcancelalerta.equals(other.getDthrcancelalerta()))) &&
            ((this.dthrinspecao==null && other.getDthrinspecao()==null) || 
             (this.dthrinspecao!=null &&
              this.dthrinspecao.equals(other.getDthrinspecao()))) &&
            ((this.dtrefturnoalerta==null && other.getDtrefturnoalerta()==null) || 
             (this.dtrefturnoalerta!=null &&
              this.dtrefturnoalerta.equals(other.getDtrefturnoalerta()))) &&
            ((this.idinspecao==null && other.getIdinspecao()==null) || 
             (this.idinspecao!=null &&
              this.idinspecao.equals(other.getIdinspecao()))) &&
            ((this.ijaledbqldinsps==null && other.getIjaledbqldinsps()==null) || 
             (this.ijaledbqldinsps!=null &&
              java.util.Arrays.equals(this.ijaledbqldinsps, other.getIjaledbqldinsps()))) &&
            ((this.ijamostragemctrls==null && other.getIjamostragemctrls()==null) || 
             (this.ijamostragemctrls!=null &&
              java.util.Arrays.equals(this.ijamostragemctrls, other.getIjamostragemctrls()))) &&
            ((this.ijamostragems==null && other.getIjamostragems()==null) || 
             (this.ijamostragems!=null &&
              java.util.Arrays.equals(this.ijamostragems, other.getIjamostragems()))) &&
            ((this.ijgrpparaminsp==null && other.getIjgrpparaminsp()==null) || 
             (this.ijgrpparaminsp!=null &&
              this.ijgrpparaminsp.equals(other.getIjgrpparaminsp()))) &&
            ((this.ijinspecaoctrls==null && other.getIjinspecaoctrls()==null) || 
             (this.ijinspecaoctrls!=null &&
              java.util.Arrays.equals(this.ijinspecaoctrls, other.getIjinspecaoctrls()))) &&
            ((this.ijmolpro==null && other.getIjmolpro()==null) || 
             (this.ijmolpro!=null &&
              this.ijmolpro.equals(other.getIjmolpro()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbcentinsp==null && other.getIjtbcentinsp()==null) || 
             (this.ijtbcentinsp!=null &&
              this.ijtbcentinsp.equals(other.getIjtbcentinsp()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbusuByCdoperador==null && other.getIjtbusuByCdoperador()==null) || 
             (this.ijtbusuByCdoperador!=null &&
              this.ijtbusuByCdoperador.equals(other.getIjtbusuByCdoperador()))) &&
            ((this.ijtbusuByCdsupervisor==null && other.getIjtbusuByCdsupervisor()==null) || 
             (this.ijtbusuByCdsupervisor!=null &&
              this.ijtbusuByCdsupervisor.equals(other.getIjtbusuByCdsupervisor()))) &&
            ((this.ijtbusuByCdusucancelalerta==null && other.getIjtbusuByCdusucancelalerta()==null) || 
             (this.ijtbusuByCdusucancelalerta!=null &&
              this.ijtbusuByCdusucancelalerta.equals(other.getIjtbusuByCdusucancelalerta()))) &&
            ((this.nretiquetainsp==null && other.getNretiquetainsp()==null) || 
             (this.nretiquetainsp!=null &&
              this.nretiquetainsp.equals(other.getNretiquetainsp()))) &&
            ((this.resultadoinspecao==null && other.getResultadoinspecao()==null) || 
             (this.resultadoinspecao!=null &&
              this.resultadoinspecao.equals(other.getResultadoinspecao())));
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
        if (getCdturnoalerta() != null) {
            _hashCode += getCdturnoalerta().hashCode();
        }
        if (getDthralerta() != null) {
            _hashCode += getDthralerta().hashCode();
        }
        if (getDthrcancelalerta() != null) {
            _hashCode += getDthrcancelalerta().hashCode();
        }
        if (getDthrinspecao() != null) {
            _hashCode += getDthrinspecao().hashCode();
        }
        if (getDtrefturnoalerta() != null) {
            _hashCode += getDtrefturnoalerta().hashCode();
        }
        if (getIdinspecao() != null) {
            _hashCode += getIdinspecao().hashCode();
        }
        if (getIjaledbqldinsps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjaledbqldinsps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjaledbqldinsps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjamostragemctrls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamostragemctrls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamostragemctrls(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjamostragems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamostragems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamostragems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpparaminsp() != null) {
            _hashCode += getIjgrpparaminsp().hashCode();
        }
        if (getIjinspecaoctrls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjinspecaoctrls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjinspecaoctrls(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmolpro() != null) {
            _hashCode += getIjmolpro().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbcentinsp() != null) {
            _hashCode += getIjtbcentinsp().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbusuByCdoperador() != null) {
            _hashCode += getIjtbusuByCdoperador().hashCode();
        }
        if (getIjtbusuByCdsupervisor() != null) {
            _hashCode += getIjtbusuByCdsupervisor().hashCode();
        }
        if (getIjtbusuByCdusucancelalerta() != null) {
            _hashCode += getIjtbusuByCdusucancelalerta().hashCode();
        }
        if (getNretiquetainsp() != null) {
            _hashCode += getNretiquetainsp().hashCode();
        }
        if (getResultadoinspecao() != null) {
            _hashCode += getResultadoinspecao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijinspecao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturnoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturnoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthralerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthralerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrcancelalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrcancelalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtrefturnoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtrefturnoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqldinsps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqldinsps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqldinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragemctrls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragemctrls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemctrl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpparaminsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpparaminsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecaoctrls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecaoctrls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecaoctrl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcentinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcentinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcentinsp"));
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
        elemField.setFieldName("ijtbusuByCdoperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdoperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdsupervisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdsupervisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusucancelalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusucancelalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nretiquetainsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nretiquetainsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoinspecao"));
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
