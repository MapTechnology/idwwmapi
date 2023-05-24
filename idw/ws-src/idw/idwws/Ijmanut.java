/**
 * Ijmanut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanut  implements java.io.Serializable {
    private java.lang.String dsmanutencao;

    private java.util.Calendar dtfimmanut;

    private java.util.Calendar dthrabeos;

    private java.util.Calendar dtinimanut;

    private java.util.Calendar dtprevfimmanut;

    private java.util.Calendar dtprevinimanut;

    private java.lang.String idchklst;

    private java.lang.String idrecurso;

    private idw.idwws.Ijalemanutprev[] ijalemanutprevs;

    private idw.idwws.Ijareres ijareres;

    private idw.idwws.Ijfreqmanutprev[] ijfreqmanutprevs;

    private idw.idwws.Ijmanutexec[] ijmanutexecs;

    private idw.idwws.Ijmanutlog[] ijmanutlogs;

    private idw.idwws.Ijmanutmateriais[] ijmanutmateriaises;

    private idw.idwws.Ijmanutrecbloq[] ijmanutrecbloqs;

    private idw.idwws.Ijmanutregliber[] ijmanutreglibers;

    private idw.idwws.Ijparprogos[] ijparprogoses;

    private idw.idwws.Ijtbusu ijtbusuByCdusuabeos;

    private idw.idwws.Ijtbusu ijtbusuByCdusufimmanut;

    private idw.idwws.Ijtbusu ijtbusuByCdusuinimanut;

    private java.lang.String nros;

    private java.math.BigDecimal qtusuaprencos;

    private org.apache.axis.types.UnsignedShort stmanut;

    private org.apache.axis.types.UnsignedShort tpmanutencao;

    private java.lang.String tprecurso;

    public Ijmanut() {
    }

    public Ijmanut(
           java.lang.String dsmanutencao,
           java.util.Calendar dtfimmanut,
           java.util.Calendar dthrabeos,
           java.util.Calendar dtinimanut,
           java.util.Calendar dtprevfimmanut,
           java.util.Calendar dtprevinimanut,
           java.lang.String idchklst,
           java.lang.String idrecurso,
           idw.idwws.Ijalemanutprev[] ijalemanutprevs,
           idw.idwws.Ijareres ijareres,
           idw.idwws.Ijfreqmanutprev[] ijfreqmanutprevs,
           idw.idwws.Ijmanutexec[] ijmanutexecs,
           idw.idwws.Ijmanutlog[] ijmanutlogs,
           idw.idwws.Ijmanutmateriais[] ijmanutmateriaises,
           idw.idwws.Ijmanutrecbloq[] ijmanutrecbloqs,
           idw.idwws.Ijmanutregliber[] ijmanutreglibers,
           idw.idwws.Ijparprogos[] ijparprogoses,
           idw.idwws.Ijtbusu ijtbusuByCdusuabeos,
           idw.idwws.Ijtbusu ijtbusuByCdusufimmanut,
           idw.idwws.Ijtbusu ijtbusuByCdusuinimanut,
           java.lang.String nros,
           java.math.BigDecimal qtusuaprencos,
           org.apache.axis.types.UnsignedShort stmanut,
           org.apache.axis.types.UnsignedShort tpmanutencao,
           java.lang.String tprecurso) {
           this.dsmanutencao = dsmanutencao;
           this.dtfimmanut = dtfimmanut;
           this.dthrabeos = dthrabeos;
           this.dtinimanut = dtinimanut;
           this.dtprevfimmanut = dtprevfimmanut;
           this.dtprevinimanut = dtprevinimanut;
           this.idchklst = idchklst;
           this.idrecurso = idrecurso;
           this.ijalemanutprevs = ijalemanutprevs;
           this.ijareres = ijareres;
           this.ijfreqmanutprevs = ijfreqmanutprevs;
           this.ijmanutexecs = ijmanutexecs;
           this.ijmanutlogs = ijmanutlogs;
           this.ijmanutmateriaises = ijmanutmateriaises;
           this.ijmanutrecbloqs = ijmanutrecbloqs;
           this.ijmanutreglibers = ijmanutreglibers;
           this.ijparprogoses = ijparprogoses;
           this.ijtbusuByCdusuabeos = ijtbusuByCdusuabeos;
           this.ijtbusuByCdusufimmanut = ijtbusuByCdusufimmanut;
           this.ijtbusuByCdusuinimanut = ijtbusuByCdusuinimanut;
           this.nros = nros;
           this.qtusuaprencos = qtusuaprencos;
           this.stmanut = stmanut;
           this.tpmanutencao = tpmanutencao;
           this.tprecurso = tprecurso;
    }


    /**
     * Gets the dsmanutencao value for this Ijmanut.
     * 
     * @return dsmanutencao
     */
    public java.lang.String getDsmanutencao() {
        return dsmanutencao;
    }


    /**
     * Sets the dsmanutencao value for this Ijmanut.
     * 
     * @param dsmanutencao
     */
    public void setDsmanutencao(java.lang.String dsmanutencao) {
        this.dsmanutencao = dsmanutencao;
    }


    /**
     * Gets the dtfimmanut value for this Ijmanut.
     * 
     * @return dtfimmanut
     */
    public java.util.Calendar getDtfimmanut() {
        return dtfimmanut;
    }


    /**
     * Sets the dtfimmanut value for this Ijmanut.
     * 
     * @param dtfimmanut
     */
    public void setDtfimmanut(java.util.Calendar dtfimmanut) {
        this.dtfimmanut = dtfimmanut;
    }


    /**
     * Gets the dthrabeos value for this Ijmanut.
     * 
     * @return dthrabeos
     */
    public java.util.Calendar getDthrabeos() {
        return dthrabeos;
    }


    /**
     * Sets the dthrabeos value for this Ijmanut.
     * 
     * @param dthrabeos
     */
    public void setDthrabeos(java.util.Calendar dthrabeos) {
        this.dthrabeos = dthrabeos;
    }


    /**
     * Gets the dtinimanut value for this Ijmanut.
     * 
     * @return dtinimanut
     */
    public java.util.Calendar getDtinimanut() {
        return dtinimanut;
    }


    /**
     * Sets the dtinimanut value for this Ijmanut.
     * 
     * @param dtinimanut
     */
    public void setDtinimanut(java.util.Calendar dtinimanut) {
        this.dtinimanut = dtinimanut;
    }


    /**
     * Gets the dtprevfimmanut value for this Ijmanut.
     * 
     * @return dtprevfimmanut
     */
    public java.util.Calendar getDtprevfimmanut() {
        return dtprevfimmanut;
    }


    /**
     * Sets the dtprevfimmanut value for this Ijmanut.
     * 
     * @param dtprevfimmanut
     */
    public void setDtprevfimmanut(java.util.Calendar dtprevfimmanut) {
        this.dtprevfimmanut = dtprevfimmanut;
    }


    /**
     * Gets the dtprevinimanut value for this Ijmanut.
     * 
     * @return dtprevinimanut
     */
    public java.util.Calendar getDtprevinimanut() {
        return dtprevinimanut;
    }


    /**
     * Sets the dtprevinimanut value for this Ijmanut.
     * 
     * @param dtprevinimanut
     */
    public void setDtprevinimanut(java.util.Calendar dtprevinimanut) {
        this.dtprevinimanut = dtprevinimanut;
    }


    /**
     * Gets the idchklst value for this Ijmanut.
     * 
     * @return idchklst
     */
    public java.lang.String getIdchklst() {
        return idchklst;
    }


    /**
     * Sets the idchklst value for this Ijmanut.
     * 
     * @param idchklst
     */
    public void setIdchklst(java.lang.String idchklst) {
        this.idchklst = idchklst;
    }


    /**
     * Gets the idrecurso value for this Ijmanut.
     * 
     * @return idrecurso
     */
    public java.lang.String getIdrecurso() {
        return idrecurso;
    }


    /**
     * Sets the idrecurso value for this Ijmanut.
     * 
     * @param idrecurso
     */
    public void setIdrecurso(java.lang.String idrecurso) {
        this.idrecurso = idrecurso;
    }


    /**
     * Gets the ijalemanutprevs value for this Ijmanut.
     * 
     * @return ijalemanutprevs
     */
    public idw.idwws.Ijalemanutprev[] getIjalemanutprevs() {
        return ijalemanutprevs;
    }


    /**
     * Sets the ijalemanutprevs value for this Ijmanut.
     * 
     * @param ijalemanutprevs
     */
    public void setIjalemanutprevs(idw.idwws.Ijalemanutprev[] ijalemanutprevs) {
        this.ijalemanutprevs = ijalemanutprevs;
    }

    public idw.idwws.Ijalemanutprev getIjalemanutprevs(int i) {
        return this.ijalemanutprevs[i];
    }

    public void setIjalemanutprevs(int i, idw.idwws.Ijalemanutprev _value) {
        this.ijalemanutprevs[i] = _value;
    }


    /**
     * Gets the ijareres value for this Ijmanut.
     * 
     * @return ijareres
     */
    public idw.idwws.Ijareres getIjareres() {
        return ijareres;
    }


    /**
     * Sets the ijareres value for this Ijmanut.
     * 
     * @param ijareres
     */
    public void setIjareres(idw.idwws.Ijareres ijareres) {
        this.ijareres = ijareres;
    }


    /**
     * Gets the ijfreqmanutprevs value for this Ijmanut.
     * 
     * @return ijfreqmanutprevs
     */
    public idw.idwws.Ijfreqmanutprev[] getIjfreqmanutprevs() {
        return ijfreqmanutprevs;
    }


    /**
     * Sets the ijfreqmanutprevs value for this Ijmanut.
     * 
     * @param ijfreqmanutprevs
     */
    public void setIjfreqmanutprevs(idw.idwws.Ijfreqmanutprev[] ijfreqmanutprevs) {
        this.ijfreqmanutprevs = ijfreqmanutprevs;
    }

    public idw.idwws.Ijfreqmanutprev getIjfreqmanutprevs(int i) {
        return this.ijfreqmanutprevs[i];
    }

    public void setIjfreqmanutprevs(int i, idw.idwws.Ijfreqmanutprev _value) {
        this.ijfreqmanutprevs[i] = _value;
    }


    /**
     * Gets the ijmanutexecs value for this Ijmanut.
     * 
     * @return ijmanutexecs
     */
    public idw.idwws.Ijmanutexec[] getIjmanutexecs() {
        return ijmanutexecs;
    }


    /**
     * Sets the ijmanutexecs value for this Ijmanut.
     * 
     * @param ijmanutexecs
     */
    public void setIjmanutexecs(idw.idwws.Ijmanutexec[] ijmanutexecs) {
        this.ijmanutexecs = ijmanutexecs;
    }

    public idw.idwws.Ijmanutexec getIjmanutexecs(int i) {
        return this.ijmanutexecs[i];
    }

    public void setIjmanutexecs(int i, idw.idwws.Ijmanutexec _value) {
        this.ijmanutexecs[i] = _value;
    }


    /**
     * Gets the ijmanutlogs value for this Ijmanut.
     * 
     * @return ijmanutlogs
     */
    public idw.idwws.Ijmanutlog[] getIjmanutlogs() {
        return ijmanutlogs;
    }


    /**
     * Sets the ijmanutlogs value for this Ijmanut.
     * 
     * @param ijmanutlogs
     */
    public void setIjmanutlogs(idw.idwws.Ijmanutlog[] ijmanutlogs) {
        this.ijmanutlogs = ijmanutlogs;
    }

    public idw.idwws.Ijmanutlog getIjmanutlogs(int i) {
        return this.ijmanutlogs[i];
    }

    public void setIjmanutlogs(int i, idw.idwws.Ijmanutlog _value) {
        this.ijmanutlogs[i] = _value;
    }


    /**
     * Gets the ijmanutmateriaises value for this Ijmanut.
     * 
     * @return ijmanutmateriaises
     */
    public idw.idwws.Ijmanutmateriais[] getIjmanutmateriaises() {
        return ijmanutmateriaises;
    }


    /**
     * Sets the ijmanutmateriaises value for this Ijmanut.
     * 
     * @param ijmanutmateriaises
     */
    public void setIjmanutmateriaises(idw.idwws.Ijmanutmateriais[] ijmanutmateriaises) {
        this.ijmanutmateriaises = ijmanutmateriaises;
    }

    public idw.idwws.Ijmanutmateriais getIjmanutmateriaises(int i) {
        return this.ijmanutmateriaises[i];
    }

    public void setIjmanutmateriaises(int i, idw.idwws.Ijmanutmateriais _value) {
        this.ijmanutmateriaises[i] = _value;
    }


    /**
     * Gets the ijmanutrecbloqs value for this Ijmanut.
     * 
     * @return ijmanutrecbloqs
     */
    public idw.idwws.Ijmanutrecbloq[] getIjmanutrecbloqs() {
        return ijmanutrecbloqs;
    }


    /**
     * Sets the ijmanutrecbloqs value for this Ijmanut.
     * 
     * @param ijmanutrecbloqs
     */
    public void setIjmanutrecbloqs(idw.idwws.Ijmanutrecbloq[] ijmanutrecbloqs) {
        this.ijmanutrecbloqs = ijmanutrecbloqs;
    }

    public idw.idwws.Ijmanutrecbloq getIjmanutrecbloqs(int i) {
        return this.ijmanutrecbloqs[i];
    }

    public void setIjmanutrecbloqs(int i, idw.idwws.Ijmanutrecbloq _value) {
        this.ijmanutrecbloqs[i] = _value;
    }


    /**
     * Gets the ijmanutreglibers value for this Ijmanut.
     * 
     * @return ijmanutreglibers
     */
    public idw.idwws.Ijmanutregliber[] getIjmanutreglibers() {
        return ijmanutreglibers;
    }


    /**
     * Sets the ijmanutreglibers value for this Ijmanut.
     * 
     * @param ijmanutreglibers
     */
    public void setIjmanutreglibers(idw.idwws.Ijmanutregliber[] ijmanutreglibers) {
        this.ijmanutreglibers = ijmanutreglibers;
    }

    public idw.idwws.Ijmanutregliber getIjmanutreglibers(int i) {
        return this.ijmanutreglibers[i];
    }

    public void setIjmanutreglibers(int i, idw.idwws.Ijmanutregliber _value) {
        this.ijmanutreglibers[i] = _value;
    }


    /**
     * Gets the ijparprogoses value for this Ijmanut.
     * 
     * @return ijparprogoses
     */
    public idw.idwws.Ijparprogos[] getIjparprogoses() {
        return ijparprogoses;
    }


    /**
     * Sets the ijparprogoses value for this Ijmanut.
     * 
     * @param ijparprogoses
     */
    public void setIjparprogoses(idw.idwws.Ijparprogos[] ijparprogoses) {
        this.ijparprogoses = ijparprogoses;
    }

    public idw.idwws.Ijparprogos getIjparprogoses(int i) {
        return this.ijparprogoses[i];
    }

    public void setIjparprogoses(int i, idw.idwws.Ijparprogos _value) {
        this.ijparprogoses[i] = _value;
    }


    /**
     * Gets the ijtbusuByCdusuabeos value for this Ijmanut.
     * 
     * @return ijtbusuByCdusuabeos
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuabeos() {
        return ijtbusuByCdusuabeos;
    }


    /**
     * Sets the ijtbusuByCdusuabeos value for this Ijmanut.
     * 
     * @param ijtbusuByCdusuabeos
     */
    public void setIjtbusuByCdusuabeos(idw.idwws.Ijtbusu ijtbusuByCdusuabeos) {
        this.ijtbusuByCdusuabeos = ijtbusuByCdusuabeos;
    }


    /**
     * Gets the ijtbusuByCdusufimmanut value for this Ijmanut.
     * 
     * @return ijtbusuByCdusufimmanut
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusufimmanut() {
        return ijtbusuByCdusufimmanut;
    }


    /**
     * Sets the ijtbusuByCdusufimmanut value for this Ijmanut.
     * 
     * @param ijtbusuByCdusufimmanut
     */
    public void setIjtbusuByCdusufimmanut(idw.idwws.Ijtbusu ijtbusuByCdusufimmanut) {
        this.ijtbusuByCdusufimmanut = ijtbusuByCdusufimmanut;
    }


    /**
     * Gets the ijtbusuByCdusuinimanut value for this Ijmanut.
     * 
     * @return ijtbusuByCdusuinimanut
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdusuinimanut() {
        return ijtbusuByCdusuinimanut;
    }


    /**
     * Sets the ijtbusuByCdusuinimanut value for this Ijmanut.
     * 
     * @param ijtbusuByCdusuinimanut
     */
    public void setIjtbusuByCdusuinimanut(idw.idwws.Ijtbusu ijtbusuByCdusuinimanut) {
        this.ijtbusuByCdusuinimanut = ijtbusuByCdusuinimanut;
    }


    /**
     * Gets the nros value for this Ijmanut.
     * 
     * @return nros
     */
    public java.lang.String getNros() {
        return nros;
    }


    /**
     * Sets the nros value for this Ijmanut.
     * 
     * @param nros
     */
    public void setNros(java.lang.String nros) {
        this.nros = nros;
    }


    /**
     * Gets the qtusuaprencos value for this Ijmanut.
     * 
     * @return qtusuaprencos
     */
    public java.math.BigDecimal getQtusuaprencos() {
        return qtusuaprencos;
    }


    /**
     * Sets the qtusuaprencos value for this Ijmanut.
     * 
     * @param qtusuaprencos
     */
    public void setQtusuaprencos(java.math.BigDecimal qtusuaprencos) {
        this.qtusuaprencos = qtusuaprencos;
    }


    /**
     * Gets the stmanut value for this Ijmanut.
     * 
     * @return stmanut
     */
    public org.apache.axis.types.UnsignedShort getStmanut() {
        return stmanut;
    }


    /**
     * Sets the stmanut value for this Ijmanut.
     * 
     * @param stmanut
     */
    public void setStmanut(org.apache.axis.types.UnsignedShort stmanut) {
        this.stmanut = stmanut;
    }


    /**
     * Gets the tpmanutencao value for this Ijmanut.
     * 
     * @return tpmanutencao
     */
    public org.apache.axis.types.UnsignedShort getTpmanutencao() {
        return tpmanutencao;
    }


    /**
     * Sets the tpmanutencao value for this Ijmanut.
     * 
     * @param tpmanutencao
     */
    public void setTpmanutencao(org.apache.axis.types.UnsignedShort tpmanutencao) {
        this.tpmanutencao = tpmanutencao;
    }


    /**
     * Gets the tprecurso value for this Ijmanut.
     * 
     * @return tprecurso
     */
    public java.lang.String getTprecurso() {
        return tprecurso;
    }


    /**
     * Sets the tprecurso value for this Ijmanut.
     * 
     * @param tprecurso
     */
    public void setTprecurso(java.lang.String tprecurso) {
        this.tprecurso = tprecurso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanut)) return false;
        Ijmanut other = (Ijmanut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsmanutencao==null && other.getDsmanutencao()==null) || 
             (this.dsmanutencao!=null &&
              this.dsmanutencao.equals(other.getDsmanutencao()))) &&
            ((this.dtfimmanut==null && other.getDtfimmanut()==null) || 
             (this.dtfimmanut!=null &&
              this.dtfimmanut.equals(other.getDtfimmanut()))) &&
            ((this.dthrabeos==null && other.getDthrabeos()==null) || 
             (this.dthrabeos!=null &&
              this.dthrabeos.equals(other.getDthrabeos()))) &&
            ((this.dtinimanut==null && other.getDtinimanut()==null) || 
             (this.dtinimanut!=null &&
              this.dtinimanut.equals(other.getDtinimanut()))) &&
            ((this.dtprevfimmanut==null && other.getDtprevfimmanut()==null) || 
             (this.dtprevfimmanut!=null &&
              this.dtprevfimmanut.equals(other.getDtprevfimmanut()))) &&
            ((this.dtprevinimanut==null && other.getDtprevinimanut()==null) || 
             (this.dtprevinimanut!=null &&
              this.dtprevinimanut.equals(other.getDtprevinimanut()))) &&
            ((this.idchklst==null && other.getIdchklst()==null) || 
             (this.idchklst!=null &&
              this.idchklst.equals(other.getIdchklst()))) &&
            ((this.idrecurso==null && other.getIdrecurso()==null) || 
             (this.idrecurso!=null &&
              this.idrecurso.equals(other.getIdrecurso()))) &&
            ((this.ijalemanutprevs==null && other.getIjalemanutprevs()==null) || 
             (this.ijalemanutprevs!=null &&
              java.util.Arrays.equals(this.ijalemanutprevs, other.getIjalemanutprevs()))) &&
            ((this.ijareres==null && other.getIjareres()==null) || 
             (this.ijareres!=null &&
              this.ijareres.equals(other.getIjareres()))) &&
            ((this.ijfreqmanutprevs==null && other.getIjfreqmanutprevs()==null) || 
             (this.ijfreqmanutprevs!=null &&
              java.util.Arrays.equals(this.ijfreqmanutprevs, other.getIjfreqmanutprevs()))) &&
            ((this.ijmanutexecs==null && other.getIjmanutexecs()==null) || 
             (this.ijmanutexecs!=null &&
              java.util.Arrays.equals(this.ijmanutexecs, other.getIjmanutexecs()))) &&
            ((this.ijmanutlogs==null && other.getIjmanutlogs()==null) || 
             (this.ijmanutlogs!=null &&
              java.util.Arrays.equals(this.ijmanutlogs, other.getIjmanutlogs()))) &&
            ((this.ijmanutmateriaises==null && other.getIjmanutmateriaises()==null) || 
             (this.ijmanutmateriaises!=null &&
              java.util.Arrays.equals(this.ijmanutmateriaises, other.getIjmanutmateriaises()))) &&
            ((this.ijmanutrecbloqs==null && other.getIjmanutrecbloqs()==null) || 
             (this.ijmanutrecbloqs!=null &&
              java.util.Arrays.equals(this.ijmanutrecbloqs, other.getIjmanutrecbloqs()))) &&
            ((this.ijmanutreglibers==null && other.getIjmanutreglibers()==null) || 
             (this.ijmanutreglibers!=null &&
              java.util.Arrays.equals(this.ijmanutreglibers, other.getIjmanutreglibers()))) &&
            ((this.ijparprogoses==null && other.getIjparprogoses()==null) || 
             (this.ijparprogoses!=null &&
              java.util.Arrays.equals(this.ijparprogoses, other.getIjparprogoses()))) &&
            ((this.ijtbusuByCdusuabeos==null && other.getIjtbusuByCdusuabeos()==null) || 
             (this.ijtbusuByCdusuabeos!=null &&
              this.ijtbusuByCdusuabeos.equals(other.getIjtbusuByCdusuabeos()))) &&
            ((this.ijtbusuByCdusufimmanut==null && other.getIjtbusuByCdusufimmanut()==null) || 
             (this.ijtbusuByCdusufimmanut!=null &&
              this.ijtbusuByCdusufimmanut.equals(other.getIjtbusuByCdusufimmanut()))) &&
            ((this.ijtbusuByCdusuinimanut==null && other.getIjtbusuByCdusuinimanut()==null) || 
             (this.ijtbusuByCdusuinimanut!=null &&
              this.ijtbusuByCdusuinimanut.equals(other.getIjtbusuByCdusuinimanut()))) &&
            ((this.nros==null && other.getNros()==null) || 
             (this.nros!=null &&
              this.nros.equals(other.getNros()))) &&
            ((this.qtusuaprencos==null && other.getQtusuaprencos()==null) || 
             (this.qtusuaprencos!=null &&
              this.qtusuaprencos.equals(other.getQtusuaprencos()))) &&
            ((this.stmanut==null && other.getStmanut()==null) || 
             (this.stmanut!=null &&
              this.stmanut.equals(other.getStmanut()))) &&
            ((this.tpmanutencao==null && other.getTpmanutencao()==null) || 
             (this.tpmanutencao!=null &&
              this.tpmanutencao.equals(other.getTpmanutencao()))) &&
            ((this.tprecurso==null && other.getTprecurso()==null) || 
             (this.tprecurso!=null &&
              this.tprecurso.equals(other.getTprecurso())));
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
        if (getDsmanutencao() != null) {
            _hashCode += getDsmanutencao().hashCode();
        }
        if (getDtfimmanut() != null) {
            _hashCode += getDtfimmanut().hashCode();
        }
        if (getDthrabeos() != null) {
            _hashCode += getDthrabeos().hashCode();
        }
        if (getDtinimanut() != null) {
            _hashCode += getDtinimanut().hashCode();
        }
        if (getDtprevfimmanut() != null) {
            _hashCode += getDtprevfimmanut().hashCode();
        }
        if (getDtprevinimanut() != null) {
            _hashCode += getDtprevinimanut().hashCode();
        }
        if (getIdchklst() != null) {
            _hashCode += getIdchklst().hashCode();
        }
        if (getIdrecurso() != null) {
            _hashCode += getIdrecurso().hashCode();
        }
        if (getIjalemanutprevs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjalemanutprevs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjalemanutprevs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjareres() != null) {
            _hashCode += getIjareres().hashCode();
        }
        if (getIjfreqmanutprevs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfreqmanutprevs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfreqmanutprevs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutexecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutexecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutexecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutlogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutlogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutlogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutmateriaises() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutmateriaises());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutmateriaises(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutrecbloqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutrecbloqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutrecbloqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutreglibers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutreglibers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutreglibers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjparprogoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjparprogoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjparprogoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusuByCdusuabeos() != null) {
            _hashCode += getIjtbusuByCdusuabeos().hashCode();
        }
        if (getIjtbusuByCdusufimmanut() != null) {
            _hashCode += getIjtbusuByCdusufimmanut().hashCode();
        }
        if (getIjtbusuByCdusuinimanut() != null) {
            _hashCode += getIjtbusuByCdusuinimanut().hashCode();
        }
        if (getNros() != null) {
            _hashCode += getNros().hashCode();
        }
        if (getQtusuaprencos() != null) {
            _hashCode += getQtusuaprencos().hashCode();
        }
        if (getStmanut() != null) {
            _hashCode += getStmanut().hashCode();
        }
        if (getTpmanutencao() != null) {
            _hashCode += getTpmanutencao().hashCode();
        }
        if (getTprecurso() != null) {
            _hashCode += getTprecurso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmanutencao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmanutencao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtfimmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtfimmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrabeos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrabeos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtinimanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtinimanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtprevfimmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtprevfimmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtprevinimanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtprevinimanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idchklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("ijalemanutprevs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijalemanutprevs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalemanutprev"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijareres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijareres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijareres"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfreqmanutprevs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfreqmanutprevs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprev"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutexecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutexecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutlogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutlogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutlog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutmateriaises");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutmateriaises"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutmateriais"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutrecbloqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutrecbloqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutrecbloq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutreglibers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutreglibers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutregliber"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparprogoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparprogoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparprogos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusuabeos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusuabeos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusufimmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusufimmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdusuinimanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdusuinimanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtusuaprencos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtusuaprencos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpmanutencao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpmanutencao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tprecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tprecurso"));
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
