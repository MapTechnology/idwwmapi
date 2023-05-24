/**
 * DwConsolid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolid  extends idw.idwws.DwConsolidTemplate  implements java.io.Serializable {
    private java.lang.Integer ano;

    private java.lang.String dsEspecializaapon;

    private java.util.Calendar dtReferencia;

    private java.util.Calendar dthrCadastro;

    private java.util.Calendar dthrFhora;

    private java.util.Calendar dthrFturno;

    private java.util.Calendar dthrIhora;

    private java.util.Calendar dthrIturno;

    private idw.idwws.DwCal dwCal;

    private idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidAcu;

    private idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidHora;

    private idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidMes;

    private idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidTurno;

    private idw.idwws.DwConsol[] dwConsols;

    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwPassagem[] dwPassagems;

    private idw.idwws.DwPepro dwPepro;

    private idw.idwws.DwProrea[] dwProreas;

    private idw.idwws.DwRt dwRt;

    private idw.idwws.DwTurno dwTurno;

    private long idConsolid;

    private java.lang.Byte isAlertasenviados;

    private java.lang.Integer mes;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.PpCp ppCp;

    private java.lang.Byte stAtivo;

    private java.lang.Byte tpId;

    public DwConsolid() {
    }

    public DwConsolid(
           java.lang.Integer ano,
           java.lang.String dsEspecializaapon,
           java.util.Calendar dtReferencia,
           java.util.Calendar dthrCadastro,
           java.util.Calendar dthrFhora,
           java.util.Calendar dthrFturno,
           java.util.Calendar dthrIhora,
           java.util.Calendar dthrIturno,
           idw.idwws.DwCal dwCal,
           idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidAcu,
           idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidHora,
           idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidMes,
           idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidTurno,
           idw.idwws.DwConsol[] dwConsols,
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwPassagem[] dwPassagems,
           idw.idwws.DwPepro dwPepro,
           idw.idwws.DwProrea[] dwProreas,
           idw.idwws.DwRt dwRt,
           idw.idwws.DwTurno dwTurno,
           long idConsolid,
           java.lang.Byte isAlertasenviados,
           java.lang.Integer mes,
           idw.idwws.OmGt omGt,
           idw.idwws.OmPt omPt,
           idw.idwws.PpCp ppCp,
           java.lang.Byte stAtivo,
           java.lang.Byte tpId) {
        this.ano = ano;
        this.dsEspecializaapon = dsEspecializaapon;
        this.dtReferencia = dtReferencia;
        this.dthrCadastro = dthrCadastro;
        this.dthrFhora = dthrFhora;
        this.dthrFturno = dthrFturno;
        this.dthrIhora = dthrIhora;
        this.dthrIturno = dthrIturno;
        this.dwCal = dwCal;
        this.dwConsolptsForIdConsolidAcu = dwConsolptsForIdConsolidAcu;
        this.dwConsolptsForIdConsolidHora = dwConsolptsForIdConsolidHora;
        this.dwConsolptsForIdConsolidMes = dwConsolptsForIdConsolidMes;
        this.dwConsolptsForIdConsolidTurno = dwConsolptsForIdConsolidTurno;
        this.dwConsols = dwConsols;
        this.dwFolha = dwFolha;
        this.dwPassagems = dwPassagems;
        this.dwPepro = dwPepro;
        this.dwProreas = dwProreas;
        this.dwRt = dwRt;
        this.dwTurno = dwTurno;
        this.idConsolid = idConsolid;
        this.isAlertasenviados = isAlertasenviados;
        this.mes = mes;
        this.omGt = omGt;
        this.omPt = omPt;
        this.ppCp = ppCp;
        this.stAtivo = stAtivo;
        this.tpId = tpId;
    }


    /**
     * Gets the ano value for this DwConsolid.
     * 
     * @return ano
     */
    public java.lang.Integer getAno() {
        return ano;
    }


    /**
     * Sets the ano value for this DwConsolid.
     * 
     * @param ano
     */
    public void setAno(java.lang.Integer ano) {
        this.ano = ano;
    }


    /**
     * Gets the dsEspecializaapon value for this DwConsolid.
     * 
     * @return dsEspecializaapon
     */
    public java.lang.String getDsEspecializaapon() {
        return dsEspecializaapon;
    }


    /**
     * Sets the dsEspecializaapon value for this DwConsolid.
     * 
     * @param dsEspecializaapon
     */
    public void setDsEspecializaapon(java.lang.String dsEspecializaapon) {
        this.dsEspecializaapon = dsEspecializaapon;
    }


    /**
     * Gets the dtReferencia value for this DwConsolid.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this DwConsolid.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dthrCadastro value for this DwConsolid.
     * 
     * @return dthrCadastro
     */
    public java.util.Calendar getDthrCadastro() {
        return dthrCadastro;
    }


    /**
     * Sets the dthrCadastro value for this DwConsolid.
     * 
     * @param dthrCadastro
     */
    public void setDthrCadastro(java.util.Calendar dthrCadastro) {
        this.dthrCadastro = dthrCadastro;
    }


    /**
     * Gets the dthrFhora value for this DwConsolid.
     * 
     * @return dthrFhora
     */
    public java.util.Calendar getDthrFhora() {
        return dthrFhora;
    }


    /**
     * Sets the dthrFhora value for this DwConsolid.
     * 
     * @param dthrFhora
     */
    public void setDthrFhora(java.util.Calendar dthrFhora) {
        this.dthrFhora = dthrFhora;
    }


    /**
     * Gets the dthrFturno value for this DwConsolid.
     * 
     * @return dthrFturno
     */
    public java.util.Calendar getDthrFturno() {
        return dthrFturno;
    }


    /**
     * Sets the dthrFturno value for this DwConsolid.
     * 
     * @param dthrFturno
     */
    public void setDthrFturno(java.util.Calendar dthrFturno) {
        this.dthrFturno = dthrFturno;
    }


    /**
     * Gets the dthrIhora value for this DwConsolid.
     * 
     * @return dthrIhora
     */
    public java.util.Calendar getDthrIhora() {
        return dthrIhora;
    }


    /**
     * Sets the dthrIhora value for this DwConsolid.
     * 
     * @param dthrIhora
     */
    public void setDthrIhora(java.util.Calendar dthrIhora) {
        this.dthrIhora = dthrIhora;
    }


    /**
     * Gets the dthrIturno value for this DwConsolid.
     * 
     * @return dthrIturno
     */
    public java.util.Calendar getDthrIturno() {
        return dthrIturno;
    }


    /**
     * Sets the dthrIturno value for this DwConsolid.
     * 
     * @param dthrIturno
     */
    public void setDthrIturno(java.util.Calendar dthrIturno) {
        this.dthrIturno = dthrIturno;
    }


    /**
     * Gets the dwCal value for this DwConsolid.
     * 
     * @return dwCal
     */
    public idw.idwws.DwCal getDwCal() {
        return dwCal;
    }


    /**
     * Sets the dwCal value for this DwConsolid.
     * 
     * @param dwCal
     */
    public void setDwCal(idw.idwws.DwCal dwCal) {
        this.dwCal = dwCal;
    }


    /**
     * Gets the dwConsolptsForIdConsolidAcu value for this DwConsolid.
     * 
     * @return dwConsolptsForIdConsolidAcu
     */
    public idw.idwws.DwConsolpt[] getDwConsolptsForIdConsolidAcu() {
        return dwConsolptsForIdConsolidAcu;
    }


    /**
     * Sets the dwConsolptsForIdConsolidAcu value for this DwConsolid.
     * 
     * @param dwConsolptsForIdConsolidAcu
     */
    public void setDwConsolptsForIdConsolidAcu(idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidAcu) {
        this.dwConsolptsForIdConsolidAcu = dwConsolptsForIdConsolidAcu;
    }

    public idw.idwws.DwConsolpt getDwConsolptsForIdConsolidAcu(int i) {
        return this.dwConsolptsForIdConsolidAcu[i];
    }

    public void setDwConsolptsForIdConsolidAcu(int i, idw.idwws.DwConsolpt _value) {
        this.dwConsolptsForIdConsolidAcu[i] = _value;
    }


    /**
     * Gets the dwConsolptsForIdConsolidHora value for this DwConsolid.
     * 
     * @return dwConsolptsForIdConsolidHora
     */
    public idw.idwws.DwConsolpt[] getDwConsolptsForIdConsolidHora() {
        return dwConsolptsForIdConsolidHora;
    }


    /**
     * Sets the dwConsolptsForIdConsolidHora value for this DwConsolid.
     * 
     * @param dwConsolptsForIdConsolidHora
     */
    public void setDwConsolptsForIdConsolidHora(idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidHora) {
        this.dwConsolptsForIdConsolidHora = dwConsolptsForIdConsolidHora;
    }

    public idw.idwws.DwConsolpt getDwConsolptsForIdConsolidHora(int i) {
        return this.dwConsolptsForIdConsolidHora[i];
    }

    public void setDwConsolptsForIdConsolidHora(int i, idw.idwws.DwConsolpt _value) {
        this.dwConsolptsForIdConsolidHora[i] = _value;
    }


    /**
     * Gets the dwConsolptsForIdConsolidMes value for this DwConsolid.
     * 
     * @return dwConsolptsForIdConsolidMes
     */
    public idw.idwws.DwConsolpt[] getDwConsolptsForIdConsolidMes() {
        return dwConsolptsForIdConsolidMes;
    }


    /**
     * Sets the dwConsolptsForIdConsolidMes value for this DwConsolid.
     * 
     * @param dwConsolptsForIdConsolidMes
     */
    public void setDwConsolptsForIdConsolidMes(idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidMes) {
        this.dwConsolptsForIdConsolidMes = dwConsolptsForIdConsolidMes;
    }

    public idw.idwws.DwConsolpt getDwConsolptsForIdConsolidMes(int i) {
        return this.dwConsolptsForIdConsolidMes[i];
    }

    public void setDwConsolptsForIdConsolidMes(int i, idw.idwws.DwConsolpt _value) {
        this.dwConsolptsForIdConsolidMes[i] = _value;
    }


    /**
     * Gets the dwConsolptsForIdConsolidTurno value for this DwConsolid.
     * 
     * @return dwConsolptsForIdConsolidTurno
     */
    public idw.idwws.DwConsolpt[] getDwConsolptsForIdConsolidTurno() {
        return dwConsolptsForIdConsolidTurno;
    }


    /**
     * Sets the dwConsolptsForIdConsolidTurno value for this DwConsolid.
     * 
     * @param dwConsolptsForIdConsolidTurno
     */
    public void setDwConsolptsForIdConsolidTurno(idw.idwws.DwConsolpt[] dwConsolptsForIdConsolidTurno) {
        this.dwConsolptsForIdConsolidTurno = dwConsolptsForIdConsolidTurno;
    }

    public idw.idwws.DwConsolpt getDwConsolptsForIdConsolidTurno(int i) {
        return this.dwConsolptsForIdConsolidTurno[i];
    }

    public void setDwConsolptsForIdConsolidTurno(int i, idw.idwws.DwConsolpt _value) {
        this.dwConsolptsForIdConsolidTurno[i] = _value;
    }


    /**
     * Gets the dwConsols value for this DwConsolid.
     * 
     * @return dwConsols
     */
    public idw.idwws.DwConsol[] getDwConsols() {
        return dwConsols;
    }


    /**
     * Sets the dwConsols value for this DwConsolid.
     * 
     * @param dwConsols
     */
    public void setDwConsols(idw.idwws.DwConsol[] dwConsols) {
        this.dwConsols = dwConsols;
    }

    public idw.idwws.DwConsol getDwConsols(int i) {
        return this.dwConsols[i];
    }

    public void setDwConsols(int i, idw.idwws.DwConsol _value) {
        this.dwConsols[i] = _value;
    }


    /**
     * Gets the dwFolha value for this DwConsolid.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwConsolid.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwPassagems value for this DwConsolid.
     * 
     * @return dwPassagems
     */
    public idw.idwws.DwPassagem[] getDwPassagems() {
        return dwPassagems;
    }


    /**
     * Sets the dwPassagems value for this DwConsolid.
     * 
     * @param dwPassagems
     */
    public void setDwPassagems(idw.idwws.DwPassagem[] dwPassagems) {
        this.dwPassagems = dwPassagems;
    }

    public idw.idwws.DwPassagem getDwPassagems(int i) {
        return this.dwPassagems[i];
    }

    public void setDwPassagems(int i, idw.idwws.DwPassagem _value) {
        this.dwPassagems[i] = _value;
    }


    /**
     * Gets the dwPepro value for this DwConsolid.
     * 
     * @return dwPepro
     */
    public idw.idwws.DwPepro getDwPepro() {
        return dwPepro;
    }


    /**
     * Sets the dwPepro value for this DwConsolid.
     * 
     * @param dwPepro
     */
    public void setDwPepro(idw.idwws.DwPepro dwPepro) {
        this.dwPepro = dwPepro;
    }


    /**
     * Gets the dwProreas value for this DwConsolid.
     * 
     * @return dwProreas
     */
    public idw.idwws.DwProrea[] getDwProreas() {
        return dwProreas;
    }


    /**
     * Sets the dwProreas value for this DwConsolid.
     * 
     * @param dwProreas
     */
    public void setDwProreas(idw.idwws.DwProrea[] dwProreas) {
        this.dwProreas = dwProreas;
    }

    public idw.idwws.DwProrea getDwProreas(int i) {
        return this.dwProreas[i];
    }

    public void setDwProreas(int i, idw.idwws.DwProrea _value) {
        this.dwProreas[i] = _value;
    }


    /**
     * Gets the dwRt value for this DwConsolid.
     * 
     * @return dwRt
     */
    public idw.idwws.DwRt getDwRt() {
        return dwRt;
    }


    /**
     * Sets the dwRt value for this DwConsolid.
     * 
     * @param dwRt
     */
    public void setDwRt(idw.idwws.DwRt dwRt) {
        this.dwRt = dwRt;
    }


    /**
     * Gets the dwTurno value for this DwConsolid.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this DwConsolid.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the idConsolid value for this DwConsolid.
     * 
     * @return idConsolid
     */
    public long getIdConsolid() {
        return idConsolid;
    }


    /**
     * Sets the idConsolid value for this DwConsolid.
     * 
     * @param idConsolid
     */
    public void setIdConsolid(long idConsolid) {
        this.idConsolid = idConsolid;
    }


    /**
     * Gets the isAlertasenviados value for this DwConsolid.
     * 
     * @return isAlertasenviados
     */
    public java.lang.Byte getIsAlertasenviados() {
        return isAlertasenviados;
    }


    /**
     * Sets the isAlertasenviados value for this DwConsolid.
     * 
     * @param isAlertasenviados
     */
    public void setIsAlertasenviados(java.lang.Byte isAlertasenviados) {
        this.isAlertasenviados = isAlertasenviados;
    }


    /**
     * Gets the mes value for this DwConsolid.
     * 
     * @return mes
     */
    public java.lang.Integer getMes() {
        return mes;
    }


    /**
     * Sets the mes value for this DwConsolid.
     * 
     * @param mes
     */
    public void setMes(java.lang.Integer mes) {
        this.mes = mes;
    }


    /**
     * Gets the omGt value for this DwConsolid.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this DwConsolid.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omPt value for this DwConsolid.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwConsolid.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ppCp value for this DwConsolid.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this DwConsolid.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the stAtivo value for this DwConsolid.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwConsolid.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tpId value for this DwConsolid.
     * 
     * @return tpId
     */
    public java.lang.Byte getTpId() {
        return tpId;
    }


    /**
     * Sets the tpId value for this DwConsolid.
     * 
     * @param tpId
     */
    public void setTpId(java.lang.Byte tpId) {
        this.tpId = tpId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolid)) return false;
        DwConsolid other = (DwConsolid) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ano==null && other.getAno()==null) || 
             (this.ano!=null &&
              this.ano.equals(other.getAno()))) &&
            ((this.dsEspecializaapon==null && other.getDsEspecializaapon()==null) || 
             (this.dsEspecializaapon!=null &&
              this.dsEspecializaapon.equals(other.getDsEspecializaapon()))) &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dthrCadastro==null && other.getDthrCadastro()==null) || 
             (this.dthrCadastro!=null &&
              this.dthrCadastro.equals(other.getDthrCadastro()))) &&
            ((this.dthrFhora==null && other.getDthrFhora()==null) || 
             (this.dthrFhora!=null &&
              this.dthrFhora.equals(other.getDthrFhora()))) &&
            ((this.dthrFturno==null && other.getDthrFturno()==null) || 
             (this.dthrFturno!=null &&
              this.dthrFturno.equals(other.getDthrFturno()))) &&
            ((this.dthrIhora==null && other.getDthrIhora()==null) || 
             (this.dthrIhora!=null &&
              this.dthrIhora.equals(other.getDthrIhora()))) &&
            ((this.dthrIturno==null && other.getDthrIturno()==null) || 
             (this.dthrIturno!=null &&
              this.dthrIturno.equals(other.getDthrIturno()))) &&
            ((this.dwCal==null && other.getDwCal()==null) || 
             (this.dwCal!=null &&
              this.dwCal.equals(other.getDwCal()))) &&
            ((this.dwConsolptsForIdConsolidAcu==null && other.getDwConsolptsForIdConsolidAcu()==null) || 
             (this.dwConsolptsForIdConsolidAcu!=null &&
              java.util.Arrays.equals(this.dwConsolptsForIdConsolidAcu, other.getDwConsolptsForIdConsolidAcu()))) &&
            ((this.dwConsolptsForIdConsolidHora==null && other.getDwConsolptsForIdConsolidHora()==null) || 
             (this.dwConsolptsForIdConsolidHora!=null &&
              java.util.Arrays.equals(this.dwConsolptsForIdConsolidHora, other.getDwConsolptsForIdConsolidHora()))) &&
            ((this.dwConsolptsForIdConsolidMes==null && other.getDwConsolptsForIdConsolidMes()==null) || 
             (this.dwConsolptsForIdConsolidMes!=null &&
              java.util.Arrays.equals(this.dwConsolptsForIdConsolidMes, other.getDwConsolptsForIdConsolidMes()))) &&
            ((this.dwConsolptsForIdConsolidTurno==null && other.getDwConsolptsForIdConsolidTurno()==null) || 
             (this.dwConsolptsForIdConsolidTurno!=null &&
              java.util.Arrays.equals(this.dwConsolptsForIdConsolidTurno, other.getDwConsolptsForIdConsolidTurno()))) &&
            ((this.dwConsols==null && other.getDwConsols()==null) || 
             (this.dwConsols!=null &&
              java.util.Arrays.equals(this.dwConsols, other.getDwConsols()))) &&
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.dwPassagems==null && other.getDwPassagems()==null) || 
             (this.dwPassagems!=null &&
              java.util.Arrays.equals(this.dwPassagems, other.getDwPassagems()))) &&
            ((this.dwPepro==null && other.getDwPepro()==null) || 
             (this.dwPepro!=null &&
              this.dwPepro.equals(other.getDwPepro()))) &&
            ((this.dwProreas==null && other.getDwProreas()==null) || 
             (this.dwProreas!=null &&
              java.util.Arrays.equals(this.dwProreas, other.getDwProreas()))) &&
            ((this.dwRt==null && other.getDwRt()==null) || 
             (this.dwRt!=null &&
              this.dwRt.equals(other.getDwRt()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            this.idConsolid == other.getIdConsolid() &&
            ((this.isAlertasenviados==null && other.getIsAlertasenviados()==null) || 
             (this.isAlertasenviados!=null &&
              this.isAlertasenviados.equals(other.getIsAlertasenviados()))) &&
            ((this.mes==null && other.getMes()==null) || 
             (this.mes!=null &&
              this.mes.equals(other.getMes()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tpId==null && other.getTpId()==null) || 
             (this.tpId!=null &&
              this.tpId.equals(other.getTpId())));
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
        if (getAno() != null) {
            _hashCode += getAno().hashCode();
        }
        if (getDsEspecializaapon() != null) {
            _hashCode += getDsEspecializaapon().hashCode();
        }
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDthrCadastro() != null) {
            _hashCode += getDthrCadastro().hashCode();
        }
        if (getDthrFhora() != null) {
            _hashCode += getDthrFhora().hashCode();
        }
        if (getDthrFturno() != null) {
            _hashCode += getDthrFturno().hashCode();
        }
        if (getDthrIhora() != null) {
            _hashCode += getDthrIhora().hashCode();
        }
        if (getDthrIturno() != null) {
            _hashCode += getDthrIturno().hashCode();
        }
        if (getDwCal() != null) {
            _hashCode += getDwCal().hashCode();
        }
        if (getDwConsolptsForIdConsolidAcu() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolptsForIdConsolidAcu());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolptsForIdConsolidAcu(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolptsForIdConsolidHora() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolptsForIdConsolidHora());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolptsForIdConsolidHora(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolptsForIdConsolidMes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolptsForIdConsolidMes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolptsForIdConsolidMes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolptsForIdConsolidTurno() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolptsForIdConsolidTurno());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolptsForIdConsolidTurno(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsols(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getDwPassagems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassagems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassagems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPepro() != null) {
            _hashCode += getDwPepro().hashCode();
        }
        if (getDwProreas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProreas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProreas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRt() != null) {
            _hashCode += getDwRt().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        _hashCode += new Long(getIdConsolid()).hashCode();
        if (getIsAlertasenviados() != null) {
            _hashCode += getIsAlertasenviados().hashCode();
        }
        if (getMes() != null) {
            _hashCode += getMes().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTpId() != null) {
            _hashCode += getTpId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsEspecializaapon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsEspecializaapon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFhora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFhora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIhora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIhora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolptsForIdConsolidAcu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolptsForIdConsolidAcu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolptsForIdConsolidHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolptsForIdConsolidHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolptsForIdConsolidMes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolptsForIdConsolidMes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolptsForIdConsolidTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolptsForIdConsolidTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPepro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPepro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPepro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProreas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProreas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProrea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlertasenviados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAlertasenviados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
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
        elemField.setFieldName("tpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpId"));
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
