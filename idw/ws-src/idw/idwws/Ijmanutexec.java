/**
 * Ijmanutexec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanutexec  implements java.io.Serializable {
    private java.lang.Double custototal;

    private java.lang.String dstarefa;

    private java.util.Calendar dtfimexec;

    private java.util.Calendar dtiniexec;

    private idw.idwws.IjmanutexecId id;

    private java.lang.String idrecurso;

    private idw.idwws.Ijmanut ijmanut;

    private idw.idwws.Ijmanutchklst ijmanutchklst;

    private idw.idwws.Ijmanutexectec[] ijmanutexectecs;

    private idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefaavulsa;

    private idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefachklst;

    private idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefachklstpai;

    private idw.idwws.Ijtbusu ijtbusuByCdusufimexec;

    private idw.idwws.Ijtbusu ijtbusuByCdusuiniexec;

    private java.math.BigDecimal nivel;

    private java.lang.String observacao;

    private java.lang.Double qtdhrs;

    private java.math.BigDecimal situacao;

    private org.apache.axis.types.UnsignedShort stchklstfilhos;

    private org.apache.axis.types.UnsignedShort stchklstobrig;

    private java.math.BigDecimal tpexec;

    private java.lang.String tprecurso;

    private java.lang.Double vlrhrs;

    public Ijmanutexec() {
    }

    public Ijmanutexec(
           java.lang.Double custototal,
           java.lang.String dstarefa,
           java.util.Calendar dtfimexec,
           java.util.Calendar dtiniexec,
           idw.idwws.IjmanutexecId id,
           java.lang.String idrecurso,
           idw.idwws.Ijmanut ijmanut,
           idw.idwws.Ijmanutchklst ijmanutchklst,
           idw.idwws.Ijmanutexectec[] ijmanutexectecs,
           idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefaavulsa,
           idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefachklst,
           idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefachklstpai,
           idw.idwws.Ijtbusu ijtbusuByCdusufimexec,
           idw.idwws.Ijtbusu ijtbusuByCdusuiniexec,
           java.math.BigDecimal nivel,
           java.lang.String observacao,
           java.lang.Double qtdhrs,
           java.math.BigDecimal situacao,
           org.apache.axis.types.UnsignedShort stchklstfilhos,
           org.apache.axis.types.UnsignedShort stchklstobrig,
           java.math.BigDecimal tpexec,
           java.lang.String tprecurso,
           java.lang.Double vlrhrs) {
           this.custototal = custototal;
           this.dstarefa = dstarefa;
           this.dtfimexec = dtfimexec;
           this.dtiniexec = dtiniexec;
           this.id = id;
           this.idrecurso = idrecurso;
           this.ijmanut = ijmanut;
           this.ijmanutchklst = ijmanutchklst;
           this.ijmanutexectecs = ijmanutexectecs;
           this.ijmanuttarefaByIdtarefaavulsa = ijmanuttarefaByIdtarefaavulsa;
           this.ijmanuttarefaByIdtarefachklst = ijmanuttarefaByIdtarefachklst;
           this.ijmanuttarefaByIdtarefachklstpai = ijmanuttarefaByIdtarefachklstpai;
           this.ijtbusuByCdusufimexec = ijtbusuByCdusufimexec;
           this.ijtbusuByCdusuiniexec = ijtbusuByCdusuiniexec;
           this.nivel = nivel;
           this.observacao = observacao;
           this.qtdhrs = qtdhrs;
           this.situacao = situacao;
           this.stchklstfilhos = stchklstfilhos;
           this.stchklstobrig = stchklstobrig;
           this.tpexec = tpexec;
           this.tprecurso = tprecurso;
           this.vlrhrs = vlrhrs;
    }


    /**
     * Gets the custototal value for this Ijmanutexec.
     * 
     * @return custototal
     */
    public java.lang.Double getCustototal() {
        return custototal;
    }


    /**
     * Sets the custototal value for this Ijmanutexec.
     * 
     * @param custototal
     */
    public void setCustototal(java.lang.Double custototal) {
        this.custototal = custototal;
    }


    /**
     * Gets the dstarefa value for this Ijmanutexec.
     * 
     * @return dstarefa
     */
    public java.lang.String getDstarefa() {
        return dstarefa;
    }


    /**
     * Sets the dstarefa value for this Ijmanutexec.
     * 
     * @param dstarefa
     */
    public void setDstarefa(java.lang.String dstarefa) {
        this.dstarefa = dstarefa;
    }


    /**
     * Gets the dtfimexec value for this Ijmanutexec.
     * 
     * @return dtfimexec
     */
    public java.util.Calendar getDtfimexec() {
        return dtfimexec;
    }


    /**
     * Sets the dtfimexec value for this Ijmanutexec.
     * 
     * @param dtfimexec
     */
    public void setDtfimexec(java.util.Calendar dtfimexec) {
        this.dtfimexec = dtfimexec;
    }


    /**
     * Gets the dtiniexec value for this Ijmanutexec.
     * 
     * @return dtiniexec
     */
    public java.util.Calendar getDtiniexec() {
        return dtiniexec;
    }


    /**
     * Sets the dtiniexec value for this Ijmanutexec.
     * 
     * @param dtiniexec
     */
    public void setDtiniexec(java.util.Calendar dtiniexec) {
        this.dtiniexec = dtiniexec;
    }


    /**
     * Gets the id value for this Ijmanutexec.
     * 
     * @return id
     */
    public idw.idwws.IjmanutexecId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmanutexec.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmanutexecId id) {
        this.id = id;
    }


    /**
     * Gets the idrecurso value for this Ijmanutexec.
     * 
     * @return idrecurso
     */
    public java.lang.String getIdrecurso() {
        return idrecurso;
    }


    /**
     * Sets the idrecurso value for this Ijmanutexec.
     * 
     * @param idrecurso
     */
    public void setIdrecurso(java.lang.String idrecurso) {
        this.idrecurso = idrecurso;
    }


    /**
     * Gets the ijmanut value for this Ijmanutexec.
     * 
     * @return ijmanut
     */
    public idw.idwws.Ijmanut getIjmanut() {
        return ijmanut;
    }


    /**
     * Sets the ijmanut value for this Ijmanutexec.
     * 
     * @param ijmanut
     */
    public void setIjmanut(idw.idwws.Ijmanut ijmanut) {
        this.ijmanut = ijmanut;
    }


    /**
     * Gets the ijmanutchklst value for this Ijmanutexec.
     * 
     * @return ijmanutchklst
     */
    public idw.idwws.Ijmanutchklst getIjmanutchklst() {
        return ijmanutchklst;
    }


    /**
     * Sets the ijmanutchklst value for this Ijmanutexec.
     * 
     * @param ijmanutchklst
     */
    public void setIjmanutchklst(idw.idwws.Ijmanutchklst ijmanutchklst) {
        this.ijmanutchklst = ijmanutchklst;
    }


    /**
     * Gets the ijmanutexectecs value for this Ijmanutexec.
     * 
     * @return ijmanutexectecs
     */
    public idw.idwws.Ijmanutexectec[] getIjmanutexectecs() {
        return ijmanutexectecs;
    }


    /**
     * Sets the ijmanutexectecs value for this Ijmanutexec.
     * 
     * @param ijmanutexectecs
     */
    public void setIjmanutexectecs(idw.idwws.Ijmanutexectec[] ijmanutexectecs) {
        this.ijmanutexectecs = ijmanutexectecs;
    }

    public idw.idwws.Ijmanutexectec getIjmanutexectecs(int i) {
        return this.ijmanutexectecs[i];
    }

    public void setIjmanutexectecs(int i, idw.idwws.Ijmanutexectec _value) {
        this.ijmanutexectecs[i] = _value;
    }


    /**
     * Gets the ijmanuttarefaByIdtarefaavulsa value for this Ijmanutexec.
     * 
     * @return ijmanuttarefaByIdtarefaavulsa
     */
    public idw.idwws.Ijmanuttarefa getIjmanuttarefaByIdtarefaavulsa() {
        return ijmanuttarefaByIdtarefaavulsa;
    }


    /**
     * Sets the ijmanuttarefaByIdtarefaavulsa value for this Ijmanutexec.
     * 
     * @param ijmanuttarefaByIdtarefaavulsa
     */
    public void setIjmanuttarefaByIdtarefaavulsa(idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefaavulsa) {
        this.ijmanuttarefaByIdtarefaavulsa = ijmanuttarefaByIdtarefaavulsa;
    }


    /**
     * Gets the ijmanuttarefaByIdtarefachklst value for this Ijmanutexec.
     * 
     * @return ijmanuttarefaByIdtarefachklst
     */
    public idw.idwws.Ijmanuttarefa getIjmanuttarefaByIdtarefachklst() {
        return ijmanuttarefaByIdtarefachklst;
    }


    /**
     * Sets the ijmanuttarefaByIdtarefachklst value for this Ijmanutexec.
     * 
     * @param ijmanuttarefaByIdtarefachklst
     */
    public void setIjmanuttarefaByIdtarefachklst(idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefachklst) {
        this.ijmanuttarefaByIdtarefachklst = ijmanuttarefaByIdtarefachklst;
    }


    /**
     * Gets the ijmanuttarefaByIdtarefachklstpai value for this Ijmanutexec.
     * 
     * @return ijmanuttarefaByIdtarefachklstpai
     */
    public idw.idwws.Ijmanuttarefa getIjmanuttarefaByIdtarefachklstpai() {
        return ijmanuttarefaByIdtarefachklstpai;
    }


    /**
     * Sets the ijmanuttarefaByIdtarefachklstpai value for this Ijmanutexec.
     * 
     * @param ijmanuttarefaByIdtarefachklstpai
     */
    public void setIjmanuttarefaByIdtarefachklstpai(idw.idwws.Ijmanuttarefa ijmanuttarefaByIdtarefachklstpai) {
        this.ijmanuttarefaByIdtarefachklstpai = ijmanuttarefaByIdtarefachklstpai;
    }


    /**
     * Gets the ijtbusuByCdusufimexec value for this Ijmanutexec.
     * 
     * @return ijtbusuByCdusufimexec
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusufimexec() {
        return ijtbusuByCdusufimexec;
    }


    /**
     * Sets the ijtbusuByCdusufimexec value for this Ijmanutexec.
     * 
     * @param ijtbusuByCdusufimexec
     */
    public void setIjtbusuByCdusufimexec(idw.idwws.Ijtbusu ijtbusuByCdusufimexec) {
        this.ijtbusuByCdusufimexec = ijtbusuByCdusufimexec;
    }


    /**
     * Gets the ijtbusuByCdusuiniexec value for this Ijmanutexec.
     * 
     * @return ijtbusuByCdusuiniexec
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuiniexec() {
        return ijtbusuByCdusuiniexec;
    }


    /**
     * Sets the ijtbusuByCdusuiniexec value for this Ijmanutexec.
     * 
     * @param ijtbusuByCdusuiniexec
     */
    public void setIjtbusuByCdusuiniexec(idw.idwws.Ijtbusu ijtbusuByCdusuiniexec) {
        this.ijtbusuByCdusuiniexec = ijtbusuByCdusuiniexec;
    }


    /**
     * Gets the nivel value for this Ijmanutexec.
     * 
     * @return nivel
     */
    public java.math.BigDecimal getNivel() {
        return nivel;
    }


    /**
     * Sets the nivel value for this Ijmanutexec.
     * 
     * @param nivel
     */
    public void setNivel(java.math.BigDecimal nivel) {
        this.nivel = nivel;
    }


    /**
     * Gets the observacao value for this Ijmanutexec.
     * 
     * @return observacao
     */
    public java.lang.String getObservacao() {
        return observacao;
    }


    /**
     * Sets the observacao value for this Ijmanutexec.
     * 
     * @param observacao
     */
    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }


    /**
     * Gets the qtdhrs value for this Ijmanutexec.
     * 
     * @return qtdhrs
     */
    public java.lang.Double getQtdhrs() {
        return qtdhrs;
    }


    /**
     * Sets the qtdhrs value for this Ijmanutexec.
     * 
     * @param qtdhrs
     */
    public void setQtdhrs(java.lang.Double qtdhrs) {
        this.qtdhrs = qtdhrs;
    }


    /**
     * Gets the situacao value for this Ijmanutexec.
     * 
     * @return situacao
     */
    public java.math.BigDecimal getSituacao() {
        return situacao;
    }


    /**
     * Sets the situacao value for this Ijmanutexec.
     * 
     * @param situacao
     */
    public void setSituacao(java.math.BigDecimal situacao) {
        this.situacao = situacao;
    }


    /**
     * Gets the stchklstfilhos value for this Ijmanutexec.
     * 
     * @return stchklstfilhos
     */
    public org.apache.axis.types.UnsignedShort getStchklstfilhos() {
        return stchklstfilhos;
    }


    /**
     * Sets the stchklstfilhos value for this Ijmanutexec.
     * 
     * @param stchklstfilhos
     */
    public void setStchklstfilhos(org.apache.axis.types.UnsignedShort stchklstfilhos) {
        this.stchklstfilhos = stchklstfilhos;
    }


    /**
     * Gets the stchklstobrig value for this Ijmanutexec.
     * 
     * @return stchklstobrig
     */
    public org.apache.axis.types.UnsignedShort getStchklstobrig() {
        return stchklstobrig;
    }


    /**
     * Sets the stchklstobrig value for this Ijmanutexec.
     * 
     * @param stchklstobrig
     */
    public void setStchklstobrig(org.apache.axis.types.UnsignedShort stchklstobrig) {
        this.stchklstobrig = stchklstobrig;
    }


    /**
     * Gets the tpexec value for this Ijmanutexec.
     * 
     * @return tpexec
     */
    public java.math.BigDecimal getTpexec() {
        return tpexec;
    }


    /**
     * Sets the tpexec value for this Ijmanutexec.
     * 
     * @param tpexec
     */
    public void setTpexec(java.math.BigDecimal tpexec) {
        this.tpexec = tpexec;
    }


    /**
     * Gets the tprecurso value for this Ijmanutexec.
     * 
     * @return tprecurso
     */
    public java.lang.String getTprecurso() {
        return tprecurso;
    }


    /**
     * Sets the tprecurso value for this Ijmanutexec.
     * 
     * @param tprecurso
     */
    public void setTprecurso(java.lang.String tprecurso) {
        this.tprecurso = tprecurso;
    }


    /**
     * Gets the vlrhrs value for this Ijmanutexec.
     * 
     * @return vlrhrs
     */
    public java.lang.Double getVlrhrs() {
        return vlrhrs;
    }


    /**
     * Sets the vlrhrs value for this Ijmanutexec.
     * 
     * @param vlrhrs
     */
    public void setVlrhrs(java.lang.Double vlrhrs) {
        this.vlrhrs = vlrhrs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanutexec)) return false;
        Ijmanutexec other = (Ijmanutexec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.custototal==null && other.getCustototal()==null) || 
             (this.custototal!=null &&
              this.custototal.equals(other.getCustototal()))) &&
            ((this.dstarefa==null && other.getDstarefa()==null) || 
             (this.dstarefa!=null &&
              this.dstarefa.equals(other.getDstarefa()))) &&
            ((this.dtfimexec==null && other.getDtfimexec()==null) || 
             (this.dtfimexec!=null &&
              this.dtfimexec.equals(other.getDtfimexec()))) &&
            ((this.dtiniexec==null && other.getDtiniexec()==null) || 
             (this.dtiniexec!=null &&
              this.dtiniexec.equals(other.getDtiniexec()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idrecurso==null && other.getIdrecurso()==null) || 
             (this.idrecurso!=null &&
              this.idrecurso.equals(other.getIdrecurso()))) &&
            ((this.ijmanut==null && other.getIjmanut()==null) || 
             (this.ijmanut!=null &&
              this.ijmanut.equals(other.getIjmanut()))) &&
            ((this.ijmanutchklst==null && other.getIjmanutchklst()==null) || 
             (this.ijmanutchklst!=null &&
              this.ijmanutchklst.equals(other.getIjmanutchklst()))) &&
            ((this.ijmanutexectecs==null && other.getIjmanutexectecs()==null) || 
             (this.ijmanutexectecs!=null &&
              java.util.Arrays.equals(this.ijmanutexectecs, other.getIjmanutexectecs()))) &&
            ((this.ijmanuttarefaByIdtarefaavulsa==null && other.getIjmanuttarefaByIdtarefaavulsa()==null) || 
             (this.ijmanuttarefaByIdtarefaavulsa!=null &&
              this.ijmanuttarefaByIdtarefaavulsa.equals(other.getIjmanuttarefaByIdtarefaavulsa()))) &&
            ((this.ijmanuttarefaByIdtarefachklst==null && other.getIjmanuttarefaByIdtarefachklst()==null) || 
             (this.ijmanuttarefaByIdtarefachklst!=null &&
              this.ijmanuttarefaByIdtarefachklst.equals(other.getIjmanuttarefaByIdtarefachklst()))) &&
            ((this.ijmanuttarefaByIdtarefachklstpai==null && other.getIjmanuttarefaByIdtarefachklstpai()==null) || 
             (this.ijmanuttarefaByIdtarefachklstpai!=null &&
              this.ijmanuttarefaByIdtarefachklstpai.equals(other.getIjmanuttarefaByIdtarefachklstpai()))) &&
            ((this.ijtbusuByCdusufimexec==null && other.getIjtbusuByCdusufimexec()==null) || 
             (this.ijtbusuByCdusufimexec!=null &&
              this.ijtbusuByCdusufimexec.equals(other.getIjtbusuByCdusufimexec()))) &&
            ((this.ijtbusuByCdusuiniexec==null && other.getIjtbusuByCdusuiniexec()==null) || 
             (this.ijtbusuByCdusuiniexec!=null &&
              this.ijtbusuByCdusuiniexec.equals(other.getIjtbusuByCdusuiniexec()))) &&
            ((this.nivel==null && other.getNivel()==null) || 
             (this.nivel!=null &&
              this.nivel.equals(other.getNivel()))) &&
            ((this.observacao==null && other.getObservacao()==null) || 
             (this.observacao!=null &&
              this.observacao.equals(other.getObservacao()))) &&
            ((this.qtdhrs==null && other.getQtdhrs()==null) || 
             (this.qtdhrs!=null &&
              this.qtdhrs.equals(other.getQtdhrs()))) &&
            ((this.situacao==null && other.getSituacao()==null) || 
             (this.situacao!=null &&
              this.situacao.equals(other.getSituacao()))) &&
            ((this.stchklstfilhos==null && other.getStchklstfilhos()==null) || 
             (this.stchklstfilhos!=null &&
              this.stchklstfilhos.equals(other.getStchklstfilhos()))) &&
            ((this.stchklstobrig==null && other.getStchklstobrig()==null) || 
             (this.stchklstobrig!=null &&
              this.stchklstobrig.equals(other.getStchklstobrig()))) &&
            ((this.tpexec==null && other.getTpexec()==null) || 
             (this.tpexec!=null &&
              this.tpexec.equals(other.getTpexec()))) &&
            ((this.tprecurso==null && other.getTprecurso()==null) || 
             (this.tprecurso!=null &&
              this.tprecurso.equals(other.getTprecurso()))) &&
            ((this.vlrhrs==null && other.getVlrhrs()==null) || 
             (this.vlrhrs!=null &&
              this.vlrhrs.equals(other.getVlrhrs())));
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
        if (getCustototal() != null) {
            _hashCode += getCustototal().hashCode();
        }
        if (getDstarefa() != null) {
            _hashCode += getDstarefa().hashCode();
        }
        if (getDtfimexec() != null) {
            _hashCode += getDtfimexec().hashCode();
        }
        if (getDtiniexec() != null) {
            _hashCode += getDtiniexec().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdrecurso() != null) {
            _hashCode += getIdrecurso().hashCode();
        }
        if (getIjmanut() != null) {
            _hashCode += getIjmanut().hashCode();
        }
        if (getIjmanutchklst() != null) {
            _hashCode += getIjmanutchklst().hashCode();
        }
        if (getIjmanutexectecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutexectecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutexectecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanuttarefaByIdtarefaavulsa() != null) {
            _hashCode += getIjmanuttarefaByIdtarefaavulsa().hashCode();
        }
        if (getIjmanuttarefaByIdtarefachklst() != null) {
            _hashCode += getIjmanuttarefaByIdtarefachklst().hashCode();
        }
        if (getIjmanuttarefaByIdtarefachklstpai() != null) {
            _hashCode += getIjmanuttarefaByIdtarefachklstpai().hashCode();
        }
        if (getIjtbusuByCdusufimexec() != null) {
            _hashCode += getIjtbusuByCdusufimexec().hashCode();
        }
        if (getIjtbusuByCdusuiniexec() != null) {
            _hashCode += getIjtbusuByCdusuiniexec().hashCode();
        }
        if (getNivel() != null) {
            _hashCode += getNivel().hashCode();
        }
        if (getObservacao() != null) {
            _hashCode += getObservacao().hashCode();
        }
        if (getQtdhrs() != null) {
            _hashCode += getQtdhrs().hashCode();
        }
        if (getSituacao() != null) {
            _hashCode += getSituacao().hashCode();
        }
        if (getStchklstfilhos() != null) {
            _hashCode += getStchklstfilhos().hashCode();
        }
        if (getStchklstobrig() != null) {
            _hashCode += getStchklstobrig().hashCode();
        }
        if (getTpexec() != null) {
            _hashCode += getTpexec().hashCode();
        }
        if (getTprecurso() != null) {
            _hashCode += getTprecurso().hashCode();
        }
        if (getVlrhrs() != null) {
            _hashCode += getVlrhrs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanutexec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custototal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custototal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtfimexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtfimexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtiniexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtiniexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexecId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idrecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idrecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutchklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutexectecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutexectecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexectec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanuttarefaByIdtarefaavulsa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanuttarefaByIdtarefaavulsa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanuttarefa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanuttarefaByIdtarefachklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanuttarefaByIdtarefachklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanuttarefa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanuttarefaByIdtarefachklstpai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanuttarefaByIdtarefachklstpai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanuttarefa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusufimexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusufimexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusuiniexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusuiniexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "observacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdhrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdhrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "situacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stchklstfilhos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stchklstfilhos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stchklstobrig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stchklstobrig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tprecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tprecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlrhrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlrhrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
